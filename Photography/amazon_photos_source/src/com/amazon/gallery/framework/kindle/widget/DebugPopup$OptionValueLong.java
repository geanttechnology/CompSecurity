// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

private static class t> extends t>
{

    boolean CheckPreferenceEquality(Context context, String s)
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong(s, 0L) == ((Long)value).longValue();
    }

    void saveValue(Context context, String s)
    {
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().tLong(s, ((Long)value).longValue()).ply();
    }

    public (Long long1)
    {
        super(long1);
    }
}
