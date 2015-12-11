// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkFacesFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.io.FileNotFoundException;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, MinibaseActivity, GameOverActivity, IdentifierPersoMinibaseActivity, 
//            ProposeAjoutMBActivity, WebviewCGV

public class AjoutModifPersoMBActivity extends AkActivity
{

    public static final int CALLER_CHARACTERFOUND = 2;
    public static final int CALLER_IDENTIFIE = 4;
    public static final int CALLER_INFO = 6;
    public static final int CALLER_LOST = 3;
    public static final int CALLER_OPTIONS = 1;
    public static final int CALLER_PROPOSE_AJOUT = 5;
    public static final String EXTRA_COMEFROM_NAME = "ActivityCaller";
    public static final String EXTRA_MODE_NAME = "ActivityMode";
    public static final boolean MODE_AJOUT = true;
    public static final boolean MODE_MODIF = false;
    int ActivityCaller;
    boolean activityMode;
    private Bitmap bitmap;
    private com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase mbSelectedCharacter;
    android.view.View.OnClickListener photoClickListener;
    android.view.View.OnClickListener ppClickListener;
    private Bitmap rescaledBitmap;
    android.view.View.OnClickListener retourClickListener;
    private Uri targetUri;
    private TextView uiActivityTitleText;
    private ImageView uiBoutonRetour;
    private Button uiBoutonValide;
    private TextView uiConfidentialityText;
    private EditText uiNomEditText;
    private TextView uiNomPersoDansAkinatorText;
    private ImageView uiPhotoImage;
    private TextView uiTextFacultatif;
    android.view.View.OnClickListener valideClickListener;

    public AjoutModifPersoMBActivity()
    {
        valideClickListener = new android.view.View.OnClickListener() {

            final AjoutModifPersoMBActivity this$0;

            public void onClick(View view)
            {
                if (uiNomEditText.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_DANS_MY_WORLD_DESCRIPTION"), 1).show();
                } else
                {
                    AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
                    if (activityMode)
                    {
                        if (AkFacesFactory.sharedInstance().getBalance() <= 0)
                        {
                            view = new android.app.AlertDialog.Builder(AjoutModifPersoMBActivity.this);
                            AkAnalyticsFactory.sharedInstance().logAffichagePropositionAchatCredits();
                            view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_2_MY_WORLD_TITRE"));
                            view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_2_MY_WORLD_DESCRIPTION"));
                            view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$1;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    goToStoreFaces(true);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                            view.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"), new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$1;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                            view.create().show();
                            return;
                        }
                        if (MinibaseFactory.sharedInstance().hasMinibid())
                        {
                            (new AsyncTask() {

                                private String mNomEdit;
                                private Dialog mProgressDialog;
                                final _cls1 this$1;

                                protected transient Integer doInBackground(Void avoid[])
                                {
                                    return Integer.valueOf(MinibaseFactory.sharedInstance().addCharacterToMinibase(mNomEdit, rescaledBitmap));
                                }

                                protected volatile Object doInBackground(Object aobj[])
                                {
                                    return doInBackground((Void[])aobj);
                                }

                                protected void onPostExecute(Integer integer)
                                {
                                    boolean flag = false;
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
                                        MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_added");
                                        AkPlayerBelongingsFactory.sharedInstance().withdrawFaces();
                                        integer = AkAnalyticsFactory.sharedInstance();
                                        if (rescaledBitmap != null)
                                        {
                                            flag = true;
                                        }
                                        integer.logAjoutProcheMW(flag);
                                        appelValide();
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
                                    mNomEdit = uiNomEditText.getText().toString();
                                }

            
            {
                this$1 = _cls1.this;
                super();
                mProgressDialog = null;
            }
                            }).execute(new Void[0]);
                            return;
                        } else
                        {
                            (new AsyncTask() {

                                private String mNomEdit;
                                private Dialog mProgressDialog;
                                final _cls1 this$1;

                                protected transient Integer doInBackground(Void avoid[])
                                {
                                    return Integer.valueOf(MinibaseFactory.sharedInstance().createMiniBase(mNomEdit, rescaledBitmap));
                                }

                                protected volatile Object doInBackground(Object aobj[])
                                {
                                    return doInBackground((Void[])aobj);
                                }

                                protected void onPostExecute(Integer integer)
                                {
                                    boolean flag = false;
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
                                        MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_added");
                                        AkPlayerBelongingsFactory.sharedInstance().withdrawFaces();
                                        integer = AkAnalyticsFactory.sharedInstance();
                                        if (rescaledBitmap != null)
                                        {
                                            flag = true;
                                        }
                                        integer.logAjoutProcheMW(flag);
                                        appelValide();
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
                                    mNomEdit = uiNomEditText.getText().toString();
                                }

            
            {
                this$1 = _cls1.this;
                super();
                mProgressDialog = null;
            }
                            }).execute(new Void[0]);
                            return;
                        }
                    }
                    if (!activityMode)
                    {
                        (new AsyncTask() {

                            private String mNomEdit;
                            private Dialog mProgressDialog;
                            final _cls1 this$1;

                            protected transient Integer doInBackground(Void avoid[])
                            {
                                return Integer.valueOf(MinibaseFactory.sharedInstance().modifyCharacterMinibase(mbSelectedCharacter.getElementMinibaseId(), mNomEdit, rescaledBitmap));
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
                                mbSelectedCharacter.setName(mNomEdit);
                                if (integer.intValue() == 0)
                                {
                                    appelRetourModif();
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
                                mNomEdit = uiNomEditText.getText().toString();
                            }

            
            {
                this$1 = _cls1.this;
                super();
                mProgressDialog = null;
            }
                        }).execute(new Void[0]);
                        return;
                    }
                }
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        };
        retourClickListener = new android.view.View.OnClickListener() {

            final AjoutModifPersoMBActivity this$0;

            public void onClick(View view)
            {
                appelRetour();
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        };
        photoClickListener = new android.view.View.OnClickListener() {

            final AjoutModifPersoMBActivity this$0;

            public void onClick(View view)
            {
                disableAdOneTime();
                launchDialogPictureChooser();
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        };
        ppClickListener = new android.view.View.OnClickListener() {

            final AjoutModifPersoMBActivity this$0;

            public void onClick(View view)
            {
                disableAdOneTime();
                view = new Intent(AjoutModifPersoMBActivity.this, com/digidust/elokence/akinator/activities/WebviewCGV);
                view.putExtra("url", "http://cgu.akinator.com/mobile/privacy");
                startActivity(view);
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        };
    }

    private void appelRetour()
    {
        Intent intent4;
        switch (ActivityCaller)
        {
        default:
            return;

        case 1: // '\001'
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/MinibaseActivity));
            finish();
            return;

        case 2: // '\002'
            Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(1);
            startActivity(intent);
            finish();
            return;

        case 3: // '\003'
            Intent intent1 = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(11);
            startActivity(intent1);
            finish();
            return;

        case 6: // '\006'
            Intent intent2 = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(21);
            startActivity(intent2);
            finish();
            return;

        case 4: // '\004'
            Intent intent3 = new Intent(this, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
            if (AkGameFactory.sharedInstance().getAkinatorStatus() == 2)
            {
                intent3.putExtra("ActivityMode", 1);
            } else
            {
                intent3.putExtra("ActivityMode", 2);
            }
            startActivity(intent3);
            finish();
            return;

        case 5: // '\005'
            intent4 = new Intent(this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
            break;
        }
        if (AkGameFactory.sharedInstance().getAkinatorStatus() == 2)
        {
            intent4.putExtra("gagne_ou_perdu", false);
        } else
        {
            intent4.putExtra("gagne_ou_perdu", true);
        }
        startActivity(intent4);
        finish();
    }

    private void appelValide()
    {
        Intent intent;
        intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
        if (activityMode)
        {
            int i = AkGameFactory.sharedInstance().getCptNbAjoutsMinibase();
            if (i == 1)
            {
                intent.putExtra("DemandeDesaCeleb", true);
            }
            if (i == 2)
            {
                intent.putExtra("AfficheTipOptions", true);
            }
        }
        if (AkGameFactory.sharedInstance().getAkinatorStatus() != 2) goto _L2; else goto _L1
_L1:
        if (activityMode) goto _L4; else goto _L3
_L3:
        if (mbSelectedCharacter.getNbPlayed() > 3)
        {
            AkGameFactory.sharedInstance().setGameOverActivityState(1);
        } else
        {
            AkGameFactory.sharedInstance().setGameOverActivityState(21);
            String s = TraductionFactory.sharedInstance().getTraductionFromToken((new StringBuilder()).append("TIP_SUITE_REJOUE_").append(AkGameFactory.sharedInstance().getNextVarianteTextAugmenteTaBase() + 1).toString());
            AkGameFactory.sharedInstance().setGameOverActivityInfo(s);
        }
_L6:
        startActivity(intent);
        finish();
        return;
_L4:
        if (activityMode)
        {
            AkGameFactory.sharedInstance().setGameOverActivityState(21);
            String s1 = TraductionFactory.sharedInstance().getTraductionFromToken((new StringBuilder()).append("TIP_SUITE_AJOUT_").append(AkGameFactory.sharedInstance().getNextVarianteTextAjoutPerso() + 1).toString());
            AkGameFactory.sharedInstance().setGameOverActivityInfo(s1);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (activityMode)
        {
            AkGameFactory.sharedInstance().setGameOverActivityState(21);
            String s2 = TraductionFactory.sharedInstance().getTraductionFromToken((new StringBuilder()).append("TIP_SUITE_AJOUT_").append(AkGameFactory.sharedInstance().getNextVarianteTextAjoutPerso() + 1).toString());
            AkGameFactory.sharedInstance().setGameOverActivityInfo(s2);
        } else
        {
            AkGameFactory.sharedInstance().setGameOverActivityState(11);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void appelRetourModif()
    {
        switch (ActivityCaller)
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            goToHome();
            return;

        case 2: // '\002'
            Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(1);
            startActivity(intent);
            finish();
            return;

        case 3: // '\003'
            Intent intent1 = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(11);
            startActivity(intent1);
            finish();
            return;

        case 6: // '\006'
            Intent intent2 = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            AkGameFactory.sharedInstance().setGameOverActivityState(21);
            startActivity(intent2);
            finish();
            return;

        case 1: // '\001'
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/MinibaseActivity));
            finish();
            return;
        }
    }

    public int getPictureOrientation(Uri uri)
    {
        uri = getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (uri.getCount() != 1)
        {
            return -1;
        }
        int i;
        try
        {
            uri.moveToFirst();
            i = uri.getInt(0);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return -1;
        }
        return i;
    }

    public void launchDialogPictureChooser()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISISSEZ_VOTRE_ACTION"));
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("PRENDRE_UNE_PHOTO");
        String s1 = TraductionFactory.sharedInstance().getTraductionFromToken("UTILISER_UNE_PHOTO_EXISTANTE");
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final AjoutModifPersoMBActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i != 0) goto _L2; else goto _L1
_L1:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 3);
_L4:
                dialoginterface.dismiss();
                return;
_L2:
                if (i == 1)
                {
                    Intent intent1 = new Intent("android.intent.action.GET_CONTENT", null);
                    intent1.setType("image/*");
                    intent1.putExtra("return-data", true);
                    startActivityForResult(intent1, 0);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        };
        builder.setItems(new CharSequence[] {
            s, s1
        }, onclicklistener);
        builder.show();
    }

    public void loadNewPicture()
    {
        (new AsyncTask() {

            private Dialog mProgressDialog;
            final AjoutModifPersoMBActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                rescalePicture();
_L2:
                return null;
                avoid;
_L3:
                avoid.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
                avoid;
                  goto _L3
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                try
                {
                    if (mProgressDialog != null && mProgressDialog.isShowing())
                    {
                        mProgressDialog.dismiss();
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    mProgressDialog = null;
                }
                if (rescaledBitmap != null)
                {
                    uiPhotoImage.setImageBitmap(rescaledBitmap);
                    uiTextFacultatif.setVisibility(4);
                    return;
                } else
                {
                    Toast.makeText(AjoutModifPersoMBActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                    return;
                }
            }

            protected void onPreExecute()
            {
                mProgressDialog = CustomLoadingDialog.show(AjoutModifPersoMBActivity.this);
            }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        targetUri = null;
        if (i != 666) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i != 3 || j != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (intent == null || !intent.getExtras().containsKey("data")) goto _L1; else goto _L3
_L3:
        bitmap = (Bitmap)intent.getExtras().get("data");
        rescalePicture();
        uiPhotoImage.setImageBitmap(rescaledBitmap);
        uiTextFacultatif.setVisibility(4);
        return;
        if (j != -1) goto _L1; else goto _L4
_L4:
        targetUri = intent.getData();
        loadNewPicture();
        return;
    }

    public void onBackPressed()
    {
        appelRetour();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!mIsRebooting)
        {
            setContentView(0x7f03001b);
            activityMode = true;
            ActivityCaller = 1;
            try
            {
                activityMode = getIntent().getExtras().getBoolean("ActivityMode", true);
                ActivityCaller = getIntent().getExtras().getInt("ActivityCaller", 1);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            uiActivityTitleText = (TextView)findViewById(0x7f0d008f);
            uiConfidentialityText = (TextView)findViewById(0x7f0d0092);
            uiNomPersoDansAkinatorText = (TextView)findViewById(0x7f0d0093);
            uiNomEditText = (EditText)findViewById(0x7f0d0096);
            uiPhotoImage = (ImageView)findViewById(0x7f0d0094);
            uiBoutonValide = (Button)findViewById(0x7f0d0097);
            uiBoutonRetour = (ImageView)findViewById(0x7f0d0133);
            uiTextFacultatif = (TextView)findViewById(0x7f0d0095);
            uiTextFacultatif.setText(TraductionFactory.sharedInstance().getTraductionFromToken("FACULTATIF"));
            uiTextFacultatif.setTypeface(tf);
            uiActivityTitleText.setTypeface(tf);
            uiConfidentialityText.setTypeface(tf);
            uiNomEditText.setTypeface(tf);
            uiBoutonValide.setTypeface(tf);
            uiNomPersoDansAkinatorText.setTypeface(tf);
            addTextView(uiTextFacultatif);
            addTextView(uiActivityTitleText);
            addTextView(uiConfidentialityText);
            addTextView(uiNomEditText);
            addTextView(uiBoutonValide);
            addTextView(uiNomPersoDansAkinatorText);
            updateTextViewsSize();
            uiPhotoImage.setOnClickListener(photoClickListener);
            uiBoutonValide.setOnClickListener(valideClickListener);
            uiBoutonRetour.setOnClickListener(retourClickListener);
            uiNomEditText.setText("");
            if (!activityMode)
            {
                if (ActivityCaller == 6 || ActivityCaller == 2 || ActivityCaller == 3)
                {
                    mbSelectedCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
                } else
                {
                    mbSelectedCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)getIntent().getSerializableExtra("minibaseCharacterToModify");
                }
                bundle = MinibaseFactory.sharedInstance().getMBCharacterPicture(this, mbSelectedCharacter);
                if (bundle != null)
                {
                    uiPhotoImage.setImageBitmap(bundle);
                    uiTextFacultatif.setVisibility(4);
                }
                uiNomEditText.setText(mbSelectedCharacter.getName());
            } else
            {
                mbSelectedCharacter = new com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase();
                mbSelectedCharacter.setElementMinibaseId(-1);
                mbSelectedCharacter.setName("");
            }
            uiNomPersoDansAkinatorText.setText("");
            if (activityMode)
            {
                uiNomPersoDansAkinatorText.setText(AkSessionFactory.sharedInstance().getCharacterNameProposed());
            }
            if (activityMode)
            {
                uiActivityTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_DANS_MY_WORLD"));
            } else
            {
                uiActivityTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MODIFIER_DANS_MY_WORLD"));
            }
            uiConfidentialityText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUT_PERSO_MYWORLD_MSG_CONFIDENTIALITE"));
            uiNomEditText.setHint(TraductionFactory.sharedInstance().getTraductionFromToken("PRENOM_NOM_PSEUDO"));
            uiBoutonValide.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER"));
            if (activityMode)
            {
                AkAnalyticsFactory.sharedInstance().logAffichageAjoutProcheMW();
                return;
            }
        }
    }

    public void onResume()
    {
        super.onResume();
        if (!mIsRebooting)
        {
            AkConfigFactory.sharedInstance().updateDebutAddMB();
        }
    }

    public void rescalePicture()
    {
        if (bitmap.getHeight() == bitmap.getWidth())
        {
            rescaledBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, true);
        } else
        if (bitmap.getHeight() > bitmap.getWidth())
        {
            rescaledBitmap = Bitmap.createScaledBitmap(bitmap, 480, (bitmap.getHeight() * 480) / bitmap.getWidth(), true);
        } else
        {
            rescaledBitmap = Bitmap.createScaledBitmap(bitmap, 640, (bitmap.getHeight() * 640) / bitmap.getWidth(), true);
        }
        if (targetUri != null)
        {
            int i = getPictureOrientation(targetUri);
            if (i > 0)
            {
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                rescaledBitmap = Bitmap.createBitmap(rescaledBitmap, 0, 0, rescaledBitmap.getWidth(), rescaledBitmap.getHeight(), matrix, true);
            }
        }
        try
        {
            bitmap.recycle();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }







/*
    static Bitmap access$502(AjoutModifPersoMBActivity ajoutmodifpersombactivity, Bitmap bitmap1)
    {
        ajoutmodifpersombactivity.bitmap = bitmap1;
        return bitmap1;
    }

*/



}
