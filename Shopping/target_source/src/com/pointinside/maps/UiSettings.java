// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMGL, PIMGLContext

public final class UiSettings
{
    public static final class DoubleTapZoomMode extends Enum
    {

        private static final DoubleTapZoomMode $VALUES[];
        public static final DoubleTapZoomMode MAPPING_STANDARD;
        public static final DoubleTapZoomMode POINT_INSIDE;
        final int id;

        public static DoubleTapZoomMode valueOf(String s)
        {
            return (DoubleTapZoomMode)Enum.valueOf(com/pointinside/maps/UiSettings$DoubleTapZoomMode, s);
        }

        public static DoubleTapZoomMode[] values()
        {
            return (DoubleTapZoomMode[])$VALUES.clone();
        }

        static 
        {
            POINT_INSIDE = new DoubleTapZoomMode("POINT_INSIDE", 0, 0);
            MAPPING_STANDARD = new DoubleTapZoomMode("MAPPING_STANDARD", 1, 1);
            $VALUES = (new DoubleTapZoomMode[] {
                POINT_INSIDE, MAPPING_STANDARD
            });
        }

        private DoubleTapZoomMode(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }


    private final PIMGLContext mContext;
    private DoubleTapZoomMode mCurrentTapZoomMode;
    private boolean mDoubleTapZoomModeEnabled;
    private boolean mDragToPanEnabled;
    private boolean mPinchToZoomEnabled;
    private boolean mRotateGestureToRotateEnabled;
    private boolean mVerticalDragToTiltEnabled;

    UiSettings(PIMGLContext pimglcontext)
    {
        mPinchToZoomEnabled = true;
        mRotateGestureToRotateEnabled = false;
        mDragToPanEnabled = true;
        mVerticalDragToTiltEnabled = false;
        mDoubleTapZoomModeEnabled = true;
        mCurrentTapZoomMode = DoubleTapZoomMode.POINT_INSIDE;
        mContext = pimglcontext;
    }

    public DoubleTapZoomMode getDoubleTapZoomMode()
    {
        return mCurrentTapZoomMode;
    }

    public boolean isDoubleTapZoomModeEnabled()
    {
        return mDoubleTapZoomModeEnabled;
    }

    public boolean isDragToPanEnabled()
    {
        return mDragToPanEnabled;
    }

    public boolean isPinchToZoomEnabled()
    {
        return mPinchToZoomEnabled;
    }

    public boolean isRotateGestureToRotateEnabled()
    {
        return mRotateGestureToRotateEnabled;
    }

    public boolean isVerticalDragToTiltEnabled()
    {
        return mVerticalDragToTiltEnabled;
    }

    public void setDoubleTapZoomMode(DoubleTapZoomMode doubletapzoommode)
    {
        mCurrentTapZoomMode = doubletapzoommode;
        PIMGL.camera_setZoomMode(mContext, doubletapzoommode.id);
    }

    public void setDoubleTapZoomModeEnabled(boolean flag)
    {
        mDoubleTapZoomModeEnabled = flag;
        PIMGL.camera_enableTapZoom(mContext, flag);
    }

    public void setDragToPanEnabled(boolean flag)
    {
        mDragToPanEnabled = flag;
        PIMGL.camera_enableTruck(mContext, flag);
    }

    public void setPinchToZoomEnabled(boolean flag)
    {
        mPinchToZoomEnabled = flag;
        PIMGL.camera_enableDolly(mContext, flag);
    }

    public void setRotateGestureToRotateEnabled(boolean flag)
    {
        mRotateGestureToRotateEnabled = flag;
        PIMGL.camera_enableOrbit(mContext, flag);
    }

    public void setVerticalDragToTiltEnabled(boolean flag)
    {
        mVerticalDragToTiltEnabled = flag;
        PIMGL.camera_enableTilt(mContext, flag);
    }
}
