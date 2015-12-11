// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.TextView;
import co.vine.android.drawable.ColoredOvalDrawable;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

public class holder
    implements android.view.er
{

    private final sition holder;
    final ConversationAdapter this$0;

    public void onClick(View view)
    {
        holder.nishMessageContainer.setVisibility(8);
        holder.nishThumbnailOverlay.setVisibility(8);
        holder.adImage.setVisibility(0);
        holder.merOval.setColor(0xff000000 | holder.lor);
        holder.nishTimerText.setVisibility(0);
        holder.nishTimerText.invalidate();
        play(holder.sition);
    }

    public ( )
    {
        this$0 = ConversationAdapter.this;
        super();
        holder = ;
    }
}
