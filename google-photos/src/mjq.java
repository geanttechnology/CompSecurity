// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.nio.ByteBuffer;

public final class mjq
    implements ato
{

    private final mjz a;
    private final mjx b;

    public mjq()
    {
        this(null, null);
    }

    public mjq(mjz mjz, mjx mjx1)
    {
        a = mjz;
        b = mjx1;
    }

    public final atm a(Context context, atu atu1)
    {
        return new mjo(atu1.a(ata, java/nio/ByteBuffer), a, b);
    }

    public final void a()
    {
        if (b != null)
        {
            b.a(null);
        }
    }
}
