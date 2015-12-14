// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.MNewCropFragment;
import com.fotoable.beautyui.other.CropImageView;

public class ip
    implements xn
{

    final MNewCropFragment a;

    public ip(MNewCropFragment mnewcropfragment)
    {
        a = mnewcropfragment;
        super();
    }

    public void a(String s, Object obj)
    {
        if (s.compareTo("original") != 0) goto _L2; else goto _L1
_L1:
        MNewCropFragment.g(a).setFloatRationWH((float)MNewCropFragment.f(a).getWidth() / (float)MNewCropFragment.f(a).getHeight());
_L4:
        FlurryAgent.logEvent((new StringBuilder()).append("crop_").append(s).toString());
        return;
_L2:
        if (s.compareTo("free") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(0.0F);
        } else
        if (s.compareTo("1-1") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(1.0F);
        } else
        if (s.compareTo("goldenH") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(1.618F);
        } else
        if (s.compareTo("goldenV") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(0.618F);
        } else
        if (s.compareTo("2-3") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(0.6666667F);
        } else
        if (s.compareTo("3-4") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(0.75F);
        } else
        if (s.compareTo("9-16") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(0.5625F);
        } else
        if (s.compareTo("3-2") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(1.5F);
        } else
        if (s.compareTo("4-3") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(1.333333F);
        } else
        if (s.compareTo("16-9") == 0)
        {
            MNewCropFragment.g(a).setFloatRationWH(1.777778F);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
