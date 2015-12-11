// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaos.adapter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.wjj.eneity.Canliu;
import com.wjj.eneity.RubSoftware;
import com.wjj.eneity.RuningApp;
import com.wjj.eneity.SoftApk;
import java.util.List;

// Referenced classes of package com.xiaos.adapter:
//            PinnedHeaderExpandableAdapter

class this._cls1
    implements android.widget.._cls1
{

    final this._cls1 this$1;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        int i = ((Integer)eck_box.getTag()).intValue();
        if (PinnedHeaderExpandableAdapter.access$0(cess._mth0(this._cls1.this)) == 0)
        {
            ((RuningApp)PinnedHeaderExpandableAdapter.access$1(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
        } else
        {
            if (PinnedHeaderExpandableAdapter.access$0(cess._mth0(this._cls1.this)) == 1)
            {
                PinnedHeaderExpandableAdapter.access$2(cess._mth0(this._cls1.this), 0);
                ((RubSoftware)PinnedHeaderExpandableAdapter.access$3(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
                return;
            }
            if (PinnedHeaderExpandableAdapter.access$0(cess._mth0(this._cls1.this)) == 2)
            {
                ((Canliu)PinnedHeaderExpandableAdapter.access$4(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
                return;
            }
            if (PinnedHeaderExpandableAdapter.access$0(cess._mth0(this._cls1.this)) == 3)
            {
                ((SoftApk)PinnedHeaderExpandableAdapter.access$5(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
                return;
            }
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
