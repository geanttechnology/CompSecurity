// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.lang.ref.WeakReference;

public class aqq
    implements aoa
{

    private WeakReference a;

    public aqq(anz anz1)
    {
        a = null;
        a = new WeakReference(anz1);
    }

    public String a(Context context)
    {
        return aqo.a(context, "").c();
    }

    public void a(Context context, String s)
    {
        anz anz1;
        try
        {
            anz1 = (anz)a.get();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            context.printStackTrace();
            return;
        }
        if (anz1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        aqo.a(context, s).a(anz1);
        aqo.a(context, s).b();
    }

    public boolean a()
    {
        return true;
    }
}
