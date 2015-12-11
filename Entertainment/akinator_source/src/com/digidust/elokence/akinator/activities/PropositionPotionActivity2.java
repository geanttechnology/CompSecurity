// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.views.DarkAutoButton;
import com.elokence.limuleapi.TraductionFactory;
import java.text.NumberFormat;
import java.util.Objects;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PopPedagogiqueActivity

public class PropositionPotionActivity2 extends AkActivity
{

    public static final int potionAchat = 1;
    public static final String potionKey = "potion";
    public static final String potionRayonnante = "rayonnante";
    public static final int potionRefusee = 0;
    public static final String potionSurvitamine = "survitamine";
    public static final String potionUltime = "ultime";
    private android.view.View.OnClickListener mBoutonNonMerciListener;
    android.view.View.OnClickListener mItemPotionClickListener;
    Button uiButtonAllTheTimeGz;
    private Button uiButtonNonMerci;
    private Button uiButtonPotion;
    private Button uiButtonPotionUltime;
    private ImageView uiImagePotion;
    private TextView uiOr;
    private TextView uiTextPotion;
    private TextView uiTextPotionUltimeDesc;
    private TextView uiTextPotionUltimeEncoreMieux;
    private TextView uiTextPotionUltimeTitre;

    public PropositionPotionActivity2()
    {
        mItemPotionClickListener = new android.view.View.OnClickListener() {

            final PropositionPotionActivity2 this$0;

            private void showPopPedagogiqueActivity()
            {
                disableAdOneTime();
                Intent intent = new Intent(PropositionPotionActivity2.this, com/digidust/elokence/akinator/activities/PopPedagogiqueActivity);
                intent.putExtra("PostPedagogiqueActivityModeGz", true);
                startActivity(intent);
            }

            public void onClick(View view)
            {
                String s = getIntent().getStringExtra("potion");
                if (view != uiButtonPotion) goto _L2; else goto _L1
_L1:
                if (s == null) goto _L4; else goto _L3
_L3:
                if (!s.equals("rayonnante")) goto _L6; else goto _L5
_L5:
                disableAdOneTime();
                AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappNoads());
                AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappNoads(), PropositionPotionActivity2.this);
_L4:
                return;
_L6:
                if (s.equals("survitamine"))
                {
                    disableAdOneTime();
                    AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappPopu());
                    AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappPopu(), PropositionPotionActivity2.this);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (view == uiButtonPotionUltime)
                {
                    disableAdOneTime();
                    AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappUltime());
                    AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappUltime(), PropositionPotionActivity2.this);
                    return;
                }
                if (view == uiButtonAllTheTimeGz)
                {
                    if (AkPlayerBelongingsFactory.sharedInstance().withdrawGeniz(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularityAllTimeCost()))
                    {
                        if (s.equals("survitamine"))
                        {
                            AkGameFactory.sharedInstance().setPopularityState(false);
                        }
                        setResult(1);
                        finish();
                        return;
                    } else
                    {
                        showPopPedagogiqueActivity();
                        return;
                    }
                }
                if (true) goto _L4; else goto _L7
_L7:
            }

            
            {
                this$0 = PropositionPotionActivity2.this;
                super();
            }
        };
        mBoutonNonMerciListener = new android.view.View.OnClickListener() {

            final PropositionPotionActivity2 this$0;

            public void onClick(View view)
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = PropositionPotionActivity2.this;
                super();
            }
        };
    }

    private void HidePotion()
    {
        uiButtonPotion.setBackgroundResource(0x7f0200e9);
        uiButtonAllTheTimeGz.setBackgroundResource(0x7f0200ed);
        uiButtonAllTheTimeGz.setEnabled(false);
        uiButtonPotion.setEnabled(false);
    }

    public void itemPurchased(String s)
    {
        updateUI();
        if (Objects.equals(s, AkInappManager.getInstance().getSkuInappPopu()) || Objects.equals(s, AkInappManager.getInstance().getSkuInappUltime()))
        {
            setResult(1);
            finish();
        }
    }

    public void onBackPressed()
    {
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002f);
        uiOr = (TextView)findViewById(0x7f0d018b);
        uiImagePotion = (ImageView)findViewById(0x7f0d0188);
        uiTextPotion = (TextView)findViewById(0x7f0d0189);
        uiTextPotionUltimeEncoreMieux = (TextView)findViewById(0x7f0d0190);
        uiTextPotionUltimeTitre = (TextView)findViewById(0x7f0d0192);
        uiTextPotionUltimeDesc = (TextView)findViewById(0x7f0d0194);
        uiButtonNonMerci = (Button)findViewById(0x7f0d0195);
        uiButtonPotion = (DarkAutoButton)findViewById(0x7f0d018c);
        uiButtonPotionUltime = (DarkAutoButton)findViewById(0x7f0d0193);
        uiButtonPotion.setOnClickListener(mItemPotionClickListener);
        uiButtonPotionUltime.setOnClickListener(mItemPotionClickListener);
        uiButtonAllTheTimeGz = (Button)findViewById(0x7f0d018a);
        uiButtonAllTheTimeGz.setOnClickListener(mItemPotionClickListener);
        uiButtonNonMerci.setTypeface(tf);
        uiOr.setTypeface(tf);
        uiTextPotion.setTypeface(tf);
        uiTextPotionUltimeEncoreMieux.setTypeface(tf, 1);
        uiTextPotionUltimeTitre.setTypeface(tf, 1);
        uiTextPotionUltimeDesc.setTypeface(tf);
        uiButtonAllTheTimeGz.setTypeface(tf);
        uiButtonAllTheTimeGz.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularityAllTimeCost()));
        bundle = getIntent().getStringExtra("potion");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (!bundle.equals("rayonnante")) goto _L4; else goto _L3
_L3:
        uiImagePotion.setImageDrawable(getResources().getDrawable(0x7f02015f));
        uiTextPotion.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_ALERTE_FREEMIUM_PAS_DE_PUB"));
_L2:
        uiOr.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OU"));
        uiButtonNonMerci.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"));
        uiButtonNonMerci.setOnClickListener(mBoutonNonMerciListener);
        uiTextPotionUltimeEncoreMieux.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_ANDROID_MISE_EN_AVANT_POTION_ULTIME"));
        updateUI();
        addTextView(uiOr);
        addTextView(uiTextPotion);
        addTextView(uiTextPotionUltimeEncoreMieux);
        addTextView(uiTextPotionUltimeTitre);
        addTextView(uiTextPotionUltimeDesc);
        updateTextViewsSize();
        return;
_L4:
        if (bundle.equals("survitamine"))
        {
            uiImagePotion.setImageDrawable(getResources().getDrawable(0x7f02015b));
            uiTextPotion.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISI_POTION_PAYE_UNE_FOIS_USAGE_ILLIMITE "));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestInappDetailsUpdate();
        AkInappManager.getInstance().requestAllPurchases();
    }

    public void onResume()
    {
        super.onResume();
        if (!AkInappManager.getInstance().isInit())
        {
            AkInappManager.getInstance().init();
        } else
        {
            AkInappManager.getInstance().requestAllPurchases();
        }
        updateUI();
        if (!AkGameFactory.sharedInstance().isPopularityLimited() || AkGameFactory.sharedInstance().isUnlocked())
        {
            setResult(1);
            finish();
        }
    }

    public void skuDetailsUpdated()
    {
        updateUI();
    }

    public void updateUI()
    {
        runOnUiThread(new Runnable() {

            final PropositionPotionActivity2 this$0;

            public void run()
            {
                String s;
                uiTextPotionUltimeTitre.setText(AkInappManager.getInstance().getNomInappUltime());
                uiTextPotionUltimeDesc.setText(AkInappManager.getInstance().getDescInappUltime());
                uiButtonPotionUltime.setText(AkInappManager.getInstance().getPriceInappUltime());
                s = getIntent().getStringExtra("potion");
                if (s == null) goto _L2; else goto _L1
_L1:
                if (!s.equals("rayonnante")) goto _L4; else goto _L3
_L3:
                uiButtonPotion.setText(AkInappManager.getInstance().getPriceInappNoads());
                uiTextPotion.setText(AkInappManager.getInstance().getDescInappNoads());
_L2:
                uiTextPotionUltimeTitre.setText(AkInappManager.getInstance().getNomInappUltime());
                uiTextPotionUltimeDesc.setText(AkInappManager.getInstance().getDescInappUltime());
                if (!AkGameFactory.sharedInstance().isPopularityLimited())
                {
                    HidePotion();
                }
                if (AkGameFactory.sharedInstance().isUnlocked())
                {
                    uiButtonPotionUltime.setBackgroundResource(0x7f0200e9);
                    uiButtonPotionUltime.setEnabled(false);
                    HidePotion();
                }
                return;
_L4:
                if (s.equals("survitamine"))
                {
                    uiButtonPotion.setText(AkInappManager.getInstance().getPriceInappPopu());
                    uiTextPotion.setText(AkInappManager.getInstance().getDescInappPopu());
                }
                if (true) goto _L2; else goto _L5
_L5:
            }

            
            {
                this$0 = PropositionPotionActivity2.this;
                super();
            }
        });
    }






}
