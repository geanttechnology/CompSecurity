// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.ShareDialog;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.activity.ActivityResultListener;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.FbConnection;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.b;
import com.socialin.android.d;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.activity.FacebookAdapterActivity;
import com.socialin.android.facebook.l;
import com.socialin.android.facebook.p;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUtils
    implements b
{

    private static final String ANALYTICS_LAST_UPDATED_DATE_KEY = "facebook.anal.date";
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private static final String FRAGMENT_PROGRESS_DIALOG_TAG = "fragmentProgressDialog";
    private static final String KEY_VIDEO_POST = "videoPost";
    private static final int MAX_TAGS_PER_ACTION = 10;
    private static com.facebook.GraphRequest.Callback OGPostCallback = new com.facebook.GraphRequest.Callback() {

        public final void onCompleted(GraphResponse graphresponse)
        {
            FacebookUtils.onPostActionResponse(graphresponse);
        }

    };
    public static boolean SSO_CHECK_MODE = false;
    private static final String TAG = com/socialin/android/facebook/util/FacebookUtils.getSimpleName();
    private static String cacheFolderPath = null;
    private static CallbackManager callbackManager;
    private static int textSize = 11;
    private static l user;

    public FacebookUtils()
    {
    }

    public static void approveFriendInfoAction(Activity activity, CallbackManager callbackmanager, p p1)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, p1, new String[] {
            "user_friends"
        });
    }

    public static void approvePostAction(Activity activity, CallbackManager callbackmanager, p p1)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, p1, new String[] {
            "publish_actions"
        });
    }

    public static boolean canIPost()
    {
        return AccessToken.getCurrentAccessToken() != null && AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
    }

    public static void checkAndPostStoryWithProfile(Activity activity, String s1, String s2)
    {
        FacebookSdk.sdkInitialize(activity, new com.facebook.FacebookSdk.InitializeCallback(activity, s1, s2) {

            private Activity a;
            private String b;
            private String c;

            public final void onInitialized()
            {
                if (s.a(a) && FacebookUtils.canIPost() && FacebookUtils.isUserConnected()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                String s3;
                Bundle bundle;
                SharedPreferences sharedpreferences;
                bundle = new Bundle();
                s3 = "";
                sharedpreferences = a.getSharedPreferences((new StringBuilder("sinPref_")).append(a.getString(m.e(a, "app_name_short"))).toString(), 0);
                if (!"og.follows".equals(b))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_follow", true))
                {
                    continue; /* Loop/switch isn't completed */
                }
                s3 = (new StringBuilder("me/")).append(b).toString();
                break; /* Loop/switch isn't completed */
                if (true) goto _L1; else goto _L3
_L3:
                if (sharedpreferences != null && sharedpreferences.getBoolean("enable_fb_explicit", false))
                {
                    bundle.putString("fb:explicitly_shared", "true");
                }
                bundle.putString("profile", c);
                FacebookUtils.postStoryFollowProfile(bundle, s3);
                return;
            }

            
            {
                a = activity;
                b = s1;
                c = s2;
                super();
            }
        });
    }

    public static void checkAndSendPhotoAction(Activity activity, String s1, String s2)
    {
        FacebookSdk.sdkInitialize(activity, new com.facebook.FacebookSdk.InitializeCallback(activity, s1, s2) {

            private Activity a;
            private String b;
            private String c;

            public final void onInitialized()
            {
                if (s.a(a) || FacebookUtils.isSessionValid()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                String s3;
                Bundle bundle;
                SharedPreferences sharedpreferences;
                String s4;
                byte byte0;
                bundle = new Bundle();
                s3 = (new StringBuilder("me/picsartphotostudio:")).append(b).toString();
                sharedpreferences = a.getSharedPreferences((new StringBuilder("sinPref_")).append(a.getString(m.e(a, "app_name_short"))).toString(), 0);
                s4 = b;
                byte0 = -1;
                s4.hashCode();
                JVM INSTR lookupswitch 4: default 140
            //                           -1478067162: 267
            //                           3321751: 219
            //                           3625706: 235
            //                           950398559: 251;
                   goto _L3 _L4 _L5 _L6 _L7
_L3:
                byte0;
                JVM INSTR tableswitch 0 3: default 172
            //                           0 283
            //                           1 312
            //                           2 341
            //                           3 370;
                   goto _L8 _L9 _L10 _L11 _L12
_L8:
                break MISSING_BLOCK_LABEL_172;
_L12:
                continue; /* Loop/switch isn't completed */
_L14:
                if (sharedpreferences != null && sharedpreferences.getBoolean("enable_fb_explicit", false))
                {
                    bundle.putString("fb:explicitly_shared", "true");
                }
                (new GraphRequest(AccessToken.getCurrentAccessToken(), s3, bundle, HttpMethod.POST, FacebookUtils.OGPostCallback)).executeAndWait();
                return;
_L5:
                if (s4.equals("like"))
                {
                    byte0 = 0;
                }
                  goto _L3
_L6:
                if (s4.equals("vote"))
                {
                    byte0 = 1;
                }
                  goto _L3
_L7:
                if (s4.equals("comment"))
                {
                    byte0 = 2;
                }
                  goto _L3
_L4:
                if (s4.equals("og.likes"))
                {
                    byte0 = 3;
                }
                  goto _L3
_L9:
                if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_like", true)) goto _L1; else goto _L13
_L13:
                bundle.putString("photo", c);
                  goto _L14
_L10:
                if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_vote", true)) goto _L1; else goto _L15
_L15:
                bundle.putString("photo", c);
                  goto _L14
_L11:
                if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_comment", true)) goto _L1; else goto _L16
_L16:
                bundle.putString("photo", c);
                  goto _L14
                if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_like", true)) goto _L1; else goto _L17
_L17:
                s3 = (new StringBuilder("me/")).append(b).toString();
                bundle.putString("object", c);
                  goto _L14
            }

            
            {
                a = activity;
                b = s1;
                c = s2;
                super();
            }
        });
    }

    private static void checkFacebookAppPresent(Activity activity)
    {
        boolean flag;
        try
        {
            flag = activity.getPackageManager().getPackageInfo("com.facebook.katana", 1).applicationInfo.enabled;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            flag = false;
        }
        setSSOMode(flag);
    }

    public static String checkForTagsCount(String s1)
    {
        String s2 = s1;
        if (!TextUtils.isEmpty(s1))
        {
            String as[] = s1.split(",");
            s2 = s1;
            if (as.length > 10)
            {
                s1 = "";
                int i = 0;
                do
                {
                    s2 = s1;
                    if (i >= 10)
                    {
                        break;
                    }
                    s2 = (new StringBuilder()).append(s1).append(as[i]).toString();
                    s1 = s2;
                    if (i < 9)
                    {
                        s1 = (new StringBuilder()).append(s2).append(",").toString();
                    }
                    i++;
                } while (true);
            }
        }
        return s2;
    }

    public static void clearPrefs()
    {
        getPrefs().edit().clear().apply();
    }

    public static void clearUserData()
    {
        user = null;
        getPrefs().edit().remove("fb.userdata").commit();
    }

    private static transient void confirmPermissionGrantProcedure(Activity activity, p p1, String as[])
    {
        if (!activity.isFinishing())
        {
            FragmentTransaction fragmenttransaction = activity.getFragmentManager().beginTransaction();
            Object obj = activity.getFragmentManager().findFragmentByTag("permission_grant");
            if (obj != null)
            {
                fragmenttransaction.remove(((Fragment) (obj)));
            }
            obj = (new com.socialin.android.dialog.b()).a(1, 0x7f0c0190);
            obj.b = activity.getResources().getString(0x7f080266);
            ((com.socialin.android.dialog.b) (obj)).a(new android.view.View.OnClickListener(activity, as, p1) {

                final p a;
                private Activity b;
                private String c[];

                public final void onClick(View view)
                {
                    FacebookUtils.loginFacebook(b, c, new p(this) {

                        private _cls5 a;

                        public final void a()
                        {
                            a.a.a();
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }

            
            {
                b = activity;
                c = as;
                a = p1;
                super();
            }
            }).a().show(fragmenttransaction, "permission_grant");
        }
    }

    public static void connectFacebook(Activity activity, CallbackManager callbackmanager, p p1)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, p1, a);
    }

    public static String createFacebookMessage(Context context, ImageItem imageitem, long l1, String s1)
    {
        long l2 = 0L;
        if (l1 > 0L)
        {
            String s2 = s1;
            if (TextUtils.isEmpty(s1))
            {
                s2 = (new StringBuilder("http://picsart.com/i/")).append(l1).toString();
            }
            l1 = l2;
            if (imageitem != null)
            {
                if (imageitem.user == null)
                {
                    l1 = l2;
                } else
                {
                    l1 = imageitem.user.id;
                }
            }
            if (SocialinV3.getInstance().getUser().id == l1)
            {
                if (imageitem != null)
                {
                    imageitem = imageitem.title;
                } else
                {
                    imageitem = "";
                }
                if (!TextUtils.isEmpty(imageitem))
                {
                    return (new StringBuilder()).append(imageitem).append("\n").toString();
                } else
                {
                    return (new StringBuilder()).append(context.getString(0x7f0805f3)).append(" #PicsArt").toString();
                }
            }
            if (imageitem == null || imageitem.user == null)
            {
                imageitem = "";
            } else
            {
                imageitem = (new StringBuilder("@")).append(imageitem.user.username).append("'s").toString();
            }
            imageitem = (new StringBuilder()).append(context.getString(0x7f080412, new Object[] {
                imageitem
            })).append(" ").append(context.getString(0x7f080437)).append(" ").append(context.getString(0x7f080413, new Object[] {
                "#PicsArt", s2
            })).toString();
            return (new StringBuilder()).append(imageitem).append("\n").append(context.getString(0x7f08046f)).toString();
        } else
        {
            return (new StringBuilder()).append(context.getString(0x7f0805f3)).append(" #PicsArt\n").append(s1).toString();
        }
    }

    public static void createTokenFromServer(Activity activity, CallbackManager callbackmanager, String s1, Date date, l l1, p p1)
    {
        callbackManager = callbackmanager;
        registerResultDelegate(activity);
        loginFacebook(activity, a, new p(l1, s1, date, p1) {

            private l a;
            private String b;
            private Date c;
            private p d;

            public final void a()
            {
                FacebookUtils.SSO_CHECK_MODE = false;
                if (FacebookUtils.user != null && FacebookUtils.user.a.equals(a.a))
                {
                    FacebookUtils.setSSOMode(true);
                    FacebookUtils.setConnectionState(true);
                } else
                {
                    FacebookUtils.setSSOMode(false);
                    FacebookUtils.setUserData(a);
                    FacebookUtils.newServerToken(b, c);
                }
                FacebookUtils.saveUserData();
                d.a();
            }

            
            {
                a = l1;
                b = s1;
                c = date;
                d = p1;
                super();
            }
        });
    }

    public static boolean directToFbDomain(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return false;
        }
        for (Iterator iterator = (new ArrayList(Arrays.asList(new String[] {
    "picsart.com", "stage.picsart.com", "picsart.app"
}))).iterator(); iterator.hasNext();)
        {
            String s2 = (String)iterator.next();
            if (s1.startsWith(s2, 7) || s1.startsWith(s2, 8))
            {
                return true;
            }
        }

        return false;
    }

    public static void dismissDialog(Activity activity)
    {
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        Object obj;
        try
        {
            if (activity.isFinishing())
            {
                break MISSING_BLOCK_LABEL_57;
            }
            obj = activity.getFragmentManager();
            activity = ((FragmentManager) (obj)).beginTransaction();
            obj = ((FragmentManager) (obj)).findFragmentByTag("fragmentProgressDialog");
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            d.a(TAG, "dismissDialog", activity);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (((Fragment) (obj)).isAdded() && !((Fragment) (obj)).isRemoving())
        {
            activity.remove(((Fragment) (obj)));
            activity.commitAllowingStateLoss();
        }
    }

    public static void evaluateFacebookErrorResponse(Activity activity, FacebookRequestError facebookrequesterror)
    {
        int i = facebookrequesterror.getErrorCode();
        if (i >= 200 && i <= 299)
        {
            Utils.a(activity, "permission error", 1);
            activity.finish();
        } else
        if (i == 102 || facebookrequesterror.getException() != null && facebookrequesterror.getException().getMessage().contains("OAuthException"))
        {
            Utils.a(activity, "access token expired", 1);
            logoutFacebook(false);
            activity.finish();
            return;
        }
    }

    private static void fetchUserInfo(AccessToken accesstoken, Activity activity, p p1, String as[])
    {
        g g1 = new g(activity);
        accesstoken = GraphRequest.newMeRequest(accesstoken, new com.facebook.GraphRequest.GraphJSONObjectCallback(activity, g1, p1, as) {

            private Activity a;
            private g b;
            private p c;
            private String d[];

            public final void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
            {
                DialogUtils.dismissDialog(a, b);
                FacebookUtils.user = new l(jsonobject);
                if (FacebookUtils.SSO_CHECK_MODE)
                {
                    c.a();
                    return;
                }
                FacebookUtils.saveUserData();
                if (!FacebookUtils.isUserConnected())
                {
                    FacebookUtils.showChooser(a, c, d);
                    return;
                } else
                {
                    c.a();
                    return;
                }
            }

            
            {
                a = activity;
                b = g1;
                c = p1;
                d = as;
                super();
            }
        });
        p1 = new Bundle();
        p1.putString("fields", c_);
        accesstoken.setParameters(p1);
        DialogUtils.showDialog(activity, g1);
        GraphRequest.executeBatchAsync(new GraphRequest[] {
            accesstoken
        });
    }

    public static void fetchUserPictureData(Activity activity, CallbackManager callbackmanager, p p1)
    {
        clearUserData();
        callbackManager = callbackmanager;
        flowDetection(activity, p1, a);
    }

    private static transient void flowDetection(Activity activity, p p1, String as[])
    {
        registerResultDelegate(activity);
        List list = Arrays.asList(as);
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        if (isUserConnected() && accesstoken != null)
        {
            user = getUserData();
            if (accesstoken.getPermissions().containsAll(list))
            {
                if (user == null)
                {
                    fetchUserInfo(accesstoken, activity, p1, as);
                    return;
                } else
                {
                    p1.a();
                    return;
                }
            } else
            {
                confirmPermissionGrantProcedure(activity, p1, as);
                return;
            }
        }
        if (accesstoken != null)
        {
            manageFacebookAccounts(activity, new p(list, p1, activity, as) {

                private List a;
                private p b;
                private Activity c;
                private String d[];

                public final void a()
                {
                    if (AccessToken.getCurrentAccessToken().getPermissions().containsAll(a))
                    {
                        b.a();
                        return;
                    } else
                    {
                        FacebookUtils.confirmPermissionGrantProcedure(c, b, d);
                        return;
                    }
                }

            
            {
                a = list;
                b = p1;
                c = activity;
                d = as;
                super();
            }
            }, as);
            return;
        } else
        {
            clearPrefs();
            loginFacebook(activity, as, p1);
            return;
        }
    }

    public static String getCacheFolderPath(Context context)
    {
        if (cacheFolderPath == null)
        {
            cacheFolderPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808c0)).append("/").append(context.getString(0x7f0808e5)).append("/").toString();
        }
        return cacheFolderPath;
    }

    public static void getFacebookFriends(Activity activity, CallbackManager callbackmanager, List list, p p1)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, new p(list, p1) {

            final List a;
            final p b;

            public final void a()
            {
                GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new com.facebook.GraphRequest.GraphJSONArrayCallback(this) {

                    private _cls9 a;

                    public final void onCompleted(JSONArray jsonarray, GraphResponse graphresponse)
                    {
                        int i;
                        if (graphresponse.getError() != null || jsonarray == null)
                        {
                            return;
                        }
                        i = 0;
_L2:
                        if (i >= jsonarray.length())
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        graphresponse = jsonarray.getJSONObject(i);
                        a.a.add(graphresponse.getString("id"));
                        i++;
                        if (true) goto _L2; else goto _L1
                        jsonarray;
                        d.b(FacebookUtils.TAG, "getFacebookFriends", jsonarray);
_L1:
                        a.b.a();
                        return;
                    }

            
            {
                a = _pcls9;
                super();
            }
                }).executeAsync();
            }

            
            {
                a = list;
                b = p1;
                super();
            }
        }, new String[] {
            "email", "user_friends"
        });
    }

    public static FbConnection getFbConnectionData()
    {
        FbConnection fbconnection1 = new FbConnection();
        if (getUserData() != null) goto _L2; else goto _L1
_L1:
        FbConnection fbconnection = null;
_L4:
        return fbconnection;
_L2:
        fbconnection1.data.id = user.a;
        fbconnection1.data.screenName = user.d;
        fbconnection1.data.profileUrl = user.c;
        fbconnection1.data.email = user.b;
        fbconnection1.data.token = AccessToken.getCurrentAccessToken().getToken();
        fbconnection1.data.tokenExpired = AccessToken.getCurrentAccessToken().getExpires().getTime();
        fbconnection1.token = fbconnection1.data.token;
        fbconnection = fbconnection1;
        if (TextUtils.isEmpty(fbconnection1.data.id)) goto _L4; else goto _L3
_L3:
        fbconnection1.connectionId = fbconnection1.data.id;
        return fbconnection1;
        NumberFormatException numberformatexception;
        numberformatexception;
        d.a(TAG, "getFbConnectionData", numberformatexception);
        return fbconnection1;
    }

    public static String getImageSizeParams(int i, int j)
    {
        return (new StringBuilder("?og_image_width=")).append(i).append("&og_image_height=").append(j).toString();
    }

    public static String getMimeType(String s1)
    {
        String s2;
label0:
        {
            String s3;
label1:
            {
                s3 = null;
                Object obj = null;
                s2 = s3;
                if (TextUtils.isEmpty(s1))
                {
                    break label0;
                }
                s2 = s3;
                if (s1.equals("null"))
                {
                    break label0;
                }
                s3 = s1.substring(s1.lastIndexOf(".") + 1, s1.length());
                if (!"jpg".equalsIgnoreCase(s3))
                {
                    s1 = obj;
                    if (!"jpeg".equalsIgnoreCase(s3))
                    {
                        break label1;
                    }
                }
                s1 = "image/jpeg";
            }
            if ("png".equalsIgnoreCase(s3))
            {
                s1 = "image/png";
            }
            s2 = s1;
            if ("gif".equalsIgnoreCase(s3))
            {
                s2 = "image/gif";
            }
        }
        return s2;
    }

    private static void getPermissions(AccessToken accesstoken)
    {
        if (accesstoken == null)
        {
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList();
            GraphRequest.executeBatchAsync(new GraphRequest[] {
                new GraphRequest(accesstoken, "me/permissions", null, HttpMethod.GET, new com.facebook.GraphRequest.Callback(arraylist, arraylist1, accesstoken) {

                    private List a;
                    private List b;
                    private AccessToken c;

                    public final void onCompleted(GraphResponse graphresponse)
                    {
                        int i;
                        if (graphresponse.getError() != null)
                        {
                            return;
                        }
                        graphresponse = graphresponse.getJSONObject();
                        JSONObject jsonobject;
                        try
                        {
                            graphresponse = graphresponse.getJSONArray("data");
                        }
                        // Misplaced declaration of an exception variable
                        catch (GraphResponse graphresponse)
                        {
                            d.a(FacebookUtils.TAG, "getPermissions", graphresponse);
                            return;
                        }
                        i = 0;
_L2:
                        if (i >= graphresponse.length())
                        {
                            break MISSING_BLOCK_LABEL_114;
                        }
                        jsonobject = graphresponse.getJSONObject(i);
                        if ("granted".equals(jsonobject.getString("status")))
                        {
                            a.add(jsonobject.getString("permission"));
                            break MISSING_BLOCK_LABEL_164;
                        }
                        if ("declined".equals(jsonobject.getString("status")))
                        {
                            b.add(jsonobject.getString("permission"));
                        }
                        break MISSING_BLOCK_LABEL_164;
                        AccessToken.setCurrentAccessToken(new AccessToken(c.getToken(), FacebookSdk.getApplicationId(), FacebookUtils.user.a, a, b, AccessTokenSource.FACEBOOK_APPLICATION_WEB, c.getExpires(), null));
                        FacebookUtils.setConnectionState(true);
                        return;
                        i++;
                        if (true) goto _L2; else goto _L1
_L1:
                    }

            
            {
                a = list;
                b = list1;
                c = accesstoken;
                super();
            }
                })
            });
            return;
        }
    }

    public static String getPhotoOGParams(int i, int j, String s1)
    {
        if (i < 600 || j < 315)
        {
            return (new StringBuilder("?og_image=")).append(s1).toString();
        } else
        {
            return "";
        }
    }

    public static SharedPreferences getPrefs()
    {
        return FacebookSdk.getApplicationContext().getSharedPreferences("fb.picsartprefs", 4);
    }

    public static String getSignInParams()
    {
        JSONObject jsonobject1 = user.a();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", jsonobject1.optString("id"));
            jsonobject.put("profile_url", jsonobject1.optString("link"));
            jsonobject.put("name", jsonobject1.optString("name"));
            jsonobject.put("username", jsonobject1.optString("username"));
            jsonobject.put("cover", jsonobject1.optString("cover"));
            jsonobject.put("email", jsonobject1.optString("email"));
            jsonobject.put("token", AccessToken.getCurrentAccessToken().getToken());
            jsonobject.put("token_expired", AccessToken.getCurrentAccessToken().getExpires().getTime());
        }
        catch (JSONException jsonexception)
        {
            d.a(TAG, "getSignInParams", jsonexception);
        }
        return jsonobject.toString();
    }

    public static String getSmallPathForCache(Context context, String s1)
    {
        return (new StringBuilder()).append(getCacheFolderPath(context)).append(s1).append("_small").toString();
    }

    public static int getTextSize()
    {
        return textSize;
    }

    public static String getTokenString()
    {
        if (AccessToken.getCurrentAccessToken() != null)
        {
            return AccessToken.getCurrentAccessToken().getToken();
        } else
        {
            return null;
        }
    }

    public static l getUserData()
    {
        if (user != null)
        {
            return user;
        } else
        {
            l l1 = retrieveUserData();
            user = l1;
            return l1;
        }
    }

    public static boolean isSSOUser()
    {
        return getPrefs().getBoolean("fb.ssomode", true);
    }

    public static boolean isSessionValid()
    {
        return AccessToken.getCurrentAccessToken() != null && isUserConnected();
    }

    public static boolean isUserConnected()
    {
        return getPrefs().getBoolean("fb.userconnected", false);
    }

    private static void loginFacebook(Activity activity, String as[], p p1)
    {
        if (isSSOUser())
        {
            checkFacebookAppPresent(activity);
        }
        List list = Arrays.asList(as);
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback(list, activity, p1, as) {

            final Activity a;
            final p b;
            private List c;
            private String d[];

            public final void onCancel()
            {
                com.socialin.android.d.b(FacebookUtils.TAG, new Object[] {
                    "loginFacebook: onCanceled"
                });
                if (FacebookUtils.SSO_CHECK_MODE)
                {
                    b.a();
                } else
                if (AccessToken.getCurrentAccessToken() == null)
                {
                    FacebookUtils.setSSOMode(true);
                    return;
                }
            }

            public final void onError(FacebookException facebookexception)
            {
                com.socialin.android.d.b(FacebookUtils.TAG, new Object[] {
                    "loginFacebook: onError ", facebookexception.getMessage()
                });
                if (facebookexception.getMessage() == null) goto _L2; else goto _L1
_L1:
                Object obj;
                try
                {
                    obj = new JSONObject(facebookexception.getMessage());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((JSONException) (obj)).printStackTrace();
                    obj = null;
                }
                facebookexception = facebookexception.getMessage().toLowerCase();
                if (!facebookexception.contains("invalid access_token")) goto _L4; else goto _L3
_L3:
                com.socialin.android.apiv3.util.Utils.clearFacebookCookies(FacebookSdk.getApplicationContext());
_L2:
                if (FacebookUtils.SSO_CHECK_MODE)
                {
                    b.a();
                }
                return;
_L4:
                if (facebookexception.contains("error validating access token"))
                {
                    FacebookUtils.logoutFacebook(false);
                } else
                if (obj != null && ((JSONObject) (obj)).has("code"))
                {
                    Utils.a(a, "permission is not granted", 0);
                }
                if (true) goto _L2; else goto _L5
_L5:
            }

            public final void onSuccess(Object obj)
            {
                obj = (LoginResult)obj;
                if (((LoginResult) (obj)).getRecentlyDeniedPermissions().size() == 0 || !c.containsAll(((LoginResult) (obj)).getRecentlyDeniedPermissions()))
                {
                    FacebookUtils.manageFacebookAccounts(a, new p(this) {

                        private _cls17 a;

                        public final void a()
                        {
                            if (!FacebookUtils.SSO_CHECK_MODE)
                            {
                                FacebookUtils.sendFriendsAnal(a.a, true);
                            }
                            a.b.a();
                        }

            
            {
                a = _pcls17;
                super();
            }
                    }, d);
                }
            }

            
            {
                c = list;
                a = activity;
                b = p1;
                d = as;
                super();
            }
        });
        if (SSO_CHECK_MODE)
        {
            LoginManager.getInstance().setLoginBehavior(LoginBehavior.SSO_CHECK);
        } else
        if (isSSOUser())
        {
            LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        } else
        {
            LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
        }
        if (list.contains("publish_actions"))
        {
            LoginManager.getInstance().logInWithPublishPermissions(activity, list);
            return;
        } else
        {
            LoginManager.getInstance().logInWithReadPermissions(activity, list);
            return;
        }
    }

    public static void logoutFacebook(boolean flag)
    {
        LoginManager.getInstance().logOut();
        com.socialin.android.apiv3.util.Utils.clearFacebookCookies(FacebookSdk.getApplicationContext());
        user = null;
        clearPrefs();
        if (flag)
        {
            SocialinV3.getInstance().removeFbConnection();
        }
    }

    public static void manageFacebookAccounts(Activity activity, p p1, String as[])
    {
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        if (user == null)
        {
            if (accesstoken != null)
            {
                fetchUserInfo(accesstoken, activity, p1, as);
                return;
            } else
            {
                user = null;
                clearPrefs();
                return;
            }
        }
        if (isUserConnected())
        {
            if (SocialinV3.getInstance().isRegistered())
            {
                SocialinV3.getInstance().addFbConnection(getFbConnectionData());
            }
            p1.a();
            return;
        } else
        {
            showChooser(activity, p1, as);
            return;
        }
    }

    private static void newServerToken(String s1, Date date)
    {
        s1 = new AccessToken(s1, FacebookSdk.getApplicationId(), user.a, Arrays.asList(a), null, AccessTokenSource.FACEBOOK_APPLICATION_WEB, date, null);
        AccessToken.setCurrentAccessToken(s1);
        getPermissions(s1);
    }

    private static String onPostActionResponse(GraphResponse graphresponse)
    {
        Object obj = null;
        JSONObject jsonobject;
        if (graphresponse != null)
        {
            jsonobject = graphresponse.getJSONObject();
        } else
        {
            jsonobject = null;
        }
        if (jsonobject == null)
        {
            d.b(TAG, (new StringBuilder("onPostActionResponse  -   graphObject= ")).append(jsonobject).append(" response= ").append(graphresponse).toString());
            return null;
        }
        if (jsonobject == null)
        {
            graphresponse = obj;
        } else
        {
            graphresponse = jsonobject.optString("id");
        }
        d.b(TAG, new Object[] {
            (new StringBuilder("onPostActionResponse  -   Post id= ")).append(graphresponse).toString()
        });
        return graphresponse;
    }

    public static void openInviteFriendChooser(Activity activity, ImageItem imageitem, String s1)
    {
        if (AppInviteDialog.canShow())
        {
            if (TextUtils.isEmpty(s1))
            {
                if (imageitem == null)
                {
                    s1 = "http://picsart.com";
                } else
                {
                    s1 = (new StringBuilder("http://picsart.com/i/")).append(imageitem.id).toString();
                }
            }
            s1 = (new com.facebook.share.model.AppInviteContent.Builder()).setApplinkUrl(s1);
            if (imageitem != null)
            {
                s1.setPreviewImageUrl(imageitem.getUrl());
            }
            AppInviteDialog.show(activity, s1.build());
        }
        if (imageitem != null)
        {
            activity.finish();
        }
    }

    public static void openPhotoChooser(Activity activity, CallbackManager callbackmanager)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, new p(activity) {

            private Activity a;

            public final void a()
            {
                FacebookUtils.startPhotoActivity(a);
            }

            
            {
                a = activity;
                super();
            }
        }, new String[] {
            "user_friends", "user_photos", "email"
        });
    }

    public static void openPostToPageScreen(Activity activity, CallbackManager callbackmanager, Bundle bundle)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, new p(activity, bundle) {

            private Activity a;
            private Bundle b;

            public final void a()
            {
                if (a == null || a.isFinishing())
                {
                    return;
                } else
                {
                    Intent intent = new Intent();
                    intent.setClassName(a.getPackageName(), "com.socialin.android.facebook.FacebookPageListActivity");
                    intent.setFlags(0x24000000);
                    b.putString("userId", FacebookUtils.user.a);
                    b.putString("userScreenName", FacebookUtils.user.d);
                    intent.putExtras(b);
                    a.startActivity(intent);
                    a.finish();
                    return;
                }
            }

            
            {
                a = activity;
                b = bundle;
                super();
            }
        }, new String[] {
            "publish_actions", "manage_pages", "publish_pages"
        });
    }

    public static void postMessage(String s1, Activity activity, CallbackManager callbackmanager)
    {
        callbackManager = callbackmanager;
        flowDetection(activity, new p(s1, activity) {

            final Activity a;
            private String b;

            public final void a()
            {
                Bundle bundle = new Bundle();
                bundle.putString("message", b);
                bundle.putString("link", a.getString(0x7f08091c));
                (new GraphRequest(AccessToken.getCurrentAccessToken(), "me/feed", bundle, HttpMethod.POST, new com.facebook.GraphRequest.Callback(this) {

                    private _cls7 a;

                    public final void onCompleted(GraphResponse graphresponse)
                    {
label0:
                        {
                            if (graphresponse != null)
                            {
                                if (graphresponse.getError() != null)
                                {
                                    break label0;
                                }
                                Utils.a(a.a, a.a.getString(0x7f0805e9), 1);
                            }
                            return;
                        }
                        Utils.a(a.a, graphresponse.getError().getErrorUserMessage(), 1);
                    }

            
            {
                a = _pcls7;
                super();
            }
                })).executeAsync();
            }

            
            {
                b = s1;
                a = activity;
                super();
            }
        }, new String[] {
            "publish_actions"
        });
    }

    public static void postOnFbWall(String s1, String s2, ImageItem imageitem, long l1, Activity activity, boolean flag, CallbackManager callbackmanager, 
            boolean flag1)
    {
        if (!s.a(activity))
        {
            c.a(activity);
            return;
        } else
        {
            callbackManager = callbackmanager;
            flowDetection(activity, new p(activity, imageitem, s2, s1, flag, flag1, l1) {

                private Activity a;
                private ImageItem b;
                private String c;
                private String d;
                private boolean e;
                private boolean f;
                private long g;

                public final void a()
                {
                    if (a != null && !a.isFinishing())
                    {
                        if (b != null && FacebookUtils.isSSOUser() && ShareDialog.canShow(com/facebook/share/model/ShareLinkContent))
                        {
                            Object obj;
                            if (c == null)
                            {
                                obj = "";
                            } else
                            {
                                obj = c;
                            }
                            obj = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle(b.title).setContentDescription(((String) (obj))).setContentUrl(Uri.parse((new StringBuilder("http://picsart.com/i/")).append(b.id).toString()))).build();
                            ShareDialog.show(a, ((com.facebook.share.model.ShareContent) (obj)));
                        } else
                        {
                            Intent intent = new Intent();
                            intent.setClassName(a.getPackageName(), "com.socialin.android.facebook.FacebookWallPostActivity");
                            intent.setFlags(0x4200000);
                            intent.putExtra("path", d);
                            intent.putExtra("freeToEdit", e);
                            intent.putExtra("videoPost", f);
                            if (c != null)
                            {
                                intent.putExtra("postMessage", c);
                            }
                            intent.putExtra("item_id", g);
                            intent.putExtra("item", b);
                            a.startActivityForResult(intent, 1231);
                            a.overridePendingTransition(0x7f040044, 0x7f040048);
                        }
                        if (a instanceof FacebookAdapterActivity)
                        {
                            a.finish();
                            return;
                        }
                    }
                }

            
            {
                a = activity;
                b = imageitem;
                c = s1;
                d = s2;
                e = flag;
                f = flag1;
                g = l1;
                super();
            }
            }, new String[] {
                "publish_actions"
            });
            return;
        }
    }

    public static void postStoryAddPhoto(String s1, String s2, String s3, String s4, int i, int j, String s5, com.facebook.GraphRequest.Callback callback)
    {
        s5 = new Bundle();
        if (!TextUtils.isEmpty(s1) && s1.startsWith("fbstaging:"))
        {
            s5.putString("photo", s2);
            s5.putString("image[0][url]", s1);
            if (i >= 600 && j >= 315)
            {
                s5.putString("image[0][user_generated]", "true");
            } else
            {
                s5.putString("image[0][user_generated]", "false");
            }
        } else
        {
            s5.putString("photo", (new StringBuilder()).append(s2).append(getImageSizeParams(i, j)).toString());
        }
        if (!TextUtils.isEmpty(s3))
        {
            s5.putString("message", s3);
        }
        s5.putString("fb:explicitly_shared", "true");
        if (!TextUtils.isEmpty(s4) && !s4.equals("[]"))
        {
            s5.putString("tags", checkForTagsCount(s4));
        }
        (new GraphRequest(AccessToken.getCurrentAccessToken(), "me/picsartphotostudio:add", s5, HttpMethod.POST, callback)).executeAsync();
    }

    private static void postStoryFollowProfile(Bundle bundle, String s1)
    {
        (new GraphRequest(AccessToken.getCurrentAccessToken(), s1, bundle, HttpMethod.POST, OGPostCallback)).executeAsync();
    }

    public static void postStorySharePhoto(String s1, String s2, String s3, String s4, String s5, String s6, int i, int j, 
            long l1, String s7, com.facebook.GraphRequest.Callback callback)
    {
        s1 = getPhotoOGParams(i, j, "?r240x240");
        s6 = new Bundle();
        if (s4 != null && !s4.equals(""))
        {
            s6.putString("message", s4);
        }
        s6.putString("photo", (new StringBuilder()).append(s3).append(s1).toString());
        s6.putString("fb:explicitly_shared", "true");
        if (i >= 600 && j >= 315)
        {
            s6.putString("image[0][user_generated]", "true");
            s6.putString("image[0][url]", s2);
        }
        if (!TextUtils.isEmpty(s5) && !s5.equals("[]"))
        {
            s6.putString("tags", checkForTagsCount(s5));
        }
        (new GraphRequest(AccessToken.getCurrentAccessToken(), "me/picsartphotostudio:share", s6, HttpMethod.POST, callback)).executeAsync();
    }

    public static void postToFbWall(String s1, String s2, Activity activity, CallbackManager callbackmanager, boolean flag)
    {
        postOnFbWall(s1, s2, null, 0L, activity, true, callbackmanager, flag);
    }

    private static void registerResultDelegate(Activity activity)
    {
        if (activity instanceof FragmentActionsListener)
        {
            ((FragmentActionsListener)activity).setOnResultListener(new ActivityResultListener() {

                public final void onActivityResult(int i, int j, Intent intent)
                {
                    if (FacebookUtils.callbackManager != null && FacebookSdk.isFacebookRequestCode(i))
                    {
                        FacebookUtils.callbackManager.onActivityResult(i, j, intent);
                    }
                }

            });
            return;
        } else
        {
            d.c(new Object[] {
                TAG, "logoutFacebook", (new StringBuilder("execute() -  ")).append(activity.getClass().getName()).append(" must be type of FragmentActionsListener!!!!").toString()
            });
            return;
        }
    }

    private static l retrieveUserData()
    {
        Object obj = getPrefs().getString("fb.userdata", null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = new l(new JSONObject(((String) (obj))));
        return ((l) (obj));
        JSONException jsonexception;
        jsonexception;
        d.a(TAG, "retrieveUserData", jsonexception);
        return null;
    }

    private static void saveUserData()
    {
        Object obj = getPrefs();
        if (obj != null && user != null)
        {
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("fb.userdata", user.a().toString());
            ((android.content.SharedPreferences.Editor) (obj)).apply();
        }
    }

    public static void sendFriendsAnal(Context context, boolean flag)
    {
        com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
        if (SocialinV3.getInstance().getSettings().isContactSyncEnabled())
        {
            SharedPreferences sharedpreferences = myobfuscated.cy.a.a(context);
            Long long1 = Long.valueOf(sharedpreferences.getLong("facebook.anal.date", 0L));
            Long long2 = Long.valueOf((new Date()).getTime());
            if (long1.longValue() == 0L || long2.longValue() - long1.longValue() > data.social.getIntervalInMillis())
            {
                FacebookSdk.sdkInitialize(context, new com.facebook.FacebookSdk.InitializeCallback(context, sharedpreferences, long2, flag) {

                    final Context a;
                    final SharedPreferences b;
                    final Long c;
                    private boolean d;

                    public final void onInitialized()
                    {
                        GraphRequest graphrequest = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new com.facebook.GraphRequest.GraphJSONArrayCallback(this) {

                            private _cls16 a;

                            public final void onCompleted(JSONArray jsonarray, GraphResponse graphresponse)
                            {
                                if (jsonarray != null && jsonarray.length() > 0)
                                {
                                    graphresponse = new JSONArray();
                                    int i = 0;
                                    while (i < jsonarray.length()) 
                                    {
                                        try
                                        {
                                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                                            JSONObject jsonobject1 = new JSONObject();
                                            jsonobject1.put("identifier", jsonobject.optString("id", "0"));
                                            graphresponse.put(jsonobject1);
                                        }
                                        catch (JSONException jsonexception)
                                        {
                                            jsonexception.printStackTrace();
                                        }
                                        i++;
                                    }
                                    if (s.a(a.a))
                                    {
                                        a.b.edit().putLong("facebook.anal.date", a.c.longValue()).apply();
                                        AnalyticUtils.getInstance(a.a).trackDeviceContactInfo("facebook", graphresponse);
                                    }
                                }
                            }

            
            {
                a = _pcls16;
                super();
            }
                        });
                        if (d)
                        {
                            graphrequest.executeAsync();
                            return;
                        } else
                        {
                            graphrequest.executeAndWait();
                            return;
                        }
                    }

            
            {
                a = context;
                b = sharedpreferences;
                c = long1;
                d = flag;
                super();
            }
                });
            }
        }
    }

    public static void setConnectionState(boolean flag)
    {
        getPrefs().edit().putBoolean("fb.userconnected", flag).apply();
    }

    public static void setSSOMode(boolean flag)
    {
        getPrefs().edit().putBoolean("fb.ssomode", flag).apply();
    }

    public static void setTextSize(int i)
    {
        textSize = i;
    }

    public static void setUserData(l l1)
    {
        user = l1;
    }

    private static void showChooser(Activity activity, p p1, String as[])
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("userId", user.a);
        bundle.putString("userDisplayName", user.d);
        FragmentTransaction fragmenttransaction = activity.getFragmentManager().beginTransaction();
        activity = activity.getFragmentManager().findFragmentByTag("accountsFragment");
        if (activity != null)
        {
            fragmenttransaction.remove(activity);
        }
        activity = new myobfuscated.bu.a();
        activity.a = p1;
        activity.b = as;
        activity.setArguments(bundle);
        try
        {
            activity.show(fragmenttransaction, "accountsFragment");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
        }
    }

    public static void showDialog(Activity activity)
    {
        showDialog(activity, activity.getResources().getString(0x7f080450));
    }

    public static void showDialog(Activity activity, String s1)
    {
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        FragmentTransaction fragmenttransaction;
        Fragment fragment;
        if (activity.isFinishing())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        activity = activity.getFragmentManager();
        fragmenttransaction = activity.beginTransaction();
        fragment = activity.findFragmentByTag("fragmentProgressDialog");
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (fragment.isAdded() && !fragment.isRemoving())
        {
            if (!fragment.isVisible())
            {
                ((DialogFragment)fragment).show(activity, "fragmentProgressDialog");
                return;
            }
            break MISSING_BLOCK_LABEL_101;
        }
        try
        {
            s1 = myobfuscated.cy.b.a("", s1);
            s1.setCancelable(true);
            s1.show(activity, "fragmentProgressDialog");
            fragmenttransaction.commitAllowingStateLoss();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            d.a(TAG, "showDialog", activity);
        }
    }

    public static void showNoNetworkDialog(Activity activity)
    {
        activity.runOnUiThread(new Runnable(activity) {

            private Activity a;

            public final void run()
            {
                DialogUtils.showNoNetworkDialog(a, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
            }

            
            {
                a = activity;
                super();
            }
        });
    }

    public static void singleSignOnFallbackLogin(Activity activity, String as[], p p1)
    {
        loginFacebook(activity, as, p1);
    }

    public static void startAdapterActivity(Activity activity, String s1)
    {
        Intent intent = new Intent(activity, com/socialin/android/facebook/activity/FacebookAdapterActivity);
        intent.putExtra("fbImagePath", s1);
        activity.startActivity(intent);
    }

    private static void startPhotoActivity(Activity activity)
    {
        boolean flag1 = false;
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = activity.getIntent().getExtras();
        boolean flag = flag1;
        if (bundle != null)
        {
            flag = flag1;
            if (bundle.getBoolean("multipleCheckMode", false))
            {
                flag = true;
            }
        }
        intent.setClassName(activity.getPackageName(), "com.socialin.android.facebook.FacebookMainActivity");
        intent.setFlags(0x24000000);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        if (flag)
        {
            activity.startActivityForResult(intent, 1338);
        } else
        {
            activity.startActivityForResult(intent, 1225);
        }
        activity.overridePendingTransition(0x7f040044, 0x7f040048);
    }









/*
    static l access$302(l l1)
    {
        user = l1;
        return l1;
    }

*/






}
