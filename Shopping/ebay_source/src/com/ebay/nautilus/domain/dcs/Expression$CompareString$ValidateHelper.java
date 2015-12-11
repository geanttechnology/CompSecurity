// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, DcsUtil

final class validation
{

    final Object localeCountry;
    final Object localeLanguage;
    final Object prefCountry;
    final Object prefLanguage;
    final localeLanguage this$0;
    final Object user;
    final DcsUtil validation;

    boolean needsValidation(validation validation1)
    {
        return validation1 == prefCountry || validation1 == prefLanguage || validation1 == localeCountry || validation1 == localeLanguage || validation1 == user;
    }

    void validate(user user1, String s)
        throws DcsException
    {
        if (user1 == prefCountry || user1 == localeCountry)
        {
            if (s.length() != 2 || s.charAt(0) < 'A' || s.charAt(0) > 'Z' || s.charAt(1) < 'A' || s.charAt(1) > 'Z')
            {
                throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
            }
            if (user1 == prefCountry && !validation.prefCountryCodes.contains(s))
            {
                throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
            }
        } else
        if ((user1 == prefLanguage || user1 == localeLanguage) && (s.length() != 2 || s.charAt(0) < 'a' || s.charAt(0) > 'z' || s.charAt(1) < 'a' || s.charAt(1) > 'z'))
        {
            throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
        }
    }

    public (DcsUtil dcsutil)
    {
        this$0 = this._cls0.this;
        super();
        prefCountry = Expression.variables.get("prefCountry");
        prefLanguage = Expression.variables.get("prefLanguage");
        localeCountry = Expression.variables.get("localeCountry");
        localeLanguage = Expression.variables.get("localeLanguage");
        user = Expression.variables.get("user");
        validation = dcsutil;
    }
}
