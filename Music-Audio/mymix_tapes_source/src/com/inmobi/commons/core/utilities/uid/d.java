// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.uid;

import android.util.Base64;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.a.c;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.utilities.uid:
//            c, a

public class d
{

    private Map a;

    public d(Map map)
    {
        a = map;
    }

    private String a(String s, String s1)
    {
        byte abyte0[];
        int i;
        try
        {
            s = s.getBytes("UTF-8");
            abyte0 = new byte[s.length];
            s1 = s1.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0[i] = (byte)(s[i] ^ s1[i % s1.length]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_22;
_L1:
        s = new String(Base64.encode(abyte0, 2), "UTF-8");
        return s;
    }

    private String c()
    {
        return (new JSONObject(a(null, false))).toString();
    }

    public HashMap a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("u-id-map", c());
        return hashmap;
    }

    public Map a(String s, boolean flag)
    {
        HashMap hashmap = new HashMap();
        if (((Boolean)a.get("O1")).booleanValue() && !com.inmobi.commons.core.utilities.uid.c.a().l())
        {
            String s8 = com.inmobi.commons.core.utilities.uid.c.a().a(com.inmobi.commons.core.utilities.uid.c.a().i());
            String s1 = s8;
            if (flag)
            {
                s1 = a(s8, s);
            }
            hashmap.put("O1", s1);
        }
        if (((Boolean)a.get("UM5")).booleanValue() && !com.inmobi.commons.core.utilities.uid.c.a().l())
        {
            String s9 = com.inmobi.commons.core.utilities.uid.c.a().b(com.inmobi.commons.core.utilities.uid.c.a().i());
            String s2 = s9;
            if (flag)
            {
                s2 = a(s9, s);
            }
            hashmap.put("UM5", s2);
        }
        if (((Boolean)a.get("LID")).booleanValue())
        {
            String s10 = com.inmobi.commons.core.utilities.uid.c.a().g();
            if (s10 != null && s10.trim().length() > 0)
            {
                String s3 = s10;
                if (flag)
                {
                    s3 = a(s10, s);
                }
                hashmap.put("LID", s3);
            }
        }
        if (((Boolean)a.get("SID")).booleanValue())
        {
            String s11 = com.inmobi.commons.core.utilities.uid.c.a().h();
            if (s11 != null && s11.trim().length() > 0)
            {
                String s4 = s11;
                if (flag)
                {
                    s4 = a(s11, s);
                }
                hashmap.put("SID", s4);
            }
        }
        if (((Boolean)a.get("GPID")).booleanValue())
        {
            com.inmobi.commons.core.utilities.uid.a a1 = com.inmobi.commons.core.utilities.uid.c.a().j();
            if (a1 != null)
            {
                String s12 = a1.b();
                if (s12 != null)
                {
                    String s5 = s12;
                    if (flag)
                    {
                        s5 = a(s12, s);
                    }
                    hashmap.put("GPID", s5);
                }
            }
        }
        if (((Boolean)a.get("IMID")).booleanValue())
        {
            String s13 = com.inmobi.commons.core.utilities.uid.c.a().a(com.inmobi.commons.a.a.b());
            if (s13 != null)
            {
                String s6 = s13;
                if (flag)
                {
                    s6 = a(s13, s);
                }
                hashmap.put("IMID", s6);
            }
        }
        if (((Boolean)a.get("AIDL")).booleanValue())
        {
            String s14 = com.inmobi.commons.core.utilities.uid.c.a().b(com.inmobi.commons.a.a.b());
            if (s14 != null)
            {
                String s7 = s14;
                if (flag)
                {
                    s7 = a(s14, s);
                }
                hashmap.put("AIDL", s7);
            }
        }
        return hashmap;
    }

    public Map b()
    {
        String s = Integer.toString((new Random()).nextInt());
        String s1 = com.inmobi.commons.core.utilities.a.c.a((new JSONObject(a(s, true))).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("u-id-map", s1);
        hashmap.put("u-id-key", s);
        hashmap.put("u-key-ver", com.inmobi.commons.core.utilities.uid.c.a().f());
        return hashmap;
    }
}
