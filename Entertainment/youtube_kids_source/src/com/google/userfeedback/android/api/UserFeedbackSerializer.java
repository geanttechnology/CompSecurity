// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import atr;
import com.google.userfeedback.android.api.common.io.protocol.ProtoBuf;
import com.google.userfeedback.android.api.encode.Base64;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackReport, UserFeedbackCrashData, UserFeedback, UserFeedbackSpec, 
//            ProductSpecificBinaryDataHolder

public class UserFeedbackSerializer
{

    private UserFeedbackReport report;

    UserFeedbackSerializer(UserFeedbackReport userfeedbackreport)
    {
        report = userfeedbackreport;
    }

    private ProtoBuf serializeAndroidData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.f);
        protobuf.setProtoBuf(1, serializeSystemData());
        protobuf.setProtoBuf(2, serializePackageData());
        protobuf.setProtoBuf(3, serializeBuildData());
        protobuf.setProtoBuf(9, serializeUserInitiatedFeedbackData());
        if (report.crashData != null)
        {
            protobuf.setProtoBuf(4, serializeCrashData());
        }
        return protobuf;
    }

    private ProtoBuf serializeBuildData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.i);
        protobuf.setString(1, report.device);
        protobuf.setString(2, report.buildId);
        protobuf.setString(3, report.buildType);
        protobuf.setString(4, report.model);
        protobuf.setString(5, report.product);
        protobuf.setString(7, report.release);
        protobuf.setString(8, report.incremental);
        protobuf.setString(9, report.codename);
        protobuf.setString(10, report.board);
        protobuf.setString(11, report.brand);
        protobuf.setInt(6, report.sdkInt);
        return protobuf;
    }

    private ProtoBuf serializeCommonData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.b);
        protobuf.setString(2, report.description);
        protobuf.setString(6, report.uiLanguage);
        if (!"".equals(report.chosenAccount))
        {
            protobuf.setString(3, report.chosenAccount);
        }
        return protobuf;
    }

    private ProtoBuf serializeCrashData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.j);
        protobuf.setString(1, report.crashData.exceptionClassName);
        protobuf.setString(3, report.crashData.throwFileName);
        protobuf.setInt(4, report.crashData.throwLineNumber);
        protobuf.setString(5, report.crashData.throwClassName);
        protobuf.setString(6, report.crashData.throwMethodName);
        protobuf.setString(7, report.crashData.stackTrace);
        if (report.crashData.exceptionMessage != null)
        {
            protobuf.setString(2, report.crashData.exceptionMessage);
        }
        return protobuf;
    }

    private ProtoBuf serializePackageData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.h);
        protobuf.setString(1, report.packageName);
        protobuf.setString(2, report.installerPackageName);
        protobuf.setString(3, report.processName);
        protobuf.setInt(4, report.packageVersion);
        protobuf.setString(5, report.packageVersionName);
        protobuf.setBool(6, report.isSystemApp);
        return protobuf;
    }

    private ProtoBuf serializeScreenshotData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.d);
        protobuf.setString(1, "image/jpeg");
        protobuf.setString(2, Base64.encodeToString(report.screenshot, 0));
        ProtoBuf protobuf1 = new ProtoBuf(atr.a);
        protobuf1.setFloat(2, report.screenshotHeight);
        protobuf1.setFloat(1, report.screenshotWidth);
        protobuf.setProtoBuf(3, protobuf1);
        return protobuf;
    }

    private ProtoBuf serializeSystemData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.g);
        if (UserFeedback.userFeedback().shouldIncludeSystemLogs())
        {
            protobuf.setString(2, report.systemLog);
        }
        protobuf.setLong(1, report.timestamp);
        protobuf.setProtoBuf(6, serializeTelephonyData());
        for (Iterator iterator = report.runningApplications.iterator(); iterator.hasNext(); protobuf.addString(5, (String)iterator.next())) { }
        return protobuf;
    }

    private ProtoBuf serializeTelephonyData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.l);
        protobuf.setInt(1, report.phoneType);
        protobuf.setInt(3, report.networkType);
        protobuf.setString(2, report.networkName);
        return protobuf;
    }

    private ProtoBuf serializeUserFeedbackReport()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.e);
        protobuf.setProtoBuf(1, serializeCommonData());
        protobuf.setProtoBuf(2, serializeAndroidData());
        return protobuf;
    }

    private ProtoBuf serializeUserInitiatedFeedbackData()
    {
        ProtoBuf protobuf = new ProtoBuf(atr.k);
        if (UserFeedback.userFeedback().shouldIncludeScreenshot() && UserFeedback.userFeedback().getSpec().isScreenshotEnabled() && report.screenshot != null)
        {
            protobuf.setProtoBuf(4, serializeScreenshotData());
        }
        if (report.categoryTag != null)
        {
            protobuf.setString(6, report.categoryTag);
        }
        if (report.bucket != null)
        {
            protobuf.setString(7, report.bucket);
        }
        int i = report.numGoogleAccounts;
        protobuf.setString(1, (new StringBuilder(11)).append(i).toString());
        Iterator iterator = report.productSpecificBinaryData.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ProductSpecificBinaryDataHolder productspecificbinarydataholder = (ProductSpecificBinaryDataHolder)iterator.next();
            byte abyte0[] = productspecificbinarydataholder.getData();
            if (abyte0 != null)
            {
                ProtoBuf protobuf1 = new ProtoBuf(atr.c);
                protobuf1.setString(1, productspecificbinarydataholder.getName());
                protobuf1.setString(2, productspecificbinarydataholder.getMimeType());
                protobuf1.setBytes(3, abyte0);
                protobuf.addProtoBuf(2, protobuf1);
            }
        } while (true);
        return protobuf;
    }

    public ProtoBuf serialize()
    {
        return serializeUserFeedbackReport();
    }
}
