// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;

// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            VoiceSearchDialog

class this._cls0
    implements android.widget.tory
{

    final VoiceSearchDialog this$0;

    public View makeView()
    {
        TextView textview;
        try
        {
            textview = (TextView)LayoutInflater.from(VoiceSearchDialog.access$000(VoiceSearchDialog.this).getContext()).inflate(com.amazon.shopapp.voice.itle, null);
            textview.setSingleLine();
            textview.setEllipsize(android.text..END);
        }
        catch (Throwable throwable)
        {
            Log.e(VoiceSearchDialog.access$100(), "Error", throwable);
            return null;
        }
        return textview;
    }

    ()
    {
        this$0 = VoiceSearchDialog.this;
        super();
    }
}
