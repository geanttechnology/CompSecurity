// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            ImageLoader, CommentsActivity

public class CommentsPopup
{

    Activity mActivity;
    Context mContext;
    Map mixtape;

    public CommentsPopup(Activity activity, Context context, Map map)
    {
        mActivity = activity;
        mContext = context;
        mixtape = map;
    }

    public Uri getLocalUriFromBitmap(Bitmap bitmap)
    {
        try
        {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), (new StringBuilder("share_image_")).append(System.currentTimeMillis()).append(".png").toString());
            file.getParentFile().mkdirs();
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
            fileoutputstream.close();
            bitmap = Uri.fromFile(file);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return null;
        }
        return bitmap;
    }

    void shareSocialNetworks(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (s.equals("com.instagram.android"))
        {
            intent.setType("image/*");
        }
        intent.putExtra("android.intent.extra.TEXT", (String)mixtape.get("sharetext"));
        intent.putExtra("android.intent.extra.STREAM", getLocalUriFromBitmap((new ImageLoader(mContext)).getBitmap((String)mixtape.get("cover"))));
        Iterator iterator = mActivity.getPackageManager().queryIntentActivities(intent, 0).iterator();
        ResolveInfo resolveinfo;
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            resolveinfo = (ResolveInfo)iterator.next();
        } while (!resolveinfo.activityInfo.packageName.equals(s));
        s = resolveinfo.activityInfo;
        s = new ComponentName(((ActivityInfo) (s)).applicationInfo.packageName, ((ActivityInfo) (s)).name);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(0x10200000);
        intent.setComponent(s);
        mActivity.startActivity(intent);
    }

    void showPopup(final FrameLayout frameLayout, ImageButton imagebutton)
    {
        Object obj = mActivity.getWindowManager().getDefaultDisplay();
        final PopupWindow popupWindow = new Point();
        ((Display) (obj)).getSize(popupWindow);
        int i = ((Point) (popupWindow)).x;
        int j = ((Point) (popupWindow)).y;
        obj = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f03001b, null);
        popupWindow = new PopupWindow(((View) (obj)), (i * 3) / 4, (j * 3) / 5);
        popupWindow.setAnimationStyle(0x1030002);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.showAtLocation(imagebutton, 17, 0, 40);
        popupWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {

            final CommentsPopup this$0;
            private final FrameLayout val$frameLayout;

            public void onDismiss()
            {
                frameLayout.getForeground().setAlpha(0);
            }

            
            {
                this$0 = CommentsPopup.this;
                frameLayout = framelayout;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080063)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                view = new Intent(mContext, com/livemixtapes/CommentsActivity);
                view.putExtra("mixTapeId", mixtape.get("id").toString());
                mContext.startActivity(view);
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f08006b)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080064)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                shareSocialNetworks("com.facebook.katana");
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080065)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                shareSocialNetworks("com.twitter.android");
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080066)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                shareSocialNetworks("com.instagram.android");
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080068)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                view = new Intent("android.intent.action.SEND");
                view.setData(Uri.parse("mailto:"));
                view.setType("plain/text");
                view.putExtra("android.intent.extra.SUBJECT", (String)mixtape.get("title"));
                view.putExtra("android.intent.extra.TEXT", (String)mixtape.get("sharetext"));
                mContext.startActivity(Intent.createChooser(view, "Send Email"));
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080069)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                view = new Intent("android.intent.action.VIEW");
                view.setData(Uri.parse("sms:"));
                view.putExtra("sms_body", (String)mixtape.get("sharetext"));
                mContext.startActivity(view);
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f080067)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                shareSocialNetworks("com.tumblr");
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        ((ImageButton)((View) (obj)).findViewById(0x7f08006a)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsPopup this$0;
            private final PopupWindow val$popupWindow;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                ((ClipboardManager)mActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", (String)mixtape.get("sharetext")));
            }

            
            {
                this$0 = CommentsPopup.this;
                popupWindow = popupwindow;
                super();
            }
        });
        frameLayout.getForeground().setAlpha(135);
    }
}
