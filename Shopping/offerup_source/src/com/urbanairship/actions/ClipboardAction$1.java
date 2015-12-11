// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.actions:
//            ClipboardAction

class val.text
    implements Runnable
{

    final ClipboardAction this$0;
    final String val$label;
    final String val$text;

    public void run()
    {
        if (android.os.INT >= 11)
        {
            ((ClipboardManager)UAirship.getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(val$label, val$text));
            return;
        } else
        {
            ((android.text.ClipboardManager)UAirship.getApplicationContext().getSystemService("clipboard")).setText(val$text);
            return;
        }
    }

    ()
    {
        this$0 = final_clipboardaction;
        val$label = s;
        val$text = String.this;
        super();
    }
}
