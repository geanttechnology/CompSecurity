// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

class bye
    implements Runnable
{

    final Uri a;
    final byd b;

    bye(byd byd1, Uri uri)
    {
        b = byd1;
        a = uri;
        super();
    }

    public void run()
    {
        byc.a(b.a).a(a);
    }
}
