// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

// Referenced classes of package com.target.ui.util:
//            SpannableStringUtils

public static class fileUrlsClickListener extends URLSpan
{
    public static interface a
    {

        public abstract void a(String s);
    }


    private final boolean drawUnderline;
    private final a fileUrlsClickListener;

    public void onClick(View view)
    {
        String s = getURL();
        if (s != null && s.startsWith("file:"))
        {
            fileUrlsClickListener.a(s);
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setUnderlineText(drawUnderline);
    }

    public a(String s, boolean flag, a a1)
    {
        super(s);
        drawUnderline = flag;
        fileUrlsClickListener = a1;
    }
}
