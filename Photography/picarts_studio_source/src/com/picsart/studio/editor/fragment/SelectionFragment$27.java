// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class r.FILL_TYPE
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[com.socialin.android.photo.select.er.DRAW_MODE.values().length];
        try
        {
            b[com.socialin.android.photo.select.er.DRAW_MODE.FREE_CROP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[com.socialin.android.photo.select.er.DRAW_MODE.LASSO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[com.socialin.android.photo.select.er.DRAW_MODE.SHAPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        a = new int[com.socialin.android.photo.select.er.FILL_TYPE.values().length];
        try
        {
            a[com.socialin.android.photo.select.er.FILL_TYPE.ADD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.socialin.android.photo.select.er.FILL_TYPE.CLEAR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.socialin.android.photo.select.er.FILL_TYPE.DEFAULT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
