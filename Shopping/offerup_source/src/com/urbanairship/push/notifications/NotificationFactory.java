// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.bj;
import android.support.v4.app.bk;
import android.support.v4.app.bl;
import android.support.v4.app.bn;
import android.support.v4.app.bo;
import android.support.v4.app.bx;
import android.support.v4.app.by;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.BitmapUtils;
import com.urbanairship.util.UAStringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationActionButtonGroup

public abstract class NotificationFactory
{

    static final String ALERT_KEY = "alert";
    static final String BACKGROUND_IMAGE_KEY = "background_image";
    private static final int BIG_IMAGE_HEIGHT_DP = 240;
    private static final double BIG_IMAGE_SCREEN_WIDTH_PERCENT = 0.75D;
    static final String BIG_PICTURE_KEY = "big_picture";
    static final String BIG_TEXT_KEY = "big_text";
    static final String EXTRA_PAGES_KEY = "extra_pages";
    static final String INBOX_KEY = "inbox";
    static final String INTERACTIVE_ACTIONS_KEY = "interactive_actions";
    static final String INTERACTIVE_TYPE_KEY = "interactive_type";
    static final String LINES_KEY = "lines";
    static final int NOTIFICATION_DEFAULTS = 3;
    static final String SUMMARY_KEY = "summary";
    static final String TITLE_KEY = "title";
    static final String TYPE_KEY = "type";
    private final Context context;

    public NotificationFactory(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private bj createBigPictureStyle(JSONObject jsonobject)
    {
        bj bj1;
        String s;
        String s1;
        bj1 = new bj();
        s = jsonobject.optString("title");
        s1 = jsonobject.optString("summary");
        jsonobject = new URL(jsonobject.optString("big_picture"));
        if (fetchBigImage(jsonobject) != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        Logger.error((new StringBuilder("Failed to create big picture style, unable to fetch image: ")).append(jsonobject).toString());
        return null;
        try
        {
            bj1.a(fetchBigImage(jsonobject));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Logger.error("Malformed big picture URL.", jsonobject);
            return null;
        }
        if (!UAStringUtil.isEmpty(s))
        {
            bj1.a(s);
        }
        if (!UAStringUtil.isEmpty(s1))
        {
            bj1.b(s1);
        }
        return bj1;
    }

    private bx createBigTextStyle(JSONObject jsonobject)
    {
        bk bk1 = new bk();
        String s = jsonobject.optString("title");
        String s1 = jsonobject.optString("summary");
        jsonobject = jsonobject.optString("big_text");
        if (!UAStringUtil.isEmpty(jsonobject))
        {
            bk1.c(jsonobject);
        }
        if (!UAStringUtil.isEmpty(s))
        {
            bk1.a(s);
        }
        if (!UAStringUtil.isEmpty(s1))
        {
            bk1.b(s1);
        }
        return bk1;
    }

    private bo createInboxStyle(JSONObject jsonobject)
    {
        bo bo1 = new bo();
        String s = jsonobject.optString("title");
        String s1 = jsonobject.optString("summary");
        jsonobject = jsonobject.optJSONArray("lines");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                String s2 = jsonobject.optString(i);
                if (s2 != null)
                {
                    bo1.c(s2);
                }
            }

        }
        if (!UAStringUtil.isEmpty(s))
        {
            bo1.a(s);
        }
        if (!UAStringUtil.isEmpty(s1))
        {
            bo1.b(s1);
        }
        return bo1;
    }

    private Notification createWearPage(JSONObject jsonobject)
    {
        bk bk1 = new bk();
        String s = jsonobject.optString("title");
        if (!UAStringUtil.isEmpty(s))
        {
            bk1.a(s);
        }
        jsonobject = jsonobject.optString("alert");
        if (!UAStringUtil.isEmpty(jsonobject))
        {
            bk1.c(jsonobject);
        }
        return (new bl(context)).a(true).a(bk1).a();
    }

    private Bitmap fetchBigImage(URL url)
    {
        if (url == null)
        {
            return null;
        } else
        {
            Logger.info((new StringBuilder("Fetching notification image at URL: ")).append(url).toString());
            WindowManager windowmanager = (WindowManager)context.getSystemService("window");
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            int i = (int)((double)Math.max(displaymetrics.widthPixels, displaymetrics.heightPixels) * 0.75D);
            int j = (int)TypedValue.applyDimension(1, 240F, displaymetrics);
            return BitmapUtils.fetchScaledBitmap(context, url, i, j);
        }
    }

    public abstract Notification createNotification(PushMessage pushmessage, int i);

    protected final bn createNotificationActionsExtender(PushMessage pushmessage, int i)
    {
        NotificationActionButtonGroup notificationactionbuttongroup = UAirship.shared().getPushManager().getNotificationActionGroup(pushmessage.getInteractiveNotificationType());
        final ArrayList androidActions = new ArrayList();
        if (notificationactionbuttongroup != null)
        {
            androidActions.addAll(notificationactionbuttongroup.createAndroidActions(getContext(), pushmessage, i, pushmessage.getInteractiveActionsPayload()));
        }
        return new _cls1();
    }

    protected final bx createNotificationStyle(PushMessage pushmessage)
    {
        String s;
        byte byte0;
        pushmessage = pushmessage.getStylePayload();
        if (pushmessage == null)
        {
            return null;
        }
        try
        {
            pushmessage = new JSONObject(pushmessage);
        }
        // Misplaced declaration of an exception variable
        catch (PushMessage pushmessage)
        {
            Logger.error("Failed to parse notification style payload.", pushmessage);
            return null;
        }
        s = pushmessage.optString("type");
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 68
    //                   100344454: 128
    //                   735420684: 114
    //                   1129611455: 142;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_142;
_L5:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
            return createBigTextStyle(pushmessage);

        case 1: // '\001'
            return createInboxStyle(pushmessage);

        case 2: // '\002'
            return createBigPictureStyle(pushmessage);
        }
_L3:
        if (s.equals("big_text"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("inbox"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("big_picture"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    protected final Notification createPublicVersionNotification(PushMessage pushmessage, int i)
    {
        if (UAStringUtil.isEmpty(pushmessage.getPublicNotificationPayload()))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        pushmessage = new JSONObject(pushmessage.getPublicNotificationPayload());
        bl bl1 = (new bl(getContext())).a(pushmessage.optString("title")).b(pushmessage.optString("alert")).a(true).a(i);
        if (pushmessage.has("summary"))
        {
            bl1.c(pushmessage.optString("summary"));
        }
        pushmessage = bl1.a();
        return pushmessage;
        pushmessage;
        Logger.error("Failed to parse public notification.", pushmessage);
        return null;
    }

    protected final by createWearableExtender(PushMessage pushmessage, int i)
    {
        by by1 = new by();
        Object obj = pushmessage.getWearablePayload();
        if (obj == null)
        {
            return by1;
        }
        String s;
        Object obj1;
        try
        {
            obj = new JSONObject(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (PushMessage pushmessage)
        {
            Logger.error("Failed to parse wearable payload.", pushmessage);
            return by1;
        }
        obj1 = ((JSONObject) (obj)).optString("interactive_type");
        s = ((JSONObject) (obj)).optString("interactive_actions", pushmessage.getInteractiveActionsPayload());
        if (!UAStringUtil.isEmpty(((String) (obj1))))
        {
            obj1 = UAirship.shared().getPushManager().getNotificationActionGroup(((String) (obj1)));
            if (obj1 != null)
            {
                by1.a(((NotificationActionButtonGroup) (obj1)).createAndroidActions(getContext(), pushmessage, i, s));
            }
        }
        pushmessage = ((JSONObject) (obj)).optString("background_image");
        if (!UAStringUtil.isEmpty(pushmessage))
        {
            try
            {
                by1.a(fetchBigImage(new URL(pushmessage)));
            }
            // Misplaced declaration of an exception variable
            catch (PushMessage pushmessage)
            {
                Logger.error("Wearable background url is malformed.", pushmessage);
            }
        }
        pushmessage = ((JSONObject) (obj)).optJSONArray("extra_pages");
        if (pushmessage != null)
        {
            for (i = 0; i < pushmessage.length(); i++)
            {
                JSONObject jsonobject = pushmessage.optJSONObject(i);
                if (jsonobject != null)
                {
                    by1.a(createWearPage(jsonobject));
                }
            }

        }
        return by1;
    }

    public Context getContext()
    {
        return context;
    }

    public abstract int getNextId(PushMessage pushmessage);

    private class _cls1
        implements bn
    {

        final NotificationFactory this$0;
        final List val$androidActions;

        public bl extend(bl bl1)
        {
            for (Iterator iterator = androidActions.iterator(); iterator.hasNext(); bl1.a((bh)iterator.next())) { }
            return bl1;
        }

        _cls1()
        {
            this$0 = NotificationFactory.this;
            androidActions = list;
            super();
        }
    }

}
