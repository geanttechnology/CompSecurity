// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifParser

private static class stripIndex
{

    int stripIndex;
    int type;

    (int i)
    {
        stripIndex = 0;
        type = i;
    }

    type(int i, int j)
    {
        type = i;
        stripIndex = j;
    }
}
