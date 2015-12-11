// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.f;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.shazam.android.d.c;

public final class b
{

    public static Intent a(Uri uri)
    {
        Intent intent = new Intent("com.shazam.android.action.tagging.SERVICE");
        intent.putExtra("tagUri", uri);
        return intent;
    }

    public static Intent a(String s, com.shazam.android.ay.b b1, c c1)
    {
        Intent intent = new Intent("com.shazam.android.action.tagging.SERVICE");
        intent.putExtra("errorString", s);
        intent.putExtra("errorType", b1);
        intent.putExtra("tagBrand", c1);
        return intent;
    }

    public static IntentFilter a()
    {
        return new IntentFilter("com.shazam.android.action.tagging.STARTED");
    }

    public static Intent b()
    {
        return new Intent("com.shazam.android.action.tagging.STOPPED");
    }

    public static Intent c()
    {
        return new Intent("com.shazam.android.action.tagging.COMPLETE");
    }

    public static IntentFilter d()
    {
        return new IntentFilter("com.shazam.android.action.tagging.STOPPED");
    }

    public static IntentFilter e()
    {
        return new IntentFilter("com.shazam.android.action.tagging.SERVICE");
    }

    public static Intent f()
    {
        return new Intent("com.shazam.android.action.tagging.AUTO_COMPLETE");
    }
}
