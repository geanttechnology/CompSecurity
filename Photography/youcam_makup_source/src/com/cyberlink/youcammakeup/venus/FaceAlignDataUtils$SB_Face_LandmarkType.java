// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;


final class  extends Enum
{

    private static final SB_LANDMARK_AMOUNT $VALUES[];
    public static final SB_LANDMARK_AMOUNT SB_CHIN;
    public static final SB_LANDMARK_AMOUNT SB_FOREHEAD_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_FOREHEAD_MIDDLE;
    public static final SB_LANDMARK_AMOUNT SB_FOREHEAD_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_LANDMARK_AMOUNT;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_BROW_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_BROW_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_BROW_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_BROW_TOP;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EAR_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EAR_TOP;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EYE_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EYE_CENTER;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EYE_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EYE_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_EYE_TOP;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_FACE_SHAPE_1;
    public static final SB_LANDMARK_AMOUNT SB_LEFT_FACE_SHAPE_2;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_BOTTOM_LIP_1;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_BOTTOM_LIP_2;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_BOTTOM_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_BOTTOM_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_INNER_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_INNER_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_LOWER_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_LOWER_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_TOP_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_TOP_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_UPPER_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_INTERP_UPPER_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_LEFT_CORNER;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_RIGHT_CORNER;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_TOP_LIP_1;
    public static final SB_LANDMARK_AMOUNT SB_MOUTH_TOP_LIP_2;
    public static final SB_LANDMARK_AMOUNT SB_NOSE_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_NOSE_BRIDGE_TOP;
    public static final SB_LANDMARK_AMOUNT SB_NOSE_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_NOSE_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_NOSE_TOP;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_BROW_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_BROW_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_BROW_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_BROW_TOP;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EAR_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EAR_TOP;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EYE_BOTTOM;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EYE_CENTER;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EYE_LEFT;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EYE_RIGHT;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_EYE_TOP;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_FACE_SHAPE_1;
    public static final SB_LANDMARK_AMOUNT SB_RIGHT_FACE_SHAPE_2;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/venus/FaceAlignDataUtils$SB_Face_LandmarkType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SB_LEFT_BROW_LEFT = new <init>("SB_LEFT_BROW_LEFT", 0);
        SB_LEFT_BROW_TOP = new <init>("SB_LEFT_BROW_TOP", 1);
        SB_LEFT_BROW_RIGHT = new <init>("SB_LEFT_BROW_RIGHT", 2);
        SB_LEFT_BROW_BOTTOM = new <init>("SB_LEFT_BROW_BOTTOM", 3);
        SB_LEFT_EYE_LEFT = new <init>("SB_LEFT_EYE_LEFT", 4);
        SB_LEFT_EYE_TOP = new <init>("SB_LEFT_EYE_TOP", 5);
        SB_LEFT_EYE_RIGHT = new <init>("SB_LEFT_EYE_RIGHT", 6);
        SB_LEFT_EYE_BOTTOM = new <init>("SB_LEFT_EYE_BOTTOM", 7);
        SB_LEFT_EYE_CENTER = new <init>("SB_LEFT_EYE_CENTER", 8);
        SB_RIGHT_BROW_LEFT = new <init>("SB_RIGHT_BROW_LEFT", 9);
        SB_RIGHT_BROW_TOP = new <init>("SB_RIGHT_BROW_TOP", 10);
        SB_RIGHT_BROW_RIGHT = new <init>("SB_RIGHT_BROW_RIGHT", 11);
        SB_RIGHT_BROW_BOTTOM = new <init>("SB_RIGHT_BROW_BOTTOM", 12);
        SB_RIGHT_EYE_LEFT = new <init>("SB_RIGHT_EYE_LEFT", 13);
        SB_RIGHT_EYE_TOP = new <init>("SB_RIGHT_EYE_TOP", 14);
        SB_RIGHT_EYE_RIGHT = new <init>("SB_RIGHT_EYE_RIGHT", 15);
        SB_RIGHT_EYE_BOTTOM = new <init>("SB_RIGHT_EYE_BOTTOM", 16);
        SB_RIGHT_EYE_CENTER = new <init>("SB_RIGHT_EYE_CENTER", 17);
        SB_NOSE_LEFT = new <init>("SB_NOSE_LEFT", 18);
        SB_NOSE_TOP = new <init>("SB_NOSE_TOP", 19);
        SB_NOSE_RIGHT = new <init>("SB_NOSE_RIGHT", 20);
        SB_NOSE_BOTTOM = new <init>("SB_NOSE_BOTTOM", 21);
        SB_MOUTH_LEFT_CORNER = new <init>("SB_MOUTH_LEFT_CORNER", 22);
        SB_MOUTH_TOP_LIP_1 = new <init>("SB_MOUTH_TOP_LIP_1", 23);
        SB_MOUTH_TOP_LIP_2 = new <init>("SB_MOUTH_TOP_LIP_2", 24);
        SB_MOUTH_RIGHT_CORNER = new <init>("SB_MOUTH_RIGHT_CORNER", 25);
        SB_MOUTH_BOTTOM_LIP_1 = new <init>("SB_MOUTH_BOTTOM_LIP_1", 26);
        SB_MOUTH_BOTTOM_LIP_2 = new <init>("SB_MOUTH_BOTTOM_LIP_2", 27);
        SB_CHIN = new <init>("SB_CHIN", 28);
        SB_LEFT_EAR_TOP = new <init>("SB_LEFT_EAR_TOP", 29);
        SB_LEFT_EAR_BOTTOM = new <init>("SB_LEFT_EAR_BOTTOM", 30);
        SB_LEFT_FACE_SHAPE_1 = new <init>("SB_LEFT_FACE_SHAPE_1", 31);
        SB_LEFT_FACE_SHAPE_2 = new <init>("SB_LEFT_FACE_SHAPE_2", 32);
        SB_RIGHT_EAR_TOP = new <init>("SB_RIGHT_EAR_TOP", 33);
        SB_RIGHT_EAR_BOTTOM = new <init>("SB_RIGHT_EAR_BOTTOM", 34);
        SB_RIGHT_FACE_SHAPE_1 = new <init>("SB_RIGHT_FACE_SHAPE_1", 35);
        SB_RIGHT_FACE_SHAPE_2 = new <init>("SB_RIGHT_FACE_SHAPE_2", 36);
        SB_MOUTH_INTERP_TOP_RIGHT = new <init>("SB_MOUTH_INTERP_TOP_RIGHT", 37);
        SB_MOUTH_INTERP_TOP_LEFT = new <init>("SB_MOUTH_INTERP_TOP_LEFT", 38);
        SB_MOUTH_INTERP_BOTTOM_RIGHT = new <init>("SB_MOUTH_INTERP_BOTTOM_RIGHT", 39);
        SB_MOUTH_INTERP_BOTTOM_LEFT = new <init>("SB_MOUTH_INTERP_BOTTOM_LEFT", 40);
        SB_MOUTH_INTERP_INNER_RIGHT = new <init>("SB_MOUTH_INTERP_INNER_RIGHT", 41);
        SB_MOUTH_INTERP_INNER_LEFT = new <init>("SB_MOUTH_INTERP_INNER_LEFT", 42);
        SB_MOUTH_INTERP_UPPER_LEFT = new <init>("SB_MOUTH_INTERP_UPPER_LEFT", 43);
        SB_MOUTH_INTERP_UPPER_RIGHT = new <init>("SB_MOUTH_INTERP_UPPER_RIGHT", 44);
        SB_MOUTH_INTERP_LOWER_LEFT = new <init>("SB_MOUTH_INTERP_LOWER_LEFT", 45);
        SB_MOUTH_INTERP_LOWER_RIGHT = new <init>("SB_MOUTH_INTERP_LOWER_RIGHT", 46);
        SB_NOSE_BRIDGE_TOP = new <init>("SB_NOSE_BRIDGE_TOP", 47);
        SB_FOREHEAD_MIDDLE = new <init>("SB_FOREHEAD_MIDDLE", 48);
        SB_FOREHEAD_LEFT = new <init>("SB_FOREHEAD_LEFT", 49);
        SB_FOREHEAD_RIGHT = new <init>("SB_FOREHEAD_RIGHT", 50);
        SB_LANDMARK_AMOUNT = new <init>("SB_LANDMARK_AMOUNT", 51);
        $VALUES = (new .VALUES[] {
            SB_LEFT_BROW_LEFT, SB_LEFT_BROW_TOP, SB_LEFT_BROW_RIGHT, SB_LEFT_BROW_BOTTOM, SB_LEFT_EYE_LEFT, SB_LEFT_EYE_TOP, SB_LEFT_EYE_RIGHT, SB_LEFT_EYE_BOTTOM, SB_LEFT_EYE_CENTER, SB_RIGHT_BROW_LEFT, 
            SB_RIGHT_BROW_TOP, SB_RIGHT_BROW_RIGHT, SB_RIGHT_BROW_BOTTOM, SB_RIGHT_EYE_LEFT, SB_RIGHT_EYE_TOP, SB_RIGHT_EYE_RIGHT, SB_RIGHT_EYE_BOTTOM, SB_RIGHT_EYE_CENTER, SB_NOSE_LEFT, SB_NOSE_TOP, 
            SB_NOSE_RIGHT, SB_NOSE_BOTTOM, SB_MOUTH_LEFT_CORNER, SB_MOUTH_TOP_LIP_1, SB_MOUTH_TOP_LIP_2, SB_MOUTH_RIGHT_CORNER, SB_MOUTH_BOTTOM_LIP_1, SB_MOUTH_BOTTOM_LIP_2, SB_CHIN, SB_LEFT_EAR_TOP, 
            SB_LEFT_EAR_BOTTOM, SB_LEFT_FACE_SHAPE_1, SB_LEFT_FACE_SHAPE_2, SB_RIGHT_EAR_TOP, SB_RIGHT_EAR_BOTTOM, SB_RIGHT_FACE_SHAPE_1, SB_RIGHT_FACE_SHAPE_2, SB_MOUTH_INTERP_TOP_RIGHT, SB_MOUTH_INTERP_TOP_LEFT, SB_MOUTH_INTERP_BOTTOM_RIGHT, 
            SB_MOUTH_INTERP_BOTTOM_LEFT, SB_MOUTH_INTERP_INNER_RIGHT, SB_MOUTH_INTERP_INNER_LEFT, SB_MOUTH_INTERP_UPPER_LEFT, SB_MOUTH_INTERP_UPPER_RIGHT, SB_MOUTH_INTERP_LOWER_LEFT, SB_MOUTH_INTERP_LOWER_RIGHT, SB_NOSE_BRIDGE_TOP, SB_FOREHEAD_MIDDLE, SB_FOREHEAD_LEFT, 
            SB_FOREHEAD_RIGHT, SB_LANDMARK_AMOUNT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
