// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class afr
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ProEditFilterActivity a;

    public afr(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void onGlobalLayout()
    {
        ProEditFilterActivity.a(a, true);
        if (ProEditFilterActivity.b(a) == null)
        {
            if (!ProEditFilterActivity.c(a))
            {
                (new Thread(new afs(this))).start();
            } else
            if (ProEditFilterActivity.e(a))
            {
                ProEditFilterActivity.b(a, false);
                ProEditFilterActivity.d(a);
                return;
            }
        }
    }
}
