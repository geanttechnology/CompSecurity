// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudGetUserByIDResponseHandler;
import com.flurry.android.responses.AppCloudLoginResponseHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            cx, AppCloudSearch, FlurryAppCloudRequestManager, di, 
//            et, dg, dj, cz, 
//            AppCloudValueUpdateHandler, r, AppCloudResponse, dl, 
//            dk, de, df, dd

public class AppCloudUser extends cx
{

    private static AppCloudUser cN = null;

    public AppCloudUser()
    {
    }

    public AppCloudUser(String s, String s1, String s2)
    {
        mUsername = s;
        mEmail = s1;
        password = s2;
    }

    AppCloudUser(JSONObject jsonobject)
    {
        createUser(jsonobject);
    }

    protected static AppCloudSearch Search()
    {
        if (getCurrentUser() == null)
        {
            return null;
        } else
        {
            return new AppCloudSearch();
        }
    }

    static AppCloudUser V()
    {
        cN = null;
        return null;
    }

    private static void a(String s, String s1, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        ArrayList arraylist;
        try
        {
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        arraylist.add(new BasicNameValuePair("username", s));
_L4:
        FlurryAppCloudRequestManager.fInternalApi = true;
        FlurryAppCloudRequestManager.Post("v1/user/forgot", arraylist, new di(appcloudcommonoperationresponsehandler));
        return;
_L2:
        if (s1 == null) goto _L4; else goto _L3
_L3:
        arraylist.add(new BasicNameValuePair("email", s1));
          goto _L4
    }

    private static void a(String s, String s1, AppCloudLoginResponseHandler appcloudloginresponsehandler)
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        if (TextUtils.equals(s, et.ba()) && TextUtils.equals(s1, et.bc()) && !TextUtils.isEmpty(et.aZ()))
        {
            arraylist.add(new BasicNameValuePair("userid", et.aZ()));
            arraylist.add(new BasicNameValuePair("password", s1));
        } else
        {
            arraylist.add(new BasicNameValuePair("username", s));
            arraylist.add(new BasicNameValuePair("password", s1));
        }
        a(((List) (arraylist)), s1, appcloudloginresponsehandler);
    }

    private static void a(List list, String s, AppCloudLoginResponseHandler appcloudloginresponsehandler)
    {
        try
        {
            FlurryAppCloudRequestManager.Get("v1/user/login", list, new dg(s, appcloudloginresponsehandler));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
        }
    }

    public static AppCloudUser getCurrentUser()
    {
        return cN;
    }

    public static void getUserById(String s, AppCloudGetUserByIDResponseHandler appcloudgetuserbyidresponsehandler)
        throws Exception
    {
        AppCloudUser appclouduser = new AppCloudUser();
        appclouduser.setId(s);
        appclouduser.getObjectOrUser(new dj(appcloudgetuserbyidresponsehandler));
    }

    public static void loginUserWithName(String s, String s1, String s2, boolean flag, AppCloudLoginResponseHandler appcloudloginresponsehandler)
    {
        if (TextUtils.isEmpty(s))
        {
            appcloudloginresponsehandler.onError(new AppCloudError(400, "User name is not set."));
            return;
        }
        if (TextUtils.isEmpty(s1))
        {
            appcloudloginresponsehandler.onError(new AppCloudError(400, "Password is not set."));
            return;
        }
        if (TextUtils.isEmpty(s2))
        {
            appcloudloginresponsehandler.onError(new AppCloudError(400, "Email is not set."));
            return;
        }
        if (!flag)
        {
            try
            {
                a(s, s1, appcloudloginresponsehandler);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
        a(s, s1, new cz(appcloudloginresponsehandler, s, s2, s1));
        return;
    }

    public static void loginWithEmail(String s, String s1, AppCloudLoginResponseHandler appcloudloginresponsehandler)
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        if (TextUtils.equals(s, et.bb()) && TextUtils.equals(s1, et.bc()) && !TextUtils.isEmpty(et.aZ()))
        {
            arraylist.add(new BasicNameValuePair("userid", et.aZ()));
            arraylist.add(new BasicNameValuePair("password", s1));
        } else
        {
            arraylist.add(new BasicNameValuePair("email", s));
            arraylist.add(new BasicNameValuePair("password", s1));
        }
        a(arraylist, s1, appcloudloginresponsehandler);
    }

    public static void resetPasswordForUserViaEmail(String s, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        a(((String) (null)), s, appcloudcommonoperationresponsehandler);
    }

    public static void resetPasswordForUserViaUsername(String s, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        a(s, null, appcloudcommonoperationresponsehandler);
    }

    protected static void setCurrentUser(AppCloudUser appclouduser)
    {
        cN = appclouduser;
    }

    public void addObserverForKey(String s, AppCloudValueUpdateHandler appcloudvalueupdatehandler)
    {
        if (TextUtils.isEmpty(mId))
        {
            Log.i("AppCloudUser", (new StringBuilder()).append("mId of user is  = ").append(mId).toString());
            appcloudvalueupdatehandler.onError(new AppCloudError(400, "Please assign an object id."));
            return;
        } else
        {
            r.a(mId, s, appcloudvalueupdatehandler);
            return;
        }
    }

    public volatile boolean containsObserver()
    {
        return super.containsObserver();
    }

    public void decrement(String s, float f, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.decrement(s, String.valueOf(f), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void decrement(String s, int i, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.decrement(s, String.valueOf(i), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void deleteWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        }
        try
        {
            delete(new dl(this, appcloudcommonoperationresponsehandler));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        {
            appcloudcommonoperationresponsehandler.printStackTrace();
        }
        return;
    }

    public volatile String get(String s)
    {
        return super.get(s);
    }

    public String getEmail()
    {
        return mEmail;
    }

    public volatile float getFloat(String s)
    {
        return super.getFloat(s);
    }

    public volatile String getId()
    {
        return super.getId();
    }

    public volatile int getInt(String s)
    {
        return super.getInt(s);
    }

    public volatile Vector getKeyValues()
    {
        return super.getKeyValues();
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return mUsername;
    }

    public void getWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        } else
        {
            getObjectOrUser(new dk(appcloudcommonoperationresponsehandler));
            return;
        }
    }

    public void increment(String s, float f, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.increment(s, String.valueOf(f), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void increment(String s, int i, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.increment(s, String.valueOf(i), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public volatile boolean isAutoSyncEnabled()
    {
        return super.isAutoSyncEnabled();
    }

    public void loginCreatingIfNewWithCompletionHandler(AppCloudLoginResponseHandler appcloudloginresponsehandler)
    {
        String s = et.ba();
        String s1 = et.bc();
        String s2 = et.bb();
        try
        {
            loginUserWithName(s, s1, s2, true, appcloudloginresponsehandler);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudLoginResponseHandler appcloudloginresponsehandler)
        {
            appcloudloginresponsehandler.printStackTrace();
        }
    }

    public void logoutWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        FlurryAppCloudRequestManager.fInternalApi = true;
        Log.i("AppCloudUser", (new StringBuilder()).append("Logout, mId = ").append(mId).toString());
        FlurryAppCloudRequestManager.Put("v1/user/logout", null, new de(appcloudcommonoperationresponsehandler));
    }

    public volatile boolean removeAllObservers()
    {
        return super.removeAllObservers();
    }

    public volatile boolean removeObserver(AppCloudValueUpdateHandler appcloudvalueupdatehandler)
    {
        return super.removeObserver(appcloudvalueupdatehandler);
    }

    public volatile boolean removeObserverForKey(String s)
    {
        return super.removeObserverForKey(s);
    }

    public void resendSignupValidationEmailWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        FlurryAppCloudRequestManager.fInternalApi = true;
        FlurryAppCloudRequestManager.Post((new StringBuilder()).append("v1/user/").append(mId).append("/resend").toString(), null, new df(appcloudcommonoperationresponsehandler));
    }

    public void resetPasswordWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        if (TextUtils.isEmpty(mUsername) && TextUtils.isEmpty(mEmail))
        {
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(400, "Current user has neither username nor email"));
            return;
        }
        if (!TextUtils.isEmpty(mEmail))
        {
            a(((String) (null)), mEmail, appcloudcommonoperationresponsehandler);
            return;
        } else
        {
            a(mUsername, null, appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void saveOrCreateWithCompletionHandler(AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
        throws Exception
    {
        super.saveOrCreateWithCompletionHandler(new dd(this, appcloudapplyoperationresonsehandler));
    }

    public volatile void saveToCache()
    {
        super.saveToCache();
    }

    public volatile void set(String s, Object obj)
    {
        super.set(s, obj);
    }

    public volatile boolean setAutoSyncEnabled(boolean flag)
    {
        return super.setAutoSyncEnabled(flag);
    }

    public void setEmail(String s)
    {
        mEmail = s;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setUsername(String s)
    {
        mUsername = s;
    }

    public volatile String toString()
    {
        return super.toString();
    }

}
