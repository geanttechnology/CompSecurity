// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.a.a.e;
import com.helpshift.t;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.analytics.b.d;
import com.target.ui.service.provider.m;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.target.ui.d:
//            c, b

public class com.target.ui.d.a
    implements com.helpshift.t.c
{
    public static interface a
    {

        public abstract void a(int i);
    }

    static class b extends Handler
    {

        private com.target.mothership.model.d mReceiver;

        public void handleMessage(Message message)
        {
            mReceiver.b(new com.target.ui.d.c());
        }

        public b(com.target.mothership.model.d d1)
        {
            mReceiver = d1;
        }
    }

    static class c extends Handler
    {

        private static final String KEY_NOTIFICATION_COUNT_CACHE = "cache";
        private static final String KEY_NOTIFICATION_COUNT_VALUE = "value";
        private com.target.mothership.model.d mReceiver;

        public void handleMessage(Message message)
        {
            message = (Bundle)message.obj;
            int i = message.getInt("value");
            boolean flag = message.getBoolean("cache");
            mReceiver.a(new com.target.ui.d.b(Integer.valueOf(i).intValue(), Boolean.valueOf(flag).booleanValue()));
        }

        public c(com.target.mothership.model.d d1)
        {
            mReceiver = d1;
        }
    }


    private static final String KEY_DISABLE_HELPSHIFT_BRANDING = "disableHelpshiftBranding";
    private static final String KEY_ENABLE_CONTACT_US = "enableContactUs";
    private static final String KEY_ENABLE_FULL_PRIVACEY = "enableFullPrivacy";
    private static final String KEY_GOTO_CONVERSATION_AFTER_CONTACT_US = "gotoConversationAfterContactUs";
    private static final String KEY_HIDE_NAME_AND_EMAIL = "hideNameAndEmail";
    private static final String KEY_INSTALL_DATE = "InstallDate";
    private static final String KEY_ITEMS_CART = "ItemsCart";
    private static final String KEY_LAST_LOGIN = "LastLogin";
    private static final String KEY_NOTIFICATION_ICON = "notificationIcon";
    private static final String KEY_REQUIRE_EMAIL = "requireEmail";
    private static final String KEY_SHOW_SEARCH_ON_NEW_CONVERSATION = "showSearchOnNewConversation";
    private static final String KEY_USER_ID = "UserID";
    private static final String NAME_SPACER = "%s %s";
    private static final String TAG = com/target/ui/d/a.getSimpleName();
    private static com.target.ui.d.a sInstance;
    private m mGuestProvider;
    private Map mMetaData;
    private a mNotificationListener;

    private com.target.ui.d.a(Application application, m m1)
    {
        if (!f())
        {
            HashMap hashmap = new HashMap();
            hashmap.put("disableHelpshiftBranding", Boolean.valueOf(true));
            hashmap.put("notificationIcon", Integer.valueOf(0x7f020154));
            t.a(application, "e0643fd48d41450ba9b6f154892f771f", "target.helpshift.com", "target_platform_20150528134034271-772cf9325439964", hashmap);
            mMetaData = new HashMap();
            mGuestProvider = m1;
            t.a(this);
        }
        com.target.ui.util.c.a.a().register(this);
    }

    private String a(Date date)
    {
        return (new SimpleDateFormat("MM-dd-yyyy hh:mm:ss")).format(date);
    }

    public static void a(Application application, m m1)
    {
        if (sInstance != null)
        {
            return;
        } else
        {
            sInstance = new com.target.ui.d.a(application, m1);
            return;
        }
    }

    private void a(Context context)
    {
        if (mMetaData == null)
        {
            mMetaData = new HashMap();
        }
        try
        {
            mMetaData.put("InstallDate", b(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private String b(Context context)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return a(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime));
    }

    public static com.target.ui.d.a c()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("Initialize must be called before getInstance");
        } else
        {
            return sInstance;
        }
    }

    private void e()
    {
        Object obj = mGuestProvider.a();
        if (obj != null && ((Guest) (obj)).getAccountDetails().b())
        {
            obj = (AccountDetails)((Guest) (obj)).getAccountDetails().c();
            String s = ((AccountDetails) (obj)).getEmailAddress();
            t.a(String.format("%s %s", new Object[] {
                ((AccountDetails) (obj)).getFirstName(), ((AccountDetails) (obj)).getLastName()
            }), s);
            return;
        } else
        {
            t.a("", "");
            return;
        }
    }

    private boolean f()
    {
        return false;
    }

    public void a()
    {
    }

    public void a(int i)
    {
        while (f() || mNotificationListener == null) 
        {
            return;
        }
        mNotificationListener.a(i);
    }

    public void a(int i, String s)
    {
    }

    public void a(Activity activity)
    {
        if (f())
        {
            return;
        } else
        {
            a(((Context) (activity)));
            HashMap hashmap = new HashMap();
            hashmap.put("showSearchOnNewConversation", Boolean.valueOf(true));
            hashmap.put("requireEmail", Boolean.valueOf(false));
            hashmap.put("gotoConversationAfterContactUs", Boolean.valueOf(true));
            hashmap.put("hideNameAndEmail", Boolean.valueOf(false));
            hashmap.put("enableFullPrivacy", Boolean.valueOf(false));
            hashmap.put("hs-custom-metadata", mMetaData);
            e();
            t.a(activity, hashmap);
            return;
        }
    }

    public void a(com.target.mothership.model.d d1)
    {
        if (f())
        {
            return;
        } else
        {
            t.a(new c(d1), new b(d1));
            return;
        }
    }

    public void a(a a1)
    {
        if (f())
        {
            return;
        } else
        {
            mNotificationListener = a1;
            return;
        }
    }

    public void a(File file)
    {
    }

    public void a(String s)
    {
    }

    public void b()
    {
    }

    public void b(int i)
    {
        if (f())
        {
            return;
        } else
        {
            mMetaData.put("ItemsCart", Integer.valueOf(i));
            return;
        }
    }

    public void b(Activity activity)
    {
        if (f())
        {
            return;
        } else
        {
            a(activity);
            HashMap hashmap = new HashMap();
            hashmap.put("enableContactUs", com.helpshift.t.a.a);
            hashmap.put("gotoConversationAfterContactUs", Boolean.valueOf(true));
            hashmap.put("requireEmail", Boolean.valueOf(false));
            hashmap.put("hideNameAndEmail", Boolean.valueOf(false));
            hashmap.put("enableFullPrivacy", Boolean.valueOf(false));
            hashmap.put("hs-custom-metadata", mMetaData);
            e();
            t.b(activity, hashmap);
            return;
        }
    }

    public void b(String s)
    {
    }

    public void c(String s)
    {
        if (f())
        {
            return;
        } else
        {
            mMetaData.put("UserID", s);
            return;
        }
    }

    public void d()
    {
        if (f())
        {
            return;
        } else
        {
            Date date = new Date();
            mMetaData.put("LastLogin", a(date));
            return;
        }
    }

    public void onEvent(d d1)
    {
        if (f())
        {
            return;
        } else
        {
            t.a(d1.screenName);
            return;
        }
    }

}
