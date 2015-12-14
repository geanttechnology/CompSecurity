// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.whisperplay;

import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.view.ViewDescriptorQuery;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.whisperplay.NoOpWhisperPlayConnectionManager;

public class WhisperPlayConnectionManagerWrapper extends NoOpWhisperPlayConnectionManager
{

    public WhisperPlayConnectionManagerWrapper(Context context, RestClient restclient, NetworkStore networkstore, DiskStore diskstore, MediaItemDao mediaitemdao, TagDao tagdao, ViewDescriptorQuery viewdescriptorquery, 
            Profiler profiler, AuthenticationManager authenticationmanager)
    {
    }
}
