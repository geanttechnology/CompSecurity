// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.emilsjolander.components.StickyListHeaders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

// Referenced classes of package com.emilsjolander.components.StickyListHeaders:
//            StickyListHeadersAdapter, WrapperView

public abstract class StickyListHeadersBaseAdapter extends BaseAdapter
    implements StickyListHeadersAdapter
{

    private Context context;
    private Drawable divider;
    private ArrayList dividerCache;
    private int dividerHeight;
    private ArrayList headerCache;
    private ArrayList wrapperCache;

    public StickyListHeadersBaseAdapter(Context context1)
    {
        headerCache = new ArrayList();
        dividerCache = new ArrayList();
        wrapperCache = new ArrayList();
        context = context1;
    }

    private View attachDividerToListItem(View view)
    {
        view.setId(R.id.list_item_view);
        Object obj = null;
        if (wrapperCache.size() > 0)
        {
            obj = (WrapperView)wrapperCache.remove(0);
        }
        WrapperView wrapperview = ((WrapperView) (obj));
        if (obj == null)
        {
            wrapperview = new WrapperView(context);
        }
        obj = null;
        if (dividerCache.size() > 0)
        {
            obj = (View)dividerCache.remove(0);
        }
        View view1 = ((View) (obj));
        if (obj == null)
        {
            view1 = new View(context);
            view1.setId(R.id.divider_view);
            view1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, dividerHeight));
        }
        view1.setBackgroundDrawable(divider);
        return wrapperview.wrapViews(new View[] {
            view1, view
        });
    }

    private View attachHeaderToListItem(View view, View view1)
    {
        view1.setId(R.id.list_item_view);
        WrapperView wrapperview = null;
        if (wrapperCache.size() > 0)
        {
            wrapperview = (WrapperView)wrapperCache.remove(0);
        }
        WrapperView wrapperview1 = wrapperview;
        if (wrapperview == null)
        {
            wrapperview1 = new WrapperView(context);
        }
        view.setClickable(true);
        view.setFocusable(false);
        return wrapperview1.wrapViews(new View[] {
            view, view1
        });
    }

    private View axtractHeaderAndListItemFromConvertView(View view)
    {
        if (view == null)
        {
            return null;
        }
        ViewGroup viewgroup = (ViewGroup)view;
        View view1 = viewgroup.findViewById(R.id.header_view);
        if (view1 != null)
        {
            view1.setVisibility(0);
            headerCache.add(view1);
        }
        view1 = viewgroup.findViewById(R.id.divider_view);
        if (view1 != null)
        {
            dividerCache.add(view1);
        }
        view1 = viewgroup.findViewById(R.id.list_item_view);
        viewgroup.removeAllViews();
        wrapperCache.add(new WrapperView(view));
        return view1;
    }

    private View getHeaderWithForPosition(int i)
    {
        View view = null;
        if (headerCache.size() > 0)
        {
            view = (View)headerCache.remove(0);
        }
        view = getHeaderView(i, view);
        view.setId(R.id.header_view);
        return view;
    }

    public Context getContext()
    {
        return context;
    }

    public abstract long getHeaderId(int i);

    public abstract View getHeaderView(int i, View view);

    protected abstract View getView(int i, View view);

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = getView(i, axtractHeaderAndListItemFromConvertView(view));
        if (i == 0 || getHeaderId(i) != getHeaderId(i - 1))
        {
            view = attachHeaderToListItem(getHeaderWithForPosition(i), view);
            view.setTag(Boolean.valueOf(true));
            return view;
        } else
        {
            view = attachDividerToListItem(view);
            view.setTag(Boolean.valueOf(false));
            return view;
        }
    }

    public void setDivider(Drawable drawable)
    {
        divider = drawable;
    }

    public void setDividerHeight(int i)
    {
        dividerHeight = i;
    }
}
