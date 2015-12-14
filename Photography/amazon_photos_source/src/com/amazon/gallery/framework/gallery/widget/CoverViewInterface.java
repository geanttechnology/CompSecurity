// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.View;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;

public interface CoverViewInterface
{

    public abstract View createCoverView(Context context, Persistable persistable);

    public abstract ItemViewHolder createViewHolder(Persistable persistable, View view);

    public abstract void onActivityPaused();

    public abstract void onActivityResumed();
}
