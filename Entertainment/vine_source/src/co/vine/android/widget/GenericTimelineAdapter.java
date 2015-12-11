// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import co.vine.android.BaseTimelineFragment;
import co.vine.android.LikeCache;
import co.vine.android.RevineCache;
import co.vine.android.ViewOffsetResolver;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.widget:
//            GenericVideoAdapter

public abstract class GenericTimelineAdapter extends GenericVideoAdapter
{

    protected final ListView mListView;
    protected final BaseTimelineFragment mTimelineFragment;

    public GenericTimelineAdapter(Activity activity, ListView listview, LikeCache likecache, RevineCache revinecache, BaseTimelineFragment basetimelinefragment, String s)
    {
        super(activity, likecache, revinecache, basetimelinefragment, basetimelinefragment, s);
        mListView = listview;
        mListView.setDivider(null);
        mListView.setOnScrollListener(basetimelinefragment);
        mTimelineFragment = basetimelinefragment;
    }

    public View getViewAtPosition(int i)
    {
        ListView listview = mListView;
        int j = 0;
        if (mViewOffsetResolver != null)
        {
            j = mViewOffsetResolver.getOffset(this);
        }
        int k = listview.getHeaderViewsCount();
        j = listview.getFirstVisiblePosition() - k - j;
        k = i - j;
        if (k < 0 || k >= listview.getChildCount())
        {
            if (SLog.sLogsOn)
            {
                SLog.w("Unable to get view for desired position, because it's not being displayed on screen: {} {} {} {}.", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(listview.getChildCount())
                });
            }
            return null;
        }
        if (SLog.sLogsOn)
        {
            SLog.d("Get view for desired position: {} {} {} {}.", new Object[] {
                Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(listview.getChildCount())
            });
        }
        return listview.getChildAt(k);
    }
}
