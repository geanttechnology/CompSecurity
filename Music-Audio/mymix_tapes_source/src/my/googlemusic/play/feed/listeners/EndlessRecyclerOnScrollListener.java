// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.feed.listeners;

import android.support.v7.widget.RecyclerView;
import java.io.PrintStream;
import my.googlemusic.play.adapters.feed.HeaderLayoutManagerFixed;

public abstract class EndlessRecyclerOnScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
{

    public static String TAG = my/googlemusic/play/feed/listeners/EndlessRecyclerOnScrollListener.getSimpleName();
    private int current_page;
    int firstVisibleItem;
    private boolean loading;
    private HeaderLayoutManagerFixed mLinearLayoutManager;
    private int previousTotal;
    int totalItemCount;
    int visibleItemCount;
    private int visibleThreshold;

    public EndlessRecyclerOnScrollListener(HeaderLayoutManagerFixed headerlayoutmanagerfixed)
    {
        previousTotal = 0;
        loading = true;
        visibleThreshold = 1;
        current_page = 1;
        mLinearLayoutManager = headerlayoutmanagerfixed;
    }

    public abstract void onLoadMore(int i);

    public abstract void onScroll(int i, int j);

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        onScroll(i, j);
        System.out.println(j);
        visibleItemCount = recyclerview.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        if (loading && totalItemCount >= previousTotal)
        {
            loading = false;
            previousTotal = totalItemCount;
        }
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold)
        {
            current_page = current_page + 1;
            onLoadMore(current_page);
            loading = true;
        }
    }

}
