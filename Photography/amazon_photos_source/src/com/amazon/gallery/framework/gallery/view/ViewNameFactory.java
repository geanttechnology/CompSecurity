// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import com.amazon.gallery.thor.thisday.ThisDayViewDescriptor;

// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewDescriptor

public class ViewNameFactory
{

    public static String getTitle(ViewDescriptor viewdescriptor, Context context)
    {
        int i = 0x7f0e0068;
        Resources resources = context.getResources();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[ViewDescriptor.CollectionType.TAG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[ViewDescriptor.CollectionType.DYNAMIC_ALBUM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[viewdescriptor.getCollectionType().ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return resources.getString(0x7f0e0066);

        case 2: // '\002'
        case 3: // '\003'
            return getTitle(viewdescriptor.getTag(), context);

        case 4: // '\004'
            if (viewdescriptor.getMediaProperty().equals(CommonMediaProperty.CAMERA))
            {
                return resources.getString(0x7f0e0098);
            }
            if (viewdescriptor.getMediaProperty().equals(CommonMediaProperty.FAVORITE))
            {
                return resources.getString(0x7f0e006a);
            }
            if (viewdescriptor.getMediaProperty().equals(CommonMediaProperty.LOCAL))
            {
                return resources.getString(0x7f0e0068);
            }
            if (viewdescriptor.getMediaProperty().equals(CommonMediaProperty.THISDAY))
            {
                if (viewdescriptor.getThisDayViewDescriptor().isShuffleData)
                {
                    return resources.getString(0x7f0e0216);
                } else
                {
                    return ThisDayUtils.getTitleForThisDayCard(context, viewdescriptor.getThisDayViewDescriptor().focusedYear);
                }
            }
            DebugAssert.assertTrue(true, (new StringBuilder()).append("Unexpected property: ").append(viewdescriptor.getMediaProperty()).toString());
            break;

        case 5: // '\005'
            break;
        }
        if (viewdescriptor.getMediaType() == MediaType.PHOTO)
        {
            if (viewdescriptor.isLocalOnly())
            {
                if (viewdescriptor.isSdCardOnly())
                {
                    i = 0x7f0e006f;
                }
                return resources.getString(i);
            } else
            {
                return resources.getString(0x7f0e0066);
            }
        }
        if (viewdescriptor.isLocalOnly())
        {
            int j;
            if (viewdescriptor.isSdCardOnly())
            {
                j = 0x7f0e0070;
            } else
            {
                j = 0x7f0e0069;
            }
            return resources.getString(j);
        } else
        {
            return resources.getString(0x7f0e0073);
        }
    }

    public static String getTitle(Tag tag, Context context)
    {
        String s;
        if (tag.hasProperty(TagProperty.YOUR_CLOUD_DRIVE))
        {
            s = context.getResources().getString(0x7f0e009a);
        } else
        if (!BuildFlavors.isAosp() && tag.hasProperty(TagProperty.CAMERA))
        {
            String s1 = context.getResources().getString(0x7f0e0098);
            s = s1;
            if (tag.hasProperty(TagProperty.REMOVABLE))
            {
                return (new StringBuilder()).append(s1).append(" ").append(context.getResources().getString(0x7f0e0205)).toString();
            }
        } else
        {
            return tag.getLabel();
        }
        return s;
    }
}
