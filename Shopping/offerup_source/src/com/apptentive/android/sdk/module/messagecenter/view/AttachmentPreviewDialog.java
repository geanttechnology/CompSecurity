// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import com.apptentive.android.sdk.module.rating.view.ApptentiveBaseDialog;
import com.apptentive.android.sdk.util.ImageUtil;
import com.apptentive.android.sdk.util.Util;
import java.io.FileNotFoundException;

public class AttachmentPreviewDialog extends ApptentiveBaseDialog
{

    private OnAttachmentAcceptedListener listener;

    public AttachmentPreviewDialog(Context context)
    {
        super(context, com.apptentive.android.sdk.R.layout.apptentive_message_center_attachment_preview);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.no)).setOnClickListener(new _cls1());
        ((ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.yes)).setOnClickListener(new _cls2());
    }

    public void setImage(Uri uri)
    {
        Uri uri1;
        ImageView imageview;
        uri1 = null;
        imageview = (ImageView)findViewById(com.apptentive.android.sdk.R.id.image);
        uri = getContext().getContentResolver().openInputStream(uri);
        uri1 = uri;
        final Bitmap thumbnail = ImageUtil.createLightweightScaledBitmapFromStream(uri, 200, 300, null);
        Util.ensureClosed(uri);
        if (thumbnail == null)
        {
            return;
        } else
        {
            imageview.setImageBitmap(thumbnail);
            setOnDismissListener(new _cls3());
            return;
        }
        uri;
        uri = null;
_L2:
        Util.ensureClosed(uri);
        return;
        uri;
        Util.ensureClosed(uri1);
        throw uri;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setOnAttachmentAcceptedListener(OnAttachmentAcceptedListener onattachmentacceptedlistener)
    {
        listener = onattachmentacceptedlistener;
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final AttachmentPreviewDialog this$0;

        public void onClick(View view)
        {
            dismiss();
        }

        _cls1()
        {
            this$0 = AttachmentPreviewDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final AttachmentPreviewDialog this$0;

        public void onClick(View view)
        {
            if (listener != null)
            {
                listener.onAttachmentAccepted();
                dismiss();
            }
        }

        _cls2()
        {
            this$0 = AttachmentPreviewDialog.this;
            super();
        }

        private class OnAttachmentAcceptedListener
        {

            public abstract void onAttachmentAccepted();
        }

    }


    private class _cls3
        implements android.content.DialogInterface.OnDismissListener
    {

        final AttachmentPreviewDialog this$0;
        final Bitmap val$thumbnail;

        public void onDismiss(DialogInterface dialoginterface)
        {
            thumbnail.recycle();
            System.gc();
        }

        _cls3()
        {
            this$0 = AttachmentPreviewDialog.this;
            thumbnail = bitmap;
            super();
        }
    }

}
