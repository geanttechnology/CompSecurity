// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.database.DataSetObserver;

// Referenced classes of package co.vine.android.widget:
//            PopupEditText

private class this._cls0 extends DataSetObserver
{

    final PopupEditText this$0;

    public void onChanged()
    {
        super.onChanged();
        if (PopupEditText.access$000(PopupEditText.this))
        {
            showDropDown();
            PopupEditText.access$002(PopupEditText.this, false);
        }
    }

    public void onInvalidated()
    {
        super.onInvalidated();
        dismissDropDown();
    }

    public ()
    {
        this$0 = PopupEditText.this;
        super();
    }
}
