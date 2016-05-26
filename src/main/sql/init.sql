-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 26 2016 г., 18:09
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 7.0.6

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
  (2, 'Apt_Kon_1', 50, 14),
  (3, 'Apt_Kon_2', 30, 14),
  (4, 'Avicena', 80, 0),
  (5, 'Apt_Av_1', 40, 4),
  (6, 'Apt_Av_2', 70, 4),
  (7, 'Apt_Av_3', 10, 4),
  (10, 'Otd_Kon_1', 30, 3),
  (11, 'Otd_Kon_2', 30, 3),
  (12, 'Otd_Kon_3', 40, 3),
  (13, 'Otd_Av_1', 30, 7),
  (14, 'Konex', 100, 0),
  (17, 'Otd_Av_1', 20, 5),
  (18, 'Otd_Av_2', 40, 5);

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
--

--
-- AUTO_INCREMENT для таблицы `comp`
--
ALTER TABLE `comp`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
