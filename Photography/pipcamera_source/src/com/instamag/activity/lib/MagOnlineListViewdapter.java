// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import fq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kf;
import ql;
import qq;

// Referenced classes of package com.instamag.activity.lib:
//            MagOnlineLibCellItemView

public class MagOnlineListViewdapter extends BaseAdapter
{

    private static String TAG = "MagOnlineListViewdapter";
    private final int CELL_COLUMNS = 3;
    private int TYPE_ITEM;
    private int TYPE_SECTION;
    private Context mContext;
    final fq mImageWorker;
    private ArrayList mItems;
    private ql magViewClickListener;

    public MagOnlineListViewdapter(Context context, ArrayList arraylist, fq fq, ql ql)
    {
        TYPE_ITEM = 0;
        TYPE_SECTION = 1;
        mContext = context;
        mImageWorker = fq;
        mItems = new ArrayList();
        magViewClickListener = ql;
        buildMagViewCellItemsByInfos(arraylist);
    }

    private void buildMagViewCellItemsByInfos(ArrayList arraylist)
    {
        mItems.clear();
        Collections.sort(arraylist, new Comparator() {

            final MagOnlineListViewdapter a;

            public int compare(Object obj, Object obj1)
            {
                boolean flag;
                boolean flag1;
                if (!(obj instanceof TPhotoComposeInfo) || !(obj1 instanceof TPhotoComposeInfo))
                {
                    break MISSING_BLOCK_LABEL_109;
                }
                obj = (TPhotoComposeInfo)obj;
                obj1 = (TPhotoComposeInfo)obj1;
                flag = a.getComposeManager().isExistedByResId(((TPhotoComposeInfo) (obj)).resId);
                flag1 = a.getComposeManager().isExistedByResId(((TPhotoComposeInfo) (obj1)).resId);
                if ((!flag || !flag1) && (flag || flag1)) goto _L2; else goto _L1
_L1:
                if (((TPhotoComposeInfo) (obj)).height <= ((TPhotoComposeInfo) (obj1)).height) goto _L4; else goto _L3
_L3:
                return -1;
_L4:
                return ((TPhotoComposeInfo) (obj)).height >= ((TPhotoComposeInfo) (obj1)).height ? 0 : 1;
_L2:
                if (!flag) goto _L3; else goto _L5
_L5:
                return 1;
                return 0;
            }

            
            {
                a = MagOnlineListViewdapter.this;
                super();
            }
        });
        int k = (int)Math.ceil((float)arraylist.size() / 3F);
        for (int i = 0; i < k; i++)
        {
            qq qq1 = new qq();
            qq1.a = TYPE_ITEM;
            qq1.d = new ArrayList();
            for (int j = 0; j < 3; j++)
            {
                int l = i * 3 + j;
                if (l < arraylist.size())
                {
                    qq1.d.add(arraylist.get(l));
                }
            }

            mItems.add(qq1);
        }

    }

    private TPhotoMagComposeManager getComposeManager()
    {
        return kf.c().e();
    }

    public int getCount()
    {
        if (mItems == null)
        {
            return 0;
        } else
        {
            return mItems.size();
        }
    }

    public Object getItem(int i)
    {
        return mItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return ((qq)mItems.get(i)).a;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getItemViewType(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        if (j == TYPE_SECTION)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f03004c, viewgroup, false);
            viewgroup = (TextView)view.findViewById(0x7f0c015b);
            viewgroup.setText(((qq)mItems.get(i)).c);
            view.setClickable(false);
            view.setFocusable(false);
            viewgroup.setTextColor(0xff000000);
        }
        if (j != TYPE_ITEM)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        viewgroup = new MagOnlineLibCellItemView(mContext);
        ((MagOnlineLibCellItemView)viewgroup).setMagItemViewClickListener(magViewClickListener);
        ((MagOnlineLibCellItemView)viewgroup).SetDataItem((qq)mItems.get(i), mImageWorker);
_L4:
        return viewgroup;
_L2:
        View view1 = view;
        if (view instanceof MagOnlineLibCellItemView)
        {
            view1 = view;
            if (j == TYPE_SECTION)
            {
                view1 = LayoutInflater.from(mContext).inflate(0x7f03004c, viewgroup, false);
                view = (TextView)view1.findViewById(0x7f0c015b);
                view.setText(((qq)mItems.get(i)).c);
                view1.setClickable(false);
                view1.setFocusable(false);
                view.setTextColor(0xff000000);
            }
        }
        if ((view1 instanceof LinearLayout) && j == TYPE_ITEM)
        {
            view = new MagOnlineLibCellItemView(mContext);
            ((MagOnlineLibCellItemView)view).setMagItemViewClickListener(magViewClickListener);
            ((MagOnlineLibCellItemView)view).SetDataItem((qq)mItems.get(i), mImageWorker);
        } else
        {
            view = view1;
        }
        if ((view instanceof MagOnlineLibCellItemView) && j == TYPE_ITEM)
        {
            ((MagOnlineLibCellItemView)view).SetDataItem((qq)mItems.get(i), mImageWorker);
        }
        viewgroup = view;
        if (!(view instanceof LinearLayout)) goto _L4; else goto _L3
_L3:
        viewgroup = view;
        if (j != TYPE_SECTION) goto _L4; else goto _L5
_L5:
        ((TextView)view.findViewById(0x7f0c015b)).setText(((qq)mItems.get(i)).c);
        return view;
        return view;
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public void setItemList(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" resItems count :").append(arraylist.size()).toString());
        }
        buildMagViewCellItemsByInfos(arraylist);
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" mItemSizeCount :").append(mItems.size()).toString());
        notifyDataSetChanged();
    }


}
