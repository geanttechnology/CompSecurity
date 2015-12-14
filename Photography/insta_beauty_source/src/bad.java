// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.commonview.TStyleCollectionView;
import com.instamag.activity.compose.MagComposeActivity;

public class bad
    implements Runnable
{

    final MagComposeActivity a;

    public bad(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public void run()
    {
        a.a.setVisibility(8);
    }
}
