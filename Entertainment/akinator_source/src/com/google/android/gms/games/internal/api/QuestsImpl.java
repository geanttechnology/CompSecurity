// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl
    implements Quests
{
    private static abstract class AcceptImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.quest.Quests.AcceptQuestResult zzas(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.AcceptQuestResult(this, status) {

                final Status zzVb;
                final AcceptImpl zzaye;

                public Quest getQuest()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaye = acceptimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzas(status);
        }

        private AcceptImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class ClaimImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.quest.Quests.ClaimMilestoneResult zzat(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.ClaimMilestoneResult(this, status) {

                final Status zzVb;
                final ClaimImpl zzayf;

                public Milestone getMilestone()
                {
                    return null;
                }

                public Quest getQuest()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayf = claimimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzat(status);
        }

        private ClaimImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.quest.Quests.LoadQuestsResult zzau(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.LoadQuestsResult(this, status) {

                final Status zzVb;
                final LoadsImpl zzayg;

                public QuestBuffer getQuests()
                {
                    return new QuestBuffer(DataHolder.zzbu(zzVb.getStatusCode()));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzayg = loadsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzau(status);
        }

        private LoadsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public QuestsImpl()
    {
    }

    public PendingResult accept(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new AcceptImpl(googleapiclient, s) {

            final String zzaxY;
            final QuestsImpl zzaxZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzh(this, zzaxY);
            }

            
            {
                zzaxZ = QuestsImpl.this;
                zzaxY = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult claim(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.zzb(new ClaimImpl(googleapiclient, s, s1) {

            final String zzaxY;
            final QuestsImpl zzaxZ;
            final String zzaya;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzaxY, zzaya);
            }

            
            {
                zzaxZ = QuestsImpl.this;
                zzaxY = s;
                zzaya = s1;
                super(googleapiclient);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient googleapiclient, String s)
    {
        return Games.zzc(googleapiclient).zzcX(s);
    }

    public Intent getQuestsIntent(GoogleApiClient googleapiclient, int ai[])
    {
        return Games.zzc(googleapiclient).zzb(ai);
    }

    public PendingResult load(GoogleApiClient googleapiclient, int ai[], int i, boolean flag)
    {
        return googleapiclient.zza(new LoadsImpl(googleapiclient, ai, i, flag) {

            final boolean zzawR;
            final QuestsImpl zzaxZ;
            final int zzaxo;
            final int zzayb[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayb, zzaxo, zzawR);
            }

            
            {
                zzaxZ = QuestsImpl.this;
                zzayb = ai;
                zzaxo = i;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult loadByIds(GoogleApiClient googleapiclient, boolean flag, String as[])
    {
        return googleapiclient.zza(new LoadsImpl(googleapiclient, flag, as) {

            final boolean zzawR;
            final QuestsImpl zzaxZ;
            final String zzayc[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzawR, zzayc);
            }

            
            {
                zzaxZ = QuestsImpl.this;
                zzawR = flag;
                zzayc = as;
                super(googleapiclient);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient googleapiclient, QuestUpdateListener questupdatelistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zzc(googleapiclient.zzo(questupdatelistener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzcY(s);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzuH();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/QuestsImpl$5

/* anonymous class */
    class _cls5 extends LoadsImpl
    {

        final boolean zzawR;
        final String zzawT;
        final int zzaxo;
        final int zzayb[];
        final String zzayd;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayd, zzayb, zzaxo, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/QuestsImpl$6

/* anonymous class */
    class _cls6 extends LoadsImpl
    {

        final boolean zzawR;
        final String zzawT;
        final String zzayc[];
        final String zzayd;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayd, zzawR, zzayc);
        }
    }

}
