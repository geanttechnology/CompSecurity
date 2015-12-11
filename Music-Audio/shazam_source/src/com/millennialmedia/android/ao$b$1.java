// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.DialogInterface;

// Referenced classes of package com.millennialmedia.android:
//            ao

final class b
    implements android.content.nterface.OnClickListener
{

    final android.webkit.tionPermissions.Callback a;
    final String b;
    final back c;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        tener(c, false);
        a.invoke(b, false, false);
    }

    back(back back, android.webkit.tionPermissions.Callback callback, String s)
    {
        c = back;
        a = callback;
        b = s;
        super();
    }
}
