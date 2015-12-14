// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations.util;

import android.view.View;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;

public class AdapterViewUtil
{

    public AdapterViewUtil()
    {
    }

    public static int getPositionForView(AdapterView adapterview, View view)
    {
        int j = adapterview.getPositionForView(view);
        int i = j;
        if (adapterview instanceof HListView)
        {
            i = j - ((HListView)adapterview).getHeaderViewsCount();
        }
        return i;
    }
}
