// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.anim.FlipAnimation;
import java.util.List;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemGroup, GNODrawer, GNOItemAdapter, GNODebugSettingsActivity

class this._cls1
    implements android.view.animation.ener
{

    final is._cls0 this$1;

    public void onAnimationEnd(Animation animation)
    {
        GNODrawerItemGroup.access$102(_fld0, false);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/gno/GNODrawerItemGroup$1

/* anonymous class */
    class GNODrawerItemGroup._cls1
        implements android.view.View.OnClickListener
    {

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
            GNODrawerItemGroup.access$002(gnodraweritemgroup, flag);
            GNODrawerItemGroup.access$102(GNODrawerItemGroup.this, true);
            if (GNODrawerItemGroup.access$000(GNODrawerItemGroup.this))
            {
                i = com.amazon.mShop.android.lib.R.drawable.gno_arrow_up;
            } else
            {
                i = com.amazon.mShop.android.lib.R.drawable.gno_arrow_down;
            }
            imageview.setImageResource(i);
            view = new FlipAnimation(imageview, FlipAnimation.X_AXIS, true, (long)getChildren().size() * GNODebugSettingsActivity.getAnimationDurationMillis(view.getContext(), GNODrawerItemGroup.access$000(GNODrawerItemGroup.this)));
            view.setAnimationListener(new GNODrawerItemGroup._cls1._cls1());
            imageview.startAnimation(view);
            if (GNODrawerItemGroup.access$000(GNODrawerItemGroup.this))
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
    }

}
