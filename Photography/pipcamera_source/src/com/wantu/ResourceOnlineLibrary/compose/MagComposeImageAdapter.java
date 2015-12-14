// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.app.Activity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.wantu.model.res.TResInfo;
import fq;
import java.util.ArrayList;
import uo;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose:
//            InstaMagType, TPhotoComposeInfo, InstaMagItemView

public class MagComposeImageAdapter extends BaseAdapter
{

    private static final String TAG = "GroupGridAdapter";
    private boolean bShowNew;
    private final Activity mContext;
    private android.widget.AbsListView.LayoutParams mImageViewLayoutParams;
    final fq mImageWorker;
    private int mItemHeight;
    ArrayList mItemList;
    private int mNumColumns;

    public MagComposeImageAdapter(Activity activity, ArrayList arraylist, fq fq1)
    {
        mItemHeight = 0;
        mNumColumns = 0;
        mContext = activity;
        mItemList = arraylist;
        mImageWorker = fq1;
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
        Log.v("GroupGridAdapter", (new StringBuilder()).append("GroupGridAdapter geview position:").append(i).toString());
        viewgroup = ((ViewGroup) (mItemList.get(i)));
        if (viewgroup instanceof TPhotoComposeInfo)
        {
            InstaMagType instamagtype = getInstaMagType((TPhotoComposeInfo)viewgroup);
            android.widget.AbsListView.LayoutParams layoutparams;
            if (view != null && (view instanceof InstaMagItemView))
            {
                if (((InstaMagItemView)view).getCurrentInstaMag() == instamagtype)
                {
                    uo uo1 = (uo)view.getTag();
                    viewgroup = view;
                    view = uo1;
                } else
                {
                    viewgroup = new InstaMagItemView(mContext, mImageWorker, instamagtype);
                    view = new uo(this);
                    uo.a(view, (InstaMagItemView)viewgroup);
                    viewgroup.setTag(view);
                }
            } else
            {
                viewgroup = new InstaMagItemView(mContext, mImageWorker, instamagtype);
                view = new uo(this);
                uo.a(view, (InstaMagItemView)viewgroup);
                viewgroup.setTag(view);
            }
            uo.a(view).setShowNew(bShowNew);
            uo.a(view).SetDataItem((TResInfo)mItemList.get(i));
            layoutparams = new android.widget.AbsListView.LayoutParams(-1, uo.a(view).getItemViewHeightByType(instamagtype));
            uo.a(view).setLayoutParams(layoutparams);
            uo.a(view).resetLayout();
            return viewgroup;
        } else
        {
            Log.e("GroupGridAdapter", String.format("getView no view for the specified positon %d ", new Object[] {
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

    public void setItemHeight(int i)
    {
        if (i == mItemHeight)
        {
            return;
        } else
        {
            mItemHeight = i;
            mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, mItemHeight);
            mImageWorker.a(i);
            notifyDataSetChanged();
            return;
        }
    }

    public void setItemList(ArrayList arraylist)
    {
        mItemList = arraylist;
        notifyDataSetChanged();
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
