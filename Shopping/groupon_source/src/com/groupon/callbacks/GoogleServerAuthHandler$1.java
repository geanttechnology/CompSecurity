// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import android.widget.Toast;
import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.callbacks:
//            GoogleServerAuthHandler

class this._cls0
    implements Runnable
{

    final GoogleServerAuthHandler this$0;

    public void run()
    {
        Toast.makeText((Context)GoogleServerAuthHandler.access$000(GoogleServerAuthHandler.this).get(), 0x7f080215, 0).show();
    }

    ()
    {
        this$0 = GoogleServerAuthHandler.this;
        super();
    }
}
