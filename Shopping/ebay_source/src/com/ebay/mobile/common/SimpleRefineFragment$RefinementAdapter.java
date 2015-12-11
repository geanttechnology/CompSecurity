// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.common:
//            SimpleRefineFragment

protected class defaultFilterByIndex extends android.support.v7.widget.aultFilterByIndex
    implements android.view.ntAdapter
{

    private static final int VIEW_TYPE_REFINEMENT = 1;
    private static final int VIEW_TYPE_TITLE = 0;
    protected int defaultFilterByIndex;
    protected int defaultSortByIndex;
    public final List refinements = new ArrayList();
    final SimpleRefineFragment this$0;

    private List getTitleIndexRanges()
    {
        ArrayList arraylist = new ArrayList();
        int j = -1;
        int l = refinements.size();
        for (int i = 0; i < l;)
        {
            int k = j;
            if (getItemViewType(i) == 0)
            {
                if (j != -1)
                {
                    arraylist.add(new Pair(Integer.valueOf(j), Integer.valueOf(i)));
                }
                k = i;
            }
            i++;
            j = k;
        }

        if (j != -1)
        {
            arraylist.add(new Pair(Integer.valueOf(j), Integer.valueOf(l + 1)));
        }
        return arraylist;
    }

    private void updateNewSelectedRefinement(getItemViewType getitemviewtype, int i)
    {
        Object obj1 = getTitleIndexRanges();
        Object obj2 = null;
        Object obj = null;
        int k = -1;
        Iterator iterator = ((List) (obj1)).iterator();
        byte byte0;
        do
        {
            byte0 = k;
            obj1 = obj2;
            if (!iterator.hasNext())
            {
                break;
            }
            obj1 = (Pair)iterator.next();
            if (((Integer)((Pair) (obj1)).first).intValue() >= i || i >= ((Integer)((Pair) (obj1)).second).intValue())
            {
                continue;
            }
            int l = Math.min(((Integer)((Pair) (obj1)).second).intValue(), refinements.size());
            int j = ((Integer)((Pair) (obj1)).first).intValue() + 1;
            do
            {
                byte0 = k;
                obj1 = obj;
                if (j >= l)
                {
                    break;
                }
                obj1 = (refinements)refinements.get(j);
                if (((refinements) (obj1)).ted())
                {
                    k = j;
                    obj = obj1;
                }
                j++;
            } while (true);
            break;
        } while (true);
        if (obj1 != null)
        {
            ((ted) (obj1)).ctionState(false);
            notifyItemChanged(byte0);
        }
        getitemviewtype.ctionState(true);
        notifyItemChanged(i);
    }

    protected void addFilterByRefinements(List list, int i)
    {
        defaultFilterByIndex = refinements.size() + i + 1;
        refinements.addAll(list);
        notifyDataSetChanged();
    }

    protected void addSortByRefinements(List list, int i)
    {
        refinements.addAll(list);
        defaultSortByIndex = i + 1;
        notifyDataSetChanged();
    }

    protected notifyDataSetChanged getCurrentRefinementInSectionThatContainsPosition(int i)
    {
        if (i != -1)
        {
            Iterator iterator = getTitleIndexRanges().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Pair pair = (Pair)iterator.next();
                if (((Integer)pair.first).intValue() < i && i < ((Integer)pair.second).intValue())
                {
                    int k = Math.min(((Integer)pair.second).intValue(), refinements.size());
                    int j = ((Integer)pair.first).intValue() + 1;
                    while (j < k) 
                    {
                        notifyDataSetChanged notifydatasetchanged = (refinements)refinements.get(j);
                        if (notifydatasetchanged.ted())
                        {
                            return notifydatasetchanged;
                        }
                        j++;
                    }
                }
            } while (true);
        }
        return null;
    }

    protected ted getDefaultFilterByRefinement()
    {
        if (defaultFilterByIndex != -1)
        {
            return (defaultFilterByIndex)refinements.get(defaultFilterByIndex);
        } else
        {
            return null;
        }
    }

    protected defaultFilterByIndex getDefaultSortByRefinement()
    {
        if (defaultSortByIndex != -1)
        {
            return (defaultSortByIndex)refinements.get(defaultSortByIndex);
        } else
        {
            return null;
        }
    }

    public int getItemCount()
    {
        return refinements.size();
    }

    public int getItemViewType(int i)
    {
        for (refinements refinements1 = (refinements)refinements.get(i); (refinements1 instanceof refinements) || !(refinements1 instanceof refinements);)
        {
            return 1;
        }

        return 0;
    }

    public void onBindViewHolder(android.support.v7.widget.inements inements, int i)
    {
        getItemViewType(i);
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 58;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        refinements refinements1 = (getItemViewType)refinements.get(i);
        ((refinements)inements).xtView.setText(refinements1.itle());
        return;
_L3:
        refinements refinements2 = (itle)refinements.get(i);
        inements = (er)inements;
        ((er) (inements)).textView.setText(refinements2.e());
        if (!refinements2.ed())
        {
            ((er) (inements)).itemView.setOnClickListener(null);
            ((er) (inements)).textView.setTextAppearance(getActivity(), 0x7f0a013f);
            ((er) (inements)).textView.setTextColor(getActivity().getResources().getColor(0x7f0d00e7));
            if (!refinements2.ltRefinement())
            {
                ((er) (inements)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
        } else
        {
            ((er) (inements)).itemView.setOnClickListener(this);
            if (refinements2.ted())
            {
                ((er) (inements)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201c3, 0);
                ((er) (inements)).textView.setTextAppearance(getActivity(), 0x7f0a0154);
                return;
            } else
            {
                ((er) (inements)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                ((er) (inements)).textView.setTextAppearance(getActivity(), 0x7f0a013f);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(View view)
    {
        int i = recyclerView.getChildLayoutPosition(view);
        if (i >= 0)
        {
            if (!(view = (er.textView)refinements.get(i)).ted())
            {
                updateNewSelectedRefinement(view, i);
                if (callback != null)
                {
                    callback.onRefinementSelected(view);
                    return;
                }
            }
        }
    }

    public android.support.v7.widget.onRefinementSelected onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (getItemViewType(i))
        {
        default:
            return null;

        case 0: // '\0'
            return new nit>(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030252, viewgroup, false));

        case 1: // '\001'
            return new er(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030251, viewgroup, false));
        }
    }

    protected void resetSelections()
    {
        Iterator iterator = refinements.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (refinements)iterator.next();
            if (obj instanceof refinements)
            {
                obj = (refinements)obj;
                ((refinements) (obj)).ctionState(((ctionState) (obj)).ltRefinement());
            }
        } while (true);
        notifyDataSetChanged();
    }

    protected void selectRefinement(notifyDataSetChanged notifydatasetchanged)
    {
        int j = refinements.size();
        int i = 0;
        do
        {
            if (i >= j || ((refinements)refinements.get(i)).ls(notifydatasetchanged))
            {
                if (i != j)
                {
                    updateNewSelectedRefinement(notifydatasetchanged, i);
                }
                return;
            }
            i++;
        } while (true);
    }

    protected ck()
    {
        this$0 = SimpleRefineFragment.this;
        super();
        defaultSortByIndex = -1;
        defaultFilterByIndex = -1;
    }
}
