// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItActivity, SnapItPhotoPreviewView

public class SnapItPhotoPreviewActivity extends AmazonActivity
{

    private SnapItPhotoPreviewView view;

    public SnapItPhotoPreviewActivity()
    {
    }

    public byte[] getLastCapturedPhoto()
    {
        return SnapItActivity.getLastPhotoCapturedOriginal();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    protected void onStart()
    {
        super.onStart();
        view = new SnapItPhotoPreviewView(this);
        super.setRootView(view, false);
    }

    public void retakePhoto()
    {
        setResult(1002);
        finish();
    }

    public void usePhoto()
    {
        setResult(1003);
        finish();
    }
}
