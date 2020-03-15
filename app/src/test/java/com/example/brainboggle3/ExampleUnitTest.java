package com.example.brainboggle3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //Main Activity
    @Test
    public void chk7()
    {
        MainActivity m4 = new MainActivity();
        boolean out4;
        out4 = m4.check1("cb.en.u4cse17357@cb.students.amrita.edu");
        assertEquals(true,out4);
    }

    @Test
    public void chk2() {
        MainActivity m2 = new MainActivity();
        boolean out;
        out = m2.check2("8008085001");
        assertEquals(false, out);

    }

    //-ve test case
    @Test
    public void chk3() {
        MainActivity m3 = new MainActivity();
        boolean outp;
        outp = m3.check3(true);
        assertEquals(true, outp);
    }

    //Login
    //-ve test case
    @Test
    public void chk4() {
        login l1 = new login();
        boolean out1;
        out1 = l1.check4("cb.en.u4cse17357@cb.students.amrita.edu");
        assertEquals(false, out1);
    }

    @Test
    public void chk5() {
        login l2 = new login();
        boolean out2;
        out2 = l2.check5("17357");
        assertEquals(true, out2);
    }

    //quiz password
    @Test
    public void chk6() {
        quiz_password qp = new quiz_password();
        boolean out3;
        out3 = qp.check6("compiler");
        assertEquals(true, out3);
    }
    @Test
    public void c4(){
        MainActivity m=new MainActivity();
        boolean op;
        op=m.check15("mm","l","k","n","o","j","q");
        assertEquals(false,op);
    }
//registration


}