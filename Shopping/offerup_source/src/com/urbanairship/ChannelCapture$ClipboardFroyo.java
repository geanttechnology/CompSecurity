// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.Context;
import android.text.ClipboardManager;

// Referenced classes of package com.urbanairship:
//            ChannelCapture

class clipboardManager
    implements clipboardManager
{

    private final ClipboardManager clipboardManager;
    final ChannelCapture this$0;

    public void clear()
    {
        clipboardManager.setText("");
    }

    public String getText()
    {
        return String.valueOf(clipboardManager.getText());
    }

    ()
    {
        this$0 = ChannelCapture.this;
        super();
        clipboardManager = (ClipboardManager)ChannelCapture.access$200(ChannelCapture.this).getSystemService("clipboard");
    }
}
