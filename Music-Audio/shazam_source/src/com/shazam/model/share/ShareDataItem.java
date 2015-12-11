// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.share;

import com.shazam.model.sheet.BottomSheetItem;
import java.io.Serializable;

public class ShareDataItem
    implements BottomSheetItem, Serializable
{
    public static class Builder
    {

        public String iconUri;
        public String intentClassName;
        public String intentPackageName;
        public String title;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.iconUri;
        }

        static String b(Builder builder)
        {
            return builder.title;
        }

        static String c(Builder builder)
        {
            return builder.intentPackageName;
        }

        static String d(Builder builder)
        {
            return builder.intentClassName;
        }

        public final ShareDataItem b()
        {
            return new ShareDataItem(this, null);
        }

        public Builder()
        {
        }
    }


    public String iconUri;
    public String intentClassName;
    public String intentPackageName;
    private String title;

    private ShareDataItem()
    {
    }

    private ShareDataItem(Builder builder)
    {
        iconUri = Builder.a(builder);
        title = Builder.b(builder);
        intentPackageName = Builder.c(builder);
        intentClassName = Builder.d(builder);
    }

    ShareDataItem(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final String a()
    {
        return iconUri;
    }

    public final String b()
    {
        return title;
    }
}
