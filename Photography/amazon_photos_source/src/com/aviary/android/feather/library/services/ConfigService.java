// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController

public class ConfigService extends BaseContextService
{

    Resources mResources;

    public ConfigService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        mResources = iaviarycontroller.getBaseContext().getResources();
    }

    public void dispose()
    {
    }

    public boolean getBoolean(int i)
    {
        return mResources.getBoolean(i);
    }

    public int getColor(int i)
    {
        return mResources.getColor(i);
    }

    public ColorStateList getColorStateList(int i)
    {
        return mResources.getColorStateList(i);
    }

    public int getDimensionPixelSize(int i)
    {
        return mResources.getDimensionPixelSize(i);
    }

    public int[] getIntArray(int i)
    {
        return mResources.getIntArray(i);
    }

    public int getInteger(int i)
    {
        return mResources.getInteger(i);
    }

    public Resources getResources()
    {
        return mResources;
    }

    public int[] getSizeArray(int i)
    {
        float f = mResources.getDisplayMetrics().density;
        int ai[] = getIntArray(i);
        if (ai != null)
        {
            for (i = 0; i < ai.length; i++)
            {
                ai[i] = (int)((float)ai[i] * f);
            }

        }
        return ai;
    }

    public String getString(int i)
    {
        return mResources.getString(i);
    }

    public String[] getStringArray(int i)
    {
        return mResources.getStringArray(i);
    }
}
