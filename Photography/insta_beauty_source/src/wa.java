// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class wa
    implements iv
{

    final MOneKeyFragment a;

    public wa(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void a()
    {
        if (MOneKeyFragment.f(a) != null)
        {
            MOneKeyFragment.f(a).b(MOneKeyFragment.c());
        }
    }

    public void a(float f)
    {
        MOneKeyFragment.a(a, f);
        MOneKeyFragment.a(a, MOneKeyFragment.a(a), f);
    }

    public void a(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            MOneKeyFragment.k(a).setImageBitmap(MOneKeyFragment.d(a));
            MOneKeyFragment.a(a).setVisibility(0);
            // fall through

        case 2: // '\002'
            return;

        case 0: // '\0'
            break;
        }
        if (MOneKeyFragment.f(a) != null)
        {
            MOneKeyFragment.a(a).setVisibility(4);
            MOneKeyFragment.k(a).setImageBitmap(MOneKeyFragment.f(a).a());
        }
        FlurryAgent.logEvent((new StringBuilder()).append("CompareClicked").append(MOneKeyFragment.c().toString()).toString());
    }

    public void a(String s)
    {
        try
        {
            if (MOneKeyFragment.f(a) != null)
            {
                MOneKeyFragment.a(a, s);
                MOneKeyFragment.a(a, 0.7F);
                if (MOneKeyFragment.l(a).equals(a.getResources().getString(0x7f06009d)))
                {
                    MOneKeyFragment.a(a, 1.0F);
                }
                sx.a("OneKeyFilterSelected", s);
                MOneKeyFragment.a(a, MOneKeyFragment.d(a), MOneKeyFragment.l(a));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
    }
}
