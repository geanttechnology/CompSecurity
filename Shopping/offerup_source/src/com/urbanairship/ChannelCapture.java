// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.bh;
import android.support.v4.app.bl;
import android.support.v4.app.ch;
import android.support.v4.b.h;
import android.util.Base64;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushManager;
import com.urbanairship.util.UAStringUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.urbanairship:
//            BaseManager, Logger, CoreReceiver, CoreActivity, 
//            AirshipConfigOptions

class ChannelCapture extends BaseManager
{

    static final String ACTION_CHANNEL_CAPTURE = "com.urbanairship.ACTION_CHANNEL_CAPTURE";
    private static final String CHANNEL_PLACEHOLDER = "CHANNEL";
    static final String EXTRA_ACTIONS = "com.urbanairship.EXTRA_ACTIONS";
    static final String EXTRA_NOTIFICATION_ID = "com.urbanairship.EXTRA_NOTIFICATION_ID";
    private static final String GO_URL = "https://go.urbanairship.com/";
    private static final int NOTIFICATION_ID = 3000;
    private final BroadcastReceiver broadcastReceiver;
    private Clipboard clipboard;
    private final AirshipConfigOptions configOptions;
    private final Context context;
    Executor executor;
    private final ch notificationManager;
    private final PushManager pushManager;

    ChannelCapture(Context context1, AirshipConfigOptions airshipconfigoptions, PushManager pushmanager)
    {
        this(context1, airshipconfigoptions, pushmanager, ch.a(context1));
    }

    ChannelCapture(Context context1, AirshipConfigOptions airshipconfigoptions, PushManager pushmanager, ch ch1)
    {
        executor = Executors.newSingleThreadExecutor();
        context = context1.getApplicationContext();
        configOptions = airshipconfigoptions;
        pushManager = pushmanager;
        notificationManager = ch1;
        broadcastReceiver = new _cls1();
    }

    private String base64Decode(String s)
    {
        if (UAStringUtil.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = new String(Base64.decode(s, 0), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.verbose("ClipBoardMagic - Unsupported encoding.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.verbose("ClipBoardMagic - Failed to decode string.");
            return null;
        }
        return s;
    }

    private void checkClipboard()
    {
        String s1 = pushManager.getChannelId();
        if (!UAStringUtil.isEmpty(s1))
        {
            String s2 = base64Decode(clipboard.getText());
            String s3 = generateToken();
            if (!UAStringUtil.isEmpty(s2) && s2.startsWith(s3))
            {
                String s = null;
                if (s2.length() > s3.length())
                {
                    s = s2.replace(s3, "https://go.urbanairship.com/").replace("CHANNEL", s1).trim();
                }
                clipboard.clear();
                displayNotification(s1, s);
                return;
            }
        }
    }

    private PendingIntent createCopyChannelPendingIntent(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("text", s);
        hashmap.put("label", "Urban Airship Channel");
        s = new HashMap();
        s.put("clipboard_action", hashmap);
        s = (new Intent(context, com/urbanairship/CoreReceiver)).setAction("com.urbanairship.ACTION_CHANNEL_CAPTURE").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", 3000).putExtra("com.urbanairship.EXTRA_ACTIONS", JsonValue.wrap(s, null).toString());
        return PendingIntent.getBroadcast(context, 3000, s, 0);
    }

    private PendingIntent createOpenUrlPendingIntent(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("open_external_url_action", s);
        s = (new Intent(context, com/urbanairship/CoreActivity)).setAction("com.urbanairship.ACTION_CHANNEL_CAPTURE").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", 3000).putExtra("com.urbanairship.EXTRA_ACTIONS", JsonValue.wrap(hashmap, null).toString());
        return PendingIntent.getActivity(context, 3000, s, 0);
    }

    private void displayNotification(String s, String s1)
    {
        PendingIntent pendingintent = createCopyChannelPendingIntent(s);
        Object obj;
        if (s1 == null)
        {
            s1 = null;
        } else
        {
            s1 = createOpenUrlPendingIntent(s1);
        }
        obj = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        obj = (new bl(context)).a(true).b(true).a(((CharSequence) (obj))).b(s).a(R.drawable.ic_urbanairship_notification).d(context.getResources().getColor(R.color.urban_airship_blue)).b(-1).c(2).d(context.getString(R.string.ua_channel_notification_ticker));
        if (s1 == null)
        {
            s = pendingintent;
        } else
        {
            s = s1;
        }
        s = ((bl) (obj)).a(s).a(new bh(R.drawable.ic_notification_button_copy, context.getString(R.string.ua_notification_button_copy), pendingintent));
        if (s1 != null)
        {
            s.a(new bh(R.drawable.ic_notification_button_open_browser, context.getString(R.string.ua_notification_button_save), s1));
        }
        notificationManager.a(3000, s.a());
    }

    private String generateToken()
    {
        byte abyte0[] = configOptions.getAppKey().getBytes();
        byte abyte1[] = configOptions.getAppSecret().getBytes();
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(String.format("%02x", new Object[] {
                Byte.valueOf((byte)(abyte0[i] ^ abyte1[i % abyte1.length]))
            }));
        }

        return stringbuilder.toString();
    }

    protected void init()
    {
        if (!configOptions.channelCaptureEnabled)
        {
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new _cls2());
            return;
        }
    }

    protected void tearDown()
    {
        h.a(context).a(broadcastReceiver);
    }



/*
    static Clipboard access$102(ChannelCapture channelcapture, Clipboard clipboard1)
    {
        channelcapture.clipboard = clipboard1;
        return clipboard1;
    }

*/



    private class _cls1 extends BroadcastReceiver
    {

        final ChannelCapture this$0;

        public void onReceive(Context context1, Intent intent)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;

                public void run()
                {
                    checkClipboard();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            executor.execute(new _cls1());
        }

        _cls1()
        {
            this$0 = ChannelCapture.this;
            super();
        }
    }


    private class Clipboard
    {

        public abstract void clear();

        public abstract String getText();
    }


    private class _cls2
        implements Runnable
    {

        final ChannelCapture this$0;

        public void run()
        {
            ChannelCapture channelcapture = ChannelCapture.this;
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                obj = new ClipboardHoneyComb();
            } else
            {
                obj = new ClipboardFroyo();
            }
            channelcapture.clipboard = ((Clipboard) (obj));
            obj = new IntentFilter();
            ((IntentFilter) (obj)).addAction("com.urbanairship.analytics.APP_FOREGROUND");
            h.a(context).a(broadcastReceiver, ((IntentFilter) (obj)));
        }

        _cls2()
        {
            this$0 = ChannelCapture.this;
            super();
        }

        private class ClipboardHoneyComb
            implements Clipboard
        {

            private final ClipboardManager clipboardManager;
            final ChannelCapture this$0;

            public void clear()
            {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            }

            public String getText()
            {
                ClipData clipdata = clipboardManager.getPrimaryClip();
                if (clipdata != null && clipdata.getItemCount() > 0)
                {
                    for (int i = 0; i < clipdata.getItemCount(); i++)
                    {
                        CharSequence charsequence = clipdata.getItemAt(i).getText();
                        if (charsequence != null)
                        {
                            return charsequence.toString();
                        }
                    }

                }
                return null;
            }

            ClipboardHoneyComb()
            {
                this$0 = ChannelCapture.this;
                super();
                clipboardManager = (ClipboardManager)context.getSystemService("clipboard");
            }
        }


        private class ClipboardFroyo
            implements Clipboard
        {

            private final android.text.ClipboardManager clipboardManager;
            final ChannelCapture this$0;

            public void clear()
            {
                clipboardManager.setText("");
            }

            public String getText()
            {
                return String.valueOf(clipboardManager.getText());
            }

            ClipboardFroyo()
            {
                this$0 = ChannelCapture.this;
                super();
                clipboardManager = (android.text.ClipboardManager)context.getSystemService("clipboard");
            }
        }

    }

}
