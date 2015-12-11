// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cv, cu, v, bq

public final class ar
    implements cv
{

    private JSONObject a;
    private String b;

    public ar(v v1)
    {
        b = cu.a.a();
        try
        {
            a = (new JSONObject()).put("appID", v1.a()).put("deviceID", v1.c()).put("crPlatform", "android").put("crVersion", v1.d()).put("deviceModel", v1.j()).put("osName", "android").put("osVersion", v1.k()).put("carrier", v1.f()).put("mobileCountryCode", v1.g()).put("mobileNetworkCode", v1.h()).put("appVersion", v1.b()).put("locale", (new bq()).a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            return;
        }
    }

    public final void a(OutputStream outputstream)
    {
        outputstream.write(a.toString().getBytes());
    }

    public final String f()
    {
        return b;
    }
}
