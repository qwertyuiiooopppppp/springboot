package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.zerock.b01.domain.Board;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
class BoardReposotoryTest {

    @Autowired
    private  BoardReposotory boardReposotory;
@Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i-> {
            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("user" + (i % 10)).build();

                    Board result=boardReposotory.save(board);
                    log.info("bno : " + result.getBno());
        });
    }
    
    @Test
    public void testRead(){
       Long bno =3L;
        Optional<Board> byId = boardReposotory.findById(bno);

        Board board= byId.orElseThrow();
        log.info(board);


    }

    @Test
    public void testTitle(){
    String title = "title...100";
    Board byTitle = boardReposotory.findByTitle(title);
    log.info(byTitle);
    }
}