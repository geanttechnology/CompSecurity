// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappListener;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.views.DarkAutoButton;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            StoreCommonElementsFragment, StoreActivity

public class StoreGzFragment extends StoreCommonElementsFragment
    implements AkInappListener
{

    private StoreActivity activityMaster;
    android.view.View.OnClickListener itemGzClickListener;
    private Button uiButtonBuyGz1;
    private Button uiButtonBuyGz2;
    private Button uiButtonBuyGz3;
    private Button uiButtonBuyGz4;
    private Button uiButtonBuyGz5;
    private TextView uiTextGz1;
    private TextView uiTextGz2;
    private TextView uiTextGz3;
    private TextView uiTextGz4;
    private TextView uiTextGz5;

    public StoreGzFragment()
    {
        itemGzClickListener = new _cls1();
    }

    public void closeWithError()
    {
        activityMaster.runOnUiThread(new _cls2());
    }

    public void itemPurchased(String s)
    {
    }

    public void onAllPurchasesRestored()
    {
        activityMaster.onAllPurchasesRestored();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030053, viewgroup, false);
        initCommonShopElements(layoutinflater);
        activityMaster = (StoreActivity)getActivity();
        uiTextGz1 = (TextView)layoutinflater.findViewById(0x7f0d0291);
        uiTextGz1.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        uiTextGz2 = (TextView)layoutinflater.findViewById(0x7f0d0293);
        uiTextGz2.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        uiTextGz3 = (TextView)layoutinflater.findViewById(0x7f0d0295);
        uiTextGz3.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        uiTextGz4 = (TextView)layoutinflater.findViewById(0x7f0d0297);
        uiTextGz4.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        uiTextGz5 = (TextView)layoutinflater.findViewById(0x7f0d0299);
        uiTextGz5.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        uiButtonBuyGz1 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0292);
        uiButtonBuyGz2 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0294);
        uiButtonBuyGz3 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0296);
        uiButtonBuyGz4 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0298);
        uiButtonBuyGz5 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d029a);
        uiTextAccepteCGV.setTextColor(activityMaster.getResources().getColor(0x7f0c008b));
        updateUI();
        uiTextGz1.setTypeface(tf);
        uiButtonBuyGz1.setTypeface(tf);
        uiTextGz2.setTypeface(tf);
        uiButtonBuyGz2.setTypeface(tf);
        uiTextGz3.setTypeface(tf);
        uiButtonBuyGz3.setTypeface(tf);
        uiTextGz4.setTypeface(tf);
        uiButtonBuyGz4.setTypeface(tf);
        uiTextGz5.setTypeface(tf);
        uiButtonBuyGz5.setTypeface(tf);
        activityMaster.addTextView(uiTextGz1);
        activityMaster.addTextView(uiTextGz2);
        activityMaster.addTextView(uiTextGz3);
        activityMaster.addTextView(uiTextGz4);
        activityMaster.addTextView(uiTextGz5);
        activityMaster.updateTextViewsSize();
        uiButtonBuyGz1.setOnClickListener(itemGzClickListener);
        uiButtonBuyGz2.setOnClickListener(itemGzClickListener);
        uiButtonBuyGz3.setOnClickListener(itemGzClickListener);
        uiButtonBuyGz4.setOnClickListener(itemGzClickListener);
        uiButtonBuyGz5.setOnClickListener(itemGzClickListener);
        return layoutinflater;
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestInappDetailsUpdate();
        AkInappManager.getInstance().requestAllPurchases();
    }

    public void onPause()
    {
        AkInappManager.getInstance().removeListener(this);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        AkInappManager.getInstance().addListener(this);
        if (!AkInappManager.getInstance().isInit())
        {
            AkInappManager.getInstance().init();
        }
    }

    public void skuDetailsUpdated()
    {
        updateUI();
    }

    public void updateUI()
    {
        activityMaster.runOnUiThread(new _cls3());
    }












    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
