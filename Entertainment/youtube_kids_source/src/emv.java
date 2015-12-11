// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class emv extends emj
{

    private final File a;
    private final eiu b;

    public transient emv(File file, emu aemu[])
    {
        a = (File)f.b(file);
        b = eiu.a(aemu);
    }

    public final OutputStream a()
    {
        return new FileOutputStream(a, b.contains(emu.a));
    }

    public final String toString()
    {
        return (new StringBuilder("Files.asByteSink(")).append(a).append(", ").append(b).append(")").toString();
    }
}
