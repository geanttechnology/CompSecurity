// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;

// Referenced classes of package com.picsart.filters:
//            b

public class FilterActivity extends AdBaseActivity
{

    private static int a = 0;

    public FilterActivity()
    {
    }

    public static ByteBuffer a(int i)
    {
        a++;
        return ImageOpCommon.allocNativeBuffer(i);
    }

    public static void a(ByteBuffer bytebuffer)
    {
        a--;
        ImageOpCommon.freeNativeBuffer(bytebuffer);
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030023);
        if (bundle == null)
        {
            a = 0;
        }
        b.a(this, 0x7f100144, getIntent()).setRetainInstance(true);
        initAd();
    }

}
