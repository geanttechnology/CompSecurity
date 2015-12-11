// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.EditText;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            CustomizeActivity

class mProgressDialog extends AsyncTask
{

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
        if (CustomizeActivity.access$300(CustomizeActivity.this) != null)
        {
            s = writeNewPictureToMemory();
        }
        CustomizeActivity.access$700(CustomizeActivity.this);
        avoid = null;
        obj2 = null;
        Object obj = new AkDBAdapter(CustomizeActivity.this);
        ((AkDBAdapter) (obj)).updateCharacterToDB(CustomizeActivity.access$800(CustomizeActivity.this), mCustomizeCharacterName, s);
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
        CustomizeActivity.access$900(CustomizeActivity.this);
    }

    protected void onPreExecute()
    {
        mProgressDialog = CustomLoadingDialog.show(CustomizeActivity.this);
        mCustomizeCharacterName = CustomizeActivity.access$600(CustomizeActivity.this).getText().toString();
    }

    ()
    {
        this$0 = CustomizeActivity.this;
        super();
        mProgressDialog = null;
    }
}
