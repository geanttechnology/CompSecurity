// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.adobe.adms.testandtarget:
//            Mbox

public final class MboxFactory
{

    private static final int BUFFER_SIZE = 512;
    private static final String COOKIE_EXPIRES_KEY_SUFFIX = "_Expires";
    private static final String COOKIE_VALUE_KEY_SUFFIX = "_Value";
    private static final long DEFAULT_DISABLE_DURATION = 0xdbba0L;
    private static final String LOG_TAG = "MboxFactory";
    private static final String MBOX_DEFAULT = "/images/log.gif";
    private static final String MBOX_DEFAULT_CONTENT_TYPE = "image/gif";
    private static final String MBOX_SERVER_PROTOCOL = "http://";
    private static final String MBOX_SERVER_SUFFIX = ".tt.omtrdc.net";
    private static final String OFFER_ENCODING = "UTF-8";
    private static final String PREFERENCES_DISABLE_KEY = "DisableTime";
    private static final String PREFERENCES_PREFIX = "TestAndTarget";
    protected static final String USER_AGENT = "Apache-HttpClient (Test&Target Android SDK)";
    private String clientCode;
    private String cookies;
    private long disableDuration;
    private boolean factoryEnabled;
    private ConcurrentHashMap mboxList;
    private String mboxServerURL;
    private Context parentContext;
    private SharedPreferences preferences;

    public MboxFactory(Context context, String s)
    {
        mboxList = new ConcurrentHashMap();
        parentContext = context;
        clientCode = s;
        disableDuration = 0xdbba0L;
        factoryEnabled = true;
        mboxServerURL = (new StringBuilder()).append("http://").append(s).append(".tt.omtrdc.net").toString();
        preferences = context.getSharedPreferences((new StringBuilder()).append("TestAndTarget").append(s).toString(), 0);
        loadCookie("mboxPC");
        loadCookie("mboxSession");
    }

    private void deleteCookie(String s)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.remove((new StringBuilder()).append(s).append("_Value").toString());
        editor.remove((new StringBuilder()).append(s).append("_Expires").toString());
        editor.commit();
    }

    private void loadCookie(String s)
    {
label0:
        {
            String s1;
label1:
            {
                long l = System.currentTimeMillis();
                long l1 = preferences.getLong((new StringBuilder()).append(s).append("_Expires").toString(), 0L);
                if (l1 > 0L)
                {
                    if (l1 <= l)
                    {
                        break label0;
                    }
                    s1 = preferences.getString((new StringBuilder()).append(s).append("_Value").toString(), "");
                    if (cookies != null)
                    {
                        break label1;
                    }
                    cookies = (new StringBuilder()).append(s).append("=").append(s1).toString();
                }
                return;
            }
            cookies = (new StringBuilder()).append(cookies).append("; ").append(s).append("=").append(s1).toString();
            return;
        }
        deleteCookie(s);
    }

    private void saveCookies(CookieStore cookiestore)
    {
        cookiestore = cookiestore.getCookies().iterator();
        do
        {
            if (!cookiestore.hasNext())
            {
                break;
            }
            Cookie cookie = (Cookie)cookiestore.next();
            String s = cookie.getName();
            if (s.equals("mboxSession") || s.equals("mboxPC"))
            {
                storeCookie(s, cookie);
            }
        } while (true);
        loadCookie("mboxPC");
        loadCookie("mboxSession");
    }

    private void storeCookie(String s, Cookie cookie)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString((new StringBuilder()).append(s).append("_Value").toString(), cookie.getValue());
        editor.putLong((new StringBuilder()).append(s).append("_Expires").toString(), cookie.getExpiryDate().getTime());
        editor.commit();
    }

    public void clearCookies()
    {
        this;
        JVM INSTR monitorenter ;
        cookies = null;
        deleteCookie("mboxPC");
        deleteCookie("mboxSession");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Mbox create(String s)
    {
        Mbox mbox = new Mbox(this, s);
        mboxList.put(s, mbox);
        return mbox;
    }

    public void disable()
    {
        this;
        JVM INSTR monitorenter ;
        factoryEnabled = false;
        long l = System.currentTimeMillis();
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("DisableTime", l);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected String encode(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.e("MboxFactory", unsupportedencodingexception.toString());
            return s;
        }
        return s1;
    }

    protected String getBaseRequestURL()
    {
        return (new StringBuilder()).append(mboxServerURL).append("/m2/").append(clientCode).append("/ubox/raw?").toString();
    }

    protected String getCookies()
    {
        return cookies;
    }

    protected String getMboxResponse(Mbox mbox, String s)
    {
        this;
        JVM INSTR monitorenter ;
        mbox = new DefaultHttpClient();
        s = new HttpGet(s);
        s.setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
        if (cookies != null)
        {
            s.setHeader("Cookie", cookies);
        }
        String s1;
        int i;
        s = mbox.execute(s);
        i = s.getStatusLine().getStatusCode();
        s1 = s.getFirstHeader("Content-Type").getValue();
        saveCookies(mbox.getCookieStore());
        if (i != 200) goto _L2; else goto _L1
_L1:
        boolean flag = s1.equals("image/gif");
        if (!flag) goto _L3; else goto _L2
_L2:
        mbox = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        return mbox;
_L3:
        byte abyte0[];
        mbox = s.getEntity().getContent();
        s = new ByteArrayOutputStream();
        abyte0 = new byte[512];
_L4:
        i = mbox.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        s.write(abyte0, 0, i);
          goto _L4
        mbox;
        Log.e("MboxFactory", (new StringBuilder()).append("ERROR: ").append(mbox.toString()).toString());
        mbox = null;
        continue; /* Loop/switch isn't completed */
        mbox = new String(s.toByteArray(), "UTF-8");
        if (true) goto _L6; else goto _L5
_L5:
        mbox;
        throw mbox;
    }

    protected boolean isEnabled()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        if (preferences == null)
        {
            preferences = parentContext.getSharedPreferences((new StringBuilder()).append("TestAndTarget").append(clientCode).toString(), 0);
        }
        l = preferences.getLong("DisableTime", 0L);
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        l = System.currentTimeMillis() - l;
        if (l >= disableDuration)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        Log.w("MboxFactory", (new StringBuilder()).append("WARNING: ").append(String.valueOf(disableDuration - l)).append("ms until MboxFactory is re-enabled.").toString());
        factoryEnabled = false;
_L1:
        boolean flag = factoryEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        factoryEnabled = true;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public void recordEvent(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        long l = System.currentTimeMillis();
        obj = (new StringBuilder()).append(getBaseRequestURL()).append("mbox=").append(encode(s)).append("&mboxDefault=").append(encode("/images/log.gif")).append("&mboxTime=").append(String.valueOf(l)).toString();
        s = new DefaultHttpClient();
        obj = new HttpGet(((String) (obj)));
        ((HttpGet) (obj)).setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
        if (cookies != null)
        {
            ((HttpGet) (obj)).setHeader("Cookie", cookies);
        }
        s.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        saveCookies(s.getCookieStore());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(s.toString()).toString());
          goto _L1
        s;
        throw s;
        s;
        Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(s.toString()).toString());
          goto _L1
    }

    public void setDisableDuration(long l)
    {
        this;
        JVM INSTR monitorenter ;
        disableDuration = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setMboxServer(String s)
        throws IllegalArgumentException
    {
        s = s.toLowerCase();
        if (s.startsWith("http://") || s.startsWith("https://"))
        {
            mboxServerURL = s;
            return;
        } else
        {
            throw new IllegalArgumentException("ERROR: mbox server URL must begin with \"http://\" or \"https://\".");
        }
    }
}
