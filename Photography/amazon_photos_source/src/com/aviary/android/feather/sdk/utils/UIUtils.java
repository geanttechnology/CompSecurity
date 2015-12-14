// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.aviary.android.feather.sdk.widget.AviaryToast;

public final class UIUtils
{

    public static final int GLOW_MODE_CHECKED = 4;
    public static final int GLOW_MODE_PRESSED = 2;
    public static final int GLOW_MODE_SELECTED = 8;
    public static final int HIGHLIGHT_MODE_CHECKED = 4;
    public static final int HIGHLIGHT_MODE_PRESSED = 2;
    public static final int HIGHLIGHT_MODE_SELECTED = 8;

    private UIUtils()
    {
    }

    public static boolean checkBits(int i, int j)
    {
        return (i & j) == j;
    }

    public static AviaryToast createModalLoaderToast(Context context)
    {
        return AviaryToast.make(context, com.aviary.android.feather.sdk.R.layout.aviary_modal_progress_view, -1);
    }

    public static Toast makeCustomToast(Context context)
    {
        return makeCustomToast(context, com.aviary.android.feather.sdk.R.layout.aviary_toast_layout);
    }

    public static Toast makeCustomToast(Context context, int i)
    {
        android.view.View view = LayoutInflater.from(context).inflate(i, null);
        context = new Toast(context);
        context.setDuration(0);
        context.setView(view);
        context.setGravity(17, 0, 0);
        return context;
    }
}
