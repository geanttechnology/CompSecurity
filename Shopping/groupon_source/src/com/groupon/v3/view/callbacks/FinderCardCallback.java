// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.view.View;
import com.groupon.db.models.Finder;

public interface FinderCardCallback
{

    public abstract void onFinderCardBound(Finder finder);

    public abstract void onFinderCardClicked(View view, Finder finder);
}
