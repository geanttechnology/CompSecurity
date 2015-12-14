// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import android.view.View;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeDismissListViewTouchListener

protected class view
    implements Comparable
{

    public final int position;
    final SwipeDismissListViewTouchListener this$0;
    public final View view;

    public int compareTo(view view1)
    {
        return view1.position - position;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (compareTo)obj;
            if (position != ((position) (obj)).position)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return position + 31;
    }

    public (int i, View view1)
    {
        this$0 = SwipeDismissListViewTouchListener.this;
        super();
        position = i;
        view = view1;
    }
}
