// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.graphics.Bitmap;
import android.media.RemoteControlClient;
import android.os.Bundle;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompatApi14

public class MediaSessionCompatApi19
{

    private static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    private static final String METADATA_KEY_ART = "android.media.metadata.ART";
    private static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    private static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";

    public MediaSessionCompatApi19()
    {
    }

    static void addNewMetadata(Bundle bundle, android.media.RemoteControlClient.MetadataEditor metadataeditor)
    {
        if (bundle.containsKey("android.media.metadata.RATING"))
        {
            metadataeditor.putObject(101, bundle.getParcelable("android.media.metadata.RATING"));
        }
        if (bundle.containsKey("android.media.metadata.USER_RATING"))
        {
            metadataeditor.putObject(0x10000001, bundle.getParcelable("android.media.metadata.USER_RATING"));
        }
        if (bundle.containsKey("android.media.metadata.ART"))
        {
            metadataeditor.putBitmap(100, (Bitmap)bundle.getParcelable("android.media.metadata.ART"));
        } else
        if (bundle.containsKey("android.media.metadata.ALBUM_ART"))
        {
            metadataeditor.putBitmap(100, (Bitmap)bundle.getParcelable("android.media.metadata.ALBUM_ART"));
            return;
        }
    }

    public static Object createMetadataUpdateListener(MediaSessionCompatApi14.Callback callback)
    {
        return new OnMetadataUpdateListener(callback);
    }

    public static void setMetadata(Object obj, Bundle bundle, boolean flag)
    {
        obj = ((RemoteControlClient)obj).editMetadata(true);
        MediaSessionCompatApi14.buildOldMetadata(bundle, ((android.media.RemoteControlClient.MetadataEditor) (obj)));
        addNewMetadata(bundle, ((android.media.RemoteControlClient.MetadataEditor) (obj)));
        if (flag && android.os.Build.VERSION.SDK_INT > 19)
        {
            ((android.media.RemoteControlClient.MetadataEditor) (obj)).addEditableKey(0x10000001);
        }
        ((android.media.RemoteControlClient.MetadataEditor) (obj)).apply();
    }

    public static void setOnMetadataUpdateListener(Object obj, Object obj1)
    {
        ((RemoteControlClient)obj).setMetadataUpdateListener((android.media.RemoteControlClient.OnMetadataUpdateListener)obj1);
    }

    private class OnMetadataUpdateListener
        implements android.media.RemoteControlClient.OnMetadataUpdateListener
    {

        protected final MediaSessionCompatApi14.Callback mCallback;

        public void onMetadataUpdate(int i, Object obj)
        {
            if (i == 0x10000001 && (obj instanceof Rating))
            {
                mCallback.onSetRating(obj);
            }
        }

        public OnMetadataUpdateListener(MediaSessionCompatApi14.Callback callback)
        {
            mCallback = callback;
        }
    }

}
