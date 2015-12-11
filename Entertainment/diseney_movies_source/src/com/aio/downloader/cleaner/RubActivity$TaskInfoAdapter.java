// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity, TaskInfo, TextFormater

private class this._cls0 extends BaseAdapter
{

    final RubActivity this$0;

    private TextView newTextView(String s)
    {
        TextView textview = new TextView(RubActivity.this);
        textview.setText(s);
        return textview;
    }

    public int getCount()
    {
        if (RubActivity.access$22(RubActivity.this).getBoolean("showSystemProcess", false))
        {
            return RubActivity.access$19(RubActivity.this).size() + 2;
        } else
        {
            return RubActivity.access$21(RubActivity.this).size() + 1;
        }
    }

    public Object getItem(int i)
    {
        if (i == 0)
        {
            return Integer.valueOf(0);
        }
        if (i <= RubActivity.access$21(RubActivity.this).size())
        {
            return RubActivity.access$21(RubActivity.this).get(i - 1);
        }
        if (i == RubActivity.access$21(RubActivity.this).size() + 1)
        {
            return Integer.valueOf(i);
        }
        if (i <= RubActivity.access$19(RubActivity.this).size() + 2)
        {
            return RubActivity.access$20(RubActivity.this).get(i - RubActivity.access$21(RubActivity.this).size() - 2);
        } else
        {
            return Integer.valueOf(i);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        this._cls0 _lcls0;
        Iterator iterator;
        if (i == 0)
        {
            return newTextView((new StringBuilder("  User Process(")).append(RubActivity.access$21(RubActivity.this).size()).append(")").toString());
        }
        if (i <= RubActivity.access$21(RubActivity.this).size())
        {
            viewgroup = (TaskInfo)RubActivity.access$21(RubActivity.this).get(i - 1);
        } else
        {
            if (i == RubActivity.access$21(RubActivity.this).size() + 1)
            {
                return newTextView((new StringBuilder("System process(")).append(RubActivity.access$20(RubActivity.this).size()).append(")").toString());
            }
            if (i <= RubActivity.access$19(RubActivity.this).size() + 2)
            {
                viewgroup = (TaskInfo)RubActivity.access$20(RubActivity.this).get(i - RubActivity.access$21(RubActivity.this).size() - 2);
            } else
            {
                viewgroup = new TaskInfo();
            }
        }
        if (view != null && !(view instanceof TextView))
        {
            break MISSING_BLOCK_LABEL_580;
        }
        view = View.inflate(RubActivity.this, 0x7f0300a1, null);
        _lcls0 = new nit>(RubActivity.this, null);
        _lcls0._process_icon = (ImageView)view.findViewById(0x7f07037a);
        _lcls0._process_name = (TextView)view.findViewById(0x7f07037b);
        _lcls0._process_memory = (TextView)view.findViewById(0x7f07037c);
        _lcls0._process_state = (CheckBox)view.findViewById(0x7f070131);
        view.setTag(_lcls0);
        iterator = RubActivity.access$21(RubActivity.this).iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Log.e("www", (new StringBuilder("getview_memory=")).append(MymemorySize).toString());
_L4:
        _lcls0._process_icon.setImageDrawable(viewgroup.getIcon());
        _lcls0._process_name.setText(viewgroup.getName());
        _lcls0._process_memory.setText((new StringBuilder("Junk File:")).append(TextFormater.getSizeFromKB(viewgroup.getMemory())).toString());
        RubActivity.access$2(RubActivity.this).setText((new StringBuilder("Junk File")).append(RubActivity.access$21(RubActivity.this).size()).toString());
        TaskInfo taskinfo;
        RubActivity rubactivity;
        if ("com.allinone.free".equals(viewgroup.getPackageName()) || "system".equals(viewgroup.getPackageName()) || "android.process.media".equals(viewgroup.getPackageName()))
        {
            _lcls0._process_state.setVisibility(4);
            _lcls0._process_memory.setText((new StringBuilder("Junk File:")).append(String.valueOf((int)(Math.random() * 10D + 1.0D))).append("MB").toString());
        } else
        {
            _lcls0._process_state.setVisibility(0);
        }
        _lcls0._process_state.setChecked(viewgroup.isCheck());
        viewgroup.isCheck();
        return view;
_L2:
        taskinfo = (TaskInfo)iterator.next();
        rubactivity = RubActivity.this;
        rubactivity.MymemorySize = rubactivity.MymemorySize + taskinfo.getMemory();
          goto _L3
        _lcls0 = (this._cls0)view.getTag();
          goto _L4
    }

    public ()
    {
        this$0 = RubActivity.this;
        super();
        RubActivity.access$17(RubActivity.this, new ArrayList());
        RubActivity.access$18(RubActivity.this, new ArrayList());
        Iterator iterator = RubActivity.access$19(RubActivity.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            TaskInfo taskinfo = (TaskInfo)iterator.next();
            if (taskinfo.isSystemProcess())
            {
                RubActivity.access$20(RubActivity.this).add(taskinfo);
            } else
            if (!taskinfo.getName().contains("Google") && !taskinfo.getPackageName().equals("com.allinone.free") && !taskinfo.getName().contains("google") && !taskinfo.getPackageName().contains("google"))
            {
                RubActivity.access$21(RubActivity.this).add(taskinfo);
            }
        } while (true);
    }
}
