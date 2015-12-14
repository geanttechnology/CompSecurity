// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.AnimationUtils;
import com.fotoable.beautyui.MNewCropFragment;
import com.fotoable.beautyui.newui.MNewItemView;
import com.fotoable.beautyui.other.TProEditCropScrollView;
import com.fotoable.beautyui.other.TProEditRotateBottomBar;

public class io
    implements android.view.View.OnClickListener
{

    final MNewCropFragment a;

    public io(MNewCropFragment mnewcropfragment)
    {
        a = mnewcropfragment;
        super();
    }

    public void onClick(View view)
    {
        if (MNewCropFragment.a(a))
        {
            MNewCropFragment.c(a).setVisibility(8);
            view = AnimationUtils.loadAnimation(a.getActivity(), 0x7f040033);
            MNewCropFragment.c(a).startAnimation(view);
            MNewCropFragment.b(a).setVisibility(0);
            view = AnimationUtils.loadAnimation(a.getActivity(), 0x7f040038);
            MNewCropFragment.b(a).startAnimation(view);
            MNewCropFragment.d(a).setSelected(false);
            MNewCropFragment.e(a).setSelected(true);
            MNewCropFragment.a(a, false);
        }
    }
}
