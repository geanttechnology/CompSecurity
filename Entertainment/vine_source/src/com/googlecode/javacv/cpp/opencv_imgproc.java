// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.SizeTPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public class opencv_imgproc
{
    public static class BaseColumnFilter extends Pointer
    {

        public native int anchor();

        public native BaseColumnFilter anchor(int i);

        public native void filter(PointerPointer pointerpointer, BytePointer bytepointer, int i, int j, int k);

        public native int ksize();

        public native BaseColumnFilter ksize(int i);

        public native void reset();

        static 
        {
            Loader.load();
        }

        public BaseColumnFilter()
        {
        }

        public BaseColumnFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class BaseFilter extends Pointer
    {

        public native opencv_core.CvPoint anchor();

        public native BaseFilter anchor(opencv_core.CvPoint cvpoint);

        public native void filter(PointerPointer pointerpointer, BytePointer bytepointer, int i, int j, int k, int l);

        public native opencv_core.CvSize ksize();

        public native BaseFilter ksize(opencv_core.CvSize cvsize);

        public native void reset();

        static 
        {
            Loader.load();
        }

        public BaseFilter()
        {
        }

        public BaseFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class BaseRowFilter extends Pointer
    {

        public native int anchor();

        public native BaseRowFilter anchor(int i);

        public native void filter(BytePointer bytepointer, BytePointer bytepointer1, int i, int j);

        public native int ksize();

        public native BaseRowFilter ksize(int i);

        static 
        {
            Loader.load();
        }

        public BaseRowFilter()
        {
        }

        public BaseRowFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CLAHE extends opencv_core.Algorithm
    {

        public native void apply(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

        public native void collectGarbage();

        public native double getClipLimit();

        public native opencv_core.CvSize getTilesGridSize();

        public native void setClipLimit(double d);

        public native void setTilesGridSize(opencv_core.CvSize cvsize);

        static 
        {
            Loader.load();
        }

        public CLAHE()
        {
        }

        public CLAHE(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvChainPtReader extends opencv_core.CvSeqReader
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native byte code();

        public native CvChainPtReader code(byte byte0);

        public native byte deltas(int i, int j);

        public native CvChainPtReader deltas(int i, int j, byte byte0);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile opencv_core.CvSeqReader position(int i)
        {
            return position(i);
        }

        public CvChainPtReader position(int i)
        {
            return (CvChainPtReader)super.position(i);
        }

        public native opencv_core.CvPoint pt();

        public native CvChainPtReader pt(opencv_core.CvPoint cvpoint);

        static 
        {
            Loader.load();
        }

        public CvChainPtReader()
        {
            allocate();
        }

        public CvChainPtReader(int i)
        {
            allocateArray(i);
        }

        public CvChainPtReader(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvConnectedComp extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native double area();

        public native CvConnectedComp area(double d);

        public native opencv_core.CvSeq contour();

        public native CvConnectedComp contour(opencv_core.CvSeq cvseq);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvConnectedComp position(int i)
        {
            return (CvConnectedComp)super.position(i);
        }

        public native opencv_core.CvRect rect();

        public native CvConnectedComp rect(opencv_core.CvRect cvrect);

        public native opencv_core.CvScalar value();

        public native CvConnectedComp value(opencv_core.CvScalar cvscalar);

        static 
        {
            Loader.load();
        }

        public CvConnectedComp()
        {
            allocate();
        }

        public CvConnectedComp(int i)
        {
            allocateArray(i);
        }

        public CvConnectedComp(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvContourScanner extends Pointer
    {

        static 
        {
            Loader.load();
        }

        public CvContourScanner()
        {
        }

        public CvContourScanner(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvConvexityDefect extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native float depth();

        public native CvConvexityDefect depth(float f);

        public native opencv_core.CvPoint depth_point();

        public native CvConvexityDefect depth_point(opencv_core.CvPoint cvpoint);

        public native opencv_core.CvPoint end();

        public native CvConvexityDefect end(opencv_core.CvPoint cvpoint);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvConvexityDefect position(int i)
        {
            return (CvConvexityDefect)super.position(i);
        }

        public native opencv_core.CvPoint start();

        public native CvConvexityDefect start(opencv_core.CvPoint cvpoint);

        static 
        {
            Loader.load();
        }

        public CvConvexityDefect()
        {
            allocate();
        }

        public CvConvexityDefect(int i)
        {
            allocateArray(i);
        }

        public CvConvexityDefect(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvDistanceFunction extends FunctionPointer
    {

        private native void allocate();

        public native float call(FloatPointer floatpointer, FloatPointer floatpointer1, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected CvDistanceFunction()
        {
            allocate();
        }

        public CvDistanceFunction(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvFeatureTree extends Pointer
    {

        static 
        {
            Loader.load();
        }

        public CvFeatureTree()
        {
        }

        public CvFeatureTree(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvHistogram extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvHistogram create(int i, int ai[], int j, float af[][], int k)
        {
            ai = opencv_imgproc.cvCreateHist(i, ai, j, af, k);
            if (ai != null)
            {
                ai.deallocator(new ReleaseDeallocator(ai));
            }
            return ai;
        }

        public native opencv_core.CvArr bins();

        public native CvHistogram bins(opencv_core.CvArr cvarr);

        public native opencv_core.CvMatND mat();

        public native CvHistogram mat(opencv_core.CvMatND cvmatnd);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvHistogram position(int i)
        {
            return (CvHistogram)super.position(i);
        }

        public void release()
        {
            deallocate();
        }

        public native float thresh(int i, int j);

        public native CvHistogram thresh(int i, int j, float f);

        public native PointerPointer thresh2();

        public native CvHistogram thresh2(PointerPointer pointerpointer);

        public native int type();

        public native CvHistogram type(int i);

        static 
        {
            Loader.load();
        }

        public CvHistogram()
        {
            allocate();
            zero();
        }

        public CvHistogram(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvHistogram(Pointer pointer)
        {
            super(pointer);
        }
    }

    static class CvHistogram.ReleaseDeallocator extends CvHistogram
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_imgproc.cvReleaseHist(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvHistogram.ReleaseDeallocator(CvHistogram cvhistogram)
        {
            super(cvhistogram);
        }
    }

    public static class CvHuMoments extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native double hu1();

        public native CvHuMoments hu1(double d);

        public native double hu2();

        public native CvHuMoments hu2(double d);

        public native double hu3();

        public native CvHuMoments hu3(double d);

        public native double hu4();

        public native CvHuMoments hu4(double d);

        public native double hu5();

        public native CvHuMoments hu5(double d);

        public native double hu6();

        public native CvHuMoments hu6(double d);

        public native double hu7();

        public native CvHuMoments hu7(double d);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvHuMoments position(int i)
        {
            return (CvHuMoments)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvHuMoments()
        {
            allocate();
        }

        public CvHuMoments(int i)
        {
            allocateArray(i);
        }

        public CvHuMoments(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvMoments extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static ThreadLocal createThreadLocal()
        {
            return new ThreadLocal() {

                protected CvMoments initialValue()
                {
                    return new CvMoments();
                }

                protected volatile Object initialValue()
                {
                    return initialValue();
                }

            };
        }

        public native double inv_sqrt_m00();

        public native CvMoments inv_sqrt_m00(double d);

        public native double m00();

        public native CvMoments m00(double d);

        public native double m01();

        public native CvMoments m01(double d);

        public native double m02();

        public native CvMoments m02(double d);

        public native double m03();

        public native CvMoments m03(double d);

        public native double m10();

        public native CvMoments m10(double d);

        public native double m11();

        public native CvMoments m11(double d);

        public native double m12();

        public native CvMoments m12(double d);

        public native double m20();

        public native CvMoments m20(double d);

        public native double m21();

        public native CvMoments m21(double d);

        public native double m30();

        public native CvMoments m30(double d);

        public native double mu02();

        public native CvMoments mu02(double d);

        public native double mu03();

        public native CvMoments mu03(double d);

        public native double mu11();

        public native CvMoments mu11(double d);

        public native double mu12();

        public native CvMoments mu12(double d);

        public native double mu20();

        public native CvMoments mu20(double d);

        public native double mu21();

        public native CvMoments mu21(double d);

        public native double mu30();

        public native CvMoments mu30(double d);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMoments position(int i)
        {
            return (CvMoments)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvMoments()
        {
            allocate();
        }

        public CvMoments(int i)
        {
            allocateArray(i);
        }

        public CvMoments(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvQuadEdge2D extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static long cvSubdiv2DRotateEdge(long l, int i)
        {
            return (-4L & l) + ((long)i + l & 3L);
        }

        public static long cvSubdiv2DSymEdge(long l)
        {
            return 2L ^ l;
        }

        public long CV_SUBDIV2D_NEXT_EDGE(long l)
        {
            return next((int)l & 3);
        }

        public CvSubdiv2DPoint cvSubdiv2DEdgeDst(long l)
        {
            return pt((int)l + 2 & 3);
        }

        public CvSubdiv2DPoint cvSubdiv2DEdgeOrg(long l)
        {
            return pt((int)l & 3);
        }

        public long cvSubdiv2DGetEdge(long l, int i)
        {
            l = next((int)l + i & 3);
            return (-4L & l) + ((long)(i >> 4) + l & 3L);
        }

        public long cvSubdiv2DNextEdge(long l)
        {
            return CV_SUBDIV2D_NEXT_EDGE(l);
        }

        public native int flags();

        public native CvQuadEdge2D flags(int i);

        public native long next(int i);

        public native CvQuadEdge2D next(int i, long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvQuadEdge2D position(int i)
        {
            return (CvQuadEdge2D)super.position(i);
        }

        public native CvQuadEdge2D pt(int i, CvSubdiv2DPoint cvsubdiv2dpoint);

        public native CvSubdiv2DPoint pt(int i);

        static 
        {
            Loader.load();
        }

        public CvQuadEdge2D()
        {
            allocate();
        }

        public CvQuadEdge2D(int i)
        {
            allocateArray(i);
        }

        public CvQuadEdge2D(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSubdiv2D extends opencv_core.CvGraph
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native opencv_core.CvPoint2D32f bottomright();

        public native CvSubdiv2D bottomright(opencv_core.CvPoint2D32f cvpoint2d32f);

        public native int is_geometry_valid();

        public native CvSubdiv2D is_geometry_valid(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile opencv_core.CvGraph position(int i)
        {
            return position(i);
        }

        public volatile opencv_core.CvSeq position(int i)
        {
            return position(i);
        }

        public volatile opencv_core.CvSet position(int i)
        {
            return position(i);
        }

        public CvSubdiv2D position(int i)
        {
            return (CvSubdiv2D)super.position(i);
        }

        public native int quad_edges();

        public native CvSubdiv2D quad_edges(int i);

        public native long recent_edge();

        public native CvSubdiv2D recent_edge(long l);

        public native opencv_core.CvPoint2D32f topleft();

        public native CvSubdiv2D topleft(opencv_core.CvPoint2D32f cvpoint2d32f);

        static 
        {
            Loader.load();
        }

        public CvSubdiv2D()
        {
            allocate();
        }

        public CvSubdiv2D(int i)
        {
            allocateArray(i);
        }

        public CvSubdiv2D(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSubdiv2DEdge extends SizeTPointer
    {

        static 
        {
            Loader.load();
        }

        public CvSubdiv2DEdge()
        {
            super(1);
        }

        public CvSubdiv2DEdge(int i)
        {
            super(i);
        }

        public CvSubdiv2DEdge(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSubdiv2DPoint extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native long first();

        public native CvSubdiv2DPoint first(long l);

        public native int flags();

        public native CvSubdiv2DPoint flags(int i);

        public native int id();

        public native CvSubdiv2DPoint id(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSubdiv2DPoint position(int i)
        {
            return (CvSubdiv2DPoint)super.position(i);
        }

        public native opencv_core.CvPoint2D32f pt();

        public native CvSubdiv2DPoint pt(opencv_core.CvPoint2D32f cvpoint2d32f);

        static 
        {
            Loader.load();
        }

        public CvSubdiv2DPoint()
        {
            allocate();
        }

        public CvSubdiv2DPoint(int i)
        {
            allocateArray(i);
        }

        public CvSubdiv2DPoint(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class FilterEngine extends Pointer
    {

        private native void allocate();

        private native void allocate(BaseFilter basefilter, BaseRowFilter baserowfilter, BaseColumnFilter basecolumnfilter, int i, int j, int k, int l, 
                int i1, opencv_core.CvScalar cvscalar);

        public native opencv_core.CvPoint anchor();

        public native FilterEngine anchor(opencv_core.CvPoint cvpoint);

        public native void apply(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvRect cvrect, opencv_core.CvPoint cvpoint, boolean flag);

        public native int borderElemSize();

        public native FilterEngine borderElemSize(int i);

        public native IntPointer borderTab();

        public native FilterEngine borderTab(IntPointer intpointer);

        public native int bufStep();

        public native FilterEngine bufStep(int i);

        public native int bufType();

        public native FilterEngine bufType(int i);

        public native int columnBorderType();

        public native FilterEngine columnBorderType(int i);

        public native BaseColumnFilter columnFilter();

        public native FilterEngine columnFilter(BaseColumnFilter basecolumnfilter);

        public native BytePointer constBorderRow();

        public native FilterEngine constBorderRow(BytePointer bytepointer);

        public native BytePointer constBorderValue();

        public native FilterEngine constBorderValue(BytePointer bytepointer);

        public native int dstType();

        public native FilterEngine dstType(int i);

        public native int dstY();

        public native FilterEngine dstY(int i);

        public native int dx1();

        public native FilterEngine dx1(int i);

        public native int dx2();

        public native FilterEngine dx2(int i);

        public native int endY();

        public native FilterEngine endY(int i);

        public native BaseFilter filter2D();

        public native FilterEngine filter2D(BaseFilter basefilter);

        public native void init(BaseFilter basefilter, BaseRowFilter baserowfilter, BaseColumnFilter basecolumnfilter, int i, int j, int k, int l, 
                int i1, opencv_core.CvScalar cvscalar);

        public native boolean isSeparable();

        public native opencv_core.CvSize ksize();

        public native FilterEngine ksize(opencv_core.CvSize cvsize);

        public native int maxWidth();

        public native FilterEngine maxWidth(int i);

        public native int proceed(BytePointer bytepointer, int i, int j, BytePointer bytepointer1, int k);

        public native int remainingInputRows();

        public native int remainingOutputRows();

        public native BytePointer ringBuf();

        public native FilterEngine ringBuf(BytePointer bytepointer);

        public native opencv_core.CvRect roi();

        public native FilterEngine roi(opencv_core.CvRect cvrect);

        public native int rowBorderType();

        public native FilterEngine rowBorderType(int i);

        public native int rowCount();

        public native FilterEngine rowCount(int i);

        public native BaseRowFilter rowFilter();

        public native FilterEngine rowFilter(BaseRowFilter baserowfilter);

        public native PointerPointer rows();

        public native FilterEngine rows(PointerPointer pointerpointer);

        public native BytePointer srcRow();

        public native FilterEngine srcRow(BytePointer bytepointer);

        public native int srcType();

        public native FilterEngine srcType(int i);

        public native int start(opencv_core.CvArr cvarr, opencv_core.CvRect cvrect, boolean flag, int i);

        public native int start(opencv_core.CvSize cvsize, opencv_core.CvRect cvrect, int i);

        public native int startY();

        public native FilterEngine startY(int i);

        public native int startY0();

        public native FilterEngine startY0(int i);

        public native opencv_core.CvSize wholeSize();

        public native FilterEngine wholeSize(opencv_core.CvSize cvsize);

        static 
        {
            Loader.load();
        }

        public FilterEngine()
        {
            allocate();
        }

        public FilterEngine(Pointer pointer)
        {
            super(pointer);
        }

        public FilterEngine(BaseFilter basefilter, BaseRowFilter baserowfilter, BaseColumnFilter basecolumnfilter, int i, int j, int k, int l, 
                int i1, opencv_core.CvScalar cvscalar)
        {
            allocate(basefilter, baserowfilter, basecolumnfilter, i, j, k, l, i1, cvscalar);
        }
    }

    public static class GeneralizedHough extends opencv_core.Algorithm
    {

        public static native GeneralizedHough create(int i);

        public native void detect(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1);

        public native void detect(opencv_core.CvArr cvarr, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, int i);

        public native void release();

        public native void setTemplate(opencv_core.CvArr cvarr, int i, opencv_core.CvPoint cvpoint);

        public native void setTemplate(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvPoint cvpoint);

        static 
        {
            Loader.load();
        }

        public GeneralizedHough()
        {
        }

        public GeneralizedHough(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class IplConvKernel extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static IplConvKernel create(int i, int j, int k, int l, int i1, int ai[])
        {
            ai = opencv_imgproc.cvCreateStructuringElementEx(i, j, k, l, i1, ai);
            if (ai != null)
            {
                ai.deallocator(new ReleaseDeallocator(ai));
            }
            return ai;
        }

        public native int anchorX();

        public native IplConvKernel anchorX(int i);

        public native int anchorY();

        public native IplConvKernel anchorY(int i);

        public native int nCols();

        public native IplConvKernel nCols(int i);

        public native int nRows();

        public native IplConvKernel nRows(int i);

        public native int nShiftR();

        public native IplConvKernel nShiftR(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public IplConvKernel position(int i)
        {
            return (IplConvKernel)super.position(i);
        }

        public void release()
        {
            deallocate();
        }

        public native IntPointer values();

        public native IplConvKernel values(IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        public IplConvKernel()
        {
            allocate();
            zero();
        }

        public IplConvKernel(int i)
        {
            allocateArray(i);
            zero();
        }

        public IplConvKernel(Pointer pointer)
        {
            super(pointer);
        }
    }

    static class IplConvKernel.ReleaseDeallocator extends IplConvKernel
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_imgproc.cvReleaseStructuringElement(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        IplConvKernel.ReleaseDeallocator(IplConvKernel iplconvkernel)
        {
            super(iplconvkernel);
        }
    }

    public static class IplConvKernelFP extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int anchorX();

        public native IplConvKernelFP anchorX(int i);

        public native int anchorY();

        public native IplConvKernelFP anchorY(int i);

        public native int nCols();

        public native IplConvKernelFP nCols(int i);

        public native int nRows();

        public native IplConvKernelFP nRows(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public IplConvKernelFP position(int i)
        {
            return (IplConvKernelFP)super.position(i);
        }

        public native FloatPointer values();

        public native IplConvKernelFP values(FloatPointer floatpointer);

        static 
        {
            Loader.load();
        }

        public IplConvKernelFP()
        {
            allocate();
            zero();
        }

        public IplConvKernelFP(int i)
        {
            allocateArray(i);
            zero();
        }

        public IplConvKernelFP(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int BORDER_CONSTANT = 0;
    public static final int BORDER_DEFAULT = 4;
    public static final int BORDER_ISOLATED = 16;
    public static final int BORDER_REFLECT = 2;
    public static final int BORDER_REFLECT101 = 4;
    public static final int BORDER_REFLECT_101 = 4;
    public static final int BORDER_REPLICATE = 1;
    public static final int BORDER_TRANSPARENT = 5;
    public static final int BORDER_WRAP = 3;
    public static final int CV_ADAPTIVE_THRESH_GAUSSIAN_C = 1;
    public static final int CV_ADAPTIVE_THRESH_MEAN_C = 0;
    public static final int CV_BGR2BGR555 = 22;
    public static final int CV_BGR2BGR565 = 12;
    public static final int CV_BGR2BGRA = 0;
    public static final int CV_BGR2GRAY = 6;
    public static final int CV_BGR2HLS = 52;
    public static final int CV_BGR2HLS_FULL = 68;
    public static final int CV_BGR2HSV = 40;
    public static final int CV_BGR2HSV_FULL = 66;
    public static final int CV_BGR2Lab = 44;
    public static final int CV_BGR2Luv = 50;
    public static final int CV_BGR2RGB = 4;
    public static final int CV_BGR2RGBA = 2;
    public static final int CV_BGR2XYZ = 32;
    public static final int CV_BGR2YCrCb = 36;
    public static final int CV_BGR2YUV = 82;
    public static final int CV_BGR2YUV_I420 = 128;
    public static final int CV_BGR2YUV_IYUV = 128;
    public static final int CV_BGR2YUV_YV12 = 132;
    public static final int CV_BGR5552BGR = 24;
    public static final int CV_BGR5552BGRA = 28;
    public static final int CV_BGR5552GRAY = 31;
    public static final int CV_BGR5552RGB = 25;
    public static final int CV_BGR5552RGBA = 29;
    public static final int CV_BGR5652BGR = 14;
    public static final int CV_BGR5652BGRA = 18;
    public static final int CV_BGR5652GRAY = 21;
    public static final int CV_BGR5652RGB = 15;
    public static final int CV_BGR5652RGBA = 19;
    public static final int CV_BGRA2BGR = 1;
    public static final int CV_BGRA2BGR555 = 26;
    public static final int CV_BGRA2BGR565 = 16;
    public static final int CV_BGRA2GRAY = 10;
    public static final int CV_BGRA2RGB = 3;
    public static final int CV_BGRA2RGBA = 5;
    public static final int CV_BGRA2YUV_I420 = 130;
    public static final int CV_BGRA2YUV_IYUV = 130;
    public static final int CV_BGRA2YUV_YV12 = 134;
    public static final int CV_BILATERAL = 4;
    public static final int CV_BLUR = 1;
    public static final int CV_BLUR_NO_SCALE = 0;
    public static final int CV_BayerBG2BGR = 46;
    public static final int CV_BayerBG2BGR_VNG = 62;
    public static final int CV_BayerBG2GRAY = 86;
    public static final int CV_BayerBG2RGB = 48;
    public static final int CV_BayerBG2RGB_VNG = 64;
    public static final int CV_BayerGB2BGR = 47;
    public static final int CV_BayerGB2BGR_VNG = 63;
    public static final int CV_BayerGB2GRAY = 87;
    public static final int CV_BayerGB2RGB = 49;
    public static final int CV_BayerGB2RGB_VNG = 65;
    public static final int CV_BayerGR2BGR = 49;
    public static final int CV_BayerGR2BGR_VNG = 65;
    public static final int CV_BayerGR2GRAY = 89;
    public static final int CV_BayerGR2RGB = 47;
    public static final int CV_BayerGR2RGB_VNG = 63;
    public static final int CV_BayerRG2BGR = 48;
    public static final int CV_BayerRG2BGR_VNG = 64;
    public static final int CV_BayerRG2GRAY = 88;
    public static final int CV_BayerRG2RGB = 46;
    public static final int CV_BayerRG2RGB_VNG = 62;
    public static final int CV_CANNY_L2_GRADIENT = 0x80000000;
    public static final int CV_CHAIN_APPROX_NONE = 1;
    public static final int CV_CHAIN_APPROX_SIMPLE = 2;
    public static final int CV_CHAIN_APPROX_TC89_KCOS = 4;
    public static final int CV_CHAIN_APPROX_TC89_L1 = 3;
    public static final int CV_CHAIN_CODE = 0;
    public static final int CV_CLOCKWISE = 1;
    public static final int CV_COLORCVT_MAX = 135;
    public static final int CV_COMP_BHATTACHARYYA = 3;
    public static final int CV_COMP_CHISQR = 1;
    public static final int CV_COMP_CORREL = 0;
    public static final int CV_COMP_HELLINGER = 3;
    public static final int CV_COMP_INTERSECT = 2;
    public static final int CV_CONTOURS_MATCH_I1 = 1;
    public static final int CV_CONTOURS_MATCH_I2 = 2;
    public static final int CV_CONTOURS_MATCH_I3 = 3;
    public static final int CV_COUNTER_CLOCKWISE = 2;
    public static final int CV_DIST_C = 3;
    public static final int CV_DIST_FAIR = 5;
    public static final int CV_DIST_HUBER = 7;
    public static final int CV_DIST_L1 = 1;
    public static final int CV_DIST_L12 = 4;
    public static final int CV_DIST_L2 = 2;
    public static final int CV_DIST_LABEL_CCOMP = 0;
    public static final int CV_DIST_LABEL_PIXEL = 1;
    public static final int CV_DIST_MASK_3 = 3;
    public static final int CV_DIST_MASK_5 = 5;
    public static final int CV_DIST_MASK_PRECISE = 0;
    public static final int CV_DIST_USER = -1;
    public static final int CV_DIST_WELSCH = 6;
    public static final int CV_FLOODFILL_FIXED_RANGE = 0x10000;
    public static final int CV_FLOODFILL_MASK_ONLY = 0x20000;
    public static final int CV_GAUSSIAN = 2;
    public static final int CV_GAUSSIAN_5x5 = 7;
    public static final int CV_GRAY2BGR = 8;
    public static final int CV_GRAY2BGR555 = 30;
    public static final int CV_GRAY2BGR565 = 20;
    public static final int CV_GRAY2BGRA = 9;
    public static final int CV_GRAY2RGB = 8;
    public static final int CV_GRAY2RGBA = 9;
    public static final int CV_HIST_ARRAY = 0;
    public static final int CV_HIST_MAGIC_VAL = 0x42450000;
    public static final int CV_HIST_RANGES_FLAG = 2048;
    public static final int CV_HIST_SPARSE = 1;
    public static final int CV_HIST_TREE = 1;
    public static final int CV_HIST_UNIFORM = 1;
    public static final int CV_HIST_UNIFORM_FLAG = 1024;
    public static final int CV_HLS2BGR = 60;
    public static final int CV_HLS2BGR_FULL = 72;
    public static final int CV_HLS2RGB = 61;
    public static final int CV_HLS2RGB_FULL = 73;
    public static final int CV_HOUGH_GRADIENT = 3;
    public static final int CV_HOUGH_MULTI_SCALE = 2;
    public static final int CV_HOUGH_PROBABILISTIC = 1;
    public static final int CV_HOUGH_STANDARD = 0;
    public static final int CV_HSV2BGR = 54;
    public static final int CV_HSV2BGR_FULL = 70;
    public static final int CV_HSV2RGB = 55;
    public static final int CV_HSV2RGB_FULL = 71;
    public static final int CV_INTER_AREA = 3;
    public static final int CV_INTER_CUBIC = 2;
    public static final int CV_INTER_LANCZOS4 = 4;
    public static final int CV_INTER_LINEAR = 1;
    public static final int CV_INTER_NN = 0;
    public static final int CV_LBGR2Lab = 74;
    public static final int CV_LBGR2Luv = 76;
    public static final int CV_LINK_RUNS = 5;
    public static final int CV_LRGB2Lab = 75;
    public static final int CV_LRGB2Luv = 77;
    public static final int CV_Lab2BGR = 56;
    public static final int CV_Lab2LBGR = 78;
    public static final int CV_Lab2LRGB = 79;
    public static final int CV_Lab2RGB = 57;
    public static final int CV_Luv2BGR = 58;
    public static final int CV_Luv2LBGR = 80;
    public static final int CV_Luv2LRGB = 81;
    public static final int CV_Luv2RGB = 59;
    public static final int CV_MAX_SOBEL_KSIZE = 7;
    public static final int CV_MEDIAN = 3;
    public static final int CV_MOP_BLACKHAT = 6;
    public static final int CV_MOP_CLOSE = 3;
    public static final int CV_MOP_DILATE = 1;
    public static final int CV_MOP_ERODE = 0;
    public static final int CV_MOP_GRADIENT = 4;
    public static final int CV_MOP_OPEN = 2;
    public static final int CV_MOP_TOPHAT = 5;
    public static final int CV_NEXT_AROUND_DST = 34;
    public static final int CV_NEXT_AROUND_LEFT = 19;
    public static final int CV_NEXT_AROUND_ORG = 0;
    public static final int CV_NEXT_AROUND_RIGHT = 49;
    public static final int CV_POLY_APPROX_DP = 0;
    public static final int CV_PREV_AROUND_DST = 51;
    public static final int CV_PREV_AROUND_LEFT = 32;
    public static final int CV_PREV_AROUND_ORG = 17;
    public static final int CV_PREV_AROUND_RIGHT = 2;
    public static final int CV_PTLOC_ERROR = -2;
    public static final int CV_PTLOC_INSIDE = 0;
    public static final int CV_PTLOC_ON_EDGE = 2;
    public static final int CV_PTLOC_OUTSIDE_RECT = -1;
    public static final int CV_PTLOC_VERTEX = 1;
    public static final int CV_RETR_CCOMP = 2;
    public static final int CV_RETR_EXTERNAL = 0;
    public static final int CV_RETR_FLOODFILL = 4;
    public static final int CV_RETR_LIST = 1;
    public static final int CV_RETR_TREE = 3;
    public static final int CV_RGB2BGR = 4;
    public static final int CV_RGB2BGR555 = 23;
    public static final int CV_RGB2BGR565 = 13;
    public static final int CV_RGB2BGRA = 2;
    public static final int CV_RGB2GRAY = 7;
    public static final int CV_RGB2HLS = 53;
    public static final int CV_RGB2HLS_FULL = 69;
    public static final int CV_RGB2HSV = 41;
    public static final int CV_RGB2HSV_FULL = 67;
    public static final int CV_RGB2Lab = 45;
    public static final int CV_RGB2Luv = 51;
    public static final int CV_RGB2RGBA = 0;
    public static final int CV_RGB2XYZ = 33;
    public static final int CV_RGB2YCrCb = 37;
    public static final int CV_RGB2YUV = 83;
    public static final int CV_RGB2YUV_I420 = 127;
    public static final int CV_RGB2YUV_IYUV = 127;
    public static final int CV_RGB2YUV_YV12 = 131;
    public static final int CV_RGBA2BGR = 3;
    public static final int CV_RGBA2BGR555 = 27;
    public static final int CV_RGBA2BGR565 = 17;
    public static final int CV_RGBA2BGRA = 5;
    public static final int CV_RGBA2GRAY = 11;
    public static final int CV_RGBA2RGB = 1;
    public static final int CV_RGBA2YUV_I420 = 129;
    public static final int CV_RGBA2YUV_IYUV = 129;
    public static final int CV_RGBA2YUV_YV12 = 133;
    public static final int CV_RGBA2mRGBA = 125;
    public static final int CV_SCHARR = -1;
    public static final int CV_SHAPE_CROSS = 1;
    public static final int CV_SHAPE_CUSTOM = 100;
    public static final int CV_SHAPE_ELLIPSE = 2;
    public static final int CV_SHAPE_RECT = 0;
    public static final int CV_SUBDIV2D_VIRTUAL_POINT_FLAG = 0x40000000;
    public static final int CV_THRESH_BINARY = 0;
    public static final int CV_THRESH_BINARY_INV = 1;
    public static final int CV_THRESH_MASK = 7;
    public static final int CV_THRESH_OTSU = 8;
    public static final int CV_THRESH_TOZERO = 3;
    public static final int CV_THRESH_TOZERO_INV = 4;
    public static final int CV_THRESH_TRUNC = 2;
    public static final int CV_TM_CCOEFF = 4;
    public static final int CV_TM_CCOEFF_NORMED = 5;
    public static final int CV_TM_CCORR = 2;
    public static final int CV_TM_CCORR_NORMED = 3;
    public static final int CV_TM_SQDIFF = 0;
    public static final int CV_TM_SQDIFF_NORMED = 1;
    public static final int CV_WARP_FILL_OUTLIERS = 8;
    public static final int CV_WARP_INVERSE_MAP = 16;
    public static final int CV_XYZ2BGR = 34;
    public static final int CV_XYZ2RGB = 35;
    public static final int CV_YCrCb2BGR = 38;
    public static final int CV_YCrCb2RGB = 39;
    public static final int CV_YUV2BGR = 84;
    public static final int CV_YUV2BGRA_I420 = 105;
    public static final int CV_YUV2BGRA_IYUV = 105;
    public static final int CV_YUV2BGRA_NV12 = 95;
    public static final int CV_YUV2BGRA_NV21 = 97;
    public static final int CV_YUV2BGRA_UYNV = 112;
    public static final int CV_YUV2BGRA_UYVY = 112;
    public static final int CV_YUV2BGRA_Y422 = 112;
    public static final int CV_YUV2BGRA_YUNV = 120;
    public static final int CV_YUV2BGRA_YUY2 = 120;
    public static final int CV_YUV2BGRA_YUYV = 120;
    public static final int CV_YUV2BGRA_YV12 = 103;
    public static final int CV_YUV2BGRA_YVYU = 122;
    public static final int CV_YUV2BGR_I420 = 101;
    public static final int CV_YUV2BGR_IYUV = 101;
    public static final int CV_YUV2BGR_NV12 = 91;
    public static final int CV_YUV2BGR_NV21 = 93;
    public static final int CV_YUV2BGR_UYNV = 108;
    public static final int CV_YUV2BGR_UYVY = 108;
    public static final int CV_YUV2BGR_Y422 = 108;
    public static final int CV_YUV2BGR_YUNV = 116;
    public static final int CV_YUV2BGR_YUY2 = 116;
    public static final int CV_YUV2BGR_YUYV = 116;
    public static final int CV_YUV2BGR_YV12 = 99;
    public static final int CV_YUV2BGR_YVYU = 118;
    public static final int CV_YUV2GRAY_420 = 106;
    public static final int CV_YUV2GRAY_I420 = 106;
    public static final int CV_YUV2GRAY_IYUV = 106;
    public static final int CV_YUV2GRAY_NV12 = 106;
    public static final int CV_YUV2GRAY_NV21 = 106;
    public static final int CV_YUV2GRAY_UYNV = 123;
    public static final int CV_YUV2GRAY_UYVY = 123;
    public static final int CV_YUV2GRAY_Y422 = 123;
    public static final int CV_YUV2GRAY_YUNV = 124;
    public static final int CV_YUV2GRAY_YUY2 = 124;
    public static final int CV_YUV2GRAY_YUYV = 124;
    public static final int CV_YUV2GRAY_YV12 = 106;
    public static final int CV_YUV2GRAY_YVYU = 124;
    public static final int CV_YUV2RGB = 85;
    public static final int CV_YUV2RGBA_I420 = 104;
    public static final int CV_YUV2RGBA_IYUV = 104;
    public static final int CV_YUV2RGBA_NV12 = 94;
    public static final int CV_YUV2RGBA_NV21 = 96;
    public static final int CV_YUV2RGBA_UYNV = 111;
    public static final int CV_YUV2RGBA_UYVY = 111;
    public static final int CV_YUV2RGBA_Y422 = 111;
    public static final int CV_YUV2RGBA_YUNV = 119;
    public static final int CV_YUV2RGBA_YUY2 = 119;
    public static final int CV_YUV2RGBA_YUYV = 119;
    public static final int CV_YUV2RGBA_YV12 = 102;
    public static final int CV_YUV2RGBA_YVYU = 121;
    public static final int CV_YUV2RGB_I420 = 100;
    public static final int CV_YUV2RGB_IYUV = 100;
    public static final int CV_YUV2RGB_NV12 = 90;
    public static final int CV_YUV2RGB_NV21 = 92;
    public static final int CV_YUV2RGB_UYNV = 107;
    public static final int CV_YUV2RGB_UYVY = 107;
    public static final int CV_YUV2RGB_Y422 = 107;
    public static final int CV_YUV2RGB_YUNV = 115;
    public static final int CV_YUV2RGB_YUY2 = 115;
    public static final int CV_YUV2RGB_YUYV = 115;
    public static final int CV_YUV2RGB_YV12 = 98;
    public static final int CV_YUV2RGB_YVYU = 117;
    public static final int CV_YUV420p2BGR = 99;
    public static final int CV_YUV420p2BGRA = 103;
    public static final int CV_YUV420p2GRAY = 106;
    public static final int CV_YUV420p2RGB = 98;
    public static final int CV_YUV420p2RGBA = 102;
    public static final int CV_YUV420sp2BGR = 93;
    public static final int CV_YUV420sp2BGRA = 97;
    public static final int CV_YUV420sp2GRAY = 106;
    public static final int CV_YUV420sp2RGB = 92;
    public static final int CV_YUV420sp2RGBA = 96;
    public static final int CV_mRGBA2RGBA = 126;
    public static final int GC_BGD = 0;
    public static final int GC_EVAL = 2;
    public static final int GC_FGD = 1;
    public static final int GC_INIT_WITH_MASK = 1;
    public static final int GC_INIT_WITH_RECT = 0;
    public static final int GC_PR_BGD = 2;
    public static final int GC_PR_FGD = 3;
    public static final int GHT_POSITION = 0;
    public static final int GHT_ROTATION = 2;
    public static final int GHT_SCALE = 1;
    public static final int KERNEL_ASYMMETRICAL = 2;
    public static final int KERNEL_GENERAL = 0;
    public static final int KERNEL_INTEGER = 8;
    public static final int KERNEL_SMOOTH = 4;
    public static final int KERNEL_SYMMETRICAL = 1;
    public static final int MORPH_BLACKHAT = 6;
    public static final int MORPH_CLOSE = 3;
    public static final int MORPH_DILATE = 1;
    public static final int MORPH_ERODE = 0;
    public static final int MORPH_GRADIENT = 4;
    public static final int MORPH_OPEN = 2;
    public static final int MORPH_TOPHAT = 5;
    public static final int PROJ_SPHERICAL_EQRECT = 1;
    public static final int PROJ_SPHERICAL_ORTHO = 0;

    public opencv_imgproc()
    {
    }

    public static boolean CV_HIST_HAS_RANGES(CvHistogram cvhistogram)
    {
        return (cvhistogram.type() & 0x800) != 0;
    }

    public static native void CV_INIT_3X3_DELTAS(int ai[], int i, int j);

    public static boolean CV_IS_HIST(opencv_core.CvArr cvarr)
    {
        CvHistogram cvhistogram = new CvHistogram(cvarr);
        return cvarr != null && (cvhistogram.type() & 0xffff0000) == 0x42450000 && cvhistogram.bins() != null;
    }

    public static boolean CV_IS_SPARSE_HIST(CvHistogram cvhistogram)
    {
        return opencv_core.CV_IS_SPARSE_MAT(cvhistogram.bins());
    }

    public static boolean CV_IS_UNIFORM_HIST(CvHistogram cvhistogram)
    {
        return (cvhistogram.type() & 0x400) != 0;
    }

    public static native CvSubdiv2DEdge CV_SUBDIV2D_NEXT_EDGE(CvSubdiv2DEdge cvsubdiv2dedge);

    public static native void Canny(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, double d1, int i, boolean flag);

    public static native float EMD(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, opencv_core.CvArr cvarr2, float af[], opencv_core.CvArr cvarr3);

    public static native void GaussianBlur(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvSize cvsize, double d, double d1, int i);

    public static native void Laplacian(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, double d, double d1, 
            int k);

    public static native double PSNR(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

    public static native void Scharr(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, int k, double d, double d1, int l);

    public static native void Sobel(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, int k, int l, double d, 
            double d1, int i1);

    public static native void bilateralFilter(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, double d, double d1, int j);

    public static native void blur(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvSize cvsize, opencv_core.CvPoint cvpoint, int i);

    public static native int borderInterpolate(int i, int j, int k);

    public static native void boxFilter(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, opencv_core.CvSize cvsize, opencv_core.CvPoint cvpoint, boolean flag, int j);

    public static native FilterEngine createBoxFilter(int i, int j, opencv_core.CvSize cvsize, opencv_core.CvPoint cvpoint, boolean flag, int k);

    public static native CLAHE createCLAHE(double d, opencv_core.CvSize cvsize);

    public static native FilterEngine createDerivFilter(int i, int j, int k, int l, int i1, int j1);

    public static native FilterEngine createGaussianFilter(int i, opencv_core.CvSize cvsize, double d, double d1, int j);

    public static native void createHanningWindow(opencv_core.CvMat cvmat, opencv_core.CvSize cvsize, int i);

    public static native FilterEngine createLinearFilter(int i, int j, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint, double d, int k, int l, 
            opencv_core.CvScalar cvscalar);

    public static native FilterEngine createMorphologyFilter(int i, int j, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint, int k, int l, opencv_core.CvScalar cvscalar);

    public static native FilterEngine createSeparableLinearFilter(int i, int j, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvPoint cvpoint, double d, int k, 
            int l, opencv_core.CvScalar cvscalar);

    public static native opencv_core.CvMat cv2DRotationMatrix(opencv_core.CvPoint2D32f cvpoint2d32f, double d, double d1, opencv_core.CvMat cvmat);

    public static native void cvAcc(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2);

    public static native void cvAdaptiveThreshold(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, int i, int j, int k, double d1);

    public static native opencv_core.CvSeq cvApproxChains(opencv_core.CvSeq cvseq, opencv_core.CvMemStorage cvmemstorage, int i, double d, int j, int k);

    public static native opencv_core.CvSeq cvApproxPoly(Pointer pointer, int i, opencv_core.CvMemStorage cvmemstorage, int j, double d, int k);

    public static native double cvArcLength(Pointer pointer, opencv_core.CvSlice cvslice, int i);

    public static native opencv_core.CvRect cvBoundingRect(opencv_core.CvArr cvarr, int i);

    public static native void cvBoxPoints(opencv_core.CvBox2D cvbox2d, opencv_core.CvPoint2D32f cvpoint2d32f);

    public static native void cvBoxPoints(opencv_core.CvBox2D cvbox2d, float af[]);

    public static native void cvCalcArrBackProject(opencv_core.CvArrArray cvarrarray, opencv_core.CvArr cvarr, CvHistogram cvhistogram);

    public static void cvCalcArrBackProject(opencv_core.CvArr acvarr[], opencv_core.CvArr cvarr, CvHistogram cvhistogram)
    {
        cvCalcArrBackProject(new opencv_core.CvArrArray(acvarr), cvarr, cvhistogram);
    }

    public static native void cvCalcArrBackProjectPatch(opencv_core.CvArrArray cvarrarray, opencv_core.CvArr cvarr, opencv_core.CvSize cvsize, CvHistogram cvhistogram, int i, double d);

    public static void cvCalcArrBackProjectPatch(opencv_core.CvArr acvarr[], opencv_core.CvArr cvarr, opencv_core.CvSize cvsize, CvHistogram cvhistogram, int i, double d)
    {
        cvCalcArrBackProjectPatch(new opencv_core.CvArrArray(acvarr), cvarr, cvsize, cvhistogram, i, d);
    }

    public static native void cvCalcArrHist(opencv_core.CvArrArray cvarrarray, CvHistogram cvhistogram, int i, opencv_core.CvArr cvarr);

    public static void cvCalcArrHist(opencv_core.CvArr acvarr[], CvHistogram cvhistogram, int i, opencv_core.CvArr cvarr)
    {
        cvCalcArrHist(new opencv_core.CvArrArray(acvarr), cvhistogram, i, cvarr);
    }

    public static void cvCalcBackProject(opencv_core.IplImageArray iplimagearray, opencv_core.CvArr cvarr, CvHistogram cvhistogram)
    {
        cvCalcArrBackProject(iplimagearray, cvarr, cvhistogram);
    }

    public static void cvCalcBackProject(opencv_core.IplImage aiplimage[], opencv_core.CvArr cvarr, CvHistogram cvhistogram)
    {
        cvCalcBackProject(new opencv_core.IplImageArray(aiplimage), cvarr, cvhistogram);
    }

    public static void cvCalcBackProjectPatch(opencv_core.IplImageArray iplimagearray, opencv_core.CvArr cvarr, opencv_core.CvSize cvsize, CvHistogram cvhistogram, int i, double d)
    {
        cvCalcArrBackProjectPatch(iplimagearray, cvarr, cvsize, cvhistogram, i, d);
    }

    public static void cvCalcBackProjectPatch(opencv_core.IplImage aiplimage[], opencv_core.CvArr cvarr, opencv_core.CvSize cvsize, CvHistogram cvhistogram, int i, double d)
    {
        cvCalcBackProjectPatch(new opencv_core.IplImageArray(aiplimage), cvarr, cvsize, cvhistogram, i, d);
    }

    public static native void cvCalcBayesianProb(CvHistogram cvhistogram, int i, CvHistogram cvhistogram1);

    public static native float cvCalcEMD2(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, CvDistanceFunction cvdistancefunction, opencv_core.CvArr cvarr2, opencv_core.CvArr cvarr3, float af[], Pointer pointer);

    public static void cvCalcHist(opencv_core.IplImageArray iplimagearray, CvHistogram cvhistogram, int i, opencv_core.CvArr cvarr)
    {
        cvCalcArrHist(iplimagearray, cvhistogram, i, cvarr);
    }

    public static void cvCalcHist(opencv_core.IplImage aiplimage[], CvHistogram cvhistogram, int i, opencv_core.CvArr cvarr)
    {
        cvCalcHist(new opencv_core.IplImageArray(aiplimage), cvhistogram, i, cvarr);
    }

    public static native void cvCalcProbDensity(CvHistogram cvhistogram, CvHistogram cvhistogram1, CvHistogram cvhistogram2, double d);

    public static native void cvCanny(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, double d1, int i);

    public static native int cvCheckContourConvexity(opencv_core.CvArr cvarr);

    public static native void cvClearHist(CvHistogram cvhistogram);

    public static native double cvCompareHist(CvHistogram cvhistogram, CvHistogram cvhistogram1, int i);

    public static native double cvContourArea(opencv_core.CvArr cvarr, opencv_core.CvSlice cvslice, int i);

    public static double cvContourPerimeter(Pointer pointer)
    {
        return cvArcLength(pointer, opencv_core.CV_WHOLE_SEQ, 1);
    }

    public static native void cvConvertMaps(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvArr cvarr3);

    public static native opencv_core.CvSeq cvConvexHull2(opencv_core.CvArr cvarr, Pointer pointer, int i, int j);

    public static native opencv_core.CvSeq cvConvexityDefects(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMemStorage cvmemstorage);

    public static native void cvCopyHist(CvHistogram cvhistogram, CvHistogram cvhistogram1);

    public static native void cvCopyMakeBorder(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvPoint cvpoint, int i, opencv_core.CvScalar cvscalar);

    public static native void cvCornerEigenValsAndVecs(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j);

    public static native void cvCornerHarris(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, double d);

    public static native void cvCornerMinEigenVal(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j);

    public static native CvHistogram cvCreateHist(int i, int ai[], int j, PointerPointer pointerpointer, int k);

    public static CvHistogram cvCreateHist(int i, int ai[], int j, float af[][], int k)
    {
        if (af == null)
        {
            af = null;
        } else
        {
            af = new PointerPointer(af);
        }
        return cvCreateHist(i, ai, j, ((PointerPointer) (af)), k);
    }

    public static native opencv_core.CvMatArray cvCreatePyramid(opencv_core.CvArr cvarr, int i, double d, opencv_core.CvSize cvsize, opencv_core.CvArr cvarr1, int j, int k);

    public static native IplConvKernel cvCreateStructuringElementEx(int i, int j, int k, int l, int i1, int ai[]);

    public static native void cvCvtColor(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native void cvDilate(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, IplConvKernel iplconvkernel, int i);

    public static native void cvDistTransform(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, FloatPointer floatpointer, opencv_core.CvArr cvarr2, int k);

    public static native opencv_core.CvSeq cvEndFindContours(CvContourScanner cvcontourscanner);

    public static native void cvEqualizeHist(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

    public static native void cvErode(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, IplConvKernel iplconvkernel, int i);

    public static native void cvFilter2D(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint);

    public static int cvFindContours(opencv_core.CvArr cvarr, opencv_core.CvMemStorage cvmemstorage, opencv_core.CvSeq cvseq, int i, int j, int k)
    {
        return cvFindContours(cvarr, cvmemstorage, cvseq, i, j, k, opencv_core.CvPoint.ZERO);
    }

    public static native int cvFindContours(opencv_core.CvArr cvarr, opencv_core.CvMemStorage cvmemstorage, opencv_core.CvSeq cvseq, int i, int j, int k, opencv_core.CvPoint cvpoint);

    public static native void cvFindCornerSubPix(opencv_core.CvArr cvarr, opencv_core.CvPoint2D32f cvpoint2d32f, int i, opencv_core.CvSize cvsize, opencv_core.CvSize cvsize1, opencv_core.CvTermCriteria cvtermcriteria);

    public static native opencv_core.CvSeq cvFindNextContour(CvContourScanner cvcontourscanner);

    public static native opencv_core.CvBox2D cvFitEllipse2(opencv_core.CvArr cvarr);

    public static native void cvFitLine(opencv_core.CvArr cvarr, int i, double d, double d1, double d2, 
            FloatPointer floatpointer);

    public static native void cvFitLine(opencv_core.CvArr cvarr, int i, double d, double d1, double d2, 
            float af[]);

    public static native void cvFloodFill(opencv_core.CvArr cvarr, opencv_core.CvPoint cvpoint, opencv_core.CvScalar cvscalar, opencv_core.CvScalar cvscalar1, opencv_core.CvScalar cvscalar2, CvConnectedComp cvconnectedcomp, int i, opencv_core.CvArr cvarr1);

    public static native opencv_core.CvMat cvGetAffineTransform(opencv_core.CvPoint2D32f cvpoint2d32f, opencv_core.CvPoint2D32f cvpoint2d32f1, opencv_core.CvMat cvmat);

    public static native opencv_core.CvMat cvGetAffineTransform(float af[], float af1[], opencv_core.CvMat cvmat);

    public static native double cvGetCentralMoment(CvMoments cvmoments, int i, int j);

    public static native void cvGetHuMoments(CvMoments cvmoments, CvHuMoments cvhumoments);

    public static native void cvGetMinMaxHistValue(CvHistogram cvhistogram, float af[], float af1[], int ai[], int ai1[]);

    public static native double cvGetNormalizedCentralMoment(CvMoments cvmoments, int i, int j);

    public static native opencv_core.CvMat cvGetPerspectiveTransform(opencv_core.CvPoint2D32f cvpoint2d32f, opencv_core.CvPoint2D32f cvpoint2d32f1, opencv_core.CvMat cvmat);

    public static native opencv_core.CvMat cvGetPerspectiveTransform(float af[], float af1[], opencv_core.CvMat cvmat);

    public static native void cvGetQuadrangleSubPix(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat);

    public static native void cvGetRectSubPix(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvPoint2D32f cvpoint2d32f);

    public static native double cvGetSpatialMoment(CvMoments cvmoments, int i, int j);

    public static native void cvGoodFeaturesToTrack(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvPoint2D32f cvpoint2d32f, int ai[], double d, double d1, opencv_core.CvArr cvarr3, int i, int j, double d2);

    public static native opencv_core.CvSeq cvHoughCircles(opencv_core.CvArr cvarr, Pointer pointer, int i, double d, double d1, double d2, double d3, int j, int k);

    public static native opencv_core.CvSeq cvHoughLines2(opencv_core.CvArr cvarr, Pointer pointer, int i, double d, double d1, int j, 
            double d2, double d3);

    public static native void cvInitUndistortMap(opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

    public static native void cvInitUndistortRectifyMap(opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvMat cvmat2, opencv_core.CvMat cvmat3, opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

    public static native void cvIntegral(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvArr cvarr3);

    public static native void cvLaplace(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native void cvLinearPolar(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvPoint2D32f cvpoint2d32f, double d, int i);

    public static native void cvLogPolar(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvPoint2D32f cvpoint2d32f, double d, int i);

    public static native CvHistogram cvMakeHistHeaderForArray(int i, int ai[], CvHistogram cvhistogram, FloatPointer floatpointer, PointerPointer pointerpointer, int j);

    public static CvHistogram cvMakeHistHeaderForArray(int i, int ai[], CvHistogram cvhistogram, FloatPointer floatpointer, float af[][], int j)
    {
        if (af == null)
        {
            af = null;
        } else
        {
            af = new PointerPointer(af);
        }
        return cvMakeHistHeaderForArray(i, ai, cvhistogram, floatpointer, ((PointerPointer) (af)), j);
    }

    public static native CvHistogram cvMakeHistHeaderForArray(int i, int ai[], CvHistogram cvhistogram, float af[], PointerPointer pointerpointer, int j);

    public static CvHistogram cvMakeHistHeaderForArray(int i, int ai[], CvHistogram cvhistogram, float af[], float af1[][], int j)
    {
        if (af1 == null)
        {
            af1 = null;
        } else
        {
            af1 = new PointerPointer(af1);
        }
        return cvMakeHistHeaderForArray(i, ai, cvhistogram, af, ((PointerPointer) (af1)), j);
    }

    public static native double cvMatchShapes(Pointer pointer, Pointer pointer1, int i, double d);

    public static native void cvMatchTemplate(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, int i);

    public static native opencv_core.CvRect cvMaxRect(opencv_core.CvRect cvrect, opencv_core.CvRect cvrect1);

    public static native opencv_core.CvBox2D cvMinAreaRect2(opencv_core.CvArr cvarr, opencv_core.CvMemStorage cvmemstorage);

    public static native int cvMinEnclosingCircle(opencv_core.CvArr cvarr, opencv_core.CvPoint2D32f cvpoint2d32f, float af[]);

    public static native int cvMinEnclosingCircle(opencv_core.CvArr cvarr, float af[], float af1[]);

    public static native void cvMoments(opencv_core.CvArr cvarr, CvMoments cvmoments, int i);

    public static native void cvMorphologyEx(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, IplConvKernel iplconvkernel, int i, int j);

    public static native void cvMultiplyAcc(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvArr cvarr3);

    public static native void cvNormalizeHist(CvHistogram cvhistogram, double d);

    public static native double cvPointPolygonTest(opencv_core.CvArr cvarr, opencv_core.CvPoint2D32f cvpoint2d32f, int i);

    public static native opencv_core.CvSeq cvPointSeqFromMat(int i, opencv_core.CvArr cvarr, opencv_core.CvContour cvcontour, opencv_core.CvSeqBlock cvseqblock);

    public static native void cvPreCornerDetect(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native void cvPyrDown(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native void cvPyrMeanShiftFiltering(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, double d1, int i, opencv_core.CvTermCriteria cvtermcriteria);

    public static native void cvPyrUp(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native opencv_core.CvPoint cvReadChainPoint(CvChainPtReader cvchainptreader);

    public static native void cvReleaseHist(CvHistogram cvhistogram);

    public static native void cvReleasePyramid(opencv_core.CvMatArray cvmatarray, int i);

    public static native void cvReleaseStructuringElement(IplConvKernel iplconvkernel);

    public static native void cvRemap(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, opencv_core.CvArr cvarr3, int i, opencv_core.CvScalar cvscalar);

    public static void cvResize(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1)
    {
        cvResize(cvarr, cvarr1, 1);
    }

    public static native void cvResize(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native void cvRunningAvg(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, opencv_core.CvArr cvarr2);

    public static native int cvSampleLine(opencv_core.CvArr cvarr, opencv_core.CvPoint cvpoint, opencv_core.CvPoint cvpoint1, Pointer pointer, int i);

    public static native void cvSetHistBinRanges(CvHistogram cvhistogram, PointerPointer pointerpointer, int i);

    public static void cvSetHistBinRanges(CvHistogram cvhistogram, float af[][], int i)
    {
        if (af == null)
        {
            af = null;
        } else
        {
            af = new PointerPointer(af);
        }
        cvSetHistBinRanges(cvhistogram, ((PointerPointer) (af)), i);
    }

    public static void cvSmooth(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j)
    {
        cvSmooth(cvarr, cvarr1, i, j, 0, 0.0D, 0.0D);
    }

    public static native void cvSmooth(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, int k, double d, double d1);

    public static native void cvSobel(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, int j, int k);

    public static native void cvSquareAcc(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2);

    public static CvContourScanner cvStartFindContours(opencv_core.CvArr cvarr, opencv_core.CvMemStorage cvmemstorage, int i, int j, int k)
    {
        return cvStartFindContours(cvarr, cvmemstorage, i, j, k, opencv_core.CvPoint.ZERO);
    }

    public static native CvContourScanner cvStartFindContours(opencv_core.CvArr cvarr, opencv_core.CvMemStorage cvmemstorage, int i, int j, int k, opencv_core.CvPoint cvpoint);

    public static native void cvStartReadChainPoints(opencv_core.CvChain cvchain, CvChainPtReader cvchainptreader);

    public static native void cvSubstituteContour(CvContourScanner cvcontourscanner, opencv_core.CvSeq cvseq);

    public static native void cvThreshHist(CvHistogram cvhistogram, double d);

    public static native double cvThreshold(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, double d, double d1, int i);

    public static void cvUndistort2(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1)
    {
        cvUndistort2(cvarr, cvarr1, cvmat, cvmat1, null);
    }

    public static native void cvUndistort2(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvMat cvmat2);

    public static native void cvUndistortPoints(opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvMat cvmat2, opencv_core.CvMat cvmat3, opencv_core.CvMat cvmat4, opencv_core.CvMat cvmat5);

    public static void cvWarpAffine(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat)
    {
        cvWarpAffine(cvarr, cvarr1, cvmat, 9, opencv_core.CvScalar.ZERO);
    }

    public static native void cvWarpAffine(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, int i, opencv_core.CvScalar cvscalar);

    public static void cvWarpPerspective(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat)
    {
        cvWarpPerspective(cvarr, cvarr1, cvmat, 9, opencv_core.CvScalar.ZERO);
    }

    public static native void cvWarpPerspective(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, int i, opencv_core.CvScalar cvscalar);

    public static native void cvWatershed(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1);

    public static native void eigen2x2(FloatPointer floatpointer, FloatPointer floatpointer1, int i);

    public static native void eigen2x2(float af[], float af1[], int i);

    public static native void filter2D(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint, double d, int j);

    public static native BaseColumnFilter getColumnSumFilter(int i, int j, int k, int l, double d);

    public static native void getDerivKernels(opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, int i, int j, int k, boolean flag, int l);

    public static native opencv_core.CvMat getGaborKernel(opencv_core.CvSize cvsize, double d, double d1, double d2, double d3, double d4, int i);

    public static native opencv_core.CvMat getGaussianKernel(int i, double d, int j);

    public static native int getKernelType(opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint);

    public static native BaseColumnFilter getLinearColumnFilter(int i, int j, opencv_core.CvMat cvmat, int k, int l, double d, int i1);

    public static native BaseFilter getLinearFilter(int i, int j, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint, double d, int k);

    public static native BaseRowFilter getLinearRowFilter(int i, int j, opencv_core.CvMat cvmat, int k, int l);

    public static native BaseColumnFilter getMorphologyColumnFilter(int i, int j, int k, int l);

    public static native BaseFilter getMorphologyFilter(int i, int j, opencv_core.CvMat cvmat, opencv_core.CvPoint cvpoint);

    public static native BaseRowFilter getMorphologyRowFilter(int i, int j, int k, int l);

    public static native BaseRowFilter getRowSumFilter(int i, int j, int k, int l);

    public static native void grabCut(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvRect cvrect, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, int i, int j);

    public static native float initWideAngleProjMap(opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvSize cvsize, int i, int j, opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int k, 
            double d);

    public static native float intersectConvexConvex(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvMat cvmat, boolean flag);

    public static native boolean isContourConvex(opencv_core.CvArr cvarr);

    public static native void medianBlur(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i);

    public static native opencv_core.CvScalar morphologyDefaultBorderValue();

    public static native opencv_core.CvPoint2D64f phaseCorrelate(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2);

    public static native opencv_core.CvPoint2D64f phaseCorrelateRes(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, opencv_core.CvArr cvarr2, double ad[]);

    public static native void sepFilter2D(opencv_core.CvArr cvarr, opencv_core.CvArr cvarr1, int i, opencv_core.CvMat cvmat, opencv_core.CvMat cvmat1, opencv_core.CvPoint cvpoint, double d, 
            int j);

    public static void tryLoad()
    {
    }

    static 
    {
        Loader.load();
    }
}
