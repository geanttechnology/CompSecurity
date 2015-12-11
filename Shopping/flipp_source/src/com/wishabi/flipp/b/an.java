// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.net.Uri;
import android.os.AsyncTask;
import com.wishabi.flipp.util.k;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            ak, a

public final class an extends AsyncTask
{

    public an()
    {
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = Uri.parse("https://backflipp.wishabi.com/msa").buildUpon();
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("locale", Locale.getDefault().toString());
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("postal_code", k.a(null));
        return ak.a(((android.net.Uri.Builder) (aobj)).build());
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (JSONObject)obj;
        a a1 = a.a;
        a.a(((JSONObject) (obj)));
    }
}
