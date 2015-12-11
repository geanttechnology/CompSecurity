// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.web.MShopWebActivity;

// Referenced classes of package com.amazon.mShop.util:
//            Util, ActivityUtils

public class TextUtils
{

    public TextUtils()
    {
    }

    public static Spannable fromHtmlToSpannedUsingEmbeddedBrowser(String s, boolean flag)
    {
        Spanned spanned = Html.fromHtml(s);
        s = new SpannableStringBuilder(spanned);
        URLSpan aurlspan[] = (URLSpan[])s.getSpans(0, spanned.length(), android/text/style/URLSpan);
        int j = aurlspan.length;
        for (int i = 0; i < j; i++)
        {
            makeLinkClickable(s, aurlspan[i], flag);
        }

        return s;
    }

    public static boolean isTextExceedMaxWidth(String s, Paint paint, int i)
    {
        while (Util.isEmpty(s) || paint == null || i < 0 || paint.measureText(s) <= (float)i) 
        {
            return false;
        }
        return true;
    }

    private static void makeLinkClickable(SpannableStringBuilder spannablestringbuilder, URLSpan urlspan, boolean flag)
    {
        int i = spannablestringbuilder.getSpanStart(urlspan);
        int j = spannablestringbuilder.getSpanEnd(urlspan);
        int k = spannablestringbuilder.getSpanFlags(urlspan);
        Object obj = spannablestringbuilder.subSequence(i, j).toString();
        String s = urlspan.getURL();
        if (flag)
        {
            obj = new ClickableSpan(s) {

                final String val$url;

                public void onClick(View view)
                {
                    view = view.getContext();
                    view.startActivity(ActivityUtils.getStartWebActivityIntent(view, com/amazon/mShop/web/MShopWebActivity, url, -1));
                }

            
            {
                url = s;
                super();
            }
            };
        } else
        {
            obj = new ClickableSpan(s, ((String) (obj))) {

                final String val$title;
                final String val$url;

                public void onClick(View view)
                {
                    view = view.getContext();
                    if (view instanceof AmazonActivity)
                    {
                        view = (AmazonActivity)view;
                        view.pushView(new AmazonBrandedWebView(view, url, title, true));
                    }
                }

            
            {
                url = s;
                title = s1;
                super();
            }
            };
        }
        spannablestringbuilder.setSpan(obj, i, j, k);
        spannablestringbuilder.removeSpan(urlspan);
    }
}
