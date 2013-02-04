--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: person; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE person (
    id bigint NOT NULL,
    first_name character varying(64),
    last_name character varying(64),
    birthday date
);


ALTER TABLE public.person OWNER TO test;

--
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.person_id_seq OWNER TO test;

--
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE person_id_seq OWNED BY person.id;


--
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('person_id_seq', 2, true);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY person ALTER COLUMN id SET DEFAULT nextval('person_id_seq'::regclass);


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: test
--

COPY person (id, first_name, last_name, birthday) FROM stdin;
1	Giacomo	Leopardi	1798-06-29
2	Giuseppe	Verdi	1813-10-10
\.


--
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

