// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.text.SpannableString;

// Referenced classes of package com.ebay.shared.ui:
//            SearchRefinementSummary

private static final class flags
{

    public int end;
    private final int flags;
    public int start;
    public Object what;

    public final void setSpan(SpannableString spannablestring)
    {
        spannablestring.setSpan(what, start, end, flags);
    }

    public (Object obj, int i, int j, int k)
    {
        what = obj;
        start = i;
        end = j;
        flags = k;
    }
}
