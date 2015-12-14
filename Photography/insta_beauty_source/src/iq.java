// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.BitmapDrawable;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.MNewCropFragment;
import com.fotoable.beautyui.other.CropImageView;

public class iq
    implements xn
{

    final MNewCropFragment a;

    public iq(MNewCropFragment mnewcropfragment)
    {
        a = mnewcropfragment;
        super();
    }

    public void a(String s, Object obj)
    {
        FlurryAgent.logEvent((new StringBuilder()).append("rotate_").append(s).toString());
        if (s.compareTo("left") != 0) goto _L2; else goto _L1
_L1:
        MNewCropFragment.a(a, MNewCropFragment.a(a, MNewCropFragment.f(a), -90F));
_L4:
        MNewCropFragment.g(a).setDrawable(new BitmapDrawable(a.getResources(), MNewCropFragment.f(a)), 0, 0);
        return;
_L2:
        if (s.compareTo("right") == 0)
        {
            MNewCropFragment.a(a, MNewCropFragment.a(a, MNewCropFragment.f(a), 90F));
        } else
        if (s.compareTo("flip-h") == 0)
        {
            MNewCropFragment.a(a, MNewCropFragment.a(a, MNewCropFragment.f(a), 0));
        } else
        if (s.compareTo("flip-v") == 0)
        {
            MNewCropFragment.a(a, MNewCropFragment.a(a, MNewCropFragment.f(a), 1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
