// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Pair;

public final class cro extends Exception
    implements bmn
{

    public cro()
    {
    }

    public final Pair a(Context context)
    {
        return Pair.create(context.getString(0x7f0b00b9), "offlinePolicyError");
    }
}
