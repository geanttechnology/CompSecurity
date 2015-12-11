// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleRefineFragment extends BaseFragment
    implements android.view.View.OnClickListener
{
    protected static abstract class RecyclerModel
    {

        public boolean equals(Object obj)
        {
            if (!(obj instanceof RecyclerModel))
            {
                return false;
            } else
            {
                return ((RecyclerModel)obj).getTitle().equals(getTitle());
            }
        }

        public abstract String getTitle();

        public int hashCode()
        {
            return getTitle().hashCode();
        }

        protected RecyclerModel()
        {
        }
    }

    private static class RefineGroup extends RecyclerModel
    {

        public final int refinementCount;
        private final String title;

        public String getTitle()
        {
            return title;
        }

        private RefineGroup(String s, int i)
        {
            title = s;
            refinementCount = i;
        }

    }

    public static abstract class Refinement extends RecyclerModel
    {

        private boolean isEnabled;
        private boolean isSelected;
        private String titleWithCount;
        private final String titleWithoutCount;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof Refinement))
            {
                return false;
            } else
            {
                return TextUtils.equals(((Refinement)obj).getStringIdentifier(), getStringIdentifier());
            }
        }

        public abstract String getStringIdentifier();

        public String getTitle()
        {
            return titleWithCount;
        }

        public int hashCode()
        {
            String s = getStringIdentifier();
            if (s == null)
            {
                return super.hashCode();
            } else
            {
                return s.hashCode();
            }
        }

        public abstract boolean isDefaultRefinement();

        public boolean isEnabled()
        {
            return isEnabled;
        }

        protected boolean isSelected()
        {
            return isSelected;
        }

        protected final void setSelectionState(boolean flag)
        {
            isSelected = flag;
        }

        public void updateTitleWithCount(int i)
        {
            titleWithCount = (new StringBuilder()).append(titleWithoutCount).append(" (").append(i).append(")").toString();
            boolean flag;
            if (i != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isEnabled = flag;
        }

        public Refinement(String s)
        {
            isEnabled = true;
            isSelected = false;
            titleWithoutCount = s;
            titleWithCount = s;
        }
    }

    protected class RefinementAdapter extends android.support.v7.widget.RecyclerView.Adapter
        implements android.view.View.OnClickListener
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

        private void updateNewSelectedRefinement(Refinement refinement, int i)
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
                    obj1 = (Refinement)refinements.get(j);
                    if (((Refinement) (obj1)).isSelected())
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
                ((Refinement) (obj1)).setSelectionState(false);
                notifyItemChanged(byte0);
            }
            refinement.setSelectionState(true);
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

        protected Refinement getCurrentRefinementInSectionThatContainsPosition(int i)
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
                            Refinement refinement = (Refinement)refinements.get(j);
                            if (refinement.isSelected())
                            {
                                return refinement;
                            }
                            j++;
                        }
                    }
                } while (true);
            }
            return null;
        }

        protected Refinement getDefaultFilterByRefinement()
        {
            if (defaultFilterByIndex != -1)
            {
                return (Refinement)refinements.get(defaultFilterByIndex);
            } else
            {
                return null;
            }
        }

        protected Refinement getDefaultSortByRefinement()
        {
            if (defaultSortByIndex != -1)
            {
                return (Refinement)refinements.get(defaultSortByIndex);
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
            for (RecyclerModel recyclermodel = (RecyclerModel)refinements.get(i); (recyclermodel instanceof Refinement) || !(recyclermodel instanceof RefineGroup);)
            {
                return 1;
            }

            return 0;
        }

        public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
        {
            getItemViewType(i);
            JVM INSTR tableswitch 0 1: default 28
        //                       0 29
        //                       1 58;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            RecyclerModel recyclermodel = (RecyclerModel)refinements.get(i);
            ((TitleViewHolder)viewholder).textView.setText(recyclermodel.getTitle());
            return;
_L3:
            Refinement refinement = (Refinement)refinements.get(i);
            viewholder = (RefinementViewHolder)viewholder;
            ((RefinementViewHolder) (viewholder)).textView.setText(refinement.getTitle());
            if (!refinement.isEnabled())
            {
                ((RefinementViewHolder) (viewholder)).itemView.setOnClickListener(null);
                ((RefinementViewHolder) (viewholder)).textView.setTextAppearance(getActivity(), 0x7f0a013f);
                ((RefinementViewHolder) (viewholder)).textView.setTextColor(getActivity().getResources().getColor(0x7f0d00e7));
                if (!refinement.isDefaultRefinement())
                {
                    ((RefinementViewHolder) (viewholder)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    return;
                }
            } else
            {
                ((RefinementViewHolder) (viewholder)).itemView.setOnClickListener(this);
                if (refinement.isSelected())
                {
                    ((RefinementViewHolder) (viewholder)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201c3, 0);
                    ((RefinementViewHolder) (viewholder)).textView.setTextAppearance(getActivity(), 0x7f0a0154);
                    return;
                } else
                {
                    ((RefinementViewHolder) (viewholder)).textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((RefinementViewHolder) (viewholder)).textView.setTextAppearance(getActivity(), 0x7f0a013f);
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
                if (!(view = (Refinement)refinements.get(i)).isSelected())
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

        public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
        {
            switch (getItemViewType(i))
            {
            default:
                return null;

            case 0: // '\0'
                return new TitleViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030252, viewgroup, false));

            case 1: // '\001'
                return new RefinementViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030251, viewgroup, false));
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
                Object obj = (RecyclerModel)iterator.next();
                if (obj instanceof Refinement)
                {
                    obj = (Refinement)obj;
                    ((Refinement) (obj)).setSelectionState(((Refinement) (obj)).isDefaultRefinement());
                }
            } while (true);
            notifyDataSetChanged();
        }

        protected void selectRefinement(Refinement refinement)
        {
            int j = refinements.size();
            int i = 0;
            do
            {
                if (i >= j || ((RecyclerModel)refinements.get(i)).equals(refinement))
                {
                    if (i != j)
                    {
                        updateNewSelectedRefinement(refinement, i);
                    }
                    return;
                }
                i++;
            } while (true);
        }

        protected RefinementAdapter()
        {
            this$0 = SimpleRefineFragment.this;
            super();
            defaultSortByIndex = -1;
            defaultFilterByIndex = -1;
        }
    }

    protected static class RefinementItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
    {

        protected final Drawable divider;

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
        {
            int j = recyclerview.getWidth();
            int k = recyclerview.getChildCount();
            for (int i = 0; i < k; i++)
            {
                state = recyclerview.getChildAt(i);
                android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
                int l = state.getBottom() + layoutparams.bottomMargin;
                int i1 = divider.getIntrinsicHeight();
                divider.setBounds(0, l, j, l + i1);
                divider.draw(canvas);
            }

        }

        public RefinementItemDecoration(Context context)
        {
            context = context.getResources();
            ShapeDrawable shapedrawable = new ShapeDrawable(new RectShape());
            shapedrawable.getPaint().setColor(context.getColor(0x7f0d00ec));
            shapedrawable.setIntrinsicHeight((int)TypedValue.applyDimension(1, 1.0F, context.getDisplayMetrics()));
            divider = shapedrawable;
        }
    }

    private static class RefinementViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        protected final TextView textView;

        public RefinementViewHolder(View view)
        {
            super(view);
            textView = (TextView)view.findViewById(0x7f1001aa);
        }
    }

    public static interface SimpleRefineCallback
    {

        public abstract List getFilterByRefinements();

        public abstract List getSortByRefinements();

        public abstract void onDonePressed();

        public abstract void onRefinementSelected(Refinement refinement);

        public abstract void onResetPressed(Refinement refinement, Refinement refinement1);
    }

    private static class TitleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        protected final TextView textView;

        public TitleViewHolder(View view)
        {
            super(view);
            textView = (TextView)view;
        }
    }


    protected static final String STATE_CURRENT_FILTER_BY_TITLE = "currentFilterTitle";
    protected static final String STATE_CURRENT_SORT_BY_TITLE = "currentSortTitle";
    private RefinementAdapter adapter;
    protected SimpleRefineCallback callback;
    protected String filterById;
    protected RecyclerView recyclerView;
    protected String sortById;

    public SimpleRefineFragment()
    {
        callback = null;
        sortById = null;
        filterById = null;
    }

    public void forceReloadData()
    {
        populateAdapter();
    }

    public Refinement getCurrentFilterByRefinement()
    {
        if (adapter != null)
        {
            return adapter.getCurrentRefinementInSectionThatContainsPosition(adapter.defaultFilterByIndex);
        } else
        {
            return null;
        }
    }

    public Refinement getCurrentSortByRefinement()
    {
        if (adapter != null)
        {
            return adapter.getCurrentRefinementInSectionThatContainsPosition(adapter.defaultSortByIndex);
        } else
        {
            return null;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131757045 2131757047: default 32
    //                   2131757045 33
    //                   2131757046 32
    //                   2131757047 50;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L2:
        if (callback != null)
        {
            callback.onDonePressed();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        adapter.resetSelections();
        view = adapter.getDefaultSortByRefinement();
        Refinement refinement = adapter.getDefaultFilterByRefinement();
        if (callback != null)
        {
            callback.onResetPressed(view, refinement);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030250, viewgroup, false);
        layoutinflater.findViewById(0x7f1007f5).setOnClickListener(this);
        layoutinflater.findViewById(0x7f1007f7).setOnClickListener(this);
        layoutinflater.setOnClickListener(this);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f1007f6);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RefinementItemDecoration(getActivity()));
        adapter = new RefinementAdapter();
        recyclerView.setAdapter(adapter);
        if (bundle != null)
        {
            sortById = bundle.getString("currentSortTitle");
            filterById = bundle.getString("currentFilterTitle");
        }
        return layoutinflater;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Refinement refinement = getCurrentSortByRefinement();
        if (refinement != null)
        {
            bundle.putString("currentSortTitle", refinement.getStringIdentifier());
        }
        refinement = getCurrentFilterByRefinement();
        if (refinement != null)
        {
            bundle.putString("currentFilterTitle", refinement.getStringIdentifier());
        }
    }

    protected void populateAdapter()
    {
        Activity activity = getActivity();
        if (adapter != null && callback != null && activity != null)
        {
            adapter.refinements.clear();
            List list = callback.getSortByRefinements();
            if (list != null && !list.isEmpty())
            {
                int k1 = list.size();
                int k = -1;
                int i = 0;
                while (i < k1) 
                {
                    Refinement refinement = (Refinement)list.get(i);
                    int i1;
                    if (refinement.isDefaultRefinement())
                    {
                        if (sortById == null || sortById.equals(refinement.getStringIdentifier()))
                        {
                            refinement.setSelectionState(true);
                        }
                        i1 = i;
                    } else
                    {
                        i1 = k;
                        if (sortById != null)
                        {
                            i1 = k;
                            if (sortById.equals(refinement.getStringIdentifier()))
                            {
                                refinement.setSelectionState(true);
                                i1 = k;
                            }
                        }
                    }
                    i++;
                    k = i1;
                }
                RefineGroup refinegroup = new RefineGroup(activity.getString(0x7f0708ee), list.size());
                ArrayList arraylist1 = new ArrayList();
                arraylist1.add(refinegroup);
                arraylist1.addAll(list);
                adapter.addSortByRefinements(arraylist1, k);
            }
            list = callback.getFilterByRefinements();
            if (list != null && !list.isEmpty())
            {
                int l1 = list.size();
                int l = -1;
                int j = 0;
                while (j < l1) 
                {
                    Refinement refinement1 = (Refinement)list.get(j);
                    int j1;
                    if (refinement1.isDefaultRefinement())
                    {
                        if (filterById == null || filterById.equals(refinement1.getStringIdentifier()))
                        {
                            refinement1.setSelectionState(true);
                        }
                        j1 = j;
                    } else
                    {
                        j1 = l;
                        if (filterById != null)
                        {
                            j1 = l;
                            if (filterById.equals(refinement1.getStringIdentifier()))
                            {
                                refinement1.setSelectionState(true);
                                j1 = l;
                            }
                        }
                    }
                    j++;
                    l = j1;
                }
                ArrayList arraylist = new ArrayList();
                arraylist.add(new RefineGroup(activity.getString(0x7f0708eb), list.size()));
                arraylist.addAll(list);
                sortById = null;
                filterById = null;
                adapter.addFilterByRefinements(arraylist, l);
            }
        }
    }

    public void setCurrentFilterByRefinement(Refinement refinement)
    {
label0:
        {
            if (refinement != null)
            {
                if (adapter != null && !adapter.refinements.isEmpty())
                {
                    break label0;
                }
                filterById = refinement.getStringIdentifier();
            }
            return;
        }
        adapter.selectRefinement(refinement);
    }

    public void setCurrentSortByRefinement(Refinement refinement)
    {
label0:
        {
            if (refinement != null)
            {
                if (adapter != null && !adapter.refinements.isEmpty())
                {
                    break label0;
                }
                sortById = refinement.getStringIdentifier();
            }
            return;
        }
        adapter.selectRefinement(refinement);
    }

    public void setSimpleRefineCallback(SimpleRefineCallback simplerefinecallback)
    {
        callback = simplerefinecallback;
        populateAdapter();
    }

    public void updateRecyclerView()
    {
        if (adapter != null)
        {
            adapter.notifyDataSetChanged();
        }
    }
}
