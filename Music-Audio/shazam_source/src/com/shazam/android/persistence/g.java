// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence;

import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.k.p;
import com.shazam.model.follow.FollowAction;

public final class g
    implements p
{

    private final com.shazam.android.persistence.n.b b;
    private final b c;

    public g(com.shazam.android.persistence.n.b b1, b b2)
    {
        b = b1;
        c = b2;
    }

    public final void a(FollowAction followaction)
    {
        try
        {
            b.b("pk_pending_follow_action", c.a(followaction));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FollowAction followaction)
        {
            return;
        }
    }

    public final boolean a()
    {
        return b.a("pk_pending_follow_action");
    }

    public final FollowAction b()
    {
        FollowAction followaction;
        try
        {
            followaction = (FollowAction)c.a(b.h("pk_pending_follow_action"), com/shazam/model/follow/FollowAction);
        }
        catch (c c1)
        {
            return com.shazam.model.follow.FollowAction.Builder.a().b();
        }
        return followaction;
    }

    public final void c()
    {
        b.i("pk_pending_follow_action");
    }
}
