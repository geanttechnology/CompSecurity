// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.wishabi.flipp.content.i;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            ak

public final class ar extends AsyncTask
{

    private final ContentResolver a;
    private final Context b;
    private final String c = Locale.getDefault().toString();

    public ar(ContentResolver contentresolver, Context context)
    {
        a = contentresolver;
        b = context;
    }

    private transient Boolean a()
    {
        Object obj;
        Object obj2;
        obj = Uri.parse("https://backflipp.wishabi.com/cat_dict").buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("locale", Locale.getDefault().toString());
        obj = ((android.net.Uri.Builder) (obj)).build();
        if (obj == null)
        {
            return Boolean.valueOf(false);
        }
        obj2 = ak.a(((Uri) (obj)));
        if (obj2 == null)
        {
            return Boolean.valueOf(false);
        }
        obj = new ArrayList();
        ((ArrayList) (obj)).add(ContentProviderOperation.newDelete(i.l).build());
        JSONArray jsonarray;
        jsonarray = ((JSONObject) (obj2)).getJSONArray("cat_order");
        ((ArrayList) (obj)).add(ContentProviderOperation.newDelete(i.m).build());
        int j = 0;
_L5:
        if (j >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        if (!jsonarray.isNull(j))
        {
            String s = jsonarray.getString(j);
            ContentValues contentvalues1 = new ContentValues();
            contentvalues1.put("category", s);
            contentvalues1.put("position", Integer.valueOf(j));
            ((ArrayList) (obj)).add(ContentProviderOperation.newInsert(i.m).withValues(contentvalues1).build());
        }
          goto _L3
_L2:
        obj2 = ((JSONObject) (obj2)).getJSONArray("search_terms");
        j = 0;
_L6:
        if (j < ((JSONArray) (obj2)).length())
        {
            JSONObject jsonobject = ((JSONArray) (obj2)).getJSONObject(j);
            if (!jsonobject.isNull("name") && !jsonobject.isNull("cat"))
            {
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("item_name", jsonobject.getString("name").toLowerCase());
                contentvalues.put("category", jsonobject.getString("cat"));
                ((ArrayList) (obj)).add(ContentProviderOperation.newInsert(i.l).withValues(contentvalues).build());
            }
            break MISSING_BLOCK_LABEL_322;
        }
        a.applyBatch("com.wishabi.flipp.models.User", ((ArrayList) (obj)));
        return Boolean.valueOf(true);
        Object obj1;
        obj1;
_L4:
        ((Exception) (obj1)).toString();
        return Boolean.valueOf(false);
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        j++;
          goto _L5
        j++;
          goto _L6
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        SharedPreferences sharedpreferences = b.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        if (((Boolean) (obj)).booleanValue())
        {
            sharedpreferences.edit().putLong("last_cat_download", System.currentTimeMillis()).putString("last_cat_download_locale", c).commit();
        }
    }
}
