// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.view.View;
import android.webkit.WebChromeClient;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDCustomViewBackgroundView

class this._cls0
    implements android.view.mViewBackgroundView._cls1
{

    final MRAIDCustomViewBackgroundView this$0;

    public void onClick(View view)
    {
        MRAIDCustomViewBackgroundView.access$000(MRAIDCustomViewBackgroundView.this).debug("onClick");
        MRAIDCustomViewBackgroundView.access$100(MRAIDCustomViewBackgroundView.this).onHideCustomView();
    }

    ()
    {
        this$0 = MRAIDCustomViewBackgroundView.this;
        super();
    }
}
