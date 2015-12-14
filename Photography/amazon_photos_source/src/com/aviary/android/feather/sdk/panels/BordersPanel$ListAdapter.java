// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.graphics.PluginDividerDrawable;
import com.aviary.android.feather.sdk.widget.EffectThumbLayout;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;
import it.sephiroth.android.library.widget.HListView;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

class mDividerResId extends CursorAdapter
{

    static final int TYPE_DIVIDER = 2;
    static final int TYPE_EXTERNAL = 1;
    static final int TYPE_INVALID = -1;
    static final int TYPE_LEFT_DIVIDER = 3;
    static final int TYPE_LEFT_GETMORE = 5;
    static final int TYPE_NORMAL = 0;
    static final int TYPE_RIGHT_DIVIDER = 4;
    static final int TYPE_RIGHT_GETMORE = 6;
    int mCount;
    int mDefaultResId;
    int mDisplayNameColumnIndex;
    int mDividerResId;
    int mExternalResId;
    int mIdColumnIndex;
    int mIdentifierColumnIndex;
    LayoutInflater mInflater;
    int mIsFreeColumnIndex;
    int mMoreResId;
    int mPackageNameColumnIndex;
    int mPathColumnIndex;
    int mTypeColumnIndex;
    final BordersPanel this$0;

    private void initColumns(Cursor cursor)
    {
        if (cursor != null)
        {
            mIdColumnIndex = cursor.getColumnIndex("_id");
            mPackageNameColumnIndex = cursor.getColumnIndex("packagename");
            mIdentifierColumnIndex = cursor.getColumnIndex("identifier");
            mTypeColumnIndex = cursor.getColumnIndex("type");
            mDisplayNameColumnIndex = cursor.getColumnIndex("displayName");
            mPathColumnIndex = cursor.getColumnIndex("path");
            mIsFreeColumnIndex = cursor.getColumnIndex("isFree");
        }
    }

    private View newView(Context context, Cursor cursor, ViewGroup viewgroup, int i)
    {
        int k = getItemViewType(i);
        k;
        JVM INSTR tableswitch 1 6: default 48
    //                   1 418
    //                   2 397
    //                   3 444
    //                   4 464
    //                   5 191
    //                   6 260;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L5:
        break MISSING_BLOCK_LABEL_464;
_L1:
        context = mInflater.inflate(mDefaultResId, viewgroup, false);
        i = BordersPanel.access$300(BordersPanel.this);
_L8:
        context.setLayoutParams(new android.view.nit>(i, -1));
        int j;
        if (k == 1)
        {
            cursor = new ternal();
        } else
        {
            cursor = new init>();
        }
        cursor.ype = k;
        cursor.mage = (ImageView)context.findViewById(com.aviary.android.feather.sdk.older.image);
        cursor.ext = (TextView)context.findViewById(com.aviary.android.feather.sdk.older.text);
        if (k != 2 && ((ext) (cursor)).mage != null)
        {
            viewgroup = ((mage) (cursor)).mage.getLayoutParams();
            viewgroup.ight = mThumbSize;
            viewgroup.dth = mThumbSize;
            ((mage) (cursor)).mage.setLayoutParams(viewgroup);
        }
        context.setTag(cursor);
        return context;
_L6:
        context = mInflater.inflate(mMoreResId, viewgroup, false);
        cursor = (ImageView)context.findViewById(com.aviary.android.feather.sdk.dapter.mMoreResId);
        if (BordersPanel.access$200(BordersPanel.this) == com.aviary.android.feather.cds.)
        {
            i = com.aviary.android.feather.sdk.item_getmore;
        } else
        {
            i = com.aviary.android.feather.sdk.tem_getmore;
        }
        cursor.setImageResource(i);
        i = BordersPanel.access$300(BordersPanel.this);
          goto _L8
_L7:
        cursor = mInflater.inflate(mMoreResId, viewgroup, false);
        context = (ImageView)cursor.findViewById(com.aviary.android.feather.sdk.dapter.mMoreResId);
        if (BordersPanel.access$200(BordersPanel.this) == com.aviary.android.feather.cds.)
        {
            i = com.aviary.android.feather.sdk.item_getmore;
        } else
        {
            i = com.aviary.android.feather.sdk.tem_getmore;
        }
        context.setImageResource(i);
        j = BordersPanel.access$300(BordersPanel.this);
        i = j;
        context = cursor;
        if (viewgroup.getChildCount() > 0)
        {
            i = j;
            context = cursor;
            if (mHList.getFirstVisiblePosition() == 0)
            {
                i = j;
                context = cursor;
                if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                {
                    cursor.setVisibility(4);
                    i = 1;
                    context = cursor;
                }
            }
        }
          goto _L8
_L3:
        context = mInflater.inflate(mDividerResId, viewgroup, false);
        i = -2;
          goto _L8
_L2:
        context = mInflater.inflate(mExternalResId, viewgroup, false);
        i = BordersPanel.access$300(BordersPanel.this);
          goto _L8
_L4:
        context = mInflater.inflate(com.aviary.android.feather.sdk.ider_right, viewgroup, false);
        i = -2;
          goto _L8
        cursor = mInflater.inflate(com.aviary.android.feather.sdk.ider_left, viewgroup, false);
        j = -2;
        i = j;
        context = cursor;
        if (viewgroup.getChildCount() > 0)
        {
            i = j;
            context = cursor;
            if (mHList.getFirstVisiblePosition() == 0)
            {
                i = j;
                context = cursor;
                if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                {
                    cursor.setVisibility(4);
                    i = 1;
                    context = cursor;
                }
            }
        }
          goto _L8
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
    }

    void bindView(View view, Context context, Cursor cursor, int i)
    {
        sition sition;
        long l;
        boolean flag;
        sition = (sition)view.getTag();
        long l1 = -1L;
        l = l1;
        if (!cursor.isAfterLast())
        {
            l = l1;
            if (!cursor.isBeforeFirst())
            {
                l = cursor.getLong(mIdColumnIndex);
            }
        }
        flag = ((Boolean)mHList.getCheckedItemPositions().get(i, Boolean.valueOf(false))).booleanValue();
        if (sition.ype != 0) goto _L2; else goto _L1
_L1:
        context = cursor.getString(mDisplayNameColumnIndex);
        String s = cursor.getString(mIdentifierColumnIndex);
        cursor = cursor.getString(mPathColumnIndex);
        sition.ext.setText(context);
        sition.dentifier = s;
        if (sition.d != l)
        {
            sition.mage.setImageBitmap(null);
            if (BordersPanel.access$200(BordersPanel.this) == com.aviary.android.feather.cds.)
            {
                context = (new StringBuilder()).append("aviary_effect://").append(cursor).append("/").append(s).append(".json").toString();
            } else
            {
                context = cursor;
                if (!cursor.startsWith("file://"))
                {
                    context = (new StringBuilder()).append("file://").append(cursor).toString();
                }
                context = (new StringBuilder()).append(context).append("/").append(s).append("-small.png").toString();
            }
            mPicassoLibrary.load(Uri.parse(context)).fade(200L).error(com.aviary.android.feather.sdk.r).withCache(BordersPanel.access$400(BordersPanel.this)).into(sition.mage);
        }
        ((EffectThumbLayout)view).setIsOpened(flag);
_L4:
        sition.d = l;
        return;
_L2:
        if (sition.ype == 1)
        {
            view = (ternal)sition;
            context = cursor.getString(mIdentifierColumnIndex);
            String s1 = cursor.getString(mDisplayNameColumnIndex);
            String s2 = cursor.getString(mPathColumnIndex);
            i = cursor.getInt(mIsFreeColumnIndex);
            sition.ext.setText(s1);
            sition.dentifier = context;
            view.free = i;
            if (sition.d != l)
            {
                mPicassoLibrary.load(s2).transform((new com.aviary.android.feather.sdk.utils.<init>()).withResources(getContext().getBaseContext().getResources()).withPackType(BordersPanel.access$200(BordersPanel.this)).withPath(s2).build()).error(com.aviary.android.feather.sdk.r).into(sition.mage);
            }
        } else
        if (sition.ype == 2)
        {
            view = sition.mage.getDrawable();
            context = cursor.getString(mDisplayNameColumnIndex);
            if (view instanceof PluginDividerDrawable)
            {
                ((PluginDividerDrawable)view).setTitle(context);
            } else
            {
                view = new PluginDividerDrawable(getContext().getBaseContext(), com.aviary.android.feather.sdk.ividerTextStyle, context);
                sition.mage.setImageDrawable(view);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getItemViewType(int i)
    {
        Cursor cursor = (Cursor)getItem(i);
        if (cursor != null)
        {
            return cursor.getInt(mTypeColumnIndex);
        } else
        {
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!mDataValid)
        {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (view == null)
        {
            view = newView(mContext, mCursor, viewgroup, i);
        }
        bindView(view, mContext, mCursor, i);
        return view;
    }

    public int getViewTypeCount()
    {
        return 7;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return null;
    }

    protected void onContentChanged()
    {
        super.onContentChanged();
    }

    public Cursor swapCursor(Cursor cursor)
    {
        initColumns(cursor);
        return super.swapCursor(cursor);
    }

    public ternal(Context context, int i, int j, int k, int l, Cursor cursor)
    {
        this$0 = BordersPanel.this;
        super(context, cursor, 0);
        mCount = -1;
        initColumns(cursor);
        mInflater = LayoutInflater.from(context);
        mDefaultResId = i;
        mMoreResId = j;
        mExternalResId = k;
        mDividerResId = l;
    }
}
