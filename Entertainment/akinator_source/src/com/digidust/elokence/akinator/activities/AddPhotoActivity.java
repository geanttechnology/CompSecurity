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
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.AsynchronousCharacterPictureLoader;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity, WebviewCGV

public class AddPhotoActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    private Bitmap bitmap;
    com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase mSelectedCharacter;
    private Bitmap rescaledBitmap;
    private Uri targetUri;
    private Button uiEnvoyer;
    private Button uiLoadPictureButton;
    private ImageView uiPicture;
    private ImageView uiReturnButton;
    private TextView uiTextPersonnalisation;

    public AddPhotoActivity()
    {
        mSelectedCharacter = null;
    }

    private void sendPhoto()
    {
        (new AsyncTask() {

            private Dialog mProgressDialog;
            final AddPhotoActivity this$0;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().getSession().addPhotoToObjectWithId(mSelectedCharacter.getIdBase(), rescaledBitmap));
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
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("added_photo");
                    AkSessionFactory.sharedInstance().setPhotoAlreadyProposed(true);
                    integer = new Intent(AddPhotoActivity.this, com/digidust/elokence/akinator/activities/GameOverActivity);
                    integer.putExtra("hasToDisplayPhotoAdded", true);
                    startActivity(integer);
                    finish();
                    return;
                }
                if (integer.intValue() == 110)
                {
                    integer = new android.app.AlertDialog.Builder(AddPhotoActivity.this);
                    integer.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
                    integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("L_EXTENSION_NE_SEMBLE_PAS_CORRESPONDRE_A_UNE_IMAGE_VALIDE"));
            /* block-local class not found */
            class _cls1 {}

                    integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new _cls1());
                    integer.create().show();
                    return;
                }
                if (integer.intValue() == 130)
                {
                    integer = new android.app.AlertDialog.Builder(AddPhotoActivity.this);
                    integer.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
                    integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("IMAGE_EN_COURS_DE_VALIDATION"));
            /* block-local class not found */
            class _cls2 {}

                    integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new _cls2());
                    integer.create().show();
                    return;
                } else
                {
                    Toast.makeText(AddPhotoActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                mProgressDialog = CustomLoadingDialog.show(AddPhotoActivity.this);
            }

            
            {
                this$0 = AddPhotoActivity.this;
                super();
                mProgressDialog = null;
            }
        }).execute(new Void[0]);
    }

    private void updateCharacter()
    {
        AkLog.w("Akinator", (new StringBuilder()).append("Path du fichier image : ").append(mSelectedCharacter.getPicturePath()).toString());
        if (mSelectedCharacter.getPicturePath() != null)
        {
            (new AsynchronousCharacterPictureLoader(this, uiPicture, mSelectedCharacter.getPicturePath())).execute(new Void[0]);
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
            uri.close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return -1;
        }
        return i;
    }

    public void goBack()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
        finish();
    }

    public void launchDialogPictureChooser()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISISSEZ_VOTRE_ACTION"));
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("PRENDRE_UNE_PHOTO");
        String s1 = TraductionFactory.sharedInstance().getTraductionFromToken("UTILISER_UNE_PHOTO_EXISTANTE");
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final AddPhotoActivity this$0;

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
                    Intent intent1 = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, 0);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = AddPhotoActivity.this;
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
            final AddPhotoActivity this$0;

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
                    uiPicture.setImageBitmap(rescaledBitmap);
                    return;
                } else
                {
                    Toast.makeText(AddPhotoActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                    return;
                }
            }

            protected void onPreExecute()
            {
                mProgressDialog = CustomLoadingDialog.show(AddPhotoActivity.this);
            }

            
            {
                this$0 = AddPhotoActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        AkLog.d("AddPhotoActivity", (new StringBuilder()).append("onActivityResult ").append(i).append(" ").append(j).toString());
        super.onActivityResult(i, j, intent);
        targetUri = null;
        if (i != 2) goto _L2; else goto _L1
_L1:
        if (j == 0)
        {
            goToHome();
        }
_L4:
        return;
_L2:
        if (i != 3 || j != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (intent == null || !intent.getExtras().containsKey("data")) goto _L4; else goto _L3
_L3:
        bitmap = (Bitmap)intent.getExtras().get("data");
        rescalePicture();
        uiPicture.setImageBitmap(rescaledBitmap);
        Log.d("AddPhotoActivity", "image rescal\351e");
        return;
        if (j != -1) goto _L4; else goto _L5
_L5:
        targetUri = intent.getData();
        loadNewPicture();
        return;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        goBack();
    }

    public void onClick(View view)
    {
        if (view == uiLoadPictureButton)
        {
            view = new Intent("android.intent.action.GET_CONTENT", null);
            view.setType("image/*");
            view.putExtra("return-data", true);
            startActivityForResult(view, 0);
        } else
        {
            if (view == uiEnvoyer)
            {
                if (rescaledBitmap == null)
                {
                    Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("SELECTIONNEZ_DABORD_PHOTO"), 0).show();
                    return;
                } else
                {
                    sendPhoto();
                    return;
                }
            }
            if (view == uiReturnButton)
            {
                AkGameFactory.sharedInstance().setCanShowAd(false);
                goBack();
                return;
            }
            if (view == uiTextPersonnalisation)
            {
                disableAdOneTime();
                view = new Intent(this, com/digidust/elokence/akinator/activities/WebviewCGV);
                view.putExtra("url", "http://cgu.akinator.com/mobile/content#inpi");
                startActivity(view);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        Log.d("AddPhotoActivity", "onCreate");
        setContentView(0x7f030019);
        mSelectedCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
        if (mSelectedCharacter == null)
        {
            bundle = new Message();
            bundle.what = 3;
            mHandler.sendMessage(bundle);
        }
        uiTextPersonnalisation = (TextView)findViewById(0x7f0d0086);
        uiTextPersonnalisation.setOnClickListener(this);
        uiReturnButton = (ImageView)findViewById(0x7f0d0133);
        uiLoadPictureButton = (Button)findViewById(0x7f0d0088);
        uiEnvoyer = (Button)findViewById(0x7f0d0089);
        uiPicture = (ImageView)findViewById(0x7f0d0087);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiTextPersonnalisation.setTypeface(tf);
        uiEnvoyer.setTypeface(tf);
        uiLoadPictureButton.setTypeface(tf);
        addTextView(uiEnvoyer);
        addTextView(uiLoadPictureButton);
        addTextView(uiTextPersonnalisation);
        updateTextViewsSize();
        uiTextPersonnalisation.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BY_CHECKING_THIS_BOX_YOU_ALLOW_ELOKENCE_TO_USE_THIS_PICTURE_AND_CERTIFY_OWNING_ITS_RIGHTS"));
        uiEnvoyer.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ENVOYER"));
        uiLoadPictureButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISIR_UNE_PHOTO"));
        uiEnvoyer.setOnClickListener(this);
        uiReturnButton.setOnClickListener(this);
        uiLoadPictureButton.setOnClickListener(this);
        updateCharacter();
    }

    public void onResume()
    {
        AkGameFactory.sharedInstance().setCanShowAd(false);
        super.onResume();
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
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }


/*
    static Bitmap access$002(AddPhotoActivity addphotoactivity, Bitmap bitmap1)
    {
        addphotoactivity.bitmap = bitmap1;
        return bitmap1;
    }

*/



}
