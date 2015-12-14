// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifParser, ExifTag

private static class isRequested
{

    boolean isRequested;
    ExifTag tag;

    (ExifTag exiftag, boolean flag)
    {
        tag = exiftag;
        isRequested = flag;
    }
}
