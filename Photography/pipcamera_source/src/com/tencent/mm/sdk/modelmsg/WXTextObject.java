// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

public class WXTextObject
    implements WXMediaMessage.IMediaObject
{

    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXTextObject";
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
            a.a("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
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
