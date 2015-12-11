// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;

import android.app.Dialog;
import android.view.Window;

// Referenced classes of package com.amazon.retailsearch.popup:
//            DialogSizeChangedListener, PopupDialogFragmentV4

private class <init>
    implements DialogSizeChangedListener
{

    final PopupDialogFragmentV4 this$0;

    public void onHeightChanged(int i)
    {
        android.view.eChangedListener echangedlistener = PopupDialogFragmentV4.access$200(PopupDialogFragmentV4.this).getWindow().getAttributes();
        int j;
        if (i > 0 && i < PopupDialogFragmentV4.access$300(PopupDialogFragmentV4.this))
        {
            j = i;
        } else
        {
            j = PopupDialogFragmentV4.access$300(PopupDialogFragmentV4.this);
        }
        echangedlistener._fld0 = j;
        PopupDialogFragmentV4.access$402(PopupDialogFragmentV4.this, i);
        PopupDialogFragmentV4.access$200(PopupDialogFragmentV4.this).getWindow().setAttributes(echangedlistener);
        if (PopupDialogFragmentV4.access$500(PopupDialogFragmentV4.this) != null)
        {
            PopupDialogFragmentV4.access$500(PopupDialogFragmentV4.this).izeChanged();
        }
    }

    private ()
    {
        this$0 = PopupDialogFragmentV4.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
