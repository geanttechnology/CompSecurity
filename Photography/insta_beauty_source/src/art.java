// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.photoselector.activity.PhotoSelectScrollFragment;

public class art
    implements android.view.View.OnClickListener
{

    final PhotoSelectScrollFragment a;

    public art(PhotoSelectScrollFragment photoselectscrollfragment)
    {
        a = photoselectscrollfragment;
        super();
    }

    public void onClick(View view)
    {
        if (PhotoSelectScrollFragment.a(a) != null)
        {
            PhotoSelectScrollFragment.a(a).d();
        }
    }
}
