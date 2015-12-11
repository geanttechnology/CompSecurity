// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaos.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wjj.eneity.Canliu;
import com.wjj.eneity.RubSoftware;
import com.wjj.eneity.RuningApp;
import com.wjj.eneity.SoftApk;
import java.util.List;

// Referenced classes of package com.xiaos.adapter:
//            PinnedHeaderExpandableAdapter

class this._cls0
{

    CheckBox check_box;
    ImageView iv;
    TextView text;
    TextView textsize;
    final PinnedHeaderExpandableAdapter this$0;


    public _cls1.this._cls1(View view)
    {
        this$0 = PinnedHeaderExpandableAdapter.this;
        super();
        text = (TextView)view.findViewById(0x7f0701a1);
        textsize = (TextView)view.findViewById(0x7f0701a2);
        check_box = (CheckBox)view.findViewById(0x7f0701a3);
        iv = (ImageView)view.findViewById(0x7f0701a0);
        check_box.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PinnedHeaderExpandableAdapter.GroupViewHolder this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                int i = ((Integer)check_box.getTag()).intValue();
                if (i != 0) goto _L2; else goto _L1
_L1:
                PinnedHeaderExpandableAdapter.access$6(this$0, flag);
                i = 0;
_L8:
                if (i < PinnedHeaderExpandableAdapter.access$1(this$0).size()) goto _L4; else goto _L3
_L3:
                PinnedHeaderExpandableAdapter.access$7(this$0).ClickGroupCheckBox(1);
_L6:
                return;
_L4:
                ((RuningApp)PinnedHeaderExpandableAdapter.access$1(this$0).get(i)).ischecked = flag;
                i++;
                continue; /* Loop/switch isn't completed */
_L2:
                if (i == 1)
                {
                    PinnedHeaderExpandableAdapter.access$8(this$0, flag);
                    i = 0;
                    do
                    {
                        if (i >= PinnedHeaderExpandableAdapter.access$3(this$0).size())
                        {
                            PinnedHeaderExpandableAdapter.access$7(this$0).ClickGroupCheckBox(2);
                            return;
                        }
                        ((RubSoftware)PinnedHeaderExpandableAdapter.access$3(this$0).get(i)).ischecked = flag;
                        i++;
                    } while (true);
                }
                if (i == 2)
                {
                    PinnedHeaderExpandableAdapter.access$9(this$0, flag);
                    i = 0;
                    do
                    {
                        if (i >= PinnedHeaderExpandableAdapter.access$4(this$0).size())
                        {
                            PinnedHeaderExpandableAdapter.access$7(this$0).ClickGroupCheckBox(3);
                            return;
                        }
                        ((Canliu)PinnedHeaderExpandableAdapter.access$4(this$0).get(i)).ischecked = flag;
                        i++;
                    } while (true);
                }
                if (i != 3) goto _L6; else goto _L5
_L5:
                PinnedHeaderExpandableAdapter.access$10(this$0, flag);
                int j = 0;
                do
                {
                    if (j >= PinnedHeaderExpandableAdapter.access$5(this$0).size())
                    {
                        PinnedHeaderExpandableAdapter.access$7(this$0).ClickGroupCheckBox(4);
                        return;
                    }
                    ((SoftApk)PinnedHeaderExpandableAdapter.access$5(this$0).get(j)).ischecked = flag;
                    j++;
                } while (true);
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                this$1 = PinnedHeaderExpandableAdapter.GroupViewHolder.this;
                super();
            }
        });
    }
}
