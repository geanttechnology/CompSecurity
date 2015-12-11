// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.cart.interfaces.a.y;
import java.util.Iterator;
import java.util.List;

public class CartErrorDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, TraceFieldInterface
{

    private static final String KEY_CART_ERROR_MSG = "keyCartErrorMessage";
    public static final String TAG = com/target/ui/fragment/cart/CartErrorDialogFragment.getSimpleName();

    public CartErrorDialogFragment()
    {
    }

    public static CartErrorDialogFragment a(Context context, w w1)
    {
        CartErrorDialogFragment carterrordialogfragment = new CartErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyCartErrorMessage", b(context, w1));
        carterrordialogfragment.setArguments(bundle);
        return carterrordialogfragment;
    }

    public static CartErrorDialogFragment a(Context context, y y1)
    {
        CartErrorDialogFragment carterrordialogfragment = new CartErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyCartErrorMessage", b(context, y1));
        carterrordialogfragment.setArguments(bundle);
        return carterrordialogfragment;
    }

    public static CartErrorDialogFragment a(String s)
    {
        CartErrorDialogFragment carterrordialogfragment = new CartErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyCartErrorMessage", s);
        carterrordialogfragment.setArguments(bundle);
        return carterrordialogfragment;
    }

    private static String b(Context context, w w1)
    {
        Object obj = w1.f();
        if (!((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        w1 = context.getString(0x7f090278);
_L4:
        return w1;
_L2:
        w1 = null;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue;
            }
            w1 = (com.target.mothership.model.cart.interfaces.a.w.a)((Iterator) (obj)).next();
            static class _cls1
            {

                static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateFulfillmentMethodFailure$UpdateFulfillmentMethodFailureReason[];
                static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateProductFailure$UpdateProductFailureReason[];

                static 
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateFulfillmentMethodFailure$UpdateFulfillmentMethodFailureReason = new int[com.target.mothership.model.cart.interfaces.a.w.a.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateFulfillmentMethodFailure$UpdateFulfillmentMethodFailureReason[com.target.mothership.model.cart.interfaces.a.w.a.ERR_FULFILLMENT_LIMITED_ITEM_IN_STORE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateFulfillmentMethodFailure$UpdateFulfillmentMethodFailureReason[com.target.mothership.model.cart.interfaces.a.w.a.ERR_FULFILLMENT_SHOP_INVENTORY_NOT_SUFFICIENT.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateFulfillmentMethodFailure$UpdateFulfillmentMethodFailureReason[com.target.mothership.model.cart.interfaces.a.w.a.ERR_CART_UNKNOWN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateProductFailure$UpdateProductFailureReason = new int[com.target.mothership.model.cart.interfaces.a.y.a.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateProductFailure$UpdateProductFailureReason[com.target.mothership.model.cart.interfaces.a.y.a.ERR_CART_MAX_PURCHASE_LIMIT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$UpdateProductFailure$UpdateProductFailureReason[com.target.mothership.model.cart.interfaces.a.y.a.ERR_CART_UNKNOWN.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.UpdateFulfillmentMethodFailure.UpdateFulfillmentMethodFailureReason[w1.ordinal()])
            {
            default:
                w1 = context.getString(0x7f090278);
                break;

            case 1: // '\001'
                w1 = context.getString(0x7f090102);
                break;

            case 2: // '\002'
                w1 = context.getString(0x7f090103);
                break;
            }
        } while (true);
          goto _L3
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String b(Context context, y y1)
    {
        Object obj1 = y1.f();
        if (!((List) (obj1)).isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = context.getString(0x7f090278);
_L4:
        return ((String) (obj));
_L2:
        obj = null;
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                continue;
            }
            obj = (com.target.mothership.model.cart.interfaces.a.y.a)((Iterator) (obj1)).next();
            switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.UpdateProductFailure.UpdateProductFailureReason[((com.target.mothership.model.cart.interfaces.a.y.a) (obj)).ordinal()])
            {
            default:
                obj = context.getString(0x7f090278);
                break;

            case 1: // '\001'
                obj = context.getString(0x7f090104, new Object[] {
                    Integer.valueOf(y1.b())
                });
                break;
            }
        } while (true);
          goto _L3
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755315: 
            dismiss();
            break;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f030049, null);
        String s = getArguments().getString("keyCartErrorMessage");
        ((TextView)view.findViewById(0x7f100132)).setText(s);
        view.findViewById(0x7f100133).setOnClickListener(this);
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

}
