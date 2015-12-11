// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v4.app:
//            Fragment, k, m, i

public class h extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener
{

    int a;
    int b;
    boolean c_;
    public boolean d;
    int e;
    public Dialog f;
    boolean g;
    public boolean h;
    public boolean i;

    public h()
    {
        a = 0;
        b = 0;
        c_ = true;
        d = true;
        e = -1;
    }

    public Dialog a(Bundle bundle)
    {
        return new Dialog(getActivity(), b);
    }

    public void a()
    {
        a(false);
    }

    public final void a(int j)
    {
        a = 2;
        if (a == 2 || a == 3)
        {
            b = 0x1030059;
        }
        if (j != 0)
        {
            b = j;
        }
    }

    public void a(k k1, String s)
    {
        h = false;
        i = true;
        k1 = k1.a();
        k1.a(this, s);
        k1.a();
    }

    public final void a(boolean flag)
    {
        if (h)
        {
            return;
        }
        h = true;
        i = false;
        if (f != null)
        {
            f.dismiss();
            f = null;
        }
        g = true;
        if (e >= 0)
        {
            getFragmentManager().b(e);
            e = -1;
            return;
        }
        m m1 = getFragmentManager().a();
        m1.a(this);
        if (flag)
        {
            m1.b();
            return;
        } else
        {
            m1.a();
            return;
        }
    }

    public final void b(boolean flag)
    {
        c_ = flag;
        if (f != null)
        {
            f.setCancelable(flag);
        }
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        if (!d)
        {
            return super.getLayoutInflater(bundle);
        }
        f = a(bundle);
        a;
        JVM INSTR tableswitch 1 3: default 52
    //                   1 87
    //                   2 87
    //                   3 75;
           goto _L1 _L2 _L2 _L3
_L1:
        if (f != null)
        {
            return (LayoutInflater)f.getContext().getSystemService("layout_inflater");
        } else
        {
            return (LayoutInflater)D.getSystemService("layout_inflater");
        }
_L3:
        f.getWindow().addFlags(24);
_L2:
        f.requestWindowFeature(1);
          goto _L1
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (d)
        {
            View view = getView();
            if (view != null)
            {
                if (view.getParent() != null)
                {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                f.setContentView(view);
            }
            f.setOwnerActivity(getActivity());
            f.setCancelable(c_);
            f.setOnCancelListener(this);
            f.setOnDismissListener(this);
            if (bundle != null)
            {
                bundle = bundle.getBundle("android:savedDialogState");
                if (bundle != null)
                {
                    f.onRestoreInstanceState(bundle);
                    return;
                }
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!i)
        {
            h = false;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (H == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if (bundle != null)
        {
            a = bundle.getInt("android:style", 0);
            b = bundle.getInt("android:theme", 0);
            c_ = bundle.getBoolean("android:cancelable", true);
            d = bundle.getBoolean("android:showsDialog", d);
            e = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (f != null)
        {
            g = true;
            f.dismiss();
            f = null;
        }
    }

    public void onDetach()
    {
        super.onDetach();
        if (!i && !h)
        {
            h = true;
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!g)
        {
            a(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (f != null)
        {
            Bundle bundle1 = f.onSaveInstanceState();
            if (bundle1 != null)
            {
                bundle.putBundle("android:savedDialogState", bundle1);
            }
        }
        if (a != 0)
        {
            bundle.putInt("android:style", a);
        }
        if (b != 0)
        {
            bundle.putInt("android:theme", b);
        }
        if (!c_)
        {
            bundle.putBoolean("android:cancelable", c_);
        }
        if (!d)
        {
            bundle.putBoolean("android:showsDialog", d);
        }
        if (e != -1)
        {
            bundle.putInt("android:backStackId", e);
        }
    }

    public void onStart()
    {
        super.onStart();
        if (f != null)
        {
            g = false;
            f.show();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (f != null)
        {
            f.hide();
        }
    }
}
