// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import ou;
import xc;

public class KidsLicensesActivity extends ou
{

    public KidsLicensesActivity()
    {
    }

    public static Intent a(Context context)
    {
        return (new Intent(context, com/google/android/apps/youtube/kids/activities/KidsLicensesActivity)).putExtra("licensesUrl", "file:///android_asset/licenses.html");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (WebView)findViewById(0x7f100134);
        if (bundle != null)
        {
            bundle.setOnLongClickListener(new xc(this));
        }
    }
}
