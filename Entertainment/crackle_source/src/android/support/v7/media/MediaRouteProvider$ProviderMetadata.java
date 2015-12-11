// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.text.TextUtils;

// Referenced classes of package android.support.v7.media:
//            MediaRouteProvider

public static final class mPackageName
{

    private final String mPackageName;

    public String getPackageName()
    {
        return mPackageName;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ProviderMetadata{ packageName=").append(mPackageName).append(" }").toString();
    }

    public (String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("packageName must not be null or empty");
        } else
        {
            mPackageName = s;
            return;
        }
    }
}
