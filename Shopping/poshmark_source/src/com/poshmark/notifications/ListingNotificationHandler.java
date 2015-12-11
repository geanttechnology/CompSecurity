// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.inner_models.Comment;

public interface ListingNotificationHandler
{

    public abstract void addCommentToListing(String s, Comment comment);

    public abstract void deleteListing(String s);

    public abstract void likeListing(String s, boolean flag);

    public abstract void newListingCreated();

    public abstract void updateListing(ListingDetails listingdetails);
}
