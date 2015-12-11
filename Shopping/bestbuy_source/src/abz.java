// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class abz extends abn
{

    private final String a;
    private final Context b;
    private final String c;
    private String d;

    public abz(Context context, String s, String s1)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
    }

    public abz(Context context, String s, String s1, String s2)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
        d = s2;
    }

    public void a()
    {
        Object obj;
        acb.d((new StringBuilder()).append("Pinging URL: ").append(c).toString());
        obj = (HttpURLConnection)(new URL(c)).openConnection();
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        abq.a(b, a, true, ((HttpURLConnection) (obj)));
_L1:
        p.a(((java.net.URLConnection) (obj)));
        int i;
        i = ((HttpURLConnection) (obj)).getResponseCode();
        p.b(((java.net.URLConnection) (obj)));
        p.c(((java.net.URLConnection) (obj)));
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        acb.e((new StringBuilder()).append("Received non-success response code ").append(i).append(" from pinging URL: ").append(c).toString());
        Object obj1;
        try
        {
            ((HttpURLConnection) (obj)).disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            acb.e((new StringBuilder()).append("Error while parsing ping URL: ").append(c).append(". ").append(((IndexOutOfBoundsException) (obj)).getMessage()).toString());
            return;
        }
        catch (IOException ioexception)
        {
            acb.e((new StringBuilder()).append("Error while pinging URL: ").append(c).append(". ").append(ioexception.getMessage()).toString());
        }
        break MISSING_BLOCK_LABEL_245;
        abq.a(b, a, true, ((HttpURLConnection) (obj)), d);
          goto _L1
        obj1;
        ((HttpURLConnection) (obj)).disconnect();
        throw obj1;
        obj1;
        p.a(((java.net.URLConnection) (obj)), ((IOException) (obj1)));
        throw obj1;
    }

    public void b()
    {
    }
}
