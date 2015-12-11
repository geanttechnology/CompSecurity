// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils.cookies;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.sponsorpay.utils.cookies:
//            SerializableHttpCookie

public class PersistentHttpCookieStore
    implements CookieStore
{

    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentHttpCookieStore";
    private final SharedPreferences cookiePrefs;
    private final Map map;

    public PersistentHttpCookieStore(Context context)
    {
        int i;
        i = 0;
        super();
        cookiePrefs = context.getSharedPreferences("CookiePrefsFile", 0);
        map = new HashMap();
        context = cookiePrefs.getString("names", null);
        if (context == null) goto _L2; else goto _L1
_L1:
        int j;
        context = TextUtils.split(context, ",");
        j = context.length;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        String s = context[i];
        Object obj = cookiePrefs.getString((new StringBuilder("cookie_")).append(s).toString(), null);
        if (StringUtils.notNullNorEmpty(((String) (obj))))
        {
            obj = decodeCookies(((String) (obj)));
            map.put(URI.create(s), obj);
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private URI cookiesUri(URI uri)
    {
        if (uri == null)
        {
            return null;
        }
        URI uri1;
        try
        {
            uri1 = new URI(uri.getScheme(), uri.getHost(), null, null);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            return uri;
        }
        return uri1;
    }

    private List decodeCookies(String s)
    {
        LinkedList linkedlist = new LinkedList();
        s = TextUtils.split(s, ",");
        int j = s.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return linkedlist;
            }
            linkedlist.add(decodeCookie(s[i]));
            i++;
        } while (true);
    }

    private String encodeCookies(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.deleteCharAt(stringbuilder.length() - 1);
                }
                return stringbuilder.toString();
            }
            stringbuilder.append(encodeCookie(new SerializableHttpCookie((HttpCookie)list.next())));
            stringbuilder.append(",");
        } while (true);
    }

    public void add(URI uri, HttpCookie httpcookie)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpcookie != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("cookie == null");
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
        URI uri1;
        uri1 = cookiesUri(uri);
        uri = (List)map.get(uri1);
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        uri = new ArrayList();
        map.put(uri1, uri);
_L1:
        uri.add(httpcookie);
        httpcookie = cookiePrefs.edit();
        httpcookie.putString("names", TextUtils.join(",", map.keySet()));
        httpcookie.putString((new StringBuilder("cookie_")).append(uri1).toString(), encodeCookies(uri));
        httpcookie.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        uri.remove(httpcookie);
          goto _L1
    }

    protected String byteArrayToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuilder.toString().toUpperCase(Locale.US);
            }
            int k = abyte0[i] & 0xff;
            if (k < 16)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(Integer.toHexString(k));
            i++;
        } while (true);
    }

    protected HttpCookie decodeCookie(String s)
    {
        s = new ByteArrayInputStream(hexStringToByteArray(s));
        try
        {
            s = ((SerializableHttpCookie)(new ObjectInputStream(s)).readObject()).getCookie();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SponsorPayLogger.d("PersistentHttpCookieStore", (new StringBuilder("IOException in decodeCookie - ")).append(s.getLocalizedMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SponsorPayLogger.d("PersistentHttpCookieStore", (new StringBuilder("ClassNotFoundException in decodeCookie - ")).append(s.getLocalizedMessage()).toString());
            return null;
        }
        return s;
    }

    protected String encodeCookie(SerializableHttpCookie serializablehttpcookie)
    {
        if (serializablehttpcookie == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            (new ObjectOutputStream(bytearrayoutputstream)).writeObject(serializablehttpcookie);
        }
        // Misplaced declaration of an exception variable
        catch (SerializableHttpCookie serializablehttpcookie)
        {
            SponsorPayLogger.d("PersistentHttpCookieStore", (new StringBuilder("IOException in encodeCookie - ")).append(serializablehttpcookie.getLocalizedMessage()).toString());
            return null;
        }
        return byteArrayToHexString(bytearrayoutputstream.toByteArray());
    }

    public List get(URI uri)
    {
        this;
        JVM INSTR monitorenter ;
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException("uri == null");
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = (List)map.get(uri);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L6:
        if (((Iterator) (obj)).hasNext()) goto _L3; else goto _L2
_L2:
        obj = map.entrySet().iterator();
_L8:
        if (((Iterator) (obj)).hasNext()) goto _L5; else goto _L4
_L4:
        uri = Collections.unmodifiableList(arraylist);
        this;
        JVM INSTR monitorexit ;
        return uri;
_L3:
        Object obj1;
label0:
        {
            obj1 = (HttpCookie)((Iterator) (obj)).next();
            if (!((HttpCookie) (obj1)).hasExpired())
            {
                break label0;
            }
            ((Iterator) (obj)).remove();
        }
          goto _L6
        arraylist.add(obj1);
          goto _L6
_L5:
        obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        if (uri.equals(((java.util.Map.Entry) (obj1)).getKey())) goto _L8; else goto _L7
_L7:
        obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
_L10:
        HttpCookie httpcookie;
        while (((Iterator) (obj1)).hasNext()) 
        {
            httpcookie = (HttpCookie)((Iterator) (obj1)).next();
            if (HttpCookie.domainMatches(httpcookie.getDomain(), uri.getHost()))
            {
                if (!httpcookie.hasExpired())
                {
                    continue; /* Loop/switch isn't completed */
                }
                ((Iterator) (obj1)).remove();
            }
        }
          goto _L8
        if (arraylist.contains(httpcookie)) goto _L10; else goto _L9
_L9:
        arraylist.add(httpcookie);
        if (true) goto _L10; else goto _L11
_L11:
          goto _L8
    }

    public List getCookies()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = map.values().iterator();
_L7:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj = Collections.unmodifiableList(((List) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        Iterator iterator1 = ((List)iterator.next()).iterator();
_L4:
        HttpCookie httpcookie;
        while (iterator1.hasNext()) 
        {
            httpcookie = (HttpCookie)iterator1.next();
            if (!httpcookie.hasExpired())
            {
                continue; /* Loop/switch isn't completed */
            }
            iterator1.remove();
        }
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        if (((List) (obj)).contains(httpcookie)) goto _L4; else goto _L3
_L3:
        ((List) (obj)).add(httpcookie);
        if (true) goto _L4; else goto _L5
_L5:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public List getURIs()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList(map.keySet());
        ((List) (obj)).remove(null);
        obj = Collections.unmodifiableList(((List) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Exception exception;
        exception;
        throw exception;
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

    public boolean remove(URI uri, HttpCookie httpcookie)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpcookie != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("cookie == null");
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
        List list;
        uri = cookiesUri(uri);
        list = (List)map.get(uri);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        boolean flag = list.remove(httpcookie);
        if (!flag) goto _L2; else goto _L1
_L1:
        httpcookie = cookiePrefs.edit();
        if (!list.isEmpty()) goto _L4; else goto _L3
_L3:
        httpcookie.remove((new StringBuilder("cookie_")).append(uri).toString());
_L5:
        httpcookie.commit();
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        httpcookie.putString((new StringBuilder("cookie_")).append(uri).toString(), encodeCookies(list));
          goto _L5
        flag = false;
          goto _L2
    }

    public boolean removeAll()
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        Iterator iterator;
        editor = cookiePrefs.edit();
        iterator = map.keySet().iterator();
_L1:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        editor.remove("names");
        editor.commit();
        Exception exception;
        boolean flag;
        if (map.isEmpty())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        map.clear();
        this;
        JVM INSTR monitorexit ;
        return flag;
        URI uri = (URI)iterator.next();
        editor.remove((new StringBuilder("cookie_")).append(uri).toString());
          goto _L1
        exception;
        throw exception;
    }
}
