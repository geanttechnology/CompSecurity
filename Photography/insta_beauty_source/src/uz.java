// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MNewProEditScrollView;

public class uz
    implements android.view.View.OnClickListener
{

    final MNewProEditScrollView a;

    public uz(MNewProEditScrollView mnewproeditscrollview)
    {
        a = mnewproeditscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (MNewProEditScrollView.access$000(a) != null)
        {
            MNewProEditScrollView.access$000(a).a(a, (com.fotoable.beautyui.newui.MNewProEditScrollView.SecondToolState)view.getTag());
        }
    }
}
