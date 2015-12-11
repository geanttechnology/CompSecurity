// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.SizeTPointer;
import java.lang.annotation.Annotation;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class opencv_core
{
    public static class Algorithm extends Pointer
    {

        public static native Algorithm _create(String s);

        private native void allocate();

        public static native void getList(StringVector stringvector);

        public native Algorithm getAlgorithm(String s);

        public native boolean getBool(String s);

        public native double getDouble(String s);

        public native int getInt(String s);

        public native CvMat getMat(String s);

        public native MatVector getMatVector(String s);

        public native void getParams(StringVector stringvector);

        public native String getString(String s);

        public native AlgorithmInfo info();

        public native String name();

        public native String paramHelp(String s);

        public native int paramType(String s);

        public native void read(CvFileStorage cvfilestorage, CvFileNode cvfilenode);

        public native void set(String s, double d);

        public native void set(String s, int i);

        public native void set(String s, Algorithm algorithm);

        public native void set(String s, CvMat cvmat);

        public native void set(String s, MatVector matvector);

        public native void set(String s, String s1);

        public native void set(String s, boolean flag);

        public native void write(CvFileStorage cvfilestorage);

        static 
        {
            Loader.load();
        }

        public Algorithm()
        {
            allocate();
        }

        public Algorithm(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Algorithm.Constructor extends FunctionPointer
    {

        private native void allocate();

        public native Algorithm call();

        static 
        {
            Loader.load();
        }

        protected Algorithm.Constructor()
        {
            allocate();
        }

        public Algorithm.Constructor(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Algorithm.Getter extends FunctionPointer
    {

        public native int call(Algorithm algorithm);

        static 
        {
            Loader.load();
        }

        public Algorithm.Getter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Algorithm.Setter extends FunctionPointer
    {

        public native void call(Algorithm algorithm, int i);

        static 
        {
            Loader.load();
        }

        public Algorithm.Setter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AlgorithmInfo extends Pointer
    {

        private native void allocate(String s, Algorithm.Constructor constructor);

        public native void addParam_(Algorithm algorithm, String s, int i, Pointer pointer, boolean flag, Algorithm.Getter getter, Algorithm.Setter setter, 
                String s1);

        public native void get(Algorithm algorithm, String s, int i, Pointer pointer);

        public native void getParams(StringVector stringvector);

        public native String name();

        public native String paramHelp(String s);

        public native int paramType(String s);

        public native void read(Algorithm algorithm, CvFileStorage cvfilestorage, CvFileNode cvfilenode);

        public native void write(Algorithm algorithm, CvFileStorage cvfilestorage);

        static 
        {
            Loader.load();
        }

        public AlgorithmInfo(Pointer pointer)
        {
            super(pointer);
        }

        public AlgorithmInfo(String s, Algorithm.Constructor constructor)
        {
            allocate(s, constructor);
        }
    }

    public static class ByteVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native byte get(long l, long l1);

        public native ByteVectorVector put(long l, long l1, byte byte0);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public ByteVectorVector()
        {
            allocate();
        }

        public ByteVectorVector(long l)
        {
            allocate(l);
        }

        public ByteVectorVector(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv32suf extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int j);

        public native float f();

        public native Cv32suf f(float f1);

        public native int i();

        public native Cv32suf i(int j);

        public volatile Pointer position(int j)
        {
            return position(j);
        }

        public Cv32suf position(int j)
        {
            return (Cv32suf)super.position(j);
        }

        public native int u();

        public native Cv32suf u(int j);

        static 
        {
            Loader.load();
        }

        public Cv32suf()
        {
            allocate();
        }

        public Cv32suf(int j)
        {
            allocateArray(j);
        }

        public Cv32suf(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv64suf extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int j);

        public native double f();

        public native Cv64suf f(double d);

        public native long i();

        public native Cv64suf i(long l);

        public volatile Pointer position(int j)
        {
            return position(j);
        }

        public Cv64suf position(int j)
        {
            return (Cv64suf)super.position(j);
        }

        public native long u();

        public native Cv64suf u(long l);

        static 
        {
            Loader.load();
        }

        public Cv64suf()
        {
            allocate();
        }

        public Cv64suf(int j)
        {
            allocateArray(j);
        }

        public Cv64suf(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvAllocFunc extends FunctionPointer
    {

        private native void allocate();

        public native Pointer call(long l, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected CvAllocFunc()
        {
            allocate();
        }

        public CvAllocFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvArr extends Pointer
        implements Cloneable
    {

        static 
        {
            Loader.load();
        }

        protected CvArr()
        {
        }

        protected CvArr(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvArrArray extends Pointer
    {

        private native void allocateArray(int i);

        public native CvArr get();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvArrArray position(int i)
        {
            return (CvArrArray)super.position(i);
        }

        public native CvArrArray put(CvArr cvarr);

        public transient CvArrArray put(CvArr acvarr[])
        {
            for (int i = 0; i < acvarr.length; i++)
            {
                position(i).put(acvarr[i]);
            }

            return this;
        }

        static 
        {
            Loader.load();
        }

        public CvArrArray(int i)
        {
            allocateArray(i);
        }

        public CvArrArray(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvArrArray(CvArr acvarr[])
        {
            this(acvarr.length);
            put(acvarr);
            position(0);
        }
    }

    public static class CvAttrList extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native PointerPointer attr();

        public native CvAttrList attr(PointerPointer pointerpointer);

        public native CvAttrList next();

        public native CvAttrList next(CvAttrList cvattrlist);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvAttrList position(int i)
        {
            return (CvAttrList)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvAttrList()
        {
            allocate();
        }

        public CvAttrList(int i)
        {
            allocateArray(i);
        }

        public CvAttrList(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvBox2D extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native float angle();

        public native CvBox2D angle(float f);

        public native CvBox2D center(CvPoint2D32f cvpoint2d32f);

        public native CvPoint2D32f center();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvBox2D position(int i)
        {
            return (CvBox2D)super.position(i);
        }

        public native CvBox2D size(CvSize2D32f cvsize2d32f);

        public native CvSize2D32f size();

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(center()).append(", ").append(size()).append(", ").append(angle()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(center()).append(", ").append(size()).append(", ").append(angle()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        static 
        {
            Loader.load();
        }

        public CvBox2D()
        {
            allocate();
        }

        public CvBox2D(int i)
        {
            allocateArray(i);
        }

        public CvBox2D(Pointer pointer)
        {
            super(pointer);
        }

        public CvBox2D(CvPoint2D32f cvpoint2d32f, CvSize2D32f cvsize2d32f, float f)
        {
            allocate();
            center(cvpoint2d32f).size(cvsize2d32f).angle(f);
        }
    }

    public static class CvChain extends CvSeq
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvChain origin(CvPoint cvpoint);

        public native CvPoint origin();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvChain position(int i)
        {
            return (CvChain)super.position(i);
        }

        public volatile CvSeq position(int i)
        {
            return position(i);
        }

        public CvChain()
        {
            allocate();
        }

        public CvChain(int i)
        {
            allocateArray(i);
        }

        public CvChain(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvCloneFunc extends FunctionPointer
    {

        private native void allocate();

        public native Pointer call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected CvCloneFunc()
        {
            allocate();
        }

        public CvCloneFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvCmpFunc extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, Pointer pointer1, Pointer pointer2);

        static 
        {
            Loader.load();
        }

        protected CvCmpFunc()
        {
            allocate();
        }

        public CvCmpFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvContour extends CvSeq
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int color();

        public native CvContour color(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvContour position(int i)
        {
            return (CvContour)super.position(i);
        }

        public volatile CvSeq position(int i)
        {
            return position(i);
        }

        public native CvContour rect(CvRect cvrect);

        public native CvRect rect();

        public native int reserved(int i);

        public native CvContour reserved(int i, int j);

        public CvContour()
        {
            allocate();
        }

        public CvContour(int i)
        {
            allocateArray(i);
        }

        public CvContour(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvErrorCallback extends FunctionPointer
    {

        private native void allocate();

        public native int call(int i, String s, String s1, String s2, int j, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected CvErrorCallback()
        {
            allocate();
        }

        public CvErrorCallback(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvFileNode extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native double data_f();

        public native CvFileNode data_f(double d);

        public native int data_i();

        public native CvFileNode data_i(int i);

        public native CvFileNode data_map(CvFileNodeHash cvfilenodehash);

        public native CvFileNodeHash data_map();

        public native CvFileNode data_seq(CvSeq cvseq);

        public native CvSeq data_seq();

        public native CvFileNode data_str(CvString cvstring);

        public native CvString data_str();

        public native CvFileNode info(CvTypeInfo cvtypeinfo);

        public native CvTypeInfo info();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvFileNode position(int i)
        {
            return (CvFileNode)super.position(i);
        }

        public native int tag();

        public native CvFileNode tag(int i);

        static 
        {
            Loader.load();
        }

        public CvFileNode()
        {
            allocate();
        }

        public CvFileNode(int i)
        {
            allocateArray(i);
        }

        public CvFileNode(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvFileNodeHash extends Pointer
    {

        static 
        {
            Loader.load();
        }

        public CvFileNodeHash()
        {
        }

        public CvFileNodeHash(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvFileStorage extends Pointer
    {

        public static CvFileStorage open(String s, CvMemStorage cvmemstorage, int i)
        {
            return open(s, cvmemstorage, i, null);
        }

        public static CvFileStorage open(String s, CvMemStorage cvmemstorage, int i, String s1)
        {
            s = opencv_core.cvOpenFileStorage(s, cvmemstorage, i, s1);
            if (s != null)
            {
                s.deallocator(new ReleaseDeallocator(s));
            }
            return s;
        }

        public void release()
        {
            deallocate();
        }

        static 
        {
            Loader.load();
        }

        public CvFileStorage()
        {
        }

        public CvFileStorage(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class CvFileStorage.ReleaseDeallocator extends CvFileStorage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseFileStorage(this);
        }

        CvFileStorage.ReleaseDeallocator(CvFileStorage cvfilestorage)
        {
            super(cvfilestorage);
        }
    }

    public static class CvFont extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native IntPointer ascii();

        public native CvFont ascii(IntPointer intpointer);

        public native CvFont color(CvScalar cvscalar);

        public native CvScalar color();

        public native IntPointer cyrillic();

        public native CvFont cyrillic(IntPointer intpointer);

        public native float dx();

        public native CvFont dx(float f);

        public native int font_face();

        public native CvFont font_face(int i);

        public native IntPointer greek();

        public native CvFont greek(IntPointer intpointer);

        public native float hscale();

        public native CvFont hscale(float f);

        public native int line_type();

        public native CvFont line_type(int i);

        public native BytePointer nameFont();

        public native CvFont nameFont(BytePointer bytepointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvFont position(int i)
        {
            return (CvFont)super.position(i);
        }

        public native float shear();

        public native CvFont shear(float f);

        public native int thickness();

        public native CvFont thickness(int i);

        public native float vscale();

        public native CvFont vscale(float f);

        static 
        {
            Loader.load();
        }

        public CvFont()
        {
            allocate();
        }

        public CvFont(int i)
        {
            allocateArray(i);
        }

        public CvFont(int i, double d, double d1, double d2, 
                int j, int k)
        {
            allocate();
            opencv_core.cvInitFont(this, i, d, d1, d2, j, k);
        }

        public CvFont(int i, double d, int j)
        {
            allocate();
            opencv_core.cvInitFont(this, i, d, d, 0.0D, j, 16);
        }

        public CvFont(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvFreeFunc extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, Pointer pointer1);

        static 
        {
            Loader.load();
        }

        protected CvFreeFunc()
        {
            allocate();
        }

        public CvFreeFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvGraph extends CvSet
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvGraph create(int i, int j, int k, int l, CvMemStorage cvmemstorage)
        {
            return opencv_core.cvCreateGraph(i, j, k, l, cvmemstorage);
        }

        public native CvGraph edges(CvSet cvset);

        public native CvSet edges();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvGraph position(int i)
        {
            return (CvGraph)super.position(i);
        }

        public volatile CvSeq position(int i)
        {
            return position(i);
        }

        public volatile CvSet position(int i)
        {
            return position(i);
        }

        public CvGraph()
        {
            allocate();
            zero();
        }

        public CvGraph(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvGraph(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvGraphEdge extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int flags();

        public native CvGraphEdge flags(int i);

        public native CvGraphEdge next(int i);

        public native CvGraphEdge next(int i, CvGraphEdge cvgraphedge);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvGraphEdge position(int i)
        {
            return (CvGraphEdge)super.position(i);
        }

        public native CvGraphEdge vtx(int i, CvGraphVtx cvgraphvtx);

        public native CvGraphVtx vtx(int i);

        public native float weight();

        public native CvGraphEdge weight(float f);

        static 
        {
            Loader.load();
        }

        public CvGraphEdge()
        {
            allocate();
        }

        public CvGraphEdge(int i)
        {
            allocateArray(i);
        }

        public CvGraphEdge(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvGraphScanner extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvGraphScanner create(CvGraph cvgraph, CvGraphVtx cvgraphvtx, int i)
        {
            cvgraph = opencv_core.cvCreateGraphScanner(cvgraph, cvgraphvtx, i);
            if (cvgraph != null)
            {
                cvgraph.deallocator(new ReleaseDeallocator(cvgraph));
            }
            return cvgraph;
        }

        public native CvGraphScanner dst(CvGraphVtx cvgraphvtx);

        public native CvGraphVtx dst();

        public native CvGraphEdge edge();

        public native CvGraphScanner edge(CvGraphEdge cvgraphedge);

        public native CvGraph graph();

        public native CvGraphScanner graph(CvGraph cvgraph);

        public native int index();

        public native CvGraphScanner index(int i);

        public native int mask();

        public native CvGraphScanner mask(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvGraphScanner position(int i)
        {
            return (CvGraphScanner)super.position(i);
        }

        public void release()
        {
            deallocate();
        }

        public native CvGraphScanner stack(CvSeq cvseq);

        public native CvSeq stack();

        public native CvGraphScanner vtx(CvGraphVtx cvgraphvtx);

        public native CvGraphVtx vtx();

        static 
        {
            Loader.load();
        }

        public CvGraphScanner()
        {
            allocate();
            zero();
        }

        public CvGraphScanner(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvGraphScanner(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class CvGraphScanner.ReleaseDeallocator extends CvGraphScanner
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseGraphScanner(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvGraphScanner.ReleaseDeallocator(CvGraphScanner cvgraphscanner)
        {
            super(cvgraphscanner);
        }
    }

    public static class CvGraphVtx extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvGraphEdge first();

        public native CvGraphVtx first(CvGraphEdge cvgraphedge);

        public native int flags();

        public native CvGraphVtx flags(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvGraphVtx position(int i)
        {
            return (CvGraphVtx)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvGraphVtx()
        {
            allocate();
        }

        public CvGraphVtx(int i)
        {
            allocateArray(i);
        }

        public CvGraphVtx(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvGraphVtx2D extends CvGraphVtx
    {

        private native void allocate();

        private native void allocateArray(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvGraphVtx2D position(int i)
        {
            return (CvGraphVtx2D)super.position(i);
        }

        public volatile CvGraphVtx position(int i)
        {
            return position(i);
        }

        public native CvGraphVtx2D ptr(CvPoint2D32f cvpoint2d32f);

        public native CvPoint2D32f ptr();

        public CvGraphVtx2D()
        {
            allocate();
        }

        public CvGraphVtx2D(int i)
        {
            allocateArray(i);
        }

        public CvGraphVtx2D(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvIsInstanceFunc extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected CvIsInstanceFunc()
        {
            allocate();
        }

        public CvIsInstanceFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvLineIterator extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int err();

        public native CvLineIterator err(int i);

        public native int minus_delta();

        public native CvLineIterator minus_delta(int i);

        public native int minus_step();

        public native CvLineIterator minus_step(int i);

        public native int plus_delta();

        public native CvLineIterator plus_delta(int i);

        public native int plus_step();

        public native CvLineIterator plus_step(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvLineIterator position(int i)
        {
            return (CvLineIterator)super.position(i);
        }

        public native BytePointer ptr();

        public native CvLineIterator ptr(BytePointer bytepointer);

        static 
        {
            Loader.load();
        }

        public CvLineIterator()
        {
            allocate();
        }

        public CvLineIterator(int i)
        {
            allocateArray(i);
        }

        public CvLineIterator(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvMat extends CvArr
    {

        static final boolean $assertionsDisabled;
        private ByteBuffer byteBuffer;
        private DoubleBuffer doubleBuffer;
        private FloatBuffer floatBuffer;
        private int fullSize;
        private IntBuffer intBuffer;
        private ShortBuffer shortBuffer;

        private native void allocate();

        private native void allocateArray(int i);

        public static CvMat create(int i, int j)
        {
            return create(i, j, 6, 1);
        }

        public static CvMat create(int i, int j, int k)
        {
            CvMat cvmat = opencv_core.cvCreateMat(i, j, k);
            if (cvmat != null)
            {
                cvmat.fullSize = cvmat.size();
                cvmat.deallocator(new ReleaseDeallocator(cvmat));
            }
            return cvmat;
        }

        public static CvMat create(int i, int j, int k, int l)
        {
            return create(i, j, opencv_core.CV_MAKETYPE(k, l));
        }

        public static CvMat createHeader(int i, int j)
        {
            return createHeader(i, j, 6, 1);
        }

        public static CvMat createHeader(int i, int j, int k)
        {
            CvMat cvmat = opencv_core.cvCreateMatHeader(i, j, k);
            if (cvmat != null)
            {
                cvmat.fullSize = cvmat.size();
                cvmat.deallocator(new ReleaseDeallocator(cvmat));
            }
            return cvmat;
        }

        public static CvMat createHeader(int i, int j, int k, int l)
        {
            return createHeader(i, j, opencv_core.CV_MAKETYPE(k, l));
        }

        public static ThreadLocal createHeaderThreadLocal(int i, int j)
        {
            return createHeaderThreadLocal(i, j, 6, 1);
        }

        public static ThreadLocal createHeaderThreadLocal(int i, int j, int k)
        {
            return new ThreadLocal(i, j, k) {

                final int val$cols;
                final int val$rows;
                final int val$type;

                protected CvMat initialValue()
                {
                    return CvMat.createHeader(rows, cols, type);
                }

                protected volatile Object initialValue()
                {
                    return initialValue();
                }

            
            {
                rows = i;
                cols = j;
                type = k;
                super();
            }
            };
        }

        public static ThreadLocal createHeaderThreadLocal(int i, int j, int k, int l)
        {
            return createHeaderThreadLocal(i, j, opencv_core.CV_MAKETYPE(k, l));
        }

        public static ThreadLocal createThreadLocal(int i, int j)
        {
            return createThreadLocal(i, j, 6, 1);
        }

        public static ThreadLocal createThreadLocal(int i, int j, int k)
        {
            return new ThreadLocal(i, j, k) {

                final int val$cols;
                final int val$rows;
                final int val$type;

                protected CvMat initialValue()
                {
                    return CvMat.create(rows, cols, type);
                }

                protected volatile Object initialValue()
                {
                    return initialValue();
                }

            
            {
                rows = i;
                cols = j;
                type = k;
                super();
            }
            };
        }

        public static ThreadLocal createThreadLocal(int i, int j, int k, int l)
        {
            return createThreadLocal(i, j, opencv_core.CV_MAKETYPE(k, l));
        }

        private int fullSize()
        {
            if (fullSize > 0)
            {
                return fullSize;
            } else
            {
                int i = size();
                fullSize = i;
                return i;
            }
        }

        public IplImage asIplImage()
        {
            IplImage iplimage = new IplImage();
            opencv_core.cvGetImage(this, iplimage);
            return iplimage;
        }

        public int channels()
        {
            return opencv_core.CV_MAT_CN(type());
        }

        public CvMat clone()
        {
            CvMat cvmat = opencv_core.cvCloneMat(this);
            if (cvmat != null)
            {
                cvmat.deallocator(new ReleaseDeallocator(cvmat));
            }
            return cvmat;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public native int cols();

        public native CvMat cols(int i);

        public CvSize cvSize()
        {
            return opencv_core.cvSize(cols(), rows());
        }

        public native DoublePointer data_db();

        public native CvMat data_db(DoublePointer doublepointer);

        public native FloatPointer data_fl();

        public native CvMat data_fl(FloatPointer floatpointer);

        public native IntPointer data_i();

        public native CvMat data_i(IntPointer intpointer);

        public native BytePointer data_ptr();

        public native CvMat data_ptr(BytePointer bytepointer);

        public native ShortPointer data_s();

        public native CvMat data_s(ShortPointer shortpointer);

        public int depth()
        {
            return opencv_core.CV_MAT_DEPTH(type());
        }

        public int elemSize()
        {
            switch (depth())
            {
            default:
                if (!$assertionsDisabled)
                {
                    throw new AssertionError();
                } else
                {
                    return 0;
                }

            case 0: // '\0'
            case 1: // '\001'
                return 1;

            case 2: // '\002'
            case 3: // '\003'
                return 2;

            case 4: // '\004'
            case 5: // '\005'
                return 4;

            case 6: // '\006'
                return 8;
            }
        }

        public boolean empty()
        {
            return length() == 0;
        }

        public double get(int i)
        {
            switch (depth())
            {
            default:
                if (!$assertionsDisabled)
                {
                    throw new AssertionError();
                } else
                {
                    return (0.0D / 0.0D);
                }

            case 0: // '\0'
                return (double)(getByteBuffer().get(i) & 0xff);

            case 1: // '\001'
                return (double)getByteBuffer().get(i);

            case 2: // '\002'
                return (double)(getShortBuffer().get(i) & 0xffff);

            case 3: // '\003'
                return (double)getShortBuffer().get(i);

            case 4: // '\004'
                return (double)getIntBuffer().get(i);

            case 5: // '\005'
                return (double)getFloatBuffer().get(i);

            case 6: // '\006'
                return getDoubleBuffer().get(i);
            }
        }

        public double get(int i, int j)
        {
            return get((step() * i) / elemSize() + channels() * j);
        }

        public double get(int i, int j, int k)
        {
            return get((step() * i) / elemSize() + channels() * j + k);
        }

        public CvMat get(int i, double ad[])
        {
            return get(i, ad, 0, ad.length);
        }

        public CvMat get(int i, double ad[], int j, int k)
        {
            this;
            JVM INSTR monitorenter ;
            int l = depth();
            l;
            JVM INSTR tableswitch 0 6: default 292
        //                       0 71
        //                       1 71
        //                       2 131
        //                       3 131
        //                       4 189
        //                       5 228
        //                       6 267;
               goto _L1 _L2 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            }
              goto _L7
            ad;
            this;
            JVM INSTR monitorexit ;
            throw ad;
_L2:
            Object obj;
            obj = getByteBuffer();
            ((ByteBuffer) (obj)).position(i);
            i = 0;
_L18:
            if (i >= k) goto _L7; else goto _L8
_L8:
            if (l != 0) goto _L10; else goto _L9
_L9:
            ad[i + j] = ((ByteBuffer) (obj)).get(i) & 0xff;
              goto _L11
_L10:
            ad[i + j] = ((ByteBuffer) (obj)).get(i);
              goto _L11
_L3:
            obj = getShortBuffer();
            ((ShortBuffer) (obj)).position(i);
            i = 0;
_L19:
            if (i >= k) goto _L7; else goto _L12
_L12:
            if (l != 2) goto _L14; else goto _L13
_L13:
            ad[i + j] = ((ShortBuffer) (obj)).get() & 0xffff;
              goto _L15
_L14:
            ad[i + j] = ((ShortBuffer) (obj)).get();
              goto _L15
_L4:
            obj = getIntBuffer();
            ((IntBuffer) (obj)).position(i);
            i = 0;
_L16:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ad[i + j] = ((IntBuffer) (obj)).get();
            i++;
            if (true) goto _L16; else goto _L7
_L5:
            obj = getFloatBuffer();
            ((FloatBuffer) (obj)).position(i);
            i = 0;
_L17:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ad[i + j] = ((FloatBuffer) (obj)).get();
            i++;
            if (true) goto _L17; else goto _L7
_L6:
            getDoubleBuffer().position(i);
            getDoubleBuffer().get(ad, j, k);
_L7:
            this;
            JVM INSTR monitorexit ;
            return this;
_L11:
            i++;
              goto _L18
_L15:
            i++;
              goto _L19
        }

        public CvMat get(double ad[])
        {
            return get(0, ad);
        }

        public double[] get()
        {
            double ad[] = new double[fullSize() / elemSize()];
            get(ad);
            return ad;
        }

        public ByteBuffer getByteBuffer()
        {
            if (byteBuffer == null)
            {
                byteBuffer = data_ptr().capacity(fullSize()).asBuffer();
            }
            byteBuffer.position(0);
            return byteBuffer;
        }

        public DoubleBuffer getDoubleBuffer()
        {
            if (doubleBuffer == null)
            {
                doubleBuffer = data_db().capacity(fullSize() / 8).asBuffer();
            }
            doubleBuffer.position(0);
            return doubleBuffer;
        }

        public FloatBuffer getFloatBuffer()
        {
            if (floatBuffer == null)
            {
                floatBuffer = data_fl().capacity(fullSize() / 4).asBuffer();
            }
            floatBuffer.position(0);
            return floatBuffer;
        }

        public IntBuffer getIntBuffer()
        {
            if (intBuffer == null)
            {
                intBuffer = data_i().capacity(fullSize() / 4).asBuffer();
            }
            intBuffer.position(0);
            return intBuffer;
        }

        public ShortBuffer getShortBuffer()
        {
            if (shortBuffer == null)
            {
                shortBuffer = data_s().capacity(fullSize() / 2).asBuffer();
            }
            shortBuffer.position(0);
            return shortBuffer;
        }

        public native int hdr_refcount();

        public native CvMat hdr_refcount(int i);

        public boolean isContinuous()
        {
            return opencv_core.CV_IS_MAT_CONT(type());
        }

        public int length()
        {
            return rows() * cols();
        }

        public int nChannels()
        {
            return opencv_core.CV_MAT_CN(type());
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMat position(int i)
        {
            return (CvMat)super.position(i);
        }

        public CvMat put(int i, double d)
        {
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
                            switch (depth())
                            {
                            default:
                                if (!$assertionsDisabled)
                                {
                                    throw new AssertionError();
                                }
                                break;

                            case 2: // '\002'
                            case 3: // '\003'
                                break label3;

                            case 4: // '\004'
                                break label2;

                            case 5: // '\005'
                                break label1;

                            case 6: // '\006'
                                break label0;

                            case 0: // '\0'
                            case 1: // '\001'
                                getByteBuffer().put(i, (byte)(int)d);
                                break;
                            }
                            return this;
                        }
                        getShortBuffer().put(i, (short)(int)d);
                        return this;
                    }
                    getIntBuffer().put(i, (int)d);
                    return this;
                }
                getFloatBuffer().put(i, (float)d);
                return this;
            }
            getDoubleBuffer().put(i, d);
            return this;
        }

        public CvMat put(int i, int j, double d)
        {
            return put((step() * i) / elemSize() + channels() * j, d);
        }

        public CvMat put(int i, int j, int k, double d)
        {
            return put((step() * i) / elemSize() + channels() * j + k, d);
        }

        public CvMat put(int i, int j, int k, CvMat cvmat, int l, int i1, int j1)
        {
            this;
            JVM INSTR monitorenter ;
            if (rows() != cvmat.rows() || cols() != cvmat.cols() || step() != cvmat.step() || type() != cvmat.type() || i != 0 || j != 0 || k != 0 || l != 0 || i1 != 0 || j1 != 0) goto _L2; else goto _L1
_L1:
            getByteBuffer().clear();
            cvmat.getByteBuffer().clear();
            getByteBuffer().put(cvmat.getByteBuffer());
_L5:
            this;
            JVM INSTR monitorexit ;
            return this;
_L2:
            int j2;
            int k2;
            int l2;
            j2 = Math.min(rows() - i, cvmat.rows() - l);
            k2 = Math.min(cols() - j, cvmat.cols() - i1);
            l2 = Math.min(channels() - k, cvmat.channels() - j1);
            int k1;
            k1 = 0;
            continue; /* Loop/switch isn't completed */
_L3:
            int i2;
            if (i2 >= l2)
            {
                break MISSING_BLOCK_LABEL_227;
            }
            int l1;
            put(k1 + i, l1 + j, i2 + k, cvmat.get(k1 + l, l1 + i1, i2 + j1));
            i2++;
              goto _L3
            cvmat;
            throw cvmat;
            if (k1 >= j2) goto _L5; else goto _L4
_L4:
            l1 = 0;
            for (l1++; l1 >= k2;)
            {
                k1++;
                continue; /* Loop/switch isn't completed */
            }

            i2 = 0;
              goto _L3
        }

        public transient CvMat put(int i, double ad[])
        {
            return put(i, ad, 0, ad.length);
        }

        public CvMat put(int i, double ad[], int j, int k)
        {
            this;
            JVM INSTR monitorenter ;
            depth();
            JVM INSTR tableswitch 0 6: default 256
        //                       0 67
        //                       1 67
        //                       2 108
        //                       3 108
        //                       4 149
        //                       5 189
        //                       6 229;
               goto _L1 _L2 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            }
              goto _L7
            ad;
            this;
            JVM INSTR monitorexit ;
            throw ad;
_L2:
            Object obj;
            obj = getByteBuffer();
            ((ByteBuffer) (obj)).position(i);
            i = 0;
_L8:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ((ByteBuffer) (obj)).put((byte)(int)ad[i + j]);
            i++;
            if (true) goto _L8; else goto _L7
_L3:
            obj = getShortBuffer();
            ((ShortBuffer) (obj)).position(i);
            i = 0;
_L9:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ((ShortBuffer) (obj)).put((short)(int)ad[i + j]);
            i++;
            if (true) goto _L9; else goto _L7
_L4:
            obj = getIntBuffer();
            ((IntBuffer) (obj)).position(i);
            i = 0;
_L10:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ((IntBuffer) (obj)).put((int)ad[i + j]);
            i++;
            if (true) goto _L10; else goto _L7
_L5:
            obj = getFloatBuffer();
            ((FloatBuffer) (obj)).position(i);
            i = 0;
_L11:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            ((FloatBuffer) (obj)).put((float)ad[i + j]);
            i++;
            if (true) goto _L11; else goto _L7
_L6:
            DoubleBuffer doublebuffer = getDoubleBuffer();
            doublebuffer.position(i);
            doublebuffer.put(ad, j, k);
_L7:
            this;
            JVM INSTR monitorexit ;
            return this;
        }

        public CvMat put(CvMat cvmat)
        {
            return put(0, 0, 0, cvmat, 0, 0, 0);
        }

        public transient CvMat put(double ad[])
        {
            return put(0, ad);
        }

        public native int raw_type();

        public native CvMat raw_type(int i);

        public native IntPointer refcount();

        public native CvMat refcount(IntPointer intpointer);

        public void release()
        {
            deallocate();
        }

        public void reset()
        {
            fullSize = 0;
            byteBuffer = null;
            shortBuffer = null;
            intBuffer = null;
            floatBuffer = null;
            doubleBuffer = null;
        }

        public native int rows();

        public native CvMat rows(int i);

        public int size()
        {
            int i = rows();
            int j = cols();
            int k = elemSize();
            int l = channels();
            if (i > 1)
            {
                i = step() * (i - 1);
            } else
            {
                i = 0;
            }
            return i + l * (j * k);
        }

        public native int step();

        public native CvMat step(int i);

        public String toString()
        {
            return toString(0);
        }

        public String toString(int i)
        {
            StringBuilder stringbuilder = new StringBuilder("[ ");
            int j1 = channels();
            for (int j = 0; j < rows(); j++)
            {
                for (int k = 0; k < cols(); k++)
                {
                    CvScalar cvscalar = opencv_core.cvGet2D(this, j, k);
                    if (j1 > 1)
                    {
                        stringbuilder.append("(");
                    }
                    for (int i1 = 0; i1 < j1; i1++)
                    {
                        stringbuilder.append((float)cvscalar.val(i1));
                        if (i1 < j1 - 1)
                        {
                            stringbuilder.append(", ");
                        }
                    }

                    if (j1 > 1)
                    {
                        stringbuilder.append(")");
                    }
                    if (k < cols() - 1)
                    {
                        stringbuilder.append(", ");
                    }
                }

                if (j >= rows() - 1)
                {
                    continue;
                }
                stringbuilder.append("\n  ");
                for (int l = 0; l < i; l++)
                {
                    stringbuilder.append(' ');
                }

            }

            stringbuilder.append(" ]");
            return stringbuilder.toString();
        }

        public int total()
        {
            return rows() * cols();
        }

        public int type()
        {
            return opencv_core.CV_MAT_TYPE(raw_type());
        }

        public void type(int i, int j)
        {
            raw_type(opencv_core.CV_MAKETYPE(i, j) | 0x42420000);
        }

        static 
        {
            boolean flag;
            if (!com/googlecode/javacv/cpp/opencv_core.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        public CvMat()
        {
            fullSize = 0;
            byteBuffer = null;
            shortBuffer = null;
            intBuffer = null;
            floatBuffer = null;
            doubleBuffer = null;
            allocate();
            zero();
        }

        public CvMat(int i)
        {
            fullSize = 0;
            byteBuffer = null;
            shortBuffer = null;
            intBuffer = null;
            floatBuffer = null;
            doubleBuffer = null;
            allocateArray(i);
            zero();
        }

        public CvMat(Pointer pointer)
        {
            super(pointer);
            fullSize = 0;
            byteBuffer = null;
            shortBuffer = null;
            intBuffer = null;
            floatBuffer = null;
            doubleBuffer = null;
        }
    }

    protected static class CvMat.ReleaseDeallocator extends CvMat
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return super.clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseMat(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvMat.ReleaseDeallocator(CvMat cvmat)
        {
            super(cvmat);
        }
    }

    public static class CvMatArray extends CvArrArray
    {

        private native void allocateArray(int i);

        public volatile CvArr get()
        {
            return get();
        }

        public native CvMat get();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile CvArrArray position(int i)
        {
            return position(i);
        }

        public CvMatArray position(int i)
        {
            return (CvMatArray)super.position(i);
        }

        public volatile CvArrArray put(CvArr cvarr)
        {
            return put(cvarr);
        }

        public volatile CvArrArray put(CvArr acvarr[])
        {
            return put(acvarr);
        }

        public CvMatArray put(CvArr cvarr)
        {
            if (cvarr instanceof CvMat)
            {
                return (CvMatArray)super.put(cvarr);
            } else
            {
                throw new ArrayStoreException(cvarr.getClass().getName());
            }
        }

        public transient CvMatArray put(CvArr acvarr[])
        {
            return (CvMatArray)super.put(acvarr);
        }

        public CvMatArray(int i)
        {
            super(new CvArr[0]);
            allocateArray(i);
        }

        public CvMatArray(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvMatArray(CvMat acvmat[])
        {
            this(acvmat.length);
            put(acvmat);
            position(0);
        }
    }

    public static class CvMatND extends CvArr
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvMatND create(int i, int ai[], int j)
        {
            ai = opencv_core.cvCreateMatND(i, ai, j);
            if (ai != null)
            {
                ai.deallocator(new ReleaseDeallocator(ai));
            }
            return ai;
        }

        public CvMatND clone()
        {
            CvMatND cvmatnd = opencv_core.cvCloneMatND(this);
            if (cvmatnd != null)
            {
                cvmatnd.deallocator(new ReleaseDeallocator(cvmatnd));
            }
            return cvmatnd;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public native DoublePointer data_db();

        public native CvMatND data_db(DoublePointer doublepointer);

        public native FloatPointer data_fl();

        public native CvMatND data_fl(FloatPointer floatpointer);

        public native IntPointer data_i();

        public native CvMatND data_i(IntPointer intpointer);

        public native BytePointer data_ptr();

        public native CvMatND data_ptr(BytePointer bytepointer);

        public native ShortPointer data_s();

        public native CvMatND data_s(ShortPointer shortpointer);

        public native int dim_size(int i);

        public native CvMatND dim_size(int i, int j);

        public native int dim_step(int i);

        public native CvMatND dim_step(int i, int j);

        public native int dims();

        public native CvMatND dims(int i);

        public native int hdr_refcount();

        public native CvMatND hdr_refcount(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMatND position(int i)
        {
            return (CvMatND)super.position(i);
        }

        public native IntPointer refcount();

        public native CvMatND refcount(IntPointer intpointer);

        public void release()
        {
            deallocate();
        }

        public native int type();

        public native CvMatND type(int i);

        public CvMatND()
        {
            allocate();
            zero();
        }

        public CvMatND(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvMatND(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class CvMatND.ReleaseDeallocator extends CvMatND
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return super.clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseMatND(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvMatND.ReleaseDeallocator(CvMatND cvmatnd)
        {
            super(cvmatnd);
        }
    }

    public static class CvMatNDArray extends CvArrArray
    {

        private native void allocateArray(int i);

        public volatile CvArr get()
        {
            return get();
        }

        public native CvMatND get();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile CvArrArray position(int i)
        {
            return position(i);
        }

        public CvMatNDArray position(int i)
        {
            return (CvMatNDArray)super.position(i);
        }

        public volatile CvArrArray put(CvArr cvarr)
        {
            return put(cvarr);
        }

        public volatile CvArrArray put(CvArr acvarr[])
        {
            return put(acvarr);
        }

        public CvMatNDArray put(CvArr cvarr)
        {
            if (cvarr instanceof CvMatND)
            {
                return (CvMatNDArray)super.put(cvarr);
            } else
            {
                throw new ArrayStoreException(cvarr.getClass().getName());
            }
        }

        public transient CvMatNDArray put(CvArr acvarr[])
        {
            return (CvMatNDArray)super.put(acvarr);
        }

        public CvMatNDArray(int i)
        {
            super(new CvArr[0]);
            allocateArray(i);
        }

        public CvMatNDArray(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvMatNDArray(CvMatND acvmatnd[])
        {
            this(acvmatnd.length);
            put(acvmatnd);
            position(0);
        }
    }

    public static class CvMemBlock extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvMemBlock next();

        public native CvMemBlock next(CvMemBlock cvmemblock);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMemBlock position(int i)
        {
            return (CvMemBlock)super.position(i);
        }

        public native CvMemBlock prev();

        public native CvMemBlock prev(CvMemBlock cvmemblock);

        static 
        {
            Loader.load();
        }

        public CvMemBlock()
        {
            allocate();
        }

        public CvMemBlock(int i)
        {
            allocateArray(i);
        }

        public CvMemBlock(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvMemStorage extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvMemStorage create()
        {
            return create(0);
        }

        public static CvMemStorage create(int i)
        {
            CvMemStorage cvmemstorage = opencv_core.cvCreateMemStorage(i);
            if (cvmemstorage != null)
            {
                cvmemstorage.deallocator(new ReleaseDeallocator(cvmemstorage));
            }
            return cvmemstorage;
        }

        public native int block_size();

        public native CvMemStorage block_size(int i);

        public native CvMemBlock bottom();

        public native CvMemStorage bottom(CvMemBlock cvmemblock);

        public native int free_space();

        public native CvMemStorage free_space(int i);

        public native CvMemStorage parent();

        public native CvMemStorage parent(CvMemStorage cvmemstorage);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMemStorage position(int i)
        {
            return (CvMemStorage)super.position(i);
        }

        public void release()
        {
            deallocate();
        }

        public native int signature();

        public native CvMemStorage signature(int i);

        public native CvMemBlock top();

        public native CvMemStorage top(CvMemBlock cvmemblock);

        static 
        {
            Loader.load();
        }

        public CvMemStorage()
        {
            allocate();
            zero();
        }

        public CvMemStorage(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvMemStorage(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class CvMemStorage.ReleaseDeallocator extends CvMemStorage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseMemStorage(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvMemStorage.ReleaseDeallocator(CvMemStorage cvmemstorage)
        {
            super(cvmemstorage);
        }
    }

    public static class CvMemStoragePos extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int free_space();

        public native CvMemStoragePos free_space(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvMemStoragePos position(int i)
        {
            return (CvMemStoragePos)super.position(i);
        }

        public native CvMemBlock top();

        public native CvMemStoragePos top(CvMemBlock cvmemblock);

        static 
        {
            Loader.load();
        }

        public CvMemStoragePos()
        {
            allocate();
        }

        public CvMemStoragePos(int i)
        {
            allocateArray(i);
        }

        public CvMemStoragePos(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvModuleInfo extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvModuleInfo func_tab(CvPluginFuncInfo cvpluginfuncinfo);

        public native CvPluginFuncInfo func_tab();

        public native BytePointer name();

        public native CvModuleInfo name(BytePointer bytepointer);

        public native CvModuleInfo next();

        public native CvModuleInfo next(CvModuleInfo cvmoduleinfo);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvModuleInfo position(int i)
        {
            return (CvModuleInfo)super.position(i);
        }

        public native BytePointer version();

        public native CvModuleInfo version(BytePointer bytepointer);

        static 
        {
            Loader.load();
        }

        public CvModuleInfo()
        {
            allocate();
        }

        public CvModuleInfo(int i)
        {
            allocateArray(i);
        }

        public CvModuleInfo(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvNArrayIterator extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int count();

        public native CvNArrayIterator count(int i);

        public native int dims();

        public native CvNArrayIterator dims(int i);

        public native CvMatND hdr(int i);

        public native CvNArrayIterator hdr(int i, CvMatND cvmatnd);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvNArrayIterator position(int i)
        {
            return (CvNArrayIterator)super.position(i);
        }

        public native BytePointer ptr(int i);

        public native CvNArrayIterator ptr(int i, BytePointer bytepointer);

        public native CvNArrayIterator size(CvSize cvsize);

        public native CvSize size();

        public native int stack(int i);

        public native CvNArrayIterator stack(int i, int j);

        static 
        {
            Loader.load();
        }

        public CvNArrayIterator()
        {
            allocate();
        }

        public CvNArrayIterator(int i)
        {
            allocateArray(i);
        }

        public CvNArrayIterator(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvPluginFuncInfo extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native Pointer default_func_addr();

        public native CvPluginFuncInfo default_func_addr(Pointer pointer);

        public native PointerPointer func_addr();

        public native CvPluginFuncInfo func_addr(PointerPointer pointerpointer);

        public native BytePointer func_names();

        public native CvPluginFuncInfo func_names(BytePointer bytepointer);

        public native int loaded_from();

        public native CvPluginFuncInfo loaded_from(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPluginFuncInfo position(int i)
        {
            return (CvPluginFuncInfo)super.position(i);
        }

        public native int search_modules();

        public native CvPluginFuncInfo search_modules(int i);

        static 
        {
            Loader.load();
        }

        public CvPluginFuncInfo()
        {
            allocate();
        }

        public CvPluginFuncInfo(int i)
        {
            allocateArray(i);
        }

        public CvPluginFuncInfo(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvPoint extends Pointer
    {

        public static final CvPoint ZERO = (new CvPoint()).x(0).y(0);

        private native void allocate();

        private native void allocateArray(int i);

        public CvPoint get(int ai[])
        {
            return get(ai, 0, ai.length);
        }

        public CvPoint get(int ai[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k);
                ai[k * 2 + i] = x();
                ai[k * 2 + i + 1] = y();
            }

            return position(0);
        }

        public int[] get()
        {
            int ai[];
            int i;
            if (capacity == 0)
            {
                i = 2;
            } else
            {
                i = capacity * 2;
            }
            ai = new int[i];
            get(ai);
            return ai;
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPoint position(int i)
        {
            return (CvPoint)super.position(i);
        }

        public CvPoint put(byte byte0, CvPoint2D32f cvpoint2d32f)
        {
            x(Math.round(cvpoint2d32f.x() * (float)(1 << byte0)));
            y(Math.round(cvpoint2d32f.y() * (float)(1 << byte0)));
            return this;
        }

        public CvPoint put(byte byte0, CvPoint2D64f cvpoint2d64f)
        {
            x((int)Math.round(cvpoint2d64f.x() * (double)(1 << byte0)));
            y((int)Math.round(cvpoint2d64f.y() * (double)(1 << byte0)));
            return this;
        }

        public final transient CvPoint put(byte byte0, double ad[])
        {
            return put(byte0, ad, 0, ad.length);
        }

        public final CvPoint put(byte byte0, double ad[], int i, int j)
        {
            int ai[] = new int[j];
            for (int k = 0; k < j; k++)
            {
                ai[k] = (int)Math.round(ad[i + k] * (double)(1 << byte0));
            }

            return put(ai, 0, j);
        }

        public CvPoint put(int i, int j)
        {
            return x(i).y(j);
        }

        public CvPoint put(CvPoint cvpoint)
        {
            return x(cvpoint.x()).y(cvpoint.y());
        }

        public final transient CvPoint put(int ai[])
        {
            return put(ai, 0, ai.length);
        }

        public final CvPoint put(int ai[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k).put(ai[k * 2 + i], ai[k * 2 + i + 1]);
            }

            return position(0);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(x()).append(", ").append(y()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native int x();

        public native CvPoint x(int i);

        public native int y();

        public native CvPoint y(int i);

        static 
        {
            Loader.load();
        }

        public CvPoint()
        {
            allocate();
        }

        public transient CvPoint(byte byte0, double ad[])
        {
            this(byte0, ad, 0, ad.length);
        }

        public CvPoint(byte byte0, double ad[], int i, int j)
        {
            this(j / 2);
            put(byte0, ad, i, j);
        }

        public CvPoint(int i)
        {
            allocateArray(i);
        }

        public CvPoint(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvPoint(int ai[])
        {
            this(ai, 0, ai.length);
        }

        public CvPoint(int ai[], int i, int j)
        {
            this(j / 2);
            put(ai, i, j);
        }
    }

    public static class CvPoint2D32f extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public CvPoint2D32f get(double ad[])
        {
            return get(ad, 0, ad.length);
        }

        public CvPoint2D32f get(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k);
                ad[k * 2 + i] = x();
                ad[k * 2 + i + 1] = y();
            }

            return position(0);
        }

        public double[] get()
        {
            double ad[];
            int i;
            if (capacity == 0)
            {
                i = 2;
            } else
            {
                i = capacity * 2;
            }
            ad = new double[i];
            get(ad);
            return ad;
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPoint2D32f position(int i)
        {
            return (CvPoint2D32f)super.position(i);
        }

        public CvPoint2D32f put(double d, double d1)
        {
            return x((float)d).y((float)d1);
        }

        public CvPoint2D32f put(CvPoint2D32f cvpoint2d32f)
        {
            return x(cvpoint2d32f.x()).y(cvpoint2d32f.y());
        }

        public CvPoint2D32f put(CvPoint2D64f cvpoint2d64f)
        {
            return x((float)cvpoint2d64f.x()).y((float)cvpoint2d64f.y());
        }

        public CvPoint2D32f put(CvPoint cvpoint)
        {
            return x(cvpoint.x()).y(cvpoint.y());
        }

        public final transient CvPoint2D32f put(double ad[])
        {
            return put(ad, 0, ad.length);
        }

        public final CvPoint2D32f put(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k).put(ad[k * 2 + i], ad[k * 2 + i + 1]);
            }

            return position(0);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(x()).append(", ").append(y()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native float x();

        public native CvPoint2D32f x(float f);

        public native float y();

        public native CvPoint2D32f y(float f);

        static 
        {
            Loader.load();
        }

        public CvPoint2D32f()
        {
            allocate();
        }

        public CvPoint2D32f(int i)
        {
            allocateArray(i);
        }

        public CvPoint2D32f(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvPoint2D32f(double ad[])
        {
            this(ad, 0, ad.length);
        }

        public CvPoint2D32f(double ad[], int i, int j)
        {
            this(j / 2);
            put(ad, i, j);
        }
    }

    public static class CvPoint2D64f extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public CvPoint2D64f get(double ad[])
        {
            return get(ad, 0, ad.length);
        }

        public CvPoint2D64f get(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k);
                ad[k * 2 + i] = x();
                ad[k * 2 + i + 1] = y();
            }

            return position(0);
        }

        public double[] get()
        {
            double ad[];
            int i;
            if (capacity == 0)
            {
                i = 2;
            } else
            {
                i = capacity * 2;
            }
            ad = new double[i];
            get(ad);
            return ad;
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPoint2D64f position(int i)
        {
            return (CvPoint2D64f)super.position(i);
        }

        public CvPoint2D64f put(double d, double d1)
        {
            return x(d).y(d1);
        }

        public CvPoint2D64f put(CvPoint2D32f cvpoint2d32f)
        {
            return x(cvpoint2d32f.x()).y(cvpoint2d32f.y());
        }

        public CvPoint2D64f put(CvPoint2D64f cvpoint2d64f)
        {
            return x(cvpoint2d64f.x()).y(cvpoint2d64f.y());
        }

        public CvPoint2D64f put(CvPoint cvpoint)
        {
            return x(cvpoint.x()).y(cvpoint.y());
        }

        public final transient CvPoint2D64f put(double ad[])
        {
            return put(ad, 0, ad.length);
        }

        public final CvPoint2D64f put(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 2; k++)
            {
                position(k).put(ad[k * 2 + i], ad[k * 2 + i + 1]);
            }

            return position(0);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append((float)x()).append(", ").append((float)y()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append((float)x()).append(", ").append((float)y()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native double x();

        public native CvPoint2D64f x(double d);

        public native double y();

        public native CvPoint2D64f y(double d);

        static 
        {
            Loader.load();
        }

        public CvPoint2D64f()
        {
            allocate();
        }

        public CvPoint2D64f(int i)
        {
            allocateArray(i);
        }

        public CvPoint2D64f(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvPoint2D64f(double ad[])
        {
            this(ad, 0, ad.length);
        }

        public CvPoint2D64f(double ad[], int i, int j)
        {
            this(j / 2);
            put(ad, i, j);
        }
    }

    public static class CvPoint3D32f extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public CvPoint3D32f get(double ad[])
        {
            return get(ad, 0, ad.length);
        }

        public CvPoint3D32f get(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 3; k++)
            {
                position(k);
                ad[k * 3 + i] = x();
                ad[k * 3 + i + 1] = y();
                ad[k * 3 + i + 2] = z();
            }

            return position(0);
        }

        public double[] get()
        {
            double ad[];
            int i;
            if (capacity == 0)
            {
                i = 3;
            } else
            {
                i = capacity * 3;
            }
            ad = new double[i];
            get(ad);
            return ad;
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPoint3D32f position(int i)
        {
            return (CvPoint3D32f)super.position(i);
        }

        public CvPoint3D32f put(double d, double d1, double d2)
        {
            return x((float)d).y((float)d1).z((float)d2);
        }

        public CvPoint3D32f put(CvPoint2D32f cvpoint2d32f)
        {
            return x(cvpoint2d32f.x()).y(cvpoint2d32f.y()).z(0.0F);
        }

        public CvPoint3D32f put(CvPoint2D64f cvpoint2d64f)
        {
            return x((float)cvpoint2d64f.x()).y((float)cvpoint2d64f.y()).z(0.0F);
        }

        public CvPoint3D32f put(CvPoint cvpoint)
        {
            return x(cvpoint.x()).y(cvpoint.y()).z(0.0F);
        }

        public final transient CvPoint3D32f put(double ad[])
        {
            return put(ad, 0, ad.length);
        }

        public final CvPoint3D32f put(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 3; k++)
            {
                position(k).put(ad[k * 3 + i], ad[k * 3 + i + 1], ad[k * 3 + i + 2]);
            }

            return position(0);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append(", ").append(z()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(x()).append(", ").append(y()).append(", ").append(z()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native float x();

        public native CvPoint3D32f x(float f);

        public native float y();

        public native CvPoint3D32f y(float f);

        public native float z();

        public native CvPoint3D32f z(float f);

        static 
        {
            Loader.load();
        }

        public CvPoint3D32f()
        {
            allocate();
        }

        public CvPoint3D32f(int i)
        {
            allocateArray(i);
        }

        public CvPoint3D32f(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvPoint3D32f(double ad[])
        {
            this(ad, 0, ad.length);
        }

        public CvPoint3D32f(double ad[], int i, int j)
        {
            this(j / 3);
            put(ad, i, j);
        }
    }

    public static class CvPoint3D64f extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public CvPoint3D64f get(double ad[])
        {
            return get(ad, 0, ad.length);
        }

        public CvPoint3D64f get(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 3; k++)
            {
                position(k);
                ad[k * 3 + i] = x();
                ad[k * 3 + i + 1] = y();
                ad[k * 3 + i + 2] = z();
            }

            return position(0);
        }

        public double[] get()
        {
            double ad[];
            int i;
            if (capacity == 0)
            {
                i = 3;
            } else
            {
                i = capacity * 3;
            }
            ad = new double[i];
            get(ad);
            return ad;
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvPoint3D64f position(int i)
        {
            return (CvPoint3D64f)super.position(i);
        }

        public CvPoint3D64f put(double d, double d1, double d2)
        {
            return x(x()).y(y()).z(z());
        }

        public CvPoint3D64f put(CvPoint2D32f cvpoint2d32f)
        {
            return x(cvpoint2d32f.x()).y(cvpoint2d32f.y()).z(0.0D);
        }

        public CvPoint3D64f put(CvPoint2D64f cvpoint2d64f)
        {
            return x(cvpoint2d64f.x()).y(cvpoint2d64f.y()).z(0.0D);
        }

        public CvPoint3D64f put(CvPoint cvpoint)
        {
            return x(cvpoint.x()).y(cvpoint.y()).z(0.0D);
        }

        public final transient CvPoint3D64f put(double ad[])
        {
            return put(ad, 0, ad.length);
        }

        public final CvPoint3D64f put(double ad[], int i, int j)
        {
            for (int k = 0; k < j / 3; k++)
            {
                position(k).put(ad[k * 3 + i], ad[k * 3 + i + 1], ad[k * 3 + i + 2]);
            }

            return position(0);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append((float)x()).append(", ").append((float)y()).append(", ").append((float)z()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append((float)x()).append(", ").append((float)y()).append(", ").append((float)z()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native double x();

        public native CvPoint3D64f x(double d);

        public native double y();

        public native CvPoint3D64f y(double d);

        public native double z();

        public native CvPoint3D64f z(double d);

        static 
        {
            Loader.load();
        }

        public CvPoint3D64f()
        {
            allocate();
        }

        public CvPoint3D64f(int i)
        {
            allocateArray(i);
        }

        public CvPoint3D64f(Pointer pointer)
        {
            super(pointer);
        }

        public transient CvPoint3D64f(double ad[])
        {
            this(ad, 0, ad.length);
        }

        public CvPoint3D64f(double ad[], int i, int j)
        {
            this(j / 3);
            put(ad, i, j);
        }
    }

    public static class CvRNG extends LongPointer
    {

        private native void allocate();

        static 
        {
            Loader.load();
        }

        public CvRNG()
        {
            this(null);
            allocate();
        }

        public CvRNG(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvReadFunc extends FunctionPointer
    {

        private native void allocate();

        public native Pointer call(CvFileStorage cvfilestorage, CvFileNode cvfilenode);

        static 
        {
            Loader.load();
        }

        protected CvReadFunc()
        {
            allocate();
        }

        public CvReadFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvRect extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int height();

        public native CvRect height(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvRect position(int i)
        {
            return (CvRect)super.position(i);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append("; ").append(width()).append(", ").append(height()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(x()).append(", ").append(y()).append("; ").append(width()).append(", ").append(height()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native int width();

        public native CvRect width(int i);

        public native int x();

        public native CvRect x(int i);

        public native int y();

        public native CvRect y(int i);

        static 
        {
            Loader.load();
        }

        public CvRect()
        {
            allocate();
        }

        public CvRect(int i)
        {
            allocateArray(i);
        }

        public CvRect(int i, int j, int k, int l)
        {
            allocate();
            x(i).y(j).width(k).height(l);
        }

        public CvRect(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvReleaseFunc extends FunctionPointer
    {

        private native void allocate();

        public native void call(PointerPointer pointerpointer);

        static 
        {
            Loader.load();
        }

        protected CvReleaseFunc()
        {
            allocate();
        }

        public CvReleaseFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvScalar extends Pointer
    {

        public static final CvScalar ALPHA1 = (new CvScalar()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 1.0D);
        public static final CvScalar ALPHA255 = (new CvScalar()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 255D);
        public static final CvScalar BLACK = opencv_core.CV_RGB(0.0D, 0.0D, 0.0D);
        public static final CvScalar BLUE = opencv_core.CV_RGB(0.0D, 0.0D, 255D);
        public static final CvScalar CYAN = opencv_core.CV_RGB(0.0D, 255D, 255D);
        public static final CvScalar GRAY = opencv_core.CV_RGB(128D, 128D, 128D);
        public static final CvScalar GREEN = opencv_core.CV_RGB(0.0D, 255D, 0.0D);
        public static final CvScalar MAGENTA = opencv_core.CV_RGB(255D, 0.0D, 255D);
        public static final CvScalar ONE = (new CvScalar()).val(0, 1.0D).val(1, 1.0D).val(2, 1.0D).val(3, 1.0D);
        public static final CvScalar ONEHALF = (new CvScalar()).val(0, 0.5D).val(1, 0.5D).val(2, 0.5D).val(3, 0.5D);
        public static final CvScalar RED = opencv_core.CV_RGB(255D, 0.0D, 0.0D);
        public static final CvScalar WHITE = opencv_core.CV_RGB(255D, 255D, 255D);
        public static final CvScalar YELLOW = opencv_core.CV_RGB(255D, 255D, 0.0D);
        public static final CvScalar ZERO = (new CvScalar()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);

        private native void allocate();

        private native void allocateArray(int i);

        public double blue()
        {
            return val(0);
        }

        public CvScalar blue(double d)
        {
            val(0, d);
            return this;
        }

        public native DoublePointer getDoublePointerVal();

        public native LongPointer getLongPointerVal();

        public double getVal(int i)
        {
            return val(i);
        }

        public double green()
        {
            return val(1);
        }

        public CvScalar green(double d)
        {
            val(1, d);
            return this;
        }

        public double magnitude()
        {
            return Math.sqrt(val(0) * val(0) + val(1) * val(1) + val(2) * val(2) + val(3) * val(3));
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvScalar position(int i)
        {
            return (CvScalar)super.position(i);
        }

        public double red()
        {
            return val(2);
        }

        public CvScalar red(double d)
        {
            val(2, d);
            return this;
        }

        public void scale(double d)
        {
            for (int i = 0; i < 4; i++)
            {
                val(i, val(i) * d);
            }

        }

        public CvScalar setVal(int i, double d)
        {
            return val(i, d);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append((float)val(0)).append(", ").append((float)val(1)).append(", ").append((float)val(2)).append(", ").append((float)val(3)).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append((float)val(0)).append(", ").append((float)val(1)).append(", ").append((float)val(2)).append(", ").append((float)val(3)).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native double val(int i);

        public native CvScalar val(int i, double d);

        static 
        {
            Loader.load();
        }

        public CvScalar()
        {
            allocate();
        }

        public CvScalar(double d, double d1, double d2, double d3)
        {
            allocate();
            val(0, d).val(1, d1).val(2, d2).val(3, d3);
        }

        public CvScalar(int i)
        {
            allocateArray(i);
        }

        public CvScalar(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSeq extends CvArr
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvSeq create(int i, int j, int k, CvMemStorage cvmemstorage)
        {
            return opencv_core.cvCreateSeq(i, j, k, cvmemstorage);
        }

        public native BytePointer block_max();

        public native CvSeq block_max(BytePointer bytepointer);

        public native int delta_elems();

        public native CvSeq delta_elems(int i);

        public native int elem_size();

        public native CvSeq elem_size(int i);

        public native CvSeq first(CvSeqBlock cvseqblock);

        public native CvSeqBlock first();

        public native int flags();

        public native CvSeq flags(int i);

        public native CvSeq free_blocks(CvSeqBlock cvseqblock);

        public native CvSeqBlock free_blocks();

        public native CvSeq h_next();

        public native CvSeq h_next(CvSeq cvseq);

        public native CvSeq h_prev();

        public native CvSeq h_prev(CvSeq cvseq);

        public native int header_size();

        public native CvSeq header_size(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSeq position(int i)
        {
            return (CvSeq)super.position(i);
        }

        public native BytePointer ptr();

        public native CvSeq ptr(BytePointer bytepointer);

        public native CvMemStorage storage();

        public native CvSeq storage(CvMemStorage cvmemstorage);

        public native int total();

        public native CvSeq total(int i);

        public native CvSeq v_next();

        public native CvSeq v_next(CvSeq cvseq);

        public native CvSeq v_prev();

        public native CvSeq v_prev(CvSeq cvseq);

        public CvSeq()
        {
            allocate();
            zero();
        }

        public CvSeq(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvSeq(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSeqBlock extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int count();

        public native CvSeqBlock count(int i);

        public native BytePointer data();

        public native CvSeqBlock data(BytePointer bytepointer);

        public native CvSeqBlock next();

        public native CvSeqBlock next(CvSeqBlock cvseqblock);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSeqBlock position(int i)
        {
            return (CvSeqBlock)super.position(i);
        }

        public native CvSeqBlock prev();

        public native CvSeqBlock prev(CvSeqBlock cvseqblock);

        public native int start_index();

        public native CvSeqBlock start_index(int i);

        static 
        {
            Loader.load();
        }

        public CvSeqBlock()
        {
            allocate();
        }

        public CvSeqBlock(int i)
        {
            allocateArray(i);
        }

        public CvSeqBlock(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSeqReader extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvSeqBlock block();

        public native CvSeqReader block(CvSeqBlock cvseqblock);

        public native BytePointer block_max();

        public native CvSeqReader block_max(BytePointer bytepointer);

        public native BytePointer block_min();

        public native CvSeqReader block_min(BytePointer bytepointer);

        public native int delta_index();

        public native CvSeqReader delta_index(int i);

        public native int header_size();

        public native CvSeqReader header_size(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSeqReader position(int i)
        {
            return (CvSeqReader)super.position(i);
        }

        public native BytePointer prev_elem();

        public native CvSeqReader prev_elem(BytePointer bytepointer);

        public native BytePointer ptr();

        public native CvSeqReader ptr(BytePointer bytepointer);

        public native CvSeq seq();

        public native CvSeqReader seq(CvSeq cvseq);

        static 
        {
            Loader.load();
        }

        public CvSeqReader()
        {
            allocate();
        }

        public CvSeqReader(int i)
        {
            allocateArray(i);
        }

        public CvSeqReader(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSeqWriter extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvSeqBlock block();

        public native CvSeqWriter block(CvSeqBlock cvseqblock);

        public native BytePointer block_max();

        public native CvSeqWriter block_max(BytePointer bytepointer);

        public native BytePointer block_min();

        public native CvSeqWriter block_min(BytePointer bytepointer);

        public native int header_size();

        public native CvSeqWriter header_size(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSeqWriter position(int i)
        {
            return (CvSeqWriter)super.position(i);
        }

        public native BytePointer ptr();

        public native CvSeqWriter ptr(BytePointer bytepointer);

        public native CvSeq seq();

        public native CvSeqWriter seq(CvSeq cvseq);

        static 
        {
            Loader.load();
        }

        public CvSeqWriter()
        {
            allocate();
        }

        public CvSeqWriter(int i)
        {
            allocateArray(i);
        }

        public CvSeqWriter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSet extends CvSeq
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvSet create(int i, int j, int k, CvMemStorage cvmemstorage)
        {
            return opencv_core.cvCreateSet(i, j, k, cvmemstorage);
        }

        public native int active_count();

        public native CvSet active_count(int i);

        public native CvSet free_elems(CvSetElem cvsetelem);

        public native CvSetElem free_elems();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile CvSeq position(int i)
        {
            return position(i);
        }

        public CvSet position(int i)
        {
            return (CvSet)super.position(i);
        }

        public CvSet()
        {
            allocate();
            zero();
        }

        public CvSet(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvSet(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSetElem extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int flags();

        public native CvSetElem flags(int i);

        public native CvSetElem next_free();

        public native CvSetElem next_free(CvSetElem cvsetelem);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSetElem position(int i)
        {
            return (CvSetElem)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvSetElem()
        {
            allocate();
        }

        public CvSetElem(int i)
        {
            allocateArray(i);
        }

        public CvSetElem(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSize extends Pointer
    {

        public static final CvSize ZERO = (new CvSize()).width(0).height(0);

        private native void allocate();

        private native void allocateArray(int i);

        public native int height();

        public native CvSize height(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSize position(int i)
        {
            return (CvSize)super.position(i);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(width()).append(", ").append(height()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(width()).append(", ").append(height()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native int width();

        public native CvSize width(int i);

        static 
        {
            Loader.load();
        }

        public CvSize()
        {
            allocate();
        }

        public CvSize(int i)
        {
            allocateArray(i);
        }

        public CvSize(int i, int j)
        {
            allocate();
            width(i).height(j);
        }

        public CvSize(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSize2D32f extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native float height();

        public native CvSize2D32f height(float f);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSize2D32f position(int i)
        {
            return (CvSize2D32f)super.position(i);
        }

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            }
            if (capacity() == 0)
            {
                return (new StringBuilder()).append("(").append(width()).append(", ").append(height()).append(")").toString();
            }
            String s = "";
            int j = position();
            int i = 0;
            while (i < capacity()) 
            {
                position(i);
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (i == 0)
                {
                    s = "(";
                } else
                {
                    s = " (";
                }
                s = stringbuilder.append(s).append(width()).append(", ").append(height()).append(")").toString();
                i++;
            }
            position(j);
            return s;
        }

        public native float width();

        public native CvSize2D32f width(float f);

        static 
        {
            Loader.load();
        }

        public CvSize2D32f()
        {
            allocate();
        }

        public CvSize2D32f(float f, float f1)
        {
            allocate();
            width(f).height(f1);
        }

        public CvSize2D32f(int i)
        {
            allocateArray(i);
        }

        public CvSize2D32f(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSlice extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int end_index();

        public native CvSlice end_index(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSlice position(int i)
        {
            return (CvSlice)super.position(i);
        }

        public native int start_index();

        public native CvSlice start_index(int i);

        static 
        {
            Loader.load();
        }

        public CvSlice()
        {
            allocate();
        }

        public CvSlice(int i)
        {
            allocateArray(i);
        }

        public CvSlice(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSparseMat extends CvArr
    {

        private native void allocate();

        private native void allocateArray(int i);

        public static CvSparseMat create(int i, int ai[], int j)
        {
            ai = opencv_core.cvCreateSparseMat(i, ai, j);
            if (ai != null)
            {
                ai.deallocator(new ReleaseDeallocator(ai));
            }
            return ai;
        }

        public CvSparseMat clone()
        {
            CvSparseMat cvsparsemat = opencv_core.cvCloneSparseMat(this);
            if (cvsparsemat != null)
            {
                cvsparsemat.deallocator(new ReleaseDeallocator(cvsparsemat));
            }
            return cvsparsemat;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public native int dims();

        public native CvSparseMat dims(int i);

        public native int hashsize();

        public native CvSparseMat hashsize(int i);

        public native PointerPointer hashtable();

        public native CvSparseMat hashtable(PointerPointer pointerpointer);

        public native int hdr_refcount();

        public native CvSparseMat hdr_refcount(int i);

        public native CvSet heap();

        public native CvSparseMat heap(CvSet cvset);

        public native int idxoffset();

        public native CvSparseMat idxoffset(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSparseMat position(int i)
        {
            return (CvSparseMat)super.position(i);
        }

        public native IntPointer refcount();

        public native CvSparseMat refcount(IntPointer intpointer);

        public void release()
        {
            deallocate();
        }

        public native int size(int i);

        public native CvSparseMat size(int i, int j);

        public native int type();

        public native CvSparseMat type(int i);

        public native int valoffset();

        public native CvSparseMat valoffset(int i);

        public CvSparseMat()
        {
            allocate();
            zero();
        }

        public CvSparseMat(int i)
        {
            allocateArray(i);
            zero();
        }

        public CvSparseMat(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class CvSparseMat.ReleaseDeallocator extends CvSparseMat
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return super.clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseSparseMat(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        CvSparseMat.ReleaseDeallocator(CvSparseMat cvsparsemat)
        {
            super(cvsparsemat);
        }
    }

    public static class CvSparseMatIterator extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int curidx();

        public native CvSparseMatIterator curidx(int i);

        public native CvSparseMat mat();

        public native CvSparseMatIterator mat(CvSparseMat cvsparsemat);

        public native CvSparseMatIterator node(CvSparseNode cvsparsenode);

        public native CvSparseNode node();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSparseMatIterator position(int i)
        {
            return (CvSparseMatIterator)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvSparseMatIterator()
        {
            allocate();
        }

        public CvSparseMatIterator(int i)
        {
            allocateArray(i);
        }

        public CvSparseMatIterator(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvSparseNode extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int hashval();

        public native CvSparseNode hashval(int i);

        public native CvSparseNode next();

        public native CvSparseNode next(CvSparseNode cvsparsenode);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvSparseNode position(int i)
        {
            return (CvSparseNode)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvSparseNode()
        {
            allocate();
        }

        public CvSparseNode(int i)
        {
            allocateArray(i);
        }

        public CvSparseNode(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvString extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int len();

        public native CvString len(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvString position(int i)
        {
            return (CvString)super.position(i);
        }

        public native BytePointer ptr();

        public native CvString ptr(BytePointer bytepointer);

        static 
        {
            Loader.load();
        }

        public CvString()
        {
            allocate();
        }

        public CvString(int i)
        {
            allocateArray(i);
        }

        public CvString(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvStringHashNode extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int hashval();

        public native CvStringHashNode hashval(int i);

        public native CvStringHashNode next();

        public native CvStringHashNode next(CvStringHashNode cvstringhashnode);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvStringHashNode position(int i)
        {
            return (CvStringHashNode)super.position(i);
        }

        public native CvString str();

        public native CvStringHashNode str(CvString cvstring);

        static 
        {
            Loader.load();
        }

        public CvStringHashNode()
        {
            allocate();
        }

        public CvStringHashNode(int i)
        {
            allocateArray(i);
        }

        public CvStringHashNode(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvTermCriteria extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native double epsilon();

        public native CvTermCriteria epsilon(double d);

        public native int max_iter();

        public native CvTermCriteria max_iter(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvTermCriteria position(int i)
        {
            return (CvTermCriteria)super.position(i);
        }

        public native int type();

        public native CvTermCriteria type(int i);

        static 
        {
            Loader.load();
        }

        public CvTermCriteria()
        {
            allocate();
        }

        public CvTermCriteria(int i)
        {
            allocateArray(i);
        }

        public CvTermCriteria(int i, int j, double d)
        {
            allocate();
            type(i).max_iter(j).epsilon(d);
        }

        public CvTermCriteria(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvTreeNodeIterator extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int level();

        public native CvTreeNodeIterator level(int i);

        public native int max_level();

        public native CvTreeNodeIterator max_level(int i);

        public native Pointer node();

        public native CvTreeNodeIterator node(Pointer pointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvTreeNodeIterator position(int i)
        {
            return (CvTreeNodeIterator)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public CvTreeNodeIterator()
        {
            allocate();
        }

        public CvTreeNodeIterator(int i)
        {
            allocateArray(i);
        }

        public CvTreeNodeIterator(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvTypeInfo extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native CvCloneFunc clone();

        public native CvTypeInfo clone(CvCloneFunc cvclonefunc);

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public native int flags();

        public native CvTypeInfo flags(int i);

        public native int header_size();

        public native CvTypeInfo header_size(int i);

        public native CvIsInstanceFunc is_instance();

        public native CvTypeInfo is_instance(CvIsInstanceFunc cvisinstancefunc);

        public native CvTypeInfo next();

        public native CvTypeInfo next(CvTypeInfo cvtypeinfo);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public CvTypeInfo position(int i)
        {
            return (CvTypeInfo)super.position(i);
        }

        public native CvTypeInfo prev();

        public native CvTypeInfo prev(CvTypeInfo cvtypeinfo);

        public native CvReadFunc read();

        public native CvTypeInfo read(CvReadFunc cvreadfunc);

        public native CvReleaseFunc release();

        public native CvTypeInfo release(CvReleaseFunc cvreleasefunc);

        public native BytePointer type_name();

        public native CvTypeInfo type_name(BytePointer bytepointer);

        public native CvTypeInfo write(CvWriteFunc cvwritefunc);

        public native CvWriteFunc write();

        static 
        {
            Loader.load();
        }

        public CvTypeInfo()
        {
            allocate();
        }

        public CvTypeInfo(int i)
        {
            allocateArray(i);
        }

        public CvTypeInfo(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class CvWriteFunc extends FunctionPointer
    {

        private native void allocate();

        public native void call(CvFileStorage cvfilestorage, String s, Pointer pointer, CvAttrList cvattrlist);

        static 
        {
            Loader.load();
        }

        protected CvWriteFunc()
        {
            allocate();
        }

        public CvWriteFunc(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv_iplAllocateImageData extends FunctionPointer
    {

        private native void allocate();

        public native void call(IplImage iplimage, int i, int j);

        static 
        {
            Loader.load();
        }

        protected Cv_iplAllocateImageData()
        {
            allocate();
        }

        public Cv_iplAllocateImageData(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv_iplCloneImage extends FunctionPointer
    {

        private native void allocate();

        public native IplImage call(IplImage iplimage);

        static 
        {
            Loader.load();
        }

        protected Cv_iplCloneImage()
        {
            allocate();
        }

        public Cv_iplCloneImage(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv_iplCreateImageHeader extends FunctionPointer
    {

        private native void allocate();

        public native IplImage call(int i, int j, int k, BytePointer bytepointer, BytePointer bytepointer1, int l, int i1, 
                int j1, int k1, int l1, IplROI iplroi, IplImage iplimage, Pointer pointer, IplTileInfo ipltileinfo);

        static 
        {
            Loader.load();
        }

        protected Cv_iplCreateImageHeader()
        {
            allocate();
        }

        public Cv_iplCreateImageHeader(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv_iplCreateROI extends FunctionPointer
    {

        private native void allocate();

        public native IplROI call(int i, int j, int k, int l, int i1);

        static 
        {
            Loader.load();
        }

        protected Cv_iplCreateROI()
        {
            allocate();
        }

        public Cv_iplCreateROI(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cv_iplDeallocate extends FunctionPointer
    {

        private native void allocate();

        public native void call(IplImage iplimage, int i);

        static 
        {
            Loader.load();
        }

        protected Cv_iplDeallocate()
        {
            allocate();
        }

        public Cv_iplDeallocate(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static interface InputArray
        extends Annotation
    {
    }

    public static interface InputMat
        extends Annotation
    {
    }

    public static class IntVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native int get(long l, long l1);

        public native IntVectorVector put(long l, long l1, int i);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public IntVectorVector()
        {
            allocate();
        }

        public IntVectorVector(long l)
        {
            allocate(l);
        }

        public IntVectorVector(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class IplImage extends CvArr
    {

        static final boolean $assertionsDisabled;
        public static final byte gamma22[];
        public static final byte gamma22inv[];

        private native void allocate();

        private native void allocateArray(int i);

        public static IplImage create(int i, int j, int k, int l)
        {
            return create(opencv_core.cvSize(i, j), k, l);
        }

        public static IplImage create(int i, int j, int k, int l, int i1)
        {
            IplImage iplimage = create(i, j, k, l);
            if (iplimage != null)
            {
                iplimage.origin(i1);
            }
            return iplimage;
        }

        public static IplImage create(CvSize cvsize, int i, int j)
        {
            cvsize = opencv_core.cvCreateImage(cvsize, i, j);
            if (cvsize != null)
            {
                cvsize.deallocator(new ReleaseDeallocator(cvsize));
            }
            return cvsize;
        }

        public static IplImage create(CvSize cvsize, int i, int j, int k)
        {
            cvsize = create(cvsize, i, j);
            if (cvsize != null)
            {
                cvsize.origin(k);
            }
            return cvsize;
        }

        public static IplImage createCompatible(IplImage iplimage)
        {
            return createIfNotCompatible(null, iplimage);
        }

        public static IplImage createHeader(int i, int j, int k, int l)
        {
            return createHeader(opencv_core.cvSize(i, j), k, l);
        }

        public static IplImage createHeader(int i, int j, int k, int l, int i1)
        {
            IplImage iplimage = createHeader(i, j, k, l);
            if (iplimage != null)
            {
                iplimage.origin(i1);
            }
            return iplimage;
        }

        public static IplImage createHeader(CvSize cvsize, int i, int j)
        {
            cvsize = opencv_core.cvCreateImageHeader(cvsize, i, j);
            if (cvsize != null)
            {
                cvsize.deallocator(new HeaderReleaseDeallocator(cvsize));
            }
            return cvsize;
        }

        public static IplImage createHeader(CvSize cvsize, int i, int j, int k)
        {
            cvsize = createHeader(cvsize, i, j);
            if (cvsize != null)
            {
                cvsize.origin(k);
            }
            return cvsize;
        }

        public static IplImage createIfNotCompatible(IplImage iplimage, IplImage iplimage1)
        {
            IplImage iplimage2;
label0:
            {
                if (iplimage != null && iplimage.width() == iplimage1.width() && iplimage.height() == iplimage1.height() && iplimage.depth() == iplimage1.depth())
                {
                    iplimage2 = iplimage;
                    if (iplimage.nChannels() == iplimage1.nChannels())
                    {
                        break label0;
                    }
                }
                iplimage2 = create(iplimage1.width(), iplimage1.height(), iplimage1.depth(), iplimage1.nChannels(), iplimage1.origin());
            }
            iplimage2.origin(iplimage1.origin());
            return iplimage2;
        }

        public static int decodeGamma22(int i)
        {
            return gamma22[i & 0xff] & 0xff;
        }

        public static int encodeGamma22(int i)
        {
            return gamma22inv[i & 0xff] & 0xff;
        }

        public static void flipCopyWithGamma(ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, int j, boolean flag, double d, boolean flag1, 
                int k)
        {
            if (!$assertionsDisabled && bytebuffer == bytebuffer1)
            {
                throw new AssertionError();
            }
            int j1 = Math.min(i, j);
            int i1 = bytebuffer.position();
            int l = bytebuffer1.position();
            byte abyte0[] = new byte[k];
            while (i1 < bytebuffer.capacity() && l < bytebuffer1.capacity()) 
            {
                int i3;
                if (flag1)
                {
                    bytebuffer.position(bytebuffer.capacity() - i1 - i);
                } else
                {
                    bytebuffer.position(i1);
                }
                bytebuffer1.position(l);
                i3 = Math.min(Math.min(j1, bytebuffer.remaining()), bytebuffer1.remaining());
                if (flag)
                {
                    if (k > 1)
                    {
                        for (j1 = 0; j1 < i3; j1 += k)
                        {
                            int k1 = 0;
                            while (k1 < k) 
                            {
                                int j3 = bytebuffer.get();
                                byte byte0;
                                if (d == 1.0D)
                                {
                                    byte0 = (byte)j3;
                                } else
                                {
                                    byte0 = (byte)(int)Math.round(Math.pow((double)j3 / 127D, d) * 127D);
                                }
                                abyte0[k1] = byte0;
                                k1++;
                            }
                            for (int l1 = k - 1; l1 >= 0; l1--)
                            {
                                bytebuffer1.put(abyte0[l1]);
                            }

                        }

                    } else
                    {
                        j1 = 0;
                        while (j1 < i3) 
                        {
                            int i2 = bytebuffer.get();
                            byte byte1;
                            if (d == 1.0D)
                            {
                                byte1 = (byte)i2;
                            } else
                            {
                                byte1 = (byte)(int)Math.round(Math.pow((double)i2 / 127D, d) * 127D);
                            }
                            bytebuffer1.put(byte1);
                            j1++;
                        }
                    }
                } else
                if (k > 1)
                {
                    for (j1 = 0; j1 < i3; j1 += k)
                    {
                        int j2 = 0;
                        while (j2 < k) 
                        {
                            int k3 = bytebuffer.get() & 0xff;
                            byte byte2;
                            if (d == 1.0D)
                            {
                                byte2 = (byte)k3;
                            } else
                            if (d == 2.2000000000000002D)
                            {
                                byte2 = gamma22[k3];
                            } else
                            if (d == 0.45454545454545453D)
                            {
                                byte2 = gamma22inv[k3];
                            } else
                            {
                                byte2 = (byte)(int)Math.round(Math.pow((double)k3 / 255D, d) * 255D);
                            }
                            abyte0[j2] = byte2;
                            j2++;
                        }
                        for (int k2 = k - 1; k2 >= 0; k2--)
                        {
                            bytebuffer1.put(abyte0[k2]);
                        }

                    }

                } else
                {
                    j1 = 0;
                    while (j1 < i3) 
                    {
                        int l2 = bytebuffer.get() & 0xff;
                        byte byte3;
                        if (d == 1.0D)
                        {
                            byte3 = (byte)l2;
                        } else
                        if (d == 2.2000000000000002D)
                        {
                            byte3 = gamma22[l2];
                        } else
                        if (d == 0.45454545454545453D)
                        {
                            byte3 = gamma22inv[l2];
                        } else
                        {
                            byte3 = (byte)(int)Math.round(Math.pow((double)l2 / 255D, d) * 255D);
                        }
                        bytebuffer1.put(byte3);
                        j1++;
                    }
                }
                i1 += i;
                l += j;
                j1 = i3;
            }
        }

        public static void flipCopyWithGamma(DoubleBuffer doublebuffer, int i, DoubleBuffer doublebuffer1, int j, double d, boolean flag, int k)
        {
            if (!$assertionsDisabled && doublebuffer == doublebuffer1)
            {
                throw new AssertionError();
            }
            int j1 = Math.min(i, j);
            int i1 = doublebuffer.position();
            int l = doublebuffer1.position();
            double ad[] = new double[k];
            while (i1 < doublebuffer.capacity() && l < doublebuffer1.capacity()) 
            {
                int i2;
                if (flag)
                {
                    doublebuffer.position(doublebuffer.capacity() - i1 - i);
                } else
                {
                    doublebuffer.position(i1);
                }
                doublebuffer1.position(l);
                i2 = Math.min(Math.min(j1, doublebuffer.remaining()), doublebuffer1.remaining());
                if (k > 1)
                {
                    for (j1 = 0; j1 < i2; j1 += k)
                    {
                        int k1 = 0;
                        while (k1 < k) 
                        {
                            double d1 = doublebuffer.get();
                            if (d != 1.0D)
                            {
                                d1 = Math.pow(d1, d);
                            }
                            ad[k1] = d1;
                            k1++;
                        }
                        for (int l1 = k - 1; l1 >= 0; l1--)
                        {
                            doublebuffer1.put(ad[l1]);
                        }

                    }

                } else
                {
                    j1 = 0;
                    while (j1 < i2) 
                    {
                        double d2 = doublebuffer.get();
                        if (d != 1.0D)
                        {
                            d2 = Math.pow(d2, d);
                        }
                        doublebuffer1.put(d2);
                        j1++;
                    }
                }
                i1 += i;
                l += j;
                j1 = i2;
            }
        }

        public static void flipCopyWithGamma(FloatBuffer floatbuffer, int i, FloatBuffer floatbuffer1, int j, double d, boolean flag, int k)
        {
            if (!$assertionsDisabled && floatbuffer == floatbuffer1)
            {
                throw new AssertionError();
            }
            int j1 = Math.min(i, j);
            int i1 = floatbuffer.position();
            int l = floatbuffer1.position();
            float af[] = new float[k];
            while (i1 < floatbuffer.capacity() && l < floatbuffer1.capacity()) 
            {
                int i2;
                if (flag)
                {
                    floatbuffer.position(floatbuffer.capacity() - i1 - i);
                } else
                {
                    floatbuffer.position(i1);
                }
                floatbuffer1.position(l);
                i2 = Math.min(Math.min(j1, floatbuffer.remaining()), floatbuffer1.remaining());
                if (k > 1)
                {
                    for (j1 = 0; j1 < i2; j1 += k)
                    {
                        int k1 = 0;
                        while (k1 < k) 
                        {
                            float f = floatbuffer.get();
                            if (d != 1.0D)
                            {
                                f = (float)Math.pow(f, d);
                            }
                            af[k1] = f;
                            k1++;
                        }
                        for (int l1 = k - 1; l1 >= 0; l1--)
                        {
                            floatbuffer1.put(af[l1]);
                        }

                    }

                } else
                {
                    j1 = 0;
                    while (j1 < i2) 
                    {
                        float f1 = floatbuffer.get();
                        if (d != 1.0D)
                        {
                            f1 = (float)Math.pow(f1, d);
                        }
                        floatbuffer1.put(f1);
                        j1++;
                    }
                }
                i1 += i;
                l += j;
                j1 = i2;
            }
        }

        public static void flipCopyWithGamma(IntBuffer intbuffer, int i, IntBuffer intbuffer1, int j, double d, boolean flag, int k)
        {
            if (!$assertionsDisabled && intbuffer == intbuffer1)
            {
                throw new AssertionError();
            }
            int j1 = Math.min(i, j);
            int i1 = intbuffer.position();
            int l = intbuffer1.position();
            int ai[] = new int[k];
            while (i1 < intbuffer.capacity() && l < intbuffer1.capacity()) 
            {
                int k2;
                if (flag)
                {
                    intbuffer.position(intbuffer.capacity() - i1 - i);
                } else
                {
                    intbuffer.position(i1);
                }
                intbuffer1.position(l);
                k2 = Math.min(Math.min(j1, intbuffer.remaining()), intbuffer1.remaining());
                if (k > 1)
                {
                    for (j1 = 0; j1 < k2; j1 += k)
                    {
                        int k1 = 0;
                        while (k1 < k) 
                        {
                            int j2 = intbuffer.get();
                            if (d != 1.0D)
                            {
                                j2 = (int)Math.round(Math.pow((double)j2 / 2147483647D, d) * 2147483647D);
                            }
                            ai[k1] = j2;
                            k1++;
                        }
                        for (int l1 = k - 1; l1 >= 0; l1--)
                        {
                            intbuffer1.put(ai[l1]);
                        }

                    }

                } else
                {
                    j1 = 0;
                    while (j1 < k2) 
                    {
                        int i2 = intbuffer.get();
                        if (d != 1.0D)
                        {
                            i2 = (int)Math.round(Math.pow((double)i2 / 2147483647D, d) * 2147483647D);
                        }
                        intbuffer1.put(i2);
                        j1++;
                    }
                }
                i1 += i;
                l += j;
                j1 = k2;
            }
        }

        public static void flipCopyWithGamma(ShortBuffer shortbuffer, int i, ShortBuffer shortbuffer1, int j, boolean flag, double d, boolean flag1, 
                int k)
        {
            if (!$assertionsDisabled && shortbuffer == shortbuffer1)
            {
                throw new AssertionError();
            }
            int j1 = Math.min(i, j);
            int i1 = shortbuffer.position();
            int l = shortbuffer1.position();
            short aword0[] = new short[k];
            while (i1 < shortbuffer.capacity() && l < shortbuffer1.capacity()) 
            {
                int i3;
                if (flag1)
                {
                    shortbuffer.position(shortbuffer.capacity() - i1 - i);
                } else
                {
                    shortbuffer.position(i1);
                }
                shortbuffer1.position(l);
                i3 = Math.min(Math.min(j1, shortbuffer.remaining()), shortbuffer1.remaining());
                if (flag)
                {
                    if (k > 1)
                    {
                        for (j1 = 0; j1 < i3; j1 += k)
                        {
                            int k1 = 0;
                            while (k1 < k) 
                            {
                                int j3 = shortbuffer.get();
                                short word0;
                                if (d == 1.0D)
                                {
                                    word0 = (short)j3;
                                } else
                                {
                                    word0 = (short)(int)Math.round(Math.pow((double)j3 / 32767D, d) * 32767D);
                                }
                                aword0[k1] = word0;
                                k1++;
                            }
                            for (int l1 = k - 1; l1 >= 0; l1--)
                            {
                                shortbuffer1.put(aword0[l1]);
                            }

                        }

                    } else
                    {
                        j1 = 0;
                        while (j1 < i3) 
                        {
                            int i2 = shortbuffer.get();
                            short word1;
                            if (d == 1.0D)
                            {
                                word1 = (short)i2;
                            } else
                            {
                                word1 = (short)(int)Math.round(Math.pow((double)i2 / 32767D, d) * 32767D);
                            }
                            shortbuffer1.put(word1);
                            j1++;
                        }
                    }
                } else
                if (k > 1)
                {
                    for (j1 = 0; j1 < i3; j1 += k)
                    {
                        int j2 = 0;
                        while (j2 < k) 
                        {
                            int k3 = shortbuffer.get();
                            short word2;
                            if (d == 1.0D)
                            {
                                word2 = (short)k3;
                            } else
                            {
                                word2 = (short)(int)Math.round(Math.pow((double)k3 / 65535D, d) * 65535D);
                            }
                            aword0[j2] = word2;
                            j2++;
                        }
                        for (int k2 = k - 1; k2 >= 0; k2--)
                        {
                            shortbuffer1.put(aword0[k2]);
                        }

                    }

                } else
                {
                    j1 = 0;
                    while (j1 < i3) 
                    {
                        int l2 = shortbuffer.get() & 0xffff;
                        short word3;
                        if (d == 1.0D)
                        {
                            word3 = (short)l2;
                        } else
                        {
                            word3 = (short)(int)Math.round(Math.pow((double)l2 / 65535D, d) * 65535D);
                        }
                        shortbuffer1.put(word3);
                        j1++;
                    }
                }
                i1 += i;
                l += j;
                j1 = i3;
            }
        }

        public native int BorderConst(int i);

        public native IplImage BorderConst(int i, int j);

        public native int BorderMode(int i);

        public native IplImage BorderMode(int i, int j);

        public native int ID();

        public native IplImage ID(int i);

        public native int align();

        public native IplImage align(int i);

        public native int alphaChannel();

        public native IplImage alphaChannel(int i);

        public void applyGamma(double d)
        {
            if (d != 1.0D) goto _L2; else goto _L1
_L1:
            return;
_L2:
            switch (depth())
            {
            default:
                if (!$assertionsDisabled)
                {
                    throw new AssertionError();
                }
                break;

            case 8: // '\b'
                flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), false, d, false, 0);
                return;

            case -2147483640: 
                flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), true, d, false, 0);
                return;

            case 16: // '\020'
                flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, false, d, false, 0);
                return;

            case -2147483632: 
                flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, true, d, false, 0);
                return;

            case -2147483616: 
                flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, d, false, 0);
                return;

            case 32: // ' '
                flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, d, false, 0);
                return;

            case 64: // '@'
                flipCopyWithGamma(getDoubleBuffer(), widthStep() / 8, getDoubleBuffer(), widthStep() / 8, d, false, 0);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public CvMat asCvMat()
        {
            CvMat cvmat = new CvMat();
            opencv_core.cvGetMat(this, cvmat, null, 0);
            return cvmat;
        }

        public native int channelSeq(int i);

        public native IplImage channelSeq(int i, int j);

        public IplImage clone()
        {
            IplImage iplimage = opencv_core.cvCloneImage(this);
            if (iplimage != null)
            {
                iplimage.deallocator(new ReleaseDeallocator(iplimage));
            }
            return iplimage;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public native int colorModel(int i);

        public native IplImage colorModel(int i, int j);

        public CvSize cvSize()
        {
            return opencv_core.cvSize(width(), height());
        }

        public native int dataOrder();

        public native IplImage dataOrder(int i);

        public native int depth();

        public native IplImage depth(int i);

        public ByteBuffer getByteBuffer()
        {
            return getByteBuffer(0);
        }

        public ByteBuffer getByteBuffer(int i)
        {
            return imageData().position(i).capacity(imageSize()).asByteBuffer();
        }

        public DoubleBuffer getDoubleBuffer()
        {
            return getDoubleBuffer(0);
        }

        public DoubleBuffer getDoubleBuffer(int i)
        {
            return getByteBuffer(i * 8).asDoubleBuffer();
        }

        public FloatBuffer getFloatBuffer()
        {
            return getFloatBuffer(0);
        }

        public FloatBuffer getFloatBuffer(int i)
        {
            return getByteBuffer(i * 4).asFloatBuffer();
        }

        public IntBuffer getIntBuffer()
        {
            return getIntBuffer(0);
        }

        public IntBuffer getIntBuffer(int i)
        {
            return getByteBuffer(i * 4).asIntBuffer();
        }

        public ShortBuffer getShortBuffer()
        {
            return getShortBuffer(0);
        }

        public ShortBuffer getShortBuffer(int i)
        {
            return getByteBuffer(i * 2).asShortBuffer();
        }

        public native int height();

        public native IplImage height(int i);

        public double highValue()
        {
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
                                double d = 0.0D;
                                switch (depth())
                                {
                                default:
                                    if (!$assertionsDisabled)
                                    {
                                        throw new AssertionError();
                                    }
                                    break;

                                case -2147483640: 
                                    break label3;

                                case -2147483632: 
                                    break label2;

                                case -2147483616: 
                                    break label1;

                                case 1: // '\001'
                                case 32: // ' '
                                case 64: // '@'
                                    break label0;

                                case 16: // '\020'
                                    break label4;

                                case 8: // '\b'
                                    d = 255D;
                                    break;
                                }
                                return d;
                            }
                            return 65535D;
                        }
                        return 127D;
                    }
                    return 32767D;
                }
                return 2147483647D;
            }
            return 1.0D;
        }

        public native BytePointer imageData();

        public native IplImage imageData(BytePointer bytepointer);

        public native IplImage imageData(ByteBuffer bytebuffer);

        public native BytePointer imageDataOrigin();

        public native IplImage imageDataOrigin(BytePointer bytepointer);

        public native Pointer imageId();

        public native IplImage imageId(Pointer pointer);

        public native int imageSize();

        public native IplImage imageSize(int i);

        public native IplImage maskROI();

        public native IplImage maskROI(IplImage iplimage);

        public native int nChannels();

        public native IplImage nChannels(int i);

        public native int nSize();

        public native IplImage nSize(int i);

        public native int origin();

        public native IplImage origin(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public IplImage position(int i)
        {
            return (IplImage)super.position(i);
        }

        public void release()
        {
            deallocate();
        }

        public native IplImage roi(IplROI iplroi);

        public native IplROI roi();

        public native IplImage tileInfo(IplTileInfo ipltileinfo);

        public native IplTileInfo tileInfo();

        public String toString()
        {
            if (isNull())
            {
                return super.toString();
            } else
            {
                return (new StringBuilder()).append("IplImage[width=").append(width()).append(",height=").append(height()).append(",depth=").append(depth()).append(",nChannels=").append(nChannels()).append("]").toString();
            }
        }

        public native int width();

        public native IplImage width(int i);

        public native int widthStep();

        public native IplImage widthStep(int i);

        static 
        {
            boolean flag;
            if (!com/googlecode/javacv/cpp/opencv_core.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
            gamma22 = new byte[256];
            gamma22inv = new byte[256];
            for (int i = 0; i < 256; i++)
            {
                gamma22[i] = (byte)(int)Math.round(Math.pow((double)i / 255D, 2.2000000000000002D) * 255D);
                gamma22inv[i] = (byte)(int)Math.round(Math.pow((double)i / 255D, 0.45454545454545453D) * 255D);
            }

        }

        public IplImage()
        {
            allocate();
            zero();
        }

        public IplImage(int i)
        {
            allocateArray(i);
            zero();
        }

        public IplImage(Pointer pointer)
        {
            super(pointer);
        }
    }

    protected static class IplImage.HeaderReleaseDeallocator extends IplImage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return super.clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseImageHeader(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        IplImage.HeaderReleaseDeallocator(IplImage iplimage)
        {
            super(iplimage);
        }
    }

    protected static class IplImage.ReleaseDeallocator extends IplImage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return super.clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseImage(this);
        }

        public volatile Pointer position(int i)
        {
            return super.position(i);
        }

        IplImage.ReleaseDeallocator(IplImage iplimage)
        {
            super(iplimage);
        }
    }

    public static class IplImageArray extends CvArrArray
    {

        private native void allocateArray(int i);

        public volatile CvArr get()
        {
            return get();
        }

        public native IplImage get();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public volatile CvArrArray position(int i)
        {
            return position(i);
        }

        public IplImageArray position(int i)
        {
            return (IplImageArray)super.position(i);
        }

        public volatile CvArrArray put(CvArr cvarr)
        {
            return put(cvarr);
        }

        public volatile CvArrArray put(CvArr acvarr[])
        {
            return put(acvarr);
        }

        public IplImageArray put(CvArr cvarr)
        {
            if (cvarr instanceof IplImage)
            {
                return (IplImageArray)super.put(cvarr);
            } else
            {
                throw new ArrayStoreException(cvarr.getClass().getName());
            }
        }

        public transient IplImageArray put(CvArr acvarr[])
        {
            return (IplImageArray)super.put(acvarr);
        }

        public IplImageArray(int i)
        {
            super(new CvArr[0]);
            allocateArray(i);
        }

        public IplImageArray(Pointer pointer)
        {
            super(pointer);
        }

        public transient IplImageArray(IplImage aiplimage[])
        {
            this(aiplimage.length);
            put(aiplimage);
            position(0);
        }
    }

    public static class IplROI extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int coi();

        public native IplROI coi(int i);

        public native int height();

        public native IplROI height(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public IplROI position(int i)
        {
            return (IplROI)super.position(i);
        }

        public native int width();

        public native IplROI width(int i);

        public native int xOffset();

        public native IplROI xOffset(int i);

        public native int yOffset();

        public native IplROI yOffset(int i);

        static 
        {
            Loader.load();
        }

        public IplROI()
        {
            allocate();
        }

        public IplROI(int i)
        {
            allocateArray(i);
        }

        public IplROI(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class IplTileInfo extends Pointer
    {

        static 
        {
            Loader.load();
        }

        public IplTileInfo()
        {
        }

        public IplTileInfo(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class KDTree extends Pointer
    {

        private native void allocate();

        private native void allocate(CvMat cvmat, CvMat cvmat1, boolean flag);

        private native void allocate(CvMat cvmat, boolean flag);

        public native void build(CvMat cvmat, CvMat cvmat1, boolean flag);

        public native void build(CvMat cvmat, boolean flag);

        public native int dims();

        public native int findNearest(FloatPointer floatpointer, int i, int j, IntPointer intpointer, CvMat cvmat, FloatPointer floatpointer1, IntPointer intpointer1);

        public native int findNearest(CvMat cvmat, int i, int j, CvMat cvmat1, CvMat cvmat2, CvMat cvmat3, CvMat cvmat4);

        public native void findOrthoRange(FloatPointer floatpointer, FloatPointer floatpointer1, IntPointer intpointer, CvMat cvmat, IntPointer intpointer1);

        public native void findOrthoRange(CvMat cvmat, CvMat cvmat1, CvMat cvmat2, CvMat cvmat3, CvMat cvmat4);

        public native FloatPointer getPoint(int i, int ai[]);

        public native void getPoints(FloatPointer floatpointer, CvMat cvmat, IntPointer intpointer);

        public native void getPoints(CvMat cvmat, CvMat cvmat1, CvMat cvmat2);

        public native IntPointer labels();

        public native KDTree labels(IntPointer intpointer);

        public native int maxDepth();

        public native KDTree maxDepth(int i);

        public native Node nodes();

        public native KDTree nodes(Node node);

        public native int normType();

        public native KDTree normType(int i);

        public native CvMat points();

        public native KDTree points(CvMat cvmat);

        static 
        {
            Loader.load();
        }

        public KDTree()
        {
            allocate();
        }

        public KDTree(Pointer pointer)
        {
            super(pointer);
        }

        public KDTree(CvMat cvmat, CvMat cvmat1, boolean flag)
        {
            allocate(cvmat, cvmat1, flag);
        }

        public KDTree(CvMat cvmat, boolean flag)
        {
            allocate(cvmat, flag);
        }
    }

    public static class KDTree.Node extends Pointer
    {

        private native void allocate();

        private native void allocate(int i, int j, int k, float f);

        private native void allocateArray(int i);

        public native float boundary();

        public native KDTree.Node boundary(float f);

        public native int idx();

        public native KDTree.Node idx(int i);

        public native int left();

        public native KDTree.Node left(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public KDTree.Node position(int i)
        {
            return (KDTree.Node)super.position(i);
        }

        public native int right();

        public native KDTree.Node right(int i);

        static 
        {
            Loader.load();
        }

        public KDTree.Node()
        {
            allocate();
        }

        public KDTree.Node(int i)
        {
            allocateArray(i);
        }

        public KDTree.Node(int i, int j, int k, float f)
        {
            allocate(i, j, k, f);
        }

        public KDTree.Node(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class MatVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native CvMat getCvMat(long l);

        public native CvMatND getCvMatND(long l);

        public native IplImage getIplImage(long l);

        public native MatVector put(long l, CvArr cvarr);

        public transient MatVector put(CvArr acvarr[])
        {
            if (size() < (long)acvarr.length)
            {
                resize(acvarr.length);
            }
            for (int i = 0; i < acvarr.length; i++)
            {
                put(i, acvarr[i]);
            }

            return this;
        }

        public native void resize(long l);

        public native long size();

        static 
        {
            Loader.load();
        }

        public MatVector()
        {
            allocate();
        }

        public MatVector(long l)
        {
            allocate(l);
        }

        public MatVector(Pointer pointer)
        {
            super(pointer);
        }

        public transient MatVector(CvArr acvarr[])
        {
            this(acvarr.length);
            put(acvarr);
        }
    }

    public static interface OutputArray
        extends Annotation
    {
    }

    public static interface OutputMat
        extends Annotation
    {
    }

    public static class Param extends Pointer
    {

        public static final int ALGORITHM = 6;
        public static final int BOOLEAN = 1;
        public static final int FLOAT = 7;
        public static final int INT = 0;
        public static final int MAT = 4;
        public static final int MAT_VECTOR = 5;
        public static final int REAL = 2;
        public static final int SHORT = 10;
        public static final int STRING = 3;
        public static final int UCHAR = 11;
        public static final int UINT64 = 9;
        public static final int UNSIGNED_INT = 8;

        private native void allocate();

        private native void allocate(int i, boolean flag, int j, Algorithm.Getter getter1, Algorithm.Setter setter1, String s);

        public native Algorithm.Getter getter();

        public native Param getter(Algorithm.Getter getter1);

        public native Param help(String s);

        public native String help();

        public native int offset();

        public native Param offset(int i);

        public native Param readonly(boolean flag);

        public native boolean readonly();

        public native Algorithm.Setter setter();

        public native Param setter(Algorithm.Setter setter1);

        public native int type();

        public native Param type(int i);

        static 
        {
            Loader.load();
        }

        public Param()
        {
            allocate();
        }

        public Param(int i, boolean flag, int j, Algorithm.Getter getter1, Algorithm.Setter setter1, String s)
        {
            allocate(i, flag, j, getter1, setter1, s);
        }

        public Param(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Point2dVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native CvPoint2D32f get(long l, long l1);

        public native Point2dVectorVector put(long l, long l1, CvPoint2D32f cvpoint2d32f);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public Point2dVectorVector()
        {
            allocate();
        }

        public Point2dVectorVector(long l)
        {
            allocate(l);
        }

        public Point2dVectorVector(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Point2fVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native CvPoint2D32f get(long l, long l1);

        public native Point2fVectorVector put(long l, long l1, CvPoint2D32f cvpoint2d32f);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public Point2fVectorVector()
        {
            allocate();
        }

        public Point2fVectorVector(long l)
        {
            allocate(l);
        }

        public Point2fVectorVector(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class PointVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native CvPoint get(long l, long l1);

        public native PointVectorVector put(long l, long l1, CvPoint cvpoint);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public PointVectorVector()
        {
            allocate();
        }

        public PointVectorVector(long l)
        {
            allocate(l);
        }

        public PointVectorVector(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Predicate extends FunctionPointer
    {

        private native void allocate();

        public native boolean call(Pointer pointer, Pointer pointer1);

        static 
        {
            Loader.load();
        }

        protected Predicate()
        {
            allocate();
        }

        public Predicate(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static interface Ptr
        extends Annotation
    {

        public abstract String value();
    }

    public static class RectVectorVector extends Pointer
    {

        private native void allocate();

        private native void allocate(long l);

        public native CvRect get(long l, long l1);

        public native RectVectorVector put(long l, long l1, CvRect cvrect);

        public native void resize(long l);

        public native void resize(long l, long l1);

        public native long size();

        public native long size(long l);

        static 
        {
            Loader.load();
        }

        public RectVectorVector()
        {
            allocate();
        }

        public RectVectorVector(long l)
        {
            allocate(l);
        }

    