// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vh
    implements uy
{

    final MNewSofterFragment a;

    public vh(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void a()
    {
        if (a.getActivity() != null)
        {
            a.getActivity().runOnUiThread(new vi(this));
        }
    }
}
