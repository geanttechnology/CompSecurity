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

        public com.google.android.gms.games.quest.Quests.AcceptQuestResult zzat(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.AcceptQuestResult(this, status) {

                final Status zzQs;
                final AcceptImpl zzavG;

                public Quest getQuest()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavG = acceptimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzat(status);
        }

        private AcceptImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class ClaimImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.quest.Quests.ClaimMilestoneResult zzau(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.ClaimMilestoneResult(this, status) {

                final Status zzQs;
                final ClaimImpl zzavH;

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
                    return zzQs;
                }

            
            {
                zzavH = claimimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzau(status);
        }

        private ClaimImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.quest.Quests.LoadQuestsResult zzav(Status status)
        {
            return new com.google.android.gms.games.quest.Quests.LoadQuestsResult(this, status) {

                final Status zzQs;
                final LoadsImpl zzavI;

                public QuestBuffer getQuests()
                {
                    return new QuestBuffer(DataHolder.zzbp(zzQs.getStatusCode()));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavI = loadsimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzav(status);
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

            final String zzavA;
            final QuestsImpl zzavB;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzh(this, zzavA);
            }

            
            {
                zzavB = QuestsImpl.this;
                zzavA = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult claim(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.zzb(new ClaimImpl(googleapiclient, s, s1) {

            final String zzavA;
            final QuestsImpl zzavB;
            final String zzavC;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzavA, zzavC);
            }

            
            {
                zzavB = QuestsImpl.this;
                zzavA = s;
                zzavC = s1;
                super(googleapiclient);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient googleapiclient, String s)
    {
        return Games.zzd(googleapiclient).zzcY(s);
    }

    public Intent getQuestsIntent(GoogleApiClient googleapiclient, int ai[])
    {
        return Games.zzd(googleapiclient).zzb(ai);
    }

    public PendingResult load(GoogleApiClient googleapiclient, int ai[], int i, boolean flag)
    {
        return googleapiclient.zza(new LoadsImpl(googleapiclient, ai, i, flag) {

            final int zzauQ;
            final boolean zzaut;
            final QuestsImpl zzavB;
            final int zzavD[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzavD, zzauQ, zzaut);
            }

            
            {
                zzavB = QuestsImpl.this;
                zzavD = ai;
                zzauQ = i;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult loadByIds(GoogleApiClient googleapiclient, boolean flag, String as[])
    {
        return googleapiclient.zza(new LoadsImpl(googleapiclient, flag, as) {

            final boolean zzaut;
            final QuestsImpl zzavB;
            final String zzavE[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzaut, zzavE);
            }

            
            {
                zzavB = QuestsImpl.this;
                zzaut = flag;
                zzavE = as;
                super(googleapiclient);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient googleapiclient, QuestUpdateListener questupdatelistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zzc(googleapiclient.zzp(questupdatelistener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzcZ(s);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zztR();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/QuestsImpl$5

/* anonymous class */
    class _cls5 extends LoadsImpl
    {

        final int zzauQ;
        final boolean zzaut;
        final String zzauv;
        final int zzavD[];
        final String zzavF;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavF, zzavD, zzauQ, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/QuestsImpl$6

/* anonymous class */
    class _cls6 extends LoadsImpl
    {

        final boolean zzaut;
        final String zzauv;
        final String zzavE[];
        final String zzavF;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavF, zzaut, zzavE);
        }
    }

}
