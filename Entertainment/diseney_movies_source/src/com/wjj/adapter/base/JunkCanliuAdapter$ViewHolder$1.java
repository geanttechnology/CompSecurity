// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.wjj.eneity.Canliu;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            JunkCanliuAdapter

class this._cls1
    implements android.widget.istener
{

    final this._cls1 this$1;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        int i = ((Integer)eck_box.getTag()).intValue();
        ((Canliu)cess._mth0(this._cls1.this).list.get(i)).ischecked = flag;
    }

    r()
    {
        this$1 = this._cls1.this;
        super();
    }
}
