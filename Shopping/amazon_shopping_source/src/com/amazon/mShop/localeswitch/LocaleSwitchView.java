// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.LocaleUtils;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitcher

public class LocaleSwitchView extends ListView
    implements TitleProvider
{
    private static final class LocaleItem extends Enum
    {

        private static final LocaleItem $VALUES[];
        public static final LocaleItem DE_DE;
        public static final LocaleItem EN_CA;
        public static final LocaleItem EN_GB;
        public static final LocaleItem EN_IN;
        public static final LocaleItem EN_US;
        public static final LocaleItem ES_ES;
        public static final LocaleItem FR_CA;
        public static final LocaleItem FR_FR;
        public static final LocaleItem IT_IT;
        public static final LocaleItem JA_JP;
        public static final LocaleItem ZH_CN;
        private int mIconDrawableId;
        private String mLocaleString;

        public static LocaleItem valueOf(String s)
        {
            return (LocaleItem)Enum.valueOf(com/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem, s);
        }

        public static LocaleItem[] values()
        {
            return (LocaleItem[])$VALUES.clone();
        }

        public int getIconDrawableId()
        {
            return mIconDrawableId;
        }

        public String getLocaleString()
        {
            return mLocaleString;
        }

        static 
        {
            EN_CA = new LocaleItem("EN_CA", 0, com.amazon.mShop.android.lib.R.drawable.icon_locale_ca, "en_CA");
            FR_CA = new LocaleItem("FR_CA", 1, com.amazon.mShop.android.lib.R.drawable.icon_locale_ca, "fr_CA");
            ZH_CN = new LocaleItem("ZH_CN", 2, com.amazon.mShop.android.lib.R.drawable.icon_locale_zh, "zh_CN");
            DE_DE = new LocaleItem("DE_DE", 3, com.amazon.mShop.android.lib.R.drawable.icon_locale_de, "de_DE");
            ES_ES = new LocaleItem("ES_ES", 4, com.amazon.mShop.android.lib.R.drawable.icon_locale_es, "es_ES");
            FR_FR = new LocaleItem("FR_FR", 5, com.amazon.mShop.android.lib.R.drawable.icon_locale_fr, "fr_FR");
            EN_IN = new LocaleItem("EN_IN", 6, com.amazon.mShop.android.lib.R.drawable.icon_locale_in, "en_IN");
            IT_IT = new LocaleItem("IT_IT", 7, com.amazon.mShop.android.lib.R.drawable.icon_locale_it, "it_IT");
            JA_JP = new LocaleItem("JA_JP", 8, com.amazon.mShop.android.lib.R.drawable.icon_locale_ja, "ja_JP");
            EN_GB = new LocaleItem("EN_GB", 9, com.amazon.mShop.android.lib.R.drawable.icon_locale_en_gb, "en_GB");
            EN_US = new LocaleItem("EN_US", 10, com.amazon.mShop.android.lib.R.drawable.icon_locale_en_us, "en_US");
            $VALUES = (new LocaleItem[] {
                EN_CA, FR_CA, ZH_CN, DE_DE, ES_ES, FR_FR, EN_IN, IT_IT, JA_JP, EN_GB, 
                EN_US
            });
        }

        private LocaleItem(String s, int i, int j, String s1)
        {
            super(s, i);
            mIconDrawableId = j;
            mLocaleString = s1;
        }
    }

    private class SelectCountryAdapter extends BaseAdapter
        implements android.widget.AdapterView.OnItemClickListener
    {

        private final LayoutInflater mLayoutInflater;
        final LocaleSwitchView this$0;

        public int getCount()
        {
            return LocaleItem.values().length;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = (RelativeLayout)view;
            if (view == null)
            {
                viewgroup = (RelativeLayout)mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.country_item, null);
            }
            ((ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.locale_icon)).setImageResource(LocaleItem.values()[i].getIconDrawableId());
            ((ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.check_mark)).setImageResource(com.amazon.mShop.android.lib.R.drawable.btn_check_buttonless_on);
            view = (ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.check_mark);
            int j;
            if (LocaleUtils.isCurrentLocale(LocaleItem.values()[i].getLocaleString()))
            {
                j = 0;
            } else
            {
                j = 4;
            }
            view.setVisibility(j);
            view = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_marketplaceCountry, LocaleItem.values()[i].getLocaleString());
            ((TextView)(TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.marketplace_country)).setText(view);
            view = new StringBuilder(ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_marketplaceName, LocaleItem.values()[i].getLocaleString()));
            ((TextView)(TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.marketplace_name)).setText((new StringBuilder()).append(" - ").append(view).toString());
            return viewgroup;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            int k = i - getHeaderViewsCount();
            if (k < 0 || k >= getCount())
            {
                return;
            }
            i = 0;
            while (i < adapterview.getChildCount()) 
            {
                View view1 = adapterview.getChildAt(i);
                if (view1 instanceof RelativeLayout)
                {
                    ImageView imageview = (ImageView)((RelativeLayout)view1).findViewById(com.amazon.mShop.android.lib.R.id.check_mark);
                    int j;
                    if (view1 == view)
                    {
                        j = 0;
                    } else
                    {
                        j = 4;
                    }
                    imageview.setVisibility(j);
                }
                i++;
            }
            mLocaleSwitcher.changeLocale(LocaleItem.values()[k].getLocaleString());
        }

        public SelectCountryAdapter()
        {
            this$0 = LocaleSwitchView.this;
            super();
            mLayoutInflater = LayoutInflater.from(getContext());
        }
    }


    private LocaleSwitcher mLocaleSwitcher;
    private SelectCountryAdapter mSelectCountryAdapter;

    public LocaleSwitchView(Activity activity, LocaleSwitcher localeswitcher)
    {
        super(activity);
        mLocaleSwitcher = localeswitcher;
        activity = new TextView(getContext());
        int i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding);
        activity.setPadding(i, i, i, i);
        activity.setText(com.amazon.mShop.android.lib.R.string.amazon_store_header);
        localeswitcher = (TextView)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.picker_view_header, null);
        localeswitcher.setText(com.amazon.mShop.android.lib.R.string.locale_switch_select_country_below);
        setHeaderDividersEnabled(false);
        addHeaderView(activity, null, false);
        addHeaderView(localeswitcher, null, false);
        mSelectCountryAdapter = new SelectCountryAdapter();
        setAdapter(mSelectCountryAdapter);
        setOnItemClickListener(mSelectCountryAdapter);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        try
        {
            super.dispatchDraw(canvas);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            Log.e(getClass().getSimpleName(), canvas.getMessage());
        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_store);
    }

}
