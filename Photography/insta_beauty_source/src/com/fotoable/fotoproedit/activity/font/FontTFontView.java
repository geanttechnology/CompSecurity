// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import akk;
import akl;
import akm;
import alq;
import ama;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import yp;

public class FontTFontView extends ListView
{

    private static final String TAG = "FontTFontView";
    private ArrayList fontInfoArray;
    private ArrayList fontNameArray;
    private akm listener;
    private akl mAdapter;

    public FontTFontView(Context context)
    {
        super(context);
        fontInfoArray = new ArrayList();
        fontNameArray = new ArrayList();
        init();
    }

    public FontTFontView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fontInfoArray = new ArrayList();
        fontNameArray = new ArrayList();
        init();
    }

    private void init()
    {
        Object obj = new alq();
        Map map = ((alq) (obj)).a();
        List list = ((alq) (obj)).b();
        obj = map.keySet().iterator();
        ama ama1 = new ama();
        ama1.g = getResources().getText(0x7f0600d5).toString();
        ama1.f = "default";
        ama1.a = false;
        ama1.e = false;
        ama1.a(getResources().getText(0x7f0600d5).toString());
        ama1.a(Typeface.DEFAULT);
        fontInfoArray.add(ama1);
        if (yp.a())
        {
            for (int i = 0; i < list.size(); i++)
            {
                fontInfoArray.add(list.get(i));
                fontNameArray.add("chinese");
            }

        }
        String s;
        for (; ((Iterator) (obj)).hasNext(); fontNameArray.add(s))
        {
            s = (String)((Iterator) (obj)).next();
            fontInfoArray.add(map.get(s));
        }

        setDividerHeight(0);
        setBackgroundColor(getResources().getColor(0x7f0c00a6));
        mAdapter = new akl(this, null);
        setAdapter(mAdapter);
        mAdapter.a(fontNameArray, fontInfoArray);
        setOnItemClickListener(new akk(this));
    }

    public void refreshFontList()
    {
        mAdapter.a();
    }

    public void setCallback(akm akm)
    {
        listener = akm;
    }



}
