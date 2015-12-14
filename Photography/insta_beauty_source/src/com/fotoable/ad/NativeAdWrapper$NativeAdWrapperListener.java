// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.view.View;
import aqe;

public interface 
{

    public abstract void onAdDelayReload();

    public abstract void onAdFailedToLoad(int i);

    public abstract void onAdLoaded(View view, aqe aqe);
}
