// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.widget.PopupWindow;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

class this._cls0
    implements Runnable
{

    final AppCompatDelegateImplV7 this$0;

    public void run()
    {
        mActionModePopup.showAtLocation(mActionModeView, 55, 0, 0);
        AppCompatDelegateImplV7.access$400(AppCompatDelegateImplV7.this);
        bi.c(mActionModeView, 0.0F);
        mFadeAnim = bi.q(mActionModeView).a(1.0F);
        class _cls1 extends dl
        {

            final AppCompatDelegateImplV7._cls4 this$1;

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

            _cls1()
            {
                this$1 = AppCompatDelegateImplV7._cls4.this;
                super();
            }
        }

        mFadeAnim.a(new _cls1());
    }

    _cls1()
    {
        this$0 = AppCompatDelegateImplV7.this;
        super();
    }
}
