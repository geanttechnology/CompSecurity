// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.Context;

public interface AsyncResult
{
    public static interface Callback
    {

        public abstract void deliverResult(Object obj);

        public abstract Context getContext();

        public abstract boolean isAbandoned();

        public abstract void onCanceled(Object obj);
    }


    public abstract boolean cancelLoad();

    public abstract void startLoad();
}
