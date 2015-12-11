// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

final class MarketingCondition
{

    private final String mName;
    private final Opt mOpt;
    private String mPkgName;
    private final Vector mValues;

    MarketingCondition(String s, String s1, Vector vector)
    {
        mName = s;
        mOpt = stringToOperator(s1);
        mValues = vector;
    }

    private boolean isSatisfiedByNumber(String s)
    {
        int i;
        int j;
        boolean flag2;
        boolean flag = true;
        flag2 = false;
        s = new BigDecimal(s);
        j = s.compareTo(new BigDecimal((String)mValues.get(0)));
        if (mValues.size() > 1)
        {
            i = s.compareTo(new BigDecimal((String)mValues.get(1)));
        } else
        {
            i = 0;
        }
        _cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[mOpt.ordinal()];
        JVM INSTR tableswitch 1 8: default 132
    //                   1 143
    //                   2 158
    //                   3 204
    //                   4 165
    //                   5 172
    //                   6 179
    //                   7 186
    //                   8 193;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        flag = false;
_L11:
        return flag;
_L2:
        boolean flag1 = flag2;
        if (j == 0)
        {
            flag1 = true;
        }
        return flag1;
_L3:
        if (j != 0) goto _L11; else goto _L10
_L10:
        return false;
_L5:
        if (j > 0) goto _L11; else goto _L12
_L12:
        return false;
_L6:
        if (j >= 0) goto _L11; else goto _L13
_L13:
        return false;
_L7:
        if (j < 0) goto _L11; else goto _L14
_L14:
        return false;
_L8:
        if (j <= 0) goto _L11; else goto _L15
_L15:
        return false;
_L9:
        if (j >= 0 && i <= 0) goto _L11; else goto _L16
_L16:
        return false;
_L4:
        Iterator iterator = mValues.iterator();
        while (iterator.hasNext()) 
        {
            if (s.compareTo(new BigDecimal((String)iterator.next())) == 0)
            {
                return true;
            }
        }
        if (true) goto _L1; else goto _L17
_L17:
    }

    private boolean isSatisfiedByString(String s)
    {
        Iterator iterator;
        switch (_cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[mOpt.ordinal()])
        {
        default:
            return isSatisfiedByNumber(s);

        case 1: // '\001'
            return s.equals(mValues.get(0));

        case 2: // '\002'
            return !s.equals(mValues.get(0));

        case 3: // '\003'
            iterator = mValues.iterator();
            break;
        }
        while (iterator.hasNext()) 
        {
            if (s.equals((String)iterator.next()))
            {
                return true;
            }
        }
        return false;
    }

    private String operatorToString(Opt opt)
    {
        switch (_cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[opt.ordinal()])
        {
        default:
            return "INVALID OPERATOR";

        case 1: // '\001'
            return "is equal to";

        case 2: // '\002'
            return "not equal to";

        case 4: // '\004'
            return "is greater than";

        case 5: // '\005'
            return "is greater than or equal to";

        case 6: // '\006'
            return "is less than";

        case 7: // '\007'
            return "is less than or equal to";

        case 8: // '\b'
            return "is in between values";

        case 3: // '\003'
            return "is a member of the list";
        }
    }

    private Opt stringToOperator(String s)
    {
        if (s.equals("eq"))
        {
            return Opt.EQUAL;
        }
        if (s.equals("neq"))
        {
            return Opt.NOT_EQUAL;
        }
        if (s.equals("gt"))
        {
            return Opt.GREATER_THAN;
        }
        if (s.equals("gte"))
        {
            return Opt.GREATER_THEN_OR_EQUAL;
        }
        if (s.equals("lt"))
        {
            return Opt.LESS_THAN;
        }
        if (s.equals("lte"))
        {
            return Opt.LESS_THAN_OR_EQUAL;
        }
        if (s.equals("btw"))
        {
            return Opt.BETWEEN;
        }
        if (s.equals("in"))
        {
            return Opt.IN_LIST;
        } else
        {
            return Opt.INVALID;
        }
    }

    final boolean isSatisfiedByAttributes(Map map)
    {
        if (map == null)
        {
            return false;
        }
        Object obj1 = map.get(mName);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = map.get((new StringBuilder()).append(mPkgName).append(":").append(mName).toString());
        }
        if (obj == null)
        {
            Localytics.Log.w(String.format("Could not find the in-app condition %s in the attributes dictionary.", new Object[] {
                mName
            }));
            return false;
        }
        boolean flag;
        if (obj instanceof String)
        {
            flag = isSatisfiedByString((String)obj);
        } else
        if (obj instanceof Number)
        {
            flag = isSatisfiedByNumber((String)obj);
        } else
        {
            Localytics.Log.w(String.format("Invalid value type %s in the attributes dictionary.", new Object[] {
                obj.getClass().getCanonicalName()
            }));
            flag = false;
        }
        return flag;
    }

    final void setPackageName(String s)
    {
        mPkgName = s;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$localytics$android$MarketingCondition$Opt[];

        static 
        {
            $SwitchMap$com$localytics$android$MarketingCondition$Opt = new int[Opt.values().length];
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.EQUAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.NOT_EQUAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.IN_LIST.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.GREATER_THAN.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.GREATER_THEN_OR_EQUAL.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.LESS_THAN.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.LESS_THAN_OR_EQUAL.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.BETWEEN.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.INVALID.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Opt extends Enum
    {

        private static final Opt $VALUES[];
        public static final Opt BETWEEN;
        public static final Opt EQUAL;
        public static final Opt GREATER_THAN;
        public static final Opt GREATER_THEN_OR_EQUAL;
        public static final Opt INVALID;
        public static final Opt IN_LIST;
        public static final Opt LESS_THAN;
        public static final Opt LESS_THAN_OR_EQUAL;
        public static final Opt NOT_EQUAL;

        public static Opt valueOf(String s)
        {
            return (Opt)Enum.valueOf(com/localytics/android/MarketingCondition$Opt, s);
        }

        public static Opt[] values()
        {
            return (Opt[])$VALUES.clone();
        }

        static 
        {
            INVALID = new Opt("INVALID", 0);
            EQUAL = new Opt("EQUAL", 1);
            NOT_EQUAL = new Opt("NOT_EQUAL", 2);
            GREATER_THAN = new Opt("GREATER_THAN", 3);
            GREATER_THEN_OR_EQUAL = new Opt("GREATER_THEN_OR_EQUAL", 4);
            LESS_THAN = new Opt("LESS_THAN", 5);
            LESS_THAN_OR_EQUAL = new Opt("LESS_THAN_OR_EQUAL", 6);
            BETWEEN = new Opt("BETWEEN", 7);
            IN_LIST = new Opt("IN_LIST", 8);
            $VALUES = (new Opt[] {
                INVALID, EQUAL, NOT_EQUAL, GREATER_THAN, GREATER_THEN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, BETWEEN, IN_LIST
            });
        }

        private Opt(String s, int i)
        {
            super(s, i);
        }
    }

}
