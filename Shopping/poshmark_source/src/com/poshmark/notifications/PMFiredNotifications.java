// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.notifications:
//            PMNotificationDetails, PMNotificationManager

public class PMFiredNotifications
{

    List firedNotifications;

    public PMFiredNotifications()
    {
        firedNotifications = new ArrayList();
    }

    private void addNotification(PMNotificationDetails pmnotificationdetails)
    {
        firedNotifications.add(pmnotificationdetails);
    }

    public static void cancelAllSavedNotifications()
    {
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        SharedPreferences sharedpreferences = ((Context) (obj)).getSharedPreferences("firedNotifications", 0);
        obj = sharedpreferences.getString("firedNotifications", null);
        if (obj == null)
        {
            return;
        }
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            obj = gson.fromJson(((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
        } else
        {
            obj = GsonInstrumentation.fromJson((Gson)gson, ((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
        }
        for (obj = ((PMFiredNotifications)obj).firedNotifications.iterator(); ((Iterator) (obj)).hasNext(); PMNotificationManager.cancelDelayedNotification(((PMNotificationDetails)((Iterator) (obj)).next()).id)) { }
        sharedpreferences.edit().clear().commit();
    }

    public static PMFiredNotifications getFiredNotifications()
    {
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        obj = ((Context) (obj)).getSharedPreferences("firedNotifications", 0).getString("firedNotifications", null);
        if (obj == null)
        {
            return null;
        }
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            obj = gson.fromJson(((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
        } else
        {
            obj = GsonInstrumentation.fromJson((Gson)gson, ((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
        }
        return (PMFiredNotifications)obj;
    }

    public static void saveFiredNotification(int i)
    {
        Gson gson = new Gson();
        PMNotificationDetails pmnotificationdetails = new PMNotificationDetails();
        pmnotificationdetails.id = i;
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        SharedPreferences sharedpreferences = ((Context) (obj)).getSharedPreferences("firedNotifications", 0);
        obj = sharedpreferences.getString("firedNotifications", null);
        if (obj == null)
        {
            PMFiredNotifications pmfirednotifications = new PMFiredNotifications();
            pmfirednotifications.addNotification(pmnotificationdetails);
            if (!(gson instanceof Gson))
            {
                obj = gson.toJson(pmfirednotifications);
            } else
            {
                obj = GsonInstrumentation.toJson((Gson)gson, pmfirednotifications);
            }
            sharedpreferences.edit().putString("firedNotifications", ((String) (obj))).commit();
            obj = pmfirednotifications;
        } else
        {
            if (!(gson instanceof Gson))
            {
                obj = gson.fromJson(((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
            } else
            {
                obj = GsonInstrumentation.fromJson((Gson)gson, ((String) (obj)), com/poshmark/notifications/PMFiredNotifications);
            }
            obj = (PMFiredNotifications)obj;
            ((PMFiredNotifications) (obj)).addNotification(pmnotificationdetails);
        }
        if (!(gson instanceof Gson))
        {
            obj = gson.toJson(obj);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)gson, obj);
        }
        sharedpreferences.edit().putString("firedNotifications", ((String) (obj))).commit();
    }
}
