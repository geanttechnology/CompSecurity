// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.fotoable.photoselector.PhotoSelectScrollFragment;
import java.util.ArrayList;

public class ark
    implements android.view.View.OnClickListener
{

    final PhotoSelectScrollFragment a;

    public ark(PhotoSelectScrollFragment photoselectscrollfragment)
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
        Toast.makeText(a.getActivity(), a.getResources().getString(aej.photo_selected_zero), 0).show();
    }
}
