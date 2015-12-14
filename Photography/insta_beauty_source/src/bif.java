// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class bif extends FileOutputStream
{

    final bic a;

    public bif(bic bic1, File file)
    {
        a = bic1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        bic.a(a, bic.a(a) + j);
        bic.a(a, new Integer[] {
            Integer.valueOf(bic.a(a))
        });
    }
}
