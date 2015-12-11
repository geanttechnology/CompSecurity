// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.RadioGroup;
import android.widget.Spinner;

// Referenced classes of package co.vine.android:
//            LocaleDialog

class this._cls0
    implements android.widget.eckedChangeListener
{

    final LocaleDialog this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        radiogroup = LocaleDialog.access$100(LocaleDialog.this);
        boolean flag;
        if (i == 0x7f0a0113)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        radiogroup.setEnabled(flag);
        LocaleDialog.access$202(LocaleDialog.this, true);
    }

    ckedChangeListener()
    {
        this$0 = LocaleDialog.this;
        super();
    }
}
