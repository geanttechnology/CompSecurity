// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.AssetManager;
import android.graphics.Bitmap;

public class ig
{

    private static boolean b = false;
    adk a;

    public ig()
    {
        if (b)
        {
            a = new adk(true);
            return;
        } else
        {
            a = null;
            return;
        }
    }

    public int a()
    {
        if (b)
        {
            return a.b();
        } else
        {
            return 0;
        }
    }

    public void a(float f)
    {
        if (b)
        {
            adu adu1 = new adu();
            adu1.a(f);
            a.a(adu1);
        }
    }

    public void a(float f, float f1, float f2)
    {
        if (b)
        {
            aea aea1 = new aea();
            aea1.a(f);
            aea1.b(f1);
            aea1.c(f2);
            a.a(aea1);
        }
    }

    public void a(float f, adj adj)
    {
        if (b)
        {
            adx adx1 = new adx();
            adx1.a(true);
            adx1.a(f);
            adx1.a(adj);
            a.a(adx1);
        }
    }

    public void a(float f, adn adn)
    {
        if (b)
        {
            ads ads1 = new ads();
            ads1.a(f);
            ads1.a(adn);
            a.a(ads1);
        }
    }

    public void a(float f, ado ado)
    {
        if (b)
        {
            ady ady1 = new ady();
            ady1.a(f);
            ady1.a(ado);
            a.a(ady1);
        }
    }

    public void a(int i)
    {
        if (b)
        {
            a.a(i);
        }
    }

    public void a(adh adh, int i)
    {
        if (b)
        {
            a.a(adh, i);
        }
    }

    public void a(adi adi, adi adi1)
    {
        if (b)
        {
            a.a(adi, adi1);
        }
    }

    public void a(adp adp1, adv adv)
    {
        if (b)
        {
            a.a(adp1, adv);
        }
    }

    public void a(adv adv)
    {
        if (b)
        {
            a.b(adv);
        }
    }

    public void a(AssetManager assetmanager, Bitmap bitmap)
    {
        if (b)
        {
            a.a(assetmanager, bitmap);
        }
    }

    public void a(Bitmap bitmap)
    {
        if (b)
        {
            a.a(bitmap);
        }
    }

    public void a(Boolean boolean1, adg adg)
    {
        if (b)
        {
            adw adw1 = new adw();
            adw1.a(boolean1.booleanValue());
            adw1.a(adg);
            a.a(adw1);
        }
    }

    public void a(boolean flag)
    {
        if (b)
        {
            a.a(flag);
        }
    }

    public void a(boolean flag, float f, float f1, float f2, float f3, float f4)
    {
        if (b)
        {
            adt adt1 = new adt();
            adt1.a(flag);
            adt1.f(f);
            adt1.a(f1);
            adt1.b(0.0F);
            adt1.e(f2);
            adt1.d(f4);
            adt1.c(f3);
            a.a(adp.a, adt1);
        }
    }

    public void b()
    {
        System.gc();
        if (b)
        {
            a.c();
        }
    }

    public void b(float f)
    {
        if (b)
        {
            adq adq1 = new adq();
            adq1.a(f);
            a.a(adq1);
        }
    }

    public void b(float f, ado ado)
    {
        if (b)
        {
            adz adz1 = new adz();
            adz1.a(f);
            adz1.a(ado);
            a.a(adz1);
        }
    }

    public void b(AssetManager assetmanager, Bitmap bitmap)
    {
        if (b)
        {
            a.b(assetmanager, bitmap);
        }
    }

    public void b(boolean flag)
    {
        if (b)
        {
            a.b(flag);
        }
    }

    public void c(float f)
    {
        if (b)
        {
            adr adr1 = new adr();
            adr1.a(f);
            a.a(adr1);
        }
    }

    public boolean c()
    {
        if (b)
        {
            return a.d();
        } else
        {
            return false;
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("fotobeautyengine");
            b = true;
        }
        catch (Exception exception)
        {
            b = false;
        }
    }
}
