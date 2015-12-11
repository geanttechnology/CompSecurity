// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.anim.FlipAnimation;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemHideable, GNODrawer, GNOItemAdapter, GNODrawerItemSimple, 
//            GNODrawerItem, GNODebugSettingsActivity

public class GNODrawerItemGroup extends GNODrawerItemHideable
{
    public static class Builder extends GNODrawerItemHideable.Builder
    {

        protected List children;

        public GNODrawerItemGroup build()
        {
            GNODrawerItemGroup gnodraweritemgroup = (GNODrawerItemGroup)super.build();
            if (!Util.isEmpty(children))
            {
                gnodraweritemgroup.setChildren(children);
            }
            return gnodraweritemgroup;
        }

        public volatile GNODrawerItemHideable build()
        {
            return build();
        }

        public volatile GNODrawerItemSimple build()
        {
            return build();
        }

        public Builder withChild(GNODrawerItem gnodraweritem)
        {
            children.add(gnodraweritem);
            return (Builder)self();
        }

        public Builder withSubView(int i)
        {
            return (Builder)self();
        }

        public volatile GNODrawerItemSimple.Builder withSubView(int i)
        {
            return withSubView(i);
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemGroup(context, s));
            super.withSubView(com.amazon.mShop.android.lib.R.layout.gno_drawer_item_group_icon);
            children = new ArrayList();
        }

        public Builder(GNODrawerItemGroup gnodraweritemgroup)
        {
            super(gnodraweritemgroup);
            super.withSubView(com.amazon.mShop.android.lib.R.layout.gno_drawer_item_group_icon);
            children = new ArrayList();
        }
    }


    protected android.view.View.OnClickListener mExpandableIconClickListener;
    private volatile boolean mIsAnimating;
    private boolean mIsExpanding;

    public GNODrawerItemGroup(Context context, String s)
    {
        super(context, s);
        mIsAnimating = false;
        mIsExpanding = false;
        mExpandableIconClickListener = new android.view.View.OnClickListener() {

            final GNODrawerItemGroup this$0;

            public void onClick(View view)
            {
                ImageView imageview = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.group_item_expandable_arrow);
                GNOItemAdapter gnoitemadapter = GNODrawer.getGNOItemAdapter();
                GNODrawerItemGroup gnodraweritemgroup = GNODrawerItemGroup.this;
                int i;
                boolean flag;
                if (!gnoitemadapter.isGroupExpanded(getId()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                gnodraweritemgroup.mIsExpanding = flag;
                mIsAnimating = true;
                if (mIsExpanding)
                {
                    i = com.amazon.mShop.android.lib.R.drawable.gno_arrow_up;
                } else
                {
                    i = com.amazon.mShop.android.lib.R.drawable.gno_arrow_down;
                }
                imageview.setImageResource(i);
                view = new FlipAnimation(imageview, FlipAnimation.X_AXIS, true, (long)getChildren().size() * GNODebugSettingsActivity.getAnimationDurationMillis(view.getContext(), mIsExpanding));
                view.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final _cls1 this$1;

                    public void onAnimationEnd(Animation animation)
                    {
                        mIsAnimating = false;
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                imageview.startAnimation(view);
                if (mIsExpanding)
                {
                    gnoitemadapter.expandGroup(getId(), true);
                } else
                {
                    gnoitemadapter.collapseGroup(getId(), true);
                }
                imageview.invalidate();
            }

            
            {
                this$0 = GNODrawerItemGroup.this;
                super();
            }
        };
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        view = super.getView(view, viewgroup);
        int i;
        boolean flag;
        if (mIsAnimating)
        {
            flag = mIsExpanding;
        } else
        {
            flag = GNODrawer.getGNOItemAdapter().isGroupExpanded(getId());
        }
        viewgroup = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.group_item_expandable_arrow);
        if (flag)
        {
            i = com.amazon.mShop.android.lib.R.drawable.action_bar_arrow_up;
        } else
        {
            i = com.amazon.mShop.android.lib.R.drawable.action_bar_arrow_down;
        }
        viewgroup.setImageResource(i);
        viewgroup.setOnClickListener(mExpandableIconClickListener);
        if (!mIsAnimating)
        {
            viewgroup.clearAnimation();
        }
        return view;
    }



/*
    static boolean access$002(GNODrawerItemGroup gnodraweritemgroup, boolean flag)
    {
        gnodraweritemgroup.mIsExpanding = flag;
        return flag;
    }

*/


/*
    static boolean access$102(GNODrawerItemGroup gnodraweritemgroup, boolean flag)
    {
        gnodraweritemgroup.mIsAnimating = flag;
        return flag;
    }

*/
}
