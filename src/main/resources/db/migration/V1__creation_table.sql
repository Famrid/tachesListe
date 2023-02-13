CREATE TABLE list(
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    name TEXT NOT NULL,
    CONSTRAINT list_pk PRIMARY KEY (id)
);

CREATE TABLE worker(
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    function TEXT NOT NULL,
    CONSTRAINT worker_pk PRIMARY KEY (id)
);

CREATE TABLE task(
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    priority TEXT NOT NULL,
    status BOOLEAN NOT NULL,
    list_id INTEGER NOT NULL,
    worker_id INTEGER NOT NULL,
    CONSTRAINT task_pk PRIMARY KEY (id),
    CONSTRAINT task_list_fk FOREIGN KEY (list_id)
        REFERENCES list (id),
    CONSTRAINT task_worker_fk FOREIGN KEY (worker_id)
        REFERENCES worker (id)
);

