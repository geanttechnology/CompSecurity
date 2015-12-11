// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.viewitem.fragments.MultiSkuCallback;
import com.ebay.mobile.viewitem.fragments.ViewItemChooseVariationsFragment;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemViewData, ViewItemDataManager

public class ViewItemChooseVariationsActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener, MultiSkuCallback
{
    public static final class IntendedAction extends Enum
    {

        private static final IntendedAction $VALUES[];
        public static final IntendedAction ADD_TO_CART;
        public static final IntendedAction BIN;
        public static final IntendedAction SPR;
        public static final IntendedAction WATCH;
        public int value;

        public static IntendedAction valueOf(String s)
        {
            return (IntendedAction)Enum.valueOf(com/ebay/mobile/viewitem/ViewItemChooseVariationsActivity$IntendedAction, s);
        }

        public static IntendedAction[] values()
        {
            return (IntendedAction[])$VALUES.clone();
        }

        static 
        {
            BIN = new IntendedAction("BIN", 0, 3);
            ADD_TO_CART = new IntendedAction("ADD_TO_CART", 1, 9);
            WATCH = new IntendedAction("WATCH", 2, 2);
            SPR = new IntendedAction("SPR", 3, 4);
            $VALUES = (new IntendedAction[] {
                BIN, ADD_TO_CART, WATCH, SPR
            });
        }

        private IntendedAction(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    public static final String PARAM_INTENDED_ACTION = "intended_action";
    private View button;
    private LayoutInflater inflater;
    private IntendedAction intendedAction;
    private LinearLayout priceLayout;
    private ViewItemChooseVariationsFragment variationsFragment;

    public ViewItemChooseVariationsActivity()
    {
    }

    private void createUI()
    {
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction[];
            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction = new int[IntendedAction.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction[IntendedAction.BIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction[IntendedAction.WATCH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction[IntendedAction.ADD_TO_CART.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemChooseVariationsActivity$IntendedAction[IntendedAction.SPR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemChooseVariationsActivity.IntendedAction[intendedAction.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 134
    //                   2 147
    //                   3 160
    //                   4 173;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        button.setOnClickListener(this);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        variationsFragment = new ViewItemChooseVariationsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("full_expansion", true);
        variationsFragment.setArguments(bundle);
        variationsFragment.setGalleryPager(imageViewPager);
        fragmenttransaction.replace(0x7f100355, variationsFragment);
        fragmenttransaction.commit();
        return;
_L2:
        button = findViewById(0x7f10089e);
        continue; /* Loop/switch isn't completed */
_L3:
        button = findViewById(0x7f100899);
        continue; /* Loop/switch isn't completed */
_L4:
        button = findViewById(0x7f1007c8);
        continue; /* Loop/switch isn't completed */
_L5:
        button = findViewById(0x7f100815);
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void render()
    {
        headerStart(0x7f03012c);
        variationsFragment.render(item, viewData);
        renderPrice();
    }

    private void renderPrice()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100898);
        viewgroup.removeAllViews();
        if (priceLayout == null)
        {
            priceLayout = (LinearLayout)inflater.inflate(0x7f03028c, viewgroup, false);
        }
        if (item.hasMultiSkuValues(viewData.nameValueList))
        {
            updatePrice();
            viewgroup.setVisibility(0);
            viewgroup.addView(priceLayout);
        }
        setButtonVisibility();
    }

    private void setButtonVisibility()
    {
        int j = button.getVisibility();
        int i;
        if (item.hasMultiSkuValues(viewData.nameValueList))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        findViewById(0x7f1002fa).setVisibility(i);
        if (j != i)
        {
            View view = button;
            int k;
            if (i == 0)
            {
                k = 0x7f040016;
            } else
            {
                k = 0x7f040015;
            }
            view.setAnimation(AnimationUtils.loadAnimation(this, k));
            button.setVisibility(i);
        }
    }

    private void setMSKUPriceLayout(Context context, ViewGroup viewgroup, Item item, ViewItemViewData viewitemviewdata)
    {
        TextView textview = (TextView)viewgroup.findViewById(0x7f1002ef);
        if (item.needsToSelectMultiSku(viewitemviewdata.nameValueList))
        {
            if (item.isDisplayPriceCurrencyCode)
            {
                viewitemviewdata = item.displayPriceConverted;
            } else
            {
                viewitemviewdata = item.displayPrice;
            }
        } else
        {
            viewitemviewdata = EbayCurrencyUtil.formatDisplay(item.currentPriceForType(getEbayContext(), viewitemviewdata, item.isDisplayPriceCurrencyCode), item.getCurrencyUtilFlag());
        }
        textview.setText(viewitemviewdata);
        textview.setTextColor(context.getResources().getColor(item.displayPriceColor));
        context = (TextView)viewgroup.findViewById(0x7f1002f1);
        if (!TextUtils.isEmpty(item.displayPriceShipping))
        {
            context.setText(item.displayPriceShipping);
            context.setVisibility(0);
            return;
        } else
        {
            context.setVisibility(8);
            return;
        }
    }

    public static void startActivity(Activity activity, ViewItemViewData viewitemviewdata, IntendedAction intendedaction)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ViewItemChooseVariationsActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        intent.putExtra("intended_action", intendedaction.name());
        activity.startActivityForResult(intent, intendedaction.value);
    }

    private void updatePrice()
    {
        setMSKUPriceLayout(this, priceLayout, item, viewData);
    }

    public String getTrackingEventName()
    {
        return "SelectMskuOptions";
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757000: 
        case 2131757077: 
        case 2131757209: 
        case 2131757214: 
            view = new Intent();
            break;
        }
        view.putExtra("view_item_view_data", viewData);
        view.putExtra("paramQty", variationsFragment.getSelectedQuantity());
        setResult(-1, view);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030150);
        setTitle(getString(0x7f070740));
        Intent intent = getIntent();
        intendedAction = IntendedAction.valueOf(intent.getStringExtra("intended_action"));
        if (bundle != null)
        {
            viewData = (ViewItemViewData)bundle.getParcelable("view_item_view_data");
        } else
        {
            viewData = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
        }
        createUI();
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (!content.getStatus().hasError())
        {
            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                break;
            }
            if (viewData.nameValueList == null || viewData.nameValueList.isEmpty())
            {
                viewData.nameValueList = new ArrayList();
                for (viewitemdatamanager = ((Variation)item.variations.get(0)).getNameValueList().iterator(); viewitemdatamanager.hasNext(); viewData.nameValueList.add(new NameValue(content.getName(), "")))
                {
                    content = (NameValue)viewitemdatamanager.next();
                }

            }
            render();
            return;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        ((ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this)).loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null || content.getData() == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onResume()
    {
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("view_item_view_data", viewData);
    }

    public void onVariationsSelected(ViewItemViewData viewitemviewdata)
    {
        renderPrice();
        headerInnards((ViewGroup)findViewById(0x7f1002ec), false);
    }
}
