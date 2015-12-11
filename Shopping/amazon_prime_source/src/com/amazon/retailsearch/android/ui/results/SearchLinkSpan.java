// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class SearchLinkSpan extends ClickableSpan
{

    private final Resources res;

    public SearchLinkSpan(Resources resources)
    {
        res = resources;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setUnderlineText(false);
        textpaint.setColor(res.getColor(com.amazon.retailsearch.R.color.rs_link_text));
    }
}
