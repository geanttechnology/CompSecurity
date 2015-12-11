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
//            j, i, k, f, 
//            ActionBar

public abstract class g
{

    g()
    {
    }

    public static g a(Activity activity, f f1)
    {
        return a(((Context) (activity)), activity.getWindow(), f1);
    }

    public static g a(Dialog dialog, f f1)
    {
        return a(dialog.getContext(), dialog.getWindow(), f1);
    }

    private static g a(Context context, Window window, f f1)
    {
        int l = android.os.Build.VERSION.SDK_INT;
        if (l >= 14)
        {
            return new j(context, window, f1);
        }
        if (l >= 11)
        {
            return new i(context, window, f1);
        } else
        {
            return new k(context, window, f1);
        }
    }

    public abstract ActionBar a();

    public abstract void a(int l);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void a(CharSequence charsequence);

    public abstract MenuInflater b();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract boolean b(int l);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract a.a g();

    public abstract void h();
}
