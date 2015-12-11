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
    ImageView iv_icon;
    final PinnedHeaderExpandableAdapter this$0;
    TextView tv_appname;
    TextView tv_appsize;


    public _cls1.this._cls1(View view)
    {
        this$0 = PinnedHeaderExpandableAdapter.this;
        super();
        check_box = (CheckBox)view.findViewById(0x7f07025b);
        iv_icon = (ImageView)view.findViewById(0x7f070255);
        tv_appname = (TextView)view.findViewById(0x7f070259);
        tv_appsize = (TextView)view.findViewById(0x7f07025a);
        check_box.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PinnedHeaderExpandableAdapter.ChildViewHolder this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                int i = ((Integer)check_box.getTag()).intValue();
                if (PinnedHeaderExpandableAdapter.access$0(this$0) == 0)
                {
                    ((RuningApp)PinnedHeaderExpandableAdapter.access$1(this$0).get(i)).ischecked = flag;
                } else
                {
                    if (PinnedHeaderExpandableAdapter.access$0(this$0) == 1)
                    {
                        PinnedHeaderExpandableAdapter.access$2(this$0, 0);
                        ((RubSoftware)PinnedHeaderExpandableAdapter.access$3(this$0).get(i)).ischecked = flag;
                        return;
                    }
                    if (PinnedHeaderExpandableAdapter.access$0(this$0) == 2)
                    {
                        ((Canliu)PinnedHeaderExpandableAdapter.access$4(this$0).get(i)).ischecked = flag;
                        return;
                    }
                    if (PinnedHeaderExpandableAdapter.access$0(this$0) == 3)
                    {
                        ((SoftApk)PinnedHeaderExpandableAdapter.access$5(this$0).get(i)).ischecked = flag;
                        return;
                    }
                }
            }

            
            {
                this$1 = PinnedHeaderExpandableAdapter.ChildViewHolder.this;
                super();
            }
        });
    }
}
