package com.example.brainboggle3;

public class ListItem_sol
{
    private  String Qu,sola,solb,solc,sold,solcorr;

    public ListItem_sol(String Qu, String sola, String solb,String solc ,String sold,String solcorr,String sol_score)
    {
        this.Qu=Qu;
        this.sola=sola;
        this.solb=solb;
        this.solc=solc;
        this.sold=sold;
        this.solcorr=solcorr;



    }
    public String getQuestion()
    {
        return Qu;
    }
    public String getSola()
    {
        return sola;
    }
    public String getSolb()
    {
        return solb;
    }
    public String getSolc()
    {
        return solc;
    }
    public String getSold()
    {
        return sold;
    }
    public String getSolcorr()
    {
        return solcorr;
    }
}
