import java.util.concurrent.atomic.AtomicLong;

public class Counters extends Thread {
static AtomicLong count1=new AtomicLong(0);
static AtomicLong count2=new AtomicLong(0);
//static long count2=0;
//static Object mutex1 = new Object();
//static Object mutex2 = new Object();
static long nIterations=1000;

public static long getCount1() {
	return count1.get();
}

public static long getCount2() {
	return count2.get();
}

public static void setnIterations(long nIterations) {
	Counters.nIterations = nIterations;
}

/*synchronized*/ static private void increment1(){	
	//synchronized (mutex1) {
		count1.getAndIncrement();
}

///*synchronized*/ static private void increment2(){
static private void increment2(){
		count2.getAndIncrement();
}


@Override
public void run(){
	for(long i=0; i<nIterations ; i++){
		increment1();
		increment2();
	}
}
}
