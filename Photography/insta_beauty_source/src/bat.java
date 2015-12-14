// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MagComposeLinkFragement;

public class bat
    implements android.view.View.OnClickListener
{

    final MagComposeLinkFragement a;

    public bat(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public void onClick(View view)
    {
        MagComposeLinkFragement.b(a, view);
    }
}
