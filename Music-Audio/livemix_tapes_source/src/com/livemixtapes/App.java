// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.ui.BaseActivity;
import org.acra.ACRA;

// Referenced classes of package com.livemixtapes:
//            CallbackActivity

public class App extends Application
{
    public static abstract class OnLayoutMeasureListener
    {

        private final ViewGroup layout;

        public abstract void onLayoutMeasure();

        public OnLayoutMeasureListener(ViewGroup viewgroup)
        {
            layout = viewgroup;
            viewgroup.setVisibility(4);
            viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(viewgroup. new _cls1());
        }
    }

    public static class ScalableStateListDrawable extends StateListDrawable
    {

        public float bottomLeftRadius;
        public float bottomRightRadius;
        public float radius;
        public float topLeftRadius;
        public float topRightRadius;

        private void scaleGradient(GradientDrawable gradientdrawable)
        {
        }

        protected boolean onStateChange(int ai[])
        {
            ai = Boolean.valueOf(super.onStateChange(ai));
            if (ai.booleanValue())
            {
                scale();
            }
            return ai.booleanValue();
        }

        public void scale()
        {
            Drawable drawable = getCurrent();
            if (drawable instanceof GradientDrawable)
            {
                scaleGradient((GradientDrawable)drawable);
            }
        }

        public ScalableStateListDrawable()
        {
        }
    }


    public static final int AREA;
    public static final float AREA_INCHES;
    public static final float AREA_RATIO;
    public static String DefaultTape;
    public static final int HEIGHT;
    public static final float HEIGHT_INCHES;
    public static final float HEIGHT_RATIO;
    public static final int STANDARD_AREA = 0xd0200;
    public static final float STANDARD_AREA_INCHES = 7.948737F;
    public static final float STANDARD_DPI = 320F;
    public static final int STANDARD_HEIGHT = 1184;
    public static final float STANDARD_HEIGHT_INCHES = 3.605315F;
    public static final int STANDARD_WIDTH = 720;
    public static final float STANDARD_WIDTH_INCHES = 2.204727F;
    public static final float STANDARD_XDPI = 326.571F;
    public static final float STANDARD_YDPI = 328.404F;
    public static final int WIDTH;
    public static final float WIDTH_INCHES;
    public static final float WIDTH_RATIO;
    public static Context context;
    public static int defaultBackground;
    public static Boolean didLoad;
    public static boolean isUnzipping;
    public static long lastUpdateAll;
    public static long lastUpdateToday;
    public static long lastUpdateUnreleased;
    public static long lastUpdateWeek;
    public static final DisplayMetrics metrics;
    public static long top_allCount;
    public static long top_dayCount;
    public static long top_unreleasedCount;
    public static long top_weekCount;
    public static String viewStyle;
    public BaseActivity currentActivity;
    private Tracker mTracker;

    public App()
    {
        currentActivity = null;
    }

    private static String getName(View view)
    {
        String s = (new StringBuilder("anonymous(")).append(view.getId()).append(")").toString();
        try
        {
            view = context.getResources().getResourceEntryName(view.getId());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return s;
        }
        return view;
    }

    public static Boolean inBounds(double d, double d1, double d2)
    {
        if (d >= d1 && d <= d2)
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static void scaleView(View view)
    {
        scaleView(view, WIDTH_RATIO);
    }

    public static void scaleView(View view, float f)
    {
        Object obj = view.getLayoutParams();
        if (((android.view.ViewGroup.LayoutParams) (obj)).width > 0)
        {
            obj.width = (int)((float)((android.view.ViewGroup.LayoutParams) (obj)).width * f);
        }
        if (((android.view.ViewGroup.LayoutParams) (obj)).height > 0)
        {
            obj.height = (int)((float)((android.view.ViewGroup.LayoutParams) (obj)).height * f);
        }
        if (obj instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            obj = (android.view.ViewGroup.MarginLayoutParams)obj;
            obj.topMargin = (int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin * f);
            obj.bottomMargin = (int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin * f);
            obj.leftMargin = (int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin * f);
            obj.rightMargin = (int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin * f);
        }
        view.setPadding((int)((float)view.getPaddingLeft() * f), (int)((float)view.getPaddingTop() * f), (int)((float)view.getPaddingRight() * f), (int)((float)view.getPaddingBottom() * f));
        if (view instanceof TextView)
        {
            view = (TextView)view;
            view.setTextSize(0, view.getTextSize() * f);
            view.setCompoundDrawablePadding((int)((float)view.getCompoundDrawablePadding() * f));
        }
    }

    public static void scaleViewGroup(ViewGroup viewgroup)
    {
        int j = viewgroup.getChildCount();
        scaleView(viewgroup);
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            View view = viewgroup.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                scaleViewGroup((ViewGroup)view);
            } else
            {
                scaleView(viewgroup.getChildAt(i));
            }
            i++;
        } while (true);
    }

    public static void showNotification(String s, ImageView imageview)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f03002c);
        remoteviews.setTextViewText(0x7f0800d1, s);
        ((BitmapDrawable)imageview.getDrawable()).getBitmap();
        (new android.app.Notification.Builder(context)).setContentTitle("LiveMixTapes").setContentText("Please swipe down for more options").setSmallIcon(0x7f02005b).setPriority(-2).setOngoing(true).setContent(remoteviews).build().bigContentView = remoteviews;
        s = new Intent(context, com/livemixtapes/CallbackActivity);
        s.putExtra("which", 1);
        s.setData(Uri.parse(s.toUri(1)));
        s = PendingIntent.getActivity(context, 0, s, 0x8000000);
        imageview = new Intent(context, com/livemixtapes/CallbackActivity);
        imageview.putExtra("which", 2);
        imageview.setData(Uri.parse(imageview.toUri(1)));
        imageview = PendingIntent.getActivity(context, 0, imageview, 0x8000000);
        Object obj = new Intent(context, com/livemixtapes/CallbackActivity);
        ((Intent) (obj)).putExtra("which", 3);
        ((Intent) (obj)).setData(Uri.parse(((Intent) (obj)).toUri(1)));
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
        remoteviews.setOnClickPendingIntent(0x7f0800d3, s);
        remoteviews.setOnClickPendingIntent(0x7f0800d4, imageview);
        remoteviews.setOnClickPendingIntent(0x7f0800d2, ((PendingIntent) (obj)));
        s = (NotificationManager)context.getSystemService("notification");
    }

    public float dpToPx(float f)
    {
        return TypedValue.applyDimension(1, f, metrics);
    }

    public Tracker getDefaultTracker()
    {
        this;
        JVM INSTR monitorenter ;
        Tracker tracker;
        if (mTracker == null)
        {
            mTracker = GoogleAnalytics.getInstance(this).newTracker(0x7f060000);
        }
        tracker = mTracker;
        this;
        JVM INSTR monitorexit ;
        return tracker;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate()
    {
        super.onCreate();
        ACRA.init(this);
        context = getApplicationContext();
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(context.getApplicationInfo().theme, new int[] {
            0x1010031
        });
        defaultBackground = typedarray.getColor(0, 0xff00ff);
        typedarray.recycle();
    }

    public void setCornerRadii(Drawable drawable, float f, float f1, float f2, float f3)
    {
        f = dpToPx(f);
        f1 = dpToPx(f1);
        f2 = dpToPx(f2);
        f3 = dpToPx(f3);
        ((GradientDrawable)drawable).setCornerRadii(new float[] {
            f, f, f1, f1, f2, f2, f3, f3
        });
    }

    public void setCornerRadii(View view, float f, float f1, float f2, float f3)
    {
        setCornerRadii(view.getBackground().mutate(), f, f1, f2, f3);
    }

    public void setCornerRadius(Drawable drawable, float f)
    {
        ((GradientDrawable)drawable).setCornerRadius(dpToPx(f));
    }

    public void setCornerRadius(View view, float f)
    {
        setCornerRadius(view.getBackground().mutate(), f);
    }

    static 
    {
        float f1;
        float f2;
label0:
        {
            lastUpdateAll = 0L;
            lastUpdateToday = 0L;
            lastUpdateWeek = 0L;
            lastUpdateUnreleased = 0L;
            top_weekCount = 0L;
            top_dayCount = 0L;
            top_unreleasedCount = 0L;
            top_allCount = 0L;
            viewStyle = "grid";
            isUnzipping = false;
            didLoad = Boolean.valueOf(false);
            DefaultTape = "{\"mixtape\":{\"id\":\"1\",\"site\":\"main\",\"state\":\"live\",\"date\":\"1970-01-01T04:00:00Z\",\"releasedate\":\"1970-01-01T00:00:00Z\",\"releaseseconds\":0,\"featured\":\"0\",\"title\":\"The Title Stays In Harlem\",\"artist\":\"\",\"DJ\":\"Diplomat Records\",\"score\":\"133\",\"votes\":\"167\",\"views\":\"80240\",\"sharetext\":\"[Mixtape] The Title Stays In Harlem :: #GetItLIVE! http://livemixtap.es/1 @LiveMixtapes\",\"sharecover\":true,\"url\":\"http://www.livemixtapes.com//mixtapes/1/_the_title_stays_in_.html\",\"cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"thumbnail\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"tracks\":[{\"track_id\":\"9\",\"track_number\":\"1\",\"track_title\":\"Intro\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"154\",\"track_duration\":\"154\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/9/jim_jones_intro.html\",\"track_sharetext\":\"[Audio] Jim Jones - Intro http://www.livemixtapes.com/download/mp3/9/jim_jones_intro.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Intro | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/01%20Intro.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/9\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"8\",\"track_number\":\"2\",\"track_title\":\"Get Em Daddy Remix\",\"track_artist\":\"Cam'ron\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"275\",\"track_duration\":\"275\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/8/camron_get_em_daddy.html\",\"track_sharetext\":\"[Audio] Cam'ron - Get Em Daddy Remix http://www.livemixtapes.com/download/mp3/8/camron_get_em_daddy.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam'ron - Get Em Daddy Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/02%20Get%20Em%20Daddy%20Remix.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/8\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"19\",\"track_number\":\"3\",\"track_title\":\"It's Nothing\",\"track_artist\":\"Cam'ron Featuring Juelz Santana\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"246\",\"track_duration\":\"246\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/19/camron_featuring_ju.html\",\"track_sharetext\":\"[Audio] Cam'ron Featuring Juelz Santana - It's Nothing http://www.livemixtapes.com/download/mp3/19/camron_featuring_ju.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam'ron Featuring Juelz Santana - It's Nothing | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/03%20It's%20Nothing%20Featuring%20Juelz%20Sant.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/19\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"17\",\"track_number\":\"4\",\"track_title\":\"Love My Life\",\"track_artist\":\"Cam'ron Featuring Nicole Wray\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"239\",\"track_duration\":\"239\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/17/camron_featuring_ni.html\",\"track_sharetext\":\"[Audio] Cam'ron Featuring Nicole Wray - Love My Life http://www.livemixtapes.com/download/mp3/17/camron_featuring_ni.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam'ron Featuring Nicole Wray - Love My Life | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/04%20Love%20My%20Life%20Featuring%20Nicole%20Wra.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/17\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"20\",\"track_number\":\"5\",\"track_title\":\"Freestyle\",\"track_artist\":\"Hell Rell\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"117\",\"track_duration\":\"117\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/20/hell_rell_freestyle.html\",\"track_sharetext\":\"[Audio] Hell Rell - Freestyle http://www.livemixtapes.com/download/mp3/20/hell_rell_freestyle.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/05%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/20\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"4\",\"track_number\":\"6\",\"track_title\":\"Big Song\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"252\",\"track_duration\":\"252\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/4/jim_jones_big_song.html\",\"track_sharetext\":\"[Audio] Jim Jones - Big Song http://www.livemixtapes.com/download/mp3/4/jim_jones_big_song.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Big Song | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/06%20Big%20Song.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/4\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"18\",\"track_number\":\"7\",\"track_title\":\"Murder Murder\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"90\",\"track_duration\":\"90\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/18/jim_jones_murder_mur.html\",\"track_sharetext\":\"[Audio] Jim Jones - Murder Murder http://www.livemixtapes.com/download/mp3/18/jim_jones_murder_mur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Murder Murder | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/07%20Murder%20Murder.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/18\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"7\",\"track_number\":\"8\",\"track_title\":\"What You Want To Talk About\",\"track_artist\":\"40 Cal Featuring A-Mafia\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"257\",\"track_duration\":\"257\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/7/40_cal_featuring_am.html\",\"track_sharetext\":\"[Audio] 40 Cal Featuring A-Mafia - What You Want To Talk About http://www.livemixtapes.com/download/mp3/7/40_cal_featuring_am.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal Featuring A-Mafia - What You Want To Talk About | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/08%20What%20You%20Want%20To%20Talk%20About%20Featu.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/7\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"2\",\"track_number\":\"9\",\"track_title\":\"Pushin'\",\"track_artist\":\"J.R Writer & 40 Cal.\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"186\",\"track_duration\":\"186\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/2/jr_writer_40_cal.html\",\"track_sharetext\":\"[Audio] J.R Writer & 40 Cal. - Pushin' http://www.livemixtapes.com/download/mp3/2/jr_writer_40_cal.html | @LiveMixtapes\",\"track_radio_sharetext\":\"J.R Writer & 40 Cal. - Pushin' | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/09%20J.R%20Writer%20&%2040%20Cal.%20-%20Pushin'.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/2\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"14\",\"track_number\":\"10\",\"track_title\":\"Best Of Both Hoods\",\"track_artist\":\"Juelz Santana Featuring Young Jeezy\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"205\",\"track_duration\":\"205\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/14/juelz_santana_featur.html\",\"track_sharetext\":\"[Audio] Juelz Santana Featuring Young Jeezy - Best Of Both Hoods http://www.livemixtapes.com/download/mp3/14/juelz_santana_featur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana Featuring Young Jeezy - Best Of Both Hoods | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/10%20Best%20Of%20Both%20Hoods%20Featuring%20Youn.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/14\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"22\",\"track_number\":\"11\",\"track_title\":\"Mesmerized\",\"track_artist\":\"JR Writer Featuring CL Smooth\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"192\",\"track_duration\":\"192\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/22/jr_writer_featuring_.html\",\"track_sharetext\":\"[Audio] JR Writer Featuring CL Smooth - Mesmerized http://www.livemixtapes.com/download/mp3/22/jr_writer_featuring_.html | @LiveMixtapes\",\"track_radio_sharetext\":\"JR Writer Featuring CL Smooth - Mesmerized | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/11%20JR%20Writer%20Featuring%20CL%20Smooth%20-%20M.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/22\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"6\",\"track_number\":\"12\",\"track_title\":\"From Bottom To Top\",\"track_artist\":\"Juelz Santana\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"218\",\"track_duration\":\"218\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/6/juelz_santana_from_b.html\",\"track_sharetext\":\"[Audio] Juelz Santana - From Bottom To Top http://www.livemixtapes.com/download/mp3/6/juelz_santana_from_b.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana - From Bottom To Top | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/12%20From%20Bottom%20To%20Top.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/6\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"12\",\"track_number\":\"13\",\"track_title\":\"Mariah Remix\",\"track_artist\":\"Cam'ron Featuring Juelz & Mariah Carey\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"163\",\"track_duration\":\"163\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/12/camron_featuring_ju.html\",\"track_sharetext\":\"[Audio] Cam'ron Featuring Juelz & Mariah Carey - Mariah Remix http://www.livemixtapes.com/download/mp3/12/camron_featuring_ju.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam'ron Featuring Juelz & Mariah Carey - Mariah Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/13%20Mariah%20Remix%20Featuring%20Juelz%20&%20Ma.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/12\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"15\",\"track_number\":\"14\",\"track_title\":\"I Aint Wit It\",\"track_artist\":\"Jha Jha Featuring Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"178\",\"track_duration\":\"178\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/15/jha_jha_featuring_ji.html\",\"track_sharetext\":\"[Audio] Jha Jha Featuring Jim Jones - I Aint Wit It http://www.livemixtapes.com/download/mp3/15/jha_jha_featuring_ji.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jha Jha Featuring Jim Jones - I Aint Wit It | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/14%20I%20Aint%20Wit%20It%20Featuring%20Jim%20Jones.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/15\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"21\",\"track_number\":\"15\",\"track_title\":\"Dipset The Realist\",\"track_artist\":\"Hell Rell\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"200\",\"track_duration\":\"200\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/21/hell_rell_dipset_the.html\",\"track_sharetext\":\"[Audio] Hell Rell - Dipset The Realist http://www.livemixtapes.com/download/mp3/21/hell_rell_dipset_the.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell - Dipset The Realist | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/15%20Dipset%20The%20Realist.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/21\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"16\",\"track_number\":\"16\",\"track_title\":\"Go Go Go\",\"track_artist\":\"40 Cal Featuring Bezell & Peedi Crack\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"188\",\"track_duration\":\"188\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/16/40_cal_featuring_bez.html\",\"track_sharetext\":\"[Audio] 40 Cal Featuring Bezell & Peedi Crack - Go Go Go http://www.livemixtapes.com/download/mp3/16/40_cal_featuring_bez.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal Featuring Bezell & Peedi Crack - Go Go Go | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/16%20Go%20Go%20Go%20Featuring%20Bezell%20&%20Peedi.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/16\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"5\",\"track_number\":\"17\",\"track_title\":\"Line Of Fire\",\"track_artist\":\"Hell Rell Featuring J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"279\",\"track_duration\":\"279\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/5/hell_rell_featuring_.html\",\"track_sharetext\":\"[Audio] Hell Rell Featuring J.R. Writer - Line Of Fire http://www.livemixtapes.com/download/mp3/5/hell_rell_featuring_.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell Featuring J.R. Writer - Line Of Fire | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/17%20Line%20Of%20Fire%20Featuring%20J.R.%20Write.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/5\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"13\",\"track_number\":\"18\",\"track_title\":\"3 Pots On A Stove\",\"track_artist\":\"Chubby Baby Featuring Hell Rell & J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"252\",\"track_duration\":\"252\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/13/chubby_baby_featurin.html\",\"track_sharetext\":\"[Audio] Chubby Baby Featuring Hell Rell & J.R. Writer - 3 Pots On A Stove http://www.livemixtapes.com/download/mp3/13/chubby_baby_featurin.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Chubby Baby Featuring Hell Rell & J.R. Writer - 3 Pots On A Stove | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/18%203%20Pots%20On%20A%20Stove%20Featuring%20Hell.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/13\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"1\",\"track_number\":\"19\",\"track_title\":\"G's Up Remix\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"277\",\"track_duration\":\"277\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/1/jim_jones_gs_up_rem.html\",\"track_sharetext\":\"[Audio] Jim Jones - G's Up Remix http://www.livemixtapes.com/download/mp3/1/jim_jones_gs_up_rem.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - G's Up Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/19%20G's%20Up%20Remix.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/1\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"23\",\"track_number\":\"20\",\"track_title\":\"Freestyle\",\"track_artist\":\"40 Cal\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"117\",\"track_duration\":\"117\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/23/40_cal_freestyle.html\",\"track_sharetext\":\"[Audio] 40 Cal - Freestyle http://www.livemixtapes.com/download/mp3/23/40_cal_freestyle.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/20%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/23\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"3\",\"track_number\":\"21\",\"track_title\":\"Do Your Thing\",\"track_artist\":\"Cam'ron\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"213\",\"track_duration\":\"213\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/3/camron_do_your_thin.html\",\"track_sharetext\":\"[Audio] Cam'ron - Do Your Thing http://www.livemixtapes.com/download/mp3/3/camron_do_your_thin.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam'ron - Do Your Thing | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/21%20Do%20Your%20Thing.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/3\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"11\",\"track_number\":\"22\",\"track_title\":\"How To Make A Girl Feel\",\"track_artist\":\"Juelz Santana Featuring Tierra Marie\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"100\",\"track_duration\":\"100\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/11/juelz_santana_featur.html\",\"track_sharetext\":\"[Audio] Juelz Santana Featuring Tierra Marie - How To Make A Girl Feel http://www.livemixtapes.com/download/mp3/11/juelz_santana_featur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana Featuring Tierra Marie - How To Make A Girl Feel | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/22%20How%20To%20Make%20A%20Girl%20Feel%20Featuring.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/11\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"10\",\"track_number\":\"23\",\"track_title\":\"Freestyle\",\"track_artist\":\"J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"191\",\"track_duration\":\"191\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/10/jr_writer_freestyl.html\",\"track_sharetext\":\"[Audio] J.R. Writer - Freestyle http://www.livemixtapes.com/download/mp3/10/jr_writer_freestyl.html | @LiveMixtapes\",\"track_radio_sharetext\":\"J.R. Writer - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/23%20JR%20Writer%20-%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/10\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"}]}}";
            metrics = Resources.getSystem().getDisplayMetrics();
            WIDTH = metrics.widthPixels;
            HEIGHT = metrics.heightPixels;
            AREA = WIDTH * HEIGHT;
            float f = metrics.densityDpi;
            f1 = f * 0.1F;
            float f4 = f - f1;
            float f5 = f + f1;
            f2 = metrics.xdpi;
            float f3 = metrics.ydpi;
            if (inBounds(f2, f4, f5).booleanValue())
            {
                f1 = f3;
                if (inBounds(f3, f4, f5).booleanValue())
                {
                    break label0;
                }
            }
            f1 = f;
            f2 = f;
        }
        WIDTH_INCHES = (float)WIDTH / f2;
        HEIGHT_INCHES = (float)HEIGHT / f1;
        AREA_INCHES = WIDTH_INCHES * HEIGHT_INCHES;
        WIDTH_RATIO = WIDTH_INCHES / 2.204727F;
        HEIGHT_RATIO = HEIGHT_INCHES / 3.605315F;
        AREA_RATIO = AREA_INCHES / 7.948737F;
    }

    // Unreferenced inner class com/livemixtapes/App$OnLayoutMeasureListener$1

/* anonymous class */
    class OnLayoutMeasureListener._cls1
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final OnLayoutMeasureListener this$1;
        private final ViewGroup val$layout;

        public void onGlobalLayout()
        {
            layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            onLayoutMeasure();
            layout.post(layout. new Runnable() {

                final OnLayoutMeasureListener._cls1 this$2;
                private final ViewGroup val$layout;

                public void run()
                {
                    layout.setVisibility(0);
                }

            
            {
                this$2 = final__pcls1;
                layout = ViewGroup.this;
                super();
            }
            });
        }

            
            {
                this$1 = final_onlayoutmeasurelistener;
                layout = ViewGroup.this;
                super();
            }
    }

}
