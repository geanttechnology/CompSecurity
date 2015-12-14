// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.wantu.activity.photoselector.PhotoSelectScrollFragment;
import java.util.ArrayList;

public class bjl
    implements android.view.View.OnClickListener
{

    final PhotoSelectScrollFragment a;

    public bjl(PhotoSelectScrollFragment photoselectscrollfragment)
    {
        a = photoselectscrollfragment;
        super();
    }

    public void onClick(View view)
    {
label0:
        {
            if (PhotoSelectScrollFragment.a(a) != null)
            {
                if (PhotoSelectScrollFragment.a(a).a() == null || PhotoSelectScrollFragment.a(a).a().size() <= 0)
                {
                    break label0;
                }
                PhotoSelectScrollFragment.a(a).b();
            }
            return;
        }
        Toast.makeText(a.getActivity(), a.getResources().getString(0x7f0601ad), 0).show();
    }
}
