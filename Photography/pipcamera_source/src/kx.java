// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.lang.ref.WeakReference;

public class kx
    implements je
{

    private WeakReference a;

    public kx(jd jd1)
    {
        a = null;
        a = new WeakReference(jd1);
    }

    public String a(Context context)
    {
        return kw.a(context, "").c();
    }

    public void a(Context context, String s)
    {
        jd jd1;
        try
        {
            jd1 = (jd)a.get();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            context.printStackTrace();
            return;
        }
        if (jd1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        kw.a(context, s).a(jd1);
        kw.a(context, s).b();
    }

    public boolean a()
    {
        return true;
    }
}
