// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.d;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.ad:
//            a, p, l, m

public final class o extends Fragment
{

    final a a;
    final m b;
    k c;
    Fragment d;
    private final HashSet e;
    private o f;

    public o()
    {
        this(new a());
    }

    private o(a a1)
    {
        b = new p(this, (byte)0);
        e = new HashSet();
        a = a1;
    }

    private boolean a(Fragment fragment)
    {
        Fragment fragment1 = b();
        for (; fragment.getParentFragment() != null; fragment = fragment.getParentFragment())
        {
            if (fragment.getParentFragment() == fragment1)
            {
                return true;
            }
        }

        return false;
    }

    private Fragment b()
    {
        Fragment fragment = getParentFragment();
        if (fragment != null)
        {
            return fragment;
        } else
        {
            return d;
        }
    }

    private void c()
    {
        if (f != null)
        {
            f.e.remove(this);
            f = null;
        }
    }

    public final Set a()
    {
        if (f == null)
        {
            return Collections.emptySet();
        }
        if (f == this)
        {
            return Collections.unmodifiableSet(e);
        }
        HashSet hashset = new HashSet();
        Iterator iterator = f.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            o o1 = (o)iterator.next();
            if (a(o1.b()))
            {
                hashset.add(o1);
            }
        } while (true);
        return Collections.unmodifiableSet(hashset);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = getActivity();
        c();
        f = l.a().a(activity.getSupportFragmentManager(), null);
        if (f != this)
        {
            f.e.add(this);
        }
_L1:
        return;
        activity;
        if (Log.isLoggable("SupportRMFragment", 5))
        {
            Log.w("SupportRMFragment", "Unable to register fragment with root", activity);
            return;
        }
          goto _L1
    }

    public final void onDestroy()
    {
        super.onDestroy();
        a.c();
        c();
    }

    public final void onDetach()
    {
        super.onDetach();
        d = null;
        c();
    }

    public final void onLowMemory()
    {
        super.onLowMemory();
        if (c != null)
        {
            c.a.onLowMemory();
        }
    }

    public final void onStart()
    {
        super.onStart();
        a.a();
    }

    public final void onStop()
    {
        super.onStop();
        a.b();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("{parent=").append(b()).append("}").toString();
    }
}
