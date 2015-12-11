// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;

import android.app.Dialog;
import android.view.Window;

// Referenced classes of package com.amazon.retailsearch.popup:
//            DialogSizeChangedListener, PopupDialogFragment

private class <init>
    implements DialogSizeChangedListener
{

    final PopupDialogFragment this$0;

    public void onHeightChanged(int i)
    {
        if (PopupDialogFragment.access$200(PopupDialogFragment.this) != null && PopupDialogFragment.access$200(PopupDialogFragment.this).getWindow() != null && PopupDialogFragment.access$200(PopupDialogFragment.this).getWindow().getAttributes() != null)
        {
            android.view.eChangedListener echangedlistener = PopupDialogFragment.access$200(PopupDialogFragment.this).getWindow().getAttributes();
            int j;
            if (i > 0 && i < PopupDialogFragment.access$300(PopupDialogFragment.this))
            {
                j = i;
            } else
            {
                j = PopupDialogFragment.access$300(PopupDialogFragment.this);
            }
            echangedlistener._fld0 = j;
            PopupDialogFragment.access$402(PopupDialogFragment.this, i);
            PopupDialogFragment.access$200(PopupDialogFragment.this).getWindow().setAttributes(echangedlistener);
            if (PopupDialogFragment.access$500(PopupDialogFragment.this) != null)
            {
                PopupDialogFragment.access$500(PopupDialogFragment.this).izeChanged();
                return;
            }
        }
    }

    private ()
    {
        this$0 = PopupDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
