// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk.utils:
//            ImageCache, DrawableReadyListener

public class SpanImageFetcher
    implements android.text.Html.ImageGetter
{

    ViewGroup container;
    TextView textView;

    public SpanImageFetcher(ViewGroup viewgroup, TextView textview)
    {
        textView = textview;
        container = viewgroup;
    }

    private int dipsToPix(int i)
    {
        return (int)TypedValue.applyDimension(1, i, textView.getContext().getResources().getDisplayMetrics());
    }

    public Drawable getDrawable(String s)
    {
        final LevelListDrawable levelListDrawable = new LevelListDrawable();
        final Object tag = textView.getTag();
        android.view.ViewGroup.LayoutParams layoutparams = container.getLayoutParams();
        layoutparams.width = -1;
        container.setLayoutParams(layoutparams);
        layoutparams = textView.getLayoutParams();
        layoutparams.width = -1;
        textView.setLayoutParams(layoutparams);
        s = ImageCache.getImage(s, new DrawableReadyListener() {

            final SpanImageFetcher this$0;
            final LevelListDrawable val$levelListDrawable;
            final Object val$tag;

            public void onDrawableLoadFailed(String s1)
            {
            }

            public void onDrawableReady(String s1, Drawable drawable)
            {
                if (textView.getTag() == tag)
                {
                    int i = dipsToPix(drawable.getIntrinsicWidth());
                    int j = textView.getMeasuredWidth();
                    double d = (double)dipsToPix(drawable.getIntrinsicHeight()) / (double)i;
                    if (j < i)
                    {
                        i = j;
                    }
                    levelListDrawable.setBounds(0, 0, i, (int)Math.round((double)i * d));
                    levelListDrawable.addLevel(0, 0, drawable);
                    levelListDrawable.setLevel(0);
                    textView.append(" ");
                    textView.invalidate();
                }
            }

            
            {
                this$0 = SpanImageFetcher.this;
                tag = obj;
                levelListDrawable = levellistdrawable;
                super();
            }
        }, textView.getContext());
        if (s != null)
        {
            return s;
        } else
        {
            return levelListDrawable;
        }
    }

}
