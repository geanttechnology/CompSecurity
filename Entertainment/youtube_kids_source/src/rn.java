// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rn
{

    static final int a[];

    static 
    {
        a = new int[ctt.values().length];
        try
        {
            a[ctt.d.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ctt.e.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ctt.b.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ctt.h.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
