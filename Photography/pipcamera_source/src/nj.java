// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.fotoable.photoselector.ui.CollectionListItemView;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import java.util.ArrayList;

public class nj extends BaseAdapter
{

    final PhotoColletionListFragment a;
    private final Context b;
    private int c;
    private ArrayList d;
    private android.widget.AbsListView.LayoutParams e;

    public nj(PhotoColletionListFragment photocolletionlistfragment, Activity activity, ArrayList arraylist, fq fq)
    {
        a = photocolletionlistfragment;
        super();
        c = 0;
        b = activity;
        e = new android.widget.AbsListView.LayoutParams(-1, -1);
    }

    public void a(ArrayList arraylist)
    {
        d = arraylist;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (d == null)
        {
            return 0;
        } else
        {
            return d.size();
        }
    }

    public Object getItem(int i)
    {
        return d.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = ((ViewGroup) (d.get(i)));
        if (viewgroup instanceof nu)
        {
            if (view == null)
            {
                view = new CollectionListItemView(b, PhotoColletionListFragment.a(a));
                view.setLayoutParams(e);
            } else
            {
                view = (CollectionListItemView)view;
            }
            if (view.getLayoutParams().height != c)
            {
                view.setLayoutParams(e);
            }
            view.SetDataItem((nu)viewgroup);
            return view;
        } else
        {
            Log.e("PhotoColletionListFragment", String.format("getView no view for the specified positon %d ", new Object[] {
                Integer.valueOf(i)
            }));
            return null;
        }
    }

    public int getViewTypeCount()
    {
        return 1;
    }
}
