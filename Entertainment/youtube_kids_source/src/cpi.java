// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.crypto.NoSuchPaddingException;

public class cpi
{

    final mh a;
    final SharedPreferences b;
    final coe c;
    cpe d;
    final String e;
    final String f;
    final String g;
    final String h;

    public cpi(mh mh1, SharedPreferences sharedpreferences, coe coe1, String s, String s1, String s2)
    {
        a = (mh)b.a(mh1);
        b = (SharedPreferences)b.a(sharedpreferences);
        c = (coe)b.a(coe1);
        e = b.a(s);
        f = b.a(s1);
        b.a(s2);
        g = String.format("%s_%s", new Object[] {
            "apiary_device_id", s2
        });
        h = String.format("%s_%s", new Object[] {
            "apiary_device_key", s2
        });
    }

    public void a()
    {
        d = null;
        b.edit().remove(g).remove(h).apply();
    }

    void a(cpe cpe1)
    {
        b.edit().putString(g, cpe1.a).putString(h, new String(Base64.encode(cpe1.b, 0))).apply();
    }

    public void a(Map map, String s, byte abyte0[])
    {
        cpe cpe1 = c();
        if (cpe1 != null)
        {
            map.put("X-Goog-Device-Auth", String.format("device_id=%s,data=%s,content=%s", new Object[] {
                cpe1.a, cpe1.a(a.b(s.getBytes(), s.getBytes().length + 1), 4), cpe1.a(abyte0, 20)
            }));
        }
    }

    cpe b()
    {
        Object obj = null;
        String s = b.getString(g, null);
        String s1 = b.getString(h, null);
        cpe cpe1 = obj;
        if (s != null)
        {
            cpe1 = obj;
            if (s1 != null)
            {
                cpe1 = new cpe(s, Base64.decode(s1, 0));
            }
        }
        return cpe1;
    }

    cpe c()
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        b.b();
        abyte0 = c.f();
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L3:
        this;
        JVM INSTR monitorexit ;
        return ((cpe) (obj));
_L2:
label0:
        {
            if (d == null)
            {
                break label0;
            }
            bmo.f("Returned cached device auth.");
            obj = d;
        }
          goto _L3
label1:
        {
            d = b();
            if (d == null)
            {
                break label1;
            }
            bmo.e("Returned device auth from shared preferences.");
            obj = d;
        }
          goto _L3
        bmk bmk1;
        crf crf1;
        bmk1 = new bmk();
        obj = c.e().buildUpon().appendEncodedPath(c.d()).appendQueryParameter("key", e).appendQueryParameter("rawDeviceId", f).build();
        crf1 = crf.a();
        cph cph1 = new cph(((Uri) (obj)), crf1, c.f(), 4);
_L7:
        a.a(cph1);
        d = (cpe)crf1.get(15L, TimeUnit.SECONDS);
        a(d);
        bmo.d("Successfully completed device registration.");
        obj = d;
          goto _L3
        Object obj1;
        obj1;
        obj1 = null;
          goto _L3
        obj1;
        obj1 = null;
          goto _L3
        Object obj2;
        obj2;
        if (!(((ExecutionException) (obj2)).getCause() instanceof mp))
        {
            break MISSING_BLOCK_LABEL_432;
        }
        obj1 = (mp)((ExecutionException) (obj2)).getCause();
        if (((mp) (obj1)).a == null || ((mp) (obj1)).a.b == null)
        {
            break MISSING_BLOCK_LABEL_432;
        }
        obj1 = String.valueOf(new String(((mp) (obj1)).a.b));
        if (((String) (obj1)).length() == 0) goto _L5; else goto _L4
_L4:
        obj1 = "Server returned: ".concat(((String) (obj1)));
_L8:
        bmo.e(((String) (obj1)));
        break MISSING_BLOCK_LABEL_432;
_L9:
        obj2 = String.valueOf(obj1.getClass().getSimpleName());
        String s = String.valueOf(((Exception) (obj1)).getMessage());
        bmo.b((new StringBuilder(String.valueOf(obj2).length() + 39 + String.valueOf(s).length())).append("Could not do device auth handshake: ").append(((String) (obj2))).append(" - ").append(s).toString());
        if (bmk1.a()) goto _L7; else goto _L6
_L6:
        long l = bmk1.a;
        bmo.a((new StringBuilder(54)).append("Giving up device auth after ").append(l).append(" tries").toString(), ((Throwable) (obj1)));
        obj1 = null;
          goto _L3
_L5:
        obj1 = new String("Server returned: ");
          goto _L8
        obj1;
        throw obj1;
        obj1;
          goto _L9
        obj1;
          goto _L9
        obj1 = obj2;
          goto _L9
    }
}
