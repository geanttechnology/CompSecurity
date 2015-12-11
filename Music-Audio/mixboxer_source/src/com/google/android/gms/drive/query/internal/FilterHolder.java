// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            c, ComparisonFilter, FieldOnlyFilter, LogicalFilter, 
//            NotFilter, InFilter

public class FilterHolder
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new c();
    final int kg;
    final ComparisonFilter rU;
    final FieldOnlyFilter rV;
    final LogicalFilter rW;
    final NotFilter rX;
    final InFilter rY;
    private final Filter rZ;

    FilterHolder(int i, ComparisonFilter comparisonfilter, FieldOnlyFilter fieldonlyfilter, LogicalFilter logicalfilter, NotFilter notfilter, InFilter infilter)
    {
        kg = i;
        rU = comparisonfilter;
        rV = fieldonlyfilter;
        rW = logicalfilter;
        rX = notfilter;
        rY = infilter;
        if (rU != null)
        {
            rZ = rU;
            return;
        }
        if (rV != null)
        {
            rZ = rV;
            return;
        }
        if (rW != null)
        {
            rZ = rW;
            return;
        }
        if (rX != null)
        {
            rZ = rX;
            return;
        }
        if (rY != null)
        {
            rZ = rY;
            return;
        } else
        {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter)
    {
        kg = 1;
        Object obj;
        if (filter instanceof ComparisonFilter)
        {
            obj = (ComparisonFilter)filter;
        } else
        {
            obj = null;
        }
        rU = ((ComparisonFilter) (obj));
        if (filter instanceof FieldOnlyFilter)
        {
            obj = (FieldOnlyFilter)filter;
        } else
        {
            obj = null;
        }
        rV = ((FieldOnlyFilter) (obj));
        if (filter instanceof LogicalFilter)
        {
            obj = (LogicalFilter)filter;
        } else
        {
            obj = null;
        }
        rW = ((LogicalFilter) (obj));
        if (filter instanceof NotFilter)
        {
            obj = (NotFilter)filter;
        } else
        {
            obj = null;
        }
        rX = ((NotFilter) (obj));
        if (filter instanceof InFilter)
        {
            obj = (InFilter)filter;
        } else
        {
            obj = null;
        }
        rY = ((InFilter) (obj));
        if (rU == null && rV == null && rW == null && rX == null && rY == null)
        {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        } else
        {
            rZ = filter;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        c.a(this, parcel, i);
    }

}
