// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class vs
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final MOneKeyFragment a;

    public vs(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void onGlobalLayout()
    {
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L2; else goto _L1
_L1:
        MOneKeyFragment.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
_L7:
        if (!MOneKeyFragment.b(a)) goto _L4; else goto _L3
_L3:
        MOneKeyFragment.c(a).setVisibility(0);
_L5:
        android.graphics.Bitmap bitmap = yo.b(MOneKeyFragment.d(a), 90, 120);
        MOneKeyFragment.e(a).setPresetScrollImg(bitmap);
        return;
_L2:
        try
        {
            MOneKeyFragment.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            if (MOneKeyFragment.f(a) != null)
            {
                MOneKeyFragment.f(a).a(MOneKeyFragment.c());
                return;
            }
        }
        return;
        continue; /* Loop/switch isn't completed */
_L4:
        MOneKeyFragment.a(a, MOneKeyFragment.c(a), yp.a(a.getActivity(), 110F), 0, 300L, true);
          goto _L5
        if (true) goto _L7; else goto _L6
_L6:
    }
}
