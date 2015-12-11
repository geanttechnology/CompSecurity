// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.content.Context;
import co.vine.android.util.BuildUtil;
import java.util.Locale;

public class Amazon
{

    public Amazon()
    {
    }

    public static String getBucket(Context context)
    {
        return BuildUtil.getAmazonBucket(context).toLowerCase(Locale.US);
    }
}
