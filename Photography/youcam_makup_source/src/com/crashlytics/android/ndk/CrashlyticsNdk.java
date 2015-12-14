// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import android.content.Context;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsKitBinder;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;

// Referenced classes of package com.crashlytics.android.ndk:
//            JniNativeApi, JsonCrashDataParser, CrashFileManager, TimeBasedCrashFileManager, 
//            NativeApi

public class CrashlyticsNdk extends Kit
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
        return (CrashlyticsNdk)Fabric.getKit(com/crashlytics/android/ndk/CrashlyticsNdk);
    }

    private File getKitStorageDirectory()
    {
        return (new FileStoreImpl(this)).getFilesDir();
    }

    private String readJsonCrashFile(File file)
    {
        Fabric.getLogger().d("CrashlyticsNdk", "Reading NDK crash data...");
        Object obj = new FileInputStream(file);
        file = ((File) (obj));
        Object obj1 = CommonUtils.streamToString(((java.io.InputStream) (obj)));
        CommonUtils.closeOrLog(((java.io.Closeable) (obj)), "Error closing crash data file.");
        return ((String) (obj1));
        Object obj2;
        obj2;
        obj = null;
_L4:
        file = ((File) (obj));
        Fabric.getLogger().e("CrashlyticsNdk", "Failed to read NDK crash data.", ((Throwable) (obj2)));
        CommonUtils.closeOrLog(((java.io.Closeable) (obj)), "Error closing crash data file.");
        return null;
        file;
        obj2 = null;
        obj = file;
_L2:
        CommonUtils.closeOrLog(((java.io.Closeable) (obj2)), "Error closing crash data file.");
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
            Fabric.getLogger().d("CrashlyticsNdk", "Found NDK crash file...");
            obj = readJsonCrashFile(((File) (obj)));
            if (obj != null)
            {
                try
                {
                    lastCrashEventData = crashDataParser.parseCrashEventData(((String) (obj)));
                }
                catch (JSONException jsonexception)
                {
                    Fabric.getLogger().e("CrashlyticsNdk", "Crashlytics failed to parse prior crash data.");
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
        return "1.1.2.90";
    }

    protected boolean onPreExecute()
    {
        if (Fabric.getKit(com/crashlytics/android/core/CrashlyticsCore) == null)
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
            Fabric.getLogger().e("CrashlyticsNdk", "Error initializing CrashlyticsNdk", crashfilemanager);
            flag = false;
        }
        if (flag)
        {
            crashlyticskitbinder.bindCrashEventDataProvider(crashlyticscore, this);
            Fabric.getLogger().d("CrashlyticsNdk", "Crashlytics NDK initialization successful");
        }
        return flag;
    }
}
