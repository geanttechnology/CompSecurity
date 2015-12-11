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
    private final Filter zzajh;
    final ComparisonFilter zzanZ;
    final FieldOnlyFilter zzaoa;
    final LogicalFilter zzaob;
    final NotFilter zzaoc;
    final InFilter zzaod;
    final MatchAllFilter zzaoe;
    final HasFilter zzaof;
    final FullTextSearchFilter zzaog;
    final OwnedByMeFilter zzaoh;

    FilterHolder(int i, ComparisonFilter comparisonfilter, FieldOnlyFilter fieldonlyfilter, LogicalFilter logicalfilter, NotFilter notfilter, InFilter infilter, MatchAllFilter matchallfilter, 
            HasFilter hasfilter, FullTextSearchFilter fulltextsearchfilter, OwnedByMeFilter ownedbymefilter)
    {
        mVersionCode = i;
        zzanZ = comparisonfilter;
        zzaoa = fieldonlyfilter;
        zzaob = logicalfilter;
        zzaoc = notfilter;
        zzaod = infilter;
        zzaoe = matchallfilter;
        zzaof = hasfilter;
        zzaog = fulltextsearchfilter;
        zzaoh = ownedbymefilter;
        if (zzanZ != null)
        {
            zzajh = zzanZ;
            return;
        }
        if (zzaoa != null)
        {
            zzajh = zzaoa;
            return;
        }
        if (zzaob != null)
        {
            zzajh = zzaob;
            return;
        }
        if (zzaoc != null)
        {
            zzajh = zzaoc;
            return;
        }
        if (zzaod != null)
        {
            zzajh = zzaod;
            return;
        }
        if (zzaoe != null)
        {
            zzajh = zzaoe;
            return;
        }
        if (zzaof != null)
        {
            zzajh = zzaof;
            return;
        }
        if (zzaog != null)
        {
            zzajh = zzaog;
            return;
        }
        if (zzaoh != null)
        {
            zzajh = zzaoh;
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
        zzanZ = ((ComparisonFilter) (obj));
        if (filter instanceof FieldOnlyFilter)
        {
            obj = (FieldOnlyFilter)filter;
        } else
        {
            obj = null;
        }
        zzaoa = ((FieldOnlyFilter) (obj));
        if (filter instanceof LogicalFilter)
        {
            obj = (LogicalFilter)filter;
        } else
        {
            obj = null;
        }
        zzaob = ((LogicalFilter) (obj));
        if (filter instanceof NotFilter)
        {
            obj = (NotFilter)filter;
        } else
        {
            obj = null;
        }
        zzaoc = ((NotFilter) (obj));
        if (filter instanceof InFilter)
        {
            obj = (InFilter)filter;
        } else
        {
            obj = null;
        }
        zzaod = ((InFilter) (obj));
        if (filter instanceof MatchAllFilter)
        {
            obj = (MatchAllFilter)filter;
        } else
        {
            obj = null;
        }
        zzaoe = ((MatchAllFilter) (obj));
        if (filter instanceof HasFilter)
        {
            obj = (HasFilter)filter;
        } else
        {
            obj = null;
        }
        zzaof = ((HasFilter) (obj));
        if (filter instanceof FullTextSearchFilter)
        {
            obj = (FullTextSearchFilter)filter;
        } else
        {
            obj = null;
        }
        zzaog = ((FullTextSearchFilter) (obj));
        if (filter instanceof OwnedByMeFilter)
        {
            obj = (OwnedByMeFilter)filter;
        } else
        {
            obj = null;
        }
        zzaoh = ((OwnedByMeFilter) (obj));
        if (zzanZ == null && zzaoa == null && zzaob == null && zzaoc == null && zzaod == null && zzaoe == null && zzaof == null && zzaog == null && zzaoh == null)
        {
            throw new IllegalArgumentException("Invalid filter type.");
        } else
        {
            zzajh = filter;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Filter getFilter()
    {
        return zzajh;
    }

    public String toString()
    {
        return String.format("FilterHolder[%s]", new Object[] {
            zzajh
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
