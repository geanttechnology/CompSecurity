// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.widget.AbsListView;

// Referenced classes of package co.vine.android.player:
//            HasVideoPlayerAdapter

public class OnVideoListScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private final HasVideoPlayerAdapter adapter;

    public OnVideoListScrollListener(HasVideoPlayerAdapter hasvideoplayeradapter)
    {
        adapter = hasvideoplayeradapter;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        adapter.playCurrentPosition();
        this;
        JVM INSTR monitorexit ;
        return;
        abslistview;
        throw abslistview;
    }
}
