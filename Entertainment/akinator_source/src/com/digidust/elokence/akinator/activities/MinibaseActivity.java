// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.digidust.elokence.akinator.adapters.AkMinibaseCharacterAdapter;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.MinibaseListener;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity

public class MinibaseActivity extends AkActivity
    implements MinibaseListener
{

    android.view.View.OnClickListener boutonRetourClickListener;
    android.view.View.OnClickListener boutonSupprAllClickListener;
    private AkMinibaseCharacterAdapter mAkMinibaseCharactersAdapter;
    private int mComeFrom;
    private ListView uiCharactersList;
    ImageView uiRetourButton;
    ImageView uiSuppAllButton;
    TextView uiTitleText;

    public MinibaseActivity()
    {
        mComeFrom = -1;
        boutonSupprAllClickListener = new android.view.View.OnClickListener() {

            final MinibaseActivity this$0;

            public void onClick(View view)
            {
                if (mAkMinibaseCharactersAdapter == null || mAkMinibaseCharactersAdapter.getCharacters() == null || mAkMinibaseCharactersAdapter.getCharacters().size() == 0)
                {
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(MinibaseActivity.this);
                    view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_TITRE"));
                    view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_DESCRIPTION"));
                    android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                        /* block-local class not found */
                        class _cls1 {}

                            if (i == -1)
                            {
                                (new _cls1()).execute(new Void[0]);
                            } else
                            if (i == -2)
                            {
                                dialoginterface.dismiss();
                                return;
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    };
                    view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), onclicklistener);
                    view.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON"), onclicklistener);
                    view.create().show();
                    return;
                }
            }

            
            {
                this$0 = MinibaseActivity.this;
                super();
            }
        };
        boutonRetourClickListener = new android.view.View.OnClickListener() {

            final MinibaseActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = MinibaseActivity.this;
                super();
            }
        };
    }

    private void onBack()
    {
        if (mComeFrom == 0)
        {
            goToHome(false);
        } else
        if (mComeFrom == 1)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
            finish();
            return;
        }
    }

    public void contentChanged()
    {
        updateGUI();
    }

    public void errorLoading(int i)
    {
    }

    public void isLoading()
    {
    }

    public void loadingComplete()
    {
        updateGUI();
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030029);
        uiTitleText = (TextView)findViewById(0x7f0d0135);
        uiSuppAllButton = (ImageView)findViewById(0x7f0d0136);
        uiRetourButton = (ImageView)findViewById(0x7f0d0133);
        uiCharactersList = (ListView)findViewById(0x7f0d0127);
        mComeFrom = AkGameFactory.sharedInstance().comeFrom();
        uiTitleText.setTypeface(tf);
        addTextView(uiTitleText);
        updateTextViewsSize();
        uiRetourButton.setOnClickListener(boutonRetourClickListener);
        uiSuppAllButton.setOnClickListener(boutonSupprAllClickListener);
        uiTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MY_WORLD"));
        AkAnalyticsFactory.sharedInstance().logListePersosMW();
    }

    public void onPause()
    {
        MinibaseFactory.sharedInstance().unsubscribe(this);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        MinibaseFactory.sharedInstance().subscribe(this);
        updateGUI();
    }

    public void resynchronized()
    {
        updateGUI();
    }

    public void updateGUI()
    {
        runOnUiThread(new Runnable() {

            final MinibaseActivity this$0;

            public void run()
            {
            /* block-local class not found */
            class _cls1 {}

                (new _cls1()).execute(new Void[0]);
            }

            
            {
                this$0 = MinibaseActivity.this;
                super();
            }
        });
    }



/*
    static AkMinibaseCharacterAdapter access$002(MinibaseActivity minibaseactivity, AkMinibaseCharacterAdapter akminibasecharacteradapter)
    {
        minibaseactivity.mAkMinibaseCharactersAdapter = akminibasecharacteradapter;
        return akminibasecharacteradapter;
    }

*/


}
