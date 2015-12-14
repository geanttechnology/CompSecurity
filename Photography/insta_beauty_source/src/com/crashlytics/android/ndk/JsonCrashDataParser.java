// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import bso;
import btb;
import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.crashlytics.android.ndk:
//            Sha1FileIdStrategy, CrashlyticsNdk, ProcMapEntryParser, ProcMapEntry, 
//            FileIdStrategy

class JsonCrashDataParser
{

    private static final String CUSTOM_KEY_JSON_SESSION = "json_session";
    private static final String DATA_DIR = "/data";
    private static final BinaryImageData EMPTY_BINARY_IMAGES[] = new BinaryImageData[0];
    private static final com.crashlytics.android.core.internal.models.ThreadData.FrameData EMPTY_FRAMES[] = new com.crashlytics.android.core.internal.models.ThreadData.FrameData[0];
    private static final ThreadData EMPTY_THREADS[] = new ThreadData[0];
    static final String KEY_AVAILABLE_INTERNAL_STORAGE = "available_internal_storage";
    static final String KEY_AVAILABLE_PHYSICAL_MEMORY = "available_physical_memory";
    static final String KEY_BATTERY_CAPACITY = "battery";
    static final String KEY_BATTERY_VELOCITY = "battery_velocity";
    static final String KEY_CRASHED = "crashed";
    static final String KEY_FRAMES = "frames";
    static final String KEY_MAPS = "maps";
    static final String KEY_ORIENTATION = "orientation";
    static final String KEY_PC = "pc";
    static final String KEY_PROXIMITY_ENABLED = "proximity_enabled";
    static final String KEY_SIG_CODE = "sig_code";
    static final String KEY_SIG_NAME = "sig_name";
    static final String KEY_SI_ADDR = "si_addr";
    static final String KEY_SYMBOL = "symbol";
    static final String KEY_THREADS = "threads";
    static final String KEY_THREAD_NAME = "name";
    static final String KEY_TIME = "time";
    static final String KEY_TOTAL_INTERNAL_STORAGE = "total_internal_storage";
    static final String KEY_TOTAL_PHYSICAL_MEMORY = "total_physical_memory";
    private static final String TAG = "JsonCrashDataParser";
    private final FileIdStrategy fileIdStrategy;

    public JsonCrashDataParser()
    {
        this(((FileIdStrategy) (new Sha1FileIdStrategy())));
    }

    JsonCrashDataParser(FileIdStrategy fileidstrategy)
    {
        fileIdStrategy = fileidstrategy;
    }

    private static File correctDataPath(File file)
    {
        Object obj = file;
        if (file.getAbsolutePath().startsWith("/data"))
        {
            try
            {
                obj = CrashlyticsNdk.getInstance().getContext();
                obj = new File(((Context) (obj)).getPackageManager().getApplicationInfo(((Context) (obj)).getPackageName(), 0).nativeLibraryDir, file.getName());
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                bso.h().e("JsonCrashDataParser", "Error getting ApplicationInfo", namenotfoundexception);
                return file;
            }
        }
        return ((File) (obj));
    }

    private static File getLibraryFile(String s)
    {
        File file = new File(s);
        s = file;
        if (!file.exists())
        {
            s = correctDataPath(file);
        }
        return s;
    }

    public BinaryImageData[] parseBinaryImageData(JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONArray("maps");
        if (jsonobject == null)
        {
            return EMPTY_BINARY_IMAGES;
        }
        LinkedList linkedlist = new LinkedList();
        int i = 0;
        while (i < jsonobject.length()) 
        {
            ProcMapEntry procmapentry = ProcMapEntryParser.parse(jsonobject.optString(i));
            if (procmapentry != null)
            {
                String s = procmapentry.path;
                Object obj = getLibraryFile(s);
                try
                {
                    obj = fileIdStrategy.getId(((File) (obj)));
                    linkedlist.add(new BinaryImageData(procmapentry.address, procmapentry.size, s, ((String) (obj))));
                }
                catch (IOException ioexception)
                {
                    bso.h().a("JsonCrashDataParser", (new StringBuilder()).append("Could not generate ID for file ").append(procmapentry.path).toString(), ioexception);
                }
            }
            i++;
        }
        return (BinaryImageData[])linkedlist.toArray(new BinaryImageData[linkedlist.size()]);
    }

    public SessionEventData parseCrashEventData(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        return new SessionEventData(jsonobject.optLong("time"), parseSignalData(jsonobject), parseThreadData(jsonobject), parseBinaryImageData(jsonobject), parseCustomAttributes(s), parseDeviceData(jsonobject));
    }

    public CustomAttributeData[] parseCustomAttributes(String s)
    {
        return (new CustomAttributeData[] {
            new CustomAttributeData("json_session", s)
        });
    }

    public DeviceData parseDeviceData(JSONObject jsonobject)
    {
        return new DeviceData(jsonobject.optInt("orientation"), jsonobject.optLong("total_physical_memory"), jsonobject.optLong("total_internal_storage"), jsonobject.optLong("available_physical_memory"), jsonobject.optLong("available_internal_storage"), jsonobject.optInt("battery"), jsonobject.optInt("battery_velocity", 1), jsonobject.optBoolean("proximity_enabled", false));
    }

    public com.crashlytics.android.core.internal.models.ThreadData.FrameData[] parseFrameData(JSONObject jsonobject, int i)
    {
        JSONArray jsonarray = jsonobject.optJSONArray("frames");
        if (jsonarray != null) goto _L2; else goto _L1
_L1:
        jsonobject = EMPTY_FRAMES;
_L4:
        return jsonobject;
_L2:
        int k = jsonarray.length();
        com.crashlytics.android.core.internal.models.ThreadData.FrameData aframedata[] = new com.crashlytics.android.core.internal.models.ThreadData.FrameData[k];
        int j = 0;
        do
        {
            jsonobject = aframedata;
            if (j >= k)
            {
                continue;
            }
            jsonobject = jsonarray.optJSONObject(j);
            long l = jsonobject.optLong("pc");
            String s = jsonobject.optString("symbol");
            jsonobject = s;
            if (s == null)
            {
                jsonobject = "";
            }
            aframedata[j] = new com.crashlytics.android.core.internal.models.ThreadData.FrameData(l, jsonobject, "", 0L, i);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public SignalData parseSignalData(JSONObject jsonobject)
    {
        return new SignalData(jsonobject.optString("sig_name", ""), jsonobject.optString("sig_code", ""), jsonobject.optLong("si_addr"));
    }

    public ThreadData[] parseThreadData(JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONArray("threads");
        if (jsonobject == null)
        {
            return EMPTY_THREADS;
        }
        int j = jsonobject.length();
        ThreadData athreaddata[] = new ThreadData[j];
        int i = 0;
        while (i < j) 
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject(i);
            String s = jsonobject1.optString("name");
            byte byte0;
            if (jsonobject1.optBoolean("crashed"))
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            athreaddata[i] = new ThreadData(s, byte0, parseFrameData(jsonobject1, byte0));
            i++;
        }
        return athreaddata;
    }

}
