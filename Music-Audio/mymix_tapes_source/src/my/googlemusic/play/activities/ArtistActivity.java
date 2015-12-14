// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.adapters.artist.ArtistAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.animations.AnimationFAB;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.transformations.BlurTransform;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity, MoreAlbumsActivity

public class ArtistActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.adapters.artist.ArtistAdapter.OnArtistAlbumClickListener, android.view.View.OnClickListener
{

    public static final String EXTRAS_ARTIST = "artist";
    List albumFeatureList;
    List albumList;
    private RelativeLayout mAdView;
    private ArtistAdapter mAdapterArtist;
    private ArtistAdapter mAdapterFeature;
    private AppBar mAppBar;
    private Artist mArtist;
    private TextView mArtistMessage;
    private ImageView mBackground;
    private ImageButton mFAB;
    private TextView mFeatureMessage;
    private ImageButton mImage;
    private ImageButton mInstagram;
    private GridView mListAlbumArtist;
    private GridView mListAlbumFeature;
    private View mLoading;
    private Button mMoreArtist;
    private Button mMoreFeature;
    private View mOverlay;
    private ScrollView mScroll;
    private Server mServer;
    private float mSpeed;
    private View mStatusBar;
    private TextView mTextInstagram;
    private TextView mTextTwitter;
    private int mTotalScrolled;
    private ImageButton mTwitter;
    private TextView mUsername;

    public ArtistActivity()
    {
        mSpeed = 3F;
    }

    private void clickCloseOptions(ImageButton imagebutton, ImageButton imagebutton1, ImageButton imagebutton2, TextView textview, TextView textview1)
    {
        imagebutton.setVisibility(4);
        imagebutton1.setVisibility(4);
        textview.setVisibility(4);
        textview1.setVisibility(4);
        AnimationFAB.buttonFadeOut(imagebutton, 120);
        AnimationFAB.textFadeOut(textview, 120);
        AnimationFAB.buttonFadeOut(imagebutton1, 120);
        AnimationFAB.textFadeOut(textview1, 120);
        imagebutton2.setBackgroundResource(0x7f02005f);
    }

    private void clickOpenOptions(ImageButton imagebutton, ImageButton imagebutton1, ImageButton imagebutton2, TextView textview, TextView textview1, ScrollView scrollview)
    {
        imagebutton.setVisibility(0);
        imagebutton1.setVisibility(0);
        textview.setVisibility(0);
        textview1.setVisibility(0);
        AnimationFAB.buttonFadeInDown(imagebutton, 120);
        AnimationFAB.textFadeIn(textview, 200);
        AnimationFAB.buttonFadeInDown(imagebutton1, 140);
        AnimationFAB.textFadeIn(textview1, 220);
        scrollview.fullScroll(33);
        imagebutton2.setBackgroundResource(0x7f02005b);
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mAdView);
    }

    private void initArtistAlbum()
    {
        setLoading(true);
        if (mArtist.getName().contains(" x "))
        {
            mArtist.getName().split(" x ");
        }
        albumList = mServer.getAlbumsArtist(mArtist, 6);
        mAdapterArtist = new ArtistAdapter(this, albumList, this);
        mListAlbumArtist.setAdapter(mAdapterArtist);
        if (albumList.size() == 0)
        {
            mArtistMessage.setVisibility(0);
            mMoreArtist.setVisibility(8);
        }
        albumFeatureList = mServer.getAlbumsRelated(mArtist, 6);
        mAdapterFeature = new ArtistAdapter(this, albumFeatureList, this);
        mListAlbumFeature.setAdapter(mAdapterFeature);
        if (albumFeatureList.size() == 0)
        {
            mFeatureMessage.setVisibility(0);
            mMoreFeature.setVisibility(8);
        }
        setLoading(false);
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
        if (getIntent().getExtras() != null)
        {
            mArtist = (Artist)getIntent().getExtras().getParcelable("artist");
        }
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mLoading = findViewById(0x7f0d019b);
        mStatusBar = findViewById(0x7f0d008e);
        mListAlbumArtist = (GridView)findViewById(0x7f0d0087);
        mListAlbumFeature = (GridView)findViewById(0x7f0d008b);
        mBackground = (ImageView)findViewById(0x7f0d0284);
        mImage = (ImageButton)findViewById(0x7f0d0286);
        mUsername = (TextView)findViewById(0x7f0d0287);
        mMoreArtist = (Button)findViewById(0x7f0d0089);
        mMoreFeature = (Button)findViewById(0x7f0d008d);
        mScroll = (ScrollView)findViewById(0x7f0d0085);
        mArtistMessage = (TextView)findViewById(0x7f0d0088);
        mFeatureMessage = (TextView)findViewById(0x7f0d008c);
        mOverlay = findViewById(0x7f0d0285);
        mFAB = (ImageButton)findViewById(0x7f0d0288);
        mTwitter = (ImageButton)findViewById(0x7f0d0289);
        mTextTwitter = (TextView)findViewById(0x7f0d028a);
        mInstagram = (ImageButton)findViewById(0x7f0d028b);
        mTextInstagram = (TextView)findViewById(0x7f0d028c);
        mAdView = (RelativeLayout)findViewById(0x7f0d008f);
        mAppBar = AppBar.with(findViewById(0x7f0d0074), this).title((new StringBuilder()).append("More albums by ").append(mArtist.getName()).toString()).back();
        TextView textview = (TextView)findViewById(0x7f0d00bd);
        textview.setTextColor(getResources().getColor(0x106000b));
        textview.setSelected(true);
        Picasso.with(this).load(mArtist.getImage()).transform(new BlurTransform(this, 20)).into(mBackground);
        Picasso.with(this).load(mArtist.getImage()).placeholder(0x7f02003e).transform(new CropSquareTransformation()).into(mImage);
        mUsername.setText(mArtist.getName());
        mTextTwitter.setText(mArtist.getTwitter());
        mTextInstagram.setText(mArtist.getInstagram());
        mMoreArtist.setOnClickListener(this);
        mMoreFeature.setOnClickListener(this);
        mFAB.setOnClickListener(this);
        mTwitter.setOnClickListener(this);
        mTextTwitter.setOnClickListener(this);
        mInstagram.setOnClickListener(this);
        mTextInstagram.setOnClickListener(this);
        if (CompatibilityUtil.getSdkVersion() >= 11)
        {
            mAppBar.getBackground().setAlpha(0.0F);
            mStatusBar.setAlpha(0.0F);
        }
        if (CompatibilityUtil.getSdkVersion() <= 19)
        {
            mStatusBar.setVisibility(8);
        }
    }

    private void setLoading(boolean flag)
    {
        View view = mLoading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onArtistAlbumClick(Album album)
    {
        Intent intent = new Intent(this, my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("albumId", album.getId());
        startActivity(intent);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Runtime.getRuntime().gc();
        finish();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 7: default 72
    //                   2131558537: 439
    //                   2131558541: 484
    //                   2131559048: 129
    //                   2131559049: 197
    //                   2131559050: 262
    //                   2131559051: 327
    //                   2131559052: 383;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        mTwitter = (ImageButton)findViewById(0x7f0d0289);
        mTextTwitter = (TextView)findViewById(0x7f0d028a);
        mInstagram = (ImageButton)findViewById(0x7f0d028b);
        mTextInstagram = (TextView)findViewById(0x7f0d028c);
        return;
_L4:
        if (mTwitter.getVisibility() == 0)
        {
            clickCloseOptions(mTwitter, mInstagram, mFAB, mTextTwitter, mTextInstagram);
        } else
        {
            clickOpenOptions(mTwitter, mInstagram, mFAB, mTextTwitter, mTextInstagram, mScroll);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mArtist.getTwitter() != null)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("https://twitter.com/").append(mArtist.getTwitter().replace("@", "")).toString())));
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (mArtist.getTwitter() != null)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("https://twitter.com/").append(mArtist.getTwitter().replace("@", "")).toString())));
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (mArtist.getInstagram() != null)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://instagram.com/").append(mArtist.getInstagram()).toString())));
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (mArtist.getInstagram() != null)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://instagram.com/").append(mArtist.getInstagram()).toString())));
        }
        continue; /* Loop/switch isn't completed */
_L2:
        startActivity((new Intent(this, my/googlemusic/play/activities/MoreAlbumsActivity)).putExtra("albums", App.getGson().toJson(albumList, (new TypeToken() {

            final ArtistActivity this$0;

            
            {
                this$0 = ArtistActivity.this;
                super();
            }
        }).getType())));
        continue; /* Loop/switch isn't completed */
_L3:
        startActivity((new Intent(this, my/googlemusic/play/activities/MoreAlbumsActivity)).putExtra("albums", App.getGson().toJson(albumFeatureList, (new TypeToken() {

            final ArtistActivity this$0;

            
            {
                this$0 = ArtistActivity.this;
                super();
            }
        }).getType())));
        if (true) goto _L1; else goto _L9
_L9:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        setContentView(0x7f03001b);
        initData();
        initView();
        initAds();
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        initArtistAlbum();
        if (mServer.getUser().isPremium() && mAdView.getVisibility() == 0)
        {
            mAdView.setVisibility(8);
        }
    }
}
