// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.target.ui.util.n;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistryLandingPageFragment

class this._cls0 extends ClickableSpan
{

    final RegistryLandingPageFragment this$0;

    public void onClick(View view)
    {
        n.a(getActivity(), Uri.parse("http://www.target.com/gift-registry/"), null);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    ()
    {
        this$0 = RegistryLandingPageFragment.this;
        super();
    }
}
