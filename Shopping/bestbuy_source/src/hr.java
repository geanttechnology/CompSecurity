// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.res.Resources;
import com.bestbuy.android.bbyobjects.BBYWebView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class hr extends ka
{

    private Activity a;
    private String j;

    public hr(Activity activity)
    {
        j = "";
        a = activity;
    }

    public void a()
    {
        Object obj1 = a.getResources().getString(0x7f08031b);
        Object obj;
        obj = new DefaultHttpClient();
        obj1 = new HttpPost(((String) (obj1)));
        ((HttpPost) (obj1)).setHeader("token", fr.b());
        obj = new BufferedReader(new InputStreamReader(p.a(((org.apache.http.client.HttpClient) (obj)), ((org.apache.http.client.methods.HttpUriRequest) (obj1))).getEntity().getContent(), "UTF-8"));
        obj1 = new StringBuilder();
_L1:
        String s = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                ((StringBuilder) (obj1)).append(s).append("\n");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return;
            }
        }
          goto _L1
        j = ((StringBuilder) (obj1)).toString();
        ((BufferedReader) (obj)).close();
        return;
    }

    public void b()
    {
        (new BBYWebView(a, null, null)).loadData(j, "text/html", "UTF-8");
    }
}
