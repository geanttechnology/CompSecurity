// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class afc extends aep
{

    private final ExecutorService b = Executors.newSingleThreadExecutor(new afd(this));
    private final Activity c;
    private final bqe d;
    private final blu e;
    private final bov f;
    private final bxe g;

    public afc(Activity activity, bqe bqe1, blu blu1, bov bov1, bxe bxe1)
    {
        c = (Activity)b.a(activity);
        d = (bqe)b.a(bqe1);
        e = (blu)b.a(blu1);
        f = (bov)b.a(bov1);
        g = (bxe)b.a(bxe1);
    }

    protected final bn b()
    {
        return new aew(b, c, d, e, f, g);
    }

    protected final bn b(View view)
    {
        ExecutorService executorservice = b;
        Activity activity = c;
        bqe bqe1 = d;
        blu blu1 = e;
        return new aew(executorservice, activity, view, bqe1, f, g);
    }

    protected final int c()
    {
        return 10;
    }
}
