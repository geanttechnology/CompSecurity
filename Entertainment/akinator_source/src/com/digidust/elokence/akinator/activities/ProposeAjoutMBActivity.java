// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, AjoutModifPersoMBActivity, GameOverActivity, IdentifierPersoMinibaseActivity

public class ProposeAjoutMBActivity extends AkActivity
{

    public static final String EXTRA_STATUS_PARTIE_NAME = "gagne_ou_perdu";
    public static final boolean EXTRA_VAL_GAGNE = false;
    public static final boolean EXTRA_VAL_PERDU = true;
    ImageView akinatorImage;
    Button boutonDejaEnregistre;
    android.view.View.OnClickListener boutonDejaEnregistreListener;
    Button boutonNon;
    android.view.View.OnClickListener boutonNonListener;
    Button boutonOui;
    android.view.View.OnClickListener boutonOuiListener;
    TextView mainText;
    boolean perdu;

    public ProposeAjoutMBActivity()
    {
        perdu = false;
        boutonOuiListener = new android.view.View.OnClickListener() {

            final ProposeAjoutMBActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ProposeAjoutMBActivity.this, com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity);
                view.putExtra("ActivityMode", true);
                view.putExtra("ActivityCaller", 5);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = ProposeAjoutMBActivity.this;
                super();
            }
        };
        boutonNonListener = new android.view.View.OnClickListener() {

            final ProposeAjoutMBActivity this$0;

            public void onClick(View view)
            {
                if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
                {
                    view = new Intent(ProposeAjoutMBActivity.this, com/digidust/elokence/akinator/activities/GameOverActivity);
                    AkGameFactory.sharedInstance().setGameOverActivityState(11);
                    startActivity(view);
                    finish();
                    return;
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls2 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(((com.elokence.limuleapi.Session.ProposedLimuleObject)SessionFactory.sharedInstance().getSession().getCurrentProposedObject()).getIdSession()));
                        }

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected void onPostExecute(Integer integer)
                        {
                            try
                            {
                                if (mProgressDialog != null && mProgressDialog.isShowing())
                                {
                                    mProgressDialog.dismiss();
                                }
                            }
                            catch (IllegalArgumentException illegalargumentexception)
                            {
                                mProgressDialog = null;
                            }
                            if (integer.intValue() == 0)
                            {
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
                                if (AkGameFactory.sharedInstance().getAkinatorStatus() == 2)
                                {
                                    AkGameFactory.sharedInstance().setGameOverActivityState(1);
                                } else
                                {
                                    AkGameFactory.sharedInstance().setGameOverActivityState(11);
                                }
                                startActivity(integer);
                                finish();
                                return;
                            } else
                            {
                                Toast.makeText(_fld0, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                                goToHome(false);
                                return;
                            }
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Integer)obj);
                        }

                        protected void onPreExecute()
                        {
                            mProgressDialog = CustomLoadingDialog.show(_fld0);
                        }

            
            {
                this$1 = _cls2.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = ProposeAjoutMBActivity.this;
                super();
            }
        };
        boutonDejaEnregistreListener = new android.view.View.OnClickListener() {

            final ProposeAjoutMBActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ProposeAjoutMBActivity.this, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
                byte byte0;
                if (perdu)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 1;
                }
                view.putExtra("ActivityMode", byte0);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = ProposeAjoutMBActivity.this;
                super();
            }
        };
    }

    public void onBackPressed()
    {
        goToHome();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002e);
        if (getIntent().getExtras() != null)
        {
            perdu = getIntent().getExtras().getBoolean("gagne_ou_perdu", false);
        }
        mainText = (TextView)findViewById(0x7f0d0182);
        boutonOui = (Button)findViewById(0x7f0d0184);
        boutonNon = (Button)findViewById(0x7f0d0185);
        boutonDejaEnregistre = (Button)findViewById(0x7f0d0183);
        akinatorImage = (ImageView)findViewById(0x7f0d00c5);
        boutonOui.setTypeface(tf);
        boutonNon.setTypeface(tf);
        boutonDejaEnregistre.setTypeface(tf);
        mainText.setTypeface(tf);
        addTextView(boutonOui);
        addTextView(boutonNon);
        addTextView(boutonDejaEnregistre);
        addTextView(mainText);
        setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_inspiration_forte"));
        setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_inspiration_forte"));
        setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_inspiration_forte"));
        boutonOui.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"));
        boutonNon.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON"));
        boutonDejaEnregistre.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEJA_ENREGISTRE"));
        mainText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PROPOSE_AJOUT_MINIBASE3")).append(TraductionFactory.sharedInstance().getTraductionFromToken("PROPOSE_AJOUT_MINIBASE4")).toString());
        boutonOui.setOnClickListener(boutonOuiListener);
        boutonNon.setOnClickListener(boutonNonListener);
        boutonDejaEnregistre.setOnClickListener(boutonDejaEnregistreListener);
        if (!MinibaseFactory.sharedInstance().hasMinibid())
        {
            boutonDejaEnregistre.setVisibility(4);
        }
        AkAnalyticsFactory.sharedInstance().logAffichagePropositionAjoutMW();
    }
}
