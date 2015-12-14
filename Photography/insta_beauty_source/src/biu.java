// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.activity.link.view.TLinkScrollImageView;

public class biu
    implements android.view.View.OnClickListener
{

    final TLinkScrollImageView a;

    public biu(TLinkScrollImageView tlinkscrollimageview)
    {
        a = tlinkscrollimageview;
        super();
    }

    public void onClick(View view)
    {
        a.performClick();
    }
}
