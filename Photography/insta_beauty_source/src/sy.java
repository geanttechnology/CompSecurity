// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class sy
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final FotoBeautySimpleActivity a;

    public sy(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        a = fotobeautysimpleactivity;
        super();
    }

    public void onGlobalLayout()
    {
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L2; else goto _L1
_L1:
        FotoBeautySimpleActivity.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
_L7:
        if (!FotoBeautySimpleActivity.b(a)) goto _L4; else goto _L3
_L3:
        FotoBeautySimpleActivity.c(a).setVisibility(0);
_L5:
        android.graphics.Bitmap bitmap = yo.b(FotoBeautySimpleActivity.d(a), 90, 120);
        FotoBeautySimpleActivity.e(a).setPresetScrollImg(bitmap);
        return;
_L2:
        try
        {
            FotoBeautySimpleActivity.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            if (FotoBeautySimpleActivity.f(a) != null)
            {
                FotoBeautySimpleActivity.f(a).a(FotoBeautySimpleActivity.b());
                return;
            }
        }
        return;
        continue; /* Loop/switch isn't completed */
_L4:
        FotoBeautySimpleActivity.a(a, FotoBeautySimpleActivity.c(a), yp.a(a, 110F), 0, 300L, true);
          goto _L5
        if (true) goto _L7; else goto _L6
_L6:
    }
}
