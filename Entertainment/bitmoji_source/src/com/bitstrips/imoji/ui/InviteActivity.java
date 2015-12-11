// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.adapters.InvitePagerAdapter;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import com.bitstrips.imoji.ui.views.ImojiBannerView;
import com.bitstrips.imoji.ui.views.ImojiView;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.io.File;
import java.util.Collections;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteDialogFragment, ImageLoader, IntentCreatorService

public class InviteActivity extends ActionBarActivity
    implements InviteShareClickListener.ImojiClickListener
{

    public static final String EXTRA_AVATAR_ID = "avatarId";
    public static final String EXTRA_BSAUTH_TOKEN = "bsauthToken";
    public static final String EXTRA_IS_FIRST_SHARE = "isFirstShare";
    private static final String TAG = "InviteActivity";
    AnalyticsService analyticsService;
    private String avatarId;
    BitstripsService bitstripsService;
    private boolean hasSharedInviteFlow;
    ImageLoader imageLoader;
    IntentCreatorService intentCreatorService;
    private boolean isFirstShare;
    private InvitePagerAdapter pagerAdapter;
    PreferenceUtils preferenceUtils;
    private List templates;
    TemplatesManager templatesManager;
    private Toolbar toolbar;
    private ViewPager viewPager;

    public InviteActivity()
    {
    }

    private Intent createShareIntent(File file)
    {
        Intent intent = new Intent();
        file = Uri.fromFile(file);
        String s = getString(0x7f06009b);
        String s1 = String.format("%s %s%s", new Object[] {
            getString(0x7f06009c), getString(0x7f060099), AvatarInfo.getIdHash(preferenceUtils)
        });
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", s1);
        intent.putExtra("android.intent.extra.STREAM", file);
        intent.setType("image/png");
        return intent;
    }

    private void createTemplateAdapter(String s)
    {
        templates = templatesManager.getListForTag("#invite");
        Collections.shuffle(templates);
        pagerAdapter = new InvitePagerAdapter(getSupportFragmentManager(), templates, s, templatesManager);
        viewPager = (ViewPager)findViewById(0x7f0b00cf);
        int i = Math.round(TypedValue.applyDimension(1, 8F, getResources().getDisplayMetrics()));
        viewPager.setPageMargin(i);
        viewPager.setAdapter(pagerAdapter);
    }

    private void customizeActionBar()
    {
        toolbar = (Toolbar)findViewById(0x7f0b0074);
        if (isFirstShare)
        {
            toolbar.setTitle(0x7f060092);
        }
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar == null)
        {
            return;
        }
        boolean flag;
        if (!isFirstShare)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        actionbar.setDisplayHomeAsUpEnabled(flag);
    }

    private void setupCustomShareDialog(Intent intent, File file, Imoji imoji)
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        Object obj = getSupportFragmentManager().findFragmentByTag("shareDialog");
        if (obj != null)
        {
            fragmenttransaction.remove(((android.support.v4.app.Fragment) (obj)));
        }
        obj = new InviteDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(InviteDialogFragment.INTENT_KEY, intent);
        bundle.putParcelable(InviteDialogFragment.IMOJI_KEY, imoji);
        bundle.putString(InviteDialogFragment.FILE_PATH_KEY, file.getAbsolutePath());
        bundle.putString(InviteDialogFragment.AVATAR_HASH_ID, AvatarInfo.getIdHash(preferenceUtils));
        ((InviteDialogFragment) (obj)).setArguments(bundle);
        ((InviteDialogFragment) (obj)).show(fragmenttransaction, "shareDialog");
    }

    public void onBackPressed()
    {
        if (isFirstShare)
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onClick(File file, Imoji imoji, int i)
    {
        if (file == null)
        {
            return;
        } else
        {
            setupCustomShareDialog(createShareIntent(file), file, imoji);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        avatarId = getIntent().getStringExtra("avatarId");
        isFirstShare = getIntent().getBooleanExtra("isFirstShare", false);
        setContentView(0x7f030043);
        customizeActionBar();
        bundle = (ImojiBannerView)findViewById(0x7f0b00ce);
        if (isFirstShare)
        {
            bundle.setSpeechBubbleText(getString(0x7f060094));
        }
        if (avatarId != null)
        {
            createTemplateAdapter(avatarId);
            return;
        } else
        {
            bundle = getIntent().getStringExtra("bsauthToken");
            String s = getString(0x7f060017);
            bitstripsService.getAvatarInfo(null, bundle, s, new Callback() {

                final InviteActivity this$0;

                public void failure(RetrofitError retrofiterror)
                {
                    retrofiterror.printStackTrace();
                }

                public void success(AvatarInfo avatarinfo, Response response)
                {
                    createTemplateAdapter(avatarinfo.getId());
                }

                public volatile void success(Object obj, Response response)
                {
                    success((AvatarInfo)obj, response);
                }

            
            {
                this$0 = InviteActivity.this;
                super();
            }
            });
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuinflater = getMenuInflater();
        if (isFirstShare)
        {
            menuinflater.inflate(0x7f0e0004, menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            return true;

        case 2131427605: 
            analyticsService.sendEvent(Category.INVITE, Action.SKIP, null);
            break;
        }
        finish();
        return true;
    }

    public void onResume()
    {
        super.onResume();
        if (hasSharedInviteFlow)
        {
            finish();
        }
    }

    public void onStart()
    {
        super.onStart();
        analyticsService.reportStart(this);
    }

    public void onStop()
    {
        super.onStop();
        analyticsService.reportStop(this);
    }

    public void setHasSharedInviteFlow()
    {
        ((Button)findViewById(0x7f0b00d0)).setEnabled(true);
        hasSharedInviteFlow = true;
    }

    public void shareButtonClickHandler(View view)
    {
        ((Button)findViewById(0x7f0b00d0)).setEnabled(false);
        int i = viewPager.getCurrentItem();
        view = (Imoji)templates.get(i);
        ImojiView imojiview = (ImojiView)viewPager.findViewById(0x7f0b00ca);
        (new GetImojiImageTask(this, view, imojiview) {

            final InviteActivity this$0;
            final Activity val$activity;
            final Imoji val$imojiToShare;
            final ImojiView val$imojiView;

            protected void onPostExecute(File file)
            {
                ((InviteShareClickListener.ImojiClickListener)activity).onClick(file, imojiToShare, imojiView.getId());
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((File)obj);
            }

            
            {
                this$0 = InviteActivity.this;
                activity = activity2;
                imojiToShare = imoji;
                imojiView = imojiview;
                super(final_activity1, final_imageloader, final_templatesmanager);
            }
        }).execute(new Imoji[] {
            view
        });
    }

}
