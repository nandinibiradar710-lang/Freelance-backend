package com.marketplace.config;

import com.marketplace.model.*;
import com.marketplace.repository.GigRepository;
import com.marketplace.repository.ProposalRepository;
import com.marketplace.repository.ReviewRepository;
import com.marketplace.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final GigRepository gigRepository;
    private final ProposalRepository proposalRepository;
    private final ReviewRepository reviewRepository;

    public DataInitializer(UserRepository userRepository,
                           GigRepository gigRepository,
                           ProposalRepository proposalRepository,
                           ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.gigRepository = gigRepository;
        this.proposalRepository = proposalRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) return;

        // 1. Seed Student Freelancers
        User student1 = new User(
                null,
                "Alex Chen",
                "alex.chen@stanford.edu",
                Role.STUDENT,
                "Stanford University",
                "Computer Science",
                "2026",
                "Full-stack student developer passionate about React, Tailwind, and scalable backend APIs. Built 4 campus apps with 10k+ users.",
                "React, TypeScript, Spring Boot, Tailwind CSS, Node.js",
                42.0,
                "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200&h=200&fit=crop&crop=face",
                4.9,
                18,
                14,
                true,
                "https://github.com/alexchen-tech",
                "https://alexchen.dev"
        );

        User student2 = new User(
                null,
                "Priya Sharma",
                "priya.sharma@berkeley.edu",
                Role.STUDENT,
                "UC Berkeley",
                "Data Science & AI",
                "2025",
                "Undergrad AI researcher. Experienced with Python, PyTorch, LangChain, LLM fine-tuning, and modern vector databases.",
                "Python, PyTorch, LLMs, LangChain, Pandas, FastAPI",
                48.0,
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?w=200&h=200&fit=crop&crop=face",
                5.0,
                24,
                19,
                true,
                "https://github.com/priyasharma-ai",
                "https://priyasharma.me"
        );

        User student3 = new User(
                null,
                "Elena Rostova",
                "elena.r@nyu.edu",
                Role.STUDENT,
                "NYU Tisch",
                "Interactive Media Design",
                "2025",
                "UI/UX product designer and frontend creative coder. Specializing in sleek modern interfaces, design systems, and micro-interactions.",
                "Figma, UI/UX Design, Tailwind CSS, Framer Motion, 3D Spline",
                45.0,
                "https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=200&h=200&fit=crop&crop=face",
                4.9,
                29,
                22,
                true,
                "https://github.com/elena-design",
                "https://elenadesign.portfolio.site"
        );

        User student4 = new User(
                null,
                "Marcus Vance",
                "m.vance@mit.edu",
                Role.STUDENT,
                "MIT",
                "Electrical Eng & CS",
                "2026",
                "Backend engineer focusing on distributed systems, high throughput Java/Spring microservices, and Docker infrastructure.",
                "Java, Spring Boot, PostgreSQL, Docker, AWS, Redis",
                50.0,
                "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200&h=200&fit=crop&crop=face",
                4.8,
                13,
                11,
                true,
                "https://github.com/marcusvance",
                "https://marcusvance.tech"
        );

        User student5 = new User(
                null,
                "Jordan Lee",
                "jlee@gatech.edu",
                Role.STUDENT,
                "Georgia Tech",
                "Computer Engineering",
                "2027",
                "Cross-platform mobile developer. Published 3 iOS & Android applications with over 50,000 combined downloads.",
                "Flutter, React Native, iOS, Android, Firebase",
                38.0,
                "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=200&h=200&fit=crop&crop=face",
                4.7,
                10,
                8,
                true,
                "https://github.com/jordanlee-dev",
                "https://jordanlee.app"
        );

        User student6 = new User(
                null,
                "Sofia Rodriguez",
                "sofia.r@columbia.edu",
                Role.STUDENT,
                "Columbia University",
                "English & Digital Media",
                "2026",
                "Content strategist and technical writer. Specializes in pitch decks, product launch copywriting, and student-focused branding.",
                "Copywriting, Technical Writing, SEO, Pitch Decks, Marketing",
                35.0,
                "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=200&h=200&fit=crop&crop=face",
                5.0,
                20,
                16,
                true,
                "",
                "https://sofiawrites.com"
        );

        student1 = userRepository.save(student1);
        student2 = userRepository.save(student2);
        student3 = userRepository.save(student3);
        student4 = userRepository.save(student4);
        student5 = userRepository.save(student5);
        student6 = userRepository.save(student6);

        // 2. Seed Client Profiles
        User client1 = new User(
                null,
                "Stanford AI Club Ventures",
                "ventures@stanford.edu",
                Role.CLIENT,
                "Stanford University",
                "Campus Organization",
                "2025",
                "Student-led accelerator funding peer student hackathon projects and venture pilots.",
                "Venture Incubation, Seed Funding",
                0.0,
                "https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=200&h=200&fit=crop",
                5.0,
                8,
                8,
                true,
                "",
                "https://stanfordaiclub.org"
        );

        User client2 = new User(
                null,
                "Dr. Henderson Lab",
                "henderson.lab@berkeley.edu",
                Role.CLIENT,
                "UC Berkeley",
                "Biotechnology Department",
                "Faculty",
                "Academic research lab working on computational genomics and biological neural modeling.",
                "Bioinformatics, Research Grants",
                0.0,
                "https://images.unsplash.com/photo-1532094349884-543bc11b234d?w=200&h=200&fit=crop",
                4.9,
                12,
                12,
                true,
                "",
                "https://hendersonlab.berkeley.edu"
        );

        client1 = userRepository.save(client1);
        client2 = userRepository.save(client2);

        // 3. Seed Gigs
        Gig gig1 = new Gig();
        gig1.setTitle("Full-Stack MVP Web App for Campus Carpooling & Ride Sharing");
        gig1.setDescription("We need a responsive web app for students to coordinate rides between campus and airports during holiday breaks. Requires user sign-up with .edu email, ride posting, seat booking, and chat. React frontend and Spring Boot / Node backend preferred.");
        gig1.setCategory("Web Development");
        gig1.setBudget(650.0);
        gig1.setBudgetType("FIXED");
        gig1.setDuration("2 weeks");
        gig1.setDifficulty("INTERMEDIATE");
        gig1.setStatus(GigStatus.OPEN);
        gig1.setClientId(client1.getId());
        gig1.setClientName(client1.getName());
        gig1.setClientUniversity(client1.getUniversity());
        gig1.setClientAvatar(client1.getAvatarUrl());
        gig1.setRequiredSkills("React, Tailwind CSS, Spring Boot, REST APIs, PostgreSQL");
        gig1.setApplicantsCount(2);
        gig1 = gigRepository.save(gig1);

        Gig gig2 = new Gig();
        gig2.setTitle("Fine-Tune Open Source LLM on Bio-Medical Research Corpus");
        gig2.setDescription("Seeking a qualified AI/ML student to fine-tune Llama 3 / Mistral on 10,000 annotated biomedical research abstracts and evaluate retrieval-augmented generation (RAG) benchmarks using LangChain or LlamaIndex.");
        gig2.setCategory("AI & Machine Learning");
        gig2.setBudget(850.0);
        gig2.setBudgetType("FIXED");
        gig2.setDuration("2-3 weeks");
        gig2.setDifficulty("ADVANCED");
        gig2.setStatus(GigStatus.OPEN);
        gig2.setClientId(client2.getId());
        gig2.setClientName(client2.getName());
        gig2.setClientUniversity(client2.getUniversity());
        gig2.setClientAvatar(client2.getAvatarUrl());
        gig2.setRequiredSkills("Python, PyTorch, HuggingFace, LangChain, RAG");
        gig2.setApplicantsCount(1);
        gig2 = gigRepository.save(gig2);

        Gig gig3 = new Gig();
        gig3.setTitle("Complete 21st-Century UI/UX Design System & Pitch Deck in Figma");
        gig3.setDescription("Need a design wizard to create an ultra-modern dark-mode UI design system in Figma for our student startup, including 12 mobile screens, interactive component variants, and an investor pitch deck.");
        gig3.setCategory("UI/UX Design");
        gig3.setBudget(480.0);
        gig3.setBudgetType("FIXED");
        gig3.setDuration("1 week");
        gig3.setDifficulty("INTERMEDIATE");
        gig3.setStatus(GigStatus.OPEN);
        gig3.setClientId(client1.getId());
        gig3.setClientName(client1.getName());
        gig3.setClientUniversity(client1.getUniversity());
        gig3.setClientAvatar(client1.getAvatarUrl());
        gig3.setRequiredSkills("Figma, UI/UX Design, Wireframing, Pitch Deck, Typography");
        gig3.setApplicantsCount(1);
        gig3 = gigRepository.save(gig3);

        Gig gig4 = new Gig();
        gig4.setTitle("Cross-Platform Flutter Mobile App for Student Note Sharing");
        gig4.setDescription("Develop a mobile application allowing students to scan handwritten lecture notes with OCR, tag by course code (e.g. CS106A), and sync to cloud storage with offline caching support.");
        gig4.setCategory("Mobile Apps");
        gig4.setBudget(720.0);
        gig4.setBudgetType("FIXED");
        gig4.setDuration("3 weeks");
        gig4.setDifficulty("ADVANCED");
        gig4.setStatus(GigStatus.OPEN);
        gig4.setClientId(client1.getId());
        gig4.setClientName(client1.getName());
        gig4.setClientUniversity(client1.getUniversity());
        gig4.setClientAvatar(client1.getAvatarUrl());
        gig4.setRequiredSkills("Flutter, Dart, Firebase, OCR, Mobile UI");
        gig4.setApplicantsCount(0);
        gig4 = gigRepository.save(gig4);

        Gig gig5 = new Gig();
        gig5.setTitle("1-on-1 Tutoring for Multivariable Calculus & Linear Algebra");
        gig5.setDescription("Looking for an experienced STEM student who aced Math 53/54 (or equivalent) to provide 10 hours of structured tutoring sessions and midterm problem set walkthroughs.");
        gig5.setCategory("Academic Tutoring");
        gig5.setBudget(350.0);
        gig5.setBudgetType("FIXED");
        gig5.setDuration("2 weeks");
        gig5.setDifficulty("BEGINNER");
        gig5.setStatus(GigStatus.OPEN);
        gig5.setClientId(client2.getId());
        gig5.setClientName(client2.getName());
        gig5.setClientUniversity(client2.getUniversity());
        gig5.setClientAvatar(client2.getAvatarUrl());
        gig5.setRequiredSkills("Calculus, Linear Algebra, STEM Tutoring, Exam Prep");
        gig5.setApplicantsCount(0);
        gig5 = gigRepository.save(gig5);

        Gig gig6 = new Gig();
        gig6.setTitle("Automated Web Scraping & Clean Dataset Builder for Academic Paper");
        gig6.setDescription("Write clean, modular Python scripts using BeautifulSoup/Playwright to collect 50,000 public records from academic preprint servers, clean missing values, and export to parquet/CSV.");
        gig6.setCategory("Data Analysis & Python");
        gig6.setBudget(420.0);
        gig6.setBudgetType("FIXED");
        gig6.setDuration("5 days");
        gig6.setDifficulty("INTERMEDIATE");
        gig6.setStatus(GigStatus.OPEN);
        gig6.setClientId(client2.getId());
        gig6.setClientName(client2.getName());
        gig6.setClientUniversity(client2.getUniversity());
        gig6.setClientAvatar(client2.getAvatarUrl());
        gig6.setRequiredSkills("Python, BeautifulSoup, Pandas, Playwright, Data Cleaning");
        gig6.setApplicantsCount(0);
        gig6 = gigRepository.save(gig6);

        // 4. Seed Proposals for gig1 and gig2
        Proposal p1 = new Proposal();
        p1.setGigId(gig1.getId());
        p1.setGigTitle(gig1.getTitle());
        p1.setStudentId(student1.getId());
        p1.setStudentName(student1.getName());
        p1.setStudentUniversity(student1.getUniversity());
        p1.setStudentMajor(student1.getMajor());
        p1.setStudentAvatar(student1.getAvatarUrl());
        p1.setStudentRating(student1.getRating());
        p1.setBidAmount(600.0);
        p1.setEstimatedDays(12);
        p1.setCoverLetter("Hey! I've already developed an open-source carpool coordinator at Stanford using React and Spring Boot. I can deliver a clean, lightning-fast web app with authentication, responsive map routes, and intuitive booking in under 12 days.");
        p1.setStatus(ProposalStatus.PENDING);
        proposalRepository.save(p1);

        Proposal p2 = new Proposal();
        p2.setGigId(gig1.getId());
        p2.setGigTitle(gig1.getTitle());
        p2.setStudentId(student4.getId());
        p2.setStudentName(student4.getName());
        p2.setStudentUniversity(student4.getUniversity());
        p2.setStudentMajor(student4.getMajor());
        p2.setStudentAvatar(student4.getAvatarUrl());
        p2.setStudentRating(student4.getRating());
        p2.setBidAmount(650.0);
        p2.setEstimatedDays(14);
        p2.setCoverLetter("Hi team, I specialize in high-efficiency Spring Boot APIs and clean React frontends. I can set up containerized microservices, PostgreSQL indexing, and security best practices for your campus launch.");
        p2.setStatus(ProposalStatus.PENDING);
        proposalRepository.save(p2);

        Proposal p3 = new Proposal();
        p3.setGigId(gig2.getId());
        p3.setGigTitle(gig2.getTitle());
        p3.setStudentId(student2.getId());
        p3.setStudentName(student2.getName());
        p3.setStudentUniversity(student2.getUniversity());
        p3.setStudentMajor(student2.getMajor());
        p3.setStudentAvatar(student2.getAvatarUrl());
        p3.setStudentRating(student2.getRating());
        p3.setBidAmount(800.0);
        p3.setEstimatedDays(14);
        p3.setCoverLetter("Hello Dr. Henderson! I do NLP research at Berkeley BAIR lab. I have hands-on experience fine-tuning LoRA adapters on PubMed and bioRxiv papers, plus building production-grade RAG evaluation with Ragas.");
        p3.setStatus(ProposalStatus.PENDING);
        proposalRepository.save(p3);

        Proposal p4 = new Proposal();
        p4.setGigId(gig3.getId());
        p4.setGigTitle(gig3.getTitle());
        p4.setStudentId(student3.getId());
        p4.setStudentName(student3.getName());
        p4.setStudentUniversity(student3.getUniversity());
        p4.setStudentMajor(student3.getMajor());
        p4.setStudentAvatar(student3.getAvatarUrl());
        p4.setStudentRating(student3.getRating());
        p4.setBidAmount(450.0);
        p4.setEstimatedDays(6);
        p4.setCoverLetter("Hi! I would love to build your 21st.dev inspired Figma design system. I specialize in neo-minimalist dark theme aesthetics, tokenized auto-layouts, and investor-ready pitch presentations!");
        p4.setStatus(ProposalStatus.PENDING);
        proposalRepository.save(p4);

        // 5. Seed Reviews
        Review r1 = new Review(
                null,
                gig1.getId(),
                student1.getId(),
                "Stanford AI Club",
                "Client",
                5,
                "Alex is exceptionally talented! Delivered the web app days ahead of schedule with flawless code quality and brilliant documentation."
        );
        Review r2 = new Review(
                null,
                gig2.getId(),
                student2.getId(),
                "Berkeley Lab Director",
                "Client",
                5,
                "Priya's ML expertise is on par with senior PhD researchers. The RAG pipeline exceeded our accuracy expectations!"
        );
        reviewRepository.save(r1);
        reviewRepository.save(r2);
    }
}
