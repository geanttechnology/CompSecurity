// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class civ extends ciu
{

    private static final String i = civ.getSimpleName();

    public civ(URL url, ciz ciz, int j, cin cin1, cio cio1)
    {
        super(url, ciz, j, cin1, cio1);
    }

    public void run()
    {
        Object obj2;
        obj2 = null;
        String s = i;
        if (a == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        String s1 = a(e.j);
        e.f.a.a();
        obj1 = i;
        obj1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        (new StringBuilder(String.valueOf(obj1).length() + 44 + String.valueOf(s2).length())).append("PrimaryTask openConnection: ").append(((String) (obj1))).append("; networkType = ").append(s2);
        obj1 = a(a, s1, b);
        if (h) goto _L4; else goto _L3
_L3:
        int j = ((HttpURLConnection) (obj1)).getContentLength();
        if (j >= 0) goto _L6; else goto _L5
_L5:
        Object obj;
        try
        {
            throw new IOException("Only Http content with valid content-length is supported.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj = null;
        }
_L11:
        byte abyte0[];
        HttpURLConnection httpurlconnection;
        Log.e(i, ((IOException) (obj2)).toString());
        abyte0 = ((byte []) (obj));
        httpurlconnection = ((HttpURLConnection) (obj1));
        if (g == null)
        {
            g = ((IOException) (obj2));
            httpurlconnection = ((HttpURLConnection) (obj1));
            abyte0 = ((byte []) (obj));
        }
_L8:
        if (abyte0 != null)
        {
            try
            {
                abyte0.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(i, ((IOException) (obj)).toString());
                if (g == null)
                {
                    g = ((IOException) (obj));
                }
                if (httpurlconnection != null)
                {
                    httpurlconnection.disconnect();
                }
            }
        }
_L9:
        d.b();
        e.f.a.b();
        obj = i;
        return;
_L6:
        d.a(j);
        abyte0 = new byte[(int)Math.ceil((double)j / (double)c)];
        obj = ((HttpURLConnection) (obj1)).getInputStream();
_L7:
        obj2 = obj;
        int k;
        try
        {
            if (h)
            {
                break; /* Loop/switch isn't completed */
            }
            k = ((InputStream) (obj)).read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        if (k < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        a(k);
        d.a(abyte0, k);
        e.f.a.a(k);
        if (true) goto _L7; else goto _L4
_L4:
        abyte0 = ((byte []) (obj2));
        httpurlconnection = ((HttpURLConnection) (obj1));
          goto _L8
_L2:
        obj = i;
          goto _L9
        obj2;
        obj1 = null;
        obj = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

}
