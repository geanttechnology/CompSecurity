// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.google.a.a.f;
import com.target.mothership.util.o;
import com.target.ui.span.a;

// Referenced classes of package com.target.ui.util:
//            ah

public class SpannableStringUtils
{
    public static class CustomUrlSpan extends URLSpan
    {

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

        public CustomUrlSpan(String s, boolean flag, a a1)
        {
            super(s);
            drawUnderline = flag;
            fileUrlsClickListener = a1;
        }
    }

    public static interface CustomUrlSpan.a
    {

        public abstract void a(String s);
    }


    public static SpannableString a(String s, int i)
    {
        if (!o.g(s))
        {
            return null;
        } else
        {
            SpannableString spannablestring = new SpannableString(s);
            spannablestring.setSpan(new ForegroundColorSpan(i), 0, s.length(), 33);
            return spannablestring;
        }
    }

    public static SpannableStringBuilder a(Context context, SpannableStringBuilder spannablestringbuilder, String s, String s1)
    {
        if (spannablestringbuilder == null || s == null || s1 == null)
        {
            return null;
        } else
        {
            s = new StringBuilder(s);
            spannablestringbuilder.setSpan(new com.target.ui.span.a(com.target.ui.util.ah.a(context, ah.a.MEDIUM)), s.indexOf(s1), s.indexOf(s1) + s1.length(), 33);
            return spannablestringbuilder;
        }
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannablestringbuilder, String s, String s1, ClickableSpan clickablespan)
    {
        if (spannablestringbuilder == null || s == null || s1 == null)
        {
            return null;
        } else
        {
            s = new StringBuilder(s);
            spannablestringbuilder.setSpan(clickablespan, s.indexOf(s1), s.indexOf(s1) + s1.length(), 33);
            return spannablestringbuilder;
        }
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannablestringbuilder, String s, String s1, ForegroundColorSpan foregroundcolorspan)
    {
        if (spannablestringbuilder == null || s == null || s1 == null)
        {
            return null;
        } else
        {
            s = new StringBuilder(s);
            spannablestringbuilder.setSpan(foregroundcolorspan, s.indexOf(s1), s.indexOf(s1) + s1.length(), 33);
            return spannablestringbuilder;
        }
    }

    public static void a(Spannable spannable, CustomUrlSpan.a a1, boolean flag)
    {
        f.a(a1, "fileUrlsClickListener cannot be null!");
        URLSpan aurlspan[] = (URLSpan[])spannable.getSpans(0, spannable.length(), android/text/style/URLSpan);
        int j = aurlspan.length;
        for (int i = 0; i < j; i++)
        {
            URLSpan urlspan = aurlspan[i];
            int k = spannable.getSpanStart(urlspan);
            int l = spannable.getSpanEnd(urlspan);
            spannable.removeSpan(urlspan);
            spannable.setSpan(new CustomUrlSpan(urlspan.getURL(), flag, a1), k, l, 0);
        }

    }
}
