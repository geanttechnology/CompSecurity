// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IWeiboDownloadListener

public class WeiboDownloader
{

    private static final String CANCEL_CHINESS = "\u4EE5\u540E\u518D\u8BF4";
    private static final String CANCEL_ENGLISH = "Download Later";
    private static final String OK_CHINESS = "\u73B0\u5728\u4E0B\u8F7D";
    private static final String OK_ENGLISH = "Download Now";
    private static final String PROMPT_CHINESS = "\u672A\u5B89\u88C5\u5FAE\u535A\u5BA2\u6237\u7AEF\uFF0C\u662F\u5426\u73B0\u5728\u53BB\u4E0B\u8F7D\uFF1F";
    private static final String PROMPT_ENGLISH = "Sina Weibo client is not installed, download now?";
    private static final String TITLE_CHINESS = "\u63D0\u793A";
    private static final String TITLE_ENGLISH = "Notice";

    public WeiboDownloader()
    {
    }

    public static Dialog createDownloadConfirmDialog(final Context context, final IWeiboDownloadListener listener)
    {
        String s3 = "\u63D0\u793A";
        String s2 = "\u672A\u5B89\u88C5\u5FAE\u535A\u5BA2\u6237\u7AEF\uFF0C\u662F\u5426\u73B0\u5728\u53BB\u4E0B\u8F7D\uFF1F";
        String s1 = "\u73B0\u5728\u4E0B\u8F7D";
        String s = "\u4EE5\u540E\u518D\u8BF4";
        if (!Utility.isChineseLocale(context.getApplicationContext()))
        {
            s3 = "Notice";
            s2 = "Sina Weibo client is not installed, download now?";
            s1 = "Download Now";
            s = "Download Later";
        }
        return (new android.app.AlertDialog.Builder(context)).setMessage(s2).setTitle(s3).setPositiveButton(s1, new android.content.DialogInterface.OnClickListener() {

            private final Context val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                WeiboDownloader.downloadWeibo(context);
            }

            
            {
                context = context1;
                super();
            }
        }).setNegativeButton(s, new android.content.DialogInterface.OnClickListener() {

            private final IWeiboDownloadListener val$listener;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (listener != null)
                {
                    listener.onCancel();
                }
            }

            
            {
                listener = iweibodownloadlistener;
                super();
            }
        }).create();
    }

    private static void downloadWeibo(Context context)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.setData(Uri.parse("http://app.sina.cn/appdetail.php?appID=84560"));
        try
        {
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

}
