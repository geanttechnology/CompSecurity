// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXFileObject
    implements WXMediaMessage.IMediaObject
{

    public byte fileData[];
    public String filePath;

    public WXFileObject()
    {
        fileData = null;
        filePath = null;
    }

    public WXFileObject(String s)
    {
        filePath = s;
    }

    public WXFileObject(byte abyte0[])
    {
        fileData = abyte0;
    }

    public boolean checkArgs()
    {
        if ((fileData == null || fileData.length == 0) && (filePath == null || filePath.length() == 0))
        {
            Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (fileData != null && fileData.length > 0xa00000)
        {
            Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
            return false;
        }
        if (filePath != null)
        {
            Object obj = filePath;
            int i;
            if (obj == null || ((String) (obj)).length() == 0)
            {
                i = 0;
            } else
            {
                obj = new File(((String) (obj)));
                if (!((File) (obj)).exists())
                {
                    i = 0;
                } else
                {
                    i = (int)((File) (obj)).length();
                }
            }
            if (i > 0xa00000)
            {
                Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
                return false;
            }
        }
        return true;
    }

    public void serialize(Bundle bundle)
    {
        bundle.putByteArray("_wxfileobject_fileData", fileData);
        bundle.putString("_wxfileobject_filePath", filePath);
    }

    public void setFileData(byte abyte0[])
    {
        fileData = abyte0;
    }

    public void setFilePath(String s)
    {
        filePath = s;
    }

    public int type()
    {
        return 6;
    }

    public void unserialize(Bundle bundle)
    {
        fileData = bundle.getByteArray("_wxfileobject_fileData");
        filePath = bundle.getString("_wxfileobject_filePath");
    }
}
