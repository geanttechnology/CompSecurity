// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.abtnprojects.ambatana.models.SignUpUserInfo;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            aqo, in

public class eu extends SignUpUserInfo
{

    private final String a;
    private final boolean b;
    private JSONArray c;

    private eu(String s, String s1, String s2, boolean flag)
    {
        super(s, s1);
        c = null;
        a = s2;
        b = flag;
    }

    public static eu a(JSONObject jsonobject, List list)
    {
        String s;
        String s2;
        boolean flag;
label0:
        {
            if (jsonobject == null)
            {
                aqo.b("jsonObject is null", new Object[0]);
                return null;
            }
            flag = in.e(jsonobject, "verified");
            s2 = in.c(jsonobject, "id");
            String s1 = in.c(jsonobject, "email");
            if (s1 != null)
            {
                s = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s = s1;
            if (list != null)
            {
                s = s1;
                if (!list.isEmpty())
                {
                    s = (String)list.get(0);
                }
            }
        }
        list = s;
        if (s != null)
        {
            list = s;
            if (!s.isEmpty())
            {
                list = s.toLowerCase(Locale.getDefault());
            }
        }
        s = in.c(jsonobject, "first_name");
        jsonobject = in.c(jsonobject, "last_name");
        StringBuffer stringbuffer;
        if (TextUtils.isEmpty(jsonobject))
        {
            jsonobject = "";
        } else
        {
            jsonobject = (new StringBuilder()).append(jsonobject.substring(0, 1).toUpperCase(Locale.getDefault())).append(".").toString();
        }
        stringbuffer = new StringBuffer();
        if (!TextUtils.isEmpty(s))
        {
            stringbuffer.append(s);
            if (!TextUtils.isEmpty(jsonobject))
            {
                stringbuffer.append(" ");
            }
        }
        if (!TextUtils.isEmpty(jsonobject))
        {
            stringbuffer.append(jsonobject);
        }
        s = stringbuffer.toString();
        if (!TextUtils.isEmpty(s2))
        {
            jsonobject = (new StringBuilder()).append("http://graph.facebook.com/").append(s2).append("/picture?type=large").toString();
        } else
        {
            jsonobject = null;
        }
        return new eu(list, s, jsonobject, flag);
    }

    public String a()
    {
        return a;
    }

    public JSONArray b()
    {
        return c;
    }
}
