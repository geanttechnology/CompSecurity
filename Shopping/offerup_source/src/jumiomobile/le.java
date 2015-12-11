// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

// Referenced classes of package jumiomobile:
//            kt, nu, gs, ku

class le
    implements android.view.View.OnClickListener
{

    final kt a;

    private le(kt kt1)
    {
        a = kt1;
        super();
    }

    le(kt kt1, ku ku)
    {
        this(kt1);
    }

    public void onClick(View view)
    {
        boolean flag1 = true;
        view.setEnabled(false);
        view = a;
        float f;
        boolean flag;
        if (!kt.d(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        kt.b(view, flag);
        view = kt.a(a);
        if (!kt.d(a))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.a(flag);
        if (kt.d(a))
        {
            kt.b(a).t();
        }
        view = kt.e(a);
        if (kt.d(a))
        {
            f = -a.b.getHeight() + kt.a(a).getCurrentHeight();
        } else
        {
            f = 0.0F;
        }
        view.setTranslationY(f);
        kt.f(a);
    }
}
