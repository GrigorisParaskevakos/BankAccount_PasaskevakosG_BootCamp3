

USE `afdemp_java_1`;
CREATE  OR REPLACE VIEW `deposits_view` AS SELECT users.username as 'balance_provider', deposit_log.amount, deposit_log.passive_user_id as 'balance_receiver', deposit_log.transaction_date_time FROM users, afdemp_java_1.deposit_log WHERE users.id = deposit_log.active_user_id AND NOT (deposit_log.amount = 0);

USE `afdemp_java_1`;
CREATE  OR REPLACE VIEW `deposits_view_users` AS SELECT deposits_view.balance_provider, deposits_view.amount, users.username as 'receiver', deposits_view.transaction_date_time FROM deposits_view, users WHERE users.id = deposits_view.balance_receiver;

USE `afdemp_java_1`;
CREATE  OR REPLACE VIEW `withdraw_view` AS SELECT users.username as 'balance_receiver', withdraw_log.amount, withdraw_log.passive_user_id as 'balance_provider', withdraw_log.transaction_date_time FROM users, afdemp_java_1.withdraw_log WHERE users.id = withdraw_log.active_user_id AND NOT (withdraw_log.amount = 0);

USE `afdemp_java_1`;
CREATE  OR REPLACE VIEW `withdraw_view_users` AS SELECT withdraw_view.balance_receiver, withdraw_view.amount, users.username as 'provider', withdraw_view.transaction_date_time FROM withdraw_view, users WHERE users.id = withdraw_view.balance_provider;
