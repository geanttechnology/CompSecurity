// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

// Referenced classes of package android.support.v7:
//            abo, xa

public class xk
{

    private String a;

    public xk()
    {
        a = "https://www.google-analytics.com";
    }

    private String b(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            abo.a((new StringBuilder()).append("Cannot encode the string: ").append(s).toString());
            return "";
        }
        return s1;
    }

    public String a(List list)
    {
        return (new StringBuilder()).append(a).append("/gtm/android?").append(b(list)).toString();
    }

    public void a(String s)
    {
        a = s;
        abo.c((new StringBuilder()).append("The Ctfe server endpoint was changed to: ").append(s).toString());
    }

    String b(List list)
    {
        boolean flag = true;
        if (list.size() > 1)
        {
            flag = false;
        }
        x.b(flag);
        if (list.isEmpty())
        {
            return "";
        }
        xa xa1 = (xa)list.get(0);
        StringBuilder stringbuilder;
        if (!xa1.f().trim().equals(""))
        {
            list = xa1.f().trim();
        } else
        {
            list = "-1";
        }
        stringbuilder = new StringBuilder();
        if (xa1.c() != null)
        {
            stringbuilder.append(xa1.c());
        } else
        {
            stringbuilder.append("id");
        }
        stringbuilder.append("=").append(b(xa1.a())).append("&").append("pv").append("=").append(b(((String) (list))));
        if (xa1.e())
        {
            stringbuilder.append("&gtm_debug=x");
        }
        return stringbuilder.toString();
    }
}
