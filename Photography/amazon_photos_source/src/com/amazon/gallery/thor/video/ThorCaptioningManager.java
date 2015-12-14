// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.video;

import android.content.Context;
import android.media.MediaFormat;
import android.view.accessibility.CaptioningManager;
import android.widget.VideoView;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.video.captioning.GalleryCaptioningManager;
import com.amazon.gallery.framework.gallery.video.captioning.SubtitleFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;

public class ThorCaptioningManager
    implements GalleryCaptioningManager
{

    private static final String TAG = com/amazon/gallery/thor/video/ThorCaptioningManager.getName();
    private final Context applicationContext;

    public ThorCaptioningManager(Context context)
    {
        applicationContext = context;
    }

    private Locale getLocale()
    {
        Locale locale = ((CaptioningManager)applicationContext.getSystemService("captioning")).getLocale();
        if (locale != null)
        {
            return locale;
        } else
        {
            return Locale.ENGLISH;
        }
    }

    private String getSubtitlePath(String s, SubtitleFormat subtitleformat)
    {
        if (s.indexOf(".") > 0)
        {
            s = s.substring(0, s.lastIndexOf("."));
            return (new StringBuilder()).append(s).append(subtitleformat.getExtension()).toString();
        } else
        {
            GLogger.e(TAG, "Invalid local video file name: %s", new Object[] {
                s
            });
            return null;
        }
    }

    public void setSubtitleSource(VideoView videoview, String s)
    {
        if (Api.isAtLeastKitkat())
        {
            SubtitleFormat subtitleformat = SubtitleFormat.VTT;
            s = getSubtitlePath(s, subtitleformat);
            if (s != null)
            {
                s = new File(s);
                if (s.exists())
                {
                    try
                    {
                        videoview.addSubtitleSource(new FileInputStream(s), MediaFormat.createSubtitleFormat(subtitleformat.getMimeType(), getLocale().getLanguage()));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (VideoView videoview)
                    {
                        GLogger.ex(TAG, "Fail to read subtitle", videoview);
                    }
                    return;
                }
            }
        }
    }

}
