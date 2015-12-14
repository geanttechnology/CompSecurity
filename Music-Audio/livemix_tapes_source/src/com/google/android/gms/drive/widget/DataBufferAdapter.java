// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter extends BaseAdapter
{

    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int zzamI;
    private int zzamJ;
    private final int zzamK;
    private final List zzamL;
    private boolean zzamM;

    public DataBufferAdapter(Context context, int i)
    {
        this(context, i, 0, ((List) (new ArrayList())));
    }

    public DataBufferAdapter(Context context, int i, int j)
    {
        this(context, i, j, ((List) (new ArrayList())));
    }

    public DataBufferAdapter(Context context, int i, int j, List list)
    {
        zzamM = true;
        mContext = context;
        zzamJ = i;
        zzamI = i;
        zzamK = j;
        zzamL = list;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public transient DataBufferAdapter(Context context, int i, int j, DataBuffer adatabuffer[])
    {
        this(context, i, j, Arrays.asList(adatabuffer));
    }

    public DataBufferAdapter(Context context, int i, List list)
    {
        this(context, i, 0, list);
    }

    public transient DataBufferAdapter(Context context, int i, DataBuffer adatabuffer[])
    {
        this(context, i, 0, Arrays.asList(adatabuffer));
    }

    private View zza(int i, View view, ViewGroup viewgroup, int j)
    {
        if (view == null)
        {
            view = mInflater.inflate(j, viewgroup, false);
        }
        if (zzamK != 0)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        viewgroup = (TextView)view;
_L1:
        Object obj = getItem(i);
        if (obj instanceof CharSequence)
        {
            viewgroup.setText((CharSequence)obj);
            return view;
        } else
        {
            viewgroup.setText(obj.toString());
            return view;
        }
        try
        {
            viewgroup = (TextView)view.findViewById(zzamK);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            zzy.zza("DataBufferAdapter", view, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", view);
        }
          goto _L1
    }

    public void append(DataBuffer databuffer)
    {
        zzamL.add(databuffer);
        if (zzamM)
        {
            notifyDataSetChanged();
        }
    }

    public void clear()
    {
        for (Iterator iterator = zzamL.iterator(); iterator.hasNext(); ((DataBuffer)iterator.next()).release()) { }
        zzamL.clear();
        if (zzamM)
        {
            notifyDataSetChanged();
        }
    }

    public Context getContext()
    {
        return mContext;
    }

    public int getCount()
    {
        Iterator iterator = zzamL.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = ((DataBuffer)iterator.next()).getCount() + i) { }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return zza(i, view, viewgroup, zzamJ);
    }

    public Object getItem(int i)
        throws CursorIndexOutOfBoundsException
    {
        Iterator iterator = zzamL.iterator();
        int j = i;
        while (iterator.hasNext()) 
        {
            DataBuffer databuffer = (DataBuffer)iterator.next();
            int k = databuffer.getCount();
            if (k <= j)
            {
                j -= k;
            } else
            {
                Object obj;
                try
                {
                    obj = databuffer.get(j);
                }
                catch (CursorIndexOutOfBoundsException cursorindexoutofboundsexception)
                {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
                return obj;
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return zza(i, view, viewgroup, zzamI);
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        zzamM = true;
    }

    public void setDropDownViewResource(int i)
    {
        zzamJ = i;
    }

    public void setNotifyOnChange(boolean flag)
    {
        zzamM = flag;
    }
}
