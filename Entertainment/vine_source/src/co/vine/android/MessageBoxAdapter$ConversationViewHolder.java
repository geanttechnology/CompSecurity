// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android:
//            MessageBoxAdapter

private class loadMoreProgress
{

    public ImageKey avatarUrl;
    public int color;
    public View divider;
    public ImageView failedUpload;
    public ImageView image;
    public FrameLayout loadMore;
    public View loadMoreContent;
    public View loadMoreProgress;
    public View retryProgress;
    public TextView tapToRetry;
    final MessageBoxAdapter this$0;
    public TextView timestamp;
    public TextView unreadCount;
    public TextView username;

    public (View view)
    {
        this$0 = MessageBoxAdapter.this;
        super();
        failedUpload = (ImageView)view.findViewById(0x7f0a010a);
        image = (ImageView)view.findViewById(0x7f0a0105);
        timestamp = (TextView)view.findViewById(0x7f0a007b);
        username = (TextView)view.findViewById(0x7f0a0107);
        unreadCount = (TextView)view.findViewById(0x7f0a0109);
        loadMore = (FrameLayout)view.findViewById(0x7f0a010c);
        divider = view.findViewById(0x7f0a0060);
        tapToRetry = (TextView)view.findViewById(0x7f0a0108);
        retryProgress = view.findViewById(0x7f0a010b);
        loadMoreContent = view.findViewById(0x7f0a010d);
        loadMoreProgress = view.findViewById(0x7f0a00b2);
    }
}
