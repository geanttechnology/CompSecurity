// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            j, m

public class v
{

    private static Object a = new Object();
    private static Map b = new HashMap();

    public static String a(Object obj)
    {
        if (obj == null)
        {
            return "(null)";
        } else
        {
            return obj.toString();
        }
    }

    protected static String a(String s, String s1, boolean flag)
    {
        String s2;
        Object obj;
        boolean flag1;
        flag1 = false;
        if (s == null || "".equals(s))
        {
            return "";
        }
        s2 = s;
        if (flag)
        {
            s2 = s.toLowerCase();
        }
        obj = null;
        s = "SHA-1";
        if ("MD5".equals(s1))
        {
            s = "MD5";
        }
        try
        {
            s = MessageDigest.getInstance(s);
            s1 = s2.getBytes("UTF-8");
            s.update(s1, 0, s1.length);
            s = s.digest();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag1 = true;
            s = obj;
        }
        if (flag1)
        {
            return "";
        } else
        {
            return a(((byte []) (s)));
        }
    }

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder;
        int i;
        int i1;
        stringbuilder = new StringBuilder();
        i1 = abyte0.length;
        i = 0;
_L2:
        int k;
        int l;
        byte byte0;
        if (i >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte0[i];
        k = byte0 >>> 4 & 0xf;
        l = 0;
_L3:
        char c1;
        if (k >= 0 && k <= 9)
        {
            c1 = (char)(k + 48);
        } else
        {
            c1 = (char)((k - 10) + 97);
        }
        stringbuilder.append(c1);
        if (l < 1)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
        l++;
        k = byte0 & 0xf;
          goto _L3
    }

    protected static void a()
    {
        synchronized (a)
        {
            b.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static boolean a(Context context)
    {
        boolean flag;
        boolean flag2 = false;
        flag = false;
        boolean flag1 = flag2;
        CertificateFactory certificatefactory;
        int i;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return flag1;
        }
        flag1 = flag2;
        certificatefactory = CertificateFactory.getInstance("X.509");
        i = 0;
_L2:
        flag1 = flag;
        if (i >= context.length)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        flag = ((X509Certificate)certificatefactory.generateCertificate(new ByteArrayInputStream(context[i].toByteArray()))).getSubjectX500Principal().getName().startsWith("CN=Android Debug,O=Android");
        if (flag)
        {
            return flag;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return flag;
    }

    public static boolean a(j j1)
    {
        return j1 == null || j1.b();
    }

    public static boolean a(String s)
    {
        return s == null || "".equals(s);
    }

    protected static boolean a(String s, String s1)
    {
        Pattern pattern;
        if (a(s) || a(s1))
        {
            return false;
        }
        pattern = null;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b.containsKey(s))
        {
            pattern = (Pattern)b.get(s);
        }
        Pattern pattern1;
        pattern1 = pattern;
        if (pattern != null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        pattern1 = Pattern.compile(s, 2);
        b.put(s, pattern1);
        obj;
        JVM INSTR monitorexit ;
        boolean flag = pattern1.matcher(s1).matches();
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Caught invalid regex Pattern exception: ").append(s).toString());
        }
        return false;
    }

    public static boolean a(List list)
    {
        return list == null || list.size() == 0;
    }

    public static boolean a(Map map)
    {
        return map == null || map.isEmpty();
    }

    protected static boolean a(Map map, Map map1)
    {
        if (a(map) || a(map1))
        {
            return false;
        }
        HashSet hashset = new HashSet(map.keySet());
        hashset.retainAll(map1.keySet());
        if (hashset.isEmpty())
        {
            return false;
        }
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            Object obj1 = (java.util.Map.Entry)map.next();
            Object obj = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = (Set)((java.util.Map.Entry) (obj1)).getValue();
            obj = (Set)map1.get(obj);
            if (!a(((Set) (obj1))) && !a(((Set) (obj))))
            {
                obj1 = new HashSet(((java.util.Collection) (obj1)));
                ((Set) (obj1)).retainAll(((java.util.Collection) (obj)));
                if (!((Set) (obj1)).isEmpty())
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean a(Set set)
    {
        return set == null || set.size() == 0;
    }

    public static boolean a(JSONArray jsonarray)
    {
        return jsonarray == null || jsonarray.length() == 0;
    }

    public static boolean a(JSONObject jsonobject)
    {
        return jsonobject == null || jsonobject.length() == 0;
    }

    protected static String b(String s)
    {
        String s1 = "";
        try
        {
            if (!a(s))
            {
                s1 = Base64.encodeToString(s.getBytes("UTF-8"), 8);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (m.s())
            {
                s.printStackTrace();
            }
            return "";
        }
        return s1;
    }

    protected static Map b(JSONObject jsonobject)
        throws JSONException
    {
        Object obj = new HashMap();
        if (jsonobject != JSONObject.NULL)
        {
            obj = c(jsonobject);
        }
        return ((Map) (obj));
    }

    protected static Map c(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            String s1 = jsonobject.optString(s);
            if (s1 != null)
            {
                hashmap.put(s, s1);
            }
        } while (true);
        return hashmap;
    }

    protected static boolean c(String s)
    {
        if (!a(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Pattern.compile(s, 2);
        return true;
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Can't process invalid key regular expression: ").append(s).toString());
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}
