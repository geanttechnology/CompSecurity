// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.query:
//            zza, SortOrder, Filter

public class Query
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final List zzajA;
    private final Set zzajB;
    final boolean zzalC;
    final LogicalFilter zzanK;
    final String zzanL;
    final SortOrder zzanM;
    final List zzanN;
    final boolean zzanO;

    private Query(int i, LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, List list1, 
            Set set, boolean flag1)
    {
        mVersionCode = i;
        zzanK = logicalfilter;
        zzanL = s;
        zzanM = sortorder;
        zzanN = list;
        zzanO = flag;
        zzajA = list1;
        zzajB = set;
        zzalC = flag1;
    }

    Query(int i, LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, List list1, 
            boolean flag1)
    {
        Object obj;
        if (list1 == null)
        {
            obj = null;
        } else
        {
            obj = new HashSet(list1);
        }
        this(i, logicalfilter, s, sortorder, list, flag, list1, ((Set) (obj)), flag1);
    }

    private Query(LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, Set set, boolean flag1)
    {
        Object obj;
        if (set == null)
        {
            obj = null;
        } else
        {
            obj = new ArrayList(set);
        }
        this(1, logicalfilter, s, sortorder, list, flag, ((List) (obj)), set, flag1);
    }

    Query(LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, Set set, boolean flag1, 
            _cls1 _pcls1)
    {
        this(logicalfilter, s, sortorder, list, flag, set, flag1);
    }

    public int describeContents()
    {
        return 0;
    }

    public Filter getFilter()
    {
        return zzanK;
    }

    public String getPageToken()
    {
        return zzanL;
    }

    public SortOrder getSortOrder()
    {
        return zzanM;
    }

    public String toString()
    {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] {
            zzanK, zzanM, zzanL, zzajA
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public List zzrO()
    {
        return zzanN;
    }

    public boolean zzrP()
    {
        return zzanO;
    }

    public Set zzrQ()
    {
        return zzajB;
    }

    public boolean zzrR()
    {
        return zzalC;
    }

}
