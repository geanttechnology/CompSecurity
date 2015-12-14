// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.fotoable.comlib.util.AsyncTask;
import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import nativead.WebBrowerActivity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ceh extends AsyncTask
{

    final WebBrowerActivity a;

    public ceh(WebBrowerActivity webbroweractivity)
    {
        a = webbroweractivity;
        super();
    }

    protected transient String a(String as[])
    {
        Object obj = as[0];
        as = URLDecoder.decode(((String) (obj)).substring(((String) (obj)).lastIndexOf("/") + 1));
        Log.i("tag", (new StringBuilder()).append("fileName=").append(as).toString());
        if (!(new File(Environment.getExternalStorageDirectory(), as)).exists())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Log.i("tag", "The file has already exists.");
        return as;
label0:
        {
            try
            {
                obj = (new DefaultHttpClient()).execute(new HttpGet(((String) (obj))));
                if (200 != ((HttpResponse) (obj)).getStatusLine().getStatusCode())
                {
                    break label0;
                }
                obj = ((HttpResponse) (obj)).getEntity().getContent();
                a.a(as, ((InputStream) (obj)));
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
                return null;
            }
            return as;
        }
        return null;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        WebBrowerActivity.e(a);
        if (s == null)
        {
            try
            {
                s = Toast.makeText(a, "\u8FDE\u63A5\u9519\u8BEF\uFF01\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01", 1);
                s.setGravity(17, 0, 0);
                s.show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_103;
        }
        s = new File(Environment.getExternalStorageDirectory(), s);
        Log.i("tag", (new StringBuilder()).append("Path=").append(s.getAbsolutePath()).toString());
        s = a.a(s);
        a.startActivity(s);
        return;
    }

    protected transient void a(Void avoid[])
    {
        super.onProgressUpdate(avoid);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        WebBrowerActivity.d(a);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Void[])aobj);
    }
}
