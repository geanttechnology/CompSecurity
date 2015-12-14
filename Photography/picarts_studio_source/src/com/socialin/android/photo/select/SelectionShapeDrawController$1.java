// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


// Referenced classes of package com.socialin.android.photo.select:
//            SelectionShapeDrawController

final class lectionShapeType
{

    static final int a[];

    static 
    {
        a = new int[lectionShapeType.values().length];
        try
        {
            a[lectionShapeType.RECTANGLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[lectionShapeType.CIRCLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
