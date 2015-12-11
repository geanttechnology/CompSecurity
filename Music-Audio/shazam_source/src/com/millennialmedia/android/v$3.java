// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.millennialmedia.android:
//            v, al

final class b
    implements Runnable
{

    final Context a;
    final String b;
    final v c;

    public final void run()
    {
        try
        {
            Toast.makeText(a, (new StringBuilder("Error: ")).append(b).toString(), 1).show();
            return;
        }
        catch (android.view.owManager.BadTokenException badtokenexception)
        {
            al.a("HandShake", "Error with toast token", badtokenexception);
        }
    }

    kenException(v v1, Context context, String s)
    {
        c = v1;
        a = context;
        b = s;
        super();
    }
}
