// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.listenerinterface;

import java.util.ArrayList;

public interface SearchCallback
{

    public abstract void onSearchFailed(int i);

    public abstract void onSearchSuccess(ArrayList arraylist);
}
