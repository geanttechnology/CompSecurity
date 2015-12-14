// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class sj extends FileOutputStream
{

    final sh a;

    public sj(sh sh1, File file)
    {
        a = sh1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        sh.a(a, sh.a(a) + j);
        sh.a(a, new Integer[] {
            Integer.valueOf(sh.a(a))
        });
    }
}
