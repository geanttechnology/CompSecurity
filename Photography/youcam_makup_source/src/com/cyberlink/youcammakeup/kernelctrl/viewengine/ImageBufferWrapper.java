// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.AccessMode;
import com.cyberlink.youcammakeup.jniproxy.PixelFormat;
import com.cyberlink.youcammakeup.jniproxy.UIBytePerPixel;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.UIJPEGSubSampling;
import com.cyberlink.youcammakeup.jniproxy.UITiffCompression;
import com.cyberlink.youcammakeup.jniproxy.as;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.p;
import com.cyberlink.youcammakeup.jniproxy.v;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.utility.bb;
import com.pf.common.utility.m;
import java.io.File;
import java.io.FileDescriptor;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            ViewEngine, b, k

public class ImageBufferWrapper
    implements Serializable
{

    private static final k e = new k(Globals.d().l());
    private static AtomicLong f = new AtomicLong(0L);
    private static final android.graphics.BitmapFactory.Options g;
    private static final long serialVersionUID = 1L;
    transient d a;
    transient int b;
    String bufferKey;
    transient int c;
    transient long d;
    private AccessMode imageAccessMode;
    long imageID;
    ViewEngine.ImageType imageType;
    boolean isImageBufferAttachedFromBitmap;
    public String name;
    ROI roi;
    double scaleRatio;
    long srcH;
    long srcW;
    long uuid;

    public ImageBufferWrapper()
    {
        isImageBufferAttachedFromBitmap = false;
        uuid = o();
        name = "";
        a = null;
        imageID = -1L;
        roi = null;
        imageType = ViewEngine.ImageType.a;
        scaleRatio = 1.0D;
        b = 0;
        c = -1;
        srcW = 0L;
        srcH = 0L;
        imageAccessMode = AccessMode.b;
        d = 0L;
        bufferKey = p();
    }

    public ImageBufferWrapper(Bitmap bitmap)
    {
        this();
        a(bitmap);
    }

    public ImageBufferWrapper(FileDescriptor filedescriptor)
    {
        this(a(filedescriptor));
    }

    private static Bitmap a(FileDescriptor filedescriptor)
    {
        return BitmapFactory.decodeFileDescriptor(filedescriptor, null, g);
    }

    private boolean a(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (s.equals(""))
        {
            return false;
        }
        boolean flag;
        p p1 = new p();
        if (!com.cyberlink.youcammakeup.jniproxy.d.a(s, p1))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        a(p1.b(), p1.c(), p1.d());
        flag = j().a(s);
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_63;
        s;
        return false;
    }

    private boolean b(String s)
    {
        d d1 = j();
        if (d1 != null)
        {
            boolean flag;
            try
            {
                flag = d1.b(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    private void c(String s)
    {
    }

    private long o()
    {
        return f.addAndGet(1L) % 8192L;
    }

    private String p()
    {
        return UUID.randomUUID().toString();
    }

    private void q()
    {
        c("[ImageBufferWrapper][detachBufferFromAndroidBitmap] starts");
        if (a == null)
        {
            c("[ImageBufferWrapper][detachBufferFromAndroidBitmap] imageBuffer is null. do nothing");
            return;
        } else
        {
            boolean flag = a.c();
            c((new StringBuilder()).append("[ImageBufferWrapper][detachBufferFromAndroidBitmap] ends. bRet=").append(flag).toString());
            return;
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            objectinputstream.defaultReadObject();
            uuid = o();
            objectinputstream = (String)objectinputstream.readObject();
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            return;
        }
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        a(objectinputstream);
        bb.b(new File(objectinputstream));
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.defaultWriteObject();
            String s1 = Globals.d().q();
            String s = UUID.randomUUID().toString();
            s1 = (new StringBuilder()).append(s1).append("/").append("_imagebuffer_saved").toString();
            if (!(new File(s1)).exists())
            {
                bb.a(s1);
            }
            s = (new StringBuilder()).append(s1).append("/").append(s).toString();
            if (b(s))
            {
                objectoutputstream.writeObject(s);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            return;
        }
        objectoutputstream.writeObject(null);
        return;
    }

    public PixelFormat a()
    {
        if (a != null)
        {
            return a.h();
        } else
        {
            return null;
        }
    }

    public void a(long l1)
    {
        if (l1 != 4L && l1 != 8L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid bpp value. bpp=").append(l1).toString());
        }
        c((new StringBuilder()).append("[ImageBufferWrapper][createEmptyBuffer] imageID:").append(imageID).append(" bpp:").append(l1).toString());
        if (a != null)
        {
            a.b();
            a = null;
            roi = null;
            isImageBufferAttachedFromBitmap = false;
        }
        if (l1 == 4L)
        {
            a = new d(PixelFormat.b);
        } else
        {
            a = new d(PixelFormat.d);
        }
        l();
        ViewEngine.a().b().a(this);
        c((new StringBuilder()).append("[ImageBufferWrapper][createEmptyBuffer] End imageID:").append(imageID).toString());
    }

    public void a(long l1, long l2, long l3)
    {
        if (l3 != 4L && l3 != 8L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid bpp value. bpp=").append(l3).toString());
        }
        c((new StringBuilder()).append("[ImageBufferWrapper][createBuffer] width:").append(l1).append(" height:").append(l2).append(" bpp:").append(l3).toString());
        if (a != null)
        {
            a.b();
            a = null;
            roi = null;
            isImageBufferAttachedFromBitmap = false;
        }
        boolean flag;
        if (l3 == 4L)
        {
            a = new d(PixelFormat.b);
        } else
        {
            a = new d(PixelFormat.d);
        }
        flag = a.a(l1, l2, l3);
        if (flag)
        {
            srcW = l1;
            srcH = l2;
            a(AccessMode.b);
            l();
            ViewEngine.a().b().a(this);
        }
        c((new StringBuilder()).append("[ImageBufferWrapper][createBuffer] End imageID:").append(imageID).append(" ret:").append(flag).toString());
    }

    public void a(Bitmap bitmap)
    {
        c("[ImageBufferWrapper][createBufferFromAndroidBitmap] starts");
        if (bitmap == null)
        {
            throw new IllegalArgumentException("The bitmap cannot be null");
        }
        d d1 = new d(PixelFormat.a);
        if (d1.a(bitmap))
        {
            srcW = d1.e();
            srcH = d1.f();
            a(srcW, srcH, d1.g());
            a.a(d1.h());
            boolean flag = com.cyberlink.youcammakeup.jniproxy.d.a(d1, a);
            c((new StringBuilder()).append("[ImageBufferWrapper][createBufferFromAndroidBitmap] SwapColorChannel ret=").append(flag).toString());
            d1.c();
            d1.b();
            c("[ImageBufferWrapper][createBufferFromAndroidBitmap] ends");
            return;
        } else
        {
            throw new RuntimeException("[ImageBufferWrapper][createBufferFromAndroidBitmap] Unexpected Error: cannot attach bitmap to tempBuffer.imageBuffer correctly");
        }
    }

    public void a(AccessMode accessmode)
    {
        if (a != null)
        {
            imageAccessMode = accessmode;
            if (imageAccessMode == AccessMode.a || imageAccessMode == AccessMode.b)
            {
                a.a(imageAccessMode);
            }
            return;
        } else
        {
            imageAccessMode = null;
            c((new StringBuilder()).append("[ImageBufferWrapper][setImageAccessMode] the buffer isn't existed. ImageID").append(imageID).toString());
            return;
        }
    }

    public boolean a(ImageBufferWrapper imagebufferwrapper)
    {
        if (imagebufferwrapper != null)
        {
            if (imagebufferwrapper.a != null);
        }
        return a(imagebufferwrapper, (new ROI(0, 0, (int)imagebufferwrapper.b(), (int)imagebufferwrapper.c())).e());
    }

    public boolean a(ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation)
    {
        long l1 = imagebufferwrapper.b();
        long l2 = imagebufferwrapper.c();
        if (uiimageorientation == UIImageOrientation.g || uiimageorientation == UIImageOrientation.i || uiimageorientation == UIImageOrientation.f || uiimageorientation == UIImageOrientation.h)
        {
            l1 = imagebufferwrapper.c();
            l2 = imagebufferwrapper.b();
        }
        a(l1, l2, imagebufferwrapper.d());
        imagebufferwrapper.l();
        boolean flag = e.a(imagebufferwrapper.a, a, uiimageorientation);
        imagebufferwrapper.m();
        return flag;
    }

    public boolean a(ImageBufferWrapper imagebufferwrapper, as as)
    {
        boolean flag = false;
        c((new StringBuilder()).append("[ImageBufferWrapper][createBufferFromImageBuffer] createBufferFromImageBufferAsync ").append(e()).toString());
        if (a != null)
        {
            a.b();
            a = null;
            roi = null;
            isImageBufferAttachedFromBitmap = false;
        }
        if (imagebufferwrapper.a() != null)
        {
            a = new d(imagebufferwrapper.a());
            imagebufferwrapper.l();
            boolean flag1 = a.a(imagebufferwrapper.a, as);
            imagebufferwrapper.m();
            c((new StringBuilder()).append("[ImageBufferWrapper][createBufferFromImageBuffer] End ret:").append(flag1).append(" ").append(e()).toString());
            flag = flag1;
            if (flag1)
            {
                srcW = imagebufferwrapper.b();
                srcH = imagebufferwrapper.c();
                l();
                ViewEngine.a().b().a(this);
                return flag1;
            }
        }
        return flag;
    }

    public boolean a(String s, UIImageOrientation uiimageorientation)
    {
        uiimageorientation = new v(UIImageFormat.b, 100, UITiffCompression.a, UIJPEGSubSampling.d, UIBytePerPixel.a, uiimageorientation);
        if (e.a(s, a, uiimageorientation, null) == UIImageCodecErrorCode.a)
        {
            c("[ImageBufferWrapper][encodeToFile] Success");
            return true;
        } else
        {
            c("[ImageBufferWrapper][encodeToFile] Failed");
            return false;
        }
    }

    public long b()
    {
        if (a != null)
        {
            return a.e();
        } else
        {
            return -1L;
        }
    }

    public void b(Bitmap bitmap)
    {
        c("[ImageBufferWrapper][attachBufferFromAndroidBitmap] starts");
        if (bitmap == null)
        {
            c("[ImageBufferWrapper][attachBufferFromAndroidBitmap] The bitmap is null. Skip it.");
            return;
        }
        if (a != null)
        {
            throw new RuntimeException("[ImageBufferWrapper][attachBufferFromAndroidBitmap] Unexpected Usage: should not attach bitmap to an imageBufferWrapper which already has imageBuffer");
        }
        isImageBufferAttachedFromBitmap = true;
        a = new d();
        boolean flag = a.a(bitmap);
        if (flag)
        {
            srcW = bitmap.getWidth();
            srcH = bitmap.getHeight();
            a(AccessMode.b);
            l();
            if (a() == PixelFormat.a || a() == PixelFormat.c)
            {
                k();
            }
            ViewEngine.a().b().a(this);
            c((new StringBuilder()).append("[ImageBufferWrapper][attachBufferFromAndroidBitmap] ends. ret=").append(flag).toString());
            return;
        } else
        {
            throw new RuntimeException("[ImageBufferWrapper][attachBufferFromAndroidBitmap] Unexpected Error: cannot attach bitmap to imageBuffer correctly");
        }
    }

    public long c()
    {
        if (a != null)
        {
            return a.f();
        } else
        {
            return -1L;
        }
    }

    public boolean c(Bitmap bitmap)
    {
        ImageBufferWrapper imagebufferwrapper;
        d d1;
        boolean flag1;
        imagebufferwrapper = null;
        if (bitmap == null)
        {
            throw new IllegalArgumentException("[ImageBufferWrapper][copyToAndroidBitmap] Invalid bitmap: bitmap should not be null");
        }
        if (a == null)
        {
            throw new RuntimeException("[ImageBufferWrapper][copyToAndroidBitmap] Unexpected Error: imageBuffer is null");
        }
        if ((long)bitmap.getWidth() != a.e() || (long)bitmap.getHeight() != a.f())
        {
            throw new RuntimeException("[ImageBufferWrapper][copyToAndroidBitmap] unfit size error");
        }
        l();
        if (d() == 8L)
        {
            c((new StringBuilder()).append("[ImageBufferWrapper][copyToAndroidBitmap] 8bpp covert ").append(e()).toString());
            imagebufferwrapper = new ImageBufferWrapper();
            imagebufferwrapper.name = "bppConvertBufferWrapper";
            imagebufferwrapper.a(b(), c(), 4L);
            boolean flag = com.cyberlink.youcammakeup.jniproxy.d.b(a, imagebufferwrapper.a);
            Globals.d().e((new StringBuilder()).append("ImageBufferWrapper::copyToAndroidBitmap(), info. getBpp() == 8, bRet").append(flag).append(", imageBuffer.w=").append(a.e()).append(", imageBuffer.h").append(a.f()).toString());
            if (!flag)
            {
                throw new RuntimeException("[ImageBufferWrapper][copyToAndroidBitmap] convert bpp error");
            }
        }
        if (imagebufferwrapper == null)
        {
            imagebufferwrapper = this;
        }
        imagebufferwrapper.l();
        d1 = new d();
        flag1 = d1.a(bitmap);
        if (!flag1)
        {
            Globals.d().e((new StringBuilder()).append("ImageBufferWrapper::AttachAndroidBitmap(), error. bitmap.w=").append(bitmap.getWidth()).append(", bitmap.h=").append(bitmap.getHeight()).toString());
        }
        c((new StringBuilder()).append("[ImageBufferWrapper][copyToAndroidBitmap] dstBuffer.AttachAndroidBitmap bRet=").append(flag1).toString());
        if (a() != PixelFormat.b && a() != PixelFormat.d) goto _L2; else goto _L1
_L1:
        flag1 = com.cyberlink.youcammakeup.jniproxy.d.a(imagebufferwrapper.a, d1);
        c((new StringBuilder()).append("[ImageBufferWrapper][copyToAndroidBitmap] CImageBuffer.SwapColorChannel bRet=").append(flag1).toString());
_L4:
        d1.c();
        d1.b();
        imagebufferwrapper.m();
        m();
        return flag1;
_L2:
        try
        {
            flag1 = com.cyberlink.youcammakeup.jniproxy.d.a(imagebufferwrapper.a, d1, null);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            flag1 = false;
            com.pf.common.utility.m.b("ImageBufferWrapper", "[ImageBufferWrapper][copyToAndroidBitmap] exception:", bitmap);
        }
        c((new StringBuilder()).append("[ImageBufferWrapper][copyToAndroidBitmap] CImageBuffer.CopyImageBufferToImageBuffer bRet=").append(flag1).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public long d()
    {
        if (a != null)
        {
            return a.g();
        } else
        {
            return -1L;
        }
    }

    public String e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("UUID: ").append(uuid).append(" ImageID: ").append(imageID).append(" ScaleRatio:").append(scaleRatio);
        stringbuilder.append(" ImageType:").append(imageType).append(" useCount:").append(b).append(" name:").append(name);
        stringbuilder.append(" w: ").append(b()).append(" h: ").append(c());
        stringbuilder.append(" bpp: ").append(d()).append(" Ref. Count:").append(d);
        StringBuilder stringbuilder1 = stringbuilder.append(" ROI:");
        double d1;
        double d2;
        Object obj;
        if (roi == null)
        {
            obj = "null";
        } else
        {
            obj = roi.toString();
        }
        stringbuilder1.append(((String) (obj)));
        stringbuilder.append(" isImageBufferAttachedFromBitmap:").append(isImageBufferAttachedFromBitmap);
        d1 = h();
        obj = stringbuilder.append(" Native MemSize:");
        if (isImageBufferAttachedFromBitmap)
        {
            d2 = 0.0D;
        } else
        {
            d2 = d1;
        }
        ((StringBuilder) (obj)).append(d2).append(" MB");
        obj = stringbuilder.append(" Bitmap MemSize:");
        if (!isImageBufferAttachedFromBitmap)
        {
            d1 = 0.0D;
        }
        ((StringBuilder) (obj)).append(d1).append(" MB");
        return stringbuilder.toString();
    }

    public String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(imageID).append("_").append(imageType).append("_");
        stringbuilder.append(b()).append("_").append(c()).append("_");
        stringbuilder.append(scaleRatio * 100D).append("_").append(bufferKey);
        return stringbuilder.toString();
    }

    public boolean g()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (a != null)
        {
            flag = flag1;
            if (scaleRatio == 1.0D)
            {
                flag = flag1;
                if (imageType == ViewEngine.ImageType.a)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public double h()
    {
        long l1;
        long l2;
        if (roi != null)
        {
            l1 = roi.c();
        } else
        {
            l1 = b();
        }
        if (roi != null)
        {
            l2 = roi.d();
        } else
        {
            l2 = c();
        }
        return com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(((double)l1 * (double)l2 * (double)d()) / 1048576D, 3);
    }

    public Bitmap i()
    {
        if (a == null)
        {
            return null;
        } else
        {
            Bitmap bitmap = Bitmap.createBitmap((int)a.e(), (int)a.f(), android.graphics.Bitmap.Config.ARGB_8888);
            c(bitmap);
            return bitmap;
        }
    }

    public d j()
    {
        return a;
    }

    public boolean k()
    {
        c((new StringBuilder()).append("[ImageBufferWrapper][swapColorChannel] start ").append(e()).toString());
        if (a != null && imageAccessMode == AccessMode.b)
        {
            l();
            boolean flag = com.cyberlink.youcammakeup.jniproxy.d.b(a);
            c((new StringBuilder()).append("[ImageBufferWrapper][swapColorChannel] end success. ret=").append(flag).append(" ").append(e()).toString());
            m();
            return true;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("[ImageBufferWrapper][swapColorChannel] the buffer is not in the correct status.");
        String s;
        if (a == null)
        {
            s = " imageBuffer is null.";
        } else
        {
            s = "";
        }
        s = stringbuilder.append(s).toString();
        throw new RuntimeException((new StringBuilder()).append(s).append(" imageAccessMode=").append(imageAccessMode).toString());
    }

    public long l()
    {
        d = d + 1L;
        b = b + 1;
        return d;
    }

    public long m()
    {
        b = b - 1;
        if (d > 0L)
        {
            d = d - 1L;
        } else
        {
            c((new StringBuilder()).append("[ImageBufferWrapper][release] Failed to release the buffer:").append(e()).toString());
        }
        if (d <= 0L)
        {
            n();
        }
        return d;
    }

    public void n()
    {
        c((new StringBuilder()).append("[ImageBufferWrapper][destroy] ").append(e()).toString());
        if (a != null)
        {
            if (isImageBufferAttachedFromBitmap)
            {
                q();
            }
            a.b();
        }
        a = null;
        isImageBufferAttachedFromBitmap = false;
        d = 0L;
        b = 0;
    }

    static 
    {
        g = new android.graphics.BitmapFactory.Options();
        g.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
    }
}
