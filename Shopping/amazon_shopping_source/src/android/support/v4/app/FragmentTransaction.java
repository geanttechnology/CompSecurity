// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            Fragment

public abstract class FragmentTransaction
{

    public FragmentTransaction()
    {
    }

    public abstract FragmentTransaction add(int i, Fragment fragment);

    public abstract FragmentTransaction add(int i, Fragment fragment, String s);

    public abstract FragmentTransaction add(Fragment fragment, String s);

    public abstract FragmentTransaction addToBackStack(String s);

    public abstract FragmentTransaction attach(Fragment fragment);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract FragmentTransaction detach(Fragment fragment);

    public abstract boolean isAddToBackStackAllowed();

    public abstract FragmentTransaction remove(Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment, String s);

    public abstract FragmentTransaction show(Fragment fragment);
}
