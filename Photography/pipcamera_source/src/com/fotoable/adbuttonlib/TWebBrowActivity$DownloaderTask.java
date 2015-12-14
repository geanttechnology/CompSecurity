// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class this._cls0 extends AsyncTask
{

    final TWebBrowActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
label0:
        {
            Object obj = as[0];
            as = URLDecoder.decode(((String) (obj)).substring(((String) (obj)).lastIndexOf("/") + 1));
            Log.i("tag", (new StringBuilder()).append("fileName=").append(as).toString());
            if ((new File(Environment.getExternalStorageDirectory(), as)).exists())
            {
                Log.i("tag", "The file has already exists.");
                return as;
            }
            try
            {
                obj = (new DefaultHttpClient()).execute(new HttpGet(((String) (obj))));
                if (200 != ((HttpResponse) (obj)).getStatusLine().getStatusCode())
                {
                    break label0;
                }
                obj = ((HttpResponse) (obj)).getEntity().getContent();
                writeToSDCard(as, ((InputStream) (obj)));
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
                Crashlytics.logException(as);
                return null;
            }
            return as;
        }
        return null;
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        TWebBrowActivity.access$600(TWebBrowActivity.this);
        if (s == null)
        {
            s = Toast.makeText(TWebBrowActivity.this, "\u8FDE\u63A5\u9519\u8BEF\uFF01\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01", 1);
            s.setGravity(17, 0, 0);
            s.show();
            return;
        } else
        {
            s = new File(Environment.getExternalStorageDirectory(), s);
            Log.i("tag", (new StringBuilder()).append("Path=").append(s.getAbsolutePath()).toString());
            s = getFileIntent(s);
            startActivity(s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        TWebBrowActivity.access$500(TWebBrowActivity.this);
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Void[])aobj);
    }

    protected transient void onProgressUpdate(Void avoid[])
    {
        super.onProgressUpdate(avoid);
    }

    public ()
    {
        this$0 = TWebBrowActivity.this;
        super();
    }
}
