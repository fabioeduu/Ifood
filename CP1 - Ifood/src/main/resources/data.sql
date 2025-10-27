-- ===========================
-- INSERIR USUÁRIOS
-- ===========================
INSERT INTO TB_USUARIO (id, nome, email, telefone, endereco, tipo_usuario) VALUES (1, 'Renato', 'renato@email.com', '11999999999', 'Rua A, 123', 'CLIENTE');

-- ===========================
-- INSERIR ENTREGADORES
-- ===========================
INSERT INTO TB_ENTREGADOR (id, nome, telefone, email, status_entregador, veiculo) VALUES (1, 'Carlos', '11988888888', 'carlos@email.com', 'DISPONIVEL', 'Moto');

-- ===========================
-- INSERIR RESTAURANTES
-- ===========================
INSERT INTO TB_RESTAURANTE (id, nome, descricao, endereco, telefone) VALUES (1, 'Restaurante Bom Sabor', 'Comida caseira', 'Rua B, 456', '11977777777');

-- ===========================
-- INSERIR PRODUTOS
-- ===========================
INSERT INTO TB_PRODUTO (id, descricao, quantidade, valor, restaurante_id, categoria_produto) VALUES (1, 'Hambúrguer Simples', 50, 15.50, 1, 'LANCHE');

-- ===========================
-- INSERIR CUPONS
-- ===========================
INSERT INTO TB_CUPOM (id, valor, codigo, validade, desconto, ativo) VALUES (1, 10.00, 'PROMO10', DATE '2025-12-31', 'PERCENTUAL', 1);

-- ===========================
-- INSERIR PEDIDOS
-- ===========================
INSERT INTO TB_PEDIDO (id, cliente_id, entregador_id, restaurante_id, status) VALUES (1, 1, 1, 1, 'PREPARANDO');

-- ===========================
-- RELACIONAMENTO PEDIDO x PRODUTO (N:N)
-- ===========================
INSERT INTO TB_PEDIDO_PRODUTO (pedido_id, produto_id) VALUES (1, 1);

-- ===========================
-- RELACIONAMENTO USUÁRIO x CUPOM (N:N)
-- ===========================
INSERT INTO TB_USUARIO_CUPOM (usuario_id, cupom_id) VALUES (1, 1);
