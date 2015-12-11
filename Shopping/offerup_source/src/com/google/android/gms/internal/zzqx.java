// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class zzqx
    implements com.google.android.gms.common.api.Api.ApiOptions.Optional
{

    public static final zzqx zzaUZ = (new zza()).zzCi();
    private final boolean zzTi;
    private final boolean zzTk;
    private final String zzTl;
    private final boolean zzaVa;
    private final com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzaVb;
    private final boolean zzaVc;

    private zzqx(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks serverauthcodecallbacks, boolean flag2, boolean flag3)
    {
        zzaVa = flag;
        zzTi = flag1;
        zzTl = s;
        zzaVb = serverauthcodecallbacks;
        zzaVc = flag2;
        zzTk = flag3;
    }

    zzqx(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks serverauthcodecallbacks, boolean flag2, boolean flag3, _cls1 _pcls1)
    {
        this(flag, flag1, s, serverauthcodecallbacks, flag2, flag3);
    }

    public final boolean zzCf()
    {
        return zzaVa;
    }

    public final com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzCg()
    {
        return zzaVb;
    }

    public final boolean zzCh()
    {
        return zzaVc;
    }

    public final boolean zzlY()
    {
        return zzTi;
    }

    public final boolean zzma()
    {
        return zzTk;
    }

    public final String zzmb()
    {
        return zzTl;
    }


    private class zza
    {

        private String zzaSe;
        private boolean zzaVd;
        private boolean zzaVe;
        private com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzaVf;
        private boolean zzaVg;
        private boolean zzaVh;

        private String zzet(String s)
        {
            zzx.zzw(s);
            boolean flag;
            if (zzaSe == null || zzaSe.equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "two different server client ids provided");
            return s;
        }

        public final zzqx zzCi()
        {
            return new zzqx(zzaVd, zzaVe, zzaSe, zzaVf, zzaVg, zzaVh, null);
        }

        public final zza zza(String s, com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks serverauthcodecallbacks)
        {
            zzaVd = true;
            zzaVe = true;
            zzaSe = zzet(s);
            zzaVf = (com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks)zzx.zzw(serverauthcodecallbacks);
            return this;
        }

        public zza()
        {
        }
    }

}
