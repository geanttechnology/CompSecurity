// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.view.View;
import com.groupon.db.models.DealCollection;

public interface CollectionCardCallback
{

    public abstract void onCollectionCardBound(DealCollection dealcollection);

    public abstract void onCollectionCardClicked(View view, DealCollection dealcollection);
}
