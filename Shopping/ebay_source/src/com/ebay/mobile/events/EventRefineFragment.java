// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.SimpleRefineFragment;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventRefineFragment extends SimpleRefineFragment
{
    private static class ButtonModel extends com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel
    {

        public String getTitle()
        {
            return null;
        }

        private ButtonModel()
        {
        }

    }

    private static class ButtonViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        private final Button resetButton;


        public ButtonViewHolder(View view)
        {
            super(view);
            resetButton = (Button)view;
        }
    }

    public static class CategoryRefinement extends EventRefinement
    {

        public com.ebay.nautilus.domain.data.Event.Category refinementCategory;

        public CategoryRefinement(com.ebay.nautilus.domain.data.Event.Category category)
        {
            super(category.name, null, RefinementType.CATEGORY_FILTER);
            refinementCategory = category;
        }
    }

    protected class EventItemDecoration extends com.ebay.mobile.common.SimpleRefineFragment.RefinementItemDecoration
    {

        final EventRefineFragment this$0;

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
        {
            int j = recyclerview.getWidth();
            int k = recyclerview.getChildCount();
            int i = 0;
            while (i < k) 
            {
                if (!((com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)eventAdapter.refinements.get(i) instanceof ButtonModel))
                {
                    state = recyclerview.getChildAt(i);
                    android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
                    int l = state.getBottom() + layoutparams.bottomMargin;
                    int i1 = divider.getIntrinsicHeight();
                    divider.setBounds(0, l, j, l + i1);
                    divider.draw(canvas);
                }
                i++;
            }
        }

        public EventItemDecoration(Context context)
        {
            this$0 = EventRefineFragment.this;
            super(context);
        }
    }

    public static class EventRefinement extends com.ebay.mobile.common.SimpleRefineFragment.Refinement
    {

        private String refineSelectedName;
        public RefinementType refinementType;

        public String getStringIdentifier()
        {
            return refineSelectedName;
        }

        public boolean isDefaultRefinement()
        {
            return false;
        }

        public boolean isTopLevelRefinement()
        {
            return refineSelectedName != null;
        }

        public EventRefinement(String s, String s1, RefinementType refinementtype)
        {
            super(s);
            refineSelectedName = s1;
            refinementType = refinementtype;
        }
    }

    private class EventRefinementAdapter extends com.ebay.mobile.common.SimpleRefineFragment.RefinementAdapter
        implements TextWatcher
    {

        private static final int VIEW_TYPE_BUTTON = 0;
        private static final int VIEW_TYPE_PRICE = 2;
        private static final int VIEW_TYPE_REFINEMENT = 1;
        final EventRefineFragment this$0;

        private void showInvalidPriceDialog()
        {
            com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
            builder.setTitle(getString(0x7f0703e0));
            builder.setMessage(getString(0x7f0703df));
            builder.setPositiveButton(0x7f070738);
            builder.createFromFragment(1, getTargetFragment()).show(getFragmentManager(), getClass().getName());
        }

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        protected com.ebay.mobile.common.SimpleRefineFragment.Refinement getDefaultFilterByRefinement()
        {
            for (Iterator iterator = refinements.iterator(); iterator.hasNext();)
            {
                Object obj = (com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)iterator.next();
                if (obj instanceof EventRefinement)
                {
                    obj = (EventRefinement)obj;
                    if (((EventRefinement) (obj)).refinementType == RefinementType.CATEGORY_FILTER)
                    {
                        return ((com.ebay.mobile.common.SimpleRefineFragment.Refinement) (obj));
                    }
                }
            }

            return null;
        }

        protected com.ebay.mobile.common.SimpleRefineFragment.Refinement getDefaultSortByRefinement()
        {
            for (Iterator iterator = refinements.iterator(); iterator.hasNext();)
            {
                Object obj = (com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)iterator.next();
                if (obj instanceof EventRefinement)
                {
                    obj = (EventRefinement)obj;
                    if (((EventRefinement) (obj)).refinementType == RefinementType.SORT)
                    {
                        return ((com.ebay.mobile.common.SimpleRefineFragment.Refinement) (obj));
                    }
                }
            }

            return null;
        }

        public int getItemViewType(int i)
        {
            boolean flag = true;
            com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel recyclermodel = (com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)refinements.get(i);
            if (recyclermodel instanceof ButtonModel)
            {
                i = 0;
            } else
            {
                if (recyclermodel instanceof PriceRefinement)
                {
                    return 2;
                }
                i = ((flag) ? 1 : 0);
                if (recyclermodel instanceof EventRefinement)
                {
                    return 1;
                }
            }
            return i;
        }

        protected void getPriceRangeCategories()
        {
            refinements.clear();
            refinements.add(new PriceRefinement(getString(0x7f0703e2), minimumPrice));
            refinements.add(new PriceRefinement(getString(0x7f0703e1), maximumPrice));
            backButton.setVisibility(0);
            notifyDataSetChanged();
            selectedRefinement = null;
        }

        protected void getSortCategories()
        {
            refinements.clear();
            if (sortCategories.size() > 0)
            {
                Iterator iterator = sortCategories.iterator();
                while (iterator.hasNext()) 
                {
                    com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder sortorder = (com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder)iterator.next();
                    String s;
                    if (sortorder == com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.None)
                    {
                        s = getString(0x7f0703ef);
                    } else
                    if (sortorder == com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.CurrentPriceHighest)
                    {
                        s = getString(0x7f070ade);
                    } else
                    {
                        s = getString(0x7f070add);
                    }
                    refinements.add(new SortRefinement(s, sortorder));
                }
                backButton.setVisibility(0);
                notifyDataSetChanged();
                selectedRefinement = null;
            }
        }

        public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
        {
            if (i < refinements.size())
            {
                PriceRefinement pricerefinement;
                switch (getItemViewType(i))
                {
                default:
                    return;

                case 0: // '\0'
                    ((ButtonViewHolder)viewholder).resetButton.setOnClickListener(this);
                    return;

                case 1: // '\001'
                    EventRefinement eventrefinement = (EventRefinement)refinements.get(i);
                    RefinementViewHolder refinementviewholder = (RefinementViewHolder)viewholder;
                    refinementviewholder.textView.setText(eventrefinement.getTitle());
                    i = (int)getResources().getDimension(0x7f090141);
                    if (eventrefinement.isTopLevelRefinement())
                    {
                        refinementviewholder.selectedTextView.setText(eventrefinement.getStringIdentifier());
                        refinementviewholder.selectedTextView.setVisibility(0);
                        refinementviewholder.selectedTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f020193), null);
                        refinementviewholder.textView.setPadding(i * 2, 0, i * 2, 0);
                    } else
                    {
                        refinementviewholder.selectedTextView.setVisibility(0);
                        refinementviewholder.selectedTextView.setText(null);
                        String s = eventrefinement.getTitle();
                        if (eventrefinement.refinementType == RefinementType.SORT)
                        {
                            viewholder = show;
                        } else
                        {
                            viewholder = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onClick(View view)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                return new ButtonViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a1, viewgroup, false));

            case 1: // '\001'
                return new RefinementViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a2, viewgroup, false));

            case 2: // '\002'
                viewgroup = new PriceViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a3, viewgroup, false));
                break;
            }
            ((PriceViewHolder) (viewgroup)).price.addTextChangedListener(this);
            ((PriceViewHolder) (viewgroup)).price.setCurrency(currencyCode);
            return viewgroup;
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            k = 0;
            boolean flag = false;
            j = 0;
            charsequence = refinements.iterator();
            while (charsequence.hasNext()) 
            {
                PriceRefinement pricerefinement = (PriceRefinement)(com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)charsequence.next();
                Object obj = 
// JavaClassFileOutputException: get_constant: invalid tag

        protected void resetRefinements()
        {
            refinements.clear();
            if (show != null)
            {
                refinements.add(new EventRefinement(getString(0x7f070ad9), show, RefinementType.SORT));
            }
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public void validatePrice(boolean flag)
        {
label0:
            {
                PriceRefinement pricerefinement = null;
                PriceRefinement pricerefinement1 = null;
                Object obj2 = refinements.iterator();
                do
                {
                    if (!((Iterator) (obj2)).hasNext())
                    {
                        break;
                    }
                    Object obj = (com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)((Iterator) (obj2)).next();
                    if (obj instanceof PriceRefinement)
                    {
                        obj = (PriceRefinement)obj;
                        if (((PriceRefinement) (obj)).getTitle().equals(getString(0x7f0703e2)))
                        {
                            pricerefinement = ((PriceRefinement) (obj));
                        } else
                        if (((PriceRefinement) (obj)).getTitle().equals(getString(0x7f0703e1)))
                        {
                            pricerefinement1 = ((PriceRefinement) (obj));
                        }
                    }
                } while (true);
                if (pricerefinement == null || pricerefinement1 == null)
                {
                    break label0;
                }
                if (pricerefinement.price > pricerefinement1.price && pricerefinement1.price > 0.0D)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    pricerefinement.price = pricerefinement1.price;
                    notifyDataSetChanged();
                    showInvalidPriceDialog();
                }
                minimumPrice = pricerefinement.price;
                maximumPrice = pricerefinement1.price;
                Object obj1 = null;
                obj2 = null;
                priceRange = "";
                if (Double.compare(minimumPrice, -1D) != 0)
                {
                    obj1 = EbayCurrencyUtil.formatDisplay(currencyCode, minimumPrice, 2);
                }
                if (Double.compare(maximumPrice, -1D) != 0)
                {
                    obj2 = EbayCurrencyUtil.formatDisplay(currencyCode, maximumPrice, 2);
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    priceRange = String.format(getString(0x7f0703e5), new Object[] {
                        obj1, obj2
                    });
                } else
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    priceRange = String.format(getString(0x7f0703e4), new Object[] {
                        obj1
                    });
                } else
                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    priceRange = String.format(getString(0x7f0703e3), new Object[] {
                        obj2
                    });
                }
                if (refinements != null)
                {
                    obj1 = refinements;
                    if (!flag)
                    {
                        pricerefinement = pricerefinement1;
                    }
                    ((com.ebay.mobile.common.SimpleRefineFragment.SimpleRefineCallback) (obj1)).onRefinementSelected(pricerefinement);
                }
            }
        }

        private EventRefinementAdapter()
        {
            this$0 = EventRefineFragment.this;
            super(EventRefineFragment.this);
        }

    }

    public static class PriceRefinement extends EventRefinement
    {

        public double price;

        public PriceRefinement(String s, double d)
        {
            super(s, null, RefinementType.PRICE_FILTER);
            price = d;
        }
    }

    private static class PriceViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public final PriceView price;
        public final TextView rangeTextView;

        public PriceViewHolder(View view)
        {
            super(view);
            rangeTextView = (TextView)view.findViewById(0x7f1001aa);
            price = (PriceView)view.findViewById(0x7f1001ac);
        }
    }

    protected static final class RefinementType extends Enum
    {

        private static final RefinementType $VALUES[];
        public static final RefinementType CATEGORY_FILTER;
        public static final RefinementType PRICE_FILTER;
        public static final RefinementType SORT;

        public static RefinementType valueOf(String s)
        {
            return (RefinementType)Enum.valueOf(com/ebay/mobile/events/EventRefineFragment$RefinementType, s);
        }

        public static RefinementType[] values()
        {
            return (RefinementType[])$VALUES.clone();
        }

        static 
        {
            SORT = new RefinementType("SORT", 0);
            CATEGORY_FILTER = new RefinementType("CATEGORY_FILTER", 1);
            PRICE_FILTER = new RefinementType("PRICE_FILTER", 2);
            $VALUES = (new RefinementType[] {
                SORT, CATEGORY_FILTER, PRICE_FILTER
            });
        }

        private RefinementType(String s, int i)
        {
            super(s, i);
        }
    }

    private static class RefinementViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        private final TextView selectedTextView;
        private final TextView textView;



        public RefinementViewHolder(View view)
        {
            super(view);
            textView = (TextView)view.findViewById(0x7f1001aa);
            selectedTextView = (TextView)view.findViewById(0x7f1001ab);
        }
    }

    public static class SortRefinement extends EventRefinement
    {

        public com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder sortOption;

        public SortRefinement(String s, com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder sortorder)
        {
            super(s, null, RefinementType.SORT);
            sortOption = sortorder;
        }
    }


    protected static final String STATE_CURRENT_PRICE_MAXIMUM = "currentPriceMaximum";
    protected static final String STATE_CURRENT_PRICE_MINIMUM = "currentPriceMinimum";
    protected static final String STATE_CURRENT_PRICE_RANGE = "currentPriceRange";
    protected static final String STATE_CURRENT_SELECTED = "currentSelected";
    private ImageView backButton;
    private String currencyCode;
    private EventRefinementAdapter eventAdapter;
    private double maximumPrice;
    private double minimumPrice;
    private String priceRange;
    private TextView refineTitle;
    private RefinementType selectedRefinement;
    private List sortCategories;

    public EventRefineFragment()
    {
        sortCategories = new ArrayList();
    }

    private RefinementType getSelectedRefinement()
    {
        for (Iterator iterator = eventAdapter.refinements.iterator(); iterator.hasNext();)
        {
            Object obj = (com.ebay.mobile.common.SimpleRefineFragment.RecyclerModel)iterator.next();
            if (obj instanceof EventRefinement)
            {
                obj = (EventRefinement)obj;
                if (!((EventRefinement) (obj)).isTopLevelRefinement())
                {
                    return ((EventRefinement) (obj)).refinementType;
                }
            }
        }

        return null;
    }

    public void addRefinementCategories(List list)
    {
        eventAdapter.refinements.clear();
        if (list.size() > 0)
        {
            com.ebay.nautilus.domain.data.Event.Category category;
            for (list = list.iterator(); list.hasNext(); eventAdapter.refinements.add(new CategoryRefinement(category)))
            {
                category = (com.ebay.nautilus.domain.data.Event.Category)list.next();
            }

            eventAdapter.notifyDataSetChanged();
            backButton.setVisibility(0);
            selectedRefinement = null;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131755429 2131755431: default 32
    //                   2131755429 50
    //                   2131755430 32
    //                   2131755431 33;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L3:
        if (callback != null)
        {
            callback.onDonePressed();
            return;
        }
          goto _L1
_L2:
        refineTitle.setText(0x7f0708e1);
        eventAdapter.resetRefinements();
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03009f, viewgroup, false);
        layoutinflater.findViewById(0x7f1001a7).setOnClickListener(this);
        refineTitle = (TextView)layoutinflater.findViewById(0x7f1001a6);
        backButton = (ImageView)layoutinflater.findViewById(0x7f1001a5);
        backButton.setOnClickListener(this);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f1001a8);
        viewgroup = getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(viewgroup));
        recyclerView.addItemDecoration(new EventItemDecoration(viewgroup));
        eventAdapter = new EventRefinementAdapter();
        recyclerView.setAdapter(eventAdapter);
        currencyCode = EbaySite.getInstanceFromId(MyApp.getCurrentSite()).getCurrency().getCurrencyCode();
        if (bundle != null)
        {
            sortById = bundle.getString("currentSortTitle");
            filterById = bundle.getString("currentFilterTitle");
            priceRange = bundle.getString("currentPriceRange");
            minimumPrice = bundle.getDouble("currentPriceMinimum");
            maximumPrice = bundle.getDouble("currentPriceMaximum");
            selectedRefinement = (RefinementType)bundle.get("currentSelected");
            return layoutinflater;
        } else
        {
            setDefaultRefinements(null);
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        recyclerView = null;
        eventAdapter = null;
        backButton = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("currentSortTitle", sortById);
        bundle.putString("currentFilterTitle", filterById);
        bundle.putString("currentPriceRange", priceRange);
        bundle.putDouble("currentPriceMinimum", minimumPrice);
        bundle.putDouble("currentPriceMaximum", maximumPrice);
        bundle.putSerializable("currentSelected", getSelectedRefinement());
    }

    protected void populateAdapter()
    {
        if (eventAdapter != null)
        {
            if (selectedRefinement == RefinementType.SORT)
            {
                eventAdapter.getSortCategories();
            } else
            {
                if (selectedRefinement == RefinementType.PRICE_FILTER)
                {
                    eventAdapter.getPriceRangeCategories();
                    return;
                }
                if (selectedRefinement == null)
                {
                    eventAdapter.resetRefinements();
                    return;
                }
            }
        }
    }

    protected void setDefaultCategories(List list, List list1)
    {
        sortCategories = list1;
        if (list != null && list.size() > 0)
        {
            if (selectedRefinement == null)
            {
                list = (com.ebay.nautilus.domain.data.Event.Category)list.get(0);
                if (TextUtils.isEmpty(filterById) && list != null)
                {
                    filterById = ((com.ebay.nautilus.domain.data.Event.Category) (list)).name;
                }
            } else
            {
                if (selectedRefinement == RefinementType.CATEGORY_FILTER)
                {
                    addRefinementCategories(list);
                    return;
                }
                if (selectedRefinement == RefinementType.SORT)
                {
                    eventAdapter.getSortCategories();
                    return;
                }
            }
        }
    }

    protected void setDefaultRefinements(com.ebay.nautilus.domain.data.Event.Category category)
    {
        if (category != null)
        {
            filterById = category.name;
        }
        sortById = getString(0x7f0703ef);
        minimumPrice = -1D;
        maximumPrice = -1D;
        priceRange = "";
    }

    public void setSimpleRefineCallback(com.ebay.mobile.common.SimpleRefineFragment.SimpleRefineCallback simplerefinecallback)
    {
        callback = simplerefinecallback;
    }


/*
    static String access$1002(EventRefineFragment eventrefinefragment, String s)
    {
        eventrefinefragment.sortById = s;
        return s;
    }

*/


/*
    static String access$1102(EventRefineFragment eventrefinefragment, String s)
    {
        eventrefinefragment.filterById = s;
        return s;
    }

*/











/*
    static String access$2002(EventRefineFragment eventrefinefragment, String s)
    {
        eventrefinefragment.priceRange = s;
        return s;
    }

*/


/*
    static RefinementType access$2202(EventRefineFragment eventrefinefragment, RefinementType refinementtype)
    {
        eventrefinefragment.selectedRefinement = refinementtype;
        return refinementtype;
    }

*/




/*
    static double access$2402(EventRefineFragment eventrefinefragment, double d)
    {
        eventrefinefragment.minimumPrice = d;
        return d;
    }

*/



/*
    static double access$2502(EventRefineFragment eventrefinefragment, double d)
    {
        eventrefinefragment.maximumPrice = d;
        return d;
    }

*/










}
