// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b.a.a.b.a;
import b.a.a.b.b;
import b.a.a.b.c;
import com.target.mothership.util.o;
import com.target.ui.e.i;
import com.target.ui.e.j;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.ai;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseScanFragment extends BaseNavigationFragment
    implements b.a.a.b.c.a
{
    protected class a extends c
    {

        final BaseScanFragment this$0;

        public void onPreviewFrame(byte abyte0[], Camera camera)
        {
            if (abyte0 == null)
            {
                if (!com.target.ui.fragment.scan.BaseScanFragment.c(BaseScanFragment.this))
                {
                    com.target.ui.fragment.scan.BaseScanFragment.a(BaseScanFragment.this, true);
                    ai.a(getActivity(), 0x7f0903e1);
                }
                return;
            } else
            {
                com.target.ui.fragment.scan.BaseScanFragment.a(BaseScanFragment.this, false);
                super.onPreviewFrame(abyte0, camera);
                return;
            }
        }

        public a(Context context)
        {
            this$0 = BaseScanFragment.this;
            super(context);
        }
    }


    private static final int STOP_CAMERA_DELAY = 1000;
    private MenuItem mFlashOffMenuItem;
    private MenuItem mFlashOnMenuItem;
    private boolean mNoData;
    private a mScannerView;
    private j mVlcManagerWrapperProvider;

    public BaseScanFragment()
    {
    }

    static a a(BaseScanFragment basescanfragment)
    {
        return basescanfragment.mScannerView;
    }

    static boolean a(BaseScanFragment basescanfragment, boolean flag)
    {
        basescanfragment.mNoData = flag;
        return flag;
    }

    static j b(BaseScanFragment basescanfragment)
    {
        return basescanfragment.mVlcManagerWrapperProvider;
    }

    static boolean c(BaseScanFragment basescanfragment)
    {
        return basescanfragment.mNoData;
    }

    protected void a()
    {
        mVlcManagerWrapperProvider.o().f();
        mScannerView.setResultHandler(this);
        mScannerView.b();
        mScannerView.setFlash(false);
        mScannerView.setAutoFocus(true);
    }

    public void a(b b1)
    {
        if (b1 == null || o.e(b1.a()))
        {
            a("");
            return;
        } else
        {
            a(b1.a());
            return;
        }
    }

    protected abstract void a(String s);

    protected transient void a(b.a.a.b.a aa[])
    {
        ArrayList arraylist = new ArrayList();
        int l = aa.length;
        for (int k = 0; k < l; k++)
        {
            arraylist.add(aa[k]);
        }

        mScannerView.setFormats(arraylist);
    }

    protected View b()
    {
        return mScannerView;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            mVlcManagerWrapperProvider = (j)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new ClassCastException("Activity must implement VlcManagerWrapperProvider");
        }
        mScannerView = new a(getActivity());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            menuinflater.inflate(0x7f120016, menu);
            mFlashOnMenuItem = menu.findItem(0x7f100613);
            mFlashOffMenuItem = menu.findItem(0x7f100614);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756563: 
            mFlashOnMenuItem.setVisible(false);
            mFlashOffMenuItem.setVisible(true);
            mScannerView.setFlash(true);
            return true;

        case 2131756564: 
            mFlashOffMenuItem.setVisible(false);
            break;
        }
        mFlashOnMenuItem.setVisible(true);
        mScannerView.setFlash(false);
        return true;
    }

    public void onPause()
    {
        super.onPause();
        mScannerView.setResultHandler(null);
        (new Handler()).postDelayed(new Runnable() {

            final BaseScanFragment this$0;

            public void run()
            {
                com.target.ui.fragment.scan.BaseScanFragment.a(BaseScanFragment.this).c();
                com.target.ui.fragment.scan.BaseScanFragment.b(BaseScanFragment.this).o().e();
            }

            
            {
                this$0 = BaseScanFragment.this;
                super();
            }
        }, 1000L);
    }

    public void onResume()
    {
        super.onResume();
        a();
    }
}
