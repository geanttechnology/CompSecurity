// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class buq
{

    public static final int a[];

    static 
    {
        a = new int[io.fabric.sdk.android.services.concurrency.AsyncTask.Status.values().length];
        try
        {
            a[io.fabric.sdk.android.services.concurrency.AsyncTask.Status.RUNNING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[io.fabric.sdk.android.services.concurrency.AsyncTask.Status.FINISHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
