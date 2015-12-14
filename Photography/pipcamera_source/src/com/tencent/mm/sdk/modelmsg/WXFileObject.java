// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXFileObject
    implements WXMediaMessage.IMediaObject
{

    private static final int CONTENT_LENGTH_LIMIT = 0xa00000;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte fileData[];
    public String filePath;

    public WXFileObject()
    {
        contentLengthLimit = 0xa00000;
        fileData = null;
        filePath = null;
    }

    public WXFileObject(String s)
    {
        contentLengthLimit = 0xa00000;
        filePath = s;
    }

    public WXFileObject(byte abyte0[])
    {
        contentLengthLimit = 0xa00000;
        fileData = abyte0;
    }

    private int getFileSize(String s)
    {
        if (s != null && s.length() != 0)
        {
            if ((s = new File(s)).exists())
            {
                return (int)s.length();
            }
        }
        return 0;
    }

    public boolean checkArgs()
    {
        if ((fileData == null || fileData.length == 0) && (filePath == null || filePath.length() == 0))
        {
            a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (fileData != null && fileData.length > contentLengthLimit)
        {
            a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
            return false;
        }
        if (filePath != null && getFileSize(filePath) > contentLengthLimit)
        {
            a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putByteArray("_wxfileobject_fileData", fileData);
        bundle.putString("_wxfileobject_filePath", filePath);
    }

    public void setContentLengthLimit(int i)
    {
        contentLengthLimit = i;
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
