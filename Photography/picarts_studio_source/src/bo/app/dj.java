// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.enums.ErrorType;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bo.app:
//            dp, dk, aj, ag, 
//            eo, az

public final class dj extends dp
{

    private static final String a;
    private final List b = new ArrayList();

    public dj(String s, int i)
    {
        super(Uri.parse((new StringBuilder()).append(s).append("data").toString()));
        switch (bo.app.dk.a[i - 1])
        {
        default:
            return;

        case 1: // '\001'
            b.add(aj.b);
            b.add(bo.app.aj.a);
            return;

        case 2: // '\002'
            b.add(aj.b);
            return;

        case 3: // '\003'
            b.add(bo.app.aj.a);
            break;
        }
    }

    public final ag a()
    {
        return ag.b;
    }

    public final void a(az az)
    {
    }

    public final void a(az az, m m1)
    {
        az = m1.a;
        if (az == ErrorType.REQUIRED_FIELD_MISSING)
        {
            myobfuscated.i.a.c(a, String.format("Required Field Missing: %s", new Object[] {
                m1.b
            }));
        } else
        if (az == ErrorType.BAD_INPUT)
        {
            myobfuscated.i.a.c(a, String.format("Bad Input: %s", new Object[] {
                m1.b
            }));
            return;
        }
    }

    public final boolean b()
    {
        boolean flag;
        if (b == null || b.size() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && super.b();
    }

    public final JSONObject c()
    {
        JSONObject jsonobject = super.c();
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            jsonobject.put("only_respond_with", bo.app.eo.a(b));
        }
        catch (JSONException jsonexception)
        {
            myobfuscated.i.a.b(a, "Experienced JSONException while retrieving parameters. Returning null.", jsonexception);
            return null;
        }
        return jsonobject;
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/dj.getName()
        });
    }
}
