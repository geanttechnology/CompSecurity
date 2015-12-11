// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

// Referenced classes of package com.google.android.gms.internal:
//            fl

public final class fs
    implements Achievements
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public Result e(Status status)
        {
            return t(status);
        }

        public com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult t(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult(this, status) {

                final Status jP;
                final a uR;

                public AchievementBuffer getAchievements()
                {
                    return new AchievementBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                uR = a1;
                jP = status;
                super();
            }
            };
        }

        private a()
        {
        }

    }

    private static abstract class b extends com.google.android.gms.games.Games.a
    {

        private final String uS;

        static String a(b b1)
        {
            return b1.uS;
        }

        public Result e(Status status)
        {
            return u(status);
        }

        public com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult u(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult(this, status) {

                final Status jP;
                final b uT;

                public String getAchievementId()
                {
                    return b.a(uT);
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                uT = b1;
                jP = status;
                super();
            }
            };
        }

        public b(String s)
        {
            uS = s;
        }
    }


    public fs()
    {
    }

    public Intent getAchievementsIntent(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getAchievementsIntent();
    }

    public void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.b(new b(s, s, i) {

            final fs uO;
            final String uP;
            final int uQ;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.a(null, uP, uQ);
            }

            
            {
                uO = fs.this;
                uP = s1;
                uQ = i;
                super(s);
            }
        });
    }

    public PendingResult incrementImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.b(new b(s, s, i) {

            final fs uO;
            final String uP;
            final int uQ;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.a(this, uP, uQ);
            }

            
            {
                uO = fs.this;
                uP = s1;
                uQ = i;
                super(s);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new a(flag) {

            final boolean uN;
            final fs uO;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.b(this, uN);
            }

            
            {
                uO = fs.this;
                uN = flag;
                super();
            }
        });
    }

    public void reveal(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.b(new b(s, s) {

            final fs uO;
            final String uP;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.b(null, uP);
            }

            
            {
                uO = fs.this;
                uP = s1;
                super(s);
            }
        });
    }

    public PendingResult revealImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(s, s) {

            final fs uO;
            final String uP;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.b(this, uP);
            }

            
            {
                uO = fs.this;
                uP = s1;
                super(s);
            }
        });
    }

    public void setSteps(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.b(new b(s, s, i) {

            final fs uO;
            final String uP;
            final int uQ;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.b(null, uP, uQ);
            }

            
            {
                uO = fs.this;
                uP = s1;
                uQ = i;
                super(s);
            }
        });
    }

    public PendingResult setStepsImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.b(new b(s, s, i) {

            final fs uO;
            final String uP;
            final int uQ;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.b(this, uP, uQ);
            }

            
            {
                uO = fs.this;
                uP = s1;
                uQ = i;
                super(s);
            }
        });
    }

    public void unlock(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.b(new b(s, s) {

            final fs uO;
            final String uP;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.c(null, uP);
            }

            
            {
                uO = fs.this;
                uP = s1;
                super(s);
            }
        });
    }

    public PendingResult unlockImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(s, s) {

            final fs uO;
            final String uP;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            public void a(fl fl1)
            {
                fl1.c(this, uP);
            }

            
            {
                uO = fs.this;
                uP = s1;
                super(s);
            }
        });
    }
}
