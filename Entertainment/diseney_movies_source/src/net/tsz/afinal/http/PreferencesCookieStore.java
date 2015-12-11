// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore
    implements CookieStore
{
    public class SerializableCookie
        implements Serializable
    {

        private static final long serialVersionUID = 0x58765a8013aeb70cL;
        private transient BasicClientCookie clientCookie;
        private final transient Cookie cookie;
        final PreferencesCookieStore this$0;

        private void readObject(ObjectInputStream objectinputstream)
            throws IOException, ClassNotFoundException
        {
            clientCookie = new BasicClientCookie((String)objectinputstream.readObject(), (String)objectinputstream.readObject());
            clientCookie.setComment((String)objectinputstream.readObject());
            clientCookie.setDomain((String)objectinputstream.readObject());
            clientCookie.setExpiryDate((Date)objectinputstream.readObject());
            clientCookie.setPath((String)objectinputstream.readObject());
            clientCookie.setVersion(objectinputstream.readInt());
            clientCookie.setSecure(objectinputstream.readBoolean());
        }

        private void writeObject(ObjectOutputStream objectoutputstream)
            throws IOException
        {
            objectoutputstream.writeObject(cookie.getName());
            objectoutputstream.writeObject(cookie.getValue());
            objectoutputstream.writeObject(cookie.getComment());
            objectoutputstream.writeObject(cookie.getDomain());
            objectoutputstream.writeObject(cookie.getExpiryDate());
            objectoutputstream.writeObject(cookie.getPath());
            objectoutputstream.writeInt(cookie.getVersion());
            objectoutputstream.writeBoolean(cookie.isSecure());
        }

        public Cookie getCookie()
        {
            Object obj = cookie;
            if (clientCookie != null)
            {
                obj = clientCookie;
            }
            return ((Cookie) (obj));
        }

        public SerializableCookie(Cookie cookie1)
        {
            this$0 = PreferencesCookieStore.this;
            super();
            cookie = cookie1;
        }
    }


    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap cookies;

    public PreferencesCookieStore(Context context)
    {
        int i;
        i = 0;
        super();
        cookiePrefs = context.getSharedPreferences("CookiePrefsFile", 0);
        cookies = new ConcurrentHashMap();
        context = cookiePrefs.getString("names", null);
        if (context == null) goto _L2; else goto _L1
_L1:
        int j;
        context = TextUtils.split(context, ",");
        j = context.length;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        clearExpired(new Date());
_L2:
        return;
_L4:
        String s = context[i];
        Object obj = cookiePrefs.getString((new StringBuilder("cookie_")).append(s).toString(), null);
        if (obj != null)
        {
            obj = decodeCookie(((String) (obj)));
            if (obj != null)
            {
                cookies.put(s, obj);
            }
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void addCookie(Cookie cookie)
    {
        String s = cookie.getName();
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
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuffer.toString().toUpperCase();
            }
            int k = abyte0[i] & 0xff;
            if (k < 16)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(Integer.toHexString(k));
            i++;
        } while (true);
    }

    public void clear()
    {
        cookies.clear();
        android.content.SharedPreferences.Editor editor = cookiePrefs.edit();
        Iterator iterator = cookies.keySet().iterator();
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
        boolean flag = false;
        android.content.SharedPreferences.Editor editor = cookiePrefs.edit();
        Iterator iterator = cookies.entrySet().iterator();
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
                        editor.putString("names", TextUtils.join(",", cookies.keySet()));
                    }
                    editor.commit();
                    return flag;
                }
                entry = (java.util.Map.Entry)iterator.next();
                s = (String)entry.getKey();
            } while (!((Cookie)entry.getValue()).isExpired(date));
            cookies.remove(s);
            editor.remove((new StringBuilder("cookie_")).append(s).toString());
            flag = true;
        } while (true);
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
        int i = 0;
        do
        {
            if (i >= j)
            {
                return abyte0;
            }
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
            i += 2;
        } while (true);
    }
}
