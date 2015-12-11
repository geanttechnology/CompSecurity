// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcelable;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import java.util.List;

public interface AggregateProductSummaryData
    extends Parcelable
{

    public abstract ProductSummaryWrapper a();

    public abstract List b();
}
