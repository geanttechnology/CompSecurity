// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            PopupOverlayMessage

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, PopupOverlayMessage popupoverlaymessage, Object obj)
    {
        popupoverlaymessage.overlayContainer = (View)nder.iew(obj, 0x7f100481, "field 'overlayContainer'");
        popupoverlaymessage.messageTextView = (TextView)nder.TextView((View)nder.iew(obj, 0x7f100482, "field 'messageTextView'"), 0x7f100482, "field 'messageTextView'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (PopupOverlayMessage)obj, obj1);
    }

    public void unbind(PopupOverlayMessage popupoverlaymessage)
    {
        popupoverlaymessage.overlayContainer = null;
        popupoverlaymessage.messageTextView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((PopupOverlayMessage)obj);
    }

    public ()
    {
    }
}
