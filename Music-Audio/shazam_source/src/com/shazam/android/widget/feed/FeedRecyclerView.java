// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.feed;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.o;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.shazam.android.widget.feed:
//            o

public class FeedRecyclerView extends RecyclerView
{

    private android.support.v7.widget.RecyclerView.l s;

    public FeedRecyclerView(Context context)
    {
        super(context);
        l();
    }

    public FeedRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        l();
    }

    public FeedRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        l();
    }

    private boolean a(MotionEvent motionevent)
    {
        return getFirstVisiblePosition() <= 0 && motionevent.getY() < (float)getNewsTop();
    }

    private int getNewsTop()
    {
        View view = getChildAt(0);
        if (view != null)
        {
            return view.getTop();
        } else
        {
            return getPaddingTop();
        }
    }

    private void l()
    {
        setSaveEnabled(false);
        Object obj = getResources();
        int i = ((Resources) (obj)).getInteger(0x7f0b0002);
        int j = Math.max(0, getResources().getDimensionPixelOffset(0x7f0a0023) - getResources().getDimensionPixelOffset(0x7f0a0025));
        setLayoutManager(new o(i));
        setHasFixedSize(true);
        setItemAnimator(null);
        setClipToPadding(false);
        setPadding(j, getPaddingTop(), j, getPaddingBottom());
        android.graphics.drawable.Drawable drawable = ((Resources) (obj)).getDrawable(0x7f02007d);
        android.graphics.drawable.Drawable drawable1 = ((Resources) (obj)).getDrawable(0x7f02007c);
        obj = new com.shazam.android.widget.feed.o(((Resources) (obj)).getDrawable(0x7f02007b), drawable, drawable1, ((Resources) (obj)).getDrawable(0x7f02007a), ((Resources) (obj)).getDrawable(0x7f0200d5));
        if (super.e != null)
        {
            super.e.a("Cannot add item decoration during a scroll  or layout");
        }
        if (super.f.isEmpty())
        {
            setWillNotDraw(false);
        }
        super.f.add(obj);
        i();
        requestLayout();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return !a(motionevent) && super.dispatchTouchEvent(motionevent);
    }

    public o getFeedLayoutManager()
    {
        return (o)super.getLayoutManager();
    }

    public int getFirstVisiblePosition()
    {
        o o1 = getFeedLayoutManager();
        return o1.a(new int[((StaggeredGridLayoutManager) (o1)).a])[0];
    }

    public android.support.v7.widget.RecyclerView.i getLayoutManager()
    {
        return super.getLayoutManager();
    }

    public android.support.v7.widget.RecyclerView.l getOnScrollListener()
    {
        return s;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return !a(motionevent) && super.onTouchEvent(motionevent);
    }

    public void setOnScrollListener(android.support.v7.widget.RecyclerView.l l1)
    {
        super.setOnScrollListener(l1);
        s = l1;
    }
}
