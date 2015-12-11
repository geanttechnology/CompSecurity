// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.apps.youtube.kids.activities.WatchActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import java.util.Iterator;
import java.util.List;

public final class yc
    implements ajg
{

    final cun a;
    amd b;
    private final Resources c;
    private final bje d;

    public yc(KidsApplication kidsapplication)
    {
        aaa aaa1 = kidsapplication.h();
        bgv bgv1 = ((nc) (kidsapplication)).a;
        cnq cnq1 = ((nc) (kidsapplication)).b;
        Context context = kidsapplication.getApplicationContext();
        d = bgv1.d();
        a = new cun(context, bgv1.l(), aaa1.c(), cnq1.c(), aaa1.n(), aaa1.u(), bgv1.h(), bgv1.a(), com/google/android/apps/youtube/kids/activities/WatchActivity, new yf(this), 0x7f0200a3, kidsapplication.h().n.e(), aaa1.x());
        c = context.getResources();
        a.b();
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a.a(new yd(this));
        }
    }

    public final void a(amd amd1)
    {
        if (b != null)
        {
            d.b(this);
            a.b();
        }
        b = amd1;
        if (b != null)
        {
            d.a(this);
            Object obj = b.n();
            if (obj != null)
            {
                if (((ame) (obj)).c())
                {
                    a.a(true);
                    if (!TextUtils.isEmpty(b.o()))
                    {
                        a.a(b.o());
                    }
                    amd1 = a;
                    obj = c.getString(0x7f0b01fc, new Object[] {
                        ((ame) (obj)).b()
                    });
                    for (amd1 = ((cun) (amd1)).b.iterator(); amd1.hasNext(); ((cuq)amd1.next()).a(((String) (obj)))) { }
                } else
                {
                    a.a(false);
                }
            }
        }
    }

    public final void onMdxPlaybackChangedEvent(alv alv1)
    {
        if (alv1.a.a())
        {
            a.a(alv1.a.a);
        }
        if (b != null)
        {
            a.a(b.d(), b.f());
        }
    }

    public final void onMdxVideoPlayerStateChangedEvent(amm amm1)
    {
        amb amb1 = amm1.a;
        ye.a[amb1.ordinal()];
        JVM INSTR tableswitch 1 10: default 68
    //                   1 157
    //                   2 157
    //                   3 157
    //                   4 157
    //                   5 157
    //                   6 157
    //                   7 157
    //                   8 167
    //                   9 167
    //                   10 167;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L3
_L1:
        Object obj = cut.d;
        ye.a[amb1.ordinal()];
        JVM INSTR tableswitch 1 7: default 124
    //                   1 198
    //                   2 205
    //                   3 184
    //                   4 177
    //                   5 191
    //                   6 198
    //                   7 198;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L5 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_205;
_L10:
        a.a(((cut) (obj)));
        obj = a;
        boolean flag;
        if (amm1.a != amb.g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((cun) (obj)).b(flag);
        return;
_L2:
        a.a();
          goto _L1
_L3:
        a.b();
          goto _L1
_L8:
        obj = cut.b;
          goto _L10
_L7:
        obj = cut.f;
          goto _L10
_L9:
        obj = cut.c;
          goto _L10
_L5:
        obj = cut.a;
          goto _L10
        obj = cut.e;
          goto _L10
    }
}
