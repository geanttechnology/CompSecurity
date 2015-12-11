// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.mopub.common.d.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.mopub.common:
//            n

public final class p extends AsyncTask
{
    static interface a
    {

        public abstract void a(String s);

        public abstract void a(String s, Throwable throwable);
    }


    private final a a;

    private p(a a1)
    {
        a = a1;
    }

    private static String a(String s)
    {
        Object obj;
        obj = null;
        s = new URL(s);
        s = (HttpURLConnection)s.openConnection();
        int i;
        s.setInstanceFollowRedirects(false);
        i = s.getResponseCode();
        if (i < 300 || i >= 400)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = s.getHeaderField("Location");
        if (s != null)
        {
            s.disconnect();
        }
        return ((String) (obj));
        if (s != null)
        {
            s.disconnect();
        }
        return null;
        Exception exception;
        exception;
        s = ((String) (obj));
        obj = exception;
_L2:
        if (s != null)
        {
            s.disconnect();
        }
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static transient String a(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((String) (obj));
_L2:
        int i;
        as = as[0];
        i = 0;
        obj = null;
_L5:
        if (as == null || i >= 10)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = as;
        if (!n.f.a(Uri.parse(as))) goto _L4; else goto _L3
_L3:
        String s = a(((String) (as)));
        i++;
        obj = as;
        as = s;
          goto _L5
        as;
        return null;
        return ((String) (obj));
    }

    public static void a(String s, a a1)
    {
        p p1 = new p(a1);
        try
        {
            com.mopub.common.d.a.a(p1, new String[] {
                s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a1.a("Failed to resolve url", s);
        }
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected final void onCancelled()
    {
        super.onCancelled();
        a.a("Task for resolving url was cancelled", null);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        super.onPostExecute(obj);
        if (isCancelled() || obj == null)
        {
            onCancelled();
            return;
        } else
        {
            a.a(((String) (obj)));
            return;
        }
    }
}
