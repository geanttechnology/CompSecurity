// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.emilsjolander.components.StickyListHeaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

// Referenced classes of package com.emilsjolander.components.StickyListHeaders:
//            StickyListHeadersAdapter

public class StickyListHeadersListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{

    private boolean areHeadersSticky;
    private boolean clipToPaddingHasBeenSet;
    private Rect clippingRect;
    private boolean clippingToPadding;
    private Drawable divider;
    private int dividerHeight;
    private View header;
    private int headerBottomPosition;
    private boolean headerHasChanged;
    private int headerHeight;
    private View lastWatchedViewHeader;
    private long oldHeaderId;
    private android.widget.AbsListView.OnScrollListener scrollListener;
    private boolean setupDone;

    public StickyListHeadersListView(Context context)
    {
        super(context);
        headerHeight = -1;
        oldHeaderId = -1L;
        headerHasChanged = true;
        clippingRect = new Rect();
        setup();
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        headerHeight = -1;
        oldHeaderId = -1L;
        headerHasChanged = true;
        clippingRect = new Rect();
        context = getContext().obtainStyledAttributes(attributeset, R.styleable.StickyListHeadersListView);
        setAreHeadersSticky(context.getBoolean(0, true));
        context.recycle();
        setup();
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        headerHeight = -1;
        oldHeaderId = -1L;
        headerHasChanged = true;
        clippingRect = new Rect();
        context = getContext().obtainStyledAttributes(attributeset, R.styleable.StickyListHeadersListView);
        setAreHeadersSticky(context.getBoolean(0, true));
        context.recycle();
        setup();
    }

    private void setup()
    {
        if (!setupDone)
        {
            setupDone = true;
            super.setOnScrollListener(this);
            setDivider(getDivider());
            setDividerHeight(getDividerHeight());
            super.setDivider(null);
            super.setDividerHeight(0);
            setVerticalFadingEdgeEnabled(false);
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (header != null && areHeadersSticky)
        {
            if (headerHasChanged)
            {
                int i = android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x40000000);
                int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                header.measure(i, k);
                header.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), headerHeight);
                headerHasChanged = false;
            }
            int j = headerBottomPosition - headerHeight;
            clippingRect.left = getPaddingLeft();
            clippingRect.right = getWidth() - getPaddingRight();
            clippingRect.bottom = headerHeight + j;
            if (clippingToPadding)
            {
                clippingRect.top = getPaddingTop();
            } else
            {
                clippingRect.top = 0;
            }
            canvas.save();
            canvas.clipRect(clippingRect);
            canvas.translate(getPaddingLeft(), j);
            header.draw(canvas);
            canvas.restore();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        headerHeight = ((Bundle)parcelable).getInt("headerHeight");
        headerHasChanged = true;
        super.onRestoreInstanceState(((Bundle)parcelable).getParcelable("superInstanceState"));
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("headerHeight", headerHeight);
        bundle.putParcelable("superInstanceState", super.onSaveInstanceState());
        return bundle;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (scrollListener != null)
        {
            scrollListener.onScroll(abslistview, i, j, k);
        }
        while (getAdapter() == null || getAdapter().getCount() == 0 || !areHeadersSticky) 
        {
            return;
        }
        if (getChildCount() == 0) goto _L2; else goto _L1
_L1:
        if (lastWatchedViewHeader != null)
        {
            lastWatchedViewHeader.setVisibility(0);
        }
        abslistview = getChildAt(0);
        j = 1;
        while (j < getChildCount()) 
        {
label0:
            {
                Object obj;
                int l;
                if (clippingToPadding)
                {
                    k = Math.abs(abslistview.getTop() - getPaddingTop());
                } else
                {
                    k = Math.abs(abslistview.getTop());
                }
                if (clippingToPadding)
                {
                    l = Math.abs(getChildAt(j).getTop() - getPaddingTop() - headerHeight);
                } else
                {
                    l = Math.abs(getChildAt(j).getTop() - headerHeight);
                }
                if (((Boolean)abslistview.getTag()).booleanValue())
                {
                    obj = abslistview;
                    if (!((Boolean)getChildAt(j).getTag()).booleanValue())
                    {
                        break label0;
                    }
                    obj = abslistview;
                    if (l >= k)
                    {
                        break label0;
                    }
                }
                obj = getChildAt(j);
            }
            j++;
            abslistview = ((AbsListView) (obj));
        }
        if (!((Boolean)abslistview.getTag()).booleanValue()) goto _L4; else goto _L3
_L3:
        if (headerHeight < 0)
        {
            headerHeight = abslistview.findViewById(R.id.header_view).getHeight();
        }
        if (i == 0 && getChildAt(0).getTop() > 0 && !clippingToPadding)
        {
            headerBottomPosition = 0;
        } else
        if (clippingToPadding)
        {
            headerBottomPosition = Math.min(abslistview.getTop(), headerHeight + getPaddingTop());
            if (headerBottomPosition < getPaddingTop())
            {
                j = headerHeight + getPaddingTop();
            } else
            {
                j = headerBottomPosition;
            }
            headerBottomPosition = j;
        } else
        {
            headerBottomPosition = Math.min(abslistview.getTop(), headerHeight);
            if (headerBottomPosition < 0)
            {
                j = headerHeight;
            } else
            {
                j = headerBottomPosition;
            }
            headerBottomPosition = j;
        }
        lastWatchedViewHeader = abslistview.findViewById(R.id.header_view);
        k = headerBottomPosition;
        if (clippingToPadding)
        {
            j = headerHeight + getPaddingTop();
        } else
        {
            j = headerHeight;
        }
        if (k != j) goto _L6; else goto _L5
_L5:
        k = abslistview.getTop();
        if (clippingToPadding)
        {
            j = headerHeight + getPaddingTop();
        } else
        {
            j = headerHeight;
        }
        if (k >= j) goto _L6; else goto _L7
_L7:
        lastWatchedViewHeader.setVisibility(4);
_L2:
        j = i;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            j = i;
            if (!clippingToPadding)
            {
                j = i;
                if (getPaddingTop() > 0)
                {
                    j = i;
                    if (getChildAt(0).getTop() > 0)
                    {
                        j = i;
                        if (i > 0)
                        {
                            j = i - 1;
                        }
                    }
                }
            }
        }
        if (oldHeaderId != ((StickyListHeadersAdapter)getAdapter()).getHeaderId(j))
        {
            headerHasChanged = true;
            header = ((StickyListHeadersAdapter)getAdapter()).getHeaderView(j, header);
            header.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, headerHeight));
        }
        oldHeaderId = ((StickyListHeadersAdapter)getAdapter()).getHeaderId(j);
        return;
_L6:
        lastWatchedViewHeader.setVisibility(0);
        continue; /* Loop/switch isn't completed */
_L4:
        headerBottomPosition = headerHeight;
        if (clippingToPadding)
        {
            headerBottomPosition = headerBottomPosition + getPaddingTop();
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (scrollListener != null)
        {
            scrollListener.onScrollStateChanged(abslistview, i);
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (!clipToPaddingHasBeenSet)
        {
            clippingToPadding = true;
        }
        if (!(listadapter instanceof StickyListHeadersAdapter))
        {
            throw new IllegalArgumentException("Adapter must be a subclass of StickyListHeadersAdapter");
        } else
        {
            ((StickyListHeadersAdapter)listadapter).setDivider(divider);
            ((StickyListHeadersAdapter)listadapter).setDividerHeight(dividerHeight);
            super.setAdapter(listadapter);
            return;
        }
    }

    public void setAreHeadersSticky(boolean flag)
    {
        if (flag)
        {
            super.setVerticalFadingEdgeEnabled(false);
        }
        areHeadersSticky = flag;
    }

    public void setClipToPadding(boolean flag)
    {
        super.setClipToPadding(flag);
        clippingToPadding = flag;
        clipToPaddingHasBeenSet = true;
    }

    public void setDivider(Drawable drawable)
    {
        if (setupDone)
        {
            divider = drawable;
            if (getAdapter() != null)
            {
                ((StickyListHeadersAdapter)getAdapter()).setDivider(drawable);
            }
            return;
        } else
        {
            super.setDivider(drawable);
            return;
        }
    }

    public void setDividerHeight(int i)
    {
        if (setupDone)
        {
            dividerHeight = i;
            if (getAdapter() != null)
            {
                ((StickyListHeadersAdapter)getAdapter()).setDividerHeight(i);
            }
            return;
        } else
        {
            super.setDividerHeight(i);
            return;
        }
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        scrollListener = onscrolllistener;
    }

    public void setVerticalFadingEdgeEnabled(boolean flag)
    {
        if (areHeadersSticky)
        {
            super.setVerticalFadingEdgeEnabled(false);
            return;
        } else
        {
            super.setVerticalFadingEdgeEnabled(flag);
            return;
        }
    }
}
