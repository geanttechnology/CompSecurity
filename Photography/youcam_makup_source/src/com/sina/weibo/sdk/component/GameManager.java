// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.sina.weibo.sdk.component:
//            GameRequestParam, BrowserLauncher, WeiboSdkBrowser

public class GameManager
{

    private static final String BOUNDARY = HttpManager.getBoundry();
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static String INVITATION_ONE_FRINED_URL = "http://widget.weibo.com/invitation/appinfo.php?";
    private static String INVITATION_URL = "http://widget.weibo.com/invitation/app.php?";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String TAG = "GameManager";
    private static StringBuffer URL;
    private static String URL_ACHIEVEMENT_ADD_UPDATE;
    private static String URL_ACHIEVEMENT_READ_PLAYER_FRIENDS;
    private static String URL_ACHIEVEMENT_READ_PLAYER_SCORE;
    private static String URL_ACHIEVEMENT_RELATION_ADD_UPDATE;
    private static String URL_ACHIEVEMENT_SCORE_ADD_UPDATE;
    private static String URL_ACHIEVEMENT_USER_GAIN;

    public GameManager()
    {
    }

    public static String AddOrUpdateGameAchievement(Context context, WeiboParameters weiboparameters)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboparameters.put("updated_time", simpledateformat.format(date));
        if (TextUtils.isEmpty((String)weiboparameters.get("create_time")))
        {
            weiboparameters.put("create_time", simpledateformat.format(date));
        }
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_ADD_UPDATE, "POST", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String addOrUpdateAchievementScore(Context context, String s, String s1, String s2, String s3, String s4)
    {
        WeiboParameters weiboparameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(s))
        {
            weiboparameters.put("access_token", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            weiboparameters.put("source", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            weiboparameters.put("game_id", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            weiboparameters.put("uid", s3);
        }
        if (!TextUtils.isEmpty(s4))
        {
            weiboparameters.put("score", s4);
        }
        s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s1 = new Date();
        weiboparameters.put("updated_time", s.format(s1));
        if (TextUtils.isEmpty((String)weiboparameters.get("create_time")))
        {
            weiboparameters.put("create_time", s.format(s1));
        }
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_SCORE_ADD_UPDATE, "POST", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String addOrUpdateGameAchievementRelation(Context context, WeiboParameters weiboparameters)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboparameters.put("updated_time", simpledateformat.format(date));
        if (TextUtils.isEmpty((String)weiboparameters.get("create_time")))
        {
            weiboparameters.put("create_time", simpledateformat.format(date));
        }
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_RELATION_ADD_UPDATE, "POST", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String readPlayerAchievementGain(Context context, String s, String s1, String s2, String s3)
    {
        WeiboParameters weiboparameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(s))
        {
            weiboparameters.put("access_token", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            weiboparameters.put("source", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            weiboparameters.put("game_id", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            weiboparameters.put("uid", s3);
        }
        weiboparameters.put("create_time", new Timestamp((new Date()).getTime()));
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_USER_GAIN, "GET", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String readPlayerFriendsScoreInfo(Context context, String s, String s1, String s2, String s3)
    {
        WeiboParameters weiboparameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(s))
        {
            weiboparameters.put("access_token", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            weiboparameters.put("source", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            weiboparameters.put("game_id", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            weiboparameters.put("uid", s3);
        }
        weiboparameters.put("create_time", new Timestamp((new Date()).getTime()));
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_FRIENDS, "GET", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String readPlayerScoreInfo(Context context, String s, String s1, String s2, String s3)
    {
        WeiboParameters weiboparameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(s))
        {
            weiboparameters.put("access_token", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            weiboparameters.put("source", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            weiboparameters.put("game_id", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            weiboparameters.put("uid", s3);
        }
        context = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_SCORE, "GET", weiboparameters));
        LogUtil.d("GameManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    private static HttpResponse requestHttpExecute(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        context = null;
        obj = null;
        obj4 = null;
        obj2 = null;
        Object obj1 = HttpManager.getNewHttpClient();
        context = ((Context) (obj1));
        obj = obj3;
        obj1 = obj4;
        context.getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
        obj = obj3;
        obj1 = obj4;
        if (!s1.equals("GET")) goto _L2; else goto _L1
_L1:
        obj = obj3;
        obj1 = obj4;
        s1 = (new StringBuilder(String.valueOf(s))).append("?").append(weiboparameters.encodeUrl()).toString();
        obj = obj3;
        obj1 = obj4;
        s = new HttpGet(s1);
        obj = obj3;
        obj1 = obj4;
        LogUtil.d("GameManager", (new StringBuilder("requestHttpExecute GET Url : ")).append(s1).toString());
        s1 = obj2;
_L7:
        obj = s1;
        obj1 = s1;
        s = context.execute(s);
        obj = s1;
        obj1 = s1;
        int i = s.getStatusLine().getStatusCode();
        if (i == 200) goto _L4; else goto _L3
_L3:
        obj = s1;
        obj1 = s1;
        try
        {
            throw new WeiboHttpException(HttpManager.readRsponse(s), i);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s = context;
        }
        finally
        {
            s1 = ((String) (obj1));
        }
        context = ((Context) (obj));
_L13:
        throw new WeiboException(s1);
        obj;
        weiboparameters = s;
        s1 = context;
        s = ((String) (obj));
_L10:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        HttpManager.shutdownHttpClient(weiboparameters);
        throw s;
_L2:
        obj = obj3;
        obj1 = obj4;
        if (!s1.equals("POST"))
        {
            break MISSING_BLOCK_LABEL_493;
        }
        obj = obj3;
        obj1 = obj4;
        LogUtil.d("GameManager", (new StringBuilder("requestHttpExecute POST Url : ")).append(s).toString());
        obj = obj3;
        obj1 = obj4;
        s1 = new HttpPost(s);
        obj = obj3;
        obj1 = obj4;
        s = new ByteArrayOutputStream();
        if (!weiboparameters.hasBinaryData()) goto _L6; else goto _L5
_L5:
        s1.setHeader("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(BOUNDARY).toString());
        HttpManager.buildParams(s, weiboparameters);
_L8:
        s1.setEntity(new ByteArrayEntity(s.toByteArray()));
        weiboparameters = s;
        s = s1;
        s1 = weiboparameters;
          goto _L7
_L6:
        obj = weiboparameters.get("content-type");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_470;
        }
        if (!(obj instanceof String))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        weiboparameters.remove("content-type");
        s1.setHeader("Content-Type", (String)obj);
_L9:
        weiboparameters = weiboparameters.encodeUrl();
        LogUtil.d("GameManager", (new StringBuilder("requestHttpExecute POST postParam : ")).append(weiboparameters).toString());
        s.write(weiboparameters.getBytes("UTF-8"));
          goto _L8
        s1.setHeader("Content-Type", "application/x-www-form-urlencoded");
          goto _L9
        weiboparameters;
        s1 = s;
        s = weiboparameters;
        weiboparameters = context;
          goto _L10
        obj = obj3;
        obj1 = obj4;
        if (!s1.equals("DELETE")) goto _L12; else goto _L11
_L11:
        obj = obj3;
        obj1 = obj4;
        s = new HttpDelete(s);
        s1 = obj2;
          goto _L7
        weiboparameters = context;
          goto _L10
_L4:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        HttpManager.shutdownHttpClient(context);
        return s;
        s;
        weiboparameters = null;
        s1 = ((String) (obj));
          goto _L10
        s1;
        s = null;
          goto _L13
_L12:
        s = null;
        s1 = obj2;
          goto _L7
        s1;
        weiboparameters = context;
        context = s;
        s = weiboparameters;
          goto _L13
    }

    public void invatationWeiboFriendsByList(Context context, String s, String s1, String s2, WeiboAuthListener weiboauthlistener)
    {
        Object obj = new WeiboParameters(s1);
        ((WeiboParameters) (obj)).put("access_token", s);
        ((WeiboParameters) (obj)).put("source", s1);
        String s3 = (new StringBuilder(String.valueOf(INVITATION_URL.toString()))).append(((WeiboParameters) (obj)).encodeUrl()).toString();
        obj = new GameRequestParam(context);
        ((GameRequestParam) (obj)).setAppKey(s1);
        ((GameRequestParam) (obj)).setToken(s);
        ((GameRequestParam) (obj)).setLauncher(BrowserLauncher.GAME);
        ((GameRequestParam) (obj)).setUrl(s3);
        ((GameRequestParam) (obj)).setAuthListener(weiboauthlistener);
        s = new Intent(context, com/sina/weibo/sdk/component/WeiboSdkBrowser);
        s1 = ((GameRequestParam) (obj)).createRequestParamBundle();
        s1.putString("key_specify_title", s2);
        s.putExtras(s1);
        context.startActivity(s);
    }

    public void invatationWeiboFriendsInOnePage(Context context, String s, String s1, String s2, WeiboAuthListener weiboauthlistener, ArrayList arraylist)
    {
        Object obj = new StringBuffer();
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < arraylist.size()) goto _L3; else goto _L2
_L2:
        arraylist = new WeiboParameters(s1);
        arraylist.put("access_token", s);
        arraylist.put("source", s1);
        obj = (new StringBuilder(String.valueOf(INVITATION_ONE_FRINED_URL.toString()))).append(arraylist.encodeUrl()).append("&uids=").append(((StringBuffer) (obj)).toString()).toString();
        arraylist = new GameRequestParam(context);
        arraylist.setAppKey(s1);
        arraylist.setToken(s);
        arraylist.setLauncher(BrowserLauncher.GAME);
        arraylist.setUrl(((String) (obj)));
        arraylist.setAuthListener(weiboauthlistener);
        s = new Intent(context, com/sina/weibo/sdk/component/WeiboSdkBrowser);
        s1 = arraylist.createRequestParamBundle();
        s1.putString("key_specify_title", s2);
        s.putExtras(s1);
        context.startActivity(s);
        return;
_L3:
        String s3 = (String)arraylist.get(i);
        if (i == 0)
        {
            ((StringBuffer) (obj)).append(s3);
        } else
        {
            ((StringBuffer) (obj)).append((new StringBuilder(",")).append(s3).toString());
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        URL = new StringBuffer("https://api.weibo.com/2/proxy/darwin/graph/game/");
        URL_ACHIEVEMENT_ADD_UPDATE = (new StringBuilder()).append(URL).append("achievement/add.json").toString();
        URL_ACHIEVEMENT_RELATION_ADD_UPDATE = (new StringBuilder()).append(URL).append("achievement/gain/add.json").toString();
        URL_ACHIEVEMENT_SCORE_ADD_UPDATE = (new StringBuilder()).append(URL).append("score/add.json").toString();
        URL_ACHIEVEMENT_READ_PLAYER_SCORE = (new StringBuilder()).append(URL).append("score/read_player.json").toString();
        URL_ACHIEVEMENT_READ_PLAYER_FRIENDS = (new StringBuilder()).append(URL).append("score/read_player_friends.json").toString();
        URL_ACHIEVEMENT_USER_GAIN = (new StringBuilder()).append(URL).append("achievement/user_gain.json").toString();
    }
}
