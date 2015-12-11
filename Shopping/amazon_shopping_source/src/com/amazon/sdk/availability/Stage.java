// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import com.amazon.mas.client.SysPropHelper;
import com.amazon.mas.util.StringUtils;

final class Stage
{
    public static final class Domain extends Enum
    {

        private static final Domain $VALUES[];
        public static final Domain MASTER;
        public static final Domain PROD;

        public static Domain valueOf(String s)
        {
            return (Domain)Enum.valueOf(com/amazon/sdk/availability/Stage$Domain, s);
        }

        public static Domain[] values()
        {
            return (Domain[])$VALUES.clone();
        }

        static 
        {
            PROD = new Domain("PROD", 0);
            MASTER = new Domain("MASTER", 1);
            $VALUES = (new Domain[] {
                PROD, MASTER
            });
        }

        private Domain(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final Domain DOMAIN;

    private Stage()
    {
    }

    public static Domain getDomain()
    {
        Object obj = SysPropHelper.get("mas.availability.stage").getValue();
        if (!StringUtils.isEmpty(((String) (obj))))
        {
            try
            {
                obj = Domain.valueOf(((String) (obj)));
            }
            catch (Exception exception)
            {
                return DOMAIN;
            }
            return ((Domain) (obj));
        } else
        {
            return DOMAIN;
        }
    }

    public static boolean isProduction()
    {
        return getDomain() == Domain.PROD;
    }

    static 
    {
        DOMAIN = Domain.PROD;
    }
}
