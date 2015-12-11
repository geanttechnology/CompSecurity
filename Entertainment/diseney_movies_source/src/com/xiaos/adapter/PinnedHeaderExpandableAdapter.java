// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaos.adapter;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wjj.eneity.Canliu;
import com.wjj.eneity.RubSoftware;
import com.wjj.eneity.RuningApp;
import com.wjj.eneity.SoftApk;
import com.wjj.utils.CommonUtil;
import com.xiaos.view.PinnedHeaderExpandableListView;
import java.util.List;

public class PinnedHeaderExpandableAdapter extends BaseExpandableListAdapter
    implements com.xiaos.view.PinnedHeaderExpandableListView.HeaderAdapter
{
    class ChildViewHolder
    {

        CheckBox check_box;
        ImageView iv_icon;
        final PinnedHeaderExpandableAdapter this$0;
        TextView tv_appname;
        TextView tv_appsize;


        public ChildViewHolder(View view)
        {
            this$0 = PinnedHeaderExpandableAdapter.this;
            super();
            check_box = (CheckBox)view.findViewById(0x7f07025b);
            iv_icon = (ImageView)view.findViewById(0x7f070255);
            tv_appname = (TextView)view.findViewById(0x7f070259);
            tv_appsize = (TextView)view.findViewById(0x7f07025a);
            check_box.setOnCheckedChangeListener(new _cls1());
        }
    }

    public static interface GroupCheckListener
    {

        public abstract void ClickGroupCheckBox(int i);
    }

    class GroupViewHolder
    {

        CheckBox check_box;
        ImageView iv;
        TextView text;
        TextView textsize;
        final PinnedHeaderExpandableAdapter this$0;


        public GroupViewHolder(View view)
        {
            this$0 = PinnedHeaderExpandableAdapter.this;
            super();
            text = (TextView)view.findViewById(0x7f0701a1);
            textsize = (TextView)view.findViewById(0x7f0701a2);
            check_box = (CheckBox)view.findViewById(0x7f0701a3);
            iv = (ImageView)view.findViewById(0x7f0701a0);
            check_box.setOnCheckedChangeListener(new _cls1());
        }
    }


    private List apkdata;
    private List cachelist;
    private GroupCheckListener checkListener;
    private List cllist;
    private Context context;
    private String groupData[];
    private String groupSize[];
    private SparseIntArray groupStatusMap;
    private boolean headcheck0;
    private boolean headcheck1;
    private boolean headcheck2;
    private boolean headcheck3;
    private int index;
    private int index2;
    private int indexalltrue;
    private LayoutInflater inflater;
    private List list;
    private PinnedHeaderExpandableListView listView;

    public PinnedHeaderExpandableAdapter(List list1, List list2, List list3, List list4, String as[], Context context1, PinnedHeaderExpandableListView pinnedheaderexpandablelistview, 
            String as1[], GroupCheckListener groupchecklistener)
    {
        index = 10;
        index2 = 0;
        indexalltrue = 0;
        groupStatusMap = new SparseIntArray();
        groupData = as;
        list = list1;
        cachelist = list2;
        cllist = list4;
        apkdata = list3;
        checkListener = groupchecklistener;
        groupSize = as1;
        context = context1;
        listView = pinnedheaderexpandablelistview;
        inflater = LayoutInflater.from(context);
    }

    private View createChildrenView()
    {
        return inflater.inflate(0x7f030062, null);
    }

    private View createGroupView()
    {
        return inflater.inflate(0x7f03003b, null);
    }

    public void configureHeader(View view, int i, int j, int k)
    {
        String s = groupData[i];
        String s1 = groupSize[i];
        ((TextView)view.findViewById(0x7f0701a1)).setText(s);
        ((TextView)view.findViewById(0x7f0701a2)).setText(s1);
        if (i == 0)
        {
            ((CheckBox)view.findViewById(0x7f0701a3)).setChecked(headcheck0);
        } else
        {
            if (i == 1)
            {
                ((CheckBox)view.findViewById(0x7f0701a3)).setChecked(headcheck1);
                return;
            }
            if (i == 2)
            {
                ((CheckBox)view.findViewById(0x7f0701a3)).setChecked(headcheck2);
                return;
            }
            if (i == 3)
            {
                ((CheckBox)view.findViewById(0x7f0701a3)).setChecked(headcheck3);
                return;
            }
        }
    }

    public Object getChild(int i, int j)
    {
        if (i == 0)
        {
            return list.get(j);
        }
        if (i == 1)
        {
            return cachelist.get(j);
        }
        if (i == 2)
        {
            return cllist.get(j);
        }
        if (i == 3)
        {
            return apkdata.get(j);
        } else
        {
            return null;
        }
    }

    public long getChildId(int i, int j)
    {
        return 0L;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = createChildrenView();
            viewgroup = new ChildViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ChildViewHolder)view.getTag();
        }
        if (i == 0)
        {
            index = 0;
            RuningApp runingapp = (RuningApp)list.get(j);
            ((ChildViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(j));
            ((ChildViewHolder) (viewgroup)).tv_appname.setText(runingapp.runingsoftname);
            ((ChildViewHolder) (viewgroup)).iv_icon.setImageDrawable(runingapp.icon);
            ((ChildViewHolder) (viewgroup)).tv_appsize.setText(CommonUtil.formatSize(runingapp.memory));
            ((ChildViewHolder) (viewgroup)).check_box.setChecked(runingapp.ischecked);
        } else
        {
            if (i == 1)
            {
                index = 1;
                RubSoftware rubsoftware = (RubSoftware)cachelist.get(j);
                ((ChildViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(j));
                ((ChildViewHolder) (viewgroup)).tv_appname.setText((new StringBuilder(String.valueOf(rubsoftware.softname))).append("'s Cache").toString());
                ((ChildViewHolder) (viewgroup)).iv_icon.setImageDrawable(rubsoftware.icon);
                ((ChildViewHolder) (viewgroup)).tv_appsize.setText(CommonUtil.formatSize(rubsoftware.allcache));
                ((ChildViewHolder) (viewgroup)).check_box.setChecked(rubsoftware.ischecked);
                return view;
            }
            if (i == 2)
            {
                index = 2;
                Canliu canliu = (Canliu)cllist.get(j);
                ((ChildViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(j));
                ((ChildViewHolder) (viewgroup)).tv_appname.setText(canliu.runingsoftname);
                ((ChildViewHolder) (viewgroup)).iv_icon.setImageResource(0x7f02010c);
                ((ChildViewHolder) (viewgroup)).tv_appsize.setText(CommonUtil.formatSize(canliu.memory));
                ((ChildViewHolder) (viewgroup)).check_box.setChecked(canliu.ischecked);
                return view;
            }
            if (i == 3)
            {
                index = 3;
                SoftApk softapk = (SoftApk)apkdata.get(j);
                ((ChildViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(j));
                ((ChildViewHolder) (viewgroup)).tv_appname.setText(softapk.apkname);
                ((ChildViewHolder) (viewgroup)).iv_icon.setImageDrawable(softapk.icon);
                ((ChildViewHolder) (viewgroup)).tv_appsize.setText(CommonUtil.formatSize(softapk.apksize));
                ((ChildViewHolder) (viewgroup)).check_box.setChecked(softapk.ischecked);
                return view;
            }
        }
        return view;
    }

    public int getChildrenCount(int i)
    {
        if (i == 0)
        {
            return list.size();
        }
        if (i == 1)
        {
            return cachelist.size();
        }
        if (i == 2)
        {
            return cllist.size();
        }
        if (i == 3)
        {
            return apkdata.size();
        } else
        {
            return 0;
        }
    }

    public Object getGroup(int i)
    {
        return groupData[i];
    }

    public int getGroupClickStatus(int i)
    {
        if (groupStatusMap.keyAt(i) >= 0)
        {
            return groupStatusMap.get(i);
        } else
        {
            return 0;
        }
    }

    public int getGroupCount()
    {
        return groupData.length;
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = createGroupView();
            viewgroup = new GroupViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (GroupViewHolder)view.getTag();
        }
        if (flag)
        {
            ((GroupViewHolder) (viewgroup)).iv.setImageResource(0x7f02001c);
        } else
        {
            ((GroupViewHolder) (viewgroup)).iv.setImageResource(0x7f02001b);
        }
        ((GroupViewHolder) (viewgroup)).text.setText(groupData[i]);
        ((GroupViewHolder) (viewgroup)).textsize.setText(groupSize[i]);
        if (i != 0) goto _L2; else goto _L1
_L1:
        index2 = 0;
        ((GroupViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        if (list.size() <= 0) goto _L4; else goto _L3
_L3:
        i = 0;
_L13:
        if (i < list.size()) goto _L6; else goto _L5
_L5:
        if (index2 == list.size())
        {
            ((GroupViewHolder) (viewgroup)).check_box.setChecked(true);
        }
_L4:
        return view;
_L6:
        if (((RuningApp)list.get(i)).ischecked)
        {
            index2 = index2 + 1;
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == 1)
        {
            index2 = 0;
            ((GroupViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
            if (cachelist.size() <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = 0;
            do
            {
                if (i >= cachelist.size())
                {
                    if (index2 == cachelist.size())
                    {
                        ((GroupViewHolder) (viewgroup)).check_box.setChecked(true);
                        return view;
                    }
                    continue; /* Loop/switch isn't completed */
                }
                if (((RubSoftware)cachelist.get(i)).ischecked)
                {
                    index2 = index2 + 1;
                }
                i++;
            } while (true);
        }
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        index2 = 0;
        ((GroupViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        if (cllist.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L8:
label0:
        {
            if (i < cllist.size())
            {
                break label0;
            }
            if (index2 == cllist.size())
            {
                ((GroupViewHolder) (viewgroup)).check_box.setChecked(true);
                return view;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (((Canliu)cllist.get(i)).ischecked)
        {
            index2 = index2 + 1;
        }
        i++;
          goto _L8
        if (i != 3) goto _L4; else goto _L9
_L9:
        index2 = 0;
        ((GroupViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        if (apkdata.size() <= 0) goto _L4; else goto _L10
_L10:
        i = 0;
        do
        {
            if (i >= apkdata.size())
            {
                if (index2 == apkdata.size())
                {
                    ((GroupViewHolder) (viewgroup)).check_box.setChecked(true);
                    return view;
                }
                break;
            }
            if (((SoftApk)apkdata.get(i)).ischecked)
            {
                index2 = index2 + 1;
            }
            i++;
        } while (true);
        if (index2 != 0) goto _L4; else goto _L11
_L11:
        ((GroupViewHolder) (viewgroup)).check_box.setChecked(false);
        return view;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public int getHeaderState(int i, int j)
    {
        if (j == getChildrenCount(i) - 1)
        {
            return 2;
        }
        return j != -1 || listView.isGroupExpanded(i) ? 1 : 0;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public void setGroupClickStatus(int i, int j)
    {
        groupStatusMap.put(i, j);
    }












    // Unreferenced inner class com/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1

/* anonymous class */
    class ChildViewHolder._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ChildViewHolder this$1;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            int i = ((Integer)check_box.getTag()).intValue();
            if (index == 0)
            {
                ((RuningApp)list.get(i)).ischecked = flag;
            } else
            {
                if (index == 1)
                {
                    indexalltrue = 0;
                    ((RubSoftware)cachelist.get(i)).ischecked = flag;
                    return;
                }
                if (index == 2)
                {
                    ((Canliu)cllist.get(i)).ischecked = flag;
                    return;
                }
                if (index == 3)
                {
                    ((SoftApk)apkdata.get(i)).ischecked = flag;
                    return;
                }
            }
        }

            
            {
                this$1 = ChildViewHolder.this;
                super();
            }
    }


    // Unreferenced inner class com/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1

/* anonymous class */
    class GroupViewHolder._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final GroupViewHolder this$1;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            int i = ((Integer)check_box.getTag()).intValue();
            if (i != 0) goto _L2; else goto _L1
_L1:
            headcheck0 = flag;
            i = 0;
_L8:
            if (i < list.size()) goto _L4; else goto _L3
_L3:
            checkListener.ClickGroupCheckBox(1);
_L6:
            return;
_L4:
            ((RuningApp)list.get(i)).ischecked = flag;
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (i == 1)
            {
                headcheck1 = flag;
                i = 0;
                do
                {
                    if (i >= cachelist.size())
                    {
                        checkListener.ClickGroupCheckBox(2);
                        return;
                    }
                    ((RubSoftware)cachelist.get(i)).ischecked = flag;
                    i++;
                } while (true);
            }
            if (i == 2)
            {
                headcheck2 = flag;
                i = 0;
                do
                {
                    if (i >= cllist.size())
                    {
                        checkListener.ClickGroupCheckBox(3);
                        return;
                    }
                    ((Canliu)cllist.get(i)).ischecked = flag;
                    i++;
                } while (true);
            }
            if (i != 3) goto _L6; else goto _L5
_L5:
            headcheck3 = flag;
            int j = 0;
            do
            {
                if (j >= apkdata.size())
                {
                    checkListener.ClickGroupCheckBox(4);
                    return;
                }
                ((SoftApk)apkdata.get(j)).ischecked = flag;
                j++;
            } while (true);
            if (true) goto _L8; else goto _L7
_L7:
        }

            
            {
                this$1 = GroupViewHolder.this;
                super();
            }
    }

}
