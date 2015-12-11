// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import java.io.IOException;
import java.util.List;

public interface AsyncList
    extends List
{
    public static interface NetworkListObserver
    {

        public abstract void onChanged();

        public abstract void onGetNotReady();

        public abstract void onNetworkError(IOException ioexception);
    }


    public abstract void close();

    public abstract void registerObserver(NetworkListObserver networklistobserver);

    public abstract void unregisterObserver(NetworkListObserver networklistobserver);
}
