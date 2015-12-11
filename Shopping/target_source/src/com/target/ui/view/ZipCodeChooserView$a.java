// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.target.ui.view:
//            ZipCodeChooserView

private static class zipCodeSearchButton
{

    public EditText zipCodeEditText;
    public Button zipCodeSearchButton;

    public (View view)
    {
        zipCodeEditText = (EditText)view.findViewById(0x7f1005ee);
        zipCodeSearchButton = (Button)view.findViewById(0x7f1005ef);
    }
}
