// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.aviary.android.feather.cds.json.CdsContentParser;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils, CdsDatabaseHelper

public final class PackInstaller
{

    private static final String LOG_TAG = "PackInstaller";

    private PackInstaller()
    {
    }

    private static int extractContent(Context context, SQLiteDatabase sqlitedatabase, File file, String s, long l, String s1)
        throws AssertionError, android.content.res.Resources.NotFoundException, IOException
    {
        boolean flag;
        boolean flag1 = true;
        Log.i("PackInstaller", (new StringBuilder()).append("extractContent: ").append(s).append(", packId: ").append(l).append(", packType: ").append(s1).toString());
        Assert.assertNotNull(file);
        Assert.assertNotNull(s);
        Assert.assertNotNull(context);
        Assert.assertNotNull(s1);
        Assert.assertNotNull(sqlitedatabase);
        Assert.assertTrue(file.exists());
        int i;
        if (l > -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        s = new File((new StringBuilder()).append(context.getFilesDir()).append("/").append(CdsUtils.getPackItemsContentPath(s)).toString());
        s.mkdirs();
        if (s.exists() && s.isDirectory())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("failed to create output dir", flag);
        s.setReadable(true, false);
        file = new FileInputStream(file);
        IOUtils.unzip(file, s);
        IOUtils.closeSilently(file);
        i = updateContentPath(context, sqlitedatabase, l, s.getAbsolutePath());
        Log.d("PackInstaller", (new StringBuilder()).append("updateContentPath result: ").append(i).toString());
        if (i > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        return i;
        context;
        IOUtils.closeSilently(file);
        throw context;
    }

    private static int extractIcon(Context context, SQLiteDatabase sqlitedatabase, File file, String s, long l)
        throws IOException, AssertionError, android.content.res.Resources.NotFoundException
    {
        Log.i("PackInstaller", (new StringBuilder()).append("extractIcon: ").append(s).append(", packId: ").append(l).toString());
        Assert.assertNotNull(file);
        Assert.assertNotNull(s);
        Assert.assertNotNull(context);
        Assert.assertNotNull(sqlitedatabase);
        Assert.assertTrue(file.exists());
        boolean flag;
        if (l > -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        Log.d("PackInstaller", (new StringBuilder()).append("icon filename: ").append(file.getName()).toString());
        context = (new StringBuilder()).append(context.getFilesDir()).append("/").append(CdsUtils.getPackIconPath(s)).toString();
        Log.d("PackInstaller", (new StringBuilder()).append("dest folder: ").append(context).toString());
        s = new File(context);
        s.mkdirs();
        Assert.assertTrue(s.isDirectory());
        context = new File((new StringBuilder()).append(context).append("/").append(file.getName()).toString());
        Log.d("PackInstaller", (new StringBuilder()).append("iconDestFile: ").append(context.getAbsolutePath()).toString());
        IOUtils.copyFile(file, context);
        Assert.assertTrue(context.exists());
        return updateIconPath(sqlitedatabase, l, context.getAbsolutePath(), 0);
    }

    private static long insertNewPackContentAndItems(Context context, SQLiteDatabase sqlitedatabase, ContentValues acontentvalues[])
    {
        long l;
        long l1;
        Assert.assertNotNull(acontentvalues);
        boolean flag;
        if (acontentvalues.length > 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        Log.d("PackInstaller", (new StringBuilder()).append("insert pack, content and items: ").append(acontentvalues.length).toString());
        l1 = CdsDatabaseHelper.insertValues("packs_table", acontentvalues[0], sqlitedatabase);
        if (l1 >= 0L) goto _L2; else goto _L1
_L1:
        Log.e("PackInstaller", (new StringBuilder()).append("packId=").append(l1).toString());
        l = -1L;
_L4:
        return l;
_L2:
        context = acontentvalues[1];
        context.put("content_packId", Long.valueOf(l1));
        l = CdsDatabaseHelper.insertValues("content_table", context, sqlitedatabase);
        if (l < 0L)
        {
            Log.e("PackInstaller", (new StringBuilder()).append("rowId=").append(l).toString());
            return -1L;
        }
        int i = 2;
        do
        {
            l = l1;
            if (i >= acontentvalues.length)
            {
                continue;
            }
            context = acontentvalues[i];
            context.put("item_packId", Long.valueOf(l1));
            l = CdsDatabaseHelper.insertValues("items_table", context, sqlitedatabase);
            if (l < 0L)
            {
                Log.e("PackInstaller", (new StringBuilder()).append("itemId=").append(l).toString());
                return -1L;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void installFromDir(Context context, File file)
        throws IOException, IllegalStateException, JSONException
    {
        Object obj;
        String s;
        Object obj1;
        ContentValues acontentvalues[];
        if (file == null || !file.isDirectory() || !file.exists())
        {
            Log.w("PackInstaller", "dir does not exists");
            throw new IOException("Target directory doesn't exist or is invalid");
        }
        if (!"production".equals("alpha"))
        {
            Log.w("PackInstaller", "install disabled. production");
            throw new IllegalStateException("Installation not enabled for 'production'");
        }
        obj = new ArrayList(Arrays.asList(new String[] {
            "status.json", "index.json", "icon.png", "content.zip"
        }));
        File afile[] = file.listFiles();
        int i1 = afile.length;
        for (int i = 0; i < i1; i++)
        {
            ((List) (obj)).remove(afile[i].getName());
        }

        if (((List) (obj)).size() != 0)
        {
            throw new IOException("Pack is not valid");
        }
        obj = new FileInputStream(new File(file, "index.json"));
        Object obj2 = new CdsContentParser();
        ((CdsContentParser) (obj2)).parse(((java.io.InputStream) (obj)));
        IOUtils.closeSilently(((java.io.Closeable) (obj)));
        obj = ((CdsContentParser) (obj2)).getIdentifier();
        obj1 = ((CdsContentParser) (obj2)).getDisplayName();
        int j = ((CdsContentParser) (obj2)).getItems().size();
        s = ((CdsContentParser) (obj2)).getPackType();
        Log.d("PackInstaller", (new StringBuilder()).append("identifier: ").append(((String) (obj))).toString());
        Log.d("PackInstaller", (new StringBuilder()).append("displayName: ").append(((String) (obj1))).toString());
        Log.d("PackInstaller", (new StringBuilder()).append("count: ").append(j).toString());
        Log.d("PackInstaller", (new StringBuilder()).append("packType: ").append(s).toString());
        obj1 = new ArrayList();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("pack_identifier", ((String) (obj)));
        contentvalues.put("pack_type", s);
        contentvalues.put("pack_versionKey", ((CdsContentParser) (obj2)).getVersionKey());
        contentvalues.put("pack_visible", Integer.valueOf(1));
        contentvalues.put("pack_displayOrder", Integer.valueOf(0));
        ((ArrayList) (obj1)).add(contentvalues);
        contentvalues = new ContentValues();
        contentvalues.put("content_displayName", ((CdsContentParser) (obj2)).getDisplayName());
        contentvalues.put("content_displayDescription", ((CdsContentParser) (obj2)).getDisplayDescription());
        contentvalues.put("content_contentURL", ((CdsContentParser) (obj2)).getContentURL());
        contentvalues.put("content_contentVersion", ((CdsContentParser) (obj2)).getContentVersion());
        contentvalues.put("content_iconUrl", ((CdsContentParser) (obj2)).getIconURL());
        contentvalues.put("content_iconVersion", ((CdsContentParser) (obj2)).getIconVersion());
        contentvalues.put("content_previewURL", ((CdsContentParser) (obj2)).getPreviewURL());
        contentvalues.put("content_previewVersion", ((CdsContentParser) (obj2)).getPreviewVersion());
        if (((CdsContentParser) (obj2)).isFree())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("content_isFree", Integer.valueOf(j));
        contentvalues.put("content_purchased", Integer.valueOf(1));
        ((ArrayList) (obj1)).add(contentvalues);
        obj2 = ((CdsContentParser) (obj2)).getItems();
        for (j = 0; j < ((List) (obj2)).size(); j++)
        {
            com.aviary.android.feather.cds.json.CdsContentParser.ContentItem contentitem = (com.aviary.android.feather.cds.json.CdsContentParser.ContentItem)((List) (obj2)).get(j);
            ContentValues contentvalues1 = new ContentValues();
            contentvalues1.put("item_identifier", contentitem.getIdentifier());
            contentvalues1.put("item_displayName", contentitem.getDisplayName());
            if (contentitem.getOptions() != null)
            {
                contentvalues1.put("item_options", contentitem.getOptions());
            }
            ((ArrayList) (obj1)).add(contentvalues1);
        }

        obj2 = CdsUtils.getPackByIdentifier(context, ((String) (obj)), null);
        if (obj2 != null)
        {
            Log.d("PackInstaller", "pack already exists. trying to uninstall");
            int k = context.getContentResolver().delete(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(((PacksColumns.PackCursorWrapper) (obj2)).getId()).append("/remove").toString()), null, null);
            Log.d("PackInstaller", (new StringBuilder()).append("remove result: ").append(k).toString());
            Log.d("PackInstaller", "now trying to delete old contents");
            CdsUtils.uninstallPack(context, ((PacksColumns.PackCursorWrapper) (obj2)).getId());
        }
        acontentvalues = (ContentValues[])((ArrayList) (obj1)).toArray(new ContentValues[((ArrayList) (obj1)).size()]);
        obj1 = CdsDatabaseHelper.getInstance(context).getWritableDatabase();
        ((SQLiteDatabase) (obj1)).beginTransaction();
        long l1 = insertNewPackContentAndItems(context, ((SQLiteDatabase) (obj1)), acontentvalues);
        if (l1 <= -1L)
        {
            break MISSING_BLOCK_LABEL_955;
        }
        int l = extractIcon(context, ((SQLiteDatabase) (obj1)), new File(file, "icon.png"), ((String) (obj)), l1);
        Log.d("PackInstaller", (new StringBuilder()).append("icon result: ").append(l).toString());
        l = extractContent(context, ((SQLiteDatabase) (obj1)), new File(file, "content.zip"), ((String) (obj)), l1, s);
        Log.d("PackInstaller", (new StringBuilder()).append("content result: ").append(l).toString());
        ((SQLiteDatabase) (obj1)).setTransactionSuccessful();
        ((SQLiteDatabase) (obj1)).endTransaction();
        return;
        context;
        ((SQLiteDatabase) (obj1)).endTransaction();
        throw context;
    }

    private static int updateContentPath(Context context, SQLiteDatabase sqlitedatabase, long l, String s)
    {
        context = new ContentValues();
        context.put("content_contentPath", s);
        context.put("content_installDate", DateTimeUtils.toSqlDateTime(System.currentTimeMillis()));
        return sqlitedatabase.update("content_table", context, "content_packId=?", new String[] {
            String.valueOf(l)
        });
    }

    private static int updateIconPath(SQLiteDatabase sqlitedatabase, long l, String s, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("content_iconPath", s);
        contentvalues.put("content_iconNeedDownload", Integer.valueOf(i));
        return sqlitedatabase.update("content_table", contentvalues, "content_packId=?", new String[] {
            String.valueOf(l)
        });
    }
}
