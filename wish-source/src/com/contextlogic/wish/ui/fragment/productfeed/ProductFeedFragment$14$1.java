// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.productfeed;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.contextlogic.wish.WishApplication;
import com.contextlogic.wish.api.core.ApiDataChangeNotificationManager;
import com.contextlogic.wish.api.data.WishUserProductBucket;
import com.contextlogic.wish.api.service.HideProductService;
import com.contextlogic.wish.api.service.MoveToBucketService;
import com.contextlogic.wish.ui.activity.root.RootActivity;
import com.contextlogic.wish.ui.components.alert.PopupAlertDialog;
import com.contextlogic.wish.ui.components.grid.StaggeredGridView;
import com.contextlogic.wish.ui.fragment.menu.wishlist.WishlistMenuFragment;
import com.contextlogic.wish.util.TabletUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.contextlogic.wish.ui.fragment.productfeed:
//            ProductFeedFragment

class this._cls1
    implements com.contextlogic.wish.api.service.sCallback
{

    final Event this$1;

    public void onServiceSucceeded()
    {
        trackEvent(com.contextlogic.wish.analytics.roduct, com.contextlogic.wish.analytics.ss);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/contextlogic/wish/ui/fragment/productfeed/ProductFeedFragment$14

/* anonymous class */
    class ProductFeedFragment._cls14
        implements com.contextlogic.wish.ui.fragment.menu.wishlist.MoveToWishlistMenuFragment.Callback
    {

        final ProductFeedFragment this$0;

        public void onBucketEditCancelled()
        {
            clearOverlay();
        }

        public void onBucketEdited(ArrayList arraylist, String s, String s1)
        {
            Object obj = (RootActivity)getActivity();
            if (!TabletUtil.isTablet(getActivity()) && ((RootActivity) (obj)).hasRightMenu()) goto _L2; else goto _L1
_L1:
            clearOverlay();
_L4:
            ProductFeedFragment.access$000(ProductFeedFragment.this).setEditModeEnabled(false);
            ProductFeedFragment.access$100(ProductFeedFragment.this).setVisibility(8);
            ProductFeedFragment.access$200(ProductFeedFragment.this).clear();
            if (s1 == null || ProductFeedFragment.access$400(ProductFeedFragment.this) == null || !s1.equals(ProductFeedFragment.access$400(ProductFeedFragment.this).getBucketId()))
            {
                if (getActivity() != null)
                {
                    PopupAlertDialog.showSuccess(getActivity(), null, String.format(getActivity().getString(0x7f0602b5), new Object[] {
                        s
                    }));
                }
                if (ProductFeedFragment.access$400(ProductFeedFragment.this) != null)
                {
                    ApiDataChangeNotificationManager.getInstance().notifyListenersForBucketEdit(ProductFeedFragment.access$400(ProductFeedFragment.this), arraylist);
                }
                for (arraylist = arraylist.iterator(); arraylist.hasNext(); (new MoveToBucketService()).requestService(((String) (obj)), s, s1, null, null))
                {
                    obj = (String)arraylist.next();
                }

            }
            break; /* Loop/switch isn't completed */
_L2:
            if (obj != null)
            {
                ((RootActivity) (obj)).closeMenus();
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (getActivity() != null)
            {
                ((RootActivity)getActivity()).setRightMenuFragment(new WishlistMenuFragment());
            }
            return;
        }

        public void onProductsRemoved(ArrayList arraylist)
        {
            Object obj = (RootActivity)getActivity();
            if (TabletUtil.isTablet(getActivity()) || !((RootActivity) (obj)).hasRightMenu())
            {
                clearOverlay();
            } else
            {
                ((RootActivity) (obj)).closeMenus();
            }
            ProductFeedFragment.access$000(ProductFeedFragment.this).setEditModeEnabled(false);
            ProductFeedFragment.access$100(ProductFeedFragment.this).setVisibility(8);
            ProductFeedFragment.access$200(ProductFeedFragment.this).clear();
            String s;
            for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); (new HideProductService()).requestService(s, new ProductFeedFragment._cls14._cls1(), null))
            {
                s = (String)((Iterator) (obj)).next();
                ApiDataChangeNotificationManager.getInstance().notifyListenersForProductUnwish(s);
            }

            PopupAlertDialog.showSuccess(getActivity(), null, WishApplication.getAppInstance().getQuantityString(0x7f070006, arraylist.size()));
            if (ProductFeedFragment.access$400(ProductFeedFragment.this) != null)
            {
                ApiDataChangeNotificationManager.getInstance().notifyListenersForBucketEdit(ProductFeedFragment.access$400(ProductFeedFragment.this), arraylist);
            }
            ((RootActivity)getActivity()).setRightMenuFragment(new WishlistMenuFragment());
        }

            
            {
                this$0 = ProductFeedFragment.this;
                super();
            }
    }

}
