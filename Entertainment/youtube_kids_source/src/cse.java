// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cse
{

    public final csf a;
    public final boolean b;
    public final String c;
    public final Throwable d;

    public cse(csf csf, boolean flag, String s)
    {
        c = s;
        d = null;
        a = csf;
        b = flag;
    }

    public cse(csf csf, boolean flag, String s, Throwable throwable)
    {
        c = s;
        d = throwable;
        a = csf;
        b = flag;
    }

    public cse(csf csf, boolean flag, Throwable throwable)
    {
        c = null;
        d = throwable;
        a = csf;
        b = true;
    }
}
