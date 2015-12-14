// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;


// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            TitlePageIndicator

final class dicatorStyle
{

    static final int a[];

    static 
    {
        a = new int[dicatorStyle.values().length];
        try
        {
            a[dicatorStyle.Triangle.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[dicatorStyle.Underline.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[dicatorStyle.Line.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
