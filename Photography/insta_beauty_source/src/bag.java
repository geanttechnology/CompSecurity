// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MagComposeFragement;

public class bag
    implements android.view.View.OnClickListener
{

    final MagComposeFragement a;

    public bag(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public void onClick(View view)
    {
        MagComposeFragement.access$000(a).setVisibility(0);
        (new Thread(new bah(this))).start();
    }
}
