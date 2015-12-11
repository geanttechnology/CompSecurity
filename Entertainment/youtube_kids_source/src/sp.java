// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.google.android.apps.youtube.core.player.overlay.DefaultOverflowOverlay;

public final class sp
    implements android.content.DialogInterface.OnClickListener
{

    public sp(DefaultOverflowOverlay defaultoverflowoverlay)
    {
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }
}
