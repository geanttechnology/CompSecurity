// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.os.Parcel;
import android.support.v4.b.c;

final class j
    implements c
{

    j()
    {
    }

    public final Object a(Parcel parcel, ClassLoader classloader)
    {
        return new VerticalViewPager.SavedState(parcel, classloader);
    }

    public final volatile Object[] a(int i)
    {
        return new VerticalViewPager.SavedState[i];
    }
}
