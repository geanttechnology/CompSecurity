// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.enums.ErrorType;
import myobfuscated.e.d;
import myobfuscated.e.e;
import myobfuscated.f.m;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bo.app:
//            dp, ag, az

public final class dl extends dp
{

    private static final String a;
    private final myobfuscated.h.e b;

    public dl(String s, myobfuscated.h.e e1)
    {
        super(Uri.parse((new StringBuilder()).append(s).append("feedback").toString()));
        b = e1;
    }

    public final ag a()
    {
        return ag.b;
    }

    public final void a(az az1)
    {
        az1.a(new e(), myobfuscated/e/e);
    }

    public final void a(az az1, m m1)
    {
        ErrorType errortype;
        errortype = m1.a;
        m1 = m1.b;
        if (errortype != ErrorType.REQUIRED_FIELD_MISSING) goto _L2; else goto _L1
_L1:
        myobfuscated.i.a.c(a, String.format("Required Field Missing: %s", new Object[] {
            m1
        }));
_L4:
        az1.a(new d(), myobfuscated/e/d);
        return;
_L2:
        if (errortype == ErrorType.BAD_INPUT)
        {
            myobfuscated.i.a.c(a, String.format("Bad Input: %s", new Object[] {
                m1
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean b()
    {
        return false;
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
            jsonobject.put("feedback", b.a());
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
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/dl.getName()
        });
    }
}
