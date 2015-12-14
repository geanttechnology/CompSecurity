// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

class de
{

    private GoogleAnalytics aij;
    private Context mContext;
    private Tracker tP;

    de(Context context)
    {
        mContext = context;
    }

    private void cn(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (aij == null)
        {
            aij = GoogleAnalytics.getInstance(mContext);
            aij.setLogger(new a());
            tP = aij.newTracker(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public Tracker cm(String s)
    {
        cn(s);
        return tP;
    }

    /* member class not found */
    class a {}

}
