// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ap

public final class ao extends Observable
{

    ao()
    {
    }

    public final void a(int i)
    {
        for (int j = mObservers.size() - 1; j >= 0; j--)
        {
            ((ap)mObservers.get(j)).a(i);
        }

    }

    public final void a(int i, int j)
    {
        for (int k = mObservers.size() - 1; k >= 0; k--)
        {
            ((ap)mObservers.get(k)).a(i, j);
        }

    }

    public final boolean a()
    {
        return !mObservers.isEmpty();
    }

    public final void b()
    {
        for (int i = mObservers.size() - 1; i >= 0; i--)
        {
            ((ap)mObservers.get(i)).a();
        }

    }

    public final void b(int i, int j)
    {
        for (int k = mObservers.size() - 1; k >= 0; k--)
        {
            ((ap)mObservers.get(k)).b(i, j);
        }

    }
}
