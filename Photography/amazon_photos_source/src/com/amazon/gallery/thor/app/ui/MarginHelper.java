// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui;

import android.view.View;

public class MarginHelper
{

    public static void adjustBottomMargin(View view, int i)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = getMarginParams(view);
        marginlayoutparams.setMargins(marginlayoutparams.leftMargin, marginlayoutparams.topMargin, marginlayoutparams.rightMargin, i);
        view.setLayoutParams(marginlayoutparams);
    }

    public static void adjustRightMargin(View view, int i)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = getMarginParams(view);
        marginlayoutparams.setMargins(marginlayoutparams.leftMargin, marginlayoutparams.topMargin, i, marginlayoutparams.bottomMargin);
        view.setLayoutParams(marginlayoutparams);
    }

    public static void adjustTopMargin(View view, int i)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = getMarginParams(view);
        marginlayoutparams.setMargins(marginlayoutparams.leftMargin, i, marginlayoutparams.rightMargin, marginlayoutparams.bottomMargin);
        view.setLayoutParams(marginlayoutparams);
    }

    private static android.view.ViewGroup.MarginLayoutParams getMarginParams(View view)
    {
        return (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
    }
}
