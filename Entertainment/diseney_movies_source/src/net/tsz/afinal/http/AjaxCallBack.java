// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http;


public abstract class AjaxCallBack
{

    private boolean progress;
    private int rate;

    public AjaxCallBack()
    {
        progress = true;
        rate = 1000;
    }

    public int getRate()
    {
        return rate;
    }

    public boolean isProgress()
    {
        return progress;
    }

    public void onFailure(Throwable throwable, String s)
    {
    }

    public void onLoading(long l, long l1)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(Object obj)
    {
    }

    public AjaxCallBack progress(boolean flag, int i)
    {
        progress = flag;
        rate = i;
        return this;
    }

    public void setRate(int i)
    {
        rate = i;
    }
}
