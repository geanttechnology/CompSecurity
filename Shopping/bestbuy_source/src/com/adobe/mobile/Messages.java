// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, Message, MessageFullScreen, ReferrerHandler, 
//            MobileConfig, Lifecycle

final class Messages
{

    protected static final String MESSAGE_ACTION_NAME = "In-App Message";
    protected static final String MESSAGE_CLICKED = "a.message.clicked";
    protected static final String MESSAGE_ID = "a.message.id";
    protected static final String MESSAGE_LOCAL_ADB_CODE = "adbMessageCode";
    protected static final Integer MESSAGE_LOCAL_IDENTIFIER = Integer.valueOf(0xb7267);
    protected static final String MESSAGE_LOCAL_PAYLOAD = "alarm_message";
    protected static final String MESSAGE_LOCAL_REQUEST_CODE = "requestCode";
    protected static final String MESSAGE_TOKEN_LIFETIME_VALUE = "{lifetimeValue}";
    protected static final String MESSAGE_TOKEN_MESSAGE_ID = "{messageId}";
    protected static final String MESSAGE_TOKEN_TRACKING_ID = "{trackingId}";
    protected static final String MESSAGE_TOKEN_USER_ID = "{userId}";
    protected static final String MESSAGE_VIEWED = "a.message.viewed";
    private static Message _currentMessage = null;
    private static final Object _currentMessageMutex = new Object();
    private static int _largeIconResourceId = -1;
    private static MessageFullScreen _messageFullScreen = null;
    private static final Object _messageFullScreenMutex = new Object();
    private static int _smallIconResourceId = -1;

    Messages()
    {
    }

    protected static void block3rdPartyCallbacksQueueForReferrer()
    {
        StaticMethods.getThirdPartyCallbacksExecutor().execute(new Runnable() {

            public void run()
            {
                while (!ReferrerHandler.getReferrerProcessed()) 
                {
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch (Exception exception)
                    {
                        StaticMethods.logWarningFormat("Data Callback - Data Callback Queue Is Interrupted(%s)", new Object[] {
                            exception.getMessage()
                        });
                    }
                }
            }

        });
    }

    protected static void checkFor3rdPartyCallbacks(final Map vars, final Map cdata)
    {
        StaticMethods.getThirdPartyCallbacksExecutor().execute(new Runnable() {

            final Map val$cdata;
            final Map val$vars;

            public void run()
            {
                Object obj = MobileConfig.getInstance().getCallbackTemplates();
                if (obj != null && ((ArrayList) (obj)).size() > 0)
                {
                    HashMap hashmap = new HashMap(Lifecycle.getContextDataLowercase());
                    HashMap hashmap1 = Messages.lowercaseKeysForMap(cdata);
                    HashMap hashmap2 = Messages.lowercaseKeysForMap(vars);
                    obj = ((ArrayList) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Message message = (Message)((Iterator) (obj)).next();
                        if (message.shouldShowForVariables(hashmap2, hashmap1, hashmap))
                        {
                            message.show();
                        }
                    }
                }
            }

            
            {
                cdata = map;
                vars = map1;
                super();
            }
        });
    }

    protected static void checkForInAppMessage(final Map vars, final Map cdata, final Map lifecycleData)
    {
        StaticMethods.getMessagesExecutor().execute(new Runnable() {

            final Map val$cdata;
            final Map val$lifecycleData;
            final Map val$vars;

            public void run()
            {
                Object obj;
                obj = null;
                if (!StaticMethods.isWearableApp())
                {
                    obj = MobileConfig.getInstance().getInAppMessages();
                }
                break MISSING_BLOCK_LABEL_15;
                Message message;
label0:
                while (true) 
                {
                    do
                    {
                        return;
                    } while (obj == null || ((ArrayList) (obj)).size() <= 0 || vars != null && vars.containsKey("pev2") && vars.get("pev2").toString().equals("ADBINTERNAL:In-App Message"));
                    HashMap hashmap = Messages.lowercaseKeysForMap(cdata);
                    HashMap hashmap1 = Messages.lowercaseKeysForMap(vars);
                    obj = ((ArrayList) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            continue label0;
                        }
                        message = (Message)((Iterator) (obj)).next();
                    } while (!message.shouldShowForVariables(hashmap1, hashmap, lifecycleData));
                    break;
                }
                message.show();
                return;
            }

            
            {
                vars = map;
                cdata = map1;
                lifecycleData = map2;
                super();
            }
        });
    }

    protected static MessageFullScreen getCurrentFullscreenMessage()
    {
        MessageFullScreen messagefullscreen;
        synchronized (_messageFullScreenMutex)
        {
            messagefullscreen = _messageFullScreen;
        }
        return messagefullscreen;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static Message getCurrentMessage()
    {
        Message message;
        synchronized (_currentMessageMutex)
        {
            message = _currentMessage;
        }
        return message;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static int getLargeIconResourceId()
    {
        return _largeIconResourceId;
    }

    protected static int getSmallIconResourceId()
    {
        return _smallIconResourceId;
    }

    protected static HashMap lowercaseKeysForMap(Map map)
    {
        if (map == null || map.size() <= 0)
        {
            return null;
        }
        HashMap hashmap = new HashMap(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(((String)entry.getKey()).toLowerCase(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    protected static void resetAllInAppMessages()
    {
        StaticMethods.getMessagesExecutor().execute(new Runnable() {

            public void run()
            {
                Object obj = MobileConfig.getInstance().getInAppMessages();
                if (obj != null && ((ArrayList) (obj)).size() > 0)
                {
                    obj = ((ArrayList) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        ((Message)((Iterator) (obj)).next()).isVisible = false;
                    }
                }
            }

        });
    }

    protected static void setCurrentMessage(Message message)
    {
        synchronized (_currentMessageMutex)
        {
            _currentMessage = message;
        }
        return;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
    }

    protected static void setCurrentMessageFullscreen(MessageFullScreen messagefullscreen)
    {
        synchronized (_messageFullScreenMutex)
        {
            _messageFullScreen = messagefullscreen;
        }
        return;
        messagefullscreen;
        obj;
        JVM INSTR monitorexit ;
        throw messagefullscreen;
    }

    protected static void setLargeIconResourceId(int i)
    {
        _largeIconResourceId = i;
    }

    protected static void setSmallIconResourceId(int i)
    {
        _smallIconResourceId = i;
    }

}
