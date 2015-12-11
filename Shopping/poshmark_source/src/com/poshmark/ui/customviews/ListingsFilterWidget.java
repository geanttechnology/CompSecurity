// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.db.DbApi;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.fragments.PMFilterableFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTextView

public class ListingsFilterWidget extends HorizontalScrollView
{
    class ButtonInfo
    {

        Button button;
        PMTextView buttonText;
        FILTER_BUTTON buttonType;
        String label;
        LinearLayout layout;
        android.view.View.OnClickListener mClickListener;
        PMTextView textView;
        final ListingsFilterWidget this$0;

        ButtonInfo(String s, FILTER_BUTTON filter_button, int i, int j, int k, int l)
        {
            this.this$0 = ListingsFilterWidget.this;
            super();
            label = s;
            buttonType = filter_button;
            mClickListener = i. new _cls1();
            if (isG2FiltersEnabled)
            {
                buttonText = (PMTextView)findViewById(k);
                textView = (PMTextView)findViewById(l);
                buttonText.setText(s);
                layout = (LinearLayout)findViewById(j);
                layout.setOnClickListener(mClickListener);
                return;
            } else
            {
                button = (Button)findViewById(k);
                button.setText(s);
                button.setOnClickListener(mClickListener);
                return;
            }
        }
    }

    public static final class FILTER_BUTTON extends Enum
    {

        private static final FILTER_BUTTON $VALUES[];
        public static final FILTER_BUTTON AVAILABILITY;
        public static final FILTER_BUTTON BRAND;
        public static final FILTER_BUTTON CATEGORY;
        public static final FILTER_BUTTON COLOR;
        public static final FILTER_BUTTON CONDITION;
        public static final FILTER_BUTTON FILTER;
        public static final FILTER_BUTTON PRICE;
        public static final FILTER_BUTTON SIZE;
        public static final FILTER_BUTTON STYLE_TAGS;

        public static FILTER_BUTTON valueOf(String s)
        {
            return (FILTER_BUTTON)Enum.valueOf(com/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON, s);
        }

        public static FILTER_BUTTON[] values()
        {
            return (FILTER_BUTTON[])$VALUES.clone();
        }

        static 
        {
            FILTER = new FILTER_BUTTON("FILTER", 0);
            CATEGORY = new FILTER_BUTTON("CATEGORY", 1);
            BRAND = new FILTER_BUTTON("BRAND", 2);
            SIZE = new FILTER_BUTTON("SIZE", 3);
            PRICE = new FILTER_BUTTON("PRICE", 4);
            AVAILABILITY = new FILTER_BUTTON("AVAILABILITY", 5);
            CONDITION = new FILTER_BUTTON("CONDITION", 6);
            COLOR = new FILTER_BUTTON("COLOR", 7);
            STYLE_TAGS = new FILTER_BUTTON("STYLE_TAGS", 8);
            $VALUES = (new FILTER_BUTTON[] {
                FILTER, CATEGORY, BRAND, SIZE, PRICE, AVAILABILITY, CONDITION, COLOR, STYLE_TAGS
            });
        }

        private FILTER_BUTTON(String s, int i)
        {
            super(s, i);
        }
    }


    final String SEPARATOR = ", ";
    final int STANDARD_STYLE = 1;
    Map buttons;
    boolean isEnhancedFilter;
    boolean isG2FiltersEnabled;
    int layoutType;
    PMFragment ownerFragment;
    android.view.View.OnClickListener styleTagClickListener;

    public ListingsFilterWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isEnhancedFilter = true;
        buttons = new HashMap();
        isG2FiltersEnabled = false;
        styleTagClickListener = new android.view.View.OnClickListener() {

            final ListingsFilterWidget this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putInt("FILTER_ACTION", 16);
                PMNotificationManager.fireNotification("com.poshmark.intents.FILTER_SELECTION_ACTION", view);
            }

            
            {
                this$0 = ListingsFilterWidget.this;
                super();
            }
        };
        layoutType = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.ListingsFilterWidget).getInt(0, 1);
        setHorizontalScrollBarEnabled(false);
        context = LayoutInflater.from(getContext());
        isG2FiltersEnabled = FeatureManager.getGlobalFeatureManager().isFilterBarv2FeatureEnabled();
        if (isG2FiltersEnabled)
        {
            context = context.inflate(0x7f03007d, null, false);
        } else
        {
            context = context.inflate(0x7f03007c, null, false);
        }
        addView(context);
        setupButtonLayout(layoutType);
        updateFilterWidget();
    }

    private String getFilterCount()
    {
        Object obj;
        int k;
        int l;
label0:
        {
            k = 0;
            int i = 0;
            obj = buttons.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (((ButtonInfo)buttons.get(((Iterator) (obj)).next())).layout.getVisibility() == 0)
                {
                    i++;
                }
            } while (true);
            l = i - 1;
            obj = getFilterManager().getSearchModel().getFilters();
            if (getFilterManager().getCurrentBrand() != null)
            {
                k = 0 + 1;
            }
            i = k;
            if (getFilterManager().getCurrentCategory() != null)
            {
                i = k + 1;
            }
            k = i;
            if (getFilterManager().getCurrentAvailability().getId() != "all_items")
            {
                k = i + 1;
            }
            i = k;
            if (getFilterManager().getCurrentCondition().getId() != "not_nwt")
            {
                i = k + 1;
            }
            if (!((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).isMySizeEnabled())
            {
                k = i;
                if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getSizeList() == null)
                {
                    break label0;
                }
                k = i;
                if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getSizeList().size() <= 0)
                {
                    break label0;
                }
            }
            k = i + 1;
        }
        int j = k;
        if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getColorList() != null)
        {
            j = k;
            if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getColorList().size() > 0)
            {
                j = k + 1;
            }
        }
        k = j;
        if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getPriceRangeDisplayList() != null)
        {
            k = j;
            if (((com.poshmark.utils.SearchFilterModel.SearchFilters) (obj)).getPriceRangeDisplayList().size() > 0)
            {
                k = j + 1;
            }
        }
        if (k > 0)
        {
            return (new StringBuilder()).append(k).append("/").append(l).toString();
        } else
        {
            return (new StringBuilder()).append(l).append("").toString();
        }
    }

    private String getFilteredAvailabilityString()
    {
        MetaItem metaitem = getSearchModel().getAvailabilityAsMetaItem();
        if (metaitem.getId().equals("available"))
        {
            return ownerFragment.getString(0x7f060050);
        }
        if (metaitem.getId().equals("sold_out"))
        {
            return ownerFragment.getString(0x7f060286);
        } else
        {
            return ownerFragment.getString(0x7f06003c);
        }
    }

    private String getFilteredBrandsDisplayString()
    {
        return getFilterManager().getCurrentBrand().getDisplay();
    }

    private String getFilteredCategoryDisplayString()
    {
        return getFilterManager().getCurrentCategory().getDisplay();
    }

    private String getFilteredColorsDisplayString()
    {
        return StringUtils.join(getFilterManager().getSearchModel().getColorList(), ", ");
    }

    private String getFilteredConditionsDisplayString()
    {
        String s = getFilterManager().getCurrentCondition().getId();
        if (s.equals("ret"))
        {
            return ownerFragment.getString(0x7f06022d);
        }
        if (s.equals("nwt"))
        {
            return ownerFragment.getString(0x7f0601d7);
        } else
        {
            return ownerFragment.getString(0x7f06003c);
        }
    }

    private String getFilteredPricesDisplayString()
    {
        return StringUtils.join(getFilterManager().getSearchModel().getFilters().getPriceRangeDisplayList(), ", ");
    }

    private String getFilteredSizesDisplayString()
    {
        MetaItem metaitem = getFilterManager().getCurrentCategory();
        boolean flag = getSearchModel().getFilters().isMySizeEnabled();
        Object obj = getFilterManager().getSearchModel().getFilters().getSizeList();
        StringBuilder stringbuilder = new StringBuilder();
        if (flag)
        {
            stringbuilder.append(ownerFragment.getString(0x7f0601ba));
            if (metaitem != null && obj != null && ((List) (obj)).size() > 0)
            {
                stringbuilder.append(", ");
            }
        }
        if (metaitem != null && obj != null && ((List) (obj)).size() > 0)
        {
            MetaItem metaitem1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((new StringBuilder()).append(metaitem1.getDisplay()).append(", ").toString()))
            {
                metaitem1 = DbApi.getSizeForCategoryFromLabel(metaitem.getId(), (String)((Iterator) (obj)).next());
            }

            stringbuilder.deleteCharAt(stringbuilder.length() - 2);
        }
        return stringbuilder.toString();
    }

    private void updateFilterView()
    {
        ButtonInfo buttoninfo = getButton(FILTER_BUTTON.CATEGORY);
        Object obj;
        if (getFilterManager().getCurrentCategory() == null)
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int i = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(i);
        }
        buttoninfo = getButton(FILTER_BUTTON.BRAND);
        if (getFilterManager().getCurrentBrand() == null)
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int j = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(j);
        }
        buttoninfo = getButton(FILTER_BUTTON.SIZE);
        obj = getSearchModel().getFilters().getSizeList();
        if (!getSearchModel().getFilters().isMySizeEnabled() && (obj == null || ((List) (obj)).size() == 0))
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int k = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(k);
        }
        buttoninfo = getButton(FILTER_BUTTON.PRICE);
        obj = getSearchModel().getFilters().getPriceRangeList();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int l = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(l);
        }
        buttoninfo = getButton(FILTER_BUTTON.CONDITION);
        obj = getSearchModel().getFilters().getConditionList();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int i1 = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(i1);
        }
        buttoninfo = getButton(FILTER_BUTTON.AVAILABILITY);
        obj = getSearchModel().getAvailabilityAsMetaItem();
        if (obj == null || ((MetaItem) (obj)).getId().equals("all_items"))
        {
            buttoninfo.button.setBackgroundColor(0);
        } else
        {
            int j1 = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(j1);
        }
        buttoninfo = getButton(FILTER_BUTTON.COLOR);
        if (getSearchModel().getColorList() == null)
        {
            buttoninfo.button.setBackgroundColor(0);
            return;
        } else
        {
            int k1 = Color.argb(125, 230, 226, 223);
            buttoninfo.button.setBackgroundColor(k1);
            return;
        }
    }

    public ButtonInfo getButton(FILTER_BUTTON filter_button)
    {
        filter_button = (ButtonInfo)buttons.get(filter_button);
        if (filter_button != null)
        {
            return filter_button;
        } else
        {
            return null;
        }
    }

    public FilterResultsManager getFilterManager()
    {
        if (ownerFragment != null)
        {
            return ((PMFilterableFragment)ownerFragment).getFilterManager();
        } else
        {
            return null;
        }
    }

    public boolean getIsG2FiltersEnabled()
    {
        return isG2FiltersEnabled;
    }

    public SearchFilterModel getSearchModel()
    {
        if (ownerFragment != null)
        {
            return ((PMFilterableFragment)ownerFragment).getFilterManager().getSearchModel();
        } else
        {
            return null;
        }
    }

    public void hideButton(FILTER_BUTTON filter_button)
    {
        Object obj = null;
        ButtonInfo buttoninfo = getButton(filter_button);
        static class _cls2
        {

            static final int $SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON[];

            static 
            {
                $SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON = new int[FILTER_BUTTON.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON[FILTER_BUTTON.CATEGORY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON[FILTER_BUTTON.BRAND.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON[FILTER_BUTTON.SIZE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (buttoninfo != null)
        {
            if (isG2FiltersEnabled)
            {
                buttoninfo.layout.setVisibility(8);
            } else
            {
                buttoninfo.button.setVisibility(8);
            }
        }
        _cls2..SwitchMap.com.poshmark.ui.customviews.ListingsFilterWidget.FILTER_BUTTON[filter_button.ordinal()];
        JVM INSTR tableswitch 1 3: default 64
    //                   1 93
    //                   2 104
    //                   3 115;
           goto _L1 _L2 _L3 _L4
_L1:
        filter_button = obj;
_L6:
        if (filter_button != null)
        {
            filter_button.setVisibility(8);
        }
        updateFilterWidget();
        return;
_L2:
        filter_button = findViewById(0x7f0c01e0);
        continue; /* Loop/switch isn't completed */
_L3:
        filter_button = findViewById(0x7f0c01de);
        continue; /* Loop/switch isn't completed */
_L4:
        filter_button = findViewById(0x7f0c01e2);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void hideWidget()
    {
        setVisibility(8);
    }

    public void setOwnerFragment(PMFragment pmfragment)
    {
        ownerFragment = pmfragment;
    }

    public void setupButtonLayout(int i)
    {
        if (isG2FiltersEnabled)
        {
            buttons.put(FILTER_BUTTON.FILTER, new ButtonInfo(getResources().getString(0x7f060121), FILTER_BUTTON.FILTER, 5, 0x7f0c01e9, 0x7f0c01dc, 0x7f0c01ea));
            buttons.put(FILTER_BUTTON.BRAND, new ButtonInfo(getResources().getString(0x7f06011d), FILTER_BUTTON.BRAND, 6, 0x7f0c01ec, 0x7f0c01dd, 0x7f0c01ed));
            buttons.put(FILTER_BUTTON.CATEGORY, new ButtonInfo(getResources().getString(0x7f06011e), FILTER_BUTTON.CATEGORY, 17, 0x7f0c01ee, 0x7f0c01df, 0x7f0c01ef));
            buttons.put(FILTER_BUTTON.CONDITION, new ButtonInfo(getResources().getString(0x7f060120), FILTER_BUTTON.CONDITION, 10, 0x7f0c01f0, 0x7f0c01e1, 0x7f0c01f1));
            buttons.put(FILTER_BUTTON.COLOR, new ButtonInfo(getResources().getString(0x7f06011f), FILTER_BUTTON.COLOR, 15, 0x7f0c01f2, 0x7f0c01e3, 0x7f0c01f3));
            buttons.put(FILTER_BUTTON.SIZE, new ButtonInfo(getResources().getString(0x7f060123), FILTER_BUTTON.SIZE, 8, 0x7f0c01f4, 0x7f0c01e5, 0x7f0c01f5));
            buttons.put(FILTER_BUTTON.PRICE, new ButtonInfo(getResources().getString(0x7f060122), FILTER_BUTTON.PRICE, 9, 0x7f0c01f6, 0x7f0c01e7, 0x7f0c01f7));
            buttons.put(FILTER_BUTTON.AVAILABILITY, new ButtonInfo(getResources().getString(0x7f06011c), FILTER_BUTTON.AVAILABILITY, 11, 0x7f0c01f8, 0x7f0c01e8, 0x7f0c01f9));
            return;
        }
        if (i == 1)
        {
            buttons.put(FILTER_BUTTON.FILTER, new ButtonInfo(getResources().getString(0x7f060121), FILTER_BUTTON.FILTER, 5, 0x7f0c01e9, 0x7f0c01dc, 0x7f0c01ea));
            buttons.put(FILTER_BUTTON.BRAND, new ButtonInfo(getResources().getString(0x7f06011d), FILTER_BUTTON.BRAND, 6, 0x7f0c01ec, 0x7f0c01dd, 0x7f0c01ed));
            buttons.put(FILTER_BUTTON.CATEGORY, new ButtonInfo(getResources().getString(0x7f06011e), FILTER_BUTTON.CATEGORY, 17, 0x7f0c01ee, 0x7f0c01df, 0x7f0c01ef));
            buttons.put(FILTER_BUTTON.COLOR, new ButtonInfo(getResources().getString(0x7f06011f), FILTER_BUTTON.COLOR, 15, 0x7f0c01f0, 0x7f0c01e1, 0x7f0c01f1));
            buttons.put(FILTER_BUTTON.SIZE, new ButtonInfo(getResources().getString(0x7f060123), FILTER_BUTTON.SIZE, 8, 0x7f0c01f2, 0x7f0c01e3, 0x7f0c01f3));
            buttons.put(FILTER_BUTTON.PRICE, new ButtonInfo(getResources().getString(0x7f060122), FILTER_BUTTON.PRICE, 9, 0x7f0c01f4, 0x7f0c01e5, 0x7f0c01f5));
            buttons.put(FILTER_BUTTON.CONDITION, new ButtonInfo(getResources().getString(0x7f060120), FILTER_BUTTON.CONDITION, 10, 0x7f0c01f6, 0x7f0c01e7, 0x7f0c01f7));
            buttons.put(FILTER_BUTTON.AVAILABILITY, new ButtonInfo(getResources().getString(0x7f06011c), FILTER_BUTTON.AVAILABILITY, 11, 0x7f0c01f8, 0x7f0c01e8, 0x7f0c01f9));
            return;
        } else
        {
            buttons.put(FILTER_BUTTON.FILTER, new ButtonInfo(getResources().getString(0x7f060121), FILTER_BUTTON.FILTER, 5, 0x7f0c01e9, 0x7f0c01dc, 0x7f0c01ea));
            buttons.put(FILTER_BUTTON.BRAND, new ButtonInfo(getResources().getString(0x7f06011d), FILTER_BUTTON.BRAND, 6, 0x7f0c01ec, 0x7f0c01dd, 0x7f0c01ed));
            buttons.put(FILTER_BUTTON.CATEGORY, new ButtonInfo(getResources().getString(0x7f06011e), FILTER_BUTTON.CATEGORY, 17, 0x7f0c01ee, 0x7f0c01df, 0x7f0c01ef));
            buttons.put(FILTER_BUTTON.AVAILABILITY, new ButtonInfo(getResources().getString(0x7f06011c), FILTER_BUTTON.AVAILABILITY, 11, 0x7f0c01f0, 0x7f0c01e1, 0x7f0c01f1));
            buttons.put(FILTER_BUTTON.PRICE, new ButtonInfo(getResources().getString(0x7f060122), FILTER_BUTTON.PRICE, 9, 0x7f0c01f2, 0x7f0c01e3, 0x7f0c01f3));
            buttons.put(FILTER_BUTTON.COLOR, new ButtonInfo(getResources().getString(0x7f06011f), FILTER_BUTTON.COLOR, 15, 0x7f0c01f4, 0x7f0c01e5, 0x7f0c01f5));
            buttons.put(FILTER_BUTTON.SIZE, new ButtonInfo(getResources().getString(0x7f060123), FILTER_BUTTON.SIZE, 8, 0x7f0c01f6, 0x7f0c01e7, 0x7f0c01f7));
            buttons.put(FILTER_BUTTON.CONDITION, new ButtonInfo(getResources().getString(0x7f060120), FILTER_BUTTON.CONDITION, 10, 0x7f0c01f8, 0x7f0c01e8, 0x7f0c01f9));
            return;
        }
    }

    public void showWidget()
    {
        setVisibility(0);
    }

    public void updateEnhancedFilterView()
    {
        String s = ownerFragment.getString(0x7f06003c);
        getButton(FILTER_BUTTON.FILTER).textView.setText((new StringBuilder()).append("(").append(getFilterCount()).append(")").toString());
        ButtonInfo buttoninfo = getButton(FILTER_BUTTON.CATEGORY);
        Object obj;
        if (getFilterManager().getCurrentCategory() == null)
        {
            buttoninfo.textView.setText(s);
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(getFilteredCategoryDisplayString());
            if (getFilterManager().getCurrentSubCategory() != null)
            {
                stringbuilder.append(" | ").append(getFilterManager().getCurrentSubCategory().getDisplay());
            }
            buttoninfo.textView.setText(stringbuilder.toString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.BRAND);
        if (getFilterManager().getCurrentBrand() == null)
        {
            buttoninfo.textView.setText(s);
        } else
        {
            buttoninfo.textView.setText(getFilteredBrandsDisplayString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.SIZE);
        obj = getSearchModel().getFilters().getSizeList();
        if (!getSearchModel().getFilters().isMySizeEnabled() && (obj == null || ((List) (obj)).size() == 0))
        {
            buttoninfo.textView.setText(s);
        } else
        {
            buttoninfo.textView.setText(getFilteredSizesDisplayString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.PRICE);
        obj = getSearchModel().getFilters().getPriceRangeList();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            buttoninfo.textView.setText(s);
        } else
        {
            buttoninfo.textView.setText(getFilteredPricesDisplayString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.CONDITION);
        obj = getSearchModel().getFilters().getConditionList();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            buttoninfo.textView.setText(s);
        } else
        {
            buttoninfo.textView.setText(getFilteredConditionsDisplayString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.AVAILABILITY);
        obj = getSearchModel().getAvailabilityAsMetaItem();
        if (obj == null || ((MetaItem) (obj)).getId().equals("all_items"))
        {
            buttoninfo.textView.setText(s);
        } else
        {
            buttoninfo.textView.setText(getFilteredAvailabilityString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
        }
        buttoninfo = getButton(FILTER_BUTTON.COLOR);
        if (getSearchModel().getColorList() == null)
        {
            buttoninfo.textView.setText(s);
            return;
        } else
        {
            buttoninfo.textView.setText(getFilteredColorsDisplayString());
            buttoninfo.textView.setTextColor(getResources().getColor(0x7f09003c));
            return;
        }
    }

    public void updateFilterWidget()
    {
        if (ownerFragment == null)
        {
            return;
        }
        if (isG2FiltersEnabled)
        {
            updateEnhancedFilterView();
            return;
        } else
        {
            updateFilterView();
            return;
        }
    }

    // Unreferenced inner class com/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1

/* anonymous class */
    class ButtonInfo._cls1
        implements android.view.View.OnClickListener
    {

        final ButtonInfo this$1;
        final int val$filter_action;
        final ListingsFilterWidget val$this$0;

        public void onClick(View view)
        {
            view = new Bundle();
            view.putInt("FILTER_ACTION", filter_action);
            PMNotificationManager.fireNotification("com.poshmark.intents.FILTER_SELECTION_ACTION", view);
        }

            
            {
                this$1 = final_buttoninfo;
                this$0 = listingsfilterwidget;
                filter_action = I.this;
                super();
            }
    }

}
