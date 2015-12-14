// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import ew;
import hb;
import hp;
import hq;
import ip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FontTFontView extends ListView
{

    private static final String TAG = "TProEditTextFontListView";
    private ArrayList fontInfoArray;
    private ArrayList fontNameArray;
    private hq listener;
    private hp mAdapter;

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
        Object obj = new ip();
        Map map = ((ip) (obj)).a();
        List list = ((ip) (obj)).b();
        obj = map.keySet().iterator();
        hb hb1 = new hb();
        hb1.g = getResources().getText(0x7f0600c7).toString();
        hb1.f = "default";
        hb1.a = false;
        hb1.e = false;
        hb1.a(getResources().getText(0x7f0600c7).toString());
        hb1.a(Typeface.DEFAULT);
        fontInfoArray.add(hb1);
        if (ew.a())
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
        setBackgroundColor(-1);
        mAdapter = new hp(this);
        setAdapter(mAdapter);
        mAdapter.a(fontNameArray, fontInfoArray);
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FontTFontView a;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                a.mAdapter.a(j);
                adapterview = (hb)a.fontInfoArray.get(j);
                if (a.listener != null)
                {
                    a.listener.a(adapterview);
                }
            }

            
            {
                a = FontTFontView.this;
                super();
            }
        });
    }

    public void refreshFontList()
    {
        mAdapter.a();
    }

    public void setCallback(hq hq)
    {
        listener = hq;
    }



}
