// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;


// Referenced classes of package com.socialin.android.photo.collage:
//            ShapeCropHelper

final class tion
{

    static final int a[];

    static 
    {
        a = new int[tion.values().length];
        try
        {
            a[tion.DRAG.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[tion.HANDLE_ZOOM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
