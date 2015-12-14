// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.util.b;
import com.socialin.android.util.s;
import java.util.Arrays;
import java.util.Date;
import myobfuscated.cy.a;
import org.json.JSONArray;
import org.json.JSONObject;
import twitter4j.IDs;
import twitter4j.Relationship;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterOAuthActivity

public class TwitterSessionManager
{

    private static final String ANALYTICS_LAST_UPDATED_DATE_KEY = "twitter.anal.date";
    private static final String LOG_TAG = com/socialin/android/twitter/TwitterSessionManager.getName();
    private static SharedPreferences settings;
    private static Twitter twitter;
    private Context context;
    private Fragment fragment;

    public TwitterSessionManager(Context context1)
    {
        this(context1, null);
    }

    public TwitterSessionManager(Context context1, Fragment fragment1)
    {
        context = context1;
        fragment = fragment1;
        if (context1 != null)
        {
            settings = context1.getSharedPreferences("TwitterPrefs", 0);
        }
        initTwitterWithConfiguration(context1);
    }

    private void checkSession()
    {
        if (twitter == null)
        {
            initTwitterWithConfiguration(context);
            AccessToken accesstoken = loadAccessToken(context);
            if (isValidToken(accesstoken))
            {
                twitter.setOAuthAccessToken(accesstoken);
            }
        }
    }

    private static Runnable createRunnableObj(Context context1)
    {
        return new Runnable(context1) {

            private Context a;

            public final void run()
            {
                if (TwitterSessionManager.settings == null)
                {
                    TwitterSessionManager.settings = a.getSharedPreferences("TwitterPrefs", 0);
                }
                if (TwitterSessionManager.isUserAuthenticated())
                {
                    TwitterSessionManager.initTwitterWithConfiguration(a);
                    if (TwitterSessionManager.isValidTwitterInstance() && s.a(a))
                    {
                        myobfuscated.cy.a.a(a).edit().putLong("twitter.anal.date", (new Date()).getTime()).apply();
                        AnalyticUtils.getInstance(a).trackDeviceContactInfo("twitter", TwitterSessionManager.getAuthFriendIds());
                    }
                }
            }

            
            {
                a = context1;
                super();
            }
        };
    }

    public static void createTwitterWithNewConfiguration(String s, String s1)
    {
        Object obj = new ConfigurationBuilder();
        ((ConfigurationBuilder) (obj)).setOAuthConsumerKey("N3aQqOLTNqrDcwTRTmUBOg");
        ((ConfigurationBuilder) (obj)).setOAuthConsumerSecret("VSLR3p6DYYxS5l7LvAQmTfCtmDLfHwBUveKSbH9Bw");
        ((ConfigurationBuilder) (obj)).setOAuthAccessToken(s);
        ((ConfigurationBuilder) (obj)).setOAuthAccessTokenSecret(s1);
        obj = (new TwitterFactory(((ConfigurationBuilder) (obj)).build())).getInstance();
        twitter = ((Twitter) (obj));
        ((Twitter) (obj)).setOAuthAccessToken(new AccessToken(s, s1));
    }

    public static JSONArray getAuthFriendIds()
    {
        JSONArray jsonarray = new JSONArray();
        long al[];
        int j;
        User user = twitter.showUser(twitter.getId());
        al = twitter.getFriendsIDs(user.getId(), -1L).getIDs();
        (new StringBuilder("ids = ")).append(Arrays.toString(al));
        j = al.length;
        int i = 0;
_L2:
        long l;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        l = al[i];
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("identifier", String.valueOf(l));
        jsonarray.put(jsonobject);
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        d.b(LOG_TAG, "getFriendsIds", exception);
_L1:
        return jsonarray;
    }

    private String getErrorMessage(TwitterException twitterexception)
    {
        String s = "Something was wrong, please try again.";
        int i = twitterexception.getStatusCode();
        if (403 == i)
        {
            s = "Already friends or Never been friends.";
        } else
        {
            if (401 == i)
            {
                return "App Access Denied!";
            }
            if (400 == i)
            {
                return "Rate is limited! Please try a while later.";
            }
            if (502 == i || 503 == i || 504 == i)
            {
                return twitterexception.getErrorMessage();
            }
        }
        return s;
    }

    public static Twitter getTwitterInstance(Context context1)
    {
        initTwitterWithConfiguration(context1);
        return twitter;
    }

    private boolean hasRelationship(Twitter twitter1, String s)
    {
        boolean flag1 = false;
        boolean flag;
        boolean flag2;
        try
        {
            twitter1 = twitter1.showFriendship(twitter1.getScreenName(), s);
        }
        // Misplaced declaration of an exception variable
        catch (Twitter twitter1)
        {
            d.b(LOG_TAG, "existsFriendship", twitter1);
            return false;
        }
        flag = flag1;
        if (twitter1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        flag2 = twitter1.isSourceFollowingTarget();
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

    private static void initTwitterWithConfiguration(Context context1)
    {
        if (twitter == null)
        {
            context1 = loadAccessToken(context1);
            Object obj = new ConfigurationBuilder();
            ((ConfigurationBuilder) (obj)).setOAuthConsumerKey("N3aQqOLTNqrDcwTRTmUBOg");
            ((ConfigurationBuilder) (obj)).setOAuthConsumerSecret("VSLR3p6DYYxS5l7LvAQmTfCtmDLfHwBUveKSbH9Bw");
            if (context1 != null)
            {
                ((ConfigurationBuilder) (obj)).setOAuthAccessToken(context1.getToken());
                ((ConfigurationBuilder) (obj)).setOAuthAccessTokenSecret(context1.getTokenSecret());
            }
            obj = (new TwitterFactory(((ConfigurationBuilder) (obj)).build())).getInstance();
            twitter = ((Twitter) (obj));
            ((Twitter) (obj)).setOAuthAccessToken(context1);
        }
    }

    private static boolean isUserAuthenticated()
    {
        return SocialinV3.getInstance().getUserTwitterToken() != null && SocialinV3.getInstance().getUserTwitterSecret() != null || settings.getString("user_token", null) != null && settings.getString("user_secret", null) != null;
    }

    public static boolean isValidToken(AccessToken accesstoken)
    {
        return accesstoken != null && !TextUtils.isEmpty(accesstoken.getToken()) && !TextUtils.isEmpty(accesstoken.getTokenSecret());
    }

    public static boolean isValidTwitterInstance()
    {
        boolean flag;
        try
        {
            flag = isValidToken(twitter.getOAuthAccessToken());
        }
        catch (TwitterException twitterexception)
        {
            return false;
        }
        return flag;
    }

    public static AccessToken loadAccessToken(Context context1)
    {
        Object obj = null;
        String s = SocialinV3.getInstance().getUserTwitterToken();
        String s2 = SocialinV3.getInstance().getUserTwitterSecret();
        if (s != null && s2 != null)
        {
            context1 = new AccessToken(s, s2);
        } else
        {
            if (settings == null)
            {
                settings = context1.getSharedPreferences("TwitterPrefs", 0);
            }
            String s1 = settings.getString("user_token", null);
            String s3 = settings.getString("user_secret", null);
            context1 = obj;
            if (s1 != null)
            {
                context1 = obj;
                if (s3 != null)
                {
                    return new AccessToken(s1, s3);
                }
            }
        }
        return context1;
    }

    public static void resetTwitterInstance()
    {
        twitter = null;
    }

    public static void sendFriendsAnal(Context context1, boolean flag)
    {
label0:
        {
            com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
            if (SocialinV3.getInstance().getSettings().isContactSyncEnabled())
            {
                Long long1 = Long.valueOf(a.a(context1).getLong("twitter.anal.date", 0L));
                long l = (new Date()).getTime();
                if (long1.longValue() == 0L || Long.valueOf(l).longValue() - long1.longValue() > data.social.getIntervalInMillis())
                {
                    context1 = createRunnableObj(context1);
                    if (!flag)
                    {
                        break label0;
                    }
                    (new Thread(context1)).start();
                }
            }
            return;
        }
        context1.run();
    }

    public static String trimTweetMessage(String s, int i)
    {
        return trimTweetMessage(s, "#PicsArt", i);
    }

    public static String trimTweetMessage(String s, String s1, int i)
    {
        String s2;
        String s3;
        int j;
        if (TextUtils.isEmpty(s))
        {
            s = " ";
        }
        s3 = "";
        s2 = s3;
        j = i;
        if (!TextUtils.isEmpty(s1))
        {
            s2 = s3;
            j = i;
            if (!s.contains(s1))
            {
                s2 = (new StringBuilder(" ")).append(s1).toString();
                j = i - s1.length();
            }
        }
        s1 = s;
        if (s.length() > j)
        {
            s1 = (new StringBuilder()).append(s.substring(0, j - 3)).append("..").toString();
        }
        return (new StringBuilder()).append(s1).append(s2).toString();
    }

    public boolean checkTwitterSession()
    {
        return isUserAuthenticated();
    }

    public void clearTwitterSession()
    {
        try
        {
            myobfuscated.cy.d.a(context);
            if (settings == null)
            {
                settings = context.getSharedPreferences("TwitterPrefs", 0);
            }
            android.content.SharedPreferences.Editor editor = settings.edit();
            editor.clear();
            editor.apply();
            twitter = null;
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                b.a(context).a("Connected Twitter w/PicsArt", false);
            }
            return;
        }
        catch (Exception exception)
        {
            d.b(LOG_TAG, "clearTwitterSession", exception);
        }
    }

    public boolean existsFriendship(String s)
    {
        if (isUserAuthenticated())
        {
            checkSession();
            return hasRelationship(twitter, s);
        } else
        {
            return false;
        }
    }

    public String follow(String s)
    {
        try
        {
            checkSession();
            twitter.createFriendship(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d.b(LOG_TAG, "follow", s);
            return getErrorMessage(s);
        }
        return null;
    }

    public long[] getFriendsIds(String s)
    {
        long al[];
        al = null;
        if (!isUserAuthenticated())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        checkSession();
        al = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        al = String.valueOf(twitter.showUser(twitter.getId()).getId());
        al = twitter.getFriendsIDs(al, -1L).getIDs();
        return al;
        s;
        d.b(LOG_TAG, "getFriendsIds", s);
        return null;
    }

    public void startTwitterNewSession(int i, boolean flag)
    {
        Intent intent = new Intent(context, com/socialin/android/twitter/TwitterOAuthActivity);
        intent.putExtra("twitterMethod", "auth");
        intent.putExtra("is_return_user_info", flag);
        if (i > 0)
        {
            if (fragment == null)
            {
                ((Activity)context).startActivityForResult(intent, i);
                return;
            } else
            {
                fragment.startActivityForResult(intent, i);
                return;
            }
        }
        if (fragment == null)
        {
            context.startActivity(intent);
            return;
        } else
        {
            fragment.startActivity(intent);
            return;
        }
    }

    public String unFollow(String s)
    {
        try
        {
            checkSession();
            twitter.destroyFriendship(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d.b(LOG_TAG, "unFollow", s);
            return getErrorMessage(s);
        }
        return null;
    }




/*
    static SharedPreferences access$002(SharedPreferences sharedpreferences)
    {
        settings = sharedpreferences;
        return sharedpreferences;
    }

*/


}
