// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.app:
//            dp, dm, bx, fu, 
//            dl, ce

public final class cd extends dp
    implements dm
{

    private static final HashMap b;
    private Bundle c;

    public cd()
    {
    }

    public static cd a(int i, String s, boolean flag, boolean flag1)
    {
        cd cd1 = new cd();
        cd1.c = bx.a(i, s, flag, flag1);
        return cd1;
    }

    public final void a(Class class1, Bundle bundle)
    {
        dl dl1;
        try
        {
            dl1 = (dl)class1.newInstance();
            dl1.setArguments(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return;
        }
        class1 = (String)b.get(class1);
        if (class1 == null)
        {
            return;
        } else
        {
            dl1.b = this;
            bundle = getChildFragmentManager().beginTransaction();
            bundle.setCustomAnimations(0x7f050005, 0x7f050006, 0x7f050004, 0x7f050007);
            bundle.replace(0x7f0b00fe, dl1, class1);
            bundle.addToBackStack(null);
            bundle.commit();
            return;
        }
    }

    public final void a(String s)
    {
        getDialog().setTitle(s);
    }

    public final boolean a()
    {
        return true;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030044, viewgroup, false);
    }

    public final void onResume()
    {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            dialog.getWindow().setLayout((int)getResources().getDimension(0x7f0a001e), (int)getResources().getDimension(0x7f0a001d));
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        setCancelable(true);
        view = getChildFragmentManager();
        if ((bx)view.findFragmentByTag("flyer_info") == null && c != null)
        {
            bundle = bx.a(c);
            bundle.b = this;
            FragmentTransaction fragmenttransaction = view.beginTransaction();
            fragmenttransaction.add(0x7f0b00fe, bundle, "flyer_info");
            fragmenttransaction.commit();
        }
        bundle = b.values().iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            android.app.Fragment fragment = view.findFragmentByTag((String)bundle.next());
            if (fragment != null && (fragment instanceof dl))
            {
                ((dl)fragment).b = this;
            }
        } while (true);
        getDialog().setOnKeyListener(new ce(this));
    }

    static 
    {
        HashMap hashmap = new HashMap();
        b = hashmap;
        hashmap.put(com/wishabi/flipp/app/bx, "flyer_info");
        b.put(com/wishabi/flipp/app/fu, "webview");
    }
}
