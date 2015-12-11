// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import co.vine.android.StartActivity;
import co.vine.android.api.VineParsers;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.network.HttpResult;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SparseArray;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.service:
//            ResourceService

public class GCMNotificationService extends Service
{
    public class BuildableNotification
    {

        final NotificationEvent event;
        final VineSingleNotification notification;
        final GCMNotificationService this$0;

        public void build()
        {
            buildNotification(notification, event);
        }

        public BuildableNotification(VineSingleNotification vinesinglenotification, NotificationEvent notificationevent)
        {
            this$0 = GCMNotificationService.this;
            super();
            notification = vinesinglenotification;
            event = notificationevent;
        }
    }

    private class GCMNotificationServiceListener extends AppSessionListener
    {

        final GCMNotificationService this$0;

        public void onMergeNotificationComplete(VineSingleNotification vinesinglenotification, ArrayList arraylist)
        {
            NotificationEvent notificationevent;
            if (arraylist != null && !arraylist.isEmpty())
            {
                int i = getNotificationId(vinesinglenotification);
                notificationevent = getNotificationEvent(i);
                if (notificationevent.notificationObjectId > 0L && vinesinglenotification.conversationRowId != notificationevent.notificationObjectId)
                {
                    notificationevent.reset();
                    notificationevent.notificationObjectId = vinesinglenotification.conversationRowId;
                }
                notificationevent.notifications = arraylist;
                if (!vinesinglenotification.isMessaging())
                {
                    break MISSING_BLOCK_LABEL_169;
                }
                try
                {
                    arraylist = new Message();
                    arraylist.what = 101;
                    if (mCameraMessenger != null)
                    {
                        mCameraMessenger.send(arraylist);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (ArrayList arraylist)
                {
                    SLog.e("Failed to send request to camera service.");
                }
                synchronized (mNotificationsToFire)
                {
                    mNotificationsToFire.put(Long.valueOf(vinesinglenotification.conversationRowId), new BuildableNotification(vinesinglenotification, notificationevent));
                }
            }
            return;
            vinesinglenotification;
            arraylist;
            JVM INSTR monitorexit ;
            throw vinesinglenotification;
            buildNotification(vinesinglenotification, notificationevent);
            return;
        }

        public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
        {
            httpresult = new ArrayList();
            Iterator iterator = mQueue.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int i = ((Integer)iterator.next()).intValue();
                NotificationEvent notificationevent = (NotificationEvent)mQueue.get(i);
                if (notificationevent.avatarKey != null && imagekey.equals(notificationevent.avatarKey))
                {
                    notificationevent.avatarKey = null;
                }
                Iterator iterator1 = notificationevent.thumbnailKeys.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    ImageKey imagekey1 = (ImageKey)iterator1.next();
                    if (imagekey.equals(imagekey1))
                    {
                        notificationevent.thumbnailKeys.put(imagekey1, Boolean.valueOf(true));
                    }
                } while (true);
                if (showNotification(notificationevent))
                {
                    httpresult.add(Integer.valueOf(i));
                }
            } while (true);
            mQueue.removeAll(httpresult);
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ArrayList arraylist = new ArrayList();
            if (!hashmap.isEmpty())
            {
                Iterator iterator = mQueue.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    int i = ((Integer)iterator.next()).intValue();
                    NotificationEvent notificationevent = (NotificationEvent)mQueue.get(i);
                    if (notificationevent.avatarKey != null && hashmap.containsKey(notificationevent.avatarKey))
                    {
                        UrlImage urlimage = (UrlImage)hashmap.get(notificationevent.avatarKey);
                        if (urlimage != null && urlimage.isValid())
                        {
                            notificationevent.bm = urlimage.bitmap;
                        }
                        notificationevent.avatarKey = null;
                    }
                    Iterator iterator1 = notificationevent.thumbnailKeys.keySet().iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        ImageKey imagekey = (ImageKey)iterator1.next();
                        if (hashmap.containsKey(imagekey))
                        {
                            notificationevent.thumbnailKeys.put(imagekey, Boolean.valueOf(true));
                        }
                    } while (true);
                    if (showNotification(notificationevent))
                    {
                        arraylist.add(Integer.valueOf(i));
                    }
                } while (true);
            }
            mQueue.removeAll(arraylist);
        }

        public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
        {
            httpresult = new ArrayList();
            Iterator iterator = mQueue.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int i = ((Integer)iterator.next()).intValue();
                NotificationEvent notificationevent = (NotificationEvent)mQueue.get(i);
                Iterator iterator1 = notificationevent.videoKeys.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    VideoKey videokey1 = (VideoKey)iterator1.next();
                    if (videokey.equals(videokey1))
                    {
                        notificationevent.videoKeys.put(videokey1, Boolean.valueOf(true));
                    }
                } while (true);
                if (showNotification(notificationevent))
                {
                    httpresult.add(Integer.valueOf(i));
                }
            } while (true);
            mQueue.removeAll(httpresult);
        }

        public void onVideoPathObtained(HashMap hashmap)
        {
            SLog.d("Video path obtained.");
            ArrayList arraylist = new ArrayList();
            Iterator iterator = mQueue.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int i = ((Integer)iterator.next()).intValue();
                NotificationEvent notificationevent = (NotificationEvent)mQueue.get(i);
                Iterator iterator1 = notificationevent.videoKeys.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    VideoKey videokey = (VideoKey)iterator1.next();
                    if (hashmap.containsKey(videokey))
                    {
                        notificationevent.videoKeys.put(videokey, Boolean.valueOf(true));
                    }
                } while (true);
                if (showNotification(notificationevent))
                {
                    arraylist.add(Integer.valueOf(i));
                }
            } while (true);
            mQueue.removeAll(arraylist);
        }

        private GCMNotificationServiceListener()
        {
            this$0 = GCMNotificationService.this;
            super();
        }

    }

    public static class NotificationEvent
    {

        public ImageKey avatarKey;
        public Bitmap bm;
        public android.support.v4.app.NotificationCompat.Builder builder;
        public final int notificationId;
        public long notificationObjectId;
        public ArrayList notifications;
        public final HashMap thumbnailKeys = new HashMap();
        public final HashMap videoKeys = new HashMap();

        public boolean isReady()
        {
            if (builder == null)
            {
                SLog.d("Builder is not ready, this event has been reset by notification merge.");
                return false;
            }
            if (avatarKey != null)
            {
                SLog.d("Notification not ready because avatar is pending.");
                return false;
            }
            for (Iterator iterator = thumbnailKeys.keySet().iterator(); iterator.hasNext();)
            {
                ImageKey imagekey = (ImageKey)iterator.next();
                if (!((Boolean)thumbnailKeys.get(imagekey)).booleanValue())
                {
                    SLog.d("Notification not ready because thumbnails are pending.");
                    return false;
                }
            }

            for (Iterator iterator1 = videoKeys.keySet().iterator(); iterator1.hasNext();)
            {
                VideoKey videokey = (VideoKey)iterator1.next();
                if (!((Boolean)videoKeys.get(videokey)).booleanValue())
                {
                    SLog.d("Notification not ready because videos are pending.");
                    return false;
                }
            }

            return true;
        }

        public void reset()
        {
            builder = null;
            notifications = null;
            avatarKey = null;
            thumbnailKeys.clear();
            videoKeys.clear();
            bm = null;
        }

        public NotificationEvent(int i)
        {
            notificationId = i;
        }
    }


    public static final String ACTION_CLEAR_NOTIFICATIONS = "co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS";
    public static final String ACTION_SHOW_NOTIFICATION = "co.vine.android.notifications.ACTION_SHOW_NOTIFICATION";
    public static final String ACTION_UPDATE_NOTIFICATIONS = "co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS";
    public static final int ACTIVITY_NOTIFICATION_ID = 1;
    private static final int DELAY_STOP_SERVICE_MS = 2000;
    public static final String EXTRA_AM_FOLLOWING = "am_following";
    public static final String EXTRA_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String EXTRA_NOTIFICATIONS_JSON = "notifications";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_USER_ID = "user_id";
    public static final int MESSAGE_NOTIFICATION_ID = 2;
    private static final String NOTIFICATION_TAG = "gcmGenericNotification";
    private static final String TAG = "GCMNotifService";
    private static final IntentFilter sConversationStateFilter;
    private AppController mAppController;
    private AppSessionListener mAppSessionListener;
    private ServiceConnection mCameraConnection;
    private Messenger mCameraMessenger;
    private final BroadcastReceiver mConversationStateReciver = new BroadcastReceiver() {

        final GCMNotificationService this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = mNotificationsToFire;
            context;
            JVM INSTR monitorenter ;
            SLog.d("Received camera request result: {}.", intent);
            if ("co.vine.android.camera.request.conversation.state.on".equals(intent.getAction()))
            {
                long l = intent.getLongExtra("co.vine.android.camera.request.conversation.state.id", -1L);
                mNotificationsToFire.remove(Long.valueOf(l));
                updateNotification(intent.getIntExtra("notification_id", 2), l);
            }
            for (intent = mNotificationsToFire.values().iterator(); intent.hasNext(); ((BuildableNotification)intent.next()).build()) { }
            break MISSING_BLOCK_LABEL_113;
            intent;
            context;
            JVM INSTR monitorexit ;
            throw intent;
            mNotificationsToFire.clear();
            context;
            JVM INSTR monitorexit ;
        }

            
            {
                this$0 = GCMNotificationService.this;
                super();
            }
    };
    private Handler mHandler;
    private boolean mIsCameraServiceConnected;
    private final HashMap mNotificationsToFire = new HashMap();
    private final SparseArray mQueue = new SparseArray();
    private ArrayList mStartIds;
    final Runnable mStopServiceRunnable = new Runnable() {

        final GCMNotificationService this$0;

        public void run()
        {
            stopService();
        }

            
            {
                this$0 = GCMNotificationService.this;
                super();
            }
    };

    public GCMNotificationService()
    {
        mCameraConnection = new ServiceConnection() {

            final GCMNotificationService this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                mCameraMessenger = new Messenger(ibinder);
                mIsCameraServiceConnected = true;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mCameraMessenger = null;
                mIsCameraServiceConnected = false;
            }

            
            {
                this$0 = GCMNotificationService.this;
                super();
            }
        };
    }

    private void buildNotification(VineSingleNotification vinesinglenotification, NotificationEvent notificationevent)
    {
        notificationevent.builder = new android.support.v4.app.NotificationCompat.Builder(this);
        notificationevent.builder.setAutoCancel(true);
        SLog.d((new StringBuilder()).append("Notification - ").append(notificationevent.notificationId).toString());
        Object obj;
        Intent intent;
        ArrayList arraylist;
        if (notificationevent.notificationId == 1)
        {
            intent = new Intent("co.vine.android.ACTIVITY_NOTIFICATION_PRESSED");
            notificationevent.builder.setContentTitle(vinesinglenotification.comment);
            SLog.d((new StringBuilder()).append("Notification - ").append(vinesinglenotification.comment).toString());
            notificationevent.builder.setSubText(getString(0x7f0e0044));
        } else
        {
            intent = new Intent("co.vine.android.MESSAGE_NOTIFICATION_PRESSED");
        }
        intent.setClass(this, co/vine/android/StartActivity);
        notificationevent.builder.setSmallIcon(0x7f0201ff);
        obj = notificationevent.notifications;
        arraylist = ((ArrayList) (obj));
        if (obj == null)
        {
            arraylist = new ArrayList();
        }
        if (notificationevent.notificationId == 2)
        {
            obj = vinesinglenotification.imageKeys.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ImageKey imagekey = (ImageKey)((Iterator) (obj)).next();
                if (notificationevent.thumbnailKeys.get(imagekey) == null)
                {
                    notificationevent.thumbnailKeys.put(imagekey, Boolean.valueOf(false));
                    if (mAppController.getPhotoBitmap(imagekey) != null)
                    {
                        notificationevent.thumbnailKeys.put(imagekey, Boolean.valueOf(true));
                    }
                }
            } while (true);
            obj = vinesinglenotification.videoKeys.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                VideoKey videokey = (VideoKey)((Iterator) (obj)).next();
                if (notificationevent.videoKeys.get(videokey) == null)
                {
                    notificationevent.videoKeys.put(videokey, Boolean.valueOf(false));
                    if (mAppController.getVideoFilePath(videokey) != null)
                    {
                        notificationevent.videoKeys.put(videokey, Boolean.valueOf(true));
                    }
                }
            } while (true);
            Iterator iterator;
            if (vinesinglenotification.messageCount > 1)
            {
                obj = getString(0x7f0e013f, new Object[] {
                    Util.getUsernameFromActivity(vinesinglenotification.comment), Integer.valueOf(vinesinglenotification.messageCount)
                });
            } else
            {
                obj = Util.stripUsernameEntities(vinesinglenotification.comment);
            }
            notificationevent.builder.setContentTitle(((CharSequence) (obj)));
            SLog.d((new StringBuilder()).append("Notification - ").append(((String) (obj))).toString());
            notificationevent.builder.setSubText(getString(0x7f0e013e));
        }
        if (arraylist.size() > 1)
        {
            android.support.v4.app.NotificationCompat.InboxStyle inboxstyle = new android.support.v4.app.NotificationCompat.InboxStyle();
            if (notificationevent.notificationId == 1)
            {
                inboxstyle.setBigContentTitle(getString(0x7f0e0043));
            } else
            {
                inboxstyle.setBigContentTitle(getString(0x7f0e013d));
            }
            iterator = arraylist.iterator();
            while (iterator.hasNext()) 
            {
                obj = (VineSingleNotification)iterator.next();
                if (notificationevent.notificationId == 2)
                {
                    if (vinesinglenotification.messageCount > 1)
                    {
                        obj = getString(0x7f0e013f, new Object[] {
                            Util.getUsernameFromActivity(((VineSingleNotification) (obj)).comment), Integer.valueOf(((VineSingleNotification) (obj)).messageCount)
                        });
                    } else
                    {
                        obj = getString(0x7f0e0140, new Object[] {
                            Util.getUsernameFromActivity(((VineSingleNotification) (obj)).comment), Integer.valueOf(((VineSingleNotification) (obj)).messageCount)
                        });
                    }
                } else
                {
                    obj = ((VineSingleNotification) (obj)).comment;
                }
                inboxstyle.addLine(((CharSequence) (obj)));
            }
            notificationevent.builder.setStyle(inboxstyle);
            notificationevent.builder.setNumber(arraylist.size());
        }
        int i;
        int j;
        if (notificationevent.notificationId == 2 && arraylist.size() == 1)
        {
            SLog.d("Notification - converstaion.");
            intent.setData(Uri.parse(String.valueOf(vinesinglenotification.conversationRowId)));
            intent.putExtra("username", vinesinglenotification.username);
            intent.putExtra("user_id", vinesinglenotification.userId);
            intent.putExtra("am_following", vinesinglenotification.followStatus);
        } else
        {
            SLog.d((new StringBuilder()).append("Notification - home - ").append(arraylist.size()).toString());
        }
        obj = Util.getDefaultSharedPrefs(this);
        j = 0;
        i = j;
        if (((SharedPreferences) (obj)).getBoolean("pref_notifications_sound", true))
        {
            if (notificationevent.notificationId == 2)
            {
                notificationevent.builder.setSound(Util.getUriFromResouce(this, 0x7f060003));
                i = j;
            } else
            {
                String s = ((SharedPreferences) (obj)).getString("pref_notifications_ringtone", "");
                if (!TextUtils.isEmpty(s))
                {
                    notificationevent.builder.setSound(Uri.parse(s));
                    i = j;
                } else
                {
                    i = false | true;
                }
            }
        }
        j = i;
        if (((SharedPreferences) (obj)).getBoolean("pref_notifications_vibrate", false))
        {
            j = i | 2;
        }
        i = j;
        if (((SharedPreferences) (obj)).getBoolean("pref_notifications_light", true))
        {
            i = j | 4;
        }
        notificationevent.builder.setDefaults(i);
        obj = PendingIntent.getActivity(this, 0, intent, 0);
        notificationevent.builder.setContentIntent(((PendingIntent) (obj)));
        if (vinesinglenotification.avatarUrl != null)
        {
            notificationevent.avatarKey = new ImageKey(vinesinglenotification.avatarUrl, true);
            notificationevent.bm = mAppController.getPhotoBitmap(notificationevent.avatarKey);
        }
        if (notificationevent.bm != null || notificationevent.avatarKey == null)
        {
            notificationevent.avatarKey = null;
            showNotification(notificationevent);
        }
    }

    private void clearNotification(int i)
    {
        ((NotificationManager)getSystemService("notification")).cancel("gcmGenericNotification", i);
        mHandler.postDelayed(mStopServiceRunnable, 2000L);
        mAppController.removeNotification(i, -1L);
    }

    public static Intent getClearNotificationIntent(Context context, int i)
    {
        context = new Intent(context, co/vine/android/service/GCMNotificationService);
        context.setAction("co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS");
        context.putExtra("notification_id", i);
        return context;
    }

    private int getNotificationId(VineSingleNotification vinesinglenotification)
    {
        return !vinesinglenotification.isMessaging() ? 1 : 2;
    }

    public static Intent getUpdateNotificationIntent(Context context, int i, long l)
    {
        context = new Intent(context, co/vine/android/service/GCMNotificationService);
        context.setAction("co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS");
        context.putExtra("notification_id", i);
        context.putExtra("conversation_row_id", l);
        return context;
    }

    private String notificationCommentToString(VineSingleNotification vinesinglenotification)
    {
        Object obj = vinesinglenotification.comment;
        vinesinglenotification = vinesinglenotification.entities;
        obj = new SpannableStringBuilder(((CharSequence) (obj)));
        if (vinesinglenotification != null)
        {
            Util.adjustEntities(vinesinglenotification, ((android.text.Editable) (obj)), 0, true);
        }
        return ((SpannableStringBuilder) (obj)).toString();
    }

    private void prepareNotification(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            VineSingleNotification vinesinglenotification;
            try
            {
                vinesinglenotification = VineParsers.parsePushNotification(VineParsers.createParser(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.logException(s, "Exception while parsing GCM push notification payload.", new Object[0]);
                mHandler.postDelayed(mStopServiceRunnable, 2000L);
                return;
            }
            if (vinesinglenotification == null)
            {
                SLog.dWithTag("GCMNotifService", (new StringBuilder()).append("Invalid GCM notification payload, notifications=").append(s).toString());
                CrashUtil.log("Invalid GCM notification payload.");
                mHandler.postDelayed(mStopServiceRunnable, 2000L);
            } else
            {
                if (!mAppController.isLoggedInReadOnly())
                {
                    SLog.e("User not logged in, we should drop this message.");
                }
                if (vinesinglenotification.isMessaging())
                {
                    mAppController.fetchConversations(1, false, 1);
                }
                if (vinesinglenotification.recipientUserId != mAppController.getActiveId())
                {
                    SLog.e("This message is intended for someone else {}.", Long.valueOf(vinesinglenotification.recipientUserId));
                }
                mAppController.mergePushNotification(vinesinglenotification, notificationCommentToString(vinesinglenotification));
            }
            mAppController.fetchActivityCounts();
        }
    }

    private boolean showNotification(NotificationEvent notificationevent)
    {
        if (notificationevent.isReady())
        {
            if (notificationevent.bm == null)
            {
                notificationevent.bm = BitmapFactory.decodeResource(getResources(), 0x7f020198);
            }
            int i = getResources().getDimensionPixelSize(0x7f0b0060);
            Object obj = Bitmap.createScaledBitmap(notificationevent.bm, i, i, true);
            notificationevent.builder.setLargeIcon(((Bitmap) (obj)));
            obj = (NotificationManager)getSystemService("notification");
            Notification notification = notificationevent.builder.build();
            notification.ledARGB = 0xff00ff00;
            FlurryUtils.traceNotificationShown();
            try
            {
                ((NotificationManager) (obj)).notify("gcmGenericNotification", notificationevent.notificationId, notification);
            }
            // Misplaced declaration of an exception variable
            catch (NotificationEvent notificationevent) { }
            mHandler.postDelayed(mStopServiceRunnable, 2000L);
            return true;
        } else
        {
            return false;
        }
    }

    private void stopService()
    {
        int i;
        for (Iterator iterator = mStartIds.iterator(); iterator.hasNext(); stopSelf(i))
        {
            i = ((Integer)iterator.next()).intValue();
            SLog.dWithTag("GCMNotifService", (new StringBuilder()).append("Stopping service for startId=").append(i).toString());
        }

    }

    private void updateNotification(int i, long l)
    {
        mAppController.removeNotification(i, l);
    }

    public NotificationEvent getNotificationEvent(int i)
    {
        NotificationEvent notificationevent1 = (NotificationEvent)mQueue.get(i);
        NotificationEvent notificationevent = notificationevent1;
        if (notificationevent1 == null)
        {
            notificationevent = new NotificationEvent(i);
            mQueue.put(i, notificationevent);
        }
        return notificationevent;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        SLog.dWithTag("GCMNotifService", "Service created.");
        mAppController = AppController.getInstance(this);
        mAppSessionListener = new GCMNotificationServiceListener();
        mAppController.addListener(mAppSessionListener);
        mStartIds = new ArrayList();
        mHandler = new Handler();
        registerReceiver(mConversationStateReciver, sConversationStateFilter, "co.vine.android.BROADCAST", null);
        bindService(new Intent(this, co/vine/android/service/ResourceService), mCameraConnection, 1);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mIsCameraServiceConnected)
        {
            unbindService(mCameraConnection);
        }
        unregisterReceiver(mConversationStateReciver);
        if (mAppSessionListener != null)
        {
            mAppController.removeListener(mAppSessionListener);
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        String s;
label0:
        {
            SLog.dWithTag("GCMNotifService", (new StringBuilder()).append("onStartCommand, startId=").append(j).append(", startIds=").append(mStartIds.toString()).toString());
            mStartIds.add(Integer.valueOf(j));
            mHandler.removeCallbacksAndMessages(null);
            if (intent != null)
            {
                s = intent.getAction();
                if (s != null)
                {
                    break label0;
                }
                stopService();
            }
            return 2;
        }
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 124
    //                   -1511558645: 173
    //                   -1225821196: 188
    //                   302383572: 158;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_188;
_L5:
        switch (i)
        {
        default:
            stopService();
            return 2;

        case 0: // '\0'
            clearNotification(intent.getIntExtra("notification_id", 1));
            return 2;

        case 1: // '\001'
            prepareNotification(intent.getStringExtra("notifications"));
            return 2;

        case 2: // '\002'
            updateNotification(intent.getIntExtra("notification_id", 2), intent.getLongExtra("conversation_row_id", -1L));
            break;
        }
        break MISSING_BLOCK_LABEL_248;
_L4:
        if (s.equals("co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS"))
        {
            i = 0;
        }
          goto _L5
_L2:
        if (s.equals("co.vine.android.notifications.ACTION_SHOW_NOTIFICATION"))
        {
            i = 1;
        }
          goto _L5
        if (s.equals("co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS"))
        {
            i = 2;
        }
          goto _L5
        return 2;
    }

    static 
    {
        sConversationStateFilter = new IntentFilter();
        sConversationStateFilter.addAction("co.vine.android.camera.request.conversation.state.on");
        sConversationStateFilter.addAction("co.vine.android.camera.request.conversation.state.off");
    }



/*
    static Messenger access$002(GCMNotificationService gcmnotificationservice, Messenger messenger)
    {
        gcmnotificationservice.mCameraMessenger = messenger;
        return messenger;
    }

*/


/*
    static boolean access$102(GCMNotificationService gcmnotificationservice, boolean flag)
    {
        gcmnotificationservice.mIsCameraServiceConnected = flag;
        return flag;
    }

*/







}
