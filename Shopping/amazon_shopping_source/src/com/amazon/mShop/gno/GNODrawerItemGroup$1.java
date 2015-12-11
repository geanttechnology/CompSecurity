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

class this._cls0
    implements android.view.Group._cls1
{

    final GNODrawerItemGroup this$0;

    public void onClick(View view)
    {
        ImageView imageview = (ImageView)view.findViewById(com.amazon.mShop.android.lib.dable_arrow);
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
            i = com.amazon.mShop.android.lib.up;
        } else
        {
            i = com.amazon.mShop.android.lib.down;
        }
        imageview.setImageResource(i);
        view = new FlipAnimation(imageview, FlipAnimation.X_AXIS, true, (long)getChildren().size() * GNODebugSettingsActivity.getAnimationDurationMillis(view.getContext(), GNODrawerItemGroup.access$000(GNODrawerItemGroup.this)));
        view.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final GNODrawerItemGroup._cls1 this$1;

            public void onAnimationEnd(Animation animation)
            {
                GNODrawerItemGroup.access$102(this$0, false);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$1 = GNODrawerItemGroup._cls1.this;
                super();
            }
        });
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

    _cls1.this._cls1()
    {
        this$0 = GNODrawerItemGroup.this;
        super();
    }
}
