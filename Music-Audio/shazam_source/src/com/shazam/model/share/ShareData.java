// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.share;

import com.shazam.android.ae.m;
import java.io.Serializable;
import java.util.ArrayList;

public class ShareData
    implements Serializable
{
    public static class Builder
    {

        public String beaconKey;
        public String campaign;
        public String screenName;
        public final ArrayList shareDataItems = new ArrayList();
        public String subject;
        public String text;
        public String trackId;
        public String trackStyle;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(ShareData sharedata)
        {
            Builder builder = new Builder();
            builder.subject = ShareData.a(sharedata);
            builder.text = ShareData.b(sharedata);
            builder.shareDataItems.addAll(ShareData.c(sharedata));
            builder.trackId = ShareData.d(sharedata);
            builder.beaconKey = ShareData.e(sharedata);
            builder.campaign = ShareData.f(sharedata);
            builder.trackStyle = ShareData.g(sharedata);
            builder.screenName = ShareData.h(sharedata);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.subject;
        }

        static String b(Builder builder)
        {
            return builder.text;
        }

        static ArrayList c(Builder builder)
        {
            return builder.shareDataItems;
        }

        static String d(Builder builder)
        {
            return builder.trackId;
        }

        static String e(Builder builder)
        {
            return builder.beaconKey;
        }

        static String f(Builder builder)
        {
            return builder.campaign;
        }

        static String g(Builder builder)
        {
            return builder.trackStyle;
        }

        static String h(Builder builder)
        {
            return builder.screenName;
        }

        public final ShareData b()
        {
            return new ShareData(this, null);
        }

        public Builder()
        {
        }
    }


    public String beaconKey;
    public String campaign;
    public String screenName;
    private ArrayList shareDataItems;
    public String subject;
    public String text;
    public String trackId;
    public String trackStyle;

    public ShareData()
    {
    }

    private ShareData(Builder builder)
    {
        subject = Builder.a(builder);
        text = Builder.b(builder);
        shareDataItems = Builder.c(builder);
        trackId = Builder.d(builder);
        beaconKey = Builder.e(builder);
        campaign = Builder.f(builder);
        trackStyle = Builder.g(builder);
        screenName = Builder.h(builder);
    }

    ShareData(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(ShareData sharedata)
    {
        return sharedata.subject;
    }

    static String b(ShareData sharedata)
    {
        return sharedata.text;
    }

    static ArrayList c(ShareData sharedata)
    {
        return sharedata.shareDataItems;
    }

    static String d(ShareData sharedata)
    {
        return sharedata.trackId;
    }

    static String e(ShareData sharedata)
    {
        return sharedata.beaconKey;
    }

    static String f(ShareData sharedata)
    {
        return sharedata.campaign;
    }

    static String g(ShareData sharedata)
    {
        return sharedata.trackStyle;
    }

    static String h(ShareData sharedata)
    {
        return sharedata.screenName;
    }

    public final ArrayList a()
    {
        if (shareDataItems != null)
        {
            return shareDataItems;
        } else
        {
            return new ArrayList(0);
        }
    }

    public final boolean b()
    {
        if (shareDataItems == null)
        {
            m.a(this, "Share data items are null", new IllegalStateException("Share data items are null"));
        }
        return !a().isEmpty();
    }
}
