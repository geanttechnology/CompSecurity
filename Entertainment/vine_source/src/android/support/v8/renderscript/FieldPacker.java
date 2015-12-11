// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.Byte2;
import android.renderscript.Byte3;
import android.renderscript.Byte4;
import android.renderscript.Double2;
import android.renderscript.Double3;
import android.renderscript.Double4;
import android.renderscript.Float2;
import android.renderscript.Float3;
import android.renderscript.Float4;
import android.renderscript.Int2;
import android.renderscript.Int3;
import android.renderscript.Int4;
import android.renderscript.Long2;
import android.renderscript.Long3;
import android.renderscript.Long4;
import android.renderscript.Matrix2f;
import android.renderscript.Matrix3f;
import android.renderscript.Matrix4f;
import android.renderscript.Short2;
import android.renderscript.Short3;
import android.renderscript.Short4;
import android.util.Log;

// Referenced classes of package android.support.v8.renderscript:
//            RenderScript, Float2, Float3, Float4, 
//            Double2, Double3, Double4, Short2, 
//            Short3, Short4, Int2, Int3, 
//            Int4, Long2, Long3, Long4, 
//            Byte2, Byte3, Byte4, Matrix2f, 
//            Matrix3f, Matrix4f, BaseObj, RSIllegalArgumentException

public class FieldPacker
{

    private final byte mData[];
    private int mLen;
    private android.renderscript.FieldPacker mN;
    private int mPos;

    public FieldPacker(int i)
    {
        mPos = 0;
        mLen = i;
        mData = new byte[i];
        if (RenderScript.shouldThunk())
        {
            mN = new android.renderscript.FieldPacker(i);
        }
    }

    public void addBoolean(boolean flag)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addBoolean(flag);
            return;
        }
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        addI8((byte)i);
    }

    public void addF32(float f)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF32(f);
            return;
        } else
        {
            addI32(Float.floatToRawIntBits(f));
            return;
        }
    }

    public void addF32(android.support.v8.renderscript.Float2 float2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF32(new Float2(float2.x, float2.y));
            return;
        } else
        {
            addF32(float2.x);
            addF32(float2.y);
            return;
        }
    }

    public void addF32(android.support.v8.renderscript.Float3 float3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF32(new Float3(float3.x, float3.y, float3.z));
            return;
        } else
        {
            addF32(float3.x);
            addF32(float3.y);
            addF32(float3.z);
            return;
        }
    }

    public void addF32(android.support.v8.renderscript.Float4 float4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF32(new Float4(float4.x, float4.y, float4.z, float4.w));
            return;
        } else
        {
            addF32(float4.x);
            addF32(float4.y);
            addF32(float4.z);
            addF32(float4.w);
            return;
        }
    }

    public void addF64(double d)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF64(d);
            return;
        } else
        {
            addI64(Double.doubleToRawLongBits(d));
            return;
        }
    }

    public void addF64(android.support.v8.renderscript.Double2 double2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF64(new Double2(double2.x, double2.y));
            return;
        } else
        {
            addF64(double2.x);
            addF64(double2.y);
            return;
        }
    }

    public void addF64(android.support.v8.renderscript.Double3 double3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF64(new Double3(double3.x, double3.y, double3.z));
            return;
        } else
        {
            addF64(double3.x);
            addF64(double3.y);
            addF64(double3.z);
            return;
        }
    }

    public void addF64(android.support.v8.renderscript.Double4 double4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addF64(new Double4(double4.x, double4.y, double4.z, double4.w));
            return;
        } else
        {
            addF64(double4.x);
            addF64(double4.y);
            addF64(double4.z);
            addF64(double4.w);
            return;
        }
    }

    public void addI16(android.support.v8.renderscript.Short2 short2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI16(new Short2(short2.x, short2.y));
            return;
        } else
        {
            addI16(short2.x);
            addI16(short2.y);
            return;
        }
    }

    public void addI16(android.support.v8.renderscript.Short3 short3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI16(new Short3(short3.x, short3.y, short3.z));
            return;
        } else
        {
            addI16(short3.x);
            addI16(short3.y);
            addI16(short3.z);
            return;
        }
    }

    public void addI16(android.support.v8.renderscript.Short4 short4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI16(new Short4(short4.x, short4.y, short4.z, short4.w));
            return;
        } else
        {
            addI16(short4.x);
            addI16(short4.y);
            addI16(short4.z);
            addI16(short4.w);
            return;
        }
    }

    public void addI16(short word0)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI16(word0);
            return;
        } else
        {
            align(2);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(word0 & 0xff);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(word0 >> 8);
            return;
        }
    }

    public void addI32(int i)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI32(i);
            return;
        } else
        {
            align(4);
            byte abyte0[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i & 0xff);
            abyte0 = mData;
            j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i >> 8 & 0xff);
            abyte0 = mData;
            j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i >> 16 & 0xff);
            abyte0 = mData;
            j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i >> 24 & 0xff);
            return;
        }
    }

    public void addI32(android.support.v8.renderscript.Int2 int2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI32(new Int2(int2.x, int2.y));
            return;
        } else
        {
            addI32(int2.x);
            addI32(int2.y);
            return;
        }
    }

    public void addI32(android.support.v8.renderscript.Int3 int3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI32(new Int3(int3.x, int3.y, int3.z));
            return;
        } else
        {
            addI32(int3.x);
            addI32(int3.y);
            addI32(int3.z);
            return;
        }
    }

    public void addI32(android.support.v8.renderscript.Int4 int4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI32(new Int4(int4.x, int4.y, int4.z, int4.w));
            return;
        } else
        {
            addI32(int4.x);
            addI32(int4.y);
            addI32(int4.z);
            addI32(int4.w);
            return;
        }
    }

    public void addI64(long l)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI64(l);
            return;
        } else
        {
            align(8);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 8 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 16 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 24 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 32 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 40 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 48 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 56 & 255L);
            return;
        }
    }

    public void addI64(android.support.v8.renderscript.Long2 long2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI64(new Long2(long2.x, long2.y));
            return;
        } else
        {
            addI64(long2.x);
            addI64(long2.y);
            return;
        }
    }

    public void addI64(android.support.v8.renderscript.Long3 long3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI64(new Long3(long3.x, long3.y, long3.z));
            return;
        } else
        {
            addI64(long3.x);
            addI64(long3.y);
            addI64(long3.z);
            return;
        }
    }

    public void addI64(android.support.v8.renderscript.Long4 long4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI64(new Long4(long4.x, long4.y, long4.z, long4.w));
            return;
        } else
        {
            addI64(long4.x);
            addI64(long4.y);
            addI64(long4.z);
            addI64(long4.w);
            return;
        }
    }

    public void addI8(byte byte0)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI8(byte0);
            return;
        } else
        {
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    public void addI8(android.support.v8.renderscript.Byte2 byte2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI8(new Byte2(byte2.x, byte2.y));
            return;
        } else
        {
            addI8(byte2.x);
            addI8(byte2.y);
            return;
        }
    }

    public void addI8(android.support.v8.renderscript.Byte3 byte3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI8(new Byte3(byte3.x, byte3.y, byte3.z));
            return;
        } else
        {
            addI8(byte3.x);
            addI8(byte3.y);
            addI8(byte3.z);
            return;
        }
    }

    public void addI8(android.support.v8.renderscript.Byte4 byte4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addI8(new Byte4(byte4.x, byte4.y, byte4.z, byte4.w));
            return;
        } else
        {
            addI8(byte4.x);
            addI8(byte4.y);
            addI8(byte4.z);
            addI8(byte4.w);
            return;
        }
    }

    public void addMatrix(android.support.v8.renderscript.Matrix2f matrix2f)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addMatrix(new Matrix2f(matrix2f.getArray()));
        } else
        {
            int i = 0;
            while (i < matrix2f.mMat.length) 
            {
                addF32(matrix2f.mMat[i]);
                i++;
            }
        }
    }

    public void addMatrix(android.support.v8.renderscript.Matrix3f matrix3f)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addMatrix(new Matrix3f(matrix3f.getArray()));
        } else
        {
            int i = 0;
            while (i < matrix3f.mMat.length) 
            {
                addF32(matrix3f.mMat[i]);
                i++;
            }
        }
    }

    public void addMatrix(android.support.v8.renderscript.Matrix4f matrix4f)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addMatrix(new Matrix4f(matrix4f.getArray()));
        } else
        {
            int i = 0;
            while (i < matrix4f.mMat.length) 
            {
                addF32(matrix4f.mMat[i]);
                i++;
            }
        }
    }

    public void addObj(BaseObj baseobj)
    {
        if (RenderScript.shouldThunk())
        {
            if (baseobj != null)
            {
                mN.addObj(baseobj.getNObj());
                return;
            } else
            {
                mN.addObj(null);
                return;
            }
        }
        if (baseobj != null)
        {
            addI32(baseobj.getID(null));
            return;
        } else
        {
            addI32(0);
            return;
        }
    }

    public void addU16(int i)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU16(i);
            return;
        }
        if (i < 0 || i > 65535)
        {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU16( ").append(i).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else
        {
            align(2);
            byte abyte0[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i & 0xff);
            abyte0 = mData;
            j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i >> 8);
            return;
        }
    }

    public void addU16(android.support.v8.renderscript.Int2 int2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU16(new Int2(int2.x, int2.y));
            return;
        } else
        {
            addU16(int2.x);
            addU16(int2.y);
            return;
        }
    }

    public void addU16(android.support.v8.renderscript.Int3 int3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU16(new Int3(int3.x, int3.y, int3.z));
            return;
        } else
        {
            addU16(int3.x);
            addU16(int3.y);
            addU16(int3.z);
            return;
        }
    }

    public void addU16(android.support.v8.renderscript.Int4 int4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU16(new Int4(int4.x, int4.y, int4.z, int4.w));
            return;
        } else
        {
            addU16(int4.x);
            addU16(int4.y);
            addU16(int4.z);
            addU16(int4.w);
            return;
        }
    }

    public void addU32(long l)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU32(l);
            return;
        }
        if (l < 0L || l > 0xffffffffL)
        {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU32( ").append(l).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else
        {
            align(4);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 8 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 16 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 24 & 255L);
            return;
        }
    }

    public void addU32(android.support.v8.renderscript.Long2 long2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU32(new Long2(long2.x, long2.y));
            return;
        } else
        {
            addU32(long2.x);
            addU32(long2.y);
            return;
        }
    }

    public void addU32(android.support.v8.renderscript.Long3 long3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU32(new Long3(long3.x, long3.y, long3.z));
            return;
        } else
        {
            addU32(long3.x);
            addU32(long3.y);
            addU32(long3.z);
            return;
        }
    }

    public void addU32(android.support.v8.renderscript.Long4 long4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU32(new Long4(long4.x, long4.y, long4.z, long4.w));
            return;
        } else
        {
            addU32(long4.x);
            addU32(long4.y);
            addU32(long4.z);
            addU32(long4.w);
            return;
        }
    }

    public void addU64(long l)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU64(l);
            return;
        }
        if (l < 0L)
        {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU64( ").append(l).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else
        {
            align(8);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 8 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 16 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 24 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 32 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 40 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 48 & 255L);
            abyte0 = mData;
            i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l >> 56 & 255L);
            return;
        }
    }

    public void addU64(android.support.v8.renderscript.Long2 long2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU64(new Long2(long2.x, long2.y));
            return;
        } else
        {
            addU64(long2.x);
            addU64(long2.y);
            return;
        }
    }

    public void addU64(android.support.v8.renderscript.Long3 long3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU64(new Long3(long3.x, long3.y, long3.z));
            return;
        } else
        {
            addU64(long3.x);
            addU64(long3.y);
            addU64(long3.z);
            return;
        }
    }

    public void addU64(android.support.v8.renderscript.Long4 long4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU64(new Long4(long4.x, long4.y, long4.z, long4.w));
            return;
        } else
        {
            addU64(long4.x);
            addU64(long4.y);
            addU64(long4.z);
            addU64(long4.w);
            return;
        }
    }

    public void addU8(android.support.v8.renderscript.Short2 short2)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU8(new Short2(short2.x, short2.y));
            return;
        } else
        {
            addU8(short2.x);
            addU8(short2.y);
            return;
        }
    }

    public void addU8(android.support.v8.renderscript.Short3 short3)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU8(new Short3(short3.x, short3.y, short3.z));
            return;
        } else
        {
            addU8(short3.x);
            addU8(short3.y);
            addU8(short3.z);
            return;
        }
    }

    public void addU8(android.support.v8.renderscript.Short4 short4)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU8(new Short4(short4.x, short4.y, short4.z, short4.w));
            return;
        } else
        {
            addU8(short4.x);
            addU8(short4.y);
            addU8(short4.z);
            addU8(short4.w);
            return;
        }
    }

    public void addU8(short word0)
    {
        if (RenderScript.shouldThunk())
        {
            mN.addU8(word0);
            return;
        }
        if (word0 < 0 || word0 > 255)
        {
            throw new IllegalArgumentException("Saving value out of range for type");
        } else
        {
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)word0;
            return;
        }
    }

    public void align(int i)
    {
        if (RenderScript.shouldThunk())
        {
            mN.align(i);
        } else
        {
            if (i <= 0 || (i - 1 & i) != 0)
            {
                throw new RSIllegalArgumentException((new StringBuilder()).append("argument must be a non-negative non-zero power of 2: ").append(i).toString());
            }
            while ((mPos & i - 1) != 0) 
            {
                byte abyte0[] = mData;
                int j = mPos;
                mPos = j + 1;
                abyte0[j] = 0;
            }
        }
    }

    public final byte[] getData()
    {
        if (RenderScript.shouldThunk())
        {
            return mN.getData();
        } else
        {
            return mData;
        }
    }

    public void reset()
    {
        if (RenderScript.shouldThunk())
        {
            mN.reset();
            return;
        } else
        {
            mPos = 0;
            return;
        }
    }

    public void reset(int i)
    {
        if (RenderScript.shouldThunk())
        {
            mN.reset(i);
            return;
        }
        if (i < 0 || i >= mLen)
        {
            throw new RSIllegalArgumentException((new StringBuilder()).append("out of range argument: ").append(i).toString());
        } else
        {
            mPos = i;
            return;
        }
    }

    public void skip(int i)
    {
        if (RenderScript.shouldThunk())
        {
            mN.skip(i);
            return;
        }
        int j = mPos + i;
        if (j < 0 || j > mLen)
        {
            throw new RSIllegalArgumentException((new StringBuilder()).append("out of range argument: ").append(i).toString());
        } else
        {
            mPos = j;
            return;
        }
    }
}
