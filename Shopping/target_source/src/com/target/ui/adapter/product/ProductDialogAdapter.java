// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.a.g;
import com.target.mothership.common.product.i;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.model.a;
import com.target.ui.service.k;
import com.target.ui.util.ae;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.Iterator;
import java.util.List;

public class ProductDialogAdapter extends e
    implements android.view.View.OnClickListener
{
    static class ViewHolder extends com.target.ui.view.a
    {

        int checkBoxPosition;
        TextView inventoryStatus;
        g pickUpItemType;
        int position;
        RadioButton radioButton;
        final View root;
        TextView storeAddress;
        ImageButton storeInfo;
        TextView storeLabel;
        TextView storeName;

        public ViewHolder(View view)
        {
            super(view);
            position = -1;
            checkBoxPosition = -1;
            root = view;
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(Store store);

        public abstract void a(com.target.ui.model.a a1, g g1);
    }


    private static final int NULL_INT = -1;
    private boolean mDisableSelection;
    private boolean mHasStoreOverride;
    private boolean mIsPickUpDialogScenario;
    private a mListener;
    private List mRelevantStores;
    private int mSelectedPosition;
    private final String mShipToStoreDeliveryDateString = a(0x7f090128);
    private boolean mShowCheckBox;
    private boolean mShowInventoryStatus;

    public ProductDialogAdapter(Context context, List list, boolean flag)
    {
        super(context, list);
        mShowCheckBox = false;
        mDisableSelection = false;
        mShowInventoryStatus = false;
        mIsPickUpDialogScenario = false;
        mRelevantStores = list;
        mSelectedPosition = -1;
        mIsPickUpDialogScenario = flag;
    }

    private int a(com.target.ui.model.a a1)
    {
        if (e(a1))
        {
            return a1.b() != i.LimitedStock ? 1 : 0;
        } else
        {
            return 2;
        }
    }

    private String a(int j)
    {
        return getContext().getResources().getString(j);
    }

    private transient String a(int j, Object aobj[])
    {
        return getContext().getResources().getString(j, aobj);
    }

    private void a(ViewHolder viewholder, com.target.ui.model.a a1)
    {
        boolean flag1 = b(a1);
        boolean flag2 = c(a1);
        boolean flag;
        if (flag1 || flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(a1, flag1, flag2, viewholder);
            return;
        } else
        {
            a(a1, viewholder);
            return;
        }
    }

    private void a(com.target.ui.model.a a1, ViewHolder viewholder)
    {
        if (!mShowInventoryStatus)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        a(a1);
        JVM INSTR tableswitch 0 1: default 36
    //                   0 147
    //                   1 196;
           goto _L1 _L2 _L3
_L1:
        String s;
        int j;
        s = a(0x7f090282);
        j = b(0x7f0f00f6);
_L4:
        viewholder.inventoryStatus.setText(s);
        viewholder.inventoryStatus.setTextColor(j);
        al.a(viewholder.inventoryStatus, new View[] {
            viewholder.storeAddress, viewholder.storeLabel
        });
        if (mShowCheckBox)
        {
            al.b(viewholder.radioButton);
        } else
        {
            al.c(viewholder.radioButton);
        }
_L5:
        viewholder.storeName.setText(a1.a().getName());
        if (!mDisableSelection);
        viewholder.root.setEnabled(false);
        viewholder.radioButton.setEnabled(false);
        return;
_L2:
        if (a1.c() > 0)
        {
            s = a(0x7f09027c, new Object[] {
                Integer.valueOf(a1.c())
            });
        } else
        {
            s = a(0x7f09027f);
        }
        j = b(0x7f0f00e9);
          goto _L4
_L3:
        s = a(0x7f09027d);
        j = b(0x7f0f00f6);
          goto _L4
        String s1 = ae.a(a1.a(), (RelevantStoreSummary)k.a().c().d(), mHasStoreOverride, getContext());
        if (o.g(s1))
        {
            viewholder.storeLabel.setText(s1);
            al.a(viewholder.storeLabel, new View[] {
                viewholder.storeAddress
            });
        } else
        {
            String s2 = (String)a1.a().getAddress().getAddressLines().get(0);
            viewholder.storeAddress.setText(s2);
            al.a(viewholder.storeAddress, new View[] {
                viewholder.storeLabel
            });
        }
        al.a(new View[] {
            viewholder.inventoryStatus, viewholder.radioButton
        });
          goto _L5
    }

    private void a(com.target.ui.model.a a1, boolean flag, boolean flag1, ViewHolder viewholder)
    {
        String s = null;
        if (!flag) goto _L2; else goto _L1
_L1:
        viewholder.pickUpItemType = g.PICK_UP_IN_STORE;
        s = a(0x7f09013c);
_L4:
        viewholder.storeName.setText(a1.a().getName());
        viewholder.root.setEnabled(true);
        viewholder.radioButton.setEnabled(true);
        viewholder.inventoryStatus.setTextColor(b(0x7f0f00ec));
        al.a(viewholder.inventoryStatus, new View[] {
            viewholder.storeAddress, viewholder.storeLabel
        });
        viewholder.inventoryStatus.setText(s);
        al.b(viewholder.radioButton);
        return;
_L2:
        if (flag1)
        {
            viewholder.pickUpItemType = g.SHIP_TO_STORE;
            s = mShipToStoreDeliveryDateString;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int b(int j)
    {
        return getContext().getResources().getColor(j);
    }

    private void b(ViewHolder viewholder, com.target.ui.model.a a1)
    {
        String s;
        int j;
        boolean flag4;
        flag4 = false;
        if (!mShowInventoryStatus)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        j = getContext().getResources().getColor(0x7f0f00e9);
        s = getContext().getResources().getString(0x7f090430);
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.InStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.LimitedStock.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OnBackorder.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrder.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.CurrentlyNotOnSale.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UNKNOWN.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[a1.b().ordinal()];
        JVM INSTR tableswitch 1 9: default 100
    //                   1 227
    //                   2 263
    //                   3 286
    //                   4 309
    //                   5 332
    //                   6 355
    //                   7 355
    //                   8 355
    //                   9 378;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L8
_L1:
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
_L9:
        if (mShowCheckBox)
        {
            al.b(viewholder.radioButton);
            boolean flag2 = flag;
            flag = flag1;
            flag1 = flag2;
        } else
        {
            al.c(viewholder.radioButton);
            boolean flag3 = flag1;
            flag1 = flag;
            flag = flag3;
        }
_L10:
        viewholder.storeName.setText(a1.a().getName());
        if (o.g(s))
        {
            viewholder.inventoryStatus.setText(s);
            viewholder.inventoryStatus.setTextColor(j);
            al.a(viewholder.inventoryStatus, new View[] {
                viewholder.storeAddress, viewholder.storeLabel
            });
        } else
        {
            s = ae.a(a1.a(), (RelevantStoreSummary)k.a().c().d(), mHasStoreOverride, getContext());
            if (o.g(s))
            {
                viewholder.storeLabel.setText(s);
                al.a(viewholder.storeLabel, new View[] {
                    viewholder.storeAddress
                });
            } else
            {
                a1 = (String)a1.a().getAddress().getAddressLines().get(0);
                viewholder.storeAddress.setText(a1);
                al.a(viewholder.storeAddress, new View[] {
                    viewholder.storeLabel
                });
            }
            al.a(new View[] {
                viewholder.inventoryStatus, viewholder.radioButton
            });
        }
        if (mDisableSelection)
        {
            flag = flag4;
        }
        viewholder.root.setEnabled(flag);
        viewholder.radioButton.setEnabled(flag1);
        return;
_L2:
        j = getContext().getResources().getColor(0x7f0f00ec);
        s = getContext().getResources().getString(0x7f090430);
        flag = true;
        flag1 = true;
          goto _L9
_L3:
        s = getContext().getResources().getString(0x7f09043f);
        flag = false;
        flag1 = false;
          goto _L9
_L4:
        s = getContext().getResources().getString(0x7f09043d);
        flag = false;
        flag1 = false;
          goto _L9
_L5:
        s = getContext().getResources().getString(0x7f090431);
        flag = false;
        flag1 = false;
          goto _L9
_L6:
        s = getContext().getResources().getString(0x7f090441);
        flag = false;
        flag1 = false;
          goto _L9
_L7:
        s = getContext().getResources().getString(0x7f09043e);
        flag = false;
        flag1 = false;
          goto _L9
_L8:
        s = getContext().getResources().getString(0x7f090448);
        flag = false;
        flag1 = false;
          goto _L9
        flag1 = false;
        s = "";
        j = 0;
        flag = false;
          goto _L10
    }

    private boolean b(com.target.ui.model.a a1)
    {
        return e(a1) && a1.b() == i.InStock;
    }

    private boolean c(com.target.ui.model.a a1)
    {
        return d(a1);
    }

    private boolean d(com.target.ui.model.a a1)
    {
        if (a1.d().isEmpty())
        {
            return false;
        }
        for (a1 = a1.d().iterator(); a1.hasNext();)
        {
            if ((com.target.mothership.common.product.o)a1.next() == com.target.mothership.common.product.o.SHIP_TO_STORE)
            {
                return true;
            }
        }

        return false;
    }

    private boolean e(com.target.ui.model.a a1)
    {
        if (a1.d().isEmpty())
        {
            return false;
        }
        for (a1 = a1.d().iterator(); a1.hasNext();)
        {
            if ((com.target.mothership.common.product.o)a1.next() == com.target.mothership.common.product.o.PICKUP_IN_STORE)
            {
                return true;
            }
        }

        return false;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(List list)
    {
        setNotifyOnChange(false);
        clear();
        mRelevantStores = list;
        mSelectedPosition = -1;
        a(((java.util.Collection) (list)));
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        mHasStoreOverride = flag;
    }

    public void a(boolean flag, boolean flag1)
    {
        mShowInventoryStatus = flag;
        mShowCheckBox = flag1;
    }

    public void b(boolean flag)
    {
        mDisableSelection = flag;
    }

    public int getCount()
    {
        return mRelevantStores.size();
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        com.target.ui.model.a a1 = (com.target.ui.model.a)getItem(j);
        RadioButton radiobutton;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030203, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        radiobutton = ((ViewHolder) (viewgroup)).radioButton;
        if (j == mSelectedPosition)
        {
            flag = true;
        }
        radiobutton.setChecked(flag);
        viewgroup.position = j;
        ((ViewHolder) (viewgroup)).storeInfo.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).radioButton.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).storeInfo.setOnClickListener(this);
        ((ViewHolder) (viewgroup)).radioButton.setOnClickListener(this);
        if (mIsPickUpDialogScenario)
        {
            a(viewgroup, a1);
            return view;
        } else
        {
            b(viewgroup, a1);
            return view;
        }
    }

    public void onClick(View view)
    {
        ViewHolder viewholder = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/product/ProductDialogAdapter$ViewHolder);
        if (viewholder != null) goto _L2; else goto _L1
_L1:
        mListener.a();
_L4:
        return;
_L2:
        if (mSelectedPosition != viewholder.position)
        {
            mSelectedPosition = viewholder.position;
            notifyDataSetChanged();
        }
        if (mListener == null) goto _L4; else goto _L3
_L3:
        switch (view.getId())
        {
        default:
            viewholder.checkBoxPosition = viewholder.position;
            if (mShowInventoryStatus)
            {
                mListener.a((com.target.ui.model.a)mRelevantStores.get(viewholder.position), viewholder.pickUpItemType);
                return;
            }
            break;

        case 2131756507: 
            view = ((com.target.ui.model.a)mRelevantStores.get(viewholder.position)).a();
            mListener.a(view);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }
}
