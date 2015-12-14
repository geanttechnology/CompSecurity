// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import android.content.Context;
import bso;
import bsy;
import btb;
import bwr;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsKitBinder;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;

// Referenced classes of package com.crashlytics.android.ndk:
//            JniNativeApi, JsonCrashDataParser, CrashFileManager, TimeBasedCrashFileManager, 
//            NativeApi

public class CrashlyticsNdk extends bsy
    implements CrashEventDataProvider
{

    private static final String TAG = "CrashlyticsNdk";
    private final JsonCrashDataParser crashDataParser;
    private CrashFileManager crashFileManager;
    SessionEventData lastCrashEventData;
    private final NativeApi nativeApi;

    public CrashlyticsNdk()
    {
        this(((NativeApi) (new JniNativeApi())));
    }

    CrashlyticsNdk(NativeApi nativeapi)
    {
        nativeApi = nativeapi;
        crashDataParser = new JsonCrashDataParser();
    }

    public static CrashlyticsNdk getInstance()
    {
        return (CrashlyticsNdk)bso.a(com/crashlytics/android/ndk/CrashlyticsNdk);
    }

    private File getKitStorageDirectory()
    {
        return (new bwr(this)).a();
    }

    private String readJsonCrashFile(File file)
    {
        bso.h().a("CrashlyticsNdk", "Reading NDK crash data...");
        Object obj = new FileInputStream(file);
        file = ((File) (obj));
        Object obj1 = CommonUtils.a(((java.io.InputStream) (obj)));
        CommonUtils.a(((java.io.Closeable) (obj)), "Error closing crash data file.");
        return ((String) (obj1));
        Object obj2;
        obj2;
        obj = null;
_L4:
        file = ((File) (obj));
        bso.h().e("CrashlyticsNdk", "Failed to read NDK crash data.", ((Throwable) (obj2)));
        CommonUtils.a(((java.io.Closeable) (obj)), "Error closing crash data file.");
        return null;
        file;
        obj2 = null;
        obj = file;
_L2:
        CommonUtils.a(((java.io.Closeable) (obj2)), "Error closing crash data file.");
        throw obj;
        obj;
        obj2 = file;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        Object obj = crashFileManager.getLastWrittenCrashFile();
        if (obj != null && ((File) (obj)).exists())
        {
            bso.h().a("CrashlyticsNdk", "Found NDK crash file...");
            obj = readJsonCrashFile(((File) (obj)));
            if (obj != null)
            {
                try
                {
                    lastCrashEventData = crashDataParser.parseCrashEventData(((String) (obj)));
                }
                catch (JSONException jsonexception)
                {
                    bso.h().e("CrashlyticsNdk", "Failed to parse NDK crash data.", jsonexception);
                }
            }
        }
        crashFileManager.clearCrashFiles();
        return null;
    }

    public SessionEventData getCrashEventData()
    {
        return lastCrashEventData;
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android.crashlytics-ndk";
    }

    public String getVersion()
    {
        return "1.1.1.74";
    }

    protected boolean onPreExecute()
    {
        if (bso.a(com/crashlytics/android/core/CrashlyticsCore) == null)
        {
            throw new UnmetDependencyException("CrashlyticsNdk requires Crashlytics");
        } else
        {
            return onPreExecute(((CrashFileManager) (new TimeBasedCrashFileManager(getKitStorageDirectory()))), CrashlyticsCore.getInstance(), new CrashlyticsKitBinder());
        }
    }

    boolean onPreExecute(CrashFileManager crashfilemanager, CrashlyticsCore crashlyticscore, CrashlyticsKitBinder crashlyticskitbinder)
    {
        crashFileManager = crashfilemanager;
        boolean flag;
        try
        {
            crashfilemanager = crashfilemanager.getNewCrashFile().getCanonicalPath();
            flag = nativeApi.initialize(crashfilemanager, getContext().getAssets());
        }
        // Misplaced declaration of an exception variable
        catch (CrashFileManager crashfilemanager)
        {
            bso.h().e("CrashlyticsNdk", "Error initializing CrashlyticsNdk", crashfilemanager);
            flag = false;
        }
        if (flag)
        {
            crashlyticskitbinder.bindCrashEventDataProvider(crashlyticscore, this);
            bso.h().a("CrashlyticsNdk", "Crashlytics NDK initialization successful");
        }
        return flag;
    }
}
