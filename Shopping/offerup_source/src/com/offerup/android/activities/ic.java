// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.b.a.a.g;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.offerup.android.utils.ba;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            id, TruYouInitActivity

final class ic extends AsyncTask
{

    final TruYouInitActivity a;

    ic(TruYouInitActivity truyouinitactivity)
    {
        a = truyouinitactivity;
        super();
    }

    private transient Void a()
    {
        AccessToken accesstoken;
        if (!StringUtils.isNotEmpty(ba.b()))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        accesstoken = AccessToken.getCurrentAccessToken();
        if (accesstoken != null)
        {
            try
            {
                GraphRequest.newMeRequest(accesstoken, new id(this)).executeAndWait();
                if (StringUtils.isNotEmpty(accesstoken.getToken()))
                {
                    TruYouInitActivity.a(a, accesstoken);
                    TruYouInitActivity.a(a, true);
                }
            }
            catch (Exception exception)
            {
                g.a(this, exception);
            }
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        a.i();
        try
        {
            if (TruYouInitActivity.d(a))
            {
                TruYouInitActivity.e(a);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        TruYouInitActivity.c(a);
        return;
    }

    protected final void onPreExecute()
    {
        a.g = ProgressDialog.show(a, "", "Verifying your Facebook account...");
    }
}
