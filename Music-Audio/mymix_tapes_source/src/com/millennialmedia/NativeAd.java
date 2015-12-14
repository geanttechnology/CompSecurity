// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.millennialmedia.internal.AdPlacement;
import com.millennialmedia.internal.AdPlacementMetadata;
import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.ErrorStatus;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.PlayList;
import com.millennialmedia.internal.adadapters.NativeAdapter;
import com.millennialmedia.internal.playlistserver.PlayListServer;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.millennialmedia:
//            MMException, MMSDK, MMLog

public class NativeAd extends AdPlacement
{
    public static final class ComponentName extends Enum
    {

        private static final ComponentName $VALUES[];
        public static final ComponentName BODY;
        public static final ComponentName CALL_TO_ACTION;
        public static final ComponentName DISCLAIMER;
        public static final ComponentName ICON_IMAGE;
        public static final ComponentName MAIN_IMAGE;
        public static final ComponentName RATING;
        public static final ComponentName TITLE;

        public static ComponentName valueOf(String s)
        {
            return (ComponentName)Enum.valueOf(com/millennialmedia/NativeAd$ComponentName, s);
        }

        public static ComponentName[] values()
        {
            return (ComponentName[])$VALUES.clone();
        }

        static 
        {
            TITLE = new ComponentName("TITLE", 0);
            BODY = new ComponentName("BODY", 1);
            ICON_IMAGE = new ComponentName("ICON_IMAGE", 2);
            MAIN_IMAGE = new ComponentName("MAIN_IMAGE", 3);
            CALL_TO_ACTION = new ComponentName("CALL_TO_ACTION", 4);
            RATING = new ComponentName("RATING", 5);
            DISCLAIMER = new ComponentName("DISCLAIMER", 6);
            $VALUES = (new ComponentName[] {
                TITLE, BODY, ICON_IMAGE, MAIN_IMAGE, CALL_TO_ACTION, RATING, DISCLAIMER
            });
        }

        private ComponentName(String s, int i)
        {
            super(s, i);
        }
    }

    private static class ExpirationRunnable
        implements Runnable
    {

        WeakReference nativeAdRef;
        WeakReference requestStateRef;

        public void run()
        {
            NativeAd nativead = (NativeAd)nativeAdRef.get();
            if (nativead == null)
            {
                MMLog.e(NativeAd.TAG, "NativeAd instance has been destroyed, aborting expiration state change");
                return;
            }
            nativead.expirationRunnable = null;
            com.millennialmedia.internal.AdPlacement.RequestState requeststate = (com.millennialmedia.internal.AdPlacement.RequestState)requestStateRef.get();
            if (requeststate == null)
            {
                MMLog.e(NativeAd.TAG, "No valid RequestStateComponents is available, unable to trigger expired state change");
                return;
            } else
            {
                nativead.onExpired(requeststate);
                return;
            }
        }

        ExpirationRunnable(NativeAd nativead, com.millennialmedia.internal.AdPlacement.RequestState requeststate)
        {
            nativeAdRef = new WeakReference(nativead);
            requestStateRef = new WeakReference(requeststate);
        }
    }

    static class ImpressionListener
    {

        volatile boolean impressionFound;
        volatile com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable impressionTimerRunnable;
        com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher viewabilityWatcher;

        public void cancel()
        {
            if (impressionTimerRunnable != null)
            {
                MMLog.d(NativeAd.TAG, "Cancelling previous impression timer runnable");
                impressionTimerRunnable.cancel();
                impressionTimerRunnable = null;
            }
            if (viewabilityWatcher != null)
            {
                MMLog.d(NativeAd.TAG, "Stopping previous impression viewability watcher");
                viewabilityWatcher.stopWatching();
                viewabilityWatcher = null;
            }
        }

        protected void listen()
        {
            if (viewabilityWatcher == null)
            {
                return;
            } else
            {
                viewabilityWatcher.setMinViewabilityPercent(50);
                viewabilityWatcher.startWatching();
                return;
            }
        }

        ImpressionListener(NativeAd nativead, View view)
        {
            impressionFound = false;
            viewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(view, nativead. new _cls1());
        }
    }

    public static class NativeAdMetadata extends AdPlacementMetadata
    {

        private static final String PLACEMENT_TYPE_NATIVE = "native";

        public NativeAdMetadata()
        {
            super("native");
        }
    }

    public static class NativeErrorStatus extends ErrorStatus
    {

        public static final int EXPIRED = 301;

        static 
        {
            errorCodes.put(Integer.valueOf(301), "EXPIRED");
        }

        public NativeErrorStatus(int i)
        {
            super(i);
        }

        public NativeErrorStatus(int i, String s, Throwable throwable)
        {
            super(i, s, throwable);
        }
    }

    public static interface NativeListener
    {

        public abstract void onAdLeftApplication(NativeAd nativead);

        public abstract void onClicked(NativeAd nativead, ComponentName componentname, int i);

        public abstract void onExpired(NativeAd nativead);

        public abstract void onLoadFailed(NativeAd nativead, NativeErrorStatus nativeerrorstatus);

        public abstract void onLoaded(NativeAd nativead);
    }


    public static final String COMPONENT_ID_BODY = "body";
    public static final String COMPONENT_ID_CALL_TO_ACTION = "callToAction";
    public static final String COMPONENT_ID_DISCLAIMER = "disclaimer";
    public static final String COMPONENT_ID_ICON_IMAGE = "iconImage";
    public static final String COMPONENT_ID_MAIN_IMAGE = "mainImage";
    public static final String COMPONENT_ID_RATING = "rating";
    public static final String COMPONENT_ID_TITLE = "title";
    private static final String DEFAULT_DISCLAIMER_TEXT = "Sponsored";
    private static final int MAX_COMP_INSTANCE_ID = 900;
    private static final int MIN_COMP_INSTANCE_ID = 1;
    private static final int MIN_IMPRESSION_DISPLAY = 1000;
    public static final String NATIVE_TYPE_INLINE = "inline";
    protected static final String STATE_EXPIRED = "expired";
    private static final String TAG = com/millennialmedia/NativeAd.getSimpleName();
    private Map accessedComponentIndices;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable adAdapterRequestTimeoutRunnable;
    private List bodyInfoList;
    private List callToActionInfoList;
    private Context context;
    private List disclaimerInfoList;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable expirationRunnable;
    private List iconImageInfoList;
    private ImpressionListener impressionListener;
    public Map loadedComponents;
    private List mainImageInfoList;
    private NativeAdapter nativeAdAdapter;
    private NativeListener nativeListener;
    private com.millennialmedia.internal.Handshake.NativeTypeDefinition nativeTypeDefinition;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable placementRequestTimeoutRunnable;
    private List ratingInfoList;
    private List requestedNativeTypes;
    private List titleInfoList;
    private boolean usingManagedLayout;

    private NativeAd(String s, String as[])
        throws MMException
    {
        super(s);
        usingManagedLayout = false;
        accessedComponentIndices = new HashMap();
        loadedComponents = new HashMap();
        if (as == null || as.length == 0 || as[0] == null || as[0].isEmpty())
        {
            throw new MMException("Unable to create native ad, nativeTypes is required");
        }
        ArrayList arraylist = new ArrayList();
        Map map = Handshake.getNativeTypeDefinitions();
        int j = as.length;
        for (int i = 0; i < j;)
        {
            String s1 = as[i];
            Object obj = null;
            Iterator iterator = map.entrySet().iterator();
            java.util.Map.Entry entry;
            do
            {
                s = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                entry = (java.util.Map.Entry)iterator.next();
                s = (String)entry.getKey();
            } while (!s1.equals(((com.millennialmedia.internal.Handshake.NativeTypeDefinition)entry.getValue()).typeName));
            if (s != null)
            {
                arraylist.add(s);
                i++;
            } else
            {
                throw new MMException((new StringBuilder()).append("Unable to load native ad, specified native type <").append(s1).append("> is not recognized").toString());
            }
        }

        requestedNativeTypes = arraylist;
    }

    public static NativeAd createInstance(String s, String s1)
        throws MMException
    {
        return createInstance(s, new String[] {
            s1
        });
    }

    public static NativeAd createInstance(String s, String as[])
        throws MMException
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create instance, SDK must be initialized first");
        } else
        {
            return new NativeAd(s, as);
        }
    }

    private void fillImageViews(List list, String s, ComponentName componentname, List list1, boolean flag)
        throws MMException
    {
        if (list != null)
        {
            s = (List)loadedComponents.get(s);
            int i;
            int j;
            if (flag)
            {
                i = list.size();
            } else
            {
                i = Math.min(list.size(), s.size());
            }
            j = 0;
            while (j < i) 
            {
                ImageView imageview = (ImageView)list.get(j);
                if (j < s.size())
                {
                    imageview.setImageDrawable(((ImageView)s.get(j)).getDrawable());
                    setComponentClickListener(imageview, componentname, j, (com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo)list1.get(j));
                } else
                {
                    imageview.setImageDrawable(null);
                    imageview.setOnClickListener(null);
                }
                j++;
            }
        }
    }

    private void fillTextViews(List list, String s, ComponentName componentname, List list1, boolean flag)
        throws MMException
    {
        if (list != null)
        {
            s = (List)loadedComponents.get(s);
            int i;
            int j;
            if (flag)
            {
                i = list.size();
            } else
            {
                i = Math.min(list.size(), s.size());
            }
            j = 0;
            while (j < i) 
            {
                TextView textview = (TextView)list.get(j);
                if (j < s.size())
                {
                    textview.setText(((TextView)s.get(j)).getText());
                    setComponentClickListener(textview, componentname, j, (com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo)list1.get(j));
                } else
                {
                    textview.setText("");
                    textview.setOnClickListener(null);
                }
                j++;
            }
        }
    }

    private List findImageViewsByComponentId(View view, String s)
        throws MMException
    {
        ArrayList arraylist = new ArrayList();
        int i = 1;
        do
        {
            if (i > 900)
            {
                break;
            }
            View view1 = view.findViewWithTag((new StringBuilder()).append(s).append("_").append(i).toString());
            if (view1 == null)
            {
                break;
            }
            if (view1 instanceof ImageView)
            {
                arraylist.add((ImageView)view1);
                i++;
            } else
            {
                throw new MMException((new StringBuilder()).append("Expected View with tag = ").append(view1.getTag()).append(" to be a ImageView.").toString());
            }
        } while (true);
        return arraylist;
    }

    private List findTextViewsByComponentId(View view, String s)
        throws MMException
    {
        ArrayList arraylist = new ArrayList();
        int i = 1;
        do
        {
            if (i > 900)
            {
                break;
            }
            View view1 = view.findViewWithTag((new StringBuilder()).append(s).append("_").append(i).toString());
            if (view1 == null)
            {
                break;
            }
            if (view1 instanceof TextView)
            {
                arraylist.add((TextView)view1);
                i++;
            } else
            {
                throw new MMException((new StringBuilder()).append("Expected View with tag = ").append(view1.getTag()).append(" to be a TextView.").toString());
            }
        } while (true);
        return arraylist;
    }

    private com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo getComponentInfo(ComponentName componentname, int i)
    {
        Object obj = null;
        if (componentname != ComponentName.CALL_TO_ACTION) goto _L2; else goto _L1
_L1:
        obj = callToActionInfoList;
_L8:
        if (obj != null) goto _L4; else goto _L3
_L3:
        MMLog.e(TAG, (new StringBuilder()).append("Unable to get component info for component name <").append(componentname).append("> and instance id <").append(i).append(">, did not find component info list").toString());
        obj = null;
_L6:
        return ((com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo) (obj));
_L2:
        if (componentname == ComponentName.ICON_IMAGE)
        {
            obj = iconImageInfoList;
        } else
        if (componentname == ComponentName.MAIN_IMAGE)
        {
            obj = mainImageInfoList;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo componentinfo;
        if (i < 1)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to get component info for component name <").append(componentname).append("> and instance id <").append(i).append(">, instance id must be greater than 0").toString());
            return null;
        }
        if (((List) (obj)).size() < i)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to get component info for component name <").append(componentname).append("> and instance id <").append(i).append(">, only <").append(((List) (obj)).size()).append("> instances found").toString());
            return null;
        }
        i--;
        componentinfo = (com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo)((List) (obj)).get(i);
        obj = componentinfo;
        if (componentinfo != null) goto _L6; else goto _L5
_L5:
        MMLog.e(TAG, (new StringBuilder()).append("Unable to get component info for component name <").append(componentname).append("> and instance id <").append(i).append(">, found value is null").toString());
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private Object getComponentInstance(int i, String s, String s1)
    {
        if (i < 1)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to retrieve the requested <").append(s1).append("> instance, instance value must be 1 or greater").toString());
            return null;
        }
        List list = (List)loadedComponents.get(s);
        if (list.size() < i)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to retrieve the requested <").append(s1).append("> instance <").append(i).append(">, only <").append(list.size()).append("> instances available").toString());
            return null;
        } else
        {
            markComponentAsAccessed(s, i);
            return list.get(i - 1);
        }
    }

    private boolean internalUpdateLayout(View view, boolean flag, boolean flag1)
        throws MMException
    {
        boolean flag5 = false;
        boolean flag4 = true;
        Object obj = new HashMap();
        com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition componentdefinition;
        for (Iterator iterator = nativeTypeDefinition.componentDefinitions.iterator(); iterator.hasNext(); ((Map) (obj)).put(componentdefinition.componentId, componentdefinition))
        {
            componentdefinition = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)iterator.next();
        }

        List list = findTextViewsByComponentId(view, "body");
        Object obj1 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("body");
        boolean flag2 = flag4;
        if (obj1 != null)
        {
            flag2 = flag4;
            if (list.size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj1)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the body component.");
                flag2 = false;
            }
        }
        obj1 = findTextViewsByComponentId(view, "callToAction");
        Object obj2 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("callToAction");
        flag4 = flag2;
        if (obj2 != null)
        {
            flag4 = flag2;
            if (((List) (obj1)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj2)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the 'Call To Action' component.");
                flag4 = false;
            }
        }
        obj2 = findTextViewsByComponentId(view, "disclaimer");
        Object obj3 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("disclaimer");
        flag2 = flag4;
        if (obj3 != null)
        {
            flag2 = flag4;
            if (((List) (obj2)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj3)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the Disclaimer component.");
                flag2 = false;
            }
        }
        obj3 = findImageViewsByComponentId(view, "iconImage");
        Object obj4 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("iconImage");
        flag4 = flag2;
        if (obj4 != null)
        {
            flag4 = flag2;
            if (((List) (obj3)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj4)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the 'Icon Image' component.");
                flag4 = false;
            }
        }
        obj4 = findImageViewsByComponentId(view, "mainImage");
        Object obj5 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("mainImage");
        flag2 = flag4;
        if (obj5 != null)
        {
            flag2 = flag4;
            if (((List) (obj4)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj5)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the 'Main Image' component.");
                flag2 = false;
            }
        }
        obj5 = findTextViewsByComponentId(view, "rating");
        Object obj6 = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("rating");
        flag4 = flag2;
        if (obj6 != null)
        {
            flag4 = flag2;
            if (((List) (obj5)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj6)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the Rating component.");
                flag4 = false;
            }
        }
        obj6 = findTextViewsByComponentId(view, "title");
        obj = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)((Map) (obj)).get("title");
        flag2 = flag4;
        if (obj != null)
        {
            flag2 = flag4;
            if (((List) (obj6)).size() < ((com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition) (obj)).publisherRequired)
            {
                MMLog.e(TAG, "Layout does not contain the required number of Views for the Title component.");
                flag2 = false;
            }
        }
        if (flag2)
        {
            boolean flag3;
            if (list.size() <= bodyInfoList.size() && ((List) (obj2)).size() <= disclaimerInfoList.size() && ((List) (obj5)).size() <= ratingInfoList.size() && ((List) (obj6)).size() <= titleInfoList.size() && ((List) (obj1)).size() <= callToActionInfoList.size() && ((List) (obj3)).size() <= iconImageInfoList.size() && ((List) (obj4)).size() <= mainImageInfoList.size())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3 || !flag)
            {
                fillTextViews(list, "body", ComponentName.BODY, bodyInfoList, flag1);
                fillTextViews(((List) (obj2)), "disclaimer", ComponentName.DISCLAIMER, disclaimerInfoList, flag1);
                fillTextViews(((List) (obj5)), "rating", ComponentName.RATING, ratingInfoList, flag1);
                fillTextViews(((List) (obj6)), "title", ComponentName.TITLE, titleInfoList, flag1);
                fillTextViews(((List) (obj1)), "callToAction", ComponentName.CALL_TO_ACTION, callToActionInfoList, flag1);
                fillImageViews(((List) (obj3)), "iconImage", ComponentName.ICON_IMAGE, iconImageInfoList, flag1);
                fillImageViews(((List) (obj4)), "mainImage", ComponentName.MAIN_IMAGE, mainImageInfoList, flag1);
                usingManagedLayout = true;
                flag5 = true;
                if (impressionListener != null)
                {
                    impressionListener.cancel();
                }
                impressionListener = new ImpressionListener(this, view);
                impressionListener.listen();
            }
            return flag5;
        } else
        {
            MMLog.e(TAG, "Layout was not updated because it did not contain the required Views.");
            return false;
        }
    }

    private void loadAdAdapter(final com.millennialmedia.internal.AdPlacement.RequestState playListItemReporter)
    {
        final com.millennialmedia.internal.AdPlacement.RequestState localRequestState = playListItemReporter.copy();
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localRequestState) && (placementState.equals("play_list_loaded") || placementState.equals("ad_adapter_load_failed")))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "loading_ad_adapter";
        this;
        JVM INSTR monitorexit ;
        if (!playList.hasNext())
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Unable to find ad adapter in play list");
            }
            onLoadFailed(localRequestState);
            return;
        }
        break MISSING_BLOCK_LABEL_92;
        playListItemReporter;
        this;
        JVM INSTR monitorexit ;
        throw playListItemReporter;
        playListItemReporter = AdPlacementReporter.getPlayListItemReporter(playListItemReporter.getAdPlacementReporter());
        final NativeAdapter nativeAdAdapter = (NativeAdapter)playList.getNextAdAdapter(this, playListItemReporter);
        if (nativeAdAdapter != null)
        {
            this.nativeAdAdapter = nativeAdAdapter;
            localRequestState.getItemHash();
            currentRequestState = localRequestState;
            int i = nativeAdAdapter.requestTimeout;
            if (i > 0)
            {
                if (adAdapterRequestTimeoutRunnable != null)
                {
                    adAdapterRequestTimeoutRunnable.cancel();
                }
                adAdapterRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    final NativeAd this$0;
                    final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;
                    final com.millennialmedia.internal.AdPlacementReporter.PlayListItemReporter val$playListItemReporter;

                    public void run()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(NativeAd.TAG, "Ad adapter load timed out");
                        }
                        AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter, -2);
                        onAdAdapterLoadFailed(localRequestState);
                    }

            
            {
                this$0 = NativeAd.this;
                localRequestState = requeststate;
                playListItemReporter = playlistitemreporter;
                super();
            }
                }, i);
            }
            nativeAdAdapter.init(new com.millennialmedia.internal.adadapters.NativeAdapter.NativeAdapterListener() );
            return;
        } else
        {
            AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter);
            onAdAdapterLoadFailed(localRequestState);
            return;
        }
    }

    private void loadButtonComponentArray(String s, ComponentName componentname, List list)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < list.size()) 
        {
            com.millennialmedia.internal.adadapters.NativeAdapter.TextComponentInfo textcomponentinfo = (com.millennialmedia.internal.adadapters.NativeAdapter.TextComponentInfo)list.get(i);
            if (textcomponentinfo != null)
            {
                Button button = new Button(context);
                button.setText(textcomponentinfo.value);
                setComponentClickListener(button, componentname, i, textcomponentinfo);
                arraylist.add(button);
            }
            i++;
        }
        loadedComponents.put(s, arraylist);
    }

    private boolean loadComponents(NativeAdapter nativeadapter)
    {
        String s = nativeadapter.getType();
        if (s == null)
        {
            MMLog.e(TAG, "Unable to load components, native type is not set");
            return false;
        }
        if (!requestedNativeTypes.contains(s))
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to load components, native type <").append(s).append("> is not a requested native type").toString());
            return false;
        }
        nativeTypeDefinition = Handshake.getNativeTypeDefinition(s);
        if (nativeTypeDefinition == null)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to load components, unable to find list of required components for native type <").append(s).append(">").toString());
            return false;
        }
        titleInfoList = nativeadapter.getTitleList();
        loadTextComponentArray("title", ComponentName.TITLE, titleInfoList);
        bodyInfoList = nativeadapter.getBodyList();
        loadTextComponentArray("body", ComponentName.BODY, bodyInfoList);
        iconImageInfoList = nativeadapter.getIconImageList();
        loadImageComponentArray("iconImage", ComponentName.ICON_IMAGE, iconImageInfoList);
        mainImageInfoList = nativeadapter.getMainImageList();
        loadImageComponentArray("mainImage", ComponentName.MAIN_IMAGE, mainImageInfoList);
        callToActionInfoList = nativeadapter.getCallToActionList();
        loadButtonComponentArray("callToAction", ComponentName.CALL_TO_ACTION, callToActionInfoList);
        ratingInfoList = nativeadapter.getRatingList();
        loadTextComponentArray("rating", ComponentName.RATING, ratingInfoList);
        disclaimerInfoList = nativeadapter.getDisclaimerList();
        if (disclaimerInfoList.isEmpty())
        {
            nativeadapter = new TextComponentInfo();
            nativeadapter.value = "Sponsored";
            disclaimerInfoList.add(nativeadapter);
        }
        loadTextComponentArray("disclaimer", ComponentName.DISCLAIMER, disclaimerInfoList);
        return validateLoadedComponents(s);
    }

    private void loadImageComponentArray(String s, ComponentName componentname, List list)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < list.size()) 
        {
            com.millennialmedia.internal.adadapters.NativeAdapter.ImageComponentInfo imagecomponentinfo = (com.millennialmedia.internal.adadapters.NativeAdapter.ImageComponentInfo)list.get(i);
            if (imagecomponentinfo != null)
            {
                BitmapDrawable bitmapdrawable = new BitmapDrawable(imagecomponentinfo.bitmap);
                ImageView imageview = new ImageView(context);
                imageview.setImageDrawable(bitmapdrawable);
                setComponentClickListener(imageview, componentname, i, imagecomponentinfo);
                arraylist.add(imageview);
            }
            i++;
        }
        loadedComponents.put(s, arraylist);
    }

    private void loadTextComponentArray(String s, ComponentName componentname, List list)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < list.size()) 
        {
            com.millennialmedia.internal.adadapters.NativeAdapter.TextComponentInfo textcomponentinfo = (com.millennialmedia.internal.adadapters.NativeAdapter.TextComponentInfo)list.get(i);
            if (textcomponentinfo != null)
            {
                TextView textview = new TextView(context);
                textview.setText(textcomponentinfo.value);
                setComponentClickListener(textview, componentname, i, textcomponentinfo);
                arraylist.add(textview);
            }
            i++;
        }
        loadedComponents.put(s, arraylist);
    }

    private void markComponentAsAccessed(String s, int i)
    {
        Set set = (Set)accessedComponentIndices.get(s);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet();
            accessedComponentIndices.put(s, obj);
        }
        ((Set) (obj)).add(Integer.valueOf(i));
    }

    private void onAdAdapterLoadFailed(com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(requeststate))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onAdAdapterLoadFailed called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onAdAdapterLoadFailed called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        requeststate;
        this;
        JVM INSTR monitorexit ;
        throw requeststate;
        placementState = "ad_adapter_load_failed";
        this;
        JVM INSTR monitorexit ;
        loadAdAdapter(requeststate);
        return;
    }

    private void onAdLeftApplication()
    {
        MMLog.i(TAG, "Ad left application");
        final NativeListener localNativeListener = nativeListener;
        if (localNativeListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final NativeAd this$0;
                final NativeListener val$localNativeListener;

                public void run()
                {
                    localNativeListener.onAdLeftApplication(NativeAd.this);
                }

            
            {
                this$0 = NativeAd.this;
                localNativeListener = nativelistener;
                super();
            }
            });
        }
    }

    private void onExpired(final com.millennialmedia.internal.AdPlacement.RequestState localNativeListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localNativeListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onExpired called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loaded"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onExpired called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localNativeListener;
        this;
        JVM INSTR monitorexit ;
        throw localNativeListener;
        placementState = "expired";
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad expired");
        localNativeListener = nativeListener;
        if (localNativeListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final NativeAd this$0;
                final NativeListener val$localNativeListener;

                public void run()
                {
                    localNativeListener.onExpired(NativeAd.this);
                }

            
            {
                this$0 = NativeAd.this;
                localNativeListener = nativelistener;
                super();
            }
            });
        }
        return;
    }

    private void onLoadFailed(final com.millennialmedia.internal.AdPlacement.RequestState localNativeListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localNativeListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onLoadFailed called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter") || placementState.equals("loading_play_list"))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onLoadFailed called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localNativeListener;
        this;
        JVM INSTR monitorexit ;
        throw localNativeListener;
        placementState = "load_failed";
        MMLog.i(TAG, "Load failed");
        stopRequestTimeoutTimers();
        AdPlacementReporter.reportPlayList(localNativeListener.getAdPlacementReporter());
        this;
        JVM INSTR monitorexit ;
        localNativeListener = nativeListener;
        if (localNativeListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final NativeAd this$0;
                final NativeListener val$localNativeListener;

                public void run()
                {
                    localNativeListener.onLoadFailed(NativeAd.this, new NativeErrorStatus(5));
                }

            
            {
                this$0 = NativeAd.this;
                localNativeListener = nativelistener;
                super();
            }
            });
        }
        return;
    }

    private void onLoadSucceeded(final com.millennialmedia.internal.AdPlacement.RequestState localNativeListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localNativeListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onLoadSucceeded called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onLoadSucceeded called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localNativeListener;
        this;
        JVM INSTR monitorexit ;
        throw localNativeListener;
        placementState = "loaded";
        MMLog.i(TAG, "Load succeeded");
        stopRequestTimeoutTimers();
        startExpirationTimer(localNativeListener);
        AdPlacementReporter.reportPlayList(localNativeListener.getAdPlacementReporter());
        this;
        JVM INSTR monitorexit ;
        try
        {
            nativeAdAdapter.getClass().getMethod("onPostLoaded", new Class[] {
                com/millennialmedia/NativeAd
            }).invoke(nativeAdAdapter, new Object[] {
                this
            });
        }
        // Misplaced declaration of an exception variable
        catch (final com.millennialmedia.internal.AdPlacement.RequestState localNativeListener)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Could not find method <onPostLoaded> in adAdapter");
            }
        }
        localNativeListener = nativeListener;
        if (localNativeListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final NativeAd this$0;
                final NativeListener val$localNativeListener;

                public void run()
                {
                    localNativeListener.onLoaded(NativeAd.this);
                }

            
            {
                this$0 = NativeAd.this;
                localNativeListener = nativelistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
    }

    private void setComponentClickListener(View view, ComponentName componentname, int i, com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo componentinfo)
    {
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final NativeAd this$0;
            final com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo val$componentInfo;
            final ComponentName val$componentName;
            final int val$index;
            final AdPlacementReporter val$reporter;

            public void onClick(View view1)
            {
                MMLog.i(NativeAd.TAG, "Ad clicked");
                AdPlacementReporter.setClicked(reporter);
                try
                {
                    nativeAdAdapter.getClass().getDeclaredMethod("onAdClicked", new Class[0]).invoke(nativeAdAdapter, new Object[0]);
                }
                // Misplaced declaration of an exception variable
                catch (View view1) { }
                view1 = nativeListener;
                if (view1 != null)
                {
                    ThreadUtils.runOffUiThread(view1. new Runnable() {

                        final _cls6 this$1;
                        final NativeListener val$localNativeListener;

                        public void run()
                        {
                            localNativeListener.onClicked(_fld0, componentName, index);
                        }

            
            {
                this$1 = final__pcls6;
                localNativeListener = NativeListener.this;
                super();
            }
                    });
                }
                if (componentInfo.clickTrackerUrls != null)
                {
                    ThreadUtils.runOnWorkerThread(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            for (Iterator iterator = componentInfo.clickTrackerUrls.iterator(); iterator.hasNext(); HttpUtils.getContentFromGetRequest((String)iterator.next())) { }
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                }
                if (componentInfo.clickUrl == null)
                {
                    MMLog.e(NativeAd.TAG, "Unable to execute click action, url is null");
                } else
                {
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setData(Uri.parse(componentInfo.clickUrl));
                    if (Utils.startActivity(context, view1))
                    {
                        onAdLeftApplication();
                        return;
                    }
                }
            }

            
            {
                this$0 = NativeAd.this;
                reporter = adplacementreporter;
                componentName = componentname;
                index = i;
                componentInfo = componentinfo;
                super();
            }
        });
    }

    private void startExpirationTimer(com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        stopExpirationTimer();
        int i = Handshake.getNativeExpirationDuration();
        if (i > 0)
        {
            expirationRunnable = ThreadUtils.runOnWorkerThreadDelayed(new ExpirationRunnable(this, requeststate), i);
        }
    }

    private void stopExpirationTimer()
    {
        if (expirationRunnable != null)
        {
            expirationRunnable.cancel();
        }
    }

    private void stopRequestTimeoutTimers()
    {
        if (placementRequestTimeoutRunnable != null)
        {
            placementRequestTimeoutRunnable.cancel();
        }
        if (adAdapterRequestTimeoutRunnable != null)
        {
            adAdapterRequestTimeoutRunnable.cancel();
        }
    }

    private boolean validateLoadedComponents(String s)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = nativeTypeDefinition.componentDefinitions.iterator(); iterator.hasNext();)
        {
            com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition componentdefinition = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)iterator.next();
            if (componentdefinition != null)
            {
                int i = componentdefinition.adverstiserRequired;
                List list = (List)loadedComponents.get(componentdefinition.componentId);
                if (list == null || list.size() < i)
                {
                    arraylist.add(componentdefinition.componentId);
                }
            } else
            {
                MMLog.e(TAG, String.format("Missing configuration data for native type: %s.", new Object[] {
                    s
                }));
                return false;
            }
        }

        if (arraylist.size() > 0)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to load required components <").append(TextUtils.join(", ", arraylist)).append("> for native type <").append(s).append(">").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void validateRequiredComponentAccess()
        throws IllegalStateException
    {
        Object obj = new ArrayList();
        Iterator iterator = nativeTypeDefinition.componentDefinitions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition componentdefinition = (com.millennialmedia.internal.Handshake.NativeTypeDefinition.ComponentDefinition)iterator.next();
            int i = 0;
            Set set = (Set)accessedComponentIndices.get(componentdefinition.componentId);
            if (set != null)
            {
                i = set.size();
            }
            if (i < componentdefinition.publisherRequired)
            {
                ((List) (obj)).add(String.format("Component: %s, required: %d, accessed: %d", new Object[] {
                    componentdefinition.componentId, Integer.valueOf(componentdefinition.publisherRequired), Integer.valueOf(i)
                }));
            }
        } while (true);
        if (!((List) (obj)).isEmpty())
        {
            obj = (new StringBuilder()).append("Unable to validate that all required native components have been accessed:\n").append(obj.toString()).toString();
            MMLog.e(TAG, ((String) (obj)));
            throw new IllegalStateException(((String) (obj)));
        } else
        {
            return;
        }
    }

    public void fireClicked()
    {
        final com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo componentInfo = getComponentInfo(ComponentName.CALL_TO_ACTION, 1);
        if (componentInfo == null)
        {
            MMLog.e(TAG, "Unable to fire clicked, found component info is null");
        } else
        {
            AdPlacementReporter.setClicked(currentRequestState.getAdPlacementReporter());
            if (componentInfo.clickTrackerUrls != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final NativeAd this$0;
                    final com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo val$componentInfo;

                    public void run()
                    {
                        for (Iterator iterator = componentInfo.clickTrackerUrls.iterator(); iterator.hasNext(); HttpUtils.getContentFromGetRequest((String)iterator.next())) { }
                    }

            
            {
                this$0 = NativeAd.this;
                componentInfo = componentinfo;
                super();
            }
                });
                return;
            }
        }
    }

    public void fireImpression()
        throws MMException
    {
        if (!isReady())
        {
            Utils.logAndFireMMException(TAG, "Native ad is not in a loaded state, you must load before showing");
            return;
        }
        if (usingManagedLayout)
        {
            MMLog.w(TAG, "Impression firing is disabled when using a managed layout.");
            return;
        }
        try
        {
            validateRequiredComponentAccess();
        }
        catch (IllegalStateException illegalstateexception)
        {
            throw new MMException(illegalstateexception.getMessage());
        }
        MMLog.i(TAG, "All required components have been accessed, firing impression");
        AdPlacementReporter.setDisplayed(currentRequestState.getAdPlacementReporter());
    }

    public TextView getBody()
    {
        return getBody(1);
    }

    public TextView getBody(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get body, ad not loaded");
            return null;
        } else
        {
            return (TextView)getComponentInstance(i, "body", "body");
        }
    }

    public Button getCallToActionButton()
    {
        return getCallToActionButton(1);
    }

    public Button getCallToActionButton(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get call to action button, ad not loaded");
            return null;
        } else
        {
            return (Button)getComponentInstance(i, "callToAction", "call to action");
        }
    }

    public String getCallToActionUrl()
    {
        com.millennialmedia.internal.adadapters.NativeAdapter.ComponentInfo componentinfo = getComponentInfo(ComponentName.CALL_TO_ACTION, 1);
        if (componentinfo == null)
        {
            MMLog.e(TAG, "Unable to get call to action url, found component info is not for a call to action component");
            return null;
        } else
        {
            return componentinfo.clickUrl;
        }
    }

    public TextView getDisclaimer()
    {
        return getDisclaimer(1);
    }

    public TextView getDisclaimer(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get disclaimer, ad not loaded");
            return null;
        } else
        {
            return (TextView)getComponentInstance(i, "disclaimer", "disclaimer");
        }
    }

    public ImageView getIconImage()
    {
        return getIconImage(1);
    }

    public ImageView getIconImage(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get icon image, ad not loaded");
            return null;
        } else
        {
            return (ImageView)getComponentInstance(i, "iconImage", "icon image");
        }
    }

    public String getImageUrl(ComponentName componentname, int i)
    {
        componentname = getComponentInfo(componentname, i);
        if (!(componentname instanceof com.millennialmedia.internal.adadapters.NativeAdapter.ImageComponentInfo))
        {
            MMLog.e(TAG, "Unable to get image url, found component info is not for a image component");
            return null;
        } else
        {
            return ((com.millennialmedia.internal.adadapters.NativeAdapter.ImageComponentInfo)componentname).bitmapUrl;
        }
    }

    public ImageView getMainImage()
    {
        return getMainImage(1);
    }

    public ImageView getMainImage(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get main image, ad not loaded");
            return null;
        } else
        {
            return (ImageView)getComponentInstance(i, "mainImage", "main image");
        }
    }

    public String getNativeType()
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get native type, ad not loaded");
        } else
        if (nativeAdAdapter != null)
        {
            return nativeTypeDefinition.typeName;
        }
        return null;
    }

    public TextView getRating()
    {
        return getRating(1);
    }

    public TextView getRating(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get rating, ad not loaded");
            return null;
        } else
        {
            return (TextView)getComponentInstance(i, "rating", "rating");
        }
    }

    public TextView getTitle()
    {
        return getTitle(1);
    }

    public TextView getTitle(int i)
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to get title, ad not loaded");
            return null;
        } else
        {
            return (TextView)getComponentInstance(i, "title", "title");
        }
    }

    public boolean hasExpired()
    {
        return placementState.equals("expired");
    }

    public View inflateLayout(Context context1, int ai[])
        throws MMException
    {
        if (!ThreadUtils.isUiThread())
        {
            MMLog.e(TAG, "NativeAd.inflateLayout must be called on the UI thread.");
        } else
        {
            if (context1 == null)
            {
                MMLog.e(TAG, "Unable to inflate a layout because the provided Context is null.");
                return null;
            }
            if (ai == null || ai.length == 0)
            {
                MMLog.e(TAG, "Unable to inflate a layout because the layoutIds are null or empty.");
                return null;
            }
            if (!isReady())
            {
                MMLog.e(TAG, "Cannot inflate a layout. The NativeAd is not loaded.");
                return null;
            }
            context1 = LayoutInflater.from(context1);
            int i = 0;
            while (i < ai.length) 
            {
                View view = context1.inflate(ai[i], null);
                boolean flag;
                if (i < ai.length - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (internalUpdateLayout(view, flag, false))
                {
                    return view;
                }
                i++;
            }
        }
        return null;
    }

    public void invokeDefaultAction()
    {
        if (!isReady())
        {
            MMLog.e(TAG, "Unable to invoke default action, ad not loaded");
        } else
        if (nativeAdAdapter != null)
        {
            String s = nativeAdAdapter.getDefaultAction();
            if (s == null)
            {
                MMLog.e(TAG, "Unable to invoke default action, no default action url found");
                return;
            } else
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(s));
                context.startActivity(intent);
                onAdLeftApplication();
                return;
            }
        }
    }

    public boolean isReady()
    {
        return placementState.equals("loaded");
    }

    public void load(Context context1, final NativeAdMetadata localRequestState)
        throws MMException
    {
        MMLog.i(TAG, (new StringBuilder()).append("Loading playlist for placement ID: ").append(placementId).toString());
        if (context1 == null)
        {
            throw new MMException("Unable to load native, specified context cannot be null");
        }
        context = context1;
        this;
        JVM INSTR monitorenter ;
        if (placementState.equals("idle") || placementState.equals("load_failed") || placementState.equals("loaded"))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "loading_play_list";
        this;
        JVM INSTR monitorexit ;
        playList = null;
        accessedComponentIndices.clear();
        loadedComponents.clear();
        usingManagedLayout = false;
        context1 = localRequestState;
        if (localRequestState == null)
        {
            context1 = new NativeAdMetadata();
        }
        localRequestState = getRequestState();
        if (placementRequestTimeoutRunnable != null)
        {
            placementRequestTimeoutRunnable.cancel();
        }
        placementRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

            final NativeAd this$0;
            final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;

            public void run()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(NativeAd.TAG, "Play list load timed out");
                }
                onLoadFailed(localRequestState);
            }

            
            {
                this$0 = NativeAd.this;
                localRequestState = requeststate;
                super();
            }
        }, Handshake.getNativeTimeout());
        context1 = context1.toMap(this);
        context1.put("nativeTypes", requestedNativeTypes);
        PlayListServer.loadPlayList(context1, new com.millennialmedia.internal.playlistserver.PlayListServer.PlayListLoadListener() );
        return;
        context1;
        this;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public void setListener(NativeListener nativelistener)
    {
        nativeListener = nativelistener;
    }

    public void updateLayout(View view)
        throws MMException
    {
        if (!ThreadUtils.isUiThread())
        {
            MMLog.e(TAG, "NativeAd.updateLayout must be called on the UI thread.");
            return;
        }
        if (view == null)
        {
            MMLog.e(TAG, "Unable to updated; the provided layout was null.");
            return;
        }
        if (!isReady())
        {
            MMLog.e(TAG, "Cannot update the layout. The NativeAd is not loaded.");
            return;
        } else
        {
            internalUpdateLayout(view, false, true);
            return;
        }
    }













/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$202(NativeAd nativead, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        nativead.expirationRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/





/*
    static String access$602(NativeAd nativead, String s)
    {
        nativead.placementState = s;
        return s;
    }

*/


/*
    static PlayList access$702(NativeAd nativead, PlayList playlist)
    {
        nativead.playList = playlist;
        return playlist;
    }

*/


/*
    static com.millennialmedia.internal.AdPlacement.RequestState access$802(NativeAd nativead, com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        nativead.currentRequestState = requeststate;
        return requeststate;
    }

*/


    // Unreferenced inner class com/millennialmedia/NativeAd$ImpressionListener$1

/* anonymous class */
    class ImpressionListener._cls1
        implements com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener
    {

        final ImpressionListener this$0;
        final NativeAd val$nativeAd;

        public void onViewableChanged(boolean flag)
        {
            ImpressionListener impressionlistener = ImpressionListener.this;
            impressionlistener;
            JVM INSTR monitorenter ;
            if (!flag) goto _L2; else goto _L1
_L1:
            if (impressionTimerRunnable != null || impressionFound) goto _L2; else goto _L3
_L3:
            impressionTimerRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() , 1000L);
_L5:
            impressionlistener;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (flag) goto _L5; else goto _L4
_L4:
            if (impressionTimerRunnable == null) goto _L5; else goto _L6
_L6:
            impressionTimerRunnable.cancel();
            impressionTimerRunnable = null;
              goto _L5
            Exception exception;
            exception;
            impressionlistener;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = final_impressionlistener;
                nativeAd = NativeAd.this;
                super();
            }
    }

}
