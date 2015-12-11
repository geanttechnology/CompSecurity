// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CameraSetting
    implements Externalizable
{

    private static final long serialVersionUID = 0x773635a4cd84a345L;
    public float backFacingAspectRatio;
    public int degrees;
    public int frameRate;
    public boolean frontFacing;
    public float frontFacingAspectRatio;
    public int imageFormat;
    public int originalFrameRate;
    public int originalH;
    public int originalW;
    public int tpf;

    public CameraSetting()
    {
    }

    public CameraSetting(int i, int j, int k, int l, int i1, boolean flag, float f, 
            float f1)
    {
        originalW = i;
        originalH = j;
        degrees = k;
        frameRate = l;
        originalFrameRate = l;
        tpf = 1000 / l;
        imageFormat = i1;
        frontFacing = flag;
        frontFacingAspectRatio = f;
        backFacingAspectRatio = f1;
    }

    public CameraSetting(CameraSetting camerasetting)
    {
        originalW = camerasetting.originalW;
        originalH = camerasetting.originalH;
        degrees = camerasetting.degrees;
        frameRate = camerasetting.frameRate;
        originalFrameRate = camerasetting.originalFrameRate;
        tpf = camerasetting.tpf;
        imageFormat = camerasetting.imageFormat;
        frontFacing = camerasetting.frontFacing;
        frontFacingAspectRatio = camerasetting.frontFacingAspectRatio;
        backFacingAspectRatio = camerasetting.backFacingAspectRatio;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        originalW = objectinput.readInt();
        originalH = objectinput.readInt();
        degrees = objectinput.readInt();
        frameRate = objectinput.readInt();
        tpf = objectinput.readInt();
        imageFormat = objectinput.readInt();
        frontFacing = objectinput.readBoolean();
        frontFacingAspectRatio = objectinput.readFloat();
        backFacingAspectRatio = objectinput.readFloat();
        originalFrameRate = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeInt(originalW);
        objectoutput.writeInt(originalH);
        objectoutput.writeInt(degrees);
        objectoutput.writeInt(frameRate);
        objectoutput.writeInt(tpf);
        objectoutput.writeInt(imageFormat);
        objectoutput.writeBoolean(frontFacing);
        objectoutput.writeFloat(frontFacingAspectRatio);
        objectoutput.writeFloat(backFacingAspectRatio);
        objectoutput.writeInt(originalFrameRate);
    }
}
