// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.AttributeSet;

public final class kv extends kw
{

    public boolean a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    public kv(int i, int j)
    {
        super(-2, -2);
        a = false;
    }

    public kv(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public kv(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
    }

    public kv(kv kv1)
    {
        super(kv1);
        a = kv1.a;
    }
}
