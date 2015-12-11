// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wjj.eneity.RuningApp;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            BoostPhoneAdapter

class check_box
{

    CheckBox check_box;
    ImageView iv_icon;
    final BoostPhoneAdapter this$0;
    TextView tv_appname;
    TextView tv_appsize;


    public ner(View view)
    {
        this$0 = BoostPhoneAdapter.this;
        super();
        check_box = (CheckBox)view.findViewById(0x7f070254);
        iv_icon = (ImageView)view.findViewById(0x7f070252);
        tv_appname = (TextView)view.findViewById(0x7f07024e);
        tv_appsize = (TextView)view.findViewById(0x7f070253);
        check_box.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final BoostPhoneAdapter.ViewHolder this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                int i = ((Integer)check_box.getTag()).intValue();
                ((RuningApp)list.get(i)).ischecked = flag;
            }

            
            {
                this$1 = BoostPhoneAdapter.ViewHolder.this;
                super();
            }
        });
    }
}
