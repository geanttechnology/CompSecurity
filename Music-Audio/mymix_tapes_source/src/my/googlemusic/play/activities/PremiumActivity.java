// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.PrintStream;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.premium.google.IabHelper;
import my.googlemusic.play.utils.premium.google.IabResult;
import my.googlemusic.play.utils.premium.google.Purchase;
import my.googlemusic.play.utils.premium.google.SecurityKey;
import my.googlemusic.play.utils.toast.ToastCreator;

public class PremiumActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private static class ViewHolder
    {

        AppBar appBar;
        Button buy;

        private ViewHolder()
        {
        }

    }


    public static final String ITEM_SKU = "mymixtapezrenewauto15";
    public static final String KEY_DEVELOPER = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkCey22BSZfedKg1H8kUpzbPzx+MRJFvv1vs32o+1+FlZB0Xp1M77M05Tu8Ds0UR6SielCHWcAy1ScB9uErKisFiznyreWUYBhUnPBCz6061RrjLkRxbcEkM9/LR6BFSj+UjSlHaSMmhUXhxvzWpCzf5G19Uk5KiMj/+gOUxoO/+04QWx6EgdiTPogfbxMcar4BLO4lvBi+tw03VdWBZ6W2KZajQEXkx8kENbfl2wVWEB6v5XHpIFYQ5vDv0eMQZv6jaHl7iwYAJp2xMYzYa82pQNzEfnTX47SZnjueC9wTmDKRtexfagARRbcEVAvOLbZPnb7mXXcKapyHJDehMq6wIDAQAB";
    private static final int RC_REQUEST = 10005;
    private IabHelper mHelper;
    private ViewHolder mHolder;
    private String mPass;
    my.googlemusic.play.utils.premium.google.IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener;
    private Server mServer;
    private boolean mTest;
    private User mUser;

    public PremiumActivity()
    {
        mPurchaseFinishedListener = new my.googlemusic.play.utils.premium.google.IabHelper.OnIabPurchaseFinishedListener() {

            final PremiumActivity this$0;

            public void onIabPurchaseFinished(IabResult iabresult, Purchase purchase)
            {
                if (mHelper == null)
                {
                    return;
                }
                if (iabresult.isFailure())
                {
                    complain((new StringBuilder()).append("Error purchasing: ").append(iabresult).toString());
                    setWaitScreen(true);
                    return;
                } else
                {
                    complain("Upgrading to Premium Mixtapez...");
                    updatePremiumTask();
                    return;
                }
            }

            
            {
                this$0 = PremiumActivity.this;
                super();
            }
        };
    }

    private void complain(String s)
    {
        Toast.makeText(this, s, 0).show();
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mUser = mServer.getUser();
        mHolder = new ViewHolder();
        mHolder.buy = (Button)findViewById(0x7f0d011b);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Get premium").back();
        if (mUser.isPremium())
        {
            setWaitScreen(false);
            return;
        } else
        {
            mHolder.buy.setOnClickListener(this);
            return;
        }
    }

    private void onPremiumPassSent()
    {
        if (mServer.getUser() != null)
        {
            mServer.upgradePremium(mServer.getUser().getId(), new my.googlemusic.play.interfaces.Server.Callback() {

                final PremiumActivity this$0;

                public void onFailure(Response response)
                {
                    onPremiumPassSent();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    finish();
                }

            
            {
                this$0 = PremiumActivity.this;
                super();
            }
            });
        }
    }

    private void setWaitScreen(boolean flag)
    {
        mHolder.buy.setEnabled(flag);
    }

    private void testKeyServer()
    {
        mServer.getPremiumPass(new my.googlemusic.play.interfaces.Server.Callback() {

            final PremiumActivity this$0;

            public void onFailure(Response response)
            {
                System.out.println((new StringBuilder()).append("fail get - ").append(response).toString());
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                System.out.println((new StringBuilder()).append("get - ").append(obj).toString());
                mPass = (String)obj;
                mPass = SecurityKey.convertKey(mPass);
                System.out.println((new StringBuilder()).append("convert to - ").append(mPass).toString());
            /* block-local class not found */
            class _cls1 {}

                mServer.sendPremiumPass(mPass, new _cls1());
            }

            
            {
                this$0 = PremiumActivity.this;
                super();
            }
        });
    }

    private void updatePremiumTask()
    {
        mServer.sendPremiumPass(mPass, new my.googlemusic.play.interfaces.Server.Callback() {

            final PremiumActivity this$0;

            public void onFailure(Response response)
            {
                my.googlemusic.play.utils.toast.Toast.with(PremiumActivity.this).message(response.toString()).show();
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                my.googlemusic.play.utils.toast.Toast.with(PremiumActivity.this).message((String)obj).show();
                onPremiumPassSent();
            }

            
            {
                this$0 = PremiumActivity.this;
                super();
            }
        });
    }

    public void buyPremiumSubscription()
    {
        if (!mHelper.subscriptionsSupported())
        {
            complain("Subscriptions not supported on your device yet. Sorry!");
            return;
        } else
        {
            String s = mUser.getEmail();
            setWaitScreen(false);
            mHelper.launchPurchaseFlow(this, "mymixtapezrenewauto15", "subs", 10005, mPurchaseFinishedListener, s);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        while (mHelper == null || mHelper.handleActivityResult(i, j, intent)) 
        {
            return;
        }
        super.onActivityResult(i, j, intent);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onClick(View view)
    {
label0:
        {
            if (view == mHolder.buy)
            {
                if (!mUser.isSkip())
                {
                    break label0;
                }
                (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            }
            return;
        }
        if (mTest)
        {
            testKeyServer();
            return;
        } else
        {
            mServer.getPremiumPass(new my.googlemusic.play.interfaces.Server.Callback() {

                final PremiumActivity this$0;

                public void onFailure(Response response)
                {
                    my.googlemusic.play.utils.toast.Toast.with(PremiumActivity.this).message(response.toString()).show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    mPass = (String)obj;
                    mPass = SecurityKey.convertKey(mPass);
                    mHelper = new IabHelper(PremiumActivity.this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkCey22BSZfedKg1H8kUpzbPzx+MRJFvv1vs32o+1+FlZB0Xp1M77M05Tu8Ds0UR6SielCHWcAy1ScB9uErKisFiznyreWUYBhUnPBCz6061RrjLkRxbcEkM9/LR6BFSj+UjSlHaSMmhUXhxvzWpCzf5G19Uk5KiMj/+gOUxoO/+04QWx6EgdiTPogfbxMcar4BLO4lvBi+tw03VdWBZ6W2KZajQEXkx8kENbfl2wVWEB6v5XHpIFYQ5vDv0eMQZv6jaHl7iwYAJp2xMYzYa82pQNzEfnTX47SZnjueC9wTmDKRtexfagARRbcEVAvOLbZPnb7mXXcKapyHJDehMq6wIDAQAB");
                    mHelper.enableDebugLogging(false);
                /* block-local class not found */
                class _cls1 {}

                    mHelper.startSetup(new _cls1());
                }

            
            {
                this$0 = PremiumActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030031);
        initData();
        initView();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mHelper != null)
        {
            mHelper.dispose();
            mHelper = null;
        }
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

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        onBackPressed();
        if (true) goto _L1; else goto _L3
_L3:
    }



/*
    static IabHelper access$102(PremiumActivity premiumactivity, IabHelper iabhelper)
    {
        premiumactivity.mHelper = iabhelper;
        return iabhelper;
    }

*/







/*
    static String access$602(PremiumActivity premiumactivity, String s)
    {
        premiumactivity.mPass = s;
        return s;
    }

*/

}
