// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import com.groupon.mvc.view.viewholder.DetailsHeaderViewHolder;

public interface OnRecyclerViewHeaderLoadedListener
{

    public abstract void onHeaderLoaded(DetailsHeaderViewHolder detailsheaderviewholder);

    public abstract void onHeaderReloaded(DetailsHeaderViewHolder detailsheaderviewholder);
}
