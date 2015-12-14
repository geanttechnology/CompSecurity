// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ConnectionUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.SystemUtils;
import com.aviary.android.feather.common.utils.os.AviaryIntentService;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory, AviaryCdsValidatorFactory

public class AviaryCdsAssetsDownloaderService extends AviaryIntentService
{

    private static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER = LoggerFactory.getLogger("AviaryCdsAssetsDownloaderService");
    private static final long SLEEP_TIME = 5L;

    public AviaryCdsAssetsDownloaderService()
    {
        super("AviaryCdsAssetsDownloaderService");
    }

    private void downloadExtraAssets(boolean flag, int i)
        throws IOException
    {
        LOGGER.info("downloadExtraAssets(wifiOnly:%b, maxItems:%d)", new Object[] {
            Boolean.valueOf(flag), Integer.valueOf(i)
        });
        if (flag)
        {
            throwIfNotConnected(getBaseContext());
        }
        processDetails(flag, i);
        if (flag)
        {
            throwIfNotConnected(getBaseContext());
        }
        processFutureMessages(flag);
        if (flag)
        {
            throwIfNotConnected(getBaseContext());
        }
        processFeaturedItems(flag, i);
        if (flag)
        {
            throwIfNotConnected(getBaseContext());
        }
        processPreviews(flag, i);
    }

    static boolean isConnected(Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (ConnectionUtils.isConnected(context, false, new int[] {
    1, 6
}))
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean processDetail(Context context, long l, String s, boolean flag)
        throws IOException
    {
        if (context == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        if (flag)
        {
            throwIfNotConnected(context);
        }
        if (!TextUtils.isEmpty(s) && (new File(s)).exists())
        {
            LOGGER.verbose("detail image for packid %d already downloaded..", new Object[] {
                Long.valueOf(l)
            });
            return false;
        }
        LOGGER.verbose("download detail image for pack %d", new Object[] {
            Long.valueOf(l)
        });
        try
        {
            AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.DETAIL_IMAGE).download(context, l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    private void processDetails(boolean flag, int i)
        throws IOException, IllegalStateException
    {
        AviaryCds.PackType apacktype[];
        int j;
        int i1;
        LOGGER.log("processDetails(wifiOnly:%b, maxItems:%d)", new Object[] {
            Boolean.valueOf(flag), Integer.valueOf(i)
        });
        if (getBaseContext() == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        apacktype = AviaryCds.PackType.values();
        i1 = apacktype.length;
        j = 0;
_L3:
        Object obj;
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        obj = apacktype[j];
        LOGGER.verbose("processing %s", new Object[] {
            obj
        });
        obj = ((AviaryCds.PackType) (obj)).toCdsString();
        obj = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "pack/content/list"), new String[] {
            "content_packId", "content_detailImageLocalPath"
        }, "pack_type=? AND content_purchased=? AND pack_visible=? AND pack_markedForDeletion=? AND ifnull(length(content_featureImageURL), 0) > 0", new String[] {
            obj, "0", "1", "0"
        }, "content_purchased ASC, pack_displayOrder ASC");
        if (obj == null)
        {
            throw new IllegalStateException("Cursor is null");
        }
        LOGGER.verbose("cursor.size: %d", new Object[] {
            Integer.valueOf(((Cursor) (obj)).getCount())
        });
        int k = 0;
_L1:
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (i <= -1 || k < i)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        LOGGER.verbose("Processed %d items. Stop", new Object[] {
            Integer.valueOf(k)
        });
        IOUtils.closeSilently(((Cursor) (obj)));
        j++;
        continue; /* Loop/switch isn't completed */
        String s;
        long l1;
        l1 = ((Cursor) (obj)).getLong(0);
        s = ((Cursor) (obj)).getString(1);
        int l = k;
        if (processDetail(getBaseContext(), l1, s, flag))
        {
            l = k + 1;
        }
        SystemUtils.trySleep(5L);
        k = l;
          goto _L1
        Exception exception;
        exception;
        IOUtils.closeSilently(((Cursor) (obj)));
        throw exception;
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private boolean processFeaturedItem(Context context, Cursor cursor, boolean flag)
        throws IllegalStateException, IOException
    {
        if (context == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        if (flag)
        {
            throwIfNotConnected(context);
        }
        cursor = FeaturedColumns.CursorWrapper.create(cursor);
        if (cursor == null)
        {
            throw new IllegalStateException("feailed to create wrapper");
        }
        if (!TextUtils.isEmpty(cursor.getFeatureImageLocalPath()) && (new File(cursor.getFeatureImageLocalPath())).exists())
        {
            LOGGER.verbose("featured image already downloaded..", new Object[0]);
            return false;
        }
        LOGGER.verbose("download featured image for pack %d", new Object[] {
            Long.valueOf(cursor.getId())
        });
        try
        {
            AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.FEATURED_IMAGE).download(context, cursor.getId());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    private void processFeaturedItems(boolean flag, int i)
        throws IOException
    {
        Object obj;
        LOGGER.log("processFeaturedItems(wifiOnly:%b, maxItems:%d)", new Object[] {
            Boolean.valueOf(flag), Integer.valueOf(i)
        });
        if (getBaseContext() == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        obj = (new StringBuilder()).append("storeFeatured/banners/");
        int j;
        if (i < 0)
        {
            j = 3;
        } else
        {
            j = i;
        }
        obj = ((StringBuilder) (obj)).append(j).toString();
        obj = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), ((String) (obj))), null, null, null, null);
        if (obj == null)
        {
            throw new IllegalStateException("Cursor is null");
        }
        LOGGER.verbose("cursor.size: %d", new Object[] {
            Integer.valueOf(((Cursor) (obj)).getCount())
        });
        int k = 0;
_L1:
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (i <= 0 || k < i)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        LOGGER.verbose("Processed %d items. Stop", new Object[] {
            Integer.valueOf(k)
        });
        IOUtils.closeSilently(((Cursor) (obj)));
        return;
        int l = k;
        if (processFeaturedItem(getBaseContext(), ((Cursor) (obj)), flag))
        {
            l = k + 1;
        }
        SystemUtils.trySleep(5L);
        k = l;
          goto _L1
        Exception exception;
        exception;
        IOUtils.closeSilently(((Cursor) (obj)));
        throw exception;
        IOUtils.closeSilently(((Cursor) (obj)));
        return;
    }

    private boolean processFutureMessage(Context context, MessageContentColumn.MessageContentCursorWrapper messagecontentcursorwrapper, boolean flag)
        throws IOException, IllegalStateException
    {
        if (context == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        if (flag)
        {
            throwIfNotConnected(context);
        }
        String s = messagecontentcursorwrapper.getContentPath();
        if (!TextUtils.isEmpty(s))
        {
            if ((new File(s)).exists())
            {
                LOGGER.verbose("file exists. Skipping..", new Object[0]);
                return false;
            }
            LOGGER.verbose("file doesn't exist!", new Object[0]);
        }
        LOGGER.verbose("processing: %s", new Object[] {
            messagecontentcursorwrapper.getContentIdentifier()
        });
        LOGGER.verbose("beginDate: %s, endDate: %s", new Object[] {
            messagecontentcursorwrapper.getBeginDate(), messagecontentcursorwrapper.getEndDate()
        });
        AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.MESSAGE).download(context, messagecontentcursorwrapper.getMessageId());
        return true;
    }

    private void processFutureMessages(boolean flag)
        throws IOException, IllegalStateException
    {
        Cursor cursor;
        int i;
        LOGGER.log("processFutureMessages(wifiOnly:%b)", new Object[] {
            Boolean.valueOf(flag)
        });
        if (getBaseContext() == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        cursor = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("message/future/").append(AviaryCds.MessageType.LAUNCH.toString().toLowerCase(Locale.US)).toString()), null, null, null, null);
        if (cursor == null)
        {
            throw new IllegalStateException("Cursor is null");
        }
        i = 1;
        LOGGER.verbose("cursor.size: %d", new Object[] {
            Integer.valueOf(cursor.getCount())
        });
_L2:
        MessageContentColumn.MessageContentCursorWrapper messagecontentcursorwrapper;
        do
        {
            if (!cursor.moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            messagecontentcursorwrapper = MessageContentColumn.MessageContentCursorWrapper.create(cursor);
        } while (messagecontentcursorwrapper == null);
        processFutureMessage(getBaseContext(), messagecontentcursorwrapper, flag);
        int j;
        j = i - 1;
        i = j;
        if (j > 0) goto _L2; else goto _L1
_L1:
        IOUtils.closeSilently(cursor);
        return;
        Exception exception;
        exception;
        IOUtils.closeSilently(cursor);
        throw exception;
    }

    private boolean processPreview(Context context, long l, long l1, String s, String s1, 
            boolean flag)
        throws IOException
    {
        if (context == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        if (flag)
        {
            throwIfNotConnected(context);
        }
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s = new File(s);
        if (!s.isDirectory())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s1 = AviaryCds.PackType.fromString(s1);
        s1 = AviaryCdsValidatorFactory.create(AviaryCds.ContentType.PREVIEW, s1);
        if (!s1.validate(context, l1, s, false))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        LOGGER.verbose("detail image for packid %d already downloaded..", new Object[] {
            Long.valueOf(l)
        });
        return false;
        s;
        LOGGER.warn("need to download again previews for packId %d", new Object[] {
            Long.valueOf(l)
        });
        LOGGER.verbose("download detail image for pack %d", new Object[] {
            Long.valueOf(l)
        });
        try
        {
            AviaryCdsDownloaderFactory.create(AviaryCds.ContentType.PREVIEW).download(context, l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    private void processPreviews(boolean flag, int i)
        throws IOException, IllegalStateException
    {
        AviaryCds.PackType apacktype[];
        int j;
        int i1;
        LOGGER.log("processPreviews(wifiOnly:%b, maxItems:%d)", new Object[] {
            Boolean.valueOf(flag), Integer.valueOf(i)
        });
        if (getBaseContext() == null)
        {
            throw new IllegalStateException("Invalid Context");
        }
        apacktype = AviaryCds.PackType.values();
        i1 = apacktype.length;
        j = 0;
_L3:
        Object obj;
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        obj = apacktype[j];
        LOGGER.verbose("processing %s", new Object[] {
            obj
        });
        obj = ((AviaryCds.PackType) (obj)).toCdsString();
        obj = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "pack/content/list"), new String[] {
            "content_packId", "content_previewPath", "pack_type", "content_id"
        }, "pack_type=? AND content_purchased=? AND pack_visible=? AND pack_markedForDeletion=? AND ifnull(length(content_previewURL), 0) > 0", new String[] {
            obj, "0", "1", "0"
        }, "content_purchased ASC, pack_displayOrder ASC");
        if (obj == null)
        {
            throw new IllegalStateException("Cursor is null");
        }
        LOGGER.verbose("cursor.size: %d", new Object[] {
            Integer.valueOf(((Cursor) (obj)).getCount())
        });
        int k = 0;
_L1:
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_257;
        }
        if (i <= 0 || k < i)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        LOGGER.verbose("Processed %d items. Stop", new Object[] {
            Integer.valueOf(k)
        });
        IOUtils.closeSilently(((Cursor) (obj)));
        j++;
        continue; /* Loop/switch isn't completed */
        String s;
        String s1;
        long l1;
        long l2;
        l1 = ((Cursor) (obj)).getLong(0);
        s = ((Cursor) (obj)).getString(1);
        s1 = ((Cursor) (obj)).getString(2);
        l2 = ((Cursor) (obj)).getLong(3);
        int l = k;
        if (processPreview(getBaseContext(), l1, l2, s, s1, flag))
        {
            l = k + 1;
        }
        SystemUtils.trySleep(5L);
        k = l;
          goto _L1
        Exception exception;
        exception;
        IOUtils.closeSilently(((Cursor) (obj)));
        throw exception;
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void throwIfNotConnected(Context context)
        throws IOException
    {
        if (!isConnected(context))
        {
            throw new IOException("NotConnected");
        } else
        {
            return;
        }
    }

    public void onCreate()
    {
        LOGGER.info("onCreate");
        super.onCreate();
    }

    public void onDestroy()
    {
        LOGGER.info("onDestroy");
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            String s = intent.getAction();
            LOGGER.info("handleIntent: action=%s", new Object[] {
                s
            });
            boolean flag = intent.getBooleanExtra("EXTRA_EXECUTE_WIFI_ONLY", true);
            int i = intent.getIntExtra("EXTRA_MAX_ITEMS", -1);
            if ("aviary.intent.action.CDS_DOWNLOAD_EXTRA_ASSETS".equals(s))
            {
                try
                {
                    downloadExtraAssets(flag, i);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    intent.printStackTrace();
                }
                return;
            }
        }
    }

}
