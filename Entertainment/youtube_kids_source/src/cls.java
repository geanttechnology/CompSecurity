// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import java.util.UUID;

public final class cls extends arc
{

    public static final UUID k = new UUID(0xedef8ba979d64aceL, 0xa3c827dcd51d21edL);
    private final boolean l;

    public cls(boolean flag, Looper looper, arb arb, Handler handler, are are)
    {
        super(k, looper, arb, handler, are);
        l = flag;
    }

    public final boolean a(String s)
    {
        return l && super.a(s);
    }

}
