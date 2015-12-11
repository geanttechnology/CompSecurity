// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bestbuy.android.activities.blueassist.BlueAssistDateTimeSelectionActivity;
import java.util.List;

public class bt extends BaseAdapter
{

    final BlueAssistDateTimeSelectionActivity a;
    private Context b;
    private List c;

    public bt(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity, Context context, List list)
    {
        a = blueassistdatetimeselectionactivity;
        super();
        b = context;
        c = list;
    }

    public int getCount()
    {
        return c.size();
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
        view = a.getLayoutInflater().inflate(0x7f03002b, null);
        viewgroup = (TextView)view.findViewById(0x7f0c00b6);
        viewgroup.setText((CharSequence)c.get(i));
        if (c.contains(BlueAssistDateTimeSelectionActivity.d(a)) && c.indexOf(BlueAssistDateTimeSelectionActivity.d(a)) == i)
        {
            viewgroup.setTypeface(null, 1);
            viewgroup.setTextSize(18F);
            return view;
        } else
        {
            viewgroup.setTypeface(null, 0);
            viewgroup.setTextSize(17F);
            return view;
        }
    }
}
