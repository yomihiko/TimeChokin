
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- テーブルの構造 `bank`
--

CREATE TABLE `bank` (
  `DepositID` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Date` date NOT NULL,
  `CoinID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `coin`
--

CREATE TABLE `coin` (
  `CoinID` int(11) NOT NULL,
  `CoinName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `eternalgoal`
--

CREATE TABLE `eternalgoal` (
  `ID` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `CoinID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `onedaygoal`
--

CREATE TABLE `onedaygoal` (
  `ID` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Date` date NOT NULL,
  `CoinID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`DepositID`),
  ADD KEY `bank_ibfk_1` (`CoinID`);

--
-- Indexes for table `coin`
--
ALTER TABLE `coin`
  ADD PRIMARY KEY (`CoinID`);

--
-- Indexes for table `eternalgoal`
--
ALTER TABLE `eternalgoal`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `eternalgoal_ibfk_1` (`CoinID`);

--
-- Indexes for table `onedaygoal`
--
ALTER TABLE `onedaygoal`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `onedaygoal_ibfk_1` (`CoinID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `DepositID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `coin`
--
ALTER TABLE `coin`
  MODIFY `CoinID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `eternalgoal`
--
ALTER TABLE `eternalgoal`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `onedaygoal`
--
ALTER TABLE `onedaygoal`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `bank`
--
ALTER TABLE `bank`
  ADD CONSTRAINT `bank_ibfk_1` FOREIGN KEY (`CoinID`) REFERENCES `coin` (`CoinID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- テーブルの制約 `eternalgoal`
--
ALTER TABLE `eternalgoal`
  ADD CONSTRAINT `eternalgoal_ibfk_1` FOREIGN KEY (`CoinID`) REFERENCES `coin` (`CoinID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- テーブルの制約 `onedaygoal`
--
ALTER TABLE `onedaygoal`
  ADD CONSTRAINT `onedaygoal_ibfk_1` FOREIGN KEY (`CoinID`) REFERENCES `coin` (`CoinID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
