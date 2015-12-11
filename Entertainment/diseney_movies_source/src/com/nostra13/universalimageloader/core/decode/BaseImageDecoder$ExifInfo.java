// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.decode;


// Referenced classes of package com.nostra13.universalimageloader.core.decode:
//            BaseImageDecoder

protected static class flipHorizontal
{

    final boolean flipHorizontal;
    final int rotation;

    ()
    {
        rotation = 0;
        flipHorizontal = false;
    }

    flipHorizontal(int i, boolean flag)
    {
        rotation = i;
        flipHorizontal = flag;
    }
}
