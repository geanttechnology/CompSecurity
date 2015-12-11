// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

public class loading
    implements android.widget.lessScrollListener
{

    private int currentPage;
    private boolean loading;
    private int previousTotal;
    final NewsfeedFragment this$0;
    private int visibleThreshold;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (canScroll)
        {
            if (loading && k > previousTotal)
            {
                loading = false;
                previousTotal = k;
                currentPage = currentPage + 1;
                MixerBoxUtils.logMsg((new StringBuilder()).append("current page = ").append(currentPage).toString());
            }
            if (!endList && !loading && i + j == k && k - j <= visibleThreshold + i)
            {
                llLoading.setVisibility(0);
                (new visibleThreshold(NewsfeedFragment.this, null)).(new Integer[] {
                    Integer.valueOf(currentPage), Integer.valueOf(k), Integer.valueOf(j)
                });
                loading = true;
                return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }


/*
    static int access$002( , int i)
    {
        .currentPage = i;
        return i;
    }

*/


/*
    static int access$102(currentPage currentpage, int i)
    {
        currentpage.previousTotal = i;
        return i;
    }

*/


/*
    static boolean access$202(previousTotal previoustotal, boolean flag)
    {
        previoustotal.loading = flag;
        return flag;
    }

*/

    public loading()
    {
        this$0 = NewsfeedFragment.this;
        super();
        visibleThreshold = 500;
        currentPage = -1;
        previousTotal = 0;
        loading = true;
    }
}
