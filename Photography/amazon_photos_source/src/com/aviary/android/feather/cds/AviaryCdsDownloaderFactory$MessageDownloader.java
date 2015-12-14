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

static class per extends per
{

    public String download(Context context, long l, boolean flag)
        throws IOException, AssertionError
    {
        Object obj;
        per per;
        Object obj5;
        Cursor cursor;
        Assert.assertNotNull("null context", context);
        obj = CdsUtils.getManifestVersion(context);
        Assert.assertNotNull("null manifest", obj);
        obj5 = ((per) (obj)).BaseURL();
        Assert.assertNotNull("null baseUrl", obj5);
        obj = null;
        Object obj3 = null;
        per = null;
        Object obj1 = null;
        cursor = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("message/id/").append(l).append("/content").toString()), new String[] {
            "msg_id", "msg_identifier", "msg_type", "msgcnt_id", "msgcnt_messageId", "msgcnt_contentURL"
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = obj3;
        per = obj1;
        if (cursor.moveToFirst())
        {
            obj = BaseURL(cursor);
            per = com.aviary.android.feather.cds.per.create(cursor);
        }
        IOUtils.closeSilently(cursor);
        Assert.assertNotNull("message is null", obj);
        Assert.assertNotNull("messageContent is null", per);
        Object obj4 = per.getContentURL();
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
        AviaryCdsDownloaderFactory.LOGGER.ContentURL("messageUrl: %s", new Object[] {
            obj2
        });
        obj4 = ((per.getContentURL) (obj)).fier();
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
        AviaryCdsDownloaderFactory.LOGGER.eDirName((new StringBuilder()).append("updating: ").append(((getCacheDirName) (obj)).getCacheDirName()).append(", ").append(per.getId()).toString());
        boolean flag1;
        if (context.getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("message/id/").append(((ntentUri) (obj)).ntentUri()).append("/content/id/").append(per.getId()).append("/update").toString()), ((ContentValues) (obj2)), null, null) > 0)
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

    per()
    {
    }
}
