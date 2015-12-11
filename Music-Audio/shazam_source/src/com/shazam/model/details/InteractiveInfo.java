// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.details;

import com.shazam.model.follow.FollowData;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;

public class InteractiveInfo
{
    public static class Builder
    {

        public FollowData followData;
        public PreviewViewData previewViewData;
        public Stores stores;

        public static Builder a()
        {
            return new Builder();
        }

        static Stores a(Builder builder)
        {
            return builder.stores;
        }

        static PreviewViewData b(Builder builder)
        {
            return builder.previewViewData;
        }

        static FollowData c(Builder builder)
        {
            return builder.followData;
        }

        public final InteractiveInfo b()
        {
            return new InteractiveInfo(this);
        }

        public Builder()
        {
        }
    }


    public FollowData followData;
    public PreviewViewData previewViewData;
    public Stores stores;

    private InteractiveInfo()
    {
    }

    private InteractiveInfo(Builder builder)
    {
        stores = Builder.a(builder);
        previewViewData = Builder.b(builder);
        followData = Builder.c(builder);
    }


    public final PreviewViewData a()
    {
        if (previewViewData == null)
        {
            return com.shazam.model.preview.PreviewViewData.Builder.a().b();
        } else
        {
            return previewViewData;
        }
    }
}
