// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.aviary.android.feather.common.AviaryIntent;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.ConnectionUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.ResourcesUtils;
import com.aviary.android.feather.common.utils.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils, AviaryCdsDownloaderFactory, AviaryCdsValidatorFactory

public final class AviaryCdsReceiver extends BroadcastReceiver
{
    private class AviaryPackageNeedsRedownloadException extends Exception
    {

        private static final long serialVersionUID = 1L;
        final AviaryCdsReceiver this$0;

        AviaryPackageNeedsRedownloadException(String s)
        {
            this$0 = AviaryCdsReceiver.this;
            super(s);
        }
    }


    public static final String ACTION_DOWNLOAD_PACKS_CONTENT = "aviary.android.cds.intent.action.ACTION_DOWNLOAD_PACKS_CONTENT";
    static final String ACTION_NOTIFICATION_DISMISSED = "aviary.android.cds.intent.action.ACTION_NOTIFICATION_DISMISSED";
    static final String ACTION_REMOVE_DOWNLOAD_CONTENT = "aviary.android.cds.intent.action.ACTION_REMOVE_DOWNLOAD_CONTENT";
    static final int DEFAULT_BACKGROUND_ITEMS = 3;
    static final int INVALID_PACK_ID = -1;
    static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER;
    static final int NOTIFICATION_SUCCESS_ID = 0x53f24;
    private static final String PREF_ACTIVE_INSTALLED_COUNT = "packs_installed_count";
    private static final String PREF_ACTIVE_INSTALLED_LIST = "packs_installed_list";

    public AviaryCdsReceiver()
    {
    }

    private void clearPrefsActiveNotifications(Context context, SharedPreferences sharedpreferences)
    {
        LOGGER.info("clearActiveNotifications");
        context = sharedpreferences.edit();
        context.clear();
        context.apply();
    }

    private PendingIntent getDeleteDownloadAlarmPendingIntent(Context context, long l)
    {
        Intent intent = new Intent(context, com/aviary/android/feather/cds/AviaryCdsReceiver);
        intent.setAction("aviary.android.cds.intent.action.ACTION_REMOVE_DOWNLOAD_CONTENT");
        intent.setData(Uri.parse((new StringBuilder()).append("content://").append(context.getPackageName()).append(".AviaryCdsReceiver/removeDownloadedPack/").append(l).toString()));
        intent.putExtra("entryId", l);
        return PendingIntent.getBroadcast(context, 0, intent, 0x8000000);
    }

    private PendingIntent getNotificationSuccessIntent(Context context)
    {
        Intent intent = new Intent(context, com/aviary/android/feather/cds/AviaryCdsReceiver);
        intent.setAction("aviary.android.cds.intent.action.ACTION_NOTIFICATION_DISMISSED");
        return PendingIntent.getBroadcast(context, 0, intent, 0x8000000);
    }

    private long getPackIdFromDownload(Cursor cursor)
    {
        if (cursor != null && cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("download_packId");
            if (i > -1)
            {
                return cursor.getLong(i);
            }
        }
        return -1L;
    }

    private String[] getPrefsInstalledPacks(Context context, SharedPreferences sharedpreferences, String s)
    {
        context = sharedpreferences.getString("packs_installed_list", "");
        if (!TextUtils.isEmpty(context))
        {
            try
            {
                context = context.split(",");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                context = null;
            }
        } else
        {
            context = null;
        }
        if (context != null && context.length > 0)
        {
            String as[] = new String[context.length + 1];
            int i = 0;
            do
            {
                sharedpreferences = as;
                if (i >= context.length)
                {
                    break;
                }
                as[i] = context[i];
                i++;
            } while (true);
        } else
        {
            sharedpreferences = new String[1];
        }
        sharedpreferences[sharedpreferences.length - 1] = s;
        return sharedpreferences;
    }

    private SharedPreferences getSharedPreferences(Context context)
    {
        return context.getSharedPreferences(com/aviary/android/feather/cds/AviaryCdsReceiver.getSimpleName(), 0);
    }

    private void handleActionDownloadComplete(Context context, long l)
    {
        DownloadManager downloadmanager;
        Cursor cursor;
        long l1;
        LOGGER.info("handleActionDownloadComplete: %d", new Object[] {
            Long.valueOf(l)
        });
        downloadmanager = (DownloadManager)context.getSystemService("download");
        Object obj = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("downloadPackId/").append(l).toString()), new String[] {
            "download_packId"
        }, null, null, null);
        l1 = getPackIdFromDownload(((Cursor) (obj)));
        IOUtils.closeSilently(((Cursor) (obj)));
        if (l1 == -1L)
        {
            return;
        }
        obj = new android.app.DownloadManager.Query();
        ((android.app.DownloadManager.Query) (obj)).setFilterById(new long[] {
            l
        });
        cursor = downloadmanager.query(((android.app.DownloadManager.Query) (obj)));
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        PacksContentColumns.ContentCursorWrapper contentcursorwrapper;
        PacksColumns.PackCursorWrapper packcursorwrapper;
        int i;
        i = cursor.getColumnIndex("status");
        contentcursorwrapper = CdsUtils.getPackContentById(context, l1, new String[] {
            "content_id", "content_packId", "content_iconPath", "content_displayName", "content_displayDescription", "content_purchased"
        });
        packcursorwrapper = CdsUtils.getPackById(context, l1, new String[] {
            "pack_id", "pack_identifier", "pack_type"
        });
        if (contentcursorwrapper != null && packcursorwrapper != null)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        throw new AviaryPackageNeedsRedownloadException("Pack information not found...fatal database error");
        AviaryPackageNeedsRedownloadException aviarypackageneedsredownloadexception;
        aviarypackageneedsredownloadexception;
        LOGGER.warn("Package needs redownload");
        downloadmanager.remove(new long[] {
            l
        });
        setNotificationForRedownloadPackage(context, l1, aviarypackageneedsredownloadexception.getMessage());
        IOUtils.closeSilently(cursor);
        setDeleteDownloadAlarm(context, l);
        return;
        i = cursor.getInt(i);
        if (context.getContentResolver().update(CdsUtils.getContentUri(context, (new StringBuilder()).append("download/id/").append(l).append("/updateStatus/").append(i).toString()), new ContentValues(), null, null) > 0)
        {
            CdsUtils.notifyDownloadStatusChange(context, l1, packcursorwrapper.getPackType(), i);
        }
          goto _L4
_L8:
        LOGGER.warn((new StringBuilder()).append("not handled: ").append(i).toString());
_L5:
        IOUtils.closeSilently(cursor);
        setDeleteDownloadAlarm(context, l);
        return;
_L9:
        Object obj1;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        obj1 = cursor.getString(cursor.getColumnIndex("local_filename"));
_L6:
        LOGGER.log((new StringBuilder()).append("uriString: ").append(((String) (obj1))).toString());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_625;
        }
        obj1 = Uri.parse(((String) (obj1))).getPath();
        LOGGER.log("path: %s", new Object[] {
            obj1
        });
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        handleDownloadSuccessful(context, packcursorwrapper, contentcursorwrapper, new File(((String) (obj1))), l);
          goto _L5
        obj1;
        IOUtils.closeSilently(cursor);
        setDeleteDownloadAlarm(context, l);
        throw obj1;
        obj1 = cursor.getString(cursor.getColumnIndex("local_uri"));
          goto _L6
        throw new AviaryPackageNeedsRedownloadException((new StringBuilder()).append("Download failed for ").append(contentcursorwrapper.getDisplayName()).append(". Path is null").toString());
        throw new AviaryPackageNeedsRedownloadException((new StringBuilder()).append("Download failed for ").append(contentcursorwrapper.getDisplayName()).append(". Uri string is null").toString());
_L10:
        throw new AviaryPackageNeedsRedownloadException((new StringBuilder()).append("Download failed for ").append(contentcursorwrapper.getDisplayName()).append(". ").append(CdsUtils.getReasonText(16, cursor.getInt(cursor.getColumnIndex("reason")))).toString());
_L2:
        LOGGER.warn((new StringBuilder()).append("Download cursor for downloadId ").append(l).append(" not valid.").toString());
        if ("amazon".equals("production")) goto _L5; else goto _L7
_L7:
        LOGGER.log("throw the exception");
        throw new AviaryPackageNeedsRedownloadException((new StringBuilder()).append("Try to download again item id ").append(l1).toString());
_L4:
        i;
        JVM INSTR lookupswitch 2: default 844
    //                   8: 430
    //                   16: 664;
           goto _L8 _L9 _L10
    }

    private void handleActionDownloadPacksContent(Context context, Intent intent)
    {
        long l = intent.getLongExtra("entryId", -1L);
        intent = AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.CONTENT);
        try
        {
            intent = intent.download(context, l);
            LOGGER.info((new StringBuilder()).append("result: ").append(intent).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            setNotificationForRedownloadPackage(context, l, intent.getMessage());
        }
    }

    private void handleConnectivityChange(Context context, Intent intent)
    {
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()))
        {
            intent = (NetworkInfo)intent.getParcelableExtra("networkInfo");
            boolean flag;
            if (android.net.NetworkInfo.State.CONNECTED == intent.getState())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && android.net.NetworkInfo.DetailedState.CONNECTED == intent.getDetailedState())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                LOGGER.warn("CONNECTED");
                intent = AviaryIntent.createCdsInitIntent(context, null, null);
                intent.putExtra("EXTRA_LAZY_EXECUTION", true);
                intent.putExtra("EXTRA_EXECUTE_WIFI_ONLY", true);
                intent.putExtra("EXTRA_EXECUTE_PLUGGED_ONLY", true);
                intent.putExtra("EXTRA_WIFI_CONNECTED", true);
                intent.putExtra("EXTRA_DOWNLOAD_EXTRA_ASSETS", true);
                intent.putExtra("EXTRA_MAX_ITEMS", 3);
                context.startService(intent);
            }
        }
    }

    private void handleDeleteDownloadEntry(Context context, Intent intent)
    {
        LOGGER.info(">> handleDeleteDownloadEntry: %s", new Object[] {
            intent
        });
        if (intent != null)
        {
            long l = intent.getLongExtra("entryId", -1L);
            context = (DownloadManager)context.getSystemService("download");
            if (context != null)
            {
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    tryDeleteDownloadedFile(context, l);
                }
                context.remove(new long[] {
                    l
                });
            }
        }
    }

    private void handleDownloadSuccessful(Context context, PacksColumns.PackCursorWrapper packcursorwrapper, PacksContentColumns.ContentCursorWrapper contentcursorwrapper, File file, long l)
        throws AviaryPackageNeedsRedownloadException
    {
        LOGGER.info("handleDownloadSuccessful");
        l = packcursorwrapper.getId();
        boolean flag = validatePackContentZip(context, contentcursorwrapper.getPackId(), packcursorwrapper.getPackType(), file);
        LOGGER.log("content is valid: %b", new Object[] {
            Boolean.valueOf(flag)
        });
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        File file1 = unpackZipFile(file, context, l, contentcursorwrapper.getId(), packcursorwrapper.getIdentifier());
        LOGGER.log("deleting downloadFile..");
        IOUtils.deleteQuietly(file);
        file = new ContentValues();
        file.put("content_contentPath", file1.getAbsolutePath());
        if (context.getContentResolver().update(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/content/id/").append(contentcursorwrapper.getId()).append("/updatePurchasedStatus/1").toString()), file, null, null) > 0)
        {
            CdsUtils.notifyPacksContentUpdated(context, packcursorwrapper.getPackType());
            CdsUtils.notifyPackContentUpdate(context, l);
            CdsUtils.notifyPackInstalled(context, l, packcursorwrapper.getPackType(), 1);
        } else
        {
            LOGGER.error("failed to update the db");
        }
        setPackDownloadSuccessfulNotification(context, l, contentcursorwrapper.getIconPath(), contentcursorwrapper.getDisplayName(), contentcursorwrapper.getDisplayDescription());
        return;
        context;
        context.printStackTrace();
        IOUtils.deleteQuietly(new File(CdsUtils.getPackItemsContentPath(packcursorwrapper.getIdentifier())));
_L1:
        throw new AviaryPackageNeedsRedownloadException("Error in unpacking zip file.");
        context;
        LOGGER.log("deleting downloadFile..");
        IOUtils.deleteQuietly(file);
        throw context;
        context;
        context.printStackTrace();
          goto _L1
        throw new AviaryPackageNeedsRedownloadException("Package contents are not valid");
    }

    private void handleNotificationDismissed(Context context, Intent intent)
    {
        LOGGER.info("handle notification dismissed");
        clearPrefsActiveNotifications(context, getSharedPreferences(context));
    }

    private void handlePackageReplaced(Context context, Intent intent)
    {
        LOGGER.warn("PACKAGE REPLACED");
        if (ConnectionUtils.isConnected(context, false, new int[] {
    1, 6
}))
        {
            intent = AviaryIntent.createCdsInitIntent(context, null, null);
            intent.putExtra("EXTRA_LAZY_EXECUTION", true);
            intent.putExtra("EXTRA_EXECUTE_WIFI_ONLY", true);
            intent.putExtra("EXTRA_EXECUTE_PLUGGED_ONLY", false);
            intent.putExtra("EXTRA_WIFI_CONNECTED", true);
            intent.putExtra("EXTRA_DOWNLOAD_EXTRA_ASSETS", true);
            intent.putExtra("EXTRA_MAX_ITEMS", 3);
            context.startService(intent);
        }
    }

    private void handlePowerConnected(Context context, Intent intent)
    {
        LOGGER.warn("PHONE CHARGING");
        if (ConnectionUtils.isConnected(context, false, new int[] {
    1, 6
}))
        {
            int i = intent.getIntExtra("plugged", 1);
            intent = AviaryIntent.createCdsInitIntent(context, null, null);
            intent.putExtra("EXTRA_LAZY_EXECUTION", true);
            intent.putExtra("EXTRA_EXECUTE_WIFI_ONLY", true);
            intent.putExtra("EXTRA_EXECUTE_PLUGGED_ONLY", true);
            intent.putExtra("EXTRA_WIFI_CONNECTED", true);
            intent.putExtra("plugged", i);
            intent.putExtra("EXTRA_DOWNLOAD_EXTRA_ASSETS", true);
            intent.putExtra("EXTRA_MAX_ITEMS", 3);
            context.startService(intent);
        }
    }

    private void setDeleteDownloadAlarm(Context context, long l)
    {
        long l1 = SystemClock.elapsedRealtime() + 1000L;
        LOGGER.info((new StringBuilder()).append("setDownloadDeleteAlarm: ").append(l1).toString());
        PendingIntent pendingintent = getDeleteDownloadAlarmPendingIntent(context, l);
        ((AlarmManager)context.getSystemService("alarm")).set(3, l1, pendingintent);
    }

    private void setNotificationForRedownloadPackage(Context context, long l, String s)
    {
        Object obj = CdsUtils.getPackById(context, l, null);
        PacksContentColumns.ContentCursorWrapper contentcursorwrapper = CdsUtils.getPackContentById(context, l, new String[] {
            "content_id", "content_packId", "content_contentURL", "content_displayName"
        });
        if (obj == null)
        {
            LOGGER.error((new StringBuilder()).append("pack is null for id: ").append(l).toString());
            return;
        } else
        {
            obj = ((PacksColumns.PackCursorWrapper) (obj)).getIdentifier();
            int i = context.getContentResolver().delete(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/").append(l).append("/delete_download_entry").toString()), null, null);
            LOGGER.info((new StringBuilder()).append(i).append(" entries deleted in download_packs_table for packId ").append(l).toString());
            Object obj1 = new Intent(context, com/aviary/android/feather/cds/AviaryCdsReceiver);
            ((Intent) (obj1)).setAction("aviary.android.cds.intent.action.ACTION_DOWNLOAD_PACKS_CONTENT");
            ((Intent) (obj1)).putExtra("entryId", l);
            ((Intent) (obj1)).putExtra("data", contentcursorwrapper.getContentURL());
            ((Intent) (obj1)).putExtra("identifier", ((String) (obj)));
            obj = PendingIntent.getBroadcast(context, 0, ((Intent) (obj1)), 0x8000000);
            obj1 = ResourcesUtils.getString(context, "feather_iap_download_failed", "Download Failed");
            s = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(0x1080078).setContentTitle(((CharSequence) (obj1))).setContentText((new StringBuilder()).append(((String) (obj1))).append(": ").append(contentcursorwrapper.getDisplayName()).toString()).setSubText(s).setContentIntent(((PendingIntent) (obj)));
            ((NotificationManager)context.getSystemService("notification")).notify((int)l, s.build());
            return;
        }
    }

    private void setPackDownloadSuccessfulNotification(Context context, long l, String s, String s1, String s2)
    {
        NotificationManager notificationmanager;
        SharedPreferences sharedpreferences;
        String as[];
        android.support.v4.app.NotificationCompat.Builder builder;
        String s3;
        int j1;
        LOGGER.info((new StringBuilder()).append("setPackDownloadSuccessfulNotification: ").append(l).append(", icon: ").append(s).toString());
        s2 = null;
        if (s != null)
        {
            s2 = BitmapFactory.decodeFile((new File(s)).getAbsolutePath());
        }
        int i = ResourcesUtils.getIdentifier(context, "aviary_iap_notification_ok", "drawable");
        int k = ResourcesUtils.getIdentifier(context, "aviary_iap_notification_group", "drawable");
        s = ResourcesUtils.getString(context, "feather_iap_pack_installed", "Installed");
        s3 = ResourcesUtils.getString(context, "feather_iap_notification_installed_summary", "Plugin succesfully installed");
        notificationmanager = (NotificationManager)context.getSystemService("notification");
        sharedpreferences = getSharedPreferences(context);
        j1 = sharedpreferences.getInt("packs_installed_count", 0);
        as = getPrefsInstalledPacks(context, sharedpreferences, s1);
        LOGGER.log("current active notifications: %d", new Object[] {
            Integer.valueOf(j1)
        });
        builder = new android.support.v4.app.NotificationCompat.Builder(context);
        builder.setAutoCancel(true);
        builder.setContentIntent(getNotificationSuccessIntent(context));
        builder.setDeleteIntent(getNotificationSuccessIntent(context));
        builder.setTicker((new StringBuilder()).append(s1).append(" ").append(s).toString());
        builder.setSmallIcon(i);
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        builder.setContentTitle(ResourcesUtils.formatString(context, "feather_notification_plugins_installed_count", "%1$d Plugins Installed", new Object[] {
            Integer.valueOf(j1 + 1)
        }));
        if (k != 0)
        {
            s2 = BitmapFactory.decodeResource(context.getResources(), k);
        }
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L2; else goto _L1
_L1:
        builder.setContentText(context.getApplicationInfo().loadLabel(context.getPackageManager()));
        builder.setContentInfo(String.valueOf(j1 + 1));
        LOGGER.log((new StringBuilder()).append("total: ").append(as.length).toString());
        s = s2;
        if (as == null) goto _L4; else goto _L3
_L3:
        s = s2;
        if (as.length <= 0) goto _L4; else goto _L5
_L5:
        int j;
        int i1;
        int k1;
        s = new android.support.v4.app.NotificationCompat.InboxStyle();
        i1 = 0;
        k1 = as.length;
        j = 0;
_L9:
        if (j >= k1) goto _L7; else goto _L6
_L6:
        s.addLine(as[j]);
        i1++;
        if (i1 <= 2) goto _L8; else goto _L7
_L7:
        if (as.length > 3)
        {
            j = as.length;
            s.setSummaryText((new StringBuilder()).append("+").append(ResourcesUtils.formatString(context, "feather_notification_plus_more", "%1$d more", new Object[] {
                Integer.valueOf(j - 3)
            })).toString());
        }
        builder.setStyle(s);
        s = s2;
_L4:
        if (s != null)
        {
            builder.setLargeIcon(s);
        }
        notificationmanager.notify(0x53f24, builder.build());
        updatePrefsActiveNotification(context, sharedpreferences, as, j1 + 1);
        return;
_L8:
        j++;
          goto _L9
_L2:
        builder.setContentText((new StringBuilder()).append(StringUtils.join(as, ",")).append(" ").append(s).toString());
        s = s2;
          goto _L4
        builder.setContentTitle(s1);
        builder.setContentText(s3);
        s = s2;
          goto _L4
    }

    private void tryDeleteDownloadedFile(DownloadManager downloadmanager, long l)
    {
        LOGGER.info("tryDeleteDownloadedFile: %d", new Object[] {
            Long.valueOf(l)
        });
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        query.setFilterById(new long[] {
            l
        });
        downloadmanager = downloadmanager.query(query);
        if (downloadmanager == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        int i;
        downloadmanager.moveToFirst();
        i = downloadmanager.getColumnIndex("local_uri");
        if (i <= -1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        String s;
        s = downloadmanager.getString(i);
        LOGGER.log("filename: %s", new Object[] {
            s
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        boolean flag = (new File(s)).delete();
        LOGGER.log("deleted: %b", new Object[] {
            Boolean.valueOf(flag)
        });
        IOUtils.closeSilently(downloadmanager);
        return;
        Object obj;
        obj;
        ((Throwable) (obj)).printStackTrace();
        IOUtils.closeSilently(downloadmanager);
        return;
        obj;
        IOUtils.closeSilently(downloadmanager);
        throw obj;
    }

    private File unpackZipFile(File file, Context context, long l, long l1, String s)
        throws IOException, AssertionError
    {
        return unpackZipFile(((InputStream) (new FileInputStream(file))), context, l, l1, s);
    }

    private File unpackZipFile(InputStream inputstream, Context context, long l, long l1, String s)
        throws IOException, AssertionError
    {
        s = CdsUtils.getPackItemsContentPath(s);
        context = new File(context.getFilesDir(), s);
        context.mkdirs();
        Assert.assertTrue(context.isDirectory());
        context.setReadable(true, false);
        IOUtils.unzip(inputstream, context);
        return context;
    }

    private void updatePrefsActiveNotification(Context context, SharedPreferences sharedpreferences, String as[], int i)
    {
        LOGGER.log("updateActiveNotificationNumber: %d (%s)", new Object[] {
            Integer.valueOf(i), StringUtils.join(as, ",")
        });
        context = sharedpreferences.edit();
        context.putInt("packs_installed_count", i);
        context.putString("packs_installed_list", StringUtils.join(as, ","));
        context.apply();
    }

    private boolean validatePackContentZip(Context context, long l, String s, File file)
    {
        AviaryCds.PackType packtype = convertPackType(s);
        if (packtype == null)
        {
            LOGGER.error((new StringBuilder()).append("unrecognized packtype: ").append(s).toString());
            return false;
        }
        s = AviaryCdsValidatorFactory.create(AviaryCds.ContentType.CONTENT, packtype);
        boolean flag;
        try
        {
            flag = s.validate(context, l, file, true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            LOGGER.error((new StringBuilder()).append("failed to validate package, ").append(context.getMessage()).toString());
            return false;
        }
        return flag;
    }

    AviaryCds.PackType convertPackType(String s)
    {
        try
        {
            s = AviaryCds.PackType.valueOf(s.toUpperCase(Locale.US));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        LOGGER.info((new StringBuilder()).append("ACTION: ").append(s).toString());
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(s))
        {
            handleActionDownloadComplete(context, intent.getLongExtra("extra_download_id", 0L));
        } else
        {
            if ("aviary.android.cds.intent.action.ACTION_DOWNLOAD_PACKS_CONTENT".equals(s))
            {
                handleActionDownloadPacksContent(context, intent);
                return;
            }
            if ("aviary.android.cds.intent.action.ACTION_REMOVE_DOWNLOAD_CONTENT".equals(s))
            {
                handleDeleteDownloadEntry(context, intent);
                return;
            }
            if ("aviary.android.cds.intent.action.ACTION_NOTIFICATION_DISMISSED".equals(s))
            {
                handleNotificationDismissed(context, intent);
                return;
            }
            if ("android.net.wifi.supplicant.CONNECTION_CHANGE".equals(s))
            {
                handleConnectivityChange(context, intent);
                return;
            }
            if ("android.net.wifi.STATE_CHANGE".equals(s))
            {
                handleConnectivityChange(context, intent);
                return;
            }
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(s))
            {
                handlePowerConnected(context, intent);
                return;
            }
            if (ApiHelper.AT_LEAST_12 && "android.intent.action.MY_PACKAGE_REPLACED".equals(s))
            {
                handlePackageReplaced(context, intent);
                return;
            }
        }
    }

    static 
    {
        LOGGER = LoggerFactory.getLogger("AviaryCdsReceiver", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
