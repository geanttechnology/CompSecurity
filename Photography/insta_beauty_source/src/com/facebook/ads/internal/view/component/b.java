// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.i;
import com.facebook.ads.internal.view.k;

// Referenced classes of package com.facebook.ads.internal.view.component:
//            c, a

public class b extends LinearLayout
{

    private ImageView a;
    private a b;
    private TextView c;
    private LinearLayout d;

    public b(Context context, NativeAd nativead, NativeAdViewAttributes nativeadviewattributes, boolean flag, int j)
    {
        super(context);
        Object obj = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        context = new LinearLayout(getContext());
        context.setOrientation(1);
        context.setGravity(16);
        Object obj1 = new android.widget.LinearLayout.LayoutParams(-1, -1);
        ((android.widget.LinearLayout.LayoutParams) (obj1)).setMargins(Math.round(15F * ((DisplayMetrics) (obj)).density), Math.round(15F * ((DisplayMetrics) (obj)).density), Math.round(15F * ((DisplayMetrics) (obj)).density), Math.round(15F * ((DisplayMetrics) (obj)).density));
        context.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        addView(context);
        d = new LinearLayout(getContext());
        obj1 = new android.widget.LinearLayout.LayoutParams(-1, 0);
        d.setOrientation(0);
        d.setGravity(16);
        obj1.weight = 3F;
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        context.addView(d);
        a = new c(getContext());
        j = a(flag, j);
        obj1 = new android.widget.LinearLayout.LayoutParams(Math.round((float)j * ((DisplayMetrics) (obj)).density), Math.round((float)j * ((DisplayMetrics) (obj)).density));
        ((android.widget.LinearLayout.LayoutParams) (obj1)).setMargins(0, 0, Math.round(15F * ((DisplayMetrics) (obj)).density), 0);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        NativeAd.downloadAndDisplayImage(nativead.getAdIcon(), a);
        d.addView(a);
        obj1 = new LinearLayout(getContext());
        ((LinearLayout) (obj1)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        ((LinearLayout) (obj1)).setOrientation(0);
        ((LinearLayout) (obj1)).setGravity(16);
        d.addView(((android.view.View) (obj1)));
        b = new a(getContext(), nativead, nativeadviewattributes);
        Object obj2 = new android.widget.LinearLayout.LayoutParams(-2, -1);
        ((android.widget.LinearLayout.LayoutParams) (obj2)).setMargins(0, 0, Math.round(15F * ((DisplayMetrics) (obj)).density), 0);
        obj2.weight = 0.5F;
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((LinearLayout) (obj1)).addView(b);
        c = new TextView(getContext());
        c.setPadding(Math.round(6F * ((DisplayMetrics) (obj)).density), Math.round(6F * ((DisplayMetrics) (obj)).density), Math.round(6F * ((DisplayMetrics) (obj)).density), Math.round(6F * ((DisplayMetrics) (obj)).density));
        c.setText(nativead.getAdCallToAction());
        c.setTextColor(nativeadviewattributes.getButtonTextColor());
        c.setTextSize(14F);
        c.setTypeface(nativeadviewattributes.getTypeface(), 1);
        c.setMaxLines(2);
        c.setEllipsize(android.text.TextUtils.TruncateAt.END);
        c.setGravity(17);
        obj2 = new GradientDrawable();
        ((GradientDrawable) (obj2)).setColor(nativeadviewattributes.getButtonColor());
        ((GradientDrawable) (obj2)).setCornerRadius(((DisplayMetrics) (obj)).density * 5F);
        ((GradientDrawable) (obj2)).setStroke(1, nativeadviewattributes.getButtonBorderColor());
        c.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj2)));
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.weight = 0.25F;
        c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((LinearLayout) (obj1)).addView(c);
        if (flag)
        {
            k k1 = new k(getContext());
            k1.setText(nativead.getAdBody());
            i.b(k1, nativeadviewattributes);
            k1.setMinTextSize(nativeadviewattributes.getDescriptionTextSize() - 1);
            nativead = new android.widget.LinearLayout.LayoutParams(-1, 0);
            nativead.weight = 1.0F;
            k1.setLayoutParams(nativead);
            k1.setGravity(80);
            context.addView(k1);
        }
    }

    private int a(boolean flag, int j)
    {
        double d1;
        int l;
        if (flag)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        d1 = 3D / (double)(l + 3);
        return (int)((double)(j - 30) * d1);
    }

    public TextView getCallToActionView()
    {
        return c;
    }

    public ImageView getIconView()
    {
        return a;
    }

    protected void onMeasure(int j, int l)
    {
        super.onMeasure(j, l);
        TextView textview = b.getTitleTextView();
        if (textview.getLayout().getLineEnd(textview.getLineCount() - 1) < b.getMinVisibleTitleCharacters())
        {
            d.removeView(a);
            super.onMeasure(j, l);
        }
    }
}
