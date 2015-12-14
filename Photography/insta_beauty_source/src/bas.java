// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MagComposeLinkFragement;

public class bas
    implements android.view.View.OnClickListener
{

    final MagComposeLinkFragement a;

    public bas(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public void onClick(View view)
    {
        MagComposeLinkFragement.a(a, view);
    }
}
