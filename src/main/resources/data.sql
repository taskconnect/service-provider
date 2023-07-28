insert into provider(full_name, email, phone_number) values ('Pedro Pereira Gonçalves', 'pedrogoncalves@email.com', '(21) 4610-3558');
insert into provider(full_name, email, phone_number) values ('Beatriz Correia Carvalho', 'beatrizcarvalho@email.com', '(31) 4552-8226');
insert into provider(full_name, email, phone_number) values ('Diogo Lima Ferreira', 'diegoferreira@email.com', '(73) 2095-2941');

-- I just realized following data is weirdly mocked, since the mock from above simulates Brazilian residents.
-- Because it's a mock, I won't bother about it.
insert into task(task_category, description, price_per_hour) values ('Programming', 'A complete, secure and robust API for your business.', 55.0);
insert into task(task_category, description, price_per_hour) values ('Cleaning', 'The best cleaning service you''ll find.', 50.0);
insert into task(task_category, description, price_per_hour) values ('Animation', 'I bring static things to life :)', 47.5);
insert into task(task_category, description, price_per_hour) values ('Flight Instruction', 'I teach you to fly.', 200.0);

insert into provider_task(provider_id, task_id) values (1, 2);
insert into provider_task(provider_id, task_id) values (2, 1);
insert into provider_task(provider_id, task_id) values (2, 3);
insert into provider_task(provider_id, task_id) values (3, 4);

--Joint Table Query, just in case you want to save your time.
--SELECT provider.id AS provider_id, provider.full_name, provider.email, provider.phone_number,
--      task.id as task_id, task.task_category, task.description, task.price_per_hour
--FROM provider
--JOIN provider_task ON provider.id = provider_task.provider_id
--JOIN task on task.id = provider_task.task_id;
