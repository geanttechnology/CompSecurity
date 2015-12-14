// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.content.DialogInterface;
import com.tencent.tauth.b;

// Referenced classes of package com.tencent.connect.b:
//            b

class b
    implements android.content.ogInterface.OnCancelListener
{

    final b a;
    final Object b;
    final com.tencent.connect.b.b c;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (a != null)
        {
            a.a(b);
        }
    }

    rface(com.tencent.connect.b.b b1, b b2, Object obj)
    {
        c = b1;
        a = b2;
        b = obj;
        super();
    }
}
