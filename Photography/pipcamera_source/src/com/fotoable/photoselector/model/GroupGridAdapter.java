// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.model;

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
import com.fotoable.photoselector.uicomp.EncryptItemView;
import fq;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import nh;
import ni;
import nl;
import nm;
import nt;
import nu;

public class GroupGridAdapter extends BaseAdapter
{

    private static final String TAG = "GroupGridAdapter";
    private PopupWindow mBtnGroup;
    private final Activity mContext;
    ArrayList mFileList;
    private android.widget.AbsListView.LayoutParams mImageViewLayoutParams;
    final fq mImageWorker;
    private int mItemHeight;
    private ni mMultiSelCallback;
    private int mNumColumns;
    private HashMap mapViewBitmaps;

    public GroupGridAdapter(Activity activity, ArrayList arraylist, fq fq1)
    {
        mItemHeight = 0;
        mNumColumns = 0;
        mapViewBitmaps = new HashMap();
        mBtnGroup = null;
        mContext = activity;
        mFileList = arraylist;
        mImageWorker = fq1;
        mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, -1);
    }

    private PopupWindow getBtnPopup()
    {
        if (mBtnGroup == null)
        {
            View view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(com.fotoable.fotophotoselector.R.layout.view_bottombtngroup, null);
            view.findViewById(com.fotoable.fotophotoselector.R.id.btnPostive).setOnClickListener(new android.view.View.OnClickListener() {

                final GroupGridAdapter a;

                public void onClick(View view1)
                {
                    a.MultiSelectOK();
                }

            
            {
                a = GroupGridAdapter.this;
                super();
            }
            });
            view.findViewById(com.fotoable.fotophotoselector.R.id.btnNegative).setOnClickListener(new android.view.View.OnClickListener() {

                final GroupGridAdapter a;

                public void onClick(View view1)
                {
                    a.MulttSelectCancel();
                }

            
            {
                a = GroupGridAdapter.this;
                super();
            }
            });
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
            if (((nl)mFileList.get(i)).h())
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
            ((nl)arraylist.get(i)).b(flag);
        }

    }

    private void setItemCheckMask(boolean flag)
    {
        displayBtnGroup(flag);
        ArrayList arraylist = mFileList;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((nl)arraylist.get(i)).a(flag);
        }

    }

    private void setItemIsSelectedStatus(boolean flag)
    {
        ArrayList arraylist = mFileList;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((nl)arraylist.get(i)).c(flag);
        }

    }

    public void DisplayCheckbox(boolean flag, ni ni1)
    {
        setEnableCheckBoxUI(flag);
        mMultiSelCallback = ni1;
    }

    protected void MultiSelectOK()
    {
        if (mMultiSelCallback != null)
        {
            mMultiSelCallback.a(getSelectedItems());
        }
        resetCheckStatus();
    }

    protected void MulttSelectCancel()
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
        if (viewgroup instanceof nu)
        {
            viewgroup = (nt)viewgroup;
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
        if (viewgroup instanceof nm)
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
            view.SetDataItem((nl)mFileList.get(i));
            return view;
        }
        if (viewgroup instanceof nh)
        {
            viewgroup = (nh)viewgroup;
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
            view.setTextColor(mContext.getResources().getColor(com.fotoable.fotophotoselector.R.color.skyblue_text_color));
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
