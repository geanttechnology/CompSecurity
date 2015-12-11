// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.operations;

import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;
import java.io.File;

public class ReportABugEmailSender
{

    private static final MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");
    private File attachment;
    private String body;
    private Context context;
    private String title;

    public ReportABugEmailSender(Context context1)
    {
        context = context1;
    }

    public ReportABugEmailSender addAttachment(File file)
    {
        if (file != null && file.exists())
        {
            attachment = file;
        }
        return this;
    }

    public void sendMail()
        throws Exception
    {
        MultipartBuilder multipartbuilder = (new MultipartBuilder()).type(MultipartBuilder.FORM).addFormDataPart("data", body).addFormDataPart("title", title);
        if (attachment != null)
        {
            multipartbuilder.addPart(Headers.of(new String[] {
                "Content-Disposition", "form-data; name=\"image\""
            }), RequestBody.create(MEDIA_TYPE_JPEG, attachment));
        }
        String s = context.getString(0x7f08050f);
        (new SyncHttp(context, java/lang/String, s, multipartbuilder.build())).method("POST").call();
    }

    public ReportABugEmailSender setEmailBody(String s)
    {
        body = s;
        return this;
    }

    public ReportABugEmailSender setEmailSubject(String s)
    {
        title = s;
        return this;
    }

}
