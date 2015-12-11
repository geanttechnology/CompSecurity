// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ai;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.google.a.a.e;
import com.h.c.u;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.WeeklyAdInfo;
import com.target.ui.model.shop.a;
import com.target.ui.span.CenteringRelativeSizeSpan;
import com.target.ui.util.al;
import com.target.ui.util.y;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.view.shop:
//            BasePageItemView

public class PageItemView extends BasePageItemView
{
    static class Views extends com.target.ui.view.a
    {

        TextView displayText;
        View divider;
        BitmapImageView image;

        Views(View view)
        {
            super(view);
        }
    }


    public static final String IMAGE_LOADING_TAG = com/target/ui/view/shop/PageItemView.getSimpleName();
    private Views mViews;

    public PageItemView(Context context)
    {
        super(context);
        a(context);
    }

    public PageItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PageItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private Spannable a(String s)
    {
        s = new SpannableString(s);
        int i = s.length();
        s.setSpan(new StrikethroughSpan(), 0, i, 33);
        s.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0f00f6)), 0, i, 33);
        s.setSpan(new CenteringRelativeSizeSpan(0.8F), 0, i, 34);
        return s;
    }

    private ImageInfo a(PageItem pageitem)
    {
        if (pageitem == null)
        {
            return null;
        }
        if (pageitem.k().b() && ((WeeklyAdInfo)pageitem.k().c()).a().b())
        {
            pageitem = (ImageInfo)((WeeklyAdInfo)pageitem.k().c()).a().c();
        } else
        if (pageitem.h().b())
        {
            pageitem = (ImageInfo)pageitem.h().c();
        } else
        {
            pageitem = null;
        }
        return pageitem;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300da, this);
        mViews = new Views(this);
    }

    private boolean b()
    {
        return getPageItem().g().b();
    }

    private void c()
    {
        if (getPageItem() == null)
        {
            return;
        }
        boolean flag = y.a((Action)getPageItem().a().d());
        boolean flag1 = getPageItem().c().b();
        boolean flag2 = getPageItem().d().b();
        boolean flag3 = getPageItem().k().b();
        if (flag || flag1 || flag2 || flag3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setEnabled(flag);
        setClickable(flag);
    }

    private void d()
    {
        al.a(mViews.divider, b());
        al.a(mViews.displayText, b());
    }

    private void e()
    {
        boolean flag;
        if (getPageItem().g().b() && getPageItem().i().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            SpannableString spannablestring = new SpannableString((CharSequence)getPageItem().g().c());
            Spannable spannable = a((String)getPageItem().i().c());
            spannablestringbuilder.append(spannablestring);
            spannablestringbuilder.append(" ");
            spannablestringbuilder.append(spannable);
            mViews.displayText.setText(spannablestringbuilder);
            return;
        }
        String s = "";
        if (getPageItem().g().b())
        {
            s = (String)getPageItem().g().c();
        }
        mViews.displayText.setText(s);
    }

    protected void a()
    {
        Object obj1 = null;
        BitmapImageView bitmapimageview = mViews.image;
        u.a(getContext()).a(bitmapimageview);
        Object obj;
        String s;
        int i;
        int j;
        int k;
        if (getPageItem().k().b())
        {
            obj = a(getPageItem());
        } else
        if (getPageItem().h().b())
        {
            obj = (ImageInfo)getPageItem().h().c();
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            u.a(getContext()).a((String)null).a(bitmapimageview);
            return;
        }
        j = mViews.image.getMeasuredWidth();
        k = mViews.image.getMeasuredHeight();
        s = ((ImageInfo) (obj)).a(k);
        if (((ImageInfo) (obj)).a().b())
        {
            obj = (String)((ImageInfo) (obj)).a().c();
            i = 1;
        } else
        {
            i = 2;
            obj = obj1;
        }
        u.a(getContext()).a(s).a(j, k).b().a(IMAGE_LOADING_TAG).a(bitmapimageview);
        mViews.image.setContentDescription(((CharSequence) (obj)));
        ai.c(mViews.image, i);
    }

    public BitmapImageView getImage()
    {
        return mViews.image;
    }

    public void setFooterHeight(int i)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.displayText.getLayoutParams().height = i;
            return;
        }
    }

    public void setPageItemElement(a a1)
    {
        super.setPageItemElement(a1);
        c();
        d();
        e();
    }

}
