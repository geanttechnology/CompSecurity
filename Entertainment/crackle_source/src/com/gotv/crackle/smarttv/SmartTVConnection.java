// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.Handler;
import android.os.Message;
import com.gotv.crackle.util.Log;
import com.samsung.rest.OnRequestCallbackListener;
import com.samsung.rest.Request;
import com.samsung.rest.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVRestClient, SmartTVListener, SmartTV

public class SmartTVConnection
    implements OnRequestCallbackListener
{
    private class InternalHandler extends Handler
    {

        final SmartTVConnection this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 4: // '\004'
            default:
                return;

            case 3: // '\003'
                handleRequestInfo((Response)message.obj);
                return;

            case 1: // '\001'
                handleConnection((Response)message.obj);
                return;

            case 2: // '\002'
                handleDisconnection((Response)message.obj);
                return;

            case 5: // '\005'
                handleLauncher((Response)message.obj);
                break;
            }
        }

        private InternalHandler()
        {
            this$0 = SmartTVConnection.this;
            super();
        }

    }


    private static final int DEFAULT_EMULATOR_PORT = 8008;
    private static final int DEFAULT_TV_PORT = 80;
    private static final String DEFAULT_WIDGET = "Crackle";
    private static final int MESSAGE_CONNECTION = 1;
    private static final int MESSAGE_DATA_SENT = 4;
    private static final int MESSAGE_DISCONNECTION = 2;
    private static final int MESSAGE_LAUNCH_APP = 5;
    private static final int MESSAGE_REQUEST_INFO = 3;
    private static String PATH_WIDGET = "/mnt/sdcard/widgetInfo.txt";
    private static final String TAG = "SmartTVConnection";
    private static String WIDGET = "";
    private static final String WIDGET_ID = "111299002012";
    public static ThreadSafeClientConnManager connManager;
    private final InternalHandler mHandler = new InternalHandler();
    private boolean mIsConnected;
    private List mListeners;
    private URL mLocation;
    private SmartTVRestClient mRestClient;

    public SmartTVConnection()
    {
        mRestClient = null;
        mListeners = null;
        mLocation = null;
        mIsConnected = false;
        mRestClient = new SmartTVRestClient(this);
        mRestClient.changePort(80);
        WIDGET = getWidgetName();
        initHttpConnection();
    }

    private int getJSONMessageAction(String s)
    {
        int i;
        int j;
        i = 0;
        j = 0;
        s = new JSONArray(s);
        int k = 0;
_L6:
        int l;
        i = j;
        l = j;
        if (k >= s.length()) goto _L2; else goto _L1
_L1:
        i = j;
        l = j;
        if (s.getJSONObject(k) == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        i = j;
        JSONObject jsonobject = s.getJSONObject(k);
        k;
        JVM INSTR tableswitch 0 0: default 168
    //                   0 80;
           goto _L3 _L4
_L4:
        i = j;
        l = Integer.parseInt(jsonobject.getString("action"));
        i = l;
        try
        {
            Log.d("JSON", (new StringBuilder()).append("ACTION -> \"").append(jsonobject.getString("action")).append("\"\n").toString());
            break MISSING_BLOCK_LABEL_172;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("JSON", (new StringBuilder()).append("Error parsing: \n").append(s.getMessage()).toString());
            l = i;
        }
_L2:
        return l;
_L3:
        l = j;
        k++;
        j = l;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String getWidgetName()
    {
        Object obj;
        try
        {
            obj = new BufferedReader(new FileReader(PATH_WIDGET));
            new String();
            obj = ((BufferedReader) (obj)).readLine();
        }
        catch (Exception exception)
        {
            Log.w("SmartTVConnection", "Crackle");
            return "Crackle";
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (!((String) (obj)).equals(""))
        {
            return ((String) (obj));
        } else
        {
            return "Crackle";
        }
        return "Crackle";
    }

    private void handleConnection(Response response)
    {
        Log.d("SmartTVConnection", (new StringBuilder()).append("callback from connect action. status code = ").append(response.getStatusCode()).toString());
        if (response.getStatusCode() == 200)
        {
            mIsConnected = true;
        }
        if (mListeners != null && mListeners.size() > 0)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((SmartTVListener)iterator.next()).onSmartTVConnect(response.getStatusCode())) { }
        }
    }

    private void handleDisconnection(Response response)
    {
        if (mIsConnected)
        {
            if (response.getStatusCode() == 200)
            {
                mIsConnected = false;
            } else
            {
                Log.w("SmartTVConnection", (new StringBuilder()).append("Disconnection returned status code = ").append(response.getStatusCode()).toString());
            }
        } else
        {
            Log.w("SmartTVConnection", "Connection flag already indicates it is disconnected. Nothing to be done.");
        }
        if (mListeners != null && mListeners.size() > 0)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((SmartTVListener)iterator.next()).onSmartTVDisconnect(response.getStatusCode())) { }
        }
    }

    private void handleLauncher(Response response)
    {
        Log.d("SmartTVConnection", (new StringBuilder()).append("callback from launcher action. status code = ").append(response.getStatusCode()).toString());
        if (mListeners != null && mListeners.size() > 0)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((SmartTVListener)iterator.next()).onSmartTVLauncher(response.getStatusCode())) { }
        }
    }

    private void handleRequestInfo(Response response)
    {
        Log.d("SmartTVConnection", (new StringBuilder()).append("GET info callback. status code = ").append(response.getStatusCode()).toString());
        response.getStatusCode();
        JVM INSTR lookupswitch 2: default 56
    //                   0: 121
    //                   200: 57;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        mIsConnected = true;
        if (mListeners != null && mListeners.size() > 0)
        {
            Iterator iterator = mListeners.iterator();
            while (iterator.hasNext()) 
            {
                ((SmartTVListener)iterator.next()).onSmartTVLauncher(response.getStatusCode());
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mListeners != null && mListeners.size() > 0)
        {
            Iterator iterator1 = mListeners.iterator();
            while (iterator1.hasNext()) 
            {
                ((SmartTVListener)iterator1.next()).onSmartTVRequestInfo(response.getStatusCode());
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static void initHttpConnection()
    {
        org.apache.http.params.HttpParams httpparams = (new DefaultHttpClient()).getParams();
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        connManager = new ThreadSafeClientConnManager(httpparams, schemeregistry);
    }

    public void connect(String s, String s1)
    {
        s = new URL(s);
        mLocation = s;
        if (!SmartTV.isTVEmulator(s1))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        mRestClient.changePort(8008);
_L2:
        mRestClient.requestApplicationStatus(s, WIDGET);
        return;
        mRestClient.changePort(80);
        if (true) goto _L2; else goto _L1
_L1:
        s;
_L4:
        Log.e("SmartTVConnection", "connectToTV: MalformedURLException.");
        s.printStackTrace();
        return;
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void connectToTV(final String locationURL, final String JSONString)
    {
        URL url = new URL(locationURL);
        mLocation = url;
        Log.d("SmartTVConnection", (new StringBuilder()).append("message is = [").append(JSONString).append("] and Host is = ").append(mLocation.getHost()).toString());
        locationURL = new Thread(new Runnable() {

            final SmartTVConnection this$0;
            final String val$JSONString;
            final String val$locationURL;

            public void run()
            {
                Object obj;
                String s;
                Object obj1;
                DefaultHttpClient defaulthttpclient;
                Object obj2;
                defaulthttpclient = new DefaultHttpClient();
                obj2 = new HttpGet(locationURL);
                obj1 = null;
                s = null;
                obj = obj1;
                obj2 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
                obj = obj1;
                ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
                JVM INSTR tableswitch 200 200: default 397
            //                           200 241;
                   goto _L1 _L2
_L1:
                obj = obj1;
                obj1 = (new StringBuilder()).append("http://").append(mLocation.getHost()).append("/ws/app/").toString();
_L4:
                obj = obj1;
                Log.d("SmartTVConnection", (new StringBuilder()).append("CONNECT STATUS: ").append(((HttpResponse) (obj2)).getStatusLine().getStatusCode()).toString());
                obj = obj1;
_L6:
                Exception exception1;
                Header aheader[];
                int i;
                int j;
                try
                {
                    obj = new HttpPost((new StringBuilder()).append(((String) (obj))).append("Crackle").toString());
                    ((HttpPost) (obj)).setHeader("SLDeviceID", "CrackleDevice");
                    ((HttpPost) (obj)).setHeader("User-Agent", "Android-Tablet");
                    ((HttpPost) (obj)).setEntity(new StringEntity(JSONString));
                    i = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj))).getStatusLine().getStatusCode();
                }
                catch (Exception exception)
                {
                    Log.e("SmartTVConnection", (new StringBuilder()).append("Launch Message Error: ").append(exception.getMessage()).toString());
                    return;
                }
                switch (i)
                {
                case 201: 
                default:
                    return;
                }
_L2:
                obj = obj1;
                aheader = ((HttpResponse) (obj2)).getHeaders("Application-URL");
                obj = obj1;
                j = aheader.length;
                i = 0;
_L5:
                obj1 = s;
                if (i >= j) goto _L4; else goto _L3
_L3:
                obj1 = aheader[i];
                obj = s;
                Log.d("SmartTVConnection", (new StringBuilder()).append(((Header) (obj1)).getName()).append(" = ").append(((Header) (obj1)).getValue()).toString());
                obj = s;
                s = ((Header) (obj1)).getValue();
                i++;
                  goto _L5
                exception1;
                Log.e("SmartTVConnection", (new StringBuilder()).append("CONNECT ERROR: ").append(exception1.getMessage()).toString());
                  goto _L6
            }

            
            {
                this$0 = SmartTVConnection.this;
                locationURL = s;
                JSONString = s1;
                super();
            }
        });
        locationURL.setPriority(5);
        locationURL.start();
_L2:
        Log.d("SmartTVConnection", "successfully launched to TV");
        return;
        locationURL;
_L3:
        Log.e("SmartTVConnection", (new StringBuilder()).append("connectToTV: Error: ").append(locationURL.getMessage()).toString());
        locationURL.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        locationURL;
          goto _L3
    }

    public void disconnect()
    {
        mRestClient.disconnect(mLocation, WIDGET);
    }

    public boolean isConnected()
    {
        return mIsConnected;
    }

    public void onRequestCallback(Request request, Response response, int i)
    {
        Log.d("SmartTVConnection", (new StringBuilder()).append("Request callback. Action code = ").append(i).toString());
        i;
        JVM INSTR tableswitch 9001 9006: default 64
    //                   9001 73
    //                   9002 99
    //                   9003 112
    //                   9004 86
    //                   9005 219
    //                   9006 232;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        Log.w("SmartTVConnection", "Unknown action on request callback");
_L9:
        return;
_L2:
        mHandler.obtainMessage(1, response).sendToTarget();
        return;
_L5:
        mHandler.obtainMessage(2, response).sendToTarget();
        return;
_L3:
        mHandler.obtainMessage(4, response).sendToTarget();
        return;
_L4:
        Log.d("SmartTVConnection", (new StringBuilder()).append("GET Status code: ").append(response.getStatusCode()).toString());
        Log.d("SmartTVConnection", (new StringBuilder()).append("GET Response Body: ").append(response.getBody()).toString());
        if (response.getStatusCode() != 200) goto _L9; else goto _L8
_L8:
        switch (getJSONMessageAction(response.getBody()))
        {
        default:
            return;

        case 201: 
            break;

        case 202: 
            Log.d("SmartTVConnection", response.getBody());
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L9; else goto _L10
_L10:
        return;
_L6:
        mHandler.obtainMessage(3, response).sendToTarget();
        return;
_L7:
        mHandler.obtainMessage(5, response).sendToTarget();
        return;
    }

    public void sendData(String s)
    {
        if (mLocation != null)
        {
            Log.d("SmartTVConnection", (new StringBuilder()).append("Posting data to RestClient = ").append(s).toString());
            mRestClient.sendData(mLocation, WIDGET, s);
            return;
        } else
        {
            Log.e("SmartTVConnection", "Trying to send data to the TV, but the base location (URL) is not defined!");
            return;
        }
    }

    public void setListeners(List list)
    {
        mListeners = list;
    }






}
