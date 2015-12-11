// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.EbayTimer;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class ViewItemSpecificsFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener, com.ebay.common.EbayTimer.OnTimerEvent
{

    private static List badSpecifics;
    private String categoryLabel;
    private ViewGroup collapsedLayout;
    private ViewGroup dynamicSpecificsLayout;
    private String itemIdHeaderName;
    private int secondaryColor;
    private boolean sellerNotesRequiresExpansion;
    private ColorStateList textColorBlue;
    private View timeLeftLayout;
    private EbayTimer timer;

    public ViewItemSpecificsFragment()
    {
        sellerNotesRequiresExpansion = false;
    }

    private boolean addCategory(ViewGroup viewgroup)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            if (item.primaryCategoryName != null)
            {
                String s = item.primaryCategoryName.replace(":", " > ");
                appendLayout(viewgroup, categoryLabel, s);
                flag = true;
            }
        }
        return flag;
    }

    private void appendLayout(ViewGroup viewgroup, final String activity, String s)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f03013e, viewgroup, false);
        ((TextView)viewgroup1.findViewById(0x7f1000ec)).setText(activity);
        TextView textview = (TextView)viewgroup1.findViewById(0x7f1000ed);
        textview.setText(s);
        if (itemIdHeaderName.equals(activity))
        {
            activity = getActivity();
            textview.setTextColor(textColorBlue);
            textview.setOnClickListener(new android.view.View.OnClickListener() {

                final ViewItemSpecificsFragment this$0;
                final Activity val$activity;

                public void onClick(View view)
                {
                    ((ClipboardManager)activity.getSystemService("clipboard")).setText(String.valueOf(item.id));
                    Toast.makeText(activity, getString(0x7f070269), 0).show();
                    Util.vibratePhone(getActivity());
                }

            
            {
                this$0 = ViewItemSpecificsFragment.this;
                activity = activity1;
                super();
            }
            });
        }
        viewgroup.addView(viewgroup1);
    }

    private int getItemSpecificsCount()
    {
        if (item != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        j = 2;
        int i = j;
        if (item.lotSize != null)
        {
            i = j;
            if (item.lotSize.intValue() > 1)
            {
                i = 2 + 1;
            }
        }
        Iterator iterator = item.itemSpecifics.iterator();
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            Object obj = (NameValue)iterator.next();
            Object obj1 = new StringBuilder();
            ((StringBuilder) (obj1)).append(((NameValue) (obj)).getName());
            obj1 = ((StringBuilder) (obj1)).toString();
            String s = Util.makeCommaDelimitedString(((NameValue) (obj)).getValues());
            if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(s) && !s.equals("-") && !badSpecifics.contains(((NameValue) (obj)).getName()))
            {
                if ("Deposit amount".equals(((NameValue) (obj)).getName()))
                {
                    obj = item.depositAmountString;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private TextView getSellerNotesTextView()
    {
        if (isCollapsed())
        {
            return (TextView)view.findViewById(0x7f1008ce);
        } else
        {
            return (TextView)view.findViewById(0x7f1008cf);
        }
    }

    public static String getTimeLeftLabel(Context context, Item item)
    {
        if (item.isScheduled)
        {
            return context.getString(0x7f070188);
        }
        int i;
        if (item.isTransacted)
        {
            i = 0x7f0703c3;
        } else
        {
            i = 0x7f0703c7;
        }
        return context.getString(i);
    }

    public static boolean isQuantityDisplayStringInRed(Item item)
    {
        return item.isHotnessLastOne || item.isHotnessCountdownUrgency || item.isHotnessAlmostGone;
    }

    private int populateCommonItems()
    {
        int i = 0;
        if (item == null)
        {
            return 0;
        }
        if (!TextUtils.isEmpty(item.conditionDisplayName))
        {
            ((TextView)view.findViewById(0x7f100305)).setText(item.conditionDisplayName);
            view.findViewById(0x7f100304).setVisibility(0);
            i = 0 + 1;
        }
        int j = i;
        if (item.isShowConditionDescription)
        {
            renderSellerNotes();
            j = i + 1;
        }
        if (!item.isHideTimeLeft && item.hotnessEndTime > 0L && EbayResponse.currentHostTime() <= item.hotnessEndTime)
        {
            i = j + 1;
            setupDealTimer(getActivity(), (ViewGroup)timeLeftLayout, item);
            timeLeftLayout.setVisibility(0);
        } else
        if (!item.isHideTimeLeft && setupEndTime((ViewGroup)timeLeftLayout, item, getActivity(), inflater))
        {
            i = j + 1;
            timeLeftLayout.setVisibility(0);
        } else
        {
            timeLeftLayout.setVisibility(8);
            i = j;
        }
        j = i;
        if (showQuantity())
        {
            j = i + 1;
        }
        i = j;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_EEK))
        {
            i = j;
            if (showEEK())
            {
                i = j + 1;
            }
        }
        j = i;
        if (item.isHotnessCharity)
        {
            j = i;
            if (showHotnessCharity(collapsedLayout))
            {
                j = i + 1;
            }
        }
        return j;
    }

    private int populateLayout(int i, ViewGroup viewgroup)
    {
label0:
        {
            collapsedLayout.removeAllViews();
            dynamicSpecificsLayout.removeAllViews();
            int k1 = populateCommonItems();
            int j1 = getItemSpecificsCount() + k1;
            int l = 1;
            int j;
            if (expandState == ViewItemBaseFragment.ExpandState.COLLAPSED)
            {
                int k;
                int i1;
                if (j1 <= i)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                i1 = i;
                k = j;
                l = i1;
                if (j == 0)
                {
                    k = j;
                    l = i1;
                    if (j1 <= i + 2)
                    {
                        l = j1;
                        k = 1;
                    }
                }
                j = k1 + populateUpToEnSpecifics(viewgroup, l - k1);
                l = k;
            } else
            {
                j = k1 + populateUpToEnSpecifics(viewgroup, j1);
            }
            if (l == 0)
            {
                k = j;
                if (j >= i)
                {
                    break label0;
                }
            }
            k = j;
            if (showLotSize(viewgroup))
            {
                k = j + 1;
            }
            addCategory(viewgroup);
            showItemId(viewgroup);
            k = k + 1 + 1;
            if (l == 0)
            {
                k = i;
            }
        }
        viewgroup.setVisibility(0);
        return k;
    }

    private int populateUpToEnSpecifics(ViewGroup viewgroup, int i)
    {
        int k = 0;
        int j = 0;
        if (item == null)
        {
            return 0;
        }
        if (i > 0)
        {
            Iterator iterator = item.itemSpecifics.iterator();
            do
            {
                k = j;
                if (!iterator.hasNext())
                {
                    break;
                }
                NameValue namevalue = (NameValue)iterator.next();
                Object obj = new StringBuilder();
                ((StringBuilder) (obj)).append(namevalue.getName());
                String s = ((StringBuilder) (obj)).toString();
                obj = Util.makeCommaDelimitedString(namevalue.getValues());
                k = j;
                if (!TextUtils.isEmpty(s))
                {
                    k = j;
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        k = j;
                        if (!((String) (obj)).equals("-"))
                        {
                            k = j;
                            if (!badSpecifics.contains(namevalue.getName()))
                            {
                                if ("Deposit amount".equals(namevalue.getName()))
                                {
                                    obj = item.depositAmountString;
                                }
                                appendLayout(viewgroup, s, ((String) (obj)));
                                k = j + 1;
                            }
                        }
                    }
                }
                j = k;
            } while (k != i);
        }
        return k;
    }

    private void renderSellerNotes()
    {
        final TextView sellerNotes = getSellerNotesTextView();
        sellerNotes.setText(item.conditionDescription);
        Layout layout = sellerNotes.getLayout();
        if (isCollapsed())
        {
            if (layout != null)
            {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0)
                {
                    sellerNotesRequiresExpansion = true;
                }
            } else
            {
                sellerNotes.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final ViewItemSpecificsFragment this$0;
                    final TextView val$sellerNotes;

                    public void onGlobalLayout()
                    {
                        Layout layout1 = sellerNotes.getLayout();
                        if (layout1 != null)
                        {
                            int i = layout1.getLineCount();
                            if (i > 0 && layout1.getEllipsisCount(i - 1) > 0)
                            {
                                sellerNotesRequiresExpansion = true;
                                render(item, viewData);
                            }
                        }
                        sellerNotes.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }

            
            {
                this$0 = ViewItemSpecificsFragment.this;
                sellerNotes = textview;
                super();
            }
                });
            }
        }
        showSellerNotes(sellerNotes);
    }

    private void setExpansionProperties(int i, int j)
    {
        boolean flag1 = true;
        boolean flag = false;
        setSeeAllVisibility(false);
        if (seeAllDivider != null)
        {
            Object obj = seeAllDivider;
            int k;
            if (false)
            {
                k = 0;
            } else
            {
                k = 8;
            }
            ((View) (obj)).setVisibility(k);
        }
        if (!fullExpansion && (isCollapsed() && (i < j || sellerNotesRequiresExpansion) || isExpanded()))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            showMoreOrLess(null);
        }
        if (!isCollapsed())
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 0;
        }
        obj = dynamicSpecificsLayout;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((ViewGroup) (obj)).setVisibility(i);
    }

    private void setupDealTimer(Context context, ViewGroup viewgroup, Item item)
    {
        Date date = new Date(item.hotnessEndTime);
        item = getTimeLeftLabel(context, item);
        viewgroup.addView(Util.createViewItemStatCountDown(context, inflater, viewgroup, item, date, false));
        timer = new EbayTimer(1000L);
        timer.setOnTimerEvent(this);
        timer.start();
    }

    public static boolean setupEndTime(ViewGroup viewgroup, Item item, Context context, LayoutInflater layoutinflater)
    {
        Date date1;
        boolean flag;
        viewgroup.removeAllViews();
        flag = false;
        date1 = null;
        if (!item.isScheduled) goto _L2; else goto _L1
_L1:
        date1 = item.startDate;
_L4:
        if (date1 != null)
        {
            viewgroup.addView(Util.createViewItemStatCountDown(context, layoutinflater, viewgroup, getTimeLeftLabel(context, item), date1, true));
            flag = true;
        }
        return flag;
_L2:
        Date date;
        if (item.isTransacted)
        {
            date = item.iTransaction.createdDate;
        } else
        {
            date = item.endDate;
        }
        if (date != null)
        {
            date1 = date;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String[] setupQuantityStrings(Context context, Item item, ViewItemViewData viewitemviewdata)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Resources resources;
        int i;
        boolean flag;
        if (context == null || item == null || viewitemviewdata == null)
        {
            throw new IllegalArgumentException();
        }
        resources = context.getResources();
        obj1 = null;
        obj2 = null;
        if (item.isMultiSku)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (item.getQuantityAvailable(viewitemviewdata.nameValueList) > i) goto _L2; else goto _L1
_L1:
        obj = obj2;
        if (item.quantitySold <= 0) goto _L3; else goto _L2
_L2:
        flag = DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_QuantitySold);
        if (item.isHotnessAlmostGone || item.isHotnessLastOne)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            int j;
            if (item.isHotnessAlmostGone)
            {
                j = 0x7f070474;
            } else
            {
                j = 0x7f070477;
            }
            context = resources.getString(j);
        } else
        {
            context = Item.getObfuscatedQuantityAvailable(context, item, viewitemviewdata.kind, viewitemviewdata.nameValueList);
        }
        if (!item.isHotnessQuantitySoldOneHour) goto _L5; else goto _L4
_L4:
        obj = resources.getQuantityString(0x7f080018, item.hotnessQuantityCount.intValue(), new Object[] {
            item.hotnessQuantityCount
        });
        obj1 = context;
_L3:
        return (new String[] {
            obj1, obj
        });
_L5:
        if (item.isHotnessQuantitySoldTwentyFourHours)
        {
            obj = resources.getQuantityString(0x7f080017, item.hotnessQuantityCount.intValue(), new Object[] {
                item.hotnessQuantityCount
            });
            obj1 = context;
        } else
        if (item.isHotnessQuantitySoldTotal)
        {
            obj = resources.getQuantityString(0x7f080019, item.hotnessQuantityCount.intValue(), new Object[] {
                item.hotnessQuantityCount
            });
            obj1 = context;
        } else
        {
            obj = obj2;
            obj1 = context;
            if (item.quantitySold > 0)
            {
                item = resources.getQuantityString(0x7f08001d, item.quantitySold, new Object[] {
                    Integer.valueOf(item.quantitySold)
                });
                if (flag && i == 0)
                {
                    obj = obj2;
                    obj1 = item;
                } else
                {
                    obj = item;
                    obj1 = context;
                }
            }
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    private boolean showEEK()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            if (item.productEnergyEfficiencyRating != null)
            {
                View view = this.view.findViewById(0x7f1008d3);
                flag = flag1;
                if (view != null)
                {
                    TextView textview = (TextView)view.findViewById(0x7f1008d4);
                    if (textview != null)
                    {
                        textview.setText(resources.getString(0x7f070087));
                    }
                    textview = (TextView)view.findViewById(0x7f1008d5);
                    if (textview != null)
                    {
                        textview.setText(item.productEnergyEfficiencyRating.value.decode());
                    }
                    view.setVisibility(0);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean showHotnessCharity(ViewGroup viewgroup)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item.isHotnessCharity)
        {
            flag = flag1;
            if (!TextUtils.isEmpty(item.displayHotnessCharityKeyString))
            {
                flag = flag1;
                if (!TextUtils.isEmpty(item.displayHotnessCharityValueString))
                {
                    appendLayout(viewgroup, item.displayHotnessCharityKeyString, item.displayHotnessCharityValueString);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean showItemId(ViewGroup viewgroup)
    {
        boolean flag = false;
        if (item != null)
        {
            appendLayout(viewgroup, itemIdHeaderName, item.getIdString());
            flag = true;
        }
        return flag;
    }

    private boolean showLotSize(ViewGroup viewgroup)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            if (item.lotSize != null)
            {
                flag = flag1;
                if (item.lotSize.intValue() > 1)
                {
                    appendLayout(viewgroup, getString(0x7f0705fc), String.valueOf(item.lotSize));
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean showQuantity()
    {
        if ((!item.isBopisable || item.iTransaction != null) && (item.isListingTypeBin || item.isBidWithBin)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        TextView textview;
        boolean flag1;
        getResources();
        obj = null;
        textview = null;
        flag1 = false;
        if (!item.isTransacted) goto _L4; else goto _L3
_L3:
        Object obj1;
        boolean flag;
        obj1 = textview;
        flag = flag1;
        if (item.iTransaction.quantityPurchased > 1)
        {
            obj = Integer.toString(item.iTransaction.quantityPurchased);
            flag = flag1;
            obj1 = textview;
        }
_L5:
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            textview = (TextView)view.findViewById(0x7f1008d1);
            textview.setText(((CharSequence) (obj)));
            if (flag)
            {
                textview.setTextColor(getResources().getColor(0x7f0d0064));
            }
            view.findViewById(0x7f10030e).setVisibility(0);
            if (obj1 != null)
            {
                obj = (TextView)view.findViewById(0x7f1008d2);
                ((TextView) (obj)).setText(((CharSequence) (obj1)));
                int i;
                if (false)
                {
                    i = getResources().getColor(0x7f0d0064);
                } else
                {
                    i = secondaryColor;
                }
                ((TextView) (obj)).setTextColor(i);
                ((TextView) (obj)).setVisibility(0);
            }
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj1 = textview;
        flag = flag1;
        if (!item.isAuctionEnded)
        {
            obj1 = setupQuantityStrings(getActivity(), item, viewData);
            obj = obj1[0];
            obj1 = obj1[1];
            flag = isQuantityDisplayStringInRed(item);
        }
          goto _L5
    }

    private void showSellerNotes(TextView textview)
    {
        view.findViewById(0x7f1008ce).setVisibility(8);
        view.findViewById(0x7f1008cf).setVisibility(8);
        view.findViewById(0x7f1008cd).setVisibility(0);
        textview.setVisibility(0);
    }

    public void OnTimer()
    {
        while (getActivity() == null || getActivity().isFinishing() || item.hotnessEndTime <= 0L || EbayResponse.currentHostTime() <= item.hotnessEndTime) 
        {
            return;
        }
        if (timer != null)
        {
            timer.stop();
            timer = null;
        }
        activityRefreshListener.reloadItemFromNetwork(null);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        categoryLabel = bundle.getString(0x7f070216);
        itemIdHeaderName = getString(0x7f070494);
        textColorBlue = ThemeUtil.resolveThemeColorStateList(resources, bundle.getTheme(), 0x1010212);
        if (seeAllTextView != null)
        {
            seeAllTextView.setText(0x7f070ba3);
        }
        bundle = bundle.getTheme();
        secondaryColor = resources.getColor(ThemeUtil.resolveThemeSecondaryColorResId(bundle, 0x1010038));
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            super.onClick(view);
            return;

        case 2131756220: 
            seeAllClicked();
            break;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f030295, viewgroup, false);
        timeLeftLayout = view.findViewById(0x7f100893);
        dynamicSpecificsLayout = (ViewGroup)view.findViewById(0x7f1008d7);
        collapsedLayout = (ViewGroup)view.findViewById(0x7f1008d6);
        setupFragment(view);
        return view;
    }

    public void onPause()
    {
        if (timer != null)
        {
            timer.stop();
        }
        super.onPause();
    }

    public void onResume()
    {
        if (timer != null)
        {
            timer.start();
        }
        super.onResume();
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        super.render(item, viewitemviewdata, expandstate);
        int i = getItemSpecificsCount();
        static class _cls3
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState = new int[ViewItemBaseFragment.ExpandState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[ViewItemBaseFragment.ExpandState.COLLAPSED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[ViewItemBaseFragment.ExpandState.EXPANDED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ExpandState[expandstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            setExpansionProperties(populateLayout(collapsedSize, collapsedLayout), i);
            return;

        case 2: // '\002'
            setExpansionProperties(populateLayout(expandedSize, dynamicSpecificsLayout), i);
            break;
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("VIN Number");
        arraylist.add("Reg. Mark");
        arraylist.add("Category");
        arraylist.add("Title");
        arraylist.add("SubTitle");
        arraylist.add("Deposit type");
        arraylist.add("Condition");
        badSpecifics = Collections.unmodifiableList(arraylist);
    }


/*
    static boolean access$002(ViewItemSpecificsFragment viewitemspecificsfragment, boolean flag)
    {
        viewitemspecificsfragment.sellerNotesRequiresExpansion = flag;
        return flag;
    }

*/
}
