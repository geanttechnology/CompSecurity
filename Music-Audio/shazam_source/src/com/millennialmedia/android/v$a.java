// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            v

private final class b
{

    long a;
    long b;
    boolean c;
    final v d;

    final void a(android.content.edPreferences.Editor editor, String s)
    {
        editor.putLong((new StringBuilder("handshake_lastvideo_")).append(s).toString(), a);
        editor.putLong((new StringBuilder("handshake_videointerval_")).append(s).toString(), b);
    }

    s.Editor(v v1)
    {
        d = v1;
        super();
        a = 0L;
        b = 0L;
    }
}
