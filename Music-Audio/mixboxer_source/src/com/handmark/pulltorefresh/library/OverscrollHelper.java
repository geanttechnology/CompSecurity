// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.view.View;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase

public final class OverscrollHelper
{

    static final float DEFAULT_OVERSCROLL_SCALE = 1F;
    static final String LOG_TAG = "OverscrollHelper";

    public OverscrollHelper()
    {
    }

    static boolean isAndroidOverScrollEnabled(View view)
    {
        return view.getOverScrollMode() != 2;
    }

    public static void overScrollBy(PullToRefreshBase pulltorefreshbase, int i, int j, int k, int l, int i1, int j1, float f, 
            boolean flag)
    {
        _cls1..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[pulltorefreshbase.getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 211;
           goto _L1 _L2
_L1:
        int k1;
        int l1;
        int i2;
        k1 = pulltorefreshbase.getScrollY();
        i2 = k;
        l1 = l;
_L13:
        if (!pulltorefreshbase.isPullToRefreshOverScrollEnabled() || pulltorefreshbase.isRefreshing()) goto _L4; else goto _L3
_L3:
        PullToRefreshBase.Mode mode = pulltorefreshbase.getMode();
        if (!mode.permitsPullToRefresh() || flag || i2 == 0) goto _L6; else goto _L5
_L5:
        l1 += i2;
        (new StringBuilder()).append("OverScroll. DeltaX: ").append(i).append(", ScrollX: ").append(j).append(", DeltaY: ").append(k).append(", ScrollY: ").append(l).append(", NewY: ").append(l1).append(", ScrollRange: ").append(i1).append(", CurrentScroll: ").append(k1).toString();
        if (l1 >= 0 - j1) goto _L8; else goto _L7
_L7:
        if (mode.showHeaderLoadingLayout())
        {
            if (k1 == 0)
            {
                pulltorefreshbase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
            }
            pulltorefreshbase.setHeaderScroll((int)((float)(l1 + k1) * f));
        }
_L4:
        return;
_L2:
        k1 = pulltorefreshbase.getScrollX();
        i2 = i;
        l1 = j;
        continue; /* Loop/switch isn't completed */
_L8:
        if (l1 <= i1 + j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!mode.showFooterLoadingLayout()) goto _L4; else goto _L9
_L9:
        if (k1 == 0)
        {
            pulltorefreshbase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
        }
        pulltorefreshbase.setHeaderScroll((int)((float)((l1 + k1) - i1) * f));
        return;
        if (Math.abs(l1) > j1 && Math.abs(l1 - i1) > j1) goto _L4; else goto _L10
_L10:
        pulltorefreshbase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
        return;
_L6:
        if (!flag || PullToRefreshBase.State.OVERSCROLLING != pulltorefreshbase.getState()) goto _L4; else goto _L11
_L11:
        pulltorefreshbase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static void overScrollBy(PullToRefreshBase pulltorefreshbase, int i, int j, int k, int l, int i1, boolean flag)
    {
        overScrollBy(pulltorefreshbase, i, j, k, l, i1, 0, 1.0F, flag);
    }

    public static void overScrollBy(PullToRefreshBase pulltorefreshbase, int i, int j, int k, int l, boolean flag)
    {
        overScrollBy(pulltorefreshbase, i, j, k, l, 0, flag);
    }

    private class _cls1
    {

        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[];

        static 
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[PullToRefreshBase.Orientation.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
