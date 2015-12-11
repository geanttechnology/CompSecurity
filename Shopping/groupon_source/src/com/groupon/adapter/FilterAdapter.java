// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.groupon.models.nst.SearchFilterNameAndPositionExtraInfo;
import com.groupon.models.nst.SearchFilterTypeExtraInfo;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.models.search.domain.FacetSelectionSummaryStringBuilder;
import com.groupon.models.search.domain.FilterSheetListItemType;
import com.groupon.models.search.domain.NestedFacetValueDisplayListBuilder;
import com.groupon.models.search.domain.SortMethod;
import com.groupon.models.search.domain.SortMethodWrapper;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

// Referenced classes of package com.groupon.adapter:
//            OnFilterSheetItemClickListener

public class FilterAdapter extends BaseAdapter
    implements StickyListHeadersAdapter
{
    private static class FacetHeaderViewHolder
    {

        final ImageView arrow;
        final TextView headerSummary;
        final TextView headerText;
        final AtomicBoolean isAnimating = new AtomicBoolean();

        public FacetHeaderViewHolder(View view)
        {
            headerText = (TextView)view.findViewById(0x7f100292);
            headerSummary = (TextView)view.findViewById(0x7f100293);
            arrow = (ImageView)view.findViewById(0x7f100182);
        }
    }

    private static class NestedFacetValueViewHolder
    {

        final TextView facetNestedTextView;
        final RadioButton radioButton;

        public NestedFacetValueViewHolder(View view)
        {
            facetNestedTextView = (TextView)view.findViewById(0x7f100294);
            radioButton = (RadioButton)view.findViewById(0x7f100295);
        }
    }

    static class Paginator
    {

        private static final String MAP_KEY = "MAP_KEY";
        private static final String MAP_VALUE = "MAP_VALUE";
        public static final int PAGE_COUNT = 15;
        private final BaseAdapter baseAdapter;
        private final Map pagedItemsMap = new ArrayMap();

        private int getPagedItemCount(Facet facet)
        {
            if (pagedItemsMap.containsKey(facet.id))
            {
                return ((Integer)pagedItemsMap.get(facet.id)).intValue();
            } else
            {
                return 15;
            }
        }

        public void addMore(Facet facet)
        {
            int i = getPagedItemCount(facet);
            pagedItemsMap.put(facet.id, Integer.valueOf(i + 15));
            baseAdapter.notifyDataSetChanged();
        }

        public List getPaginatedValues(Facet facet)
        {
            ArrayList arraylist = new ArrayList();
            int i = getPagedItemCount(facet);
            facet = facet.getValues();
            if (facet.size() == i + 1)
            {
                arraylist.addAll(facet);
            } else
            {
                arraylist.addAll(facet.subList(0, Math.min(i, facet.size())));
                if (facet.size() > i)
                {
                    arraylist.add(new PaginatorItem());
                    return arraylist;
                }
            }
            return arraylist;
        }

        public void onRestoreInstanceState(Bundle bundle)
        {
            pagedItemsMap.clear();
            if (bundle != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String as[] = bundle.getStringArray("MAP_KEY");
            bundle = bundle.getIntArray("MAP_VALUE");
            if (as != null && bundle != null)
            {
                int i = 0;
                while (i < as.length) 
                {
                    pagedItemsMap.put(as[i], Integer.valueOf(bundle[i]));
                    i++;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            int i = pagedItemsMap.size();
            String as[] = new String[i];
            int ai[] = new int[i];
            i = 0;
            for (Iterator iterator = pagedItemsMap.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                as[i] = (String)entry.getKey();
                ai[i] = ((Integer)entry.getValue()).intValue();
                i++;
            }

            bundle.putStringArray("MAP_KEY", as);
            bundle.putIntArray("MAP_VALUE", ai);
        }

        public Paginator(BaseAdapter baseadapter)
        {
            baseAdapter = baseadapter;
        }
    }

    static class PaginatorItem
        implements FilterSheetListItemType
    {

        public static final int PAGINATOR_ITEM_TYPE = 4;
        public final String id = UUID.randomUUID().toString();

        public int getFilterSheetListItemType()
        {
            return 4;
        }

        public PaginatorItem()
        {
        }
    }

    private static class RangedFacetValueViewHolder
    {

        final RadioButton facetRadio;

        public RangedFacetValueViewHolder(View view)
        {
            facetRadio = (RadioButton)view.findViewById(0x7f100296);
        }
    }

    private static class SortMethodHeader
        implements FilterSheetListItemType
    {

        public static final int sortType = 3;

        public int getFilterSheetListItemType()
        {
            return 3;
        }

        public int hashCode()
        {
            return "sort".hashCode();
        }

        private SortMethodHeader()
        {
        }

    }

    private static class SortMethodViewHolder
    {

        final RadioButton facetRadio;

        public SortMethodViewHolder(View view)
        {
            facetRadio = (RadioButton)view.findViewById(0x7f100296);
        }
    }

    private static class StaticFacetValueViewHolder
    {

        final CompoundButton facetCheck;

        public StaticFacetValueViewHolder(View view)
        {
            facetCheck = (CompoundButton)view.findViewById(0x7f100297);
        }
    }


    private static final String COLLAPSED = "COLLAPSED";
    private static final int NESTED_FACET_DEFAULT_LEFT_PADDING_DP = 24;
    private static final int NESTED_FACET_INDENTED_LEFT_PADDING_DP = 48;
    private static final String NST_ADD_MORE_CLICKED = "filter_more_option_select";
    public static final String NST_FILTER_IMPRESSION = "filter_impression";
    private static final float ROTATION_COLLAPSED = -180F;
    private static final float ROTATION_EXPANDED = 0F;
    protected static final Class facetTypeViewClasses[] = {
        com/groupon/adapter/FilterAdapter$RangedFacetValueViewHolder, com/groupon/adapter/FilterAdapter$StaticFacetValueViewHolder, com/groupon/adapter/FilterAdapter$NestedFacetValueViewHolder, com/groupon/adapter/FilterAdapter$SortMethodViewHolder, com/groupon/adapter/FilterAdapter$PaginatorItem
    };
    private final Map childParentMap = new ArrayMap();
    private HashMap collapsedMap;
    private DeviceInfoUtil deviceInfoUtil;
    private FacetSelectionSummaryStringBuilder facetSelectionSummaryStringBuilder;
    private final LayoutInflater inflater;
    private final List listViewItems = new ArrayList();
    private Logger logger;
    private NestedFacetValueDisplayListBuilder nestedFacetValueDisplayListBuilder;
    private OnFilterSheetItemClickListener onFilterSheetItemClickListener;
    private final List originalFacetsList = new ArrayList();
    private final Paginator paginator = new Paginator(this);
    private List sortMethods;

    public FilterAdapter(Context context, List list, List list1, OnFilterSheetItemClickListener onfiltersheetitemclicklistener)
    {
        collapsedMap = new HashMap();
        sortMethods = new ArrayList();
        RoboGuice.getInjector(context).injectMembers(this);
        onFilterSheetItemClickListener = onfiltersheetitemclicklistener;
        sortMethods = list1;
        inflater = LayoutInflater.from(context);
        setDataSet(list);
    }

    private SortMethodWrapper findSelectedSortMethod()
    {
        for (Iterator iterator = sortMethods.iterator(); iterator.hasNext();)
        {
            SortMethodWrapper sortmethodwrapper = (SortMethodWrapper)iterator.next();
            if (sortmethodwrapper.isSelected)
            {
                return sortmethodwrapper;
            }
        }

        throw new IllegalStateException("Must have a selected sort value");
    }

    private void generateDataMap()
    {
        listViewItems.clear();
        childParentMap.clear();
        SortMethodHeader sortmethodheader = new SortMethodHeader();
        for (int i = 0; i < sortMethods.size(); i++)
        {
            SortMethodWrapper sortmethodwrapper = (SortMethodWrapper)sortMethods.get(i);
            listViewItems.add(i, sortmethodwrapper);
            childParentMap.put(sortmethodwrapper, sortmethodheader);
        }

        for (Iterator iterator = originalFacetsList.iterator(); iterator.hasNext();)
        {
            Facet facet = (Facet)iterator.next();
            if (facet.isNested())
            {
                Object obj = new ArrayList();
                nestedFacetValueDisplayListBuilder.generateDisplayFacetValueListForNestedFacet(facet.getValues(), ((List) (obj)));
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    FacetValue facetvalue = (FacetValue)((Iterator) (obj)).next();
                    listViewItems.add(facetvalue);
                    childParentMap.put(facetvalue, facet);
                }
            } else
            {
                Iterator iterator1 = paginator.getPaginatedValues(facet).iterator();
                while (iterator1.hasNext()) 
                {
                    Object obj1 = iterator1.next();
                    listViewItems.add(obj1);
                    childParentMap.put(obj1, facet);
                }
            }
        }

    }

    private String getStringResourceForSortMethod(Context context, SortMethod sortmethod)
    {
        if (com.groupon.models.search.domain.SortMethod.Methods.RELEVANCE.equals(sortmethod))
        {
            return context.getString(0x7f0801c1);
        }
        if (com.groupon.models.search.domain.SortMethod.Methods.DISTANCE.equals(sortmethod))
        {
            return context.getString(0x7f0801bd);
        }
        if (com.groupon.models.search.domain.SortMethod.Methods.PRICE_ASC.equals(sortmethod))
        {
            return context.getString(0x7f0801bf);
        }
        if (com.groupon.models.search.domain.SortMethod.Methods.PRICE_DESC.equals(sortmethod))
        {
            return context.getString(0x7f0801c0);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown sort method '").append(sortmethod.id).append("'").toString());
        }
    }

    private boolean isLastItemInSection(int i)
    {
        Object obj = getHeaderViewItem(i);
        int j = i + 1;
        return i > 0 && j < getCount() && obj != getHeaderViewItem(j) && getItemViewType(j) != 4;
    }

    private void updateRowBackground(View view, boolean flag)
    {
        android.graphics.drawable.Drawable drawable = ContextCompat.getDrawable(view.getContext(), 0x7f0e00ac);
        android.graphics.drawable.Drawable drawable1 = ContextCompat.getDrawable(view.getContext(), 0x7f020048);
        if (android.os.Build.VERSION.SDK_INT <= 19 && flag)
        {
            int i = view.getPaddingTop();
            int j = view.getPaddingBottom();
            int k = view.getPaddingLeft();
            int l = view.getPaddingRight();
            view.setBackground(drawable1);
            view.setPadding(k, i, l, j);
            return;
        }
        if (flag)
        {
            drawable = drawable1;
        }
        view.setBackground(drawable);
    }

    public List generateCollapsedIdList()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = collapsedMap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Long long1 = (Long)iterator.next();
            if (((Boolean)collapsedMap.get(long1)).booleanValue())
            {
                arraylist.add(long1);
            }
        } while (true);
        return arraylist;
    }

    public int getCount()
    {
        return listViewItems.size();
    }

    public long getHeaderId(int i)
    {
        return (long)getHeaderViewItem(i).hashCode();
    }

    public String getHeaderNiceName(int i)
    {
        FilterSheetListItemType filtersheetlistitemtype = (FilterSheetListItemType)childParentMap.get(listViewItems.get(i));
        if (filtersheetlistitemtype instanceof Facet)
        {
            return ((Facet)filtersheetlistitemtype).id;
        } else
        {
            return null;
        }
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        int j = getHeaderViewItemType(i);
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(0x7f0300e3, viewgroup, false);
            view1.setTag(new FacetHeaderViewHolder(view1));
        }
        view = (FacetHeaderViewHolder)view1.getTag();
        long l;
        boolean flag;
        if (j == 3)
        {
            viewgroup = findSelectedSortMethod();
            ((FacetHeaderViewHolder) (view)).headerText.setText(view1.getContext().getString(0x7f0801be));
            ((FacetHeaderViewHolder) (view)).headerSummary.setText(getStringResourceForSortMethod(view1.getContext(), ((SortMethodWrapper) (viewgroup)).sortMethod));
        } else
        {
            viewgroup = (Facet)getHeaderViewItem(i);
            ((FacetHeaderViewHolder) (view)).headerText.setText(((Facet) (viewgroup)).friendlyName);
            String s = facetSelectionSummaryStringBuilder.buildSummaryString(viewgroup);
            int k;
            if (s.isEmpty())
            {
                ((FacetHeaderViewHolder) (view)).headerSummary.setVisibility(8);
            } else
            {
                ((FacetHeaderViewHolder) (view)).headerSummary.setVisibility(0);
                ((FacetHeaderViewHolder) (view)).headerSummary.setText(s);
            }
            k = originalFacetsList.indexOf(viewgroup);
            logger.logImpression("", "filter_impression", "search", String.valueOf(k), new SearchFilterNameAndPositionExtraInfo(((Facet) (viewgroup)).id, k));
        }
        ((FacetHeaderViewHolder) (view)).headerText.setTag(view);
        l = getHeaderId(i);
        view = (Boolean)collapsedMap.get(Long.valueOf(l));
        if (view == null)
        {
            flag = true;
        } else
        {
            flag = view.booleanValue();
        }
        onHeaderToggled(l, view1, flag, false);
        return view1;
    }

    public Object getHeaderViewItem(int i)
    {
        Object obj = getItem(i);
        return childParentMap.get(obj);
    }

    public int getHeaderViewItemType(int i)
    {
        return ((FilterSheetListItemType)getHeaderViewItem(i)).getFilterSheetListItemType();
    }

    public Object getItem(int i)
    {
        return listViewItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        Object obj = getItem(i);
        if (obj instanceof FilterSheetListItemType)
        {
            return ((FilterSheetListItemType)obj).getFilterSheetListItemType();
        } else
        {
            return getHeaderViewItemType(i);
        }
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        getItemViewType(position);
        JVM INSTR tableswitch 0 4: default 40
    //                   0 169
    //                   1 279
    //                   2 389
    //                   3 42
    //                   4 605;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return null;
_L5:
        final SortMethodWrapper sortMethodWrapper = (SortMethodWrapper)getItem(position);
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(0x7f0300e5, viewgroup, false);
            view1.setTag(new SortMethodViewHolder(view1));
        }
        view = (SortMethodViewHolder)view1.getTag();
        ((SortMethodViewHolder) (view)).facetRadio.setText(getStringResourceForSortMethod(view1.getContext(), sortMethodWrapper.sortMethod));
        ((SortMethodViewHolder) (view)).facetRadio.setOnCheckedChangeListener(null);
        ((SortMethodViewHolder) (view)).facetRadio.setChecked(sortMethodWrapper.isSelected);
        ((SortMethodViewHolder) (view)).facetRadio.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FilterAdapter this$0;
            final SortMethodWrapper val$sortMethodWrapper;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (onFilterSheetItemClickListener != null)
                {
                    onFilterSheetItemClickListener.onSortMethodSelected(sortMethodWrapper);
                }
            }

            
            {
                this$0 = FilterAdapter.this;
                sortMethodWrapper = sortmethodwrapper;
                super();
            }
        });
        view = view1;
_L8:
        updateRowBackground(view, isLastItemInSection(position));
        return view;
_L2:
        final FacetValue facetValue = (FacetValue)getItem(position);
        View view2 = view;
        if (view == null)
        {
            view2 = inflater.inflate(0x7f0300e5, viewgroup, false);
            view2.setTag(new RangedFacetValueViewHolder(view2));
        }
        view = (RangedFacetValueViewHolder)view2.getTag();
        ((RangedFacetValueViewHolder) (view)).facetRadio.setText(facetValue.friendlyName);
        ((RangedFacetValueViewHolder) (view)).facetRadio.setOnCheckedChangeListener(null);
        ((RangedFacetValueViewHolder) (view)).facetRadio.setChecked(facetValue.isSelected);
        ((RangedFacetValueViewHolder) (view)).facetRadio.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FilterAdapter this$0;
            final FacetValue val$facetValue;
            final int val$position;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                onFilterSheetItemSelected(position, facetValue, flag);
            }

            
            {
                this$0 = FilterAdapter.this;
                position = i;
                facetValue = facetvalue;
                super();
            }
        });
        view = view2;
        continue; /* Loop/switch isn't completed */
_L3:
        final FacetValue facetValue = (FacetValue)getItem(position);
        View view3 = view;
        if (view == null)
        {
            view3 = inflater.inflate(0x7f0300e6, viewgroup, false);
            view3.setTag(new StaticFacetValueViewHolder(view3));
        }
        view = (StaticFacetValueViewHolder)view3.getTag();
        ((StaticFacetValueViewHolder) (view)).facetCheck.setText(facetValue.friendlyName);
        ((StaticFacetValueViewHolder) (view)).facetCheck.setOnCheckedChangeListener(null);
        ((StaticFacetValueViewHolder) (view)).facetCheck.setChecked(facetValue.isSelected);
        ((StaticFacetValueViewHolder) (view)).facetCheck.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FilterAdapter this$0;
            final FacetValue val$facetValue;
            final int val$position;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                onFilterSheetItemSelected(position, facetValue, flag);
            }

            
            {
                this$0 = FilterAdapter.this;
                position = i;
                facetValue = facetvalue;
                super();
            }
        });
        view = view3;
        continue; /* Loop/switch isn't completed */
_L4:
        final FacetValue facetValue = (FacetValue)getItem(position);
        View view4 = view;
        if (view == null)
        {
            view4 = inflater.inflate(0x7f0300e4, viewgroup, false);
            view4.setTag(new NestedFacetValueViewHolder(view4));
        }
        int i = deviceInfoUtil.convertDpToPixels(24);
        if (facetValue.isDerivedLeaf)
        {
            i = deviceInfoUtil.convertDpToPixels(48);
        }
        view4.setPadding(i, view4.getPaddingTop(), view4.getPaddingRight(), view4.getPaddingBottom());
        view = (NestedFacetValueViewHolder)view4.getTag();
        ((NestedFacetValueViewHolder) (view)).facetNestedTextView.setText(facetValue.friendlyName);
        ((NestedFacetValueViewHolder) (view)).facetNestedTextView.setOnClickListener(new android.view.View.OnClickListener() {

            final FilterAdapter this$0;
            final FacetValue val$facetValue;
            final int val$position;

            public void onClick(View view6)
            {
                view6 = FilterAdapter.this;
                int j = position;
                FacetValue facetvalue = facetValue;
                boolean flag;
                if (!facetValue.isSelected)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view6.onFilterSheetItemSelected(j, facetvalue, flag);
            }

            
            {
                this$0 = FilterAdapter.this;
                position = i;
                facetValue = facetvalue;
                super();
            }
        });
        if (facetValue.isSelected && !facetValue.hasSelectedChildren())
        {
            ((NestedFacetValueViewHolder) (view)).facetNestedTextView.setTextColor(view4.getResources().getColor(0x7f0e00b6));
            ((NestedFacetValueViewHolder) (view)).radioButton.setChecked(true);
            view = view4;
        } else
        {
            ((NestedFacetValueViewHolder) (view)).facetNestedTextView.setTextColor(view4.getResources().getColor(0x7f0e0031));
            ((NestedFacetValueViewHolder) (view)).radioButton.setChecked(false);
            view = view4;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        final Facet facet = (Facet)getHeaderViewItem(position);
        View view5 = view;
        if (view == null)
        {
            view5 = inflater.inflate(0x7f0300e2, viewgroup, false);
        }
        view5.setOnClickListener(new android.view.View.OnClickListener() {

            final FilterAdapter this$0;
            final Facet val$facet;

            public void onClick(View view6)
            {
                logger.logClick("", "filter_more_option_select", "search", Logger.NULL_NST_FIELD, new SearchFilterTypeExtraInfo(facet.id));
                paginator.addMore(facet);
            }

            
            {
                this$0 = FilterAdapter.this;
                facet = facet1;
                super();
            }
        });
        view = view5;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int getViewTypeCount()
    {
        return facetTypeViewClasses.length;
    }

    public void notifyDataSetChanged()
    {
        generateDataMap();
        super.notifyDataSetChanged();
    }

    public void onFilterSheetItemSelected(int i, FacetValue facetvalue, boolean flag)
    {
        if (onFilterSheetItemClickListener != null)
        {
            onFilterSheetItemClickListener.onFacetValueSelected((Facet)getHeaderViewItem(i), facetvalue, flag);
        }
    }

    public void onHeaderToggled(long l, final View holder, boolean flag, boolean flag1)
    {
        holder = (FacetHeaderViewHolder)holder.getTag();
        float f;
        if (flag)
        {
            f = -180F;
        } else
        {
            f = 0.0F;
        }
        if (flag)
        {
            collapsedMap.put(Long.valueOf(l), Boolean.valueOf(true));
        } else
        {
            collapsedMap.put(Long.valueOf(l), Boolean.valueOf(false));
        }
        if (flag1)
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(((FacetHeaderViewHolder) (holder)).arrow, "rotation", new float[] {
                f
            });
            objectanimator.addListener(new AnimatorListenerAdapter() {

                final FilterAdapter this$0;
                final FacetHeaderViewHolder val$holder;

                public void onAnimationCancel(Animator animator)
                {
                    holder.isAnimating.set(false);
                }

                public void onAnimationEnd(Animator animator)
                {
                    holder.isAnimating.set(false);
                }

                public void onAnimationStart(Animator animator)
                {
                    holder.isAnimating.set(true);
                }

            
            {
                this$0 = FilterAdapter.this;
                holder = facetheaderviewholder;
                super();
            }
            });
            objectanimator.start();
        } else
        if (!((FacetHeaderViewHolder) (holder)).isAnimating.get() && ((FacetHeaderViewHolder) (holder)).arrow.getRotation() != f)
        {
            ((FacetHeaderViewHolder) (holder)).arrow.setRotation(f);
            return;
        }
    }

    public void onRestoreInstanceState(Bundle bundle, ExpandableStickyListHeadersListView expandablestickylistheaderslistview)
    {
        if (bundle != null && bundle.containsKey("COLLAPSED"))
        {
            Object obj = (HashMap)bundle.getSerializable("COLLAPSED");
            if (obj != null)
            {
                collapsedMap = ((HashMap) (obj));
            }
            obj = collapsedMap.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                long l = ((Long)((Iterator) (obj)).next()).longValue();
                if (((Boolean)collapsedMap.get(Long.valueOf(l))).booleanValue())
                {
                    expandablestickylistheaderslistview.collapse(l);
                }
            } while (true);
            paginator.onRestoreInstanceState(bundle);
            notifyDataSetChanged();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putSerializable("COLLAPSED", collapsedMap);
        paginator.onSaveInstanceState(bundle);
    }

    public void setDataSet(List list)
    {
        originalFacetsList.clear();
        originalFacetsList.addAll(list);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Facet facet = (Facet)list.next();
            if (!collapsedMap.containsKey(Long.valueOf(facet.id.hashCode())))
            {
                collapsedMap.put(Long.valueOf(facet.id.hashCode()), Boolean.valueOf(true));
            }
        } while (true);
    }

    public void setOnFilterSheetItemClickListener(OnFilterSheetItemClickListener onfiltersheetitemclicklistener)
    {
        onFilterSheetItemClickListener = onfiltersheetitemclicklistener;
    }




}
