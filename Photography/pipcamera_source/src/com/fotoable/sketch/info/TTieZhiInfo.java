// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.info;

import ahn;
import android.graphics.Bitmap;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.List;
import oo;
import pb;
import tm;

public class TTieZhiInfo extends TResInfo
{

    public static float kDefaultSrcImageWidth = 320F;
    public static float kDefaultTZScale = 0.4F;
    public static int kDefaultTZWidth = 100;
    public static int kTZDecorationTypeID = 101;
    public static int kTZFacialTypeID = 102;
    public static int kTZFunnyTypeID = 104;
    public static int kTZLocalTypeID = 99;
    public static int kTZRecommendTypeID = 100;
    public static int kTZWordsTypeID = 103;
    public int TZListId;
    public int TZTypeId;
    public TIEZHIFACEALIGN faceAlign;
    public TIEZHIFACETYPE faceType;
    public List groupIds;
    public boolean isGroupEnable;
    public float margin;
    public TIEZHIPOSITION position;
    public String src;

    public TTieZhiInfo()
    {
    }

    public static TIEZHIFACEALIGN faceAlignFromInt(int i)
    {
        TIEZHIFACEALIGN tiezhifacealign = TIEZHIFACEALIGN.FACEALIGN_CENTER;
        switch (i)
        {
        default:
            return tiezhifacealign;

        case 0: // '\0'
            return TIEZHIFACEALIGN.FACEALIGN_CENTER;

        case 1: // '\001'
            return TIEZHIFACEALIGN.FACEALIGN_TOP;

        case 2: // '\002'
            return TIEZHIFACEALIGN.FACEALIGN_BOTTOM;
        }
    }

    public static TIEZHIFACETYPE faceTypeFromInt(int i)
    {
        TIEZHIFACETYPE tiezhifacetype = TIEZHIFACETYPE.GENERAL;
        switch (i)
        {
        default:
            return TIEZHIFACETYPE.GENERAL;

        case 0: // '\0'
            return TIEZHIFACETYPE.GENERAL;

        case 1: // '\001'
            return TIEZHIFACETYPE.FACE_EYE;

        case 2: // '\002'
            return TIEZHIFACETYPE.FACE_ERE;

        case 3: // '\003'
            return TIEZHIFACETYPE.FACE_MOUTH;

        case 4: // '\004'
            return TIEZHIFACETYPE.FACE_NOSE;

        case 5: // '\005'
            return TIEZHIFACETYPE.FACE_CHEEK;

        case 6: // '\006'
            return TIEZHIFACETYPE.FACE_MOUSTACHE;

        case 7: // '\007'
            return TIEZHIFACETYPE.FACE_MEIXIN;
        }
    }

    public static TIEZHIPOSITION positionFromInt(int i)
    {
        TIEZHIPOSITION tiezhiposition = TIEZHIPOSITION.CENTER;
        switch (i)
        {
        default:
            return TIEZHIPOSITION.CENTER;

        case 0: // '\0'
            return TIEZHIPOSITION.CENTER;

        case 1: // '\001'
            return TIEZHIPOSITION.LEFT;

        case 2: // '\002'
            return TIEZHIPOSITION.TOP;

        case 3: // '\003'
            return TIEZHIPOSITION.RIGHT;

        case 4: // '\004'
            return TIEZHIPOSITION.BOTTOM;

        case 5: // '\005'
            return TIEZHIPOSITION.LEFTTOP;

        case 6: // '\006'
            return TIEZHIPOSITION.LEFTBOTTOM;

        case 7: // '\007'
            return TIEZHIPOSITION.RIGHTTOP;

        case 8: // '\b'
            return TIEZHIPOSITION.RIGHTBOTTOM;
        }
    }

    public Bitmap getIconImage()
    {
        if (resType == EResType.NETWORK && (folderName == null || folderName.equalsIgnoreCase("")) || icon == null || icon.equalsIgnoreCase(""))
        {
            return null;
        }
        Bitmap bitmap;
        try
        {
            if (resType == EResType.NETWORK)
            {
                String s = (new StringBuilder()).append(folderName).append("/").append(icon).toString();
                return (Bitmap)oo.a().c().a(s, new ahn());
            }
            bitmap = pb.b(PIPCameraApplication.a, icon);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public Bitmap getSrcImage()
    {
        if (resType == EResType.NETWORK && (folderName == null || folderName.equalsIgnoreCase("")) || src == null || src.equalsIgnoreCase(""))
        {
            return null;
        }
        Bitmap bitmap;
        try
        {
            if (resType == EResType.NETWORK)
            {
                String s = (new StringBuilder()).append(folderName).append("/").append(src).toString();
                return (Bitmap)oo.a().c().a(s, new ahn());
            }
            bitmap = pb.b(PIPCameraApplication.a, src);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public boolean hasSrcImg()
    {
        if (resType == EResType.NETWORK && (folderName == null || folderName.equalsIgnoreCase("")) || src == null || src.equalsIgnoreCase(""))
        {
            return false;
        }
        Object obj;
        if (resType != EResType.NETWORK)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = (new StringBuilder()).append(folderName).append("/").append(src).toString();
        obj = (Bitmap)oo.a().c().a(((String) (obj)), new ahn());
_L1:
        if (obj != null)
        {
            try
            {
                if (!((Bitmap) (obj)).isRecycled())
                {
                    ((Bitmap) (obj)).recycle();
                }
            }
            catch (Exception exception)
            {
                return false;
            }
        } else
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_148;
        obj = pb.b(PIPCameraApplication.a, src);
          goto _L1
        return true;
    }


    private class TIEZHIFACEALIGN extends Enum
    {

        private static final TIEZHIFACEALIGN $VALUES[];
        public static final TIEZHIFACEALIGN FACEALIGN_BOTTOM;
        public static final TIEZHIFACEALIGN FACEALIGN_CENTER;
        public static final TIEZHIFACEALIGN FACEALIGN_TOP;

        public static TIEZHIFACEALIGN valueOf(String s)
        {
            return (TIEZHIFACEALIGN)Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIFACEALIGN, s);
        }

        public static TIEZHIFACEALIGN[] values()
        {
            return (TIEZHIFACEALIGN[])$VALUES.clone();
        }

        static 
        {
            FACEALIGN_CENTER = new TIEZHIFACEALIGN("FACEALIGN_CENTER", 0);
            FACEALIGN_TOP = new TIEZHIFACEALIGN("FACEALIGN_TOP", 1);
            FACEALIGN_BOTTOM = new TIEZHIFACEALIGN("FACEALIGN_BOTTOM", 2);
            $VALUES = (new TIEZHIFACEALIGN[] {
                FACEALIGN_CENTER, FACEALIGN_TOP, FACEALIGN_BOTTOM
            });
        }

        private TIEZHIFACEALIGN(String s, int i)
        {
            super(s, i);
        }
    }


    private class TIEZHIFACETYPE extends Enum
    {

        private static final TIEZHIFACETYPE $VALUES[];
        public static final TIEZHIFACETYPE FACE_CHEEK;
        public static final TIEZHIFACETYPE FACE_ERE;
        public static final TIEZHIFACETYPE FACE_EYE;
        public static final TIEZHIFACETYPE FACE_MEIXIN;
        public static final TIEZHIFACETYPE FACE_MOUSTACHE;
        public static final TIEZHIFACETYPE FACE_MOUTH;
        public static final TIEZHIFACETYPE FACE_NOSE;
        public static final TIEZHIFACETYPE GENERAL;

        public static TIEZHIFACETYPE valueOf(String s)
        {
            return (TIEZHIFACETYPE)Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIFACETYPE, s);
        }

        public static TIEZHIFACETYPE[] values()
        {
            return (TIEZHIFACETYPE[])$VALUES.clone();
        }

        static 
        {
            GENERAL = new TIEZHIFACETYPE("GENERAL", 0);
            FACE_EYE = new TIEZHIFACETYPE("FACE_EYE", 1);
            FACE_ERE = new TIEZHIFACETYPE("FACE_ERE", 2);
            FACE_MOUTH = new TIEZHIFACETYPE("FACE_MOUTH", 3);
            FACE_NOSE = new TIEZHIFACETYPE("FACE_NOSE", 4);
            FACE_CHEEK = new TIEZHIFACETYPE("FACE_CHEEK", 5);
            FACE_MOUSTACHE = new TIEZHIFACETYPE("FACE_MOUSTACHE", 6);
            FACE_MEIXIN = new TIEZHIFACETYPE("FACE_MEIXIN", 7);
            $VALUES = (new TIEZHIFACETYPE[] {
                GENERAL, FACE_EYE, FACE_ERE, FACE_MOUTH, FACE_NOSE, FACE_CHEEK, FACE_MOUSTACHE, FACE_MEIXIN
            });
        }

        private TIEZHIFACETYPE(String s, int i)
        {
            super(s, i);
        }
    }


    private class TIEZHIPOSITION extends Enum
    {

        private static final TIEZHIPOSITION $VALUES[];
        public static final TIEZHIPOSITION BOTTOM;
        public static final TIEZHIPOSITION CENTER;
        public static final TIEZHIPOSITION LEFT;
        public static final TIEZHIPOSITION LEFTBOTTOM;
        public static final TIEZHIPOSITION LEFTTOP;
        public static final TIEZHIPOSITION RIGHT;
        public static final TIEZHIPOSITION RIGHTBOTTOM;
        public static final TIEZHIPOSITION RIGHTTOP;
        public static final TIEZHIPOSITION TOP;

        public static TIEZHIPOSITION valueOf(String s)
        {
            return (TIEZHIPOSITION)Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIPOSITION, s);
        }

        public static TIEZHIPOSITION[] values()
        {
            return (TIEZHIPOSITION[])$VALUES.clone();
        }

        static 
        {
            CENTER = new TIEZHIPOSITION("CENTER", 0);
            LEFT = new TIEZHIPOSITION("LEFT", 1);
            TOP = new TIEZHIPOSITION("TOP", 2);
            RIGHT = new TIEZHIPOSITION("RIGHT", 3);
            BOTTOM = new TIEZHIPOSITION("BOTTOM", 4);
            LEFTTOP = new TIEZHIPOSITION("LEFTTOP", 5);
            LEFTBOTTOM = new TIEZHIPOSITION("LEFTBOTTOM", 6);
            RIGHTTOP = new TIEZHIPOSITION("RIGHTTOP", 7);
            RIGHTBOTTOM = new TIEZHIPOSITION("RIGHTBOTTOM", 8);
            $VALUES = (new TIEZHIPOSITION[] {
                CENTER, LEFT, TOP, RIGHT, BOTTOM, LEFTTOP, LEFTBOTTOM, RIGHTTOP, RIGHTBOTTOM
            });
        }

        private TIEZHIPOSITION(String s, int i)
        {
            super(s, i);
        }
    }

}
