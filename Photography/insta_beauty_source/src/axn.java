// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.fotoable.sketch.view.TTieZhiLibraryView;
import com.fotoable.sketch.view.TTieZhiTableHeaderView;
import com.fotoable.sketch.view.TTieZhiViewListCell;
import java.util.ArrayList;
import java.util.List;

public class axn extends BaseExpandableListAdapter
{

    final TTieZhiLibraryView a;

    public axn(TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }

    public Object getChild(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        if (i < a.mTypeInfo.e.size() && i >= 0)
        {
            awj awj1 = (awj)a.mTypeInfo.e.get(i);
            if (awj1 != null && awj1.e != null)
            {
                i = j * 4;
                if (i < awj1.e.size())
                {
                    arraylist.add(awj1.e.get(i));
                    if (i + 1 < awj1.e.size())
                    {
                        arraylist.add(awj1.e.get(i + 1));
                        if (i + 2 < awj1.e.size())
                        {
                            arraylist.add(awj1.e.get(i + 2));
                            if (i + 3 < awj1.e.size())
                            {
                                arraylist.add(awj1.e.get(i + 3));
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public long getChildId(int i, int j)
    {
        return 0L;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
label0:
        {
label1:
            {
                if (i >= a.mTypeInfo.e.size())
                {
                    return null;
                }
                if (view == null)
                {
                    view = new TTieZhiViewListCell(a.getContext(), a.imageWorker);
                }
                viewgroup = new ArrayList();
                if (i < a.mTypeInfo.e.size() && i >= 0)
                {
                    awj awj1 = (awj)a.mTypeInfo.e.get(i);
                    if (awj1 == null || awj1.e == null)
                    {
                        break label0;
                    }
                    i = j * 4;
                    if (i >= awj1.e.size())
                    {
                        break label1;
                    }
                    viewgroup.add(awj1.e.get(i));
                    if (i + 1 < awj1.e.size())
                    {
                        viewgroup.add(awj1.e.get(i + 1));
                        if (i + 2 < awj1.e.size())
                        {
                            viewgroup.add(awj1.e.get(i + 2));
                            if (i + 3 < awj1.e.size())
                            {
                                viewgroup.add(awj1.e.get(i + 3));
                            }
                        }
                    }
                }
                ((TTieZhiViewListCell)view).setItemClickLisener(a.lisener);
                ((TTieZhiViewListCell)view).setDataItem(viewgroup);
                return view;
            }
            return null;
        }
        return null;
    }

    public int getChildrenCount(int i)
    {
        if (a.mTypeInfo != null && a.mTypeInfo.e != null && i < a.mTypeInfo.e.size() && i >= 0)
        {
            awj awj1 = (awj)a.mTypeInfo.e.get(i);
            if (awj1 != null && awj1.e != null)
            {
                int k = awj1.e.size();
                int j = k / 4;
                i = j;
                if (j * 4 < k)
                {
                    i = j + 1;
                }
                return i;
            }
        }
        return 0;
    }

    public Object getGroup(int i)
    {
        if (i >= a.mTypeInfo.e.size())
        {
            return null;
        } else
        {
            return a.mTypeInfo.e.get(i);
        }
    }

    public int getGroupCount()
    {
        if (a.mTypeInfo != null && a.mTypeInfo.e != null)
        {
            return a.mTypeInfo.e.size();
        } else
        {
            return 0;
        }
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (i >= a.mTypeInfo.e.size())
        {
            return null;
        }
        awj awj1;
        if (view == null)
        {
            viewgroup = new TTieZhiTableHeaderView(a.getContext());
        } else
        {
            viewgroup = view;
        }
        awj1 = (awj)a.mTypeInfo.e.get(i);
        if (awj1 == null)
        {
            return null;
        }
        view = awj1.d;
        if (!yp.b()) goto _L2; else goto _L1
_L1:
        view = awj1.b;
_L4:
        ((TTieZhiTableHeaderView)viewgroup).handleTitle(view);
        return viewgroup;
_L2:
        if (yp.c())
        {
            view = awj1.c;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return false;
    }
}
