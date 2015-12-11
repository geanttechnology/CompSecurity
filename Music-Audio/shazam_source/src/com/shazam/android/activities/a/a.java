// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.a;

import android.content.Intent;
import android.net.Uri;

public final class a
{

    public static Uri a(Intent intent)
    {
        return (Uri)(Uri)intent.getParcelableExtra("shazamUri");
    }

    public static void a(Intent intent, Uri uri)
    {
        intent.putExtra("shazamUri", uri);
    }
}
