// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Locale;

public final class CategoryViewModel extends ViewModel
{

    private static final String CATEGORY_IMAGE_URL_FORMAT = "%1$simg_category_%2$d.%3$s";
    public final EbayCategory category;

    public CategoryViewModel(int i, EbayCategory ebaycategory, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        category = ebaycategory;
    }

    public static String getCategoryImageUrl(long l)
    {
        Object obj = DeviceConfiguration.getNoSync();
        String s = ((DeviceConfiguration) (obj)).get(DcsString.categoryBrowseAssetHostURL);
        obj = ((DeviceConfiguration) (obj)).get(DcsString.DCSCategoryBrowseAssetType);
        Locale locale = Locale.US;
        if (!s.endsWith("/"))
        {
            s = (new StringBuilder()).append(s).append("/").toString();
        }
        return String.format(locale, "%1$simg_category_%2$d.%3$s", new Object[] {
            s, Long.valueOf(l), obj
        });
    }
}
