// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class akc
    implements akb
{

    final chq a;
    awi b;
    auz c;
    boolean d;
    private final Context e;

    akc(Context context, chq chq)
    {
        d = false;
        e = context;
        a = chq;
    }

    private awo c(String s)
    {
        return new ake(this, s);
    }

    public final void a()
    {
        d = true;
    }

    public final void a(double d1)
    {
        String s = String.valueOf("SET VOLUME ");
        s = (new StringBuilder(String.valueOf(s).length() + 24)).append(s).append(d1).toString();
        try
        {
            aud.c.a(b, d1);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            chq chq = a;
            String s1 = String.valueOf(illegalargumentexception);
            (new StringBuilder(String.valueOf(s).length() + 16 + String.valueOf(s1).length())).append("Command ").append(s).append(" failed:").append(s1);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            chq chq1 = a;
            String s2 = String.valueOf(illegalstateexception);
            (new StringBuilder(String.valueOf(s).length() + 16 + String.valueOf(s2).length())).append("Command ").append(s).append(" failed:").append(s2);
            return;
        }
        catch (IOException ioexception)
        {
            chq chq2 = a;
            String s3 = String.valueOf(ioexception);
            (new StringBuilder(String.valueOf(s).length() + 16 + String.valueOf(s3).length())).append("Command ").append(s).append(" failed:").append(s3);
            return;
        }
    }

    public final void a(long l)
    {
        String s = String.valueOf("SEEK TO ");
        s = (new StringBuilder(String.valueOf(s).length() + 20)).append(s).append(l).toString();
        auz auz1 = c;
        awi awi1 = b;
        awi1.b(new ave(auz1, awi1, l, 0, null)).a(c(s));
    }

    public final void a(CastDevice castdevice, aun aun, avt avt, awk awk)
    {
        Object obj = e;
        castdevice = new aul(new aum(castdevice, aun));
        aun = new awj(((Context) (obj)));
        obj = aud.b;
        a.f(castdevice, "Null options are not permitted for this Api");
        ((awj) (aun)).b.put(obj, castdevice);
        castdevice = ((awa) (obj)).c;
        int k = castdevice.size();
        for (int j = 0; j < k; j++)
        {
            ((awj) (aun)).a.add(((cm)castdevice.get(j)).d());
        }

        aun.a(avt);
        castdevice = aun.a();
        castdevice.a(new akf(this, castdevice, awk));
        castdevice.a();
    }

    public final void a(String s)
    {
        if (s != null)
        {
            aud.c.a(b, s);
            return;
        } else
        {
            aud.c.a(b);
            return;
        }
    }

    public final void a(String s, LaunchOptions launchoptions, awo awo)
    {
        aud.c.a(b, s, launchoptions).a(awo);
    }

    public final boolean a(String s, auo auo)
    {
        try
        {
            aud.c.a(b, s, auo);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public final void b(String s)
    {
        aud.c.a(b, "urn:x-cast:com.google.youtube.mdx", s).a(new akd(this, s));
    }

    public final boolean b()
    {
        return b != null;
    }

    public final void c()
    {
        b.b();
    }

    public final void d()
    {
        b = null;
    }

    public final boolean e()
    {
        return b() && c != null;
    }

    public final void f()
    {
        auz auz1 = new auz();
        awi awi1;
        try
        {
            aud.c.a(b, ((azg) (auz1.b)).b, auz1);
        }
        catch (IllegalStateException illegalstateexception)
        {
            chq chq = a;
            String s = String.valueOf(illegalstateexception);
            (new StringBuilder(String.valueOf(s).length() + 36)).append("setupRemoteMediaPlayer state error: ").append(s);
        }
        catch (IOException ioexception)
        {
            chq chq1 = a;
            String s1 = String.valueOf(ioexception);
            (new StringBuilder(String.valueOf(s1).length() + 33)).append("setupRemoteMediaPlayer IO error: ").append(s1);
        }
        auz1.d = new akg(this, auz1);
        awi1 = b;
        awi1.b(new avb(auz1, awi1));
    }

    public final void g()
    {
        if (c != null)
        {
            c = null;
        }
    }

    public final void h()
    {
        auz auz1 = c;
        awi awi1 = b;
        awi1.b(new avd(auz1, awi1, null)).a(c("PLAY"));
    }

    public final void i()
    {
        auz auz1 = c;
        awi awi1 = b;
        awi1.b(new avc(auz1, awi1, null)).a(c("PAUSE"));
    }
}
