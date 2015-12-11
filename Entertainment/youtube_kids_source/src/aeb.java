// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.ui.TimeBar;

final class aeb
    implements agg
{

    final adw this$0;

    private aeb(adw adw1)
    {
        this$0 = adw1;
        super();
    }

    aeb(adw adw1, adx adx)
    {
        this(adw1);
    }

    public final void onScrubbingEnd(int i)
    {
        adw.access$200(adw.this).b = false;
        if (adw.access$000(adw.this) != null)
        {
            adw.access$000(adw.this).onSeekTo(i);
        }
    }

    public final void onScrubbingStart()
    {
    }
}
