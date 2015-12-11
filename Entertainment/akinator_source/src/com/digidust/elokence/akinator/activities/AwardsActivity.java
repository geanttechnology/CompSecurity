// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.TraductionFactory;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PopPedagogiqueActivity

public class AwardsActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    public static final String keyGoToHome = "keyGoToHome";
    private AkDBAdapter akDbAdapter;
    android.view.View.OnClickListener awardClickListener;
    private boolean goToHome;
    private boolean mFirstLoad;
    private ImageView uiBackButtonImage;
    private ImageView uiClosePopUp;
    private ImageView uiImageBadge;
    private ImageView uiImageNbBadgeBlack;
    private ImageView uiImageNbBadgeBronze;
    private ImageView uiImageNbBadgeGold;
    private ImageView uiImageNbBadgePlatinum;
    private ImageView uiImageNbBadgeSilver;
    private ImageView uiImageNbBadgeStandard;
    private RelativeLayout uiLayoutCharactersPlayed;
    private RelativeLayout uiLayoutCharactersPlayedZone;
    private LinearLayout uiLayoutItems;
    private TextView uiTextNbBadgeBlack;
    private TextView uiTextNbBadgeBronze;
    private TextView uiTextNbBadgeGold;
    private TextView uiTextNbBadgePlatinum;
    private TextView uiTextNbBadgeSilver;
    private TextView uiTextNbBadgeStandard;
    private TextView uiTextRang;
    private View uiViewCancel;
    private ImageView uiWhatIsAkiAward;

    public AwardsActivity()
    {
        mFirstLoad = true;
        akDbAdapter = null;
        goToHome = true;
        awardClickListener = new android.view.View.OnClickListener() {

            final AwardsActivity this$0;

            public void onClick(View view)
            {
                byte byte0 = 0;
                LayoutInflater layoutinflater;
                Object obj;
                TextView textview;
                LinearLayout linearlayout;
                Pair pair;
                Iterator iterator;
                if (view == uiImageNbBadgeBlack)
                {
                    byte0 = 6;
                } else
                if (view == uiImageNbBadgePlatinum)
                {
                    byte0 = 5;
                } else
                if (view == uiImageNbBadgeGold)
                {
                    byte0 = 4;
                } else
                if (view == uiImageNbBadgeSilver)
                {
                    byte0 = 3;
                } else
                if (view == uiImageNbBadgeBronze)
                {
                    byte0 = 2;
                } else
                if (view == uiImageNbBadgeStandard)
                {
                    byte0 = 1;
                }
                akDbAdapter = new AkDBAdapter(AwardsActivity.this);
                obj = akDbAdapter.getCharactersPlayedForAwardLevel(byte0);
                if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
                layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
                uiLayoutItems.removeAllViews();
                for (iterator = ((List) (obj)).iterator(); iterator.hasNext(); uiLayoutItems.addView(linearlayout))
                {
                    pair = (Pair)iterator.next();
                    linearlayout = (LinearLayout)layoutinflater.inflate(0x7f030058, null);
                    obj = (TextView)linearlayout.findViewById(0x7f0d025d);
                    textview = (TextView)linearlayout.findViewById(0x7f0d025e);
                    addTextView(textview);
                    addTextView(((TextView) (obj)));
                    ((TextView) (obj)).setText((CharSequence)pair.first);
                    textview.setText((CharSequence)pair.second);
                }

                updateTextViewsSize();
                if (view != uiImageNbBadgeBlack) goto _L4; else goto _L3
_L3:
                uiImageBadge.setImageResource(0x7f020066);
                uiImageBadge.setBackgroundResource(0x7f02007a);
_L8:
                uiLayoutCharactersPlayed.setVisibility(0);
_L2:
                if (akDbAdapter != null)
                {
                    akDbAdapter.close();
                }
_L6:
                return;
_L4:
                if (view == uiImageNbBadgePlatinum)
                {
                    uiImageBadge.setImageResource(0x7f020076);
                    uiImageBadge.setBackgroundResource(0x7f02007a);
                } else
                if (view == uiImageNbBadgeGold)
                {
                    uiImageBadge.setImageResource(0x7f020072);
                    uiImageBadge.setBackgroundResource(0x7f02007a);
                }
                continue; /* Loop/switch isn't completed */
                view;
                view.printStackTrace();
                if (false)
                {
                    throw new NullPointerException();
                }
                if (akDbAdapter == null) goto _L6; else goto _L5
_L5:
                akDbAdapter.close();
                return;
                view;
                if (false)
                {
                    throw new NullPointerException();
                }
                if (akDbAdapter != null)
                {
                    akDbAdapter.close();
                }
                throw view;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                this$0 = AwardsActivity.this;
                super();
            }
        };
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    public void onClick(View view)
    {
        if (view != uiBackButtonImage) goto _L2; else goto _L1
_L1:
        BackgroundSoundsBinder.sharedInstance().playBip();
        super.onBackPressed();
        finish();
_L4:
        return;
_L2:
        if (view != uiViewCancel && view != uiClosePopUp)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (uiLayoutCharactersPlayed.getVisibility() != 0) goto _L4; else goto _L3
_L3:
        uiLayoutCharactersPlayed.setVisibility(8);
        return;
        if (view != uiWhatIsAkiAward) goto _L4; else goto _L5
_L5:
        disableAdOneTime();
        view = new Intent(this, com/digidust/elokence/akinator/activities/PopPedagogiqueActivity);
        view.putExtra("PostPedagogiqueActivityModeGz", false);
        startActivity(view);
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001c);
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE;
        uiWhatIsAkiAward = (ImageView)findViewById(0x7f0d009b);
        uiWhatIsAkiAward.setOnClickListener(this);
        uiTextNbBadgeStandard = (TextView)findViewById(0x7f0d00ab);
        uiTextNbBadgeBronze = (TextView)findViewById(0x7f0d00a9);
        uiTextNbBadgeSilver = (TextView)findViewById(0x7f0d00a7);
        uiTextNbBadgeGold = (TextView)findViewById(0x7f0d00a4);
        uiTextNbBadgePlatinum = (TextView)findViewById(0x7f0d00a1);
        uiTextNbBadgeBlack = (TextView)findViewById(0x7f0d009e);
        uiImageNbBadgeGold = (ImageView)findViewById(0x7f0d00a5);
        uiImageNbBadgeGold.setOnClickListener(awardClickListener);
        uiImageNbBadgePlatinum = (ImageView)findViewById(0x7f0d00a2);
        uiImageNbBadgePlatinum.setOnClickListener(awardClickListener);
        uiImageNbBadgeBlack = (ImageView)findViewById(0x7f0d009f);
        uiImageNbBadgeBlack.setOnClickListener(awardClickListener);
        uiImageBadge = (ImageView)findViewById(0x7f0d00b8);
        uiViewCancel = findViewById(0x7f0d00b5);
        uiViewCancel.setOnClickListener(this);
        uiClosePopUp = (ImageView)findViewById(0x7f0d00b7);
        uiClosePopUp.setOnClickListener(this);
        uiLayoutItems = (LinearLayout)findViewById(0x7f0d00b9);
        uiLayoutCharactersPlayed = (RelativeLayout)findViewById(0x7f0d00b4);
        uiLayoutCharactersPlayedZone = (RelativeLayout)findViewById(0x7f0d00b6);
        uiTextRang = (TextView)findViewById(0x7f0d00b2);
        uiBackButtonImage = (ImageView)findViewById(0x7f0d00ba);
        uiBackButtonImage.setOnClickListener(this);
        uiTextNbBadgeStandard.setTypeface(tf);
        uiTextNbBadgeBronze.setTypeface(tf);
        uiTextNbBadgeSilver.setTypeface(tf);
        uiTextNbBadgeGold.setTypeface(tf);
        uiTextNbBadgePlatinum.setTypeface(tf);
        uiTextNbBadgeBlack.setTypeface(tf);
        uiTextRang.setTypeface(tf);
        try
        {
            akDbAdapter = new AkDBAdapter(this);
            uiTextNbBadgeStandard.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(1)));
            uiTextNbBadgeBronze.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(2)));
            uiTextNbBadgeSilver.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(3)));
            uiTextNbBadgeGold.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(4)));
            uiTextNbBadgePlatinum.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(5)));
            uiTextNbBadgeBlack.setText(String.valueOf(akDbAdapter.getNbCharactersPlayedForAwardLevel(6)));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        addTextView(uiTextNbBadgeStandard);
        addTextView(uiTextNbBadgeBronze);
        addTextView(uiTextNbBadgeSilver);
        addTextView(uiTextNbBadgeGold);
        addTextView(uiTextNbBadgePlatinum);
        addTextView(uiTextNbBadgeBlack);
        addTextView(uiTextRang);
        updateTextViewsSize();
        goToHome = getIntent().getBooleanExtra("keyGoToHome", true);
    }

    public void onResume()
    {
        super.onResume();
        if (!mFirstLoad) goto _L2; else goto _L1
_L1:
        mFirstLoad = false;
        if (currentSeuil != 0) goto _L4; else goto _L3
_L3:
        uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEBUTANT"));
_L6:
        addTextView(uiTextRang);
        updateTextViewsSize();
_L2:
        return;
_L4:
        if (currentSeuil == 3500)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEBUTANT_PLUS"));
        } else
        if (currentSeuil == 20000)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("INTERMEDIAIRE"));
        } else
        if (currentSeuil == 45000)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("INTERMEDIAIRE_PLUS"));
        } else
        if (currentSeuil == 0x15f90)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CONFIRME"));
        } else
        if (currentSeuil == 0x23280)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CONFIRME_PLUS"));
        } else
        if (currentSeuil == 0x6ddd0)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("EXPERT"));
        } else
        if (currentSeuil == 0xdbba0)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ULTIME"));
        } else
        if (currentSeuil == 0x1e8480)
        {
            uiTextRang.setText(TraductionFactory.sharedInstance().getTraductionFromToken("EXPERT_PLUS"));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }









/*
    static AkDBAdapter access$602(AwardsActivity awardsactivity, AkDBAdapter akdbadapter)
    {
        awardsactivity.akDbAdapter = akdbadapter;
        return akdbadapter;
    }

*/



}
