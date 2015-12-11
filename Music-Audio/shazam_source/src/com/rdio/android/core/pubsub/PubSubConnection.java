// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.d;
import com.google.a.d.e;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.core.util.Logging;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubMessageReceivedEvent, PubSubStateChangedEvent, PubSubPublishEvent, PubSubTopicSubscriptionEvent

public class PubSubConnection
{
    private final class PubSubSocket
        implements Runnable
    {

        private volatile boolean keepRunning;
        private OutputStream outgoing;
        private int port;
        private Socket socket;
        private Thread socketThread;
        final PubSubConnection this$0;
        private String url;

        public final void close()
        {
            logging.log(3, "PubSubConnection", "Asking socket to close");
            try
            {
                keepRunning = false;
                if (socketThread != null && socketThread.isAlive())
                {
                    StreamHelper.closeSocket(socket, logging);
                    StreamHelper.closeStream(outgoing, logging);
                    outgoing = null;
                    socket = null;
                    socketThread.interrupt();
                    logging.log(3, "PubSubConnection", "Stopping socket thread");
                }
                return;
            }
            catch (Throwable throwable)
            {
                logging.log(6, "PubSubConnection", "Error disconnecting socket");
                logging.logException(throwable, false);
                return;
            }
        }

        public final boolean isConnected()
        {
            return keepRunning && outgoing != null;
        }

        public final void run()
        {
            logging.log(3, "PubSubConnection", "Socket thread started");
            InputStream inputstream1;
            socket = new Socket(url, port);
            inputstream1 = socket.getInputStream();
            InputStream inputstream = inputstream1;
            outgoing = socket.getOutputStream();
            inputstream = inputstream1;
            onConnected();
            inputstream = inputstream1;
            Object obj1 = new ByteArrayOutputStream(8096);
            inputstream = inputstream1;
            byte abyte0[] = new byte[8096];
_L16:
            inputstream = inputstream1;
            if (!keepRunning) goto _L2; else goto _L1
_L1:
            inputstream = inputstream1;
            int l = inputstream1.read(abyte0, 0, 8096);
            if (l != -1) goto _L4; else goto _L3
_L3:
            inputstream = inputstream1;
            logging.log(3, "PubSubConnection", "Socket end of stream");
_L2:
            keepRunning = false;
            onDisconnected();
            StreamHelper.closeStream(inputstream1, logging);
            StreamHelper.closeStream(outgoing, logging);
            outgoing = null;
            StreamHelper.closeSocket(socket, logging);
_L14:
            logging.log(3, "PubSubConnection", "Socket thread ended");
            return;
_L4:
            int j;
            int k;
            j = 0;
            k = 0;
_L20:
            if (j >= l) goto _L6; else goto _L5
_L5:
            if (abyte0[j] != 0) goto _L8; else goto _L7
_L7:
            inputstream = inputstream1;
            ((ByteArrayOutputStream) (obj1)).reset();
            int i = j + 1;
              goto _L9
_L8:
            i = k;
            if (abyte0[j] != -1) goto _L9; else goto _L10
_L10:
            if (j - k <= 0)
            {
                break MISSING_BLOCK_LABEL_282;
            }
            inputstream = inputstream1;
            ((ByteArrayOutputStream) (obj1)).write(abyte0, k, j - k);
            inputstream = inputstream1;
            byte abyte1[] = ((ByteArrayOutputStream) (obj1)).toByteArray();
            inputstream = inputstream1;
            if (abyte1.length != 0) goto _L12; else goto _L11
_L11:
            inputstream = inputstream1;
            logging.log(6, "PubSubConnection", "Badly framed message. No starting 0x00.");
_L13:
            inputstream = inputstream1;
            ((ByteArrayOutputStream) (obj1)).reset();
            i = j + 2;
            break; /* Loop/switch isn't completed */
_L12:
            inputstream = inputstream1;
            onMessage(new String(abyte1));
            if (true) goto _L13; else goto _L9
            obj1;
_L19:
            inputstream = inputstream1;
            logging.log(5, "PubSubConnection", (new StringBuilder("Socket failed.")).append(obj1).toString());
            keepRunning = false;
            onDisconnected();
            StreamHelper.closeStream(inputstream1, logging);
            StreamHelper.closeStream(outgoing, logging);
            outgoing = null;
            StreamHelper.closeSocket(socket, logging);
              goto _L14
_L6:
            if (k >= l) goto _L16; else goto _L15
_L15:
            inputstream = inputstream1;
            ((ByteArrayOutputStream) (obj1)).write(abyte0, k, l - k);
              goto _L16
            obj1;
            Object obj;
            inputstream1 = inputstream;
            obj = obj1;
_L18:
            keepRunning = false;
            onDisconnected();
            StreamHelper.closeStream(inputstream1, logging);
            StreamHelper.closeStream(outgoing, logging);
            outgoing = null;
            StreamHelper.closeSocket(socket, logging);
            throw obj;
            obj;
            inputstream1 = null;
            if (true) goto _L18; else goto _L17
_L17:
            obj1;
            inputstream1 = null;
              goto _L19
_L9:
            j++;
            k = i;
              goto _L20
        }

        public final void send(String s)
        {
            try
            {
                if (outgoing != null)
                {
                    logging.log(3, "PubSubConnection", (new StringBuilder("Sending '")).append(s).append("'").toString());
                    outgoing.write(0);
                    outgoing.write(s.getBytes("utf8"));
                    outgoing.write(255);
                    outgoing.flush();
                }
                return;
            }
            catch (Exception exception)
            {
                logging.log(5, "PubSubConnection", (new StringBuilder("Error sending '")).append(s).append("'").toString());
            }
            onDisconnected();
        }

        protected PubSubSocket(String s, int i)
        {
            this$0 = PubSubConnection.this;
            super();
            logging.log(3, "PubSubConnection", (new StringBuilder("Creating socket for ")).append(s).append(":").append(i).toString());
            url = s;
            port = i;
            keepRunning = true;
            socketThread = new Thread(this, "PubSub");
            socketThread.start();
        }
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Connected;
        public static final State Connecting;
        public static final State Disconnected;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/rdio/android/core/pubsub/PubSubConnection$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Disconnected = new State("Disconnected", 0);
            Connecting = new State("Connecting", 1);
            Connected = new State("Connected", 2);
            $VALUES = (new State[] {
                Disconnected, Connecting, Connected
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

    private static class StreamHelper
    {

        public static void closeSocket(Socket socket1, Logging logging1)
        {
            if (socket1 == null)
            {
                break MISSING_BLOCK_LABEL_8;
            }
            socket1.close();
            return;
            socket1;
            logging1.log(6, "PubSubConnection", (new StringBuilder("Failed to close connection.")).append(socket1.toString()).toString());
            logging1.logException(socket1, false);
            return;
        }

        public static void closeStream(InputStream inputstream, Logging logging1)
        {
            if (inputstream == null)
            {
                break MISSING_BLOCK_LABEL_8;
            }
            inputstream.close();
            return;
            inputstream;
            logging1.log(6, "PubSubConnection", (new StringBuilder("Error closing input stream ")).append(inputstream.toString()).toString());
            logging1.logException(inputstream, false);
            return;
        }

        public static void closeStream(OutputStream outputstream, Logging logging1)
        {
            if (outputstream == null)
            {
                break MISSING_BLOCK_LABEL_8;
            }
            outputstream.close();
            return;
            outputstream;
            logging1.log(6, "PubSubConnection", (new StringBuilder("Error closing output stream ")).append(outputstream.toString()).toString());
            logging1.logException(outputstream, false);
            return;
        }

        private StreamHelper()
        {
        }
    }


    private static final int DEFAULT_PORT = 8080;
    private static final int RECONNECT_INTERVALS[] = {
        100, 500, 3000, 3000, 3000, 5000, 10000, 30000, 60000, 0x75300, 
        0xea600, 0xea600, 0x1d4c00
    };
    private static final String TAG = "PubSubConnection";
    private final e eventBus;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final boolean isRemoteControllable;
    private final Logging logging;
    private final String playerName;
    private final RdioService_Api rdioService;
    private int reconnectIndex;
    private boolean reconnecting;
    private int serverIndex;
    private JSONArray serverList;
    private boolean shouldReconnect;
    private PubSubSocket socket;
    private State state;
    private List subscriptions;
    private String token;
    private String userTopic;

    public PubSubConnection(String s, boolean flag, RdioService_Api rdioservice_api, e e1, Logging logging1)
    {
        state = State.Disconnected;
        serverIndex = -1;
        reconnectIndex = 0;
        reconnecting = false;
        shouldReconnect = false;
        logging = logging1;
        eventBus = e1;
        rdioService = rdioservice_api;
        isRemoteControllable = flag;
        playerName = s;
        subscriptions = new ArrayList(5);
        serverList = new JSONArray();
        e1.register(this);
    }

    private void authorize()
    {
        if (socket != null && socket.isConnected())
        {
            JSONObject jsonobject = new JSONObject();
            JSONObject jsonobject1 = new JSONObject();
            JSONObject jsonobject2 = new JSONObject();
            try
            {
                jsonobject1.put("name", playerName);
                jsonobject1.put("canRemote", isRemoteControllable);
                jsonobject2.put("noVolume", true);
                jsonobject1.put("remote", jsonobject2);
                jsonobject.put("player", jsonobject1);
            }
            catch (JSONException jsonexception)
            {
                logging.log(6, "PubSubConnection", "Exception while authorizing");
                logging.logException(jsonexception, true);
                return;
            }
            socket.send((new StringBuilder("CONNECT ")).append(token).append("|").append(jsonobject.toString()).toString());
        }
    }

    private void connectToServer()
    {
        int i;
        if (socket != null)
        {
            logging.log(5, "PubSubConnection", "Socket already in place! Unexpected");
            return;
        }
        String as[];
        String s;
        try
        {
            logging.log(3, "PubSubConnection", (new StringBuilder("Connecting to server ")).append(serverList.getString(serverIndex)).toString());
            as = serverList.getString(serverIndex).split(":");
        }
        catch (Exception exception)
        {
            logging.log(6, "PubSubConnection", (new StringBuilder("connectToServer failed. ")).append(exception).toString());
            reconnect();
            return;
        }
        s = as[0];
        if (as.length <= 1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        i = Integer.parseInt(as[1]);
_L1:
        socket = new PubSubSocket(s, i);
        return;
        i = 8080;
          goto _L1
    }

    private void getServerList()
    {
        RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("method", "pubsubInfo");
        RdioService_Api rdioservice_api = rdioService;
        com.rdio.android.core.RdioService_Api.ResponseListener responselistener = new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final PubSubConnection this$0;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (!rdioapiresponse.isSuccess())
                {
                    logging.log(6, "PubSubConnection", (new StringBuilder("pubsubInfo server response was not successful: ")).append(rdioapiresponse.getErrorMessage()).toString());
                    return;
                }
                rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
                try
                {
                    token = rdioapiresponse.getString("token");
                    userTopic = rdioapiresponse.getString("topic");
                    serverList = rdioapiresponse.getJSONArray("servers");
                    serverIndex = 0;
                    connectToServer();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (RdioApiResponse rdioapiresponse)
                {
                    logging.log(6, "PubSubConnection", "Failed to get pub sub info");
                }
                logging.logException(rdioapiresponse, true);
                serverList = new JSONArray();
                reconnect();
            }

            
            {
                this$0 = PubSubConnection.this;
                super();
            }
        };
        rdioservice_api.postRequest(new RdioApiRequestArg[] {
            rdioapirequestarg
        }, responselistener);
    }

    private void onConnected()
    {
        if (socket != null && socket.isConnected())
        {
            logging.log(3, "PubSubConnection", "Socket connected");
            reconnectIndex = 0;
            authorize();
            sendSubscriptions();
            setState(State.Connected);
            return;
        } else
        {
            logging.log(3, "PubSubConnection", "onConnect called, but not ready");
            reconnect();
            return;
        }
    }

    private void onDisconnected()
    {
        logging.log(3, "PubSubConnection", "Socket disconnected");
        if (state != State.Disconnected)
        {
            reconnect();
        }
    }

    private void onMessage(String s)
    {
        logging.log(3, "PubSubConnection", (new StringBuilder("Received: ")).append(s).toString());
        if (!s.startsWith("PUB"))
        {
            return;
        }
        try
        {
            int i = s.indexOf("|");
            JSONObject jsonobject = new JSONObject(s.substring(i + 1));
            String s1 = s.substring(4, i);
            logging.log(3, "PubSubConnection", (new StringBuilder("Parsed PUB for topic ")).append(s1).toString());
            onPostMessageReceived(s1, jsonobject);
            return;
        }
        catch (Exception exception)
        {
            logging.log(5, "PubSubConnection", (new StringBuilder("Unable to parse incoming message: ")).append(s).toString());
        }
        return;
    }

    private void onPostMessageReceived(String s, JSONObject jsonobject)
    {
        eventBus.post(new PubSubMessageReceivedEvent(s, jsonobject));
    }

    private void publish(String s, JSONObject jsonobject)
    {
        if (socket != null && socket.isConnected())
        {
            jsonobject = jsonobject.toString();
            socket.send((new StringBuilder("PUB ")).append(s).append("|").append(jsonobject).toString());
        }
    }

    private void reconnect()
    {
        if (reconnecting)
        {
            logging.log(3, "PubSubConnection", "Reconnect already in progress");
            return;
        }
        reconnecting = true;
        if (socket != null)
        {
            if (socket.isConnected())
            {
                socket.close();
            }
            socket = null;
        }
        setState(State.Disconnected);
        int i = RECONNECT_INTERVALS[reconnectIndex];
        Random random = new Random();
        double d1 = i;
        float f = random.nextFloat();
        i = (int)(Math.floor((float)i * f) + d1);
        if (reconnectIndex < RECONNECT_INTERVALS.length - 1)
        {
            reconnectIndex = reconnectIndex + 1;
        }
        serverIndex = serverIndex + 1;
        logging.log(3, "PubSubConnection", (new StringBuilder("Reconnecting in ")).append(i).toString());
        handler.postDelayed(new Runnable() {

            final PubSubConnection this$0;

            public void run()
            {
                reconnecting = false;
                if (shouldReconnect)
                {
                    connect();
                }
            }

            
            {
                this$0 = PubSubConnection.this;
                super();
            }
        }, i);
    }

    private void sendSubscriptions()
    {
        if (socket != null && socket.isConnected() && subscriptions.size() > 0)
        {
            String s = d.a(" ").a(subscriptions);
            socket.send((new StringBuilder("SUB ")).append(s).toString());
        }
    }

    private void setState(State state1)
    {
        if (state == state1)
        {
            return;
        } else
        {
            logging.log(3, "PubSubConnection", (new StringBuilder("State change: ")).append(state).append(" -> ").append(state1).toString());
            state = state1;
            eventBus.post(new PubSubStateChangedEvent(state, userTopic, playerName));
            return;
        }
    }

    private void subscribe(String s)
    {
        if (!subscriptions.contains(s))
        {
            subscriptions.add(s);
            if (socket != null && socket.isConnected())
            {
                socket.send((new StringBuilder("SUB ")).append(s).toString());
            }
        }
    }

    private void unsubscribe(String s)
    {
        subscriptions.remove(s);
        if (socket != null && socket.isConnected())
        {
            socket.send((new StringBuilder("UNSUB ")).append(s).toString());
        }
    }

    public void connect()
    {
        if (state != State.Disconnected)
        {
            logging.log(5, "PubSubConnection", (new StringBuilder("Connect called in invalid state ")).append(state).toString());
            return;
        }
        setState(State.Connecting);
        shouldReconnect = true;
        if (serverIndex < 0 || serverIndex >= serverList.length())
        {
            getServerList();
            return;
        } else
        {
            connectToServer();
            return;
        }
    }

    public void disconnect()
    {
        logging.log(3, "PubSubConnection", "Disconnecting");
        shouldReconnect = false;
        try
        {
            if (socket != null)
            {
                socket.close();
                socket = null;
            }
        }
        catch (Exception exception)
        {
            logging.log(6, "PubSubConnection", "Exception closing socket");
            logging.logException(exception, false);
        }
        serverList = new JSONArray();
        userTopic = null;
        token = null;
        subscriptions = new ArrayList(5);
        setState(State.Disconnected);
    }

    public State getState()
    {
        return state;
    }

    public void onPubSubPublish(PubSubPublishEvent pubsubpublishevent)
    {
        publish(pubsubpublishevent.getTopic(), pubsubpublishevent.getData());
    }

    public void onTopicSubscription(PubSubTopicSubscriptionEvent pubsubtopicsubscriptionevent)
    {
        if (pubsubtopicsubscriptionevent.isSubscribe())
        {
            subscribe(pubsubtopicsubscriptionevent.getTopic());
            return;
        } else
        {
            unsubscribe(pubsubtopicsubscriptionevent.getTopic());
            return;
        }
    }





/*
    static String access$102(PubSubConnection pubsubconnection, String s)
    {
        pubsubconnection.token = s;
        return s;
    }

*/



/*
    static String access$202(PubSubConnection pubsubconnection, String s)
    {
        pubsubconnection.userTopic = s;
        return s;
    }

*/


/*
    static JSONArray access$302(PubSubConnection pubsubconnection, JSONArray jsonarray)
    {
        pubsubconnection.serverList = jsonarray;
        return jsonarray;
    }

*/


/*
    static int access$402(PubSubConnection pubsubconnection, int i)
    {
        pubsubconnection.serverIndex = i;
        return i;
    }

*/




/*
    static boolean access$702(PubSubConnection pubsubconnection, boolean flag)
    {
        pubsubconnection.reconnecting = flag;
        return flag;
    }

*/


}
