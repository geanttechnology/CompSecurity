// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose.manage;

import android.app.Activity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import bhb;
import bho;
import bhp;
import bhq;
import com.wantu.ResourceOnlineLibrary.compose.FootItemView;
import com.wantu.ResourceOnlineLibrary.compose.FootViewItem;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import zu;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose.manage:
//            InstaMagManageItemView

public class MagManageAdapter extends BaseAdapter
{

    private static final String TAG = "MagManageAdapter";
    private boolean bShowNew;
    private bhb footViewLisener;
    private final Activity mContext;
    private android.widget.AbsListView.LayoutParams mImageViewLayoutParams;
    final zu mImageWorker;
    private int mItemHeight;
    ArrayList mItemList;
    private bho mItemViewCallback;
    private int mNumColumns;

    public MagManageAdapter(Activity activity, ArrayList arraylist, zu zu)
    {
        mItemHeight = 0;
        mNumColumns = 0;
        mContext = activity;
        mItemList = arraylist;
        mImageWorker = zu;
        mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, -1);
    }

    private int getDisplayWidth(Activity activity)
    {
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }

    public int getCount()
    {
        if (mItemList == null)
        {
            return 0;
        } else
        {
            return mItemList.size();
        }
    }

    public InstaMagType getInstaMagType(TPhotoComposeInfo tphotocomposeinfo)
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (tphotocomposeinfo.width == 320F)
            {
                instamagtype = instamagtype1;
                if (tphotocomposeinfo.height == 214F)
                {
                    return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public Object getItem(int i)
    {
        return mItemList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public int getNumColumns()
    {
        return mNumColumns;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Log.v("MagManageAdapter", (new StringBuilder()).append("MagManageAdapter geview position:").append(i).toString());
        viewgroup = ((ViewGroup) (mItemList.get(i)));
        if (viewgroup instanceof TPhotoComposeInfo)
        {
            Object obj = getInstaMagType((TPhotoComposeInfo)viewgroup);
            view = new InstaMagManageItemView(mContext, mImageWorker, ((InstaMagType) (obj)));
            viewgroup = new bhq(this);
            bhq.a(viewgroup, (InstaMagManageItemView)view);
            view.setTag(viewgroup);
            bhq.a(viewgroup).setShowNew(bShowNew);
            bhq.a(viewgroup).SetDataItem((TResInfo)mItemList.get(i));
            obj = new android.widget.AbsListView.LayoutParams(-1, bhq.a(viewgroup).getItemViewHeightByType(((InstaMagType) (obj))));
            bhq.a(viewgroup).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            bhq.a(viewgroup).resetLayout();
            if (bhq.a(viewgroup).getDeleteButton() != null)
            {
                bhq.a(viewgroup).getDeleteButton().setOnClickListener(new bhp(this));
            }
            return view;
        }
        if (viewgroup instanceof FootViewItem)
        {
            if (view != null && (view instanceof FootItemView))
            {
                view = (FootItemView)view;
            } else
            {
                view = new FootItemView(mContext);
            }
            view.setFootViewItemLisener(footViewLisener);
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(getDisplayWidth(mContext), -2));
            return view;
        } else
        {
            Log.e("MagManageAdapter", String.format("getView no view for the specified positon %d ", new Object[] {
                Integer.valueOf(i)
            }));
            return null;
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public void removeItem(TResInfo tresinfo)
    {
        int i = 0;
_L3:
        if (i >= mItemList.size())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((TResInfo)mItemList.get(i)).resId != tresinfo.resId) goto _L2; else goto _L1
_L1:
        tresinfo = (TResInfo)mItemList.get(i);
_L4:
        mItemList.remove(tresinfo);
        notifyDataSetChanged();
        return;
_L2:
        i++;
          goto _L3
        tresinfo = null;
          goto _L4
    }

    public void setFootViewItemLisener(bhb bhb)
    {
        footViewLisener = bhb;
    }

    public void setItemList(ArrayList arraylist)
    {
        mItemList = arraylist;
        notifyDataSetChanged();
    }

    public void setManageItemViewDelegate(bho bho)
    {
        mItemViewCallback = bho;
    }

    public void setNumColumns(int i)
    {
        mNumColumns = i;
    }

    public void setShowNewAlert(boolean flag)
    {
        bShowNew = flag;
    }

}
