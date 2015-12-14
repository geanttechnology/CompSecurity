// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bj;

import android.view.View;
import android.widget.Toast;

// Referenced classes of package myobfuscated.bj:
//            a, b

final class it>
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        int i = myobfuscated.bj.a.b(a);
        int j = myobfuscated.bj.a.e(a);
        if (i == -1 || j == -1)
        {
            Toast.makeText(a.getActivity(), a.getString(0x7f08039e), 1).show();
            return;
        }
        if (i < myobfuscated.bj.a.h(a) || i > myobfuscated.bj.a.i(a))
        {
            Toast.makeText(a.getActivity(), a.getString(0x7f080107, new Object[] {
                Integer.valueOf(myobfuscated.bj.a.h(a)), Integer.valueOf(myobfuscated.bj.a.i(a))
            }), 1).show();
            return;
        }
        if (j < myobfuscated.bj.a.j(a) || j > myobfuscated.bj.a.k(a))
        {
            Toast.makeText(a.getActivity(), a.getString(0x7f080106, new Object[] {
                Integer.valueOf(myobfuscated.bj.a.j(a)), Integer.valueOf(myobfuscated.bj.a.k(a))
            }), 1).show();
            return;
        }
        if (myobfuscated.bj.a.l(a) != null)
        {
            myobfuscated.bj.a.l(a).a(i, j);
        }
        a.dismiss();
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
