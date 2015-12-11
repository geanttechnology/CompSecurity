// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Image;
import com.groupon.db.models.Option;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.ImageUrl;
import com.groupon.util.LayoutUtil;
import com.groupon.view.dealcards.DealCardBase;
import java.util.Collection;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class DealCardCompact extends DealCardBase
{

    private static final int RES_LAYOUT = 0x7f0300bc;
    private TextView cartDiscount;
    private View cartPhotoStack;
    private String discountPercent;
    private View loadingView;
    private View mainContainer;

    public DealCardCompact(Context context)
    {
        super(context, 0x7f0300bc);
    }

    public DealCardCompact(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DealCardCompact(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f0300bc, this);
    }

    private String getImageUrl(String s, Collection collection)
    {
        Collection collection1;
label0:
        {
            collection1 = null;
            Object obj = null;
            if (collection.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = collection.iterator();
            collection1 = obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                collection = ((Image)iterator.next()).url;
                collection1 = collection;
            } while (!Strings.notEmpty(collection));
            collection1 = collection;
        }
        if (Strings.notEmpty(collection1))
        {
            return collection1;
        } else
        {
            return s;
        }
    }

    public String getDiscountPercent()
    {
        return discountPercent;
    }

    public boolean isLoading()
    {
        return loadingView.getVisibility() == 0;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mainContainer = findViewById(0x7f100219);
        loadingView = findViewById(0x7f100218);
        cartPhotoStack = findViewById(0x7f10021b);
        cartDiscount = (TextView)findViewById(0x7f10021c);
        layoutUtil.setDrawableStart(mobileOnly, 0x7f020286);
    }

    public void setInfo(DealSummary dealsummary, Option option)
    {
        super.setInfoWithPlace(dealsummary, null);
        String s;
        int i;
        if (Strings.notEmpty(option.getTitle()))
        {
            s = option.getTitle();
        } else
        if (Strings.notEmpty(dealsummary.announcementTitle))
        {
            s = dealsummary.announcementTitle;
        } else
        {
            s = dealsummary.title;
        }
        setTitle(s);
        s = getImageUrl(dealsummary.derivedImageUrl, option.images);
        if (Strings.notEmpty(s))
        {
            dealsummary = new ImageUrl(s, true);
        } else
        {
            dealsummary = new ImageUrl(dealsummary.largeImageUrl, false);
        }
        dealImageView.setImageUrl(dealsummary);
        i = option.getMinimumPurchaseQuantity();
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            dealsummary = String.format(getResources().getString(0x7f080134), new Object[] {
                Integer.valueOf(option.getDiscountPercent())
            });
        } else
        {
            dealsummary = currencyFormatter.formatWithQuantity(option.getValue(), i, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        }
        s = currencyFormatter.formatWithQuantity(option.getPrice(), i, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        i = option.getDiscountPercent();
        if (i > 0)
        {
            discountPercent = String.format("%d%%", new Object[] {
                Integer.valueOf(i)
            });
        }
        setPrice(s);
        setReferencePrice(dealsummary);
        mainContainer.animate().setDuration(500L).alpha(1.0F);
    }

    public void setLoading(boolean flag)
    {
        View view = loadingView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void setShoppingCartInfo(int i, String s, String s1)
    {
        setTitle(Html.fromHtml(getContext().getResources().getQuantityString(0x7f0c000b, i, new Object[] {
            Integer.valueOf(i)
        })));
        setImage(new ImageUrl(s1));
        displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.PRICE, false);
        displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.REFERENCE_PRICE, false);
        cartPhotoStack.setVisibility(0);
        cartDiscount.setVisibility(0);
        if (Strings.notEmpty(s))
        {
            discountPercent = "";
            cartDiscount.setText(String.format(getContext().getString(0x7f080136), new Object[] {
                s
            }));
        }
        mainContainer.animate().setDuration(500L).alpha(1.0F);
    }
}
