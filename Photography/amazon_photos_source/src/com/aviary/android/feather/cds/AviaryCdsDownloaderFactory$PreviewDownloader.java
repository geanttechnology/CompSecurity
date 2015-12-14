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
import java.io.IOException;
import java.util.Locale;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory, CdsUtils, AviaryCdsValidatorFactory

static class Q extends Q
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
        s1 = ((Q) (obj)).BaseURL();
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
            obj1 = ntentUri(cursor);
            obj = te(cursor);
        }
        IOUtils.closeSilently(cursor);
        Assert.assertNotNull("null pack", obj1);
        Assert.assertNotNull("null context", obj);
        String s = ((te) (obj)).reviewURL();
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
        AviaryCdsDownloaderFactory.LOGGER.RL("previewUrl: %s", new Object[] {
            obj3
        });
        s = ((reviewURL) (obj1)).reviewURL();
        obj1 = ((reviewURL) (obj1)).reviewURL();
        long l1 = ((reviewURL) (obj)).d();
        obj3 = IOUtils.hunt(context, ((String) (obj3)));
        obj = AviaryCdsDownloaderFactory.getCacheDir(context, getCacheDirName());
        Assert.assertNotNull("destination directory is null", obj);
        ((File) (obj)).setReadable(true, false);
        AviaryCdsDownloaderFactory.LOGGER.eDirName("destDir: %s", new Object[] {
            ((File) (obj)).getAbsolutePath()
        });
        obj = new File(((File) (obj)), s);
        ((File) (obj)).mkdirs();
        IOUtils.createNoMediaFile(((File) (obj)));
        Assert.assertTrue((new StringBuilder()).append("failed to create dest folder: ").append(s).toString(), ((File) (obj)).exists());
        ((File) (obj)).setReadable(true, false);
        IOUtils.unzip(((java.io.InputStream) (obj3)), ((File) (obj)));
        IOUtils.closeSilently(((java.io.Closeable) (obj3)));
        obj1 = getCacheDirName(((String) (obj1)).toUpperCase(Locale.US));
        Assert.assertTrue("invalid preview content", AviaryCdsValidatorFactory.create(getCacheDirName, ((getCacheDirName) (obj1))).getCacheDirName(context, l, ((File) (obj)), false));
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("content_previewPath", ((File) (obj)).getAbsolutePath());
        AviaryCdsDownloaderFactory.LOGGER.eDirName((new StringBuilder()).append("updating: ").append(l).append(", ").append(l1).toString());
        AviaryCdsDownloaderFactory.LOGGER.eDirName((new StringBuilder()).append("destFolder: ").append(((File) (obj)).getAbsolutePath()).toString());
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

    Q()
    {
    }
}
