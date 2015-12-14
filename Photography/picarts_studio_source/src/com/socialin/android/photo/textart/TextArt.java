// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.NoProGuard;
import com.socialin.android.brushlib.input.a;
import com.socialin.android.brushlib.input.b;
import com.socialin.android.photo.AbstractItem;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.d;
import com.socialin.android.util.l;

// Referenced classes of package com.socialin.android.photo.textart:
//            TextArtStyle, TypefaceSpec

public class TextArt extends AbstractItem
    implements NoProGuard, b
{

    public static final int FONT_FAVORITE = 3;
    public static final int FONT_MY = 1;
    public static final int FONT_PICSART = 0;
    public static final int FONT_SHOP = 2;
    public static final String LOG_TAG = com/socialin/android/photo/textart/TextArt.getSimpleName();
    private float X;
    private float Y;
    boolean activateOnlyProps;
    private int alignment;
    private int blendMode;
    private float centerX;
    private float centerY;
    private Context context;
    private float curHeight;
    private float curWidth;
    private Integer curZoomType;
    private int currentAction;
    private Paint fillPaint;
    private boolean fromDrawing;
    private a gestureDetector;
    private Bitmap handleCorner;
    float handleDeltaX;
    float handleDeltaY;
    private Paint handleRectPaint1;
    private Paint handleRectPaint2;
    private Bitmap handleRotate;
    private Bitmap handleSide;
    private boolean horizontal;
    private float horizontalTextCenterY;
    private boolean inPinchMode;
    private long lastTouchTime;
    float lastTouchX;
    float lastTouchY;
    private String lines[];
    private int maxWidth;
    private PointF moveStartMidPoint;
    private Rect onImageRect;
    private String origText;
    private int origTextHeight;
    private int origTextWidth;
    public boolean pinchOutOfBounds;
    private float pinchStartDistance;
    private PointF pinchStartPoint1;
    private PointF pinchStartPoint2;
    private float preDegree;
    private float rotateDegree;
    private float scaleFactorOfMainView;
    private float scaleX;
    private float scaleY;
    private boolean showRotateHandle;
    private float startRotateDegree;
    private float startRotateDegree1;
    private float startScaleXPinch;
    private float startScaleYPinch;
    private Paint strokePaint;
    private int strokeWidth;
    private TextArtStyle style;
    private String text;
    private Rect textBounds;
    private int textSize;
    private Rect trect;
    private float verticalKoef;
    private View view;
    private int wrapAngle;
    private RectF wrapBounds;
    private float wrapCy;
    private boolean wrapEnabled;
    private float wrapOrigHeight;
    private float wrapOrigWidth;
    private int wrapProgress;
    private float wrapRadius;
    private boolean wrapWingsUp;

    public TextArt(Context context1, TextArtStyle textartstyle, String s, View view1, int i, int j, boolean flag)
    {
        text = "PicsArt";
        lines = (new String[] {
            text
        });
        origText = null;
        context = null;
        view = null;
        onImageRect = new Rect();
        textSize = 80;
        strokeWidth = 5;
        X = 10F;
        Y = 10F;
        scaleX = 1.0F;
        scaleY = 1.0F;
        textBounds = new Rect();
        trect = new Rect();
        centerX = -1F;
        centerY = -1F;
        rotateDegree = 0.0F;
        startRotateDegree = 0.0F;
        preDegree = 0.0F;
        wrapEnabled = false;
        wrapWingsUp = true;
        wrapAngle = 0;
        wrapBounds = new RectF();
        wrapProgress = 50;
        horizontal = true;
        handleSide = null;
        handleCorner = null;
        handleRotate = null;
        showRotateHandle = true;
        curZoomType = null;
        currentAction = 1;
        fromDrawing = false;
        verticalKoef = 0.9F;
        lastTouchTime = -1L;
        style = null;
        blendMode = -1;
        alignment = 19;
        maxWidth = 0;
        lastTouchX = -1F;
        lastTouchY = -1F;
        handleDeltaX = 0.0F;
        handleDeltaY = 0.0F;
        scaleFactorOfMainView = 1.0F;
        activateOnlyProps = false;
        inPinchMode = false;
        pinchOutOfBounds = false;
        context = context1;
        view = view1;
        fromDrawing = flag;
        style = textartstyle;
        maxWidth = j;
        if (flag)
        {
            textSize = i;
        }
        refreshProperties(s, false);
        isDrawHandle = false;
        if (s.length() > 1)
        {
            isDrawHandle = true;
        }
        initHandles(context1);
        gestureDetector = new a(this);
        handleRectPaint1 = new Paint(1);
        handleRectPaint1.setColor(-1);
        handleRectPaint1.setStyle(android.graphics.Paint.Style.STROKE);
        handleRectPaint1.setStrokeWidth(1.0F);
        handleRectPaint2 = new Paint(1);
        handleRectPaint2.setColor(0x99000000);
        handleRectPaint2.setStyle(android.graphics.Paint.Style.STROKE);
        handleRectPaint2.setStrokeWidth(1.0F);
    }

    private float adjustCoordOnScreenOrientationChanged(float f, int i, int j, float f1)
    {
        return (f - (float)j) * f1 + (float)i;
    }

    private float calculateScaledCoordinate(float f, float f1, float f2)
    {
        return (f - f1) * f2 + f1;
    }

    private android.graphics.Paint.Align getAlign()
    {
        switch (alignment)
        {
        case 18: // '\022'
        case 20: // '\024'
        default:
            return android.graphics.Paint.Align.LEFT;

        case 17: // '\021'
            return android.graphics.Paint.Align.CENTER;

        case 19: // '\023'
            return android.graphics.Paint.Align.LEFT;

        case 21: // '\025'
            return android.graphics.Paint.Align.RIGHT;
        }
    }

    private int getLineSpacing()
    {
        return (int)((3F * fillPaint.getFontSpacing()) / 4F);
    }

    private float getStartCoord(float f)
    {
        switch (alignment)
        {
        case 18: // '\022'
        case 20: // '\024'
        default:
            return X - f - (float)textBounds.left;

        case 17: // '\021'
            return (X - f) + (float)textBounds.centerX();

        case 19: // '\023'
            return X - f - (float)textBounds.left;

        case 21: // '\025'
            return (X - f) + (float)textBounds.right;
        }
    }

    private void initHandles(Context context1)
    {
        if (handleCorner == null)
        {
            handleCorner = c.a(context1.getResources(), 0x7f02024a);
        }
        if (handleSide == null)
        {
            handleSide = c.a(context1.getResources(), 0x7f02024b);
        }
        if (handleRotate == null)
        {
            handleRotate = c.a(context1.getResources(), 0x7f02024c);
        }
    }

    public static void initTextArtForDrawing(Context context1, TextArtStyle textartstyle, Paint paint, Paint paint1)
    {
        if (textartstyle == null)
        {
            return;
        } else
        {
            android.graphics.Typeface typeface = TypefaceSpec.getTypeFace(context1, textartstyle.getTypefaceSpec());
            int i = (int)TypedValue.applyDimension(2, textartstyle.getFontSize(), context1.getResources().getDisplayMetrics());
            int j = (int)TypedValue.applyDimension(2, 1.0F, context1.getResources().getDisplayMetrics());
            paint.setStyle(android.graphics.Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setTextSize(i);
            paint.setTypeface(typeface);
            paint.setColor(textartstyle.getFillColor());
            paint1.setTextSize(i);
            paint1.setStyle(android.graphics.Paint.Style.STROKE);
            paint1.setStrokeWidth(j);
            paint1.setAntiAlias(true);
            paint1.setTypeface(typeface);
            paint1.setColor(textartstyle.getStrokeColor());
            return;
        }
    }

    private void initXY()
    {
label0:
        {
            if (centerX != -1F || centerY != -1F)
            {
                X = centerX - (float)origTextWidth * 0.5F;
                if (!horizontal || !wrapEnabled)
                {
                    break label0;
                }
                Y = horizontalTextCenterY - (float)origTextHeight * 0.5F;
            }
            return;
        }
        Y = centerY - (float)origTextHeight * 0.5F;
    }

    private Path makeWrapPath(float f, float f1)
    {
        Path path = new Path();
        RectF rectf = new RectF();
        rectf.set(centerX - wrapRadius, wrapCy - wrapRadius, centerX + wrapRadius, wrapCy + wrapRadius);
        rectf.offset(f, f1);
        if (wrapWingsUp)
        {
            path.addArc(rectf, 90F + (float)wrapAngle * 0.5F, -wrapAngle);
            return path;
        } else
        {
            path.addArc(rectf, 270F - (float)wrapAngle * 0.5F, wrapAngle);
            return path;
        }
    }

    private void refreshTextProperties()
    {
        if (horizontal && wrapEnabled)
        {
            float f = calculateScaledCoordinate(wrapBounds.left, centerX, scaleX);
            float f2 = calculateScaledCoordinate(wrapBounds.top, centerY, scaleY);
            float f4 = calculateScaledCoordinate(wrapBounds.right, centerX, scaleX);
            float f6 = calculateScaledCoordinate(wrapBounds.bottom, centerY, scaleY);
            trect.left = Math.round(f);
            trect.top = Math.round(f2);
            trect.right = Math.round(f4);
            trect.bottom = Math.round(f6);
        } else
        {
            if (centerX == -1F || centerY == -1F)
            {
                centerX = X + curWidth * 0.5F;
                centerY = Y + curHeight * 0.5F;
            }
            if (horizontal)
            {
                horizontalTextCenterY = centerY;
            }
            float f1 = calculateScaledCoordinate(X, centerX, scaleX);
            float f3 = calculateScaledCoordinate(Y, centerY, scaleY);
            float f5 = calculateScaledCoordinate(centerX + (centerX - X), centerX, scaleX);
            float f7 = calculateScaledCoordinate(centerY + (centerY - Y), centerY, scaleY);
            trect.left = Math.round(f1);
            trect.top = Math.round(f3);
            trect.right = Math.round(f5);
            trect.bottom = Math.round(f7);
        }
        curWidth = trect.width();
        curHeight = trect.height();
        if (style.hasGradient())
        {
            LinearGradient lineargradient = new LinearGradient(0.0F, Y, 0.0F, Y + (float)textBounds.height(), style.getFillColor(), style.getFillGradientBottomColor(), android.graphics.Shader.TileMode.CLAMP);
            fillPaint.setShader(lineargradient);
        }
        setAlignment();
    }

    private void refreshTextPropertiesForBitmapDraw(float f, float f1, float f2)
    {
        onImageRect.left = Math.round(((float)trect.left - f) / f2);
        onImageRect.right = Math.round(((float)trect.right - f) / f2);
        onImageRect.top = Math.round(((float)trect.top - f1) / f2);
        onImageRect.bottom = Math.round(((float)trect.bottom - f1) / f2);
        if (style.hasGradient())
        {
            LinearGradient lineargradient = new LinearGradient(0.0F, Y - imageTop, 0.0F, (Y - imageTop) + (float)origTextHeight, style.getFillColor(), style.getFillGradientBottomColor(), android.graphics.Shader.TileMode.CLAMP);
            fillPaint.setShader(lineargradient);
        }
    }

    private void rotate(float f, float f1)
    {
        f1 = (float)Math.toDegrees(Math.atan2(f1 - centerY, f - centerX));
        f = f1;
        if (f1 < 0.0F)
        {
            f = f1 + 360F;
        }
        rotateDegree = (int)((f + startRotateDegree) - preDegree);
    }

    private void zoom(float f, float f1)
    {
        if (horizontal && wrapEnabled)
        {
            scaleX = (curWidth + 2.0F * f) / wrapOrigWidth;
            scaleY = (curHeight + 2.0F * f1) / wrapOrigHeight;
        } else
        {
            scaleX = (curWidth + 2.0F * f) / (float)origTextWidth;
            scaleY = (curHeight + 2.0F * f1) / (float)origTextHeight;
        }
        curWidth = curWidth + 2.0F * f;
        curHeight = curHeight + 2.0F * f1;
    }

    public void activate(float f, float f1, float f2)
    {
        float f3 = centerX;
        float f4 = centerY;
        centerX = (float)onImageRect.centerX() * (scaleFactorOfMainView * f2) + f;
        centerY = (float)onImageRect.centerY() * (scaleFactorOfMainView * f2) + f1;
        if (wrapEnabled)
        {
            f = centerX;
            f1 = centerY - f4;
            wrapCy = wrapCy + f1;
            horizontalTextCenterY = horizontalTextCenterY + f1;
            wrapBounds.offset(f - f3, f1);
        }
        initXY();
        if (activateOnlyProps)
        {
            activateOnlyProps = false;
            return;
        } else
        {
            f = f2 / imageZoom;
            scaleX = scaleX * f;
            scaleY = f * scaleY;
            refreshTextProperties();
            return;
        }
    }

    public void cleanBitmaps()
    {
        c.a(handleSide);
        c.a(handleCorner);
        c.a(handleRotate);
        handleSide = null;
        handleCorner = null;
        handleRotate = null;
    }

    public void clearData()
    {
        cleanBitmaps();
    }

    public int describeContents()
    {
        return 0;
    }

    public void draw(Canvas canvas)
    {
        refreshTextProperties();
        canvas.save(1);
        canvas.rotate(rotateDegree, centerX, centerY);
        canvas.scale(scaleX, scaleY, centerX, centerY);
        if (!horizontal) goto _L2; else goto _L1
_L1:
        int i = textBounds.bottom;
        if (!wrapEnabled) goto _L4; else goto _L3
_L3:
        Path path = makeWrapPath(0.0F, 0.0F);
        if (style.hasStroke())
        {
            canvas.drawTextOnPath(text, path, 0.0F, (float)origTextHeight * 0.5F - (float)i, strokePaint);
        }
        canvas.drawTextOnPath(text, path, 0.0F, (float)origTextHeight * 0.5F - (float)i, fillPaint);
_L6:
        canvas.restore();
        if (isDrawHandle)
        {
            if (handleSide == null || handleCorner == null || handleRotate == null)
            {
                initHandles(context);
            }
            com.socialin.android.photo.view.a.a(canvas, trect, handleRectPaint1, handleRectPaint2, centerX, centerY, rotateDegree, handleCorner, handleRotate, handleSide, showRotateHandle);
        }
        return;
_L4:
        int j1;
        j1 = getLineSpacing();
        if (!style.hasStroke())
        {
            break; /* Loop/switch isn't completed */
        }
        Path path1 = new Path();
        int j = 0;
        while (j < lines.length) 
        {
            strokePaint.getTextPath(lines[j], 0, lines[j].length(), getStartCoord(0.0F), Y + (float)(origTextHeight - textBounds.bottom) + (float)(j * j1), path1);
            canvas.drawPath(path1, strokePaint);
            fillPaint.getTextPath(lines[j], 0, lines[j].length(), getStartCoord(0.0F), Y + (float)(origTextHeight - textBounds.bottom) + (float)(j * j1), path1);
            canvas.drawPath(path1, fillPaint);
            path1.reset();
            j++;
        }
        if (true) goto _L6; else goto _L5
_L5:
        int k = 0;
        while (k < lines.length) 
        {
            String s = lines[k];
            int l1 = lines[k].length();
            float f = getStartCoord(0.0F);
            float f2 = Y;
            float f4 = origTextHeight - textBounds.bottom;
            canvas.drawText(s, 0, l1, f, (float)(k * j1) + (f2 + f4), fillPaint);
            k++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        String as[] = lines;
        int i2 = as.length;
        int i1 = 0;
        float f1 = 0.0F;
        while (i1 < i2) 
        {
            String s1 = as[i1];
            float f3 = 0.0F;
            int k1 = 0;
            while (k1 < s1.length()) 
            {
                Rect rect = new Rect();
                fillPaint.getTextBounds(s1, k1, k1 + 1, rect);
                f3 = Math.max(f3, rect.width());
                if (style.hasStroke())
                {
                    Path path2 = new Path();
                    strokePaint.getTextPath(s1, k1, k1 + 1, X + f1 + (f3 - (float)rect.width()) / 2.0F, Y + verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1), path2);
                    canvas.drawPath(path2, strokePaint);
                    path2.reset();
                    fillPaint.getTextPath(s1, k1, k1 + 1, X + f1 + (f3 - (float)rect.width()) / 2.0F, Y + verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1), path2);
                    canvas.drawPath(path2, fillPaint);
                } else
                {
                    float f5 = X;
                    float f7 = (f3 - (float)rect.width()) / 2.0F;
                    float f8 = Y;
                    canvas.drawText(s1, k1, k1 + 1, f7 + (f5 + f1), verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1) + f8, fillPaint);
                }
                k1++;
            }
            float f6 = (float)getLineSpacing() / 3F;
            i1++;
            f1 += f3 + f6;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void draw(Canvas canvas, float f, float f1, float f2, float f3, float f4)
    {
        float f5 = f2 * f3;
        imageZoom = f3;
        imageLeft = f;
        imageTop = f1;
        scaleFactorOfMainView = f2;
        refreshTextPropertiesForBitmapDraw(f, f1, f5);
        canvas.save();
        canvas.scale(1.0F / f5, 1.0F / f5);
        canvas.rotate(rotateDegree - f4, centerX - imageLeft, centerY - imageTop);
        canvas.scale(scaleX, scaleY, centerX - imageLeft, centerY - imageTop);
        if (!horizontal) goto _L2; else goto _L1
_L1:
        int i = textBounds.bottom;
        if (!wrapEnabled) goto _L4; else goto _L3
_L3:
        Path path = makeWrapPath(-imageLeft, -imageTop);
        if (style.hasStroke())
        {
            canvas.drawTextOnPath(text, path, 0.0F, (float)origTextHeight * 0.5F - (float)i, strokePaint);
        }
        canvas.drawTextOnPath(text, path, 0.0F, (float)origTextHeight * 0.5F - (float)i, fillPaint);
_L6:
        canvas.restore();
        return;
_L4:
        int j1;
        j1 = getLineSpacing();
        if (!style.hasStroke())
        {
            break; /* Loop/switch isn't completed */
        }
        Path path1 = new Path();
        int j = 0;
        while (j < lines.length) 
        {
            strokePaint.getTextPath(lines[j], 0, lines[j].length(), getStartCoord(imageLeft), (Y - imageTop) + (float)(origTextHeight - textBounds.bottom) + (float)(j * j1), path1);
            canvas.drawPath(path1, strokePaint);
            fillPaint.getTextPath(lines[j], 0, lines[j].length(), getStartCoord(imageLeft), (Y - imageTop) + (float)(origTextHeight - textBounds.bottom) + (float)(j * j1), path1);
            canvas.drawPath(path1, fillPaint);
            path1.reset();
            j++;
        }
        if (true) goto _L6; else goto _L5
_L5:
        int k = 0;
        while (k < lines.length) 
        {
            String s = lines[k];
            int l1 = lines[k].length();
            f = getStartCoord(imageLeft);
            f1 = Y;
            f2 = imageTop;
            f3 = origTextHeight - textBounds.bottom;
            canvas.drawText(s, 0, l1, f, (float)(k * j1) + ((f1 - f2) + f3), fillPaint);
            k++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        String as[] = lines;
        int i2 = as.length;
        int i1 = 0;
        f = 0.0F;
        while (i1 < i2) 
        {
            String s1 = as[i1];
            f1 = 0.0F;
            int k1 = 0;
            while (k1 < s1.length()) 
            {
                Rect rect = new Rect();
                fillPaint.getTextBounds(s1, k1, k1 + 1, rect);
                f1 = Math.max(f1, rect.width());
                if (style.hasStroke())
                {
                    Path path2 = new Path();
                    strokePaint.getTextPath(s1, k1, k1 + 1, ((X + f) - imageLeft) + (f1 - (float)rect.width()) / 2.0F, (Y - imageTop) + verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1), path2);
                    canvas.drawPath(path2, strokePaint);
                    path2.reset();
                    fillPaint.getTextPath(s1, k1, k1 + 1, ((X + f) - imageLeft) + (f1 - (float)rect.width()) / 2.0F, (Y - imageTop) + verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1), path2);
                    canvas.drawPath(path2, fillPaint);
                } else
                {
                    f2 = X;
                    f3 = imageLeft;
                    f4 = (f1 - (float)rect.width()) / 2.0F;
                    float f6 = Y;
                    float f7 = imageTop;
                    canvas.drawText(s1, k1, k1 + 1, f4 + ((f2 + f) - f3), verticalKoef * fillPaint.getTextSize() * (float)(k1 + 1) + (f6 - f7), fillPaint);
                }
                k1++;
            }
            f2 = (float)getLineSpacing() / 3F;
            i1++;
            f += f1 + f2;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public int getBlendMode()
    {
        return blendMode;
    }

    public float getCenterX()
    {
        return centerX;
    }

    public float getCenterY()
    {
        return centerY;
    }

    public Paint getFillPaint()
    {
        return fillPaint;
    }

    public float getHeight()
    {
        return curHeight;
    }

    public float getRotation()
    {
        return rotateDegree;
    }

    public float getScaleX()
    {
        return scaleX;
    }

    public float getScaleY()
    {
        return scaleY;
    }

    public TextArtStyle getStyle()
    {
        return style;
    }

    public String getText()
    {
        return text;
    }

    public Rect getTextBounds()
    {
        return textBounds;
    }

    public int getType()
    {
        return 1;
    }

    public float getWidth()
    {
        return curWidth;
    }

    public int getWrapProgress()
    {
        return wrapProgress;
    }

    public float getX()
    {
        return X;
    }

    public float getY()
    {
        return Y;
    }

    public boolean isHorizontal()
    {
        return horizontal;
    }

    public boolean isInItem(float f, float f1)
    {
        return com.socialin.android.photo.view.a.a(onImageRect, f, f1, -rotateDegree);
    }

    public void onLongPress(PointF pointf)
    {
    }

    public void onPan(PointF pointf)
    {
    }

    public void onPanEnd(PointF pointf)
    {
    }

    public void onPanStart(PointF pointf)
    {
    }

    public void onPinch(PointF pointf, PointF pointf1)
    {
        if (!pinchOutOfBounds && pinchStartPoint1 != null && pinchStartPoint2 != null && pointf != null && pointf1 != null && isActive() && isDrawHandle())
        {
            rotateDegree = startRotateDegree1 + l.a(pinchStartPoint1, pinchStartPoint2, pointf, pointf1);
            float f4 = Geom.a(pointf, pointf1);
            float f;
            float f2;
            if (horizontal && wrapEnabled)
            {
                f2 = wrapOrigWidth;
                f = wrapOrigHeight;
            } else
            {
                f2 = origTextWidth;
                f = origTextHeight;
            }
            if (f4 != 0.0F && pinchStartDistance != 0.0F)
            {
                float f5 = scaleX;
                float f6 = scaleY;
                float f7 = curWidth;
                float f8 = curHeight;
                f4 /= pinchStartDistance;
                scaleX = startScaleXPinch * f4;
                scaleY = f4 * startScaleYPinch;
                curWidth = f2 * scaleX;
                curHeight = f * scaleY;
                f = Utils.a(20F, context);
                if (Math.abs(curWidth) < f && Math.abs(curHeight) < f)
                {
                    curWidth = f7;
                    curHeight = f8;
                    scaleX = f5;
                    scaleY = f6;
                    return;
                }
            }
            PointF pointf2 = new PointF();
            l.a(pointf, pointf1, pointf2);
            if (moveStartMidPoint != null)
            {
                float f1 = pointf2.x - moveStartMidPoint.x;
                float f3 = pointf2.y - moveStartMidPoint.y;
                X = X + f1;
                Y = Y + f3;
                centerX = centerX + f1;
                centerY = centerY + f3;
                if (wrapEnabled)
                {
                    wrapCy = wrapCy + f3;
                    horizontalTextCenterY = horizontalTextCenterY + f3;
                    wrapBounds.offset(f1, f3);
                }
            }
            moveStartMidPoint = pointf2;
            if (view != null)
            {
                view.invalidate();
                return;
            }
        }
    }

    public void onPinchEnd(PointF pointf, PointF pointf1)
    {
        pinchOutOfBounds = false;
        inPinchMode = false;
        moveStartMidPoint = null;
        startRotateDegree = rotateDegree;
    }

    public void onPinchStart(PointF pointf, PointF pointf1)
    {
        if (trect == null || !com.socialin.android.photo.view.a.a(trect, pointf.x, pointf.y, -rotateDegree) && !com.socialin.android.photo.view.a.a(trect, pointf1.x, pointf1.y, -rotateDegree))
        {
            pinchOutOfBounds = true;
        } else
        {
            pinchOutOfBounds = false;
            if (isActive() && isDrawHandle())
            {
                inPinchMode = true;
                pinchStartPoint1 = new PointF(pointf.x, pointf.y);
                pinchStartPoint2 = new PointF(pointf1.x, pointf1.y);
                startRotateDegree1 = rotateDegree;
                preDegree = rotateDegree;
                pinchStartDistance = Geom.a(pointf, pointf1);
                startScaleXPinch = scaleX;
                startScaleYPinch = scaleY;
                PointF pointf2 = new PointF();
                l.a(pointf, pointf1, pointf2);
                moveStartMidPoint = pointf2;
                return;
            }
        }
    }

    public void onTap(PointF pointf)
    {
    }

    public void onTouchEvent(MotionEvent motionevent)
    {
        gestureDetector.a(motionevent);
    }

    public void refreshProperties(String s, boolean flag)
    {
        text = s;
        if (horizontal && wrapEnabled)
        {
            if (s.contains("\n"))
            {
                origText = s;
                text = s.replaceAll("\n", " ");
            }
        } else
        if (origText != null)
        {
            text = origText;
        }
        lines = text.trim().split("\n");
        if (!fromDrawing)
        {
            textSize = style.getFontSize();
        }
        alignment = style.getAlignment();
        strokeWidth = Integer.valueOf(1).intValue();
        if (fromDrawing)
        {
            strokeWidth = (textSize * strokeWidth) / 30;
        }
        textSize = (int)TypedValue.applyDimension(2, textSize, context.getResources().getDisplayMetrics());
        strokeWidth = (int)TypedValue.applyDimension(2, strokeWidth, context.getResources().getDisplayMetrics());
        s = TypefaceSpec.getTypeFace(context, style.getTypefaceSpec());
        fillPaint = new Paint();
        fillPaint.setStyle(android.graphics.Paint.Style.FILL);
        fillPaint.setAntiAlias(true);
        fillPaint.setTextSize(textSize);
        fillPaint.setTypeface(s);
        fillPaint.setColor(style.getFillColor());
        strokePaint = new Paint();
        strokePaint.setTextSize(textSize);
        strokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        strokePaint.setStrokeWidth(strokeWidth);
        strokePaint.setAntiAlias(true);
        strokePaint.setTypeface(s);
        strokePaint.setColor(style.getStrokeColor());
        s = new Rect();
        if (horizontal)
        {
            textBounds.setEmpty();
            float f;
            int j;
            if (wrapEnabled && origText != null)
            {
                fillPaint.getTextBounds(text, 0, text.length(), textBounds);
            } else
            {
                int k = getLineSpacing();
                i = 0;
                while (i < lines.length) 
                {
                    fillPaint.getTextBounds(lines[i], 0, lines[i].length(), s);
                    s.top = ((Rect) (s)).top + i * k;
                    s.bottom = ((Rect) (s)).bottom + i * k;
                    textBounds.union(s);
                    i++;
                }
            }
        } else
        {
            s = lines;
            int j1 = s.length;
            float f1 = 0.0F;
            float f2 = 0.0F;
            for (i = 0; i < j1; i++)
            {
                String s1 = s[i];
                float f3 = 0.0F;
                for (int i1 = 0; i1 < s1.length(); i1++)
                {
                    Rect rect = new Rect();
                    fillPaint.getTextBounds(s1, i1, i1 + 1, rect);
                    f3 = Math.max(f3, rect.width());
                }

                f2 += (float)getLineSpacing() / 3F + f3;
                f1 = Math.max(f1, verticalKoef * fillPaint.getTextSize() * (float)s1.length());
            }

            float f4 = (float)getLineSpacing() / 3F;
            textBounds.set(0, -(int)f1, (int)(f2 - f4), 0);
        }
        origTextWidth = textBounds.width();
        origTextHeight = textBounds.height();
        if (maxWidth != 0 && !flag && origTextWidth != 0)
        {
            f = Math.max((float)maxWidth / (float)origTextWidth, 0.5F);
            if (f < 1.0F)
            {
                scaleX = f;
                scaleY = f;
            }
        }
        maxWidth = 0;
        if (horizontal && wrapEnabled)
        {
            curWidth = wrapOrigWidth * scaleX;
            curHeight = wrapOrigHeight * scaleY;
        } else
        {
            curWidth = (float)origTextWidth * scaleX;
            curHeight = (float)origTextHeight * scaleY;
        }
        if ((centerX == -1F || centerY == -1F) && view.getWidth() != 0 && view.getHeight() != 0)
        {
            centerX = (float)view.getWidth() * 0.5F;
            centerY = (float)view.getHeight() * 0.5F;
        }
        initXY();
        if (flag && horizontal && wrapEnabled)
        {
            j = wrapProgress;
            int i;
            if (wrapWingsUp)
            {
                i = wrapAngle;
            } else
            {
                i = -wrapAngle;
            }
            wrapText(j, i);
        }
        setOpacity(opacity);
        setBlendMode(blendMode);
    }

    public void setAlignment()
    {
        fillPaint.setTextAlign(getAlign());
        strokePaint.setTextAlign(getAlign());
    }

    public void setBlendMode(int i)
    {
        blendMode = i;
        android.graphics.PorterDuffXfermode porterduffxfermode = d.a(i);
        fillPaint.setXfermode(porterduffxfermode);
        strokePaint.setXfermode(porterduffxfermode);
    }

    public void setFillPaintColor(int i)
    {
        fillPaint.setColor(i);
    }

    public void setHorizontal(boolean flag)
    {
        horizontal = flag;
        refreshProperties(text, true);
    }

    public void setOpacity(int i)
    {
        opacity = i;
        fillPaint.setAlpha(opacity);
        strokePaint.setAlpha(opacity);
    }

    public void setStyle(TextArtStyle textartstyle)
    {
        style = textartstyle;
    }

    public void sizeChanged(int i, int j, int k, int i1, float f, float f1)
    {
        float f2 = f1 / imageZoom;
        if (!isActive)
        {
            activateOnlyProps = true;
            activate(k, i1, f1);
            imageZoom = f1;
            imageLeft = i;
            imageTop = j;
            scaleFactorOfMainView = scaleFactorOfMainView * f;
        }
        centerX = adjustCoordOnScreenOrientationChanged(centerX, i, k, f);
        centerY = adjustCoordOnScreenOrientationChanged(centerY, j, i1, f);
        if (wrapEnabled)
        {
            horizontalTextCenterY = adjustCoordOnScreenOrientationChanged(horizontalTextCenterY, j, i1, f);
            i1 = wrapProgress;
            if (wrapWingsUp)
            {
                k = wrapAngle;
            } else
            {
                k = -wrapAngle;
            }
            wrapText(i1, k);
        }
        initXY();
        if (isActive)
        {
            scaleX = scaleX * f;
            scaleY = scaleY * f;
            return;
        } else
        {
            scaleX = scaleX * f * f2;
            scaleY = scaleY * f * f2;
            refreshTextProperties();
            refreshTextPropertiesForBitmapDraw(i, j, scaleFactorOfMainView * f1);
            return;
        }
    }

    public boolean touch_down(float f, float f1)
    {
        return false;
    }

    public void touch_move(float f, float f1)
    {
        float f4;
        float f5;
        if (inPinchMode)
        {
            return;
        }
        if (lastTouchX == -1F || lastTouchY == -1F)
        {
            lastTouchX = f;
            lastTouchY = f1;
            return;
        }
        f4 = f - lastTouchX;
        f5 = f1 - lastTouchY;
        if (currentAction != 2) goto _L2; else goto _L1
_L1:
        float f2;
        float f3;
        float af[] = new float[2];
        af[0] = f;
        af[1] = f1;
        com.socialin.android.photo.view.a.a(af, centerX, centerY, -rotateDegree);
        f1 = af[0];
        f = af[1];
        f2 = f1 - handleDeltaX;
        f3 = f - handleDeltaY;
        curZoomType.intValue();
        JVM INSTR tableswitch 3 7: default 164
    //                   3 183
    //                   4 211
    //                   5 231
    //                   6 249
    //                   7 268;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        lastTouchX = f2;
        lastTouchY = f3;
        view.invalidate();
        return;
_L4:
        zoom(f2 - (float)trect.right, f3 - (float)trect.bottom);
        continue; /* Loop/switch isn't completed */
_L5:
        zoom(0.0F, -(f3 - (float)trect.top));
        continue; /* Loop/switch isn't completed */
_L6:
        zoom(f2 - (float)trect.right, 0.0F);
        continue; /* Loop/switch isn't completed */
_L7:
        zoom(0.0F, f3 - (float)trect.bottom);
        continue; /* Loop/switch isn't completed */
_L8:
        zoom(-(f2 - (float)trect.left), 0.0F);
        continue; /* Loop/switch isn't completed */
_L2:
        if (currentAction == 1)
        {
            X = X + f4;
            Y = Y + f5;
            centerX = centerX + f4;
            centerY = centerY + f5;
            f2 = f;
            f3 = f1;
            if (wrapEnabled)
            {
                wrapCy = wrapCy + f5;
                horizontalTextCenterY = horizontalTextCenterY + f5;
                wrapBounds.offset(f4, f5);
                f2 = f;
                f3 = f1;
            }
        } else
        {
            f2 = f;
            f3 = f1;
            if (currentAction == 3)
            {
                showRotateHandle = false;
                rotate(f, f1);
                f2 = f;
                f3 = f1;
            }
        }
        if (true) goto _L3; else goto _L9
_L9:
    }

    public void touch_up()
    {
        if (inPinchMode)
        {
            return;
        }
        if (currentAction == 3)
        {
            startRotateDegree = rotateDegree;
            showRotateHandle = true;
        }
        lastTouchX = -1F;
        lastTouchY = -1F;
    }

    public void wrapText(int i, int j)
    {
        if (i == 0 || i == 100)
        {
            return;
        }
        wrapProgress = i;
        wrapAngle = Math.abs(j);
        if (wrapAngle == 360)
        {
            wrapAngle = 359;
        }
        if (j > 0)
        {
            wrapWingsUp = true;
        } else
        {
            wrapWingsUp = false;
        }
        if (wrapAngle == 0)
        {
            wrapEnabled = false;
            if (origText != null)
            {
                refreshProperties(origText, false);
                origText = null;
            }
            curWidth = (float)origTextWidth * scaleX;
            curHeight = (float)origTextHeight * scaleY;
            centerY = horizontalTextCenterY;
            return;
        }
        wrapEnabled = true;
        if (text.contains("\n"))
        {
            refreshProperties(text, false);
        }
        wrapRadius = (float)((double)(origTextWidth * 180) / ((double)wrapAngle * 3.1415926535897931D));
        float f;
        if (wrapWingsUp)
        {
            wrapCy = horizontalTextCenterY - wrapRadius;
        } else
        {
            wrapCy = horizontalTextCenterY + wrapRadius;
        }
        wrapBounds.setEmpty();
        makeWrapPath(0.0F, 0.0F).computeBounds(wrapBounds, false);
        if (wrapWingsUp)
        {
            wrapBounds.bottom = wrapCy + wrapRadius;
        } else
        {
            wrapBounds.top = wrapCy - wrapRadius;
        }
        f = (float)origTextHeight * 0.5F;
        wrapBounds.inset(-f, -f);
        wrapOrigWidth = wrapBounds.width();
        wrapOrigHeight = wrapBounds.height();
        centerY = wrapBounds.centerY();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    public void zoomProportional(float f, float f1, boolean flag)
    {
        float f4 = scaleX;
        float f5 = scaleY;
        float f2;
        float f3;
        float f6;
        if (horizontal && wrapEnabled)
        {
            f3 = wrapOrigWidth;
            f2 = wrapOrigHeight;
        } else
        {
            f3 = origTextWidth;
            f2 = origTextHeight;
        }
        scaleX = (curWidth + f) / f3;
        scaleY = (curHeight + f1) / f2;
        f1 = Math.abs(f4) - Math.abs(scaleX);
        f6 = Math.abs(f5) - Math.abs(scaleY);
        if (f6 > f1)
        {
            f = Math.abs(scaleY);
        } else
        {
            f = Math.abs(scaleX);
        }
        if (f6 > f1)
        {
            f1 = f;
            if (scaleY < 0.0F)
            {
                f1 = -f;
            }
            scaleY = f1;
            scaleX = Geom.a(scaleX) * Math.abs((f4 / f5) * scaleY);
        } else
        {
            f1 = f;
            if (scaleX < 0.0F)
            {
                f1 = -f;
            }
            scaleX = f1;
            scaleY = Geom.a(scaleY) * Math.abs((f5 / f4) * scaleX);
        }
        f = curWidth;
        f1 = curHeight;
        curWidth = f3 * scaleX;
        curHeight = f2 * scaleY;
        if (flag)
        {
            f2 = Utils.a(20F, context);
            if (Math.abs(curWidth) < f2 && Math.abs(curHeight) < f2)
            {
                curWidth = f;
                curHeight = f1;
                scaleX = f4;
                scaleY = f5;
            }
        }
    }

}
