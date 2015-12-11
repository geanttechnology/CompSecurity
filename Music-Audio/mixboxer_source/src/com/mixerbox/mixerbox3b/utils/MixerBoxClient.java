// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxSharedPreferences, MixerBoxSQLite

public class MixerBoxClient
{

    public static final String MIXERBOX_URL = "http://prod.mixerbox.com/";
    public static String MIXERBOX_URL_PARAMETER = "service?mobile=2";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public MixerBoxClient()
    {
    }

    public static String addSongUrl(String s, SongItem songitem)
    {
        String s1;
        String s2;
        String s5;
        s1 = "";
        s2 = "";
        s5 = "";
        String s3 = URLEncoder.encode(s, "utf-8");
        Object obj;
        String s4;
        s = s1;
        s4 = s2;
        obj = s1;
        if (songitem.getSongId() == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        s4 = s2;
        obj = s1;
        s = URLEncoder.encode(songitem.getSongId(), "utf-8");
        s4 = s2;
        obj = s;
        s2 = URLEncoder.encode(songitem.getSongYtId(), "utf-8");
        s4 = s2;
        obj = s;
        s1 = URLEncoder.encode(songitem.getSongTime(), "utf-8");
        obj = URLEncoder.encode(songitem.getSongName(), "utf-8");
_L2:
        if (songitem.getSongSource() == 3)
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s3).append("&action=add").append("&music%5Bduration%5D=").append(songitem.getSongTime()).append("&music%5Bsource%5D=").append("soundcloud").append("&music%5BstreamUrl%5D=").append("https://api.soundcloud.com/tracks/").append(songitem.getSongYtId()).append("/stream").append("&music%5Bthumbnail%5D=").append(songitem.getSongId()).append("&music%5Btitle%5D=").append(((String) (obj))).append("&music%5BtrackId%5D=").append(songitem.getSongYtId()).append("&music%5B_id%5D=").toString();
        }
        break; /* Loop/switch isn't completed */
        obj;
        s4 = "";
        s3 = s;
        s = s1;
        s1 = s4;
_L3:
        ((UnsupportedEncodingException) (obj)).printStackTrace();
        obj = s5;
        if (true) goto _L2; else goto _L1
_L1:
        if (s.length() != 0)
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s3).append("&action=add").append("&music%5Bf%5D=").append(s2).append("&music%5Bt%5D=yt&music%5Bmb%5D=true&music%5Btm%5D=").append(s1).append("&music%5B_id%5D=").append(s).toString();
        } else
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s3).append("&action=add").append("&music%5Bf%5D=").append(s2).append("&music%5Bt%5D=yt&music%5Bmb%5D=true&music%5Btm%5D=").append(s1).toString();
        }
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s1 = "";
        s2 = s4;
        s = ((String) (obj));
        obj = unsupportedencodingexception;
          goto _L3
        obj;
          goto _L3
    }

    public static String createPlaylistUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&action=create&isPub=1&name=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String followUrl(String s)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=follow&userId=").append(s).toString();
    }

    public static void get(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        client.setTimeout(30000);
        client.get(s, requestparams, asynchttpresponsehandler);
    }

    public static String getArtistAlbumUrl(String s)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=getVector&type=dj&limit=0&vectorId=").append(s).toString();
    }

    public static String getAuthLoginUrl(String s, String s1)
    {
        String s2 = URLEncoder.encode(s, "utf-8");
        s = s2;
        s2 = URLEncoder.encode(s1, "utf-8");
        s1 = s2;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&uuid=").append(s).append("&uuid2=").append(s).append("&funcs=authLoginV2&accessToken=").append(s1).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L3:
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        unsupportedencodingexception;
          goto _L3
    }

    public static String getBatchAddUrl(String s, String s1)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&action=batchAdd&id=").append(s).append(s1).toString();
    }

    public static String getCohortListeningUrl(String s, String s1, String s2, String s3)
    {
        if (s3.length() == 0)
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=listeningV2&uuid=").append(s).append("&musicId=").append(s1).append("&playlistId=").append(s2).toString();
        } else
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=listeningV2&uuid=").append(s).append("&playlistId=").append(s2).append("&f=").append(s3).toString();
        }
    }

    public static String getCohortRegisterUrl(Context context, String s, String s1, String s2, String s3)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/register.php?q=android_register&uuid=").append(s).append("&lang=").append(s1).append("&appkey=").append(MixerBoxSharedPreferences.getPackageName(context)).append("&registrationId=").append(s2).append("&appVer=").append(s3).toString();
    }

    public static String getDJsUrl(Context context, String s)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=getMyFollowing&limit=0&locale=").append(s).toString();
    }

    public static String getExportFailUrl()
    {
        String s = Build.DEVICE;
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=logExternalStorageError&version=").append(android.os.Build.VERSION.SDK_INT).append("&device=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getFollowerUrl(String s)
    {
        String s2 = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=followInfoV2&type=follower&userId=").append(s).append("&locale=").append(s2).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getNewsfeedUrl(Context context, int i)
    {
        String s1 = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        int j = MixerBoxSharedPreferences.getNewsfeedRequestCount(context);
        String s = ((MainPage)context).DB.getLastHistory();
        if (s.length() > 0)
        {
            s = (new StringBuilder()).append("&relYtId=").append(s).toString();
        } else
        {
            s = "";
        }
        if (i == 0)
        {
            j++;
            MixerBoxSharedPreferences.putNewsfeedRequestCount(context, j);
        }
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=newsPage").append("&locale=").append(s1).append("&requestCount=").append(j).append("&limit=20&skip=").append(i * 20).append(s).toString();
    }

    public static String getOnboardingArtistUrl()
    {
        String s = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=getOnboardingArtist&locale=").append(s).toString();
    }

    public static String getSearchUrl(String s, String s1, int i)
    {
        String s2 = URLEncoder.encode(s1, "utf-8");
        s1 = s2;
_L2:
        String s3 = "";
        if (s.length() > 0)
        {
            s3 = (new StringBuilder()).append("&limit=25&category=").append(s).append("&skip=").append(i * 25).toString();
        }
        s = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=searchVideo&q=").append(s1).append("&locale=").append(s).append(s3).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getSongUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=getVector&limit=0&type=playlist&vectorId=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getSubsInfoUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=subsInfoV2&id=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getSysInfoUrl(Long long1, String s)
    {
        String s1 = Build.DEVICE;
        String s2 = URLEncoder.encode(s1, "utf-8");
        s1 = s2;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=sysinfo").append("&locale=").append(s).append("&firstLaunch=").append(String.valueOf(long1)).append("&platform=").append(s1).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getSystemListUrl(Context context, String s)
    {
        int i = MixerBoxSharedPreferences.getSearchRequestCount(context) + 1;
        MixerBoxSharedPreferences.putSearchRequestCount(context, i);
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=searchPage").append("&locale=").append(s).append("&requestCount=").append(i).toString();
    }

    public static String getVectorUrl(String s, int i, String s1)
    {
        String s4 = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        String s2;
        String s3;
        UnsupportedEncodingException unsupportedencodingexception;
        if (s1.equals("dj"))
        {
            s2 = "0";
        } else
        {
            s2 = "20";
        }
        s3 = URLEncoder.encode(s, "utf-8");
        s = s3;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=getVector&vectorId=").append(s).append("&limit=").append(s2).append("&skip=").append(i * 20).append("&type=").append(s1).append("&locale=").append(s4).toString();
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isConnectingToInternet(Context context)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        flag = flag1;
        if (context == null) goto _L2; else goto _L1
_L1:
        context = context.getAllNetworkInfo();
        flag = flag1;
        if (context == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        flag = flag1;
        if (i >= context.length) goto _L2; else goto _L4
_L4:
        if (context[i].getState() != android.net.NetworkInfo.State.CONNECTED) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void post(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        client.setTimeout(30000);
        client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static String removePlaylistUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s).append("&action=rm").toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String removeSongUrl(String s, SongItem songitem, int i)
    {
        Object obj;
        String s1;
        String s4;
        s1 = "";
        obj = "";
        s4 = "";
        String s2 = URLEncoder.encode(s, "utf-8");
        Object obj1;
        String s3;
        obj1 = obj;
        s3 = s1;
        s1 = URLEncoder.encode(songitem.getSongId(), "utf-8");
        obj1 = obj;
        s3 = s1;
        obj = URLEncoder.encode(songitem.getSongYtId(), "utf-8");
        obj1 = obj;
        s3 = s1;
        s = URLEncoder.encode(songitem.getSongName(), "utf-8");
        obj1 = URLEncoder.encode(songitem.getSongName(), "utf-8");
_L1:
        if (songitem.getSongSource() == 3)
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s2).append("&action=rmMusic").append("&music%5Bduration%5D=").append(songitem.getSongTime()).append("&music%5Bsource%5D=").append("soundcloud").append("&music%5BstreamUrl%5D=").append("https://api.soundcloud.com/tracks/").append(songitem.getSongYtId()).append("/stream").append("&music%5Bthumbnail%5D=").append(songitem.getSongThumbnail()).append("&music%5Btitle%5D=").append(((String) (obj1))).append("&music%5BtrackId%5D=").append(songitem.getSongYtId()).append("&music%5B_id%5D=").append(songitem.getSongId()).append("&index=").append(i).toString();
        } else
        {
            return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&action=rmMusic&id=").append(s2).append("&music%5Bid%5D=yt").append(((String) (obj))).append("&music%5B_id%5D=").append(s1).append("&music%5Bf%5D=").append(((String) (obj))).append("&music%5Btt%5D=").append(s).append("&music%5Bt%5D=yt&music%5Bmb%5D=true&index=").append(i).toString();
        }
        obj1;
        s3 = "";
        s2 = s;
        s = s3;
_L2:
        ((UnsupportedEncodingException) (obj1)).printStackTrace();
        obj1 = s4;
          goto _L1
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s = "";
        obj = obj1;
        s1 = s3;
        obj1 = unsupportedencodingexception;
          goto _L2
        obj1;
          goto _L2
    }

    public static String renamePlaylistUrl(String s, String s1)
    {
        String s2 = URLEncoder.encode(s1, "utf-8");
        s1 = s2;
        s2 = URLEncoder.encode(s, "utf-8");
        s = s2;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&id=").append(s).append("&action=rename&name=").append(s1).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L3:
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        unsupportedencodingexception;
          goto _L3
    }

    public static String reorderUrl(String s)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=changePlaylist&action=reorder&playlistId=").append(s).toString();
    }

    public static void reset()
    {
        client = new AsyncHttpClient();
    }

    public static String subsPlaylistUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&action=subs&id=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String unfollowUrl(String s)
    {
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=unfollow&userId=").append(s).toString();
    }

    public static String unsubsPlaylistUrl(String s)
    {
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L2:
        return (new StringBuilder()).append("http://prod.mixerbox.com/").append(MIXERBOX_URL_PARAMETER).append("&funcs=mChangePlaylist&action=unsubs&id=").append(s).toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

}
