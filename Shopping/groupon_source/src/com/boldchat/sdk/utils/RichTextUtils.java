// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.widget.TextView;

public class RichTextUtils
{
    public static interface SpanConverter
    {

        public abstract CharacterStyle convert(CharacterStyle characterstyle);
    }


    public static Spannable replaceAll(Spanned spanned, Class class1, SpanConverter spanconverter)
    {
        return replaceAll(spanned, class1, spanconverter, null);
    }

    public static Spannable replaceAll(Spanned spanned, Class class1, SpanConverter spanconverter, TextView textview)
    {
        spanned = new SpannableString(spanned);
        class1 = (CharacterStyle[])spanned.getSpans(0, spanned.length(), class1);
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            CharacterStyle characterstyle = class1[i];
            int k = spanned.getSpanStart(characterstyle);
            int l = spanned.getSpanEnd(characterstyle);
            int i1 = spanned.getSpanFlags(characterstyle);
            spanned.removeSpan(characterstyle);
            spanned.setSpan(spanconverter.convert(characterstyle), k, l, i1);
        }

        if (textview != null)
        {
            textview.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return spanned;
    }
}
