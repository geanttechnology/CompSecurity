// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.content.res.Resources;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.bt:
//            c

final class f
    implements d
{

    private String a;
    private c b;

    public f(c c1, String s)
    {
        b = c1;
        super();
        a = s;
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        m.b(b.getActivity(), c.c(b));
        Utils.c(b.getActivity(), exception.getMessage());
        b.getActivity().finish();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
label0:
        {
            obj = (List)obj;
            if (!c.b(b))
            {
                m.b(b.getActivity(), c.c(b));
                if (obj != null)
                {
                    break label0;
                }
                Utils.c(b.getActivity(), b.getActivity().getResources().getString(0x7f0805cb));
                b.getActivity().finish();
            }
            return;
        }
        c.a(b, a, ((List) (obj)));
    }
}
