// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package co.vine.android.widget:
//            TypefacesEditText

private class this._cls0 extends InputConnectionWrapper
{

    final TypefacesEditText this$0;

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        return TypefacesEditText.access$000(TypefacesEditText.this) != null && TypefacesEditText.access$000(TypefacesEditText.this).vent(keyevent) || super.sendKeyEvent(keyevent);
    }

    public (InputConnection inputconnection, boolean flag)
    {
        this$0 = TypefacesEditText.this;
        super(inputconnection, flag);
    }
}
