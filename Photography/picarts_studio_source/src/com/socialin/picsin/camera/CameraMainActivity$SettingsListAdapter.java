// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.picsin.camera:
//            e, CameraMainActivity

class this._cls0 extends ArrayList
    implements ListAdapter
{

    private static final long serialVersionUID = 0x959d9315733bdd64L;
    private final HashMap SETTINGS_NAMES_MAP = new HashMap() {

        final CameraMainActivity.SettingsListAdapter this$1;

            
            {
                this$1 = CameraMainActivity.SettingsListAdapter.this;
                super();
                put("White Balance", Integer.valueOf(0x7f080098));
                put("Scene Modes", Integer.valueOf(0x7f080094));
                put("Sound", Integer.valueOf(0x7f080097));
                put("Effects", Integer.valueOf(0x7f080091));
                put("Reset defaults", Integer.valueOf(0x7f080093));
            }
    };
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    final CameraMainActivity this$0;

    public boolean areAllItemsEnabled()
    {
        return true;
    }

    public int getCount()
    {
        return size();
    }

    public e getItem(int i)
    {
        return (e)get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public e getItemByName(String s)
    {
        int j = size();
        for (int i = 0; i < j; i++)
        {
            e e1 = (e)get(i);
            if (e1.a.equals(s))
            {
                return e1;
            }
        }

        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        e e1 = getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = getLayoutInflater().inflate(0x7f030054, null);
        }
        TextView textview = (TextView)viewgroup.findViewById(0x7f100252);
        view = e1.a;
        if (SETTINGS_NAMES_MAP.containsKey(e1.a))
        {
            i = ((Integer)SETTINGS_NAMES_MAP.get(e1.a)).intValue();
            view = getString(i);
        }
        textview.setText(view);
        view = (TextView)viewgroup.findViewById(0x7f100253);
        view.setText(e1.b);
        view.setTag((new StringBuilder()).append(e1.a).append("_value").toString());
        view = (CheckBox)viewgroup.findViewById(0x7f100254);
        view.setTag(e1.a);
        if (e1.c)
        {
            view.setChecked(e1.d);
            view.setVisibility(0);
            return viewgroup;
        } else
        {
            view.setVisibility(8);
            return viewgroup;
        }
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean isEnabled(int i)
    {
        return true;
    }

    public void notifyDataSetChanged()
    {
        mDataSetObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObservable.registerObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObservable.unregisterObserver(datasetobserver);
    }

    public _cls1.put()
    {
        this$0 = CameraMainActivity.this;
        super();
    }
}
