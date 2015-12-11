// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;

import android.os.Handler;
import android.os.Looper;
import com.google.a.d.e;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.core.pubsub.PubSubMessageReceivedEvent;
import com.rdio.android.core.pubsub.PubSubPublishEvent;
import com.rdio.android.core.pubsub.PubSubStateChangedEvent;
import com.rdio.android.core.pubsub.PubSubTopicSubscriptionEvent;
import com.rdio.android.core.util.Logging;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.remote:
//            RemoteClientCapabilities, RemoteClientPresenceEvent, RemoteClientStatusChangedEvent, RemoteClientTakeMasterEvent

public abstract class RemoteClientManager
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status Elsewhere;
        public static final Status Master;
        public static final Status Unknown;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/rdio/android/core/remote/RemoteClientManager$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            Unknown = new Status("Unknown", 0);
            Elsewhere = new Status("Elsewhere", 1);
            Master = new Status("Master", 2);
            $VALUES = (new Status[] {
                Unknown, Elsewhere, Master
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MASTER_QUERY_TIMEOUT = 3000;
    public static final int PLAY_STATE_IDLE = 0;
    public static final int PLAY_STATE_PLAYING = 1;
    private static final String TAG = "RemoteClientManager";
    private final e eventBus;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isQueryingForMaster;
    private boolean isTakingMaster;
    protected final Logging logging;
    private final Runnable masterQueryCompletion = new Runnable() {

        final RemoteClientManager this$0;

        public void run()
        {
            isQueryingForMaster = false;
            onMasterQueryComplete(getStatus());
        }

            
            {
                this$0 = RemoteClientManager.this;
                super();
            }
    };
    private int playState;
    private final String playerName;
    private String playerTopic;
    private final RdioService_Api rdioService;
    private Map remotePlayerCapsMap;
    private Status status;
    private final Runnable takeMasterCompletion = new Runnable() {

        final RemoteClientManager this$0;

        public void run()
        {
            isTakingMaster = false;
            onTakeMasterComplete();
        }

            
            {
                this$0 = RemoteClientManager.this;
                super();
            }
    };
    private String userTopic;

    public RemoteClientManager(String s, RdioService_Api rdioservice_api, e e1, Logging logging1)
    {
        status = Status.Unknown;
        playState = 0;
        playerName = s;
        logging = logging1;
        eventBus = e1;
        rdioService = rdioservice_api;
    }

    private Map getRemotePlayerCapsMap()
    {
        if (remotePlayerCapsMap == null)
        {
            remotePlayerCapsMap = new HashMap(1);
        }
        return remotePlayerCapsMap;
    }

    private void handleConnectionJoin(JSONObject jsonobject)
    {
        String s = jsonobject.optString("id");
        if (s == null)
        {
            logging.log(6, "RemoteClientManager", "connectionJoin with null id");
            return;
        }
        jsonobject = jsonobject.optJSONObject("caps");
        if (jsonobject == null)
        {
            logging.log(6, "RemoteClientManager", (new StringBuilder("Client: ")).append(s).append(" has no caps").toString());
            return;
        }
        jsonobject = jsonobject.optJSONObject("player");
        if (jsonobject == null)
        {
            logging.log(6, "RemoteClientManager", (new StringBuilder("Client: ")).append(s).append(" has no player").toString());
            return;
        }
        String s1 = jsonobject.optString("name");
        if (s1 == null)
        {
            logging.log(6, "RemoteClientManager", (new StringBuilder("Client: ")).append(s).append(" has no player name").toString());
            return;
        } else
        {
            boolean flag = jsonobject.optBoolean("canRemote");
            logging.log(3, "RemoteClientManager", (new StringBuilder("Adding ")).append(s).append(" name:").append(s1).append(":canRemote=").append(flag).toString());
            getRemotePlayerCapsMap().put(s, new RemoteClientCapabilities(s1, flag));
            eventBus.post(new RemoteClientPresenceEvent(s, RemoteClientPresenceEvent.Action.Join, getRemotePlayerCapsMap()));
            return;
        }
    }

    private void handleConnectionPart(JSONObject jsonobject)
    {
        jsonobject = jsonobject.optString("id");
        if (jsonobject == null)
        {
            logging.log(6, "RemoteClientManager", "connectionPart with null id");
            return;
        } else
        {
            logging.log(3, "RemoteClientManager", (new StringBuilder("Removing ")).append(jsonobject).toString());
            getRemotePlayerCapsMap().remove(jsonobject);
            eventBus.post(new RemoteClientPresenceEvent(jsonobject, RemoteClientPresenceEvent.Action.Part, getRemotePlayerCapsMap()));
            return;
        }
    }

    private boolean isPlayerRemoteControllable(String s)
    {
        for (Iterator iterator = getRemotePlayerCapsMap().keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (RemoteClientCapabilities)getRemotePlayerCapsMap().get(obj);
            if (((RemoteClientCapabilities) (obj)).getName().equals(s))
            {
                return ((RemoteClientCapabilities) (obj)).canRemote();
            }
        }

        logging.log(6, "RemoteClientManager", (new StringBuilder("No caps found for player name: ")).append(s).toString());
        return false;
    }

    private void setStatus(Status status1, String s, int i, boolean flag)
    {
        if (status != status1 || playState != i)
        {
            status = status1;
            playState = i;
            eventBus.post(new RemoteClientStatusChangedEvent(status1, s, i, flag));
        }
    }

    private void updateActivePlayerToWebService()
    {
        RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("method", "updateActivePlayer");
        RdioApiRequestArg rdioapirequestarg1 = new RdioApiRequestArg("deviceid", playerName);
        RdioApiRequestArg rdioapirequestarg2 = new RdioApiRequestArg("manual", Boolean.valueOf(true));
        RdioService_Api rdioservice_api = rdioService;
        com.rdio.android.core.RdioService_Api.ResponseListener responselistener = new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final RemoteClientManager this$0;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (rdioapiresponse.isSuccess())
                {
                    logging.log(3, "RemoteClientManager", "Successfully updated active player with web service");
                } else
                {
                    logging.log(3, "RemoteClientManager", "Failed to update active player with web service");
                }
                takeMasterCompletion.run();
            }

            
            {
                this$0 = RemoteClientManager.this;
                super();
            }
        };
        rdioservice_api.postRequest(new RdioApiRequestArg[] {
            rdioapirequestarg, rdioapirequestarg1, rdioapirequestarg2
        }, responselistener);
    }

    protected void becomeUnknown()
    {
        setStatus(Status.Unknown, playerName, playState, true);
        publishMasterQuery();
    }

    public abstract int getPlayState();

    public Status getStatus()
    {
        return status;
    }

    public abstract boolean isRemoteControllable();

    protected void onMasterQueryComplete(Status status1)
    {
    }

    public final void onPubSubMessage(PubSubMessageReceivedEvent pubsubmessagereceivedevent)
    {
        String s;
        byte byte0;
        logging.log(3, "RemoteClientManager", (new StringBuilder("Received message: ")).append(pubsubmessagereceivedevent.getData()).toString());
        try
        {
            s = pubsubmessagereceivedevent.getData().getString("event");
        }
        // Misplaced declaration of an exception variable
        catch (PubSubMessageReceivedEvent pubsubmessagereceivedevent)
        {
            logging.log(6, "RemoteClientManager", "Exception when handling pubsub message");
            logging.logException(pubsubmessagereceivedevent, true);
            return;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 100
    //                   -1236541469: 189
    //                   1208232838: 204
    //                   1269903656: 219
    //                   1270069233: 234
    //                   1331505543: 174;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        byte0;
        JVM INSTR tableswitch 0 4: default 136
    //                   0 249
    //                   1 380
    //                   2 529
    //                   3 544
    //                   4 553;
           goto _L7 _L8 _L9 _L10 _L11 _L12
_L7:
        onUnhandledPubSubMessage(pubsubmessagereceivedevent.getData());
_L14:
        return;
_L6:
        if (s.equals("activePlayer"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("masterPlayer"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("masterQuery"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s.equals("connectionJoin"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("connectionPart"))
        {
            byte0 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        pubsubmessagereceivedevent = pubsubmessagereceivedevent.getData().optString("name");
        if (pubsubmessagereceivedevent == null)
        {
            logging.log(6, "RemoteClientManager", "activePlayer had null name field");
            return;
        }
        if (pubsubmessagereceivedevent.equals(playerName) || isPlayerRemoteControllable(pubsubmessagereceivedevent)) goto _L14; else goto _L13
_L13:
        logging.log(3, "RemoteClientManager", (new StringBuilder("Handling activePlayer for ")).append(pubsubmessagereceivedevent).toString());
        if (isTakingMaster)
        {
            isTakingMaster = false;
            logging.log(3, "RemoteClientManager", (new StringBuilder("Master takeover interrupted by client: ")).append(pubsubmessagereceivedevent).toString());
        }
        setStatus(Status.Elsewhere, pubsubmessagereceivedevent, 0, true);
        return;
_L9:
        handler.removeCallbacks(masterQueryCompletion);
        String s1;
        try
        {
            s1 = pubsubmessagereceivedevent.getData().getString("name");
        }
        // Misplaced declaration of an exception variable
        catch (PubSubMessageReceivedEvent pubsubmessagereceivedevent)
        {
            logging.log(6, "RemoteClientManager", "Exception when handling pubsub message");
            logging.logException(pubsubmessagereceivedevent, true);
            return;
        }
        if (!playerName.equals(s1))
        {
            if (isTakingMaster)
            {
                isTakingMaster = false;
                logging.log(3, "RemoteClientManager", (new StringBuilder("Master takeover interrupted by client: ")).append(s1).toString());
            }
            int i = pubsubmessagereceivedevent.getData().optInt("playState");
            setStatus(Status.Elsewhere, s1, i, true);
        } else
        {
            setStatus(Status.Master, s1, getPlayState(), true);
        }
        masterQueryCompletion.run();
        return;
_L10:
        if (status != Status.Master) goto _L14; else goto _L15
_L15:
        publishMasterPlayer();
        return;
_L11:
        handleConnectionJoin(pubsubmessagereceivedevent.getData());
        return;
_L12:
        handleConnectionPart(pubsubmessagereceivedevent.getData());
        return;
        if (true) goto _L1; else goto _L16
_L16:
    }

    public void onPubSubStateChanged(PubSubStateChangedEvent pubsubstatechangedevent)
    {
        if (pubsubstatechangedevent.getState() == com.rdio.android.core.pubsub.PubSubConnection.State.Connected)
        {
            userTopic = pubsubstatechangedevent.getUserTopic();
            playerTopic = pubsubstatechangedevent.getUserTopic().replace("private", "player");
            eventBus.post(new PubSubTopicSubscriptionEvent(userTopic, true));
            eventBus.post(new PubSubTopicSubscriptionEvent(playerTopic, true));
            pubsubstatechangedevent = pubsubstatechangedevent.getUserTopic().replace("private", "presence");
            eventBus.post(new PubSubTopicSubscriptionEvent(pubsubstatechangedevent, true));
            publishMasterQuery();
        }
    }

    public void onTakeMaster(RemoteClientTakeMasterEvent remoteclienttakemasterevent)
    {
        if (status == Status.Master)
        {
            logging.log(4, "RemoteClientManager", "Already the master player, takeover ignored.");
            return;
        }
        if (isTakingMaster)
        {
            logging.log(4, "RemoteClientManager", "Master takeover in progress, request ignored.");
            return;
        } else
        {
            handler.removeCallbacks(masterQueryCompletion);
            isTakingMaster = true;
            publishMasterPlayer();
            return;
        }
    }

    protected void onTakeMasterComplete()
    {
    }

    protected void onUnhandledPubSubMessage(JSONObject jsonobject)
    {
    }

    public void publishMasterPlayer()
    {
        if (isRemoteControllable())
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("event", "masterPlayer");
                jsonobject.put("name", playerName);
                jsonobject.put("playState", getPlayState());
            }
            catch (JSONException jsonexception)
            {
                logging.log(6, "RemoteClientManager", "Exception when publishing active player");
                logging.logException(jsonexception, true);
                return;
            }
            eventBus.post(new PubSubPublishEvent(playerTopic, jsonobject));
        }
        updateActivePlayerToWebService();
        setStatus(Status.Master, playerName, getPlayState(), isRemoteControllable());
    }

    public void publishMasterQuery()
    {
        if (isQueryingForMaster)
        {
            return;
        } else
        {
            isQueryingForMaster = true;
            HashMap hashmap = new HashMap();
            hashmap.put("event", "masterQuery");
            eventBus.post(new PubSubPublishEvent(userTopic, new JSONObject(hashmap)));
            handler.postDelayed(masterQueryCompletion, 3000L);
            return;
        }
    }


/*
    static boolean access$002(RemoteClientManager remoteclientmanager, boolean flag)
    {
        remoteclientmanager.isTakingMaster = flag;
        return flag;
    }

*/


/*
    static boolean access$102(RemoteClientManager remoteclientmanager, boolean flag)
    {
        remoteclientmanager.isQueryingForMaster = flag;
        return flag;
    }

*/

}
