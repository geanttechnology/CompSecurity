// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.async.BlockingProgressDialog;
import com.amazon.gallery.foundation.utils.async.CancellableBlockingProgressDialog;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.gallery.view.multiselect.MultiSelectKind;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.ParentalControl;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction, PrepareMediaItemsHelper, PostShareAction

public abstract class AbstractShareAction extends MediaItemAction
{
    static final class CommonSharedActivity extends Enum
    {

        private static final CommonSharedActivity $VALUES[];
        public static final CommonSharedActivity Email;
        public static final CommonSharedActivity Facebook;
        public static final CommonSharedActivity Twitter;
        private String packageName;

        public static CommonSharedActivity valueOf(String s)
        {
            return (CommonSharedActivity)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/AbstractShareAction$CommonSharedActivity, s);
        }

        public static CommonSharedActivity[] values()
        {
            return (CommonSharedActivity[])$VALUES.clone();
        }

        static 
        {
            Email = new CommonSharedActivity("Email", 0, "com.android.email.activity.MessageCompose");
            Facebook = new CommonSharedActivity("Facebook", 1, "com.amazon.unifiedshare.facebook.FacebookShareActivity");
            Twitter = new CommonSharedActivity("Twitter", 2, "com.amazon.unifiedshare.twitter.TwitterShareActivity");
            $VALUES = (new CommonSharedActivity[] {
                Email, Facebook, Twitter
            });
        }


        private CommonSharedActivity(String s, int i, String s1)
        {
            super(s, i);
            packageName = s1;
        }
    }

    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent ShareClicked;
        public static final MetricsEvent ShareFile;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/AbstractShareAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            ShareClicked = new MetricsEvent("ShareClicked", 0);
            ShareFile = new MetricsEvent("ShareFile", 1);
            $VALUES = (new MetricsEvent[] {
                ShareClicked, ShareFile
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/actions/AbstractShareAction.getName();
    private final ParentalControl parentalControl;
    private PostShareAction postShareAction;
    protected final PrepareMediaItemsHelper prepareHelper;
    private Profiler profiler;

    public AbstractShareAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, int i, ShareStore sharestore, RestClient restclient, Profiler profiler1)
    {
        super(activity, networkconnectivity, photosdemomanager, i);
        profiler = profiler1;
        prepareHelper = new PrepareMediaItemsHelper(activity, NetworkExecutor.getInstance(), restclient, sharestore);
        parentalControl = (ParentalControl)((BeanAwareApplication)activity.getApplication()).getBeanFactory().getBean(Keys.PARENTAL_CONTROL);
    }

    private String getCustomerMetricSuffix(int i, int j)
    {
        return (new StringBuilder()).append(";Photos:").append(i).append(";Videos:").append(j).toString();
    }

    private String getShortSharedActivityName(String s)
    {
        String s1;
        if (s.equals(CommonSharedActivity.Email.packageName))
        {
            s1 = CommonSharedActivity.Email.name();
        } else
        {
            if (s.equals(CommonSharedActivity.Facebook.packageName))
            {
                return CommonSharedActivity.Facebook.name();
            }
            s1 = s;
            if (s.equals(CommonSharedActivity.Twitter.packageName))
            {
                return CommonSharedActivity.Twitter.name();
            }
        }
        return s1;
    }

    public boolean canExecute(List list)
    {
        EnumSet enumset;
        Iterator iterator;
        enumset = EnumSet.noneOf(com/amazon/gallery/framework/gallery/view/multiselect/MultiSelectKind);
        iterator = list.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        MediaItem mediaitem = (MediaItem)iterator.next();
        if (mediaitem != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()])
        {
        case 1: // '\001'
            enumset.add(MultiSelectKind.PHOTO);
            break;

        case 2: // '\002'
            if (MediaItemUtil.isLocalMediaItem(mediaitem))
            {
                enumset.add(MultiSelectKind.LOCAL_VIDEO);
            } else
            {
                enumset.add(MultiSelectKind.CLOUD_VIDEO);
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (enumset.size() != 1 || enumset.contains(MultiSelectKind.CLOUD_VIDEO) && list.size() != 1) goto _L3; else goto _L5
_L5:
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void execute(List list)
    {
        if (photosDemoManager.isInDemoMode())
        {
            photosDemoManager.showWarningForUnavailableAction(context);
            return;
        }
        if (parentalControl.isSocialNetworkingBlocked(context))
        {
            parentalControl.promptSocialNetworkingBlocked(context);
            return;
        } else
        {
            super.execute(list);
            prepareItemsToShare(getShareIntent(list), list);
            return;
        }
    }

    protected String getMIMEType(List list)
    {
        Object obj;
        MediaType mediatype;
        HashSet hashset;
        Iterator iterator;
        obj = null;
        mediatype = null;
        hashset = new HashSet();
        iterator = list.iterator();
_L2:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_232;
        }
        list = (MediaItem)iterator.next();
        if (mediatype != null && list.getType() != mediatype)
        {
            DebugAssert.assertMsg("Can't share with mixed mime types");
        }
        mediatype = list.getType();
        switch (_cls2..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediatype.ordinal()])
        {
        default:
            DebugAssert.assertMsg((new StringBuilder()).append("Not supported type: ").append(mediatype).toString());
            list = ((List) (obj));
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_190;
        }
_L3:
        obj = list;
        if (hashset.size() > 1)
        {
            return list;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (GroupType.LENTICULAR.equals(list.getGroupType()))
        {
            list = "image/gif";
        } else
        {
            obj = list.getMIMEType();
            list = ((List) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                list = "image/*";
            }
            hashset.add(list);
        }
          goto _L3
        if (MediaItemUtil.isCloudMediaItem(list))
        {
            hashset.add("text/plain");
            list = "text/plain";
        } else
        {
            hashset.add(list.getMIMEType());
            list = "video/*";
        }
          goto _L3
        if (hashset.size() == 1)
        {
            obj = (String)hashset.toArray()[0];
        }
        list = ((List) (obj));
        if (obj == null)
        {
            DebugAssert.assertMsg("Need at least one item to find mime type");
            list = "image/*";
        }
        return list;
    }

    protected Intent getShareIntent(List list)
    {
        Intent intent = new Intent();
        if (list.size() > 1)
        {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
        } else
        {
            intent.setAction("android.intent.action.SEND");
        }
        intent.setType(getMIMEType(list));
        return intent;
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void prepareItemsToShare(Intent intent, List list)
    {
        String s = context.getString(0x7f0e015b);
        String s1 = context.getString(0x7f0e015a);
        MediaItem mediaitem = (MediaItem)list.get(0);
        if (mediaitem.getType() == MediaType.VIDEO && MediaItemUtil.isCloudMediaItem(mediaitem) && networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            intent = new CancellableBlockingProgressDialog(list, intent) {

                final AbstractShareAction this$0;
                final Intent val$shareIntent;
                final List val$shareList;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((MediaItem[])aobj);
                }

                protected transient Void doInBackground(MediaItem amediaitem[])
                {
                    prepareHelper.setProgressNotifier(new PrepareMediaItemsHelper.ProgressNotifier() {

                        final _cls1 this$1;

                        public void update(int i, int j)
                        {
                            publishProgress(new Integer[] {
                                Integer.valueOf(i)
                            });
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    amediaitem = amediaitem[0];
                    if (amediaitem.getType() != MediaType.VIDEO || !MediaItemUtil.isCloudMediaItem(amediaitem)) goto _L2; else goto _L1
_L1:
                    prepareHelper.setUriPreference(PrepareMediaItemsHelper.UriPreference.CLOUD);
                    amediaitem = prepareHelper.prepareItems(shareList);
                    if (!amediaitem.isEmpty())
                    {
                        shareIntent.putExtra("android.intent.extra.TEXT", ((Uri)amediaitem.get(0)).toString());
                    }
_L4:
                    return null;
_L2:
                    prepareHelper.setUriPreference(PrepareMediaItemsHelper.UriPreference.FILE);
                    amediaitem = prepareHelper.prepareItems(shareList);
                    if (amediaitem.size() == 1)
                    {
                        shareIntent.putExtra("android.intent.extra.STREAM", (Parcelable)amediaitem.get(0));
                    } else
                    if (!amediaitem.isEmpty())
                    {
                        shareIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", amediaitem);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    if (!shareIntent.hasExtra("android.intent.extra.STREAM") && !shareIntent.hasExtra("android.intent.extra.TEXT"))
                    {
                        break MISSING_BLOCK_LABEL_121;
                    }
                    GlobalMessagingBus.post(new ActionCompleteEvent());
                    startActivity(shareIntent);
                    if (postShareAction != null)
                    {
                        postShareAction.onShareSuccess();
                    }
                    trackEvent(shareList);
_L2:
                    return;
                    void1;
                    GLogger.w(AbstractShareAction.TAG, "Target activity not found, do nothing", new Object[0]);
                    if (postShareAction == null) goto _L2; else goto _L1
_L1:
                    postShareAction.onShareFailed(void1);
                    return;
                    GLogger.e(AbstractShareAction.TAG, "Tried to share, but intent didn't fire.", new Object[0]);
                    return;
                }


            
            {
                this$0 = AbstractShareAction.this;
                shareList = list;
                shareIntent = intent;
                super(final_context, final_i);
            }
            };
            intent.setDialogTitle(s);
            intent.setDialogMessage(s1);
            intent.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list.toArray(new MediaItem[0]));
            return;
        }
    }

    public void recordOnActionMetrics(List list)
    {
        if (actionSource == MediaItemAction.ActionSource.SINGLE_VIEW_HAB)
        {
            profiler.trackEvent(getClass().getSimpleName(), MetricsEvent.ShareClicked.toString(), ClickstreamEventHelper.createClickstreamExtra("ActionEvent", HitType.APP_ACTION));
        }
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPShareAction;
            profiler.trackEvent(getClass().getSimpleName(), list.toString(), CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }

    public void setPostShareAction(PostShareAction postshareaction)
    {
        postShareAction = postshareaction;
    }

    protected void startActivity(Intent intent)
    {
        context.startActivity(intent);
    }

    protected void trackEvent(List list)
    {
        MediaItem mediaitem;
        for (list = list.iterator(); list.hasNext(); profiler.trackEvent(getClass().getSimpleName(), MetricsEvent.ShareFile.toString(), CustomerMetricsHelper.getExtra(mediaitem)))
        {
            mediaitem = (MediaItem)list.next();
        }

    }

    protected void trackEvent(List list, String s)
    {
        int j = 0;
        int i = 0;
        list = list.iterator();
        do
        {
            if (list.hasNext())
            {
                MediaItem mediaitem = (MediaItem)list.next();
                if (mediaitem == null)
                {
                    GLogger.e(TAG, "Item from share list is null", new Object[0]);
                    return;
                }
                switch (_cls2..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()])
                {
                case 1: // '\001'
                    j++;
                    break;

                case 2: // '\002'
                    i++;
                    break;
                }
            } else
            {
                profiler.trackEvent(getClass().getSimpleName(), MetricsEvent.ShareFile.toString(), CustomerMetricsHelper.getExtraEventTag((new StringBuilder()).append(getShortSharedActivityName(s)).append(getCustomerMetricSuffix(j, i)).toString()));
                return;
            }
        } while (true);
    }



}
