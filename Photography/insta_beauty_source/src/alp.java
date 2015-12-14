// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class alp extends FileOutputStream
{

    final alm a;

    public alp(alm alm1, File file)
    {
        a = alm1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        alm.a(a, alm.a(a) + j);
        alm.a(a, new Integer[] {
            Integer.valueOf(alm.a(a))
        });
    }
}
