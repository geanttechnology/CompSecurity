// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class WXTextObject
    implements WXMediaMessage.IMediaObject
{

    public String text;

    public WXTextObject()
    {
        this(null);
    }

    public WXTextObject(String s)
    {
        text = s;
    }

    public boolean checkArgs()
    {
        if (text == null || text.length() == 0 || text.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxtextobject_text", text);
    }

    public int type()
    {
        return 1;
    }

    public void unserialize(Bundle bundle)
    {
        text = bundle.getString("_wxtextobject_text");
    }
}
