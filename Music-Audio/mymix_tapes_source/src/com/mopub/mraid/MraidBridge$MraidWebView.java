// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.BaseWebView;

// Referenced classes of package com.mopub.mraid:
//            MraidBridge

public static class mIsVisible extends BaseWebView
{
    public static interface OnVisibilityChangedListener
    {

        public abstract void onVisibilityChanged(boolean flag);
    }


    private boolean mIsVisible;
    private OnVisibilityChangedListener mOnVisibilityChangedListener;

    public boolean isVisible()
    {
        return mIsVisible;
    }

    protected void onVisibilityChanged(View view, int i)
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
        if (flag != mIsVisible)
        {
            mIsVisible = flag;
            if (mOnVisibilityChangedListener != null)
            {
                mOnVisibilityChangedListener.onVisibilityChanged(mIsVisible);
            }
        }
    }

    void setVisibilityChangedListener(OnVisibilityChangedListener onvisibilitychangedlistener)
    {
        mOnVisibilityChangedListener = onvisibilitychangedlistener;
    }

    public OnVisibilityChangedListener(Context context)
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
        mIsVisible = flag;
    }
}
