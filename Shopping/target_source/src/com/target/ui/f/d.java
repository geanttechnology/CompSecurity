// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.f;

import android.content.Context;
import android.view.View;
import com.google.a.a.e;
import com.target.ui.fragment.common.BaseNavigationFragment;

// Referenced classes of package com.target.ui.f:
//            f

public class d
{

    private final Context mContext;
    private final BaseNavigationFragment mCurrentFragment;
    private f mCurrentFragmentTransitionListenerHolder;
    private f mTargetFragmentTransitionListenerHolder;
    private final String mTransitionTag;
    private String mTransitionThumbnailUrl;
    private final View mTransitionView;

    public d(Context context, BaseNavigationFragment basenavigationfragment, View view, String s)
    {
        mContext = context;
        mCurrentFragment = basenavigationfragment;
        mTransitionView = view;
        mTransitionTag = s;
        mTransitionView.setTransitionName(s);
    }

    public void a(f f1)
    {
        mCurrentFragmentTransitionListenerHolder = f1;
    }

    public void a(String s)
    {
        mTransitionThumbnailUrl = s;
    }

    public View b()
    {
        return mTransitionView;
    }

    public void b(f f1)
    {
        mTargetFragmentTransitionListenerHolder = f1;
    }

    public String c()
    {
        return mTransitionTag;
    }

    public Context d()
    {
        return mContext;
    }

    public BaseNavigationFragment e()
    {
        return mCurrentFragment;
    }

    public e f()
    {
        return com.google.a.a.e.c(mCurrentFragmentTransitionListenerHolder);
    }

    public e g()
    {
        return com.google.a.a.e.c(mTargetFragmentTransitionListenerHolder);
    }

    public String h()
    {
        return mTransitionThumbnailUrl;
    }
}
