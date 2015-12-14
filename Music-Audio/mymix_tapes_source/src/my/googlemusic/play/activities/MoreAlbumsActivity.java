// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import my.googlemusic.play.adapters.manager.GridAlbumAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

public class MoreAlbumsActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.adapters.manager.GridAlbumAdapter.OnAlbumClickListener
{
    private static class ViewHolder
    {

        AppBar appBar;
        ListView recyclerView;

        private ViewHolder()
        {
        }

    }


    private GridAlbumAdapter mAdapter;
    private ArrayList mAlbums;
    private ViewHolder mHolder;

    public MoreAlbumsActivity()
    {
    }

    private void initData()
    {
        mAlbums = (ArrayList)App.getGson().fromJson(getIntent().getExtras().getString("albums"), (new TypeToken() {

            final MoreAlbumsActivity this$0;

            
            {
                this$0 = MoreAlbumsActivity.this;
                super();
            }
        }).getType());
    }

    private void initList()
    {
        if (mAdapter == null)
        {
            mAdapter = new GridAlbumAdapter(this, mAlbums, -1, this);
            mHolder.recyclerView.setAdapter(mAdapter);
            return;
        } else
        {
            mAdapter.setList(mAlbums);
            mAdapter.notifyDataSetChanged();
            return;
        }
    }

    private void initView()
    {
        mHolder = new ViewHolder();
        mHolder.recyclerView = (ListView)findViewById(0x7f0d00fa);
        mHolder.recyclerView.setAdapter(mAdapter);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).back();
        if (mAlbums.isEmpty())
        {
            mHolder.appBar.title("No more albums founded");
            return;
        } else
        {
            mHolder.appBar.title((new StringBuilder()).append("More from ").append(((Album)mAlbums.get(0)).getArtist().getName()).toString());
            return;
        }
    }

    public void onAlbumClick(Album album)
    {
        Intent intent = new Intent(this, my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("albumId", album.getId());
        startActivity(intent);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            onBackPressed();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Runtime.getRuntime().gc();
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        setContentView(0x7f03002e);
        initData();
        initView();
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        initList();
    }
}
