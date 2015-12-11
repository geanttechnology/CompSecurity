// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItPhotoPreviewActivity, SnapItPhotoCaptureActivity

public class SnapItActivity extends AmazonActivity
{

    private static byte sLastPhotoCaptured[];
    private static int sLastknownOrientation;

    public SnapItActivity()
    {
    }

    static void clearLastPhotoCaptured()
    {
        sLastPhotoCaptured = null;
        sLastknownOrientation = -1;
    }

    static int getLastKnownOrientation()
    {
        return sLastknownOrientation;
    }

    static byte[] getLastPhotoCapturedOriginal()
    {
        return sLastPhotoCaptured;
    }

    static void setLastPhotoCaptured(byte abyte0[])
    {
        sLastPhotoCaptured = abyte0;
    }

    static void setLastPhotoCaptured(byte abyte0[], int i)
    {
        sLastPhotoCaptured = abyte0;
        sLastknownOrientation = i;
    }

    private void startPreview()
    {
        startActivityForResult(new Intent(this, com/amazon/mShop/search/image/SnapItPhotoPreviewActivity), 12);
    }

    private void startSnapItCapture()
    {
        startActivityForResult(new Intent(this, com/amazon/mShop/search/image/SnapItPhotoCaptureActivity), 11);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (11 == i && 1001 == j)
        {
            startPreview();
        } else
        {
            if (11 == i && j == 0)
            {
                setResult(0);
                clearLastPhotoCaptured();
                finish();
                return;
            }
            if (12 == i)
            {
                if (1002 == j)
                {
                    clearLastPhotoCaptured();
                    startSnapItCapture();
                    return;
                }
                if (1003 == j)
                {
                    setResult(1003);
                    finish();
                    return;
                } else
                {
                    clearLastPhotoCaptured();
                    setResult(0);
                    finish();
                    return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        startSnapItCapture();
    }

    protected void onStart()
    {
        super.onStart();
    }
}
