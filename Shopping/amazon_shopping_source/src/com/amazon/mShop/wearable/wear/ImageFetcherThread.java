// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.MShopIOUtils;
import com.amazon.mShop.wearable.wear.shared.StampedMessage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Wearable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

public class ImageFetcherThread extends HandlerThread
{

    private static final com.amazon.mShop.util.ImageUtil.StyleCodePattern WEAR_STYLE_CODE_CROP = new com.amazon.mShop.util.ImageUtil.StyleCodePattern("AC");
    private static final com.amazon.mShop.util.ImageUtil.StyleCodePattern WEAR_STYLE_CODE_SIZE = new com.amazon.mShop.util.ImageUtil.StyleCodePattern("SR");
    private final GoogleApiClient mGoogleApiClient;
    private final Handler mHandler = new Handler(getLooper());

    public ImageFetcherThread(GoogleApiClient googleapiclient)
    {
        super("RetailImageFetcherThread");
        start();
        mGoogleApiClient = googleapiclient;
    }

    private void syncImage(String s, String s1)
    {
        try
        {
            String s2 = ImageUtil.getImageUrl(s1);
            s1 = ImageUtil.getImageId(s2);
            s2 = WEAR_STYLE_CODE_SIZE.appendTo(s2, "300,160");
            byte abyte0[] = MShopIOUtils.getByteArray(((HttpURLConnection)(new URL(WEAR_STYLE_CODE_CROP.appendTo(s2))).openConnection()).getInputStream());
            if (!mGoogleApiClient.isConnected())
            {
                mGoogleApiClient.blockingConnect();
            }
            abyte0 = MShopWearListenerService.toBytes(new StampedMessage(null, abyte0));
            Wearable.MessageApi.sendMessage(mGoogleApiClient, s, (new StringBuilder()).append("/image/").append(s1).toString(), abyte0).await();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WearImageFetcherThread", "IOException thrown while fetching image", s);
        }
    }

    public void fetchImage(final String node, final String imageUrl)
    {
        Log.d("WearImageFetcherThread", String.format("Fetching image for url: %s", new Object[] {
            imageUrl
        }));
        mHandler.post(new Runnable() {

            final ImageFetcherThread this$0;
            final String val$imageUrl;
            final String val$node;

            public void run()
            {
                syncImage(node, imageUrl);
            }

            
            {
                this$0 = ImageFetcherThread.this;
                node = s;
                imageUrl = s1;
                super();
            }
        });
    }


}
