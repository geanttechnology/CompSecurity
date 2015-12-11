// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.network.a.r;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.t;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package com.smule.android.network.managers:
//            LocalizationManager, n

public class m extends t
{

    public String mBaseUrl;
    public String mLocPackageId;
    public String mUrl;

    public m()
    {
    }

    static m a(o o)
    {
        return (m)a(o, com/smule/android/network/managers/m);
    }

    private String a(String s, String s1)
    {
        String s2;
        try
        {
            s2 = (new URI(s)).getPath().replaceAll("/", "_");
        }
        catch (URISyntaxException urisyntaxexception)
        {
            aa.b(com.smule.android.network.managers.LocalizationManager.b(), (new StringBuilder()).append("Wrong syntax of locale resource url").append(s).toString(), urisyntaxexception);
            return s1;
        }
        return s2;
    }

    public n b()
    {
        aa.a(com.smule.android.network.managers.LocalizationManager.b(), (new StringBuilder()).append("LogPackageID=").append(mLocPackageId).append(" URL=").append(mUrl).append(" BaseURL=").append(mBaseUrl).toString());
        if (!a())
        {
            com.smule.android.network.core.b.a(a);
        } else
        if (mLocPackageId != null)
        {
            String s;
            if (mUrl != null)
            {
                s = mUrl;
            } else
            if (mBaseUrl != null)
            {
                s = mBaseUrl;
            } else
            {
                s = null;
            }
            if (s != null)
            {
                Object obj = a(s, mLocPackageId.toString());
                aa.a(com.smule.android.network.managers.LocalizationManager.b(), (new StringBuilder()).append("Saving url ").append(s).append(" to ").append(((String) (obj))).toString());
                try
                {
                    obj = r.a(s, ((String) (obj)), com.smule.android.network.core.b.d().e());
                    obj = new n(e.a().readTree(((java.io.File) (obj))));
                }
                catch (Exception exception)
                {
                    aa.b(com.smule.android.network.managers.LocalizationManager.b(), (new StringBuilder()).append("Failed to parse base localization package from ").append(s).toString(), exception);
                    return null;
                }
                return ((n) (obj));
            }
        }
        return null;
    }
}
