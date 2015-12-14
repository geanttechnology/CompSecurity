// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bol;
import bom;
import bon;
import boo;
import bop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileAdapter extends ArrayAdapter
{

    private View currentBgBtn;
    private String currentPathName;
    private String currentPathName1;
    private View currentShowFram;
    private View currentShowImage;
    SharedPreferences ferences;
    private boolean flag;
    private View lastShowFram;
    private Context mContext;
    private ArrayList mItems;
    private HashMap map;
    public boo onSelectedBtnItemCall;

    public FileAdapter(Context context, int i)
    {
        super(context, i);
        flag = true;
        map = new HashMap();
        mItems = new ArrayList();
        mContext = context;
    }

    public FileAdapter(Context context, int i, List list)
    {
        super(context, i, list);
        flag = true;
        map = new HashMap();
        mItems = new ArrayList();
        mContext = context;
        mItems = (ArrayList)list;
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

    public String getFileName(String s)
    {
        return s.substring(s.lastIndexOf("/") + 1, s.length());
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public String getItem(int i)
    {
        if (mItems == null)
        {
            return null;
        } else
        {
            return (String)mItems.get(i);
        }
    }

    public long getItemId(int i)
    {
        return super.getItemId(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        obj = getItem(i);
        String s = getFileName(((String) (obj)));
        bom bom1;
        if (view == null)
        {
            view = new bop(this);
            View view1 = LayoutInflater.from(mContext).inflate(0x7f030056, viewgroup, false);
            view.a = (TextView)view1.findViewById(0x7f0d01e9);
            view.b = (ImageView)view1.findViewById(0x7f0d01e8);
            view.c = (ImageView)view1.findViewById(0x7f0d01ea);
            view.d = (FrameLayout)view1.findViewById(0x7f0d01eb);
            view.f = (Button)view1.findViewById(0x7f0d01ec);
            view.e = (Button)view1.findViewById(0x7f0d01ed);
            view.g = (RelativeLayout)view1.findViewById(0x7f0d01e7);
            viewgroup = view;
            view = view1;
        } else
        {
            viewgroup = (bop)view.getTag();
        }
        bom1 = new bom(this, ((String) (obj)), ((bop) (viewgroup)).c);
        ((bop) (viewgroup)).c.setOnClickListener(bom1);
        view.setTag(viewgroup);
        if (currentPathName != null && currentPathName.equals(obj))
        {
            ((bop) (viewgroup)).c.setVisibility(0);
            currentBgBtn = ((bop) (viewgroup)).c;
            currentShowImage = ((bop) (viewgroup)).c;
        } else
        {
            ((bop) (viewgroup)).c.setVisibility(4);
        }
        ((bop) (viewgroup)).a.setText(s);
        ((bop) (viewgroup)).f.setOnClickListener(new bol(this, i));
        if (currentPathName1 == null || !currentPathName1.equals(obj)) goto _L2; else goto _L1
_L1:
        ((bop) (viewgroup)).d.setVisibility(0);
        lastShowFram = ((bop) (viewgroup)).d;
        currentShowFram = ((bop) (viewgroup)).d;
_L4:
        obj = new bon(this, ((String) (obj)), ((bop) (viewgroup)).d);
        ((bop) (viewgroup)).g.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        ((bop) (viewgroup)).e.setOnClickListener(bom1);
        return view;
_L2:
        ((bop) (viewgroup)).d.setVisibility(8);
        if (currentPathName != null && currentPathName.equals(obj) && flag)
        {
            ((bop) (viewgroup)).d.setVisibility(0);
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCurrentPathName(String s)
    {
        currentPathName = s;
    }

    public void setOnSelectedBtnItemCall(boo boo)
    {
        onSelectedBtnItemCall = boo;
    }

    public void updateItems(ArrayList arraylist)
    {
        mItems = arraylist;
        notifyDataSetChanged();
    }



/*
    public static View access$002(FileAdapter fileadapter, View view)
    {
        fileadapter.currentBgBtn = view;
        return view;
    }

*/



/*
    public static String access$102(FileAdapter fileadapter, String s)
    {
        fileadapter.currentPathName = s;
        return s;
    }

*/




/*
    public static View access$302(FileAdapter fileadapter, View view)
    {
        fileadapter.currentShowImage = view;
        return view;
    }

*/



/*
    public static View access$402(FileAdapter fileadapter, View view)
    {
        fileadapter.lastShowFram = view;
        return view;
    }

*/



/*
    public static View access$502(FileAdapter fileadapter, View view)
    {
        fileadapter.currentShowFram = view;
        return view;
    }

*/


/*
    public static String access$602(FileAdapter fileadapter, String s)
    {
        fileadapter.currentPathName1 = s;
        return s;
    }

*/
}
