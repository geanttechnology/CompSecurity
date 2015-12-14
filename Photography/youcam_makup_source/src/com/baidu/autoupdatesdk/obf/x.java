// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.autoupdatesdk.ICallback;
import org.json.JSONObject;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            ab, ai, af, ac, 
//            aa, w

public class x
{

    private static final String a = "utf-8";
    private String b;
    private Context c;
    private int d;
    private int e;
    private String f;
    private Object g;

    protected x(Context context, String s)
    {
        b = s;
        c = context.getApplicationContext();
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Invalid Session");
        } else
        {
            return (new ab(abyte0)).a(abyte1);
        }
    }

    private JSONObject b(byte abyte0[])
    {
        try
        {
            abyte0 = (JSONObject)ai.a(abyte0, "utf-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    private void b(int j, String s, Object obj)
    {
        Log.d("BDAutoUpdateSDK", (new StringBuilder()).append("ACT:").append(d).append(",resultCode:").append(e).append(",resultDesc:").append(f).toString());
    }

    private static byte[] b(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Invalid Session");
        }
        byte abyte2[] = new byte[abyte1.length];
        abyte0 = new ab(abyte0);
        try
        {
            abyte0 = abyte0.b(abyte1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    private byte[] c(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return a(af.a("78ce10521a046e95ed8c5bc1bba12a6029bee2769576d532"), abyte0);
        }
    }

    final String a()
    {
        String s = b();
        if (!TextUtils.isEmpty(s))
        {
            b = s;
        }
        return b.replaceFirst("_ActionID", (new StringBuilder()).append(d).append("").toString()).replaceFirst("_Ver", "1.2.0");
    }

    final String a(String s)
    {
        s = c();
        return s.getString(ac.b(s, "bdp_update_request_net_error"));
    }

    protected final transient String a(String s, Object aobj[])
    {
        s = c();
        return s.getString(ac.b(s, "bdp_update_request_net_error"));
    }

    final void a(int j, String s)
    {
        e = j;
        f = s;
    }

    final void a(int j, String s, Object obj)
    {
        e = j;
        f = s;
        g = obj;
    }

    final void a(ICallback icallback)
    {
    }

    protected final void a(short word0)
    {
        d = word0;
    }

    final void a(byte abyte0[])
    {
        abyte0 = b(abyte0);
        if (abyte0 == null)
        {
            a(-2, a("json error"));
            return;
        }
        String s = abyte0.optString("ResultCode", null);
        if (TextUtils.isEmpty(s))
        {
            a(-2, b("ResultCode"));
            return;
        }
        w w1;
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a(-2, c("ResultCode"));
            return;
        }
        s = abyte0.optString("ResultMsg", null);
        if (j != 0)
        {
            a(j, s);
        }
        try
        {
            abyte0 = (new String(aa.b(abyte0.optString("Content", "").getBytes("utf-8")), "utf-8")).getBytes("windows-1252");
            abyte0 = new JSONObject(new String(b(af.a("78ce10521a046e95ed8c5bc1bba12a6029bee2769576d532"), abyte0), "utf-8"));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            abyte0 = null;
        }
        if (abyte0 == null)
        {
            a(-2, c("Content"));
        }
        w1 = new w(null, null);
        if (!a(j, w1, ((JSONObject) (abyte0))))
        {
            a(-2, (String)w1.a);
            return;
        }
        if (!TextUtils.isEmpty(s))
        {
            abyte0 = s;
        } else
        {
            abyte0 = (String)w1.a;
        }
        a(j, ((String) (abyte0)), w1.b);
    }

    protected boolean a(int j, w w1, JSONObject jsonobject)
    {
        return false;
    }

    protected String b()
    {
        return "";
    }

    protected final String b(String s)
    {
        s = c();
        return s.getString(ac.b(s, "bdp_update_request_net_error"));
    }

    final void b(ICallback icallback)
    {
        try
        {
            b(e, f, g);
        }
        // Misplaced declaration of an exception variable
        catch (ICallback icallback)
        {
            icallback.printStackTrace();
            return;
        }
        if (icallback == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        icallback.onCallback(e, f, g);
    }

    protected final Context c()
    {
        return c;
    }

    protected final String c(String s)
    {
        s = c();
        return s.getString(ac.b(s, "bdp_update_request_net_error"));
    }

    public final int d()
    {
        return e;
    }

    public final String e()
    {
        return f;
    }

    public final Object f()
    {
        return g;
    }

    protected JSONObject g()
    {
        return null;
    }

    public byte[] h()
    {
        byte abyte0[];
        try
        {
            abyte0 = c(i());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    protected final byte[] i()
    {
        JSONObject jsonobject = g();
        byte abyte0[] = null;
        if (jsonobject != null)
        {
            abyte0 = jsonobject.toString().getBytes("utf-8");
        }
        return abyte0;
    }
}
