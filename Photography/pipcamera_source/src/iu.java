// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class iu extends FileOutputStream
{

    final it a;

    public iu(it it1, File file)
    {
        a = it1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        it.a(a, it.a(a) + j);
        it.a(a, new Integer[] {
            Integer.valueOf(it.a(a))
        });
    }
}
