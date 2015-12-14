// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.socialin.android.apiv3.controllers.AddConnectionController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.GetAppPropsController;
import com.socialin.android.apiv3.controllers.GetOwnerController;
import com.socialin.android.apiv3.controllers.GetSettingsController;
import com.socialin.android.apiv3.controllers.GetUserShopItemsListController;
import com.socialin.android.apiv3.controllers.GetWhatsNewController;
import com.socialin.android.apiv3.controllers.RemoveConnectionController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.gcm.ServerUtilities;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.FbConnection;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.AddCommentParams;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.c;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.util.an;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.CacheManager;
import com.socialin.asyncnet.d;
import com.socialin.gson.Gson;
import com.socialin.gson.stream.JsonReader;
import com.socialin.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.apiv3:
//            b, SocialinApiV3

public class SocialinV3
    implements CommonConstants, d
{

    public static final String FROM = "from";
    public static final String PROVIDER_FACEBOOK = "facebook";
    public static final String PROVIDER_GOOGLEPLUS = "google";
    public static final String PROVIDER_INSTAGRAM = "instagram";
    public static final String PROVIDER_SITE = "android";
    public static final String PROVIDER_TWITTER = "twitter";
    public static String RESOURCE_URL;
    public static String SHOP_PACKAGE_ICON_URL;
    public static String STATIC_URL;
    public static final String UPDATE_ADDS_ENABLED_ACTION = "update.adds.enabled.action";
    public static final Uri UPDATE_SHOP_ITEMS_URI = Uri.parse("content://com.picsart.studio.provider/user.shop.items.update");
    public static final String UPDATE_USER_RECEIVER_ACTION = "com.picsart.studio.update.user.action";
    public static final Uri UPDATE_USER_URI = Uri.parse("content://com.picsart.studio.provider/user.update");
    private static SocialinV3 instance;
    public static String market = "google";
    public static String url = "http://playgamesite.com/android/socialin/uploadedImg/";
    private static final String userDataPath = "user_data";
    private AppProps appProps;
    private final String cache;
    private Application context;
    private String deviceId;
    private User emptyUser;
    private GetAppPropsController getAppPropsController;
    private GetOwnerController getOwnerController;
    private Settings settings;
    private UpdateUserController updateUserController;
    private User user;
    private GetUserShopItemsListController userItemListController;
    private GetWhatsNewController whatsNewController;

    public SocialinV3(Application application)
    {
        emptyUser = User.emptyUser;
        appProps = AppProps.emptyAppProps;
        settings = Settings.emptySettings;
        getOwnerController = new GetOwnerController();
        getAppPropsController = new GetAppPropsController("props", true);
        updateUserController = new UpdateUserController();
        whatsNewController = new GetWhatsNewController();
        userItemListController = null;
        if (instance != null)
        {
            throw new IllegalStateException("user get instance");
        } else
        {
            context = application;
            market = application.getString(0x7f0808c8);
            cache = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(application.getPackageName()).append("/.cache/").toString();
            getOwnerController.setRequestCompleteListener(this);
            user = emptyUser;
            instance = this;
            readUser();
            getAppPropsController.setRequestCompleteListener(new d() {

                private SocialinV3 a;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
                    a.notifyMainPageForAds();
                }

            
            {
                a = SocialinV3.this;
                super();
            }
            });
            getAppPropsController.doRequest();
            GetSettingsController getsettingscontroller = new GetSettingsController("settings", true);
            getsettingscontroller.setRequestCompleteListener(new d() {

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final volatile void onSuccess(Object obj, Request request)
                {
                }

            });
            getsettingscontroller.doRequest();
            application.getContentResolver().registerContentObserver(UPDATE_USER_URI, false, new b(this, new Handler()));
            userItemListController = new GetUserShopItemsListController();
            userItemListController.setRequestCompleteListener(new d(application) {

                private Application a;
                private SocialinV3 b;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    Log.i("test", "onFailure");
                    if (SocialinV3.getInstance().isRegistered())
                    {
                        Inventory.restoreShopItems();
                        exception = new Intent("update.adds.enabled.action");
                        b.notifyMainPageForAds();
                        a.sendBroadcast(exception);
                    }
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
                    obj = (ShopItemsListResponse)obj;
                    if (obj != null)
                    {
                        request = ((ShopItemsListResponse) (obj)).response;
                        obj = new JSONArray();
                        for (request = request.iterator(); request.hasNext();)
                        {
                            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)request.next();
                            try
                            {
                                ((JSONArray) (obj)).put(shopitem.toJson());
                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                            }
                        }

                        Inventory.setUserShopItems(((JSONArray) (obj)), false);
                    }
                    obj = new Intent("update.adds.enabled.action");
                    b.notifyMainPageForAds();
                    a.sendBroadcast(((Intent) (obj)));
                }

            
            {
                b = SocialinV3.this;
                a = application;
                super();
            }
            });
            return;
        }
    }

    public static void checkGcm()
    {
        while (!getInstance().getAppProps().getData().registerDevice || !getInstance().isRegistered()) 
        {
            return;
        }
        (new an() {

            private static transient Void a()
            {
                String s1;
                Application application;
                SocialinV3 socialinv3;
                GoogleCloudMessaging googlecloudmessaging;
                application = SocialinV3.getInstance().getContext();
                googlecloudmessaging = GoogleCloudMessaging.getInstance(application);
                socialinv3 = SocialinV3.getInstance();
                s1 = socialinv3.getRegistrationId(application);
                String s = s1;
                try
                {
                    if (s1.length() == 0)
                    {
                        s = googlecloudmessaging.register(new String[] {
                            "1076413845392"
                        });
                    }
                    if (ServerUtilities.register(application, s))
                    {
                        socialinv3.setRegistrationId(application, s);
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final volatile void onPostExecute(Object obj)
            {
            }

        }).a(new Void[0]);
    }

    private SharedPreferences getGCMPreferences(Context context1)
    {
        return context1.getSharedPreferences("google.cloud.message.pref", 4);
    }

    public static SocialinV3 getInstance()
    {
        if (instance == null)
        {
            throw new IllegalStateException("instance not created yet");
        } else
        {
            return instance;
        }
    }

    private void notifyMainPageForAds()
    {
        getContext().getContentResolver().notifyChange(UPDATE_SHOP_ITEMS_URI, null);
    }

    private void readUser()
    {
        JsonReader jsonreader = new JsonReader(new InputStreamReader(context.openFileInput("user_data")));
        Object obj = jsonreader;
        user = (User)c.a().fromJson(jsonreader, com/socialin/android/apiv3/model/User);
        obj = jsonreader;
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = jsonreader;
        if (user.key == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = jsonreader;
        SocialinApiV3.getInstance().setApiKey(user.key);
        obj = jsonreader;
        if (!context.getString(0x7f0808c8).equals(context.getString(0x7f0808d3)))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = jsonreader;
        user.mature = false;
        obj = jsonreader;
        if (user != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = jsonreader;
        user = emptyUser;
        jsonreader.close();
_L2:
        return;
        obj;
        ((IOException) (obj)).printStackTrace();
        return;
        Object obj1;
        obj1;
        jsonreader = null;
_L7:
        obj = jsonreader;
        ((FileNotFoundException) (obj1)).printStackTrace();
        if (jsonreader == null) goto _L2; else goto _L1
_L1:
        try
        {
            jsonreader.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        return;
        obj1;
        jsonreader = null;
_L6:
        obj = jsonreader;
        ((Exception) (obj1)).printStackTrace();
        if (jsonreader == null) goto _L2; else goto _L3
_L3:
        try
        {
            jsonreader.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        return;
        Exception exception;
        exception;
        obj = null;
_L5:
        if (obj != null)
        {
            try
            {
                ((JsonReader) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
        obj1;
          goto _L7
    }

    private void setRegistrationId(Context context1, String s)
    {
        getGCMPreferences(context1).edit().putString("registration_id", s).commit();
    }

    public void addFbConnection(FbConnection fbconnection)
    {
        if (fbconnection != null)
        {
            (new AddConnectionController()).doRequest(null, fbconnection);
        }
    }

    public AppProps getAppProps()
    {
        return appProps;
    }

    public Application getContext()
    {
        return context;
    }

    public String getDeviceId()
    {
        if (deviceId != null)
        {
            return deviceId;
        }
        deviceId = getContext().getSharedPreferences("com.picsart.studio.deviceid.key", 0).getString("com.picsart.studio.deviceid.key", "");
        if (TextUtils.isEmpty(deviceId))
        {
            deviceId = (new StringBuilder("andy-")).append(UUID.randomUUID().toString()).toString();
            getContext().getSharedPreferences("com.picsart.studio.deviceid.key", 0).edit().putString("com.picsart.studio.deviceid.key", deviceId).commit();
        }
        return deviceId;
    }

    public String getExternalChachePath()
    {
        return cache;
    }

    public String getFilesDirPath()
    {
        String s = "";
        if (context.getFilesDir() != null)
        {
            s = context.getFilesDir().getPath();
        }
        return s;
    }

    public String getRegistrationId(Context context1)
    {
        String s = getGCMPreferences(context1).getString("registration_id", "");
        context1 = s;
        if (s.length() == 0)
        {
            context1 = "";
        }
        return context1;
    }

    public Settings getSettings()
    {
        return settings;
    }

    public User getUser()
    {
        return user;
    }

    public com.socialin.android.apiv3.model.UserConnection.Data getUserFbData()
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getFbConnection()) != null)
            {
                return ((FbConnection) (obj)).data;
            }
        }
        return null;
    }

    public String getUserFbId()
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getFbConnection()) != null && !TextUtils.isEmpty(((FbConnection) (obj)).connectionId))
            {
                return ((FbConnection) (obj)).connectionId;
            }
        }
        return null;
    }

    public String getUserFbToken()
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getFbConnection()) != null)
            {
                return ((FbConnection) (obj)).token;
            }
        }
        return null;
    }

    public String getUserTwitterSecret()
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getTwitterConnection()) != null)
            {
                return ((TwitterConnection) (obj)).getTokenSecret();
            }
        }
        return null;
    }

    public String getUserTwitterToken()
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getTwitterConnection()) != null)
            {
                return ((TwitterConnection) (obj)).token;
            }
        }
        return null;
    }

    public boolean isRegistered()
    {
        return user != null && user != emptyUser && !TextUtils.isEmpty(user.key);
    }

    public void logoutUser()
    {
        setUser(emptyUser, true);
        CacheManager.a().c();
        Inventory.reset();
        Utils.clearFacebookCookies(context);
    }

    public void onCancelRequest(User user1, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((User)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(User user1, Request request)
    {
        user = user1;
        writeUser();
        user1 = new Intent("com.picsart.studio.update.user.action");
        context.sendBroadcast(user1);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((User)obj, request);
    }

    public void refreshUser()
    {
        if (user == emptyUser)
        {
            return;
        } else
        {
            getOwnerController.doRequest();
            return;
        }
    }

    public void removeDevice()
    {
        Object obj = getRegistrationId(context);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return;
        } else
        {
            AddCommentParams addcommentparams = new AddCommentParams();
            addcommentparams.text = ((String) (obj));
            obj = RequestControllerFactory.createRemoveDeviceController();
            ((BaseSocialinApiRequestController) (obj)).setRequestCompleteListener(new d() {

                private SocialinV3 a;

                public final volatile void onCancelRequest(Object obj1, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    if (com.socialin.android.d.b)
                    {
                        com.socialin.android.d.c(new Object[] {
                            "SocialinV3", "removeDevice: onFailure "
                        });
                    }
                    exception.printStackTrace();
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj1, Request request)
                {
                    a.logoutUser();
                }

            
            {
                a = SocialinV3.this;
                super();
            }
            });
            ((BaseSocialinApiRequestController) (obj)).doRequest(null, addcommentparams);
            return;
        }
    }

    public void removeFbConnection()
    {
        if (user.connections != null)
        {
            FbConnection fbconnection = user.connections.getFbConnection();
            if (fbconnection != null)
            {
                (new RemoveConnectionController()).doRequest(null, fbconnection);
            }
            return;
        } else
        {
            FbConnection fbconnection1 = new FbConnection();
            fbconnection1.provider = "facebook";
            (new RemoveConnectionController()).doRequest(null, fbconnection1);
            return;
        }
    }

    public void removeTwitterConnection()
    {
        if (user.connections != null)
        {
            (new RemoveConnectionController()).doRequest(null, user.connections.getTwitterConnection());
        }
    }

    public void requestWhatsNewData()
    {
        whatsNewController.doRequest();
    }

    public void setAppProps(AppProps appprops)
    {
        appProps = appprops;
        if (!TextUtils.isEmpty(appprops.getResourceUrl()))
        {
            RESOURCE_URL = appprops.getResourceUrl();
            SHOP_PACKAGE_ICON_URL = (new StringBuilder()).append(RESOURCE_URL).append("shop/package_icon").toString();
        }
    }

    public void setSettings(Settings settings1)
    {
        settings = settings1;
    }

    public void setUser(User user1, boolean flag)
    {
        user = user1;
        if (flag)
        {
            writeUser();
        }
        SocialinApiV3.getInstance().setApiKey(user1.key);
    }

    public boolean setUserFbToken(String s)
    {
        Object obj = user.connections;
        if (obj != null)
        {
            if ((obj = ((com.socialin.android.apiv3.model.User.UserConnections) (obj)).getFbConnection()) != null)
            {
                obj.token = s;
                return true;
            }
        }
        return false;
    }

    public void updateInventory()
    {
        if (getInstance().isRegistered())
        {
            userItemListController.doRequest();
        } else
        {
            Inventory.removeInventoryData();
            Intent intent = new Intent("update.adds.enabled.action");
            context.sendBroadcast(intent);
            notifyMainPageForAds();
        }
        (new StringBuilder("UpdateUserObserver---  ")).append(SocialinApiV3.getInstance().hashCode());
    }

    public void updateUser()
    {
        UpdateUserParams updateuserparams = new UpdateUserParams();
        updateuserparams.address = user.address;
        updateuserparams.email = user.email;
        updateuserparams.name = user.name;
        updateuserparams.photo = user.getPhoto();
        updateuserparams.username = user.username;
        updateUserController.setRequestParams(updateuserparams);
        updateUserController.setRequestCompleteListener(new d() {

            private SocialinV3 a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                if (com.socialin.android.d.b)
                {
                    com.socialin.android.d.c(new Object[] {
                        "SocialinV3", (new StringBuilder("updateUser- ")).append(exception.getLocalizedMessage()).toString()
                    });
                }
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                a.writeUser();
            }

            
            {
                a = SocialinV3.this;
                super();
            }
        });
        updateUserController.doRequest();
    }

    public void writeUser()
    {
        Object obj = null;
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Gson gson = c.a();
        Object obj1 = new JsonWriter(new OutputStreamWriter(context.openFileOutput("user_data", 0)));
        obj = obj1;
        gson.toJson(user, com/socialin/android/apiv3/model/User, ((JsonWriter) (obj1)));
        ((JsonWriter) (obj1)).flush();
_L7:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        getContext().getContentResolver().notifyChange(UPDATE_USER_URI, null);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        ((IOException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Object obj2;
        obj2;
        obj1 = null;
_L5:
        obj = obj1;
        ((FileNotFoundException) (obj2)).printStackTrace();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        ((JsonWriter) (obj1)).flush();
        flag = true;
        continue; /* Loop/switch isn't completed */
        obj;
        ((IOException) (obj)).printStackTrace();
        flag = true;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj1 = obj;
        obj = obj2;
_L3:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        ((JsonWriter) (obj1)).flush();
_L1:
        throw obj;
        obj1;
        ((IOException) (obj1)).printStackTrace();
          goto _L1
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L3; else goto _L2
_L2:
        obj2;
        if (true) goto _L5; else goto _L4
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static 
    {
        STATIC_URL = "http://static";
        RESOURCE_URL = (new StringBuilder()).append(STATIC_URL).append(".picsart.com/").toString();
        SHOP_PACKAGE_ICON_URL = (new StringBuilder()).append(RESOURCE_URL).append("shop/package_icon").toString();
    }



}
