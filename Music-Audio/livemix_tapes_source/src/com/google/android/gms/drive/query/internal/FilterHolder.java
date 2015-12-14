// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            zzd, ComparisonFilter, FieldOnlyFilter, LogicalFilter, 
//            NotFilter, InFilter, MatchAllFilter, HasFilter, 
//            FullTextSearchFilter, OwnedByMeFilter

public class FilterHolder
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    private final Filter zzagW;
    final FieldOnlyFilter zzalA;
    final LogicalFilter zzalB;
    final NotFilter zzalC;
    final InFilter zzalD;
    final MatchAllFilter zzalE;
    final HasFilter zzalF;
    final FullTextSearchFilter zzalG;
    final OwnedByMeFilter zzalH;
    final ComparisonFilter zzalz;

    FilterHolder(int i, ComparisonFilter comparisonfilter, FieldOnlyFilter fieldonlyfilter, LogicalFilter logicalfilter, NotFilter notfilter, InFilter infilter, MatchAllFilter matchallfilter, 
            HasFilter hasfilter, FullTextSearchFilter fulltextsearchfilter, OwnedByMeFilter ownedbymefilter)
    {
        mVersionCode = i;
        zzalz = comparisonfilter;
        zzalA = fieldonlyfilter;
        zzalB = logicalfilter;
        zzalC = notfilter;
        zzalD = infilter;
        zzalE = matchallfilter;
        zzalF = hasfilter;
        zzalG = fulltextsearchfilter;
        zzalH = ownedbymefilter;
        if (zzalz != null)
        {
            zzagW = zzalz;
            return;
        }
        if (zzalA != null)
        {
            zzagW = zzalA;
            return;
        }
        if (zzalB != null)
        {
            zzagW = zzalB;
            return;
        }
        if (zzalC != null)
        {
            zzagW = zzalC;
            return;
        }
        if (zzalD != null)
        {
            zzagW = zzalD;
            return;
        }
        if (zzalE != null)
        {
            zzagW = zzalE;
            return;
        }
        if (zzalF != null)
        {
            zzagW = zzalF;
            return;
        }
        if (zzalG != null)
        {
            zzagW = zzalG;
            return;
        }
        if (zzalH != null)
        {
            zzagW = zzalH;
            return;
        } else
        {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter)
    {
        zzx.zzb(filter, "Null filter.");
        mVersionCode = 2;
        Object obj;
        if (filter instanceof ComparisonFilter)
        {
            obj = (ComparisonFilter)filter;
        } else
        {
            obj = null;
        }
        zzalz = ((ComparisonFilter) (obj));
        if (filter instanceof FieldOnlyFilter)
        {
            obj = (FieldOnlyFilter)filter;
        } else
        {
            obj = null;
        }
        zzalA = ((FieldOnlyFilter) (obj));
        if (filter instanceof LogicalFilter)
        {
            obj = (LogicalFilter)filter;
        } else
        {
            obj = null;
        }
        zzalB = ((LogicalFilter) (obj));
        if (filter instanceof NotFilter)
        {
            obj = (NotFilter)filter;
        } else
        {
            obj = null;
        }
        zzalC = ((NotFilter) (obj));
        if (filter instanceof InFilter)
        {
            obj = (InFilter)filter;
        } else
        {
            obj = null;
        }
        zzalD = ((InFilter) (obj));
        if (filter instanceof MatchAllFilter)
        {
            obj = (MatchAllFilter)filter;
        } else
        {
            obj = null;
        }
        zzalE = ((MatchAllFilter) (obj));
        if (filter instanceof HasFilter)
        {
            obj = (HasFilter)filter;
        } else
        {
            obj = null;
        }
        zzalF = ((HasFilter) (obj));
        if (filter instanceof FullTextSearchFilter)
        {
            obj = (FullTextSearchFilter)filter;
        } else
        {
            obj = null;
        }
        zzalG = ((FullTextSearchFilter) (obj));
        if (filter instanceof OwnedByMeFilter)
        {
            obj = (OwnedByMeFilter)filter;
        } else
        {
            obj = null;
        }
        zzalH = ((OwnedByMeFilter) (obj));
        if (zzalz == null && zzalA == null && zzalB == null && zzalC == null && zzalD == null && zzalE == null && zzalF == null && zzalG == null && zzalH == null)
        {
            throw new IllegalArgumentException("Invalid filter type.");
        } else
        {
            zzagW = filter;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Filter getFilter()
    {
        return zzagW;
    }

    public String toString()
    {
        return String.format("FilterHolder[%s]", new Object[] {
            zzagW
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
