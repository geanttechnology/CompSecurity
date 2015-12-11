// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            AddToCartState

public class QuantitySwitcherDialog extends Dialog
{
    private class QuantitySwitcherAdapter extends BaseAdapter
    {

        private final int DEFAULT_MAX_QUANTITY = 10;
        private int currentQuantity;
        private int maxQuantity;
        final QuantitySwitcherDialog this$0;

        public int getCount()
        {
            return maxQuantity + 1;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            boolean flag = false;
            View view1 = view;
            if (view == null)
            {
                view1 = LayoutInflater.from(viewgroup.getContext()).inflate(com.amazon.retailsearch.R.layout.rs_quantity_changer_list_item, viewgroup, false);
            }
            ((TextView)view1.findViewById(com.amazon.retailsearch.R.id.rs_quantity_changer_info)).setText(getItem(i).toString());
            view = view1.findViewById(com.amazon.retailsearch.R.id.rs_quantity_changer_indicator);
            if (i == currentQuantity)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 4;
            }
            view.setVisibility(i);
            return view1;
        }

        public QuantitySwitcherAdapter(int i, int j)
        {
            this$0 = QuantitySwitcherDialog.this;
            super();
            currentQuantity = i;
            if (j > -1)
            {
                maxQuantity = Math.min(10, j);
                maxQuantity = Math.max(maxQuantity, currentQuantity);
                return;
            } else
            {
                maxQuantity = 10;
                QuantitySwitcherDialog.log.error("Invalid stockOnHand. Uses default value:10");
                return;
            }
        }
    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/buttons/QuantitySwitcherDialog);
    private ImageView close;
    private ListView dialogList;
    UserInteractionListener userInteractionListener;

    public QuantitySwitcherDialog(Context context, final AddToCartState cartState, final String offerId, final String qid, final String sr)
    {
        super(context, com.amazon.retailsearch.R.style.Rs_Twister_Dialog);
        RetailSearchDaggerGraphController.inject(this);
        setContentView(com.amazon.retailsearch.R.layout.rs_quantity_changer);
        close = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_quantity_dialog_close);
        close.setOnClickListener(new android.view.View.OnClickListener() {

            final QuantitySwitcherDialog this$0;

            public void onClick(View view)
            {
                try
                {
                    dismiss();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    QuantitySwitcherDialog.log.error("Could not dismiss dialog", view);
                }
            }

            
            {
                this$0 = QuantitySwitcherDialog.this;
                super();
            }
        });
        dialogList = (ListView)findViewById(com.amazon.retailsearch.R.id.rs_quantity_changer_list);
        dialogList.setAdapter(new QuantitySwitcherAdapter(cartState.getQuantity(), cartState.getStockOnHand()));
        dialogList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final QuantitySwitcherDialog this$0;
            final AddToCartState val$cartState;
            final String val$offerId;
            final String val$qid;
            final String val$sr;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                cartState.setState(2);
                userInteractionListener.updateQuantity(cartState.getItemId(), offerId, qid, sr, i, i. new com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback() {

                    final _cls2 this$1;
                    final int val$quantity;

                    public void error()
                    {
                        cartState.reset();
                    }

                    public void error(int i, String s, int j)
                    {
                        cartState.update(i, s, j);
                    }

                    public void success()
                    {
                        cartState.reset(quantity);
                    }

                    public void success(int i, String s, int j)
                    {
                        cartState.update(i, s, j);
                    }

            
            {
                this$1 = final__pcls2;
                quantity = I.this;
                super();
            }
                });
                try
                {
                    dismiss();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    QuantitySwitcherDialog.log.error("Could not dismiss dialog", adapterview);
                }
            }

            
            {
                this$0 = QuantitySwitcherDialog.this;
                cartState = addtocartstate;
                offerId = s;
                qid = s1;
                sr = s2;
                super();
            }
        });
    }


}
