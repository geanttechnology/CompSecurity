// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.CroppableImageView;

// Referenced classes of package co.vine.android:
//            CropActivity

public class EditProfileCropActivity extends CropActivity
{

    private Button mSaveButton;

    public EditProfileCropActivity()
    {
    }

    protected void onBitmapProcessingDone(Bitmap bitmap)
    {
        super.onBitmapProcessingDone(bitmap);
        mSaveButton.setEnabled(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030032);
        mSaveButton = (Button)findViewById(0x7f0a00c9);
        mSaveButton.setEnabled(false);
        mView.setCropType(2);
        ViewUtil.reduceTextSizeViaFontScaleIfNeeded(this, 1.1F, 12F, new TextView[] {
            (TextView)findViewById(0x7f0a00c9), (TextView)findViewById(0x7f0a00c8)
        });
        setupActionBar(null, Boolean.valueOf(true), 0x7f0e00a5, null);
    }
}
