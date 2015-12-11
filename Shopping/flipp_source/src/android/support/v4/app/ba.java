// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.k;

public interface ba
{

    public abstract k onCreateLoader(int i, Bundle bundle);

    public abstract void onLoadFinished(k k, Object obj);

    public abstract void onLoaderReset(k k);
}
