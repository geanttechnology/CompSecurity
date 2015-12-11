// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class ali
    implements amr
{

    final Map a = new HashMap();
    final chf b;
    final chl c;
    final cgz d;
    final amd e;
    private final Executor f;

    public ali(Executor executor, SharedPreferences sharedpreferences, Resources resources, amd amd1, chq chq, chs chs, chl chl1)
    {
        f = (Executor)b.a(executor);
        b.a(sharedpreferences);
        b.a(resources);
        e = (amd)b.a(amd1);
        b.a(chq);
        executor = new chh(chs);
        new chk(executor);
        b = new chf(executor);
        c = (chl)b.a(chl1);
        d = new cgz(sharedpreferences);
    }

    private void c(bhv bhv)
    {
        f.execute(new all(this, bhv));
    }

    public final void a(bhv bhv)
    {
        c(new alj(this, null, bhv, bhv));
    }

    public final void b(bhv bhv)
    {
        c(new alk(this, null, null, null));
    }
}
