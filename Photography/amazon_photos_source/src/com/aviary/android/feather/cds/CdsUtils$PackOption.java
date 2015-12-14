// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

public static final class  extends Enum
{

    private static final DOWNLOAD_COMPLETE $VALUES[];
    public static final DOWNLOAD_COMPLETE DOWNLOADING;
    public static final DOWNLOAD_COMPLETE DOWNLOAD_COMPLETE;
    public static final DOWNLOAD_COMPLETE DOWNLOAD_ERROR;
    public static final DOWNLOAD_COMPLETE ERROR;
    public static final DOWNLOAD_COMPLETE FREE;
    public static final DOWNLOAD_COMPLETE INSTALL;
    public static final DOWNLOAD_COMPLETE OWNED;
    public static final DOWNLOAD_COMPLETE PACK_OPTION_BEING_DETERMINED;
    public static final DOWNLOAD_COMPLETE PURCHASE;
    public static final DOWNLOAD_COMPLETE RESTORE;
    public static final DOWNLOAD_COMPLETE UNINSTALL;

    public static  fromDownloadManagerStatus(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 4: // '\004'
        case 16: // '\020'
            return DOWNLOAD_ERROR;

        case 1: // '\001'
        case 2: // '\002'
            return DOWNLOADING;

        case 8: // '\b'
            return DOWNLOAD_COMPLETE;
        }
    }

    public static boolean isDetermined(DOWNLOAD_COMPLETE download_complete)
    {
        if (download_complete != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (p.com.aviary.android.feather.cds.CdsUtils.PackOption[download_complete.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isFree(ordinal ordinal)
    {
        switch (p.com.aviary.android.feather.cds.CdsUtils.PackOption[ordinal.ordinal()])
        {
        default:
            return false;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            return true;
        }
    }

    public static boolean isInstalled(ordinal ordinal)
    {
        return ordinal != null && (ordinal == OWNED || ordinal == UNINSTALL);
    }

    public static boolean isOwned(UNINSTALL uninstall)
    {
        switch (p.com.aviary.android.feather.cds.CdsUtils.PackOption[uninstall.ordinal()])
        {
        default:
            return false;

        case 4: // '\004'
        case 5: // '\005'
            return true;
        }
    }

    public static ordinal valueOf(String s)
    {
        return (ordinal)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$PackOption, s);
    }

    public static ordinal[] values()
    {
        return (ordinal[])$VALUES.clone();
    }

    static 
    {
        PURCHASE = new <init>("PURCHASE", 0);
        FREE = new <init>("FREE", 1);
        INSTALL = new <init>("INSTALL", 2);
        RESTORE = new <init>("RESTORE", 3);
        OWNED = new <init>("OWNED", 4);
        UNINSTALL = new <init>("UNINSTALL", 5);
        PACK_OPTION_BEING_DETERMINED = new <init>("PACK_OPTION_BEING_DETERMINED", 6);
        ERROR = new <init>("ERROR", 7);
        DOWNLOADING = new <init>("DOWNLOADING", 8);
        DOWNLOAD_ERROR = new <init>("DOWNLOAD_ERROR", 9);
        DOWNLOAD_COMPLETE = new <init>("DOWNLOAD_COMPLETE", 10);
        $VALUES = (new .VALUES[] {
            PURCHASE, FREE, INSTALL, RESTORE, OWNED, UNINSTALL, PACK_OPTION_BEING_DETERMINED, ERROR, DOWNLOADING, DOWNLOAD_ERROR, 
            DOWNLOAD_COMPLETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
