// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import com.f.a.c.d;
import com.f.a.f;
import java.lang.ref.WeakReference;

// Referenced classes of package com.target.ui.view.common:
//            h

protected class this._cls0 extends d
{

    final h this$0;

    public void a(f f1)
    {
        h.a(h.this);
        if (mViewReference == null || h.b(h.this))
        {
            return;
        } else
        {
            h.a(h.this, (View)mViewReference.get(), f1.getHeight());
            return;
        }
    }

    public void d(f f1)
    {
        h.c(h.this);
        if (mViewReference == null || com.target.ui.view.common.h.d(h.this) > 0)
        {
            return;
        } else
        {
            h.b(h.this, (View)mViewReference.get(), f1.getHeight());
            return;
        }
    }

    protected ()
    {
        this$0 = h.this;
        super();
    }
}
