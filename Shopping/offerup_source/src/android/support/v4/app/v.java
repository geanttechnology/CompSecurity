// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            z, t, Fragment

final class v extends z
{

    private t c;

    public v(t t1)
    {
        c = t1;
        super(t1);
    }

    public final View a(int i)
    {
        return c.findViewById(i);
    }

    public final void a(Fragment fragment)
    {
        c.onAttachFragment(fragment);
    }

    public final void a(Fragment fragment, Intent intent, int i)
    {
        c.startActivityFromFragment(fragment, intent, i);
    }

    public final void a(Fragment fragment, String as[], int i)
    {
        t.access$000(c, fragment, as, i);
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        c.dump(s, null, printwriter, as);
    }

    public final boolean a()
    {
        Window window = c.getWindow();
        return window != null && window.peekDecorView() != null;
    }

    public final boolean a(String s)
    {
        t t1 = c;
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            return t1.shouldShowRequestPermissionRationale(s);
        } else
        {
            return false;
        }
    }

    public final boolean b()
    {
        return !c.isFinishing();
    }

    public final LayoutInflater c()
    {
        return c.getLayoutInflater().cloneInContext(c);
    }

    public final void d()
    {
        c.supportInvalidateOptionsMenu();
    }

    public final boolean e()
    {
        return c.getWindow() != null;
    }

    public final int f()
    {
        Window window = c.getWindow();
        if (window == null)
        {
            return 0;
        } else
        {
            return window.getAttributes().windowAnimations;
        }
    }

    public final volatile Object g()
    {
        return c;
    }
}
