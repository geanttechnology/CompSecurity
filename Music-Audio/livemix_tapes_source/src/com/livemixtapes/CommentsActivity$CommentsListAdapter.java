// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.livemixtapes:
//            CommentsActivity

public class comments extends BaseAdapter
{

    private Activity activity;
    private List comments;
    private LayoutInflater inflater;
    final CommentsActivity this$0;

    public int getCount()
    {
        return comments.size();
    }

    public Object getItem(int i)
    {
        return comments.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        Object obj1;
        if (inflater == null)
        {
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        }
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f03001d, null);
        }
        obj1 = (TextView)viewgroup.findViewById(0x7f080074);
        TextView textview = (TextView)viewgroup.findViewById(0x7f080063);
        view = (TextView)viewgroup.findViewById(0x7f080075);
        obj = (HashMap)comments.get(i);
        ((TextView) (obj1)).setText((CharSequence)((HashMap) (obj)).get("username"));
        textview.setText((CharSequence)((HashMap) (obj)).get("comment"));
        obj1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        ((SimpleDateFormat) (obj1)).setTimeZone(TimeZone.getTimeZone("UTC"));
        obj = ((SimpleDateFormat) (obj1)).parse((String)((HashMap) (obj)).get("timestamp"));
        obj1 = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
        ((SimpleDateFormat) (obj1)).setTimeZone(TimeZone.getDefault());
        view.setText(((SimpleDateFormat) (obj1)).format(((java.util.Date) (obj))));
        return viewgroup;
        view;
_L2:
        view.printStackTrace();
        return viewgroup;
        view;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public (Activity activity1, List list)
    {
        this$0 = CommentsActivity.this;
        super();
        activity = activity1;
        comments = list;
    }
}
