// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class nk extends bmr
{

    private nd a;

    nk(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        java.io.File file = null;
        if (a.e(a.a))
        {
            file = a.a.getExternalFilesDir(null);
        }
        return file;
    }
}
