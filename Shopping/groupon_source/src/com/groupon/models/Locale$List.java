// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.models.country.json.Locales;
import java.util.ArrayList;

// Referenced classes of package com.groupon.models:
//            Locale

public static class > extends ArrayList
{

    public .Locales(Locales locales)
    {
        locales = locales.languages;
        int j = locales.length;
        for (int i = 0; i < j; i++)
        {
            add(new Locale(locales[i]));
        }

    }
}
