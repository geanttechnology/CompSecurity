// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

final class AviaryCdsPreviewValidator extends AviaryCdsValidatorFactory.Validator
{

    public AviaryCdsPreviewValidator(AviaryCds.PackType packtype)
    {
        super(packtype);
    }

    public boolean validate(Context context, long l, File file, boolean flag)
    {
        String s;
        Assert.assertNotNull("input dir is null", file);
        Assert.assertNotNull("context is null", context);
        context = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/").append(l).append("/item/list").toString()), new String[] {
            "item_id", "item_identifier"
        }, null, null, null);
        Assert.assertNotNull("cursor is null", context);
        s = AviaryCds.getPreviewItemExt(mPackType);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        int i = context.getColumnIndex("item_identifier");
        if (i > -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("index column < 0", flag);
        if (context.getCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("cursor is empty", flag);
        Object obj;
        for (; context.moveToNext(); Assert.assertTrue((new StringBuilder()).append("file '").append(((File) (obj)).getAbsolutePath()).append("' does not exists").toString(), ((File) (obj)).exists()))
        {
            obj = context.getString(i);
            Assert.assertNotNull("identifier is null", obj);
            obj = new File(file, (new StringBuilder()).append(((String) (obj))).append(s).toString());
        }

        break MISSING_BLOCK_LABEL_247;
        file;
        IOUtils.closeSilently(context);
        throw file;
        IOUtils.closeSilently(context);
        return true;
        return false;
    }
}
