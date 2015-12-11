// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.AbstractDeal;
import com.groupon.service.core.AbTestService;
import java.util.Date;
import roboguice.util.Strings;

public class IncentivesUtil
{
    public static final class PromotionType extends Enum
    {

        private static final PromotionType $VALUES[];
        public static final PromotionType INCENTIVE;
        public static final PromotionType PROMO_CODE;
        private String name;

        public static PromotionType fromString(String s)
        {
            if (Strings.notEmpty(s))
            {
                PromotionType apromotiontype[] = values();
                int j = apromotiontype.length;
                for (int i = 0; i < j; i++)
                {
                    PromotionType promotiontype = apromotiontype[i];
                    if (Strings.equals(s, promotiontype.name))
                    {
                        return promotiontype;
                    }
                }

            }
            return null;
        }

        public static PromotionType valueOf(String s)
        {
            return (PromotionType)Enum.valueOf(com/groupon/util/IncentivesUtil$PromotionType, s);
        }

        public static PromotionType[] values()
        {
            return (PromotionType[])$VALUES.clone();
        }

        static 
        {
            PROMO_CODE = new PromotionType("PROMO_CODE", 0, "promocode");
            INCENTIVE = new PromotionType("INCENTIVE", 1, "incentive");
            $VALUES = (new PromotionType[] {
                PROMO_CODE, INCENTIVE
            });
        }

        private PromotionType(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    private static final String PROMOTION_TYPE_INCENTIVE = "incentive";
    private static final String PROMOTION_TYPE_PROMO_CODE = "promocode";
    private AbTestService abTestService;

    public IncentivesUtil()
    {
    }

    public String getIncentiveLongTitle(AbstractDeal abstractdeal, boolean flag)
    {
label0:
        {
            PromotionType promotiontype = getPromotionType(abstractdeal);
            if (shouldDisplayIncentive(promotiontype, flag))
            {
                String s = abstractdeal.incentivePromoCode;
                Date date = abstractdeal.incentiveExpiryDate;
                boolean flag1;
                if (date != null && (new Date()).after(date))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1 && (promotiontype != PromotionType.PROMO_CODE || !Strings.isEmpty(s)))
                {
                    break label0;
                }
            }
            return null;
        }
        return abstractdeal.incentiveLongMessage;
    }

    public String getIncentivePromoCode(AbstractDeal abstractdeal)
    {
        return getIncentivePromoCode(abstractdeal, false);
    }

    public String getIncentivePromoCode(AbstractDeal abstractdeal, boolean flag)
    {
label0:
        {
            if (shouldDisplayIncentive(getPromotionType(abstractdeal), flag))
            {
                Date date = abstractdeal.incentiveExpiryDate;
                boolean flag1;
                if (date != null && (new Date()).after(date))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    break label0;
                }
            }
            return null;
        }
        return abstractdeal.incentivePromoCode;
    }

    public String getIncentiveShortTitle(AbstractDeal abstractdeal, boolean flag)
    {
label0:
        {
            PromotionType promotiontype = getPromotionType(abstractdeal);
            if (shouldDisplayIncentive(promotiontype, flag))
            {
                String s = abstractdeal.incentivePromoCode;
                Date date = abstractdeal.incentiveExpiryDate;
                boolean flag1;
                if (date != null && (new Date()).after(date))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1 && (promotiontype != PromotionType.PROMO_CODE || !Strings.isEmpty(s)))
                {
                    break label0;
                }
            }
            return null;
        }
        return abstractdeal.incentiveShortMessage;
    }

    public PromotionType getPromotionType(AbstractDeal abstractdeal)
    {
        return PromotionType.fromString(abstractdeal.incentivePromotionType);
    }

    public boolean isExperimentEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("incentiveCRM1504USCA", "on");
    }

    public boolean isValidPromotionType(PromotionType promotiontype)
    {
        return promotiontype == PromotionType.PROMO_CODE || promotiontype == PromotionType.INCENTIVE;
    }

    public boolean shouldDisplayIncentive(PromotionType promotiontype, boolean flag)
    {
        return isExperimentEnabled() && !flag && isValidPromotionType(promotiontype);
    }
}
