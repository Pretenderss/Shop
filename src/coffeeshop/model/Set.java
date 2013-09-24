package coffeeshop.model;

import java.util.ArrayList;
import java.util.Collection;

public class Set {
	ArrayList<Beverage> bv = new <Beverage> ArrayList();
	Equipment[] defaultEq = {new EqCup(), new EqLid(), new EqSticks(),new EqLid(), new EqNapkins()};
	ArrayList eq = new ArrayList();

	Set(ArrayList <Beverage> bv, Ingredients... ingr) {
	
	}
}
