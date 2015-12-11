// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class zzdc
{

    private Context mContext;
    private Tracker zzLw;
    private GoogleAnalytics zzLy;

    public zzdc(Context context)
    {
        mContext = context;
    }

    private void zzfc(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzLy == null)
        {
            zzLy = GoogleAnalytics.getInstance(mContext);
            zzLy.setLogger(new zza());
            zzLw = zzLy.newTracker(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public Tracker zzfb(String s)
    {
        zzfc(s);
        return zzLw;
    }

    private class zza
        implements Logger
    {

        private static int zzjB(int i)
        {
            switch (i)
            {
            case 6: // '\006'
            default:
                return 3;

            case 5: // '\005'
                return 2;

            case 3: // '\003'
            case 4: // '\004'
                return 1;

            case 2: // '\002'
                return 0;
            }
        }

        public void error(Exception exception)
        {
            zzbg.zzb("", exception);
        }

        public void error(String s)
        {
            zzbg.e(s);
        }

        public int getLogLevel()
        {
            return zzjB(zzbg.getLogLevel());
        }

        public void info(String s)
        {
            zzbg.zzaG(s);
        }

        public void setLogLevel(int i)
        {
            zzbg.zzaH("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String s)
        {
            zzbg.v(s);
        }

        public void warn(String s)
        {
            zzbg.zzaH(s);
        }

        zza()
        {
        }
    }

}
