// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.db.models.Image;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.db.models.PricingMetadata;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.BuyUtils;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.UrgencyPricingUtils;
import com.squareup.picasso.Callback;
import java.util.Collection;
import java.util.Iterator;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView, DealCardMoreInfoView

public class OneTraitMultiOptionListItem extends FrameLayout
    implements Callback
{

    private BuyUtils buyUtil;
    private Context context;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private boolean displayDiscount;
    private boolean isUSACompatible;
    private UrlImageView optionImageView;

    public OneTraitMultiOptionListItem(Context context1)
    {
        this(context1, null, false, false);
    }

    public OneTraitMultiOptionListItem(Context context1, AttributeSet attributeset, int i, boolean flag, boolean flag1)
    {
        super(context1, attributeset, i);
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        displayDiscount = flag1;
        if (flag)
        {
            i = 0x7f030119;
        } else
        {
            i = 0x7f03011a;
        }
        inflate(context1, i, this);
        onFinishInflate();
    }

    public OneTraitMultiOptionListItem(Context context1, AttributeSet attributeset, boolean flag, boolean flag1)
    {
        this(context1, attributeset, 0, flag, flag1);
    }

    public OneTraitMultiOptionListItem(Context context1, boolean flag, boolean flag1)
    {
        this(context1, null, flag, flag1);
    }

    protected void applySoldOutBanner(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        TextView textview = (TextView)findViewById(0x7f10032f);
        ImageView imageview = (ImageView)findViewById(0x7f10032e);
        Resources resources = getResources();
        int i;
        if (flag1)
        {
            i = 0x7f0803b2;
        } else
        {
            i = 0x7f0802b6;
        }
        textview.setText(resources.getString(i));
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        if (flag)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        imageview.setVisibility(i);
    }

    protected int getDefaultImageViewHeight()
    {
        return getResources().getDimensionPixelSize(0x7f0b0005);
    }

    protected int getDefaultImageViewWidth()
    {
        return getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelSize(0x7f0b0155) * 2;
    }

    public com.groupon.util.ViewUtils.Size getImageViewSize()
    {
        if (optionImageView == null)
        {
            return new com.groupon.util.ViewUtils.Size(getDefaultImageViewWidth(), getDefaultImageViewHeight());
        }
        int j = optionImageView.getWidth();
        int k = optionImageView.getHeight();
        int i = j;
        if (j == 0)
        {
            i = getDefaultImageViewWidth();
        }
        j = k;
        if (k == 0)
        {
            j = getDefaultImageViewHeight();
        }
        return new com.groupon.util.ViewUtils.Size(i, j);
    }

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        if (((BitmapDrawable)imageview.getDrawable()).getBitmap() == null)
        {
            return;
        }
        int i = imageview.getDrawable().getIntrinsicHeight();
        double d = ((double)imageview.getDrawable().getIntrinsicWidth() * 1.0D) / (double)i;
        i = imageview.getLayoutParams().height;
        if (d > ((double)imageview.getLayoutParams().width * 1.0D) / (double)i || currentCountryManager.getCurrentCountry().isJapan())
        {
            imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            return;
        } else
        {
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            return;
        }
    }

    public void setOption(Option option)
    {
        Object obj = option.images;
        Object obj1;
        boolean flag;
        int i;
        boolean flag1;
        boolean flag2;
        if (((Collection) (obj)).size() > 0)
        {
            obj1 = ((Collection) (obj)).iterator();
            do
            {
                obj = (Image)((Iterator) (obj1)).next();
            } while (((Iterator) (obj1)).hasNext() && Strings.isEmpty(((Image) (obj)).url));
            optionImageView = (UrlImageView)findViewById(0x7f10032d);
            DealCardMoreInfoView dealcardmoreinfoview;
            TextView textview;
            String s;
            TextView textview1;
            TextView textview2;
            String s1;
            boolean flag3;
            if (obj == null || Strings.isEmpty(((Image) (obj)).url))
            {
                optionImageView.setImageUrl("");
            } else
            {
                obj1 = optionImageView;
                StringBuilder stringbuilder = (new StringBuilder()).append(((Image) (obj)).url);
                if (!currentCountryManager.getCurrentCountry().isJapan())
                {
                    obj = "t954x610.jpg";
                } else
                {
                    obj = "";
                }
                ((UrlImageView) (obj1)).setImageUrl(stringbuilder.append(((String) (obj))).toString());
            }
        }
        s = option.getTitle();
        textview1 = (TextView)findViewById(0x7f100330);
        textview = (TextView)findViewById(0x7f100334);
        textview2 = (TextView)findViewById(0x7f100333);
        obj1 = (TextView)findViewById(0x7f100193);
        dealcardmoreinfoview = (DealCardMoreInfoView)findViewById(0x7f100335);
        flag1 = buyUtil.isOptionExpired(option);
        if (option.isSoldOut() || flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag3 = currentCountryManager.getCurrentCountry().isJapan();
        if (displayDiscount && isUSACompatible && Strings.notEmpty(UrgencyPricingUtils.getUrgencyPricingAvailability(option.regularPrice, option.pricingMetadata)) && Strings.notEmpty(option.pricingMetadata.offerLabelDescriptive))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1)
        {
            i = 1;
        } else
        {
            i = option.getMinimumPurchaseQuantity();
        }
        if (flag3)
        {
            obj = getResources().getString(0x7f080134, new Object[] {
                Integer.valueOf(option.getDiscountPercent())
            });
        } else
        {
            CurrencyFormatter currencyformatter = currencyFormatter;
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                obj = option.getValue();
            } else
            {
                obj = option.getDiscount();
            }
            obj = currencyformatter.formatWithQuantity(((Price) (obj)), i);
        }
        s1 = currencyFormatter.formatWithQuantity(option.getPrice(), i);
        applySoldOutBanner(flag1, option.isSoldOut());
        textview1.setText(s);
        if (!flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        textview1.setEnabled(flag2);
        textview2.setText(((CharSequence) (obj)));
        if (!flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        textview2.setEnabled(flag2);
        if (!flag3)
        {
            textview2.setPaintFlags(textview2.getPaintFlags() | 0x10);
        }
        if (option.getDiscount().amount > 0 && option.getValue().amount > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview2.setVisibility(i);
        textview.setText(s1);
        obj = context.getResources();
        if (flag)
        {
            i = 0x7f0e0144;
        } else
        {
            i = 0x7f0e019a;
        }
        textview.setTextColor(((Resources) (obj)).getColor(i));
        if (!flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        textview.setEnabled(flag2);
        i = option.getSoldQuantity();
        if (i > 0)
        {
            obj = option.getSoldQuantityMessage();
            dealcardmoreinfoview.setTitle(Strings.capitalize(getResources().getQuantityString(0x7f0c0002, i)));
            if (!Strings.notEmpty(obj))
            {
                obj = Integer.valueOf(i);
            }
            dealcardmoreinfoview.setSubtitle(Strings.toString(obj));
        }
        if (flag)
        {
            ((TextView) (obj1)).setText(option.pricingMetadata.offerLabelDescriptive);
            ((TextView) (obj1)).setVisibility(0);
        } else
        {
            ((TextView) (obj1)).setVisibility(8);
        }
        if (!flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        dealcardmoreinfoview.setEnabled(flag1);
    }
}
