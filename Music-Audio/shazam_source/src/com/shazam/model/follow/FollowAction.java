// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


// Referenced classes of package com.shazam.model.follow:
//            FollowData

public class FollowAction
{
    public static class Builder
    {

        public FollowData followData;
        public boolean following;

        public static Builder a()
        {
            return new Builder();
        }

        static boolean a(Builder builder)
        {
            return builder.following;
        }

        static FollowData b(Builder builder)
        {
            return builder.followData;
        }

        public final FollowAction b()
        {
            return new FollowAction(this, null);
        }

        public Builder()
        {
        }
    }


    private FollowData followData;
    public boolean following;

    private FollowAction()
    {
    }

    private FollowAction(Builder builder)
    {
        following = Builder.a(builder);
        followData = Builder.b(builder);
    }

    FollowAction(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final FollowData a()
    {
        if (followData == null)
        {
            return FollowData.Builder.a().b();
        } else
        {
            return followData;
        }
    }
}
