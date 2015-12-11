// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.widget.Filter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7:
//            hv

class nit> extends Filter
{

    final hv a;

    protected android.widget.r.FilterResults performFiltering(CharSequence charsequence)
    {
        android.widget.r.FilterResults filterresults = new android.widget.r.FilterResults();
        if (charsequence != null)
        {
            hv.a(a, hv.a(a, charsequence.toString()));
            filterresults.values = hv.a(a);
            int i;
            if (hv.a(a) == null)
            {
                i = 0;
            } else
            {
                i = hv.a(a).size();
            }
            filterresults.count = i;
        }
        return filterresults;
    }

    protected void publishResults(CharSequence charsequence, android.widget.r.FilterResults filterresults)
    {
        a.notifyDataSetChanged();
    }

    lterResults(hv hv1)
    {
        a = hv1;
        super();
    }
}
