// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.j;

// Referenced classes of package com.mopub.b:
//            a

public static final class a extends j
{
    public static interface a
    {

        public abstract void a(boolean flag);
    }


    boolean a;
    private a c;

    protected final void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != a)
        {
            a = flag;
            if (c != null)
            {
                c.a(a);
            }
        }
    }

    final void setVisibilityChangedListener(a a1)
    {
        c = a1;
    }

    public Context(Context context)
    {
        super(context);
        boolean flag;
        if (getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
