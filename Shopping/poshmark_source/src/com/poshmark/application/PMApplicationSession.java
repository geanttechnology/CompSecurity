// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.application;

import android.content.Context;
import android.content.SharedPreferences;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.data_model.models.ExternalPermissions;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.user.UserInfo;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.DateUtils;
import java.util.Date;

// Referenced classes of package com.poshmark.application:
//            PMApplication

public class PMApplicationSession
{

    static PMApplicationSession session = null;
    SharedPreferences fbPrefs;
    ExternalServiceInfo fb_info;
    SharedPreferences gpPrefs;
    boolean isLoggedIn;
    SharedPreferences ptPrefs;
    SharedPreferences tmPrefs;
    ExternalServiceInfo tm_info;
    SharedPreferences twPrefs;
    ExternalServiceInfo tw_info;
    SharedPreferences userPrefs;

    PMApplicationSession()
    {
        isLoggedIn = false;
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        userPrefs = context.getSharedPreferences("userPrefs", 0);
        context = PMApplication.getContext();
        PMApplication.getContext();
        fbPrefs = context.getSharedPreferences("fbPrefs", 0);
        context = PMApplication.getContext();
        PMApplication.getContext();
        gpPrefs = context.getSharedPreferences("gpPrefs", 0);
        context = PMApplication.getContext();
        PMApplication.getContext();
        twPrefs = context.getSharedPreferences("twPrefs", 0);
        context = PMApplication.getContext();
        PMApplication.getContext();
        tmPrefs = context.getSharedPreferences("tmPrefs", 0);
        context = PMApplication.getContext();
        PMApplication.getContext();
        ptPrefs = context.getSharedPreferences("ptPrefs", 0);
        if (userPrefs.getString("accessToken", null) != null)
        {
            isLoggedIn = true;
            return;
        } else
        {
            isLoggedIn = false;
            return;
        }
    }

    public static PMApplicationSession GetPMSession()
    {
        if (session == null)
        {
            session = new PMApplicationSession();
        }
        return session;
    }

    private boolean hasFbTokenExpired()
    {
        boolean flag1 = false;
        Date date = new Date();
        Date date1 = getFacebookTokenExpirationDate();
        boolean flag = flag1;
        if (date1 != null)
        {
            flag = flag1;
            if (DateUtils.getDiffBetweenDates(date, date1, com.poshmark.utils.DateUtils.TIME_UNIT.DAYS) <= 10L)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean canPerformActionForRole(String s)
    {
        return false;
    }

    public void clearFacebookInfo()
    {
        fbPrefs.edit().clear().commit();
    }

    public void clearGoogleInfo()
    {
        gpPrefs.edit().clear().commit();
    }

    public void clearPinterestInfo()
    {
        ptPrefs.edit().clear().commit();
    }

    public void clearTumblrInfo()
    {
        tmPrefs.edit().clear().commit();
    }

    public void clearTwitterInfo()
    {
        twPrefs.edit().clear().commit();
    }

    public String getAccessToken()
    {
        return userPrefs.getString("accessToken", null);
    }

    public String getDevIP()
    {
        Object obj = null;
        if (EnvConfig.ENV == Env.DEV)
        {
            obj = PMApplication.getContext();
            PMApplication.getContext();
            obj = ((Context) (obj)).getSharedPreferences("DEV", 0).getString("IP", null);
        }
        return ((String) (obj));
    }

    public String getDisplayHandle()
    {
        return userPrefs.getString("displayHandle", null);
    }

    public ExternalServiceInfo getFacebookInfo()
    {
        ExternalServiceInfo externalserviceinfo = new ExternalServiceInfo();
        externalserviceinfo.ext_access_token = getFacebookToken();
        externalserviceinfo.ext_token_expr = fbPrefs.getString("ext_token_expr", null);
        externalserviceinfo.ext_user_id = fbPrefs.getString("ext_user_id", null);
        externalserviceinfo.ext_permissions = new ExternalPermissions();
        externalserviceinfo.ext_permissions.email = fbPrefs.getInt("email_permission", 0);
        externalserviceinfo.ext_permissions.public_profile = fbPrefs.getInt("public_profile_permission", 0);
        externalserviceinfo.ext_permissions.user_friends = fbPrefs.getInt("user_friends_permission", 0);
        externalserviceinfo.ext_permissions.publish_actions = fbPrefs.getInt("publish_actions_permission", 0);
        return externalserviceinfo;
    }

    public Boolean getFacebookSharingFlag()
    {
        return Boolean.valueOf(fbPrefs.getBoolean("fb_sharing", false));
    }

    public String getFacebookToken()
    {
        return fbPrefs.getString("ext_access_token", null);
    }

    public Date getFacebookTokenExpirationDate()
    {
        Date date = null;
        String s = fbPrefs.getString("ext_token_expr", null);
        if (s != null)
        {
            date = DateUtils.getDateFromString(s);
        }
        return date;
    }

    public String getFacebookUserId()
    {
        return fbPrefs.getString("ext_user_id", null);
    }

    public String getFirstName()
    {
        return userPrefs.getString("firstName", "");
    }

    public String getFullName()
    {
        return (new StringBuilder()).append(userPrefs.getString("firstName", "")).append(" ").append(userPrefs.getString("lastName", "")).toString();
    }

    public String getGCMAppVersion()
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        return context.getSharedPreferences("GCMInfo", 0).getString("GCMAppVersion", null);
    }

    public Date getGCMLastRegisteredTime()
    {
        Date date = null;
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        obj = ((Context) (obj)).getSharedPreferences("GCMInfo", 0).getString("GCMLastRegisteredTime", null);
        if (obj != null)
        {
            date = DateUtils.getDateFromString(((String) (obj)));
        }
        return date;
    }

    public String getGCMRegId()
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        return context.getSharedPreferences("GCMInfo", 0).getString("GCMRegId", null);
    }

    public boolean getGCMRegIdSentFlag()
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        return context.getSharedPreferences("GCMInfo", 0).getBoolean("GCMRegIdSentFlag", false);
    }

    public Boolean getGoogleSharingFlag()
    {
        return Boolean.valueOf(gpPrefs.getBoolean("gp_sharing", false));
    }

    public String getGoogleToken()
    {
        return gpPrefs.getString("ext_access_token", null);
    }

    public Date getGoogleTokenExpirationDate()
    {
        Date date = null;
        String s = gpPrefs.getString("ext_token_expr", null);
        if (s != null)
        {
            date = DateUtils.getDateFromString(s);
        }
        return date;
    }

    public String getGoogleUserId()
    {
        return gpPrefs.getString("ext_user_id", null);
    }

    public String getPicUrl()
    {
        return userPrefs.getString("picUrl", null);
    }

    public Boolean getPinterestSharingFlag()
    {
        return Boolean.valueOf(ptPrefs.getBoolean("pin_sharing", false));
    }

    public String getPinterestToken()
    {
        return ptPrefs.getString("ext_access_token", null);
    }

    public String getPinterestUserName()
    {
        return ptPrefs.getString("ext_username", null);
    }

    public Boolean getTumblrSharingFlag()
    {
        return Boolean.valueOf(tmPrefs.getBoolean("tm_sharing", false));
    }

    public String getTumblrToken()
    {
        return tmPrefs.getString("ext_access_token", null);
    }

    public String getTumblrUsername()
    {
        return tmPrefs.getString("ext_username", null);
    }

    public Boolean getTwitterSharingFlag()
    {
        return Boolean.valueOf(twPrefs.getBoolean("tw_sharing", false));
    }

    public String getTwitterToken()
    {
        return twPrefs.getString("ext_access_token", null);
    }

    public String getTwitterUsername()
    {
        return twPrefs.getString("ext_username", null);
    }

    public String getUserABSegment()
    {
        return userPrefs.getString("absegment", null);
    }

    public String getUserId()
    {
        return userPrefs.getString("id", null);
    }

    public String getUserName()
    {
        return userPrefs.getString("username", null);
    }

    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }

    public boolean isPinterestPostDialogShown()
    {
        return userPrefs.getBoolean("pin_post_dialog", false);
    }

    public boolean isPinterestPreDialogShown()
    {
        return userPrefs.getBoolean("pin_pre_dialog", false);
    }

    public boolean isUserAdmin()
    {
        return userPrefs.getBoolean("isAdmin", false);
    }

    public void logout()
    {
        isLoggedIn = false;
        userPrefs.edit().clear().commit();
        fbPrefs.edit().clear().commit();
        twPrefs.edit().clear().commit();
        tmPrefs.edit().clear().commit();
        gpPrefs.edit().clear().commit();
        ptPrefs.edit().clear().commit();
    }

    public void saveSession(UserInfo userinfo)
    {
        updateUserInfo(userinfo.getInfoDetails());
        userPrefs.edit().putString("accessToken", userinfo.getAccessToken()).commit();
        userPrefs.edit().putString("createdAppVersion", userinfo.getUserCreatedAppVersion()).commit();
        userPrefs.edit().putString("createdApiVersion ", userinfo.getUserCreatedApiVersion()).commit();
        isLoggedIn = true;
    }

    public void setDevIP(String s)
    {
        if (EnvConfig.ENV == Env.DEV)
        {
            Context context = PMApplication.getContext();
            PMApplication.getContext();
            context.getSharedPreferences("DEV", 0).edit().putString("IP", s).commit();
        }
    }

    public void setFacebookPostToTimelineFlag(boolean flag)
    {
        userPrefs.edit().putBoolean("postToTimeline", flag).commit();
    }

    public void setFacebookSharingFlag(Boolean boolean1)
    {
        fbPrefs.edit().putBoolean("fb_sharing", boolean1.booleanValue()).commit();
    }

    public void setGCMAppVersion(String s)
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        context.getSharedPreferences("GCMInfo", 0).edit().putString("GCMAppVersion", s).commit();
    }

    public void setGCMLastRegisteredTime(Date date)
    {
        Object obj = PMApplication.getContext();
        PMApplication.getContext();
        obj = ((Context) (obj)).getSharedPreferences("GCMInfo", 0);
        date = DateUtils.getStringFromUTCDate(date);
        ((SharedPreferences) (obj)).edit().putString("GCMLastRegisteredTime", date).commit();
    }

    public void setGCMRegId(String s)
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        context.getSharedPreferences("GCMInfo", 0).edit().putString("GCMRegId", s).commit();
    }

    public void setGCMRegIdSentFlag(boolean flag)
    {
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        context.getSharedPreferences("GCMInfo", 0).edit().putBoolean("GCMRegIdSentFlag", flag).commit();
    }

    public void setGoogleSharingFlag(Boolean boolean1)
    {
        gpPrefs.edit().putBoolean("gp_sharing", boolean1.booleanValue()).commit();
    }

    public void setPinterestPostDialogShown(Boolean boolean1)
    {
        userPrefs.edit().putBoolean("pin_post_dialog", boolean1.booleanValue()).commit();
    }

    public void setPinterestPreDialogShownFlag(Boolean boolean1)
    {
        userPrefs.edit().putBoolean("pin_pre_dialog", boolean1.booleanValue()).commit();
    }

    public void setPinterestSharingFlag(Boolean boolean1)
    {
        ptPrefs.edit().putBoolean("pin_sharing", boolean1.booleanValue()).commit();
    }

    public void setPinterestToken(String s)
    {
        ptPrefs.edit().putString("ext_access_token", s).commit();
    }

    public void setPinterestUserName(String s)
    {
        ptPrefs.edit().putString("ext_username", s).commit();
    }

    public void setSearchVisibilityFlag(boolean flag)
    {
        userPrefs.edit().putBoolean("searchVisibility", flag).commit();
    }

    public void setTumblrSharingFlag(Boolean boolean1)
    {
        tmPrefs.edit().putBoolean("tm_sharing", boolean1.booleanValue()).commit();
    }

    public void setTwitterSharingFlag(Boolean boolean1)
    {
        twPrefs.edit().putBoolean("tw_sharing", boolean1.booleanValue()).commit();
    }

    public void setUserABSegment(String s)
    {
        userPrefs.edit().putString("absegment", s).commit();
    }

    public void updateFacebookData(ExternalServiceInfo externalserviceinfo)
    {
        if (externalserviceinfo != null)
        {
            fbPrefs.edit().putString("ext_user_id", externalserviceinfo.ext_user_id).commit();
            fbPrefs.edit().putString("ext_token_expr", externalserviceinfo.ext_token_expr).commit();
            fbPrefs.edit().putString("ext_username", externalserviceinfo.ext_username).commit();
            fbPrefs.edit().putString("ext_access_token", externalserviceinfo.ext_access_token).commit();
            fbPrefs.edit().putInt("email_permission", externalserviceinfo.ext_permissions.email).commit();
            fbPrefs.edit().putInt("public_profile_permission", externalserviceinfo.ext_permissions.public_profile).commit();
            fbPrefs.edit().putInt("publish_actions_permission", externalserviceinfo.ext_permissions.publish_actions).commit();
            fbPrefs.edit().putInt("user_friends_permission", externalserviceinfo.ext_permissions.user_friends).commit();
        }
    }

    public void updateGoogleData(ExternalServiceInfo externalserviceinfo)
    {
        if (externalserviceinfo != null)
        {
            gpPrefs.edit().putString("ext_user_id", externalserviceinfo.ext_user_id).commit();
            gpPrefs.edit().putString("ext_token_expr", externalserviceinfo.ext_token_expr).commit();
            gpPrefs.edit().putString("ext_username", externalserviceinfo.ext_username).commit();
            gpPrefs.edit().putString("ext_access_token", externalserviceinfo.ext_access_token).commit();
            PMNotificationManager.fireNotification("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED");
        }
    }

    public void updatePinterestData(ExternalServiceInfo externalserviceinfo)
    {
        if (externalserviceinfo != null)
        {
            ptPrefs.edit().putString("ext_user_id", externalserviceinfo.ext_user_id).commit();
            ptPrefs.edit().putString("ext_token_expr", externalserviceinfo.ext_token_expr).commit();
            ptPrefs.edit().putString("ext_username", externalserviceinfo.ext_username).commit();
            ptPrefs.edit().putString("ext_access_token", externalserviceinfo.ext_access_token).commit();
            PMNotificationManager.fireNotification("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED");
        }
    }

    public void updateTumblrData(ExternalServiceInfo externalserviceinfo)
    {
        if (externalserviceinfo != null)
        {
            tmPrefs.edit().putString("ext_user_id", externalserviceinfo.ext_user_id).commit();
            tmPrefs.edit().putString("ext_token_expr", externalserviceinfo.ext_token_expr).commit();
            tmPrefs.edit().putString("ext_username", externalserviceinfo.ext_username).commit();
            tmPrefs.edit().putString("ext_access_token", externalserviceinfo.ext_access_token).commit();
            PMNotificationManager.fireNotification("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED");
        }
    }

    public void updateTwitterData(ExternalServiceInfo externalserviceinfo)
    {
        if (externalserviceinfo != null)
        {
            twPrefs.edit().putString("ext_user_id", externalserviceinfo.ext_user_id).commit();
            twPrefs.edit().putString("ext_token_expr", externalserviceinfo.ext_token_expr).commit();
            twPrefs.edit().putString("ext_username", externalserviceinfo.ext_username).commit();
            twPrefs.edit().putString("ext_access_token", externalserviceinfo.ext_access_token).commit();
            PMNotificationManager.fireNotification("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED");
        }
    }

    public void updateUserInfo(UserInfoDetails userinfodetails)
    {
        updateFacebookData(userinfodetails.getFbInfo());
        updateTwitterData(userinfodetails.getTwitterInfo());
        updateTumblrData(userinfodetails.getTumblrInfo());
        updateGoogleData(userinfodetails.getGPInfo());
        updatePinterestData(userinfodetails.getPnInfo());
        userPrefs.edit().putString("id", userinfodetails.getPMUserId()).commit();
        userPrefs.edit().putString("displayHandle", userinfodetails.getUserDisplayHandle()).commit();
        userPrefs.edit().putString("email", userinfodetails.getUserEmail()).commit();
        userPrefs.edit().putString("firstName", userinfodetails.getUserFirstName()).commit();
        userPrefs.edit().putString("lastName", userinfodetails.getUserLastName()).commit();
        userPrefs.edit().putString("username", userinfodetails.getUserName()).commit();
        userPrefs.edit().putString("picUrl", userinfodetails.getUserSmallPicUrl()).commit();
        userPrefs.edit().putString("shoeSize", userinfodetails.getUserShoeSize()).commit();
        userPrefs.edit().putString("dressSize", userinfodetails.getUserDressSize()).commit();
        userPrefs.edit().putString("city", userinfodetails.getUserCity()).commit();
        userPrefs.edit().putString("state", userinfodetails.getUserState()).commit();
        userPrefs.edit().putString("website", userinfodetails.getUserWebsite()).commit();
        userPrefs.edit().putString("username", userinfodetails.getUserName()).commit();
        userPrefs.edit().putString("loginConnectionType", userinfodetails.getUserLoginConnectionType()).commit();
        userPrefs.edit().putBoolean("searchVisibility", userinfodetails.getSearchVisibilityFlag()).commit();
        userPrefs.edit().putBoolean("postToTimeline", userinfodetails.getPostToTimelineFlag()).commit();
        userPrefs.edit().putString("absegment", userinfodetails.getABSegment()).commit();
        userinfodetails = userinfodetails.getRoles();
        boolean flag1 = false;
        boolean flag = false;
        if (userinfodetails != null)
        {
            int j = userinfodetails.length;
            int i = 0;
            do
            {
                flag1 = flag;
                if (i >= j)
                {
                    break;
                }
                String s = userinfodetails[i];
                flag1 = flag;
                if (s != null)
                {
                    flag1 = flag;
                    if (s.equalsIgnoreCase("admin"))
                    {
                        flag1 = true;
                    }
                }
                i++;
                flag = flag1;
            } while (true);
        }
        userPrefs.edit().putBoolean("isAdmin", flag1).commit();
    }

}
