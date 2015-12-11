// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.AsynchronousCharacterPictureLoader;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity

public class CustomizeActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    public static final String DISPLAY_ALERT = "displayCustomizeAlert";
    private com.elokence.limuleapi.Session.ProposedLimuleObject akSelectedCharacter;
    private com.elokence.limuleapi.Session.ProposedLimuleObject akSelectedCharacterAvantPerso;
    private Bitmap bitmap;
    boolean hasReseted;
    private android.view.View.OnClickListener mRetourClickListener;
    private Bitmap rescaledBitmap;
    private AsyncTask savePictureAT;
    private Uri targetUri;
    private EditText uiCustomizeCharacterName;
    private Button uiLoadPictureButton;
    private Button uiOkButton;
    private ImageView uiPicture;
    private Button uiResetPictureButton;
    private ImageView uiReturnButton;
    private TextView uiTextPersonnalisation;

    public CustomizeActivity()
    {
        hasReseted = false;
        mRetourClickListener = new android.view.View.OnClickListener() {

            final CustomizeActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = CustomizeActivity.this;
                super();
            }
        };
    }

    private void SavePerso()
    {
        Object obj;
        Object obj1;
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        boolean flag1;
        if (rescaledBitmap != null)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("SAUVEGARDE_DE_L_IMAGE_EN_COURS"), 0).show();
        }
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        obj1 = null;
        obj = null;
        flag1 = false;
        Object obj2 = new AkDBAdapter(this);
        boolean flag = ((AkDBAdapter) (obj2)).getCustomNameAndUrlFromDB(akSelectedCharacter, stringbuffer, stringbuffer1);
        obj = obj2;
        flag1 = flag;
        if (obj2 != null)
        {
            ((AkDBAdapter) (obj2)).close();
            flag1 = flag;
            obj = obj2;
        }
_L3:
        if (!flag1 || rescaledBitmap != null || !uiCustomizeCharacterName.getText().toString().equals(stringbuffer.toString())) goto _L2; else goto _L1
_L1:
        if (!hasReseted)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        resetCharacterNameAndUrl();
        obj1 = new AkDBAdapter(this);
        obj = obj1;
        ((AkDBAdapter) (obj1)).eraseCharacterFromDB(akSelectedCharacter);
        ((AkDBAdapter) (obj1)).close();
_L4:
        onBack();
        return;
        obj2;
_L9:
        obj1 = obj;
        ((Exception) (obj2)).printStackTrace();
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
          goto _L3
        obj;
_L8:
        if (obj1 != null)
        {
            ((AkDBAdapter) (obj1)).close();
        }
        throw obj;
        obj2;
        obj1 = obj;
_L7:
        obj = obj1;
        ((Exception) (obj2)).printStackTrace();
        ((AkDBAdapter) (obj1)).close();
          goto _L4
        obj1;
_L6:
        ((AkDBAdapter) (obj)).close();
        throw obj1;
_L2:
        if (!flag1 && rescaledBitmap == null && uiCustomizeCharacterName.getText().toString().equals(akSelectedCharacter.getName()))
        {
            onBack();
            return;
        } else
        {
            saveOrUpdatedSelectedCharacter();
            MetricsSetAdapter.sharedInstance().incMetricCompteur("tyf_adds");
            return;
        }
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
          goto _L7
        obj;
        obj1 = obj2;
          goto _L8
        Exception exception;
        exception;
        obj = obj2;
        obj2 = exception;
          goto _L9
    }

    private void checkResetButtonVisibility()
    {
        Object obj;
        StringBuffer stringbuffer;
        Object obj3;
        StringBuffer stringbuffer1;
        boolean flag1;
        obj = null;
        obj3 = null;
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        flag1 = false;
        resetCharacterNameAndUrl();
        Object obj1 = new AkDBAdapter(this);
        boolean flag = ((AkDBAdapter) (obj1)).getCustomNameAndUrlFromDB(akSelectedCharacter, stringbuffer, stringbuffer1);
        if (obj1 != null)
        {
            ((AkDBAdapter) (obj1)).close();
        }
_L1:
        Object obj2;
        if (flag)
        {
            uiResetPictureButton.setVisibility(0);
            return;
        } else
        {
            uiResetPictureButton.setVisibility(4);
            return;
        }
        obj2;
        obj1 = obj3;
_L4:
        obj = obj1;
        ((Exception) (obj2)).printStackTrace();
        flag = flag1;
        if (obj1 != null)
        {
            ((AkDBAdapter) (obj1)).close();
            flag = flag1;
        }
          goto _L1
        obj1;
_L3:
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L3; else goto _L2
_L2:
        obj2;
          goto _L4
    }

    private void goBackWithAlert()
    {
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
        intent.putExtra("displayCustomizeAlert", true);
        startActivity(intent);
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    private void onBack()
    {
        super.onBackPressed();
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    private void resetCharacterNameAndUrl()
    {
        Object obj;
        StringBuffer stringbuffer;
        Object obj3;
        StringBuffer stringbuffer1;
        obj = null;
        obj3 = null;
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        Object obj1 = new AkDBAdapter(this);
        ((AkDBAdapter) (obj1)).getCustomNameAndUrlFromDB(akSelectedCharacter, stringbuffer, stringbuffer1);
        if (!stringbuffer.toString().isEmpty())
        {
            akSelectedCharacter.setName(stringbuffer.toString());
        }
        if (!stringbuffer1.toString().isEmpty())
        {
            akSelectedCharacter.setPicturePath(stringbuffer1.toString());
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        ((AkDBAdapter) (obj1)).close();
_L2:
        return;
        Object obj2;
        obj2;
        obj1 = obj3;
_L5:
        obj = obj1;
        ((Exception) (obj2)).printStackTrace();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        ((AkDBAdapter) (obj1)).close();
        return;
        obj1;
_L4:
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
          goto _L5
    }

    private void saveOrUpdatedSelectedCharacter()
    {
        savePictureAT = new AsyncTask() {

            private String mCustomizeCharacterName;
            private Dialog mProgressDialog;
            final CustomizeActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                String s;
                Object obj2;
                s = "";
                if (rescaledBitmap != null)
                {
                    s = writeNewPictureToMemory();
                }
                resetCharacterNameAndUrl();
                avoid = null;
                obj2 = null;
                Object obj = new AkDBAdapter(CustomizeActivity.this);
                ((AkDBAdapter) (obj)).updateCharacterToDB(akSelectedCharacter, mCustomizeCharacterName, s);
                if (obj != null)
                {
                    ((AkDBAdapter) (obj)).close();
                }
_L1:
                return null;
                Object obj1;
                obj1;
                obj = obj2;
_L4:
                avoid = ((Void []) (obj));
                ((Exception) (obj1)).printStackTrace();
                if (obj != null)
                {
                    ((AkDBAdapter) (obj)).close();
                }
                  goto _L1
                obj;
_L3:
                if (avoid != null)
                {
                    avoid.close();
                }
                throw obj;
                obj1;
                avoid = ((Void []) (obj));
                obj = obj1;
                if (true) goto _L3; else goto _L2
_L2:
                obj1;
                  goto _L4
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
                goBackWithAlert();
            }

            protected void onPreExecute()
            {
                mProgressDialog = CustomLoadingDialog.show(CustomizeActivity.this);
                mCustomizeCharacterName = uiCustomizeCharacterName.getText().toString();
            }

            
            {
                this$0 = CustomizeActivity.this;
                super();
                mProgressDialog = null;
            }
        };
        savePictureAT.execute(new Void[0]);
    }

    public int getPictureOrientation(Uri uri)
    {
        uri = getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (uri.getCount() != 1)
        {
            return -1;
        } else
        {
            uri.moveToFirst();
            return uri.getInt(0);
        }
    }

    public void launchDialogPictureChooser()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISISSEZ_VOTRE_ACTION"));
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("PRENDRE_UNE_PHOTO");
        String s1 = TraductionFactory.sharedInstance().getTraductionFromToken("UTILISER_UNE_PHOTO_EXISTANTE");
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CustomizeActivity this$0;

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
                this$0 = CustomizeActivity.this;
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
            final CustomizeActivity this$0;

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
                    uiResetPictureButton.setVisibility(0);
                    return;
                } else
                {
                    Toast.makeText(CustomizeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                    return;
                }
            }

            protected void onPreExecute()
            {
                mProgressDialog = CustomLoadingDialog.show(CustomizeActivity.this);
            }

            
            {
                this$0 = CustomizeActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
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
        return;
        if (j != -1) goto _L4; else goto _L5
_L5:
        targetUri = intent.getData();
        loadNewPicture();
        return;
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onClick(View view)
    {
        if (view == uiLoadPictureButton)
        {
            launchDialogPictureChooser();
        } else
        {
            if (view == uiResetPictureButton)
            {
                resetCharacterNameAndUrl();
                uiCustomizeCharacterName.setText(akSelectedCharacter.getName());
                (new AsynchronousCharacterPictureLoader(this, uiPicture, akSelectedCharacter.getPicturePath())).execute(new Void[0]);
                rescaledBitmap = null;
                uiResetPictureButton.setVisibility(4);
                hasReseted = true;
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNAGE_REINITIALISE"), 0).show();
                SavePerso();
                onBack();
                return;
            }
            if (view == uiOkButton)
            {
                SavePerso();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        StringBuffer stringbuffer;
        Object obj2;
        StringBuffer stringbuffer1;
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        setContentView(0x7f03001f);
        akSelectedCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        bundle = null;
        obj2 = null;
        Object obj = new AkDBAdapter(this);
        ((AkDBAdapter) (obj)).getCustomNameAndUrlFromDB(akSelectedCharacter, stringbuffer, stringbuffer1);
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
_L1:
        if (akSelectedCharacter == null)
        {
            bundle = new Message();
            bundle.what = 3;
            mHandler.sendMessage(bundle);
        }
        uiTextPersonnalisation = (TextView)findViewById(0x7f0d0086);
        uiOkButton = (Button)findViewById(0x7f0d00cd);
        uiReturnButton = (ImageView)findViewById(0x7f0d0133);
        uiLoadPictureButton = (Button)findViewById(0x7f0d0088);
        uiResetPictureButton = (Button)findViewById(0x7f0d00ce);
        uiPicture = (ImageView)findViewById(0x7f0d0087);
        uiCustomizeCharacterName = (EditText)findViewById(0x7f0d00cc);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiTextPersonnalisation.setTypeface(tf);
        uiOkButton.setTypeface(tf);
        uiLoadPictureButton.setTypeface(tf);
        uiResetPictureButton.setTypeface(tf);
        addTextView(uiOkButton);
        addTextView(uiLoadPictureButton);
        addTextView(uiResetPictureButton);
        addTextView(uiTextPersonnalisation);
        updateTextViewsSize();
        uiTextPersonnalisation.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNALISER_2"));
        uiOkButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER"));
        uiLoadPictureButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MODIFIER_LA_PHOTO_DU_PERSONNAGE"));
        uiResetPictureButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REINITIALISER_LE_PERSONNAGE"));
        uiOkButton.setOnClickListener(this);
        uiReturnButton.setOnClickListener(mRetourClickListener);
        uiLoadPictureButton.setOnClickListener(this);
        uiTextPersonnalisation.setOnClickListener(this);
        uiResetPictureButton.setOnClickListener(this);
        uiCustomizeCharacterName.setText(akSelectedCharacter.getName());
        (new AsynchronousCharacterPictureLoader(this, uiPicture, akSelectedCharacter.getPicturePath())).execute(new Void[0]);
        checkResetButtonVisibility();
        return;
        Object obj1;
        obj1;
        obj = obj2;
_L4:
        bundle = ((Bundle) (obj));
        ((Exception) (obj1)).printStackTrace();
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
          goto _L1
        obj;
_L3:
        if (bundle != null)
        {
            bundle.close();
        }
        throw obj;
        obj1;
        bundle = ((Bundle) (obj));
        obj = obj1;
        if (true) goto _L3; else goto _L2
_L2:
        obj1;
          goto _L4
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

    public String writeNewPictureToMemory()
    {
        String s;
        try
        {
            AkLog.w("Akinator", "Ecriture de l'image commenc\351e");
            s = (new StringBuilder()).append("").append(akSelectedCharacter.getIdBase()).append(".png").toString();
            java.io.FileOutputStream fileoutputstream = openFileOutput(s, 0);
            rescaledBitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
            s = (new StringBuilder()).append(getFilesDir().getAbsolutePath()).append("/").append(s).toString();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }



/*
    static Bitmap access$102(CustomizeActivity customizeactivity, Bitmap bitmap1)
    {
        customizeactivity.bitmap = bitmap1;
        return bitmap1;
    }

*/








}
