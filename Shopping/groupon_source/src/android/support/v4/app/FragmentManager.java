// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import java.util.List;

// Referenced classes of package android.support.v4.app:
//            FragmentTransaction, Fragment

public abstract class FragmentManager
{
    public static interface OnBackStackChangedListener
    {

        public abstract void onBackStackChanged();
    }


    public FragmentManager()
    {
    }

    public abstract FragmentTransaction beginTransaction();

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentByTag(String s);

    public abstract List getFragments();

    public abstract void popBackStack(int i, int j);
}
