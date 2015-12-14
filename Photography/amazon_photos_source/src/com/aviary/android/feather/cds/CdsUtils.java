// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.amazon.gallery.framework.aspect.AviaryCdsAspect;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.Objects;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory, IAPInstance

public final class CdsUtils
{
    public static final class PackOption extends Enum
    {

        private static final PackOption $VALUES[];
        public static final PackOption DOWNLOADING;
        public static final PackOption DOWNLOAD_COMPLETE;
        public static final PackOption DOWNLOAD_ERROR;
        public static final PackOption ERROR;
        public static final PackOption FREE;
        public static final PackOption INSTALL;
        public static final PackOption OWNED;
        public static final PackOption PACK_OPTION_BEING_DETERMINED;
        public static final PackOption PURCHASE;
        public static final PackOption RESTORE;
        public static final PackOption UNINSTALL;

        public static PackOption fromDownloadManagerStatus(int i)
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

        public static boolean isDetermined(PackOption packoption)
        {
            if (packoption != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            static class _cls3
            {

                static final int $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[];

                static 
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption = new int[PackOption.values().length];
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.PACK_OPTION_BEING_DETERMINED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.DOWNLOADING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.DOWNLOAD_COMPLETE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.OWNED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.UNINSTALL.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.FREE.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.INSTALL.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[PackOption.RESTORE.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[packoption.ordinal()])
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

        public static boolean isFree(PackOption packoption)
        {
            switch (_cls3..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[packoption.ordinal()])
            {
            default:
                return false;

            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
                return true;
            }
        }

        public static boolean isInstalled(PackOption packoption)
        {
            return packoption != null && (packoption == OWNED || packoption == UNINSTALL);
        }

        public static boolean isOwned(PackOption packoption)
        {
            switch (_cls3..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[packoption.ordinal()])
            {
            default:
                return false;

            case 4: // '\004'
            case 5: // '\005'
                return true;
            }
        }

        public static PackOption valueOf(String s)
        {
            return (PackOption)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$PackOption, s);
        }

        public static PackOption[] values()
        {
            return (PackOption[])$VALUES.clone();
        }

        static 
        {
            PURCHASE = new PackOption("PURCHASE", 0);
            FREE = new PackOption("FREE", 1);
            INSTALL = new PackOption("INSTALL", 2);
            RESTORE = new PackOption("RESTORE", 3);
            OWNED = new PackOption("OWNED", 4);
            UNINSTALL = new PackOption("UNINSTALL", 5);
            PACK_OPTION_BEING_DETERMINED = new PackOption("PACK_OPTION_BEING_DETERMINED", 6);
            ERROR = new PackOption("ERROR", 7);
            DOWNLOADING = new PackOption("DOWNLOADING", 8);
            DOWNLOAD_ERROR = new PackOption("DOWNLOAD_ERROR", 9);
            DOWNLOAD_COMPLETE = new PackOption("DOWNLOAD_COMPLETE", 10);
            $VALUES = (new PackOption[] {
                PURCHASE, FREE, INSTALL, RESTORE, OWNED, UNINSTALL, PACK_OPTION_BEING_DETERMINED, ERROR, DOWNLOADING, DOWNLOAD_ERROR, 
                DOWNLOAD_COMPLETE
            });
        }

        private PackOption(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PackOptionWithPrice
        implements Serializable
    {

        public PackOption option;
        public String price;

        public boolean equals(Object obj)
        {
            if (obj instanceof PackOptionWithPrice)
            {
                if (Objects.equal(((PackOptionWithPrice) (obj = (PackOptionWithPrice)obj)).option, option) && Objects.equal(((PackOptionWithPrice) (obj)).price, price))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            int j = option.hashCode();
            int i;
            if (price != null)
            {
                i = price.hashCode();
            } else
            {
                i = 0;
            }
            return i + (j + 1000);
        }

        public String toString()
        {
            return (new StringBuilder()).append("PackOptionWithPrice{ option: ").append(option.name()).append(", price: ").append(price).append("}").toString();
        }

        public PackOptionWithPrice(PackOption packoption)
        {
            this(packoption, null);
        }

        public PackOptionWithPrice(PackOption packoption, String s)
        {
            option = packoption;
            price = s;
        }
    }

    public static final class Resolution extends Enum
    {

        private static final Resolution $VALUES[];
        public static final Resolution DENSITY_TV;
        public static final Resolution HIGH;
        public static final Resolution LOW;
        public static final Resolution MEDIUM;
        public static final Resolution XHIGH;
        public static final Resolution XXHIGH;
        public static final Resolution XXXHIGH;
        int value;

        public static Resolution valueOf(String s)
        {
            return (Resolution)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$Resolution, s);
        }

        public static Resolution[] values()
        {
            return (Resolution[])$VALUES.clone();
        }

        static 
        {
            LOW = new Resolution("LOW", 0, 120);
            MEDIUM = new Resolution("MEDIUM", 1, 160);
            DENSITY_TV = new Resolution("DENSITY_TV", 2, 213);
            HIGH = new Resolution("HIGH", 3, 240);
            XHIGH = new Resolution("XHIGH", 4, 320);
            XXHIGH = new Resolution("XXHIGH", 5, 480);
            XXXHIGH = new Resolution("XXXHIGH", 6, 640);
            $VALUES = (new Resolution[] {
                LOW, MEDIUM, DENSITY_TV, HIGH, XHIGH, XXHIGH, XXXHIGH
            });
        }

        private Resolution(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    public static final class SubscriptionDurationTier extends Enum
    {

        private static final SubscriptionDurationTier $VALUES[];
        public static final SubscriptionDurationTier MONTH;
        public static final SubscriptionDurationTier YEAR;
        int value;

        public static SubscriptionDurationTier fromInt(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return MONTH;

            case 2: // '\002'
                return YEAR;
            }
        }

        public static SubscriptionDurationTier valueOf(String s)
        {
            return (SubscriptionDurationTier)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$SubscriptionDurationTier, s);
        }

        public static SubscriptionDurationTier[] values()
        {
            return (SubscriptionDurationTier[])$VALUES.clone();
        }

        static 
        {
            MONTH = new SubscriptionDurationTier("MONTH", 0, 1);
            YEAR = new SubscriptionDurationTier("YEAR", 1, 2);
            $VALUES = (new SubscriptionDurationTier[] {
                MONTH, YEAR
            });
        }

        private SubscriptionDurationTier(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    public static final String BROADCAST_DOWNLOAD_MISSING_PACKS_COMPLETED = ".cds.downloadMissingPacksCompleted";
    public static final String BROADCAST_DOWNLOAD_STATUS_CHANGED = ".cds.downloadStatusChanged";
    public static final String BROADCAST_PACK_INSTALLED = ".cds.packInstalled";
    public static final String BROADCAST_PACK_PURCHASED = ".cds.packPurchased";
    public static final String BROADCAST_SUBSCRIPTION_PURCHASED = ".cds.subscriptionPurchased";
    public static final List CDS_SUPPORTED_COUNTRIES = new ArrayList(Arrays.asList(new String[] {
        "US", "JP", "CN", "KR", "ID", "IN", "BR", "GB", "FR", "DE"
    }));
    public static final List CDS_SUPPORTED_LANGUAGES = new ArrayList(Arrays.asList(new String[] {
        "en", "ja", "zh", "ko", "id", "pt", "fr", "de"
    }));
    static final String DOWNLOAD_REF_ID_PROJECTION[] = {
        "download_refId"
    };
    public static final String LOG_TAG = "CdsUtils";
    private static final Comparator SIGNATURE_PARAMS_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((NameValuePair)obj, (NameValuePair)obj1);
        }

        public int compare(NameValuePair namevaluepair, NameValuePair namevaluepair1)
        {
            return namevaluepair.getName().compareTo(namevaluepair1.getName());
        }

    };
    static final List SUPPORTED_DENSITIES = Arrays.asList(new Integer[] {
        Integer.valueOf(160), Integer.valueOf(240), Integer.valueOf(320), Integer.valueOf(480)
    });
    static final HashMap S_LEGACY_PACKS_MAP;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_1;
    static String sResolution;

    private CdsUtils()
    {
    }

    static void addSignature(List list, String s)
    {
        Collections.sort(list, SIGNATURE_PARAMS_COMPARATOR);
        String s1 = URLEncodedUtils.format(list, "utf-8");
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA-256");
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return;
        }
        s = (new StringBuilder()).append(s1).append(s).toString();
        Log.d("CdsUtils", (new StringBuilder()).append("query: ").append(s).toString());
        messagedigest.update(s.getBytes());
        list.add(new BasicNameValuePair("signature", Base64.encodeToString(messagedigest.digest(), 2)));
    }

    private static void ajc$preClinit()
    {
        Factory factory = new Factory("CdsUtils.java", com/aviary/android/feather/cds/CdsUtils);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("8", "notifyDownloadStatusChange", "com.aviary.android.feather.cds.CdsUtils", "android.content.Context:long:java.lang.String:int", "context:packId:packType:newStatus", "", "void"), 1193);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig("9", "requestPackDownload", "com.aviary.android.feather.cds.CdsUtils", "android.content.Context:long:boolean", "context:packId:notify", "java.lang.AssertionError:java.io.IOException", "java.lang.String"), 1454);
    }

    static boolean apkInstalled(Context context, String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (PackageManagerUtils.getPackageInfo(context, s, 0) != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void filterSkuByPackType(List list, String s)
    {
        if (list != null)
        {
            list = list.iterator();
            s = (new StringBuilder()).append("com.aviary.").append(s).toString();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                if (!((String)list.next()).startsWith(s))
                {
                    list.remove();
                }
            } while (true);
        }
    }

    public static PacksContentColumns.ContentCursorWrapper getContentByIdentifier(Context context, String s, String as[])
    {
        Object obj = null;
        s = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/identifier/").append(s).append("/content").toString()), as, null, null, null);
        context = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        context = obj;
        if (s.moveToFirst())
        {
            context = PacksContentColumns.ContentCursorWrapper.create(s);
        }
        IOUtils.closeSilently(s);
        return context;
        context;
        IOUtils.closeSilently(s);
        throw context;
    }

    static Uri getContentUri(Context context, String s)
    {
        return PackageManagerUtils.getCDSProviderContentUri(context, s);
    }

    static List getInstalledLegacyPacks(Context context)
    {
        return getInstalledLegacyPacks(context, getLegacyEntryIterator());
    }

    static List getInstalledLegacyPacks(Context context, Iterator iterator)
    {
        ArrayList arraylist = new ArrayList();
        if (iterator != null)
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s = (String)entry.getKey();
                if (apkInstalled(context, (String)entry.getValue()))
                {
                    arraylist.add(s);
                }
            } while (true);
        }
        return arraylist;
    }

    static Iterator getLegacyEntryIterator()
    {
        return S_LEGACY_PACKS_MAP.entrySet().iterator();
    }

    public static String getLegacyPackageName(String s)
    {
        return (String)S_LEGACY_PACKS_MAP.get(s);
    }

    static VersionColumns.VersionCursorWrapper getManifestVersion(Context context)
    {
        context = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, "manifestVersion"), null, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        VersionColumns.VersionCursorWrapper versioncursorwrapper;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_43;
        }
        versioncursorwrapper = VersionColumns.VersionCursorWrapper.create(context);
        IOUtils.closeSilently(context);
        return versioncursorwrapper;
        IOUtils.closeSilently(context);
        return null;
        Exception exception;
        exception;
        IOUtils.closeSilently(context);
        throw exception;
    }

    public static MessageColumns.MessageCursorWrapper getMessageByIdentifier(Context context, String s, String as[])
    {
        as = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("message/identifier/").append(s).toString()), as, null, null, null);
        s = null;
        context = s;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context = s;
        if (as.moveToFirst())
        {
            context = MessageColumns.MessageCursorWrapper.create(as);
        }
        IOUtils.closeSilently(as);
        return context;
        context;
        IOUtils.closeSilently(as);
        throw context;
    }

    static String getMessageContentPath(String s)
    {
        return (new StringBuilder()).append(getPackRootContent(s)).append("/message_content").toString();
    }

    public static PacksColumns.PackCursorWrapper getPackById(Context context, long l, String as[])
    {
        Cursor cursor;
        cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).toString()), as, null, null, null);
        as = null;
        context = as;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        context = as;
        if (cursor.moveToFirst())
        {
            context = PacksColumns.PackCursorWrapper.create(cursor);
        }
        IOUtils.closeSilently(cursor);
        return context;
        context;
        IOUtils.closeSilently(cursor);
        throw context;
    }

    public static PacksColumns.PackCursorWrapper getPackByIdentifier(Context context, String s, String as[])
    {
        as = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/identifier/").append(s).toString()), as, null, null, null);
        s = null;
        context = s;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context = s;
        if (as.moveToFirst())
        {
            context = PacksColumns.PackCursorWrapper.create(as);
        }
        IOUtils.closeSilently(as);
        return context;
        context;
        IOUtils.closeSilently(as);
        throw context;
    }

    public static PacksContentColumns.ContentCursorWrapper getPackContentById(Context context, long l, String as[])
    {
        Object obj = null;
        as = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), as, null, null, null);
        context = obj;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        context = obj;
        if (as.moveToFirst())
        {
            context = PacksContentColumns.ContentCursorWrapper.create(as);
        }
        IOUtils.closeSilently(as);
        return context;
        context;
        IOUtils.closeSilently(as);
        throw context;
    }

    public static long getPackContentFileSize(Context context, String s)
    {
        return FileUtils.sizeOfDirectory(new File(context.getFilesDir(), getPackItemsContentPath(s)));
    }

    static String getPackContentFolderPath(String s)
    {
        return (new StringBuilder()).append(getPackRootContent(s)).append("/pack_content").toString();
    }

    public static String getPackContentPath(Context context, long l)
    {
        Cursor cursor;
        Object obj = null;
        cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), new String[] {
            "content_contentPath"
        }, null, null, null);
        context = obj;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        context = cursor.getString(cursor.getColumnIndex("content_contentPath"));
        IOUtils.closeSilently(cursor);
        return context;
        IOUtils.closeSilently(cursor);
        return null;
        context;
        IOUtils.closeSilently(cursor);
        throw context;
    }

    public static Pair getPackDownloadStatus(Context context, long l)
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        cursor1 = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("packDownloadStatus/").append(l).toString()), DOWNLOAD_REF_ID_PROJECTION, null, null, null);
        cursor = null;
        obj = (DownloadManager)context.getSystemService("download");
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        context = cursor;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_214;
        }
        context = cursor;
        l = cursor1.getLong(0);
        context = cursor;
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        context = cursor;
        query.setFilterById(new long[] {
            l
        });
        context = cursor;
        cursor = ((DownloadManager) (obj)).query(query);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        context = cursor;
        boolean flag = cursor.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        IOUtils.closeSilently(cursor1);
        IOUtils.closeSilently(cursor);
        return null;
        context = cursor;
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        context = cursor;
        obj = new Pair(Integer.valueOf(i), getReasonText(i, cursor.getInt(cursor.getColumnIndex("reason"))));
        IOUtils.closeSilently(cursor1);
        IOUtils.closeSilently(cursor);
        return ((Pair) (obj));
        IOUtils.closeSilently(cursor1);
        IOUtils.closeSilently(null);
        return null;
        Exception exception;
        exception;
        IOUtils.closeSilently(cursor1);
        IOUtils.closeSilently(context);
        throw exception;
    }

    public static PacksColumns.PackCursorWrapper getPackFullInfoById(Context context, long l)
    {
        Cursor cursor;
        Object obj = null;
        cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), null, null, null, null);
        context = obj;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        context = obj;
        if (cursor.moveToFirst())
        {
            context = PacksColumns.PackCursorWrapper.create(cursor);
            context.setContent(PacksContentColumns.ContentCursorWrapper.create(cursor));
        }
        IOUtils.closeSilently(cursor);
        return context;
        context;
        IOUtils.closeSilently(cursor);
        throw context;
    }

    static String getPackIconPath(String s)
    {
        return (new StringBuilder()).append(getPackRootContent(s)).append("/icon").toString();
    }

    public static Pair getPackItemByIdentifier(Context context, String s, String s1, String as[])
    {
        Object obj;
        Object obj1;
        obj = null;
        Object obj2 = null;
        obj1 = null;
        as = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/").append(s).append("/item/").append(s1).toString()), as, "pack_finishedDownloading=1 AND pack_visible=1 AND pack_markedForDeletion=0", null, null);
        s = obj1;
        context = obj2;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = obj1;
        context = obj2;
        if (!as.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = PacksItemsColumns.CursorWrapper.create(as);
        s = obj1;
        context = s1;
        if (!as.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = PacksContentColumns.ContentCursorWrapper.create(as);
        context = s1;
        IOUtils.closeSilently(as);
        s1 = obj;
        if (context != null)
        {
            s1 = obj;
            if (s != null)
            {
                s1 = Pair.create(s, context);
            }
        }
        return s1;
        context;
        IOUtils.closeSilently(as);
        throw context;
    }

    static String getPackItemsContentPath(String s)
    {
        return (new StringBuilder()).append(getPackRootContent(s)).append("/pack_content").toString();
    }

    public static PackOption getPackOption(Context context, FeaturedColumns.CursorWrapper cursorwrapper)
    {
        if (context == null || cursorwrapper == null)
        {
            return PackOption.ERROR;
        }
        if (cursorwrapper.getPurchased() == 1)
        {
            if (cursorwrapper.getContentPath() == null)
            {
                Log.w("CdsUtils", "purchased but without content");
                return PackOption.RESTORE;
            }
            if ((new File(cursorwrapper.getContentPath())).isDirectory())
            {
                return PackOption.OWNED;
            } else
            {
                Log.d("CdsUtils", (new StringBuilder()).append(cursorwrapper.getIdentifier()).append(" owned but not correctly installed").toString());
                return PackOption.RESTORE;
            }
        }
        if (cursorwrapper.getFree() == 1)
        {
            return PackOption.FREE;
        }
        String s = getLegacyPackageName(cursorwrapper.getIdentifier());
        if (s != null && apkInstalled(context, s))
        {
            return PackOption.RESTORE;
        }
        if (isPackTypeUnlockedBySubscription(context, AviaryCds.PackType.fromString(cursorwrapper.getPackType())))
        {
            return PackOption.INSTALL;
        } else
        {
            return PackOption.PACK_OPTION_BEING_DETERMINED;
        }
    }

    public static PackOption getPackOption(Context context, PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        if (context == null || packcursorwrapper == null || packcursorwrapper.getContent() == null)
        {
            return PackOption.ERROR;
        }
        if (packcursorwrapper.getContent().getPurchased() == 1)
        {
            if (TextUtils.isEmpty(packcursorwrapper.getContent().getContentPath()))
            {
                Log.w("CdsUtils", "purchased but without content");
                return PackOption.RESTORE;
            }
            if ((new File(packcursorwrapper.getContent().getContentPath())).isDirectory())
            {
                return PackOption.OWNED;
            } else
            {
                Log.d("CdsUtils", (new StringBuilder()).append(packcursorwrapper.getIdentifier()).append(" owned but not correctly installed").toString());
                return PackOption.RESTORE;
            }
        }
        if (packcursorwrapper.getContent().getFree() == 1)
        {
            return PackOption.FREE;
        }
        String s = getLegacyPackageName(packcursorwrapper.getIdentifier());
        if (s != null && apkInstalled(context, s))
        {
            return PackOption.RESTORE;
        }
        if (isPackTypeUnlockedBySubscription(context, AviaryCds.PackType.fromString(packcursorwrapper.getPackType())))
        {
            return PackOption.INSTALL;
        } else
        {
            return PackOption.PACK_OPTION_BEING_DETERMINED;
        }
    }

    public static Pair getPackOptionDownloadStatus(Context context, long l)
    {
        if (context == null)
        {
            return null;
        }
        context = getPackDownloadStatus(context, l);
        if (context != null)
        {
            Log.d("CdsUtils", (new StringBuilder()).append("packId: ").append(l).append(", status: ").append(((Pair) (context)).first).append(", reason: ").append((String)((Pair) (context)).second).toString());
            switch (((Integer)((Pair) (context)).first).intValue())
            {
            default:
                return null;

            case 4: // '\004'
            case 16: // '\020'
                return new Pair(PackOption.DOWNLOAD_ERROR, ((Pair) (context)).second);

            case 1: // '\001'
            case 2: // '\002'
                return new Pair(PackOption.DOWNLOADING, ((Pair) (context)).second);

            case 8: // '\b'
                return new Pair(PackOption.DOWNLOAD_COMPLETE, ((Pair) (context)).second);
            }
        } else
        {
            return null;
        }
    }

    static String getPackPreviewPath(String s)
    {
        return (new StringBuilder()).append(getPackRootContent(s)).append("/previews").toString();
    }

    static String getPackRootContent(String s)
    {
        return (new StringBuilder()).append("cdsv2/").append(s).toString();
    }

    static Cursor getPacksList(Context context, String as[], String s, String as1[])
    {
        return context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, "pack/list"), as, s, as1, null);
    }

    public static List getPermissions(Context context)
    {
        context = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, "permissions/list"), new String[] {
            "perm_value"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        Object obj;
        context.moveToFirst();
        obj = context.getString(0);
        Log.d("CdsUtils", (new StringBuilder()).append("permissions: ").append(((String) (obj))).toString());
        obj = Collections.unmodifiableList(Arrays.asList(((String) (obj)).split(",")));
        IOUtils.closeSilently(context);
        return ((List) (obj));
        Object obj1;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        IOUtils.closeSilently(context);
        return Collections.unmodifiableList(new ArrayList());
        obj1;
        IOUtils.closeSilently(context);
        throw obj1;
    }

    static String getReasonText(int i, int j)
    {
        switch (i)
        {
        default:
            return null;

        case 4: // '\004'
            return getReasonTextPaused(j);

        case 16: // '\020'
            return getReasonTextFailed(j);
        }
    }

    static String getReasonTextFailed(int i)
    {
        switch (i)
        {
        case 1005: 
        default:
            return "Unknown error";

        case 1008: 
            return "Cannot resume download";

        case 1007: 
            return "SD card not mounted";

        case 1009: 
            return "File already exists";

        case 1004: 
            return "Failed to download file";

        case 1006: 
            return "SD card is full";
        }
    }

    static String getReasonTextPaused(int i)
    {
        switch (i)
        {
        default:
            return "Paused";

        case 3: // '\003'
            return "Paused, waiting for wifi";

        case 2: // '\002'
            return "Paused. Waiting for network";

        case 1: // '\001'
            return "Paused. Waiting to retry";
        }
    }

    public static String getResolution(Context context)
    {
        Log.i("CdsUtils", "getResolution");
        if (sResolution != null) goto _L2; else goto _L1
_L1:
        int i;
        i = context.getResources().getDisplayMetrics().densityDpi;
        Log.d("CdsUtils", (new StringBuilder()).append("density: ").append(i).toString());
        if (!SUPPORTED_DENSITIES.contains(Integer.valueOf(i))) goto _L4; else goto _L3
_L3:
        Log.d("CdsUtils", "resolution is supported!");
        sResolution = getResolutionString(i);
_L2:
        return sResolution;
_L4:
        if (i < ((Integer)SUPPORTED_DENSITIES.get(0)).intValue())
        {
            Log.d("CdsUtils", "resolution is too small");
            sResolution = getResolutionString(((Integer)SUPPORTED_DENSITIES.get(0)).intValue());
            continue; /* Loop/switch isn't completed */
        }
        if (i > ((Integer)SUPPORTED_DENSITIES.get(SUPPORTED_DENSITIES.size() - 1)).intValue())
        {
            Log.d("CdsUtils", "resolution is too big");
            sResolution = getResolutionString(((Integer)SUPPORTED_DENSITIES.get(SUPPORTED_DENSITIES.size() - 1)).intValue());
            continue; /* Loop/switch isn't completed */
        }
        context = SUPPORTED_DENSITIES.iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            int j = ((Integer)context.next()).intValue();
            if (j <= i)
            {
                continue;
            }
            Log.d("CdsUtils", (new StringBuilder()).append("use resolution: ").append(j).toString());
            sResolution = getResolutionString(j);
            break;
        } while (true);
        if (sResolution == null)
        {
            Log.d("CdsUtils", (new StringBuilder()).append("use a custom fallback resolution:  ").append(SUPPORTED_DENSITIES.get(SUPPORTED_DENSITIES.size() / 2)).toString());
            sResolution = getResolutionString(((Integer)SUPPORTED_DENSITIES.get(SUPPORTED_DENSITIES.size() / 2)).intValue());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static String getResolutionString(int i)
    {
        switch (i)
        {
        default:
            return "high";

        case 640: 
            return "xxxhigh";

        case 480: 
            return "xxhigh";

        case 320: 
            return "xhigh";

        case 240: 
            return "high";

        case 160: 
            return "medium";

        case 120: // 'x'
            return "low";
        }
    }

    public static boolean hasSubscriptionAvailable(Context context)
    {
        Log.i("CdsUtils", "hasSubscriptionAvailable");
        if (PackageManagerUtils.isStandalone(context)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Uri uri = PackageManagerUtils.getCDSProviderContentUri(context, "subscription/content/list");
        context = context.getContentResolver().query(uri, null, "subscription_visible=1 OR subscriptions_content_purchased=1", null, null);
        if (context == null) goto _L1; else goto _L3
_L3:
        int i;
        Log.d("CdsUtils", (new StringBuilder()).append("cursor.size: ").append(context.getCount()).toString());
        i = context.getCount();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IOUtils.closeSilently(context);
        return flag;
        Exception exception;
        exception;
        IOUtils.closeSilently(context);
        throw exception;
    }

    public static boolean isPackTypeUnlockedBySubscription(Context context, AviaryCds.PackType packtype)
    {
        Uri uri = PackageManagerUtils.getCDSProviderContentUri(context, "subscription/content/list");
        context = context.getContentResolver().query(uri, null, "subscriptions_content_purchased=1", null, null);
        if (context == null)
        {
            return false;
        }
_L2:
        Object obj;
        if (!context.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = SubscriptionsContentColumns.CursorWrapper.create(context);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag;
        if (((SubscriptionsContentColumns.CursorWrapper) (obj)).getPurchased() != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((SubscriptionsContentColumns.CursorWrapper) (obj)).getUnlockType();
        flag = "all".equals(obj);
        if (flag)
        {
            IOUtils.closeSilently(context);
            return true;
        }
        flag = ((String) (obj)).equals(packtype.toCdsString());
        if (flag)
        {
            IOUtils.closeSilently(context);
            return true;
        }
        if (true) goto _L2; else goto _L1
_L1:
        IOUtils.closeSilently(context);
        return false;
        packtype;
        IOUtils.closeSilently(context);
        throw packtype;
    }

    static void notifyDownloadComplete(Context context)
    {
        if (context != null)
        {
            Log.i("CdsUtils", "notifyServiceFinished");
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, "service/finished"), null);
        }
    }

    static void notifyDownloadMissingPacksCompleted(Context context, String s, int i)
    {
        if (context != null)
        {
            Log.i("CdsUtils", (new StringBuilder()).append("notifyDownloadMissingPacksCompleted, packType = ").append(s).append(", error: ").append(i).toString());
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("downloadMissingPacks/completed/").append(s).append("/").append(i).toString()), null);
            Intent intent = new Intent((new StringBuilder()).append(context.getPackageName()).append(".cds.downloadMissingPacksCompleted").toString());
            intent.putExtra("error", i);
            intent.putExtra("packType", s);
            context.sendBroadcast(intent);
        }
    }

    static void notifyDownloadStatusChange(Context context, long l, String s, int i)
    {
        JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, null, null, new Object[] {
            context, Conversions.longObject(l), s, Conversions.intObject(i)
        });
        AviaryCdsAspect.aspectOf().invokeDownloadStatusChange((new AjcClosure1(new Object[] {
            context, Conversions.longObject(l), s, Conversions.intObject(i), joinpoint
        })).linkClosureAndJoinPoint(0x10000));
    }

    static final void notifyDownloadStatusChange_aroundBody0(Context context, long l, String s, int i, JoinPoint joinpoint)
    {
        if (context != null)
        {
            Log.i("CdsUtils", (new StringBuilder()).append("notifyDownloadStatusChange, packId = ").append(l).toString());
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("download/statusChanged/").append(l).append("/").append(i).toString()), null);
            joinpoint = new Intent((new StringBuilder()).append(context.getPackageName()).append(".cds.downloadStatusChanged").toString());
            joinpoint.putExtra("packId", l);
            joinpoint.putExtra("status", i);
            joinpoint.putExtra("packType", s);
            context.sendBroadcast(joinpoint);
        }
    }

    static void notifyKill(Context context)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, "permissions/kill"), null);
        }
    }

    static void notifyMessageContentUpdate(Context context, long l)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("message/contentUpdated/").append(l).toString()), null);
        }
    }

    static void notifyMessagesContentUpdated(Context context, String s)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("messages/contentUpdated/").append(s).toString()), null);
        }
    }

    static void notifyPackContentUpdate(Context context, long l)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/contentUpdated/").append(l).toString()), null);
        }
    }

    static void notifyPackInstalled(Context context, long l, String s, int i)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/purchased/").append(l).append("/").append(i).toString()), null);
            Intent intent = new Intent((new StringBuilder()).append(context.getPackageName()).append(".cds.packInstalled").toString());
            intent.putExtra("packType", s);
            intent.putExtra("packId", l);
            intent.putExtra("purchased", i);
            context.sendBroadcast(intent);
        }
    }

    public static void notifyPackPurchased(Context context, long l, String s, Purchase purchase)
    {
        if (context != null)
        {
            Intent intent = new Intent((new StringBuilder()).append(context.getPackageName()).append(".cds.packPurchased").toString());
            intent.putExtra("packType", s);
            intent.putExtra("packId", l);
            intent.putExtra("purchase", purchase);
            context.sendBroadcast(intent);
        }
    }

    static void notifyPacksContentUpdated(Context context, String s)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("packs/contentUpdated/").append(s).toString()), null);
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("packTray/").append(s).toString()), null);
        }
    }

    static void notifyPermissionsUpdated(Context context)
    {
        if (context != null)
        {
            context.getContentResolver().notifyChange(PackageManagerUtils.getCDSProviderContentUri(context, "permissions/updated"), null);
        }
    }

    public static void printCursorAndReset(Cursor cursor)
    {
    }

    public static String requestPackDownload(Context context, long l, boolean flag)
        throws AssertionError, IOException
    {
        JoinPoint joinpoint = Factory.makeJP(ajc$tjp_1, null, null, new Object[] {
            context, Conversions.longObject(l), Conversions.booleanObject(flag)
        });
        return (String)AviaryCdsAspect.aspectOf().invokeRequestDownload((new AjcClosure3(new Object[] {
            context, Conversions.longObject(l), Conversions.booleanObject(flag), joinpoint
        })).linkClosureAndJoinPoint(0x10000));
    }

    static final String requestPackDownload_aroundBody2(Context context, long l, boolean flag, JoinPoint joinpoint)
    {
        String s;
        Cursor cursor;
        Log.i("CdsUtils", (new StringBuilder()).append("requestPackDownload: ").append(l).toString());
        Assert.assertNotNull("Invalid Context", context);
        s = null;
        joinpoint = null;
        cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), new String[] {
            "pack_id", "pack_identifier", "content_id", "content_contentURL"
        }, null, null, null);
        Assert.assertNotNull("Invalid Cursor", cursor);
        if (cursor.moveToFirst())
        {
            s = cursor.getString(cursor.getColumnIndex("pack_identifier"));
            joinpoint = cursor.getString(cursor.getColumnIndex("content_contentURL"));
        }
        IOUtils.closeSilently(cursor);
        Assert.assertNotNull("Failed to retrieve the pack identifier", s);
        Assert.assertNotNull("Failed to retrieve the pack download url", joinpoint);
        return AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.CONTENT).download(context, l, flag);
        context;
        IOUtils.closeSilently(cursor);
        throw context;
    }

    public static String toSQLArray(Collection collection)
    {
        StringBuilder stringbuilder = new StringBuilder();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            String s = (String)collection.next();
            stringbuilder.append("'").append(s).append("'");
            if (collection.hasNext())
            {
                stringbuilder.append(",");
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static boolean uninstallPack(Context context, long l)
    {
        Log.i("CdsUtils", (new StringBuilder()).append("uninstallPack: ").append(l).toString());
        if (context != null) goto _L2; else goto _L1
_L1:
        Log.w("CdsUtils", "context is null");
_L4:
        return false;
_L2:
        PacksColumns.PackCursorWrapper packcursorwrapper;
        long l1;
        packcursorwrapper = getPackFullInfoById(context, l);
        if (packcursorwrapper == null)
        {
            Log.w("CdsUtils", "pack is null!");
            return false;
        }
        Log.d("CdsUtils", (new StringBuilder()).append("pack: ").append(packcursorwrapper).toString());
        l1 = 0L;
        int i = context.getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/content/id/").append(packcursorwrapper.getContent().getId()).append("/updatePurchasedStatus/0").toString()), new ContentValues(), null, null);
        l1 = i;
_L5:
        Log.d("CdsUtils", (new StringBuilder()).append("result: ").append(l1).toString());
        if (l1 > 0L)
        {
            Object obj = getPackContentFolderPath(packcursorwrapper.getIdentifier());
            Log.i("CdsUtils", (new StringBuilder()).append("folder to remove: ").append(((String) (obj))).toString());
            if (obj != null)
            {
                obj = new File(context.getFilesDir(), ((String) (obj)));
                Log.i("CdsUtils", (new StringBuilder()).append("directory abs path: ").append(((File) (obj)).getAbsolutePath()).toString());
                Object obj1;
                try
                {
                    FileUtils.deleteDirectory(((File) (obj)));
                    Log.d("CdsUtils", "folder deleted");
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            }
            notifyPackContentUpdate(context, packcursorwrapper.getId());
            notifyPacksContentUpdated(context, packcursorwrapper.getPackType());
            notifyPackInstalled(context, l, packcursorwrapper.getPackType(), 0);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        ((SQLiteException) (obj1)).printStackTrace();
          goto _L5
        obj1;
        ((NullPointerException) (obj1)).printStackTrace();
          goto _L5
    }

    public static IabResult waitForIAPSetupDone(IAPInstance iapinstance)
    {
        return waitForIAPSetupDone(iapinstance, 2000L);
    }

    public static IabResult waitForIAPSetupDone(IAPInstance iapinstance, long l)
    {
        Object obj = new Object();
        com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener oniabsetupfinishedlistener = new com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener(obj) {

            final Object val$lock;

            public void onIabSetupFinished(IabResult iabresult)
            {
                Log.d("CdsUtils", (new StringBuilder()).append("IAPInstance::onIabSetupFinished: ").append(iabresult).toString());
                synchronized (lock)
                {
                    lock.notify();
                }
                return;
                exception1;
                iabresult;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                lock = obj;
                super();
            }
        };
        iapinstance;
        JVM INSTR monitorenter ;
        if (iapinstance.isSetupDone()) goto _L2; else goto _L1
_L1:
        iapinstance.startSetup(oniabsetupfinishedlistener);
        obj;
        JVM INSTR monitorenter ;
        Log.d("CdsUtils", "wait for done...");
        obj.wait(l);
_L3:
        obj;
        JVM INSTR monitorexit ;
_L2:
        iapinstance;
        JVM INSTR monitorexit ;
        return iapinstance.getResult();
        Object obj1;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        Exception exception;
        exception;
        iapinstance;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        ajc$preClinit();
        S_LEGACY_PACKS_MAP = new HashMap();
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.01", "com.aviary.android.feather.plugins.filters.grunge");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.02", "com.aviary.android.feather.plugins.filters.nostalgia");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.03", "com.aviary.android.feather.plugins.filters.camera");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.05", "com.aviary.android.feather.plugins.filters.tidal");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.06", "com.aviary.android.feather.plugins.filters.original");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.07", "com.aviary.android.feather.plugins.filters.toycamera");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.08", "com.aviary.android.feather.plugins.filters.love");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.32", "com.aviary.android.feather.plugins.filters.street");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.45", "com.aviary.android.feather.plugins.filters.woodland");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.68", "com.aviary.android.feather.plugins.filters.noir");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.77", "com.aviary.android.feather.plugins.filters.fireworks");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.80", "com.aviary.android.feather.plugins.filters.shadowpro");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.83", "com.aviary.android.feather.plugins.filters.astro");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.88", "com.aviary.android.feather.plugins.filters.wanderlust");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.95", "com.aviary.android.feather.plugins.filters.archetype");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.98", "com.aviary.android.feather.plugins.filters.sagapro");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.99", "com.aviary.android.feather.plugins.filters.gotham");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.104", "com.aviary.android.feather.plugins.filters.runway");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.109", "com.aviary.android.feather.plugins.filters.signetpro");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.116", "com.aviary.android.feather.plugins.filters.cam80s");
        S_LEGACY_PACKS_MAP.put("com.aviary.effectpack.117", "com.aviary.android.feather.plugins.filters.foodie");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.00", "com.aviary.android.feather.plugins.stickers.free_stickers");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.01", "com.aviary.android.feather.plugins.stickers.moustaches");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.02", "com.aviary.android.feather.plugins.stickers.animal");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.03", "com.aviary.android.feather.plugins.stickers.halloween");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.04", "com.aviary.android.feather.plugins.stickers.american_football");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.05", "com.aviary.android.feather.plugins.stickers.hats");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.07", "com.aviary.android.feather.plugins.stickers.helmets");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.08", "com.aviary.android.feather.plugins.stickers.holiday");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.09", "com.aviary.android.feather.plugins.stickers.space");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.10", "com.aviary.android.feather.plugins.stickers.galaxy");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.11", "com.aviary.android.feather.plugins.stickers.love");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.13", "com.aviary.android.feather.plugins.stickers.glasses");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.35", "com.aviary.android.feather.plugins.stickers.doodles");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.37", "com.aviary.android.feather.plugins.stickers.petdressup");
        S_LEGACY_PACKS_MAP.put("com.aviary.stickerpack.41", "com.aviary.android.feather.plugins.stickers.travel");
        S_LEGACY_PACKS_MAP.put("com.aviary.framepack.00", "com.aviary.android.feather.plugins.borders.free");
        S_LEGACY_PACKS_MAP.put("com.aviary.framepack.04", "com.aviary.android.feather.plugins.borders.drift");
        S_LEGACY_PACKS_MAP.put("com.aviary.framepack.05", "com.aviary.android.feather.plugins.borders.bloom");
        S_LEGACY_PACKS_MAP.put("com.aviary.framepack.06", "com.aviary.android.feather.plugins.borders.artdeco");
        S_LEGACY_PACKS_MAP.put("com.aviary.framepack.07", "com.aviary.android.feather.plugins.borders.rugged");
    }

    private class AjcClosure1 extends AroundClosure
    {

        public Object run(Object aobj[])
        {
            aobj = super.state;
            CdsUtils.notifyDownloadStatusChange_aroundBody0((Context)aobj[0], Conversions.longValue(aobj[1]), (String)aobj[2], Conversions.intValue(aobj[3]), (JoinPoint)aobj[4]);
            return null;
        }

        public AjcClosure1(Object aobj[])
        {
            super(aobj);
        }
    }


    private class AjcClosure3 extends AroundClosure
    {

        public Object run(Object aobj[])
        {
            aobj = super.state;
            return CdsUtils.requestPackDownload_aroundBody2((Context)aobj[0], Conversions.longValue(aobj[1]), Conversions.booleanValue(aobj[2]), (JoinPoint)aobj[3]);
        }

        public AjcClosure3(Object aobj[])
        {
            super(aobj);
        }
    }

}
