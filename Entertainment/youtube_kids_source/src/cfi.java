// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.HandlerThread;
import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

public class cfi
    implements cfw
{

    private static final String a = cfi.getCanonicalName();
    private cfk b;
    private final cfj c;
    private final HttpClient d;
    private final chs e;

    private cfi(che che, cfj cfj1, HttpClient httpclient, chs chs1)
    {
        c = cfj1;
        d = httpclient;
        e = chs1;
        cfj1 = new HandlerThread(getClass().getName(), 10);
        cfj1.start();
        b = new cfk(cfj1.getLooper(), che);
    }

    public cfi(che che, chs chs1)
    {
        this(che, new cfj(), a.z(), chs1);
    }

    static String b()
    {
        return a;
    }

    public final void a()
    {
        b.removeMessages(1);
    }

    public final void a(Uri uri)
    {
        uri = new HttpDelete(uri.toString());
        uri.setHeader("Origin", "package:com.google.android.youtube");
        int i;
        try
        {
            i = d.execute(uri).getStatusLine().getStatusCode();
        }
        catch (IOException ioexception)
        {
            uri = a;
            String s = String.valueOf(ioexception);
            Log.e(uri, (new StringBuilder(String.valueOf(s).length() + 25)).append("Error stopping YouTubeTV.").append(s).toString());
            return;
        }
        if (i != 200)
        {
            Log.e(a, (new StringBuilder(54)).append("Error stopping YouTubeTV. Response code is ").append(i).toString());
        }
        try
        {
            Thread.sleep(1000L);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
        }
    }

    public final void a(Uri uri, String s, long l, cgm cgm1, String s1, cfx cfx1)
    {
        cgm cgm2;
        cgm2 = c.a();
        HttpPost httppost = new HttpPost(uri.toString());
        httppost.setHeader(new BasicHeader("Content-Type", "text/plain; charset=\"utf-8\""));
        httppost.setHeader("Origin", "package:com.google.android.youtube");
        try
        {
            cgm1 = String.format("pairingCode=%s&theme=%s%s", new Object[] {
                cgm2.toString(), s1, e.c
            });
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            cfx1.a(4);
            return;
        }
        uri = cgm1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        uri = String.valueOf(cgm1);
        s = String.valueOf(String.format("&v=%s&t=%d", new Object[] {
            s, Long.valueOf(l / 1000L)
        }));
        if (s.length() != 0)
        {
            uri = uri.concat(s);
        } else
        {
            uri = new String(uri);
        }
        httppost.setEntity(new StringEntity(uri, "UTF-8"));
        s = d.execute(httppost);
        s.getStatusLine().getStatusCode();
        JVM INSTR lookupswitch 4: default 335
    //                   201: 238
    //                   303: 308
    //                   404: 317
    //                   503: 326;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        b.a(cfl.a(cgm2, cfx1));
        uri = null;
        if (s.containsHeader("LOCATION"))
        {
            uri = Uri.parse(s.getFirstHeader("LOCATION").getValue());
        }
        s = uri;
        if (uri != null)
        {
            s = uri;
            if (uri.getHost() == null)
            {
                s = null;
            }
        }
        cfx1.a(s);
        return;
_L3:
        cfx1.a(1);
        return;
_L4:
        cfx1.a(2);
        return;
_L5:
        cfx1.a(0);
        return;
_L1:
    }

}
