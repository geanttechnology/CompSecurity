// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import com.aviary.android.feather.common.log.LoggerFactory;
import it.sephiroth.android.library.exif2.ExifInterface;
import java.io.IOException;
import java.io.InputStream;

public final class ExifUtils
{

    private static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;

    private ExifUtils()
    {
    }

    public static int getOrientation(ExifInterface exifinterface)
    {
        exifinterface = exifinterface.getTagIntValue(ExifInterface.TAG_ORIENTATION);
        if (exifinterface == null)
        {
            return 0;
        } else
        {
            return ExifInterface.getRotationForOrientationValue(exifinterface.shortValue());
        }
    }

    public static int getOrientation(InputStream inputstream)
    {
        logger.info("getOrientation");
        if (inputstream == null)
        {
            return 0;
        }
        ExifInterface exifinterface = new ExifInterface();
        int i;
        try
        {
            exifinterface.readExif(inputstream, 1);
            i = getOrientation(exifinterface);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            logger.warn("Failed to read EXIF orientation: %s", new Object[] {
                inputstream.getMessage()
            });
            return 0;
        }
        return i;
    }

    public static int getOrientation(String s)
    {
        if (s == null)
        {
            return 0;
        }
        ExifInterface exifinterface = new ExifInterface();
        int i;
        try
        {
            exifinterface.readExif(s, 1);
            i = getOrientation(exifinterface);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.warn("Failed to read EXIF orientation", new Object[] {
                s
            });
            return 0;
        }
        return i;
    }

    static 
    {
        logger = LoggerFactory.getLogger("ExifUtils", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
