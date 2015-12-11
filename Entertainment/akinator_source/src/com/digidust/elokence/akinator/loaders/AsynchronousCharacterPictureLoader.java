// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.loaders;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.digidust.elokence.akinator.loaders:
//            CustomLoadingDialog

public class AsynchronousCharacterPictureLoader extends AsyncTask
{

    Bitmap mBmp;
    Context mContext;
    Dialog mProgressDialog;
    String mUrl;
    ImageView uiImageView;

    public AsynchronousCharacterPictureLoader(Context context, ImageView imageview, String s)
    {
        mBmp = null;
        mContext = context;
        uiImageView = imageview;
        mUrl = s;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AkLog.d("AkinatorACPL", (new StringBuilder()).append("DoInBackground. mUrl = ").append(mUrl).toString());
        if (mUrl != null && uiImageView != null)
        {
            mBmp = downloadPicture(mUrl);
        }
        return null;
    }

    public Bitmap downloadPicture(String s)
    {
label0:
        {
            Object obj = null;
            AkLog.d("AkinatorACPL", (new StringBuilder()).append("Download picture ").append(s).toString());
            Bitmap bitmap = obj;
            if (s != null)
            {
                if (!s.startsWith("http"))
                {
                    break label0;
                }
                bitmap = obj;
                if (AkConfigFactory.sharedInstance().canDownloadPicture())
                {
                    try
                    {
                        s = (HttpURLConnection)(new URL(s)).openConnection();
                        s.setDoInput(true);
                        s.setConnectTimeout(5000);
                        s.connect();
                        bitmap = BitmapFactory.decodeStream(s.getInputStream());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        AkLog.e("AkinatorACPL", (new StringBuilder()).append("DL URL MALFORMEE : ").append(s).toString());
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        AkLog.e("AkinatorACPL", (new StringBuilder()).append("DL IO EXCEPTION : ").append(s).toString());
                        return null;
                    }
                }
            }
            return bitmap;
        }
        try
        {
            s = BitmapFactory.decodeFile(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AkLog.e("AkinatorACPL", (new StringBuilder()).append("DL DECODE FILE FAILED : ").append(s).toString());
            return null;
        }
        return s;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        float f;
        float f1;
        float f2;
        float f3;
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
        AkLog.d("AkinatorACPL", "PostExecute mBmp?");
        if (uiImageView == null || mUrl == null || mBmp == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        AkLog.d("AkinatorACPL", "postExecute : pas de null");
        try
        {
            f = uiImageView.getWidth();
            f1 = uiImageView.getHeight();
            f3 = mBmp.getWidth();
            f2 = mBmp.getHeight();
            f /= f3;
            f1 /= f2;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            AkLog.e("Akinator", "PB DE MEMOIRE POUR CHARGER L'IMAGE DU PERSONNAGE");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            AkLog.e("Akinator", "PB DE SIZE BMP");
            return;
        }
        if (f >= f1)
        {
            f = f1;
        }
        f1 = f3 * f;
        f2 *= f;
        AkLog.d("AkinatorACPL", (new StringBuilder()).append("Ratio : ").append(f).append(", new size : ").append(f1).append(" * ").append(f2).toString());
        mBmp = Bitmap.createScaledBitmap(mBmp, (int)f1, (int)f2, true);
        uiImageView.setImageBitmap(mBmp);
_L1:
        return;
        if (mBmp == null && uiImageView != null)
        {
            uiImageView.setImageResource(0x7f0202e6);
            return;
        }
          goto _L1
    }

    protected void onPreExecute()
    {
        mProgressDialog = CustomLoadingDialog.show(mContext);
    }
}
