// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

final class cqa
    implements Runnable
{

    private mj a;
    private Uri b;

    cqa(cpz cpz, mj mj1, Uri uri)
    {
        a = mj1;
        b = uri;
        super();
    }

    public final void run()
    {
        mj mj1 = a;
        String s = String.valueOf(b);
        mj1.a(new md((new StringBuilder(String.valueOf(s).length() + 12)).append("Invalid URI ").append(s).toString()));
    }
}
