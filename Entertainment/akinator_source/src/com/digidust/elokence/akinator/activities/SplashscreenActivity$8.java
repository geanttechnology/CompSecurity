// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.os.AsyncTask;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0 extends AsyncTask
{

    final SplashscreenActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        while (!SplashscreenActivity.access$000(SplashscreenActivity.this)) 
        {
            try
            {
                Thread.sleep(10L);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        void1 = new android.app.it>(SplashscreenActivity.this);
        void1.Message(TraductionFactory.sharedInstance().getTraductionFromToken("UNE_NOUVELLE_VERSION_EST_DISPONIBLE"));
    /* block-local class not found */
    class _cls1 {}

        void1.PositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), new _cls1());
    /* block-local class not found */
    class _cls2 {}

        void1.NegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"), new _cls2());
        void1.ate().show();
    }

    _cls2()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}
