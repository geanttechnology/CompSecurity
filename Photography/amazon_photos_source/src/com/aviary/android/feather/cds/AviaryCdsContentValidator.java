// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

class AviaryCdsContentValidator extends AviaryCdsValidatorFactory.Validator
{
    static abstract class ContentValidator
    {

        abstract boolean validateItem(String s, List list)
            throws AssertionError;

        abstract boolean validateItem(String s, ZipFile zipfile)
            throws AssertionError;

        ContentValidator()
        {
        }
    }

    static class EffectValidator extends ContentValidator
    {

        boolean validateItem(String s, List list)
            throws AssertionError
        {
            return list.contains((new StringBuilder()).append(s).append(".json").toString());
        }

        boolean validateItem(String s, ZipFile zipfile)
            throws AssertionError
        {
            Assert.assertNotNull("identifier is null", s);
            Assert.assertNotNull("zip is null", zipfile);
            zipfile = zipfile.getEntry((new StringBuilder()).append(s).append(".json").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append(".json").toString(), zipfile);
            return true;
        }

        EffectValidator()
        {
        }
    }

    static class FrameValidator extends ContentValidator
    {

        boolean validateItem(String s, List list)
            throws AssertionError
        {
            while (!list.contains((new StringBuilder()).append(s).append("-small.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-br-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-r-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-tr-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-t-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-tl-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-l-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-b-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-bl-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-br-medium.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-br-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-r-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-tr-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-t-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-tl-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-l-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-b-large.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-bl-large.png").toString())) 
            {
                return false;
            }
            return list.contains((new StringBuilder()).append(s).append("-br-large.png").toString());
        }

        boolean validateItem(String s, ZipFile zipfile)
        {
            Assert.assertNotNull("identifier is null", s);
            Assert.assertNotNull("zip is null", zipfile);
            java.util.zip.ZipEntry zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-small.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-small.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-br-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-br-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-r-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-r-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-tr-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-tr-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-t-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-t-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-tl-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-tl-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-l-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-l-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-b-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-b-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-bl-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-bl-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-br-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-br-medium.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-br-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-br-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-r-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-r-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-tr-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-tr-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-t-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-t-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-tl-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-tl-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-l-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-l-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-b-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-b-large.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-bl-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-bl-large.png").toString(), zipentry);
            zipfile = zipfile.getEntry((new StringBuilder()).append(s).append("-br-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-br-large.png").toString(), zipfile);
            return true;
        }

        FrameValidator()
        {
        }
    }

    static class OverlayValidator extends ContentValidator
    {

        boolean validateItem(String s, List list)
            throws AssertionError
        {
            return true;
        }

        boolean validateItem(String s, ZipFile zipfile)
            throws AssertionError
        {
            return true;
        }

        OverlayValidator()
        {
        }
    }

    static class StickerValidator extends ContentValidator
    {

        boolean validateItem(String s, List list)
            throws AssertionError
        {
            while (!list.contains((new StringBuilder()).append(s).append("-small.png").toString()) || !list.contains((new StringBuilder()).append(s).append("-medium.png").toString())) 
            {
                return false;
            }
            return list.contains((new StringBuilder()).append(s).append("-large.png").toString());
        }

        boolean validateItem(String s, ZipFile zipfile)
            throws AssertionError
        {
            Assert.assertNotNull("identifier is null", s);
            Assert.assertNotNull("zip is null", zipfile);
            java.util.zip.ZipEntry zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-small.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-small.png").toString(), zipentry);
            zipentry = zipfile.getEntry((new StringBuilder()).append(s).append("-medium.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-medium.png").toString(), zipentry);
            zipfile = zipfile.getEntry((new StringBuilder()).append(s).append("-large.png").toString());
            Assert.assertNotNull((new StringBuilder()).append(s).append("-large.png").toString(), zipfile);
            return true;
        }

        StickerValidator()
        {
        }
    }


    ContentValidator mInstance;

    public AviaryCdsContentValidator(AviaryCds.PackType packtype)
    {
        super(packtype);
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType = new int[AviaryCds.PackType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.FRAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.EFFECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.STICKER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.OVERLAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.PackType[packtype.ordinal()])
        {
        default:
            mInstance = null;
            return;

        case 1: // '\001'
            mInstance = new FrameValidator();
            return;

        case 2: // '\002'
            mInstance = new EffectValidator();
            return;

        case 3: // '\003'
            mInstance = new StickerValidator();
            return;

        case 4: // '\004'
            mInstance = new OverlayValidator();
            break;
        }
    }

    public boolean validate(Context context, long l, File file, boolean flag)
    {
        List list;
        String s;
        boolean flag1;
        logger.info((new StringBuilder()).append("validate: ").append(l).append(", ").append(file.getAbsolutePath()).toString());
        s = null;
        list = null;
        int i;
        if (flag)
        {
            try
            {
                file = new ZipFile(file);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return false;
            }
        } else
        {
            list = Arrays.asList(file.list());
            file = s;
        }
        context = context.getContentResolver().query(CdsUtils.getContentUri(context, (new StringBuilder()).append("pack/").append(l).append("/item/list").toString()), new String[] {
            "item_id", "item_identifier"
        }, null, null, null);
        Assert.assertNotNull("cannot fetch list of items", context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_380;
        }
        i = context.getColumnIndex("item_identifier");
        if (i > -1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assert.assertTrue("unable to find identifier column index", flag1);
        if (context.getCount() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assert.assertTrue("item cursor has '0' rows", flag1);
_L2:
        if (!context.moveToNext())
        {
            break MISSING_BLOCK_LABEL_355;
        }
        s = context.getString(i);
        Assert.assertNotNull("identifier is null", s);
        logger.log("checking.. %s", new Object[] {
            s
        });
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mInstance.validateItem(s, file)) goto _L2; else goto _L1
_L1:
        logger.error("failed to validate %s", new Object[] {
            s
        });
        IOUtils.closeSilently(context);
        IOUtils.closeSilently(file);
        return false;
        if (mInstance.validateItem(s, list)) goto _L2; else goto _L3
_L3:
        logger.error("failed to validate %s", new Object[] {
            s
        });
        IOUtils.closeSilently(context);
        IOUtils.closeSilently(file);
        return false;
        IOUtils.closeSilently(context);
        IOUtils.closeSilently(file);
        return true;
        Exception exception;
        exception;
        IOUtils.closeSilently(context);
        IOUtils.closeSilently(file);
        throw exception;
        return false;
    }
}
