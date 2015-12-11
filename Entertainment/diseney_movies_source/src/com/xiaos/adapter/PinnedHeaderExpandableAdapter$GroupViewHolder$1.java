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
        if (i != 0) goto _L2; else goto _L1
_L1:
        PinnedHeaderExpandableAdapter.access$6(cess._mth0(this._cls1.this), flag);
        i = 0;
_L8:
        if (i < PinnedHeaderExpandableAdapter.access$1(cess._mth0(this._cls1.this)).size()) goto _L4; else goto _L3
_L3:
        PinnedHeaderExpandableAdapter.access$7(cess._mth0(this._cls1.this)).ClickGroupCheckBox(1);
_L6:
        return;
_L4:
        ((RuningApp)PinnedHeaderExpandableAdapter.access$1(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == 1)
        {
            PinnedHeaderExpandableAdapter.access$8(cess._mth0(this._cls1.this), flag);
            i = 0;
            do
            {
                if (i >= PinnedHeaderExpandableAdapter.access$3(cess._mth0(this._cls1.this)).size())
                {
                    PinnedHeaderExpandableAdapter.access$7(cess._mth0(this._cls1.this)).ClickGroupCheckBox(2);
                    return;
                }
                ((RubSoftware)PinnedHeaderExpandableAdapter.access$3(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
                i++;
            } while (true);
        }
        if (i == 2)
        {
            PinnedHeaderExpandableAdapter.access$9(cess._mth0(this._cls1.this), flag);
            i = 0;
            do
            {
                if (i >= PinnedHeaderExpandableAdapter.access$4(cess._mth0(this._cls1.this)).size())
                {
                    PinnedHeaderExpandableAdapter.access$7(cess._mth0(this._cls1.this)).ClickGroupCheckBox(3);
                    return;
                }
                ((Canliu)PinnedHeaderExpandableAdapter.access$4(cess._mth0(this._cls1.this)).get(i)).ischecked = flag;
                i++;
            } while (true);
        }
        if (i != 3) goto _L6; else goto _L5
_L5:
        PinnedHeaderExpandableAdapter.access$10(cess._mth0(this._cls1.this), flag);
        int j = 0;
        do
        {
            if (j >= PinnedHeaderExpandableAdapter.access$5(cess._mth0(this._cls1.this)).size())
            {
                PinnedHeaderExpandableAdapter.access$7(cess._mth0(this._cls1.this)).ClickGroupCheckBox(4);
                return;
            }
            ((SoftApk)PinnedHeaderExpandableAdapter.access$5(cess._mth0(this._cls1.this)).get(j)).ischecked = flag;
            j++;
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
