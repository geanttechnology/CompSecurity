// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bff extends Exception
{

    public final buz a;
    public final crx b;

    public bff(String s, Throwable throwable, buz buz, crx crx)
    {
        super(s, throwable);
        a = buz;
        b = crx;
    }

    public bff(Throwable throwable, buz buz, crx crx)
    {
        this(null, null, buz, crx);
    }
}
