// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.aio.downloader.activity.AppRecommendKeywordsActivity;
import com.aio.downloader.model.AppdetailModel;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.model.SearcherPromitModel;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.utils:
//            publicTools

public class Myutils
{

    public static final String APP_CACAHE_DIRNAME = "webcache";
    public static final String BasehitsUrl = "http://android.downloadatoz.com/_201409/market/hits.php?type=";
    public static final int TYPE_ALARM = 4;
    public static final int TYPE_ALL = 7;
    public static final int TYPE_NOTIFICATION = 2;
    public static final int TYPE_RINGTONE = 1;
    public static final String andmob_full = "ca-app-pub-1054623928013334/3671172209";
    public static final String banner_type_name = "ca-app-pub-2192624499353475/5842010949";
    public static int big_ad_interval = 0;
    public static final String cachePath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("com.allinone.free").toString();
    public static String contactus_url_home = "http://android.downloadatoz.com/_201409/market/contact.php?type=more_features";
    public static String contactus_url_setting = "http://android.downloadatoz.com/_201409/market/contact.php";
    public static boolean detail_save = false;
    public static File dir = Environment.getExternalStorageDirectory();
    public static final String facebookgift = "340186902832477_401790893338744";
    public static final String facebooklist = "340186902832477_394762884041545";
    public static boolean fb_ad = false;
    public static final String fbappfeature = "340186902832477_388101491374351";
    public static final String fbdownloadgift = "340186902832477_436045469913286";
    public static final String fbdownloadmanager = "340186902832477_436045399913293";
    public static final String fbgamefeature = "340186902832477_388101491374351";
    public static final String fbhome = "340186902832477_436045309913302";
    public static final String fbmusthave = "340186902832477_388101491374351";
    public static final String fbmyapp = "340186902832477_388101491374351";
    public static final String fbtodaypick = "340186902832477_388101491374351";
    public static final String fbuninstall = "340186902832477_388101491374351";
    public static final String fbupdategift = "340186902832477_436045659913267";
    public static final String fbupdatetop = "340186902832477_388101491374351";
    public static boolean gamefan = false;
    public static Long getoffset = null;
    public static String hint = "";
    public static String hintid = "";
    public static final String inmobbannerid = "bf34144de1cf4616bca0c4acbdd94860";
    public static final String inmobigift = "dd15bc6e28814b60a1b162840af80d88";
    public static final String inmobilist = "cabf4e2618d24d6c84d7b2d7562f6b7d";
    private static Myutils instance = null;
    public static boolean iscleaner = false;
    public static boolean iswidget = false;
    public static boolean iswidget2 = false;
    public static boolean iswidget_float = false;
    public static String jsonfile = "";
    public static long last_time_show_big_ad = 0L;
    public static int laststate = 0;
    public static List list;
    public static ArrayList list_array;
    public static int number = 0;
    public static String packagename = "";
    public static String packagename2 = "com.aio.downloader";
    public static String searchkeywords = null;
    public static JSONObject setting_json;
    public static boolean shotcut = false;
    public static Boolean showimg = Boolean.valueOf(false);
    public static int status = 0;
    public static DownloadMovieItem successItem;
    public static boolean today_save = false;
    public static String type_current;
    public static final String version = "3.3.9";

    public Myutils()
    {
        list = new ArrayList();
    }

    public static void MaoPao()
    {
        int ai[];
        int i;
        ai = new int[10];
        ai;
        ai[0] = 87;
        ai[1] = 25;
        ai[2] = 4;
        ai[3] = 22;
        ai[4] = 2;
        ai[5] = 56;
        ai[6] = 11;
        ai[7] = 28;
        ai[8] = 35;
        ai[9] = 15;
        i = 0;
_L2:
        if (i >= ai.length)
        {
            return;
        }
        int j = 0;
        do
        {
label0:
            {
                if (j < ai.length - 1)
                {
                    break label0;
                }
                i++;
            }
            if (true)
            {
                continue;
            }
            if (ai[i] >= ai[j])
            {
                int k = ai[i];
                ai[i] = ai[j];
                ai[j] = k;
            }
            j++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void copyfile(File file, File file1, Boolean boolean1)
    {
        while (!file.exists() || !file.isFile() || !file.canRead()) 
        {
            return;
        }
        if (!file1.getParentFile().exists())
        {
            file1.getParentFile().mkdirs();
        }
        if (file1.exists() && boolean1.booleanValue())
        {
            file1.delete();
        }
        file = new FileInputStream(file);
        file1 = new FileOutputStream(file1);
        boolean1 = new byte[1024];
_L1:
        int i = file.read(boolean1);
        if (i <= 0)
        {
            try
            {
                file.close();
                file1.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
        }
        file1.write(boolean1, 0, i);
          goto _L1
    }

    public static String doHttpPost(String s, HashMap hashmap)
    {
        DefaultHttpClient defaulthttpclient;
        Object obj;
        obj = new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
        defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 5000);
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 5000);
        ConnManagerParams.setTimeout(defaulthttpclient.getParams(), 5000);
        s = new HttpPost(s);
        s.setHeaders(new BasicHeader[] {
            obj
        });
        obj = new ArrayList();
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        hashmap = hashmap.entrySet().iterator();
_L5:
        if (hashmap.hasNext()) goto _L3; else goto _L2
_L2:
        java.util.Map.Entry entry;
        try
        {
            s.setEntity(new UrlEncodedFormEntity(((List) (obj)), "UTF-8"));
            s = defaulthttpclient.execute(s);
            if (s.getStatusLine().getStatusCode() != 200)
            {
                break; /* Loop/switch isn't completed */
            }
            s = EntityUtils.toString(s.getEntity(), "UTF-8");
            Log.e("gog", (new StringBuilder("result=")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "TIMEOUTERROR";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "OTHERERROR";
        }
        return s;
_L3:
        entry = (java.util.Map.Entry)hashmap.next();
        ((ArrayList) (obj)).add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
        if (true) goto _L5; else goto _L4
_L4:
        s = (new StringBuilder(String.valueOf(EntityUtils.toString(s.getEntity(), "UTF-8")))).append(s.getStatusLine().getStatusCode()).append("ERROR").toString();
        Log.e("gog", (new StringBuilder("ERRORresult=")).append(s).toString());
        return s;
    }

    public static int excuteSuCMD(String s)
    {
        int i;
        try
        {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream dataoutputstream = new DataOutputStream(process.getOutputStream());
            dataoutputstream.writeBytes("export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n");
            dataoutputstream.writeBytes((new StringBuilder(String.valueOf(String.valueOf(s)))).append("\n").toString());
            dataoutputstream.flush();
            dataoutputstream.writeBytes("exit\n");
            dataoutputstream.flush();
            process.waitFor();
            i = Integer.valueOf(process.exitValue()).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return -1;
        }
        return i;
    }

    public static String formatTime(long l)
    {
        String s;
        String s2;
        s = (new StringBuilder(String.valueOf(l / 60000L))).toString();
        s2 = (new StringBuilder(String.valueOf(l % 60000L))).toString();
        String s1;
        if (s.length() < 2)
        {
            s1 = (new StringBuilder("0")).append(l / 60000L).toString();
        } else
        {
            s1 = (new StringBuilder(String.valueOf(l / 60000L))).toString();
        }
        if (s2.length() != 4) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder("0")).append(l % 60000L).toString();
_L4:
        return (new StringBuilder(String.valueOf(s1))).append(":").append(s.trim().substring(0, 2)).toString();
_L2:
        if (s2.length() == 3)
        {
            s = (new StringBuilder("00")).append(l % 60000L).toString();
        } else
        if (s2.length() == 2)
        {
            s = (new StringBuilder("000")).append(l % 60000L).toString();
        } else
        {
            s = s2;
            if (s2.length() == 1)
            {
                s = (new StringBuilder("0000")).append(l % 60000L).toString();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList funList(String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list_array = new ArrayList();
        int k;
        s = new JSONObject(s);
        k = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int l;
        jsonarray = s.getJSONArray("list");
        l = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L8:
        if (i < l) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new FunModel();
        Object obj;
        obj = jsonarray.getJSONObject(i);
        s.setTitle(((JSONObject) (obj)).getString("title"));
        s.setThu_path(((JSONObject) (obj)).getString("thu_path"));
        s.setLike_count(((JSONObject) (obj)).getString("like_count"));
        s.setShare_count(((JSONObject) (obj)).getString("share_count"));
        s.setImg_count(((JSONObject) (obj)).getInt("img_count"));
        s.setCreate_time(((JSONObject) (obj)).getString("create_time"));
        s.setVideo_src(((JSONObject) (obj)).getString("video_src"));
        s.setImg_src(((JSONObject) (obj)).getString("img_src"));
        s.setSerial(((JSONObject) (obj)).getString("serial"));
        s.setCat(((JSONObject) (obj)).getString("cat"));
        s.setSave(((JSONObject) (obj)).getString("score"));
        s.setHas_next_page(k);
        obj = ((JSONObject) (obj)).getJSONArray("img_src_array");
        s.setFunlist(new ArrayList());
        int j = 0;
_L4:
        if (j < ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_263;
        }
        arraylist.add(s);
        i++;
        continue; /* Loop/switch isn't completed */
        ((FunModel) (s)).funlist.add(((JSONArray) (obj)).getString(j));
        j++;
          goto _L4
        s;
_L6:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static ArrayList fun_appList(String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list_array = new ArrayList();
        int k;
        s = new JSONObject(s);
        k = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int l;
        jsonarray = s.getJSONArray("list");
        l = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L8:
        if (i < l) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new Fun_appModel();
        Object obj;
        obj = jsonarray.getJSONObject(i);
        s.setTitle(((JSONObject) (obj)).getString("title"));
        s.setThu_path(((JSONObject) (obj)).getString("thu_path"));
        s.setLike_count(((JSONObject) (obj)).getString("like_count"));
        s.setShare_count(((JSONObject) (obj)).getString("share_count"));
        s.setImg_count(((JSONObject) (obj)).getInt("img_count"));
        s.setCreate_time(((JSONObject) (obj)).getString("create_time"));
        s.setVideo_src(((JSONObject) (obj)).getString("video_src"));
        s.setImg_src(((JSONObject) (obj)).getString("img_src"));
        s.setSerial(((JSONObject) (obj)).getString("serial"));
        s.setCat(((JSONObject) (obj)).getString("cat"));
        s.setSave(((JSONObject) (obj)).getString("score"));
        s.setHas_next_page(k);
        obj = ((JSONObject) (obj)).getJSONArray("img_src_array");
        s.setFunlist(new ArrayList());
        int j = 0;
_L4:
        if (j < ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_263;
        }
        arraylist.add(s);
        i++;
        continue; /* Loop/switch isn't completed */
        ((Fun_appModel) (s)).funlist.add(((JSONArray) (obj)).getString(j));
        j++;
          goto _L4
        s;
_L6:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static byte[] getBytes(InputStream inputstream)
        throws Exception
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                inputstream.close();
                bytearrayoutputstream.flush();
                return bytearrayoutputstream.toByteArray();
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
    }

    public static Bitmap getImage(String s)
    {
        try
        {
            s = getBytes(new FileInputStream(new File(s)));
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            options.inInputShareable = true;
            options.inPurgeable = true;
            s = BitmapFactory.decodeByteArray(s, 0, s.length, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Myutils getInstance()
    {
        if (instance == null)
        {
            instance = new Myutils();
        }
        return instance;
    }

    public static String getVersionName(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static AppdetailModel parseAppdetail(String s)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        JSONObject jsonobject = new JSONObject(s);
        s = obj1;
        if (jsonobject.getInt("status") != 1)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        s = new AppdetailModel();
        obj = jsonobject.getJSONObject("pdt");
        s.setId(((JSONObject) (obj)).getString("id"));
        s.setTitle(((JSONObject) (obj)).getString("title"));
        s.setAuthor_title(((JSONObject) (obj)).getString("author_title"));
        s.setIcon(((JSONObject) (obj)).getString("icon"));
        s.setRating(Float.parseFloat(((JSONObject) (obj)).getString("rating")));
        s.setVersion(((JSONObject) (obj)).getString("version"));
        s.setRelease_date(((JSONObject) (obj)).getString("release_date"));
        s.setDownloads(((JSONObject) (obj)).getString("downloads"));
        s.setSize(((JSONObject) (obj)).getString("size"));
        s.setPrice(((JSONObject) (obj)).getString("price"));
        s.setDetail(((JSONObject) (obj)).getString("detail"));
        s.setScreenshots(((JSONObject) (obj)).getString("screenshots"));
        s.setHas_apk(((JSONObject) (obj)).getString("has_apk"));
        return s;
        s;
_L2:
        s.printStackTrace();
        return ((AppdetailModel) (obj));
        JSONException jsonexception;
        jsonexception;
        obj = s;
        s = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static ArrayList parseApplist(String s)
    {
        ArrayList arraylist = new ArrayList();
        int j;
        s = new JSONObject(s);
        j = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int k;
        jsonarray = s.getJSONArray("list");
        k = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new DownloadMovieItem();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setSerial(jsonobject.getInt("serial"));
        s.setTitle(jsonobject.getString("title"));
        s.setAuthor_title(jsonobject.getString("author_title"));
        s.setIcon(jsonobject.getString("icon"));
        s.setSize(jsonobject.getString("size"));
        s.setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
        s.setPrice(jsonobject.getString("price"));
        s.setHas_apk(jsonobject.getString("has_apk"));
        s.setIs_official(jsonobject.getString("is_official"));
        s.setHas_next_page(j);
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parseMp3list(String s)
    {
        ArrayList arraylist = new ArrayList();
        int j;
        s = new JSONObject(s);
        j = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int k;
        jsonarray = s.getJSONArray("list");
        k = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new DownloadMovieItem();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setTitle(jsonobject.getString("title"));
        s.setAlbum_title(jsonobject.getString("album_title"));
        s.setArtist_title(jsonobject.getString("artist_title"));
        s.setSize(jsonobject.getString("size"));
        s.setHas_next_page(j);
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parseRingtonelist(String s)
    {
        ArrayList arraylist = new ArrayList();
        int j;
        s = new JSONObject(s);
        j = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int k;
        jsonarray = s.getJSONArray("list");
        k = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new DownloadMovieItem();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setTitle(jsonobject.getString("title"));
        s.setCat(jsonobject.getString("cat"));
        s.setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
        s.setSize(jsonobject.getString("size"));
        s.setHas_next_page(j);
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parseSearchKeywords(String s)
    {
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray;
        int j;
        jsonarray = new JSONArray(s);
        jsonarray.length();
        j = AppRecommendKeywordsActivity.search1;
        Log.e("qwa", (new StringBuilder("sear=")).append(j).toString());
        int i;
        i = j;
        s = null;
_L2:
        if (i >= j + 10)
        {
            return arraylist;
        }
        s = new SearchkeywordModel();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setKeyword(jsonobject.getString("keyword"));
        arraylist.add(s);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
_L4:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList parsearchpromitlist(String s)
    {
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray;
        int j;
        jsonarray = new JSONArray(s);
        j = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L2:
        if (i >= j)
        {
            return arraylist;
        }
        s = new SearcherPromitModel();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setT(jsonobject.getString("t"));
        s.setS(jsonobject.getString("s"));
        arraylist.add(s);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
_L4:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList parsefeatured(String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        boolean flag = false;
        int k;
        s = new JSONObject(s);
        k = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = s.getJSONArray("list");
        int i = 0;
_L12:
        if (i >= jsonarray.length())
        {
            return arraylist;
        }
        ArrayList arraylist1;
        JSONObject jsonobject1;
        arraylist1 = new ArrayList();
        jsonobject1 = jsonarray.getJSONObject(i);
        Object obj;
        String s13;
        obj = null;
        s13 = null;
        s = ((String) (obj));
        Object obj1 = new JSONObject(jsonobject1.getString("info"));
        s = ((String) (obj));
        String s14 = ((JSONObject) (obj1)).getString("title");
        s = s14;
        obj = ((JSONObject) (obj1)).getString("search_keyword");
        s13 = ((String) (obj));
_L10:
        Object obj2;
        Object obj3;
        String s1;
        Object obj4;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        Object obj5;
        String s9;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        String s10;
        String s11;
        String s12;
        String s15;
        Object obj10;
        Object obj11;
        JSONObject jsonobject;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        s15 = null;
        obj19 = null;
        s8 = null;
        obj18 = null;
        obj8 = null;
        obj17 = null;
        s10 = null;
        obj16 = null;
        s5 = null;
        obj15 = null;
        s7 = null;
        obj14 = null;
        obj9 = null;
        obj13 = null;
        obj7 = null;
        obj12 = null;
        obj6 = null;
        jsonobject = null;
        obj5 = null;
        obj11 = null;
        s9 = null;
        obj10 = null;
        s6 = null;
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = obj19;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj18;
        obj = obj14;
        s11 = s15;
        s = obj17;
        JSONObject jsonobject2 = new JSONObject(jsonobject1.getString("banner"));
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = obj19;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj18;
        obj = obj14;
        s11 = s15;
        s = obj17;
        s15 = jsonobject2.getString("status");
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = obj19;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj18;
        obj = obj14;
        s11 = s15;
        s = obj17;
        if (!s15.equals("1"))
        {
            break MISSING_BLOCK_LABEL_965;
        }
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = obj19;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj18;
        obj = obj14;
        s11 = s15;
        s = obj17;
        s8 = jsonobject2.getString("id");
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj18;
        obj = obj14;
        s11 = s15;
        s = obj17;
        obj8 = jsonobject2.getString("serial");
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj8;
        obj = obj14;
        s11 = s15;
        s = obj17;
        s10 = jsonobject2.getString("title");
        s4 = obj16;
        s12 = obj10;
        s3 = obj15;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj8;
        obj = obj14;
        s11 = s15;
        s = s10;
        s5 = jsonobject2.getString("author_title");
        s4 = s5;
        s12 = obj10;
        s3 = obj15;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj8;
        obj = obj14;
        s11 = s15;
        s = s10;
        s7 = jsonobject2.getString("icon");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj8;
        obj = obj14;
        s11 = s15;
        s = s10;
        obj9 = jsonobject2.getString("size");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj13;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        obj7 = jsonobject2.getString("rating");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj12;
        obj2 = obj7;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        obj6 = jsonobject2.getString("price");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = jsonobject;
        s1 = obj11;
        obj3 = obj6;
        obj2 = obj7;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        obj5 = jsonobject2.getString("is_official");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = obj5;
        s1 = obj11;
        obj3 = obj6;
        obj2 = obj7;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        s9 = jsonobject2.getString("link_url");
        s4 = s5;
        s12 = obj10;
        s3 = s7;
        s2 = s8;
        obj4 = obj5;
        s1 = s9;
        obj3 = obj6;
        obj2 = obj7;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        s6 = jsonobject2.getString("has_apk");
        s4 = s5;
        s12 = s6;
        s3 = s7;
        s2 = s8;
        obj4 = obj5;
        s1 = s9;
        obj3 = obj6;
        obj2 = obj7;
        obj1 = obj8;
        obj = obj9;
        s11 = s15;
        s = s10;
        Log.e("yyyy", s15);
        s11 = s15;
        s4 = s5;
_L9:
        obj11 = null;
        obj4 = null;
        obj10 = null;
        obj2 = null;
        s15 = null;
        obj3 = null;
        s12 = null;
        s1 = null;
        s5 = null;
        obj1 = obj10;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = obj11;
        jsonobject = new JSONObject(jsonobject1.getString("minigame"));
        obj1 = obj10;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = obj11;
        s5 = jsonobject.getString("status");
        obj1 = obj10;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = obj11;
        if (!s5.equals("1"))
        {
            break MISSING_BLOCK_LABEL_1246;
        }
        obj1 = obj10;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = obj11;
        obj4 = jsonobject.getString("title");
        obj1 = obj10;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = ((String) (obj4));
        obj2 = jsonobject.getString("detail");
        obj1 = obj2;
        obj = s15;
        s3 = s12;
        s2 = s5;
        s = ((String) (obj4));
        obj3 = jsonobject.getString("icon");
        obj1 = obj2;
        obj = obj3;
        s3 = s12;
        s2 = s5;
        s = ((String) (obj4));
        s1 = jsonobject.getString("link");
        obj1 = obj2;
        obj = obj3;
        s3 = s1;
        s2 = s5;
        s = ((String) (obj4));
        Log.e("serty", s5);
        s = ((String) (obj4));
        s2 = s5;
        obj = obj3;
        obj1 = obj2;
_L7:
        obj2 = new JSONArray(jsonobject1.getString("app"));
        int j = 0;
_L3:
        if (j < ((JSONArray) (obj2)).length())
        {
            break MISSING_BLOCK_LABEL_1328;
        }
        arraylist.add(arraylist1);
        i++;
        continue; /* Loop/switch isn't completed */
        obj3 = new DownloadMovieItem();
        ((DownloadMovieItem) (obj3)).setHas_next_page(k);
        ((DownloadMovieItem) (obj3)).setInfotitle(s14);
        ((DownloadMovieItem) (obj3)).setSearch_keyword(s13);
        ((DownloadMovieItem) (obj3)).setBannerstatus(s11);
        ((DownloadMovieItem) (obj3)).setBannerid(s8);
        ((DownloadMovieItem) (obj3)).setBannerserial(((String) (obj8)));
        ((DownloadMovieItem) (obj3)).setBannertitle(s10);
        ((DownloadMovieItem) (obj3)).setBannerauthor_title(s4);
        ((DownloadMovieItem) (obj3)).setBannericon(s7);
        ((DownloadMovieItem) (obj3)).setBannersize(((String) (obj9)));
        ((DownloadMovieItem) (obj3)).setBannerrating(((String) (obj7)));
        ((DownloadMovieItem) (obj3)).setBannerprice(((String) (obj6)));
        ((DownloadMovieItem) (obj3)).setBannerisoffical(((String) (obj5)));
        ((DownloadMovieItem) (obj3)).setBannerlink_url(s9);
        ((DownloadMovieItem) (obj3)).setBannerhas_apk(s6);
        ((DownloadMovieItem) (obj3)).setMinigamestatus(s2);
        ((DownloadMovieItem) (obj3)).setMinigametitle(s);
        ((DownloadMovieItem) (obj3)).setDetail(((String) (obj1)));
        ((DownloadMovieItem) (obj3)).setMinigameicon(((String) (obj)));
        ((DownloadMovieItem) (obj3)).setLink(s1);
        obj4 = ((JSONArray) (obj2)).getJSONObject(j);
        ((DownloadMovieItem) (obj3)).setId(((JSONObject) (obj4)).getString("id"));
        ((DownloadMovieItem) (obj3)).setSerial(((JSONObject) (obj4)).getInt("serial"));
        ((DownloadMovieItem) (obj3)).setTitle(((JSONObject) (obj4)).getString("title"));
        ((DownloadMovieItem) (obj3)).setAuthor_title(((JSONObject) (obj4)).getString("author_title"));
        ((DownloadMovieItem) (obj3)).setIcon(((JSONObject) (obj4)).getString("icon"));
        ((DownloadMovieItem) (obj3)).setSize(((JSONObject) (obj4)).getString("size"));
        ((DownloadMovieItem) (obj3)).setRating(Float.valueOf(Float.parseFloat(((JSONObject) (obj4)).getString("rating"))));
        ((DownloadMovieItem) (obj3)).setPrice(((JSONObject) (obj4)).getString("price"));
        ((DownloadMovieItem) (obj3)).setIs_official(((JSONObject) (obj4)).getString("is_official"));
        ((DownloadMovieItem) (obj3)).setLink_url(((JSONObject) (obj4)).getString("link_url"));
        ((DownloadMovieItem) (obj3)).setHas_apk(((JSONObject) (obj4)).getString("has_apk"));
        arraylist1.add(obj3);
        j++;
        boolean flag1 = false;
          goto _L3
        s;
_L5:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L5; else goto _L4
_L4:
        obj2;
        s1 = s3;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception1;
        exception1;
        s6 = s12;
        s7 = s3;
        s8 = s2;
        obj5 = obj4;
        s9 = s1;
        obj6 = obj3;
        obj7 = obj2;
        obj8 = obj1;
        obj9 = obj;
        s10 = s;
        if (true) goto _L9; else goto _L8
_L8:
        Exception exception;
        exception;
        s14 = s;
        if (true) goto _L10; else goto _L2
_L2:
        return arraylist;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static ArrayList parseminigamelist(String s)
    {
        ArrayList arraylist = new ArrayList();
        int j;
        s = new JSONObject(s);
        j = s.getInt("next");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int k;
        jsonarray = s.getJSONArray("game_list");
        k = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new MiniGameModel();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setSerial(jsonobject.getString("serial"));
        s.setTitle(jsonobject.getString("title"));
        s.setIcon(jsonobject.getString("icon"));
        s.setPlay_url(jsonobject.getString("play_url"));
        s.setProc(jsonobject.getString("proc"));
        s.setSound(jsonobject.getString("sound"));
        s.setShort_desc(jsonobject.getString("short_desc"));
        s.setDetail(jsonobject.getString("detail"));
        s.setHits(jsonobject.getString("hits"));
        s.setCreate_time(jsonobject.getString("create_time"));
        s.setIs_safe(jsonobject.getString("is_safe"));
        s.setNext(j);
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parseminikeywords(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = new JSONObject(s);
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j;
        jsonarray = s.getJSONArray("keyword_list");
        j = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new SearchkeywordModel();
        s.setKeyword(jsonarray.getString(i));
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parsetodaypick(String s)
    {
        ArrayList arraylist = new ArrayList();
        int j;
        s = new JSONObject(s);
        j = s.getInt("has_next_page");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int k;
        jsonarray = s.getJSONArray("list");
        k = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new DownloadMovieItem();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setSerial(jsonobject.getInt("serial"));
        s.setCreate_time(Long.valueOf(jsonobject.getLong("show_time")));
        s.setTitle(jsonobject.getString("title"));
        s.setIcon(jsonobject.getString("icon"));
        s.setPpshort_desc(jsonobject.getString("short_desc"));
        s.setMovieHeadImagePath(jsonobject.getString("img"));
        s.setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
        s.setHas_apk(jsonobject.getString("has_apk"));
        s.setSetCount(jsonobject.getString("rating_count"));
        s.setHas_next_page(j);
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ArrayList parseupdata(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = new JSONObject(s);
        status = s.getInt("status");
        if (s.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j;
        jsonarray = s.getJSONArray("app_list");
        j = jsonarray.length();
        int i;
        i = 0;
        s = null;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        s = new DownloadMovieItem();
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        s.setId(jsonobject.getString("id"));
        s.setVersion(jsonobject.getString("version"));
        s.setLink_url(jsonobject.getString("apk_download_url"));
        s.setSize(jsonobject.getString("size"));
        arraylist.add(s);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s;
_L7:
        s.printStackTrace();
        return arraylist;
        s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void record_run_times()
    {
        int i = 0;
        int j = setting_json.getInt("run_times");
        i = j;
_L2:
        try
        {
            setting_json.put("run_times", i + 1);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        Exception exception1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void recoverSetting()
    {
        setting_json = publicTools.read_json_from_file((new StringBuilder(String.valueOf(dir.toString()))).append("/").append(packagename).append("/setting.json").toString());
    }

    public static void saveSetting()
    {
        publicTools.save_json_to_file((new StringBuilder(String.valueOf(dir.toString()))).append("/").append(packagename).append("/setting.json").toString(), setting_json);
    }

    public static void save_download_data(String s, List list1)
        throws IOException
    {
        JSONArray jsonarray = new JSONArray();
        int i = 0;
        do
        {
            if (i >= list1.size())
            {
                if (s.equals("apk"))
                {
                    jsonfile = "apk.json";
                } else
                if (s.equals("mp3"))
                {
                    jsonfile = "mp3.json";
                } else
                if (s.equals("ringtone"))
                {
                    jsonfile = "ringtone.json";
                }
                s = new BufferedWriter(new FileWriter((new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(packagename).toString(), jsonfile)).getAbsolutePath()));
                s.write(jsonarray.toString());
                s.close();
                return;
            }
            jsonarray.put((JSONObject)list1.get(i));
            i++;
        } while (true);
    }

    public static void setListViewHeightBasedOnChildren(ListView listview)
    {
        ListAdapter listadapter = listview.getAdapter();
        if (listadapter == null)
        {
            return;
        }
        int j = 0;
        int i = 0;
        do
        {
            if (i >= listadapter.getCount())
            {
                android.view.ViewGroup.LayoutParams layoutparams = listview.getLayoutParams();
                layoutparams.height = listview.getDividerHeight() * (listadapter.getCount() - 1) + j;
                listview.setLayoutParams(layoutparams);
                return;
            }
            View view = listadapter.getView(i, null, listview);
            view.measure(0, 0);
            j += view.getMeasuredHeight();
            i++;
        } while (true);
    }

    public static String timezhuanhua(long l)
    {
        String s1 = (String)DateFormat.format("MM", l);
        String s;
        if (s1.equals("01"))
        {
            s = "January";
        } else
        {
            if (s1.equals("02"))
            {
                return "February";
            }
            if (s1.equals("03"))
            {
                return "March";
            }
            if (s1.equals("04"))
            {
                return "April";
            }
            if (s1.equals("05"))
            {
                return "May";
            }
            if (s1.equals("06"))
            {
                return "June";
            }
            if (s1.equals("07"))
            {
                return "July";
            }
            if (s1.equals("08"))
            {
                return "August";
            }
            if (s1.equals("09"))
            {
                return "September";
            }
            if (s1.equals("10"))
            {
                return "October";
            }
            if (s1.equals("11"))
            {
                return "November";
            }
            s = s1;
            if (s1.equals("12"))
            {
                return "December";
            }
        }
        return s;
    }

    private String toTime(int i)
    {
        int j = i / 1000 / 60;
        i = (i / 1000) % 60;
        String s;
        String s1;
        if (j < 10)
        {
            s = (new StringBuilder("0")).append(j).toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(j))).toString();
        }
        if (i < 10)
        {
            s1 = (new StringBuilder("0")).append(i).toString();
        } else
        {
            s1 = (new StringBuilder()).append(i).toString();
        }
        return (new StringBuilder(String.valueOf(s))).append(":").append(s1).toString();
    }

    public static Boolean to_show_big_ad()
    {
        if (last_time_show_big_ad == 0L)
        {
            last_time_show_big_ad = System.currentTimeMillis() - (long)(big_ad_interval / 2);
        }
        if (big_ad_interval > 0 && System.currentTimeMillis() - last_time_show_big_ad > (long)big_ad_interval)
        {
            last_time_show_big_ad = System.currentTimeMillis();
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    static 
    {
        detail_save = false;
        today_save = false;
        big_ad_interval = 60000;
        last_time_show_big_ad = 0L;
        iswidget = false;
        iswidget2 = false;
        iswidget_float = false;
        iscleaner = false;
        gamefan = false;
        shotcut = true;
        fb_ad = true;
        laststate = 0;
    }
}
