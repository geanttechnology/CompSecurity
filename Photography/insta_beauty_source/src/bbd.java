// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MagComposeLinkFragement;

public class bbd
    implements android.view.View.OnLongClickListener
{

    final MagComposeLinkFragement a;

    public bbd(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public boolean onLongClick(View view)
    {
        MagComposeLinkFragement.a(a);
        MagComposeLinkFragement.a(a, view, 1);
        return true;
    }
}
