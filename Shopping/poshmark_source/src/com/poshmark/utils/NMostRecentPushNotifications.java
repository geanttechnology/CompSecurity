// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplication;
import java.util.LinkedList;

public class NMostRecentPushNotifications
{
    public static class PushMessage
    {

        String msg;
        int priority;

        public CharSequence getMessage()
        {
            return msg;
        }

        public PushMessage(String s)
        {
            priority = 0;
            msg = s;
        }

        public PushMessage(String s, String s1)
        {
            priority = 0;
            msg = s;
            try
            {
                priority = Integer.parseInt(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                priority = 1;
            }
        }
    }


    int MAX_PRIOTITY;
    PushMessage VIPMessage;
    int blockSize;
    int currentSize;
    SharedPreferences savedNotifications;
    LinkedList stack;

    public NMostRecentPushNotifications()
    {
        stack = new LinkedList();
        blockSize = 4;
        currentSize = 0;
        MAX_PRIOTITY = 100;
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        savedNotifications = ((Context) (obj)).getSharedPreferences("savedNotifications", 0);
        obj = savedNotifications.getString("version", null);
        if (obj != null && !((String) (obj)).equals(AppInfo.getInstance().versionName))
        {
            savedNotifications.edit().clear().commit();
        }
        currentSize = savedNotifications.getInt("savedNotificationCount", 0);
    }

    private void addNewMessage(PushMessage pushmessage)
    {
        stack.addFirst(pushmessage);
        if (VIPMessage == null || pushmessage.priority >= VIPMessage.priority)
        {
            VIPMessage = pushmessage;
        }
    }

    public static void clearAllSavedPushNotifications()
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        context.getSharedPreferences("savedNotifications", 0).edit().clear().commit();
    }

    private void removeOldMessage(int i)
    {
        if (currentSize == blockSize)
        {
            i = stack.size();
            int j = MAX_PRIOTITY;
            int l = 0;
            for (i--; i >= 0;)
            {
                PushMessage pushmessage = (PushMessage)stack.get(i);
                int k = j;
                if (pushmessage.priority < j)
                {
                    k = pushmessage.priority;
                    l = i;
                }
                i--;
                j = k;
            }

            stack.remove(l);
            currentSize = currentSize - 1;
        }
    }

    public void add(PushMessage pushmessage)
    {
        if (stack.size() == blockSize)
        {
            removeOldMessage(pushmessage.priority);
        }
        addNewMessage(pushmessage);
        currentSize = currentSize + 1;
    }

    public void flush()
    {
        Gson gson = (new GsonBuilder()).create();
        savedNotifications.edit().putString("version", AppInfo.getInstance().versionName).commit();
        savedNotifications.edit().putInt("savedNotificationCount", currentSize).commit();
        int i = 0;
        while (i < currentSize) 
        {
            Object obj = (PushMessage)stack.get(i);
            String s;
            if (!(gson instanceof Gson))
            {
                obj = gson.toJson(obj);
            } else
            {
                obj = GsonInstrumentation.toJson((Gson)gson, obj);
            }
            s = (new StringBuilder()).append("Notification-").append(Integer.toString(i)).toString();
            savedNotifications.edit().putString(s, ((String) (obj))).commit();
            i++;
        }
        if (VIPMessage != null)
        {
            Object obj1 = VIPMessage;
            if (!(gson instanceof Gson))
            {
                obj1 = gson.toJson(obj1);
            } else
            {
                obj1 = GsonInstrumentation.toJson((Gson)gson, obj1);
            }
            savedNotifications.edit().putString("VipPushNotification", ((String) (obj1))).commit();
        }
    }

    public PushMessage get(int i)
    {
        return (PushMessage)stack.get(i);
    }

    public int getCount()
    {
        return currentSize;
    }

    public PushMessage getVIPMessage()
    {
        return VIPMessage;
    }

    public void loadAll()
    {
        Gson gson = (new GsonBuilder()).create();
        int i = 0;
        while (i < currentSize) 
        {
            Object obj = (new StringBuilder()).append("Notification-").append(Integer.toString(i)).toString();
            obj = savedNotifications.getString(((String) (obj)), null);
            if (!(gson instanceof Gson))
            {
                obj = gson.fromJson(((String) (obj)), com/poshmark/utils/NMostRecentPushNotifications$PushMessage);
            } else
            {
                obj = GsonInstrumentation.fromJson((Gson)gson, ((String) (obj)), com/poshmark/utils/NMostRecentPushNotifications$PushMessage);
            }
            obj = (PushMessage)obj;
            if (obj != null)
            {
                stack.add(obj);
            }
            i++;
        }
        Object obj1 = savedNotifications.getString("VipPushNotification", null);
        if (obj1 != null)
        {
            if (!(gson instanceof Gson))
            {
                obj1 = gson.fromJson(((String) (obj1)), com/poshmark/utils/NMostRecentPushNotifications$PushMessage);
            } else
            {
                obj1 = GsonInstrumentation.fromJson((Gson)gson, ((String) (obj1)), com/poshmark/utils/NMostRecentPushNotifications$PushMessage);
            }
            VIPMessage = (PushMessage)obj1;
        }
    }
}
