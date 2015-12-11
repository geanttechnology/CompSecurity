// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.view.ViewTreeObserver;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDWebView

class this._cls0
    implements android.view.r.OnGlobalLayoutListener
{

    final MRAIDWebView this$0;

    public void onGlobalLayout()
    {
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
        MRAIDWebView.access$802(MRAIDWebView.this, true);
        MRAIDWebView.access$700(MRAIDWebView.this);
    }

    er()
    {
        this$0 = MRAIDWebView.this;
        super();
    }
}
