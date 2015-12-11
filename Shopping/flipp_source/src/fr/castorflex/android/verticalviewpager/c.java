// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;


// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            VerticalViewPager

final class c
    implements Runnable
{

    final VerticalViewPager a;

    c(VerticalViewPager verticalviewpager)
    {
        a = verticalviewpager;
        super();
    }

    public final void run()
    {
        VerticalViewPager.a(a);
        a.b();
    }
}
