// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import com.millennialmedia.MMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.millennialmedia.internal.utils:
//            IOUtils

public static class outputFile
    implements eamer
{

    private File outputFile;

    public void streamContent(InputStream inputstream, eamer eamer)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        FileOutputStream fileoutputstream = new FileOutputStream(outputFile);
        IOUtils.read(inputstream, fileoutputstream);
        eamer.le = outputFile;
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        fileoutputstream.close();
_L2:
        return;
        inputstream;
        MMLog.e(IOUtils.access$000(), "Error closing OutputStream when writing file", inputstream);
        return;
        eamer;
        inputstream = obj1;
_L5:
        obj = inputstream;
        MMLog.e(IOUtils.access$000(), "Unable to create file from input stream", eamer);
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            MMLog.e(IOUtils.access$000(), "Error closing OutputStream when writing file", inputstream);
        }
        return;
        inputstream;
_L4:
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (eamer eamer)
            {
                MMLog.e(IOUtils.access$000(), "Error closing OutputStream when writing file", eamer);
            }
        }
        throw inputstream;
        inputstream;
        obj = fileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
        eamer;
        inputstream = fileoutputstream;
          goto _L5
    }

    public eamer(File file)
    {
        outputFile = file;
    }
}
