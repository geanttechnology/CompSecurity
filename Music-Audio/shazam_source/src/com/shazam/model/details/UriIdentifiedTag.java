// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.details;

import android.net.Uri;
import com.shazam.model.Tag;

public class UriIdentifiedTag
{
    public static class Builder
    {

        public Tag tag;
        public Uri uri;

        static Uri a(Builder builder)
        {
            return builder.uri;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static Tag b(Builder builder)
        {
            return builder.tag;
        }

        public final UriIdentifiedTag b()
        {
            return new UriIdentifiedTag(this, null);
        }

        public Builder()
        {
        }
    }


    public final Tag tag;
    public final Uri uri;

    private UriIdentifiedTag(Builder builder)
    {
        uri = Builder.a(builder);
        tag = Builder.b(builder);
    }

    UriIdentifiedTag(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final boolean a()
    {
        return tag != null && tag.track != null;
    }
}
