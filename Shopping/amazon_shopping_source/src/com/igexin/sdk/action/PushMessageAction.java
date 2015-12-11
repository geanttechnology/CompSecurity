// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.content.Intent;
import android.util.Base64;
import com.igexin.sdk.ActionManager;
import com.igexin.sdk.Consts;
import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.encrypt.RC4Carder;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            EndAction, GotoAction, NotificationAction, PopupAction, 
//            StartAppAction, StartWebAction, AbstractPushMessageAction

public class PushMessageAction
{

    private static PushMessageAction instance;
    private static Map prepareWaitCountMap;
    private Map pushMessageActionMap;

    public PushMessageAction()
    {
        prepareWaitCountMap = new HashMap();
        pushMessageActionMap = new HashMap();
        pushMessageActionMap.put("null", new EndAction());
        pushMessageActionMap.put("goto", new GotoAction());
        pushMessageActionMap.put("notification", new NotificationAction());
        pushMessageActionMap.put("popup", new PopupAction());
        pushMessageActionMap.put("startapp", new StartAppAction());
        pushMessageActionMap.put("startweb", new StartWebAction());
    }

    public static PushMessageAction getInstance()
    {
        if (instance == null)
        {
            instance = new PushMessageAction();
        }
        return instance;
    }

    public void doPushMessageAction(Intent intent)
    {
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        String as[];
        PushMessageBean pushmessagebean;
        String s2;
        byte abyte0[];
        String s3;
        String s4;
        String s5;
        try
        {
            String s = intent.getStringExtra("vPayloadid");
            intent = new JSONObject(intent.getStringExtra("vPayload"));
            String s1 = intent.getString("vcid");
            System.out.println((new StringBuilder()).append("Payload vcid = ").append(s1).append(" == vcid = ").append(BasicDataManager.vcid).toString());
            if (!s1.equals(BasicDataManager.vcid))
            {
                break MISSING_BLOCK_LABEL_376;
            }
            as = s.split(":");
            if (as.length != 2)
            {
                break MISSING_BLOCK_LABEL_376;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
            return;
        }
        s2 = as[0];
        s3 = as[1];
        s4 = intent.getString("taskid");
        s5 = intent.getString("messageid");
        abyte0 = Base64.decode(intent.getString("action_chains"), 0);
        pushmessagebean = new PushMessageBean();
        pushmessagebean.setMasterMessageId(s2);
        pushmessagebean.setMasterTaskId(s3);
        pushmessagebean.setTaskId(s4);
        pushmessagebean.setMessageId(s5);
        ActionManager.getInstance().feedback(pushmessagebean, "0", null);
        s2 = getInstance().getPushMessageCacheId(s4, s5);
        if (BasicDataManager.pushMessageMap.get(s2) != null || abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        s2 = new String(RC4Carder.Dencrypt(abyte0, Consts.VPUSH_APPSECRET), "UTF-8");
        System.out.println((new StringBuilder()).append("actionChainsStr = ").append(s2).toString());
        if (intent.has("payload"))
        {
            intent = intent.getString("payload");
            if (!intent.equals(""))
            {
                intent = RC4Carder.Dencrypt(Base64.decode(intent, 0), Consts.VPUSH_APPSECRET);
                pushmessagebean.setPayload(intent);
                System.out.println((new StringBuilder()).append("payloadBytes = ").append(new String(intent)).toString());
            }
        }
        if (parsePushMessageAction(new JSONArray(s2), pushmessagebean))
        {
            intent = prepareExecutePushMessageAction(pushmessagebean);
            System.out.println((new StringBuilder()).append("prepareState = ").append(intent).toString());
            if (intent == com.igexin.sdk.Consts.ActionPrepareState.success)
            {
                executePushMessageAction(pushmessagebean, "1");
            }
        }
    }

    public boolean executePushMessageAction(PushMessageBean pushmessagebean, String s)
    {
        System.out.println((new StringBuilder()).append("executePushMessageAction = ").append(s).toString());
        ActionManager.getInstance().feedback(pushmessagebean, s, null);
        BaseBean basebean = pushmessagebean.getBean(s);
        AbstractPushMessageAction abstractpushmessageaction;
        if (basebean != null)
        {
            if ((abstractpushmessageaction = (AbstractPushMessageAction)pushMessageActionMap.get(basebean.getType())) != null)
            {
                pushmessagebean.setActionId(s);
                return abstractpushmessageaction.executeAction(pushmessagebean, basebean);
            }
        }
        return false;
    }

    public int getPrepareWaitActionCounts(String s, boolean flag)
    {
        Map map = prepareWaitCountMap;
        map;
        JVM INSTR monitorenter ;
        int j;
        if (prepareWaitCountMap.get(s) == null)
        {
            prepareWaitCountMap.put(s, Integer.valueOf(0));
        }
        j = ((Integer)prepareWaitCountMap.get(s)).intValue();
        int i;
        i = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        j--;
        prepareWaitCountMap.put(s, Integer.valueOf(j));
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        prepareWaitCountMap.remove(s);
        i = j;
        map;
        JVM INSTR monitorexit ;
        return i;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getPushMessageCacheId(String s, String s1)
    {
        return (new StringBuilder()).append(s).append(":").append(s1).toString();
    }

    public boolean parsePushMessageAction(JSONArray jsonarray, PushMessageBean pushmessagebean)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        Object obj1;
        int i;
        if (jsonarray.length() == 0)
        {
            return false;
        }
        i = 0;
          goto _L1
_L3:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj = (JSONObject)jsonarray.get(i);
        obj1 = ((JSONObject) (obj)).getString("type");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj1 = (AbstractPushMessageAction)pushMessageActionMap.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj = ((AbstractPushMessageAction) (obj1)).parseAction(((JSONObject) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        arraylist.add(obj);
        i++;
        continue; /* Loop/switch isn't completed */
        pushmessagebean.setActionChains(arraylist);
        jsonarray = getInstance().getPushMessageCacheId(pushmessagebean.getTaskId(), pushmessagebean.getMessageId());
        BasicDataManager.pushMessageMap.put(jsonarray, pushmessagebean);
        return true;
        jsonarray;
        jsonarray.printStackTrace();
        return false;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecutePushMessageAction(PushMessageBean pushmessagebean)
    {
        Object obj = com.igexin.sdk.Consts.ActionPrepareState.stop;
        int i = 0;
        for (Iterator iterator = pushmessagebean.getActionChains().iterator(); iterator.hasNext();)
        {
            obj = (BaseBean)iterator.next();
            com.igexin.sdk.Consts.ActionPrepareState actionpreparestate = com.igexin.sdk.Consts.ActionPrepareState.stop;
            if (obj == null)
            {
                return actionpreparestate;
            }
            AbstractPushMessageAction abstractpushmessageaction = (AbstractPushMessageAction)pushMessageActionMap.get(((BaseBean) (obj)).getType());
            if (abstractpushmessageaction != null)
            {
                actionpreparestate = abstractpushmessageaction.prepareExecuteAction(pushmessagebean, ((BaseBean) (obj)));
                if (actionpreparestate == com.igexin.sdk.Consts.ActionPrepareState.wait)
                {
                    i++;
                    obj = actionpreparestate;
                } else
                {
                    obj = actionpreparestate;
                    if (actionpreparestate == com.igexin.sdk.Consts.ActionPrepareState.stop)
                    {
                        return actionpreparestate;
                    }
                }
            } else
            {
                return actionpreparestate;
            }
        }

        if (i != 0)
        {
            if (!setPrepareWaitActionCounts(pushmessagebean.getTaskId(), Integer.valueOf(i), true))
            {
                obj = com.igexin.sdk.Consts.ActionPrepareState.success;
            } else
            {
                obj = com.igexin.sdk.Consts.ActionPrepareState.wait;
            }
        }
        return ((com.igexin.sdk.Consts.ActionPrepareState) (obj));
    }

    public boolean setPrepareWaitActionCounts(String s, Integer integer, boolean flag)
    {
        Map map = prepareWaitCountMap;
        map;
        JVM INSTR monitorenter ;
        int j = integer.intValue();
        int i;
        i = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        i = j;
        if (prepareWaitCountMap.get(s) == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        j = ((Integer)prepareWaitCountMap.get(s)).intValue() + integer.intValue();
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        prepareWaitCountMap.remove(s);
        map;
        JVM INSTR monitorexit ;
        return false;
        prepareWaitCountMap.put(s, Integer.valueOf(i));
        map;
        JVM INSTR monitorexit ;
        return true;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }
}
