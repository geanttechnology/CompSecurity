// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.FloatMath;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity, ViewItUtil, CameraBgHelper, FSEGraphic, 
//            CameraPreview

public class ViewItScreenOverlay
{

    private String mDescriptionLine1;
    private String mDescriptionLine2;
    private int mInstructionalTextHeight;
    private String mOverLayStartText;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStatus;
    private String mSteadyText;

    public ViewItScreenOverlay(FSECameraActivity fsecameraactivity)
    {
        mOverLayStartText = fsecameraactivity.getString(com.amazon.mShop.android.lib.R.string.scanit_search_camera_overlay_start_text);
        mSteadyText = fsecameraactivity.getString(com.amazon.mShop.android.lib.R.string.scanit_search_camera_overlay_steady);
        mDescriptionLine1 = fsecameraactivity.getString(com.amazon.mShop.android.lib.R.string.scanit_search_camera_overlay_info_text_line1);
        mDescriptionLine2 = fsecameraactivity.getString(com.amazon.mShop.android.lib.R.string.scanit_search_camera_overlay_info_text_line2);
        mInstructionalTextHeight = fsecameraactivity.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_barcode_scan_toolbar_height);
        mStatus = mOverLayStartText;
        fsecameraactivity = ViewItUtil.getScreenSize(fsecameraactivity);
        mScreenWidth = ((Point) (fsecameraactivity)).x;
        mScreenHeight = ((Point) (fsecameraactivity)).y;
    }

    private Rect getScanBoxRect(FSECameraActivity fsecameraactivity)
    {
        int i = mScreenWidth;
        int j = mScreenHeight - mInstructionalTextHeight * 2;
        float f;
        float f1;
        float f2;
        float f3;
        if (fsecameraactivity.getResources().getConfiguration().orientation == 1)
        {
            f1 = (float)i / 1.4F;
            f = f1 * 0.75F;
        } else
        {
            f = (float)j / 1.4F;
            f1 = f / 0.75F;
        }
        f2 = ((float)i - f1) / 2.0F;
        f3 = ((float)j - f) / 2.0F + (float)mInstructionalTextHeight;
        return new Rect((int)FloatMath.floor(f2), (int)Math.floor(f3), (int)FloatMath.ceil(f2 + f1), (int)Math.ceil(f3 + f));
    }

    private void initPaint(Paint paint)
    {
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setARGB(255, 255, 255, 255);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setTypeface(Typeface.DEFAULT);
    }

    public void drawScreenOverlay(FSECameraActivity fsecameraactivity, Canvas canvas, List list, CameraPreview camerapreview, boolean flag)
    {
        int j = fsecameraactivity.getCameraBgHelper().getCameraScreenMarginLeft();
        if (!fsecameraactivity.mIsBarcodeScanOnly)
        {
            if (!Util.isEmpty(list))
            {
                for (fsecameraactivity = list.iterator(); fsecameraactivity.hasNext(); ((FSEGraphic)fsecameraactivity.next()).draw(canvas, camerapreview)) { }
            }
        } else
        {
            if (j != 0)
            {
                canvas.save();
                canvas.translate(Math.abs(j), 0.0F);
            }
            int i = fsecameraactivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.photo_capture_dark_background);
            int i1 = fsecameraactivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.photo_capture_light_background);
            int k = fsecameraactivity.getWindowManager().getDefaultDisplay().getWidth();
            int l = fsecameraactivity.getWindowManager().getDefaultDisplay().getHeight();
            list = new Paint();
            camerapreview = new Rect();
            list.setStyle(android.graphics.Paint.Style.FILL);
            list.setColor(i);
            camerapreview.set(0, 0, k, (int)((double)mInstructionalTextHeight * 0.75D));
            canvas.drawRect(camerapreview, list);
            list.setShader(new LinearGradient(0.0F, (int)((double)mInstructionalTextHeight * 0.75D), 0.0F, mInstructionalTextHeight, i, i1, android.graphics.Shader.TileMode.CLAMP));
            camerapreview.set(0, (int)((double)mInstructionalTextHeight * 0.75D), k, mInstructionalTextHeight);
            canvas.drawRect(camerapreview, list);
            list.setShader(new LinearGradient(0.0F, l - mInstructionalTextHeight, 0.0F, l - (int)((double)mInstructionalTextHeight * 0.75D), i1, i, android.graphics.Shader.TileMode.CLAMP));
            camerapreview.set(0, l - mInstructionalTextHeight, k, l - (int)((double)mInstructionalTextHeight * 0.75D));
            canvas.drawRect(camerapreview, list);
            list.setColor(i);
            camerapreview.set(0, l - (int)((double)mInstructionalTextHeight * 0.75D), k, l);
            canvas.drawRect(camerapreview, list);
            list = new TextPaint();
            initPaint(list);
            list.setTextSize(fsecameraactivity.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.scanit_help_text_font_size));
            list.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            float f = -list.ascent() + list.descent();
            camerapreview = UIUtils.breakLines(mStatus, 5, list, k - (int)(2.0F * fsecameraactivity.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.a9_barcode_scanit_overlay_view_instructional_text_padding)));
            if (camerapreview != null)
            {
                for (i = 0; i < camerapreview.size(); i++)
                {
                    canvas.drawText((String)camerapreview.get(i), (float)k / 2.0F, ((float)mInstructionalTextHeight - (float)camerapreview.size() * f) / 2.0F + (float)i * f + -list.ascent(), list);
                }

            }
            list = new Paint();
            initPaint(list);
            list.setTextSize(fsecameraactivity.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.scanit_bottom_description_text_font_size));
            f = -list.ascent();
            float f1 = list.descent();
            canvas.drawText(mDescriptionLine1, (float)k / 2.0F, ((float)(l - mInstructionalTextHeight / 2) - (f + f1)) + -list.ascent(), list);
            canvas.drawText(mDescriptionLine2, (float)k / 2.0F, (float)(l - mInstructionalTextHeight / 2) + -list.ascent(), list);
            list = new Paint();
            list.setStyle(android.graphics.Paint.Style.STROKE);
            list.setStrokeWidth(5F);
            if (flag)
            {
                i = 0xff00ff00;
            } else
            {
                i = fsecameraactivity.getResources().getColor(com.amazon.mShop.android.lib.R.color.view_it_screen_rect_orange_line);
            }
            list.setColor(i);
            fsecameraactivity = getScanBoxRect(fsecameraactivity);
            i = ((Rect) (fsecameraactivity)).left;
            k = ((Rect) (fsecameraactivity)).top - 18;
            l = ((Rect) (fsecameraactivity)).right;
            i1 = ((Rect) (fsecameraactivity)).bottom + 18;
            canvas.drawLine(i, k, l, k, list);
            canvas.drawLine(i, i1, l, i1, list);
            list.setStrokeWidth(3F);
            list.setStyle(android.graphics.Paint.Style.FILL);
            fsecameraactivity = new Path();
            fsecameraactivity.moveTo(i, k);
            fsecameraactivity.lineTo(i, k + 18);
            fsecameraactivity.lineTo(i + 18, k);
            fsecameraactivity.close();
            canvas.drawPath(fsecameraactivity, list);
            fsecameraactivity.moveTo(l, k);
            fsecameraactivity.lineTo(l, k + 18);
            fsecameraactivity.lineTo(l - 18, k);
            fsecameraactivity.close();
            canvas.drawPath(fsecameraactivity, list);
            fsecameraactivity.moveTo(i, i1);
            fsecameraactivity.lineTo(i, i1 - 18);
            fsecameraactivity.lineTo(i + 18, i1);
            fsecameraactivity.close();
            canvas.drawPath(fsecameraactivity, list);
            fsecameraactivity.moveTo(l, i1);
            fsecameraactivity.lineTo(l, i1 - 18);
            fsecameraactivity.lineTo(l - 18, i1);
            fsecameraactivity.close();
            canvas.drawPath(fsecameraactivity, list);
            f = (float)k + (float)(i1 - k) * 0.5F;
            fsecameraactivity = new Paint();
            fsecameraactivity.setARGB(255, 153, 0, 0);
            fsecameraactivity.setStrokeWidth(2.0F);
            fsecameraactivity.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawLine(i + 18, f, l - 18, f, fsecameraactivity);
            if (j != 0)
            {
                canvas.restore();
            }
        }
    }

    public void setSteadyStatus(boolean flag)
    {
        String s;
        if (flag)
        {
            s = mOverLayStartText;
        } else
        {
            s = mSteadyText;
        }
        mStatus = s;
    }
}
