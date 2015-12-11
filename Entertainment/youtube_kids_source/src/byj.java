// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public final class byj extends cod
    implements byu
{

    private final crb a;
    private final bng g;
    private final String h;
    private final String i;

    public byj(Executor executor, HttpClient httpclient, bng bng1, cog cog1, String s)
    {
        super(executor, httpclient);
        try
        {
            h = b.a(new String(cog1.a(), "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (Executor executor)
        {
            throw new RuntimeException(executor);
        }
        i = b.a(s, "serial cannot be null or empty");
        g = bng1;
        executor = cog1.b();
        a = a(new cpc(bkf.b), new byv(executor));
    }

    public final void a(bhv bhv)
    {
        Object obj;
        String s;
        if (g == null)
        {
            obj = "https://www.google.com/youtube/accounts/registerDevice";
        } else
        {
            obj = g.a("https://www.google.com/youtube/accounts/registerDevice");
        }
        obj = String.valueOf(obj);
        s = String.valueOf("?developer=%s&serialNumber=%s");
        if (s.length() != 0)
        {
            obj = ((String) (obj)).concat(s);
        } else
        {
            obj = new String(((String) (obj)));
        }
        obj = Uri.parse(String.format(((String) (obj)), new Object[] {
            h, i
        }));
        a.a(obj, bhv);
    }
}
