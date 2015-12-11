// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.internal.ds;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, a

private final class mUri extends ResultReceiver
{

    private final Uri mUri;
    private final ArrayList oj = new ArrayList();
    boolean ok;
    final ImageManager ol;

    static ArrayList a(mUri muri)
    {
        return muri.oj;
    }

    public void bB()
    {
        Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
        intent.putExtra("com.google.android.gms.extras.uri", mUri);
        intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
        intent.putExtra("com.google.android.gms.extras.priority", 3);
        ImageManager.a(ol).sendBroadcast(intent);
    }

    public void c(a a1)
    {
        boolean flag;
        if (!ok)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ds.a(flag, "Cannot add an ImageRequest when mHandlingRequests is true");
        ds.N("ImageReceiver.addImageRequest() must be called in the main thread");
        oj.add(a1);
    }

    public void d(a a1)
    {
        boolean flag;
        if (!ok)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ds.a(flag, "Cannot remove an ImageRequest when mHandlingRequests is true");
        ds.N("ImageReceiver.removeImageRequest() must be called in the main thread");
        oj.remove(a1);
    }

    public void onReceiveResult(int i, Bundle bundle)
    {
        bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
        ImageManager.d(ol).execute(new ol(ol, mUri, bundle));
    }

    (ImageManager imagemanager, Uri uri)
    {
        ol = imagemanager;
        super(new Handler(Looper.getMainLooper()));
        ok = false;
        mUri = uri;
    }
}
