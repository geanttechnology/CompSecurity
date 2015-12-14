// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.SectionIndexer;
import com.instamag.activity.library.view.LibraryExpandableChildView;
import com.instamag.activity.library.view.LibraryExpandableGroupView;
import com.instamag.activity.library.view.LibraryExpandableListView;
import java.util.ArrayList;
import java.util.List;

public class bdo extends BaseExpandableListAdapter
    implements SectionIndexer
{

    bdk a;
    final LibraryExpandableListView b;

    public bdo(LibraryExpandableListView libraryexpandablelistview)
    {
        b = libraryexpandablelistview;
        super();
        a = null;
    }

    public void a(bdk bdk)
    {
        a = bdk;
    }

    public Object getChild(int i, int j)
    {
label0:
        {
            bbu bbu1 = new bbu();
            bbu1.a = new ArrayList();
            if (i < b.mSections.size())
            {
                List list = LibraryExpandableListView.access$000(b, (String)b.mSections.get(i), b.mFilterInfos);
                i = j * 3;
                if (i >= list.size())
                {
                    break label0;
                }
                bbu1.a.add(list.get(i));
                if (i + 1 < list.size())
                {
                    bbu1.a.add(list.get(i + 1));
                    if (i + 2 < list.size())
                    {
                        bbu1.a.add(list.get(i + 2));
                    }
                }
            }
            return bbu1;
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
            if (i >= b.mSections.size())
            {
                return null;
            }
            if (view == null)
            {
                view = new LibraryExpandableChildView(b.getContext(), b.imageWorker);
            }
            viewgroup = new bbu();
            viewgroup.a = new ArrayList();
            if (i < b.mSections.size())
            {
                List list = LibraryExpandableListView.access$000(b, (String)b.mSections.get(i), b.mFilterInfos);
                i = j * 3;
                if (i >= list.size())
                {
                    break label0;
                }
                ((bbu) (viewgroup)).a.add(list.get(i));
                if (i + 1 < list.size())
                {
                    ((bbu) (viewgroup)).a.add(list.get(i + 1));
                    if (i + 2 < list.size())
                    {
                        ((bbu) (viewgroup)).a.add(list.get(i + 2));
                    }
                }
            }
            ((LibraryExpandableChildView)view).setItemClickLisener(LibraryExpandableListView.access$100(b));
            ((LibraryExpandableChildView)view).setEditMode(b.mIsEdit);
            ((LibraryExpandableChildView)view).SetDataItem(viewgroup);
            return view;
        }
        return null;
    }

    public int getChildrenCount(int i)
    {
        if (i < b.mSections.size())
        {
            List list = LibraryExpandableListView.access$000(b, (String)b.mSections.get(i), b.mFilterInfos);
            int j = list.size() / 3;
            i = j;
            if (j * 3 < list.size())
            {
                i = j + 1;
            }
            return i;
        } else
        {
            return 0;
        }
    }

    public Object getGroup(int i)
    {
        if (i < b.mSections.size())
        {
            return b.mSections.get(i);
        } else
        {
            return null;
        }
    }

    public int getGroupCount()
    {
        return b.mSections.size();
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (i >= b.mSections.size())
        {
            return null;
        }
        StringBuilder stringbuilder;
        if (view == null)
        {
            viewgroup = new LibraryExpandableGroupView(b.getContext());
        } else
        {
            viewgroup = view;
        }
        ((LibraryExpandableGroupView)viewgroup).setListener(a);
        ((LibraryExpandableGroupView)viewgroup).handleDataWithState(flag);
        view = (String)b.mSections.get(i);
        if (!view.equalsIgnoreCase("R")) goto _L2; else goto _L1
_L1:
        if (yp.b())
        {
            view = "\u6700\u8FD1\u4F7F\u7528";
        } else
        if (yp.c())
        {
            view = "\u6700\u8FD1\u4F7F\u7528";
        } else
        {
            view = "Recent";
        }
_L4:
        ((LibraryExpandableGroupView)viewgroup).handleDataWithTitleAndMode(view, b.mIsEdit);
        return viewgroup;
_L2:
        if (view.equalsIgnoreCase("S"))
        {
            if (yp.b())
            {
                view = "\u62FC\u63A5";
            } else
            if (yp.c())
            {
                view = "\u62FC\u63A5";
            } else
            {
                view = "Strips";
            }
            continue; /* Loop/switch isn't completed */
        }
        stringbuilder = (new StringBuilder()).append(view);
        if (!yp.b())
        {
            break; /* Loop/switch isn't completed */
        }
        view = "\u5F20";
_L5:
        view = stringbuilder.append(view).toString();
        if (true) goto _L4; else goto _L3
_L3:
        if (yp.c())
        {
            view = "\u5F35";
        } else
        if (Integer.valueOf(view).intValue() > 1)
        {
            view = " Frames";
        } else
        {
            view = " Frame";
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int getPositionForSection(int i)
    {
        for (; i >= 0; i--)
        {
            for (int j = 0; j < getGroupCount(); j++)
            {
                if (apm.a(String.valueOf(((String)getGroup(j)).charAt(0)), String.valueOf(b.mSections.get(i))))
                {
                    return j;
                }
            }

        }

        return 0;
    }

    public int getSectionForPosition(int i)
    {
        return 0;
    }

    public Object[] getSections()
    {
        String as[] = new String[b.mSections.size()];
        for (int i = 0; i < b.mSections.size(); i++)
        {
            as[i] = (String)b.mSections.get(i);
        }

        return as;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }
}
