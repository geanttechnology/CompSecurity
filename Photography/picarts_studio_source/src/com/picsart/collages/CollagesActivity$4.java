// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.widget.Toast;

// Referenced classes of package com.picsart.collages:
//            CollagesActivity

final class a
    implements Runnable
{

    private CollagesActivity a;

    public final void run()
    {
        Toast.makeText(a, a.getString(0x7f0805af), 0).show();
    }

    (CollagesActivity collagesactivity)
    {
        a = collagesactivity;
        super();
    }
}
