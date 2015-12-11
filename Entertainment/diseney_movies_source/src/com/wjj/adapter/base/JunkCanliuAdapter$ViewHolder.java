// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.wjj.eneity.Canliu;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            JunkCanliuAdapter

class check_box
{

    CheckBox check_box;
    TextView name;
    TextView size;
    final JunkCanliuAdapter this$0;


    public ner(View view)
    {
        this$0 = JunkCanliuAdapter.this;
        super();
        check_box = (CheckBox)view.findViewById(0x7f07025b);
        name = (TextView)view.findViewById(0x7f070259);
        size = (TextView)view.findViewById(0x7f07025a);
        check_box.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final JunkCanliuAdapter.ViewHolder this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                int i = ((Integer)check_box.getTag()).intValue();
                ((Canliu)list.get(i)).ischecked = flag;
            }

            
            {
                this$1 = JunkCanliuAdapter.ViewHolder.this;
                super();
            }
        });
    }
}
