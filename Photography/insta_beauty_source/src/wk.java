// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wk
    implements uy
{

    final MSlimBodyFragment a;

    public wk(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void a()
    {
        if (a.getActivity() != null)
        {
            a.getActivity().runOnUiThread(new wl(this));
        }
    }
}
