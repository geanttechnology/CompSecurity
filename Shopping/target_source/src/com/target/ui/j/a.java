// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j;

import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.ui.adapter.product.b;
import com.target.ui.adapter.product.e;
import com.target.ui.fragment.checkout.c.c;
import com.target.ui.fragment.checkout.c.d;
import com.target.ui.fragment.checkout.c.f;
import com.target.ui.j.b.g;
import com.target.ui.j.b.h;
import com.target.ui.j.b.i;
import com.target.ui.service.k;
import java.util.List;

public class a
{

    public static e a(List list)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$taplytics$options$CartRecommendationsTestingOptions$CartRecommendationsExperiment[];
            static final int $SwitchMap$com$target$ui$taplytics$options$DealsTabTestingOptions$DealsTabExperiment[];
            static final int $SwitchMap$com$target$ui$taplytics$options$PdpExpressCheckoutTestingOptions$PdpExpressCheckoutExperiment[];
            static final int $SwitchMap$com$target$ui$taplytics$options$PlpGridProductInfoTestingOptions$PlpGridProductInfoExperiment[];
            static final int $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[];

            static 
            {
                $SwitchMap$com$target$ui$taplytics$options$PlpGridProductInfoTestingOptions$PlpGridProductInfoExperiment = new int[com.target.ui.j.b.h.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PlpGridProductInfoTestingOptions$PlpGridProductInfoExperiment[com.target.ui.j.b.h.a.EXPERIMENT_DEALS_TAG_AND_RATING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PlpGridProductInfoTestingOptions$PlpGridProductInfoExperiment[com.target.ui.j.b.h.a.EXPERIMENT_DEALS_TAG_ONLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PlpGridProductInfoTestingOptions$PlpGridProductInfoExperiment[com.target.ui.j.b.h.a.EXPERIMENT_DEFAULT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$com$target$ui$taplytics$options$PdpExpressCheckoutTestingOptions$PdpExpressCheckoutExperiment = new int[com.target.ui.j.b.g.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PdpExpressCheckoutTestingOptions$PdpExpressCheckoutExperiment[com.target.ui.j.b.g.a.EXPERIMENT_SHOW_EXPRESS_CHECKOUT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PdpExpressCheckoutTestingOptions$PdpExpressCheckoutExperiment[com.target.ui.j.b.g.a.EXPERIMENT_DEFAULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$target$ui$taplytics$options$DealsTabTestingOptions$DealsTabExperiment = new int[com.target.ui.j.b.c.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$DealsTabTestingOptions$DealsTabExperiment[com.target.ui.j.b.c.a.EXPERIMENT_NEW_TAB.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$DealsTabTestingOptions$DealsTabExperiment[com.target.ui.j.b.c.a.EXPERIMENT_DEFAULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$com$target$ui$taplytics$options$CartRecommendationsTestingOptions$CartRecommendationsExperiment = new int[com.target.ui.j.b.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$CartRecommendationsTestingOptions$CartRecommendationsExperiment[com.target.ui.j.b.b.a.EXPERIMENT_SHOW_RECOMMENDATIONS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$CartRecommendationsTestingOptions$CartRecommendationsExperiment[com.target.ui.j.b.b.a.EXPERIMENT_DEFAULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment = new int[com.target.ui.j.b.i.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_BUY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$PurchaseCTATestingOptions$PurchaseCTAExperiment[com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_DEFAULT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.PlpGridProductInfoTestingOptions.PlpGridProductInfoExperiment[com.target.ui.j.b.a.a().g().a().ordinal()])
        {
        default:
            return new e(list);

        case 1: // '\001'
            return new com.target.ui.adapter.product.a(list);

        case 2: // '\002'
            return new b(list);
        }
    }

    public static f a()
    {
        com.target.ui.j.b.a a1 = com.target.ui.j.b.a.a();
        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.PurchaseCTATestingOptions.PurchaseCTAExperiment[a1.c().a().ordinal()])
        {
        default:
            return new d();

        case 1: // '\001'
            return new com.target.ui.fragment.checkout.c.a();

        case 2: // '\002'
            return new com.target.ui.fragment.checkout.c.b();

        case 3: // '\003'
            return new c();

        case 4: // '\004'
            return new com.target.ui.fragment.checkout.c.e();
        }
    }

    public static com.target.ui.fragment.shop.b.e a(com.target.a.a.a a1)
    {
        return (new com.target.ui.fragment.cardstream.i(k.a(), com.target.ui.j.b.a.a(), a1)).a();
    }

    public static com.target.ui.fragment.shop.b.f a(PromotionRequest promotionrequest)
    {
        com.target.ui.j.b.a a1 = com.target.ui.j.b.a.a();
        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.DealsTabTestingOptions.DealsTabExperiment[a1.f().a().ordinal()])
        {
        default:
            return new com.target.ui.fragment.shop.b.c(promotionrequest);

        case 1: // '\001'
            return new com.target.ui.fragment.shop.b.b(promotionrequest);
        }
    }

    public static com.target.ui.fragment.cart.b.a.a b()
    {
        com.target.ui.j.b.a a1 = com.target.ui.j.b.a.a();
        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.CartRecommendationsTestingOptions.CartRecommendationsExperiment[a1.e().a().ordinal()])
        {
        default:
            return new com.target.ui.fragment.cart.b.a.b(new com.target.ui.helper.b.a());

        case 1: // '\001'
            return new com.target.ui.fragment.cart.b.a.c(new com.target.ui.helper.b.a());
        }
    }

    public static com.target.ui.fragment.product.pdp.presenter.a.a c()
    {
        com.target.ui.j.b.a a1 = com.target.ui.j.b.a.a();
        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.PdpExpressCheckoutTestingOptions.PdpExpressCheckoutExperiment[a1.b().a().ordinal()])
        {
        default:
            return new com.target.ui.fragment.product.pdp.presenter.a.b();

        case 1: // '\001'
            return new com.target.ui.fragment.product.pdp.presenter.a.c();
        }
    }
}
