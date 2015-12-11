// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RecyclerPagerAdapter extends PagerAdapter
{
    private static class InternalItem
    {

        public Object instantiatedObject;
        public float pageWidth;
        public int position;
        public int viewType;

        private InternalItem()
        {
        }

    }


    private static final int TAG_KEY;
    final List destroyedItems = new ArrayList();
    final List instantiatedItems = new ArrayList();

    public RecyclerPagerAdapter()
    {
    }

    private void clearItems()
    {
        instantiatedItems.clear();
        destroyedItems.clear();
    }

    private static InternalItem getInternalItem(View view)
    {
        return (InternalItem)view.getTag(TAG_KEY);
    }

    private SparseArrayCompat removeDestroyedItemsViews(ViewGroup viewgroup)
    {
        ArrayList arraylist = new ArrayList();
        SparseArrayCompat sparsearraycompat = new SparseArrayCompat();
        for (int i = 0; i < viewgroup.getChildCount(); i++)
        {
            View view = viewgroup.getChildAt(i);
            InternalItem internalitem = getInternalItem(view);
            if (destroyedItems.indexOf(internalitem) < 0)
            {
                continue;
            }
            arraylist.add(view);
            List list = (List)sparsearraycompat.get(internalitem.viewType);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                sparsearraycompat.put(internalitem.viewType, obj);
            }
            ((List) (obj)).add(view);
        }

        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); viewgroup.removeView((View)iterator.next())) { }
        return sparsearraycompat;
    }

    public final void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        destroyedItems.add((InternalItem)obj);
    }

    public final void finishUpdate(ViewGroup viewgroup)
    {
        SparseArrayCompat sparsearraycompat = removeDestroyedItemsViews(viewgroup);
        Iterator iterator = instantiatedItems.iterator();
        while (iterator.hasNext()) 
        {
            InternalItem internalitem = (InternalItem)iterator.next();
            Object obj = null;
            if (sparsearraycompat.size() > 0)
            {
                obj = (List)sparsearraycompat.get(internalitem.viewType);
            }
            if (obj != null && ((List) (obj)).size() > 0)
            {
                obj = (View)((List) (obj)).remove(0);
                viewgroup.addView(((View) (obj)));
                getView(internalitem.position, ((View) (obj)), viewgroup);
            } else
            {
                obj = getView(internalitem.position, null, viewgroup);
                viewgroup.addView(((View) (obj)));
            }
            ((View) (obj)).setTag(TAG_KEY, internalitem);
        }
        clearItems();
    }

    public abstract Object getItem(int i);

    public final int getItemPosition(Object obj)
    {
        obj = (InternalItem)obj;
        if (((InternalItem) (obj)).instantiatedObject.equals(getItem(((InternalItem) (obj)).position)) && ((InternalItem) (obj)).viewType == getItemViewType(((InternalItem) (obj)).position) && ((InternalItem) (obj)).pageWidth == getPageWidth(((InternalItem) (obj)).position))
        {
            return ((InternalItem) (obj)).position;
        } else
        {
            return -2;
        }
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public abstract View getView(int i, View view, ViewGroup viewgroup);

    public final Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = new InternalItem();
        viewgroup.instantiatedObject = getItem(i);
        viewgroup.position = i;
        viewgroup.viewType = getItemViewType(i);
        viewgroup.pageWidth = getPageWidth(i);
        instantiatedItems.add(viewgroup);
        return viewgroup;
    }

    public final boolean isViewFromObject(View view, Object obj)
    {
        return getInternalItem(view) == obj;
    }

    public final void startUpdate(ViewGroup viewgroup)
    {
        clearItems();
    }

    static 
    {
        TAG_KEY = com.groupon.commonlibs.R.id.RECYCLER_PAGER_ADAPTER_TAG_KEY;
    }
}
