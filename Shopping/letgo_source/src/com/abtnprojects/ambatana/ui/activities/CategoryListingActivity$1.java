// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v7.ho;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            CategoryListingActivity

class a extends android.support.v7.widget.Lookup
{

    final CategoryListingActivity a;

    public int getSpanSize(int i)
    {
        switch (CategoryListingActivity.a(a).getItemViewType(i))
        {
        default:
            return -1;

        case 1: // '\001'
            return CategoryListingActivity.b(a);

        case 0: // '\0'
            return 1;
        }
    }

    (CategoryListingActivity categorylistingactivity)
    {
        a = categorylistingactivity;
        super();
    }
}
