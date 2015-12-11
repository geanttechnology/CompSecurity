// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.content.res.Resources;

// Referenced classes of package com.ebay.shared.ui:
//            SearchRefinementSummary

private static final class resources
{

    private final Resources resources;
    StringBuilder sb;

    public final void add(boolean flag, int i)
    {
        if (flag)
        {
            if (sb == null)
            {
                sb = new StringBuilder();
            } else
            {
                sb.append("; ");
            }
            sb.append(resources.getString(i));
        }
    }

    public final transient void add(boolean flag, int i, Object aobj[])
    {
        if (flag)
        {
            if (sb == null)
            {
                sb = new StringBuilder();
            } else
            {
                sb.append("; ");
            }
            sb.append(resources.getString(i, aobj));
        }
    }

    public final boolean isEmpty()
    {
        return sb == null;
    }

    public String toString()
    {
        if (sb == null)
        {
            return super.toString();
        } else
        {
            return sb.toString();
        }
    }

    public (Resources resources1)
    {
        sb = null;
        resources = resources1;
    }
}
