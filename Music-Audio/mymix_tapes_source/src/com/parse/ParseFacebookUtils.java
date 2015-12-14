// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bolts.Task;
import com.facebook.Session;
import com.facebook.android.Facebook;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider, ManifestInfo, Parse, ParseUser, 
//            ParseException, SaveCallback, LogInCallback

public final class ParseFacebookUtils
{
    public static final class Permissions
    {

        private Permissions()
        {
        }
    }

    public static final class Permissions.Extended
    {

        public static final String ADS_MANAGEMENT = "ads_management";
        public static final String CREATE_EVENT = "create_event";
        public static final String MANAGE_FRIEND_LISTS = "manage_friendlists";
        public static final String MANAGE_NOTIFICATIONS = "manage_notifications";
        public static final String OFFLINE_ACCESS = "offline_access";
        public static final String PUBLISH_ACTIONS = "publish_actions";
        public static final String PUBLISH_CHECKINS = "publish_checkins";
        public static final String PUBLISH_STREAM = "publish_stream";
        public static final String READ_FRIEND_LISTS = "read_friendlists";
        public static final String READ_INSIGHTS = "read_insights";
        public static final String READ_MAILBOX = "read_mailbox";
        public static final String READ_REQUESTS = "read_requests";
        public static final String READ_STREAM = "read_stream";
        public static final String RSVP_EVENT = "rsvp_event";
        public static final String XMPP_LOGIN = "xmpp_login";

        private Permissions.Extended()
        {
        }
    }

    public static final class Permissions.Friends
    {

        public static final String ABOUT_ME = "friends_about_me";
        public static final String ACTIVITIES = "friends_activities";
        public static final String BIRTHDAY = "friends_birthday";
        public static final String CHECKINS = "friends_checkins";
        public static final String EDUCATION_HISTORY = "friends_education_history";
        public static final String EVENTS = "friends_events";
        public static final String GROUPS = "friends_groups";
        public static final String HOMETOWN = "friends_hometown";
        public static final String INTERESTS = "friends_interests";
        public static final String LIKES = "friends_likes";
        public static final String LOCATION = "friends_location";
        public static final String NOTES = "friends_notes";
        public static final String ONLINE_PRESENCE = "friends_online_presence";
        public static final String PHOTOS = "friends_photos";
        public static final String QUESTIONS = "friends_questions";
        public static final String RELATIONSHIPS = "friends_relationships";
        public static final String RELATIONSHIP_DETAILS = "friends_relationship_details";
        public static final String RELIGION_POLITICS = "friends_religion_politics";
        public static final String STATUS = "friends_status";
        public static final String VIDEOS = "friends_videos";
        public static final String WEBSITE = "friends_website";
        public static final String WORK_HISTORY = "friends_work_history";

        private Permissions.Friends()
        {
        }
    }

    public static final class Permissions.Page
    {

        public static final String MANAGE_PAGES = "manage_pages";

        private Permissions.Page()
        {
        }
    }

    public static final class Permissions.User
    {

        public static final String ABOUT_ME = "user_about_me";
        public static final String ACTIVITIES = "user_activities";
        public static final String BIRTHDAY = "user_birthday";
        public static final String CHECKINS = "user_checkins";
        public static final String EDUCATION_HISTORY = "user_education_history";
        public static final String EMAIL = "email";
        public static final String EVENTS = "user_events";
        public static final String GROUPS = "user_groups";
        public static final String HOMETOWN = "user_hometown";
        public static final String INTERESTS = "user_interests";
        public static final String LIKES = "user_likes";
        public static final String LOCATION = "user_location";
        public static final String NOTES = "user_notes";
        public static final String ONLINE_PRESENCE = "user_online_presence";
        public static final String PHOTOS = "user_photos";
        public static final String QUESTIONS = "user_questions";
        public static final String RELATIONSHIPS = "user_relationships";
        public static final String RELATIONSHIP_DETAILS = "user_relationship_details";
        public static final String RELIGION_POLITICS = "user_religion_politics";
        public static final String STATUS = "user_status";
        public static final String VIDEOS = "user_videos";
        public static final String WEBSITE = "user_website";
        public static final String WORK_HISTORY = "user_work_history";

        private Permissions.User()
        {
        }
    }


    private static boolean isInitialized;
    protected static FacebookAuthenticationProvider provider;

    private ParseFacebookUtils()
    {
    }

    private static void checkInitialization()
    {
        if (!isInitialized)
        {
            initialize();
        }
    }

    public static void extendAccessToken(ParseUser parseuser, Context context, SaveCallback savecallback)
    {
        checkInitialization();
        provider.extendAccessToken(context, new ParseAuthenticationProvider.ParseAuthenticationCallback(parseuser, savecallback) {

            final SaveCallback val$callback;
            final ParseUser val$user;

            public void onCancel()
            {
                if (callback != null)
                {
                    callback.internalDone(null, null);
                }
            }

            public void onError(Throwable throwable)
            {
                if (callback != null)
                {
                    callback.internalDone(null, new ParseException(throwable));
                }
            }

            public void onSuccess(JSONObject jsonobject)
            {
                Parse.callbackOnMainThreadAsync(user.linkWithAsync(ParseFacebookUtils.provider.getAuthType(), jsonobject), callback, true);
            }

            
            {
                user = parseuser;
                callback = savecallback;
                super();
            }
        });
    }

    public static boolean extendAccessTokenIfNeeded(ParseUser parseuser, Context context, SaveCallback savecallback)
    {
        if (shouldExtendAccessToken(parseuser))
        {
            extendAccessToken(parseuser, context, savecallback);
            return true;
        } else
        {
            return false;
        }
    }

    public static void finishAuthentication(int i, int j, Intent intent)
    {
        if (provider != null)
        {
            provider.onActivityResult(i, j, intent);
        }
    }

    public static Facebook getFacebook()
    {
        if (provider == null)
        {
            throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getFacebook()");
        } else
        {
            return provider.getFacebook();
        }
    }

    public static Session getSession()
    {
        if (provider == null)
        {
            throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getSession()");
        } else
        {
            return provider.getSession();
        }
    }

    static void initialize()
    {
        String s = null;
        Bundle bundle = ManifestInfo.getApplicationMetadata();
        if (bundle != null)
        {
            s = bundle.getString("com.facebook.sdk.ApplicationId");
        }
        initialize(s);
    }

    public static void initialize(String s)
    {
        if (Parse.applicationContext == null)
        {
            throw new IllegalStateException("You must call Parse.initialize() before using ParseFacebookUtils");
        } else
        {
            provider = new FacebookAuthenticationProvider(Parse.applicationContext, s);
            ParseUser.registerAuthenticationProvider(provider);
            isInitialized = true;
            return;
        }
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.getLinkedServiceNames().contains("facebook");
    }

    public static void link(ParseUser parseuser, Activity activity)
    {
        linkInBackground(parseuser, activity);
    }

    public static void link(ParseUser parseuser, Activity activity, int i)
    {
        linkInBackground(parseuser, activity, i);
    }

    public static void link(ParseUser parseuser, Activity activity, int i, SaveCallback savecallback)
    {
        link(parseuser, ((Collection) (Collections.emptyList())), activity, i, savecallback);
    }

    public static void link(ParseUser parseuser, Activity activity, SaveCallback savecallback)
    {
        link(parseuser, ((Collection) (Collections.emptyList())), activity, 32665, savecallback);
    }

    public static void link(ParseUser parseuser, String s, String s1, Date date)
    {
        linkInBackground(parseuser, s, s1, date);
    }

    public static void link(ParseUser parseuser, String s, String s1, Date date, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(linkInBackground(parseuser, s, s1, date), savecallback);
    }

    public static void link(ParseUser parseuser, Collection collection, Activity activity)
    {
        linkInBackground(parseuser, collection, activity);
    }

    public static void link(ParseUser parseuser, Collection collection, Activity activity, int i)
    {
        linkInBackground(parseuser, collection, activity, i);
    }

    public static void link(ParseUser parseuser, Collection collection, Activity activity, int i, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(linkInBackground(parseuser, collection, activity, i), savecallback, true);
    }

    public static void link(ParseUser parseuser, Collection collection, Activity activity, SaveCallback savecallback)
    {
        link(parseuser, collection, activity, 32665, savecallback);
    }

    public static Task linkInBackground(ParseUser parseuser, Activity activity)
    {
        return linkInBackground(parseuser, ((Collection) (Collections.emptyList())), activity, 32665);
    }

    public static Task linkInBackground(ParseUser parseuser, Activity activity, int i)
    {
        return linkInBackground(parseuser, ((Collection) (Collections.emptyList())), activity, i);
    }

    public static Task linkInBackground(ParseUser parseuser, String s, String s1, Date date)
    {
        checkInitialization();
        try
        {
            parseuser = parseuser.linkWithAsync(provider.getAuthType(), provider.getAuthData(s, s1, date));
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            return Task.forError(new ParseException(parseuser));
        }
        return parseuser;
    }

    public static Task linkInBackground(ParseUser parseuser, Collection collection, Activity activity)
    {
        return linkInBackground(parseuser, collection, activity, 32665);
    }

    public static Task linkInBackground(ParseUser parseuser, Collection collection, Activity activity, int i)
    {
        checkInitialization();
        provider.setActivity(activity);
        provider.setActivityCode(i);
        activity = collection;
        if (collection == null)
        {
            activity = Collections.emptyList();
        }
        provider.setPermissions(activity);
        return parseuser.linkWithAsync(provider.getAuthType());
    }

    public static void logIn(Activity activity, int i, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(Collections.emptyList(), activity, i), logincallback, true);
    }

    public static void logIn(Activity activity, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(Collections.emptyList(), activity, 32665), logincallback, true);
    }

    public static void logIn(String s, String s1, Date date, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(s, s1, date), logincallback);
    }

    public static void logIn(Collection collection, Activity activity, int i, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(collection, activity, i), logincallback, true);
    }

    public static void logIn(Collection collection, Activity activity, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(collection, activity, 32665), logincallback, true);
    }

    public static Task logInInBackground(String s, String s1, Date date)
    {
        checkInitialization();
        try
        {
            s = ParseUser.logInWithAsync(provider.getAuthType(), provider.getAuthData(s, s1, date));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return Task.forError(new ParseException(s));
        }
        return s;
    }

    public static Task logInInBackground(Collection collection, Activity activity, int i)
    {
        checkInitialization();
        provider.setActivity(activity);
        provider.setActivityCode(i);
        activity = collection;
        if (collection == null)
        {
            activity = Collections.emptyList();
        }
        provider.setPermissions(activity);
        return ParseUser.logInWithAsync(provider.getAuthType());
    }

    public static void saveLatestSessionData(ParseUser parseuser)
    {
        saveLatestSessionDataInBackground(parseuser);
    }

    public static void saveLatestSessionData(ParseUser parseuser, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(saveLatestSessionDataInBackground(parseuser), savecallback);
    }

    public static Task saveLatestSessionDataInBackground(ParseUser parseuser)
    {
        checkInitialization();
        if (!isLinked(parseuser))
        {
            throw new IllegalStateException("The user must already be linked to Facebook.");
        } else
        {
            Session session = getSession();
            return linkInBackground(parseuser, provider.getUserId(), session.getAccessToken(), session.getExpirationDate());
        }
    }

    public static boolean shouldExtendAccessToken(ParseUser parseuser)
    {
        return parseuser != null && isLinked(parseuser) && getFacebook().shouldExtendAccessToken();
    }

    public static void unlink(ParseUser parseuser)
        throws ParseException
    {
        Parse.waitForTask(unlinkInBackground(parseuser));
    }

    public static Task unlinkInBackground(ParseUser parseuser)
    {
        checkInitialization();
        return parseuser.unlinkFromAsync("facebook");
    }

    public static void unlinkInBackground(ParseUser parseuser, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(unlinkInBackground(parseuser), savecallback);
    }
}
