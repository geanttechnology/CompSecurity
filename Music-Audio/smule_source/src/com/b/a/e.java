// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

// Referenced classes of package com.b.a:
//            i, l, n, j

public class e
    implements i
{

    private n a;

    public e()
    {
    }

    static n a(e e1)
    {
        return e1.a;
    }

    public void a(Context context, String s, String s1, j j, Runnable runnable)
    {
        l.a(new AsyncTask(s, context, j, runnable) {

            final String a;
            final Context b;
            final j c;
            final Runnable d;
            final e e;

            protected transient Void a(Void avoid[])
            {
                avoid = a;
_L3:
                avoid = (HttpURLConnection)(new URL(avoid)).openConnection();
                avoid.setInstanceFollowRedirects(true);
                if (e.a(e) == null) goto _L2; else goto _L1
_L1:
                Object obj = e.a(e).a(b, a);
                if (obj != null)
                {
                    try
                    {
                        NameValuePair namevaluepair;
                        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); avoid.addRequestProperty(namevaluepair.getName(), namevaluepair.getValue()))
                        {
                            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
                        }

                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                        return null;
                    }
                }
_L2:
                if (avoid.getResponseCode() == 302 || avoid.getResponseCode() == 301)
                {
                    break MISSING_BLOCK_LABEL_171;
                }
                if (avoid.getResponseCode() == 200)
                {
                    break MISSING_BLOCK_LABEL_181;
                }
                l.a((new StringBuilder()).append("Response Code: ").append(avoid.getResponseCode()).toString(), new Object[0]);
                return null;
                avoid = avoid.getHeaderField("Location");
                  goto _L3
                avoid = avoid.getInputStream();
                c.a(e, avoid, null);
                return null;
            }

            protected void a(Void void1)
            {
                d.run();
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                e = e.this;
                a = s;
                b = context;
                c = j1;
                d = runnable;
                super();
            }
        });
    }

    public boolean a()
    {
        return true;
    }

    public boolean a(String s)
    {
        return s.startsWith("http");
    }
}
