// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappListener;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.views.DarkAutoButton;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            StoreCommonElementsFragment, StoreActivity

public class StoreFacesFragment extends StoreCommonElementsFragment
    implements AkInappListener
{

    private StoreActivity activityMaster;
    boolean affichePrixMyWorld;
    android.view.View.OnClickListener itemFaceClickListener;
    boolean onCreation;
    int selectedSkuIndex[];
    Button uiButtonPriceFaces1;
    Button uiButtonPriceFaces2;
    Button uiButtonPriceFaces3;
    Button uiButtonPriceFaces4;
    Button uiButtonPriceFaces5;
    LinearLayout uiItemFaces1;
    LinearLayout uiItemFaces2;
    LinearLayout uiItemFaces3;
    LinearLayout uiItemFaces4;
    LinearLayout uiItemFaces5;
    View uiLine1;
    View uiLine2;
    View uiLine3;
    View uiLine4;
    View uiLine5;
    TextView uiTextDescPackFaces1;
    TextView uiTextDescPackFaces2;
    TextView uiTextDescPackFaces3;
    TextView uiTextDescPackFaces4;
    TextView uiTextDescPackFaces5;
    TextView uiTextNomPackFaces1;
    TextView uiTextNomPackFaces2;
    TextView uiTextNomPackFaces3;
    TextView uiTextNomPackFaces4;
    TextView uiTextNomPackFaces5;

    public StoreFacesFragment()
    {
        affichePrixMyWorld = true;
        itemFaceClickListener = new _cls1();
    }

    public void closeWithError()
    {
        activityMaster.runOnUiThread(new _cls3());
    }

    public void itemPurchased(String s)
    {
        updateUI();
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
        layoutinflater = layoutinflater.inflate(0x7f030052, viewgroup, false);
        initCommonShopElements(layoutinflater);
        activityMaster = (StoreActivity)getActivity();
        onCreation = true;
        uiTextNomPackFaces1 = (TextView)layoutinflater.findViewById(0x7f0d0223);
        uiTextDescPackFaces1 = (TextView)layoutinflater.findViewById(0x7f0d0224);
        uiButtonPriceFaces1 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0225);
        uiItemFaces1 = (LinearLayout)layoutinflater.findViewById(0x7f0d0222);
        uiLine1 = layoutinflater.findViewById(0x7f0d0226);
        uiTextNomPackFaces2 = (TextView)layoutinflater.findViewById(0x7f0d0228);
        uiTextDescPackFaces2 = (TextView)layoutinflater.findViewById(0x7f0d0229);
        uiButtonPriceFaces2 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d022a);
        uiItemFaces2 = (LinearLayout)layoutinflater.findViewById(0x7f0d0227);
        uiLine2 = layoutinflater.findViewById(0x7f0d022b);
        uiTextNomPackFaces3 = (TextView)layoutinflater.findViewById(0x7f0d022d);
        uiTextDescPackFaces3 = (TextView)layoutinflater.findViewById(0x7f0d022e);
        uiButtonPriceFaces3 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d022f);
        uiItemFaces3 = (LinearLayout)layoutinflater.findViewById(0x7f0d022c);
        uiLine3 = layoutinflater.findViewById(0x7f0d0230);
        uiTextNomPackFaces4 = (TextView)layoutinflater.findViewById(0x7f0d0232);
        uiTextDescPackFaces4 = (TextView)layoutinflater.findViewById(0x7f0d0233);
        uiButtonPriceFaces4 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0234);
        uiItemFaces4 = (LinearLayout)layoutinflater.findViewById(0x7f0d0231);
        uiLine4 = layoutinflater.findViewById(0x7f0d0235);
        uiTextNomPackFaces5 = (TextView)layoutinflater.findViewById(0x7f0d0237);
        uiTextDescPackFaces5 = (TextView)layoutinflater.findViewById(0x7f0d0238);
        uiButtonPriceFaces5 = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0239);
        uiItemFaces5 = (LinearLayout)layoutinflater.findViewById(0x7f0d0236);
        uiLine5 = layoutinflater.findViewById(0x7f0d023a);
        uiButtonPriceFaces1.setOnClickListener(itemFaceClickListener);
        uiButtonPriceFaces2.setOnClickListener(itemFaceClickListener);
        uiButtonPriceFaces3.setOnClickListener(itemFaceClickListener);
        uiButtonPriceFaces4.setOnClickListener(itemFaceClickListener);
        uiButtonPriceFaces5.setOnClickListener(itemFaceClickListener);
        uiTextAccepteCGV.setTextColor(activityMaster.getResources().getColor(0x7f0c008a));
        uiTextDescPackFaces1.setTypeface(tf);
        uiTextDescPackFaces2.setTypeface(tf);
        uiTextDescPackFaces3.setTypeface(tf);
        uiTextDescPackFaces4.setTypeface(tf);
        uiTextDescPackFaces5.setTypeface(tf);
        uiTextNomPackFaces1.setTypeface(tf);
        uiTextNomPackFaces2.setTypeface(tf);
        uiTextNomPackFaces3.setTypeface(tf);
        uiTextNomPackFaces4.setTypeface(tf);
        uiTextNomPackFaces5.setTypeface(tf);
        uiButtonPriceFaces1.setTypeface(tf);
        uiButtonPriceFaces2.setTypeface(tf);
        uiButtonPriceFaces3.setTypeface(tf);
        uiButtonPriceFaces4.setTypeface(tf);
        uiButtonPriceFaces5.setTypeface(tf);
        activityMaster.addTextView(uiButtonPriceFaces1);
        activityMaster.addTextView(uiButtonPriceFaces2);
        activityMaster.addTextView(uiButtonPriceFaces3);
        activityMaster.addTextView(uiButtonPriceFaces4);
        activityMaster.addTextView(uiButtonPriceFaces5);
        activityMaster.addTextView(uiTextDescPackFaces1);
        activityMaster.addTextView(uiTextDescPackFaces2);
        activityMaster.addTextView(uiTextDescPackFaces3);
        activityMaster.addTextView(uiTextDescPackFaces4);
        activityMaster.addTextView(uiTextDescPackFaces5);
        activityMaster.addTextView(uiTextNomPackFaces1);
        activityMaster.addTextView(uiTextNomPackFaces2);
        activityMaster.addTextView(uiTextNomPackFaces3);
        activityMaster.addTextView(uiTextNomPackFaces4);
        activityMaster.addTextView(uiTextNomPackFaces5);
        activityMaster.updateTextViewsSize();
        viewgroup = AkConfigFactory.sharedInstance().getSelectedInapps();
        selectedSkuIndex = new int[viewgroup.size()];
        int i = 0;
label0:
        do
        {
            if (i < viewgroup.size())
            {
                int k = Integer.parseInt((String)((Pair)viewgroup.get(i)).first);
                int j = 0;
                do
                {
label1:
                    {
                        if (j < AkInappManager.getInstance().getListIdInappFaces().length)
                        {
                            if (AkInappManager.getInstance().getListIdInappFaces()[j] != k)
                            {
                                break label1;
                            }
                            selectedSkuIndex[i] = j;
                        }
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            return layoutinflater;
        } while (true);
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
        updateUI();
        onCreation = false;
    }

    public void skuDetailsUpdated()
    {
        updateUI();
    }

    public void updateUI()
    {
        activityMaster.runOnUiThread(new _cls2());
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}

}
