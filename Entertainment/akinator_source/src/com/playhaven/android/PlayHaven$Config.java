// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android;


// Referenced classes of package com.playhaven.android:
//            PlayHaven

public static final class  extends Enum
{

    private static final InstallReported $VALUES[];
    public static final InstallReported APIServer;
    public static final InstallReported AppPkg;
    public static final InstallReported AppVersion;
    public static final InstallReported DeviceId;
    public static final InstallReported DeviceModel;
    public static final InstallReported FullScreen;
    public static final InstallReported InstallReported;
    public static final InstallReported OSName;
    public static final InstallReported OSVersion;
    public static final InstallReported OptOut;
    public static final InstallReported PluginIdentifer;
    public static final InstallReported PluginType;
    public static final InstallReported PushProjectId;
    public static final InstallReported SDKVersion;
    public static final InstallReported Secret;
    public static final InstallReported Token;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/playhaven/android/PlayHaven$Config, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Token = new <init>("Token", 0);
        Secret = new <init>("Secret", 1);
        APIServer = new <init>("APIServer", 2);
        SDKVersion = new <init>("SDKVersion", 3);
        PluginIdentifer = new <init>("PluginIdentifer", 4);
        PluginType = new <init>("PluginType", 5);
        AppPkg = new <init>("AppPkg", 6);
        AppVersion = new <init>("AppVersion", 7);
        OSName = new <init>("OSName", 8);
        OSVersion = new <init>("OSVersion", 9);
        DeviceId = new <init>("DeviceId", 10);
        PushProjectId = new <init>("PushProjectId", 11);
        DeviceModel = new <init>("DeviceModel", 12);
        FullScreen = new <init>("FullScreen", 13);
        OptOut = new <init>("OptOut", 14);
        InstallReported = new <init>("InstallReported", 15);
        $VALUES = (new .VALUES[] {
            Token, Secret, APIServer, SDKVersion, PluginIdentifer, PluginType, AppPkg, AppVersion, OSName, OSVersion, 
            DeviceId, PushProjectId, DeviceModel, FullScreen, OptOut, InstallReported
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
