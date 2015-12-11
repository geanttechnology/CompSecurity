// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.e.a;
import android.util.TypedValue;
import android.view.View;

// Referenced classes of package android.support.v7.a:
//            g, h

public class m extends Dialog
    implements g
{

    private h a;

    public m(Context context, int i)
    {
        int j = i;
        if (i == 0)
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().resolveAttribute(android.support.v7.b.a.a.dialogTheme, typedvalue, true);
            j = typedvalue.resourceId;
        }
        super(context, j);
        a().a(null);
    }

    public final h a()
    {
        if (a == null)
        {
            a = android.support.v7.a.h.a(getContext(), getWindow(), this);
        }
        return a;
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a().b(view, layoutparams);
    }

    public void invalidateOptionsMenu()
    {
        a().f();
    }

    protected void onCreate(Bundle bundle)
    {
        a().i();
        super.onCreate(bundle);
        a().a(bundle);
    }

    protected void onStop()
    {
        super.onStop();
        a().d();
    }

    public void onSupportActionModeFinished(a a1)
    {
    }

    public void onSupportActionModeStarted(a a1)
    {
    }

    public a onWindowStartingSupportActionMode(android.support.v7.e.a.a a1)
    {
        return null;
    }

    public void setContentView(int i)
    {
        a().a(i);
    }

    public void setContentView(View view)
    {
        a().a(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a().a(view, layoutparams);
    }

    public void setTitle(int i)
    {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        a().a(charsequence);
    }
}
