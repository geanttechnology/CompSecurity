// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.content.Context;
import android.net.Uri;

public final class SettingsContract
{

    public static final Uri AUTHORITY_URI;
    public static final Uri VALUES_CONTENT_URI;

    private SettingsContract()
    {
    }

    public static String getAppLocalNamespace(Context context)
    {
        return context.getPackageName();
    }

    static 
    {
        AUTHORITY_URI = Uri.parse("content://com.amazon.dcp.settings");
        VALUES_CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "values");
    }
}
