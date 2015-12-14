// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.activity:
//            SaveToSdCardDialogActivity

final class d extends BaseAdapter
    implements SpinnerAdapter
{

    private SaveToSdCardDialogActivity a;

    d(SaveToSdCardDialogActivity savetosdcarddialogactivity)
    {
        a = savetosdcarddialogactivity;
        super();
    }

    public final int getCount()
    {
        return SaveToSdCardDialogActivity.access$000(a).size();
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = new TextView(a);
        view.setText((CharSequence)SaveToSdCardDialogActivity.access$000(a).get(i));
        return view;
    }

    public final Object getItem(int i)
    {
        return (String)SaveToSdCardDialogActivity.access$000(a).get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final int getItemViewType(int i)
    {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = a.getLayoutInflater().inflate(0x1090008, viewgroup, false);
        ((TextView)view.findViewById(0x1020014)).setText((CharSequence)SaveToSdCardDialogActivity.access$000(a).get(i));
        return view;
    }

    public final int getViewTypeCount()
    {
        return 1;
    }

    public final boolean hasStableIds()
    {
        return false;
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final void registerDataSetObserver(DataSetObserver datasetobserver)
    {
    }

    public final void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
    }
}
