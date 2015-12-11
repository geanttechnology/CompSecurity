// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetPlaceService;
import com.abtnprojects.ambatana.datasource.api.c;
import org.json.JSONObject;
import retrofit.RetrofitError;

// Referenced classes of package android.support.v7:
//            aqo

public class di
{

    private GetPlaceService a;
    private boolean b;

    public di(String s)
    {
        a = c.d(s);
        b = false;
    }

    public JSONObject a(String s)
    {
        if (b)
        {
            return null;
        }
        b = true;
        try
        {
            s = a.getPlace(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "Error getPlace", new Object[0]);
            b = false;
            return null;
        }
        return s;
    }
}
