// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.poshmark.application.PMApplication;
import com.poshmark.utils.TextClickListener;
import com.poshmark.utils.ViewUtils;

public class PMUrlSpan extends URLSpan
{

    String data;
    boolean isBold;
    TextClickListener nameClickListener;
    int textColor;
    Typeface typeface;

    public PMUrlSpan(String s, TextClickListener textclicklistener, int i, String s1, boolean flag)
    {
        super(s);
        data = s;
        nameClickListener = textclicklistener;
        textColor = i;
        typeface = ViewUtils.getTypefaceFromName(PMApplication.getContext(), s1);
        isBold = flag;
    }

    public void onClick(View view)
    {
        nameClickListener.onClick(data);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(textColor);
        textpaint.setUnderlineText(false);
        textpaint.setFakeBoldText(isBold);
    }
}
