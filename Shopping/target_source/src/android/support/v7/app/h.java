// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            k, j, AppCompatDelegateImplV7, g, 
//            a

public abstract class h
{

    h()
    {
    }

    public static h a(Activity activity, g g1)
    {
        return a(((Context) (activity)), activity.getWindow(), g1);
    }

    public static h a(Dialog dialog, g g1)
    {
        return a(dialog.getContext(), dialog.getWindow(), g1);
    }

    private static h a(Context context, Window window, g g1)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            return new k(context, window, g1);
        }
        if (i >= 11)
        {
            return new j(context, window, g1);
        } else
        {
            return new AppCompatDelegateImplV7(context, window, g1);
        }
    }

    public abstract a a();

    public abstract void a(int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void a(CharSequence charsequence);

    public abstract MenuInflater b();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract boolean b(int i);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract b.a g();

    public abstract void h();
}
