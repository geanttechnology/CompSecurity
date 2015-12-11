// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.layout_manager;

import android.support.v7.widget.x;
import android.view.View;

// Referenced classes of package com.target.ui.layout_manager:
//            BaseLayoutManager

class this._cls0
{

    int mCoordinate;
    boolean mLayoutFromEnd;
    int mPosition;
    final BaseLayoutManager this$0;

    void a()
    {
        mPosition = -1;
        mCoordinate = 0x80000000;
        mLayoutFromEnd = false;
    }

    public void a(View view)
    {
        if (mLayoutFromEnd)
        {
            mCoordinate = mOrientationHelper.b(view) + mOrientationHelper.b();
        } else
        {
            mCoordinate = mOrientationHelper.a(view);
        }
        mPosition = d(view);
    }

    public boolean a(View view, android.support.v7.widget..a a1)
    {
        android.support.v7.widget..a a2 = (android.support.v7.widget..a)view.getLayoutParams();
        if (!a2.a() && a2.a() >= 0 && a2.a() < a1.a())
        {
            a(view);
            return true;
        } else
        {
            return false;
        }
    }

    void b()
    {
        int i;
        if (mLayoutFromEnd)
        {
            i = mOrientationHelper.d();
        } else
        {
            i = mOrientationHelper.c();
        }
        mCoordinate = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AnchorInfo{mPosition=").append(mPosition).append(", mCoordinate=").append(mCoordinate).append(", mLayoutFromEnd=").append(mLayoutFromEnd).append('}').toString();
    }

    ()
    {
        this$0 = BaseLayoutManager.this;
        super();
    }
}
