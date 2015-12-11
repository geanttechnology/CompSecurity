// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

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

// Referenced classes of package shared_presage.com.loopj.android.http:
//            SerializableCookie

public class PersistentCookieStore
    implements CookieStore
{

    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap cookies = new ConcurrentHashMap();

    public PersistentCookieStore(Context context)
    {
        int i = 0;
        super();
        cookiePrefs = context.getSharedPreferences("CookiePrefsFile", 0);
        context = cookiePrefs.getString("names", null);
        if (context != null)
        {
            context = TextUtils.split(context, ",");
            for (int j = context.length; i < j; i++)
            {
                String s = context[i];
                Object obj = cookiePrefs.getString((new StringBuilder("cookie_")).append(s).toString(), null);
                if (obj == null)
                {
                    continue;
                }
                obj = decodeCookie(((String) (obj)));
                if (obj != null)
                {
                    cookies.put(s, obj);
                }
            }

            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie)
    {
        String s = (new StringBuilder()).append(cookie.getName()).append(cookie.getDomain()).toString();
        android.content.SharedPreferences.Editor editor;
        if (!cookie.isExpired(new Date()))
        {
            cookies.put(s, cookie);
        } else
        {
            cookies.remove(s);
        }
        editor = cookiePrefs.edit();
        editor.putString("names", TextUtils.join(",", cookies.keySet()));
        editor.putString((new StringBuilder("cookie_")).append(s).toString(), encodeCookie(new SerializableCookie(cookie)));
        editor.commit();
    }

    protected String byteArrayToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            int k = abyte0[i] & 0xff;
            if (k < 16)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(Integer.toHexString(k));
        }

        return stringbuilder.toString().toUpperCase();
    }

    public void clear()
    {
        android.content.SharedPreferences.Editor editor = cookiePrefs.edit();
        String s;
        for (Iterator iterator = cookies.keySet().iterator(); iterator.hasNext(); editor.remove((new StringBuilder("cookie_")).append(s).toString()))
        {
            s = (String)iterator.next();
        }

        editor.remove("names");
        editor.commit();
        cookies.clear();
    }

    public boolean clearExpired(Date date)
    {
        android.content.SharedPreferences.Editor editor = cookiePrefs.edit();
        Iterator iterator = cookies.entrySet().iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if (((Cookie)entry.getValue()).isExpired(date))
            {
                cookies.remove(s);
                editor.remove((new StringBuilder("cookie_")).append(s).toString());
                flag = true;
            }
        } while (true);
        if (flag)
        {
            editor.putString("names", TextUtils.join(",", cookies.keySet()));
        }
        editor.commit();
        return flag;
    }

    protected Cookie decodeCookie(String s)
    {
        s = new ByteArrayInputStream(hexStringToByteArray(s));
        try
        {
            s = ((SerializableCookie)(new ObjectInputStream(s)).readObject()).getCookie();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    protected String encodeCookie(SerializableCookie serializablecookie)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            (new ObjectOutputStream(bytearrayoutputstream)).writeObject(serializablecookie);
        }
        // Misplaced declaration of an exception variable
        catch (SerializableCookie serializablecookie)
        {
            return null;
        }
        return byteArrayToHexString(bytearrayoutputstream.toByteArray());
    }

    public List getCookies()
    {
        return new ArrayList(cookies.values());
    }

    protected byte[] hexStringToByteArray(String s)
    {
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }
}
