// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.comcast.cim.android.view.common:
//            SelectionListDialogFragment

class this._cls0 extends BaseAdapter
{

    final SelectionListDialogFragment this$0;

    public int getCount()
    {
        return selectionItems.length;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = SelectionListDialogFragment.access$100(SelectionListDialogFragment.this).inflate(com.comcast.cim.android.ListAdapter.this._fld0, null);
        ((TextView)view.findViewById(com.comcast.cim.android.ListAdapter.this._fld0)).setText(getDisplayText(selectionItems[i]));
        viewgroup = (CheckBox)view.findViewById(com.comcast.cim.android.Items);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final SelectionListDialogFragment.SelectionListAdapter this$1;

            public void onClick(View view1)
            {
                boolean flag1 = false;
                int k = view1.getId();
                if (SelectionListDialogFragment.access$200(this$0) < 0 || SelectionListDialogFragment.access$200(this$0) != k || isToggleable)
                {
                    view1 = this$0;
                    int j = k;
                    if (SelectionListDialogFragment.access$200(this$0) == k)
                    {
                        j = -1;
                    }
                    SelectionListDialogFragment.access$202(view1, j);
                    k = SelectionListDialogFragment.access$300(this$0).getFirstVisiblePosition();
                    view1 = SelectionListDialogFragment.access$300(this$0).getChildAt(0);
                    if (view1 == null)
                    {
                        j = ((flag1) ? 1 : 0);
                    } else
                    {
                        j = view1.getTop();
                    }
                    ((SelectionListDialogFragment.SelectionListAdapter)SelectionListDialogFragment.access$300(this$0).getAdapter()).notifyDataSetInvalidated();
                    SelectionListDialogFragment.access$300(this$0).setSelectionFromTop(k, j);
                    if (cancelOnSelectionChanged)
                    {
                        getDialog().cancel();
                        return;
                    }
                }
            }

            
            {
                this$1 = SelectionListDialogFragment.SelectionListAdapter.this;
                super();
            }
        });
        viewgroup.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SelectionListDialogFragment.SelectionListAdapter this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                if (flag1 && compoundbutton.getId() != SelectionListDialogFragment.access$200(this$0) || isToggleable)
                {
                    onSelectionChangedListener.onSelectionChanged(compoundbutton.getId());
                    return;
                } else
                {
                    compoundbutton.setChecked(true);
                    return;
                }
            }

            
            {
                this$1 = SelectionListDialogFragment.SelectionListAdapter.this;
                super();
            }
        });
        boolean flag;
        if (SelectionListDialogFragment.access$200(SelectionListDialogFragment.this) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.setChecked(flag);
        viewgroup.setId(i);
        return view;
    }

    _cls2.this._cls1()
    {
        this$0 = SelectionListDialogFragment.this;
        super();
    }
}
