// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.ConditionVariable;
import android.util.Base64;
import java.net.URI;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;

public class bys
    implements bhv, cqs, crc
{

    final byu a;
    final SharedPreferences b;
    volatile boolean c;
    final ConditionVariable d;
    volatile cdl e;
    volatile byt f;

    public bys(byu byu1, SharedPreferences sharedpreferences)
    {
        Object obj = null;
        super();
        a = (byu)b.b(byu1, "deviceRegistrationClient cannot be null");
        b = (SharedPreferences)b.a(sharedpreferences);
        byu1 = String.valueOf("device_id");
        String s = String.valueOf("");
        String s1;
        if (s.length() != 0)
        {
            byu1 = byu1.concat(s);
        } else
        {
            byu1 = new String(byu1);
        }
        s = sharedpreferences.getString(byu1, null);
        byu1 = String.valueOf("device_key");
        s1 = String.valueOf("");
        if (s1.length() != 0)
        {
            byu1 = byu1.concat(s1);
        } else
        {
            byu1 = new String(byu1);
        }
        byu1 = sharedpreferences.getString(byu1, null);
        if (s != null && byu1 != null)
        {
            byu1 = new cdl(s, Base64.decode(byu1, 0));
        } else
        {
            byu1 = null;
        }
        e = byu1;
        byu1 = obj;
        if (e == null)
        {
            byu1 = new ConditionVariable(false);
        }
        d = byu1;
    }

    String a(Uri uri)
    {
        boolean flag;
        flag = true;
        if (e != null)
        {
            return e.a(uri);
        }
        this;
        JVM INSTR monitorenter ;
        if (c)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        c = true;
        d.close();
_L1:
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            a.a(this);
        } else
        {
            d.block();
        }
        if (f != null)
        {
            throw f;
        } else
        {
            return e.a(uri);
        }
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
        flag = false;
          goto _L1
    }

    public void a(cdl cdl1)
    {
        e = cdl1;
        f = null;
        cdl cdl2 = e;
        android.content.SharedPreferences.Editor editor = b.edit();
        cdl1 = String.valueOf("device_id");
        String s = String.valueOf("");
        if (s.length() != 0)
        {
            cdl1 = cdl1.concat(s);
        } else
        {
            cdl1 = new String(cdl1);
        }
        editor = editor.putString(cdl1, cdl2.a);
        cdl1 = String.valueOf("device_key");
        s = String.valueOf("");
        if (s.length() != 0)
        {
            cdl1 = cdl1.concat(s);
        } else
        {
            cdl1 = new String(cdl1);
        }
        editor.putString(cdl1, new String(Base64.encode(cdl2.b, 0))).apply();
        d.open();
        c = false;
        bmo.e("device registered");
    }

    public void a(Exception exception)
    {
        e = null;
        f = new byt(exception);
        d.open();
        c = false;
        bmo.b("device registration failed");
    }

    public volatile void a(Object obj, Exception exception)
    {
        a(exception);
    }

    public volatile void a(Object obj, Object obj1)
    {
        a((cdl)obj1);
    }

    public void a(Map map, cra cra1)
    {
        cra1 = Uri.parse(cra1.j_());
        try
        {
            map.put("X-GData-Device", a(((Uri) (cra1))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return;
        }
    }

    public void a(HttpUriRequest httpurirequest)
    {
        Uri uri = Uri.parse(httpurirequest.getURI().toString());
        try
        {
            httpurirequest.setHeader("X-GData-Device", a(uri));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            throw new bnn(httpurirequest);
        }
    }
}
