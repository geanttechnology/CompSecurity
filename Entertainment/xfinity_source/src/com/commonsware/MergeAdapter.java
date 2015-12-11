// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.commonsware:
//            SackOfViewsAdapter

public class MergeAdapter extends BaseAdapter
    implements SectionIndexer
{
    private class CascadeDataSetObserver extends DataSetObserver
    {

        final MergeAdapter this$0;

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        public void onInvalidated()
        {
            notifyDataSetInvalidated();
        }

        private CascadeDataSetObserver()
        {
            this$0 = MergeAdapter.this;
            super();
        }

    }

    private static class EnabledSackAdapter extends SackOfViewsAdapter
    {

        public boolean areAllItemsEnabled()
        {
            return true;
        }

        public boolean isEnabled(int i)
        {
            return true;
        }

        public EnabledSackAdapter(List list)
        {
            super(list);
        }
    }


    private ArrayList pieces;

    public MergeAdapter()
    {
        pieces = new ArrayList();
    }

    public void addAdapter(ListAdapter listadapter)
    {
        pieces.add(listadapter);
        listadapter.registerDataSetObserver(new CascadeDataSetObserver());
    }

    public void addView(View view, boolean flag)
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(view);
        addViews(arraylist, flag);
    }

    public void addViews(List list, boolean flag)
    {
        if (flag)
        {
            addAdapter(new EnabledSackAdapter(list));
            return;
        } else
        {
            addAdapter(new SackOfViewsAdapter(list));
            return;
        }
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getCount()
    {
        int i = 0;
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            i += ((ListAdapter)iterator.next()).getCount();
        }

        return i;
    }

    public Object getItem(int i)
    {
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            ListAdapter listadapter = (ListAdapter)iterator.next();
            int j = listadapter.getCount();
            if (i < j)
            {
                return listadapter.getItem(i);
            }
            i -= j;
        }

        return null;
    }

    public long getItemId(int i)
    {
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            ListAdapter listadapter = (ListAdapter)iterator.next();
            int j = listadapter.getCount();
            if (i < j)
            {
                return listadapter.getItemId(i);
            }
            i -= j;
        }

        return -1L;
    }

    public int getItemViewType(int i)
    {
        boolean flag = false;
        byte byte0 = -1;
        Iterator iterator = pieces.iterator();
        int j = i;
        i = ((flag) ? 1 : 0);
        do
        {
            ListAdapter listadapter;
            int k;
label0:
            {
                k = byte0;
                if (iterator.hasNext())
                {
                    listadapter = (ListAdapter)iterator.next();
                    k = listadapter.getCount();
                    if (j >= k)
                    {
                        break label0;
                    }
                    k = i + listadapter.getItemViewType(j);
                }
                return k;
            }
            j -= k;
            i += listadapter.getViewTypeCount();
        } while (true);
    }

    public int getPositionForSection(int i)
    {
        boolean flag = false;
        Iterator iterator = pieces.iterator();
        int j = i;
        i = ((flag) ? 1 : 0);
        while (iterator.hasNext()) 
        {
            ListAdapter listadapter = (ListAdapter)iterator.next();
            int k = j;
            if (listadapter instanceof SectionIndexer)
            {
                Object aobj[] = ((SectionIndexer)listadapter).getSections();
                int l = 0;
                if (aobj != null)
                {
                    l = aobj.length;
                }
                if (j < l)
                {
                    return ((SectionIndexer)listadapter).getPositionForSection(j) + i;
                }
                k = j;
                if (aobj != null)
                {
                    k = j - l;
                }
            }
            i += listadapter.getCount();
            j = k;
        }
        return 0;
    }

    public int getSectionForPosition(int i)
    {
        boolean flag = false;
        int j = 0;
        Iterator iterator = pieces.iterator();
        do
        {
            ListAdapter listadapter;
            int i1;
label0:
            {
                int k = ((flag) ? 1 : 0);
                if (iterator.hasNext())
                {
                    listadapter = (ListAdapter)iterator.next();
                    i1 = listadapter.getCount();
                    if (i >= i1)
                    {
                        break label0;
                    }
                    k = ((flag) ? 1 : 0);
                    if (listadapter instanceof SectionIndexer)
                    {
                        k = ((SectionIndexer)listadapter).getSectionForPosition(i) + j;
                    }
                }
                return k;
            }
            int l = j;
            if (listadapter instanceof SectionIndexer)
            {
                Object aobj[] = ((SectionIndexer)listadapter).getSections();
                l = j;
                if (aobj != null)
                {
                    l = j + aobj.length;
                }
            }
            i -= i1;
            j = l;
        } while (true);
    }

    public Object[] getSections()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = pieces.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListAdapter listadapter = (ListAdapter)iterator.next();
            if (listadapter instanceof SectionIndexer)
            {
                Object aobj[] = ((SectionIndexer)listadapter).getSections();
                if (aobj != null)
                {
                    arraylist.add(((Object) (aobj)));
                }
            }
        } while (true);
        if (arraylist.size() == 0)
        {
            return null;
        } else
        {
            return arraylist.toArray(new Object[arraylist.size()]);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            ListAdapter listadapter = (ListAdapter)iterator.next();
            int j = listadapter.getCount();
            if (i < j)
            {
                return listadapter.getView(i, view, viewgroup);
            }
            i -= j;
        }

        return null;
    }

    public int getViewTypeCount()
    {
        int i = 0;
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            i += ((ListAdapter)iterator.next()).getViewTypeCount();
        }

        return Math.max(i, 1);
    }

    public boolean isEnabled(int i)
    {
        for (Iterator iterator = pieces.iterator(); iterator.hasNext();)
        {
            ListAdapter listadapter = (ListAdapter)iterator.next();
            int j = listadapter.getCount();
            if (i < j)
            {
                return listadapter.isEnabled(i);
            }
            i -= j;
        }

        return false;
    }
}
