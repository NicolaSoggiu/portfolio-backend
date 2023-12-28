INSERT INTO projects (title, description, image, link, git) VALUES('Bool Bnb', 'Replica di Bool bnb', 'images/BoolBnb.png', 'https://www.linkedin.com/feed/update/urn:li:activity:7108882156243857408/', 'https://github.com/SimoneRicco/front-BoolBnB');
INSERT INTO projects (title, description, image, link, git) VALUES('Game Hub', 'Replica della piattaforma Rawg', 'images/Rawg.png', 'https://game-hub-teal-two.vercel.app/', 'https://github.com/NicolaSoggiu/game-hub');
INSERT INTO projects (title, description, image, link, git) VALUES('Pizzeria', 'Pizzeria backend', 'images/Pizzeria.png', '', 'https://github.com/NicolaSoggiu/spring-la-mia-pizzeria-webapi');
INSERT INTO projects (title, description, image, link, git) VALUES('Spotify', 'Replica di spotify', 'images/Spotify.png', 'https://html-css-spotifyweb-omega.vercel.app/', 'https://github.com/NicolaSoggiu/html-css-spotifyweb');
INSERT INTO projects (title, description, image, link, git) VALUES('Cinema', 'Web app di un azienda di videomaker', 'images/Cinema.png', 'https://proj-html-vuejs-iota.vercel.app/', 'https://github.com/NicolaSoggiu/proj-html-vuejs');
INSERT INTO projects (title, description, image, link, git) VALUES('Boolzapp', 'Replica di Whatsapp', 'images/Boolzapp.png', 'https://vue-boolzapp-nu.vercel.app/', 'https://github.com/NicolaSoggiu/vue-boolzapp');
INSERT INTO projects (title, description, image, link, git) VALUES('Netflix', 'Replica di Netflix', 'images/Netflix.png', 'https://vite-boolflix-gamma.vercel.app/', 'https://github.com/NicolaSoggiu/vite-boolflix');


INSERT INTO technologies(name) VALUES('Html');
INSERT INTO technologies(name) VALUES('Javascript');
INSERT INTO technologies(name) VALUES('CSS');
INSERT INTO technologies(name) VALUES('Laravel');
INSERT INTO technologies(name) VALUES('Vue');
INSERT INTO technologies(name) VALUES('PHP');
INSERT INTO technologies(name) VALUES('Bootstrap');
INSERT INTO technologies(name) VALUES('Tailwind');
INSERT INTO technologies(name) VALUES('React');
INSERT INTO technologies(name) VALUES('Java');

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,4);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,5);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,6);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(1,8);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(2,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(2,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(2,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(2,9);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(3,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(3,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(3,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(3,10);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(4,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(4,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(4,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(4,7);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(5,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(5,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(5,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(5,5);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(5,7);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(6,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(6,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(6,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(6,7);

INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(7,1);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(7,2);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(7,3);
INSERT INTO projects_technology_list(projects_id, technology_list_id) VALUES(7,7);

INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, name) VALUES(2, 'USER');

INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('nicola@email.com', 'Nicola', 'Soggiu', '2023-11-20 10:35', '{noop}nicola');
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('mario@email.com', 'Mario', 'Rossi', '2023-11-20 10:35','{noop}mario');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);