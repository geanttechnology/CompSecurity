// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.astuetz.PagerSlidingTabStrip;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;
import my.googlemusic.play.adapters.search.SearchPagerAdapter;
import my.googlemusic.play.utils.appbar.AppBar;

public class SearchActivity extends ActionBarActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, TextWatcher, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.widget.TextView.OnEditorActionListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener
{
    public static interface Searchable
    {

        public abstract void search(String s);
    }

    private static class ViewHolder
    {

        AppBar appBar;
        AutoCompleteTextView field;
        ViewPager pager;
        PagerSlidingTabStrip tab;

        private ViewHolder()
        {
        }

    }


    private final long SEARCH_DELAY = 1000L;
    private SearchPagerAdapter mAdapter;
    private ViewHolder mHolder;
    private Timer timer;

    public SearchActivity()
    {
    }

    private void actionSearch()
    {
        android.support.v4.app.Fragment fragment = mAdapter.getRegisteredFragment(mHolder.pager.getCurrentItem());
        if (fragment instanceof Searchable)
        {
            String s1 = String.valueOf(mHolder.field.getText());
            String s = s1;
            if (s1.contains("'"))
            {
                s = s1.replace("'", "`");
            }
            ((Searchable)fragment).search(s);
        }
    }

    private void closeKeyboard()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void initView()
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        mHolder = new ViewHolder();
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).back().search();
        mHolder.pager = (ViewPager)findViewById(0x7f0d014b);
        mHolder.tab = (PagerSlidingTabStrip)findViewById(0x7f0d014a);
        mHolder.field = (AutoCompleteTextView)findViewById(0x7f0d018e);
        mHolder.field.setVisibility(0);
        mHolder.field.setOnEditorActionListener(this);
        mHolder.field.addTextChangedListener(this);
        mHolder.field.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf"));
        mAdapter = new SearchPagerAdapter(getSupportFragmentManager());
        mHolder.pager.setAdapter(mAdapter);
        mHolder.tab.setViewPager(mHolder.pager);
        mHolder.tab.setOnPageChangeListener(this);
    }

    public void afterTextChanged(Editable editable)
    {
        System.out.println("OUTSIDE");
        if (mHolder.pager.getCurrentItem() == 0)
        {
            timer.cancel();
            timer = new Timer();
            timer.schedule(new TimerTask() {

                final SearchActivity this$0;

                public void run()
                {
                    System.out.println("INSIDE");
                    actionSearch();
                }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
            }, 1000L);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        } else
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SEARCH)
        {
            actionSearch();
            closeKeyboard();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030035);
        initView();
        actionSearch();
        timer = new Timer();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        actionSearch();
        closeKeyboard();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return i == 82 || super.onKeyDown(i, keyevent);
    }

    public boolean onLongClick(View view)
    {
        return true;
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        mHolder.pager.setCurrentItem(i);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        return true;
    }

}
