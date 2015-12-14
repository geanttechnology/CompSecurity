// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import my.googlemusic.play.adapters.presentation.PresentationAdapter;

// Referenced classes of package my.googlemusic.play.activities:
//            ManagerActivity

public class PresentationActivity extends ActionBarActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.view.View.OnClickListener
{
    private static class ViewHolder
    {

        Button finish;
        ImageView next;
        ViewPager pager;
        ImageView selectorFour;
        ImageView selectorOne;
        ImageView selectorThree;
        ImageView selectorTwo;
        Button skip;

        private ViewHolder()
        {
        }

    }


    private ViewHolder mHolder;
    private int mPageSelected;
    private SharedPreferences mSharedPreferences;

    public PresentationActivity()
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        skipPresentation();
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0d007c)
        {
            skipPresentation();
            finish();
        } else
        {
            if (view.getId() == 0x7f0d0084)
            {
                mPageSelected = mPageSelected + 1;
                mHolder.pager.setCurrentItem(mPageSelected);
                return;
            }
            if (view.getId() == 0x7f0d0083)
            {
                skipPresentation();
                finish();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f03001a);
        mHolder = new ViewHolder();
        mHolder.skip = (Button)findViewById(0x7f0d007c);
        mHolder.next = (ImageView)findViewById(0x7f0d0084);
        mHolder.finish = (Button)findViewById(0x7f0d0083);
        mHolder.selectorOne = (ImageView)findViewById(0x7f0d007e);
        mHolder.selectorTwo = (ImageView)findViewById(0x7f0d007f);
        mHolder.pager = (ViewPager)findViewById(0x7f0d0082);
        mHolder.selectorFour = (ImageView)findViewById(0x7f0d0081);
        mHolder.selectorThree = (ImageView)findViewById(0x7f0d0080);
        mHolder.pager.setAdapter(new PresentationAdapter(getSupportFragmentManager()));
        mHolder.next.setOnClickListener(this);
        mHolder.skip.setOnClickListener(this);
        mHolder.finish.setOnClickListener(this);
        mHolder.pager.setOnPageChangeListener(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        byte byte0 = 4;
        Object obj = mHolder.finish;
        int j;
        if (i == 3)
        {
            j = 0;
        } else
        {
            j = 4;
        }
        ((Button) (obj)).setVisibility(j);
        obj = mHolder.next;
        if (i == 3)
        {
            j = byte0;
        } else
        {
            j = 0;
        }
        ((ImageView) (obj)).setVisibility(j);
        mHolder.selectorOne.setBackgroundResource(0x7f020212);
        mHolder.selectorTwo.setBackgroundResource(0x7f020212);
        mHolder.selectorThree.setBackgroundResource(0x7f020212);
        mHolder.selectorFour.setBackgroundResource(0x7f020212);
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            mPageSelected = 0;
            mHolder.selectorOne.setBackgroundResource(0x7f020213);
            return;

        case 1: // '\001'
            mPageSelected = 1;
            mHolder.selectorTwo.setBackgroundResource(0x7f020213);
            return;

        case 2: // '\002'
            mPageSelected = 2;
            mHolder.selectorThree.setBackgroundResource(0x7f020213);
            return;

        case 3: // '\003'
            mPageSelected = 3;
            break;
        }
        mHolder.selectorFour.setBackgroundResource(0x7f020213);
    }

    public void skipPresentation()
    {
        if (mSharedPreferences == null)
        {
            mSharedPreferences = getSharedPreferences(ManagerActivity.sPreferencesName, 0);
        }
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(ManagerActivity.sPreferencesName, true);
        editor.commit();
    }
}
