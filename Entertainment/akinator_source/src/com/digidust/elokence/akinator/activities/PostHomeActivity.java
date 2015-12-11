// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.billing.Base64;
import com.digidust.elokence.akinator.billing.Base64DecoderException;
import com.digidust.elokence.akinator.db.DefiSetAdapter;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PartageAppsFragment, QuestionActivity

public class PostHomeActivity extends AkActivity
{

    protected static final int MB_STATUS_ERROR = 2;
    protected static final int MB_STATUS_OK = 0;
    protected static final int MB_STATUS_WAITING = 1;
    private TextView alertFiltreEnfant;
    private PartageAppsFragment fragmentPartage;
    private View layoutAlertFiltreEnfant;
    private android.view.View.OnClickListener mFiltreEnfantClickListener;
    private android.view.View.OnClickListener mNotPlayClickListener;
    private android.view.View.OnClickListener mPlayClickListener;
    private android.view.View.OnClickListener mRetourClickListener;
    private int mbStatus;
    private ImageView retourButton;
    private ImageView uiFiltreEnfant;
    private Button uiGoButton;
    private TextView uiPostHomeText;

    public PostHomeActivity()
    {
        fragmentPartage = null;
        mRetourClickListener = new android.view.View.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(View view)
            {
                goToHome(false);
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        };
        mFiltreEnfantClickListener = new android.view.View.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(View view)
            {
                if (layoutAlertFiltreEnfant != null && layoutAlertFiltreEnfant.getVisibility() == 0)
                {
                    layoutAlertFiltreEnfant.setVisibility(8);
                    alertFiltreEnfant.setVisibility(8);
                }
                view = AkConfigFactory.sharedInstance();
                boolean flag;
                if (!AkConfigFactory.sharedInstance().isChildProtectEnabled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setChildProtectEnabled(flag);
                SessionFactory.sharedInstance().SetChildrenProtect(AkConfigFactory.sharedInstance().isChildProtectEnabled());
                if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
                {
                    view = new android.app.AlertDialog.Builder(PostHomeActivity.this);
                    view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT_ACTIVE"));
                    view.setCancelable(false);
                    view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view.show();
                    uiFiltreEnfant.setImageResource(0x7f0201d9);
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(PostHomeActivity.this);
                    view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT_DESACTIVE"));
                    view.setCancelable(false);
                    view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view.show();
                    uiFiltreEnfant.setImageResource(0x7f0201da);
                    return;
                }
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        };
        mPlayClickListener = new android.view.View.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(View view)
            {
                if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated() && !AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
                {
                    Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("SELECTIONNER_UNE_BASE"), 1).show();
                }
                AkConfigFactory.sharedInstance().setCanReShowAlert(true);
                BackgroundSoundsBinder.sharedInstance().playStartPlaying();
                if (!AkConfigFactory.sharedInstance().isOnline())
                {
                    Toast.makeText(PostHomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("VERIFIEZ_VOTRE_CONNEXION_ET_REESSAYEZ"), 0).show();
                    return;
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls5 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            if (AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
                            {
                                avoid = SessionFactory.sharedInstance();
                                boolean flag;
                                if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                return Integer.valueOf(avoid.startSessionWithMinibase(true, flag));
                            } else
                            {
                                return Integer.valueOf(SessionFactory.sharedInstance().startSession());
                            }
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
                            if (integer.intValue() == 0 || integer.intValue() == 800)
                            {
                                AkGameFactory.sharedInstance().setAkinatorStatus(0);
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/QuestionActivity);
                                startActivity(integer);
                                finish();
                                return;
                            }
                            if (integer.intValue() == 500)
                            {
                                Toast.makeText(_fld0, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
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
                this$1 = _cls5.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        };
        mNotPlayClickListener = new android.view.View.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(View view)
            {
                goToHome(false);
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        };
    }

    private void showAlertChildProtect()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("LE_SAVIEZ_VOUS"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("PENSEZ_ACTIVER_FILTRE_ENFANTS"));
        builder.setCancelable(false);
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AkConfigFactory.sharedInstance().setChildProtectionChosen(true);
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    private void showAlertDiscoverMyWorld()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("INFO"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_6_DECOUVREZ_MY_WORLD_DESCRIPTION"));
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AkGameFactory.sharedInstance().disableDiscoverMyWorld();
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        });
        AkAnalyticsFactory.sharedInstance().logAffichageMessageJoueProche();
        builder.show();
    }

    private void showAlertRateApp()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("INFO"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VOUS_AIMEZ_AKINATOR_COMMENTAIRE_MARKET"));
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                disableAdOneTime();
                dialoginterface.dismiss();
                BackgroundSoundsBinder.sharedInstance().playBip();
                dialoginterface = new Intent("android.intent.action.VIEW");
                dialoginterface.setData(Uri.parse("market://details?id=com.digidust.elokence.akinator.freemium"));
                startActivity(dialoginterface);
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        });
        builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NE_PLUS_ME_LE_RAPPELER"), new android.content.DialogInterface.OnClickListener() {

            final PostHomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        });
        AkGameFactory.sharedInstance().disableAlertRateApp();
        builder.show();
    }

    private void updateViewDefi()
    {
        runOnUiThread(new Runnable() {

            final PostHomeActivity this$0;

            public void run()
            {
                Object obj = (RelativeLayout)findViewById(0x7f0d0169);
                com.digidust.elokence.akinator.db.DefiSetAdapter.DefiInfos defiinfos = DefiSetAdapter.sharedInstance().getDefiDuJourInfos();
                if (defiinfos == null)
                {
                    AkLog.d("defi", "on cache la vue car infos == null");
                    ((RelativeLayout) (obj)).setVisibility(4);
                    return;
                }
                ((RelativeLayout) (obj)).setVisibility(0);
                obj = (TextView)findViewById(0x7f0d00cf);
                ((TextView) (obj)).setTypeface(tf);
                ((TextView) (obj)).setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TITRE")).append(" ").append(defiinfos.getTitle()).toString());
            /* block-local class not found */
            class _cls1 {}

                ((ImageView)findViewById(0x7f0d016f)).setOnClickListener(new _cls1(defiinfos));
                Object obj1 = (LinearLayout)findViewById(0x7f0d016c);
                ((LinearLayout) (obj1)).removeAllViews();
                int j = (int)TypedValue.applyDimension(0, 10F, getResources().getDisplayMetrics());
                int k = (int)TypedValue.applyDimension(0, getResources().getDimension(0x7f09006d), getResources().getDisplayMetrics());
                AkLog.d("defi", (new StringBuilder()).append(defiinfos.getListPerso().size()).append(" persos a afficher").toString());
                int i = 0;
                while (i < defiinfos.getListPerso().size()) 
                {
                    Object obj2 = (com.digidust.elokence.akinator.db.DefiSetAdapter.Perso)defiinfos.getListPerso().get(i);
                    String s = ((com.digidust.elokence.akinator.db.DefiSetAdapter.Perso) (obj2)).getPhotoBase64();
                    boolean flag = ((com.digidust.elokence.akinator.db.DefiSetAdapter.Perso) (obj2)).isFound();
                    ImageView imageview = new ImageView(PostHomeActivity.this);
                    if (flag)
                    {
                        try
                        {
                            byte abyte0[] = Base64.decode(s);
                            imageview.setImageBitmap(BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length));
                        }
                        catch (Base64DecoderException base64decoderexception)
                        {
                            base64decoderexception.printStackTrace();
                            imageview.setImageResource(0x7f02021e);
                        }
                    } else
                    {
                        imageview.setImageResource(0x7f02021e);
                    }
                    AkLog.d("defi", (new StringBuilder()).append(" persos rajouter ").append(((com.digidust.elokence.akinator.db.DefiSetAdapter.Perso) (obj2)).getBaseId()).toString());
                    obj2 = new android.widget.LinearLayout.LayoutParams(k, k);
                    ((android.widget.LinearLayout.LayoutParams) (obj2)).setMargins(j, 0, j, 0);
                    imageview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
                    ((LinearLayout) (obj1)).addView(imageview);
                    i++;
                }
                defiinfos = DefiSetAdapter.sharedInstance().getDefiInfos(false);
                obj1 = (TextView)findViewById(0x7f0d016e);
                LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0d016d);
                if (defiinfos != null)
                {
                    linearlayout.setVisibility(0);
                    ((TextView) (obj1)).setTypeface(tf);
                    ((TextView) (obj1)).setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_PRECEDENT"));
            /* block-local class not found */
            class _cls2 {}

                    linearlayout.setOnClickListener(new _cls2());
                    addTextView(((TextView) (obj1)));
                } else
                {
                    linearlayout.setVisibility(4);
                }
                addTextView(((TextView) (obj)));
                updateTextViewsSize();
            }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
        });
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 2 && j == 0)
        {
            goToHome();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (fragmentPartage != null && fragmentPartage.isVisible())
        {
            fragmentPartage.hide();
            return;
        } else
        {
            goToHome(false);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002c);
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.FULL_MUSIC;
        AkSessionFactory.sharedInstance().setStepOfLastProp(0);
        uiGoButton = (Button)findViewById(0x7f0d016a);
        uiPostHomeText = (TextView)findViewById(0x7f0d0167);
        retourButton = (ImageView)findViewById(0x7f0d0133);
        retourButton.setOnClickListener(mRetourClickListener);
        uiFiltreEnfant = (ImageView)findViewById(0x7f0d0172);
        uiFiltreEnfant.setOnClickListener(mFiltreEnfantClickListener);
        if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
        {
            uiFiltreEnfant.setImageResource(0x7f0201d9);
        } else
        {
            uiFiltreEnfant.setImageResource(0x7f0201da);
        }
        uiGoButton.setTypeface(tf);
        uiPostHomeText.setTypeface(tf);
        addTextView(uiGoButton);
        addTextView(uiPostHomeText);
        updateTextViewsSize();
        uiGoButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("C_EST_PARTI"));
        uiPostHomeText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PENSEZ_A_UN_PERSONNAGE_REEL_OU_FICTIF")).append(". ").append(Character.toUpperCase(TraductionFactory.sharedInstance().getTraductionFromToken("JE_VAIS_TENTER_DE_LE_DEVINER").charAt(0))).append(TraductionFactory.sharedInstance().getTraductionFromToken("JE_VAIS_TENTER_DE_LE_DEVINER").substring(1, TraductionFactory.sharedInstance().getTraductionFromToken("JE_VAIS_TENTER_DE_LE_DEVINER").length())).append(".").toString());
        AkGameFactory.sharedInstance().getNbWonGames();
        AkGameFactory.sharedInstance().getNbGames();
        updateTextViewsSize();
        if (AkConfigFactory.sharedInstance().canPlay() == 1 || AkConfigFactory.sharedInstance().canPlay() == 0 && AkConfigFactory.sharedInstance().isPrio())
        {
            uiGoButton.setOnClickListener(mPlayClickListener);
        } else
        if (AkConfigFactory.sharedInstance().canPlay() == -1 || AkConfigFactory.sharedInstance().canPlay() == 0 && !AkConfigFactory.sharedInstance().isPrio())
        {
            uiGoButton.setOnClickListener(mNotPlayClickListener);
        }
        if (MinibaseFactory.sharedInstance().isLoaded())
        {
            mbStatus = 0;
        } else
        if (MinibaseFactory.sharedInstance().hasError())
        {
            mbStatus = 2;
        } else
        {
            mbStatus = 1;
        }
        if (!AkConfigFactory.sharedInstance().hasOverlayChildProtectionAlreadyDisplayed())
        {
            AkConfigFactory.sharedInstance().setOverlayChildProtection();
            layoutAlertFiltreEnfant = findViewById(0x7f0d0170);
            layoutAlertFiltreEnfant.setOnClickListener(new android.view.View.OnClickListener() {

                final PostHomeActivity this$0;

                public void onClick(View view)
                {
                    alertFiltreEnfant.setVisibility(8);
                    layoutAlertFiltreEnfant.setVisibility(8);
                }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
            });
            alertFiltreEnfant = (TextView)findViewById(0x7f0d0171);
            layoutAlertFiltreEnfant.setVisibility(0);
            alertFiltreEnfant.setVisibility(0);
            alertFiltreEnfant.setText(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT_PEDAGOGIQUE"));
            alertFiltreEnfant.setTypeface(tf);
            addTextView(alertFiltreEnfant);
            updateTextViewsSize();
        }
        if (!AkConfigFactory.sharedInstance().hasChosenChildProtection() && AkGameFactory.sharedInstance().getNbWonGames() >= 2)
        {
            showAlertChildProtect();
        } else
        if (!AkGameFactory.sharedInstance().isAppRated() && AkGameFactory.sharedInstance().getNbWonGames() >= 5)
        {
            showAlertRateApp();
        } else
        if (!AkGameFactory.sharedInstance().hasDiscoverMyWorld() && !MinibaseFactory.sharedInstance().hasMinibid() && AkGameFactory.sharedInstance().getNbWonGames() >= 10)
        {
            showAlertDiscoverMyWorld();
        }
        updateViewDefi();
    }

    public void onDefiDuJourModified()
    {
        super.onDefiDuJourModified();
        AkLog.d("defi", "on update la post home car nouveau d\351fi");
        updateViewDefi();
    }

    protected void onDestroy()
    {
        uiPostHomeText = null;
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        uiTextScoreXp.setTextColor(getResources().getColor(0x7f0c002a));
        uiTextXp.setTextColor(getResources().getColor(0x7f0c002a));
    }






/*
    static PartageAppsFragment access$302(PostHomeActivity posthomeactivity, PartageAppsFragment partageappsfragment)
    {
        posthomeactivity.fragmentPartage = partageappsfragment;
        return partageappsfragment;
    }

*/
}
