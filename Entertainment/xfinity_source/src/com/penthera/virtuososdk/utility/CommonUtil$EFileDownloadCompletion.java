// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class I extends Enum
{

    public static final EInternalErrorRetryOn416 EDownloadBlockedAuthentication;
    public static final EInternalErrorRetryOn416 EDownloadBlockedBattery;
    public static final EInternalErrorRetryOn416 EDownloadBlockedCell;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorExpired;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorFile;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorFileCorrupt;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorFileExpectedSize;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorFileMimeType;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorHTTP;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorNetwork;
    public static final EInternalErrorRetryOn416 EDownloadBlockedErrorsMaxed;
    public static final EInternalErrorRetryOn416 EDownloadBlockedHeadroom;
    public static final EInternalErrorRetryOn416 EDownloadBlockedPaused;
    public static final EInternalErrorRetryOn416 EDownloadBlockedStorage;
    public static final EInternalErrorRetryOn416 EDownloadBlockedUnknown;
    public static final EInternalErrorRetryOn416 EDownloadComplete;
    public static final EInternalErrorRetryOn416 EDownloadFileExpired;
    public static final EInternalErrorRetryOn416 EDownloadFileRemoved;
    public static final EInternalErrorRetryOn416 EDownloadPriorityChange;
    public static final EInternalErrorRetryOn416 EInternalErrorRetryOn416;
    private static final EInternalErrorRetryOn416 ENUM$VALUES[];

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion, s);
    }

    public static I[] values()
    {
        I ai[] = ENUM$VALUES;
        int i = ai.length;
        I ai1[] = new ENUM.VALUES[i];
        System.arraycopy(ai, 0, ai1, 0, i);
        return ai1;
    }

    static 
    {
        EDownloadComplete = new <init>("EDownloadComplete", 0);
        EDownloadBlockedCell = new <init>("EDownloadBlockedCell", 1);
        EDownloadBlockedPaused = new <init>("EDownloadBlockedPaused", 2);
        EDownloadBlockedBattery = new <init>("EDownloadBlockedBattery", 3);
        EDownloadBlockedHeadroom = new <init>("EDownloadBlockedHeadroom", 4);
        EDownloadBlockedStorage = new <init>("EDownloadBlockedStorage", 5);
        EDownloadBlockedErrorHTTP = new <init>("EDownloadBlockedErrorHTTP", 6);
        EDownloadBlockedErrorNetwork = new <init>("EDownloadBlockedErrorNetwork", 7);
        EDownloadBlockedErrorFile = new <init>("EDownloadBlockedErrorFile", 8);
        EDownloadBlockedErrorFileMimeType = new <init>("EDownloadBlockedErrorFileMimeType", 9);
        EDownloadBlockedErrorFileExpectedSize = new <init>("EDownloadBlockedErrorFileExpectedSize", 10);
        EDownloadBlockedErrorFileCorrupt = new <init>("EDownloadBlockedErrorFileCorrupt", 11);
        EDownloadBlockedErrorsMaxed = new <init>("EDownloadBlockedErrorsMaxed", 12);
        EDownloadBlockedErrorExpired = new <init>("EDownloadBlockedErrorExpired", 13);
        EDownloadBlockedUnknown = new <init>("EDownloadBlockedUnknown", 14);
        EDownloadPriorityChange = new <init>("EDownloadPriorityChange", 15);
        EDownloadFileRemoved = new <init>("EDownloadFileRemoved", 16);
        EDownloadFileExpired = new <init>("EDownloadFileExpired", 17);
        EDownloadBlockedAuthentication = new <init>("EDownloadBlockedAuthentication", 18);
        EInternalErrorRetryOn416 = new <init>("EInternalErrorRetryOn416", 19);
        ENUM$VALUES = (new ENUM.VALUES[] {
            EDownloadComplete, EDownloadBlockedCell, EDownloadBlockedPaused, EDownloadBlockedBattery, EDownloadBlockedHeadroom, EDownloadBlockedStorage, EDownloadBlockedErrorHTTP, EDownloadBlockedErrorNetwork, EDownloadBlockedErrorFile, EDownloadBlockedErrorFileMimeType, 
            EDownloadBlockedErrorFileExpectedSize, EDownloadBlockedErrorFileCorrupt, EDownloadBlockedErrorsMaxed, EDownloadBlockedErrorExpired, EDownloadBlockedUnknown, EDownloadPriorityChange, EDownloadFileRemoved, EDownloadFileExpired, EDownloadBlockedAuthentication, EInternalErrorRetryOn416
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
