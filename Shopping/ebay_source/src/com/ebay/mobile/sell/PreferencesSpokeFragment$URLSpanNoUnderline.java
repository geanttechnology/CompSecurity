// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.text.TextPaint;
import android.text.style.URLSpan;

// Referenced classes of package com.ebay.mobile.sell:
//            PreferencesSpokeFragment

private class this._cls0 extends URLSpan
{

    final PreferencesSpokeFragment this$0;

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setUnderlineText(false);
    }

    public (String s)
    {
        this$0 = PreferencesSpokeFragment.this;
        super(s);
    }
}
