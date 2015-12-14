// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class tc
    implements iv
{

    final FotoBeautySimpleActivity a;

    public tc(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        a = fotobeautysimpleactivity;
        super();
    }

    public void a()
    {
        if (FotoBeautySimpleActivity.f(a) != null)
        {
            FotoBeautySimpleActivity.f(a).b(FotoBeautySimpleActivity.b());
        }
    }

    public void a(float f)
    {
        FotoBeautySimpleActivity.a(a, f);
        FotoBeautySimpleActivity.a(a, FotoBeautySimpleActivity.a(a), f);
    }

    public void a(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            FotoBeautySimpleActivity.i(a).setImageBitmap(FotoBeautySimpleActivity.d(a));
            FotoBeautySimpleActivity.a(a).setVisibility(0);
            // fall through

        case 2: // '\002'
            return;

        case 0: // '\0'
            break;
        }
        if (FotoBeautySimpleActivity.f(a) != null)
        {
            FotoBeautySimpleActivity.a(a).setVisibility(4);
            FotoBeautySimpleActivity.i(a).setImageBitmap(FotoBeautySimpleActivity.f(a).a());
        }
        FlurryAgent.logEvent((new StringBuilder()).append("CompareClicked").append(FotoBeautySimpleActivity.b().toString()).toString());
    }

    public void a(String s)
    {
        try
        {
            if (FotoBeautySimpleActivity.f(a) != null)
            {
                FotoBeautySimpleActivity.a(a, s);
                FotoBeautySimpleActivity.a(a, 0.7F);
                if (FotoBeautySimpleActivity.m(a).equals(a.getResources().getString(0x7f06009d)))
                {
                    FotoBeautySimpleActivity.a(a, 1.0F);
                }
                sx.a("OneKeyFilterSelected", s);
                FotoBeautySimpleActivity.a(a, FotoBeautySimpleActivity.d(a), FotoBeautySimpleActivity.m(a));
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
