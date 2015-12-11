// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.c.a;
import android.util.SparseArray;

// Referenced classes of package android.support.v7.widget:
//            bi

public final class bf
{

    int a;
    a b;
    a c;
    a d;
    int e;
    int f;
    int g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    private SparseArray l;

    public bf()
    {
        a = -1;
        b = new a();
        c = new a();
        d = new a();
        e = 0;
        f = 0;
        g = 0;
        h = false;
        i = false;
        j = false;
        k = false;
    }

    public final int a()
    {
        if (i)
        {
            return f - g;
        } else
        {
            return e;
        }
    }

    public final void a(bi bi)
    {
        b.remove(bi);
        c.remove(bi);
        if (d == null) goto _L2; else goto _L1
_L1:
        a a1;
        int i1;
        a1 = d;
        i1 = a1.size() - 1;
_L7:
        if (i1 < 0) goto _L2; else goto _L3
_L3:
        if (bi != a1.c(i1)) goto _L5; else goto _L4
_L4:
        a1.d(i1);
_L2:
        return;
_L5:
        i1--;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final String toString()
    {
        return (new StringBuilder("State{mTargetPosition=")).append(a).append(", mPreLayoutHolderMap=").append(b).append(", mPostLayoutHolderMap=").append(c).append(", mData=").append(l).append(", mItemCount=").append(e).append(", mPreviousLayoutItemCount=").append(f).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(g).append(", mStructureChanged=").append(h).append(", mInPreLayout=").append(i).append(", mRunSimpleAnimations=").append(j).append(", mRunPredictiveAnimations=").append(k).append('}').toString();
    }
}
