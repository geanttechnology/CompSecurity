// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            Fragment, m

public abstract class k
{
    public static interface a
    {

        public abstract void a();
    }


    public k()
    {
    }

    public abstract Fragment.SavedState a(Fragment fragment);

    public abstract Fragment a(int i);

    public abstract Fragment a(Bundle bundle, String s);

    public abstract Fragment a(String s);

    public abstract m a();

    public abstract void a(Bundle bundle, String s, Fragment fragment);

    public abstract void a(a a1);

    public abstract void b(int i);

    public abstract boolean b();

    public abstract void c();

    public abstract boolean d();

    public abstract int e();

    public abstract List f();

    public abstract boolean g();
}
