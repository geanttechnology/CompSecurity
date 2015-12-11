// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk;


// Referenced classes of package com.penthera.virtuososdk:
//            Common

public static final class  extends Enum
{

    public static final EBlockedAuthentication EBlockedAuthentication;
    public static final EBlockedAuthentication EBlockedBattery;
    public static final EBlockedAuthentication EBlockedCell;
    public static final EBlockedAuthentication EBlockedErrorHTTP;
    public static final EBlockedAuthentication EBlockedHeadroom;
    public static final EBlockedAuthentication EBlockedPaused;
    public static final EBlockedAuthentication EBlockedStorage;
    public static final EBlockedAuthentication EErrorExpired;
    public static final EBlockedAuthentication EErrorFile;
    public static final EBlockedAuthentication EErrorFileCorrupt;
    public static final EBlockedAuthentication EErrorFileExpectedSize;
    public static final EBlockedAuthentication EErrorFileMimeType;
    public static final EBlockedAuthentication EErrorNetwork;
    public static final EBlockedAuthentication EErrorUnknown;
    public static final EBlockedAuthentication EErrorsMaxed;
    public static final EBlockedAuthentication EFileExpired;
    public static final EBlockedAuthentication EFileRemoved;
    private static final EBlockedAuthentication ENUM$VALUES[];
    public static final EBlockedAuthentication ENoError;
    public static final EBlockedAuthentication EPriorityChange;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/Common$EngineStatusInfo, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        ENoError = new <init>("ENoError", 0);
        EBlockedCell = new <init>("EBlockedCell", 1);
        EBlockedPaused = new <init>("EBlockedPaused", 2);
        EBlockedBattery = new <init>("EBlockedBattery", 3);
        EBlockedHeadroom = new <init>("EBlockedHeadroom", 4);
        EBlockedStorage = new <init>("EBlockedStorage", 5);
        EBlockedErrorHTTP = new <init>("EBlockedErrorHTTP", 6);
        EErrorNetwork = new <init>("EErrorNetwork", 7);
        EErrorFile = new <init>("EErrorFile", 8);
        EErrorFileMimeType = new <init>("EErrorFileMimeType", 9);
        EErrorFileExpectedSize = new <init>("EErrorFileExpectedSize", 10);
        EErrorFileCorrupt = new <init>("EErrorFileCorrupt", 11);
        EErrorsMaxed = new <init>("EErrorsMaxed", 12);
        EErrorExpired = new <init>("EErrorExpired", 13);
        EErrorUnknown = new <init>("EErrorUnknown", 14);
        EPriorityChange = new <init>("EPriorityChange", 15);
        EFileRemoved = new <init>("EFileRemoved", 16);
        EFileExpired = new <init>("EFileExpired", 17);
        EBlockedAuthentication = new <init>("EBlockedAuthentication", 18);
        ENUM$VALUES = (new ENUM.VALUES[] {
            ENoError, EBlockedCell, EBlockedPaused, EBlockedBattery, EBlockedHeadroom, EBlockedStorage, EBlockedErrorHTTP, EErrorNetwork, EErrorFile, EErrorFileMimeType, 
            EErrorFileExpectedSize, EErrorFileCorrupt, EErrorsMaxed, EErrorExpired, EErrorUnknown, EPriorityChange, EFileRemoved, EFileExpired, EBlockedAuthentication
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
