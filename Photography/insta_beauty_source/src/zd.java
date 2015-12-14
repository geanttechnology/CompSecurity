// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class zd
{

    public static final int a[];

    static 
    {
        a = new int[com.fotoable.comlib.util.AsyncTask.Status.values().length];
        try
        {
            a[com.fotoable.comlib.util.AsyncTask.Status.RUNNING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.comlib.util.AsyncTask.Status.FINISHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
