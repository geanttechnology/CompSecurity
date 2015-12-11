// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EulaDialog extends AmazonAlertDialog
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener
{

    private final ScrollView mEulaScroller;
    private final AmazonActivity mMShopActivity;

    public EulaDialog(AmazonActivity amazonactivity)
    {
        Object obj1;
        Object obj3;
        super(amazonactivity);
        mMShopActivity = amazonactivity;
        obj1 = null;
        obj3 = null;
        Object obj = new BufferedReader(new InputStreamReader(amazonactivity.getResources().openRawResource(com.amazon.mShop.android.lib.R.raw.eula)));
        obj1 = new StringBuilder();
_L3:
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj1)).append(s).append('\n');
          goto _L3
        Object obj2;
        obj2;
_L7:
        obj1 = obj;
        ((IOException) (obj2)).printStackTrace();
        obj2 = "";
        obj1 = obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        ((BufferedReader) (obj)).close();
        obj1 = obj2;
_L4:
        mEulaScroller = (ScrollView)LayoutInflater.from(amazonactivity).inflate(com.amazon.mShop.android.lib.R.layout.eula, null);
        ((TextView)mEulaScroller.findViewById(com.amazon.mShop.android.lib.R.id.eula_text)).setText(((CharSequence) (obj1)));
        setTitle(com.amazon.mShop.android.lib.R.string.eula_title);
        setCancelable(true);
        setButton(-1, amazonactivity.getText(com.amazon.mShop.android.lib.R.string.eula_accept), this);
        setButton(-2, amazonactivity.getText(com.amazon.mShop.android.lib.R.string.eula_dont_accept), this);
        setOnCancelListener(this);
        setView(mEulaScroller, 0, 0, 0, 0);
        setCanceledOnTouchOutside(true);
        return;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
          goto _L4
        amazonactivity;
_L5:
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw amazonactivity;
        obj;
        obj1 = obj2;
          goto _L4
        amazonactivity;
        obj1 = obj;
          goto _L5
        obj2;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean mustShowEula(AmazonActivity amazonactivity)
    {
        while (!ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_hasEula) || amazonactivity.getString(com.amazon.mShop.android.lib.R.string.eula_version).equals(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("acceptedEulaVersion"))) 
        {
            return false;
        }
        return true;
    }

    private void onAccepted()
    {
        String s = mMShopActivity.getString(com.amazon.mShop.android.lib.R.string.eula_version);
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("acceptedEulaVersion", s);
        mMShopActivity.onEulaAccepted();
    }

    private void onRefused()
    {
        mMShopActivity.finish();
    }

    public static void showEulaIfNeeded(AmazonActivity amazonactivity)
    {
        if (mustShowEula(amazonactivity))
        {
            (new EulaDialog(amazonactivity)).show();
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        onRefused();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (-1 == i)
        {
            onAccepted();
            return;
        } else
        {
            onRefused();
            return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (mEulaScroller.executeKeyEvent(keyevent))
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (mEulaScroller.executeKeyEvent(keyevent))
        {
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void show()
    {
        super.show();
        Button button = getButton(-2);
        if (button != null)
        {
            button.setFocusableInTouchMode(true);
            button.requestFocus();
        }
    }
}
