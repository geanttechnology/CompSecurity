// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.Cursor;

final class biw
    implements bjc
{

    private Cursor a;
    private bjb b;

    biw(bjb bjb1, Cursor cursor)
    {
        b = bjb1;
        a = cursor;
        super();
    }

    public final void a()
    {
        if (!a.isClosed())
        {
            a.close();
        }
    }

    public final boolean hasNext()
    {
        if (!a.isClosed() && a.getCount() > 0 && !a.isLast())
        {
            return true;
        } else
        {
            a();
            return false;
        }
    }

    public final Object next()
    {
        a.moveToNext();
        return b.a(a.getBlob(0));
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
