// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TabIndicator extends RelativeLayout
{

    private ImageView mIcon;
    private int mIconNewResId;
    private int mIconResId;
    private boolean mNew;
    private ImageView mNewIndicator;
    private TextView mTabText;

    public TabIndicator(Context context)
    {
        super(context);
    }

    public TabIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TabIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static ColorStateList createTextColorList(int i, int j)
    {
        int ai[] = {
            0x10100a7
        };
        int ai1[] = new int[0];
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a1
            }, ai, ai1
        }, new int[] {
            i, i, j
        });
    }

    public static TabIndicator newIconIndicator(LayoutInflater layoutinflater, int i, TabHost tabhost, int j, int k)
    {
        layoutinflater = (TabIndicator)layoutinflater.inflate(i, tabhost.getTabWidget(), false);
        if (j > 0)
        {
            layoutinflater.setTabIcon(j, k);
        }
        return layoutinflater;
    }

    public static TabIndicator newTextIndicator(LayoutInflater layoutinflater, int i, TabHost tabhost, int j, boolean flag)
    {
        layoutinflater = (TabIndicator)layoutinflater.inflate(i, tabhost.getTabWidget(), false);
        if (j > 0)
        {
            layoutinflater.setTabText(j, flag);
        }
        return layoutinflater;
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (mTabText == null);
    }

    public TextView getIndicatorText()
    {
        return mTabText;
    }

    public ImageView getNewIndicator()
    {
        return mNewIndicator;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mTabText = (TextView)findViewById(0x7f0a00e5);
        mNewIndicator = (ImageView)findViewById(0x7f0a0071);
        mIcon = (ImageView)findViewById(0x7f0a0049);
    }

    public void setColor(int i)
    {
        mIcon.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
        mIcon.invalidate();
    }

    public void setNew(boolean flag)
    {
        if (flag == mNew)
        {
            return;
        }
        if (mNewIndicator == null) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            mNewIndicator.setVisibility(0);
        } else
        {
            mNewIndicator.setVisibility(8);
        }
_L4:
        mNew = flag;
        return;
_L2:
        if (mIconNewResId > 0)
        {
            if (flag)
            {
                mIcon.setImageResource(mIconNewResId);
            } else
            {
                mIcon.setImageResource(mIconResId);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setTabIcon(int i, int j)
    {
        if (mIcon != null)
        {
            if (i > 0)
            {
                mIcon.setImageResource(i);
                mIcon.setVisibility(0);
            } else
            {
                mIcon.setVisibility(8);
            }
        }
        mIconResId = i;
        mIconNewResId = j;
    }

    public void setTabText(int i, boolean flag)
    {
label0:
        {
            if (mTabText != null)
            {
                String s1 = getResources().getString(i);
                String s = s1;
                if (flag)
                {
                    s = s1.toUpperCase();
                }
                if (i <= 0)
                {
                    break label0;
                }
                mTabText.setVisibility(0);
                mTabText.setText(s);
            }
            return;
        }
        mTabText.setVisibility(8);
    }

    public void unSetColor()
    {
        mIcon.setColorFilter(null);
        mIcon.invalidate();
    }
}
