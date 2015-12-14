// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.graphics.Bitmap;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.adcontrollers.NativeController;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            NativeAdapter

public class NativeNativeAdapter extends NativeAdapter
{
    static interface ImageLoadedCallback
    {

        public abstract void imageLoaded(NativeAdapter.ImageComponentInfo imagecomponentinfo);
    }


    private static final String ASSET_COMPONENT_TYPE_ID_BODY = "101";
    private static final String ASSET_COMPONENT_TYPE_ID_CALL_TO_ACTION = "104";
    private static final String ASSET_COMPONENT_TYPE_ID_DISCLAIMER = "106";
    private static final String ASSET_COMPONENT_TYPE_ID_ICON_IMAGE = "102";
    private static final String ASSET_COMPONENT_TYPE_ID_MAIN_IMAGE = "103";
    private static final String ASSET_COMPONENT_TYPE_ID_RATING = "105";
    private static final String ASSET_COMPONENT_TYPE_ID_TITLE = "100";
    private static final String TAG = com/millennialmedia/internal/adadapters/NativeNativeAdapter.getName();
    private List bodies;
    private List callToActions;
    private List disclaimers;
    private List iconImages;
    private List mainImages;
    private NativeAdapter.NativeAdapterListener nativeAdapterListener;
    private volatile NativeController nativeController;
    com.millennialmedia.internal.adcontrollers.NativeController.NativeControllerListener nativeControllerListener;
    private String nativeType;
    private List ratings;
    private List titles;

    public NativeNativeAdapter()
    {
        titles = new ArrayList();
        bodies = new ArrayList();
        iconImages = new ArrayList();
        mainImages = new ArrayList();
        callToActions = new ArrayList();
        ratings = new ArrayList();
        disclaimers = new ArrayList();
        nativeControllerListener = new com.millennialmedia.internal.adcontrollers.NativeController.NativeControllerListener() {

            final NativeNativeAdapter this$0;

            public void initFailed(Throwable throwable)
            {
                nativeAdapterListener.initFailed(throwable);
            }

            public void initSucceeded()
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        if (loadComponentsInfo())
                        {
                            nativeAdapterListener.initSucceeded();
                            return;
                        } else
                        {
                            nativeAdapterListener.initFailed(new RuntimeException("Component info not loaded"));
                            return;
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = NativeNativeAdapter.this;
                super();
            }
        };
    }

    private boolean loadComponentsInfo()
    {
        final CountDownLatch loadingLatch = new CountDownLatch(nativeController.assets.size());
        int i = 0;
        while (i < nativeController.assets.size()) 
        {
            final com.millennialmedia.internal.adcontrollers.NativeController.Asset asset = (com.millennialmedia.internal.adcontrollers.NativeController.Asset)nativeController.assets.get(i);
            if (asset == null)
            {
                MMLog.w(TAG, "Unable to load component, asset is null");
                loadingLatch.countDown();
            } else
            {
                Object obj = Integer.toString(asset.id);
                if (((String) (obj)).length() != 9)
                {
                    MMLog.e(TAG, "error when processing native asset, asset ID is not the correct length");
                    loadingLatch.countDown();
                } else
                {
                    nativeType = ((String) (obj)).substring(0, 3);
                    obj = ((String) (obj)).substring(3, 6);
                    if (((String) (obj)).equals("100"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.TITLE)
                        {
                            obj = new NativeAdapter.TextComponentInfo();
                            obj.value = asset.title.value;
                            setLink(((NativeAdapter.ComponentInfo) (obj)), asset);
                            titles.add(obj);
                        } else
                        {
                            MMLog.w(TAG, "Unable to load title component, asset not the expected type");
                        }
                        loadingLatch.countDown();
                    } else
                    if (((String) (obj)).equals("101"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.DATA)
                        {
                            obj = new NativeAdapter.TextComponentInfo();
                            obj.value = asset.data.value;
                            setLink(((NativeAdapter.ComponentInfo) (obj)), asset);
                            bodies.add(obj);
                        } else
                        {
                            MMLog.w(TAG, "Unable to load body component, asset not the expected type");
                        }
                        loadingLatch.countDown();
                    } else
                    if (((String) (obj)).equals("102"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.IMAGE)
                        {
                            loadImageComponent(asset.image.url, new ImageLoadedCallback() {

                                final NativeNativeAdapter this$0;
                                final com.millennialmedia.internal.adcontrollers.NativeController.Asset val$asset;
                                final CountDownLatch val$loadingLatch;

                                public void imageLoaded(NativeAdapter.ImageComponentInfo imagecomponentinfo)
                                {
                                    if (imagecomponentinfo != null)
                                    {
                                        setLink(imagecomponentinfo, asset);
                                        iconImages.add(imagecomponentinfo);
                                    }
                                    loadingLatch.countDown();
                                }

            
            {
                this$0 = NativeNativeAdapter.this;
                asset = asset1;
                loadingLatch = countdownlatch;
                super();
            }
                            });
                        } else
                        {
                            MMLog.w(TAG, "Unable to load icon image component, asset not the expected type");
                            loadingLatch.countDown();
                        }
                    } else
                    if (((String) (obj)).equals("103"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.IMAGE)
                        {
                            loadImageComponent(asset.image.url, new ImageLoadedCallback() {

                                final NativeNativeAdapter this$0;
                                final com.millennialmedia.internal.adcontrollers.NativeController.Asset val$asset;
                                final CountDownLatch val$loadingLatch;

                                public void imageLoaded(NativeAdapter.ImageComponentInfo imagecomponentinfo)
                                {
                                    if (imagecomponentinfo != null)
                                    {
                                        setLink(imagecomponentinfo, asset);
                                        mainImages.add(imagecomponentinfo);
                                    }
                                    loadingLatch.countDown();
                                }

            
            {
                this$0 = NativeNativeAdapter.this;
                asset = asset1;
                loadingLatch = countdownlatch;
                super();
            }
                            });
                        } else
                        {
                            MMLog.w(TAG, "Unable to load main image component, asset not the expected type");
                            loadingLatch.countDown();
                        }
                    } else
                    if (((String) (obj)).equals("104"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.DATA)
                        {
                            obj = new NativeAdapter.TextComponentInfo();
                            obj.value = asset.data.value;
                            setLink(((NativeAdapter.ComponentInfo) (obj)), asset);
                            callToActions.add(obj);
                        } else
                        {
                            MMLog.w(TAG, "Unable to load call to action text component, asset not the expected type");
                        }
                        loadingLatch.countDown();
                    } else
                    if (((String) (obj)).equals("105"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.DATA)
                        {
                            obj = new NativeAdapter.TextComponentInfo();
                            obj.value = asset.data.value;
                            setLink(((NativeAdapter.ComponentInfo) (obj)), asset);
                            ratings.add(obj);
                        } else
                        {
                            MMLog.w(TAG, "Unable to load rating component, asset not the expected type");
                        }
                        loadingLatch.countDown();
                    } else
                    if (((String) (obj)).equals("106"))
                    {
                        if (asset.type == com.millennialmedia.internal.adcontrollers.NativeController.Asset.Type.DATA)
                        {
                            obj = new NativeAdapter.TextComponentInfo();
                            obj.value = asset.data.value;
                            setLink(((NativeAdapter.ComponentInfo) (obj)), asset);
                            disclaimers.add(obj);
                        } else
                        {
                            MMLog.w(TAG, "Unable to load disclaimer component, asset not the expected type");
                        }
                        loadingLatch.countDown();
                    } else
                    {
                        MMLog.e(TAG, (new StringBuilder()).append("Unable to load component from asset, asset type is unrecognized <").append(((String) (obj))).append(">").toString());
                        loadingLatch.countDown();
                    }
                }
            }
            i++;
        }
        boolean flag;
        try
        {
            flag = loadingLatch.await(5000L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            MMLog.e(TAG, "Error occurred when loading native component info");
            return false;
        }
        return flag;
    }

    private void loadImageComponent(String s, ImageLoadedCallback imageloadedcallback)
    {
        com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(s);
        if (response.code == 200 && response.bitmap != null)
        {
            NativeAdapter.ImageComponentInfo imagecomponentinfo = new NativeAdapter.ImageComponentInfo();
            imagecomponentinfo.bitmapUrl = s;
            imagecomponentinfo.bitmap = response.bitmap;
            imagecomponentinfo.width = response.bitmap.getWidth();
            imagecomponentinfo.height = response.bitmap.getHeight();
            imageloadedcallback.imageLoaded(imagecomponentinfo);
            return;
        } else
        {
            imageloadedcallback.imageLoaded(null);
            return;
        }
    }

    private void setLink(NativeAdapter.ComponentInfo componentinfo, com.millennialmedia.internal.adcontrollers.NativeController.Asset asset)
    {
        if (asset.link != null)
        {
            componentinfo.clickUrl = asset.link.url;
            componentinfo.clickTrackerUrls = asset.link.clickTrackerUrls;
        } else
        if (nativeController.link != null)
        {
            componentinfo.clickUrl = nativeController.link.url;
            componentinfo.clickTrackerUrls = nativeController.link.clickTrackerUrls;
            return;
        }
    }

    public List getBodyList()
    {
        return bodies;
    }

    public List getCallToActionList()
    {
        return callToActions;
    }

    public String getDefaultAction()
    {
        if (nativeController.link != null)
        {
            return nativeController.link.url;
        } else
        {
            return null;
        }
    }

    public List getDisclaimerList()
    {
        return disclaimers;
    }

    public List getIconImageList()
    {
        return iconImages;
    }

    public List getMainImageList()
    {
        return mainImages;
    }

    public List getRatingList()
    {
        return ratings;
    }

    public List getTitleList()
    {
        return titles;
    }

    public String getType()
    {
        return nativeType;
    }

    public void init(NativeAdapter.NativeAdapterListener nativeadapterlistener)
    {
        nativeAdapterListener = nativeadapterlistener;
        nativeController = new NativeController(nativeControllerListener);
        nativeController.init(adContent);
    }






}
