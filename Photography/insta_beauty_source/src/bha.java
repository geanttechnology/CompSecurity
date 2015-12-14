// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.ResourceOnlineLibrary.compose.FootItemView;

public class bha
    implements android.view.View.OnClickListener
{

    final FootItemView a;

    public bha(FootItemView footitemview)
    {
        a = footitemview;
        super();
    }

    public void onClick(View view)
    {
        if (FootItemView.access$000(a) != null)
        {
            FootItemView.access$000(a).a(view);
        }
    }
}
