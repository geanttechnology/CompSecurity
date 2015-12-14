// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.d;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.ad:
//            a, k, l, m

public final class j extends Fragment
{

    final a a;
    final m b;
    k c;
    Fragment d;
    private final HashSet e;
    private j f;

    public j()
    {
        this(new a());
    }

    private j(a a1)
    {
        b = new myobfuscated.ad.k(this, (byte)0);
        e = new HashSet();
        a = a1;
    }

    private boolean a(Fragment fragment)
    {
        Fragment fragment1 = getParentFragment();
        for (; fragment.getParentFragment() != null; fragment = fragment.getParentFragment())
        {
            if (fragment.getParentFragment() == fragment1)
            {
                return true;
            }
        }

        return false;
    }

    private void b()
    {
        if (f != null)
        {
            f.e.remove(this);
            f = null;
        }
    }

    public final Set a()
    {
        if (f == this)
        {
            return Collections.unmodifiableSet(e);
        }
        if (f == null || android.os.Build.VERSION.SDK_INT < 17)
        {
            return Collections.emptySet();
        }
        HashSet hashset = new HashSet();
        Iterator iterator = f.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            j j1 = (j)iterator.next();
            if (a(j1.getParentFragment()))
            {
                hashset.add(j1);
            }
        } while (true);
        return Collections.unmodifiableSet(hashset);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b();
        f = l.a().a(activity.getFragmentManager(), null);
        if (f != this)
        {
            f.e.add(this);
        }
_L1:
        return;
        activity;
        if (Log.isLoggable("RMFragment", 5))
        {
            Log.w("RMFragment", "Unable to register fragment with root", activity);
            return;
        }
          goto _L1
    }

    public final void onDestroy()
    {
        super.onDestroy();
        a.c();
        b();
    }

    public final void onDetach()
    {
        super.onDetach();
        b();
    }

    public final void onLowMemory()
    {
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

    public final void onTrimMemory(int i)
    {
        if (c != null)
        {
            c.a.onTrimMemory(i);
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(super.toString()).append("{parent=");
        Fragment fragment;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            fragment = getParentFragment();
        } else
        {
            fragment = null;
        }
        if (fragment == null)
        {
            fragment = d;
        }
        return stringbuilder.append(fragment).append("}").toString();
    }
}
