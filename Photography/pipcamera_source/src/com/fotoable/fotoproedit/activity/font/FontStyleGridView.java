// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import hb;
import hi;
import hs;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextLabelInfo

public class FontStyleGridView extends FrameLayout
{

    private String TAG;
    private String curText;
    private FontStyleGridViewAdapter fontShadowAdapter;
    private ArrayList fontStyleList;
    private Context mContext;
    private hb mCurFontInfo;
    private hi mListener;
    private GridView shadowGridView;

    public FontStyleGridView(Context context)
    {
        super(context);
        TAG = "FontStyleGridView";
        curText = "";
        mContext = context;
        init();
    }

    public FontStyleGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "FontStyleGridView";
        curText = "";
        mContext = context;
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300bd, this, true);
        shadowGridView = (GridView)findViewById(0x7f0c02db);
        fontStyleList = hs.a().b();
        fontShadowAdapter = new FontStyleGridViewAdapter(mContext);
        fontShadowAdapter.setFontData(fontStyleList);
        shadowGridView.setAdapter(fontShadowAdapter);
        shadowGridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FontStyleGridView a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (a.mListener != null)
                {
                    adapterview = (FontTextLabelInfo)a.fontStyleList.get(i);
                    a.mListener.a(adapterview);
                    a.fontShadowAdapter.setSeclection(i);
                }
            }

            
            {
                a = FontStyleGridView.this;
                super();
            }
        });
    }

    public void setFontAndTxt(FontTextLabelInfo fonttextlabelinfo, hb hb)
    {
        if (curText.endsWith(fonttextlabelinfo.m) && mCurFontInfo != null && mCurFontInfo.equals(hb))
        {
            return;
        }
        curText = fonttextlabelinfo.m;
        mCurFontInfo = hb;
        for (int i = 0; i < fontStyleList.size(); i++)
        {
            ((FontTextLabelInfo)fontStyleList.get(i)).m = fonttextlabelinfo.m;
        }

        fontShadowAdapter.setFontData(fontStyleList);
    }

    public void setFontStyleListener(hi hi)
    {
        mListener = hi;
    }






    private class FontStyleGridViewAdapter extends BaseAdapter
    {

        private int clickTemp;
        private Context mContext;
        private boolean needReDraw;
        private ArrayList styleList;
        final FontStyleGridView this$0;

        public View GetViewByPosition(int i)
        {
            int j = shadowGridView.getFirstVisiblePosition();
            int k = shadowGridView.getLastVisiblePosition();
            if (i < j || i > k)
            {
                return null;
            } else
            {
                return shadowGridView.getChildAt(i - j);
            }
        }

        public int getCount()
        {
            if (styleList != null)
            {
                return styleList.size();
            } else
            {
                return 0;
            }
        }

        public Object getItem(int i)
        {
            if (styleList != null && i < styleList.size())
            {
                return styleList.get(i);
            } else
            {
                return null;
            }
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            FontTextLabelInfo fonttextlabelinfo = (FontTextLabelInfo)styleList.get(i);
            hh hh1;
            Object obj;
            boolean flag;
            if (view == null)
            {
                viewgroup = LayoutInflater.from(mContext).inflate(0x7f0300c0, null);
                hh1 = new hh(this);
                hh1.a = (ImageView)viewgroup.findViewById(0x7f0c0269);
                hh1.b = (FrameLayout)viewgroup.findViewById(0x7f0c005a);
                viewgroup.setTag(hh1);
            } else
            {
                hh1 = (hh)view.getTag();
                viewgroup = view;
            }
            obj = fonttextlabelinfo.m;
            view = ((View) (obj));
            if (((String) (obj)).length() == 0)
            {
                view = mContext.getResources().getString(0x7f060267);
            }
            obj = view;
            if (view.length() > 4)
            {
                obj = view.substring(0, 4);
            }
            fonttextlabelinfo.m = ((String) (obj));
            hj.a().a(needReDraw, fonttextlabelinfo, mCurFontInfo, i, new hl() {

                final FontStyleGridViewAdapter a;

                public void a(Bitmap bitmap, int j)
                {
                    Object obj1 = a.GetViewByPosition(j);
                    if (obj1 != null)
                    {
                        obj1 = (hh)((View) (obj1)).getTag();
                        if (obj1 != null && ((hh) (obj1)).a != null)
                        {
                            ((hh) (obj1)).a.setImageBitmap(bitmap);
                            ((hh) (obj1)).a.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        }
                    }
                }

                
                {
                    a = FontStyleGridViewAdapter.this;
                    super();
                }
            });
            view = hh1.b;
            if (clickTemp == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            return viewgroup;
        }

        public void setFontData(ArrayList arraylist)
        {
            styleList.clear();
            styleList.addAll(arraylist);
            needReDraw = true;
            notifyDataSetChanged();
        }

        public void setSeclection(int i)
        {
            clickTemp = i;
            notifyDataSetChanged();
        }

        public FontStyleGridViewAdapter(Context context)
        {
            this$0 = FontStyleGridView.this;
            super();
            clickTemp = -1;
            needReDraw = true;
            mContext = context;
            styleList = new ArrayList();
        }
    }

}
