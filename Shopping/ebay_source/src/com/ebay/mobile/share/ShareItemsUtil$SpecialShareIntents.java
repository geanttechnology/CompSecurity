// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.share;

import java.util.Locale;

// Referenced classes of package com.ebay.mobile.share:
//            ShareItemsUtil

private static final class isSupported extends Enum
{

    private static final SMS_MMS $VALUES[];
    public static final SMS_MMS COMANDROIDBLUETOOTH;
    public static final SMS_MMS COMGOOGLEANDROIDGM;
    public static final SMS_MMS COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX;
    public static final SMS_MMS COMGOOGLEZXINGCLIENTANDROID;
    public static final SMS_MMS COMHTCFRIENDSTREAM;
    public static final SMS_MMS COMMOTOROLAVZWVMM;
    public static final SMS_MMS FACEBOOK;
    public static final SMS_MMS MAILAPPS;
    public static final SMS_MMS SKYPE;
    public static final SMS_MMS SMS_MMS;
    public static final SMS_MMS TWITTER;
    private final boolean isSupported;
    private final String rawPackageName;

    public static String generatePackageKey(String s)
    {
        if (s.contains(ShareItemsUtil.access$700()) || s.contains(ShareItemsUtil.access$800()) || s.contains(ShareItemsUtil.access$900()) || s.contains(ShareItemsUtil.access$1000()))
        {
            return ShareItemsUtil.access$300();
        }
        if (s.contains(ShareItemsUtil.access$1100()) || s.contains(ShareItemsUtil.access$1200()) || s.contains(ShareItemsUtil.access$1300()))
        {
            return ShareItemsUtil.access$600();
        }
        if (s.contains(ShareItemsUtil.access$1400()))
        {
            return ShareItemsUtil.access$400();
        }
        if (s.contains(ShareItemsUtil.access$1500()))
        {
            return ShareItemsUtil.access$500();
        } else
        {
            return s.replace(".", "").toUpperCase(Locale.getDefault());
        }
    }

    public static isSupported valueOf(String s)
    {
        return (isSupported)Enum.valueOf(com/ebay/mobile/share/ShareItemsUtil$SpecialShareIntents, s);
    }

    public static isSupported[] values()
    {
        return (isSupported[])$VALUES.clone();
    }

    protected String getPackageName()
    {
        return rawPackageName.trim();
    }

    public boolean isSupported()
    {
        return isSupported;
    }

    static 
    {
        COMGOOGLEANDROIDGM = new <init>("COMGOOGLEANDROIDGM", 0, ShareItemsUtil.access$000(), true);
        COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX = new <init>("COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX", 1, ShareItemsUtil.access$100(), true);
        MAILAPPS = new <init>("MAILAPPS", 2, ShareItemsUtil.access$200(), true);
        COMANDROIDBLUETOOTH = new <init>("COMANDROIDBLUETOOTH", 3, "com.android.bluetooth", false);
        TWITTER = new <init>("TWITTER", 4, ShareItemsUtil.access$300(), true);
        FACEBOOK = new <init>("FACEBOOK", 5, ShareItemsUtil.access$400(), true);
        COMGOOGLEZXINGCLIENTANDROID = new <init>("COMGOOGLEZXINGCLIENTANDROID", 6, "com.google.zxing.client.android", false);
        COMHTCFRIENDSTREAM = new <init>("COMHTCFRIENDSTREAM", 7, "com.htc.friendstream", false);
        COMMOTOROLAVZWVMM = new <init>("COMMOTOROLAVZWVMM", 8, "com.motorola.vzw.vmm", false);
        SKYPE = new <init>("SKYPE", 9, ShareItemsUtil.access$500(), false);
        SMS_MMS = new <init>("SMS_MMS", 10, ShareItemsUtil.access$600(), true);
        $VALUES = (new .VALUES[] {
            COMGOOGLEANDROIDGM, COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX, MAILAPPS, COMANDROIDBLUETOOTH, TWITTER, FACEBOOK, COMGOOGLEZXINGCLIENTANDROID, COMHTCFRIENDSTREAM, COMMOTOROLAVZWVMM, SKYPE, 
            SMS_MMS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        rawPackageName = s1;
        isSupported = true;
    }

    private isSupported(String s, int i, String s1, boolean flag)
    {
        super(s, i);
        rawPackageName = s1;
        isSupported = flag;
    }
}
