// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Element;

// Referenced classes of package android.support.v8.renderscript:
//            Element, RenderScriptThunker, RenderScript

class ElementThunker extends android.support.v8.renderscript.Element
{
    static class BuilderThunker
    {

        android.renderscript.Element.Builder mN;

        public void add(android.support.v8.renderscript.Element element, String s, int i)
        {
            element = (ElementThunker)element;
            mN.add(((ElementThunker) (element)).mN, s, i);
        }

        public android.support.v8.renderscript.Element create(RenderScript renderscript)
        {
            return new ElementThunker(renderscript, mN.create());
        }

        public BuilderThunker(RenderScript renderscript)
        {
            mN = new android.renderscript.Element.Builder(((RenderScriptThunker)renderscript).mN);
        }
    }


    Element mN;

    ElementThunker(RenderScript renderscript, Element element)
    {
        super(0, renderscript);
        mN = element;
    }

    static android.renderscript.Element.DataKind convertKind(Element.DataKind datakind)
    {
        static class _cls1
        {

            static final int $SwitchMap$android$support$v8$renderscript$Element$DataKind[];
            static final int $SwitchMap$android$support$v8$renderscript$Element$DataType[];

            static 
            {
                $SwitchMap$android$support$v8$renderscript$Element$DataType = new int[Element.DataType.values().length];
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.FLOAT_32.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.FLOAT_64.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_8.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_16.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_32.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_64.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_8.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_16.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_32.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_64.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.BOOLEAN.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_4X4.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_3X3.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_2X2.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_ELEMENT.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_TYPE.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_ALLOCATION.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_SAMPLER.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_SCRIPT.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$android$support$v8$renderscript$Element$DataKind = new int[Element.DataKind.values().length];
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.USER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_L.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_A.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_LA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_RGB.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_RGBA.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.android.support.v8.renderscript.Element.DataKind[datakind.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return android.renderscript.Element.DataKind.USER;

        case 2: // '\002'
            return android.renderscript.Element.DataKind.PIXEL_L;

        case 3: // '\003'
            return android.renderscript.Element.DataKind.PIXEL_A;

        case 4: // '\004'
            return android.renderscript.Element.DataKind.PIXEL_LA;

        case 5: // '\005'
            return android.renderscript.Element.DataKind.PIXEL_RGB;

        case 6: // '\006'
            return android.renderscript.Element.DataKind.PIXEL_RGBA;
        }
    }

    static android.renderscript.Element.DataType convertType(Element.DataType datatype)
    {
        switch (_cls1..SwitchMap.android.support.v8.renderscript.Element.DataType[datatype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return android.renderscript.Element.DataType.NONE;

        case 2: // '\002'
            return android.renderscript.Element.DataType.FLOAT_32;

        case 3: // '\003'
            return android.renderscript.Element.DataType.FLOAT_64;

        case 4: // '\004'
            return android.renderscript.Element.DataType.SIGNED_8;

        case 5: // '\005'
            return android.renderscript.Element.DataType.SIGNED_16;

        case 6: // '\006'
            return android.renderscript.Element.DataType.SIGNED_32;

        case 7: // '\007'
            return android.renderscript.Element.DataType.SIGNED_64;

        case 8: // '\b'
            return android.renderscript.Element.DataType.UNSIGNED_8;

        case 9: // '\t'
            return android.renderscript.Element.DataType.UNSIGNED_16;

        case 10: // '\n'
            return android.renderscript.Element.DataType.UNSIGNED_32;

        case 11: // '\013'
            return android.renderscript.Element.DataType.UNSIGNED_64;

        case 12: // '\f'
            return android.renderscript.Element.DataType.BOOLEAN;

        case 13: // '\r'
            return android.renderscript.Element.DataType.MATRIX_4X4;

        case 14: // '\016'
            return android.renderscript.Element.DataType.MATRIX_3X3;

        case 15: // '\017'
            return android.renderscript.Element.DataType.MATRIX_2X2;

        case 16: // '\020'
            return android.renderscript.Element.DataType.RS_ELEMENT;

        case 17: // '\021'
            return android.renderscript.Element.DataType.RS_TYPE;

        case 18: // '\022'
            return android.renderscript.Element.DataType.RS_ALLOCATION;

        case 19: // '\023'
            return android.renderscript.Element.DataType.RS_SAMPLER;

        case 20: // '\024'
            return android.renderscript.Element.DataType.RS_SCRIPT;
        }
    }

    static android.support.v8.renderscript.Element create(RenderScript renderscript, Element.DataType datatype)
    {
        Object obj;
        RenderScriptThunker renderscriptthunker;
        renderscriptthunker = (RenderScriptThunker)renderscript;
        obj = null;
        _cls1..SwitchMap.android.support.v8.renderscript.Element.DataType[datatype.ordinal()];
        JVM INSTR tableswitch 2 20: default 104
    //                   2 116
    //                   3 127
    //                   4 138
    //                   5 149
    //                   6 160
    //                   7 171
    //                   8 182
    //                   9 193
    //                   10 204
    //                   11 215
    //                   12 226
    //                   13 237
    //                   14 248
    //                   15 259
    //                   16 270
    //                   17 281
    //                   18 292
    //                   19 303
    //                   20 314;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L1:
        datatype = obj;
_L22:
        return new ElementThunker(renderscript, datatype);
_L2:
        datatype = Element.F32(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L3:
        datatype = Element.F64(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L4:
        datatype = Element.I8(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L5:
        datatype = Element.I16(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L6:
        datatype = Element.I32(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L7:
        datatype = Element.I64(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L8:
        datatype = Element.U8(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L9:
        datatype = Element.U16(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L10:
        datatype = Element.U32(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L11:
        datatype = Element.U64(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L12:
        datatype = Element.BOOLEAN(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L13:
        datatype = Element.MATRIX_4X4(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L14:
        datatype = Element.MATRIX_3X3(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L15:
        datatype = Element.MATRIX_2X2(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L16:
        datatype = Element.ELEMENT(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L17:
        datatype = Element.TYPE(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L18:
        datatype = Element.ALLOCATION(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L19:
        datatype = Element.SAMPLER(renderscriptthunker.mN);
        continue; /* Loop/switch isn't completed */
_L20:
        datatype = Element.SCRIPT(renderscriptthunker.mN);
        if (true) goto _L22; else goto _L21
_L21:
    }

    public static android.support.v8.renderscript.Element createPixel(RenderScript renderscript, Element.DataType datatype, Element.DataKind datakind)
    {
        return new ElementThunker(renderscript, Element.createPixel(((RenderScriptThunker)renderscript).mN, convertType(datatype), convertKind(datakind)));
    }

    public static android.support.v8.renderscript.Element createVector(RenderScript renderscript, Element.DataType datatype, int i)
    {
        return new ElementThunker(renderscript, Element.createVector(((RenderScriptThunker)renderscript).mN, convertType(datatype), i));
    }

    public int getBytesSize()
    {
        return mN.getBytesSize();
    }

    public Element.DataKind getDataKind()
    {
        return mKind;
    }

    public Element.DataType getDataType()
    {
        return mType;
    }

    volatile BaseObj getNObj()
    {
        return getNObj();
    }

    Element getNObj()
    {
        return mN;
    }

    public android.support.v8.renderscript.Element getSubElement(int i)
    {
        return new ElementThunker(mRS, mN.getSubElement(i));
    }

    public int getSubElementArraySize(int i)
    {
        return mN.getSubElementArraySize(i);
    }

    public int getSubElementCount()
    {
        return mN.getSubElementCount();
    }

    public String getSubElementName(int i)
    {
        return mN.getSubElementName(i);
    }

    public int getSubElementOffsetBytes(int i)
    {
        return mN.getSubElementOffsetBytes(i);
    }

    public int getVectorSize()
    {
        return mN.getVectorSize();
    }

    public boolean isCompatible(android.support.v8.renderscript.Element element)
    {
        return ((ElementThunker)element).mN.isCompatible(mN);
    }

    public boolean isComplex()
    {
        return mN.isComplex();
    }
}
