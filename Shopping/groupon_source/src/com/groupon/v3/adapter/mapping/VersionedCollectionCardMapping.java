// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.crittercism.app.Crittercism;
import com.groupon.db.models.DealCollection;
import com.groupon.deeplink.CollectionCardDeepLinkValidator;
import com.groupon.deeplink.DeepLinkValidator;
import com.groupon.view.widgetcards.FullBleedCollectionCardView;
import com.groupon.view.widgetcards.HiddenCollectionCardView;
import com.groupon.view.widgetcards.NativeCollectionCardView;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            CollectionCardMapping, VersionableCard, Mapping

public class VersionedCollectionCardMapping extends CollectionCardMapping
    implements VersionableCard
{

    public static final String COLLECTION_CARD_V1_REQUIRED_FIELDS[] = {
        "deepLink", "titleText", "callToActionText", "collectionSizeText"
    };
    public static final String FULL_BLEED_COLLECTION_CARD = "FullBleedCollectionCard";
    private static final int FULL_BLEED_COLLECTION_CARD_MAXIMUM_SUPPORTED_VERSION = 11000;
    private static final int MINOR_VERSION_DIGITS = 4;
    public static final String NATIVE_COLLECTION_CARD = "NativeCollectionCard";
    private static final int NATIVE_COLLECTION_CARD_MAXIMUM_SUPPORTED_VERSION = 11000;
    private final Class cardViewClass;
    private final DeepLinkValidator deepLinkValidator;
    private final int maximumSupportedVersion;
    private final Set requiredAttributes;
    private final String viewType;

    private transient VersionedCollectionCardMapping(String s, int i, Class class1, DeepLinkValidator deeplinkvalidator, String as[])
    {
        viewType = s;
        maximumSupportedVersion = i;
        cardViewClass = class1;
        requiredAttributes = new HashSet(Arrays.asList(as));
        deepLinkValidator = deeplinkvalidator;
    }

    public static Mapping create(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   -2096932487: 83
    //                   -331744539: 97;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_97;
_L4:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported view type : ").append(s).toString());

        case 0: // '\0'
            return new VersionedCollectionCardMapping("FullBleedCollectionCard", 11000, com/groupon/view/widgetcards/FullBleedCollectionCardView, new CollectionCardDeepLinkValidator(), COLLECTION_CARD_V1_REQUIRED_FIELDS);

        case 1: // '\001'
            return new VersionedCollectionCardMapping("NativeCollectionCard", 11000, com/groupon/view/widgetcards/NativeCollectionCardView, new CollectionCardDeepLinkValidator(), COLLECTION_CARD_V1_REQUIRED_FIELDS);
        }
_L2:
        if (s.equals("FullBleedCollectionCard"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("NativeCollectionCard"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    public View createView(Context context)
    {
        View view;
        try
        {
            view = (View)cardViewClass.getConstructor(new Class[] {
                android/content/Context
            }).newInstance(new Object[] {
                context
            });
        }
        catch (Exception exception)
        {
            Ln.e(exception);
            Crittercism.logHandledException(exception);
            return new HiddenCollectionCardView(context);
        }
        return view;
    }

    protected int getMaximumSupportedVersion()
    {
        return maximumSupportedVersion;
    }

    protected String getViewName()
    {
        return viewType;
    }

    public boolean isSupported(Object obj)
    {
        boolean flag = false;
        if (!(obj instanceof DealCollection))
        {
            return false;
        }
        obj = (DealCollection)obj;
        if (!getViewName().equals(((DealCollection) (obj)).templateView) || ((DealCollection) (obj)).getCardDetails() == null || ((DealCollection) (obj)).getCardDetails().isEmpty() || (new BigDecimal(((DealCollection) (obj)).templateVersion)).movePointRight(4).intValue() > getMaximumSupportedVersion()) goto _L2; else goto _L1
_L1:
        Iterator iterator = requiredAttributes.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!Strings.isEmpty(((DealCollection) (obj)).getValue((String)iterator.next(), null))) goto _L6; else goto _L5
_L5:
        return false;
_L4:
        boolean flag1 = deepLinkValidator.validateDeepLink(((DealCollection) (obj)).getValue("deepLink", null));
        flag = flag1;
_L7:
        return flag;
        obj;
        if (Ln.isDebugEnabled())
        {
            Ln.e(((Throwable) (obj)));
        } else
        {
            Crittercism.logHandledException(((Throwable) (obj)));
        }
        if (true) goto _L7; else goto _L2
_L2:
        return false;
    }

}
