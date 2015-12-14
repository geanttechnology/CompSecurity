// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.tgifview;


// Referenced classes of package com.fotoable.tgifview:
//            TGifView

class fImageType
{

    static final int a[];

    static 
    {
        a = new int[fImageType.values().length];
        try
        {
            a[fImageType.WAIT_FINISH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[fImageType.COVER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[fImageType.SYNC_DECODER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
