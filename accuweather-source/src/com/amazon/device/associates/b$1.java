// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.associates;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.associates:
//            b, ay

class a
    implements Runnable
{

    final Intent a;
    final b b;

    public void run()
    {
        com.amazon.device.associates.b.a(b).b().startActivity(a);
    }

    (b b1, Intent intent)
    {
        b = b1;
        a = intent;
        super();
    }
}
