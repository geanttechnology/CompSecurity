// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wjj.eneity.SoftApk;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            ApkSoftAdapter

class check_box
{

    CheckBox check_box;
    ImageView iv_icon;
    TextView soft_version;
    final ApkSoftAdapter this$0;
    TextView tv_softname;
    TextView tv_softsizi;


    public stener(View view)
    {
        this$0 = ApkSoftAdapter.this;
        super();
        soft_version = (TextView)view.findViewById(0x7f07024f);
        check_box = (CheckBox)view.findViewById(0x7f070251);
        iv_icon = (ImageView)view.findViewById(0x7f07024d);
        tv_softname = (TextView)view.findViewById(0x7f07024e);
        tv_softsizi = (TextView)view.findViewById(0x7f070250);
        check_box.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ApkSoftAdapter.ViewHolder this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                int i = ((Integer)check_box.getTag()).intValue();
                ((SoftApk)list.get(i)).ischecked = flag;
            }

            
            {
                this$1 = ApkSoftAdapter.ViewHolder.this;
                super();
            }
        });
    }
}
