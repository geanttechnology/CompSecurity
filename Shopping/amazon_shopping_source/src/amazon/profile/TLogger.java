// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.profile;

import android.util.Log;

public class TLogger
{

    TLogger()
    {
    }

    public TLogger enableLog(boolean flag)
    {
        Log.d("BogusTLogger", "enableLog");
        return this;
    }

    public TLogger enableTrapz(boolean flag)
    {
        Log.d("BogusTLogger", "enableTrapz");
        return this;
    }

    public int getTraceId(String s, String s1, String s2)
    {
        Log.d("BogusTLogger", "getTraceId");
        return 0;
    }

    public void l(int i, int j, int k)
    {
        l(i, j, k, "");
    }

    public void l(int i, int j, int k, String s)
    {
        Log.d("BogusTLogger", "l");
    }
}
