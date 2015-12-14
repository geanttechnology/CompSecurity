// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.appbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

public class AppBar
    implements android.view.View.OnClickListener
{
    public static interface OnAppBarListener
    {

        public abstract void onAppBarClick(Action action1);
    }

    public static final class OnAppBarListener.Action extends Enum
    {

        private static final OnAppBarListener.Action $VALUES[];
        public static final OnAppBarListener.Action BACK;
        public static final OnAppBarListener.Action CLOSE;
        public static final OnAppBarListener.Action COMMENTS;
        public static final OnAppBarListener.Action DRAWER;
        public static final OnAppBarListener.Action INSTAGRAM;
        public static final OnAppBarListener.Action LOADING;
        public static final OnAppBarListener.Action PROFILE;
        public static final OnAppBarListener.Action SEARCH;
        public static final OnAppBarListener.Action SETTINGS;
        public static final OnAppBarListener.Action SHARE;
        public static final OnAppBarListener.Action TWITTER;

        public static OnAppBarListener.Action valueOf(String s)
        {
            return (OnAppBarListener.Action)Enum.valueOf(my/googlemusic/play/utils/appbar/AppBar$OnAppBarListener$Action, s);
        }

        public static OnAppBarListener.Action[] values()
        {
            return (OnAppBarListener.Action[])$VALUES.clone();
        }

        static 
        {
            DRAWER = new OnAppBarListener.Action("DRAWER", 0);
            BACK = new OnAppBarListener.Action("BACK", 1);
            INSTAGRAM = new OnAppBarListener.Action("INSTAGRAM", 2);
            TWITTER = new OnAppBarListener.Action("TWITTER", 3);
            SHARE = new OnAppBarListener.Action("SHARE", 4);
            SEARCH = new OnAppBarListener.Action("SEARCH", 5);
            SETTINGS = new OnAppBarListener.Action("SETTINGS", 6);
            PROFILE = new OnAppBarListener.Action("PROFILE", 7);
            LOADING = new OnAppBarListener.Action("LOADING", 8);
            COMMENTS = new OnAppBarListener.Action("COMMENTS", 9);
            CLOSE = new OnAppBarListener.Action("CLOSE", 10);
            $VALUES = (new OnAppBarListener.Action[] {
                DRAWER, BACK, INSTAGRAM, TWITTER, SHARE, SEARCH, SETTINGS, PROFILE, LOADING, COMMENTS, 
                CLOSE
            });
        }

        private OnAppBarListener.Action(String s, int i)
        {
            super(s, i);
        }
    }


    private ViewHolder mHolder;
    private OnAppBarListener mListener;

    private AppBar(View view, OnAppBarListener onappbarlistener)
    {
        mListener = onappbarlistener;
        initView(view);
    }

    private void action(View view)
    {
        view.setOnClickListener(this);
        view.setVisibility(0);
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        mHolder.background = view.findViewById(0x7f0d00c4);
        mHolder.title = (TextView)view.findViewById(0x7f0d00bd);
        mHolder.back = (ImageButton)view.findViewById(0x7f0d00c5);
        mHolder.share = (ImageButton)view.findViewById(0x7f0d018c);
        mHolder.close = (ImageButton)view.findViewById(0x7f0d0184);
        mHolder.twitter = (ImageButton)view.findViewById(0x7f0d018a);
        mHolder.search = (ImageButton)view.findViewById(0x7f0d0188);
        mHolder.drawer = (ImageButton)view.findViewById(0x7f0d0183);
        mHolder.profile = (ImageButton)view.findViewById(0x7f0d0187);
        mHolder.loading = (ImageButton)view.findViewById(0x7f0d0186);
        mHolder.settings = (ImageButton)view.findViewById(0x7f0d018b);
        mHolder.instagram = (ImageButton)view.findViewById(0x7f0d0189);
        mHolder.comments = (ImageButton)view.findViewById(0x7f0d018d);
        mHolder.searchField = (AutoCompleteTextView)view.findViewById(0x7f0d018e);
        mHolder.back.setVisibility(8);
        mHolder.share.setVisibility(8);
        mHolder.title.setVisibility(8);
        mHolder.twitter.setVisibility(8);
        mHolder.search.setVisibility(8);
        mHolder.drawer.setVisibility(8);
        mHolder.profile.setVisibility(8);
        mHolder.comments.setVisibility(8);
        mHolder.settings.setVisibility(8);
        mHolder.instagram.setVisibility(8);
        mHolder.searchField.setVisibility(8);
    }

    public static AppBar with(View view, OnAppBarListener onappbarlistener)
    {
        if (view.getId() != 0x7f0d0074)
        {
            throw new IllegalArgumentException("You should create app bar with the app view. Try to use findViewById(R.id.app_bar)");
        } else
        {
            return new AppBar(view, onappbarlistener);
        }
    }

    public AppBar back()
    {
        action(mHolder.back);
        return this;
    }

    public AppBar background(int i)
    {
        mHolder.background.setBackgroundColor(i);
        return this;
    }

    public AppBar close()
    {
        action(mHolder.close);
        return this;
    }

    public AppBar drawer()
    {
        action(mHolder.drawer);
        return this;
    }

    public AppBar enableInstagram(boolean flag)
    {
        ImageButton imagebutton = mHolder.instagram;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        imagebutton.setVisibility(i);
        return this;
    }

    public View getBackground()
    {
        return mHolder.background;
    }

    public Drawable getLoadingDrawable()
    {
        return mHolder.loading.getDrawable();
    }

    public AppBar instagram()
    {
        action(mHolder.instagram);
        return this;
    }

    public AppBar loading()
    {
        action(mHolder.loading);
        return this;
    }

    public void onClick(View view)
    {
        if (view.getId() == mHolder.drawer.getId())
        {
            mListener.onAppBarClick(OnAppBarListener.Action.DRAWER);
        } else
        {
            if (view.getId() == mHolder.back.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.BACK);
                return;
            }
            if (view.getId() == mHolder.twitter.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.TWITTER);
                return;
            }
            if (view.getId() == mHolder.search.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.SEARCH);
                return;
            }
            if (view.getId() == mHolder.settings.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.SETTINGS);
                return;
            }
            if (view.getId() == mHolder.profile.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.PROFILE);
                return;
            }
            if (view.getId() == mHolder.instagram.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.INSTAGRAM);
                return;
            }
            if (view.getId() == mHolder.loading.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.LOADING);
                return;
            }
            if (view.getId() == mHolder.comments.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.COMMENTS);
                return;
            }
            if (view.getId() == mHolder.close.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.CLOSE);
                return;
            }
            if (view.getId() == mHolder.share.getId())
            {
                mListener.onAppBarClick(OnAppBarListener.Action.SHARE);
                return;
            }
        }
    }

    public AppBar profile()
    {
        action(mHolder.profile);
        return this;
    }

    public AppBar queue()
    {
        action(mHolder.comments);
        return this;
    }

    public void remove(OnAppBarListener.Action action1)
    {
        if (action1 == OnAppBarListener.Action.DRAWER)
        {
            mHolder.drawer.setVisibility(4);
        } else
        {
            if (action1 == OnAppBarListener.Action.BACK)
            {
                mHolder.back.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.TWITTER)
            {
                mHolder.twitter.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.SEARCH)
            {
                mHolder.search.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.SETTINGS)
            {
                mHolder.settings.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.PROFILE)
            {
                mHolder.profile.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.INSTAGRAM)
            {
                mHolder.instagram.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.LOADING)
            {
                mHolder.loading.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.COMMENTS)
            {
                mHolder.comments.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.CLOSE)
            {
                mHolder.close.setVisibility(4);
                return;
            }
            if (action1 == OnAppBarListener.Action.SHARE)
            {
                mHolder.share.setVisibility(4);
                return;
            }
        }
    }

    public AppBar search()
    {
        action(mHolder.search);
        return this;
    }

    public AppBar setLoading(boolean flag)
    {
        ImageButton imagebutton = mHolder.loading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        imagebutton.setVisibility(i);
        return this;
    }

    public AppBar settings()
    {
        action(mHolder.settings);
        return this;
    }

    public AppBar share()
    {
        action(mHolder.share);
        return this;
    }

    public AppBar title(String s)
    {
        mHolder.title.setText(s);
        mHolder.title.setVisibility(0);
        return this;
    }

    public AppBar twitter()
    {
        action(mHolder.twitter);
        return this;
    }
}
