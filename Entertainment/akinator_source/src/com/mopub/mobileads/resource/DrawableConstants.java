// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.graphics.Color;
import android.graphics.Typeface;

public class DrawableConstants
{
    public static class BlurredLastVideoFrame
    {

        public static final int ALPHA = 128;

        public BlurredLastVideoFrame()
        {
        }
    }

    public static class CloseButton
    {

        public static final String DEFAULT_CLOSE_BUTTON_TEXT = "";
        public static final int EDGE_PADDING = 16;
        public static final int IMAGE_PADDING_DIPS = 5;
        public static final android.graphics.Paint.Cap STROKE_CAP;
        public static final int STROKE_COLOR = -1;
        public static final float STROKE_WIDTH = 8F;
        public static final int TEXT_COLOR = -1;
        public static final int TEXT_RIGHT_MARGIN_DIPS = 7;
        public static final float TEXT_SIZE_SP = 20F;
        public static final Typeface TEXT_TYPEFACE = Typeface.create("Helvetica", 0);
        public static final int WIDGET_HEIGHT_DIPS = 46;

        static 
        {
            STROKE_CAP = android.graphics.Paint.Cap.ROUND;
        }

        public CloseButton()
        {
        }
    }

    public static class CtaButton
    {

        public static final int BACKGROUND_ALPHA = 51;
        public static final int BACKGROUND_COLOR = 0xff000000;
        public static final android.graphics.Paint.Style BACKGROUND_STYLE;
        public static final int CORNER_RADIUS_DIPS = 6;
        public static final String DEFAULT_CTA_TEXT = "Learn More";
        public static final int HEIGHT_DIPS = 42;
        public static final int MARGIN_DIPS = 16;
        public static final int OUTLINE_ALPHA = 51;
        public static final int OUTLINE_COLOR = -1;
        public static final int OUTLINE_STROKE_WIDTH_DIPS = 2;
        public static final android.graphics.Paint.Style OUTLINE_STYLE;
        public static final android.graphics.Paint.Align TEXT_ALIGN;
        public static final int TEXT_COLOR = -1;
        public static final float TEXT_SIZE_SP = 20F;
        public static final Typeface TEXT_TYPEFACE = Typeface.create("Helvetica", 1);
        public static final int WIDTH_DIPS = 200;

        static 
        {
            BACKGROUND_STYLE = android.graphics.Paint.Style.FILL;
            OUTLINE_STYLE = android.graphics.Paint.Style.STROKE;
            TEXT_ALIGN = android.graphics.Paint.Align.CENTER;
        }

        public CtaButton()
        {
        }
    }

    public static class GradientStrip
    {

        public static final int END_COLOR = Color.argb(0, 255, 255, 255);
        public static final int GRADIENT_STRIP_HEIGHT_DIPS = 72;
        public static final int START_COLOR = Color.argb(102, 0, 0, 0);


        public GradientStrip()
        {
        }
    }

    public static class ProgressBar
    {

        public static final int BACKGROUND_ALPHA = 128;
        public static final int BACKGROUND_COLOR = -1;
        public static final android.graphics.Paint.Style BACKGROUND_STYLE;
        public static final int HEIGHT_DIPS = 4;
        public static final int NUGGET_WIDTH_DIPS = 4;
        public static final int PROGRESS_ALPHA = 255;
        public static final int PROGRESS_COLOR = Color.parseColor("#FFCC4D");
        public static final android.graphics.Paint.Style PROGRESS_STYLE;

        static 
        {
            BACKGROUND_STYLE = android.graphics.Paint.Style.FILL;
            PROGRESS_STYLE = android.graphics.Paint.Style.FILL;
        }

        public ProgressBar()
        {
        }
    }

    public static class RadialCountdown
    {

        public static final int BACKGROUND_ALPHA = 128;
        public static final int BACKGROUND_COLOR = -1;
        public static final android.graphics.Paint.Style BACKGROUND_STYLE;
        public static final int CIRCLE_STROKE_WIDTH_DIPS = 3;
        public static final int PADDING_DIPS = 5;
        public static final int PROGRESS_ALPHA = 255;
        public static final int PROGRESS_COLOR = -1;
        public static final android.graphics.Paint.Style PROGRESS_STYLE;
        public static final int RIGHT_MARGIN_DIPS = 16;
        public static final int SIDE_LENGTH_DIPS = 45;
        public static final float START_ANGLE = -90F;
        public static final android.graphics.Paint.Align TEXT_ALIGN;
        public static final int TEXT_COLOR = -1;
        public static final float TEXT_SIZE_SP = 18F;
        public static final int TOP_MARGIN_DIPS = 16;

        static 
        {
            BACKGROUND_STYLE = android.graphics.Paint.Style.STROKE;
            PROGRESS_STYLE = android.graphics.Paint.Style.STROKE;
            TEXT_ALIGN = android.graphics.Paint.Align.CENTER;
        }

        public RadialCountdown()
        {
        }
    }


    public DrawableConstants()
    {
    }
}
