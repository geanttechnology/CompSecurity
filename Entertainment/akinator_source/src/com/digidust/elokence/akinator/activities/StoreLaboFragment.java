// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappListener;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.views.DarkAutoButton;
import com.elokence.limuleapi.TraductionFactory;
import java.text.NumberFormat;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            StoreCommonElementsFragment, StoreActivity

public class StoreLaboFragment extends StoreCommonElementsFragment
    implements AkInappListener
{

    StoreActivity activityMaster;
    android.view.View.OnClickListener itemPotionClickListener;
    boolean onCreation;
    Button uiButton2hGz;
    Button uiButtonAllTheTimeGz;
    Button uiButtonPotionPopularity;
    Button uiButtonPotionUltime;
    ImageView uiImageHome;
    private TextView uiText2Hours;
    private TextView uiTextAllTheTime;
    TextView uiTextDescPotionPopularity;
    TextView uiTextDescPotionUltime;
    TextView uiTextNomPotionPopularity;
    TextView uiTextNomPotionUltime;
    private TextView uiTextOr;

    public StoreLaboFragment()
    {
        itemPotionClickListener = new _cls1();
    }

    private void HidePopu()
    {
        uiButtonPotionPopularity.setBackgroundResource(0x7f0200e9);
        uiButton2hGz.setBackgroundResource(0x7f0200ed);
        uiButtonAllTheTimeGz.setBackgroundResource(0x7f0200ed);
        uiButton2hGz.setEnabled(false);
        uiButtonAllTheTimeGz.setEnabled(false);
        uiButtonPotionPopularity.setEnabled(false);
    }

    public void itemPurchased(String s)
    {
        if ((s.equals(AkInappManager.getInstance().getSkuInappUltime()) || s.equals(AkInappManager.getInstance().getSkuInappPopu())) && AkConfigFactory.sharedInstance().canPlay() == 0 && AkConfigFactory.sharedInstance().canCheckFull())
        {
            s = new android.app.AlertDialog.Builder(activityMaster);
            s.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_FULL_ACHETE"));
            _cls3 _lcls3 = new _cls3();
            s.setCancelable(false);
            s.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), _lcls3);
            s.create().show();
        }
        updateUI();
    }

    public void onAllPurchasesRestored()
    {
        activityMaster.onAllPurchasesRestored();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030055, viewgroup, false);
        initCommonShopElements(layoutinflater);
        activityMaster = (StoreActivity)getActivity();
        uiTextAllTheTime = (TextView)layoutinflater.findViewById(0x7f0d00eb);
        uiTextOr = (TextView)layoutinflater.findViewById(0x7f0d018b);
        uiText2Hours = (TextView)layoutinflater.findViewById(0x7f0d00e9);
        onCreation = true;
        uiImageHome = (ImageView)layoutinflater.findViewById(0x7f0d028b);
        uiTextNomPotionPopularity = (TextView)layoutinflater.findViewById(0x7f0d0254);
        uiTextDescPotionPopularity = (TextView)layoutinflater.findViewById(0x7f0d0255);
        uiButtonPotionPopularity = (DarkAutoButton)layoutinflater.findViewById(0x7f0d018c);
        uiTextNomPotionUltime = (TextView)layoutinflater.findViewById(0x7f0d024f);
        uiTextDescPotionUltime = (TextView)layoutinflater.findViewById(0x7f0d0250);
        uiButtonPotionUltime = (DarkAutoButton)layoutinflater.findViewById(0x7f0d0251);
        uiButtonAllTheTimeGz = (Button)layoutinflater.findViewById(0x7f0d018a);
        uiButton2hGz = (Button)layoutinflater.findViewById(0x7f0d00ea);
        uiButtonPotionPopularity.setOnClickListener(itemPotionClickListener);
        uiButtonPotionUltime.setOnClickListener(itemPotionClickListener);
        uiButton2hGz.setOnClickListener(itemPotionClickListener);
        uiButtonAllTheTimeGz.setOnClickListener(itemPotionClickListener);
        uiButtonPotionUltime.setTypeface(tf);
        uiButtonPotionPopularity.setTypeface(tf);
        uiTextAllTheTime.setTypeface(tf);
        uiTextOr.setTypeface(tf);
        uiText2Hours.setTypeface(tf);
        uiTextDescPotionPopularity.setTypeface(tf);
        uiTextDescPotionUltime.setTypeface(tf);
        uiTextNomPotionPopularity.setTypeface(tf);
        uiTextNomPotionUltime.setTypeface(tf);
        uiButtonAllTheTimeGz.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularityAllTimeCost()));
        uiButton2hGz.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularity2HoursCost()));
        uiTextAllTheTime.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_DEBLOQUE_TOUT_LE_TEMPS"));
        uiTextOr.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OU"));
        uiText2Hours.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_DEBLOQUE_2H"));
        uiButtonAllTheTimeGz.setTypeface(tf);
        uiButton2hGz.setTypeface(tf);
        activityMaster.addTextView(uiTextNomPotionPopularity);
        activityMaster.addTextView(uiTextNomPotionUltime);
        activityMaster.addTextView(uiTextDescPotionPopularity);
        activityMaster.addTextView(uiTextDescPotionUltime);
        activityMaster.addTextView(uiTextAllTheTime);
        activityMaster.addTextView(uiTextOr);
        activityMaster.addTextView(uiText2Hours);
        activityMaster.updateTextViewsSize();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
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
        } else
        {
            AkInappManager.getInstance().requestAllPurchases();
        }
        updateUI();
        if (AkConfigFactory.sharedInstance().canPlay() == 0 && !AkConfigFactory.sharedInstance().isPrio())
        {
            AkConfigFactory.sharedInstance().setCanCheckFull(true);
        }
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
