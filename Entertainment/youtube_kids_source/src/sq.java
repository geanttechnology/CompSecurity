// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.google.android.apps.youtube.core.player.overlay.DefaultOverflowOverlay;

public final class sq
    implements android.content.DialogInterface.OnClickListener
{

    private DefaultOverflowOverlay a;

    public sq(DefaultOverflowOverlay defaultoverflowoverlay)
    {
        a = defaultoverflowoverlay;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        DefaultOverflowOverlay.a(a);
        dialoginterface.dismiss();
        a.b();
        DefaultOverflowOverlay.a(a);
    }
}
