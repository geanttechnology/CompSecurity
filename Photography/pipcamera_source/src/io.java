// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

final class io extends FileOutputStream
{

    final im a;

    public io(im im1, File file)
    {
        a = im1;
        super(file);
    }

    public void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
        im.a(a, im.a(a) + j);
        im.a(a, new Integer[] {
            Integer.valueOf(im.a(a))
        });
    }
}
