// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.searchapp.retailsearch.model.RefinementLink;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            GroupAdapter, RefinementGroupType, FilterAdapter

public class FilterItemAdapter
    implements GroupAdapter
{

    private RefinementLink clearLink;
    private Context context;
    private ImageView indicator;
    private boolean needAnimation;
    private RefinementLink refinementLink;
    private Resources resources;
    private ResultLayoutType resultLayoutType;
    private TextView title;

    public FilterItemAdapter(Context context1, ResultLayoutType resultlayouttype, RefinementLink refinementlink, RefinementLink refinementlink1, boolean flag)
    {
        context = context1;
        resources = context1.getResources();
        resultLayoutType = resultlayouttype;
        refinementLink = refinementlink;
        clearLink = refinementlink1;
        needAnimation = flag;
    }

    public boolean containsChild(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return s.equals(refinementLink.getId());
        }
    }

    public Object getChild(int i)
    {
        return null;
    }

    public int getChildPosition(String s)
    {
        return 0;
    }

    public String getChildUrl(int i)
    {
        if (refinementLink == null)
        {
            return null;
        } else
        {
            return refinementLink.getUrl();
        }
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        return null;
    }

    public int getChildrenCount()
    {
        return 0;
    }

    public Object getData()
    {
        return refinementLink;
    }

    public String getId()
    {
        return refinementLink.getId();
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.FILTER_ITEM;
    }

    public String getUrl()
    {
        if (refinementLink != null)
        {
            if (refinementLink.getSelected())
            {
                if (clearLink != null)
                {
                    return clearLink.getUrl();
                }
            } else
            {
                return refinementLink.getUrl();
            }
        }
        return null;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
label0:
        {
            View view1 = view;
            if (view1 != null)
            {
                view = view1;
                if (view1.getId() == com.amazon.retailsearch.R.id.rs_refinement_filter_item_layout)
                {
                    break label0;
                }
            }
            view = View.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_filter_item, null);
        }
        title = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_filter_item_label);
        indicator = (ImageView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_filter_item_indicator);
        title.setText(FilterAdapter.getFilterMessage(context, resultLayoutType, refinementLink));
        viewgroup = indicator;
        Resources resources1 = resources;
        int i;
        if (refinementLink.getSelected())
        {
            i = com.amazon.retailsearch.R.drawable.rs_checkbox_filled;
        } else
        {
            i = com.amazon.retailsearch.R.drawable.rs_checkbox;
        }
        viewgroup.setImageDrawable(resources1.getDrawable(i));
        if (needAnimation)
        {
            viewgroup = AnimationUtils.loadAnimation(context, com.amazon.retailsearch.R.anim.fly_in);
            viewgroup.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final FilterItemAdapter this$0;

                public void onAnimationEnd(Animation animation)
                {
                    needAnimation = false;
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = FilterItemAdapter.this;
                super();
            }
            });
            indicator.startAnimation(viewgroup);
            return view;
        } else
        {
            indicator.clearAnimation();
            return view;
        }
    }

    public boolean isChildEnabled(int i)
    {
        return false;
    }

    public boolean isChildSelected(String s)
    {
        while (refinementLink == null || TextUtils.isEmpty(s) || !refinementLink.getSelected() || !s.equals(refinementLink.getId())) 
        {
            return false;
        }
        return true;
    }

    public boolean isEnabled()
    {
        return refinementLink != null;
    }


/*
    static boolean access$002(FilterItemAdapter filteritemadapter, boolean flag)
    {
        filteritemadapter.needAnimation = flag;
        return flag;
    }

*/
}
