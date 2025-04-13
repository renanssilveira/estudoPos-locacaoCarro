CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50),
    marca VARCHAR(50),
    placa VARCHAR(50),
    ano INT,
    cor VARCHAR(20),
    valor_diaria DECIMAL(10, 2)
);

INSERT INTO veiculos (modelo, marca, placa, ano, cor, valor_diaria) VALUES
('Fusca', 'Volkswagen', 'ABC1D23', 1975, 'azul', 100.00),
('Civic', 'Honda', 'XYZ4W56', 2020, 'preto', 150.00),
('Corolla', 'Toyota', 'LMN7O89', 2019, 'branco', 120.00),
('Palio', 'Fiat', 'QRS2T34', 2018, 'vermelho', 80.00),
('Onix', 'Chevrolet', 'JKL5P67', 2021, 'prata', 90.00);


CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cpf VARCHAR(50),
    telefone VARCHAR(50),
    email VARCHAR(60)
);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES
('João Silva', '123.456.789-00', '(11) 98765-4321', 'joao.silva@email.com'),
('Maria Oliveira', '987.654.321-00', '(21) 91234-5678', 'maria.oliveira@email.com'),
('Carlos Pereira', '456.789.123-00', '(31) 99876-5432', 'carlos.pereira@email.com'),
('Ana Souza', '321.654.987-00', '(41) 97654-3210', 'ana.souza@email.com'),
('Pedro Santos', '654.321.987-00', '(51) 93456-7890', 'pedro.santos@email.com');
