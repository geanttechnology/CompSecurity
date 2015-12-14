// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MergeCursor;
import com.aviary.android.feather.cds.json.CdsManifestParser;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IDisposable;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.ResourcesUtils;
import com.aviary.android.feather.common.utils.SystemUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService, CdsUtils, IAPWrapper

public final class RestoreAllHelper
    implements IDisposable
{

    static final int NOTIFICATION_COMPLETE_ERROR_ID = 22334;
    public static final int NOTIFICATION_ONGOING_ID = 22322;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    Context context;
    NotificationManager notificationManager;
    android.support.v4.app.NotificationCompat.Builder notificationProgressBuilder;
    AviaryCds.PackType packType;
    AviaryCdsService service;
    boolean wifiOnly;

    RestoreAllHelper(AviaryCdsService aviarycdsservice, AviaryCds.PackType packtype, boolean flag)
    {
        service = aviarycdsservice;
        context = aviarycdsservice.getBaseContext();
        packType = packtype;
        wifiOnly = flag;
        notificationManager = (NotificationManager)context.getSystemService("notification");
    }

    private ArrayList acquireRestoreList()
        throws AviaryCdsService.RestoreException
    {
        Object obj;
        Object obj2;
        ArrayList arraylist;
        Object obj3;
        logger.info("acquireRestoreList");
        arraylist = new ArrayList();
        obj2 = new ArrayList();
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption = new int[CdsUtils.PackOption.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[CdsUtils.PackOption.RESTORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[CdsUtils.PackOption.ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        CdsUtils.PackOption packoption;
        if (packType != null)
        {
            obj = acquireRestoreListCursor(packType);
        } else
        {
            obj = new Cursor[AviaryCds.PackType.values().length];
            int j = 0;
            obj3 = AviaryCds.PackType.values();
            int k = obj3.length;
            for (int i = 0; i < k; i++)
            {
                obj[j] = acquireRestoreListCursor(obj3[i]);
                j++;
            }

            obj = new MergeCursor(((Cursor []) (obj)));
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        logger.log("cursor.size: %d", new Object[] {
            Integer.valueOf(((Cursor) (obj)).getCount())
        });
_L9:
        if (!((Cursor) (obj)).moveToNext()) goto _L4; else goto _L3
_L3:
        obj3 = PacksColumns.PackCursorWrapper.create(((Cursor) (obj)));
        ((PacksColumns.PackCursorWrapper) (obj3)).setContent(PacksContentColumns.ContentCursorWrapper.create(((Cursor) (obj))));
        packoption = CdsUtils.getPackOption(context, ((PacksColumns.PackCursorWrapper) (obj3)));
        logger.log("%s (%s) = %s", new Object[] {
            ((PacksColumns.PackCursorWrapper) (obj3)).getContent().getDisplayName(), ((PacksColumns.PackCursorWrapper) (obj3)).getIdentifier(), packoption
        });
        _cls1..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[packoption.ordinal()];
        JVM INSTR tableswitch 1 3: default 380
    //                   1 180
    //                   2 268
    //                   3 268;
           goto _L5 _L6 _L7 _L7
_L6:
        ((ArrayList) (obj2)).add(obj3);
_L5:
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
        IOUtils.closeSilently(((Cursor) (obj)));
        throw obj2;
_L7:
        arraylist.add(obj3);
          goto _L9
_L4:
        IOUtils.closeSilently(((Cursor) (obj)));
        if (arraylist.size() > 0)
        {
            Object obj1;
            try
            {
                obj1 = service.getIAPInstance().getPurchasedItems(arraylist);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
                throw new AviaryCdsService.RestoreException(1, ((Throwable) (obj1)));
            }
            if (obj1 == null)
            {
                throw new AviaryCdsService.RestoreException(1, "Purchased Inventory is empty");
            } else
            {
                logger.log("inventoryList: %s", new Object[] {
                    obj1
                });
                ((ArrayList) (obj2)).addAll(((java.util.Collection) (obj1)));
                return ((ArrayList) (obj2));
            }
        } else
        {
            logger.log("checkPackList is empty");
            return ((ArrayList) (obj2));
        }
_L2:
        throw new AviaryCdsService.RestoreException(2, "Restore Cursor is null");
    }

    private Cursor acquireRestoreListCursor(AviaryCds.PackType packtype)
    {
        logger.verbose("acquireRestoreListCursor, packType: %s", new Object[] {
            packtype
        });
        return context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/type/").append(packtype.toCdsString()).append("/content/restore/list").toString()), new String[] {
            "pack_id as _id", "pack_id", "pack_type", "pack_identifier", "content_id", "content_contentPath", "content_contentURL", "content_displayName", "content_iconPath", "content_iconUrl", 
            "content_isFree", "content_purchased", "content_packId", "content_numItems"
        }, null, null, "pack_id ASC");
    }

    public static android.support.v4.app.NotificationCompat.Builder createNotification(Context context1)
    {
        int i = ResourcesUtils.getIdentifier(context1, "aviary_iap_notification_ok", "drawable");
        String s = ResourcesUtils.getString(context1, "feather_iap_restore_all", "Restore All");
        String s1 = ResourcesUtils.getString(context1, "feather_iap_restore_all_in_progress", "Restore All in Progress");
        return (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(i).setContentTitle(s).setContentText(s1).setTicker(s1).setProgress(100, 0, true).setContentIntent(getNullPendingIntent(context1)).setOngoing(true);
    }

    private static PendingIntent getNullPendingIntent(Context context1)
    {
        return PendingIntent.getService(context1, 0, new Intent(), 0);
    }

    private void onComplete(Context context1, ArrayList arraylist, List list)
    {
        logger.info("onComplete: %d - %d", new Object[] {
            Integer.valueOf(arraylist.size()), Integer.valueOf(list.size())
        });
        notificationManager.cancel(22322);
        if (list.size() == 0)
        {
            onNotifyComplete(context1, arraylist);
        }
        onNotifyCompleteError(context1, list);
    }

    private List onDownloadMissingIcons(ArrayList arraylist, String s, int i, int j)
    {
        double d;
        double d1;
        ArrayList arraylist1;
        int k;
        logger.info("onDownloadMissingIcons: %d", new Object[] {
            Integer.valueOf(arraylist.size())
        });
        arraylist1 = new ArrayList();
        k = arraylist.size();
        d = 0.0D;
        d1 = j - i;
        logger.log("icons to be downloaded: %d", new Object[] {
            Integer.valueOf(k)
        });
        arraylist = arraylist.iterator();
_L2:
        PacksColumns.PackCursorWrapper packcursorwrapper;
        boolean flag;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        packcursorwrapper = (PacksColumns.PackCursorWrapper)arraylist.next();
        flag = false;
        logger.log("checking icon for %s", new Object[] {
            packcursorwrapper.getIdentifier()
        });
        boolean flag1 = service.downloadPackIcon(context, s, false, packcursorwrapper);
        flag = flag1;
_L3:
        if (!flag)
        {
            arraylist1.add(new AviaryCdsService.RestoreException(7, (new StringBuilder()).append("Failed to download icon for ").append(packcursorwrapper.getContent().getDisplayName()).toString()));
            arraylist.remove();
        }
        onProgress(100, i + (int)((d / (double)k) * d1), false);
        d++;
        if (true) goto _L2; else goto _L1
        Object obj;
        obj;
        ((IOException) (obj)).printStackTrace();
          goto _L3
        obj;
        ((AssertionError) (obj)).printStackTrace();
          goto _L3
_L1:
        return arraylist1;
    }

    private List onDownloadPacks(List list, int i, int j)
    {
        double d;
        double d1;
        ArrayList arraylist;
        Iterator iterator;
        int k;
        logger.info("onDownloadPacks %d items", new Object[] {
            Integer.valueOf(list.size())
        });
        k = list.size();
        d = 0.0D;
        d1 = j - i;
        arraylist = new ArrayList();
        iterator = list.iterator();
_L2:
        String s;
        PacksColumns.PackCursorWrapper packcursorwrapper;
        String s2;
        long l;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        packcursorwrapper = (PacksColumns.PackCursorWrapper)iterator.next();
        l = packcursorwrapper.getId();
        s = null;
        s2 = packcursorwrapper.getIdentifier();
        list = null;
        String s1 = CdsUtils.requestPackDownload(context, l, true);
        s = s1;
_L3:
        if (s == null)
        {
            logger.error((new StringBuilder()).append("failed to start download for ").append(s2).toString());
            if (list != null)
            {
                arraylist.add(new AviaryCdsService.RestoreException(8, (new StringBuilder()).append("Failed to download ").append(s2).append(". ").append(list.toString()).toString()));
            } else
            {
                arraylist.add(new AviaryCdsService.RestoreException(8, (new StringBuilder()).append("Download failed for ").append(s2).toString()));
            }
            iterator.remove();
        } else
        {
            logger.log("started download request for %s (result:%s)", new Object[] {
                packcursorwrapper.getIdentifier(), s
            });
        }
        onProgress(100, i + (int)((d / (double)k) * d1), false);
        SystemUtils.trySleep(1000L);
        d++;
        if (true) goto _L2; else goto _L1
        list;
          goto _L3
_L1:
        return arraylist;
    }

    private void onNotifyComplete(Context context1, ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            int i = ResourcesUtils.getIdentifier(context1, "aviary_iap_notification_ok", "drawable");
            arraylist = ResourcesUtils.getString(context1, "feather_notification_restore_all_completed", "Restore all completed");
            String s = ResourcesUtils.getString(context1, "feather_notification_no_items_to_restore", "No item needs to be restored");
            context1 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setContentTitle(arraylist).setContentText(s).setTicker(arraylist).setContentIntent(getNullPendingIntent(context1)).setSmallIcon(i);
            notificationManager.notify(22322, context1.build());
        }
    }

    private void onNotifyCompleteError(Context context1, List list)
    {
        if (list == null || list.size() < 1)
        {
            return;
        }
        String s = ResourcesUtils.getString(context1, "feather_notification_some_items_cant_be_restored", "Some items could not be restored");
        String s1 = ResourcesUtils.getString(context1, "feather_please_try_again_later", "Please try again later");
        String s2 = ResourcesUtils.getString(context1, "feather_notification_n_items_cant_be_restored", "%1$s items could not be restored");
        context1 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setContentTitle(String.format(s2, new Object[] {
            Integer.valueOf(list.size())
        })).setContentText(s).setTicker(s).setSubText(s1).setAutoCancel(true).setContentIntent(getNullPendingIntent(context1)).setLights(0xffff0000, 500, 1500).setVibrate(new long[] {
            0L, 100L, 200L, 300L
        }).setSmallIcon(0x1080078);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            android.support.v4.app.NotificationCompat.InboxStyle inboxstyle = new android.support.v4.app.NotificationCompat.InboxStyle();
            int i = 0;
            Iterator iterator = list.iterator();
            int k;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                inboxstyle.addLine(((AviaryCdsService.RestoreException)iterator.next()).getLocalizedMessage());
                k = i + 1;
                i = k;
            } while (k <= 2);
            if (list.size() > 3)
            {
                int j = list.size();
                inboxstyle.setSummaryText((new StringBuilder()).append("+").append(j - 3).append(" more").toString());
            }
            context1.setStyle(inboxstyle);
        }
        notificationManager.notify(22334, context1.build());
    }

    private void onProgress(int i, int j, boolean flag)
    {
        notificationProgressBuilder.setProgress(i, j, flag);
        notificationManager.notify(22322, notificationProgressBuilder.build());
    }

    private void onProgressError(CharSequence charsequence, AviaryCdsService.RestoreException restoreexception, CharSequence charsequence1, int i)
    {
        logger.error("onProgressError: %s", new Object[] {
            restoreexception
        });
        int j = 0;
        CharSequence charsequence2 = charsequence1;
        if (restoreexception != null)
        {
            if (restoreexception.getMessage() != null)
            {
                charsequence1 = restoreexception.getMessage();
            }
            j = restoreexception.getCode();
            charsequence2 = charsequence1;
        }
        onProgressError(charsequence, charsequence2, i, j);
    }

    private void onProgressError(CharSequence charsequence, CharSequence charsequence1, int i, int j)
    {
        charsequence1 = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(0x1080078).setContentTitle(charsequence).setContentText(charsequence1).setTicker(charsequence);
        StringBuilder stringbuilder = (new StringBuilder()).append("Error code: ").append(i);
        if (j > 0)
        {
            charsequence = (new StringBuilder()).append(", Cause: ").append(j).toString();
        } else
        {
            charsequence = "";
        }
        charsequence = charsequence1.setSubText(stringbuilder.append(charsequence).toString()).setOngoing(false).setContentIntent(getNullPendingIntent(context)).build();
        notificationManager.cancel(22322);
        notificationManager.notify(22322, charsequence);
    }

    public void dispose()
    {
    }

    void restoreAll()
    {
        String s;
        String s1;
        Object obj;
        ArrayList arraylist;
        logger.info("restoreAll. packType: %s", new Object[] {
            packType
        });
        s = ResourcesUtils.getString(context, "feather_iap_failed_download_informations", "Failed to download the required informations");
        s1 = ResourcesUtils.getString(context, "feather_iap_restore_all_failed", "Restore All Failed");
        notificationProgressBuilder = createNotification(context);
        onProgress(100, 0, true);
        SystemUtils.trySleep(500L);
        logger.info(">> DownloadManifest");
        Object obj1;
        try
        {
            obj = service.downloadAndParseManifest(wifiOnly);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((AviaryCdsService.RestoreException) (obj)).printStackTrace();
            onProgressError(s1, ((AviaryCdsService.RestoreException) (obj)), s, 1);
            return;
        }
        onProgress(100, 5, false);
        arraylist = new ArrayList();
        logger.info(">> RestoreOwnedPacks");
        if (packType == null) goto _L2; else goto _L1
_L1:
        arraylist.addAll(service.onRestoreOwnedPacks(((CdsManifestParser) (obj)), packType.toCdsString(), wifiOnly));
_L4:
        onProgress(100, 20, false);
        logger.info(">> RestoreMissingPacks");
        obj1 = CdsUtils.getInstalledLegacyPacks(context);
        if (packType != null)
        {
            CdsUtils.filterSkuByPackType(((List) (obj1)), packType.toCdsString());
            logger.log("legacy packs filtered: %s", new Object[] {
                obj1
            });
        }
        if (obj1 != null)
        {
            arraylist.addAll(service.onRestoreMissingPacks(((CdsManifestParser) (obj)), ((List) (obj1)).iterator(), wifiOnly));
        }
        onProgress(100, 35, false);
        logger.info(">> AcquireRestoreList");
        AviaryCdsService.RestoreException restoreexception;
        AviaryCds.PackType apacktype[];
        AviaryCds.PackType packtype;
        int i;
        int j;
        try
        {
            obj1 = acquireRestoreList();
        }
        catch (AviaryCdsService.RestoreException restoreexception1)
        {
            onProgressError(s1, restoreexception1, s, 4);
            return;
        }
        onProgress(100, 40, false);
        logger.info(">> DownloadMissingIcons");
        arraylist.addAll(onDownloadMissingIcons(((ArrayList) (obj1)), ((CdsManifestParser) (obj)).getAssetsBaseURL(), 40, 70));
        logger.info(">> DownloadAll");
        arraylist.addAll(onDownloadPacks(((List) (obj1)), 70, 100));
        onComplete(context, ((ArrayList) (obj1)), arraylist);
        return;
_L2:
        try
        {
            apacktype = AviaryCds.PackType.values();
            j = apacktype.length;
        }
        // Misplaced declaration of an exception variable
        catch (AviaryCdsService.RestoreException restoreexception)
        {
            restoreexception.printStackTrace();
            onProgressError(s1, restoreexception, s, 2);
            return;
        }
        i = 0;
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        packtype = apacktype[i];
        arraylist.addAll(service.onRestoreOwnedPacks(((CdsManifestParser) (obj)), packtype.toCdsString(), wifiOnly));
        i++;
          goto _L5
    }

    static 
    {
        logger = LoggerFactory.getLogger(com/aviary/android/feather/cds/RestoreAllHelper.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
