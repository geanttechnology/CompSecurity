// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces;

import android.os.Parcelable;
import com.google.a.a.e;
import java.util.Date;

public interface ListItem
    extends Parcelable
{

    public abstract int getDesiredQuantity();

    public abstract long getItemPosition();

    public abstract int getKey();

    public abstract Date getLastModifiedDate();

    public abstract String getListId();

    public abstract String getListItemId();

    public abstract int getListKey();

    public abstract String getNote();

    public abstract int getPurchasedQuantity();

    public abstract Date getServerLastModifiedDate();

    public abstract e getTcin();

    public abstract String getTitle();

    public abstract boolean isCompleted();

    public abstract boolean isDeleting();

    public abstract boolean isDirty();

    public abstract boolean isFulfilled();
}
