// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.UAStringUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.actions:
//            ActionRunRequestFactory, ActionValue, Situation, ActionRunRequest

public class ActionService extends Service
{

    public static final String ACTION_RUN_ACTIONS = "com.urbanairship.actionservice.ACTION_RUN_ACTIONS";
    public static final String EXTRA_ACTIONS_BUNDLE = "com.urbanairship.actionservice.EXTRA_ACTIONS";
    public static final String EXTRA_ACTIONS_PAYLOAD = "com.urbanairship.actionservice.EXTRA_ACTIONS_PAYLOAD";
    public static final String EXTRA_METADATA = "com.urbanairship.actionservice.EXTRA_METADATA";
    public static final String EXTRA_PUSH_BUNDLE = "com.urbanairship.actionservice.EXTRA_PUSH_BUNDLE";
    public static final String EXTRA_SITUATION = "com.urbanairship.actionservice.EXTRA_SITUATION";
    private final ActionRunRequestFactory actionRunRequestFactory;
    private int lastStartId;
    private int runningActions;

    public ActionService()
    {
        this(new ActionRunRequestFactory());
    }

    ActionService(ActionRunRequestFactory actionrunrequestfactory)
    {
        lastStartId = 0;
        runningActions = 0;
        actionRunRequestFactory = actionrunrequestfactory;
    }

    private static Bundle createActionsBundle(String s)
    {
        Bundle bundle;
        bundle = new Bundle();
        if (UAStringUtil.isEmpty(s))
        {
            return bundle;
        }
        Object obj = JsonValue.parseString(s).getMap();
        if (obj != null)
        {
            try
            {
                java.util.Map.Entry entry;
                for (obj = ((JsonMap) (obj)).iterator(); ((Iterator) (obj)).hasNext(); bundle.putParcelable((String)entry.getKey(), new ActionValue((JsonValue)entry.getValue())))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

            }
            catch (JsonException jsonexception)
            {
                Logger.error((new StringBuilder("Unable to parse action payload: ")).append(s).toString());
            }
        }
        return bundle;
    }

    private void onRunActions(Intent intent)
    {
        Bundle bundle = intent.getBundleExtra("com.urbanairship.actionservice.EXTRA_ACTIONS");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        Situation situation = (Situation)intent.getSerializableExtra("com.urbanairship.actionservice.EXTRA_SITUATION");
        Bundle bundle1 = intent.getBundleExtra("com.urbanairship.actionservice.EXTRA_METADATA");
        if (bundle1 == null)
        {
            bundle1 = new Bundle();
        }
        bundle.putAll(createActionsBundle(intent.getStringExtra("com.urbanairship.actionservice.EXTRA_ACTIONS_PAYLOAD")));
        intent = (Bundle)intent.getParcelableExtra("com.urbanairship.actionservice.EXTRA_PUSH_BUNDLE");
        if (intent != null)
        {
            bundle1.putParcelable("com.urbanairship.PUSH_MESSAGE", new PushMessage(intent));
        }
        if (bundle.isEmpty())
        {
            Logger.debug("ActionService - No actions to run.");
        } else
        {
            intent = bundle.keySet().iterator();
            while (intent.hasNext()) 
            {
                String s = (String)intent.next();
                runningActions = runningActions + 1;
                actionRunRequestFactory.createActionRequest(s).setMetadata(bundle1).setValue((ActionValue)bundle.getParcelable(s)).setSituation(situation).run(new _cls1());
            }
        }
    }

    public static void runActions(Context context, String s, Situation situation, Bundle bundle)
    {
        s = createActionsBundle(s);
        if (s.isEmpty())
        {
            return;
        }
        Intent intent = (new Intent("com.urbanairship.actionservice.ACTION_RUN_ACTIONS")).setClass(context, com/urbanairship/actions/ActionService).putExtra("com.urbanairship.actionservice.EXTRA_ACTIONS", s);
        s = situation;
        if (situation == null)
        {
            s = Situation.MANUAL_INVOCATION;
        }
        s = intent.putExtra("com.urbanairship.actionservice.EXTRA_SITUATION", s);
        if (bundle != null)
        {
            s.putExtra("com.urbanairship.actionservice.EXTRA_METADATA", bundle);
        }
        context.startService(s);
    }

    public static void runActions(Context context, Map map, Situation situation, Bundle bundle)
    {
        if (map.isEmpty())
        {
            return;
        }
        Object obj = new Bundle();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); ((Bundle) (obj)).putParcelable((String)entry.getKey(), (Parcelable)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        obj = (new Intent("com.urbanairship.actionservice.ACTION_RUN_ACTIONS")).setClass(context, com/urbanairship/actions/ActionService).putExtra("com.urbanairship.actionservice.EXTRA_ACTIONS", ((Bundle) (obj)));
        map = situation;
        if (situation == null)
        {
            map = Situation.MANUAL_INVOCATION;
        }
        map = ((Intent) (obj)).putExtra("com.urbanairship.actionservice.EXTRA_SITUATION", map);
        if (bundle != null)
        {
            map.putExtra("com.urbanairship.actionservice.EXTRA_METADATA", bundle);
        }
        context.startService(map);
    }

    public static void runActionsPayload(Context context, String s, Situation situation)
    {
        runActions(context, s, situation, null);
    }

    public static void runActionsPayload(Context context, String s, Situation situation, PushMessage pushmessage)
    {
        Bundle bundle = new Bundle();
        if (pushmessage != null)
        {
            bundle.putParcelable("com.urbanairship.PUSH_MESSAGE", pushmessage);
        }
        runActions(context, s, situation, bundle);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        Autopilot.automaticTakeOff(getApplicationContext());
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Autopilot.automaticTakeOff((Application)getApplicationContext());
        lastStartId = j;
        if (intent != null && "com.urbanairship.actionservice.ACTION_RUN_ACTIONS".equals(intent.getAction()))
        {
            Logger.verbose((new StringBuilder("ActionService - Received intent: ")).append(intent.getAction()).append(" startId: ").append(j).toString());
            onRunActions(intent);
        }
        if (runningActions == 0)
        {
            stopSelf(j);
        }
        return 2;
    }



/*
    static int access$010(ActionService actionservice)
    {
        int i = actionservice.runningActions;
        actionservice.runningActions = i - 1;
        return i;
    }

*/


}
