// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

final class emr
    implements emt
{

    static final emr a = new emr();

    emr()
    {
    }

    public final void a(Closeable closeable, Throwable throwable, Throwable throwable1)
    {
        emp.a.log(Level.WARNING, (new StringBuilder("Suppressing exception thrown when closing ")).append(closeable).toString(), throwable1);
    }

}
