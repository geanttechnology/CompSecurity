// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class wd
    implements uy
{

    final Bitmap a;
    final MOneKeyFragment b;

    public wd(MOneKeyFragment monekeyfragment, Bitmap bitmap)
    {
        b = monekeyfragment;
        a = bitmap;
        super();
    }

    public void a()
    {
        if (b.getActivity() != null)
        {
            b.getActivity().runOnUiThread(new we(this));
        }
    }
}
