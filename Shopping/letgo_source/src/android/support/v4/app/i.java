// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            Fragment, m

public abstract class i
{
    public static interface a
    {

        public abstract void a();
    }


    public i()
    {
    }

    public abstract Fragment.SavedState a(Fragment fragment);

    public abstract Fragment a(int j);

    public abstract Fragment a(Bundle bundle, String s);

    public abstract Fragment a(String s);

    public abstract m a();

    public abstract void a(int j, int k);

    public abstract void a(Bundle bundle, String s, Fragment fragment);

    public abstract boolean b();

    public abstract List c();

    public abstract boolean d();
}
