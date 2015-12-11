// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;


public final class OTAStep extends Enum
{

    private static final OTAStep $VALUES[];
    public static final OTAStep Download;
    public static final OTAStep DownloadManifest;
    public static final OTAStep Install;
    public static final OTAStep InstallManifest;
    public static final OTAStep None;
    public static final OTAStep ProcessManfiest;
    private final String mStep;

    private OTAStep(String s, int i, String s1)
    {
        super(s, i);
        mStep = s1;
    }

    public static OTAStep valueOf(String s)
    {
        return (OTAStep)Enum.valueOf(com/amazon/dcp/ota/OTAStep, s);
    }

    public static OTAStep[] values()
    {
        return (OTAStep[])$VALUES.clone();
    }

    public String toString()
    {
        return mStep;
    }

    static 
    {
        None = new OTAStep("None", 0, "None");
        DownloadManifest = new OTAStep("DownloadManifest", 1, "OTAStepDownloadManifest");
        InstallManifest = new OTAStep("InstallManifest", 2, "OTAStepInstallManifest");
        ProcessManfiest = new OTAStep("ProcessManfiest", 3, "OTAStepProcessManifest");
        Download = new OTAStep("Download", 4, "OTAStepDownload");
        Install = new OTAStep("Install", 5, "OTAStepInstall");
        $VALUES = (new OTAStep[] {
            None, DownloadManifest, InstallManifest, ProcessManfiest, Download, Install
        });
    }
}
