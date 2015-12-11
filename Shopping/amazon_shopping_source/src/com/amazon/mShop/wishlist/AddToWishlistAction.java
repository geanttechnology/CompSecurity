// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wishlist;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.item.BuyButtonController;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.wishlist.WishListController;
import com.amazon.mShop.control.wishlist.WishListManageController;
import com.amazon.mShop.control.wishlist.WishListSubscriber;
import com.amazon.mShop.details.BuyButtonView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.NativeAppNotification;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ListList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wishlist:
//            WishListChooserSubscriber, WishListChooserView

public class AddToWishlistAction
    implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener, WishListSubscriber, WishListChooserSubscriber
{

    private boolean dismissWhenLogin;
    private AmazonActivity mActivity;
    private String mAsin;
    private AmazonAlertDialog mListChooserDialog;
    private WishListController mWishListController;

    public AddToWishlistAction()
    {
        this(false);
    }

    public AddToWishlistAction(boolean flag)
    {
        mWishListController = new WishListController(this);
        dismissWhenLogin = false;
        dismissWhenLogin = flag;
    }

    private void addItemToWishList(String s)
    {
        if (!Util.isEmpty(mAsin))
        {
            com.amazon.mShop.control.TaskCallback taskcallback = (new TaskCallbackFactory(mActivity)).getTaskCallback(mWishListController, com.amazon.mShop.android.lib.R.string.wishlist_adding_to_wishlist);
            if (!mWishListController.hasServiceCallRunning())
            {
                mWishListController.addToWishList(mAsin, s, taskcallback);
            }
        }
    }

    public void addItem(AmazonActivity amazonactivity, String s)
    {
        mActivity = amazonactivity;
        mAsin = s;
        if (!Util.isEmpty(mAsin) && !mWishListController.hasServiceCallRunning())
        {
            amazonactivity = (new TaskCallbackFactory(mActivity)).getTaskCallback(mWishListController, com.amazon.mShop.android.lib.R.string.wishlist_getting_lists);
            mWishListController.getListList("wishlist", amazonactivity);
        }
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            ActivityUtils.startWishListActivity(mActivity);
        }
        dialoginterface.dismiss();
    }

    public void onClick(View view)
    {
        mActivity = (AmazonActivity)view.getContext();
        mAsin = null;
        if (!(view instanceof BuyButtonView)) goto _L2; else goto _L1
_L1:
        mAsin = ((BuyButtonView)view).getBuyButtonController().getProductController().getAsin();
_L4:
        addItem(mActivity, mAsin);
        RefMarkerObserver.logRefMarker("wl_add");
        return;
_L2:
        if ((view instanceof TextView) && (view.getTag() instanceof ProductController))
        {
            mAsin = ((ProductController)((TextView)view).getTag()).getAsin();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onError(Exception exception, final ServiceCall currentView)
    {
        Log.e("AmazonActivity", exception.toString());
        currentView = mActivity.getCurrentView();
        com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final AddToWishlistAction this$0;
            final View val$currentView;

            public void onActionButtonClick(int i)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        mActivity.clearErrorOnView(currentView);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = AddToWishlistAction.this;
                currentView = view;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(mActivity, amazonerrorboxactionlistener, currentView, exception, mActivity.getString(com.amazon.mShop.android.lib.R.string.ok));
    }

    public void onListLists(List list)
    {
        if (list.size() > 1)
        {
            Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity);
            ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setTitle(com.amazon.mShop.android.lib.R.string.wishlist_add_dialog_title);
            mListChooserDialog = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
            obj = new WishListChooserView(mActivity, 4, this);
            ((WishListChooserView) (obj)).setWishLists(list);
            mListChooserDialog.setView(((View) (obj)), 0, 0, 0, 0);
            ((WishListChooserView) (obj)).setFocusable(true);
            mListChooserDialog.setIcon(0);
            mListChooserDialog.show();
            return;
        } else
        {
            addItemToWishList("");
            WishListManageController.getInstance().setCurrentList(null);
            return;
        }
    }

    public void onListSelected(ListList listlist, int i)
    {
        addItemToWishList(listlist.getListId());
        WishListManageController.getInstance().setCurrentList(listlist);
        mListChooserDialog.dismiss();
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
    {
        if (dismissWhenLogin && callback == mWishListController)
        {
            mWishListController.dismissProgressDialog();
        }
        mActivity.authenticateUser(callback, null);
    }

    public void onWishListItemAdded()
    {
        UIUtils.info(mActivity, com.amazon.mShop.android.lib.R.string.wishlist_added_to_wishlist);
        NativeAppNotification.notifyNativeWishListChanged();
    }

}
