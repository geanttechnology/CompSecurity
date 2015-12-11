// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.facebook.messenger.MessengerThreadParams;
import com.facebook.messenger.MessengerUtils;
import com.facebook.messenger.ShareToMessengerParams;
import com.facebook.messenger.ShareToMessengerParamsBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class B4MService
{
    public static interface ReplyFriendsListener
    {

        public abstract void onReplyFriendsFailure(String s);

        public abstract void onReplyFriendsSuccess(String s);
    }


    protected static final String APP_LINKS_BUNDLE = "al_applink_data";
    private static final String APP_LINKS_BUNDLE_EXTRAS = "extras";
    public static final String B4M_PACKAGE_NAME = "com.bitstrips.bitmoji.messenger";
    public static final String FACEBOOK_MESSENGER_PACKAGE_NAME = "com.facebook.orca";
    private static final String FRIEND_AVATARS_ENDPOINT = "%simoji/friends.php?app_name=%s&friends=%s&bsauth_token=%s";
    public static final int REPLY_MODE = 1;
    public static final int SHARE_TO_MESSENGER_REQUEST_CODE = 1;
    public static final int STANDALONE_MODE = 0;
    private static final String TAG = "B4MService";
    private String FBSDK_GRAPH_API_HEADER;
    private String FBSDK_TARGET_PLATFORM_VERSION;
    FacebookService facebookService;
    protected ArrayList friendAvatarIds;
    protected List friendFacebookIds;
    private ArrayList listeners;
    protected int mode;
    PreferenceUtils preferenceUtils;
    RequestQueue requestQueue;
    protected HashMap templateToFriendAvatarHashMap;

    public B4MService(Context context)
    {
        FBSDK_GRAPH_API_HEADER = "";
        FBSDK_TARGET_PLATFORM_VERSION = "";
        ((InjectorApplication)context).inject(this);
        listeners = new ArrayList();
    }

    private void replyFriendsError(String s)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((ReplyFriendsListener)iterator.next()).onReplyFriendsFailure(s)) { }
    }

    private void replyFriendsSuccess(String s)
    {
        setReplyFriends(s);
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((ReplyFriendsListener)iterator.next()).onReplyFriendsSuccess(s)) { }
    }

    public void addReplyFriendListener(ReplyFriendsListener replyfriendslistener)
    {
        listeners.add(replyfriendslistener);
    }

    public void configureWithIntent(Intent intent)
    {
        resetReplyMode();
        for (Bundle bundle = intent.getBundleExtra("al_applink_data"); bundle == null || bundle.getBundle("extras") == null;)
        {
            return;
        }

        if ("android.intent.action.PICK".equals(intent.getAction()))
        {
            setMode(1);
        }
        friendFacebookIds = MessengerUtils.getMessengerThreadParamsForIntent(intent).participants;
    }

    public String getFriendAvatarId(String s)
    {
        if (friendAvatarIds == null || friendAvatarIds.size() == 0)
        {
            return null;
        }
        if (!templateToFriendAvatarHashMap.containsKey(s))
        {
            int i = (new Random()).nextInt(friendAvatarIds.size());
            templateToFriendAvatarHashMap.put(s, friendAvatarIds.get(i));
        }
        return (String)templateToFriendAvatarHashMap.get(s);
    }

    public void getReplyFriends(Activity activity)
    {
        String s = activity.getString(0x7f060017);
        String s1 = preferenceUtils.getString(0x7f06003a, "");
        if (friendFacebookIds == null || friendFacebookIds.size() == 0)
        {
            replyFriendsError("Friends with avatars not found");
            return;
        } else
        {
            String s2 = TextUtils.join(",", friendFacebookIds);
            activity = new StringRequest(0, String.format("%simoji/friends.php?app_name=%s&friends=%s&bsauth_token=%s", new Object[] {
                activity.getString(0x7f060038), s, s2, s1
            }), new com.android.volley.Response.Listener() {

                final B4MService this$0;

                public volatile void onResponse(Object obj)
                {
                    onResponse((String)obj);
                }

                public void onResponse(String s3)
                {
                    replyFriendsSuccess(s3);
                }

            
            {
                this$0 = B4MService.this;
                super();
            }
            }, new com.android.volley.Response.ErrorListener() {

                final B4MService this$0;

                public void onErrorResponse(VolleyError volleyerror)
                {
                    replyFriendsError(volleyerror.toString());
                }

            
            {
                this$0 = B4MService.this;
                super();
            }
            }) {

                final B4MService this$0;

                public Map getHeaders()
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put(FBSDK_GRAPH_API_HEADER, FBSDK_TARGET_PLATFORM_VERSION);
                    return hashmap;
                }

            
            {
                this$0 = B4MService.this;
                super(i, s, listener, errorlistener);
            }
            };
            requestQueue.add(activity);
            return;
        }
    }

    protected String getStringifiedJsonForMetaData(String s)
    {
        JSONObject jsonobject = new JSONObject();
        String s1 = preferenceUtils.getString(0x7f06002a, "");
        try
        {
            jsonobject.put("template_id", s);
            jsonobject.put("avatar_id", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return jsonobject.toString();
    }

    public boolean isReplyMode()
    {
        return mode == 1;
    }

    public boolean isReplyWithFriends()
    {
        return friendAvatarIds != null && friendAvatarIds.size() > 0;
    }

    public boolean isStandaloneMode()
    {
        return mode == 0;
    }

    public void removeReplyListener(ReplyFriendsListener replyfriendslistener)
    {
        listeners.remove(replyfriendslistener);
    }

    public void resetReplyMode()
    {
        friendFacebookIds = new ArrayList();
        friendAvatarIds = new ArrayList();
        templateToFriendAvatarHashMap = new HashMap();
        setMode(0);
    }

    public void setGraphAPIVersionData(String s, String s1)
    {
        FBSDK_GRAPH_API_HEADER = s;
        FBSDK_TARGET_PLATFORM_VERSION = s1;
    }

    public void setMode(int i)
    {
        mode = i;
    }

    public void setReplyFriends(String s)
    {
        try
        {
            s = new JSONObject(s);
            for (Iterator iterator = s.keys(); iterator.hasNext(); friendAvatarIds.add(s.getString((String)iterator.next()))) { }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void shareToFacebookMessenger(Activity activity, Uri uri, String s)
    {
        s = getStringifiedJsonForMetaData(s);
        uri = ShareToMessengerParams.newBuilder(uri, "image/png").setMetaData(s).build();
        if (isReplyMode())
        {
            MessengerUtils.finishShareToMessenger(activity, uri);
            activity.finish();
            return;
        } else
        {
            MessengerUtils.shareToMessenger(activity, 1, uri);
            return;
        }
    }




}
