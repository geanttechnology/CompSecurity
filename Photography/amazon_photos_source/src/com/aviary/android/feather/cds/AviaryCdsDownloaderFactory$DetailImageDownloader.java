// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory, CdsUtils

static class  extends 
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
        s1 = (() (obj)).URL();
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
            obj1 = getLocalPathColumnName(cursor);
            obj = getLocalPathColumnName(cursor);
        }
        IOUtils.closeSilently(cursor);
        String s;
        Assert.assertNotNull("null pack", obj1);
        Assert.assertNotNull("null content", obj);
        s = getRemotePath(((getRemotePath) (obj)));
        Object obj3 = getLocalPath(((getLocalPath) (obj)));
        if (!TextUtils.isEmpty(((CharSequence) (obj3))))
        {
            obj3 = new File(((String) (obj3)));
            AviaryCdsDownloaderFactory.LOGGER.lPath("localPath exists: %b", new Object[] {
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
        AviaryCdsDownloaderFactory.LOGGER.lPath("remotePath: %s", new Object[] {
            obj4
        });
        obj1 = ((getLocalPath) (obj1)).getLocalPath();
        long l1 = ((getLocalPath) (obj)).getLocalPath();
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
        AviaryCdsDownloaderFactory.LOGGER.lPathColumnName((new StringBuilder()).append("updating: ").append(l).append(", ").append(l1).toString());
        AviaryCdsDownloaderFactory.LOGGER.lPathColumnName((new StringBuilder()).append("destFile: ").append(((File) (obj)).getAbsolutePath()).toString());
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

    protected String getLocalPath(getLocalPathColumnName getlocalpathcolumnname)
    {
        return getlocalpathcolumnname.lImageLocalPath();
    }

    protected String getLocalPathColumnName()
    {
        return "content_detailImageLocalPath";
    }

    protected String getRemotePath(lImageLocalPath limagelocalpath)
    {
        return limagelocalpath.lImageURL();
    }

    protected String getRemoteUrlColumnName()
    {
        return "content_detailImageURL";
    }

    ()
    {
    }
}
