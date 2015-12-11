// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            NotificationSettingsFragment

class selectionIndicator
{

    View header;
    TextView headerText;
    View selectionIndicator;
    Spinner spinner;
    final selectionIndicator this$1;
    TextView title;

    public (View view)
    {
        this$1 = this._cls1.this;
        super();
        header = view.findViewById(0x7f0a005b);
        headerText = (TextView)view.findViewById(0x7f0a005c);
        title = (TextView)view.findViewById(0x7f0a004a);
        spinner = (Spinner)view.findViewById(0x7f0a0149);
        selectionIndicator = view.findViewById(0x7f0a0148);
    }
}
