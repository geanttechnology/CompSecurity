// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class PlacementSize extends Enum
{

    private static final PlacementSize $VALUES[];
    public static final PlacementSize Banner300x250;
    public static final PlacementSize Banner320x53;
    public static final PlacementSize Banner468x60;
    public static final PlacementSize Banner768x90;
    public static final PlacementSize Fullscreen;
    private int height;
    private int width;

    private PlacementSize(String s, int i, int j, int k)
    {
        super(s, i);
        width = j;
        height = k;
    }

    private int convertDeviceIndependendPixelsToPixels(Context context, int i)
    {
        context = context.getResources().getDisplayMetrics();
        return (int)((double)((float)i * ((DisplayMetrics) (context)).density) + 0.5D);
    }

    public static PlacementSize valueOf(String s)
    {
        return (PlacementSize)Enum.valueOf(com/intentsoftware/addapptr/PlacementSize, s);
    }

    public static PlacementSize[] values()
    {
        return (PlacementSize[])$VALUES.clone();
    }

    public int getHeight()
    {
        return height;
    }

    int getHeightInPixels(Context context)
    {
        return convertDeviceIndependendPixelsToPixels(context, height);
    }

    public int getWidth()
    {
        return width;
    }

    int getWidthInPixels(Context context)
    {
        return convertDeviceIndependendPixelsToPixels(context, width);
    }

    static 
    {
        Banner320x53 = new PlacementSize("Banner320x53", 0, 320, 53);
        Banner768x90 = new PlacementSize("Banner768x90", 1, 768, 90);
        Banner300x250 = new PlacementSize("Banner300x250", 2, 300, 250);
        Fullscreen = new PlacementSize("Fullscreen", 3, -1, -1);
        Banner468x60 = new PlacementSize("Banner468x60", 4, 468, 60);
        $VALUES = (new PlacementSize[] {
            Banner320x53, Banner768x90, Banner300x250, Fullscreen, Banner468x60
        });
    }
}
