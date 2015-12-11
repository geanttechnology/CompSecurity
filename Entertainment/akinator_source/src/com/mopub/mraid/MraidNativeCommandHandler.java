// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.mopub.common.HttpClient;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.network.HeaderUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.mopub.mraid:
//            MraidCommandException

public class MraidNativeCommandHandler
{
    private static class DownloadImageAsyncTask extends AsyncTask
    {

        private final Context mContext;
        private final DownloadImageAsyncTaskListener mListener;

        private String getFileNameForUriAndHttpResponse(URI uri, HttpResponse httpresponse)
        {
            uri = uri.getPath();
            if (uri != null) goto _L2; else goto _L1
_L1:
            uri = null;
_L4:
            return uri;
_L2:
            String s;
            int i;
            int j;
            s = (new File(uri)).getName();
            httpresponse = httpresponse.getFirstHeader("Content-Type");
            uri = s;
            if (httpresponse == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            httpresponse = httpresponse.getValue().split(";");
            j = httpresponse.length;
            i = 0;
_L5:
            uri = s;
            if (i < j)
            {
label0:
                {
                    uri = httpresponse[i];
                    if (!uri.contains("image/"))
                    {
                        break label0;
                    }
                    httpresponse = (new StringBuilder()).append(".").append(uri.split("/")[1]).toString();
                    uri = s;
                    if (!s.endsWith(httpresponse))
                    {
                        return (new StringBuilder()).append(s).append(httpresponse).toString();
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            i++;
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        private File getPictureStoragePath()
        {
            return new File(Environment.getExternalStorageDirectory(), "Pictures");
        }

        private void loadPictureIntoGalleryApp(String s)
        {
            s = new MoPubMediaScannerConnectionClient(s, null);
            MediaScannerConnection mediascannerconnection = new MediaScannerConnection(mContext, s);
            s.setMediaScannerConnection(mediascannerconnection);
            mediascannerconnection.connect();
        }

        protected Boolean doInBackground(String as[])
        {
            Object obj;
            String as1[];
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            File file;
            Object obj6;
            org.apache.http.client.methods.HttpGet httpget;
            boolean flag;
            if (as.length > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag);
            Preconditions.checkNotNull(as[0]);
            file = getPictureStoragePath();
            file.mkdirs();
            obj2 = URI.create(as[0]);
            obj6 = HttpClientFactory.create();
            httpget = HttpClient.initializeHttpGet(((URI) (obj2)).toString());
            obj5 = null;
            as = null;
            obj4 = null;
            obj3 = null;
            as1 = as;
            obj = obj5;
            obj1 = obj4;
            obj6 = ((org.apache.http.client.HttpClient) (obj6)).execute(httpget);
            as1 = as;
            obj = obj5;
            obj1 = obj4;
            as = ((HttpResponse) (obj6)).getEntity().getContent();
            as1 = as;
            obj = as;
            obj1 = obj4;
            obj5 = HeaderUtils.extractHeader(((HttpResponse) (obj6)), ResponseHeader.LOCATION);
            if (obj5 == null)
            {
                break MISSING_BLOCK_LABEL_145;
            }
            as1 = as;
            obj = as;
            obj1 = obj4;
            obj2 = URI.create(((String) (obj5)));
            as1 = as;
            obj = as;
            obj1 = obj4;
            obj5 = new File(file, getFileNameForUriAndHttpResponse(((URI) (obj2)), ((HttpResponse) (obj6))));
            as1 = as;
            obj = as;
            obj1 = obj4;
            obj2 = new FileOutputStream(((File) (obj5)));
            Streams.copyContent(as, ((java.io.OutputStream) (obj2)));
            loadPictureIntoGalleryApp(((File) (obj5)).toString());
            Streams.closeStream(as);
            Streams.closeStream(((java.io.Closeable) (obj2)));
            return Boolean.valueOf(true);
            as;
            obj = obj3;
            as = as1;
_L4:
            Streams.closeStream(as);
            Streams.closeStream(((java.io.Closeable) (obj)));
            return Boolean.valueOf(false);
            Exception exception;
            exception;
            as = ((String []) (obj));
_L2:
            Streams.closeStream(as);
            Streams.closeStream(((java.io.Closeable) (obj1)));
            throw exception;
            exception;
            obj1 = obj2;
            if (true) goto _L2; else goto _L1
_L1:
            IOException ioexception;
            ioexception;
            ioexception = ((IOException) (obj2));
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
            if (boolean1 != null && boolean1.booleanValue())
            {
                mListener.onSuccess();
                return;
            } else
            {
                mListener.onFailure();
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        public DownloadImageAsyncTask(Context context, DownloadImageAsyncTaskListener downloadimageasynctasklistener)
        {
            mContext = context.getApplicationContext();
            mListener = downloadimageasynctasklistener;
        }
    }

    static interface DownloadImageAsyncTask.DownloadImageAsyncTaskListener
    {

        public abstract void onFailure();

        public abstract void onSuccess();
    }

    private static class MoPubMediaScannerConnectionClient
        implements android.media.MediaScannerConnection.MediaScannerConnectionClient
    {

        private final String mFilename;
        private MediaScannerConnection mMediaScannerConnection;
        private final String mMimeType;

        private void setMediaScannerConnection(MediaScannerConnection mediascannerconnection)
        {
            mMediaScannerConnection = mediascannerconnection;
        }

        public void onMediaScannerConnected()
        {
            if (mMediaScannerConnection != null)
            {
                mMediaScannerConnection.scanFile(mFilename, mMimeType);
            }
        }

        public void onScanCompleted(String s, Uri uri)
        {
            if (mMediaScannerConnection != null)
            {
                mMediaScannerConnection.disconnect();
            }
        }


        private MoPubMediaScannerConnectionClient(String s, String s1)
        {
            mFilename = s;
            mMimeType = s1;
        }

    }

    static interface MraidCommandFailureListener
    {

        public abstract void onFailure(MraidCommandException mraidcommandexception);
    }


    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";
    private static final String DATE_FORMATS[] = {
        "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"
    };
    private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
    static final String MIME_TYPE_HEADER = "Content-Type";

    public MraidNativeCommandHandler()
    {
    }

    private String dayNumberToDayOfMonthString(int i)
        throws IllegalArgumentException
    {
        if (i != 0 && i >= -31 && i <= 31)
        {
            return (new StringBuilder()).append("").append(i).toString();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid day of month ").append(i).toString());
        }
    }

    private String dayNumberToDayOfWeekString(int i)
        throws IllegalArgumentException
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("invalid day of week ").append(i).toString());

        case 0: // '\0'
            return "SU";

        case 1: // '\001'
            return "MO";

        case 2: // '\002'
            return "TU";

        case 3: // '\003'
            return "WE";

        case 4: // '\004'
            return "TH";

        case 5: // '\005'
            return "FR";

        case 6: // '\006'
            return "SA";
        }
    }

    static boolean isCalendarAvailable(Context context)
    {
        Intent intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Intents.deviceCanHandleIntent(context, intent);
    }

    public static boolean isStorePictureSupported(Context context)
    {
        return "mounted".equals(Environment.getExternalStorageState()) && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private Date parseDate(String s)
    {
        Object obj;
        String as[];
        int i;
        int j;
        obj = null;
        as = DATE_FORMATS;
        j = as.length;
        i = 0;
_L2:
        Object obj1;
        obj1 = obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj1 = as[i];
        obj1 = (new SimpleDateFormat(((String) (obj1)), Locale.US)).parse(s);
        obj = obj1;
        obj1 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj1 = obj;
        return ((Date) (obj1));
        obj1;
        obj1 = obj;
        i++;
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String parseRecurrenceRule(Map map)
        throws IllegalArgumentException
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!map.containsKey("frequency")) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        s = (String)map.get("frequency");
        i = -1;
        if (map.containsKey("interval"))
        {
            i = Integer.parseInt((String)map.get("interval"));
        }
        if (!"daily".equals(s)) goto _L4; else goto _L3
_L3:
        stringbuilder.append("FREQ=DAILY;");
        if (i != -1)
        {
            stringbuilder.append((new StringBuilder()).append("INTERVAL=").append(i).append(";").toString());
        }
_L2:
        return stringbuilder.toString();
_L4:
        if ("weekly".equals(s))
        {
            stringbuilder.append("FREQ=WEEKLY;");
            if (i != -1)
            {
                stringbuilder.append((new StringBuilder()).append("INTERVAL=").append(i).append(";").toString());
            }
            if (map.containsKey("daysInWeek"))
            {
                map = translateWeekIntegersToDays((String)map.get("daysInWeek"));
                if (map == null)
                {
                    throw new IllegalArgumentException("invalid ");
                }
                stringbuilder.append((new StringBuilder()).append("BYDAY=").append(map).append(";").toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!"monthly".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append("FREQ=MONTHLY;");
        if (i != -1)
        {
            stringbuilder.append((new StringBuilder()).append("INTERVAL=").append(i).append(";").toString());
        }
        if (map.containsKey("daysInMonth"))
        {
            map = translateMonthIntegersToDays((String)map.get("daysInMonth"));
            if (map == null)
            {
                throw new IllegalArgumentException();
            }
            stringbuilder.append((new StringBuilder()).append("BYMONTHDAY=").append(map).append(";").toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
    }

    private void showUserDialog(final Context context, final String imageUrl, final MraidCommandFailureListener failureListener)
    {
        (new android.app.AlertDialog.Builder(context)).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new android.content.DialogInterface.OnClickListener() {

            final MraidNativeCommandHandler this$0;
            final Context val$context;
            final MraidCommandFailureListener val$failureListener;
            final String val$imageUrl;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                downloadImage(context, imageUrl, failureListener);
            }

            
            {
                this$0 = MraidNativeCommandHandler.this;
                context = context1;
                imageUrl = s;
                failureListener = mraidcommandfailurelistener;
                super();
            }
        }).setCancelable(true).show();
    }

    private Map translateJSParamsToAndroidCalendarEventMapping(Map map)
    {
        HashMap hashmap = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start"))
        {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        hashmap.put("title", map.get("description"));
        if (map.containsKey("start") && map.get("start") != null)
        {
            Date date = parseDate((String)map.get("start"));
            if (date != null)
            {
                hashmap.put("beginTime", Long.valueOf(date.getTime()));
                if (map.containsKey("end") && map.get("end") != null)
                {
                    Date date1 = parseDate((String)map.get("end"));
                    if (date1 == null)
                    {
                        break MISSING_BLOCK_LABEL_338;
                    }
                    hashmap.put("endTime", Long.valueOf(date1.getTime()));
                }
                if (map.containsKey("location"))
                {
                    hashmap.put("eventLocation", map.get("location"));
                }
                if (map.containsKey("summary"))
                {
                    hashmap.put("description", map.get("summary"));
                }
                if (map.containsKey("transparency"))
                {
                    int i;
                    if (((String)map.get("transparency")).equals("transparent"))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    hashmap.put("availability", Integer.valueOf(i));
                }
                hashmap.put("rrule", parseRecurrenceRule(map));
                return hashmap;
            } else
            {
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
        } else
        {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
    }

    private String translateMonthIntegersToDays(String s)
        throws IllegalArgumentException
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean aflag[] = new boolean[63];
        s = s.split(",");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            int k = Integer.parseInt(s[i]);
            if (!aflag[k + 31])
            {
                stringbuilder.append((new StringBuilder()).append(dayNumberToDayOfMonthString(k)).append(",").toString());
                aflag[k + 31] = true;
            }
        }

        if (s.length == 0)
        {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        } else
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
            return stringbuilder.toString();
        }
    }

    private String translateWeekIntegersToDays(String s)
        throws IllegalArgumentException
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean aflag[] = new boolean[7];
        s = s.split(",");
        int l = s.length;
        for (int i = 0; i < l; i++)
        {
            int k = Integer.parseInt(s[i]);
            int j = k;
            if (k == 7)
            {
                j = 0;
            }
            if (!aflag[j])
            {
                stringbuilder.append((new StringBuilder()).append(dayNumberToDayOfWeekString(j)).append(",").toString());
                aflag[j] = true;
            }
        }

        if (s.length == 0)
        {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        } else
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
            return stringbuilder.toString();
        }
    }

    void createCalendarEvent(Context context, Map map)
        throws MraidCommandException
    {
        if (!isCalendarAvailable(context))
        {
            break MISSING_BLOCK_LABEL_224;
        }
        Intent intent;
        Iterator iterator;
        map = translateJSParamsToAndroidCalendarEventMapping(map);
        intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        iterator = map.keySet().iterator();
_L3:
        String s;
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        s = (String)iterator.next();
        obj = map.get(s);
        if (!(obj instanceof Long)) goto _L2; else goto _L1
_L1:
        intent.putExtra(s, ((Long)obj).longValue());
          goto _L3
_L2:
label0:
        {
            if (!(obj instanceof Integer))
            {
                break label0;
            }
            intent.putExtra(s, ((Integer)obj).intValue());
        }
          goto _L3
        try
        {
            intent.putExtra(s, (String)obj);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("no calendar app installed");
            throw new MraidCommandException("Action is unsupported on this device - no calendar app installed");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d((new StringBuilder()).append("create calendar: invalid parameters ").append(context.getMessage()).toString());
            throw new MraidCommandException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("could not create calendar event");
            throw new MraidCommandException(context);
        }
          goto _L3
        intent.setFlags(0x10000000);
        context.startActivity(intent);
        return;
        MoPubLog.d("unsupported action createCalendarEvent for devices pre-ICS");
        throw new MraidCommandException("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    void downloadImage(final Context context, String s, final MraidCommandFailureListener failureListener)
    {
        AsyncTasks.safeExecuteOnExecutor(new DownloadImageAsyncTask(context, new DownloadImageAsyncTask.DownloadImageAsyncTaskListener() {

            final MraidNativeCommandHandler this$0;
            final Context val$context;
            final MraidCommandFailureListener val$failureListener;

            public void onFailure()
            {
                Toast.makeText(context, "Image failed to download.", 0).show();
                MoPubLog.d("Error downloading and saving image file.");
                failureListener.onFailure(new MraidCommandException("Error downloading and saving image file."));
            }

            public void onSuccess()
            {
                MoPubLog.d("Image successfully saved.");
            }

            
            {
                this$0 = MraidNativeCommandHandler.this;
                context = context1;
                failureListener = mraidcommandfailurelistener;
                super();
            }
        }), new String[] {
            s
        });
    }

    boolean isInlineVideoAvailable(Activity activity, View view)
    {
        if (!VersionCode.currentApiLevel().isBelow(VersionCode.HONEYCOMB_MR1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        do
        {
            if (view.isHardwareAccelerated() && !Utils.bitMaskContainsFlag(view.getLayerType(), 1))
            {
label0:
                {
                    if (view.getParent() instanceof View)
                    {
                        break label0;
                    }
                    activity = activity.getWindow();
                    if (activity != null && Utils.bitMaskContainsFlag(activity.getAttributes().flags, 0x1000000))
                    {
                        return true;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            view = (View)view.getParent();
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    boolean isSmsAvailable(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    boolean isTelAvailable(Context context)
    {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    void storePicture(Context context, String s, MraidCommandFailureListener mraidcommandfailurelistener)
        throws MraidCommandException
    {
        if (!isStorePictureSupported(context))
        {
            MoPubLog.d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            throw new MraidCommandException("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
        }
        if (context instanceof Activity)
        {
            showUserDialog(context, s, mraidcommandfailurelistener);
            return;
        } else
        {
            Toast.makeText(context, "Downloading image to Picture gallery...", 0).show();
            downloadImage(context, s, mraidcommandfailurelistener);
            return;
        }
    }

}
