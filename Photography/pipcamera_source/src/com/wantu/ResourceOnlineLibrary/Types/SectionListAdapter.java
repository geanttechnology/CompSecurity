// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import uh;
import ui;

public class SectionListAdapter extends BaseAdapter
{

    public ui _flddelegate;
    public android.widget.AdapterView.OnItemClickListener itemClickListener;

    public SectionListAdapter()
    {
        itemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final SectionListAdapter a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = a.indexPathForPosition(i);
                if (((uh) (adapterview)).b >= 0)
                {
                    a._flddelegate.a(adapterview, view);
                }
            }

            
            {
                a = SectionListAdapter.this;
                super();
            }
        };
    }

    public int getCount()
    {
        int i = 0;
        int k = _flddelegate.a();
        int j = 0;
        for (; i < k; i++)
        {
            j += _flddelegate.a(i);
        }

        return j + k;
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
        uh uh1 = indexPathForPosition(i);
        if (uh1.b == -1)
        {
            Log.e("section list", (new StringBuilder()).append("index ").append(i).toString());
            return _flddelegate.a(uh1.a, view, viewgroup);
        } else
        {
            return _flddelegate.a(uh1, view, viewgroup);
        }
    }

    public uh indexPathForPosition(int i)
    {
        uh uh1 = new uh(this);
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < _flddelegate.a();)
        {
            int k = _flddelegate.a(i);
            if (j - k - 1 >= 0)
            {
                j -= k + 1;
                i++;
            } else
            {
                uh1.a = i;
                uh1.b = j - 1;
                return uh1;
            }
        }

        return uh1;
    }
}
