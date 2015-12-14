// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.model;

import apc;
import azn;
import bdg;
import bdh;
import bdi;
import bdj;
import bgd;
import cen;
import cer;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.instabeauty.application.InstaBeautyApplication;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TResTypeManager
{

    public static int KLANDSCAPETYPEID = -98;
    public static int KPORTRAITTYPEID = -100;
    public static int KRECOMMENDTYPEID = -1000;
    public static int KRES_3D = 106;
    public static int KRES_ALLTYPE = 10;
    public static int KRES_ARTISTIC = 103;
    public static int KRES_COMMONLYUSED = -1900;
    public static int KRES_CREATIVE = 101;
    public static int KRES_HOLIDAYS = 105;
    public static int KRES_MANGA = 107;
    public static int KRES_MINIMAL = 90;
    public static int KRES_OBJECTS = 102;
    public static int KRES_OTHERTYPE = 108;
    public static int KRES_PIP = 104;
    public static int KRES_SIMPLE = 100;
    public static int KSQUARETYPEID = -99;
    public static int KSTRIPSTYPEID = -97;
    private static String MAGTESTYPE_MANAGER_LIST = "MAGTESTYPE_MANAGER_LIST";
    private static TResTypeManager instance = null;
    private apc mCache;
    private cen mFileCache;
    public boolean needUpdate;
    private ArrayList typeList;

    private TResTypeManager()
    {
        needUpdate = false;
        typeList = null;
        mCache = apc.a(InstaBeautyApplication.a);
        typeList = new ArrayList();
        unarchive();
        initType();
    }

    private void addResTypeInfo(bdg bdg1)
    {
        synchronized (typeList)
        {
            if (!isResTypeInfoExist(bdg1))
            {
                typeList.add(bdg1);
            }
        }
        return;
        bdg1;
        arraylist;
        JVM INSTR monitorexit ;
        throw bdg1;
    }

    private cen getFileCache()
    {
        if (mFileCache == null)
        {
            mFileCache = new bgd(InstaBeautyApplication.a().b(), "magResTypeConfig");
        }
        return mFileCache;
    }

    private void initType()
    {
        bdg bdg1 = new bdg();
        bdg1.a = KRES_ALLTYPE;
        bdg1.b = "\u6240\u6709\u5206\u7C7B";
        bdg1.c = "\u6240\u6709\u5206\u985E";
        bdg1.d = "All";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_SIMPLE;
        bdg1.b = "\u7B80\u7EA6";
        bdg1.c = "\u7C21\u7D04";
        bdg1.d = "Classic";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_CREATIVE;
        bdg1.b = "\u521B\u610F";
        bdg1.c = "\u5275\u610F";
        bdg1.d = "Creative";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_OBJECTS;
        bdg1.b = "\u5199\u5B9E";
        bdg1.c = "\u5BEB\u5BE6";
        bdg1.d = "Objects";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_ARTISTIC;
        bdg1.b = "\u6587\u827A";
        bdg1.c = "\u6587\u85DD";
        bdg1.d = "Artistic";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_PIP;
        bdg1.b = "\u753B\u4E2D\u753B";
        bdg1.c = "\u756B\u4E2D\u756B";
        bdg1.d = "PIP";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_HOLIDAYS;
        bdg1.b = "\u8282\u65E5";
        bdg1.c = "\u7BC0\u65E5";
        bdg1.d = "Holidays";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_3D;
        bdg1.b = "3D";
        bdg1.c = "3D";
        bdg1.d = "3D";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_OTHERTYPE;
        bdg1.b = "\u5176\u4ED6";
        bdg1.c = "\u5176\u4ED6";
        bdg1.d = "Other";
        addResTypeInfo(bdg1);
        bdg1 = new bdg();
        bdg1.a = KRES_MINIMAL;
        bdg1.b = "\u6781\u7B80";
        bdg1.c = "\u6975\u7C21";
        bdg1.d = "Minimal";
        addResTypeInfo(bdg1);
    }

    public static TResTypeManager instance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/instamag/activity/library/model/TResTypeManager;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new TResTypeManager();
        }
        com/instamag/activity/library/model/TResTypeManager;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/instamag/activity/library/model/TResTypeManager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean isResTypeInfoExist(bdg bdg1)
    {
        for (Iterator iterator = typeList.iterator(); iterator.hasNext();)
        {
            if (((bdg)iterator.next()).a == bdg1.a)
            {
                return true;
            }
        }

        return false;
    }

    private boolean parseJsonData(JSONObject jsonobject)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        JSONArray jsonarray = jsonobject.getJSONArray("data");
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        int i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        jsonobject = jsonarray.getJSONObject(i);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        bdg bdg1;
        JSONArray jsonarray1;
        bdg1 = new bdg();
        bdg1.a = Integer.valueOf(jsonobject.getString("id")).intValue();
        bdg1.b = jsonobject.getString("name_cn");
        bdg1.d = jsonobject.getString("name_en");
        bdg1.c = jsonobject.getString("name_tw");
        if (!jsonobject.has("Materials"))
        {
            break MISSING_BLOCK_LABEL_207;
        }
        jsonarray1 = jsonobject.getJSONArray("Materials");
        int j;
        jsonobject = ",";
        j = 0;
_L2:
        if (j >= jsonarray1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        int k = Integer.valueOf(jsonarray1.getInt(j)).intValue();
        jsonobject = (new StringBuilder()).append(jsonobject).append(k).append(",").toString();
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        bdg1.e = jsonobject;
        arraylist.add(bdg1);
        i++;
          goto _L3
        jsonobject;
        jsonobject.printStackTrace();
        if (arraylist.size() > 0)
        {
            needUpdate = true;
            typeList.clear();
            typeList.addAll(arraylist);
            saveResTypeToDataFile();
            return true;
        } else
        {
            return false;
        }
        return false;
    }

    private void saveResTypeToDataFile()
    {
        asynArchive();
    }

    public void asynArchive()
    {
        bdj;
        JVM INSTR monitorenter ;
        (new bdj(this, new ArrayList(typeList))).execute(new Void[0]);
        bdj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        bdj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void checkOnlineTypeInfo()
    {
        Object obj;
        boolean flag;
        try
        {
            obj = mCache.b("json_magResTypeManagerUrl");
        }
        catch (Exception exception)
        {
            exception = null;
        }
        if (parseJsonData(((JSONObject) (obj))))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            obj = azn.c();
            AsyncHttpClient asynchttpclient = new AsyncHttpClient();
            asynchttpclient.setConnectTimeout(20000);
            asynchttpclient.setTimeout(20000);
            asynchttpclient.get(((String) (obj)), null, new bdi(this));
        }
    }

    public ArrayList getAllTypeList()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < typeList.size(); i++)
        {
            arraylist.add((bdg)typeList.get(i));
        }

        return arraylist;
    }

    public bdg getCommonlyType()
    {
        bdg bdg1 = new bdg();
        bdg1.a = KRES_COMMONLYUSED;
        bdg1.b = "\u6700\u8FD1\u4F7F\u7528";
        bdg1.c = "\u6700\u8FD1\u4F7F\u7528";
        bdg1.d = "Recent";
        return bdg1;
    }

    public bdg getResTypeById(int i)
    {
        for (int j = 0; j < typeList.size(); j++)
        {
            bdg bdg1 = (bdg)typeList.get(j);
            if (bdg1.a == i)
            {
                return bdg1;
            }
        }

        bdg bdg2 = new bdg();
        bdg2.a = KRES_OTHERTYPE;
        bdg2.b = "\u5176\u4ED6";
        bdg2.c = "\u5176\u4ED6";
        bdg2.d = "Other";
        return bdg2;
    }

    public ArrayList getSpecailList()
    {
        ArrayList arraylist = new ArrayList();
        bdg bdg1 = new bdg();
        bdg1.a = KPORTRAITTYPEID;
        bdg1.b = "\u7AD6\u7248";
        bdg1.c = "\u7AD6\u7248";
        bdg1.d = "Portrait";
        arraylist.add(bdg1);
        bdg1 = new bdg();
        bdg1.a = KSQUARETYPEID;
        bdg1.b = "\u6B63\u65B9\u5F62";
        bdg1.c = "\u6B63\u65B9\u5F62";
        bdg1.d = "Square";
        arraylist.add(bdg1);
        bdg1 = new bdg();
        bdg1.a = KLANDSCAPETYPEID;
        bdg1.b = "\u6A2A\u7248";
        bdg1.c = "\u6A2A\u7248";
        bdg1.d = "Landscape";
        arraylist.add(bdg1);
        return arraylist;
    }

    public bdg getStripsType()
    {
        bdg bdg1 = new bdg();
        bdg1.a = KSTRIPSTYPEID;
        bdg1.b = "\u62FC\u63A5";
        bdg1.c = "\u62FC\u63A5";
        bdg1.d = "Strips";
        return bdg1;
    }

    public void unarchive()
    {
        Object obj;
        Gson gson;
        obj = getFileCache().a(MAGTESTYPE_MANAGER_LIST, new cer());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj = (String)obj;
        gson = new Gson();
        typeList = (ArrayList)gson.fromJson(((String) (obj)), (new bdh(this)).getType());
        return;
        JsonSyntaxException jsonsyntaxexception;
        jsonsyntaxexception;
        getFileCache().a(MAGTESTYPE_MANAGER_LIST);
        return;
    }





}
