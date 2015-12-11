// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, StoreLaboFragment, StoreItemsFragment, StoreFacesFragment, 
//            StoreGzFragment

public class StoreActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    public static final String KEY_CALLED_FOR_RESULT = "STORE_FOR_RESULT";
    public static final String KEY_DISPLAY_OTHER_TABS = "displayOtherTabs";
    public static final String KEY_TAB = "TabToDisplay";
    public static final int TAB_GZ = 3;
    public static final int TAB_ITEM = 1;
    public static final int TAB_MY_WORLD = 2;
    public static final int TAB_POTION = 0;
    private boolean calledForResult;
    private StoreFacesFragment faces;
    private boolean isFreemium;
    private StoreLaboFragment labo;
    private ImageView tabButtonIcons[];
    private TextView tabTextIcons[];
    public View uiLayoutFaces;
    public View uiLayoutGz;
    private LinearLayout uiLayoutStoreBottom;
    private RelativeLayout uiStoreTabDecors;
    private RelativeLayout uiStoreTabFaces;
    private RelativeLayout uiStoreTabGeniz;
    private RelativeLayout uiStoreTabPotion;
    private TextView uiStoreTextFaces;
    private TextView uiStoreTextGz;
    private TextView uiStoreTextItems;
    private TextView uiStoreTextPotion;
    private ImageView uiTabFaces;
    private ImageView uiTabGz;
    private ImageView uiTabItems;
    private ImageView uiTabLabo;
    TextView uiTextNomStore;

    public StoreActivity()
    {
        calledForResult = false;
    }

    private void displayPressedButton(int i)
    {
        for (int j = 0; j < tabButtonIcons.length; j++)
        {
            if (tabButtonIcons[j] != null)
            {
                tabButtonIcons[j].setImageDrawable(null);
                tabTextIcons[j].setTextColor(getResources().getColor(0x7f0c004f));
            }
        }

        tabButtonIcons[i].setImageDrawable(getResources().getDrawable(0x7f02020e));
        tabButtonIcons[i].setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        tabTextIcons[i].setTextColor(getResources().getColor(0x7f0c009a));
    }

    public void onBackPressed()
    {
        if (calledForResult)
        {
            setResult(0);
            finish();
            return;
        } else
        {
            super.onBackPressed();
            AkGameFactory.sharedInstance().setCanShowAd(false);
            goToHome(false);
            return;
        }
    }

    public void onClick(View view)
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        if (view == uiTabLabo)
        {
            displayPressedButton(0);
            uiLayoutFaces.setVisibility(8);
            uiLayoutGz.setVisibility(0);
            fragmenttransaction.replace(0x7f0d00e0, new StoreLaboFragment()).commit();
        } else
        {
            if (view == uiTabItems)
            {
                displayPressedButton(1);
                uiLayoutFaces.setVisibility(8);
                uiLayoutGz.setVisibility(0);
                fragmenttransaction.replace(0x7f0d00e0, new StoreItemsFragment()).commit();
                return;
            }
            if (view == uiTabFaces)
            {
                displayPressedButton(2);
                uiLayoutGz.setVisibility(8);
                uiLayoutFaces.setVisibility(0);
                fragmenttransaction.replace(0x7f0d00e0, new StoreFacesFragment()).commit();
                return;
            }
            if (view == uiTabGz)
            {
                displayPressedButton(3);
                uiLayoutFaces.setVisibility(8);
                uiLayoutGz.setVisibility(0);
                fragmenttransaction.replace(0x7f0d00e0, new StoreGzFragment()).commit();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        boolean flag;
        super.onCreate(bundle);
        setContentView(0x7f03003a);
        isFreemium = AkConfigFactory.sharedInstance().isFreemium();
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.SHORT_MUSIC;
        uiTextNomStore = (TextView)findViewById(0x7f0d01c4);
        calledForResult = getIntent().getExtras().getBoolean("STORE_FOR_RESULT", false);
        i = getIntent().getIntExtra("TabToDisplay", 0);
        flag = getIntent().getBooleanExtra("displayOtherTabs", true);
        uiLayoutGz = findViewById(0x7f0d01d3);
        uiLayoutFaces = findViewById(0x7f0d01d4);
        uiStoreTextPotion = (TextView)findViewById(0x7f0d01c8);
        uiStoreTextFaces = (TextView)findViewById(0x7f0d01ce);
        uiStoreTextItems = (TextView)findViewById(0x7f0d01cb);
        uiStoreTextGz = (TextView)findViewById(0x7f0d01d1);
        uiLayoutStoreBottom = (LinearLayout)findViewById(0x7f0d01c5);
        uiStoreTabPotion = (RelativeLayout)findViewById(0x7f0d01c6);
        uiStoreTabFaces = (RelativeLayout)findViewById(0x7f0d01cc);
        uiStoreTabGeniz = (RelativeLayout)findViewById(0x7f0d01cf);
        uiStoreTabDecors = (RelativeLayout)findViewById(0x7f0d01c9);
        uiTabLabo = (ImageView)findViewById(0x7f0d01c7);
        uiTabLabo.setOnClickListener(this);
        uiTabFaces = (ImageView)findViewById(0x7f0d01cd);
        uiTabFaces.setOnClickListener(this);
        uiTabItems = (ImageView)findViewById(0x7f0d01ca);
        uiTabItems.setOnClickListener(this);
        uiTabGz = (ImageView)findViewById(0x7f0d01d0);
        uiTabGz.setOnClickListener(this);
        tabButtonIcons = new ImageView[4];
        tabButtonIcons[0] = uiTabLabo;
        tabButtonIcons[1] = uiTabItems;
        tabButtonIcons[2] = uiTabFaces;
        tabButtonIcons[3] = uiTabGz;
        tabTextIcons = new TextView[4];
        tabTextIcons[0] = uiStoreTextPotion;
        tabTextIcons[1] = uiStoreTextItems;
        tabTextIcons[2] = uiStoreTextFaces;
        tabTextIcons[3] = uiStoreTextGz;
        bundle = getFragmentManager().beginTransaction();
        i;
        JVM INSTR tableswitch 0 3: default 444
    //                   0 589
    //                   1 626
    //                   2 663
    //                   3 700;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_700;
_L6:
        displayPressedButton(i);
        if (flag)
        {
            uiTextNomStore.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BOUTIQUE_AKINATOR"));
        } else
        {
            uiLayoutStoreBottom.setVisibility(8);
            if (i == 1)
            {
                uiTextNomStore.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CHOIX_DES_ACCESSOIRES"));
            } else
            if (i == 2)
            {
                uiTextNomStore.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BOUTIQUE_AKINATOR"));
            }
        }
        uiStoreTextPotion.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ONGLET_POTION"));
        uiStoreTextFaces.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MY_WORLD"));
        uiStoreTextItems.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ONGLET_ACCESSOIRES"));
        uiStoreTextGz.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ONGLET_GENIZ"));
        uiTextNomStore.setTypeface(tf);
        addTextView(uiTextNomStore);
        addTextView(uiStoreTextPotion);
        addTextView(uiStoreTextFaces);
        addTextView(uiStoreTextItems);
        addTextView(uiStoreTextGz);
        updateTextViewsSize();
        return;
_L2:
        uiLayoutFaces.setVisibility(8);
        uiLayoutGz.setVisibility(0);
        bundle.add(0x7f0d00e0, new StoreLaboFragment()).commit();
          goto _L6
_L3:
        uiLayoutFaces.setVisibility(8);
        uiLayoutGz.setVisibility(0);
        bundle.add(0x7f0d00e0, new StoreItemsFragment()).commit();
          goto _L6
_L4:
        uiLayoutGz.setVisibility(8);
        uiLayoutFaces.setVisibility(0);
        bundle.add(0x7f0d00e0, new StoreFacesFragment()).commit();
          goto _L6
        uiLayoutFaces.setVisibility(8);
        uiLayoutGz.setVisibility(0);
        bundle.add(0x7f0d00e0, new StoreGzFragment()).commit();
          goto _L6
    }
}
