// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumMediaItemAction, CreateAlbumHelper

public class CreateAlbumAction extends AlbumMediaItemAction
{

    private final AuthenticationManager authenticationManager;
    private final Context context;
    private final SharedPreferences sharedPrefs;

    public CreateAlbumAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e001a);
        context = activity;
        sharedPrefs = activity.getSharedPreferences("galleryKindleSharedPrefs", 0);
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        while (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE || viewdescriptor.getMediaProperty() == CommonMediaProperty.LOCAL || viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA) 
        {
            do
            {
                return false;
            } while (!authenticationManager.hasActiveAccount() || !sharedPrefs.getBoolean("coldBootStatus", false) || mediaitem != null);
            if (viewdescriptor == null)
            {
                break;
            }
            if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING)
            {
                return true;
            }
        }
        if (getTagFromViewDescriptor(viewdescriptor) != null)
        {
            flag = false;
        }
        return flag;
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = (PhotosDemoManager)ThorGalleryApplication.getBean(Keys.DEMO_MANAGER);
        if (viewdescriptor != null && viewdescriptor.isInDemoMode())
        {
            viewdescriptor.showWarningForUnavailableAction((Activity)context);
        } else
        if (!networkConnectivity.promptIfOffline(context))
        {
            (new CreateAlbumHelper((BeanAwareActivity)context, profiler)).execute();
            return;
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return false;
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
    }
}
