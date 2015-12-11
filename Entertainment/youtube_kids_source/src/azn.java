// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.ig;

final class azn
    implements Runnable
{

    private ig a;
    private azk b;

    azn(azk azk1, ig ig)
    {
        b = azk1;
        a = ig;
        super();
    }

    public final void run()
    {
        azh.a(b.b, a);
    }
}
