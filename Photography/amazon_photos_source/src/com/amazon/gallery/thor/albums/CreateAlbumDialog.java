// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumTask

public class CreateAlbumDialog extends PersistentDialogFragment
{
    private final class InputValidator
    {

        private final String INVALID_CHARS;
        private final String INVALID_START_CHAR;
        private final int MAX_CHAR_LIMIT;
        final CreateAlbumDialog this$0;

        public boolean isValid(CharSequence charsequence)
        {
            while (StringUtils.isEmpty(charsequence) || charsequence.length() > 280 || StringUtils.startsWith(charsequence, ".") || StringUtils.contains(charsequence, "/")) 
            {
                return false;
            }
            return true;
        }

        private InputValidator()
        {
            this$0 = CreateAlbumDialog.this;
            super();
            MAX_CHAR_LIMIT = 280;
            INVALID_START_CHAR = ".";
            INVALID_CHARS = "/";
        }

    }


    private CharSequence albumName;
    private Dialog dialog;
    private String inputErrorString;
    private InputValidator inputValidator;
    private List mediaItemIdsToAdd;
    private ComponentProfiler profiler;

    public CreateAlbumDialog()
    {
        inputValidator = new InputValidator();
    }

    private Dialog createCustomLayoutDialog(Bundle bundle)
    {
        dialog = super.onCreateDialog(bundle);
        bundle = getActivity();
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(bundle);
        View view = LayoutInflater.from(bundle).inflate(0x7f03007a, null, false);
        final EditText albumNameInput = (EditText)view.findViewById(0x7f0c0123);
        if (albumName != null)
        {
            albumNameInput.setText(albumName);
        }
        albumNameInput.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final CreateAlbumDialog this$0;

            public void onFocusChange(View view1, boolean flag)
            {
                if (flag)
                {
                    dialog.getWindow().setSoftInputMode(5);
                }
            }

            
            {
                this$0 = CreateAlbumDialog.this;
                super();
            }
        });
        builder.setNegativeButton(bundle.getString(0x7f0e0092), new android.content.DialogInterface.OnClickListener() {

            final CreateAlbumDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                GlobalMessagingBus.post(new ActionCompleteEvent());
                dialoginterface.dismiss();
            }

            
            {
                this$0 = CreateAlbumDialog.this;
                super();
            }
        });
        builder.setPositiveButton(bundle.getString(0x7f0e0019), new android.content.DialogInterface.OnClickListener() {

            final CreateAlbumDialog this$0;
            final EditText val$albumNameInput;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                String s = albumNameInput.getText().toString();
                if (s.length() == 0)
                {
                    return;
                } else
                {
                    (new CreateAlbumTask(getActivity(), s, mediaItemIdsToAdd, profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    GlobalMessagingBus.post(new ActionCompleteEvent());
                    dialoginterface.dismiss();
                    return;
                }
            }

            
            {
                this$0 = CreateAlbumDialog.this;
                albumNameInput = edittext;
                super();
            }
        });
        builder.setView(view);
        dialog = builder.create();
        dialog.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final CreateAlbumDialog this$0;
            final EditText val$albumNameInput;

            public void onShow(DialogInterface dialoginterface)
            {
                dialoginterface = ((AlertDialog)dialoginterface).getButton(-1);
                boolean flag;
                if (!StringUtils.isEmpty(albumNameInput.getText()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                dialoginterface.setEnabled(flag);
            }

            
            {
                this$0 = CreateAlbumDialog.this;
                albumNameInput = edittext;
                super();
            }
        });
        albumNameInput.addTextChangedListener(new TextWatcher() {

            final CreateAlbumDialog this$0;
            final EditText val$albumNameInput;

            public void afterTextChanged(Editable editable)
            {
                Button button = ((AlertDialog)dialog).getButton(-1);
                if (StringUtils.isEmpty(editable))
                {
                    button.setEnabled(false);
                    return;
                }
                if (!inputValidator.isValid(editable))
                {
                    button.setEnabled(false);
                    albumNameInput.setError(inputErrorString);
                    return;
                } else
                {
                    button.setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = CreateAlbumDialog.this;
                albumNameInput = edittext;
                super();
            }
        });
        return dialog;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        inputErrorString = getActivity().getString(0x7f0e001d);
        dialog = createCustomLayoutDialog(bundle);
        return dialog;
    }

    public void setAlbumName(CharSequence charsequence)
    {
        albumName = charsequence;
    }

    public void setMediaItemsList(List list)
    {
        mediaItemIdsToAdd = list;
    }

    public void setProfiler(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
    }





}
