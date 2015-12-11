// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            UploadsAdapter

private class retry
{

    public ImageView retry;
    public TextView status;
    final UploadsAdapter this$0;
    public ImageView thumbnail;

    public (View view)
    {
        this$0 = UploadsAdapter.this;
        super();
        thumbnail = (ImageView)view.findViewById(0x7f0a0065);
        status = (TextView)view.findViewById(0x7f0a0228);
        retry = (ImageView)view.findViewById(0x7f0a0229);
    }
}
