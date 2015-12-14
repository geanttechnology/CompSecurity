// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import it.sephiroth.android.library.disklrumulticache.DiskLruMultiCache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils, AviaryCdsValidatorFactory

public final class AviaryCdsDownloaderFactory
{
    static class ContentDownloader extends Downloader
    {

        private String createExternalDownloadDirectory()
            throws AssertionError
        {
            AviaryCdsDownloaderFactory.LOGGER.info("createDownloadDirectory");
            Assert.assertTrue("External storage is not available", getExternalStorageAvailable());
            String s;
            File file;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                s = Environment.DIRECTORY_DOWNLOADS;
            } else
            {
                s = "temp";
            }
            AviaryCdsDownloaderFactory.LOGGER.log("dst: %s", new Object[] {
                s
            });
            file = Environment.getExternalStoragePublicDirectory(s);
            if (file != null)
            {
                AviaryCdsDownloaderFactory.LOGGER.log("root: %s, isDirectory: %b", new Object[] {
                    file.getAbsolutePath(), Boolean.valueOf(file.isDirectory())
                });
                if (file.isDirectory())
                {
                    return file.getName();
                }
            }
            for (int i = 0; i < 10; i++)
            {
                AviaryCdsDownloaderFactory.LOGGER.log("i: %d, %s", new Object[] {
                    Integer.valueOf(i), (new StringBuilder()).append(s).append(i).toString()
                });
                File file1 = Environment.getExternalStoragePublicDirectory((new StringBuilder()).append(s).append(i).toString());
                if (file1 == null)
                {
                    continue;
                }
                if (!file1.exists())
                {
                    file1.mkdirs();
                }
                if (file1.exists() && file1.isDirectory())
                {
                    return file1.getName();
                }
            }

            return null;
        }

        private boolean getExternalStorageAvailable()
        {
            String s = Environment.getExternalStorageState();
            return "checking".equals(s) || "mounted".equals(s);
        }

        public String download(Context context, long l, boolean flag)
            throws AssertionError
        {
            Object obj;
            PacksColumns.PackCursorWrapper packcursorwrapper;
            Object obj5;
            Object obj6;
            Assert.assertNotNull("Invalid Context", context);
            obj = CdsUtils.getManifestVersion(context);
            Assert.assertNotNull("Failed to retrieve manifest", obj);
            obj5 = ((VersionColumns.VersionCursorWrapper) (obj)).getAssetsBaseURL();
            Assert.assertNotNull("Failed to retrieve baseUrl", obj5);
            packcursorwrapper = null;
            Object obj1 = null;
            obj = null;
            Object obj3 = null;
            obj6 = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), new String[] {
                "pack_id", "pack_identifier", "pack_type", "content_id", "content_packId", "content_contentURL", "content_displayName"
            }, null, null, null);
            if (obj6 == null)
            {
                break MISSING_BLOCK_LABEL_168;
            }
            obj = obj3;
            packcursorwrapper = obj1;
            if (((Cursor) (obj6)).moveToFirst())
            {
                packcursorwrapper = PacksColumns.PackCursorWrapper.create(((Cursor) (obj6)));
                obj = PacksContentColumns.ContentCursorWrapper.create(((Cursor) (obj6)));
            }
            IOUtils.closeSilently(((Cursor) (obj6)));
            Object obj2;
            Object obj4;
            DownloadManager downloadmanager;
            Cursor cursor;
            String s;
            Assert.assertNotNull("Invalid pack informations", packcursorwrapper);
            Assert.assertNotNull("Invalid pack's content informations", obj);
            Assert.assertNotNull("Invalid Context", obj);
            obj4 = ((PacksContentColumns.ContentCursorWrapper) (obj)).getContentURL();
            obj2 = obj4;
            if (!TextUtils.isEmpty(((CharSequence) (obj4))))
            {
                obj2 = obj4;
                if (!((String) (obj4)).startsWith("http://"))
                {
                    obj2 = obj4;
                    if (!((String) (obj4)).startsWith("https://"))
                    {
                        obj2 = (new StringBuilder()).append(((String) (obj5))).append(((String) (obj4))).toString();
                    }
                }
            }
            AviaryCdsDownloaderFactory.LOGGER.log("contentUrl: %s", new Object[] {
                obj2
            });
            s = packcursorwrapper.getIdentifier();
            cursor = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("packDownloadStatus/").append(l).toString()), new String[] {
                "download_refId"
            }, null, null, null);
            downloadmanager = (DownloadManager)context.getSystemService("download");
            obj5 = null;
            obj4 = null;
            obj6 = obj4;
            if (cursor == null) goto _L2; else goto _L1
_L1:
            obj6 = obj4;
            obj4 = obj5;
            if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
            obj4 = obj5;
            long l1 = cursor.getLong(cursor.getColumnIndex("download_refId"));
            obj4 = obj5;
            obj6 = new android.app.DownloadManager.Query();
            obj4 = obj5;
            ((android.app.DownloadManager.Query) (obj6)).setFilterById(new long[] {
                l1
            });
            obj4 = obj5;
            obj5 = downloadmanager.query(((android.app.DownloadManager.Query) (obj6)));
            if (obj5 == null) goto _L5; else goto _L4
_L4:
            obj4 = obj5;
            if (!((Cursor) (obj5)).moveToFirst()) goto _L5; else goto _L6
_L6:
            obj4 = obj5;
            int i = ((Cursor) (obj5)).getInt(((Cursor) (obj5)).getColumnIndex("status"));
            obj4 = obj5;
            int j = ((Cursor) (obj5)).getColumnIndex("uri");
            if (j <= -1) goto _L8; else goto _L7
_L7:
            obj4 = obj5;
            obj6 = ((Cursor) (obj5)).getString(j);
              goto _L9
_L18:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.warn("not handled");
_L5:
            obj4 = obj5;
            downloadmanager.remove(new long[] {
                l1
            });
            obj4 = obj5;
            i = context.getContentResolver().delete(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/").append(l).append("/delete_download_entry").toString()), null, null);
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.info((new StringBuilder()).append(i).append(" entries deleted in download_packs_table for packId ").append(l).toString());
            obj6 = obj5;
            if (i != 0) goto _L2; else goto _L10
_L10:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.error("failed to remove download entry");
            obj6 = obj5;
_L2:
            IOUtils.closeSilently(cursor);
            IOUtils.closeSilently(((Cursor) (obj6)));
            if (((PacksContentColumns.ContentCursorWrapper) (obj)).getDisplayName() != null)
            {
                obj = ((PacksContentColumns.ContentCursorWrapper) (obj)).getDisplayName();
            } else
            {
                obj = "Downloading";
            }
            obj2 = Uri.parse(((String) (obj2)));
            obj4 = new android.app.DownloadManager.Request(((Uri) (obj2)));
            if (((Uri) (obj2)).getLastPathSegment() == null)
            {
                obj2 = (new StringBuilder()).append(packcursorwrapper.getIdentifier()).append("-").append(System.currentTimeMillis()).append(".temp").toString();
            } else
            {
                obj2 = (new StringBuilder()).append(System.currentTimeMillis()).append("-").append(((Uri) (obj2)).getLastPathSegment()).toString();
            }
            obj5 = createExternalDownloadDirectory();
            AviaryCdsDownloaderFactory.LOGGER.log("downloadPath: %s", new Object[] {
                obj5
            });
            Assert.assertNotNull("Failed to create directory to download contents", obj5);
            ((android.app.DownloadManager.Request) (obj4)).setTitle(((CharSequence) (obj)));
            ((android.app.DownloadManager.Request) (obj4)).setDestinationInExternalPublicDir(((String) (obj5)), ((String) (obj2)));
            l1 = downloadmanager.enqueue(((android.app.DownloadManager.Request) (obj4)));
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("Download content, packId: ").append(l).append(" with downloadId: ").append(l1).toString());
            obj = new ContentValues();
            ((ContentValues) (obj)).put("download_packId", Long.valueOf(l));
            ((ContentValues) (obj)).put("download_refId", Long.valueOf(l1));
            obj = context.getContentResolver().insert(CdsUtils.getContentUri(context, "insertPacksDownloadTable"), ((ContentValues) (obj)));
            Assert.assertNotNull("Failed to insert data into the database", obj);
            if (context.getContentResolver().update(CdsUtils.getContentUri(context, (new StringBuilder()).append("download/id/").append(l1).append("/updateStatus/1").toString()), new ContentValues(), null, null) > 0 && flag)
            {
                CdsUtils.notifyDownloadStatusChange(context, l, packcursorwrapper.getPackType(), 1);
            }
            return ((Uri) (obj)).toString();
            context;
            IOUtils.closeSilently(((Cursor) (obj6)));
            throw context;
_L8:
            obj6 = null;
              goto _L9
_L13:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.warn((new StringBuilder()).append("The download for ").append(s).append(" has already started with downloadId ").append(l1).toString());
            IOUtils.closeSilently(cursor);
            IOUtils.closeSilently(((Cursor) (obj5)));
            return ((String) (obj6));
_L16:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.warn("Download failed, trying again");
              goto _L5
            context;
            IOUtils.closeSilently(cursor);
            IOUtils.closeSilently(((Cursor) (obj4)));
            throw context;
_L12:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.log("Download is pending");
              goto _L5
_L14:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.log("Download is paused");
              goto _L5
_L15:
            obj4 = obj5;
            AviaryCdsDownloaderFactory.LOGGER.log("Download was successful, but restarting");
              goto _L5
_L9:
            i;
            JVM INSTR lookupswitch 5: default 1236
        //                       1: 1085
        //                       2: 997
        //                       4: 1103
        //                       8: 1121
        //                       16: 1054;
               goto _L11 _L12 _L13 _L14 _L15 _L16
_L11:
            if (true) goto _L18; else goto _L17
_L17:
        }

        ContentDownloader()
        {
        }
    }

    static class DetailImageDownloader extends Downloader
    {

        public String download(Context context, long l, boolean flag)
            throws IOException, AssertionError
        {
            Object obj;
            Object obj1;
            String s1;
            Cursor cursor;
            Assert.assertNotNull("null context", context);
            obj = CdsUtils.getManifestVersion(context);
            Assert.assertNotNull("null manifest", obj);
            s1 = ((VersionColumns.VersionCursorWrapper) (obj)).getAssetsBaseURL();
            Assert.assertNotNull("null baseUrl", s1);
            obj1 = null;
            Object obj2 = null;
            obj = null;
            Object obj5 = null;
            cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), new String[] {
                "pack_id", "pack_identifier", "content_id", "content_packId", getRemoteUrlColumnName(), getLocalPathColumnName()
            }, null, null, null);
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_166;
            }
            obj = obj5;
            obj1 = obj2;
            if (cursor.moveToFirst())
            {
                obj1 = PacksColumns.PackCursorWrapper.create(cursor);
                obj = PacksContentColumns.ContentCursorWrapper.create(cursor);
            }
            IOUtils.closeSilently(cursor);
            String s;
            Assert.assertNotNull("null pack", obj1);
            Assert.assertNotNull("null content", obj);
            s = getRemotePath(((PacksContentColumns.ContentCursorWrapper) (obj)));
            Object obj3 = getLocalPath(((PacksContentColumns.ContentCursorWrapper) (obj)));
            if (!TextUtils.isEmpty(((CharSequence) (obj3))))
            {
                obj3 = new File(((String) (obj3)));
                AviaryCdsDownloaderFactory.LOGGER.log("localPath exists: %b", new Object[] {
                    Boolean.valueOf(((File) (obj3)).exists())
                });
                if (((File) (obj3)).exists())
                {
                    return ((File) (obj3)).getAbsolutePath();
                }
            }
            break MISSING_BLOCK_LABEL_262;
            context;
            IOUtils.closeSilently(cursor);
            throw context;
            Object obj4 = s;
            if (!TextUtils.isEmpty(s))
            {
                obj4 = s;
                if (!s.startsWith("http://"))
                {
                    obj4 = s;
                    if (!s.startsWith("https://"))
                    {
                        obj4 = s;
                        if (!s.startsWith("file://"))
                        {
                            obj4 = (new StringBuilder()).append(s1).append(s).toString();
                        }
                    }
                }
            }
            AviaryCdsDownloaderFactory.LOGGER.log("remotePath: %s", new Object[] {
                obj4
            });
            obj1 = ((PacksColumns.PackCursorWrapper) (obj1)).getIdentifier();
            long l1 = ((PacksContentColumns.ContentCursorWrapper) (obj)).getId();
            obj = AviaryCdsDownloaderFactory.getCacheDir(context, getCacheDirName());
            Assert.assertNotNull("destination directory is null", obj);
            obj = new File(((File) (obj)), (new StringBuilder()).append(((String) (obj1))).append(".jpg").toString());
            obj1 = IOUtils.hunt(context, ((String) (obj4)));
            obj4 = new FileOutputStream(((File) (obj)));
            org.apache.commons.io.IOUtils.copy(((java.io.InputStream) (obj1)), ((java.io.OutputStream) (obj4)));
            IOUtils.closeSilently(((java.io.Closeable) (obj1)));
            IOUtils.closeSilently(((java.io.Closeable) (obj4)));
            obj1 = new ContentValues();
            ((ContentValues) (obj1)).put(getLocalPathColumnName(), ((File) (obj)).getAbsolutePath());
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("updating: ").append(l).append(", ").append(l1).toString());
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("destFile: ").append(((File) (obj)).getAbsolutePath()).toString());
            boolean flag1;
            if (context.getContentResolver().update(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content/id/").append(l1).append("/update").toString()), ((ContentValues) (obj1)), null, null) > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assert.assertTrue("failed to update the provider", flag1);
            if (flag)
            {
                CdsUtils.notifyPackContentUpdate(context, l);
            }
            return ((File) (obj)).getAbsolutePath();
        }

        protected String getCacheDirName()
        {
            return "aviary-cds-detail-image-cache";
        }

        protected String getLocalPath(PacksContentColumns.ContentCursorWrapper contentcursorwrapper)
        {
            return contentcursorwrapper.getDetailImageLocalPath();
        }

        protected String getLocalPathColumnName()
        {
            return "content_detailImageLocalPath";
        }

        protected String getRemotePath(PacksContentColumns.ContentCursorWrapper contentcursorwrapper)
        {
            return contentcursorwrapper.getDetailImageURL();
        }

        protected String getRemoteUrlColumnName()
        {
            return "content_detailImageURL";
        }

        DetailImageDownloader()
        {
        }
    }

    public static abstract class Downloader
    {

        public final String download(Context context, long l)
            throws IOException, AssertionError
        {
            return download(context, l, true);
        }

        public abstract String download(Context context, long l, boolean flag)
            throws IOException, AssertionError;

        public Downloader()
        {
        }
    }

    static class FeatureImageDownloader extends DetailImageDownloader
    {

        protected String getCacheDirName()
        {
            return "aviary-cds-featured-image-cache";
        }

        protected String getLocalPath(PacksContentColumns.ContentCursorWrapper contentcursorwrapper)
        {
            return contentcursorwrapper.getFeatureImageLocalPath();
        }

        protected String getLocalPathColumnName()
        {
            return "content_featureImageLocalPath";
        }

        protected String getRemotePath(PacksContentColumns.ContentCursorWrapper contentcursorwrapper)
        {
            return contentcursorwrapper.getFeatureImageURL();
        }

        protected String getRemoteUrlColumnName()
        {
            return "content_featureImageURL";
        }

        FeatureImageDownloader()
        {
        }
    }

    static class MessageDownloader extends Downloader
    {

        public String download(Context context, long l, boolean flag)
            throws IOException, AssertionError
        {
            Object obj;
            MessageContentColumn.MessageContentCursorWrapper messagecontentcursorwrapper;
            Object obj5;
            Cursor cursor;
            Assert.assertNotNull("null context", context);
            obj = CdsUtils.getManifestVersion(context);
            Assert.assertNotNull("null manifest", obj);
            obj5 = ((VersionColumns.VersionCursorWrapper) (obj)).getAssetsBaseURL();
            Assert.assertNotNull("null baseUrl", obj5);
            obj = null;
            Object obj3 = null;
            messagecontentcursorwrapper = null;
            Object obj1 = null;
            cursor = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("message/id/").append(l).append("/content").toString()), new String[] {
                "msg_id", "msg_identifier", "msg_type", "msgcnt_id", "msgcnt_messageId", "msgcnt_contentURL"
            }, null, null, null);
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_162;
            }
            obj = obj3;
            messagecontentcursorwrapper = obj1;
            if (cursor.moveToFirst())
            {
                obj = MessageColumns.MessageCursorWrapper.create(cursor);
                messagecontentcursorwrapper = MessageContentColumn.MessageContentCursorWrapper.create(cursor);
            }
            IOUtils.closeSilently(cursor);
            Assert.assertNotNull("message is null", obj);
            Assert.assertNotNull("messageContent is null", messagecontentcursorwrapper);
            Object obj4 = messagecontentcursorwrapper.getContentURL();
            Object obj2 = obj4;
            if (!TextUtils.isEmpty(((CharSequence) (obj4))))
            {
                obj2 = obj4;
                if (!((String) (obj4)).startsWith("http://"))
                {
                    obj2 = obj4;
                    if (!((String) (obj4)).startsWith("https://"))
                    {
                        obj2 = (new StringBuilder()).append(((String) (obj5))).append(((String) (obj4))).toString();
                    }
                }
            }
            AviaryCdsDownloaderFactory.LOGGER.log("messageUrl: %s", new Object[] {
                obj2
            });
            obj4 = ((MessageColumns.MessageCursorWrapper) (obj)).getIdentifier();
            obj5 = AviaryCdsDownloaderFactory.getCacheDir(context, getCacheDirName());
            Assert.assertNotNull("destination directory is null", obj5);
            ((File) (obj5)).setReadable(true, false);
            obj4 = new File(((File) (obj5)), (new StringBuilder()).append(((String) (obj4))).append(".jpg").toString());
            obj2 = IOUtils.download(((String) (obj2)), null);
            obj5 = new FileOutputStream(((File) (obj4)));
            IOUtils.copyFile(((java.io.InputStream) (obj2)), ((java.io.OutputStream) (obj5)));
            IOUtils.closeSilently(((java.io.Closeable) (obj2)));
            IOUtils.closeSilently(((java.io.Closeable) (obj5)));
            obj2 = new ContentValues();
            ((ContentValues) (obj2)).put("msgcnt_contentPath", ((File) (obj4)).getAbsolutePath());
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("updating: ").append(((MessageColumns.MessageCursorWrapper) (obj)).getId()).append(", ").append(messagecontentcursorwrapper.getId()).toString());
            boolean flag1;
            if (context.getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("message/id/").append(((MessageColumns.MessageCursorWrapper) (obj)).getId()).append("/content/id/").append(messagecontentcursorwrapper.getId()).append("/update").toString()), ((ContentValues) (obj2)), null, null) > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assert.assertTrue("failed to update the provider", flag1);
            if (flag)
            {
                CdsUtils.notifyMessageContentUpdate(context, l);
            }
            return ((File) (obj4)).getAbsolutePath();
            context;
            IOUtils.closeSilently(cursor);
            throw context;
        }

        protected String getCacheDirName()
        {
            return "aviary-cds-message-image-cache";
        }

        MessageDownloader()
        {
        }
    }

    static class PreviewDownloader extends Downloader
    {

        public String download(Context context, long l, boolean flag)
            throws IOException, AssertionError
        {
            Object obj;
            Object obj1;
            String s1;
            Cursor cursor;
            Assert.assertNotNull("null context", context);
            obj = CdsUtils.getManifestVersion(context);
            Assert.assertNotNull("null manifest", obj);
            s1 = ((VersionColumns.VersionCursorWrapper) (obj)).getAssetsBaseURL();
            Assert.assertNotNull("null baseUrl", s1);
            obj1 = null;
            Object obj2 = null;
            obj = null;
            Object obj4 = null;
            cursor = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content").toString()), new String[] {
                "pack_id", "pack_identifier", "pack_type", "content_id", "content_packId", "content_previewURL"
            }, null, null, null);
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_162;
            }
            obj = obj4;
            obj1 = obj2;
            if (cursor.moveToFirst())
            {
                obj1 = PacksColumns.PackCursorWrapper.create(cursor);
                obj = PacksContentColumns.ContentCursorWrapper.create(cursor);
            }
            IOUtils.closeSilently(cursor);
            Assert.assertNotNull("null pack", obj1);
            Assert.assertNotNull("null context", obj);
            String s = ((PacksContentColumns.ContentCursorWrapper) (obj)).getPreviewURL();
            Object obj3 = s;
            if (!TextUtils.isEmpty(s))
            {
                obj3 = s;
                if (!s.startsWith("http://"))
                {
                    obj3 = s;
                    if (!s.startsWith("https://"))
                    {
                        obj3 = s;
                        if (!s.startsWith("file://"))
                        {
                            obj3 = (new StringBuilder()).append(s1).append(s).toString();
                        }
                    }
                }
            }
            AviaryCdsDownloaderFactory.LOGGER.log("previewUrl: %s", new Object[] {
                obj3
            });
            s = ((PacksColumns.PackCursorWrapper) (obj1)).getIdentifier();
            obj1 = ((PacksColumns.PackCursorWrapper) (obj1)).getPackType();
            long l1 = ((PacksContentColumns.ContentCursorWrapper) (obj)).getId();
            obj3 = IOUtils.hunt(context, ((String) (obj3)));
            obj = AviaryCdsDownloaderFactory.getCacheDir(context, getCacheDirName());
            Assert.assertNotNull("destination directory is null", obj);
            ((File) (obj)).setReadable(true, false);
            AviaryCdsDownloaderFactory.LOGGER.log("destDir: %s", new Object[] {
                ((File) (obj)).getAbsolutePath()
            });
            obj = new File(((File) (obj)), s);
            ((File) (obj)).mkdirs();
            IOUtils.createNoMediaFile(((File) (obj)));
            Assert.assertTrue((new StringBuilder()).append("failed to create dest folder: ").append(s).toString(), ((File) (obj)).exists());
            ((File) (obj)).setReadable(true, false);
            IOUtils.unzip(((java.io.InputStream) (obj3)), ((File) (obj)));
            IOUtils.closeSilently(((java.io.Closeable) (obj3)));
            obj1 = AviaryCds.PackType.valueOf(((String) (obj1)).toUpperCase(Locale.US));
            Assert.assertTrue("invalid preview content", AviaryCdsValidatorFactory.create(AviaryCds.ContentType.PREVIEW, ((AviaryCds.PackType) (obj1))).validate(context, l, ((File) (obj)), false));
            obj1 = new ContentValues();
            ((ContentValues) (obj1)).put("content_previewPath", ((File) (obj)).getAbsolutePath());
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("updating: ").append(l).append(", ").append(l1).toString());
            AviaryCdsDownloaderFactory.LOGGER.log((new StringBuilder()).append("destFolder: ").append(((File) (obj)).getAbsolutePath()).toString());
            boolean flag1;
            if (context.getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/content/id/").append(l1).append("/update").toString()), ((ContentValues) (obj1)), null, null) > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assert.assertTrue("failed to update the provider", flag1);
            if (flag)
            {
                CdsUtils.notifyPackContentUpdate(context, l);
            }
            return ((File) (obj)).getAbsolutePath();
            context;
            IOUtils.closeSilently(cursor);
            throw context;
        }

        protected String getCacheDirName()
        {
            return "aviary-cds-preview-image-cache";
        }

        PreviewDownloader()
        {
        }
    }


    static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER;

    private AviaryCdsDownloaderFactory()
    {
    }

    public static Downloader create(AviaryCds.ContentType contenttype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType = new int[AviaryCds.ContentType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.PREVIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.CONTENT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.MESSAGE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.DETAIL_IMAGE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$ContentType[AviaryCds.ContentType.FEATURED_IMAGE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.ContentType[contenttype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new PreviewDownloader();

        case 2: // '\002'
            return new ContentDownloader();

        case 3: // '\003'
            return new MessageDownloader();

        case 4: // '\004'
            return new DetailImageDownloader();

        case 5: // '\005'
            return new FeatureImageDownloader();
        }
    }

    static File getCacheDir(Context context, String s)
    {
        context = DiskLruMultiCache.getCacheDir(context, s);
        if (context != null)
        {
            if (context.exists())
            {
                IOUtils.createNoMediaFile(context);
                return context;
            }
            if (context.mkdirs())
            {
                IOUtils.createNoMediaFile(context);
                return context;
            }
        }
        return null;
    }

    static 
    {
        LOGGER = LoggerFactory.getLogger(com/aviary/android/feather/cds/AviaryCdsDownloaderFactory.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
