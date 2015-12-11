// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

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
import com.target.mothership.model.coupons.c;
import com.target.mothership.model.coupons.interfaces.a.a;
import com.target.mothership.model.coupons.interfaces.a.b;
import com.target.mothership.model.coupons.interfaces.a.d;

public class CouponsErrorDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, TraceFieldInterface
{
    private class a
    {

        TextView dialogMsg;
        TextView dialogTitle;
        final CouponsErrorDialogFragment this$0;

        a(View view)
        {
            this$0 = CouponsErrorDialogFragment.this;
            super();
            dialogTitle = (TextView)view.findViewById(0x7f1000d0);
            dialogMsg = (TextView)view.findViewById(0x7f1000d1);
        }
    }


    private static final String DIALOG_MSG_STRING = "DIALOG_MSG_STRING";
    private static final String DIALOG_TITLE_STRING = "DIALOG_TITLE_STRING";
    public static final String TAG = com/target/ui/fragment/mcoupons/CouponsErrorDialogFragment.getSimpleName();
    private a mViews;

    public CouponsErrorDialogFragment()
    {
    }

    public static CouponsErrorDialogFragment a(Context context, com.target.mothership.model.coupons.interfaces.a.a a1)
    {
        CouponsErrorDialogFragment couponserrordialogfragment = new CouponsErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DIALOG_TITLE_STRING", context.getString(0x7f0902ba));
        bundle.putString("DIALOG_MSG_STRING", b(context, a1));
        couponserrordialogfragment.setArguments(bundle);
        return couponserrordialogfragment;
    }

    public static CouponsErrorDialogFragment a(Context context, b b1)
    {
        CouponsErrorDialogFragment couponserrordialogfragment = new CouponsErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DIALOG_TITLE_STRING", context.getString(0x7f0902c8));
        bundle.putString("DIALOG_MSG_STRING", b(context, b1));
        couponserrordialogfragment.setArguments(bundle);
        return couponserrordialogfragment;
    }

    public static CouponsErrorDialogFragment a(Context context, com.target.mothership.model.coupons.interfaces.a.c c1)
    {
        CouponsErrorDialogFragment couponserrordialogfragment = new CouponsErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DIALOG_MSG_STRING", b(context, c1));
        bundle.putString("DIALOG_TITLE_STRING", context.getString(0x7f0902b1));
        couponserrordialogfragment.setArguments(bundle);
        return couponserrordialogfragment;
    }

    public static CouponsErrorDialogFragment a(Context context, d d1)
    {
        CouponsErrorDialogFragment couponserrordialogfragment = new CouponsErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DIALOG_MSG_STRING", b(context, d1));
        bundle.putString("DIALOG_TITLE_STRING", context.getString(0x7f0902c8));
        couponserrordialogfragment.setArguments(bundle);
        return couponserrordialogfragment;
    }

    public static CouponsErrorDialogFragment a(String s, String s1)
    {
        CouponsErrorDialogFragment couponserrordialogfragment = new CouponsErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DIALOG_TITLE_STRING", s);
        bundle.putString("DIALOG_MSG_STRING", s1);
        couponserrordialogfragment.setArguments(bundle);
        return couponserrordialogfragment;
    }

    private static String b(Context context, com.target.mothership.model.coupons.interfaces.a.a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[];
            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason[];
            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$GetAssignedOffersFailure$GetAssignedOffersFailureReason[];
            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_ADD_FAILED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_EXECUTION_FAILED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_PRE_ASSIGNED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_REQUEST_EXPIRED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_INSTANCE_KEY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$GetAssignedOffersFailure$GetAssignedOffersFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.c.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$GetAssignedOffersFailure$GetAssignedOffersFailureReason[com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_INSTANCE_KEY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$GetAssignedOffersFailure$GetAssignedOffersFailureReason[com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_EXECUTION_FAILED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$GetAssignedOffersFailure$GetAssignedOffersFailureReason[com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_REQUEST_EXPIRED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.d.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_INVALID_PHONE_NUMBER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_DENIED_SMS_DELIVERY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_EXECUTION_FAILED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_FAILED_SMS_DELIVERY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_MOBILE_OPERATOR_UNSUPPORTED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_PROVIDER_DETAILS_NOT_FOUND.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$RegisterBySmsFailure$RegisterBySmsFailureReason[com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_REQUEST_EXPIRED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason[com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_INVALID_CREDENTIALS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason[com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_PIN_MISMATCH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason[com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_EXECUTION_FAILED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$CouponSignUpFailure$CouponSignUpFailureReason[com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_REQUEST_EXPIRED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.mothership.model.coupons.interfaces.error.AddOnDemandCouponFailure.AddOnDemandCouponFailureReason[((com.target.mothership.model.coupons.interfaces.a.a.a)a1.e()).ordinal()];
        JVM INSTR tableswitch 1 5: default 48
    //                   1 57
    //                   2 57
    //                   3 63
    //                   4 69
    //                   5 75;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L1:
        int i = 0x7f0902c5;
_L7:
        return context.getString(i);
_L2:
        i = 0x7f0902b9;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0902b8;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f0902c3;
        continue; /* Loop/switch isn't completed */
_L5:
        (new c()).b();
        i = 0x7f0902bb;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static String b(Context context, b b1)
    {
        _cls1..SwitchMap.com.target.mothership.model.coupons.interfaces.error.CouponSignUpFailure.CouponSignUpFailureReason[((com.target.mothership.model.coupons.interfaces.a.b.a)b1.e()).ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 53
    //                   2 59
    //                   3 65
    //                   4 71;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int i = 0x7f0902c5;
_L7:
        return context.getString(i);
_L2:
        i = 0x7f0902c7;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0902c9;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f0902be;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f0902c3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static String b(Context context, com.target.mothership.model.coupons.interfaces.a.c c1)
    {
        _cls1..SwitchMap.com.target.mothership.model.coupons.interfaces.error.GetAssignedOffersFailure.GetAssignedOffersFailureReason[((com.target.mothership.model.coupons.interfaces.a.c.a)c1.e()).ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 49
    //                   2 65
    //                   3 71;
           goto _L1 _L2 _L3 _L4
_L1:
        int i = 0x7f0902c5;
_L6:
        return context.getString(i);
_L2:
        (new c()).b();
        i = 0x7f0902b2;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0902be;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f0902c3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static String b(Context context, d d1)
    {
        _cls1..SwitchMap.com.target.mothership.model.coupons.interfaces.error.RegisterBySmsFailure.RegisterBySmsFailureReason[((com.target.mothership.model.coupons.interfaces.a.d.a)d1.e()).ordinal()];
        JVM INSTR tableswitch 1 7: default 56
    //                   1 65
    //                   2 71
    //                   3 77
    //                   4 83
    //                   5 89
    //                   6 95
    //                   7 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        int i = 0x7f0902c5;
_L10:
        return context.getString(i);
_L2:
        i = 0x7f0902c1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0902c4;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f0902be;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f0902c3;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f0902c0;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 0x7f0902c2;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 0x7f0902c3;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755218: 
            dismiss();
            break;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f030033, null);
        mViews = new a(view);
        view.findViewById(0x7f1000d2).setOnClickListener(this);
        Object obj = getArguments();
        String s = ((Bundle) (obj)).getString("DIALOG_TITLE_STRING", "");
        obj = ((Bundle) (obj)).getString("DIALOG_MSG_STRING", "");
        mViews.dialogTitle.setText(s);
        mViews.dialogMsg.setText(((CharSequence) (obj)));
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
