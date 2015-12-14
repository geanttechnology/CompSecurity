// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class SideSelector extends View
{

    private static String TAG = com/instamag/activity/commonview/SideSelector.getCanonicalName();
    private ListView list;
    private Paint paint;
    private String sections[];
    private SectionIndexer selectionIndexer;

    public SideSelector(Context context)
    {
        super(context);
        selectionIndexer = null;
        init();
    }

    public SideSelector(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectionIndexer = null;
        init();
    }

    public SideSelector(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        selectionIndexer = null;
        init();
    }

    private int getPaddHeight()
    {
        return getHeight() / 2;
    }

    private int getPaddTop()
    {
        return getHeight() / 2 / 2;
    }

    private void init()
    {
        setBackgroundColor(0);
        paint = new Paint(33);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.rgb(44, 133, 156));
        paint.setTextSize(20F);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
    }

    protected void onDraw(Canvas canvas)
    {
        int i = getPaddHeight();
        float f = getPaddTop();
        float f1 = (float)i / (float)sections.length;
        float f2 = getMeasuredWidth() / 2;
        for (int j = 0; j < sections.length; j++)
        {
            canvas.drawText(String.valueOf(sections[j]), f2, f + f1 + (float)j * f1, paint);
        }

        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
label0:
        {
            super.onTouchEvent(motionevent);
            float f = (float)((int)motionevent.getY() - getPaddTop()) / (float)getPaddHeight();
            f = (float)sections.length * f;
            if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
            {
                if (selectionIndexer == null)
                {
                    selectionIndexer = (SectionIndexer)list.getAdapter();
                }
                if (f < 0.0F)
                {
                    f = 0.0F;
                }
                float f1 = f;
                if (sections != null)
                {
                    f1 = f;
                    if (f >= (float)sections.length)
                    {
                        f1 = sections.length - 1;
                    }
                }
                i = selectionIndexer.getPositionForSection((int)f1);
                Log.v(TAG, (new StringBuilder()).append(TAG).append("Touch on selectedIndex: ").append(String.valueOf(f1)).toString());
                if (i != -1)
                {
                    break label0;
                }
            }
            return true;
        }
        list.setSelection(i);
        return true;
    }

    public void refreshIndex()
    {
        selectionIndexer = (SectionIndexer)list.getAdapter();
        Object aobj[] = selectionIndexer.getSections();
        sections = new String[aobj.length];
        for (int i = 0; i < aobj.length; i++)
        {
            sections[i] = aobj[i].toString();
        }

        invalidate();
    }

    public void setListView(ListView listview)
    {
        list = listview;
        selectionIndexer = (SectionIndexer)listview.getAdapter();
        listview = ((ListView) (selectionIndexer.getSections()));
        sections = new String[listview.length];
        for (int i = 0; i < listview.length; i++)
        {
            sections[i] = listview[i].toString();
        }

    }

}
