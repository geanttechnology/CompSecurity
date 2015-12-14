// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.thor.app.activity.CollectionListPickActivity;
import java.util.EnumSet;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            Page

public class IntentPage extends Page
{

    private static final String PRESERVED_STRING_EXTRAS[] = {
        "imageMediaType"
    };
    private final Class chooserClass;
    protected Intent intent;

    public IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent metricsevent, Intent intent1, Class class1)
    {
        super(metricsevent, EnumSet.noneOf(com/amazon/gallery/framework/kindle/activity/Page$VisibilityFlag));
        intent = intent1;
        chooserClass = class1;
    }

    public IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent metricsevent, Intent intent1, Class class1, EnumSet enumset)
    {
        super(metricsevent, enumset);
        intent = intent1;
        chooserClass = class1;
    }

    public IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent metricsevent, Intent intent1, EnumSet enumset)
    {
        super(metricsevent, enumset);
        intent = intent1;
        chooserClass = null;
    }

    public static Intent getHelpIntent()
    {
        Intent intent1 = new Intent("com.amazon.kindle.otter.csapp.ACTION_LAUNCH_CS_APP");
        intent1.putExtra("ApplicationName", "Photos");
        intent1.putExtra("ApplicationVersion", "1.0");
        intent1.putExtra("ApplicationHelpContext", "AmazonPhotos");
        intent1.putExtra("Mode", "online");
        return intent1;
    }

    public static Intent getSettingsIntent()
    {
        Intent intent1 = new Intent();
        intent1.setAction("android.intent.action.VIEW");
        intent1.addCategory("amazon.intent.category.PHOTOS_SETTINGS");
        intent1.putExtra("com.amazon.photos.FROM_PHOTOS", true);
        return intent1;
    }

    protected static void preserveChooserState(Intent intent1, Intent intent2)
    {
        if (intent1.hasExtra("CHOOSER_ACTION"))
        {
            intent2.putExtra("CHOOSER_ACTION", intent1.getStringExtra("CHOOSER_ACTION"));
        } else
        {
            intent2.putExtra("CHOOSER_ACTION", intent1.getAction());
        }
        if (StringUtils.isNotEmpty(intent1.getType()))
        {
            intent2.putExtra("imageMediaType", intent1.getType());
        }
    }

    protected static void preserveExtras(Intent intent1, Intent intent2)
    {
        String as[] = PRESERVED_STRING_EXTRAS;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (intent1.hasExtra(s))
            {
                intent2.putExtra(s, intent1.getStringExtra(s));
            }
        }

    }

    public boolean onClick(Activity activity)
    {
        Intent intent1 = new Intent(intent);
        Intent intent3 = activity.getIntent();
        Intent intent2 = intent1;
        if (IntentUtil.isChooser(intent3))
        {
            if (chooserClass != null)
            {
                intent2 = new Intent(activity, chooserClass);
                intent2.putExtras(intent);
                intent1 = intent2;
                if (chooserClass.equals(com/amazon/gallery/thor/app/activity/CollectionListPickActivity))
                {
                    intent2.addFlags(0x40000000);
                    intent1 = intent2;
                }
            }
            preserveChooserState(intent3, intent1);
            intent2 = intent1;
            if (StringUtils.isNotEmpty(intent3.getType()))
            {
                intent1.setType(intent3.getType());
                intent2 = intent1;
            }
        }
        preserveExtras(intent3, intent2);
        activity.startActivity(intent2);
        return true;
    }

}
