// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

// Referenced classes of package com.idunnololz.widgets:
//            a

public class AnimatedExpandableListView extends ExpandableListView
{

    private static final String a = com/idunnololz/widgets/a.getSimpleName();
    private a b;

    public AnimatedExpandableListView(Context context)
    {
        super(context);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static int a(AnimatedExpandableListView animatedexpandablelistview)
    {
        return animatedexpandablelistview.getAnimationDuration();
    }

    private int getAnimationDuration()
    {
        return 300;
    }

    public boolean a(int i)
    {
        int j = getFlatListPosition(getPackedPositionForGroup(i));
        if (j != -1)
        {
            j -= getFirstVisiblePosition();
            if (j < getChildCount())
            {
                View view = getChildAt(j);
                j = getTop();
                if (view.getBottom() + j >= getBottom() - getPaddingBottom())
                {
                    b.e(i);
                    return expandGroup(i);
                }
            }
        }
        com.idunnololz.widgets.a.a(b, i, 0);
        return expandGroup(i);
    }

    public boolean b(int i)
    {
        int j = getFlatListPosition(getPackedPositionForGroup(i));
        if (j != -1)
        {
            j -= getFirstVisiblePosition();
            if (j >= 0 && j < getChildCount())
            {
                View view = getChildAt(j);
                j = getTop();
                if (view.getBottom() + j >= getBottom() - getPaddingBottom())
                {
                    return collapseGroup(i);
                }
            } else
            {
                return collapseGroup(i);
            }
        }
        long l = getExpandableListPosition(getFirstVisiblePosition());
        j = getPackedPositionChild(l);
        int k = getPackedPositionGroup(l);
        if (j == -1 || k != i)
        {
            j = 0;
        }
        com.idunnololz.widgets.a.b(b, i, j);
        b.notifyDataSetChanged();
        return isGroupExpanded(i);
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        super.setAdapter(expandablelistadapter);
        if (expandablelistadapter instanceof a)
        {
            b = (a)expandablelistadapter;
            com.idunnololz.widgets.a.a(b, this);
            return;
        } else
        {
            throw new ClassCastException((new StringBuilder()).append(expandablelistadapter.toString()).append(" must implement AnimatedExpandableListAdapter").toString());
        }
    }

}
