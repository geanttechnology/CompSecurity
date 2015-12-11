// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Message;
import android.util.Log;
import com.medialets.commons.codec.binary.Base64;
import com.medialets.thrift.BroadcastData;
import com.medialets.thrift.ECActionResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

// Referenced classes of package com.medialets.analytics:
//            e, a, d, g, 
//            BinaryResponseHandler, MMAnalyticsManager

final class f
    implements Runnable
{

    private final Context a;
    private final String b;
    private LocationManager c;
    private final String d;
    private final String e;
    private d f;
    private final SharedPreferences g;
    private final List h = new LinkedList();
    private boolean i;

    public f(Context context, String s, String s1, String s2)
    {
        i = false;
        a = context;
        d = s1;
        e = s2;
        b = s;
        g = a.getSharedPreferences("com.medialets", 0);
    }

    private Location a()
    {
        Location location;
        try
        {
            location = c.getLastKnownLocation(b);
        }
        catch (Exception exception)
        {
            Log.d("MMT.HTTPTransport", (new StringBuilder()).append("Exception caught:: ").append(exception.toString()).toString());
            return null;
        }
        return location;
    }

    private void a(ECActionResponse ecactionresponse)
    {
        android.content.SharedPreferences.Editor editor = g.edit();
        editor.putLong("lastBroadcastTime", System.currentTimeMillis());
        if (ecactionresponse.isSetMinBroadcastInterval())
        {
            editor.putLong("broadcastInterval", ecactionresponse.getMinBroadcastInterval());
        }
        if (ecactionresponse.getBroadcastURL() != null && ecactionresponse.getBroadcastURL().length() > 0)
        {
            editor.putString("broadcastURL", ecactionresponse.getBroadcastURL());
        }
        String s = g.getString("broadcastURLNew", null);
        if (s != null)
        {
            editor.putString("broadcastURL", s);
            editor.remove("broadcastURL");
        }
        if (ecactionresponse.getClientToken() != null && ecactionresponse.getClientToken().length() > 0)
        {
            editor.putString("clientToken", ecactionresponse.getClientToken());
        }
        if (ecactionresponse.getAppTok() != null && ecactionresponse.getAppTok().length() > 0)
        {
            editor.putString("appTok", ecactionresponse.getAppTok());
        }
        if (ecactionresponse.getDevTok() != null && ecactionresponse.getDevTok().length() > 0)
        {
            editor.putString("devTok", ecactionresponse.getDevTok());
        }
        if (ecactionresponse.getUserMessage() != null && ecactionresponse.getUserMessage().length() > 0 && !ecactionresponse.getUserMessage().equals(e))
        {
            editor.putString("versionMessage", ecactionresponse.getUserMessage());
            if (ecactionresponse.getUserMessageURL() != null && ecactionresponse.getUserMessageURL().length() > 0)
            {
                editor.putString("versionMessageURL", ecactionresponse.getUserMessageURL());
            }
        }
        if (ecactionresponse.getAdInstructionsSize() > 0)
        {
            synchronized (h)
            {
                h.clear();
                h.addAll(ecactionresponse.getAdInstructions());
            }
        }
        if (ecactionresponse.isShutdown())
        {
            i = true;
        }
        editor.commit();
        return;
        ecactionresponse;
        list;
        JVM INSTR monitorexit ;
        throw ecactionresponse;
    }

    public final void run()
    {
        List list;
        BroadcastData broadcastdata;
        String s = com.medialets.analytics.e.a(new Date());
        f = new a(a);
        c = (LocationManager)a.getSystemService("location");
        list = f.b(e);
        broadcastdata = new BroadcastData();
        broadcastdata.setTime(s);
        Object obj;
        Object obj1;
        HttpPost httppost;
        ArrayList arraylist;
        DeflaterOutputStream deflateroutputstream;
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        broadcastdata.setLocTrOn(flag);
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        broadcastdata.setLocSrvOn(flag);
        broadcastdata.setRuns(list);
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        broadcastdata.setLat(((Location) (obj)).getLatitude());
        broadcastdata.setLon(((Location) (obj)).getLongitude());
        if (((Location) (obj)).hasAltitude())
        {
            broadcastdata.setAlt(((Location) (obj)).getAltitude());
        }
        if (((Location) (obj)).hasAccuracy())
        {
            broadcastdata.setHorizontalAccuracy(((Location) (obj)).getAccuracy());
        }
        if (i)
        {
            break MISSING_BLOCK_LABEL_968;
        }
        if (!g.getBoolean("useTestServer", false))
        {
            break MISSING_BLOCK_LABEL_779;
        }
        obj = g.getString("broadcastURL", "http://beta.medialytics.com/event");
        Log.v("MMT.HTTPTransport", (new StringBuilder()).append("Using server: ").append(((String) (obj))).toString());
_L1:
        g.getBoolean("debug", false);
        httppost = new HttpPost(((String) (obj)));
        arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("v", "2.0"));
        arraylist.add(new BasicNameValuePair("b", Integer.toString(0)));
        arraylist.add(new BasicNameValuePair("tok", g.getString("clientToken", "CAFEBABE")));
        arraylist.add(new BasicNameValuePair("sys", "Android"));
        arraylist.add(new BasicNameValuePair("sysv", g.DEVICE_SYSTEM_VERSION));
        obj1 = a;
        obj = d;
        obj1 = android.provider.Settings.Secure.getString(((Context) (obj1)).getContentResolver(), "android_id");
        if (obj1 != null)
        {
            obj = obj1;
        }
        arraylist.add(new BasicNameValuePair("dev", com.medialets.analytics.e.a(((String) (obj)))));
        arraylist.add(new BasicNameValuePair("model", g.DEVICE_MODEL));
        arraylist.add(new BasicNameValuePair("app", d));
        arraylist.add(new BasicNameValuePair("appv", e));
        obj = (new TSerializer()).serialize(broadcastdata);
        obj1 = new ByteArrayOutputStream(obj.length);
        deflateroutputstream = new DeflaterOutputStream(((java.io.OutputStream) (obj1)));
        deflateroutputstream.write(((byte []) (obj)), 0, obj.length);
        deflateroutputstream.finish();
        deflateroutputstream.close();
        arraylist.add(new BasicNameValuePair("data", new String(Base64.encodeBase64(((ByteArrayOutputStream) (obj1)).toByteArray(), false))));
        if (g.contains("appTok"))
        {
            arraylist.add(new BasicNameValuePair("appTok", g.getString("appTok", "")));
        }
        if (g.contains("devTok"))
        {
            arraylist.add(new BasicNameValuePair("devTok", g.getString("devTok", "")));
        }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        obj = new BinaryResponseHandler();
        obj1 = (byte[])(new DefaultHttpClient()).execute(httppost, ((org.apache.http.client.ResponseHandler) (obj)));
        if (obj1 == null)
        {
            Object obj2;
            try
            {
                throw new IOException("No data returned from HTTP post");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("MMT.HTTPTransport", (new StringBuilder()).append("Transport Exception caught:: ").append(((NoSuchAlgorithmException) (obj)).toString()).toString());
            }
            catch (TException texception)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
            return;
        }
        break MISSING_BLOCK_LABEL_823;
        obj = g.getString("broadcastURL", "http://t.medialytics.com/event");
        Log.v("MMT.HTTPTransport", (new StringBuilder()).append("Using server: ").append(((String) (obj))).toString());
          goto _L1
        obj2 = new TDeserializer(new org.apache.thrift.protocol.TBinaryProtocol.Factory());
        obj = new ECActionResponse();
        ((TDeserializer) (obj2)).deserialize(((org.apache.thrift.TBase) (obj)), ((byte []) (obj1)));
        obj1 = new TSerializer(new org.apache.thrift.protocol.TSimpleJSONProtocol.Factory());
        obj2 = new PrintStream(new BufferedOutputStream(a.openFileOutput("lastResponse.txt", 0), 4096));
        ((PrintStream) (obj2)).print(((TSerializer) (obj1)).toString(((org.apache.thrift.TBase) (obj))));
        ((PrintStream) (obj2)).close();
        a(((ECActionResponse) (obj)));
        Log.d("MMT.HTTPTransport", (new StringBuilder()).append("Posted data to server - ").append(broadcastdata.getRunsSize()).append(" runs sent, ").append(((ECActionResponse) (obj)).getReceivedRunsSize()).append(" received").toString());
        f.a(list);
        Message.obtain(MMAnalyticsManager.sharedInstance(a).mHandler, 1, null).sendToTarget();
        return;
    }
}
