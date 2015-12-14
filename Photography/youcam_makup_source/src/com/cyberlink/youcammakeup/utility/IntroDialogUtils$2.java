// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.r;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            IntroDialogUtils, ac

final class d
    implements l
{

    final r a;
    final Integer b;
    final ac c;
    final troDialogType d;

    public void a(a a1)
    {
    }

    public void a(bn bn1)
    {
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        z.a((new StringBuilder()).append("INTRO_IMAGE_").append(a.a).toString(), s, Globals.d());
        if (!IntroDialogUtils.c().containsKey(b))
        {
            IntroDialogUtils.c().put(b, new ArrayList());
        }
        Object obj = new File(s);
        s = (List)IntroDialogUtils.c().get(b);
        if (!s.contains(((File) (obj)).getName()))
        {
            s.add(((File) (obj)).getName());
        }
        obj = (List)IntroDialogUtils.d().get(b);
        if (s.size() == ((List) (obj)).size())
        {
            Globals.d(new Runnable() {

                final IntroDialogUtils._cls2 a;

                public void run()
                {
                    a.c.a(a.d);
                }

            
            {
                a = IntroDialogUtils._cls2.this;
                super();
            }
            });
        }
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    troDialogType(r r1, Integer integer, ac ac, troDialogType trodialogtype)
    {
        a = r1;
        b = integer;
        c = ac;
        d = trodialogtype;
        super();
    }
}
