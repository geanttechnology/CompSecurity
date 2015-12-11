// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXFileObject
    implements WXMediaMessage.IMediaObject
{

    private int contentLengthLimit;
    public byte fileData[];
    public String filePath;

    public WXFileObject()
    {
        contentLengthLimit = 0xa00000;
        fileData = null;
        filePath = null;
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
            Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (fileData != null && fileData.length > contentLengthLimit)
        {
            Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
            return false;
        }
        if (filePath != null && getFileSize(filePath) > contentLengthLimit)
        {
            Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
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
