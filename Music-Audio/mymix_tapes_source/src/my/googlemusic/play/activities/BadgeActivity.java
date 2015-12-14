// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.adapters.badge.BadgeAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Badge;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.RobotoTextView;

public class BadgeActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.adapters.badge.BadgeAdapter.OnBadgeListener
{
    private static class ViewHolder
    {

        private AppBar appBar;
        private GridView grid;



/*
        static GridView access$102(ViewHolder viewholder, GridView gridview)
        {
            viewholder.grid = gridview;
            return gridview;
        }

*/


/*
        static AppBar access$202(ViewHolder viewholder, AppBar appbar)
        {
            viewholder.appBar = appbar;
            return appbar;
        }

*/

        private ViewHolder()
        {
        }

    }

    private static class ViewHolderDialog
    {

        private RobotoTextView activate;
        private ImageView badge;
        private RobotoTextView cancel;
        private RobotoTextView name;



/*
        static RobotoTextView access$1102(ViewHolderDialog viewholderdialog, RobotoTextView robototextview)
        {
            viewholderdialog.cancel = robototextview;
            return robototextview;
        }

*/



/*
        static ImageView access$1302(ViewHolderDialog viewholderdialog, ImageView imageview)
        {
            viewholderdialog.badge = imageview;
            return imageview;
        }

*/



/*
        static RobotoTextView access$1402(ViewHolderDialog viewholderdialog, RobotoTextView robototextview)
        {
            viewholderdialog.name = robototextview;
            return robototextview;
        }

*/



/*
        static RobotoTextView access$702(ViewHolderDialog viewholderdialog, RobotoTextView robototextview)
        {
            viewholderdialog.activate = robototextview;
            return robototextview;
        }

*/

        private ViewHolderDialog()
        {
        }

    }


    private BadgeAdapter mAdapter;
    private Badge mBadge;
    private List mBadgeList;
    private Dialog mDialog;
    private ViewHolder mHolder;
    private ViewHolderDialog mHolderDialog;
    private Server mServer;

    public BadgeActivity()
    {
    }

    private void initData()
    {
        mBadgeList = new ArrayList();
        mServer = ((App)getApplication()).getServer();
    }

    private void initList()
    {
        mServer.getBadgeList(mServer.getUser().getId(), new my.googlemusic.play.interfaces.Server.Callback() {

            final BadgeActivity this$0;

            public void onFailure(Response response)
            {
                if (mAdapter == null)
                {
                    mAdapter = new BadgeAdapter(BadgeActivity.this, mBadgeList, mServer, BadgeActivity.this);
                    mHolder.grid.setAdapter(mAdapter);
                    return;
                } else
                {
                    mAdapter.setGrid(mBadgeList);
                    mAdapter.notifyDataSetChanged();
                    return;
                }
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                mBadgeList = (List)obj;
                if (mAdapter == null)
                {
                    mAdapter = new BadgeAdapter(BadgeActivity.this, mBadgeList, mServer, BadgeActivity.this);
                    mHolder.grid.setAdapter(mAdapter);
                    return;
                } else
                {
                    mAdapter.setGrid(mBadgeList);
                    mAdapter.notifyDataSetChanged();
                    return;
                }
            }

            
            {
                this$0 = BadgeActivity.this;
                super();
            }
        });
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f03001c);
        mHolder = new ViewHolder();
        mHolder.grid = (GridView)findViewById(0x7f0d0090);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("My Badges").back();
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onBadgeClick(Badge badge)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, 0x7f0800e7));
        View view = getLayoutInflater().inflate(0x7f03004c, null);
        mBadge = badge;
        mHolderDialog = new ViewHolderDialog();
        mHolderDialog.badge = (ImageView)view.findViewById(0x7f0d01b4);
        mHolderDialog.name = (RobotoTextView)view.findViewById(0x7f0d01b5);
        mHolderDialog.cancel = (RobotoTextView)view.findViewById(0x7f0d01b6);
        mHolderDialog.activate = (RobotoTextView)view.findViewById(0x7f0d01b7);
        mHolderDialog.cancel.setOnClickListener(this);
        mHolderDialog.activate.setOnClickListener(this);
        RobotoTextView robototextview = mHolderDialog.activate;
        int i;
        if (badge.isAvailable())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        robototextview.setVisibility(i);
        mHolderDialog.name.setText((new StringBuilder()).append(badge.getName()).append(" - Unavailable").toString());
        Picasso.with(this).load(mServer.getLinkBadge(mServer.getUser().getId(), badge.getId())).fit().centerCrop().into(mHolderDialog.badge);
        builder.setView(view);
        mDialog = builder.create();
        mDialog.show();
    }

    public void onClick(View view)
    {
        if (view == mHolderDialog.activate)
        {
            view = ((App)getApplication()).getServer();
            view.setBadge(view.getUser().getId(), mBadge.getId(), new my.googlemusic.play.interfaces.Server.Callback() {

                final BadgeActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(BadgeActivity.this).message(response.getContent()).show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(BadgeActivity.this).message(obj.toString()).show();
                        mServer.changeBadge(mBadge.getId());
                        mDialog.dismiss();
                        initList();
                    }
                }

            
            {
                this$0 = BadgeActivity.this;
                super();
            }
            });
        } else
        if (view == mHolderDialog.cancel)
        {
            mDialog.cancel();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initData();
        initView();
        initList();
    }

    protected void onResume()
    {
        super.onResume();
    }




/*
    static List access$302(BadgeActivity badgeactivity, List list)
    {
        badgeactivity.mBadgeList = list;
        return list;
    }

*/



/*
    static BadgeAdapter access$402(BadgeActivity badgeactivity, BadgeAdapter badgeadapter)
    {
        badgeactivity.mAdapter = badgeadapter;
        return badgeadapter;
    }

*/




}
