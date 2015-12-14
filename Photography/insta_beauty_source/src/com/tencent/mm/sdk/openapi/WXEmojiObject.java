// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXEmojiObject
    implements WXMediaMessage.IMediaObject
{

    public byte emojiData[];
    public String emojiPath;

    public WXEmojiObject()
    {
        emojiData = null;
        emojiPath = null;
    }

    public WXEmojiObject(String s)
    {
        emojiPath = s;
    }

    public WXEmojiObject(byte abyte0[])
    {
        emojiData = abyte0;
    }

    public boolean checkArgs()
    {
        if ((emojiData == null || emojiData.length == 0) && (emojiPath == null || emojiPath.length() == 0))
        {
            Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (emojiData != null && emojiData.length > 0xa00000)
        {
            Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
            return false;
        }
        if (emojiPath != null)
        {
            Object obj = emojiPath;
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
                Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
                return false;
            }
        }
        return true;
    }

    public void serialize(Bundle bundle)
    {
        bundle.putByteArray("_wxemojiobject_emojiData", emojiData);
        bundle.putString("_wxemojiobject_emojiPath", emojiPath);
    }

    public void setEmojiData(byte abyte0[])
    {
        emojiData = abyte0;
    }

    public void setEmojiPath(String s)
    {
        emojiPath = s;
    }

    public int type()
    {
        return 8;
    }

    public void unserialize(Bundle bundle)
    {
        emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
