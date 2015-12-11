// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.support.v4.view.dl;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

class this._cls1 extends dl
{

    final View.setVisibility this$1;

    public void onAnimationEnd(View view)
    {
        bi.c(mActionModeView, 1.0F);
        mFadeAnim.a(null);
        mFadeAnim = null;
    }

    public void onAnimationStart(View view)
    {
        mActionModeView.setVisibility(0);
    }

    View()
    {
        this$1 = this._cls1.this;
        super();
    }
}
