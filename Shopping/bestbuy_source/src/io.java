// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.MyBBYHomeCard;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.mybby.CIALoginFragment;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.base.BBYBaseFragment;

public class io extends ka
{

    private String a;
    private int j;
    private LoggedInUserProfile k;
    private nb l;
    private String m;

    public io(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment);
        j = 0;
        a = s;
        m = s1;
        l = nb.a();
    }

    static int a(io io1, int i)
    {
        io1.j = i;
        return i;
    }

    public void a()
    {
        k = fs.a(a, m);
        if (k != null && !k.isHasError() && k.getErrorCode() == null)
        {
            fr.a(k);
            l.m(false);
        }
    }

    public void b()
    {
        j = 1;
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        if (!k.isHasError() || !k.getErrorCode().equals("403") && !k.getErrorCode().equals("401") && !k.getErrorCode().equals("409")) goto _L2; else goto _L1
_L1:
        c();
_L4:
        return;
_L2:
        if (k.isHasError() && k.getErrorCode().equals("499"))
        {
            if (l.Z())
            {
                l.m(false);
            }
            nm.a(f, new no() {

                final io a;

                public void a()
                {
                }

            
            {
                a = io.this;
                super();
            }
            }, new nn() {

                final io a;

                public void a()
                {
                    io.a(a, 1);
                }

            
            {
                a = io.this;
                super();
            }
            }, e, j);
            return;
        }
        l.w().a(k);
        if (!(i instanceof CIALoginFragment) || !i.isAdded())
        {
            break; /* Loop/switch isn't completed */
        }
        ((CIALoginFragment)i).a(k);
        (new hs()).execute(new Void[0]);
_L5:
        if (l.Z())
        {
            l.m(false);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ((i instanceof MdotWebFragment) && i.isAdded())
        {
            ((MdotWebFragment)i).a(k);
            (new hs()).execute(new Void[0]);
            ((HomeActivity)f).recreateHomeScreen(false);
            ((HomeActivity)f).buildSideMenu();
            ((MdotWebFragment)i).a(false);
        } else
        if ((i instanceof MyBBYHomeCard) && i.isAdded())
        {
            ((MyBBYHomeCard)i).a(k);
            (new hs()).execute(new Void[0]);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        c();
        return;
    }

    public void c()
    {
        if (l.Z())
        {
            l.m(false);
        }
        j = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
    }

    public void d()
    {
        j = j + 1;
    }

    public void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }
}
