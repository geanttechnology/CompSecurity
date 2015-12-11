// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.a.a.e;
import com.target.mothership.common.product.i;
import com.target.mothership.model.c.c;
import com.target.mothership.model.d;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.helper.product.g;
import com.target.ui.model.a;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.service.k;
import com.target.ui.util.ai;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseProductDialogFragment extends BaseDialogFragment
    implements com.target.ui.helper.product.g.c
{
    public static interface a
    {

        public abstract void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, ProductDetails productdetails1, ProductVariationModel productvariationmodel, Store store, com.target.mothership.common.a.g g1);

        public abstract void a(Store store);

        public abstract void a(GridItem griditem);

        public abstract void a(ProductVariationModel productvariationmodel);

        public abstract void b(com.target.ui.helper.product.b b1);
    }

    public static interface b
    {

        public abstract a r_();
    }


    private static final int DEFAULT_QUANTITY = 1;
    private static final int MAX_STORE_INFO_REQUIRED = 7;
    protected static final int PRODUCT_DETAIL_DEFAULT_INDEX = 0;
    private static final String RELEVANT_STORES_TAG = "RELEVANT_STORES_TAG";
    public static final String TAG = com/target/ui/fragment/product/dialog/BaseProductDialogFragment.getSimpleName();
    private Boolean mHasStoreOverride;
    private c mLocationManager;
    private g mProductDataHelper;

    public BaseProductDialogFragment()
    {
    }

    static Boolean a(BaseProductDialogFragment baseproductdialogfragment, Boolean boolean1)
    {
        baseproductdialogfragment.mHasStoreOverride = boolean1;
        return boolean1;
    }

    static List a(BaseProductDialogFragment baseproductdialogfragment, List list)
    {
        return baseproductdialogfragment.b(list);
    }

    private void a(double d1, double d2)
    {
        k.a().a(d1, d2, 7, new h() {

            final BaseProductDialogFragment this$0;

            public void a(x x1)
            {
                BaseProductDialogFragment.this.a(com.target.ui.service.k.a.NO_NEARBY_STORES);
                ai.a(BaseProductDialogFragment.this, "Unable to retrieve nearby stores.");
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                BaseProductDialogFragment.this.a(com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a(BaseProductDialogFragment.this, list));
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    protected static void a(DialogFragment dialogfragment, b b1)
        throws IllegalArgumentException
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("ProductDialogStateListenerProvider cannot be null");
        }
        if (!(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement ProductDialogStateListenerProvider");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)b1, 0);
            return;
        }
    }

    static void a(BaseProductDialogFragment baseproductdialogfragment, double d1, double d2)
    {
        baseproductdialogfragment.a(d1, d2);
    }

    private List b(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(new com.target.ui.model.a((RelevantStoreSummary)list.next(), 1, i.UNKNOWN, Collections.emptyList()))) { }
        return arraylist;
    }

    private void j()
    {
        k.a().b(new h() {

            final BaseProductDialogFragment this$0;

            public void a(x x1)
            {
                q.a(BaseProductDialogFragment.TAG, "Unable to verify if guest has override store, defaulting to false");
                com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a(BaseProductDialogFragment.this, Boolean.valueOf(false));
                BaseProductDialogFragment.this.a(Boolean.valueOf(false));
            }

            public void a(Boolean boolean1)
            {
                com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a(BaseProductDialogFragment.this, boolean1);
                BaseProductDialogFragment.this.a(boolean1);
            }

            public volatile void a(Object obj)
            {
                a((Boolean)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    protected abstract View a(LayoutInflater layoutinflater, ViewGroup viewgroup);

    protected void a(Product product)
    {
        mProductDataHelper.a(product, b(), this);
    }

    protected void a(Product product, String s)
    {
        if (mHasStoreOverride == null)
        {
            j();
        }
        k.a().a("RELEVANT_STORES_TAG");
        k.a().a(product, 1, s, new com.target.ui.service.k.b() {

            final BaseProductDialogFragment this$0;

            public void a(com.target.ui.service.k.a a1, x x1)
            {
                BaseProductDialogFragment.this.a(a1);
                String s1 = BaseProductDialogFragment.TAG;
                StringBuilder stringbuilder = (new StringBuilder()).append("Error fetching the stores by product ");
                if (x1 != null)
                {
                    a1 = x1.getMessage();
                } else
                {
                    a1 = "";
                }
                q.a(s1, stringbuilder.append(a1).toString());
            }

            public void a(List list)
            {
                BaseProductDialogFragment.this.a(list);
            }

            public String getTag()
            {
                return "RELEVANT_STORES_TAG";
            }

            public void onResult(Object obj)
            {
                a((List)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    protected abstract void a(ProductDetails productdetails, ProductVariationModel productvariationmodel);

    public void a(ProductDetailsWrapper productdetailswrapper)
    {
        if (getView() == null || productdetailswrapper == null || productdetailswrapper.b() == null)
        {
            return;
        } else
        {
            productdetailswrapper = (ProductDetails)productdetailswrapper.b().get(0);
            a(((ProductDetails) (productdetailswrapper)), (new ProductVariationModelHelper(getActivity())).a(productdetailswrapper));
            return;
        }
    }

    public void a(x x)
    {
    }

    protected void a(GridItem griditem)
    {
        if (d() == null)
        {
            return;
        } else
        {
            d().a(griditem);
            return;
        }
    }

    protected abstract void a(com.target.ui.service.k.a a1);

    protected abstract void a(Boolean boolean1);

    protected void a(String s)
    {
        if (mHasStoreOverride == null)
        {
            j();
        }
        mLocationManager.a(s, new d() {

            final BaseProductDialogFragment this$0;

            public void a(com.target.mothership.model.c.c.a.a a1)
            {
                BaseProductDialogFragment.this.a(com.target.ui.service.k.a.GEOCODE_FAILURE);
            }

            public void a(com.target.mothership.model.c.c.a a1)
            {
                if (a1.d().b() && a1.e().b())
                {
                    com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a(BaseProductDialogFragment.this, ((Double)a1.d().c()).doubleValue(), ((Double)a1.e().c()).doubleValue());
                    return;
                } else
                {
                    BaseProductDialogFragment.this.a(com.target.ui.service.k.a.GEOCODE_FAILURE);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((com.target.mothership.model.c.c.a)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.c.c.a.a)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    protected abstract void a(List list);

    protected abstract Store b();

    protected String b(com.target.ui.service.k.a a1)
    {
        int l;
        byte byte0;
        byte0 = -1;
        l = byte0;
        static class _cls7
        {

            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];
            static final int $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[];

            static 
            {
                $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType = new int[com.target.ui.service.k.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NO_PRODUCT_DPCI_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.RELEVANT_STORE_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NO_RELEVANT_STORES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.AVAILABILITY_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.STORE_LOOKUP_ERROR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NO_STORES_ZIP.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NO_NEARBY_STORES.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.GEOCODE_FAILURE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NETWORK.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.PICK_UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SHIP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.EXPRESS_CHECKOUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.EMAIL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.MAIL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SMS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls7..SwitchMap.com.target.ui.service.RelevantStoreService.ErrorType[a1.ordinal()];
        JVM INSTR tableswitch 1 9: default 64
    //                   1 66
    //                   2 66
    //                   3 66
    //                   4 73
    //                   5 79
    //                   6 85
    //                   7 91
    //                   8 97
    //                   9 103;
           goto _L1 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_103;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        l = byte0;
_L9:
        if (l < 0)
        {
            return "";
        } else
        {
            return getString(l);
        }
_L3:
        l = 0x7f090435;
          goto _L9
_L4:
        l = 0x7f09043a;
          goto _L9
_L5:
        l = 0x7f090439;
          goto _L9
_L6:
        l = 0x7f090437;
          goto _L9
_L7:
        l = 0x7f090436;
          goto _L9
        l = 0x7f090438;
          goto _L9
    }

    protected void b(Product product)
    {
        if (mHasStoreOverride == null)
        {
            j();
        }
        k.a().a("RELEVANT_STORES_TAG");
        k.a().a(product, 1, new com.target.ui.service.k.b() {

            final BaseProductDialogFragment this$0;

            public void a(com.target.ui.service.k.a a1, x x1)
            {
                BaseProductDialogFragment.this.a(a1);
                String s = BaseProductDialogFragment.TAG;
                StringBuilder stringbuilder = (new StringBuilder()).append("Error fetching the stores by product ");
                if (x1 != null)
                {
                    a1 = x1.getMessage();
                } else
                {
                    a1 = "";
                }
                q.a(s, stringbuilder.append(a1).toString());
            }

            public void a(List list)
            {
                BaseProductDialogFragment.this.a(list);
            }

            public String getTag()
            {
                return "RELEVANT_STORES_TAG";
            }

            public void onResult(Object obj)
            {
                a((List)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    protected abstract void c();

    protected boolean c(com.target.ui.service.k.a a1)
    {
        switch (_cls7..SwitchMap.com.target.ui.service.RelevantStoreService.ErrorType[a1.ordinal()])
        {
        case 6: // '\006'
        case 7: // '\007'
        default:
            return false;

        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        case 9: // '\t'
            return true;
        }
    }

    protected abstract a d();

    protected abstract ProductVariationModel e();

    protected abstract com.target.ui.helper.product.b f();

    protected void g()
    {
        ProductVariationModel productvariationmodel;
        if (d() != null)
        {
            if ((productvariationmodel = e()) != null)
            {
                productvariationmodel.g();
                d().a(e());
                return;
            }
        }
    }

    protected com.target.ui.view.product.a h()
    {
        switch (_cls7..SwitchMap.com.target.ui.helper.product.AddToCartItemType[f().ordinal()])
        {
        default:
            return com.target.ui.view.product.a.UNKNOWN;

        case 1: // '\001'
            return com.target.ui.view.product.a.PICK_UP;

        case 2: // '\002'
        case 3: // '\003'
            return com.target.ui.view.product.a.SHIP_IT;

        case 4: // '\004'
            return com.target.ui.view.product.a.EMAIL;

        case 5: // '\005'
            return com.target.ui.view.product.a.MAIL;

        case 6: // '\006'
            return com.target.ui.view.product.a.SMS;
        }
    }

    protected void i()
    {
        if (mHasStoreOverride == null)
        {
            j();
        }
        k.a().a("RELEVANT_STORES_TAG");
        k.a().a(7, new com.target.ui.service.k.d() {

            final BaseProductDialogFragment this$0;

            public void a(com.target.ui.service.k.a a1, x x1)
            {
                BaseProductDialogFragment.this.a(a1);
                String s = BaseProductDialogFragment.TAG;
                StringBuilder stringbuilder = (new StringBuilder()).append("Error fetching the stores by store id : ");
                if (x1 != null)
                {
                    a1 = x1.getMessage();
                } else
                {
                    a1 = "";
                }
                q.a(s, stringbuilder.append(a1).toString());
            }

            public void a(List list)
            {
                BaseProductDialogFragment.this.a(com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a(BaseProductDialogFragment.this, list));
            }

            public String getTag()
            {
                return "RELEVANT_STORES_TAG";
            }

            public void onResult(Object obj)
            {
                a((List)obj);
            }

            
            {
                this$0 = BaseProductDialogFragment.this;
                super();
            }
        });
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (d() == null)
        {
            return;
        } else
        {
            d().b(f());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mProductDataHelper = new g();
        mLocationManager = new c();
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return a(layoutinflater, viewgroup);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mProductDataHelper = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mProductDataHelper.a();
        k.a().a("RELEVANT_STORES_TAG");
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

    public void onStart()
    {
        super.onStart();
        if (getDialog() == null)
        {
            return;
        } else
        {
            int l = getResources().getDimensionPixelSize(0x7f0a0239);
            getDialog().getWindow().setLayout(-1, l);
            return;
        }
    }

    public void onStop()
    {
        super.onStop();
        g();
    }

    public void t_()
    {
    }

}
