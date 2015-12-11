// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemPlaceBidActivity

protected static class 
    implements InputFilter
{

    static final Pattern pattern = Pattern.compile("\\d*([\\,\\.][\\d]{0,1})?");

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (!pattern.matcher(spanned).matches())
        {
            return "";
        } else
        {
            return null;
        }
    }


    protected ()
    {
    }
}
