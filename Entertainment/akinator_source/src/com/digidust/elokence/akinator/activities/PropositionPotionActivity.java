// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

public class PropositionPotionActivity extends AkActivity
{

    public static final int potionAchat = 1;
    public static final String potionKey = "potion";
    public static final String potionRayonnante = "rayonnante";
    public static final int potionRefusee = 0;
    public static final String potionSurvitamine = "survitamine";
    public static final String potionUltime = "ultime";
    PropositionPotionActivity activity;
    private android.view.View.OnClickListener mAcheterListener;
    private android.view.View.OnClickListener mBoutonNonMerciListener;
    private Button uiButtonAcheter;
    private Button uiButtonNonMerci;
    private ImageView uiPotionDansOverlayQuestion;
    private TextView uiTexteOverlayDesc;

    public PropositionPotionActivity()
    {
        mAcheterListener = new android.view.View.OnClickListener() {

            final PropositionPotionActivity this$0;

            public void onClick(View view)
            {
                if (!AkInappManager.getInstance().isInit())
                {
                    break MISSING_BLOCK_LABEL_137;
                }
                view = getIntent().getStringExtra("potion");
                if (view == null) goto _L2; else goto _L1
_L1:
                if (!view.equals("rayonnante")) goto _L4; else goto _L3
_L3:
                disableAdOneTime();
                AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappNoads(), activity);
_L2:
                return;
_L4:
                if (view.equals("survitamine"))
                {
                    disableAdOneTime();
                    AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappPopu(), activity);
                    return;
                }
                if (!view.equals("ultime")) goto _L2; else goto _L5
_L5:
                disableAdOneTime();
                AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappUltime(), activity);
                return;
                Toast.makeText(activity, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                return;
            }

            
            {
                this$0 = PropositionPotionActivity.this;
                super();
            }
        };
        mBoutonNonMerciListener = new android.view.View.OnClickListener() {

            final PropositionPotionActivity this$0;

            public void onClick(View view)
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = PropositionPotionActivity.this;
                super();
            }
        };
    }

    public void itemPurchased(String s)
    {
        String s1 = getIntent().getStringExtra("potion");
        if (s1 != null && (s1.equals("survitamine") && s.equals(AkInappManager.getInstance().getSkuInappPopu()) || s1.equals("ultime") && s.equals(AkInappManager.getInstance().getSkuInappUltime()) || s1.equals("rayonnante") && s.equals(AkInappManager.getInstance().getSkuInappNoads())))
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
        setContentView(0x7f030031);
        activity = this;
        uiPotionDansOverlayQuestion = (ImageView)findViewById(0x7f0d01a1);
        uiTexteOverlayDesc = (TextView)findViewById(0x7f0d01a2);
        uiButtonAcheter = (Button)findViewById(0x7f0d01a3);
        uiButtonNonMerci = (Button)findViewById(0x7f0d0195);
        uiTexteOverlayDesc.setTypeface(tf);
        uiButtonAcheter.setTypeface(tf);
        uiButtonNonMerci.setTypeface(tf);
        bundle = getIntent().getStringExtra("potion");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (!bundle.equals("rayonnante")) goto _L4; else goto _L3
_L3:
        uiPotionDansOverlayQuestion.setImageResource(0x7f02015f);
        uiTexteOverlayDesc.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_ALERTE_FREEMIUM_PAS_DE_PUB"));
        MetricsSetAdapter.sharedInstance().incMetricCompteur("pub_close");
_L2:
        uiButtonAcheter.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"));
        uiButtonNonMerci.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"));
        addTextView(uiButtonAcheter);
        addTextView(uiButtonNonMerci);
        addTextView(uiTexteOverlayDesc);
        updateTextViewsSize();
        uiButtonAcheter.setOnClickListener(mAcheterListener);
        uiButtonNonMerci.setOnClickListener(mBoutonNonMerciListener);
        return;
_L4:
        if (bundle.equals("survitamine"))
        {
            uiPotionDansOverlayQuestion.setImageResource(0x7f02015b);
            uiTexteOverlayDesc.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_FREE_POPULARITE"));
        } else
        if (bundle.equals("ultime"))
        {
            uiPotionDansOverlayQuestion.setImageResource(0x7f020163);
            uiTexteOverlayDesc.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("FONCTIONNALITE_INDISPONIBLE_EN_VERSION_FREEMIUM")).append("\n").append(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_ANDROID_ALERTE_FREEMIUM_PERSONNALISER_NEW")).toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestAllPurchases();
    }

    public void onResume()
    {
        super.onResume();
        if (!AkInappManager.getInstance().isInit())
        {
            AkInappManager.getInstance().init();
            return;
        } else
        {
            AkInappManager.getInstance().requestAllPurchases();
            return;
        }
    }
}
