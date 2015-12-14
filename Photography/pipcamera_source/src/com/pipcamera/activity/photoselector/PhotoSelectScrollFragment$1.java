// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import sq;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            PhotoSelectScrollFragment

class a
    implements android.view.oSelectScrollFragment._cls1
{

    final PhotoSelectScrollFragment a;

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
        Toast.makeText(a.getActivity(), a.getResources().getString(0x7f060046), 0).show();
    }

    (PhotoSelectScrollFragment photoselectscrollfragment)
    {
        a = photoselectscrollfragment;
        super();
    }
}
