// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.net.Uri;

// Referenced classes of package com.groupon.util:
//            ContextUtils

public class UriUtil
{

    public UriUtil()
    {
    }

    public static Uri generateSoundUri(Context context, int i)
    {
        return Uri.parse((new StringBuilder()).append("android.resource://").append(ContextUtils.getResourcePackageName(context)).append("/").append(i).toString());
    }
}
