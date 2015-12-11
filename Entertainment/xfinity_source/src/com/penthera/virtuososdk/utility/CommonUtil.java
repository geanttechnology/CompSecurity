// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.penthera.virtuososdk.monitor.ExternalStorageInfo;
import java.io.File;
import org.apache.http.Header;

public final class CommonUtil
{
    public static final class BearerAction extends Enum
    {

        public static final BearerAction EDownload;
        private static final BearerAction ENUM$VALUES[];
        public static final BearerAction EUpload;

        public static BearerAction valueOf(String s)
        {
            return (BearerAction)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$BearerAction, s);
        }

        public static BearerAction[] values()
        {
            BearerAction abeareraction[] = ENUM$VALUES;
            int i = abeareraction.length;
            BearerAction abeareraction1[] = new BearerAction[i];
            System.arraycopy(abeareraction, 0, abeareraction1, 0, i);
            return abeareraction1;
        }

        static 
        {
            EUpload = new BearerAction("EUpload", 0);
            EDownload = new BearerAction("EDownload", 1);
            ENUM$VALUES = (new BearerAction[] {
                EUpload, EDownload
            });
        }

        private BearerAction(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Broadcasts
    {

        public static void registerLocalReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
        {
            registerReceiver(broadcastreceiver, intentfilter, true);
        }

        public static void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
        {
            registerReceiver(broadcastreceiver, intentfilter, false);
        }

        private static void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, boolean flag)
        {
            Context context = CommonUtil.getApplicationContext();
            if (flag)
            {
                LocalBroadcastManager.getInstance(context).registerReceiver(broadcastreceiver, intentfilter);
                return;
            } else
            {
                context.registerReceiver(broadcastreceiver, intentfilter);
                return;
            }
        }

        public static void sendBroadcast(String s)
        {
            sendBroadcast(s, null, null);
        }

        public static void sendBroadcast(String s, Bundle bundle)
        {
            sendBroadcast(s, bundle, null);
        }

        public static void sendBroadcast(String s, Bundle bundle, String s1)
        {
            sendBroadcast(s, bundle, s1, false);
        }

        public static void sendBroadcast(String s, Bundle bundle, String s1, boolean flag)
        {
            Context context = CommonUtil.getApplicationContext();
            Intent intent = new Intent();
            intent.setAction(s);
            if (bundle != null)
            {
                intent.putExtras(bundle);
            }
            if (s1 != null)
            {
                intent.setType(s1);
            }
            if (flag)
            {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                return;
            } else
            {
                context.sendBroadcast(intent);
                return;
            }
        }

        public static void sendLocalBroadcast(String s)
        {
            sendBroadcast(s, null, null, true);
        }

        public static void sendLocalBroadcast(String s, Bundle bundle)
        {
            sendBroadcast(s, bundle, null, true);
        }

        public static void unregisterLocalReceiver(BroadcastReceiver broadcastreceiver)
        {
            unregisterReceiver(broadcastreceiver, true);
        }

        public static void unregisterReceiver(BroadcastReceiver broadcastreceiver)
        {
            unregisterReceiver(broadcastreceiver, false);
        }

        private static void unregisterReceiver(BroadcastReceiver broadcastreceiver, boolean flag)
        {
            Context context = CommonUtil.getApplicationContext();
            if (flag)
            {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastreceiver);
                return;
            } else
            {
                context.unregisterReceiver(broadcastreceiver);
                return;
            }
        }
    }

    public static final class Config
    {

        public static final BUILD_TYPE BUILD;

        static 
        {
            BUILD = BUILD_TYPE.EGold;
        }
    }

    public static final class Config.BUILD_TYPE extends Enum
    {

        public static final Config.BUILD_TYPE EGold;
        private static final Config.BUILD_TYPE ENUM$VALUES[];
        public static final Config.BUILD_TYPE ESilver;

        public static Config.BUILD_TYPE valueOf(String s)
        {
            return (Config.BUILD_TYPE)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE, s);
        }

        public static Config.BUILD_TYPE[] values()
        {
            Config.BUILD_TYPE abuild_type[] = ENUM$VALUES;
            int i = abuild_type.length;
            Config.BUILD_TYPE abuild_type1[] = new Config.BUILD_TYPE[i];
            System.arraycopy(abuild_type, 0, abuild_type1, 0, i);
            return abuild_type1;
        }

        static 
        {
            ESilver = new Config.BUILD_TYPE("ESilver", 0);
            EGold = new Config.BUILD_TYPE("EGold", 1);
            ENUM$VALUES = (new Config.BUILD_TYPE[] {
                ESilver, EGold
            });
        }

        private Config.BUILD_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Config.BuildFeatures
    {

        public static boolean isFlagSet(int i)
        {
            return (6L & (long)i) > 0L;
        }
    }

    public static final class Directory
    {

        public static String NOMEDIA_FILENAME = ".nomedia";

        public static boolean createMediaRoot(Context context)
        {
            StringBuffer stringbuffer = new StringBuffer();
            context = getRoot(context);
            if (TextUtils.isEmpty(context))
            {
                return false;
            }
            stringbuffer.append(context);
            stringbuffer.append("/");
            stringbuffer.append("media");
            stringbuffer.append("/");
            context = new File(stringbuffer.toString());
            if (context.exists())
            {
                return true;
            } else
            {
                return context.mkdirs();
            }
        }

        public static boolean createRoot(Context context)
        {
            context = getExternalPath(context, "virtuoso");
            if (context == null)
            {
                return false;
            }
            if (context.exists())
            {
                return true;
            } else
            {
                return context.mkdirs();
            }
        }

        private static File getExternalPath(Context context, String s)
        {
            return getExternalPath(context, s, true);
        }

        private static File getExternalPath(Context context, String s, boolean flag)
        {
            Object obj;
            obj = ExternalStorageInfo.getInstance();
            ((ExternalStorageInfo) (obj)).update();
            if (((ExternalStorageInfo) (obj)).isMounted() || ((ExternalStorageInfo) (obj)).isWritable()) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            Object obj1;
            StringBuilder stringbuilder;
            boolean flag1;
            stringbuilder = new StringBuilder();
            obj1 = null;
            obj = obj1;
            flag1 = flag;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            if (context == null)
            {
                Log.e("Directory", "getExternalPath: context is null");
                return null;
            }
            obj = context.getExternalFilesDir(null);
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag1 = flag;
_L4:
            if (!flag1)
            {
                obj = Environment.getExternalStorageDirectory();
            }
            if (obj != null)
            {
                stringbuilder.append(((File) (obj)).getAbsolutePath());
                stringbuilder.append("/");
                if (s != null)
                {
                    stringbuilder.append(s);
                    stringbuilder.append("/");
                }
                return new File(stringbuilder.toString());
            }
            if (true) goto _L1; else goto _L3
_L3:
            context;
            flag1 = false;
            obj = obj1;
              goto _L4
        }

        public static String getMediaRoot(Context context)
        {
            context = getExternalPath(context, "virtuoso/media");
            if (context != null)
            {
                return context.getAbsolutePath();
            } else
            {
                return "";
            }
        }

        public static String getRoot(Context context)
        {
            context = getExternalPath(context, "virtuoso");
            if (context != null)
            {
                return context.getAbsolutePath();
            } else
            {
                return "";
            }
        }

    }

    public static final class EDownloadCallbackType extends Enum
    {

        public static final EDownloadCallbackType ECollectionComplete;
        public static final EDownloadCallbackType ECollectionProgress;
        public static final EDownloadCallbackType ECollectionsChanged;
        public static final EDownloadCallbackType ECollectionsDeleted;
        public static final EDownloadCallbackType EDownloadEnd;
        public static final EDownloadCallbackType EDownloadQueueChanged;
        public static final EDownloadCallbackType EDownloadStart;
        public static final EDownloadCallbackType EDownloadedListChanged;
        public static final EDownloadCallbackType EFragmentComplete;
        public static final EDownloadCallbackType EFullListChanged;
        public static final EDownloadCallbackType EItemDownloadRemoved;
        public static final EDownloadCallbackType EItemUpdate;
        public static final EDownloadCallbackType EListFiles;
        public static final EDownloadCallbackType EListFilesIteratively;
        private static final EDownloadCallbackType ENUM$VALUES[];
        public static final EDownloadCallbackType EProgressUpdate;
        public static final EDownloadCallbackType ESettingsChanged;
        public static final EDownloadCallbackType EStatusChange;

        public static EDownloadCallbackType valueOf(String s)
        {
            return (EDownloadCallbackType)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType, s);
        }

        public static EDownloadCallbackType[] values()
        {
            EDownloadCallbackType aedownloadcallbacktype[] = ENUM$VALUES;
            int i = aedownloadcallbacktype.length;
            EDownloadCallbackType aedownloadcallbacktype1[] = new EDownloadCallbackType[i];
            System.arraycopy(aedownloadcallbacktype, 0, aedownloadcallbacktype1, 0, i);
            return aedownloadcallbacktype1;
        }

        static 
        {
            EStatusChange = new EDownloadCallbackType("EStatusChange", 0);
            EDownloadStart = new EDownloadCallbackType("EDownloadStart", 1);
            EProgressUpdate = new EDownloadCallbackType("EProgressUpdate", 2);
            EDownloadEnd = new EDownloadCallbackType("EDownloadEnd", 3);
            EDownloadQueueChanged = new EDownloadCallbackType("EDownloadQueueChanged", 4);
            EDownloadedListChanged = new EDownloadCallbackType("EDownloadedListChanged", 5);
            EFullListChanged = new EDownloadCallbackType("EFullListChanged", 6);
            EListFiles = new EDownloadCallbackType("EListFiles", 7);
            EListFilesIteratively = new EDownloadCallbackType("EListFilesIteratively", 8);
            ESettingsChanged = new EDownloadCallbackType("ESettingsChanged", 9);
            EItemUpdate = new EDownloadCallbackType("EItemUpdate", 10);
            ECollectionsChanged = new EDownloadCallbackType("ECollectionsChanged", 11);
            ECollectionsDeleted = new EDownloadCallbackType("ECollectionsDeleted", 12);
            ECollectionProgress = new EDownloadCallbackType("ECollectionProgress", 13);
            ECollectionComplete = new EDownloadCallbackType("ECollectionComplete", 14);
            EFragmentComplete = new EDownloadCallbackType("EFragmentComplete", 15);
            EItemDownloadRemoved = new EDownloadCallbackType("EItemDownloadRemoved", 16);
            ENUM$VALUES = (new EDownloadCallbackType[] {
                EStatusChange, EDownloadStart, EProgressUpdate, EDownloadEnd, EDownloadQueueChanged, EDownloadedListChanged, EFullListChanged, EListFiles, EListFilesIteratively, ESettingsChanged, 
                EItemUpdate, ECollectionsChanged, ECollectionsDeleted, ECollectionProgress, ECollectionComplete, EFragmentComplete, EItemDownloadRemoved
            });
        }

        private EDownloadCallbackType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EFileDownloadCompletion extends Enum
    {

        public static final EFileDownloadCompletion EDownloadBlockedAuthentication;
        public static final EFileDownloadCompletion EDownloadBlockedBattery;
        public static final EFileDownloadCompletion EDownloadBlockedCell;
        public static final EFileDownloadCompletion EDownloadBlockedErrorExpired;
        public static final EFileDownloadCompletion EDownloadBlockedErrorFile;
        public static final EFileDownloadCompletion EDownloadBlockedErrorFileCorrupt;
        public static final EFileDownloadCompletion EDownloadBlockedErrorFileExpectedSize;
        public static final EFileDownloadCompletion EDownloadBlockedErrorFileMimeType;
        public static final EFileDownloadCompletion EDownloadBlockedErrorHTTP;
        public static final EFileDownloadCompletion EDownloadBlockedErrorNetwork;
        public static final EFileDownloadCompletion EDownloadBlockedErrorsMaxed;
        public static final EFileDownloadCompletion EDownloadBlockedHeadroom;
        public static final EFileDownloadCompletion EDownloadBlockedPaused;
        public static final EFileDownloadCompletion EDownloadBlockedStorage;
        public static final EFileDownloadCompletion EDownloadBlockedUnknown;
        public static final EFileDownloadCompletion EDownloadComplete;
        public static final EFileDownloadCompletion EDownloadFileExpired;
        public static final EFileDownloadCompletion EDownloadFileRemoved;
        public static final EFileDownloadCompletion EDownloadPriorityChange;
        public static final EFileDownloadCompletion EInternalErrorRetryOn416;
        private static final EFileDownloadCompletion ENUM$VALUES[];

        public static EFileDownloadCompletion valueOf(String s)
        {
            return (EFileDownloadCompletion)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion, s);
        }

        public static EFileDownloadCompletion[] values()
        {
            EFileDownloadCompletion aefiledownloadcompletion[] = ENUM$VALUES;
            int i = aefiledownloadcompletion.length;
            EFileDownloadCompletion aefiledownloadcompletion1[] = new EFileDownloadCompletion[i];
            System.arraycopy(aefiledownloadcompletion, 0, aefiledownloadcompletion1, 0, i);
            return aefiledownloadcompletion1;
        }

        static 
        {
            EDownloadComplete = new EFileDownloadCompletion("EDownloadComplete", 0);
            EDownloadBlockedCell = new EFileDownloadCompletion("EDownloadBlockedCell", 1);
            EDownloadBlockedPaused = new EFileDownloadCompletion("EDownloadBlockedPaused", 2);
            EDownloadBlockedBattery = new EFileDownloadCompletion("EDownloadBlockedBattery", 3);
            EDownloadBlockedHeadroom = new EFileDownloadCompletion("EDownloadBlockedHeadroom", 4);
            EDownloadBlockedStorage = new EFileDownloadCompletion("EDownloadBlockedStorage", 5);
            EDownloadBlockedErrorHTTP = new EFileDownloadCompletion("EDownloadBlockedErrorHTTP", 6);
            EDownloadBlockedErrorNetwork = new EFileDownloadCompletion("EDownloadBlockedErrorNetwork", 7);
            EDownloadBlockedErrorFile = new EFileDownloadCompletion("EDownloadBlockedErrorFile", 8);
            EDownloadBlockedErrorFileMimeType = new EFileDownloadCompletion("EDownloadBlockedErrorFileMimeType", 9);
            EDownloadBlockedErrorFileExpectedSize = new EFileDownloadCompletion("EDownloadBlockedErrorFileExpectedSize", 10);
            EDownloadBlockedErrorFileCorrupt = new EFileDownloadCompletion("EDownloadBlockedErrorFileCorrupt", 11);
            EDownloadBlockedErrorsMaxed = new EFileDownloadCompletion("EDownloadBlockedErrorsMaxed", 12);
            EDownloadBlockedErrorExpired = new EFileDownloadCompletion("EDownloadBlockedErrorExpired", 13);
            EDownloadBlockedUnknown = new EFileDownloadCompletion("EDownloadBlockedUnknown", 14);
            EDownloadPriorityChange = new EFileDownloadCompletion("EDownloadPriorityChange", 15);
            EDownloadFileRemoved = new EFileDownloadCompletion("EDownloadFileRemoved", 16);
            EDownloadFileExpired = new EFileDownloadCompletion("EDownloadFileExpired", 17);
            EDownloadBlockedAuthentication = new EFileDownloadCompletion("EDownloadBlockedAuthentication", 18);
            EInternalErrorRetryOn416 = new EFileDownloadCompletion("EInternalErrorRetryOn416", 19);
            ENUM$VALUES = (new EFileDownloadCompletion[] {
                EDownloadComplete, EDownloadBlockedCell, EDownloadBlockedPaused, EDownloadBlockedBattery, EDownloadBlockedHeadroom, EDownloadBlockedStorage, EDownloadBlockedErrorHTTP, EDownloadBlockedErrorNetwork, EDownloadBlockedErrorFile, EDownloadBlockedErrorFileMimeType, 
                EDownloadBlockedErrorFileExpectedSize, EDownloadBlockedErrorFileCorrupt, EDownloadBlockedErrorsMaxed, EDownloadBlockedErrorExpired, EDownloadBlockedUnknown, EDownloadPriorityChange, EDownloadFileRemoved, EDownloadFileExpired, EDownloadBlockedAuthentication, EInternalErrorRetryOn416
            });
        }

        private EFileDownloadCompletion(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FileAction extends Enum
    {

        public static final FileAction EAdd;
        public static final FileAction EAddToCollection;
        public static final FileAction EExpire;
        public static final FileAction EListAllFiles;
        public static final FileAction EListDownloaded;
        public static final FileAction EListQueued;
        public static final FileAction EMove;
        private static final FileAction ENUM$VALUES[];
        public static final FileAction ERemove;
        public static final FileAction ERemoveAll;
        public static final FileAction ERemoveAllFromQueue;
        public static final FileAction EUpdate;

        public static FileAction valueOf(String s)
        {
            return (FileAction)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$FileAction, s);
        }

        public static FileAction[] values()
        {
            FileAction afileaction[] = ENUM$VALUES;
            int i = afileaction.length;
            FileAction afileaction1[] = new FileAction[i];
            System.arraycopy(afileaction, 0, afileaction1, 0, i);
            return afileaction1;
        }

        static 
        {
            EAdd = new FileAction("EAdd", 0);
            EAddToCollection = new FileAction("EAddToCollection", 1);
            EMove = new FileAction("EMove", 2);
            ERemove = new FileAction("ERemove", 3);
            EListQueued = new FileAction("EListQueued", 4);
            EListDownloaded = new FileAction("EListDownloaded", 5);
            EListAllFiles = new FileAction("EListAllFiles", 6);
            ERemoveAllFromQueue = new FileAction("ERemoveAllFromQueue", 7);
            ERemoveAll = new FileAction("ERemoveAll", 8);
            EExpire = new FileAction("EExpire", 9);
            EUpdate = new FileAction("EUpdate", 10);
            ENUM$VALUES = (new FileAction[] {
                EAdd, EAddToCollection, EMove, ERemove, EListQueued, EListDownloaded, EListAllFiles, ERemoveAllFromQueue, ERemoveAll, EExpire, 
                EUpdate
            });
        }

        private FileAction(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FileHelpers
    {

        public static long getFileSize(File file)
        {
            if (file.exists())
            {
                return file.length();
            } else
            {
                return 0L;
            }
        }
    }

    public static final class HttpUtils
    {

        public static void dumpHeaders(Header aheader[])
        {
            if (aheader != null)
            {
                int j = aheader.length;
                int i = 0;
                while (i < j) 
                {
                    Header header = aheader[i];
                    Log.d("HttpUtils", (new StringBuilder(String.valueOf(header.getName()))).append(" : ").append(header.getValue()).toString());
                    i++;
                }
            }
        }
    }

    public static final class Log
    {

        public static int iLogLevel = 0;

        public static void a(String s, String s1)
        {
            android.util.Log.i(s, s1);
        }

        public static void d(String s, String s1)
        {
            if (iLogLevel > 2)
            {
                android.util.Log.i(s, s1);
            }
        }

        public static void d(String s, String s1, Throwable throwable)
        {
            if (iLogLevel > 2)
            {
                android.util.Log.i(s, s1, throwable);
            }
        }

        public static void e(String s, String s1)
        {
            if (iLogLevel > 0)
            {
                android.util.Log.e(s, s1);
            }
        }

        public static void e(String s, String s1, Throwable throwable)
        {
            if (iLogLevel > 0)
            {
                android.util.Log.e(s, s1, throwable);
            }
        }

        public static void i(String s, String s1)
        {
            if (iLogLevel > 1)
            {
                android.util.Log.i(s, s1);
            }
        }

        public static void w(String s, String s1)
        {
            if (iLogLevel > 0)
            {
                android.util.Log.e(s, s1);
            }
        }

    }

    public static final class NetworkHelpers
    {

        public static void dump(NetworkInfo networkinfo)
        {
            if (networkinfo == null)
            {
                Log.w("NetworkHelpers", "NetworkInfo is null: There is no connection");
                return;
            } else
            {
                Log.i("NetworkHelpers", (new StringBuilder("isAvailable: ")).append(networkinfo.isAvailable()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("isConnected: ")).append(networkinfo.isConnected()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("isConnectedOrConnecting: ")).append(networkinfo.isConnectedOrConnecting()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("isRoaming: ")).append(networkinfo.isRoaming()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("getState: ")).append(networkinfo.getState()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("getDetailedState: ")).append(networkinfo.getDetailedState()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("getReason: ")).append(networkinfo.getReason()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("getTypeName: ")).append(networkinfo.getTypeName()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("getSubTypeName: ")).append(networkinfo.getSubtypeName()).toString());
                Log.i("NetworkHelpers", (new StringBuilder("isFailOver: ")).append(networkinfo.isFailover()).toString());
                return;
            }
        }

        public static void dump(WifiManager wifimanager)
        {
            if (wifimanager == null)
            {
                try
                {
                    Log.w("NetworkHelpers", "WifiManager is null: There is no WIFI");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (WifiManager wifimanager)
                {
                    Log.e("NetworkHelpers", (new StringBuilder("Caught exception taking a dump: ")).append(wifimanager).toString());
                }
                break MISSING_BLOCK_LABEL_110;
            }
            Log.i("NetworkHelpers", (new StringBuilder("isWifiEnabled: ")).append(wifimanager.isWifiEnabled()).toString());
            Log.i("NetworkHelpers", (new StringBuilder("getWifiState: ")).append(wifiStateToString(wifimanager.getWifiState())).toString());
            Log.i("NetworkHelpers", (new StringBuilder("getConnectionInfo: ")).append(wifimanager.getConnectionInfo()).toString());
            return;
        }

        public static boolean isCell(Context context)
        {
            context = (ConnectivityManager)context.getSystemService("connectivity");
            if (context != null)
            {
                if ((context = context.getActiveNetworkInfo()) != null && context.getType() == 0)
                {
                    return true;
                }
            }
            return false;
        }

        public static String wifiStateToString(int i)
        {
            switch (i)
            {
            default:
                return "WHOPPER_JAWED";

            case 1: // '\001'
                return "WIFI_STATE_DISABLED";

            case 0: // '\0'
                return "WIFI_STATE_DISABLING";

            case 3: // '\003'
                return "WIFI_STATE_ENABLED";

            case 2: // '\002'
                return "WIFI_STATE_ENABLING";

            case 4: // '\004'
                return "WIFI_STATE_UNKNOWN";
            }
        }
    }


    private static Context iApplicationContext;

    public static Context getApplicationContext()
    {
        return iApplicationContext;
    }

    public static String mimeTypeToExtension(String s)
    {
        return null;
    }

    public static void setApplicationContext(Context context)
    {
        iApplicationContext = context;
    }
}
