// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;


// Referenced classes of package android.support.v8.renderscript:
//            BaseObj, RSInvalidStateException, Element, RenderScript, 
//            RSIllegalArgumentException

public class Type extends BaseObj
{
    public static class Builder
    {

        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Type create()
        {
            if (mDimZ > 0)
            {
                if (mDimX < 1 || mDimY < 1)
                {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
                if (mDimFaces)
                {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (mDimY > 0 && mDimX < 1)
            {
                throw new RSInvalidStateException("X dimension required when Y is present.");
            }
            if (mDimFaces && mDimY < 1)
            {
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            }
            if (mYuv != 0 && (mDimZ != 0 || mDimFaces || mDimMipmaps))
            {
                throw new RSInvalidStateException("YUV only supports basic 2D.");
            } else
            {
                Type type = new Type(mRS.nTypeCreate(mElement.getID(mRS), mDimX, mDimY, mDimZ, mDimMipmaps, mDimFaces, mYuv), mRS);
                type.mElement = mElement;
                type.mDimX = mDimX;
                type.mDimY = mDimY;
                type.mDimZ = mDimZ;
                type.mDimMipmaps = mDimMipmaps;
                type.mDimFaces = mDimFaces;
                type.mDimYuv = mYuv;
                type.calcElementCount();
                return type;
            }
        }

        public Builder setFaces(boolean flag)
        {
            mDimFaces = flag;
            return this;
        }

        public Builder setMipmaps(boolean flag)
        {
            mDimMipmaps = flag;
            return this;
        }

        public Builder setX(int i)
        {
            if (i < 1)
            {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
            } else
            {
                mDimX = i;
                return this;
            }
        }

        public Builder setY(int i)
        {
            if (i < 1)
            {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
            } else
            {
                mDimY = i;
                return this;
            }
        }

        public Builder setYuvFormat(int i)
        {
            switch (i)
            {
            default:
                throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");

            case 17: // '\021'
            case 842094169: 
                mYuv = i;
                break;
            }
            return this;
        }

        public Builder setZ(int i)
        {
            if (i < 1)
            {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
            } else
            {
                mDimZ = i;
                return this;
            }
        }

        public Builder(RenderScript renderscript, Element element)
        {
            mDimX = 1;
            element.checkValid();
            mRS = renderscript;
            mElement = element;
        }
    }

    public static final class CubemapFace extends Enum
    {

        private static final CubemapFace $VALUES[];
        public static final CubemapFace NEGATIVE_X;
        public static final CubemapFace NEGATIVE_Y;
        public static final CubemapFace NEGATIVE_Z;
        public static final CubemapFace POSITIVE_X;
        public static final CubemapFace POSITIVE_Y;
        public static final CubemapFace POSITIVE_Z;
        int mID;

        public static CubemapFace valueOf(String s)
        {
            return (CubemapFace)Enum.valueOf(android/support/v8/renderscript/Type$CubemapFace, s);
        }

        public static CubemapFace[] values()
        {
            return (CubemapFace[])$VALUES.clone();
        }

        static 
        {
            POSITIVE_X = new CubemapFace("POSITIVE_X", 0, 0);
            NEGATIVE_X = new CubemapFace("NEGATIVE_X", 1, 1);
            POSITIVE_Y = new CubemapFace("POSITIVE_Y", 2, 2);
            NEGATIVE_Y = new CubemapFace("NEGATIVE_Y", 3, 3);
            POSITIVE_Z = new CubemapFace("POSITIVE_Z", 4, 4);
            NEGATIVE_Z = new CubemapFace("NEGATIVE_Z", 5, 5);
            $VALUES = (new CubemapFace[] {
                POSITIVE_X, NEGATIVE_X, POSITIVE_Y, NEGATIVE_Y, POSITIVE_Z, NEGATIVE_Z
            });
        }

        private CubemapFace(String s, int i, int j)
        {
            super(s, i);
            mID = j;
        }
    }


    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    Type(long l, RenderScript renderscript)
    {
        super(l, renderscript);
    }

    public static Type createX(RenderScript renderscript, Element element, int i)
    {
        if (i < 1)
        {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        } else
        {
            renderscript = new Type(renderscript.nTypeCreate(element.getID(renderscript), i, 0, 0, false, false, 0), renderscript);
            renderscript.mElement = element;
            renderscript.mDimX = i;
            renderscript.calcElementCount();
            return renderscript;
        }
    }

    public static Type createXY(RenderScript renderscript, Element element, int i, int j)
    {
        if (i < 1 || j < 1)
        {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        } else
        {
            renderscript = new Type(renderscript.nTypeCreate(element.getID(renderscript), i, j, 0, false, false, 0), renderscript);
            renderscript.mElement = element;
            renderscript.mDimX = i;
            renderscript.mDimY = j;
            renderscript.calcElementCount();
            return renderscript;
        }
    }

    public static Type createXYZ(RenderScript renderscript, Element element, int i, int j, int k)
    {
        if (i < 1 || j < 1 || k < 1)
        {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        } else
        {
            renderscript = new Type(renderscript.nTypeCreate(element.getID(renderscript), i, j, k, false, false, 0), renderscript);
            renderscript.mElement = element;
            renderscript.mDimX = i;
            renderscript.mDimY = j;
            renderscript.mDimZ = k;
            renderscript.calcElementCount();
            return renderscript;
        }
    }

    void calcElementCount()
    {
        boolean flag = hasMipmaps();
        int k = getX();
        int j = getY();
        int i1 = getZ();
        int i;
        byte byte0;
        int j1;
        if (hasFaces())
        {
            byte0 = 6;
        } else
        {
            byte0 = 1;
        }
        i = k;
        if (k == 0)
        {
            i = 1;
        }
        k = j;
        if (j == 0)
        {
            k = 1;
        }
        j = i1;
        if (i1 == 0)
        {
            j = 1;
        }
        i1 = k;
        j1 = i;
        i = i * k * j * byte0;
        int l;
        for (; flag && (j1 > 1 || i1 > 1 || j > 1); j1 = l)
        {
            l = j1;
            if (j1 > 1)
            {
                l = j1 >> 1;
            }
            j1 = i1;
            if (i1 > 1)
            {
                j1 = i1 >> 1;
            }
            i1 = j;
            if (j > 1)
            {
                i1 = j >> 1;
            }
            i += l * j1 * i1 * byte0;
            j = i1;
            i1 = j1;
        }

        mElementCount = i;
    }

    public int getCount()
    {
        return mElementCount;
    }

    public long getDummyType(RenderScript renderscript, long l)
    {
        return renderscript.nIncTypeCreate(l, mDimX, mDimY, mDimZ, mDimMipmaps, mDimFaces, mDimYuv);
    }

    public Element getElement()
    {
        return mElement;
    }

    public int getX()
    {
        return mDimX;
    }

    public int getY()
    {
        return mDimY;
    }

    public int getYuv()
    {
        return mDimYuv;
    }

    public int getZ()
    {
        return mDimZ;
    }

    public boolean hasFaces()
    {
        return mDimFaces;
    }

    public boolean hasMipmaps()
    {
        return mDimMipmaps;
    }
}
