// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.a.a.a:
//            n

public class j
    implements CookieStore
{

    private static final String a = "LiveRailCookiePrefsFile";
    private static final String b = "names";
    private static final String c = "cookie_";
    private final ConcurrentHashMap d;
    private final SharedPreferences e;

    public j(Context context)
    {
        int i;
        i = 0;
        super();
        e = context.getSharedPreferences("LiveRailCookiePrefsFile", 0);
        d = new ConcurrentHashMap();
        context = e.getString("names", null);
        if (context == null) goto _L2; else goto _L1
_L1:
        int k;
        context = TextUtils.split(context, ",");
        k = context.length;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return;
_L3:
        String s = context[i];
        Object obj = e.getString((new StringBuilder("cookie_")).append(s).toString(), null);
        if (obj != null)
        {
            obj = a(((String) (obj)));
            if (obj != null)
            {
                d.put(s, obj);
            }
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected String a(n n1)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            (new ObjectOutputStream(bytearrayoutputstream)).writeObject(n1);
        }
        // Misplaced declaration of an exception variable
        catch (n n1)
        {
            return null;
        }
        return a(bytearrayoutputstream.toByteArray());
    }

    protected String a(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        int k = abyte0.length;
        int i = 0;
        do
        {
            if (i >= k)
            {
                return stringbuffer.toString().toUpperCase();
            }
            int l = abyte0[i] & 0xff;
            if (l < 16)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(Integer.toHexString(l));
            i++;
        } while (true);
    }

    protected Cookie a(String s)
    {
        s = new ByteArrayInputStream(b(s));
        try
        {
            s = ((n)(new ObjectInputStream(s)).readObject()).a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public void addCookie(Cookie cookie)
    {
        String s = cookie.getName();
        android.content.SharedPreferences.Editor editor;
        if (!cookie.isExpired(new Date()))
        {
            d.put(s, cookie);
        } else
        {
            d.remove(s);
        }
        editor = e.edit();
        editor.putString("names", TextUtils.join(",", d.keySet()));
        editor.putString((new StringBuilder("cookie_")).append(s).toString(), a(new n(cookie)));
        editor.commit();
    }

    protected byte[] b(String s)
    {
        int k = s.length();
        byte abyte0[] = new byte[k / 2];
        int i = 0;
        do
        {
            if (i >= k)
            {
                return abyte0;
            }
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
            i += 2;
        } while (true);
    }

    public void clear()
    {
        d.clear();
        android.content.SharedPreferences.Editor editor = e.edit();
        Iterator iterator = d.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                editor.remove("names");
                editor.commit();
                return;
            }
            String s = (String)iterator.next();
            editor.remove((new StringBuilder("cookie_")).append(s).toString());
        } while (true);
    }

    public boolean clearExpired(Date date)
    {
        android.content.SharedPreferences.Editor editor = e.edit();
        Iterator iterator = d.entrySet().iterator();
        boolean flag = false;
        do
        {
            java.util.Map.Entry entry;
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    if (flag)
                    {
                        editor.putString("names", TextUtils.join(",", d.keySet()));
                    }
                    editor.commit();
                    return flag;
                }
                entry = (java.util.Map.Entry)iterator.next();
                s = (String)entry.getKey();
            } while (!((Cookie)entry.getValue()).isExpired(date));
            d.remove(s);
            editor.remove((new StringBuilder("cookie_")).append(s).toString());
            flag = true;
        } while (true);
    }

    public List getCookies()
    {
        return new ArrayList(d.values());
    }
}
