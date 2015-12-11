// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.poshmark.application.PMApplication;

// Referenced classes of package com.poshmark.utils:
//            ViewUtils, TextClickListener

public class PMClickableSpan extends ClickableSpan
{

    String data;
    boolean isBold;
    TextClickListener nameClickListener;
    int textColor;
    Typeface typeface;

    public PMClickableSpan(String s, TextClickListener textclicklistener, int i, String s1, boolean flag)
    {
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
