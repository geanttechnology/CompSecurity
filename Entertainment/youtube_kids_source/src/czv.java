// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.Log;
import com.google.android.speech.callback.Callback;
import com.google.android.speech.utils.HexUtils;
import com.google.android.speech.utils.IoUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class czv
    implements daa
{

    private final eyr a;
    private final dat b = a.H();
    private final czp c;
    private final boolean d = true;
    private Callback e;
    private czx f;
    private dac g;
    private HttpURLConnection h;
    private URL i;
    private czz j;
    private int k;

    public czv(eyr eyr1, czp czp1, boolean flag)
    {
        a = eyr1;
        c = czp1;
    }

    static void a(HttpURLConnection httpurlconnection, eyk eyk1)
    {
        if (!eyk1.i)
        {
            httpurlconnection.setRequestProperty("X-S3-Send-Compressible", "1");
        }
    }

    public final void a(Callback callback, exe exe1)
    {
        dat dat = b;
        a(1);
        e = (Callback)f.b(callback);
        callback = UUID.randomUUID().toString();
        f = new czx(this, new URL((new StringBuilder()).append(a.a.a).append(callback).toString()), a, c, e);
        f.start();
        eyk eyk1 = a.b;
        i = new URL((new StringBuilder()).append(eyk1.a).append(callback).toString());
        h = c.a(eyk1, i);
        IoUtils.addHttpHeaders(h, eyk1);
        a(h, eyk1);
        h.setDoOutput(true);
        h.setUseCaches(false);
        a.a(h);
        g = new dac(h.getOutputStream(), eyk1.d, false);
        callback = g;
        boolean flag;
        if (!((dac) (callback)).d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (((dac) (callback)).e.position() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            f.b(flag);
            ((dac) (callback)).e.put(dac.a);
            ((dac) (callback)).e.put(HexUtils.hexToBytes(((dac) (callback)).c.replace("_", "")));
            callback.a(exe1);
            callback.d = true;
            if (!f.a())
            {
                throw new IOException("Timed out / error during connect");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Callback callback)
        {
            Log.w("PairHttpConnection", "[Upload] Connection error", callback);
            close();
            throw callback;
        }
        return;
    }

    public final void a(exe exe1)
    {
        Object obj;
        boolean flag;
        int l;
        boolean flag1;
        flag = true;
        obj = b;
        if (g != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        f.b(flag1, "call to send() after close() / error / end of data");
        obj = g;
        f.b(((dac) (obj)).d);
        if (((dac) (obj)).e.position() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        try
        {
            f.b(flag1);
            ((dac) (obj)).a(exe1);
            g.b.flush();
        }
        // Misplaced declaration of an exception variable
        catch (exe exe1)
        {
            e.onError(new dam("Failed to send request", exe1));
            return;
        }
        if (!exe1.a)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        g.close();
        l = h.getResponseCode();
        g = null;
        exe1 = i;
        obj = h;
        if (!exe1.getHost().equals(((HttpURLConnection) (obj)).getURL().getHost()))
        {
            Log.w("PairHttpConnection", (new StringBuilder("[Upload] unexpected redirect to ")).append(((HttpURLConnection) (obj)).getURL()).toString());
            throw new dam((new StringBuilder("[Upload] unexpected redirect to ")).append(((HttpURLConnection) (obj)).getURL()).toString());
        }
        break MISSING_BLOCK_LABEL_233;
        exe1;
        e.onError(new dam("[Upload] Failed to send request", exe1));
        return;
        if (l == 200) goto _L2; else goto _L1
_L1:
        exe1 = ((HttpURLConnection) (obj)).getHeaderField("X-Speech-S3-Res-Code");
        if (!TextUtils.isEmpty(exe1))
        {
            throw new daq(Integer.parseInt(exe1));
        }
          goto _L3
        exe1;
        e.onError(exe1);
_L2:
        exe1 = h.getInputStream();
        obj = new dad(exe1);
        exf exf = ((dad) (obj)).a();
        exe1 = exf;
_L4:
        if (flag)
        {
            a(2);
            f.b(exe1);
            j = new czz(((dad) (obj)), h, e, exe1);
            h = null;
            j.start();
            return;
        } else
        {
            emp.a(((java.io.Closeable) (obj)));
            return;
        }
_L3:
        Log.w("PairHttpConnection", (new StringBuilder("[Upload] response code ")).append(l).toString());
        throw new dam((new StringBuilder("[Upload] bad response: ")).append(l).toString());
        exe1;
        exe1 = null;
        obj = null;
_L5:
        emp.a(((java.io.Closeable) (obj)));
        flag = false;
        obj = exe1;
        exe1 = null;
          goto _L4
        obj;
        Object obj1 = null;
        obj = exe1;
        exe1 = obj1;
          goto _L5
        IOException ioexception;
        ioexception;
        exe exe2 = exe1;
        exe1 = ((exe) (obj));
        obj = exe2;
          goto _L5
    }

    final boolean a(int l)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        l = czw.a[l - 1];
        l;
        JVM INSTR tableswitch 1 4: default 44
    //                   1 51
    //                   2 89
    //                   3 136
    //                   4 188;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        boolean flag = flag1;
_L13:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (k != 3) goto _L7; else goto _L6
_L6:
        Log.w("PairHttpConnection", "The response is sent in the up and down");
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L7:
        k = 2;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        if (k != 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (k != 2) goto _L9; else goto _L8
_L8:
        Log.w("PairHttpConnection", "The response is sent in the up and down");
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L9:
        k = 3;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (!d)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k != 3) goto _L11; else goto _L10
_L10:
        k = 4;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L11:
        if (k == 2)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        k = 4;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        k = 1;
        flag = true;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final void close()
    {
        dat dat = b;
        emp.a(g);
        if (h != null)
        {
            h.disconnect();
            h = null;
        }
        emp.a(j);
        emp.a(f);
    }
}
