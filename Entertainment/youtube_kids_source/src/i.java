// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class i extends j
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener
{

    private int W;
    private int X;
    private boolean Y;
    private int Z;
    public boolean a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    public Dialog b;

    public i()
    {
        W = 0;
        X = 0;
        Y = true;
        a = true;
        Z = -1;
    }

    public final void a()
    {
        super.a();
        if (!ac && !ab)
        {
            ab = true;
        }
    }

    public final void a(Activity activity)
    {
        super.a(activity);
        if (!ac)
        {
            ab = false;
        }
    }

    public final void a(Bundle bundle)
    {
        super.a(bundle);
        boolean flag;
        if (A == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (bundle != null)
        {
            W = bundle.getInt("android:style", 0);
            X = bundle.getInt("android:theme", 0);
            Y = bundle.getBoolean("android:cancelable", true);
            a = bundle.getBoolean("android:showsDialog", a);
            Z = bundle.getInt("android:backStackId", -1);
        }
    }

    public void a(r r1, String s)
    {
        ab = false;
        ac = true;
        r1 = r1.a();
        r1.a(this, s);
        r1.a();
    }

    public final void a(boolean flag)
    {
        Y = true;
        if (b != null)
        {
            b.setCancelable(true);
        }
    }

    public final LayoutInflater b(Bundle bundle)
    {
        if (!a)
        {
            return super.b(bundle);
        }
        b = c(bundle);
        W;
        JVM INSTR tableswitch 1 3: default 52
    //                   1 87
    //                   2 87
    //                   3 75;
           goto _L1 _L2 _L2 _L3
_L1:
        if (b != null)
        {
            return (LayoutInflater)b.getContext().getSystemService("layout_inflater");
        } else
        {
            return (LayoutInflater)w.getSystemService("layout_inflater");
        }
_L3:
        b.getWindow().addFlags(24);
_L2:
        b.requestWindowFeature(1);
          goto _L1
    }

    public final void b()
    {
        super.b();
        if (b != null)
        {
            aa = false;
            b.show();
        }
    }

    public Dialog c(Bundle bundle)
    {
        return new Dialog(super.w, X);
    }

    public final void c()
    {
        super.c();
        if (b != null)
        {
            b.hide();
        }
    }

    public final void d()
    {
        super.d();
        if (b != null)
        {
            aa = true;
            b.dismiss();
            b = null;
        }
    }

    public final void d(Bundle bundle)
    {
        super.d(bundle);
        if (a)
        {
            View view = super.K;
            if (view != null)
            {
                if (view.getParent() != null)
                {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                b.setContentView(view);
            }
            b.setOwnerActivity(super.w);
            b.setCancelable(Y);
            b.setOnCancelListener(this);
            b.setOnDismissListener(this);
            if (bundle != null)
            {
                bundle = bundle.getBundle("android:savedDialogState");
                if (bundle != null)
                {
                    b.onRestoreInstanceState(bundle);
                    return;
                }
            }
        }
    }

    public final void e(Bundle bundle)
    {
        super.e(bundle);
        if (b != null)
        {
            Bundle bundle1 = b.onSaveInstanceState();
            if (bundle1 != null)
            {
                bundle.putBundle("android:savedDialogState", bundle1);
            }
        }
        if (W != 0)
        {
            bundle.putInt("android:style", W);
        }
        if (X != 0)
        {
            bundle.putInt("android:theme", X);
        }
        if (!Y)
        {
            bundle.putBoolean("android:cancelable", Y);
        }
        if (!a)
        {
            bundle.putBoolean("android:showsDialog", a);
        }
        if (Z != -1)
        {
            bundle.putInt("android:backStackId", Z);
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
label0:
        {
            if (!aa && !ab)
            {
                ab = true;
                ac = false;
                if (b != null)
                {
                    b.dismiss();
                    b = null;
                }
                aa = true;
                if (Z < 0)
                {
                    break label0;
                }
                super.v.a(Z, 1);
                Z = -1;
            }
            return;
        }
        dialoginterface = super.v.a();
        dialoginterface.a(this);
        dialoginterface.b();
    }
}
