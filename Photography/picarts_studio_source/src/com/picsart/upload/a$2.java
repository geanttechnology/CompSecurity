// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;


// Referenced classes of package com.picsart.upload:
//            a

final class ror
{

    static final int a[];

    static 
    {
        a = new int[com.socialin.android.util.Utils.ImageFileFormat.values().length];
        try
        {
            a[com.socialin.android.util.Utils.ImageFileFormat.PNG.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.socialin.android.util.Utils.ImageFileFormat.JPEG.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.socialin.android.util.Utils.ImageFileFormat.GIF.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
