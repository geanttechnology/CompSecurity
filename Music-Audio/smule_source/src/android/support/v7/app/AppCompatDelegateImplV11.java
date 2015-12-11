// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7, AppCompatCallback

class AppCompatDelegateImplV11 extends AppCompatDelegateImplV7
    implements android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener
{

    private NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    AppCompatDelegateImplV11(Context context, Window window, AppCompatCallback appcompatcallback)
    {
        super(context, window, appcompatcallback);
    }

    View callActivityOnCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        View view1 = super.callActivityOnCreateView(view, s, context, attributeset);
        if (view1 != null)
        {
            return view1;
        }
        if (mOriginalWindowCallback instanceof android.view.LayoutInflater.Factory2)
        {
            return ((android.view.LayoutInflater.Factory2)mOriginalWindowCallback).onCreateView(view, s, context, attributeset);
        } else
        {
            return null;
        }
    }

    void onSubDecorInstalled(ViewGroup viewgroup)
    {
        mNativeActionModeAwareLayout = (NativeActionModeAwareLayout)viewgroup.findViewById(0x1020002);
        if (mNativeActionModeAwareLayout != null)
        {
            mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback)
    {
        view = startSupportActionMode(new android.support.v7.internal.view.SupportActionModeWrapper.CallbackWrapper(view.getContext(), callback));
        if (view != null)
        {
            return new SupportActionModeWrapper(mContext, view);
        } else
        {
            return null;
        }
    }
}
