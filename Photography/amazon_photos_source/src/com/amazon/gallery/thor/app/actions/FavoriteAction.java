// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.cms.KindleCMSClient;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Iterator;
import java.util.List;

public class FavoriteAction
    implements SelectionAction
{

    private KindleCMSClient cmsClient;

    public FavoriteAction(BeanAwareActivity beanawareactivity)
    {
        cmsClient = (KindleCMSClient)beanawareactivity.getApplicationBean(Keys.KINDLE_CMS_CLIENT);
    }

    private boolean isValid(Tag tag)
    {
        return BuildFlavors.isFireOS4OrOlder() && !cmsClient.checkIfAlbumIsFavorite(tag.getObjectId());
    }

    public boolean canExecute(List list)
    {
        return false;
    }

    public boolean canExecuteTags(List list)
    {
        if (list.size() != 1)
        {
            return false;
        } else
        {
            return isValid((Tag)list.get(0));
        }
    }

    public void execute(List list)
    {
    }

    public void executeTags(List list)
    {
        for (list = list.iterator(); list.hasNext(); GlobalMessagingBus.post(new ActionCompleteEvent()))
        {
            Tag tag = (Tag)list.next();
            cmsClient.addToFavourite(tag.getObjectId());
        }

    }
}
