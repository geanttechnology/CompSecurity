// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import df;

// Referenced classes of package android.support.v7.internal.widget:
//            ContentFrameLayout

public class NativeActionModeAwareLayout extends ContentFrameLayout
{

    private df mActionModeForChildListener;

    public NativeActionModeAwareLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void setActionModeForChildListener(df df1)
    {
        mActionModeForChildListener = df1;
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback)
    {
        if (mActionModeForChildListener != null)
        {
            return mActionModeForChildListener.a(view, callback);
        } else
        {
            return super.startActionModeForChild(view, callback);
        }
    }
}
