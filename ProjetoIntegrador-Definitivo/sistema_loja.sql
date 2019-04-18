-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17-Abr-2019 às 03:00
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistema_loja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `usuario` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `senha` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`usuario`, `senha`) VALUES
('adm', 'adm'),
('vendedor1', 'venda'),
('administrador', 'administrador'),
('vendedor02', 'vendedor02');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `cod_produto` int(11) NOT NULL,
  `produto` varchar(100) DEFAULT NULL,
  `preco` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`cod_produto`, `produto`, `preco`) VALUES
(1, 'Bolo simples (pouco confeito)', 35),
(2, 'Bolo confeitado', 50),
(3, 'Bolo Personalizado cerveja', 80),
(4, 'Cupkakes', 25),
(5, 'Mini Brownie', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `cod_venda` int(11) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `cod_produto` int(11) NOT NULL,
  `data_compra` varchar(15) DEFAULT NULL,
  `forma_pagamento` varchar(50) DEFAULT NULL,
  `parcelas` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`cod_venda`, `cpf`, `cod_produto`, `data_compra`, `forma_pagamento`, `parcelas`, `total`) VALUES
(1, '111.111.111.11', 1, '13/04/2019', 'dinheiro', 0, 35),
(6, '164.565.489.89', 2, '13/04/2019', 'cartão de crédito', 1, 50),
(7, '166.565.548.88', 3, '13/04/2019', 'débito', 0, 80),
(8, '166.548.466.65', 4, '13/04/2019', 'dinheiro', 0, 25),
(9, '444.444.444.44', 5, '15/04/2019', 'cartão de crédito', 2, 10),
(10, '242.424.242.42', 2, '15/04/2019', 'dinheiro', 0, 50),
(11, '498.479.498.48', 3, '16/04/2019', 'dinheiro', 0, 80),
(13, '222.222.222.22', 5, '16/04/2019', 'cartão de crédito', 4, 10),
(14, '656.465.465.46', 1, '16/04/2019', 'dinheiro', 0, 35),
(15, '888.888.888.88', 1, '16/04/2019', 'dinheiro', 0, 35),
(16, '666.666.666.66', 1, '16/04/2019', 'cartão de crédito', 1, 35),
(17, '151.655.498.46', 5, '16/04/2019', 'dinheiro', 0, 10),
(18, '656.165.655.66', 5, '16/04/2019', 'cartão de crédito', 1, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`senha`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`cod_produto`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`cod_venda`),
  ADD KEY `id_cod_produto` (`cod_produto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `cod_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `cod_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
