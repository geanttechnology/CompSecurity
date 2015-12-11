// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package net.hockeyapp.android:
//            Constants, FeedbackManagerListener, FeedbackActivity

public class FeedbackManager
{

    private static String identifier = null;
    private static FeedbackManagerListener lastListener = null;
    private static String urlString = null;

    public FeedbackManager()
    {
    }

    public static FeedbackManagerListener getLastListener()
    {
        return lastListener;
    }

    private static String getURLString(Context context)
    {
        return (new StringBuilder()).append(urlString).append("api/2/apps/").append(identifier).append("/feedback/").toString();
    }

    public static void register(Context context, String s)
    {
        register(context, s, null);
    }

    public static void register(Context context, String s, String s1, FeedbackManagerListener feedbackmanagerlistener)
    {
        if (context != null)
        {
            identifier = s1;
            urlString = s;
            lastListener = feedbackmanagerlistener;
            Constants.loadFromContext(context);
        }
    }

    public static void register(Context context, String s, FeedbackManagerListener feedbackmanagerlistener)
    {
        register(context, "https://sdk.hockeyapp.net/", s, feedbackmanagerlistener);
    }

    public static void showFeedbackActivity(Context context)
    {
        if (context != null)
        {
            Object obj = null;
            if (lastListener != null)
            {
                obj = lastListener.getFeedbackActivityClass();
            }
            Object obj1 = obj;
            if (obj == null)
            {
                obj1 = net/hockeyapp/android/FeedbackActivity;
            }
            obj = new Intent();
            ((Intent) (obj)).setClass(context, ((Class) (obj1)));
            ((Intent) (obj)).putExtra("url", getURLString(context));
            context.startActivity(((Intent) (obj)));
        }
    }

    public static void unregister()
    {
        lastListener = null;
    }

}
