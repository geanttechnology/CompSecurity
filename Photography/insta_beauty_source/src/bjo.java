// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.activity.photoselector.PhotoSelectScrollView;

public class bjo
    implements Runnable
{

    final PhotoSelectScrollView a;

    public bjo(PhotoSelectScrollView photoselectscrollview)
    {
        a = photoselectscrollview;
        super();
    }

    public void run()
    {
        a.scroolToLast();
    }
}
