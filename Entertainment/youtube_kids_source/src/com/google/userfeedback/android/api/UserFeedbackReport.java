// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackCrashData

public class UserFeedbackReport
{

    public List accounts;
    public String board;
    public String brand;
    public String bucket;
    public String buildId;
    public String buildType;
    public String categoryTag;
    public String chosenAccount;
    public String codename;
    public UserFeedbackCrashData crashData;
    public String description;
    public String device;
    public String incremental;
    public List installedPackages;
    public String installerPackageName;
    private boolean isSubmitted;
    public boolean isSystemApp;
    public String model;
    public String networkName;
    public int networkType;
    public int numGoogleAccounts;
    public String packageName;
    public int packageVersion;
    public String packageVersionName;
    public int phoneType;
    public String processName;
    public String product;
    public List productSpecificBinaryData;
    private boolean readyToBeSubmitted;
    public String release;
    public List runningApplications;
    public byte screenshot[];
    public int screenshotHeight;
    public int screenshotWidth;
    public int sdkInt;
    public String systemLog;
    public long timestamp;
    public String uiLanguage;

    UserFeedbackReport()
    {
        installedPackages = new ArrayList();
        runningApplications = new ArrayList();
        productSpecificBinaryData = new LinkedList();
        setSubmitted(false);
        setReadyToSubmit(false);
        crashData = null;
    }

    public void setReadyToSubmit(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        readyToBeSubmitted = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSubmitted(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        isSubmitted = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean shouldSubmitReport()
    {
        return !isSubmitted && readyToBeSubmitted;
    }
}
