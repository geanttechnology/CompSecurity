// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.events.InAppMessageStateChangeListener;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.InAppMessageSyncManager;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DivisionUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ObjectMapperWrapper;
import com.squareup.okhttp.FormEncodingBuilder;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.codehaus.jackson.type.TypeReference;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService, LocationService

public class InAppMessageService
    implements InAppMessageStateChangeListener, com.groupon.models.inappmessage.InAppMessageStateChangeListener
{
    public static final class EventName extends Enum
    {

        private static final EventName $VALUES[];
        public static final EventName CLICKED;
        public static final EventName DISMISSED;
        public static final EventName VIEWED;

        public static EventName valueOf(String s)
        {
            return (EventName)Enum.valueOf(com/groupon/service/InAppMessageService$EventName, s);
        }

        public static EventName[] values()
        {
            return (EventName[])$VALUES.clone();
        }

        public String toString()
        {
            return super.toString().toLowerCase();
        }

        static 
        {
            VIEWED = new EventName("VIEWED", 0);
            CLICKED = new EventName("CLICKED", 1);
            DISMISSED = new EventName("DISMISSED", 2);
            $VALUES = (new EventName[] {
                VIEWED, CLICKED, DISMISSED
            });
        }

        private EventName(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LocalMessageType extends Enum
    {

        private static final LocalMessageType $VALUES[];
        public static final LocalMessageType HEARTX_TOAST;

        public static LocalMessageType valueOf(String s)
        {
            return (LocalMessageType)Enum.valueOf(com/groupon/service/InAppMessageService$LocalMessageType, s);
        }

        public static LocalMessageType[] values()
        {
            return (LocalMessageType[])$VALUES.clone();
        }

        static 
        {
            HEARTX_TOAST = new LocalMessageType("HEARTX_TOAST", 0);
            $VALUES = (new LocalMessageType[] {
                HEARTX_TOAST
            });
        }

        private LocalMessageType(String s, int i)
        {
            super(s, i);
        }
    }


    private AbTestService abTestService;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private DaoInAppMessage daoInAppMessage;
    private String deviceId;
    private Lazy divisionUtil;
    private ExecutorService executorService;
    private List history;
    private InAppMessageSyncManager inAppSyncManager;
    private boolean isRedesignInAppMessages1406;
    private LocalizedSharedPreferencesProvider locationPreferenceManager;
    private Lazy locationService;
    private Logger logger;
    private LoginService loginService;
    private ObjectMapperWrapper objectMapper;
    private SharedPreferences prefs;
    private String version;

    public InAppMessageService(Application application)
    {
        try
        {
            version = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            throw new RuntimeException(application);
        }
        divisionUtil = new Lazy(application) {

            final InAppMessageService this$0;

            
            {
                this$0 = InAppMessageService.this;
                super(context1);
            }
        };
        locationService = new Lazy(application) {

            final InAppMessageService this$0;

            
            {
                this$0 = InAppMessageService.this;
                super(context1);
            }
        };
    }

    private SyncHttp buildInAppEventRequest(String s, EventName eventname)
        throws Exception
    {
        s = String.format("https:/in_app_messages/%s/events.json", new Object[] {
            s
        });
        eventname = (new FormEncodingBuilder()).add("device_id", deviceId).add("event_name", eventname.toString());
        if (loginService.isLoggedIn())
        {
            eventname.add("user_id", loginService.getUserId());
        }
        return (new SyncHttp(context, java/lang/Void, s, eventname.build())).method("POST");
    }

    private InAppMessage getLocalMessageByType(LocalMessageType localmessagetype)
    {
        static class _cls8
        {

            static final int $SwitchMap$com$groupon$service$InAppMessageService$LocalMessageType[];

            static 
            {
                $SwitchMap$com$groupon$service$InAppMessageService$LocalMessageType = new int[LocalMessageType.values().length];
                try
                {
                    $SwitchMap$com$groupon$service$InAppMessageService$LocalMessageType[LocalMessageType.HEARTX_TOAST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls8..SwitchMap.com.groupon.service.InAppMessageService.LocalMessageType[localmessagetype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            localmessagetype = new InAppMessage();
            break;
        }
        localmessagetype.setId("1");
        localmessagetype.setContext("featured");
        localmessagetype.setTitle("Get better deals by telling us what you like.");
        localmessagetype.setMessage("Tap here to learn more.");
        localmessagetype.setTarget("us/heartx/tutorial");
        return localmessagetype;
    }

    private LocalMessageType getLocalMessageType()
    {
        return null;
    }

    private InAppMessage getLocalizedMobileAppMessage()
    {
        InAppMessage inappmessage = new InAppMessage();
        inappmessage.setId("1");
        inappmessage.setContext("featured");
        inappmessage.setTitle(context.getResources().getString(0x7f0802a0, new Object[] {
            currentDivisionManager.getCurrentDivision().name.toUpperCase()
        }));
        inappmessage.setMessage(context.getResources().getString(0x7f08029f));
        inappmessage.setTarget("us/channel/featured");
        return inappmessage;
    }

    private void initializeHistory()
    {
        if (locationPreferenceManager.get().contains("inAppMessageHistory"))
        {
            String s = locationPreferenceManager.get().getString("inAppMessageHistory", "");
            if (Strings.notEmpty(s))
            {
                try
                {
                    history = (List)objectMapper.readValue(s, new TypeReference() {

                        final InAppMessageService this$0;

            
            {
                this$0 = InAppMessageService.this;
                super();
            }
                    });
                }
                catch (IOException ioexception)
                {
                    Ln.e(ioexception, "Impossible to read in app message from history.", new Object[0]);
                }
            }
        }
        if (history == null)
        {
            history = new ArrayList();
        }
    }

    private void setInAppMessage(InAppMessage inappmessage, Function1 function1)
    {
label0:
        {
            inappmessage.setServices(this);
            String s = inappmessage.getId();
            if (Strings.isEmpty(s))
            {
                Ln.w("No Message Id", new Object[0]);
                return;
            }
            if (Strings.equals(s, "7834"))
            {
                break label0;
            }
            Iterator iterator = history.iterator();
            do
            {
                InAppMessage inappmessage1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    inappmessage1 = (InAppMessage)iterator.next();
                } while (!Strings.equals(s, inappmessage1.getId()));
                inappmessage.updateFrom(inappmessage1);
            } while (inappmessage.isEnabled());
            Ln.i("duplicate %s", new Object[] {
                s
            });
            return;
        }
        function1.execute(inappmessage);
    }

    private boolean shouldShowLocalMessage()
    {
        return false;
    }

    private boolean shouldShowLocalizedMobileAppMessage()
    {
        if (prefs.getString("locationChangedInAppMessageId", "").equals("7834"))
        {
            prefs.edit().remove("locationChangedInAppMessageId").apply();
            return true;
        } else
        {
            return false;
        }
    }

    public void getOneMessage(Function1 function1, Function0 function0)
    {
        if (history == null)
        {
            initializeHistory();
        }
        if (function1 == null)
        {
            if (function0 != null)
            {
                function0.execute();
            }
            return;
        }
        if (shouldShowLocalizedMobileAppMessage())
        {
            try
            {
                setInAppMessage(getLocalizedMobileAppMessage(), function1);
                Ln.d("LocalizedMobileApp: set InAppMessage", new Object[0]);
                return;
            }
            catch (Exception exception)
            {
                Ln.e((new StringBuilder()).append("LocalizedMobileApp: ").append(exception).toString(), new Object[0]);
            }
        }
        if (shouldShowLocalMessage())
        {
            try
            {
                setInAppMessage(getLocalMessageByType(getLocalMessageType()), function1);
            }
            catch (Exception exception1)
            {
                Ln.e(exception1);
            }
        }
        (new Http("https:/in_app_messages", function1, function0) {

            final InAppMessageService this$0;
            final Function0 val$onFinally;
            final Function1 val$onMessageAvailable;

            public com.groupon.models.inappmessage.InAppMessage.List call()
                throws Exception
            {
                if (currentDivisionManager.getCurrentDivision() == null)
                {
                    Ln.i("Division empty - cannot retrieve messages", new Object[0]);
                    return null;
                }
                if (Strings.isEmpty(deviceId))
                {
                    Ln.w("Device Id empty - cannot retrieve messages", new Object[0]);
                    return null;
                }
                android.location.Location location = ((LocationService)locationService.get()).getLocation();
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "page", Integer.valueOf(1), "per_page", Integer.valueOf(1)
                }));
                if (loginService.isLoggedIn())
                {
                    arraylist.addAll(Arrays.asList(new String[] {
                        "user_id", loginService.getUserId()
                    }));
                }
                arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairs(location));
                arraylist.addAll(Arrays.asList(new String[] {
                    "version_number", version
                }));
                arraylist.addAll(Arrays.asList(new String[] {
                    "device_id", deviceId
                }));
                nvps(arraylist.toArray());
                return (com.groupon.models.inappmessage.InAppMessage.List)super.call();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            protected void onException(Exception exception2)
            {
                Ln.w(exception2);
            }

            protected void onFinally()
            {
                if (onFinally != null)
                {
                    onFinally.execute();
                }
            }

            protected void onSuccess(com.groupon.models.inappmessage.InAppMessage.List list)
                throws Exception
            {
                try
                {
                    if (list.inAppMessages != null && !list.inAppMessages.isEmpty())
                    {
                        setInAppMessage((InAppMessage)list.inAppMessages.get(0), onMessageAvailable);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.groupon.models.inappmessage.InAppMessage.List list)
                {
                    Ln.e(list);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.inappmessage.InAppMessage.List)obj);
            }

            
            {
                this$0 = InAppMessageService.this;
                onMessageAvailable = function1;
                onFinally = function0;
                super(final_context1, final_class1, s);
            }
        }).execute();
    }

    protected void init()
    {
        isRedesignInAppMessages1406 = abTestService.isVariantEnabled("redesignInAppMessages1406", "on");
        if (isRedesignInAppMessages1406 && !prefs.contains("inAppMessageForceUpdate"))
        {
            prefs.edit().putBoolean("inAppMessageForceUpdate", false).apply();
        }
    }

    public void initExecutor()
    {
        executorService = Executors.newSingleThreadExecutor();
        if (loginService.isLoggedIn() && prefs.getBoolean("inAppMessageForceUpdate", false))
        {
            inAppSyncManager.requestSync(null, null);
            prefs.edit().putBoolean("inAppMessageForceUpdate", false).apply();
        }
    }

    public boolean isInAppMessageEnabled()
    {
        return !currentCountryManager.getCurrentCountry().isJapan() && !currentCountryManager.getCurrentCountry().isRussia();
    }

    public boolean isInAppMessagesRedesignEnabled()
    {
        return isInAppMessageEnabled() && isRedesignInAppMessages1406;
    }

    public void logInAppBellIconClick(String s, int i, int j)
    {
        logger.logClick("", "bell_icon_click", s, (new StringBuilder()).append("unread messages: ").append(i).append(" read messages: ").append(j).toString());
    }

    public void logInAppMessageClick(String s, String s1, String s2)
    {
        logger.logClick("", "in_app_message", s, (new StringBuilder()).append("messageId: ").append(s1).append(", clickable = ").append(s2).toString());
    }

    public void onStateChanged(com.groupon.db.models.InAppMessage inappmessage, EventName eventname)
    {
        try
        {
            (new Http(eventname, inappmessage) {

                final InAppMessageService this$0;
                final EventName val$eventType;
                final com.groupon.db.models.InAppMessage val$inAppMessage;

                protected void onException(Exception exception)
                {
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((Void)obj);
                }

                protected void onSuccess(Void void1)
                {
                    if (eventType == EventName.VIEWED)
                    {
                        inAppMessage.read = true;
                        updateInAppMessage(inAppMessage);
                    }
                }

            
            {
                this$0 = InAppMessageService.this;
                eventType = eventname;
                inAppMessage = inappmessage;
                super(final_context1, final_synchttp);
            }
            }).execute();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.groupon.db.models.InAppMessage inappmessage)
        {
            throw new RuntimeException(inappmessage);
        }
    }

    public void onStateChanged(InAppMessage inappmessage, EventName eventname)
    {
        try
        {
            (new Http(inappmessage, eventname) {

                final InAppMessageService this$0;
                final EventName val$eventType;
                final InAppMessage val$inAppMessage;

                protected void onException(Exception exception1)
                {
                    inAppMessage.onUpdateFailed(eventType);
                    updateHistory(inAppMessage);
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((Void)obj);
                }

                protected void onSuccess(Void void1)
                {
                    inAppMessage.onUpdateSuccess(eventType);
                    updateHistory(inAppMessage);
                }

            
            {
                this$0 = InAppMessageService.this;
                inAppMessage = inappmessage;
                eventType = eventname;
                super(final_context1, final_synchttp);
            }
            }).execute();
            return;
        }
        catch (Exception exception)
        {
            Ln.e(exception);
        }
        inappmessage.onUpdateFailed(eventname);
        updateHistory(inappmessage);
    }

    public void shutDownExecutor()
    {
        if (executorService != null)
        {
            executorService.shutdown();
        }
    }

    public void updateHistory(InAppMessage inappmessage)
    {
        this;
        JVM INSTR monitorenter ;
        String s = inappmessage.getId();
        boolean flag1 = false;
        Iterator iterator = history.iterator();
_L2:
        boolean flag = flag1;
        InAppMessage inappmessage1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        inappmessage1 = (InAppMessage)iterator.next();
        if (!Strings.equals(s, inappmessage1.getId())) goto _L2; else goto _L1
_L1:
        inappmessage.updateTo(inappmessage1);
        flag = true;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        history.add(inappmessage);
        for (inappmessage = history.iterator(); history.size() > 10 && inappmessage.hasNext(); inappmessage.remove())
        {
            inappmessage.next();
        }

        break MISSING_BLOCK_LABEL_135;
        inappmessage;
        throw inappmessage;
        locationPreferenceManager.get().edit().putString("inAppMessageHistory", objectMapper.writeValueAsString(history)).apply();
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
        inappmessage;
        Ln.e(inappmessage, "Impossible to write history of in app messages.", new Object[0]);
          goto _L3
    }

    public void updateInAppMessage(final com.groupon.db.models.InAppMessage inAppMessage)
    {
        if (executorService != null)
        {
            executorService.execute(new Runnable() {

                final InAppMessageService this$0;
                final com.groupon.db.models.InAppMessage val$inAppMessage;

                public void run()
                {
                    daoInAppMessage.replace(inAppMessage);
                }

            
            {
                this$0 = InAppMessageService.this;
                inAppMessage = inappmessage;
                super();
            }
            });
        }
    }








}
