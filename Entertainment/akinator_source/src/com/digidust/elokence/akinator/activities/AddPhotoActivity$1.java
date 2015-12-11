// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.TraductionFactory;
import java.io.FileNotFoundException;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AddPhotoActivity

class this._cls0 extends AsyncTask
{

    private Dialog mProgressDialog;
    final AddPhotoActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AddPhotoActivity.access$002(AddPhotoActivity.this, BitmapFactory.decodeStream(getContentResolver().openInputStream(AddPhotoActivity.access$100(AddPhotoActivity.this))));
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
        if (AddPhotoActivity.access$200(AddPhotoActivity.this) != null)
        {
            AddPhotoActivity.access$300(AddPhotoActivity.this).setImageBitmap(AddPhotoActivity.access$200(AddPhotoActivity.this));
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

    ()
    {
        this$0 = AddPhotoActivity.this;
        super();
    }
}
