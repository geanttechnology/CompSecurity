// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.EventList;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMDisplayedAlerts;
import com.poshmark.notifications.PMFiredNotifications;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.notifications.PartyAlert;
import com.poshmark.utils.DateUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GlobalPartiesController
    implements PMNotificationListener
{

    static GlobalPartiesController globalModelStore = null;
    final int CURRENT_PARTY_END_MSG = 1;
    boolean disableAlerts;
    EventList eventList;
    Date lastFetchTime;
    public Handler partyMessageHandler;

    GlobalPartiesController()
    {
        eventList = null;
        lastFetchTime = null;
        disableAlerts = false;
        partyMessageHandler = new Handler() {

            final GlobalPartiesController this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    message = (String)message.obj;
                    break;
                }
                handleEndOfPartyTimerMessage(message);
            }

            
            {
                this$0 = GlobalPartiesController.this;
                super();
            }
        };
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_EVENTS_ON_SERVER", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
    }

    public static GlobalPartiesController getGlobalPartiesController()
    {
        if (globalModelStore == null)
        {
            globalModelStore = new GlobalPartiesController();
        }
        return globalModelStore;
    }

    private void handleCurrentParties()
    {
        partyMessageHandler.removeMessages(1);
        Object obj = eventList.getCurrentParties().iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (PartyEvent)((Iterator) (obj)).next();
            Object obj1 = DateUtils.getDateFromString(((PartyEvent) (obj)).getStartTime());
            Date date = new Date();
            Date date1 = new Date();
            date1.setTime(((Date) (obj1)).getTime() + ((PartyEvent) (obj)).getDuration() * 1000L);
            long l = date1.getTime();
            long l1 = date.getTime();
            obj1 = new Message();
            obj1.obj = ((PartyEvent) (obj)).getId();
            obj1.what = 1;
            partyMessageHandler.sendMessageDelayed(((Message) (obj1)), l - l1);
            obj1 = new Bundle();
            ((Bundle) (obj1)).putString("ID", ((PartyEvent) (obj)).getId());
            ((Bundle) (obj1)).putString("PARTY_TITLE", ((PartyEvent) (obj)).getName());
            if (((PartyEvent) (obj)).isReminderEnabled() && !PMDisplayedAlerts.isEventAlertDisplayed(((PartyEvent) (obj)).getId()))
            {
                PMDisplayedAlerts.addEventToDisplayedList(((PartyEvent) (obj)).getId());
                if (!disableAlerts)
                {
                    PartyAlert.showPartyAlert(((Bundle) (obj1)));
                }
            }
        }
    }

    private void handleEndOfPartyTimerMessage(String s)
    {
        reorganizeParties();
        PMDisplayedAlerts.removeDisplayedAlertFromList(s);
        PMNotificationManager.fireNotification("com.poshmark.intents.PARTY_EVENT_END");
    }

    private void handleFutureParties()
    {
        PMFiredNotifications.cancelAllSavedNotifications();
        Iterator iterator = eventList.getFutureParties().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PartyEvent partyevent = (PartyEvent)iterator.next();
            if (partyevent.isReminderEnabled())
            {
                Date date = DateUtils.getDateFromString(partyevent.getStartTime());
                Bundle bundle = new Bundle();
                bundle.putString("ID", partyevent.getId());
                bundle.putString("PARTY_TITLE", partyevent.getName());
                PMNotificationManager.fireDelayedNotification("com.poshmark.intents.PARTY_ALARM", bundle, date.getTime());
            }
        } while (true);
    }

    private void setupPartyNotifications()
    {
        handleFutureParties();
        handleCurrentParties();
    }

    public void disableAllControllerNotifications()
    {
        partyMessageHandler.removeMessages(1);
    }

    public void disablePartyAlerts()
    {
        disableAlerts = true;
    }

    public void enablePartyAlerts()
    {
        disableAlerts = false;
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        for (ListIterator listiterator = eventList.getCurrentParties().listIterator(); listiterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (PartyEvent)listiterator.next()
})) { }
        for (ListIterator listiterator1 = eventList.getFutureParties().listIterator(eventList.getFutureParties().size()); listiterator1.hasPrevious(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (PartyEvent)listiterator1.previous()
})) { }
        for (ListIterator listiterator2 = eventList.getPastParties().listIterator(); listiterator2.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (PartyEvent)listiterator2.next()
})) { }
    }

    public void firePartyAlert(Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        if (eventList != null)
        {
            reorganizeParties();
            handleCurrentParties();
            PMNotificationManager.fireNotification("com.poshmark.intents.PARTY_EVENT_START");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bundle;
        throw bundle;
    }

    public void forceRefreshOfEventData()
    {
        PMFiredNotifications.cancelAllSavedNotifications();
        partyMessageHandler.removeMessages(1);
        getEventsData();
    }

    public List getCurrentParties()
    {
        if (eventList != null)
        {
            return eventList.getCurrentParties();
        } else
        {
            return null;
        }
    }

    public int getCurrentPartiesCount()
    {
        if (eventList != null)
        {
            return eventList.getCurrentPartiesCount();
        } else
        {
            return 0;
        }
    }

    public int getEventsCount()
    {
        if (eventList != null)
        {
            return eventList.getEventsCount();
        } else
        {
            return 0;
        }
    }

    void getEventsData()
    {
        PMApi.getEvents(new PMApiResponseHandler() {

            final GlobalPartiesController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    eventList = (EventList)pmapiresponse.data;
                    lastFetchTime = new Date();
                    if (eventList != null)
                    {
                        eventList.filterParties();
                        setupPartyNotifications();
                        PMNotificationManager.fireNotification("com.poshmark.intents.EVENTS_FETCH_COMPLETE");
                    }
                }
            }

            
            {
                this$0 = GlobalPartiesController.this;
                super();
            }
        });
    }

    public PartyEvent getParty(String s)
    {
        if (eventList != null)
        {
            return eventList.getParty(s);
        } else
        {
            return null;
        }
    }

    public int getPastPartiesCount()
    {
        if (eventList != null)
        {
            return eventList.getPastPartiesCount();
        } else
        {
            return 0;
        }
    }

    public int getUpcomingPartiesCount()
    {
        if (eventList != null)
        {
            return eventList.getUpcomingPartiesCount();
        } else
        {
            return 0;
        }
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            disableAllControllerNotifications();
            PMFiredNotifications.cancelAllSavedNotifications();
            eventList = null;
            lastFetchTime = null;
        } else
        if (intent.getAction().equals("com.poshmark.intents.NEW_EVENTS_ON_SERVER"))
        {
            getEventsData();
            return;
        }
    }

    public boolean isCurrentParty(String s)
    {
        if (eventList != null)
        {
            Iterator iterator = eventList.getCurrentParties().iterator();
            while (iterator.hasNext()) 
            {
                if (((PartyEvent)iterator.next()).getId().equals(s))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isModelPopulated()
    {
        return eventList != null;
    }

    public boolean lastUpdatedBefore(Date date)
    {
        return lastFetchTime == null || lastFetchTime.before(date);
    }

    public void reorganizeParties()
    {
        this;
        JVM INSTR monitorenter ;
        if (eventList != null)
        {
            eventList.filterParties();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }



}
