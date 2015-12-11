// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            a

public class j extends a
{

    private float mDeltaY;
    private float mOriginalY;

    public j(RecyclerView recyclerview)
    {
        super(recyclerview);
    }

    static float a(j j1)
    {
        return j1.mDeltaY;
    }

    private void s(android.support.v7.widget.RecyclerView.t t)
    {
        mOriginalY = mRecyclerView.getLayoutManager().h(t.itemView);
        mDeltaY = (float)mRecyclerView.getHeight() - mOriginalY;
    }

    public boolean a(android.support.v7.widget.RecyclerView.t t, android.support.v7.widget.RecyclerView.t t1, int i, int k, int l, int i1)
    {
        return false;
    }

    protected void p(android.support.v7.widget.RecyclerView.t t)
    {
        s(t);
        ai.b(t.itemView, mDeltaY);
    }

    protected void q(final android.support.v7.widget.RecyclerView.t holder)
    {
        View view = holder.itemView;
        ai.s(view).a();
        ai.s(view).c(0.0F).a(e()).a(new a.b() {

            final j this$0;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void b(View view1)
            {
                f(holder);
                mAddAnimations.remove(holder);
                j.this.j();
            }

            public void c(View view1)
            {
                ai.b(view1, 0.0F);
            }

            
            {
                this$0 = j.this;
                holder = t;
                super();
            }
        }).b();
        mAddAnimations.add(holder);
    }

    protected void r(final android.support.v7.widget.RecyclerView.t holder)
    {
        View view = holder.itemView;
        ai.s(view).a();
        ai.s(view).a(f()).c(mDeltaY).a(new a.b() {

            final j this$0;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void b(View view1)
            {
                ai.b(view1, j.a(j.this));
                d(holder);
                mRemoveAnimations.remove(holder);
                j.this.j();
            }

            
            {
                this$0 = j.this;
                holder = t;
                super();
            }
        }).b();
        mRemoveAnimations.add(holder);
    }
}
