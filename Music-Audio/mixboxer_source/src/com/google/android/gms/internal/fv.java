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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

// Referenced classes of package com.google.android.gms.internal:
//            fl

public final class fv
    implements Invitations
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public Result e(Status status)
        {
            return w(status);
        }

        public com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult w(Status status)
        {
            return new com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult(this, status) {

                final Status jP;
                final a uX;

                public InvitationBuffer getInvitations()
                {
                    return new InvitationBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                uX = a1;
                jP = status;
                super();
            }
            };
        }

        private a()
        {
        }

    }


    public fv()
    {
    }

    public Intent getInvitationInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getInvitationInboxIntent();
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a() {

            final fv uW;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.h(this);
            }

            
            {
                uW = fv.this;
                super();
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient googleapiclient, OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        Games.j(googleapiclient).registerInvitationListener(oninvitationreceivedlistener);
    }

    public void unregisterInvitationListener(GoogleApiClient googleapiclient)
    {
        Games.j(googleapiclient).unregisterInvitationListener();
    }
}
