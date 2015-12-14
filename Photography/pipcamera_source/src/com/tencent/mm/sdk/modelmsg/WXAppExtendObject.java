// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXAppExtendObject
    implements WXMediaMessage.IMediaObject
{

    private static final int CONTENT_LENGTH_LIMIT = 0xa00000;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
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
        if ((extInfo == null || extInfo.length() == 0) && (filePath == null || filePath.length() == 0) && (fileData == null || fileData.length == 0))
        {
            a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
            return false;
        }
        if (extInfo != null && extInfo.length() > 2048)
        {
            a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
            return false;
        }
        if (filePath != null && filePath.length() > 10240)
        {
            a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
            return false;
        }
        if (filePath != null && getFileSize(filePath) > 0xa00000)
        {
            a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
            return false;
        }
        if (fileData != null && fileData.length > 0xa00000)
        {
            a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
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
