// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.il;

final class azm
    implements Runnable
{

    private il a;
    private azk b;

    azm(azk azk1, il il)
    {
        b = azk1;
        a = il;
        super();
    }

    public final void run()
    {
        azh.a(b.b, a);
    }
}
