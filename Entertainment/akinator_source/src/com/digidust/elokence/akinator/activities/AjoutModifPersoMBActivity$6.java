// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.TraductionFactory;
import java.io.FileNotFoundException;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AjoutModifPersoMBActivity

class this._cls0 extends AsyncTask
{

    private Dialog mProgressDialog;
    final AjoutModifPersoMBActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AjoutModifPersoMBActivity.access$502(AjoutModifPersoMBActivity.this, BitmapFactory.decodeStream(getContentResolver().openInputStream(AjoutModifPersoMBActivity.access$600(AjoutModifPersoMBActivity.this))));
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
        if (AjoutModifPersoMBActivity.access$100(AjoutModifPersoMBActivity.this) != null)
        {
            AjoutModifPersoMBActivity.access$700(AjoutModifPersoMBActivity.this).setImageBitmap(AjoutModifPersoMBActivity.access$100(AjoutModifPersoMBActivity.this));
            AjoutModifPersoMBActivity.access$800(AjoutModifPersoMBActivity.this).setVisibility(4);
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

    ()
    {
        this$0 = AjoutModifPersoMBActivity.this;
        super();
    }
}
