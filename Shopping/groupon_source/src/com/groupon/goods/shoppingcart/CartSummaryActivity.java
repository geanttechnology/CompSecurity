// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.activity.GrouponActivity;
import com.groupon.activity.IntentFactory;
import com.groupon.goods.shoppingcart.mapping.ShoppingCartItemMapping;
import com.groupon.goods.shoppingcart.model.ContinueShoppingClickExtraInfo;
import com.groupon.goods.shoppingcart.v3.FixedUniversalListAdapter;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DefaultGrouponDialogListenerImpl;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.decoration.SimpleDividerItemDecoration;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryView, CartSummaryPresenter, NewPurchaseCart

public class CartSummaryActivity extends GrouponActivity
    implements CartSummaryView
{
    private class ConfirmDeleteItemDialogListener extends DefaultGrouponDialogListenerImpl
    {

        private final String optionUuid;
        private final int position;
        final CartSummaryActivity this$0;

        public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
        {
            onConfirmDialogResponse(false, optionUuid, position);
        }

        public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
        {
            onConfirmDialogResponse(true, optionUuid, position);
        }

        public ConfirmDeleteItemDialogListener(String s, int i)
        {
            this$0 = CartSummaryActivity.this;
            super();
            optionUuid = s;
            position = i;
        }
    }


    public static final String CART_CONTINUE_SHOPPING_CLICK = "continue_shopping";
    private static final String CONFIRM_DELETE_ITEM_TAG = "confirm_delete_item_tag";
    private UniversalListAdapter adapter;
    View bottomBar;
    Bus bus;
    Button checkoutButton;
    boolean comingFromDealDetails;
    Button continueShoppingButton;
    Button continueShoppingEmptyButton;
    View emptyLayout;
    TextView emptyMessage;
    IntentFactory intentFactory;
    boolean isDeepLinked;
    private ShoppingCartItemMapping mapping;
    private CartSummaryPresenter presenter;
    ShoppingCartService shoppingCartService;
    TextView subTotal;
    TextView subTotalLabel;

    public CartSummaryActivity()
    {
    }

    private void initAdapter()
    {
        RecyclerView recyclerview = (RecyclerView)ButterKnife.findById(this, 0x7f10009d);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        recyclerview.addItemDecoration(new SimpleDividerItemDecoration(this));
        adapter = new FixedUniversalListAdapter();
        adapter.registerOverrideMapping(mapping);
        adapter.setList(Collections.emptyList());
        recyclerview.setAdapter(adapter);
    }

    private void initPresenter(Bundle bundle)
    {
        ShoppingCartService shoppingcartservice = (ShoppingCartService)RoboGuice.getInjector(this).getInstance(com/groupon/service/ShoppingCartService);
        if (bundle != null)
        {
            presenter = new CartSummaryPresenter(this, shoppingcartservice, bus, bundle);
        }
        if (presenter == null)
        {
            presenter = new CartSummaryPresenter(this, shoppingcartservice, bus);
        }
    }

    private void onConfirmDialogResponse(boolean flag, String s, int i)
    {
        presenter.onDeleteItemConfirmation(flag, s, i);
    }

    public static Intent openShoppingCartIntent(Context context)
    {
        return (new Intent(context, com/groupon/goods/shoppingcart/CartSummaryActivity)).setFlags(0x4000000);
    }

    public void confirmDeleteItem(String s, int i)
    {
        s = new GrouponDialogFragment(new ConfirmDeleteItemDialogListener(s, i));
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_title_res_id", 0x7f080097);
        bundle.putInt("dialog_message_res_id", 0x7f080096);
        bundle.putInt("dialog_positive_button_text_res_id", 0x104000a);
        bundle.putInt("dialog_negative_button_text_res_id", 0x1040000);
        s.setArguments(bundle);
        GrouponDialogFragment.show(getFragmentManager(), s, "confirm_delete_item_tag");
    }

    public void enableCheckoutButton(boolean flag)
    {
        checkoutButton.setEnabled(flag);
    }

    public void enableContinueShoppingButton(boolean flag)
    {
        continueShoppingButton.setEnabled(flag);
    }

    public void finishView()
    {
        finish();
    }

    public int getProgressViewId()
    {
        return 0x7f1000a7;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080429));
    }

    public void notifyItemUpdated(int i)
    {
        adapter.notifyItemChanged(i);
    }

    public void onCheckoutClick()
    {
        presenter.checkout();
    }

    public void onContinueShoppingClick()
    {
        logger.logClick("", "continue_shopping", getClass().getSimpleName(), Logger.NULL_NST_FIELD, new ContinueShoppingClickExtraInfo(adapter.getItemCount()));
        presenter.continueShopping();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001c);
        if (comingFromDealDetails)
        {
            overridePendingTransition(0x7f040007, 0x7f040006);
        }
        mapping = new ShoppingCartItemMapping(bus);
        initPresenter(bundle);
        initAdapter();
        shoppingCartService.setCartInAppMessageViewed(true);
    }

    protected void onPause()
    {
        presenter.onPause();
        mapping.unregister();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mapping.register();
        presenter.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        presenter.onSaveInstanceState(bundle);
        mapping.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void setItems(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Collections.addAll(arraylist, list.toArray());
        adapter.setList(arraylist);
    }

    public void setSubTotal(String s)
    {
        subTotal.setText(s);
    }

    public void showEmptyView(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int i;
        if (flag)
        {
            Object obj = emptyMessage;
            if (flag1)
            {
                i = 0x7f08009c;
            } else
            {
                i = 0x7f08009a;
            }
            ((TextView) (obj)).setText(i);
            obj = continueShoppingEmptyButton;
            if (flag1)
            {
                i = 0x7f080099;
            } else
            {
                i = 0x7f0800c5;
            }
            ((Button) (obj)).setText(i);
        }
        obj = subTotalLabel;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = subTotal;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = bottomBar;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = emptyLayout;
        if (flag)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    public void startCarousel()
    {
        startActivity(intentFactory.newGoodsIntent(isDeepLinked));
    }

    public void startCheckout(int i, String s, String s1)
    {
        startActivity(NewPurchaseCart.openPurchaseCartIntent(this, i, s, s1));
    }

}
