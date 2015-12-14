// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewBeautyMainFragment;

public class to
    implements kh
{

    final MNewBeautyMainFragment a;

    public to(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        a = mnewbeautymainfragment;
        super();
    }

    public void a()
    {
        MNewBeautyMainFragment.f(a);
        if (a.b != null && a.c != null)
        {
            a.b.a(a.c);
        }
    }

    public void b()
    {
        if (a.b != null)
        {
            a.b.b();
        }
    }

    public void c()
    {
        if (uv.c().f())
        {
            android.graphics.Bitmap bitmap = uv.c().g();
            if (a.b != null)
            {
                a.b.b(bitmap);
            }
        }
    }

    public void d()
    {
        if (uv.c().e())
        {
            android.graphics.Bitmap bitmap = uv.c().h();
            if (a.b != null)
            {
                a.b.b(bitmap);
            }
        }
    }
}
