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
//            dp, dm, cx, n, 
//            e, z, dl, dg

public final class df extends dp
    implements dm
{

    private static final HashMap b;

    public df()
    {
    }

    public static df a(long l, float f)
    {
        df df1 = new df();
        df1.setArguments(cx.a(l, f));
        return df1;
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
        bundle = (cx)view.findFragmentByTag("item_details");
        Object obj = getArguments();
        if (bundle == null && obj != null)
        {
            bundle = cx.a(((Bundle) (obj)));
            bundle.b = this;
            obj = view.beginTransaction();
            ((FragmentTransaction) (obj)).add(0x7f0b00fe, bundle, "item_details");
            ((FragmentTransaction) (obj)).commit();
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
        getDialog().setOnKeyListener(new dg(this));
    }

    static 
    {
        HashMap hashmap = new HashMap();
        b = hashmap;
        hashmap.put(com/wishabi/flipp/app/cx, "item_details");
        b.put(com/wishabi/flipp/app/n, "coupon_details");
        b.put(com/wishabi/flipp/app/e, "barcode");
        b.put(com/wishabi/flipp/app/z, "coupon_help");
    }
}
