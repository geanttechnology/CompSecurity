// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.view.View;
import com.socialin.android.dialog.g;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.bt:
//            c, e

final class it>
    implements android.view..OnClickListener
{

    private c a;

    public final void onClick(View view)
    {
        view = a;
        if (!view.b())
        {
            ((c) (view)).g.setMessage(view.getString(0x7f080656));
            m.a(view.getActivity(), ((c) (view)).g);
            m.a(((c) (view)).e, ((c) (view)).c, ((c) (view)).f, new e(view, (byte)0));
        }
    }

    .dialog.g(c c1)
    {
        a = c1;
        super();
    }
}
