// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            SelectCountryTitleView, SelectCountryActivity, Country, SelectCountryItemView

class <init> extends BaseAdapter
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
        if (SelectCountryActivity.access$0(SelectCountryActivity.this) != null)
        {
            return SelectCountryActivity.access$0(SelectCountryActivity.this).size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (SelectCountryActivity.access$0(SelectCountryActivity.this) == null || SelectCountryActivity.access$0(SelectCountryActivity.this).isEmpty())
        {
            return null;
        }
        if (i == SelectCountryActivity.access$0(SelectCountryActivity.this).size())
        {
            return null;
        }
        this._cls0 _lcls0 = (this._cls0)SelectCountryActivity.access$0(SelectCountryActivity.this).get(i);
        if (_lcls0.dexInList == -1)
        {
            return null;
        } else
        {
            return SelectCountryActivity.access$1(SelectCountryActivity.this)[_lcls0.dexInListArray].get(_lcls0.dexInList);
        }
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (dexInList)SelectCountryActivity.access$0(SelectCountryActivity.this).get(i);
        if (view == null)
        {
            if (((this._cls0) (viewgroup)).dexInList == -1)
            {
                return createTitleView(((createTitleView) (viewgroup)).dexInListArray);
            } else
            {
                view = (Country)SelectCountryActivity.access$1(SelectCountryActivity.this)[((this._cls0) (viewgroup)).dexInListArray].get(((dexInListArray) (viewgroup)).dexInList);
                return new SelectCountryItemView(SelectCountryActivity.this, view.getName(), view.getCode());
            }
        }
        if (((this._cls0) (viewgroup)).dexInList == -1)
        {
            if (view instanceof SelectCountryTitleView)
            {
                if (((dexInList) (viewgroup)).dexInListArray == 0)
                {
                    ((SelectCountryTitleView)view).update(ResourceManager.getString(SelectCountryActivity.this, "Common", "\u5E38\u7528", "\u5E38\u7528"));
                    return view;
                } else
                {
                    return createTitleView(((createTitleView) (viewgroup)).dexInListArray);
                }
            } else
            {
                return createTitleView(((createTitleView) (viewgroup)).dexInListArray);
            }
        }
        viewgroup = (Country)SelectCountryActivity.access$1(SelectCountryActivity.this)[((this._cls0) (viewgroup)).dexInListArray].get(((dexInListArray) (viewgroup)).dexInList);
        if (view instanceof SelectCountryTitleView)
        {
            return new SelectCountryItemView(SelectCountryActivity.this, viewgroup.getName(), viewgroup.getCode());
        } else
        {
            ((SelectCountryItemView)view).updateContent(viewgroup.getName(), viewgroup.getCode());
            return view;
        }
    }

    private ()
    {
        this$0 = SelectCountryActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
