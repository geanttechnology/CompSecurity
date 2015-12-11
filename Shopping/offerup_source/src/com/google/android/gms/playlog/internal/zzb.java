// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            PlayLoggerContext, LogEvent

public class zzb
{

    private final ArrayList zzaRK;
    private int zzaRL;

    public zzb()
    {
        this(100);
    }

    public zzb(int i)
    {
        zzaRK = new ArrayList();
        zzaRL = i;
    }

    private void zzBu()
    {
        for (; getSize() > getCapacity(); zzaRK.remove(0)) { }
    }

    public void clear()
    {
        zzaRK.clear();
    }

    public int getCapacity()
    {
        return zzaRL;
    }

    public int getSize()
    {
        return zzaRK.size();
    }

    public boolean isEmpty()
    {
        return zzaRK.isEmpty();
    }

    public ArrayList zzBt()
    {
        return zzaRK;
    }

    public void zza(PlayLoggerContext playloggercontext, LogEvent logevent)
    {
        zzaRK.add(new zza(playloggercontext, logevent, null));
        zzBu();
    }

    private class zza
    {

        public final PlayLoggerContext zzaRM;
        public final LogEvent zzaRN;
        public final com.google.android.gms.internal.zzsi.zzd zzaRO;

        private zza(PlayLoggerContext playloggercontext, LogEvent logevent)
        {
            zzaRM = (PlayLoggerContext)zzx.zzw(playloggercontext);
            zzaRN = (LogEvent)zzx.zzw(logevent);
            zzaRO = null;
        }

        zza(PlayLoggerContext playloggercontext, LogEvent logevent, _cls1 _pcls1)
        {
            this(playloggercontext, logevent);
        }
    }

}
