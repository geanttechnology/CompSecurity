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
    private class RecordEventTask
        implements Runnable
    {

        final MboxFactory this$0;
        public String url;

        public void run()
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
            if (cookies != null)
            {
                httpget.setHeader("Cookie", cookies);
            }
            try
            {
                defaulthttpclient.execute(httpget);
                saveCookies(defaulthttpclient.getCookieStore());
                return;
            }
            catch (ClientProtocolException clientprotocolexception)
            {
                Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(clientprotocolexception.toString()).toString());
                return;
            }
            catch (IOException ioexception)
            {
                Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(ioexception.toString()).toString());
            }
        }

        public RecordEventTask(String s)
        {
            this$0 = MboxFactory.this;
            super();
            url = s;
        }
    }

    private class TargetBackgroundTask
        implements Runnable
    {

        public TargetCallback callback;
        final MboxFactory this$0;
        public String url;

        public void run()
        {
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            DefaultHttpClient defaulthttpclient;
            Object obj9;
            defaulthttpclient = new DefaultHttpClient();
            obj9 = new HttpGet(url);
            ((HttpGet) (obj9)).setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
            if (cookies != null)
            {
                ((HttpGet) (obj9)).setHeader("Cookie", cookies);
            }
            obj7 = null;
            obj8 = null;
            obj = null;
            obj5 = null;
            obj6 = null;
            obj4 = null;
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            obj9 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj9)));
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            int i = ((HttpResponse) (obj9)).getStatusLine().getStatusCode();
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            String s = ((HttpResponse) (obj9)).getFirstHeader("Content-Type").getValue();
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            saveCookies(defaulthttpclient.getCookieStore());
            if (i != 200) goto _L2; else goto _L1
_L1:
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            if (!s.equals("image/gif")) goto _L3; else goto _L2
_L2:
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            callback.call("/images/log.gif");
            obj1 = obj4;
_L7:
            Exception exception1;
            try
            {
                ((InputStream) (obj)).close();
                ((ByteArrayOutputStream) (obj1)).close();
                return;
            }
            catch (Exception exception)
            {
                return;
            }
_L3:
            obj2 = obj6;
            obj1 = obj7;
            obj3 = obj8;
            obj = ((HttpResponse) (obj9)).getEntity().getContent();
            obj2 = obj6;
            obj1 = obj;
            obj3 = obj;
            obj4 = new ByteArrayOutputStream();
            obj1 = new byte[512];
_L6:
            i = ((InputStream) (obj)).read(((byte []) (obj1)));
            if (i == -1) goto _L5; else goto _L4
_L4:
            ((ByteArrayOutputStream) (obj4)).write(((byte []) (obj1)), 0, i);
              goto _L6
            obj2;
            obj1 = obj4;
            obj3 = obj;
            obj4 = obj2;
            obj = obj1;
_L10:
            obj2 = obj;
            obj1 = obj3;
            Log.e("MboxFactory", (new StringBuilder()).append("ERROR: ").append(((IOException) (obj4)).toString()).toString());
            obj2 = obj;
            obj1 = obj3;
            callback.call("/images/log.gif");
            try
            {
                ((InputStream) (obj3)).close();
                ((ByteArrayOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
_L5:
            callback.call(new String(((ByteArrayOutputStream) (obj4)).toByteArray(), "UTF-8"));
            obj1 = obj4;
              goto _L7
            obj;
_L9:
            try
            {
                ((InputStream) (obj1)).close();
                ((ByteArrayOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            throw obj;
            exception1;
            obj2 = obj4;
            obj1 = obj;
            obj = exception1;
            if (true) goto _L9; else goto _L8
_L8:
            obj4;
            obj = obj5;
              goto _L10
        }

        public TargetBackgroundTask(Mbox mbox, String s, TargetCallback targetcallback)
        {
            this$0 = MboxFactory.this;
            super();
            url = s;
            callback = targetcallback;
        }
    }

    protected static interface TargetCallback
    {

        public abstract void call(Object obj);
    }


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
        if (context == null)
        {
            Log.d("TARGET", "Parameter 'parentContext' in MboxFactory() cannot be null");
            return;
        }
        if (s == null || s.length() == 0)
        {
            Log.d("TARGET", "Parameter 'clientCode' in MboxFactory() cannot be null or empty");
            return;
        } else
        {
            parentContext = context;
            clientCode = s;
            disableDuration = 0xdbba0L;
            factoryEnabled = true;
            mboxServerURL = (new StringBuilder()).append("http://").append(s).append(".tt.omtrdc.net").toString();
            preferences = context.getSharedPreferences((new StringBuilder()).append("TestAndTarget").append(s).toString(), 0);
            loadCookie("mboxPC");
            loadCookie("mboxSession");
            return;
        }
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
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = System.currentTimeMillis();
        l1 = preferences.getLong((new StringBuilder()).append(s).append("_Expires").toString(), 0L);
        if (l1 <= 0L) goto _L2; else goto _L1
_L1:
        if (l1 <= l)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        String s1 = preferences.getString((new StringBuilder()).append(s).append("_Value").toString(), "");
        if (cookies != null) goto _L4; else goto _L3
_L3:
        cookies = (new StringBuilder()).append(s).append("=").append(s1).toString();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        cookies = (new StringBuilder()).append(cookies).append("; ").append(s).append("=").append(s1).toString();
          goto _L2
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        deleteCookie(s);
          goto _L2
    }

    private void saveCookies(CookieStore cookiestore)
    {
        this;
        JVM INSTR monitorenter ;
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
        break MISSING_BLOCK_LABEL_72;
        cookiestore;
        this;
        JVM INSTR monitorexit ;
        throw cookiestore;
        loadCookie("mboxPC");
        loadCookie("mboxSession");
        this;
        JVM INSTR monitorexit ;
    }

    private void storeCookie(String s, Cookie cookie)
    {
        this;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString((new StringBuilder()).append(s).append("_Value").toString(), cookie.getValue());
        editor.putLong((new StringBuilder()).append(s).append("_Expires").toString(), cookie.getExpiryDate().getTime());
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void clearCookies()
    {
        cookies = null;
        deleteCookie("mboxPC");
        deleteCookie("mboxSession");
    }

    public Mbox create(String s)
    {
        if (s == null || s.length() == 0)
        {
            Log.d("TARGET", "Parameter 'mboxName' in create() cannot be null or empty");
            return null;
        } else
        {
            Mbox mbox = new Mbox(this, s);
            mboxList.put(s, mbox);
            return mbox;
        }
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
        this;
        JVM INSTR monitorexit ;
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

    protected void getMboxResponse(final Mbox mbox, String s)
    {
        this;
        JVM INSTR monitorenter ;
        (new Thread(new TargetBackgroundTask(mbox, s, new TargetCallback() {

            final MboxFactory this$0;
            final Mbox val$mbox;

            public volatile void call(Object obj)
            {
                call((String)obj);
            }

            public void call(String s1)
            {
                mbox.callOnLoadConsumers(s1);
            }

            
            {
                this$0 = MboxFactory.this;
                mbox = mbox1;
                super();
            }
        }))).start();
        this;
        JVM INSTR monitorexit ;
        return;
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
        long l = System.currentTimeMillis();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getBaseRequestURL()).append("mbox=").append(encode(s)).append("&mboxDefault=").append(encode("/images/log.gif")).append("&mboxTime=").append(String.valueOf(l));
        (new Thread(new RecordEventTask(stringbuilder.toString()))).start();
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


}
