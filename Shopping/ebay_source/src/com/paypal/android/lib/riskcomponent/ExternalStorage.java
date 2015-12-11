// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;

import android.os.Environment;
import com.paypal.android.lib.riskcomponent.utils.IOUtilities;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ExternalStorage
{

    private boolean mAvailable;
    private File mDir;
    private boolean mWriteable;

    public ExternalStorage()
    {
        mAvailable = false;
        mWriteable = false;
        updateState();
        mDir = Environment.getExternalStorageDirectory();
    }

    private void updateState()
    {
        String s;
        byte byte0;
        s = Environment.getExternalStorageState();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 36
    //                   1242932856: 71
    //                   1299749220: 85;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_85;
_L4:
        switch (byte0)
        {
        default:
            mWriteable = false;
            mAvailable = false;
            return;

        case 0: // '\0'
            mWriteable = true;
            mAvailable = true;
            return;

        case 1: // '\001'
            mAvailable = true;
            break;
        }
        break MISSING_BLOCK_LABEL_115;
_L2:
        if (s.equals("mounted"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("mounted_ro"))
        {
            byte0 = 1;
        }
          goto _L4
        mWriteable = false;
        return;
    }

    public String read(String s)
        throws UnsupportedEncodingException
    {
        byte abyte0[];
        byte abyte1[];
        Object obj1;
        abyte1 = new byte[1024];
        abyte0 = abyte1;
        if (!mWriteable)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj1 = null;
        abyte0 = null;
        s = new FileInputStream(new File(mDir, s));
        int i;
        abyte0 = new ByteArrayOutputStream();
        i = s.read(abyte1, 0, 1024);
_L1:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        abyte0.write(abyte1, 0, i);
        i = s.read(abyte1, 0, 1024);
          goto _L1
        abyte0 = abyte0.toByteArray();
        IOUtilities.closeQuietly(s);
        return new String(abyte0, "UTF-8");
        s;
        s = abyte0;
_L5:
        IOUtilities.closeQuietly(s);
        return "";
        Object obj;
        obj;
        s = obj1;
_L3:
        IOUtilities.closeQuietly(s);
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        obj;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setDirectory(String s)
    {
        mDir = new File(s);
    }

    public void write(String s, byte abyte0[])
        throws IOException
    {
        String s1;
        Object obj;
        if (!mAvailable || !mWriteable)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = null;
        s1 = null;
        if (!mDir.mkdirs() && !mDir.isDirectory())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s = new FileOutputStream(new File(mDir, s));
        s.write(abyte0);
        s1 = s;
        IOUtilities.closeQuietly(s1);
        return;
        abyte0;
        s = obj;
_L2:
        IOUtilities.closeQuietly(s);
        throw abyte0;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
