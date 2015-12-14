// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;
import com.amazon.gallery.framework.model.tags.Tag;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumPickerAdapter, CreateAlbumHelper

public class AddToAlbumDialog extends PersistentDialogFragment
{

    private AlbumPickerAdapter albumAdapter;
    private Multimap albumMap;
    private List albums;
    private Dialog dialog;
    private EditText filterText;
    private List mediaItemIds;
    private ComponentProfiler profiler;

    public AddToAlbumDialog()
    {
    }

    private Dialog createCustomLayoutDialog(final Bundle activity)
    {
        dialog = super.onCreateDialog(activity);
        activity = getActivity();
        Object obj = getArguments();
        if (obj != null)
        {
            obj = ((Bundle) (obj)).getStringArrayList("media_item_ids");
            if (obj != null)
            {
                mediaItemIds = new ArrayList(((List) (obj)).size());
                mediaItemIds.addAll(((java.util.Collection) (obj)));
            }
        }
        albumMap = ArrayListMultimap.create();
        Tag tag;
        for (obj = albums.iterator(); ((Iterator) (obj)).hasNext(); albumMap.put(tag.getLabel().toLowerCase(), tag))
        {
            tag = (Tag)((Iterator) (obj)).next();
        }

        obj = new android.support.v7.app.AlertDialog.Builder(activity);
        View view = LayoutInflater.from(activity).inflate(0x7f030019, null, false);
        ListView listview = (ListView)view.findViewById(0x7f0c0083);
        listview.setTextFilterEnabled(true);
        filterText = (EditText)view.findViewById(0x7f0c0082);
        filterText.addTextChangedListener(new TextWatcher() {

            final AddToAlbumDialog this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                charsequence = charsequence.toString().trim();
                albumAdapter.getFilter().filter(charsequence);
                albumAdapter.setFilterText(charsequence);
                filterText.setError(null);
            }

            
            {
                this$0 = AddToAlbumDialog.this;
                super();
            }
        });
        ((android.support.v7.app.AlertDialog.Builder) (obj)).setView(view);
        dialog = ((android.support.v7.app.AlertDialog.Builder) (obj)).create();
        view.findViewById(0x7f0c0080).setOnClickListener(new android.view.View.OnClickListener() {

            final AddToAlbumDialog this$0;
            final Activity val$activity;

            public void onClick(View view1)
            {
                GlobalMessagingBus.post(new ActionCompleteEvent());
                dialog.dismiss();
                (new CreateAlbumHelper((BeanAwareActivity)activity, profiler, filterText.getText(), mediaItemIds)).execute();
            }

            
            {
                this$0 = AddToAlbumDialog.this;
                activity = activity1;
                super();
            }
        });
        albumAdapter = new AlbumPickerAdapter(activity, albums, mediaItemIds, dialog, profiler);
        listview.setAdapter(albumAdapter);
        dialog.getWindow().setSoftInputMode(16);
        return dialog;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        dialog = createCustomLayoutDialog(bundle);
        dialog.getWindow().setSoftInputMode(2);
        return dialog;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        albumAdapter.cleanUp();
    }

    public void setAlbumsList(List list)
    {
        albums = list;
    }

    public void setProfiler(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
    }





}
