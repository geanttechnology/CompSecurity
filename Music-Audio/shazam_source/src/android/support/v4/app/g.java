// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.app:
//            af, Fragment, k

public abstract class g extends af
{

    public g(k k)
    {
        super(k);
    }

    public final Object a(ViewGroup viewgroup, int i)
    {
        viewgroup = (Fragment)super.a(viewgroup, i);
        Bundle bundle = ((Fragment) (viewgroup)).n;
        if (bundle != null)
        {
            bundle.setClassLoader(viewgroup.getClass().getClassLoader());
        }
        return viewgroup;
    }
}
