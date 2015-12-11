// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class val.message
    implements Runnable
{

    final val.message this$1;
    final Context val$context;
    final String val$message;
    final String val$title;

    public void run()
    {
        (new android.app.veBridge._cls6(val$context)).context(val$title).title(val$message).message(0x104000a, null).message();
    }

    ()
    {
        this$1 = final_;
        val$context = context1;
        val$title = s;
        val$message = String.this;
        super();
    }
}
