// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

public class ImageZoomActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private class ViewHolder
    {

        AppBar appBar;
        ImageView image;
        ProgressBar loading;
        final ImageZoomActivity this$0;

        private ViewHolder()
        {
            this$0 = ImageZoomActivity.this;
            super();
        }

    }


    public static final String EXTRA_IMAGE = "ImageZoomActivity:image";
    private long idUser;
    private ViewHolder mHolder;
    private Server mServer;

    public ImageZoomActivity()
    {
    }

    private void initData()
    {
        idUser = getIntent().getExtras().getLong("idUser");
        mServer = ((App)getApplication()).getServer();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f030028);
        mHolder = new ViewHolder();
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).back().title("");
        mHolder.loading = (ProgressBar)findViewById(0x7f0d00e3);
        mHolder.image = (ImageView)findViewById(0x7f0d00e4);
        setLoading(true);
        mServer.getProfile(mServer.getUser().getId(), idUser, new my.googlemusic.play.interfaces.Server.Callback() {

            final ImageZoomActivity this$0;

            public void onFailure(Response response)
            {
                setLoading(false);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                obj = (User)((List)obj).get(0);
                String s = mServer.getLinkUserImage(((User) (obj)).getId());
                Picasso.with(ImageZoomActivity.this).load(s).placeholder(0x7f0201dc).into(mHolder.image);
                mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), ImageZoomActivity.this).back().title(((User) (obj)).getUsername());
                setLoading(false);
            }

            
            {
                this$0 = ImageZoomActivity.this;
                super();
            }
        });
    }

    private void setLoading(boolean flag)
    {
        ProgressBar progressbar = mHolder.loading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        progressbar.setVisibility(i);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initData();
        initView();
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



}
