// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            LetterIndexBar, PinyinUtils, CountryList, Country

public class SelectCountryActivity extends Activity
    implements LetterIndexBar.OnIndexChangeListener
{

    private static final String CHINA_CN = "\u4E2D\u56FD";
    private static final String CHINA_EN = "China";
    private static final String CHINA_TW = "\u4E2D\u570B";
    public static final String EXTRA_COUNTRY_CODE = "code";
    public static final String EXTRA_COUNTRY_NAME = "name";
    private static final String INFO_CN = "\u5E38\u7528";
    private static final String INFO_EN = "Common";
    private static final String INFO_TW = "\u5E38\u7528";
    private static final String SELECT_COUNTRY_EN = "Region";
    private static final String SELECT_COUNTRY_ZH_CN = "\u9009\u62E9\u56FD\u5BB6";
    private static final String SELECT_COUNTRY_ZH_TW = "\u9078\u64C7\u570B\u5BB6";
    private List arrSubCountry[];
    String countryStr;
    private List indexCountries;
    private CountryAdapter mAdapter;
    private List mCountries;
    private FrameLayout mFrameLayout;
    private LetterIndexBar mLetterIndexBar;
    private ListView mListView;
    private RelativeLayout mMainLayout;
    private CountryList result;

    public SelectCountryActivity()
    {
        countryStr = "";
        indexCountries = new ArrayList();
    }

    private List compose(List alist[])
    {
        ArrayList arraylist = new ArrayList();
        if (alist == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i < alist.length) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        List list = alist[i];
        if (list == null || list.size() <= 0) goto _L5; else goto _L4
_L4:
        int j = 0;
_L7:
        if (j < list.size())
        {
            break MISSING_BLOCK_LABEL_65;
        }
_L5:
        i++;
          goto _L6
        if (j == 0)
        {
            arraylist.add(new IndexCountry(i, -1));
        }
        arraylist.add(new IndexCountry(i, j));
        j++;
          goto _L7
    }

    private void initView()
    {
        mMainLayout = new RelativeLayout(this);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        mMainLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new TitleBar(this);
        ((TitleBar) (obj)).setId(1);
        ((TitleBar) (obj)).setLeftBtnBg(ResourceManager.createStateListDrawable(this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
        ((TitleBar) (obj)).setTitleBarText(ResourceManager.getString(this, "Region", "\u9009\u62E9\u56FD\u5BB6", "\u9078\u64C7\u570B\u5BB6"));
        ((TitleBar) (obj)).setTitleBarClickListener(new com.sina.weibo.sdk.component.view.TitleBar.ListenerOnTitleBtnClicked() {

            final SelectCountryActivity this$0;

            public void onLeftBtnClicked()
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = SelectCountryActivity.this;
                super();
            }
        });
        mMainLayout.addView(((View) (obj)));
        mFrameLayout = new FrameLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(3, ((TitleBar) (obj)).getId());
        mFrameLayout.setLayoutParams(layoutparams);
        mMainLayout.addView(mFrameLayout);
        mListView = new ListView(this);
        obj = new android.widget.AbsListView.LayoutParams(-1, -1);
        mListView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mListView.setFadingEdgeLength(0);
        mListView.setSelector(new ColorDrawable(0));
        mListView.setDividerHeight(ResourceManager.dp2px(this, 1));
        mListView.setCacheColorHint(0);
        mListView.setDrawSelectorOnTop(false);
        mListView.setScrollingCacheEnabled(false);
        mListView.setScrollbarFadingEnabled(false);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SelectCountryActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (Country)mAdapter.getItem(i);
                if (adapterview == null)
                {
                    return;
                } else
                {
                    view = new Intent();
                    view.putExtra("code", adapterview.getCode());
                    view.putExtra("name", adapterview.getName());
                    setResult(-1, view);
                    finish();
                    return;
                }
            }

            
            {
                this$0 = SelectCountryActivity.this;
                super();
            }
        });
        mFrameLayout.addView(mListView);
        mAdapter = new CountryAdapter(null);
        mListView.setAdapter(mAdapter);
        mLetterIndexBar = new LetterIndexBar(this);
        mLetterIndexBar.setIndexChangeListener(this);
        obj = new android.widget.FrameLayout.LayoutParams(-2, -1);
        obj.gravity = 5;
        mLetterIndexBar.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mFrameLayout.addView(mLetterIndexBar);
        PinyinUtils.getInstance(this);
        obj = ResourceManager.getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(obj))
        {
            countryStr = ResourceManager.readCountryFromAsset(this, "countryCode.txt");
        } else
        if (Locale.TRADITIONAL_CHINESE.equals(obj))
        {
            countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeTw.txt");
        } else
        {
            countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeEn.txt");
        }
        result = new CountryList(countryStr);
        mCountries = result.countries;
        arrSubCountry = subCountries(mCountries);
        indexCountries = compose(arrSubCountry);
        mAdapter.notifyDataSetChanged();
        setContentView(mMainLayout);
    }

    private List[] subCountries(List list)
    {
        ArrayList aarraylist[];
        int i;
        aarraylist = new ArrayList[27];
        Country country = new Country();
        country.setCode("0086");
        country.setName(ResourceManager.getString(this, "China", "\u4E2D\u56FD", "\u4E2D\u570B"));
        aarraylist[0] = new ArrayList();
        aarraylist[0].add(country);
        i = 0;
_L2:
        Country country1;
        if (i >= list.size())
        {
            return aarraylist;
        }
        country1 = (Country)list.get(i);
        if (!country1.getCode().equals("00852") && !country1.getCode().equals("00853") && !country1.getCode().equals("00886"))
        {
            break; /* Loop/switch isn't completed */
        }
        aarraylist[0].add(country1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        int j = (country1.getPinyin().charAt(0) - 97) + 1;
        if (aarraylist[j] == null)
        {
            aarraylist[j] = new ArrayList();
        }
        aarraylist[j].add(country1);
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onIndexChange(int i)
    {
        if (arrSubCountry != null && i < arrSubCountry.length && arrSubCountry[i] != null)
        {
            mListView.setSelection(indexCountries.indexOf(new IndexCountry(i, -1)));
        }
    }

    protected void onPause()
    {
        super.onPause();
    }




    private class IndexCountry
    {

        int indexInList;
        int indexInListArray;
        final SelectCountryActivity this$0;

        public boolean equals(Object obj)
        {
            if ((obj instanceof IndexCountry) && indexInList == -1)
            {
                obj = (IndexCountry)obj;
                if (indexInListArray == ((IndexCountry) (obj)).indexInListArray && indexInList == ((IndexCountry) (obj)).indexInList)
                {
                    return true;
                }
            }
            return false;
        }

        IndexCountry(int i, int j)
        {
            this$0 = SelectCountryActivity.this;
            super();
            indexInListArray = i;
            indexInList = j;
        }
    }


    private class CountryAdapter extends BaseAdapter
    {

        final SelectCountryActivity this$0;

        private SelectCountryTitleView createTitleView(int i)
        {
            SelectCountryTitleView selectcountrytitleview = new SelectCountryTitleView(getApplicationContext());
            if (i == 0)
            {
                selectcountrytitleview.setTitle(ResourceManager.getString(SelectCountryActivity.this, "Common", "\u5E38\u7528", "\u5E38\u7528"));
                return selectcountrytitleview;
            } else
            {
                selectcountrytitleview.setTitle(String.valueOf((char)((i + 65) - 1)));
                return selectcountrytitleview;
            }
        }

        public int getCount()
        {
            if (indexCountries != null)
            {
                return indexCountries.size();
            } else
            {
                return 0;
            }
        }

        public Object getItem(int i)
        {
            if (indexCountries == null || indexCountries.isEmpty())
            {
                return null;
            }
            if (i == indexCountries.size())
            {
                return null;
            }
            IndexCountry indexcountry = (IndexCountry)indexCountries.get(i);
            if (indexcountry.indexInList == -1)
            {
                return null;
            } else
            {
                return arrSubCountry[indexcountry.indexInListArray].get(indexcountry.indexInList);
            }
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = (IndexCountry)indexCountries.get(i);
            if (view == null)
            {
                if (((IndexCountry) (viewgroup)).indexInList == -1)
                {
                    return createTitleView(((IndexCountry) (viewgroup)).indexInListArray);
                } else
                {
                    view = (Country)arrSubCountry[((IndexCountry) (viewgroup)).indexInListArray].get(((IndexCountry) (viewgroup)).indexInList);
                    return new SelectCountryItemView(SelectCountryActivity.this, view.getName(), view.getCode());
                }
            }
            if (((IndexCountry) (viewgroup)).indexInList == -1)
            {
                if (view instanceof SelectCountryTitleView)
                {
                    if (((IndexCountry) (viewgroup)).indexInListArray == 0)
                    {
                        ((SelectCountryTitleView)view).update(ResourceManager.getString(SelectCountryActivity.this, "Common", "\u5E38\u7528", "\u5E38\u7528"));
                        return view;
                    } else
                    {
                        return createTitleView(((IndexCountry) (viewgroup)).indexInListArray);
                    }
                } else
                {
                    return createTitleView(((IndexCountry) (viewgroup)).indexInListArray);
                }
            }
            viewgroup = (Country)arrSubCountry[((IndexCountry) (viewgroup)).indexInListArray].get(((IndexCountry) (viewgroup)).indexInList);
            if (view instanceof SelectCountryTitleView)
            {
                return new SelectCountryItemView(SelectCountryActivity.this, viewgroup.getName(), viewgroup.getCode());
            } else
            {
                ((SelectCountryItemView)view).updateContent(viewgroup.getName(), viewgroup.getCode());
                return view;
            }
        }

        private CountryAdapter()
        {
            this$0 = SelectCountryActivity.this;
            super();
        }

        CountryAdapter(CountryAdapter countryadapter)
        {
            this();
        }
    }

}
