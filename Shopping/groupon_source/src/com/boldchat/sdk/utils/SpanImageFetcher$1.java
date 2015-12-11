// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk.utils:
//            DrawableReadyListener, SpanImageFetcher

class e
    implements DrawableReadyListener
{

    final SpanImageFetcher this$0;
    final LevelListDrawable val$levelListDrawable;
    final Object val$tag;

    public void onDrawableLoadFailed(String s)
    {
    }

    public void onDrawableReady(String s, Drawable drawable)
    {
        if (textView.getTag() == val$tag)
        {
            int i = SpanImageFetcher.access$000(SpanImageFetcher.this, drawable.getIntrinsicWidth());
            int j = textView.getMeasuredWidth();
            double d = (double)SpanImageFetcher.access$000(SpanImageFetcher.this, drawable.getIntrinsicHeight()) / (double)i;
            if (j < i)
            {
                i = j;
            }
            val$levelListDrawable.setBounds(0, 0, i, (int)Math.round((double)i * d));
            val$levelListDrawable.addLevel(0, 0, drawable);
            val$levelListDrawable.setLevel(0);
            textView.append(" ");
            textView.invalidate();
        }
    }

    e()
    {
        this$0 = final_spanimagefetcher;
        val$tag = obj;
        val$levelListDrawable = LevelListDrawable.this;
        super();
    }
}
