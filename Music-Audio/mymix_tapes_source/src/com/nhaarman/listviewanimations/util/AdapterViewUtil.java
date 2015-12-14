// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.util;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AdapterViewUtil
{

    public AdapterViewUtil()
    {
    }

    public static int getPositionForView(AdapterView adapterview, View view)
    {
        int j = adapterview.getPositionForView(view);
        int i = j;
        if (adapterview instanceof ListView)
        {
            i = j - ((ListView)adapterview).getHeaderViewsCount();
        }
        return i;
    }
}
