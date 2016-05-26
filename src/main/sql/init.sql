SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `tree`
--

-- --------------------------------------------------------

--
-- Структура таблицы `comp`
--

CREATE TABLE `comp` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `earning` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `comp`
--

INSERT INTO `comp` (`id`, `name`, `earning`, `parent_id`) VALUES
  (1, 'Konex', 100, 0),
  (2, 'Apt1', 50, 1),
  (3, 'Apt2', 30, 1),
  (4, 'Avicena', 80, 0),
  (5, 'Apt1', 40, 2),
  (6, 'Apt2', 70, 2),
  (7, 'Apt3', 10, 2),
  (8, 'Otd1', 40, 5),
  (9, 'Otd2', 30, 5),
  (10, 'Otd1', 30, 3),
  (11, 'Otd2', 30, 3),
  (12, 'Otd3', 40, 3),
  (13, 'Otd1', 30, 7);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `comp`
--
ALTER TABLE `comp`
ADD PRIMARY KEY (`id`),
ADD KEY `parent_index` (`parent_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц