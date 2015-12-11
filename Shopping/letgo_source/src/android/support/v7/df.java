// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetAddressByIpService;
import com.abtnprojects.ambatana.datasource.api.c;
import org.json.JSONObject;
import retrofit.RetrofitError;

// Referenced classes of package android.support.v7:
//            aqo

public class df
{

    private GetAddressByIpService a;
    private boolean b;

    public df(String s)
    {
        a = c.e(s);
        b = false;
    }

    public JSONObject a()
    {
        if (b)
        {
            return null;
        }
        b = true;
        JSONObject jsonobject;
        try
        {
            jsonobject = a.getAddress();
        }
        catch (RetrofitError retrofiterror)
        {
            aqo.b(retrofiterror, "Error getAddressFromIp", new Object[0]);
            b = false;
            return null;
        }
        return jsonobject;
    }
}
