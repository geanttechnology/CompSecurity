// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils
{

    private static final String KEY_CONTENT_TYPE = "content-type";
    private static final String KEY_CUSTOM_DATA = "custom-data";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_URL = "movie-urls";

    public Utils()
    {
    }

    public static boolean checkGooglePlaySevices(Activity activity)
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        switch (i)
        {
        default:
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(i, activity, 0);
            dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(activity) {

                final Activity val$activity;

                public void onCancel(DialogInterface dialoginterface)
                {
                    activity.finish();
                }

            
            {
                activity = activity1;
                super();
            }
            });
            dialog.show();
            return false;

        case 0: // '\0'
            return true;
        }
    }

    public static String formatMillis(int i)
    {
        String s = "";
        int j = i / 0x36ee80;
        int k = i % 0x36ee80;
        i = k / 60000;
        k = (k % 60000) / 1000;
        if (j > 0)
        {
            s = (new StringBuilder()).append("").append(j).append(":").toString();
        }
        String s1 = s;
        if (i >= 0)
        {
            if (i > 9)
            {
                s1 = (new StringBuilder()).append(s).append(i).append(":").toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append("0").append(i).append(":").toString();
            }
        }
        if (k > 9)
        {
            return (new StringBuilder()).append(s1).append(k).toString();
        } else
        {
            return (new StringBuilder()).append(s1).append("0").append(k).toString();
        }
    }

    public static Bundle fromMediaInfo(MediaInfo mediainfo)
    {
        if (mediainfo == null)
        {
            mediainfo = null;
        } else
        {
            Object obj = mediainfo.getMetadata();
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.cast.metadata.TITLE", ((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.TITLE"));
            bundle.putString("com.google.android.gms.cast.metadata.SUBTITLE", ((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.SUBTITLE"));
            bundle.putString("movie-urls", mediainfo.getContentId());
            bundle.putString("com.google.android.gms.cast.metadata.STUDIO", ((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.STUDIO"));
            bundle.putString("content-type", mediainfo.getContentType());
            if (mediainfo.getCustomData() != null)
            {
                bundle.putString("custom-data", mediainfo.getCustomData().toString());
            }
            mediainfo = bundle;
            if (((MediaMetadata) (obj)).getImages() != null)
            {
                mediainfo = new ArrayList();
                for (obj = ((MediaMetadata) (obj)).getImages().iterator(); ((Iterator) (obj)).hasNext(); mediainfo.add(((WebImage)((Iterator) (obj)).next()).getUrl().toString())) { }
                bundle.putStringArrayList("images", mediainfo);
                return bundle;
            }
        }
        return mediainfo;
    }

    public static boolean getBooleanFromPreference(Context context, String s, boolean flag)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(s, flag);
    }

    public static float getFloatFromPreference(Context context, String s)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(s, 1.401298E-45F);
    }

    public static String getImageUrl(MediaInfo mediainfo, int i)
    {
        mediainfo = mediainfo.getMetadata();
        if (mediainfo != null && mediainfo.getImages() != null && mediainfo.getImages().size() > i)
        {
            return ((WebImage)mediainfo.getImages().get(i)).getUrl().toString();
        } else
        {
            return null;
        }
    }

    public static String getStringFromPreference(Context context, String s)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(s, null);
    }

    public static void saveFloatToPreference(Context context, String s, float f)
    {
        context = PreferenceManager.getDefaultSharedPreferences(context);
        if (1.401298E-45F == f)
        {
            context.edit().remove(s).apply();
            return;
        } else
        {
            context.edit().putFloat(s, f).apply();
            return;
        }
    }

    public static void saveStringToPreference(Context context, String s, String s1)
    {
        context = PreferenceManager.getDefaultSharedPreferences(context);
        if (s1 == null)
        {
            context.edit().remove(s).apply();
            return;
        } else
        {
            context.edit().putString(s, s1).apply();
            return;
        }
    }

    public static final void showErrorDialog(Context context, int i)
    {
        if ((context instanceof Activity) && ((Activity)context).isFinishing())
        {
            return;
        } else
        {
            (new android.app.AlertDialog.Builder(context)).setTitle(com.google.sample.castcompanionlibrary.R.string.error).setMessage(context.getString(i)).setPositiveButton(com.google.sample.castcompanionlibrary.R.string.ok, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.cancel();
                }

            }).create().show();
            return;
        }
    }

    public static MediaInfo toMediaInfo(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        MediaMetadata mediametadata = new MediaMetadata(1);
        mediametadata.putString("com.google.android.gms.cast.metadata.SUBTITLE", bundle.getString("com.google.android.gms.cast.metadata.SUBTITLE"));
        mediametadata.putString("com.google.android.gms.cast.metadata.TITLE", bundle.getString("com.google.android.gms.cast.metadata.TITLE"));
        mediametadata.putString("com.google.android.gms.cast.metadata.STUDIO", bundle.getString("com.google.android.gms.cast.metadata.STUDIO"));
        Object obj = bundle.getStringArrayList("images");
        if (obj != null && !((ArrayList) (obj)).isEmpty())
        {
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mediametadata.addImage(new WebImage(Uri.parse((String)((Iterator) (obj)).next())))) { }
        }
        Object obj1 = null;
        String s = bundle.getString("custom-data");
        obj = obj1;
        if (s != null)
        {
            try
            {
                obj = new JSONObject(s);
            }
            catch (JSONException jsonexception)
            {
                jsonexception = obj1;
            }
        }
        return (new com.google.android.gms.cast.MediaInfo.Builder(bundle.getString("movie-urls"))).setStreamType(1).setContentType(bundle.getString("content-type")).setMetadata(mediametadata).setCustomData(((JSONObject) (obj))).build();
    }
}
