// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureView

public class PhotoCaptureActivity extends AmazonActivity
{

    private boolean mIsFocusKeyAlreadyPressing;
    private PhotoCaptureView mView;

    public PhotoCaptureActivity()
    {
        mIsFocusKeyAlreadyPressing = false;
    }

    protected void cleanupMyView()
    {
        if (mView != null)
        {
            mView.release();
            mView = null;
        }
    }

    protected PhotoCaptureView createPhotoCaptureView()
    {
        return new PhotoCaptureView(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (27 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            if (mView != null)
            {
                mView.doTakePhoto();
            }
        } else
        if (80 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            if (mView != null && !mIsFocusKeyAlreadyPressing)
            {
                mView.doAutoFocus(false);
                mIsFocusKeyAlreadyPressing = true;
                return true;
            }
        } else
        if (80 == keyevent.getKeyCode() && 1 == keyevent.getAction())
        {
            mIsFocusKeyAlreadyPressing = false;
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
        return true;
    }

    public void handleCancelPhoto()
    {
        cleanupMyView();
        setResult(0);
        finish();
    }

    public void handlePhotoTaken(byte abyte0[], int i)
    {
        cleanupMyView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(3);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            handleCancelPhoto();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onResume()
    {
        super.onResume();
        cleanupMyView();
        mView = createPhotoCaptureView();
        setContentView(mView);
    }

    public boolean onSearchRequested()
    {
        return false;
    }
}
