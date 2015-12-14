// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


// Referenced classes of package com.socialin.android.photo.select:
//            SelectionDrawController

final class AW_MODE
{

    static final int a[];

    static 
    {
        a = new int[AW_MODE.values().length];
        try
        {
            a[AW_MODE.FREE_CROP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[AW_MODE.LASSO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[AW_MODE.SHAPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[AW_MODE.ADD_DRAWABLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
