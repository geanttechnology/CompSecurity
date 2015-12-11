// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query:
//            SearchableField, Filter

public class Filters
{

    public Filters()
    {
    }

    public static transient Filter and(Filter filter, Filter afilter[])
    {
        return new LogicalFilter(Operator.si, filter, afilter);
    }

    public static Filter and(List list)
    {
        return new LogicalFilter(Operator.si, list);
    }

    public static Filter contains(MetadataField metadatafield, String s)
    {
        return new ComparisonFilter(Operator.sl, metadatafield, s);
    }

    public static Filter eq(MetadataField metadatafield, Object obj)
    {
        return new ComparisonFilter(Operator.sd, metadatafield, obj);
    }

    public static Filter greaterThan(OrderedMetadataField orderedmetadatafield, Comparable comparable)
    {
        return new ComparisonFilter(Operator.sg, orderedmetadatafield, comparable);
    }

    public static Filter greaterThanEquals(OrderedMetadataField orderedmetadatafield, Comparable comparable)
    {
        return new ComparisonFilter(Operator.sh, orderedmetadatafield, comparable);
    }

    public static Filter in(CollectionMetadataField collectionmetadatafield, Object obj)
    {
        return new InFilter(collectionmetadatafield, obj);
    }

    public static Filter lessThan(OrderedMetadataField orderedmetadatafield, Comparable comparable)
    {
        return new ComparisonFilter(Operator.se, orderedmetadatafield, comparable);
    }

    public static Filter lessThanEquals(OrderedMetadataField orderedmetadatafield, Comparable comparable)
    {
        return new ComparisonFilter(Operator.sf, orderedmetadatafield, comparable);
    }

    public static Filter not(Filter filter)
    {
        return new NotFilter(filter);
    }

    public static transient Filter or(Filter filter, Filter afilter[])
    {
        return new LogicalFilter(Operator.sj, filter, afilter);
    }

    public static Filter or(List list)
    {
        return new LogicalFilter(Operator.sj, list);
    }

    public static Filter sharedWithMe()
    {
        return new FieldOnlyFilter(SearchableField.rM);
    }
}
