// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.LinkAccountsResult;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.util.Arrays;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrieveAvatarActivity extends AppCompatActivity
{

    private static final String TAG = "RetrieveAvatarActivity";
    public static Bitmap avatarBitmap = null;
    BitstripsService bitstripsService;
    FacebookService facebookService;
    PreferenceUtils preferenceUtils;
    Toolbar toolbar;

    public RetrieveAvatarActivity()
    {
    }

    private void addAvatarBitmap()
    {
        final ImageView image = (ImageView)findViewById(0x7f0b00f9);
        final RelativeLayout parent = (RelativeLayout)image.getParent();
        image.setImageBitmap(avatarBitmap);
        image.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final RetrieveAvatarActivity this$0;
            final ImageView val$image;
            final RelativeLayout val$parent;

            public boolean onPreDraw()
            {
                if (RetrieveAvatarActivity.avatarBitmap == null)
                {
                    return true;
                } else
                {
                    int i = RetrieveAvatarActivity.avatarBitmap.getWidth();
                    int j = RetrieveAvatarActivity.avatarBitmap.getHeight();
                    float f = ((float)parent.getMeasuredHeight() * 0.9F) / (float)j;
                    image.getLayoutParams().width = (int)((float)i * f);
                    image.getLayoutParams().height = (int)((float)j * f);
                    image.setX(((float)parent.getMeasuredWidth() - (float)image.getLayoutParams().width) / 2.0F);
                    image.setY(((float)parent.getMeasuredHeight() - (float)image.getLayoutParams().height) / 2.0F);
                    return true;
                }
            }

            
            {
                this$0 = RetrieveAvatarActivity.this;
                parent = relativelayout;
                image = imageview;
                super();
            }
        });
    }

    private void close()
    {
        setResult(-1);
        finish();
    }

    private void setUpBanner()
    {
        if (avatarBitmap == null)
        {
            findViewById(0x7f0b00f5).setVisibility(0);
            findViewById(0x7f0b00f6).setVisibility(8);
            return;
        } else
        {
            findViewById(0x7f0b00f5).setVisibility(8);
            findViewById(0x7f0b00f6).setVisibility(0);
            return;
        }
    }

    private void setUpCustomActionBar()
    {
        toolbar = (Toolbar)findViewById(0x7f0b0074);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void sizeAvatarNotFoundImage()
    {
        final ImageView image = (ImageView)findViewById(0x7f0b00f8);
        Object obj = (Button)findViewById(0x7f0b00fa);
        obj = image.getViewTreeObserver();
        final RelativeLayout parent = (RelativeLayout)image.getParent();
        if (avatarBitmap != null)
        {
            image.setAlpha(0.0F);
            return;
        } else
        {
            ((ViewTreeObserver) (obj)).addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                final RetrieveAvatarActivity this$0;
                final ImageView val$image;
                final RelativeLayout val$parent;

                public boolean onPreDraw()
                {
                    image.getViewTreeObserver().removeOnPreDrawListener(this);
                    int i = image.getMeasuredWidth();
                    int j = image.getMeasuredHeight();
                    float f = ((float)parent.getMeasuredWidth() * 0.6F) / (float)i;
                    image.getLayoutParams().width = (int)((float)i * f);
                    image.getLayoutParams().height = (int)((float)j * f);
                    image.setX(((float)parent.getMeasuredWidth() - (float)image.getLayoutParams().width) / 2.0F);
                    image.setY(((float)parent.getMeasuredHeight() - (float)image.getLayoutParams().height) / 2.0F);
                    return true;
                }

            
            {
                this$0 = RetrieveAvatarActivity.this;
                image = imageview;
                parent = relativelayout;
                super();
            }
            });
            return;
        }
    }

    private void sizeBackgroundImage()
    {
        final ImageView image = (ImageView)findViewById(0x7f0b00f7);
        image.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final RetrieveAvatarActivity this$0;
            final ImageView val$image;
            final RelativeLayout val$parent;

            public boolean onPreDraw()
            {
                image.getViewTreeObserver().removeOnPreDrawListener(this);
                int i = image.getMeasuredWidth();
                int j = image.getMeasuredHeight();
                float f = (float)parent.getMeasuredWidth() / (float)i;
                image.getLayoutParams().width = (int)((float)i * f);
                image.getLayoutParams().height = (int)((float)j * f);
                return true;
            }

            
            {
                this$0 = RetrieveAvatarActivity.this;
                image = imageview;
                parent = relativelayout;
                super();
            }
        });
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        facebookService.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f03005e);
        sizeBackgroundImage();
        sizeAvatarNotFoundImage();
        addAvatarBitmap();
        setUpCustomActionBar();
        setUpBanner();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0007, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0b00f1)
        {
            close();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResume()
    {
        super.onResume();
        facebookService.logActivate(this);
    }

    public void onRetrieveClicked(final View bsauthToken)
    {
        bsauthToken = preferenceUtils.getString(0x7f06003a, "");
        final TextView skipText = (TextView)findViewById(0x7f0b00f1);
        final Button retrieveButton = (Button)findViewById(0x7f0b00fa);
        facebookService.openActiveSession(this, true, new com.bitstrips.imoji.auth.FacebookService.SessionOpenCallback() {

            final RetrieveAvatarActivity this$0;
            final String val$bsauthToken;
            final Context val$context;
            final Button val$retrieveButton;
            final TextView val$skipText;

            public void onOpened()
            {
                retrieveButton.setEnabled(false);
                retrieveButton.setAlpha(0.3F);
                skipText.setEnabled(false);
                skipText.setAlpha(0.3F);
                String s = facebookService.getToken();
                String s1 = getString(0x7f060017);
                bitstripsService.linkAccounts(s, bsauthToken, s1, s. new Callback() {

                    final _cls4 this$1;
                    final String val$fbToken;

                    public void failure(RetrofitError retrofiterror)
                    {
                        close();
                    }

                    public void success(LinkAccountsResult linkaccountsresult, Response response)
                    {
                        if (linkaccountsresult.success().booleanValue())
                        {
                            linkaccountsresult = context.getString(0x7f060017);
                            bitstripsService.getAvatarInfo(fbToken, bsauthToken, linkaccountsresult, new Callback() {

                                final _cls1 this$2;

                                public void failure(RetrofitError retrofiterror)
                                {
                                    close();
                                }

                                public void success(AvatarInfo avatarinfo, Response response)
                                {
                                    preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
                                    close();
                                }

                                public volatile void success(Object obj, Response response)
                                {
                                    success((AvatarInfo)obj, response);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            return;
                        } else
                        {
                            close();
                            return;
                        }
                    }

                    public volatile void success(Object obj, Response response)
                    {
                        success((LinkAccountsResult)obj, response);
                    }

            
            {
                this$1 = final__pcls4;
                fbToken = String.this;
                super();
            }
                });
            }

            
            {
                this$0 = RetrieveAvatarActivity.this;
                retrieveButton = button;
                skipText = textview;
                bsauthToken = s;
                context = context1;
                super();
            }
        }, Arrays.asList(new String[] {
            "email"
        }));
    }


}
