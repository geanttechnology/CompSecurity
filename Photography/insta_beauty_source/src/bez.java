// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class bez extends FileOutputStream
{

    final bex a;

    public bez(bex bex1, File file)
    {
        a = bex1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        bex.a(a, bex.a(a) + j);
        bex.a(a, new Integer[] {
            Integer.valueOf(bex.a(a))
        });
    }
}
