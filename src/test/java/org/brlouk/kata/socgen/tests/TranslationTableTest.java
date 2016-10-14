package org.brlouk.kata.socgen.tests;

import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;

import javax.annotation.Resource;

import org.brlouk.kata.socgen.model.TranslationTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslationTableTest {
	
	@Resource
	private TranslationTable table;
	
	@Test
	public void findFirst(){
		Assert.assertEquals(Optional.of(new SimpleEntry<Integer,String>(5,"V")), table.findFirstSymbol(7));
		Assert.assertEquals(Optional.empty(), table.findFirstSymbol(0));
		Assert.assertEquals(Optional.of(new SimpleEntry<Integer,String>(1,"I")), table.findFirstSymbol(1));
		
	}

}
