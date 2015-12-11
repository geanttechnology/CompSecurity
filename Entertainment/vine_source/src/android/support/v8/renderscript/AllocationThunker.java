// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.FieldPacker;

// Referenced classes of package android.support.v8.renderscript:
//            Allocation, RenderScriptThunker, TypeThunker, ElementThunker, 
//            Element, BaseObj, Type, FieldPacker, 
//            RenderScript

class AllocationThunker extends android.support.v8.renderscript.Allocation
{

    static android.graphics.BitmapFactory.Options mBitmapOptions;
    Allocation mN;

    AllocationThunker(RenderScript renderscript, Type type, int i, Allocation allocation)
    {
        super(0, renderscript, type, i);
        mType = type;
        mUsage = i;
        mN = allocation;
    }

    static android.renderscript.Allocation.MipmapControl convertMipmapControl(Allocation.MipmapControl mipmapcontrol)
    {
        static class _cls1
        {

            static final int $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[];

            static 
            {
                $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl = new int[Allocation.MipmapControl.values().length];
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[Allocation.MipmapControl.MIPMAP_NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[Allocation.MipmapControl.MIPMAP_FULL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.android.support.v8.renderscript.Allocation.MipmapControl[mipmapcontrol.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return android.renderscript.Allocation.MipmapControl.MIPMAP_NONE;

        case 2: // '\002'
            return android.renderscript.Allocation.MipmapControl.MIPMAP_FULL;

        case 3: // '\003'
            return android.renderscript.Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
        }
    }

    public static android.support.v8.renderscript.Allocation createCubemapFromBitmap(RenderScript renderscript, Bitmap bitmap, Allocation.MipmapControl mipmapcontrol, int i)
    {
        bitmap = Allocation.createCubemapFromBitmap(((RenderScriptThunker)renderscript).mN, bitmap, convertMipmapControl(mipmapcontrol), i);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, bitmap.getType()), i, bitmap);
    }

    public static android.support.v8.renderscript.Allocation createCubemapFromCubeFaces(RenderScript renderscript, Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Allocation.MipmapControl mipmapcontrol, 
            int i)
    {
        bitmap = Allocation.createCubemapFromCubeFaces(((RenderScriptThunker)renderscript).mN, bitmap, bitmap1, bitmap2, bitmap3, bitmap4, bitmap5, convertMipmapControl(mipmapcontrol), i);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, bitmap.getType()), i, bitmap);
    }

    public static android.support.v8.renderscript.Allocation createFromBitmap(RenderScript renderscript, Bitmap bitmap, Allocation.MipmapControl mipmapcontrol, int i)
    {
        bitmap = Allocation.createFromBitmap(((RenderScriptThunker)renderscript).mN, bitmap, convertMipmapControl(mipmapcontrol), i);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, bitmap.getType()), i, bitmap);
    }

    public static android.support.v8.renderscript.Allocation createFromBitmapResource(RenderScript renderscript, Resources resources, int i, Allocation.MipmapControl mipmapcontrol, int j)
    {
        resources = Allocation.createFromBitmapResource(((RenderScriptThunker)renderscript).mN, resources, i, convertMipmapControl(mipmapcontrol), j);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, resources.getType()), j, resources);
    }

    public static android.support.v8.renderscript.Allocation createFromString(RenderScript renderscript, String s, int i)
    {
        s = Allocation.createFromString(((RenderScriptThunker)renderscript).mN, s, i);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, s.getType()), i, s);
    }

    public static android.support.v8.renderscript.Allocation createSized(RenderScript renderscript, android.support.v8.renderscript.Element element, int i, int j)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        ElementThunker elementthunker = (ElementThunker)element;
        element = Allocation.createSized(renderscriptthunker.mN, (Element)element.getNObj(), i, j);
        return new AllocationThunker(renderscript, new TypeThunker(renderscript, element.getType()), j, element);
    }

    public static android.support.v8.renderscript.Allocation createTyped(RenderScript renderscript, Type type, Allocation.MipmapControl mipmapcontrol, int i)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        TypeThunker typethunker = (TypeThunker)type;
        return new AllocationThunker(renderscript, type, i, Allocation.createTyped(renderscriptthunker.mN, typethunker.mN, convertMipmapControl(mipmapcontrol), i));
    }

    public void copy1DRangeFrom(int i, int j, android.support.v8.renderscript.Allocation allocation, int k)
    {
        allocation = (AllocationThunker)allocation;
        mN.copy1DRangeFrom(i, j, ((AllocationThunker) (allocation)).mN, k);
    }

    public void copy1DRangeFrom(int i, int j, byte abyte0[])
    {
        mN.copy1DRangeFrom(i, j, abyte0);
    }

    public void copy1DRangeFrom(int i, int j, float af[])
    {
        mN.copy1DRangeFrom(i, j, af);
    }

    public void copy1DRangeFrom(int i, int j, int ai[])
    {
        mN.copy1DRangeFrom(i, j, ai);
    }

    public void copy1DRangeFrom(int i, int j, short aword0[])
    {
        mN.copy1DRangeFrom(i, j, aword0);
    }

    public void copy1DRangeFromUnchecked(int i, int j, byte abyte0[])
    {
        mN.copy1DRangeFromUnchecked(i, j, abyte0);
    }

    public void copy1DRangeFromUnchecked(int i, int j, float af[])
    {
        mN.copy1DRangeFromUnchecked(i, j, af);
    }

    public void copy1DRangeFromUnchecked(int i, int j, int ai[])
    {
        mN.copy1DRangeFromUnchecked(i, j, ai);
    }

    public void copy1DRangeFromUnchecked(int i, int j, short aword0[])
    {
        mN.copy1DRangeFromUnchecked(i, j, aword0);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, android.support.v8.renderscript.Allocation allocation, int i1, int j1)
    {
        allocation = (AllocationThunker)allocation;
        mN.copy2DRangeFrom(i, j, k, l, ((AllocationThunker) (allocation)).mN, i1, j1);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, byte abyte0[])
    {
        mN.copy2DRangeFrom(i, j, k, l, abyte0);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, float af[])
    {
        mN.copy2DRangeFrom(i, j, k, l, af);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, int ai[])
    {
        mN.copy2DRangeFrom(i, j, k, l, ai);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, short aword0[])
    {
        mN.copy2DRangeFrom(i, j, k, l, aword0);
    }

    public void copy2DRangeFrom(int i, int j, Bitmap bitmap)
    {
        mN.copy2DRangeFrom(i, j, bitmap);
    }

    public void copyFrom(Bitmap bitmap)
    {
        mN.copyFrom(bitmap);
    }

    public void copyFrom(android.support.v8.renderscript.Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.copyFrom(((AllocationThunker) (allocation)).mN);
    }

    public void copyFrom(byte abyte0[])
    {
        mN.copyFrom(abyte0);
    }

    public void copyFrom(float af[])
    {
        mN.copyFrom(af);
    }

    public void copyFrom(int ai[])
    {
        mN.copyFrom(ai);
    }

    public void copyFrom(android.support.v8.renderscript.BaseObj abaseobj[])
    {
        if (abaseobj == null)
        {
            return;
        }
        BaseObj abaseobj1[] = new BaseObj[abaseobj.length];
        for (int i = 0; i < abaseobj.length; i++)
        {
            abaseobj1[i] = abaseobj[i].getNObj();
        }

        mN.copyFrom(abaseobj1);
    }

    public void copyFrom(short aword0[])
    {
        mN.copyFrom(aword0);
    }

    public void copyFromUnchecked(byte abyte0[])
    {
        mN.copyFromUnchecked(abyte0);
    }

    public void copyFromUnchecked(float af[])
    {
        mN.copyFromUnchecked(af);
    }

    public void copyFromUnchecked(int ai[])
    {
        mN.copyFromUnchecked(ai);
    }

    public void copyFromUnchecked(short aword0[])
    {
        mN.copyFromUnchecked(aword0);
    }

    public void copyTo(Bitmap bitmap)
    {
        mN.copyTo(bitmap);
    }

    public void copyTo(byte abyte0[])
    {
        mN.copyTo(abyte0);
    }

    public void copyTo(float af[])
    {
        mN.copyTo(af);
    }

    public void copyTo(int ai[])
    {
        mN.copyTo(ai);
    }

    public void copyTo(short aword0[])
    {
        mN.copyTo(aword0);
    }

    public void generateMipmaps()
    {
        mN.generateMipmaps();
    }

    public int getBytesSize()
    {
        return mN.getBytesSize();
    }

    public android.support.v8.renderscript.Element getElement()
    {
        return getType().getElement();
    }

    Allocation getNObj()
    {
        return mN;
    }

    volatile BaseObj getNObj()
    {
        return getNObj();
    }

    public Type getType()
    {
        return TypeThunker.find(mN.getType());
    }

    public int getUsage()
    {
        return mN.getUsage();
    }

    public void ioReceive()
    {
        mN.ioReceive();
    }

    public void ioSend()
    {
        mN.ioSend();
    }

    public void setFromFieldPacker(int i, int j, android.support.v8.renderscript.FieldPacker fieldpacker)
    {
        fieldpacker = new FieldPacker(fieldpacker.getData());
        mN.setFromFieldPacker(i, j, fieldpacker);
    }

    public void setFromFieldPacker(int i, android.support.v8.renderscript.FieldPacker fieldpacker)
    {
        fieldpacker = new FieldPacker(fieldpacker.getData());
        mN.setFromFieldPacker(i, fieldpacker);
    }

    public void syncAll(int i)
    {
        mN.syncAll(i);
    }

    static 
    {
        mBitmapOptions = new android.graphics.BitmapFactory.Options();
        mBitmapOptions.inScaled = false;
    }
}
