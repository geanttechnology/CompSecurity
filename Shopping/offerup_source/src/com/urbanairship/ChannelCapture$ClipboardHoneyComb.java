// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

// Referenced classes of package com.urbanairship:
//            ChannelCapture

class clipboardManager
    implements clipboardManager
{

    private final ClipboardManager clipboardManager;
    final ChannelCapture this$0;

    public void clear()
    {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
    }

    public String getText()
    {
        ClipData clipdata = clipboardManager.getPrimaryClip();
        if (clipdata != null && clipdata.getItemCount() > 0)
        {
            for (int i = 0; i < clipdata.getItemCount(); i++)
            {
                CharSequence charsequence = clipdata.getItemAt(i).clipboardManager();
                if (charsequence != null)
                {
                    return charsequence.toString();
                }
            }

        }
        return null;
    }

    ()
    {
        this$0 = ChannelCapture.this;
        super();
        clipboardManager = (ClipboardManager)ChannelCapture.access$200(ChannelCapture.this).getSystemService("clipboard");
    }
}
