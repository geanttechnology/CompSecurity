// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            VastResourceXmlManager, VastWebView

class VastResource
    implements Serializable
{
    static final class CreativeType extends Enum
    {

        private static final CreativeType $VALUES[];
        public static final CreativeType IMAGE;
        public static final CreativeType JAVASCRIPT;
        public static final CreativeType NONE;

        public static CreativeType valueOf(String s)
        {
            return (CreativeType)Enum.valueOf(com/mopub/mobileads/VastResource$CreativeType, s);
        }

        public static CreativeType[] values()
        {
            return (CreativeType[])$VALUES.clone();
        }

        static 
        {
            NONE = new CreativeType("NONE", 0);
            IMAGE = new CreativeType("IMAGE", 1);
            JAVASCRIPT = new CreativeType("JAVASCRIPT", 2);
            $VALUES = (new CreativeType[] {
                NONE, IMAGE, JAVASCRIPT
            });
        }

        private CreativeType(String s, int i)
        {
            super(s, i);
        }
    }

    static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type HTML_RESOURCE;
        public static final Type IFRAME_RESOURCE;
        public static final Type STATIC_RESOURCE;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/mopub/mobileads/VastResource$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            STATIC_RESOURCE = new Type("STATIC_RESOURCE", 0);
            HTML_RESOURCE = new Type("HTML_RESOURCE", 1);
            IFRAME_RESOURCE = new Type("IFRAME_RESOURCE", 2);
            $VALUES = (new Type[] {
                STATIC_RESOURCE, HTML_RESOURCE, IFRAME_RESOURCE
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    private static final List VALID_APPLICATION_TYPES = Arrays.asList(new String[] {
        "application/x-javascript"
    });
    private static final List VALID_IMAGE_TYPES = Arrays.asList(new String[] {
        "image/jpeg", "image/png", "image/bmp", "image/gif"
    });
    private static final long serialVersionUID = 0L;
    private CreativeType mCreativeType;
    private int mHeight;
    private String mResource;
    private Type mType;
    private int mWidth;

    VastResource(String s, Type type, CreativeType creativetype, int i, int j)
    {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(creativetype);
        mResource = s;
        mType = type;
        mCreativeType = creativetype;
        mWidth = i;
        mHeight = j;
    }

    static VastResource fromVastResourceXmlManager(VastResourceXmlManager vastresourcexmlmanager, int i, int j)
    {
        Type atype[] = Type.values();
        int l = atype.length;
        for (int k = 0; k < l; k++)
        {
            VastResource vastresource = fromVastResourceXmlManager(vastresourcexmlmanager, atype[k], i, j);
            if (vastresource != null)
            {
                return vastresource;
            }
        }

        return null;
    }

    static VastResource fromVastResourceXmlManager(VastResourceXmlManager vastresourcexmlmanager, Type type, int i, int j)
    {
        Preconditions.checkNotNull(vastresourcexmlmanager);
        Preconditions.checkNotNull(type);
        String s = vastresourcexmlmanager.getIFrameResource();
        String s1 = vastresourcexmlmanager.getHTMLResource();
        String s2 = vastresourcexmlmanager.getStaticResource();
        vastresourcexmlmanager = vastresourcexmlmanager.getStaticResourceType();
        if (type == Type.STATIC_RESOURCE && s2 != null && vastresourcexmlmanager != null && (VALID_IMAGE_TYPES.contains(vastresourcexmlmanager) || VALID_APPLICATION_TYPES.contains(vastresourcexmlmanager)))
        {
            s = s2;
            if (VALID_IMAGE_TYPES.contains(vastresourcexmlmanager))
            {
                vastresourcexmlmanager = CreativeType.IMAGE;
            } else
            {
                vastresourcexmlmanager = CreativeType.JAVASCRIPT;
            }
        } else
        if (type == Type.HTML_RESOURCE && s1 != null)
        {
            s = s1;
            vastresourcexmlmanager = CreativeType.NONE;
        } else
        if (type == Type.IFRAME_RESOURCE && s != null)
        {
            vastresourcexmlmanager = CreativeType.NONE;
        } else
        {
            return null;
        }
        return new VastResource(s, type, vastresourcexmlmanager, i, j);
    }

    public String getCorrectClickThroughUrl(String s, String s1)
    {
        String s2 = s1;
        static class _cls1
        {

            static final int $SwitchMap$com$mopub$mobileads$VastResource$Type[];

            static 
            {
                $SwitchMap$com$mopub$mobileads$VastResource$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$com$mopub$mobileads$VastResource$Type[Type.STATIC_RESOURCE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$mobileads$VastResource$Type[Type.HTML_RESOURCE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$mobileads$VastResource$Type[Type.IFRAME_RESOURCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.mopub.mobileads.VastResource.Type[mType.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 44
    //                   2 42
    //                   3 42;
           goto _L1 _L2 _L3 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        s2 = null;
_L5:
        return s2;
_L2:
        if (CreativeType.IMAGE == mCreativeType)
        {
            return s;
        }
        s2 = s1;
        if (CreativeType.JAVASCRIPT != mCreativeType)
        {
            return null;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public CreativeType getCreativeType()
    {
        return mCreativeType;
    }

    public String getResource()
    {
        return mResource;
    }

    public Type getType()
    {
        return mType;
    }

    public void initializeWebView(VastWebView vastwebview)
    {
        Preconditions.checkNotNull(vastwebview);
        if (mType == Type.IFRAME_RESOURCE)
        {
            vastwebview.loadData((new StringBuilder()).append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"").append(mWidth).append("\" height=\"").append(mHeight).append("\" src=\"").append(mResource).append("\"></iframe>").toString());
        } else
        {
            if (mType == Type.HTML_RESOURCE)
            {
                vastwebview.loadData(mResource);
                return;
            }
            if (mType == Type.STATIC_RESOURCE)
            {
                if (mCreativeType == CreativeType.IMAGE)
                {
                    vastwebview.loadData((new StringBuilder()).append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"").append(mResource).append("\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" />").append("</body>").append("</html>").toString());
                    return;
                }
                if (mCreativeType == CreativeType.JAVASCRIPT)
                {
                    vastwebview.loadData((new StringBuilder()).append("<script src=\"").append(mResource).append("\"></script>").toString());
                    return;
                }
            }
        }
    }

}
