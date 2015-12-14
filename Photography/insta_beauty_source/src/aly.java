// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class aly extends FileOutputStream
{

    final alw a;

    public aly(alw alw1, File file)
    {
        a = alw1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        alw.a(a, alw.a(a) + j);
        alw.a(a, new Integer[] {
            Integer.valueOf(alw.a(a))
        });
    }
}
