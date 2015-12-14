// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, MMLog

class b
    implements Runnable
{

    private Context a;
    private String b;

    public void run()
    {
        try
        {
            Toast.makeText(a, (new StringBuilder("Error: ")).append(b).toString(), 1).show();
            return;
        }
        catch (android.view.r.BadTokenException badtokenexception)
        {
            MMLog.a("HandShake", "Error with toast token", badtokenexception);
        }
    }

    tion(Context context, String s)
    {
        a = context;
        b = s;
        super();
    }
}
