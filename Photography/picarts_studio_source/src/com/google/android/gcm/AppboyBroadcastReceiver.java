// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.appboy.Constants;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.photo.picsinphoto.MainPagerActivity;
import myobfuscated.f.m;

public class AppboyBroadcastReceiver extends BroadcastReceiver
{

    public static final String DESTINATION_VIEW = "destination";
    public static final String FEED = "feed";
    public static final String FEEDBACK = "feedback";
    public static final String HOME = "home";
    public static final String SOURCE_KEY = "source";
    private static final String TAG;

    public AppboyBroadcastReceiver()
    {
    }

    private Bundle getPushExtrasBundle(Intent intent)
    {
        Bundle bundle1 = intent.getBundleExtra("extra");
        Bundle bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("cid", intent.getStringExtra("cid"));
        bundle.putString("source", "Appboy");
        return bundle;
    }

    private String readDeepLink(Bundle bundle)
    {
label0:
        {
            String s = "";
            if (bundle != null)
            {
                if (!bundle.containsKey("deep_link"))
                {
                    break label0;
                }
                s = bundle.getString("deep_link");
            }
            return s;
        }
        return bundle.getString("uri");
    }

    private void startPicsArtWithIntent(Context context, Bundle bundle)
    {
        Intent intent = new Intent(context, com/socialin/android/photo/picsinphoto/MainPagerActivity);
        intent.setFlags(0x34000000);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    private void trackAppNotify(Intent intent, Context context)
    {
        String s1 = null;
        String s = s1;
        if (intent.getExtras() != null)
        {
            s = s1;
            if (intent.hasExtra("extra"))
            {
                s = intent.getExtras().getBundle("extra").getString("deep_link");
            }
        }
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = readDeepLink(getPushExtrasBundle(intent));
        }
        if (s1 != null)
        {
            if ("picsart://appinvite".equals(s1) || "picsart://appinvite_skip_redeem".equals(s1))
            {
                AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowNotifyEvent("ad_remover", s1));
            }
            AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.PushReceivedEvent(SocialinV3.getInstance().getUser().id, s1));
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        String s3;
        if (!SocialinV3.getInstance().getAppProps().isAppboyEnabled())
        {
            return;
        }
        String s2 = context.getPackageName();
        String s = (new StringBuilder()).append(s2).append(".intent.APPBOY_PUSH_RECEIVED").toString();
        s2 = (new StringBuilder()).append(s2).append(".intent.APPBOY_NOTIFICATION_OPENED").toString();
        s3 = intent.getAction();
        String.format("Received intent with action %s", new Object[] {
            s3
        });
        if (s.equals(s3))
        {
            try
            {
                trackAppNotify(intent, context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                d.b(TAG, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
            return;
        }
        if (!s2.equals(s3))
        {
            break MISSING_BLOCK_LABEL_255;
        }
        try
        {
            AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.PushClickedEvent(SocialinV3.getInstance().getUser().id));
            intent = getPushExtrasBundle(intent);
            String s1 = readDeepLink(intent);
            if (!m.a(s1))
            {
                context.startActivity((new Intent("android.intent.action.VIEW", Uri.parse(s1))).putExtras(intent).setFlags(0x10000000));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            return;
        }
        startPicsArtWithIntent(context, intent);
        return;
        String.format("Ignoring intent with unsupported action %s", new Object[] {
            s3
        });
        return;
    }

    static 
    {
        TAG = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, com/google/android/gcm/AppboyBroadcastReceiver.getName()
        });
    }
}
