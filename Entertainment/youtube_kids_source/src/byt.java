// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Pair;

public final class byt extends Exception
    implements bmn
{

    public byt(Throwable throwable)
    {
        super(throwable);
    }

    public final Pair a(Context context)
    {
        return Pair.create(context.getString(0x7f0b00ad), "deviceRegistration");
    }
}
