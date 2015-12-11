// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk;


public final class Common
{
    public static final class BearerType extends Enum
    {

        private static final BearerType ENUM$VALUES[];
        public static final BearerType cellular;
        public static final BearerType none;
        public static final BearerType wifi;

        public static BearerType valueOf(String s)
        {
            return (BearerType)Enum.valueOf(com/penthera/virtuososdk/Common$BearerType, s);
        }

        public static BearerType[] values()
        {
            BearerType abearertype[] = ENUM$VALUES;
            int i = abearertype.length;
            BearerType abearertype1[] = new BearerType[i];
            System.arraycopy(abearertype, 0, abearertype1, 0, i);
            return abearertype1;
        }

        static 
        {
            none = new BearerType("none", 0);
            wifi = new BearerType("wifi", 1);
            cellular = new BearerType("cellular", 2);
            ENUM$VALUES = (new BearerType[] {
                none, wifi, cellular
            });
        }

        private BearerType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EFileDownloadStatus extends Enum
    {

        private static final EFileDownloadStatus ENUM$VALUES[];
        public static final EFileDownloadStatus KvDE_Download_Complete;
        public static final EFileDownloadStatus KvDE_Download_Complete_Pending_Integrity_Check;
        public static final EFileDownloadStatus kVDE_Download_File_Copy_Error;
        public static final EFileDownloadStatus kVDE_Download_File_Corrupt;
        public static final EFileDownloadStatus kVDE_Download_File_Mime_Mismatch;
        public static final EFileDownloadStatus kVDE_Download_File_Size_Mismatch;
        public static final EFileDownloadStatus kVDE_Download_HLS_Fragment_Copy_Error;
        public static final EFileDownloadStatus kVDE_Download_Network_Error;
        public static final EFileDownloadStatus kVDE_Download_Not_Pending;
        public static final EFileDownloadStatus kVDE_Download_Pending;
        public static final EFileDownloadStatus kVDE_Download_Reachability_Error;
        public static final EFileDownloadStatus kVDE_Downloading;
        public static final EFileDownloadStatus kvDE_Collection_Partially_Complete;
        public static final EFileDownloadStatus kvDE_Expired;
        public static final EFileDownloadStatus kvDE_HLS_Manifest_Processing;

        public static EFileDownloadStatus valueOf(String s)
        {
            return (EFileDownloadStatus)Enum.valueOf(com/penthera/virtuososdk/Common$EFileDownloadStatus, s);
        }

        public static EFileDownloadStatus[] values()
        {
            EFileDownloadStatus aefiledownloadstatus[] = ENUM$VALUES;
            int i = aefiledownloadstatus.length;
            EFileDownloadStatus aefiledownloadstatus1[] = new EFileDownloadStatus[i];
            System.arraycopy(aefiledownloadstatus, 0, aefiledownloadstatus1, 0, i);
            return aefiledownloadstatus1;
        }

        static 
        {
            kVDE_Download_Not_Pending = new EFileDownloadStatus("kVDE_Download_Not_Pending", 0);
            kVDE_Download_Pending = new EFileDownloadStatus("kVDE_Download_Pending", 1);
            kVDE_Downloading = new EFileDownloadStatus("kVDE_Downloading", 2);
            kVDE_Download_Network_Error = new EFileDownloadStatus("kVDE_Download_Network_Error", 3);
            kVDE_Download_Reachability_Error = new EFileDownloadStatus("kVDE_Download_Reachability_Error", 4);
            kVDE_Download_File_Copy_Error = new EFileDownloadStatus("kVDE_Download_File_Copy_Error", 5);
            kVDE_Download_File_Mime_Mismatch = new EFileDownloadStatus("kVDE_Download_File_Mime_Mismatch", 6);
            kVDE_Download_File_Size_Mismatch = new EFileDownloadStatus("kVDE_Download_File_Size_Mismatch", 7);
            kVDE_Download_File_Corrupt = new EFileDownloadStatus("kVDE_Download_File_Corrupt", 8);
            KvDE_Download_Complete_Pending_Integrity_Check = new EFileDownloadStatus("KvDE_Download_Complete_Pending_Integrity_Check", 9);
            KvDE_Download_Complete = new EFileDownloadStatus("KvDE_Download_Complete", 10);
            kvDE_Expired = new EFileDownloadStatus("kvDE_Expired", 11);
            kvDE_Collection_Partially_Complete = new EFileDownloadStatus("kvDE_Collection_Partially_Complete", 12);
            kvDE_HLS_Manifest_Processing = new EFileDownloadStatus("kvDE_HLS_Manifest_Processing", 13);
            kVDE_Download_HLS_Fragment_Copy_Error = new EFileDownloadStatus("kVDE_Download_HLS_Fragment_Copy_Error", 14);
            ENUM$VALUES = (new EFileDownloadStatus[] {
                kVDE_Download_Not_Pending, kVDE_Download_Pending, kVDE_Downloading, kVDE_Download_Network_Error, kVDE_Download_Reachability_Error, kVDE_Download_File_Copy_Error, kVDE_Download_File_Mime_Mismatch, kVDE_Download_File_Size_Mismatch, kVDE_Download_File_Corrupt, KvDE_Download_Complete_Pending_Integrity_Check, 
                KvDE_Download_Complete, kvDE_Expired, kvDE_Collection_Partially_Complete, kvDE_HLS_Manifest_Processing, kVDE_Download_HLS_Fragment_Copy_Error
            });
        }

        private EFileDownloadStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EVirtuosoDownloadEngineStatus extends Enum
    {

        private static final EVirtuosoDownloadEngineStatus ENUM$VALUES[];
        public static final EVirtuosoDownloadEngineStatus kVDE_AuthenticationFailure;
        public static final EVirtuosoDownloadEngineStatus kVDE_Blocked;
        public static final EVirtuosoDownloadEngineStatus kVDE_Disabled;
        public static final EVirtuosoDownloadEngineStatus kVDE_Downloading;
        public static final EVirtuosoDownloadEngineStatus kVDE_Errors;
        public static final EVirtuosoDownloadEngineStatus kVDE_Idle;
        public static final EVirtuosoDownloadEngineStatus kVDE_Paused;

        public static EVirtuosoDownloadEngineStatus valueOf(String s)
        {
            return (EVirtuosoDownloadEngineStatus)Enum.valueOf(com/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus, s);
        }

        public static EVirtuosoDownloadEngineStatus[] values()
        {
            EVirtuosoDownloadEngineStatus aevirtuosodownloadenginestatus[] = ENUM$VALUES;
            int i = aevirtuosodownloadenginestatus.length;
            EVirtuosoDownloadEngineStatus aevirtuosodownloadenginestatus1[] = new EVirtuosoDownloadEngineStatus[i];
            System.arraycopy(aevirtuosodownloadenginestatus, 0, aevirtuosodownloadenginestatus1, 0, i);
            return aevirtuosodownloadenginestatus1;
        }

        static 
        {
            kVDE_Downloading = new EVirtuosoDownloadEngineStatus("kVDE_Downloading", 0);
            kVDE_Idle = new EVirtuosoDownloadEngineStatus("kVDE_Idle", 1);
            kVDE_Paused = new EVirtuosoDownloadEngineStatus("kVDE_Paused", 2);
            kVDE_Disabled = new EVirtuosoDownloadEngineStatus("kVDE_Disabled", 3);
            kVDE_Blocked = new EVirtuosoDownloadEngineStatus("kVDE_Blocked", 4);
            kVDE_Errors = new EVirtuosoDownloadEngineStatus("kVDE_Errors", 5);
            kVDE_AuthenticationFailure = new EVirtuosoDownloadEngineStatus("kVDE_AuthenticationFailure", 6);
            ENUM$VALUES = (new EVirtuosoDownloadEngineStatus[] {
                kVDE_Downloading, kVDE_Idle, kVDE_Paused, kVDE_Disabled, kVDE_Blocked, kVDE_Errors, kVDE_AuthenticationFailure
            });
        }

        private EVirtuosoDownloadEngineStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EngineStatusInfo extends Enum
    {

        public static final EngineStatusInfo EBlockedAuthentication;
        public static final EngineStatusInfo EBlockedBattery;
        public static final EngineStatusInfo EBlockedCell;
        public static final EngineStatusInfo EBlockedErrorHTTP;
        public static final EngineStatusInfo EBlockedHeadroom;
        public static final EngineStatusInfo EBlockedPaused;
        public static final EngineStatusInfo EBlockedStorage;
        public static final EngineStatusInfo EErrorExpired;
        public static final EngineStatusInfo EErrorFile;
        public static final EngineStatusInfo EErrorFileCorrupt;
        public static final EngineStatusInfo EErrorFileExpectedSize;
        public static final EngineStatusInfo EErrorFileMimeType;
        public static final EngineStatusInfo EErrorNetwork;
        public static final EngineStatusInfo EErrorUnknown;
        public static final EngineStatusInfo EErrorsMaxed;
        public static final EngineStatusInfo EFileExpired;
        public static final EngineStatusInfo EFileRemoved;
        private static final EngineStatusInfo ENUM$VALUES[];
        public static final EngineStatusInfo ENoError;
        public static final EngineStatusInfo EPriorityChange;

        public static EngineStatusInfo valueOf(String s)
        {
            return (EngineStatusInfo)Enum.valueOf(com/penthera/virtuososdk/Common$EngineStatusInfo, s);
        }

        public static EngineStatusInfo[] values()
        {
            EngineStatusInfo aenginestatusinfo[] = ENUM$VALUES;
            int i = aenginestatusinfo.length;
            EngineStatusInfo aenginestatusinfo1[] = new EngineStatusInfo[i];
            System.arraycopy(aenginestatusinfo, 0, aenginestatusinfo1, 0, i);
            return aenginestatusinfo1;
        }

        static 
        {
            ENoError = new EngineStatusInfo("ENoError", 0);
            EBlockedCell = new EngineStatusInfo("EBlockedCell", 1);
            EBlockedPaused = new EngineStatusInfo("EBlockedPaused", 2);
            EBlockedBattery = new EngineStatusInfo("EBlockedBattery", 3);
            EBlockedHeadroom = new EngineStatusInfo("EBlockedHeadroom", 4);
            EBlockedStorage = new EngineStatusInfo("EBlockedStorage", 5);
            EBlockedErrorHTTP = new EngineStatusInfo("EBlockedErrorHTTP", 6);
            EErrorNetwork = new EngineStatusInfo("EErrorNetwork", 7);
            EErrorFile = new EngineStatusInfo("EErrorFile", 8);
            EErrorFileMimeType = new EngineStatusInfo("EErrorFileMimeType", 9);
            EErrorFileExpectedSize = new EngineStatusInfo("EErrorFileExpectedSize", 10);
            EErrorFileCorrupt = new EngineStatusInfo("EErrorFileCorrupt", 11);
            EErrorsMaxed = new EngineStatusInfo("EErrorsMaxed", 12);
            EErrorExpired = new EngineStatusInfo("EErrorExpired", 13);
            EErrorUnknown = new EngineStatusInfo("EErrorUnknown", 14);
            EPriorityChange = new EngineStatusInfo("EPriorityChange", 15);
            EFileRemoved = new EngineStatusInfo("EFileRemoved", 16);
            EFileExpired = new EngineStatusInfo("EFileExpired", 17);
            EBlockedAuthentication = new EngineStatusInfo("EBlockedAuthentication", 18);
            ENUM$VALUES = (new EngineStatusInfo[] {
                ENoError, EBlockedCell, EBlockedPaused, EBlockedBattery, EBlockedHeadroom, EBlockedStorage, EBlockedErrorHTTP, EErrorNetwork, EErrorFile, EErrorFileMimeType, 
                EErrorFileExpectedSize, EErrorFileCorrupt, EErrorsMaxed, EErrorExpired, EErrorUnknown, EPriorityChange, EFileRemoved, EFileExpired, EBlockedAuthentication
            });
        }

        private EngineStatusInfo(String s, int i)
        {
            super(s, i);
        }
    }

}
