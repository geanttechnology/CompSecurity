// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public class akw
{

    private static akw b = null;
    public ArrayList a;

    private akw()
    {
        b();
    }

    public static akw a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        akw;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new akw();
        }
        akw;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        akw;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void b()
    {
        a = new ArrayList();
        a.add(a("1", -1, ""));
        a.add(a("2", 0xffe5e5e7, ""));
        a.add(a("3", 0xffc1c6ca, ""));
        a.add(a("4", 0xff9da1a4, ""));
        a.add(a("5", 0xff000000, ""));
        a.add(a("6", 0xffd3ccc6, ""));
        a.add(a("7", 0xffb3adac, ""));
        a.add(a("8", 0xffa68f87, ""));
        a.add(a("9", 0xff928179, ""));
        a.add(a("10", 0xffb38c6f, ""));
        a.add(a("11", 0xff6f4b3d, ""));
        a.add(a("12", 0xffe5e6fa, ""));
        a.add(a("13", 0xffd0c0d7, ""));
        a.add(a("14", 0xffcca6bf, ""));
        a.add(a("15", 0xffa69abe, ""));
        a.add(a("16", 0xffa37bb8, ""));
        a.add(a("17", 0xffcd77fe, ""));
        a.add(a("18", 0xffbc54ef, ""));
        a.add(a("19", 0xff986ef2, ""));
        a.add(a("20", 0xffebf7f7, ""));
        a.add(a("21", 0xffc1e4e8, ""));
        a.add(a("22", 0xffa7eee6, ""));
        a.add(a("23", 0xffa0d8ef, ""));
        a.add(a("24", 0xff84a2d4, ""));
        a.add(a("25", 0xffd9d9d9, ""));
        a.add(a("26", 0xffa8a8a8, ""));
        a.add(a("27", 0xff545454, ""));
        a.add(a("28", 0xff262626, ""));
        a.add(a("30", 0xffac1919, ""));
        a.add(a("31", -48595, ""));
        a.add(a("32", -34253, ""));
        a.add(a("33", -27887, ""));
        a.add(a("34", 0xfffbb334, ""));
        a.add(a("35", -8579, ""));
        a.add(a("36", -12439, ""));
        a.add(a("37", -256, ""));
        a.add(a("38", -93, ""));
        a.add(a("39", 0xffdcff5a, ""));
        a.add(a("40", 0xff8bff16, ""));
        a.add(a("41", 0xff23d70d, ""));
        a.add(a("42", 0xff1aa437, ""));
        a.add(a("43", 0xff248325, ""));
        a.add(a("44", 0xff06583c, ""));
        a.add(a("45", 0xff6bd6a1, ""));
        a.add(a("46", 0xff7ce0ff, ""));
        a.add(a("47", 0xff27ccff, ""));
        a.add(a("48", 0xff3ba4ff, ""));
        a.add(a("49", 0xff1673ff, ""));
        a.add(a("50", 0xff0244cc, ""));
        a.add(a("51", 0xff0d2d94, ""));
        a.add(a("52", 0xff5b1ee5, ""));
        a.add(a("53", 0xff5727a2, ""));
        a.add(a("54", 0xffbc54f0, ""));
        a.add(a("55", 0xffcb78ff, ""));
        a.add(a("56", 0xffbe00e7, ""));
        a.add(a("57", 0xffd430b3, ""));
        a.add(a("58", 0xfff571da, ""));
        a.add(a("59", -45431, ""));
        a.add(a("60", -32864, ""));
        a.add(a("61", -24123, ""));
        a.add(a("62", 0xff796947, ""));
        a.add(a("63", 0xff683300, ""));
        a.add(a("64", 0xff381b00, ""));
    }

    public ams a(String s, int i, String s1)
    {
        s1 = new ams();
        s1.a(s);
        s1.a(i);
        return s1;
    }

}
