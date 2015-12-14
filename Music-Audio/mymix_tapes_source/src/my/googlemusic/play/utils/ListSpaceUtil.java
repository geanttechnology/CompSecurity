// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

public class ListSpaceUtil
{

    public ListSpaceUtil()
    {
    }

    public static View getSpace(Context context, int i)
    {
        RelativeLayout relativelayout = new RelativeLayout(context);
        relativelayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics())));
        return relativelayout;
    }
}
