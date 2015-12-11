// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bitstrips.outfitbuilder.managers.OBUrlsManager;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.bitstrips.outfitbuilder.views.BrandHeaderView;
import com.bitstrips.outfitbuilder.views.FittingRoomPreviewView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

public class OBFittingRoomActivity extends AppCompatActivity
    implements com.bitstrips.outfitbuilder.views.FittingRoomPreviewView.Listener
{
    public class OBFittingRoomAdapter extends PagerAdapter
    {

        OBAvatarData avatarData;
        Context context;
        ArrayList items;
        final OBFittingRoomActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            return items.size();
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            Object obj = (OBOutfit)items.get(i);
            LayoutInflater.from(context);
            ImageView imageview = new ImageView(context);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            imageview.setTag(Integer.valueOf(((OBOutfit) (obj)).getId()));
            obj = OBUrlsManager.getInstance().getFloatingOutfitUrl(((OBOutfit) (obj)).getId(), avatarData);
            Picasso.with(context).load(((String) (obj))).fit().centerCrop().into(imageview);
            viewgroup.addView(imageview, 0, layoutparams);
            return imageview;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        public OBFittingRoomAdapter(Context context1, ArrayList arraylist, OBAvatarData obavatardata)
        {
            this$0 = OBFittingRoomActivity.this;
            super();
            context = context1;
            items = arraylist;
            avatarData = obavatardata;
        }
    }


    public static String INITIAL_OUTFIT_EXTRA = "InitialOutfit";
    public static String TAG = com/bitstrips/outfitbuilder/OBFittingRoomActivity.getCanonicalName();
    OBAvatarData avatarData;
    Drawable backButtonDrawable;
    private BrandHeaderView brandHeaderView;
    int currentlySelectedOutfit;
    private FittingRoomPreviewView fittingRoomPreviewView;
    BroadcastReceiver mMessageReceiver;
    ArrayList outfits;
    ViewPager pager;
    final android.support.v4.view.ViewPager.OnPageChangeListener pagerListener = new android.support.v4.view.ViewPager.OnPageChangeListener() {

        final OBFittingRoomActivity this$0;

        public void onPageScrollStateChanged(int i)
        {
            if (i == 1)
            {
                showAllOutfits();
            } else
            if (i == 0)
            {
                setData(currentlySelectedOutfit);
                return;
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
        }

        public void onPageSelected(int i)
        {
            setData(i);
        }

            
            {
                this$0 = OBFittingRoomActivity.this;
                super();
            }
    };
    private RelativeLayout progressSpinner;
    Drawable saveButtonDrawable;
    private Toolbar toolbar;

    public OBFittingRoomActivity()
    {
        currentlySelectedOutfit = 0;
        mMessageReceiver = new BroadcastReceiver() {

            final OBFittingRoomActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressSpinner.setVisibility(8);
                int i = intent.getIntExtra("com.bitstrips.outfitbuilder.saveOutfitResponseCode", -1);
                if (i == 0)
                {
                    closeFittingRoom();
                } else
                if (i == 1)
                {
                    showErrorDialog();
                    return;
                }
            }

            
            {
                this$0 = OBFittingRoomActivity.this;
                super();
            }
        };
    }

    private void closeFittingRoom()
    {
        progressSpinner.setVisibility(0);
        setResult(-1, new Intent());
        finish();
    }

    private void hideOutfitWithId(int i)
    {
        for (int j = 0; j < pager.getChildCount(); j++)
        {
            ImageView imageview = (ImageView)pager.getChildAt(j);
            if (((Integer)imageview.getTag()).intValue() == i)
            {
                imageview.setVisibility(4);
            }
        }

    }

    private void saveOutfit()
    {
        progressSpinner.setVisibility(0);
        Intent intent = new Intent("com.bitstrips.outfitbuilder.save-outfit-request");
        intent.putExtra("OutfitIDExtra", ((OBOutfit)outfits.get(currentlySelectedOutfit)).getId());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void setData(int i)
    {
        OBOutfit oboutfit = (OBOutfit)outfits.get(i);
        if (oboutfit == null)
        {
            return;
        } else
        {
            currentlySelectedOutfit = i;
            showAllOutfits();
            brandHeaderView.setBrandData(oboutfit.getBrand());
            setToolbarDrawablesTint(oboutfit.getBrand().getHeaderForegroundColor());
            fittingRoomPreviewView.setOutfitData(avatarData, oboutfit);
            return;
        }
    }

    private void setReferenceToBackButtonDrawable()
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < toolbar.getChildCount())
                {
                    View view = toolbar.getChildAt(i);
                    if (!(view instanceof ImageButton))
                    {
                        break label0;
                    }
                    backButtonDrawable = ((ImageButton)view).getDrawable();
                }
                return;
            }
            i++;
        } while (true);
    }

    private void setToolbarDrawablesTint(int i)
    {
        if (backButtonDrawable == null || saveButtonDrawable == null)
        {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            backButtonDrawable.setTint(i);
            saveButtonDrawable.setTint(i);
            return;
        } else
        {
            PorterDuffColorFilter porterduffcolorfilter = new PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
            backButtonDrawable.setColorFilter(porterduffcolorfilter);
            saveButtonDrawable.setColorFilter(porterduffcolorfilter);
            return;
        }
    }

    private void showAllOutfits()
    {
        fittingRoomPreviewView.setNakedAvatar(avatarData);
        for (int i = 0; i < pager.getChildCount(); i++)
        {
            pager.getChildAt(i).setVisibility(0);
        }

    }

    private void showErrorDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error_dialog_title));
        builder.setMessage(getString(R.string.error_failed_to_save_avatar_message));
        builder.setPositiveButton(getString(R.string.error_retry_btn), new android.content.DialogInterface.OnClickListener() {

            final OBFittingRoomActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                saveOutfit();
            }

            
            {
                this$0 = OBFittingRoomActivity.this;
                super();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new android.content.DialogInterface.OnClickListener() {

            final OBFittingRoomActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = OBFittingRoomActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    public void init(OBCatalog obcatalog)
    {
        outfits = obcatalog.asOutfitList();
        pager = (ViewPager)findViewById(R.id.fitting_room_pager);
        pager.setClipToPadding(false);
        int j = getIntent().getIntExtra(INITIAL_OUTFIT_EXTRA, 0);
        int i = 0;
        do
        {
label0:
            {
                if (i < outfits.size())
                {
                    if (((OBOutfit)outfits.get(i)).getId() != j)
                    {
                        break label0;
                    }
                    currentlySelectedOutfit = i;
                }
                i = getResources().getDisplayMetrics().widthPixels;
                pager.setPadding(i / 4, 0, i / 4, 0);
                obcatalog = new OBFittingRoomAdapter(this, outfits, avatarData);
                pager.setAdapter(obcatalog);
                showAllOutfits();
                pager.addOnPageChangeListener(pagerListener);
                pager.setCurrentItem(currentlySelectedOutfit);
                setData(currentlySelectedOutfit);
                return;
            }
            i++;
        } while (true);
    }

    public void onAssetLoadingError()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error_loading_dialog_title));
        builder.setMessage(getString(R.string.error_loading_dialog_message));
        builder.setNegativeButton(getString(0x104000a), new android.content.DialogInterface.OnClickListener() {

            final OBFittingRoomActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = OBFittingRoomActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_obfitting_room);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(0x1060000));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(null);
        brandHeaderView = (BrandHeaderView)findViewById(R.id.brand_header_view);
        fittingRoomPreviewView = (FittingRoomPreviewView)findViewById(R.id.fitting_room_preview);
        progressSpinner = (RelativeLayout)findViewById(R.id.progress);
        avatarData = (OBAvatarData)getIntent().getParcelableExtra("avatarDataExtra");
        fittingRoomPreviewView.setHeadData(avatarData.getId());
        fittingRoomPreviewView.setNakedAvatar(avatarData);
        init((OBCatalog)getIntent().getParcelableExtra("outfitCatalog"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("com.bitstrips.outfitbuilder.save-outfit-response"));
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            bundle = getWindow();
            bundle.addFlags(0x80000000);
            bundle.clearFlags(0x4000000);
            bundle.setStatusBarColor(getResources().getColor(0x106000c));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.fitting_room_menu, menu);
        saveButtonDrawable = menu.getItem(0).getIcon();
        setReferenceToBackButtonDrawable();
        setData(currentlySelectedOutfit);
        return true;
    }

    public void onDestroy()
    {
        pager.removeOnPageChangeListener(pagerListener);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        setToolbarDrawablesTint(-1);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x102002c)
        {
            finish();
            return true;
        }
        if (i == R.id.save)
        {
            saveOutfit();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onOutfitLoaded(OBOutfit oboutfit)
    {
        hideOutfitWithId(oboutfit.getId());
    }







}
