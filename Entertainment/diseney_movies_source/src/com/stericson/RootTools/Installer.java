// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            InternalMethods, RootTools

class Installer
{

    private static final String BOGUS_FILE_NAME = "bogus";
    private static final String LOG_TAG = "RootTools::Installer";
    private Context context;
    private String filesPath;

    public Installer(Context context1)
        throws IOException
    {
        context = context1;
        filesPath = context1.getFilesDir().getCanonicalPath();
    }

    protected boolean installBinary(int i, String s, String s1)
    {
        File file = new File((new StringBuilder(String.valueOf(filesPath))).append(File.separator).append(s).toString());
        if (file.exists()) goto _L2; else goto _L1
_L1:
        context.openFileInput("bogus").close();
_L11:
        Object obj;
        FileOutputStream fileoutputstream;
        InputStream inputstream;
        inputstream = context.getResources().openRawResource(i);
        obj = null;
        fileoutputstream = null;
        Object obj1 = new FileOutputStream(file);
        obj = new byte[4096];
_L5:
        i = inputstream.read(((byte []) (obj)));
        if (-1 != i) goto _L4; else goto _L3
_L3:
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (RootTools.debugMode)
            {
                Log.e("RootTools::Installer", s.toString());
            }
            return false;
        }
        try
        {
            (new InternalMethods()).doExec(new String[] {
                (new StringBuilder("chmod ")).append(s1).append(" ").append(filesPath).append(File.separator).append(s).toString()
            }, -1);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
_L2:
        return true;
        obj;
        obj1 = null;
        obj = null;
        fileoutputstream = context.openFileOutput("bogus", 0);
        obj = fileoutputstream;
        obj1 = fileoutputstream;
        fileoutputstream.write("justcreatedfilesdirectory".getBytes());
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
                context.deleteFile("bogus");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        continue; /* Loop/switch isn't completed */
        s;
        obj1 = obj;
        if (!RootTools.debugMode)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        obj1 = obj;
        Log.e("RootTools::Installer", s.toString());
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
                context.deleteFile("bogus");
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        s;
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
                context.deleteFile("bogus");
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        if (RootTools.debugMode)
        {
            Log.e("RootTools::Installer", s.toString());
        }
        return false;
_L4:
        ((FileOutputStream) (obj1)).write(((byte []) (obj)), 0, i);
          goto _L5
        s;
        if (RootTools.debugMode)
        {
            Log.e("RootTools::Installer", s.toString());
        }
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        s1;
        s = fileoutputstream;
_L9:
        obj = s;
        if (!RootTools.debugMode)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        obj = s;
        Log.e("RootTools::Installer", s1.toString());
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        s;
_L7:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        obj = obj1;
        if (true) goto _L7; else goto _L6
_L6:
        s1;
        s = ((String) (obj1));
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    protected boolean isBinaryInstalled(String s)
    {
        boolean flag = false;
        if ((new File((new StringBuilder(String.valueOf(filesPath))).append(File.separator).append(s).toString())).exists())
        {
            flag = true;
        }
        return flag;
    }
}
