// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FolderUtil
{

    public static final String TAG = com/amazon/gallery/foundation/utils/file/FolderUtil.getName();

    public FolderUtil()
    {
    }

    public static boolean directoryEqualsOrContainsPath(File file, File file1)
    {
_L2:
        return false;
        if (file1 == null || file == null || !file.exists()) goto _L2; else goto _L1
_L1:
        boolean flag;
        try
        {
            if (FileUtils.directoryContains(file, file1))
            {
                break; /* Loop/switch isn't completed */
            }
            flag = file.getCanonicalPath().equalsIgnoreCase(file1.getCanonicalPath());
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            GLogger.wx(TAG, "Unable to determine whether path is in the camera directory", file);
            return false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        return true;
    }

}
