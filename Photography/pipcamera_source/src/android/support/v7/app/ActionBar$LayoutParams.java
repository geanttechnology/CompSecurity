// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class a extends android.view.arams
{

    public int a;

    public (int i, int j)
    {
        super(i, j);
        a = 0;
        a = 0x800013;
    }

    public a(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        context = context.obtainStyledAttributes(attributeset, android.support.v7.appcompat.yout);
        a = context.getInt(android.support.v7.appcompat.yout_android_layout_gravity, 0);
        context.recycle();
    }

    public ut_gravity(ut_gravity ut_gravity)
    {
        super(ut_gravity);
        a = 0;
        a = ut_gravity.a;
    }

    public a(android.view.outParams outparams)
    {
        super(outparams);
        a = 0;
    }
}
