// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.widget.Toast;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatFormView

class val.message
    implements Runnable
{

    final val.message this$1;
    final String val$message;

    public void run()
    {
        Toast.makeText(BoldChatFormView.access$500(_fld0), val$message, 0).show();
    }

    _cls9()
    {
        this$1 = final__pcls9;
        val$message = String.this;
        super();
    }
}
