// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl
    implements AppContents
{
    private static abstract class LoadsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult zzaa(Status status)
        {
            return new com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult(this, status) {

                final Status zzVb;
                final LoadsImpl zzaxc;

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxc = loadsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaa(status);
        }
    }


    public AppContentsImpl()
    {
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/AppContentsImpl$1

/* anonymous class */
    class _cls1 extends LoadsImpl
    {

        final boolean zzawR;
        final int zzawZ;
        final String zzaxa;
        final String zzaxb[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawZ, zzaxa, zzaxb, zzawR);
        }
    }

}
