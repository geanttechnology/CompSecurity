// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXAppExtendObject
    implements WXMediaMessage.IMediaObject
{

    public String extInfo;
    public byte fileData[];
    public String filePath;

    public WXAppExtendObject()
    {
    }

    public WXAppExtendObject(String s, String s1)
    {
        extInfo = s;
        filePath = s1;
    }

    public WXAppExtendObject(String s, byte abyte0[])
    {
        extInfo = s;
        fileData = abyte0;
    }

    public boolean checkArgs()
    {
        if ((extInfo == null || extInfo.length() == 0) && (filePath == null || filePath.length() == 0) && (fileData == null || fileData.length == 0))
        {
            Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
            return false;
        }
        if (extInfo != null && extInfo.length() > 2048)
        {
            Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
            return false;
        }
        if (filePath != null && filePath.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
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
                Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
                return false;
            }
        }
        if (fileData != null && fileData.length > 0xa00000)
        {
            Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxappextendobject_extInfo", extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", fileData);
        bundle.putString("_wxappextendobject_filePath", filePath);
    }

    public int type()
    {
        return 7;
    }

    public void unserialize(Bundle bundle)
    {
        extInfo = bundle.getString("_wxappextendobject_extInfo");
        fileData = bundle.getByteArray("_wxappextendobject_fileData");
        filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
