// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.tagmanager:
//            DataLayer, AdwordsClickReferrerListener, Container, Log, 
//            PreviewManager, Logger

public class TagManager
{
    static class ContainerOpenException extends RuntimeException
    {

        private final String mContainerId;

        public String getContainerId()
        {
            return mContainerId;
        }

        private ContainerOpenException(String s)
        {
            super((new StringBuilder()).append("Container already open: ").append(s).toString());
            mContainerId = s;
        }
    }

    static interface ContainerProvider
    {

        public abstract Container newContainer(Context context, String s, TagManager tagmanager);
    }

    public static interface Logger
        extends com.google.tagmanager.Logger
    {
    }

    public static final class RefreshMode extends Enum
    {

        private static final RefreshMode $VALUES[];
        public static final RefreshMode DEFAULT_CONTAINER;
        public static final RefreshMode STANDARD;

        public static RefreshMode valueOf(String s)
        {
            return (RefreshMode)Enum.valueOf(com/google/tagmanager/TagManager$RefreshMode, s);
        }

        public static RefreshMode[] values()
        {
            return (RefreshMode[])$VALUES.clone();
        }

        static 
        {
            STANDARD = new RefreshMode("STANDARD", 0);
            DEFAULT_CONTAINER = new RefreshMode("DEFAULT_CONTAINER", 1);
            $VALUES = (new RefreshMode[] {
                STANDARD, DEFAULT_CONTAINER
            });
        }

        private RefreshMode(String s, int i)
        {
            super(s, i);
        }
    }


    private static TagManager sInstance;
    private final ContainerProvider mContainerProvider;
    private final ConcurrentMap mContainers;
    private final Context mContext;
    private volatile String mCtfeServerAddr;
    private final DataLayer mDataLayer;
    private volatile RefreshMode mRefreshMode;

    TagManager(Context context, ContainerProvider containerprovider, DataLayer datalayer)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        } else
        {
            mContext = context.getApplicationContext();
            mContainerProvider = containerprovider;
            mRefreshMode = RefreshMode.STANDARD;
            mContainers = new ConcurrentHashMap();
            mDataLayer = datalayer;
            mDataLayer.registerListener(new DataLayer.Listener() {

                final TagManager this$0;

                public void changed(Map map)
                {
                    map = ((Map) (map.get("event")));
                    if (map != null)
                    {
                        refreshTagsInAllContainers(map.toString());
                    }
                }

            
            {
                this$0 = TagManager.this;
                super();
            }
            });
            mDataLayer.registerListener(new AdwordsClickReferrerListener(mContext));
            return;
        }
    }

    public static TagManager getInstance(Context context)
    {
        com/google/tagmanager/TagManager;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new TagManager(context, new ContainerProvider() {

                public Container newContainer(Context context1, String s, TagManager tagmanager)
                {
                    return new Container(context1, s, tagmanager);
                }

            }, new DataLayer());
        }
        context = sInstance;
        com/google/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        com/google/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void refreshTagsInAllContainers(String s)
    {
        for (Iterator iterator = mContainers.values().iterator(); iterator.hasNext(); ((Container)iterator.next()).evaluateTags(s)) { }
    }

    public Container getContainer(String s)
    {
        return (Container)mContainers.get(s);
    }

    public Context getContext()
    {
        return mContext;
    }

    public DataLayer getDataLayer()
    {
        return mDataLayer;
    }

    public com.google.tagmanager.Logger getLogger()
    {
        return Log.getLogger();
    }

    public RefreshMode getRefreshMode()
    {
        return mRefreshMode;
    }

    public Container openContainer(String s, Container.Callback callback)
    {
        Container container = mContainerProvider.newContainer(mContext, s, this);
        if (mContainers.putIfAbsent(s, container) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Container id:").append(s).append(" has already been opened.").toString());
        }
        if (mCtfeServerAddr != null)
        {
            container.setCtfeServerAddress(mCtfeServerAddr);
        }
        container.load(callback);
        return container;
    }

    boolean removeContainer(String s)
    {
        return mContainers.remove(s) != null;
    }

    void setCtfeServerAddress(String s)
    {
        mCtfeServerAddr = s;
    }

    public void setLogger(com.google.tagmanager.Logger logger)
    {
        Log.setLogger(logger);
    }

    boolean setPreviewData(Uri uri)
    {
        this;
        JVM INSTR monitorenter ;
        PreviewManager previewmanager = PreviewManager.getInstance();
        if (!previewmanager.setPreviewData(uri)) goto _L2; else goto _L1
_L1:
        int i;
        uri = previewmanager.getContainerId();
        static class _cls3
        {

            static final int $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[];

            static 
            {
                $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode = new int[PreviewManager.PreviewMode.values().length];
                try
                {
                    $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewManager.PreviewMode.NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewManager.PreviewMode.CONTAINER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewManager.PreviewMode.CONTAINER_DEBUG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        i = _cls3..SwitchMap.com.google.tagmanager.PreviewManager.PreviewMode[previewmanager.getPreviewMode().ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 68
    //                   2 103
    //                   3 103;
           goto _L3 _L4 _L5 _L5
_L3:
        boolean flag = true;
_L10:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        uri = (Container)mContainers.get(uri);
        if (uri == null) goto _L3; else goto _L6
_L6:
        uri.setCtfeUrlPathAndQuery(null);
        uri.refresh();
          goto _L3
        uri;
        throw uri;
_L5:
        Iterator iterator = mContainers.entrySet().iterator();
_L8:
        Container container;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            container = (Container)entry.getValue();
            if (!((String)entry.getKey()).equals(uri))
            {
                continue; /* Loop/switch isn't completed */
            }
            container.setCtfeUrlPathAndQuery(previewmanager.getCTFEUrlPath());
            container.refresh();
        }
          goto _L3
        if (container.getCtfeUrlPathAndQuery() == null) goto _L8; else goto _L7
_L7:
        container.setCtfeUrlPathAndQuery(null);
        container.refresh();
        if (true) goto _L8; else goto _L9
_L9:
          goto _L3
_L2:
        flag = false;
          goto _L10
    }

    public void setRefreshMode(RefreshMode refreshmode)
    {
        mRefreshMode = refreshmode;
    }

}
