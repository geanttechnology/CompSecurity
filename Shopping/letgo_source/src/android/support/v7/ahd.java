// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.location.f;
import com.kahuna.sdk.v;
import org.json.JSONException;
import org.json.JSONObject;

public class ahd
{

    private final String a;
    private final double b;
    private final double c;
    private final float d;
    private long e;
    private int f;

    public ahd(String s, double d1, double d2, float f1, long l, int i)
    {
        if (v.a(s))
        {
            throw new IllegalArgumentException("Cannot create Geofence with null or empty regionId");
        }
        if (d1 < -90D || d1 > 90D)
        {
            throw new IllegalArgumentException("Cannot create Geofence with latitude outside of -90 to 90");
        }
        if (d2 < -180D || d2 > 180D)
        {
            throw new IllegalArgumentException("Cannot create Geofence with longitude outside of -180 to 180");
        }
        if (f1 < 1.0F)
        {
            throw new IllegalArgumentException("Cannot create Geofence with radius less than 1");
        }
        a = (new StringBuilder()).append("KahunaEngineRegion_").append(s).toString();
        b = d1;
        c = d2;
        d = f1;
        if (l < 1L)
        {
            e = 0x9a7ec800L;
        } else
        {
            e = l;
        }
        f = i;
    }

    public static ahd a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            jsonobject = new ahd(jsonobject.getString("id").replace("KahunaEngineRegion_", ""), jsonobject.getDouble("lat"), jsonobject.getDouble("long"), (float)jsonobject.getDouble("radius"), jsonobject.getLong("expiration"), jsonobject.getInt("transition"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return jsonobject;
    }

    protected String a()
    {
        return a;
    }

    protected double b()
    {
        return b;
    }

    protected double c()
    {
        return c;
    }

    protected float d()
    {
        return d;
    }

    protected long e()
    {
        return e;
    }

    protected f f()
    {
        return (new com.google.android.gms.location.f.a()).a(a()).a(f).a(b(), c(), d()).a(e).a();
    }

    public JSONObject g()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", a());
            jsonobject.put("lat", b());
            jsonobject.put("long", c());
            jsonobject.put("radius", d());
            jsonobject.put("expiration", e);
            jsonobject.put("transition", f);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }
}
