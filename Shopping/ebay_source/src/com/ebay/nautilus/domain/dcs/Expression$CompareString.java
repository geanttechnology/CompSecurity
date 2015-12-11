// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, Operator, DcsState, 
//            DcsUtil

static final class ion extends ion
    implements ion
{
    final class ValidateHelper
    {

        final Object localeCountry;
        final Object localeLanguage;
        final Object prefCountry;
        final Object prefLanguage;
        final Expression.CompareString this$0;
        final Object user;
        final DcsUtil validation;

        boolean needsValidation(Expression.StringExpression stringexpression)
        {
            return stringexpression == prefCountry || stringexpression == prefLanguage || stringexpression == localeCountry || stringexpression == localeLanguage || stringexpression == user;
        }

        void validate(Expression.StringExpression stringexpression, String s)
            throws DcsException
        {
            if (stringexpression == prefCountry || stringexpression == localeCountry)
            {
                if (s.length() != 2 || s.charAt(0) < 'A' || s.charAt(0) > 'Z' || s.charAt(1) < 'A' || s.charAt(1) > 'Z')
                {
                    throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
                }
                if (stringexpression == prefCountry && !validation.prefCountryCodes.contains(s))
                {
                    throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
                }
            } else
            if ((stringexpression == prefLanguage || stringexpression == localeLanguage) && (s.length() != 2 || s.charAt(0) < 'a' || s.charAt(0) > 'z' || s.charAt(1) < 'a' || s.charAt(1) > 'z'))
            {
                throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
            }
        }

        public ValidateHelper(DcsUtil dcsutil)
        {
            this$0 = Expression.CompareString.this;
            super();
            prefCountry = Expression.variables.get("prefCountry");
            prefLanguage = Expression.variables.get("prefLanguage");
            localeCountry = Expression.variables.get("localeCountry");
            localeLanguage = Expression.variables.get("localeLanguage");
            user = Expression.variables.get("user");
            validation = dcsutil;
        }
    }


    public boolean eval(DcsState dcsstate)
        throws DcsException
    {
        boolean flag = true;
        String s = ((on)left).eval(dcsstate);
        dcsstate = ((on)right).eval(dcsstate);
        switch (com.ebay.nautilus.domain.dcs.Operator[op.ordinal()])
        {
        default:
            throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for string comparison!").toString());

        case 1: // '\001'
            return TextUtils.equals(s, dcsstate);

        case 2: // '\002'
            return !TextUtils.equals(s, dcsstate);

        case 3: // '\003'
            if (s == null || !s.matches(dcsstate))
            {
                flag = false;
            }
            return flag;

        case 4: // '\004'
            break;
        }
        if (s == null || dcsstate == null)
        {
            return false;
        }
        if (dcsstate.indexOf(',') == -1)
        {
            return dcsstate.equals(s);
        } else
        {
            return Arrays.asList(dcsstate.split("\\s*,\\s*")).contains(s);
        }
    }

    public void validate(DcsUtil dcsutil)
        throws DcsException
    {
        String s;
        on on;
        super.validate(dcsutil);
        if ((left instanceof left) && (right instanceof n))
        {
            on = (on)left;
            s = ((on)right).eval(null);
        } else
        if ((left instanceof n) && (right instanceof right))
        {
            on = (on)right;
            s = ((on)left).eval(null);
        } else
        {
            on = null;
            s = null;
        }
        if (on == null || s == null) goto _L2; else goto _L1
_L1:
        dcsutil = new ValidateHelper(dcsutil);
        if (!dcsutil.needsValidation(on)) goto _L2; else goto _L3
_L3:
        com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 169
    //                   2 169
    //                   3 116
    //                   4 224;
           goto _L2 _L4 _L4 _L2 _L5
_L2:
        return;
_L4:
        if (s.indexOf(',') != -1)
        {
            throw new DcsException((new StringBuilder()).append("Did you intend to use 'in' instead of '").append(op.symbol).append("'?").toString());
        } else
        {
            dcsutil.validate(on, s);
            return;
        }
_L5:
        if (s.indexOf(',') == -1)
        {
            dcsutil.validate(on, s);
            return;
        }
        String as[] = s.split("\\s*,\\s*");
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            dcsutil.validate(on, as[i]);
            i++;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public on(on on, on on1, Operator operator)
    {
        super(on, on1, operator);
    }
}
