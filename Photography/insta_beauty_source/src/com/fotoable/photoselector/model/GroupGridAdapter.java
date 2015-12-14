// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.model;

import aee;
import aeh;
import aei;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import asg;
import ash;
import asi;
import asj;
import aso;
import asp;
import asz;
import ata;
import com.fotoable.photoselector.uicomp.EncryptItemView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import zt;

public class GroupGridAdapter extends BaseAdapter
{

    private static final String TAG = "GroupGridAdapter";
    private PopupWindow mBtnGroup;
    private final Activity mContext;
    ArrayList mFileList;
    private android.widget.AbsListView.LayoutParams mImageViewLayoutParams;
    final zt mImageWorker;
    private int mItemHeight;
    private asj mMultiSelCallback;
    private int mNumColumns;
    private HashMap mapViewBitmaps;

    public GroupGridAdapter(Activity activity, ArrayList arraylist, zt zt1)
    {
        mItemHeight = 0;
        mNumColumns = 0;
        mapViewBitmaps = new HashMap();
        mBtnGroup = null;
        mContext = activity;
        mFileList = arraylist;
        mImageWorker = zt1;
        mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, -1);
    }

    private PopupWindow getBtnPopup()
    {
        if (mBtnGroup == null)
        {
            View view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(aei.view_bottombtngroup, null);
            view.findViewById(aeh.btnPostive).setOnClickListener(new ash(this));
            view.findViewById(aeh.btnNegative).setOnClickListener(new asi(this));
            mBtnGroup = new PopupWindow(view, -1, -2);
            mBtnGroup.setTouchable(true);
        }
        return mBtnGroup;
    }

    private final ArrayList getSelectedItems()
    {
        ArrayList arraylist = new ArrayList(5);
        for (int i = 0; i < mFileList.size(); i++)
        {
            if (((aso)mFileList.get(i)).h())
            {
                arraylist.add(mFileList.get(i));
            }
        }

        return arraylist;
    }

    private void resetCheckStatus()
    {
        setEnableCheckBoxUI(false);
        setItemIsSelectedStatus(false);
        displayBtnGroup(false);
    }

    private void setEnableCheckBoxUI(boolean flag)
    {
        displayBtnGroup(flag);
        ArrayList arraylist = mFileList;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((aso)arraylist.get(i)).b(flag);
        }

    }

    private void setItemCheckMask(boolean flag)
    {
        displayBtnGroup(flag);
        ArrayList arraylist = mFileList;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((aso)arraylist.get(i)).a(flag);
        }

    }

    private void setItemIsSelectedStatus(boolean flag)
    {
        ArrayList arraylist = mFileList;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((aso)arraylist.get(i)).c(flag);
        }

    }

    public void DisplayCheckbox(boolean flag, asj asj1)
    {
        setEnableCheckBoxUI(flag);
        mMultiSelCallback = asj1;
    }

    public void MultiSelectOK()
    {
        if (mMultiSelCallback != null)
        {
            mMultiSelCallback.a(getSelectedItems());
        }
        resetCheckStatus();
    }

    public void MulttSelectCancel()
    {
        if (mMultiSelCallback != null)
        {
            mMultiSelCallback.a();
        }
        resetCheckStatus();
    }

    protected void displayBtnGroup(boolean flag)
    {
        if (getBtnPopup().isShowing() == flag)
        {
            return;
        }
        if (flag)
        {
            getBtnPopup().showAtLocation(mContext.getWindow().getDecorView().getRootView(), 81, 0, 0);
            return;
        } else
        {
            getBtnPopup().dismiss();
            return;
        }
    }

    public int getCount()
    {
        if (mFileList == null)
        {
            return 0;
        } else
        {
            return mFileList.size();
        }
    }

    public Object getItem(int i)
    {
        return mFileList.get(i);
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
        viewgroup = ((ViewGroup) (mFileList.get(i)));
        if (viewgroup instanceof ata)
        {
            viewgroup = (asz)viewgroup;
            if (view != null && (view instanceof TextView))
            {
                view = (TextView)view;
            } else
            {
                view = new TextView(mContext);
                view.setLayoutParams(mImageViewLayoutParams);
            }
            if (view.getLayoutParams().height != mItemHeight)
            {
                view.setLayoutParams(mImageViewLayoutParams);
            }
            view.setText(viewgroup.a());
            return view;
        }
        if (viewgroup instanceof asp)
        {
            if (view != null && (view instanceof EncryptItemView))
            {
                view = (EncryptItemView)view;
                view.cancelImageLoad();
            } else
            {
                view = new EncryptItemView(mContext, mImageWorker);
                view.setLayoutParams(mImageViewLayoutParams);
            }
            mapViewBitmaps.put(view, view);
            if (view.getLayoutParams().height != mItemHeight)
            {
                view.setLayoutParams(mImageViewLayoutParams);
            }
            view.SetDataItem((aso)mFileList.get(i));
            return view;
        }
        if (viewgroup instanceof asg)
        {
            viewgroup = (asg)viewgroup;
            if (view != null && (view instanceof TextView))
            {
                view = (TextView)view;
            } else
            {
                view = new TextView(mContext);
                view.setLayoutParams(mImageViewLayoutParams);
            }
            if (view.getLayoutParams().height != mItemHeight)
            {
                view.setLayoutParams(mImageViewLayoutParams);
            }
            view.setTextColor(mContext.getResources().getColor(aee.skyblue_text_color));
            view.setText(DateFormat.getDateInstance(2, Locale.getDefault()).format(viewgroup.b()));
            return view;
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

    public void recycleImage()
    {
        for (Iterator iterator = mapViewBitmaps.keySet().iterator(); iterator.hasNext(); ((EncryptItemView)iterator.next()).recycleImage()) { }
    }

    public void setFileList(ArrayList arraylist)
    {
        mFileList = arraylist;
        setItemIsSelectedStatus(false);
        setEnableCheckBoxUI(false);
        notifyDataSetChanged();
    }

    public void setFileListNoMask(ArrayList arraylist)
    {
        mFileList = arraylist;
        setItemIsSelectedStatus(false);
        setEnableCheckBoxUI(false);
        setItemCheckMask(false);
        notifyDataSetChanged();
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

    public void setNumColumns(int i)
    {
        mNumColumns = i;
    }
}
