// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

// Referenced classes of package myobfuscated.bt:
//            i

final class it>
    implements android.view..OnClickListener
{

    private i a;

    public final void onClick(View view)
    {
        view = a;
        if (view.getView() != null)
        {
            ((i) (view)).b.clear();
            ((i) (view)).a.removeAllViews();
            view.getView().setVisibility(8);
            view.a();
        }
    }

    rLayout(i j)
    {
        a = j;
        super();
    }
}
