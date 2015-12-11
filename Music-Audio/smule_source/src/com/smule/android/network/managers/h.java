// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.p;
import com.smule.android.network.a.d;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.util.Map;

public class h
{

    private static final String a = com/smule/android/network/managers/h.getName();
    private static h b;
    private Context c;
    private long d;
    private Map e;

    public h()
    {
        d = 0L;
    }

    static long a(h h1, long l)
    {
        h1.d = l;
        return l;
    }

    static SharedPreferences a(h h1)
    {
        return h1.d();
    }

    public static h a()
    {
        com/smule/android/network/managers/h;
        JVM INSTR monitorenter ;
        h h1;
        if (b == null)
        {
            b = new h();
            b.c = com.smule.android.network.core.b.d().e();
            b.e();
        }
        h1 = b;
        com/smule/android/network/managers/h;
        JVM INSTR monitorexit ;
        return h1;
        Exception exception;
        exception;
        throw exception;
    }

    private Map a(JsonNode jsonnode)
    {
        return com.smule.android.f.e.a(jsonnode, new TypeReference() {

            final h a;

            
            {
                a = h.this;
                super();
            }
        });
    }

    static Map a(h h1, JsonNode jsonnode)
    {
        return h1.a(jsonnode);
    }

    static Map a(h h1, Map map)
    {
        h1.e = map;
        return map;
    }

    private void a(boolean flag)
    {
        aa.a(a, "refreshDeviceSettings - begin");
        if (!flag && System.currentTimeMillis() < d + 0x36ee80L)
        {
            aa.a(a, "refreshDeviceSettings - we have updated recently; ignoring call to refresh");
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final h a;

                public void run()
                {
                    Object obj;
                    obj = com.smule.android.network.a.d.a();
                    if (!((o) (obj)).a())
                    {
                        break MISSING_BLOCK_LABEL_129;
                    }
                    p.a(h.a(a).edit().putString("DEVICE_SETTINGS_JSON", ((o) (obj)).h));
                    obj = h.a(a, ((o) (obj)).j);
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_119;
                    }
                    aa.b(h.c(), (new StringBuilder()).append("refreshDeviceSettings - new settings contains ").append(((Map) (obj)).size()).append(" items").toString());
                    this;
                    JVM INSTR monitorenter ;
                    h.a(a, ((Map) (obj)));
                    h.a(a, System.currentTimeMillis());
                    this;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    this;
                    JVM INSTR monitorexit ;
                    throw exception;
                    aa.e(h.c(), "refreshDeviceSettings - parsing new settings failed");
                    return;
                    aa.e(h.c(), "refreshDeviceSettings - call to getDeviceSettings did not succeed");
                    return;
                }

            
            {
                a = h.this;
                super();
            }
            });
            return;
        }
    }

    static String c()
    {
        return a;
    }

    private SharedPreferences d()
    {
        return c.getSharedPreferences("DEVICE_SETTINGS_FILE", 0);
    }

    private void e()
    {
        Object obj = d().getString("DEVICE_SETTINGS_JSON", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = a(((JsonNode)com.smule.android.f.e.a().readValue(((String) (obj)), com/fasterxml/jackson/databind/JsonNode)).get("data"))) == null) goto _L1; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
        e = ((Map) (obj));
        this;
        JVM INSTR monitorexit ;
        try
        {
            aa.a(a, (new StringBuilder()).append("restoreSettings - done restoring settings. Settings contains ").append(e.size()).append(" items").toString());
            return;
        }
        catch (Exception exception)
        {
            aa.b(a, "restoreSettings - exception thrown restoring device settings.", exception);
        }
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public void b()
    {
        a(false);
    }

}
