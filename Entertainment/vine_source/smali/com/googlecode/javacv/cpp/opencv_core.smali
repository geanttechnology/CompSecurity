.class public Lcom/googlecode/javacv/cpp/opencv_core;
.super Ljava/lang/Object;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Properties;
    value = {
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            include = {
                "<opencv2/core/core.hpp>",
                "opencv_adapters.h"
            }
            link = {
                "opencv_core@.2.4"
            }
            preload = {
                "tbb"
            }
        .end subannotation,
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            define = {
                "_WIN32_WINNT 0x0502"
            }
            includepath = {
                "C:/opencv/build/include/"
            }
            link = {
                "opencv_core246"
            }
            preload = {
                "msvcr100",
                "msvcp100"
            }
            value = {
                "windows"
            }
        .end subannotation,
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            linkpath = {
                "C:/opencv/build/x86/vc10/lib/"
            }
            preloadpath = {
                "C:/opencv/build/x86/vc10/bin/"
            }
            value = {
                "windows-x86"
            }
        .end subannotation,
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            linkpath = {
                "C:/opencv/build/x64/vc10/lib/"
            }
            preloadpath = {
                "C:/opencv/build/x64/vc10/bin/"
            }
            value = {
                "windows-x86_64"
            }
        .end subannotation
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$Predicate;,
        Lcom/googlecode/javacv/cpp/opencv_core$Param;,
        Lcom/googlecode/javacv/cpp/opencv_core$AlgorithmInfo;,
        Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;,
        Lcom/googlecode/javacv/cpp/opencv_core$KDTree;,
        Lcom/googlecode/javacv/cpp/opencv_core$RectVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$Point2dVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$Point2fVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$PointVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$IntVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$ByteVectorVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$MatVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$StringVector;,
        Lcom/googlecode/javacv/cpp/opencv_core$Ptr;,
        Lcom/googlecode/javacv/cpp/opencv_core$OutputMat;,
        Lcom/googlecode/javacv/cpp/opencv_core$InputMat;,
        Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$InputArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvErrorCallback;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCloneImage;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCreateROI;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplDeallocate;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplAllocateImageData;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCreateImageHeader;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvFreeFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvAllocFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvTreeNodeIterator;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvFont;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvGraphScanner;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvCmpFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvModuleInfo;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPluginFuncInfo;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvTypeInfo;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvCloneFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvWriteFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvReadFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvReleaseFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvIsInstanceFunc;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvFileNodeHash;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvStringHashNode;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvString;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvContour;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvChain;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx2D;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSet;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMemStoragePos;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMemBlock;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvLineIterator;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSize;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvRect;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMatIterator;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMat;,
        Lcom/googlecode/javacv/cpp/opencv_core$IplROI;,
        Lcom/googlecode/javacv/cpp/opencv_core$IplTileInfo;,
        Lcom/googlecode/javacv/cpp/opencv_core$IplImage;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv64suf;,
        Lcom/googlecode/javacv/cpp/opencv_core$Cv32suf;,
        Lcom/googlecode/javacv/cpp/opencv_core$IplImageArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMatNDArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvMatArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;,
        Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field public static final CV_16S:I = 0x3

.field public static final CV_16SC1:I

.field public static final CV_16SC2:I

.field public static final CV_16SC3:I

.field public static final CV_16SC4:I

.field public static final CV_16U:I = 0x2

.field public static final CV_16UC1:I

.field public static final CV_16UC2:I

.field public static final CV_16UC3:I

.field public static final CV_16UC4:I

.field public static final CV_32F:I = 0x5

.field public static final CV_32FC1:I

.field public static final CV_32FC2:I

.field public static final CV_32FC3:I

.field public static final CV_32FC4:I

.field public static final CV_32S:I = 0x4

.field public static final CV_32SC1:I

.field public static final CV_32SC2:I

.field public static final CV_32SC3:I

.field public static final CV_32SC4:I

.field public static final CV_64F:I = 0x6

.field public static final CV_64FC1:I

.field public static final CV_64FC2:I

.field public static final CV_64FC3:I

.field public static final CV_64FC4:I

.field public static final CV_8S:I = 0x1

.field public static final CV_8SC1:I

.field public static final CV_8SC2:I

.field public static final CV_8SC3:I

.field public static final CV_8SC4:I

.field public static final CV_8U:I = 0x0

.field public static final CV_8UC1:I

.field public static final CV_8UC2:I

.field public static final CV_8UC3:I

.field public static final CV_8UC4:I

.field public static final CV_AA:I = 0x10

.field public static final CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

.field public static final CV_AUTOSTEP:I = 0x7fffffff

.field public static final CV_AUTO_STEP:I = 0x7fffffff

.field public static final CV_BACK:I = 0x0

.field public static final CV_BadAlign:I = -0x15

.field public static final CV_BadAlphaChannel:I = -0x12

.field public static final CV_BadCOI:I = -0x18

.field public static final CV_BadCallBack:I = -0x16

.field public static final CV_BadDataPtr:I = -0xc

.field public static final CV_BadDepth:I = -0x11

.field public static final CV_BadImageSize:I = -0xa

.field public static final CV_BadModelOrChSeq:I = -0xe

.field public static final CV_BadNumChannel1U:I = -0x10

.field public static final CV_BadNumChannels:I = -0xf

.field public static final CV_BadOffset:I = -0xb

.field public static final CV_BadOrder:I = -0x13

.field public static final CV_BadOrigin:I = -0x14

.field public static final CV_BadROISize:I = -0x19

.field public static final CV_BadStep:I = -0xd

.field public static final CV_BadTileSize:I = -0x17

.field public static final CV_C:I = 0x1

.field public static final CV_CHECK_QUIET:I = 0x2

.field public static final CV_CHECK_RANGE:I = 0x1

.field public static final CV_CHOLESKY:I = 0x3

.field public static final CV_CMP_EQ:I = 0x0

.field public static final CV_CMP_GE:I = 0x2

.field public static final CV_CMP_GT:I = 0x1

.field public static final CV_CMP_LE:I = 0x4

.field public static final CV_CMP_LT:I = 0x3

.field public static final CV_CMP_NE:I = 0x5

.field public static final CV_CN_MAX:I = 0x200

.field public static final CV_CN_SHIFT:I = 0x3

.field public static final CV_COVAR_COLS:I = 0x10

.field public static final CV_COVAR_NORMAL:I = 0x1

.field public static final CV_COVAR_ROWS:I = 0x8

.field public static final CV_COVAR_SCALE:I = 0x4

.field public static final CV_COVAR_SCRAMBLED:I = 0x0

.field public static final CV_COVAR_USE_AVG:I = 0x2

.field public static final CV_CPU_AVX:I = 0xa

.field public static final CV_CPU_MMX:I = 0x1

.field public static final CV_CPU_NONE:I = 0x0

.field public static final CV_CPU_POPCNT:I = 0x8

.field public static final CV_CPU_SSE:I = 0x2

.field public static final CV_CPU_SSE2:I = 0x3

.field public static final CV_CPU_SSE3:I = 0x4

.field public static final CV_CPU_SSE4_1:I = 0x6

.field public static final CV_CPU_SSE4_2:I = 0x7

.field public static final CV_CPU_SSSE3:I = 0x5

.field public static final CV_DEPTH_MAX:I = 0x8

.field public static final CV_DIFF:I = 0x10

.field public static final CV_DIFF_C:I = 0x11

.field public static final CV_DIFF_L1:I = 0x12

.field public static final CV_DIFF_L2:I = 0x14

.field public static final CV_DXT_FORWARD:I = 0x0

.field public static final CV_DXT_INVERSE:I = 0x1

.field public static final CV_DXT_INVERSE_SCALE:I = 0x3

.field public static final CV_DXT_INV_SCALE:I = 0x3

.field public static final CV_DXT_MUL_CONJ:I = 0x8

.field public static final CV_DXT_ROWS:I = 0x4

.field public static final CV_DXT_SCALE:I = 0x2

.field public static final CV_ErrModeLeaf:I = 0x0

.field public static final CV_ErrModeParent:I = 0x1

.field public static final CV_ErrModeSilent:I = 0x2

.field public static final CV_FILLED:I = -0x1

.field public static final CV_FONT_HERSHEY_COMPLEX:I = 0x3

.field public static final CV_FONT_HERSHEY_COMPLEX_SMALL:I = 0x5

.field public static final CV_FONT_HERSHEY_DUPLEX:I = 0x2

.field public static final CV_FONT_HERSHEY_PLAIN:I = 0x1

.field public static final CV_FONT_HERSHEY_SCRIPT_COMPLEX:I = 0x7

.field public static final CV_FONT_HERSHEY_SCRIPT_SIMPLEX:I = 0x6

.field public static final CV_FONT_HERSHEY_SIMPLEX:I = 0x0

.field public static final CV_FONT_HERSHEY_TRIPLEX:I = 0x4

.field public static final CV_FONT_ITALIC:I = 0x10

.field public static final CV_FONT_VECTOR0:I = 0x0

.field public static final CV_FRONT:I = 0x1

.field public static final CV_GEMM_A_T:I = 0x1

.field public static final CV_GEMM_B_T:I = 0x2

.field public static final CV_GEMM_C_T:I = 0x4

.field public static final CV_GRAPH:I = 0x1000

.field public static final CV_GRAPH_ALL_ITEMS:I = -0x1

.field public static final CV_GRAPH_ANY_EDGE:I = 0x1e

.field public static final CV_GRAPH_BACKTRACKING:I = 0x40

.field public static final CV_GRAPH_BACK_EDGE:I = 0x4

.field public static final CV_GRAPH_CROSS_EDGE:I = 0x10

.field public static final CV_GRAPH_FLAG_ORIENTED:I = 0x4000

.field public static final CV_GRAPH_FORWARD_EDGE:I = 0x8

.field public static final CV_GRAPH_FORWARD_EDGE_FLAG:I = 0x10000000

.field public static final CV_GRAPH_ITEM_VISITED_FLAG:I = 0x40000000

.field public static final CV_GRAPH_NEW_TREE:I = 0x20

.field public static final CV_GRAPH_OVER:I = -0x1

.field public static final CV_GRAPH_SEARCH_TREE_NODE_FLAG:I = 0x20000000

.field public static final CV_GRAPH_TREE_EDGE:I = 0x2

.field public static final CV_GRAPH_VERTEX:I = 0x1

.field public static final CV_GpuApiCallError:I = -0xd9

.field public static final CV_GpuNotSupported:I = -0xd8

.field public static final CV_HARDWARE_MAX_FEATURE:I = 0xff

.field public static final CV_HeaderIsNull:I = -0x9

.field public static final CV_KMEANS_USE_INITIAL_LABELS:I = 0x1

.field public static final CV_L1:I = 0x2

.field public static final CV_L2:I = 0x4

.field public static final CV_LSQ:I = 0x8

.field public static final CV_LU:I = 0x0

.field public static final CV_MAGIC_MASK:I = -0x10000

.field public static final CV_MAJOR_VERSION:I = 0x2

.field public static final CV_MATND_MAGIC_VAL:I = 0x42430000

.field public static final CV_MAT_CN_MASK:I = 0xff8

.field public static final CV_MAT_CONT_FLAG:I = 0x4000

.field public static final CV_MAT_CONT_FLAG_SHIFT:I = 0xe

.field public static final CV_MAT_DEPTH_MASK:I = 0x7

.field public static final CV_MAT_MAGIC_VAL:I = 0x42420000

.field public static final CV_MAT_TEMP_FLAG:I = 0x8000

.field public static final CV_MAT_TEMP_FLAG_SHIFT:I = 0xf

.field public static final CV_MAT_TYPE_MASK:I = 0xfff

.field public static final CV_MAX_ARR:I = 0xa

.field public static final CV_MAX_DIM:I = 0x20

.field public static final CV_MAX_DIM_HEAP:I = 0x400

.field public static final CV_MINMAX:I = 0x20

.field public static final CV_MINOR_VERSION:I = 0x4

.field public static final CV_MaskIsTiled:I = -0x1a

.field public static final CV_NODE_EMPTY:I = 0x20

.field public static final CV_NODE_FLOAT:I = 0x2

.field public static final CV_NODE_FLOW:I = 0x8

.field public static final CV_NODE_INT:I = 0x1

.field public static final CV_NODE_INTEGER:I = 0x1

.field public static final CV_NODE_MAP:I = 0x6

.field public static final CV_NODE_NAMED:I = 0x40

.field public static final CV_NODE_NONE:I = 0x0

.field public static final CV_NODE_REAL:I = 0x2

.field public static final CV_NODE_REF:I = 0x4

.field public static final CV_NODE_SEQ:I = 0x5

.field public static final CV_NODE_SEQ_SIMPLE:I = 0x100

.field public static final CV_NODE_STR:I = 0x3

.field public static final CV_NODE_STRING:I = 0x3

.field public static final CV_NODE_TYPE_MASK:I = 0x7

.field public static final CV_NODE_USER:I = 0x10

.field public static final CV_NORMAL:I = 0x10

.field public static final CV_NORM_MASK:I = 0x7

.field public static final CV_NO_CN_CHECK:I = 0x2

.field public static final CV_NO_DEPTH_CHECK:I = 0x1

.field public static final CV_NO_SIZE_CHECK:I = 0x4

.field public static final CV_ORIENTED_GRAPH:I = 0x5000

.field public static final CV_OpenGlApiCallError:I = -0xdb

.field public static final CV_OpenGlNotSupported:I = -0xda

.field public static final CV_PCA_DATA_AS_COL:I = 0x1

.field public static final CV_PCA_DATA_AS_ROW:I = 0x0

.field public static final CV_PCA_USE_AVG:I = 0x2

.field public static final CV_QR:I = 0x4

.field public static final CV_RAND_NORMAL:I = 0x1

.field public static final CV_RAND_UNI:I = 0x0

.field public static final CV_REDUCE_AVG:I = 0x1

.field public static final CV_REDUCE_MAX:I = 0x2

.field public static final CV_REDUCE_MIN:I = 0x3

.field public static final CV_REDUCE_SUM:I = 0x0

.field public static final CV_RELATIVE:I = 0x8

.field public static final CV_RELATIVE_C:I = 0x9

.field public static final CV_RELATIVE_L1:I = 0xa

.field public static final CV_RELATIVE_L2:I = 0xc

.field public static final CV_RNG_COEFF:J = 0xf83f630aL

.field public static final CV_SEQ_CHAIN:I

.field public static final CV_SEQ_CHAIN_CONTOUR:I

.field public static final CV_SEQ_CONNECTED_COMP:I = 0x0

.field public static final CV_SEQ_CONTOUR:I

.field public static final CV_SEQ_ELTYPE_BITS:I = 0xc

.field public static final CV_SEQ_ELTYPE_CODE:I

.field public static final CV_SEQ_ELTYPE_CONNECTED_COMP:I = 0x0

.field public static final CV_SEQ_ELTYPE_GENERIC:I = 0x0

.field public static final CV_SEQ_ELTYPE_GRAPH_EDGE:I = 0x0

.field public static final CV_SEQ_ELTYPE_GRAPH_VERTEX:I = 0x0

.field public static final CV_SEQ_ELTYPE_INDEX:I

.field public static final CV_SEQ_ELTYPE_MASK:I = 0xfff

.field public static final CV_SEQ_ELTYPE_POINT:I

.field public static final CV_SEQ_ELTYPE_POINT3D:I

.field public static final CV_SEQ_ELTYPE_PPOINT:I = 0x7

.field public static final CV_SEQ_ELTYPE_PTR:I = 0x7

.field public static final CV_SEQ_ELTYPE_TRIAN_ATR:I = 0x0

.field public static final CV_SEQ_FLAG_CLOSED:I = 0x4000

.field public static final CV_SEQ_FLAG_CONVEX:I = 0x0

.field public static final CV_SEQ_FLAG_HOLE:I = 0x8000

.field public static final CV_SEQ_FLAG_SHIFT:I = 0xe

.field public static final CV_SEQ_FLAG_SIMPLE:I = 0x0

.field public static final CV_SEQ_INDEX:I

.field public static final CV_SEQ_KIND_BIN_TREE:I = 0x2000

.field public static final CV_SEQ_KIND_BITS:I = 0x2

.field public static final CV_SEQ_KIND_CURVE:I = 0x1000

.field public static final CV_SEQ_KIND_GENERIC:I = 0x0

.field public static final CV_SEQ_KIND_GRAPH:I = 0x1000

.field public static final CV_SEQ_KIND_MASK:I = 0x3000

.field public static final CV_SEQ_KIND_SUBDIV2D:I = 0x2000

.field public static final CV_SEQ_MAGIC_VAL:I = 0x42990000

.field public static final CV_SEQ_POINT3D_SET:I

.field public static final CV_SEQ_POINT_SET:I

.field public static final CV_SEQ_POLYGON:I

.field public static final CV_SEQ_POLYGON_TREE:I = 0x2000

.field public static final CV_SEQ_POLYLINE:I

.field public static final CV_SEQ_SIMPLE_POLYGON:I

.field public static final CV_SET_ELEM_FREE_FLAG:I = 0x80

.field public static final CV_SET_ELEM_IDX_MASK:I = 0x3ffffff

.field public static final CV_SET_MAGIC_VAL:I = 0x42980000

.field public static final CV_SORT_ASCENDING:I = 0x0

.field public static final CV_SORT_DESCENDING:I = 0x10

.field public static final CV_SORT_EVERY_COLUMN:I = 0x1

.field public static final CV_SORT_EVERY_ROW:I = 0x0

.field public static final CV_SPARSE_MAT_MAGIC_VAL:I = 0x42440000

.field public static final CV_STORAGE_APPEND:I = 0x2

.field public static final CV_STORAGE_FORMAT_AUTO:I = 0x0

.field public static final CV_STORAGE_FORMAT_MASK:I = 0x38

.field public static final CV_STORAGE_FORMAT_XML:I = 0x8

.field public static final CV_STORAGE_FORMAT_YAML:I = 0x10

.field public static final CV_STORAGE_MAGIC_VAL:I = 0x42890000

.field public static final CV_STORAGE_MEMORY:I = 0x4

.field public static final CV_STORAGE_READ:I = 0x0

.field public static final CV_STORAGE_WRITE:I = 0x1

.field public static final CV_STORAGE_WRITE_BINARY:I = 0x1

.field public static final CV_STORAGE_WRITE_TEXT:I = 0x1

.field public static final CV_SUBMINOR_VERSION:I = 0x6

.field public static final CV_SVD:I = 0x1

.field public static final CV_SVD_MODIFY_A:I = 0x1

.field public static final CV_SVD_SYM:I = 0x2

.field public static final CV_SVD_U_T:I = 0x2

.field public static final CV_SVD_V_T:I = 0x4

.field public static final CV_StsAssert:I = -0xd7

.field public static final CV_StsAutoTrace:I = -0x8

.field public static final CV_StsBackTrace:I = -0x1

.field public static final CV_StsBadArg:I = -0x5

.field public static final CV_StsBadFlag:I = -0xce

.field public static final CV_StsBadFunc:I = -0x6

.field public static final CV_StsBadMask:I = -0xd0

.field public static final CV_StsBadMemBlock:I = -0xd6

.field public static final CV_StsBadPoint:I = -0xcf

.field public static final CV_StsBadSize:I = -0xc9

.field public static final CV_StsDivByZero:I = -0xca

.field public static final CV_StsError:I = -0x2

.field public static final CV_StsFilterOffsetErr:I = -0x1f

.field public static final CV_StsFilterStructContentErr:I = -0x1d

.field public static final CV_StsInplaceNotSupported:I = -0xcb

.field public static final CV_StsInternal:I = -0x3

.field public static final CV_StsKernelStructContentErr:I = -0x1e

.field public static final CV_StsNoConv:I = -0x7

.field public static final CV_StsNoMem:I = -0x4

.field public static final CV_StsNotImplemented:I = -0xd5

.field public static final CV_StsNullPtr:I = -0x1b

.field public static final CV_StsObjectNotFound:I = -0xcc

.field public static final CV_StsOk:I = 0x0

.field public static final CV_StsOutOfRange:I = -0xd3

.field public static final CV_StsParseError:I = -0xd4

.field public static final CV_StsUnmatchedFormats:I = -0xcd

.field public static final CV_StsUnmatchedSizes:I = -0xd1

.field public static final CV_StsUnsupportedFormat:I = -0xd2

.field public static final CV_StsVecLengthErr:I = -0x1c

.field public static final CV_TERMCRIT_EPS:I = 0x2

.field public static final CV_TERMCRIT_ITER:I = 0x1

.field public static final CV_TERMCRIT_NUMBER:I = 0x1

.field public static final CV_TYPE_NAME_GRAPH:Ljava/lang/String; = "opencv-graph"

.field public static final CV_TYPE_NAME_IMAGE:Ljava/lang/String; = "opencv-image"

.field public static final CV_TYPE_NAME_MAT:Ljava/lang/String; = "opencv-matrix"

.field public static final CV_TYPE_NAME_MATND:Ljava/lang/String; = "opencv-nd-matrix"

.field public static final CV_TYPE_NAME_SEQ:Ljava/lang/String; = "opencv-sequence"

.field public static final CV_TYPE_NAME_SEQ_TREE:Ljava/lang/String; = "opencv-sequence-tree"

.field public static final CV_TYPE_NAME_SPARSE_MAT:Ljava/lang/String; = "opencv-sparse-matrix"

.field public static final CV_USRTYPE1:I = 0x7

.field public static final CV_VERSION:Ljava/lang/String; = "2.4.6.1"

.field public static final CV_VERSION_EPOCH:I = 0x2

.field public static final CV_VERSION_MAJOR:I = 0x4

.field public static final CV_VERSION_MINOR:I = 0x6

.field public static final CV_VERSION_REVISION:I = 0x1

.field public static final CV_WHOLE_ARR:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

.field public static final CV_WHOLE_SEQ:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

.field public static final CV_WHOLE_SEQ_END_INDEX:I = 0x3fffffff

.field public static final IPL_ALIGN_16BYTES:I = 0x10

.field public static final IPL_ALIGN_32BYTES:I = 0x20

.field public static final IPL_ALIGN_4BYTES:I = 0x4

.field public static final IPL_ALIGN_8BYTES:I = 0x8

.field public static final IPL_ALIGN_DWORD:I = 0x4

.field public static final IPL_ALIGN_QWORD:I = 0x8

.field public static final IPL_BORDER_CONSTANT:I = 0x0

.field public static final IPL_BORDER_REFLECT:I = 0x2

.field public static final IPL_BORDER_REFLECT_101:I = 0x4

.field public static final IPL_BORDER_REPLICATE:I = 0x1

.field public static final IPL_BORDER_TRANSPARENT:I = 0x5

.field public static final IPL_BORDER_WRAP:I = 0x3

.field public static final IPL_DATA_ORDER_PIXEL:I = 0x0

.field public static final IPL_DATA_ORDER_PLANE:I = 0x1

.field public static final IPL_DEPTH_16S:I = -0x7ffffff0

.field public static final IPL_DEPTH_16U:I = 0x10

.field public static final IPL_DEPTH_1U:I = 0x1

.field public static final IPL_DEPTH_32F:I = 0x20

.field public static final IPL_DEPTH_32S:I = -0x7fffffe0

.field public static final IPL_DEPTH_64F:I = 0x40

.field public static final IPL_DEPTH_8S:I = -0x7ffffff8

.field public static final IPL_DEPTH_8U:I = 0x8

.field public static final IPL_DEPTH_SIGN:I = -0x80000000

.field public static final IPL_IMAGE_DATA:I = 0x2

.field public static final IPL_IMAGE_HEADER:I = 0x1

.field public static final IPL_IMAGE_MAGIC_VAL:I

.field public static final IPL_IMAGE_ROI:I = 0x4

.field public static final IPL_ORIGIN_BL:I = 0x1

.field public static final IPL_ORIGIN_TL:I = 0x0

.field public static final NORM_HAMMING:I = 0x6

.field public static final NORM_HAMMING2:I = 0x7

.field public static final NORM_INF:I = 0x1

.field public static final NORM_L1:I = 0x2

.field public static final NORM_L2:I = 0x4

.field public static final NORM_L2SQR:I = 0x5

.field public static final NORM_MINMAX:I = 0x20

.field public static final NORM_RELATIVE:I = 0x8

.field public static final NORM_TYPE_MASK:I = 0x7


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v2, 0x1

    .line 105
    const-class v1, Lcom/googlecode/javacv/cpp/opencv_core;

    invoke-virtual {v1}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v1

    if-nez v1, :cond_1

    move v1, v2

    :goto_0
    sput-boolean v1, Lcom/googlecode/javacv/cpp/opencv_core;->$assertionsDisabled:Z

    .line 114
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 115
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->getPlatformName()Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "platformName":Ljava/lang/String;
    const-string v1, "windows-x86"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 117
    const-string v1, "C:/opencv/build/x86/vc10/bin/"

    invoke-static {v1}, Lcom/googlecode/javacv/cpp/opencv_core;->SetLibraryPath(Ljava/lang/String;)V

    .line 926
    :cond_0
    :goto_1
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    move v1, v3

    :goto_2
    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->IPL_IMAGE_MAGIC_VAL:I

    .line 966
    invoke-static {v3, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8UC1:I

    .line 967
    invoke-static {v3, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8UC2:I

    .line 968
    invoke-static {v3, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8UC3:I

    .line 969
    invoke-static {v3, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8UC4:I

    .line 971
    invoke-static {v2, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8SC1:I

    .line 972
    invoke-static {v2, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8SC2:I

    .line 973
    invoke-static {v2, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8SC3:I

    .line 974
    invoke-static {v2, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8SC4:I

    .line 976
    invoke-static {v4, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16UC1:I

    .line 977
    invoke-static {v4, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16UC2:I

    .line 978
    invoke-static {v4, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16UC3:I

    .line 979
    invoke-static {v4, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16UC4:I

    .line 981
    invoke-static {v5, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16SC1:I

    .line 982
    invoke-static {v5, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16SC2:I

    .line 983
    invoke-static {v5, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16SC3:I

    .line 984
    invoke-static {v5, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_16SC4:I

    .line 986
    invoke-static {v6, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC1:I

    .line 987
    invoke-static {v6, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC2:I

    .line 988
    invoke-static {v6, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC3:I

    .line 989
    invoke-static {v6, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC4:I

    .line 991
    const/4 v1, 0x5

    invoke-static {v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC1:I

    .line 992
    const/4 v1, 0x5

    invoke-static {v1, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC2:I

    .line 993
    const/4 v1, 0x5

    invoke-static {v1, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC3:I

    .line 994
    const/4 v1, 0x5

    invoke-static {v1, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC4:I

    .line 996
    const/4 v1, 0x6

    invoke-static {v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_64FC1:I

    .line 997
    const/4 v1, 0x6

    invoke-static {v1, v4}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_64FC2:I

    .line 998
    const/4 v1, 0x6

    invoke-static {v1, v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_64FC3:I

    .line 999
    const/4 v1, 0x6

    invoke-static {v1, v6}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v1

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_64FC4:I

    .line 1002
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_4

    const/4 v1, 0x0

    :goto_3
    sput-object v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_WHOLE_ARR:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    .line 2384
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_5

    const/4 v1, 0x0

    :goto_4
    sput-object v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_WHOLE_SEQ:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    .line 2769
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC2:I

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_POINT:I

    .line 2770
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8UC1:I

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_CODE:I

    .line 2774
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC1:I

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_INDEX:I

    .line 2779
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC3:I

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_POINT3D:I

    .line 2808
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_POINT:I

    or-int/lit8 v1, v1, 0x0

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POINT_SET:I

    .line 2809
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_POINT3D:I

    or-int/lit8 v1, v1, 0x0

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POINT3D_SET:I

    .line 2810
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_POINT:I

    or-int/lit16 v1, v1, 0x1000

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POLYLINE:I

    .line 2811
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POLYLINE:I

    or-int/lit16 v1, v1, 0x4000

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POLYGON:I

    .line 2812
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POLYGON:I

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_CONTOUR:I

    .line 2813
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_POLYGON:I

    or-int/lit8 v1, v1, 0x0

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_SIMPLE_POLYGON:I

    .line 2816
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_CODE:I

    or-int/lit16 v1, v1, 0x1000

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_CHAIN:I

    .line 2817
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_CHAIN:I

    or-int/lit16 v1, v1, 0x4000

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_CHAIN_CONTOUR:I

    .line 2826
    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_INDEX:I

    or-int/lit8 v1, v1, 0x0

    sput v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_INDEX:I

    .line 3008
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-direct {v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;-><init>()V

    sput-object v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    return-void

    .end local v0    # "platformName":Ljava/lang/String;
    :cond_1
    move v1, v3

    .line 105
    goto/16 :goto_0

    .line 118
    .restart local v0    # "platformName":Ljava/lang/String;
    :cond_2
    const-string v1, "windows-x86_64"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 119
    const-string v1, "C:/opencv/build/x64/vc10/bin/"

    invoke-static {v1}, Lcom/googlecode/javacv/cpp/opencv_core;->SetLibraryPath(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 926
    :cond_3
    const-class v1, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v1

    goto/16 :goto_2

    .line 1002
    :cond_4
    const v1, 0x3fffffff    # 1.9999999f

    invoke-static {v3, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSlice(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    move-result-object v1

    goto :goto_3

    .line 2384
    :cond_5
    const v1, 0x3fffffff    # 1.9999999f

    invoke-static {v3, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSlice(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    move-result-object v1

    goto :goto_4
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4662
    return-void
.end method

.method public static CV_16SC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 960
    const/4 v0, 0x3

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_16UC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 959
    const/4 v0, 0x0

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_32FC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 962
    const/4 v0, 0x5

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_32SC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 961
    const/4 v0, 0x4

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_64FC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 963
    const/4 v0, 0x6

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_8SC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 958
    const/4 v0, 0x1

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_8UC(I)I
    .locals 1
    .param p0, "n"    # I

    .prologue
    .line 957
    const/4 v0, 0x0

    invoke-static {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_ARE_CNS_EQ(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 2
    .param p0, "mat1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p1, "mat2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 1458
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v1

    xor-int/2addr v0, v1

    and-int/lit16 v0, v0, 0xff8

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_ARE_DEPTHS_EQ(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 2
    .param p0, "mat1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p1, "mat2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 1461
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v1

    xor-int/2addr v0, v1

    and-int/lit8 v0, v0, 0x7

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_ARE_SIZES_EQ(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 2
    .param p0, "mat1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p1, "mat2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 1464
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows()I

    move-result v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols()I

    move-result v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols()I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_ARE_TYPES_EQ(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 2
    .param p0, "mat1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p1, "mat2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 1455
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v1

    xor-int/2addr v0, v1

    and-int/lit16 v0, v0, 0xfff

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_CURRENT_POINT(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .locals 2
    .param p0, "reader"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;

    .prologue
    .line 2939
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;->ptr()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-object v0
.end method

.method public static CV_ELEM_SIZE(I)I
    .locals 3
    .param p0, "type"    # I

    .prologue
    .line 1473
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_CN(I)I

    move-result v0

    const-class v1, Lcom/googlecode/javacpp/SizeTPointer;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v1

    div-int/lit8 v1, v1, 0x4

    add-int/lit8 v1, v1, 0x1

    mul-int/lit16 v1, v1, 0x4000

    or-int/lit16 v1, v1, 0x3a50

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    shr-int/2addr v1, v2

    and-int/lit8 v1, v1, 0x3

    shl-int/2addr v0, v1

    return v0
.end method

.method public static CV_ELEM_SIZE1(I)I
    .locals 2
    .param p0, "type"    # I

    .prologue
    .line 1470
    const-class v0, Lcom/googlecode/javacpp/SizeTPointer;

    invoke-static {v0}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v0

    shl-int/lit8 v0, v0, 0x1c

    const v1, 0x8442211

    or-int/2addr v0, v1

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v1

    mul-int/lit8 v1, v1, 0x4

    shr-int/2addr v0, v1

    and-int/lit8 v0, v0, 0xf

    return v0
.end method

.method public static CV_IS_CONT_MAT(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 1014
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_MAT_CONT(I)Z

    move-result v0

    return v0
.end method

.method public static CV_IS_GRAPH(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2873
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SET(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/16 v1, 0x1000

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_GRAPH_EDGE_VISITED(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Z
    .locals 2
    .param p0, "vtx"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    .prologue
    .line 3818
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->flags()I

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_GRAPH_ORIENTED(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2876
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    and-int/lit16 v0, v0, 0x4000

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_GRAPH_VERTEX_VISITED(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)Z
    .locals 2
    .param p0, "edge"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    .prologue
    .line 3821
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->flags()I

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_IMAGE(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 1
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 933
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_IMAGE_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->imageData()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_IMAGE_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 930
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->nSize()I

    move-result v0

    const-class v1, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MASK_ARR(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 2
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 1452
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v0

    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_8SC1:I

    xor-int/lit8 v1, v1, -0x1

    and-int/lit16 v1, v1, 0xfff

    and-int/2addr v0, v1

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MAT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 1
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1449
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_MAT_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->data_ptr()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MATND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 1
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1572
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_MATND_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->data_ptr()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MATND_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1569
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->type()I

    move-result v0

    const/high16 v1, -0x10000

    and-int/2addr v0, v1

    const/high16 v1, 0x42430000    # 48.75f

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MAT_CONST(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Z
    .locals 3
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    const/4 v0, 0x1

    .line 1467
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows()I

    move-result v1

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols()I

    move-result v2

    or-int/2addr v1, v2

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MAT_CONT(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 1013
    and-int/lit16 v0, p0, 0x4000

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MAT_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 3
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1439
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 1440
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    if-eqz p0, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v1

    const/high16 v2, -0x10000

    and-int/2addr v1, v2

    const/high16 v2, 0x42420000    # 48.5f

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows()I

    move-result v1

    if-lez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static CV_IS_MAT_HDR_Z(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 3
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1444
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 1445
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    if-eqz p0, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type()I

    move-result v1

    const/high16 v2, -0x10000

    and-int/2addr v1, v2

    const/high16 v2, 0x42420000    # 48.5f

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols()I

    move-result v1

    if-ltz v1, :cond_0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows()I

    move-result v1

    if-ltz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 2829
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    const/high16 v1, -0x10000

    and-int/2addr v0, v1

    const/high16 v1, 0x42990000    # 76.5f

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_CHAIN(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 3
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    const/4 v0, 0x1

    .line 2860
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v1

    const/16 v2, 0x1000

    if-ne v1, v2, :cond_0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->elem_size()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_CHAIN_CONTOUR(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2866
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_CHAIN(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_CLOSED(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_CLOSED(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2842
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    and-int/lit16 v0, v0, 0x4000

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_CONTOUR(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2863
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_CLOSED(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_POLYLINE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_CHAIN(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_CONVEX(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2843
    const/4 v0, 0x0

    return v0
.end method

.method public static CV_IS_SEQ_CURVE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2841
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/16 v1, 0x1000

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_HOLE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2844
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    const v1, 0x8000

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_INDEX(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2838
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE_INDEX:I

    if-ne v0, v1, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_POINT_SET(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2848
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32SC2:I

    if-eq v0, v1, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    sget v1, Lcom/googlecode/javacv/cpp/opencv_core;->CV_32FC2:I

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_POINT_SUBSET(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2851
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_INDEX(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_POLYGON(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2857
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_POLYLINE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_CLOSED(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_POLYGON_TREE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2869
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/16 v1, 0x2000

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_POLYLINE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2854
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/16 v1, 0x1000

    if-ne v0, v1, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SEQ_POINT_SET(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SEQ_SIMPLE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2845
    const/4 v0, 0x1

    return v0
.end method

.method public static CV_IS_SET(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "set"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 2832
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->flags()I

    move-result v0

    const/high16 v1, -0x10000

    and-int/2addr v0, v1

    const/high16 v1, 0x42980000    # 76.0f

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SET_ELEM(Lcom/googlecode/javacpp/Pointer;)Z
    .locals 1
    .param p0, "ptr"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2654
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags()I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SPARSE_MAT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 1
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1630
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SPARSE_MAT_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    return v0
.end method

.method public static CV_IS_SPARSE_MAT_HDR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 1627
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->type()I

    move-result v0

    const/high16 v1, -0x10000

    and-int/2addr v0, v1

    const/high16 v1, 0x42440000    # 49.0f

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_STORAGE(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z
    .locals 2
    .param p0, "storage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 2536
    if-eqz p0, :cond_0

    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->signature()I

    move-result v0

    const/high16 v1, -0x10000

    and-int/2addr v0, v1

    const/high16 v1, 0x42890000    # 68.5f

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_SUBDIV2D(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2879
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SET(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I

    move-result v0

    const/16 v1, 0x2000

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_IS_TEMP_MAT(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 1015
    const v0, 0x8000

    and-int/2addr v0, p0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_MAKETYPE(II)I
    .locals 2
    .param p0, "depth"    # I
    .param p1, "cn"    # I

    .prologue
    .line 954
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v0

    add-int/lit8 v1, p1, -0x1

    shl-int/lit8 v1, v1, 0x3

    add-int/2addr v0, v1

    return v0
.end method

.method public static CV_MAKE_TYPE(II)I
    .locals 1
    .param p0, "depth"    # I
    .param p1, "cn"    # I

    .prologue
    .line 955
    invoke-static {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAKETYPE(II)I

    move-result v0

    return v0
.end method

.method public static CV_MAT_CN(I)I
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 1011
    and-int/lit16 v0, p0, 0xff8

    shr-int/lit8 v0, v0, 0x3

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public static CV_MAT_DEPTH(I)I
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 952
    and-int/lit8 v0, p0, 0x7

    return v0
.end method

.method public static CV_MAT_TYPE(I)I
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 1012
    and-int/lit16 v0, p0, 0xfff

    return v0
.end method

.method public static CV_NEXT_GRAPH_EDGE(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
    .locals 3
    .param p0, "edge"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
    .param p1, "vertex"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 2949
    sget-boolean v2, Lcom/googlecode/javacv/cpp/opencv_core;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    invoke-virtual {p0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->vtx(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->vtx(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 2950
    :cond_0
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->vtx(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->next(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    move-result-object v0

    return-object v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public static native CV_NEXT_LINE_POINT(Lcom/googlecode/javacv/cpp/opencv_core$CvLineIterator;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvLineIterator;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native CV_NEXT_SEQ_ELEM(ILcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static CV_NODE_HAS_NAME(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 3045
    and-int/lit8 v0, p0, 0x40

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IDX(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;)Lcom/googlecode/javacpp/IntPointer;
    .locals 3
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    .param p1, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;

    .prologue
    .line 1670
    new-instance v0, Lcom/googlecode/javacpp/IntPointer;

    new-instance v1, Lcom/googlecode/javacpp/BytePointer;

    invoke-direct {v1, p1}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->idxoffset()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/googlecode/javacpp/IntPointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-object v0
.end method

.method public static CV_NODE_IS_COLLECTION(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    .line 3041
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v0

    const/4 v1, 0x5

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_EMPTY(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 3043
    and-int/lit8 v0, p0, 0x20

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_FLOW(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 3042
    and-int/lit8 v0, p0, 0x8

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_INT(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    const/4 v0, 0x1

    .line 3036
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_MAP(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    .line 3040
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_REAL(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    .line 3037
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_SEQ(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    .line 3039
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_STRING(I)Z
    .locals 2
    .param p0, "flags"    # I

    .prologue
    .line 3038
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_TYPE(I)I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_IS_USER(I)Z
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 3044
    and-int/lit8 v0, p0, 0x10

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_SEQ_IS_SIMPLE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)Z
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 3046
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    and-int/lit16 v0, v0, 0x100

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static CV_NODE_TYPE(I)I
    .locals 1
    .param p0, "flags"    # I

    .prologue
    .line 3035
    and-int/lit8 v0, p0, 0x7

    return v0
.end method

.method public static CV_NODE_VAL(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;)Lcom/googlecode/javacpp/Pointer;
    .locals 2
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    .param p1, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;

    .prologue
    .line 1667
    new-instance v0, Lcom/googlecode/javacpp/BytePointer;

    invoke-direct {v0, p1}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->valoffset()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    return-object v0
.end method

.method public static CV_PREV_POINT(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .locals 2
    .param p0, "reader"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;

    .prologue
    .line 2940
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;->prev_elem()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-object v0
.end method

.method public static native CV_PREV_SEQ_ELEM(ILcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static CV_READ_EDGE(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
    .locals 2
    .param p0, "pt1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p1, "pt2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "reader"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;

    .prologue
    .line 2942
    sget-boolean v0, Lcom/googlecode/javacv/cpp/opencv_core;->$assertionsDisabled:Z

    if-nez v0, :cond_0

    invoke-virtual {p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;->seq()Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->elem_size()I

    move-result v0

    const-class v1, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 2943
    :cond_0
    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_PREV_POINT(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-result-object p0

    .line 2944
    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_CURRENT_POINT(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-result-object p1

    .line 2945
    invoke-virtual {p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;->ptr()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;->prev_elem(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;

    .line 2946
    const-class v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-static {v0}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v0

    invoke-static {v0, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NEXT_SEQ_ELEM(ILcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V

    .line 2947
    return-void
.end method

.method public static native CV_READ_SEQ_ELEM(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native CV_REV_READ_SEQ_ELEM(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 8
    .param p0, "r"    # D
    .param p2, "g"    # D
    .param p4, "b"    # D

    .prologue
    .line 3870
    const-wide/16 v6, 0x0

    move-wide v0, p4

    move-wide v2, p2

    move-wide v4, p0

    invoke-static/range {v0 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->cvScalar(DDDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public static CV_SEQ_ELTYPE(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2835
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    and-int/lit16 v0, v0, 0xfff

    return v0
.end method

.method public static CV_SEQ_KIND(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    .prologue
    .line 2836
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->flags()I

    move-result v0

    and-int/lit16 v0, v0, 0x3000

    return v0
.end method

.method public static native CV_WRITE_SEQ_ELEM(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native CV_WRITE_SEQ_ELEM_VAR(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static IPL2CV_DEPTH(I)I
    .locals 3
    .param p0, "depth"    # I

    .prologue
    .line 1476
    const v1, 0x43160520

    and-int/lit16 v0, p0, 0xf0

    shr-int/lit8 v2, v0, 0x2

    const/high16 v0, -0x80000000

    and-int/2addr v0, p0

    if-eqz v0, :cond_0

    const/16 v0, 0x14

    :goto_0
    add-int/2addr v0, v2

    shr-int v0, v1, v0

    and-int/lit8 v0, v0, 0xf

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static native SetLibraryPath(Ljava/lang/String;)V
.end method

.method public static native batchDistance(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;ILcom/googlecode/javacv/cpp/opencv_core$CvMat;IILcom/googlecode/javacv/cpp/opencv_core$CvArr;IZ)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p7    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p9    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
        value = "cv"
    .end annotation
.end method

.method public static cvAXPY(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 1
    .param p0, "A"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "real_scalar"    # D
    .param p3, "B"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p4, "C"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3415
    invoke-static {p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRealScalar(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    invoke-static {p0, v0, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core;->cvScaleAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3416
    return-void
.end method

.method public static cvAbs(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 2
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3446
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvScalarAll(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvAbsDiffS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V

    .line 3447
    return-void
.end method

.method public static native cvAbsDiff(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvAbsDiffS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvAddS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvAddWeighted(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;DDLcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvAlloc(J)Lcom/googlecode/javacpp/Pointer;
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method

.method public static native cvAnd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvAndS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvAttrList()Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;
    .locals 1

    .prologue
    .line 3013
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;-><init>()V

    return-object v0
.end method

.method public static cvAttrList(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;
    .locals 1
    .param p0, "attr"    # Lcom/googlecode/javacpp/PointerPointer;
    .param p1, "next"    # Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    .prologue
    .line 3010
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;->attr(Lcom/googlecode/javacpp/PointerPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;->next(Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    move-result-object v0

    return-object v0
.end method

.method public static native cvAttrValue(Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public static native cvAvg(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvAvgSdv(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvBackProjectPCA(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvCalcCovarMatrix(Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static cvCalcCovarMatrix([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
    .locals 1
    .param p0, "vects"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "count"    # I
    .param p2, "cov_mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p3, "avg"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p4, "flags"    # I

    .prologue
    .line 3573
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;-><init>([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    invoke-static {v0, p1, p2, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCalcCovarMatrix(Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 3574
    return-void
.end method

.method public static native cvCalcPCA(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvCartToPolar(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvCbrt(F)F
.end method

.method public static native cvChangeSeqBlock(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;I)V
.end method

.method public static native cvCheckArr(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IDD)I
.end method

.method public static cvCheckArray(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IDD)I
    .locals 1
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "flags"    # I
    .param p2, "min_val"    # D
    .param p4, "max_val"    # D

    .prologue
    .line 3465
    invoke-static/range {p0 .. p5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCheckArr(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IDD)I

    move-result v0

    return v0
.end method

.method public static native cvCheckHardwareSupport(I)I
.end method

.method public static native cvCheckTermCriteria(Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;DI)Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvCircle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvClearGraph(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;)V
.end method

.method public static native cvClearMemStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)V
.end method

.method public static native cvClearND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[I)V
.end method

.method public static native cvClearSeq(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)V
.end method

.method public static native cvClearSet(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;)V
.end method

.method public static native cvClipLine(Lcom/googlecode/javacv/cpp/opencv_core$CvSize;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;)I
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvClone(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvCloneGraph(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
.end method

.method public static native cvCloneImage(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
.end method

.method public static native cvCloneMat(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvCloneMatND(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public static cvCloneSeq(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .locals 2
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p1, "storage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    .prologue
    .line 3719
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_WHOLE_SEQ:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    const/4 v1, 0x1

    invoke-static {p0, v0, p1, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSeqSlice(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    move-result-object v0

    return-object v0
.end method

.method public static native cvCloneSparseMat(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public static native cvCmp(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvCmpS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvColorToScalar(DI)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvCompleteSymm(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;I)V
.end method

.method public static cvConvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 6
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3394
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvConvertScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V

    .line 3395
    return-void
.end method

.method public static native cvConvertScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V
.end method

.method public static native cvConvertScaleAbs(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V
.end method

.method public static cvCopy(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 1
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3366
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCopy(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3367
    return-void
.end method

.method public static native cvCopy(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvCountNonZero(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)I
.end method

.method public static native cvCreateChildMemStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public static native cvCreateData(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvCreateGraph(IIIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
.end method

.method public static native cvCreateGraphScanner(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphScanner;
.end method

.method public static native cvCreateImage(Lcom/googlecode/javacv/cpp/opencv_core$CvSize;II)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvCreateImageHeader(Lcom/googlecode/javacv/cpp/opencv_core$CvSize;II)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvCreateMat(III)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvCreateMatHeader(III)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvCreateMatND(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public static native cvCreateMatNDHeader(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public static native cvCreateMemStorage(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public static native cvCreateSeq(IJILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method

.method public static native cvCreateSeqBlock(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
.end method

.method public static native cvCreateSet(IIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.end method

.method public static native cvCreateSparseMat(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public static native cvCrossProduct(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static cvCvtScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "scale"    # D
    .param p4, "shift"    # D

    .prologue
    .line 3388
    invoke-static/range {p0 .. p5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvConvertScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V

    .line 3389
    return-void
.end method

.method public static cvCvtScaleAbs(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "scale"    # D
    .param p4, "shift"    # D

    .prologue
    .line 3398
    invoke-static/range {p0 .. p5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvConvertScaleAbs(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V

    .line 3399
    return-void
.end method

.method public static cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p1, "elements"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 3707
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_WHOLE_SEQ:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    return-object v0
.end method

.method public static native cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;)Lcom/googlecode/javacpp/Pointer;
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Ljava/nio/Buffer;)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p0, "seq"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p1, "elements"    # Ljava/nio/Buffer;

    .prologue
    .line 3711
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_WHOLE_SEQ:Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Ljava/nio/Buffer;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    return-object v0
.end method

.method public static native cvCvtSeqToArray(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Ljava/nio/Buffer;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;)Lcom/googlecode/javacpp/Pointer;
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvDCT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvDFT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)V
.end method

.method public static native cvDet(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
.end method

.method public static native cvDiv(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V
.end method

.method public static native cvDotProduct(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
.end method

.method public static cvDrawCircle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "center"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "radius"    # I
    .param p3, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p4, "thickness"    # I
    .param p5, "line_type"    # I
    .param p6, "shift"    # I

    .prologue
    .line 3927
    invoke-static/range {p0 .. p6}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCircle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3928
    return-void
.end method

.method public static cvDrawContours(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 8
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "contour"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p2, "external_color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3, "hole_color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p4, "max_level"    # I
    .param p5, "thickness"    # I
    .param p6, "line_type"    # I

    .prologue
    .line 4028
    sget-object v7, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->ZERO:Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-static/range {v0 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->cvDrawContours(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;IIILcom/googlecode/javacv/cpp/opencv_core$CvPoint;)V

    .line 4029
    return-void
.end method

.method public static native cvDrawContours(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;IIILcom/googlecode/javacv/cpp/opencv_core$CvPoint;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p7    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvDrawEllipse(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;DDDLcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "center"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "axes"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
    .param p3, "angle"    # D
    .param p5, "start_angle"    # D
    .param p7, "end_angle"    # D
    .param p9, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p10, "thickness"    # I
    .param p11, "line_type"    # I
    .param p12, "shift"    # I

    .prologue
    .line 3932
    invoke-static/range {p0 .. p12}, Lcom/googlecode/javacv/cpp/opencv_core;->cvEllipse(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;DDDLcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3934
    return-void
.end method

.method public static cvDrawLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pt1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "pt2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p3, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p4, "thickness"    # I
    .param p5, "line_type"    # I
    .param p6, "shift"    # I

    .prologue
    .line 3923
    invoke-static/range {p0 .. p6}, Lcom/googlecode/javacv/cpp/opencv_core;->cvLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3924
    return-void
.end method

.method public static cvDrawPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pts"    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint**"
            }
        .end annotation
    .end param
    .param p2, "npts"    # [I
    .param p3, "contours"    # I
    .param p4, "is_closed"    # I
    .param p5, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p6, "thickness"    # I
    .param p7, "line_type"    # I
    .param p8, "shift"    # I

    .prologue
    .line 3943
    invoke-static/range {p0 .. p8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3944
    return-void
.end method

.method public static cvDrawPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pts"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p2, "npts"    # [I
    .param p3, "contours"    # I
    .param p4, "is_closed"    # I
    .param p5, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p6, "thickness"    # I
    .param p7, "line_type"    # I
    .param p8, "shift"    # I

    .prologue
    .line 3948
    invoke-static/range {p0 .. p8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3949
    return-void
.end method

.method public static cvDrawPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pts"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "npts"    # [I
    .param p3, "contours"    # I
    .param p4, "is_closed"    # I
    .param p5, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p6, "thickness"    # I
    .param p7, "line_type"    # I
    .param p8, "shift"    # I

    .prologue
    .line 3938
    invoke-static/range {p0 .. p8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3939
    return-void
.end method

.method public static cvDrawRect(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 0
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pt1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "pt2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p3, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p4, "thickness"    # I
    .param p5, "line_type"    # I
    .param p6, "shift"    # I

    .prologue
    .line 3919
    invoke-static/range {p0 .. p6}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRectangle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3920
    return-void
.end method

.method public static native cvEigenVV(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DII)V
.end method

.method public static native cvEllipse(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;DDDLcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p9    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvEllipse2Poly(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;IIILcom/googlecode/javacv/cpp/opencv_core$CvPoint;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvEllipseBox(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 14
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "box"    # Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3, "thickness"    # I
    .param p4, "line_type"    # I
    .param p5, "shift"    # I

    .prologue
    .line 3888
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;->size()Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;

    move-result-object v13

    .line 3889
    .local v13, "size":Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;
    invoke-virtual {v13}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;->width()F

    move-result v0

    float-to-double v0, v0

    const-wide/high16 v3, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v0, v3

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int v0, v0

    invoke-virtual {v13}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;->height()F

    move-result v1

    float-to-double v3, v1

    const-wide/high16 v5, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->round(D)J

    move-result-wide v3

    long-to-int v1, v3

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSize(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSize;

    move-result-object v2

    .line 3890
    .local v2, "axes":Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;->center()Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    move-result-object v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPointFrom32f(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-result-object v1

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvBox2D;->angle()F

    move-result v0

    float-to-double v3, v0

    const-wide/16 v5, 0x0

    const-wide v7, 0x4076800000000000L    # 360.0

    move-object v0, p0

    move-object/from16 v9, p2

    move/from16 v10, p3

    move/from16 v11, p4

    move/from16 v12, p5

    invoke-static/range {v0 .. v12}, Lcom/googlecode/javacv/cpp/opencv_core;->cvEllipse(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;DDDLcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3892
    return-void
.end method

.method public static native cvEndWriteSeq(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
.end method

.method public static native cvEndWriteStruct(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V
.end method

.method public static native cvError(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
.end method

.method public static native cvErrorFromIppStatus(I)I
.end method

.method public static native cvErrorStr(I)Ljava/lang/String;
.end method

.method public static native cvExp(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static cvFFT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "flags"    # I
    .param p3, "nonzero_rows"    # I

    .prologue
    .line 3657
    invoke-static {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvDFT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)V

    .line 3658
    return-void
.end method

.method public static native cvFastArctan(FF)F
.end method

.method public static native cvFillConvexPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvFillConvexPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V
    .param p1    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvFillPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint**"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvFillPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvFillPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V
    .locals 7
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pts"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "npts"    # [I
    .param p3, "contours"    # I
    .param p4, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p5, "line_type"    # I
    .param p6, "shift"    # I

    .prologue
    .line 3899
    new-instance v1, Lcom/googlecode/javacpp/PointerPointer;

    invoke-direct {v1, p1}, Lcom/googlecode/javacpp/PointerPointer;-><init>([Lcom/googlecode/javacpp/Pointer;)V

    move-object v0, p0

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move v5, p5

    move v6, p6

    invoke-static/range {v0 .. v6}, Lcom/googlecode/javacv/cpp/opencv_core;->cvFillPoly(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;II)V

    .line 3900
    return-void
.end method

.method public static native cvFindGraphEdge(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;II)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public static native cvFindGraphEdgeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public static native cvFindType(Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvTypeInfo;
.end method

.method public static native cvFirstType()Lcom/googlecode/javacv/cpp/opencv_core$CvTypeInfo;
.end method

.method public static native cvFlip(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvFlushSeqWriter(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
.end method

.method public static cvFont(DI)Lcom/googlecode/javacv/cpp/opencv_core$CvFont;
    .locals 10
    .param p0, "scale"    # D
    .param p2, "thickness"    # I

    .prologue
    .line 4009
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvFont;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFont;-><init>()V

    .line 4010
    .local v0, "font":Lcom/googlecode/javacv/cpp/opencv_core$CvFont;
    const/4 v1, 0x1

    const-wide/16 v6, 0x0

    const/16 v9, 0x10

    move-wide v2, p0

    move-wide v4, p0

    move v8, p2

    invoke-static/range {v0 .. v9}, Lcom/googlecode/javacv/cpp/opencv_core;->cvInitFont(Lcom/googlecode/javacv/cpp/opencv_core$CvFont;IDDDII)V

    .line 4011
    return-object v0
.end method

.method public static cvFree(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p0, "ptr"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 3220
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvFree_(Lcom/googlecode/javacpp/Pointer;)V

    .line 3221
    invoke-virtual {p0}, Lcom/googlecode/javacpp/Pointer;->setNull()V

    .line 3222
    return-void
.end method

.method public static native cvFree_(Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native cvGEMM(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvGet1D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvGet2D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvGet3D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;III)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static cvGetCol(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .locals 1
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "submat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2, "col"    # I

    .prologue
    .line 3258
    add-int/lit8 v0, p2, 0x1

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetCols(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;II)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    move-result-object v0

    return-object v0
.end method

.method public static native cvGetCols(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;II)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvGetDiag(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvGetDimSize(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)I
.end method

.method public static native cvGetDims(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[I)I
.end method

.method public static native cvGetElemType(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)I
.end method

.method public static native cvGetErrInfo(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;[I)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native cvGetErrMode()I
.end method

.method public static native cvGetErrStatus()I
.end method

.method public static native cvGetFileNode(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacv/cpp/opencv_core$CvStringHashNode;I)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
.end method

.method public static native cvGetFileNodeByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
.end method

.method public static native cvGetFileNodeName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)Ljava/lang/String;
.end method

.method public static cvGetGraphVtx(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
    .locals 2
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .param p1, "idx"    # I

    .prologue
    .line 3794
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    invoke-static {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetSetElem(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;I)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-object v0
.end method

.method public static native cvGetHashedKey(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;II)Lcom/googlecode/javacv/cpp/opencv_core$CvStringHashNode;
.end method

.method public static native cvGetImage(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
.end method

.method public static native cvGetImageCOI(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)I
.end method

.method public static native cvGetImageROI(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvGetMat(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;[II)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvGetModuleInfo(Ljava/lang/String;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)V
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native cvGetND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvGetNextSparseNode(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMatIterator;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;
.end method

.method public static native cvGetNumThreads()I
.end method

.method public static native cvGetOptimalDFTSize(I)I
.end method

.method public static native cvGetRawData(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/BytePointer;[ILcom/googlecode/javacv/cpp/opencv_core$CvSize;)V
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uchar**"
            }
        .end annotation
    .end param
.end method

.method public static native cvGetReal1D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D
.end method

.method public static native cvGetReal2D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)D
.end method

.method public static native cvGetReal3D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;III)D
.end method

.method public static native cvGetRealND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[I)D
.end method

.method public static native cvGetRootFileNode(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;I)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
.end method

.method public static cvGetRow(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .locals 2
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "submat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2, "row"    # I

    .prologue
    .line 3253
    add-int/lit8 v0, p2, 0x1

    const/4 v1, 0x1

    invoke-static {p0, p1, p2, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetRows(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;III)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    move-result-object v0

    return-object v0
.end method

.method public static native cvGetRows(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;III)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvGetSeqElem(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;I)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvGetSeqReaderPos(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)I
.end method

.method public static cvGetSetElem(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;I)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    .locals 2
    .param p0, "set_header"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
    .param p1, "index"    # I

    .prologue
    .line 3764
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    invoke-static {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetSeqElem(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 3765
    .local v0, "elem":Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_IS_SET_ELEM(Lcom/googlecode/javacpp/Pointer;)Z

    move-result v1

    if-eqz v1, :cond_0

    .end local v0    # "elem":Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    :goto_0
    return-object v0

    .restart local v0    # "elem":Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static native cvGetSize(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static cvGetSubArr(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvRect;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .locals 1
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "submat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2, "rect"    # Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param

    .prologue
    .line 3248
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetSubRect(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvRect;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    move-result-object v0

    return-object v0
.end method

.method public static native cvGetSubRect(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvRect;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvGetTextSize(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvFont;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;[I)V
.end method

.method public static native cvGetThreadNum()I
.end method

.method public static native cvGetTickCount()J
.end method

.method public static native cvGetTickFrequency()D
.end method

.method public static native cvGraphAddEdge(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;IILcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)I
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvGraphAddEdgeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)I
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvGraphAddVtx(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)I
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static cvGraphEdgeIdx(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)I
    .locals 2
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .param p1, "edge"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    .prologue
    .line 3796
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->flags()I

    move-result v0

    const v1, 0x3ffffff

    and-int/2addr v0, v1

    return v0
.end method

.method public static cvGraphFindEdge(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;II)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
    .locals 1
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .param p1, "start_idx"    # I
    .param p2, "end_idx"    # I

    .prologue
    .line 3785
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvFindGraphEdge(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;II)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    move-result-object v0

    return-object v0
.end method

.method public static cvGraphFindEdgeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
    .locals 1
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .param p1, "start_vtx"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
    .param p2, "end_vtx"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    .prologue
    .line 3788
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvFindGraphEdgeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    move-result-object v0

    return-object v0
.end method

.method public static cvGraphGetEdgeCount(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;)I
    .locals 1
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    .prologue
    .line 3798
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->edges()Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    move-result-object v0

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->active_count()I

    move-result v0

    return v0
.end method

.method public static cvGraphGetVtxCount(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;)I
    .locals 1
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    .prologue
    .line 3797
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->active_count()I

    move-result v0

    return v0
.end method

.method public static native cvGraphRemoveEdge(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;II)V
.end method

.method public static native cvGraphRemoveEdgeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)V
.end method

.method public static native cvGraphRemoveVtx(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;I)I
.end method

.method public static native cvGraphRemoveVtxByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)I
.end method

.method public static native cvGraphVtxDegree(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;I)I
.end method

.method public static native cvGraphVtxDegreeByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)I
.end method

.method public static cvGraphVtxIdx(Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)I
    .locals 2
    .param p0, "graph"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .param p1, "vtx"    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    .prologue
    .line 3795
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->flags()I

    move-result v0

    const v1, 0x3ffffff

    and-int/2addr v0, v1

    return v0
.end method

.method public static native cvGuiBoxReport(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/googlecode/javacpp/Pointer;)I
.end method

.method public static native cvInRange(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvInRangeS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvInitFont(Lcom/googlecode/javacv/cpp/opencv_core$CvFont;IDDDII)V
.end method

.method public static native cvInitImageHeader(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Lcom/googlecode/javacv/cpp/opencv_core$CvSize;IIII)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvInitLineIterator(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvLineIterator;II)I
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvInitMatHeader(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;IIILcom/googlecode/javacpp/Pointer;I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvInitMatNDHeader(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;I[IILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public static native cvInitNArrayIterator(ILcom/googlecode/javacv/cpp/opencv_core$CvArrArray;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;I)I
.end method

.method public static cvInitNArrayIterator(I[Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;I)I
    .locals 6
    .param p0, "count"    # I
    .param p1, "arrs"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "mask"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p3, "stubs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    .param p4, "array_iterator"    # Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;
    .param p5, "flags"    # I

    .prologue
    .line 3311
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;

    invoke-direct {v1, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;-><init>([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    move v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvInitNArrayIterator(ILcom/googlecode/javacv/cpp/opencv_core$CvArrArray;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;I)I

    move-result v0

    return v0
.end method

.method public static native cvInitSparseMatIterator(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMatIterator;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseNode;
.end method

.method public static native cvInitTreeNodeIterator(Lcom/googlecode/javacv/cpp/opencv_core$CvTreeNodeIterator;Lcom/googlecode/javacpp/Pointer;I)V
.end method

.method public static native cvInsertNodeIntoTree(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static cvInv(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
    .locals 2
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3543
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvInv(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D
    .locals 2
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "method"    # I

    .prologue
    .line 3540
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
    .locals 2
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3537
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D

    move-result-wide v0

    return-wide v0
.end method

.method public static native cvInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D
.end method

.method public static cvIplDepth(I)I
    .locals 3
    .param p0, "type"    # I

    .prologue
    .line 1498
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v0

    .line 1499
    .local v0, "depth":I
    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ELEM_SIZE1(I)I

    move-result v1

    mul-int/lit8 v2, v1, 0x8

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    :cond_0
    const/high16 v1, -0x80000000

    :goto_0
    or-int/2addr v1, v2

    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static native cvKMeans2(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;ILcom/googlecode/javacv/cpp/opencv_core$CvRNG;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;[D)I
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvLUT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvLoad(Ljava/lang/String;)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p0, "filename"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 4246
    invoke-static {p0, v0, v0, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvLoad(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Ljava/lang/String;Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    return-object v0
.end method

.method public static native cvLoad(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Ljava/lang/String;Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/Pointer;
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native cvLog(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvMahalanobis(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
.end method

.method public static cvMahalonobis(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
    .locals 2
    .param p0, "vec1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "vec2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3588
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvMahalanobis(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D

    move-result-wide v0

    return-wide v0
.end method

.method public static native cvMakeSeqHeaderForArray(IIILcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
.end method

.method public static cvMat(IIILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .locals 3
    .param p0, "rows"    # I
    .param p1, "cols"    # I
    .param p2, "type"    # I
    .param p3, "data"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1482
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;-><init>()V

    .line 1484
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    sget-boolean v1, Lcom/googlecode/javacv/cpp/opencv_core;->$assertionsDisabled:Z

    if-nez v1, :cond_1

    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v1

    if-ltz v1, :cond_0

    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_DEPTH(I)I

    move-result v1

    const/4 v2, 0x6

    if-le v1, v2, :cond_1

    :cond_0
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1

    .line 1485
    :cond_1
    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_MAT_TYPE(I)I

    move-result p2

    .line 1486
    const v1, 0x42424000    # 48.5625f

    or-int/2addr v1, p2

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->raw_type(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1487
    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->cols(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1488
    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->rows(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1489
    invoke-static {p2}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ELEM_SIZE(I)I

    move-result v1

    mul-int/2addr v1, p1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->step(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1490
    new-instance v1, Lcom/googlecode/javacpp/BytePointer;

    invoke-direct {v1, p3}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->data_ptr(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1491
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->refcount(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1492
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMat;->hdr_refcount(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .line 1494
    return-object v0
.end method

.method public static cvMatMul(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 1
    .param p0, "src1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "src2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3491
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvMatMulAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3492
    return-void
.end method

.method public static cvMatMulAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 9
    .param p0, "src1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "src2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "src3"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p3, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 3488
    const/4 v8, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move-wide v5, v2

    move-object v7, p3

    invoke-static/range {v0 .. v8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGEMM(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 3489
    return-void
.end method

.method public static cvMatMulAddEx(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
    .locals 0
    .param p0, "srcA"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "srcB"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "alpha"    # D
    .param p4, "srcC"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p5, "beta"    # D
    .param p7, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p8, "tABC"    # I

    .prologue
    .line 3501
    invoke-static/range {p0 .. p8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGEMM(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 3502
    return-void
.end method

.method public static cvMatMulAddS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "transmat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p3, "shiftvec"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;

    .prologue
    .line 3505
    invoke-static {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvTransform(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V

    .line 3506
    return-void
.end method

.method public static native cvMax(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvMaxS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvMemStorageAlloc(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;J)Lcom/googlecode/javacpp/Pointer;
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method

.method public static native cvMemStorageAllocString(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Lcom/googlecode/javacpp/BytePointer;I)Lcom/googlecode/javacv/cpp/opencv_core$CvString;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvMemStorageAllocString(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Ljava/lang/String;I)Lcom/googlecode/javacv/cpp/opencv_core$CvString;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvMerge(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvMin(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static cvMinMaxLoc(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[D[D)V
    .locals 6
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "min_val"    # [D
    .param p2, "max_val"    # [D

    .prologue
    const/4 v5, 0x0

    .line 3601
    move-object v3, v5

    check-cast v3, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-object v4, v5

    check-cast v4, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvMinMaxLoc(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[D[DLcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3602
    return-void
.end method

.method public static native cvMinMaxLoc(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[D[DLcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvMinMaxLoc(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[D[D[I[ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint*"
            }
        .end annotation
    .end param
    .param p4    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint*"
            }
        .end annotation
    .end param
.end method

.method public static native cvMinS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DLcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static cvMirror(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "flip_mode"    # I

    .prologue
    .line 3517
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvFlip(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 3518
    return-void
.end method

.method public static native cvMixChannels(Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;ILcom/googlecode/javacv/cpp/opencv_core$CvArrArray;I[II)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static cvMixChannels([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I[Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I[II)V
    .locals 6
    .param p0, "src"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "src_count"    # I
    .param p2, "dst"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p3, "dst_count"    # I
    .param p4, "from_to"    # [I
    .param p5, "pair_count"    # I

    .prologue
    .line 3381
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;

    invoke-direct {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;-><init>([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;

    invoke-direct {v2, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;-><init>([Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    move v1, p1

    move v3, p3

    move-object v4, p4

    move v5, p5

    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvMixChannels(Lcom/googlecode/javacv/cpp/opencv_core$CvArrArray;ILcom/googlecode/javacv/cpp/opencv_core$CvArrArray;I[II)V

    .line 3382
    return-void
.end method

.method public static native cvMul(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V
.end method

.method public static native cvMulSpectrums(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvMulTransposed(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V
.end method

.method public static native cvNextGraphItem(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphScanner;)I
.end method

.method public static native cvNextNArraySlice(Lcom/googlecode/javacv/cpp/opencv_core$CvNArrayIterator;)I
.end method

.method public static native cvNextTreeNode(Lcom/googlecode/javacv/cpp/opencv_core$CvTreeNodeIterator;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
    .locals 2
    .param p0, "arr1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    const/4 v1, 0x0

    .line 3629
    const/4 v0, 0x4

    invoke-static {p0, v1, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
    .locals 2
    .param p0, "arr1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "arr2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3626
    const/4 v0, 0x4

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)D
    .locals 2
    .param p0, "arr1"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "arr2"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "norm_type"    # I

    .prologue
    .line 3623
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)D

    move-result-wide v0

    return-wide v0
.end method

.method public static native cvNorm(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)D
.end method

.method public static cvNormalize(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 8
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3635
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    const-wide/16 v4, 0x0

    const/4 v6, 0x4

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->cvNormalize(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DDILcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3636
    return-void
.end method

.method public static native cvNormalize(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DDILcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvNot(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvNulDevReport(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/googlecode/javacpp/Pointer;)I
.end method

.method public static native cvOpenFileStorage(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;ILjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
.end method

.method public static native cvOr(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvOrS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvPerspectiveTransform(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
.end method

.method public static cvPoint(II)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .locals 1
    .param p0, "x"    # I
    .param p1, "y"    # I

    .prologue
    .line 1864
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->x(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->y(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    move-result-object v0

    return-object v0
.end method

.method public static cvPoint2D32f(DD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;
    .locals 2
    .param p0, "x"    # D
    .param p2, "y"    # D

    .prologue
    .line 1949
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;-><init>()V

    double-to-float v1, p0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->x(F)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    move-result-object v0

    double-to-float v1, p2

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->y(F)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    move-result-object v0

    return-object v0
.end method

.method public static cvPoint2D64f(DD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;
    .locals 1
    .param p0, "x"    # D
    .param p2, "y"    # D

    .prologue
    .line 2130
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;-><init>()V

    invoke-virtual {v0, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;

    move-result-object v0

    return-object v0
.end method

.method public static cvPoint3D32f(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;
    .locals 2
    .param p0, "x"    # D
    .param p2, "y"    # D
    .param p4, "z"    # D

    .prologue
    .line 2045
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;-><init>()V

    double-to-float v1, p0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;->x(F)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;

    move-result-object v0

    double-to-float v1, p2

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;->y(F)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;

    move-result-object v0

    double-to-float v1, p4

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;->z(F)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D32f;

    move-result-object v0

    return-object v0
.end method

.method public static cvPoint3D64f(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 1
    .param p0, "x"    # D
    .param p2, "y"    # D
    .param p4, "z"    # D

    .prologue
    .line 2217
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;-><init>()V

    invoke-virtual {v0, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {v0, p4, p5}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public static cvPointFrom32f(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .locals 2
    .param p0, "point"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    .prologue
    .line 1955
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;-><init>()V

    .line 1956
    .local v0, "ipt":Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->x()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->x(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    .line 1957
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->y()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->y(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    .line 1958
    return-object v0
.end method

.method public static cvPointTo32f(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;
    .locals 4
    .param p0, "point"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    .prologue
    .line 1952
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->x()I

    move-result v0

    int-to-float v0, v0

    float-to-double v0, v0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->y()I

    move-result v2

    int-to-float v2, v2

    float-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPoint2D32f(DD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    move-result-object v0

    return-object v0
.end method

.method public static native cvPolarToCart(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "CvPoint**"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .locals 9
    .param p0, "img"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "pts"    # [Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .param p2, "npts"    # [I
    .param p3, "contours"    # I
    .param p4, "is_closed"    # I
    .param p5, "color"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p6, "thickness"    # I
    .param p7, "line_type"    # I
    .param p8, "shift"    # I

    .prologue
    .line 3908
    new-instance v1, Lcom/googlecode/javacpp/PointerPointer;

    invoke-direct {v1, p1}, Lcom/googlecode/javacpp/PointerPointer;-><init>([Lcom/googlecode/javacpp/Pointer;)V

    move-object v0, p0

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v5, p5

    move v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    invoke-static/range {v0 .. v8}, Lcom/googlecode/javacv/cpp/opencv_core;->cvPolyLine(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/PointerPointer;[IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V

    .line 3909
    return-void
.end method

.method public static native cvPow(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V
.end method

.method public static native cvPrevTreeNode(Lcom/googlecode/javacv/cpp/opencv_core$CvTreeNodeIterator;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvProjectPCA(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvPtr1D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I[I)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvPtr2D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II[I)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvPtr3D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;III[I)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvPtrND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[I[II[I)Lcom/googlecode/javacpp/Pointer;
    .param p4    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
.end method

.method public static native cvPutText(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvFont;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvRNG()Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;
    .locals 2

    .prologue
    .line 331
    const-wide/16 v0, -0x1

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRNG(J)Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;

    move-result-object v0

    return-object v0
.end method

.method public static cvRNG(J)Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;
    .locals 3
    .param p0, "seed"    # J

    .prologue
    .line 334
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;-><init>()V

    const-wide/16 v1, 0x0

    cmp-long v1, p0, v1

    if-eqz v1, :cond_0

    .end local p0    # "seed":J
    :goto_0
    invoke-virtual {v0, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;->put(J)Lcom/googlecode/javacpp/LongPointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;

    return-object v0

    .restart local p0    # "seed":J
    :cond_0
    const-wide/16 p0, -0x1

    goto :goto_0
.end method

.method public static cvROIToRect(Lcom/googlecode/javacv/cpp/opencv_core$IplROI;)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
    .locals 4
    .param p0, "roi"    # Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .prologue
    .line 1726
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->xOffset()I

    move-result v0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->yOffset()I

    move-result v1

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->width()I

    move-result v2

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->height()I

    move-result v3

    invoke-static {v0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRect(IIII)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    move-result-object v0

    return-object v0
.end method

.method public static native cvRandArr(Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvRandInt(Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;)I
    .locals 8
    .param p0, "rng"    # Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;

    .prologue
    const-wide v6, 0xffffffffL

    .line 337
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;->get()J

    move-result-wide v0

    .line 338
    .local v0, "temp":J
    and-long v2, v0, v6

    const-wide v4, 0xf83f630aL

    mul-long/2addr v2, v4

    const/16 v4, 0x20

    shr-long v4, v0, v4

    and-long/2addr v4, v6

    add-long v0, v2, v4

    .line 339
    invoke-virtual {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;->put(J)Lcom/googlecode/javacpp/LongPointer;

    .line 340
    long-to-int v2, v0

    return v2
.end method

.method public static cvRandReal(Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;)D
    .locals 4
    .param p0, "rng"    # Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;

    .prologue
    .line 343
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRandInt(Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;)I

    move-result v0

    int-to-long v0, v0

    const-wide v2, 0xffffffffL

    and-long/2addr v0, v2

    long-to-double v0, v0

    const-wide/high16 v2, 0x3df0000000000000L    # 2.3283064365386963E-10

    mul-double/2addr v0, v2

    return-wide v0
.end method

.method public static native cvRandShuffle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvRNG;D)V
.end method

.method public static native cvRange(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
.end method

.method public static native cvRawDataToScalar(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
.end method

.method public static cvRead(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    .prologue
    .line 4213
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRead(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    return-object v0
.end method

.method public static native cvRead(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static cvReadByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 4217
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    return-object v0
.end method

.method public static cvReadByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacpp/Pointer;
    .locals 2
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "attributes"    # Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    .prologue
    .line 4220
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetFileNodeByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    move-result-object v0

    .line 4221
    .local v0, "n":Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    invoke-static {p0, v0, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRead(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)Lcom/googlecode/javacpp/Pointer;

    move-result-object v1

    return-object v1
.end method

.method public static cvReadInt(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)I
    .locals 1
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    .prologue
    .line 4163
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadInt(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;I)I

    move-result v0

    return v0
.end method

.method public static cvReadInt(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;I)I
    .locals 2
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p1, "default_value"    # I

    .prologue
    .line 4166
    if-nez p0, :cond_0

    .end local p1    # "default_value":I
    :goto_0
    return p1

    .restart local p1    # "default_value":I
    :cond_0
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->tag()I

    move-result v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_IS_INT(I)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->data_i()I

    move-result p1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->tag()I

    move-result v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_IS_REAL(I)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->data_f()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int p1, v0

    goto :goto_0

    :cond_2
    const p1, 0x7fffffff

    goto :goto_0
.end method

.method public static cvReadIntByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)I
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 4171
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadIntByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static cvReadIntByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;I)I
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "default_value"    # I

    .prologue
    .line 4174
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetFileNodeByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    move-result-object v0

    invoke-static {v0, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadInt(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;I)I

    move-result v0

    return v0
.end method

.method public static native cvReadRawData(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;)V
.end method

.method public static native cvReadRawDataSlice(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;ILcom/googlecode/javacpp/Pointer;Ljava/lang/String;)V
.end method

.method public static cvReadReal(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)D
    .locals 2
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    .prologue
    .line 4177
    const-wide/16 v0, 0x0

    invoke-static {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadReal(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvReadReal(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;D)D
    .locals 1
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p1, "default_value"    # D

    .prologue
    .line 4180
    if-nez p0, :cond_0

    .end local p1    # "default_value":D
    :goto_0
    return-wide p1

    .restart local p1    # "default_value":D
    :cond_0
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->tag()I

    move-result v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_IS_INT(I)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->data_i()I

    move-result v0

    int-to-double p1, v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->tag()I

    move-result v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_IS_REAL(I)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->data_f()D

    move-result-wide p1

    goto :goto_0

    :cond_2
    const-wide p1, 0x7e37e43c8800759cL    # 1.0E300

    goto :goto_0
.end method

.method public static cvReadRealByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)D
    .locals 2
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 4185
    const-wide/16 v0, 0x0

    invoke-static {p0, p1, p2, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadRealByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvReadRealByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;D)D
    .locals 2
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "default_value"    # D

    .prologue
    .line 4188
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetFileNodeByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    move-result-object v0

    invoke-static {v0, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadReal(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public static cvReadString(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)Ljava/lang/String;
    .locals 1
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    .prologue
    .line 4191
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadString(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static cvReadString(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "node"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p1, "default_value"    # Ljava/lang/String;

    .prologue
    .line 4194
    if-nez p0, :cond_0

    .line 4203
    .end local p1    # "default_value":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 4196
    .restart local p1    # "default_value":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->tag()I

    move-result v3

    invoke-static {v3}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_NODE_IS_STRING(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 4197
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;->data_str()Lcom/googlecode/javacv/cpp/opencv_core$CvString;

    move-result-object v2

    .line 4198
    .local v2, "str":Lcom/googlecode/javacv/cpp/opencv_core$CvString;
    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvString;->ptr()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v1

    .line 4199
    .local v1, "pointer":Lcom/googlecode/javacpp/BytePointer;
    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvString;->len()I

    move-result v3

    new-array v0, v3, [B

    .line 4200
    .local v0, "bytes":[B
    invoke-virtual {v1, v0}, Lcom/googlecode/javacpp/BytePointer;->get([B)Lcom/googlecode/javacpp/BytePointer;

    .line 4201
    new-instance p1, Ljava/lang/String;

    .end local p1    # "default_value":Ljava/lang/String;
    invoke-direct {p1, v0}, Ljava/lang/String;-><init>([B)V

    goto :goto_0

    .line 4203
    .end local v0    # "bytes":[B
    .end local v1    # "pointer":Lcom/googlecode/javacpp/BytePointer;
    .end local v2    # "str":Lcom/googlecode/javacv/cpp/opencv_core$CvString;
    .restart local p1    # "default_value":Ljava/lang/String;
    :cond_1
    const/4 p1, 0x0

    goto :goto_0
.end method

.method public static cvReadStringByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 4207
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadStringByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static cvReadStringByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "map"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "default_value"    # Ljava/lang/String;

    .prologue
    .line 4210
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvGetFileNodeByName(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;

    move-result-object v0

    invoke-static {v0, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReadString(Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static cvRealScalar(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 4
    .param p0, "val0"    # D

    .prologue
    const-wide/16 v2, 0x0

    .line 2471
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public static cvRect(IIII)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
    .locals 1
    .param p0, "x"    # I
    .param p1, "y"    # I
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 1714
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->x(I)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->y(I)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->width(I)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->height(I)Lcom/googlecode/javacv/cpp/opencv_core$CvRect;

    move-result-object v0

    return-object v0
.end method

.method public static cvRectToROI(Lcom/googlecode/javacv/cpp/opencv_core$CvRect;I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;
    .locals 2
    .param p0, "rect"    # Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
    .param p1, "coi"    # I

    .prologue
    .line 1717
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;-><init>()V

    .line 1718
    .local v0, "roi":Lcom/googlecode/javacv/cpp/opencv_core$IplROI;
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->x()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->xOffset(I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .line 1719
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->y()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->yOffset(I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .line 1720
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->width()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->width(I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .line 1721
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvRect;->height()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->height(I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .line 1722
    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplROI;->coi(I)Lcom/googlecode/javacv/cpp/opencv_core$IplROI;

    .line 1723
    return-object v0
.end method

.method public static native cvRectangle(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvRectangleR(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvRect;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;III)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvRedirectError(Lcom/googlecode/javacv/cpp/opencv_core$CvErrorCallback;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvErrorCallback;
    .param p2    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
.end method

.method public static native cvReduce(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II)V
.end method

.method public static native cvRegisterModule(Lcom/googlecode/javacv/cpp/opencv_core$CvModuleInfo;)I
.end method

.method public static native cvRegisterType(Lcom/googlecode/javacv/cpp/opencv_core$CvTypeInfo;)V
.end method

.method public static native cvRelease(Lcom/googlecode/javacpp/PointerPointer;)V
.end method

.method public static native cvReleaseData(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvReleaseFileStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseGraphScanner(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphScanner;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvGraphScanner;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseImage(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseImageHeader(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseMat(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseMatND(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseMemStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvReleaseSparseMat(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;)V
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvRemoveNodeFromTree(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native cvRepeat(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvResetImageROI(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
.end method

.method public static native cvReshape(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;II)Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
.end method

.method public static native cvReshapeMatND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;II[I)Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
.end method

.method public static cvReshapeND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;II[I)Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .locals 6
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "header"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "new_cn"    # I
    .param p3, "new_dims"    # I
    .param p4, "new_sizes"    # [I

    .prologue
    .line 3350
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v1

    move-object v0, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReshapeMatND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;II[I)Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    move-result-object v0

    return-object v0
.end method

.method public static native cvRestoreMemStoragePos(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStoragePos;)V
.end method

.method public static native cvSVBkSb(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvSVD(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static cvSave(Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;)V
    .locals 2
    .param p0, "filename"    # Ljava/lang/String;
    .param p1, "struct_ptr"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    const/4 v1, 0x0

    .line 4241
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-static {p0, p1, v1, v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSave(Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V

    .line 4242
    return-void
.end method

.method public static native cvSave(Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSaveMemStoragePos(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStoragePos;)V
.end method

.method public static cvScalar(DDDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 2
    .param p0, "val0"    # D
    .param p2, "val1"    # D
    .param p4, "val2"    # D
    .param p6, "val3"    # D

    .prologue
    .line 2468
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p4, p5}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, p6, p7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public static cvScalarAll(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 2
    .param p0, "val0123"    # D

    .prologue
    .line 2474
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public static native cvScalarToRawData(Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacpp/Pointer;II)V
.end method

.method public static cvScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "scale"    # D
    .param p4, "shift"    # D

    .prologue
    .line 3391
    invoke-static/range {p0 .. p5}, Lcom/googlecode/javacv/cpp/opencv_core;->cvConvertScale(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;DD)V

    .line 3392
    return-void
.end method

.method public static native cvScaleAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSeqElemIdx(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;)I
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvSeqInsert(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvSeqInsertSlice(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;ILcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvSeqInvert(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)V
.end method

.method public static native cvSeqPartition(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvCmpFunc;Lcom/googlecode/javacpp/Pointer;)I
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvSeqPop(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native cvSeqPopFront(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native cvSeqPopMulti(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;II)V
.end method

.method public static native cvSeqPush(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "schar*"
        }
    .end annotation
.end method

.method public static native cvSeqPushFront(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "schar*"
        }
    .end annotation
.end method

.method public static native cvSeqPushMulti(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;II)V
.end method

.method public static native cvSeqRemove(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;I)V
.end method

.method public static native cvSeqRemoveSlice(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSeqSearch(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvCmpFunc;I[ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native cvSeqSlice(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSeqSort(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvCmpFunc;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static cvSet(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .locals 1
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "value"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .prologue
    .line 3370
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSet(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3371
    return-void
.end method

.method public static native cvSet(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSet1D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSet2D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IILcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSet3D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IIILcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSetAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)I
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native cvSetData(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacpp/Pointer;I)V
.end method

.method public static native cvSetErrMode(I)I
.end method

.method public static native cvSetErrStatus(I)V
.end method

.method public static native cvSetIPLAllocators(Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCreateImageHeader;Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplAllocateImageData;Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplDeallocate;Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCreateROI;Lcom/googlecode/javacv/cpp/opencv_core$Cv_iplCloneImage;)V
.end method

.method public static cvSetIdentity(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 2
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3561
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    invoke-static {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSetIdentity(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V

    .line 3562
    return-void
.end method

.method public static cvSetIdentity(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;D)V
    .locals 1
    .param p0, "mat"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "value"    # D

    .prologue
    .line 3558
    invoke-static {p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvRealScalar(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSetIdentity(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V

    .line 3559
    return-void
.end method

.method public static native cvSetIdentity(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSetImageCOI(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;I)V
.end method

.method public static native cvSetImageROI(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Lcom/googlecode/javacv/cpp/opencv_core$CvRect;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvRect;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSetMemoryManager(Lcom/googlecode/javacv/cpp/opencv_core$CvAllocFunc;Lcom/googlecode/javacv/cpp/opencv_core$CvFreeFunc;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native cvSetND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[ILcom/googlecode/javacv/cpp/opencv_core$CvScalar;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvSetNumThreads(I)V
.end method

.method public static native cvSetReal1D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ID)V
.end method

.method public static native cvSetReal2D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IID)V
.end method

.method public static native cvSetReal3D(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;IIID)V
.end method

.method public static native cvSetRealND(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;[ID)V
.end method

.method public static native cvSetRemove(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;I)V
.end method

.method public static native cvSetSeqBlockSize(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;I)V
.end method

.method public static native cvSetSeqReaderPos(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;II)V
.end method

.method public static native cvSetZero(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static cvSize(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
    .locals 1
    .param p0, "width"    # I
    .param p1, "height"    # I

    .prologue
    .line 2259
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSize;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize;->width(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSize;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize;->height(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSize;

    move-result-object v0

    return-object v0
.end method

.method public static cvSize2D32f(DD)Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;
    .locals 2
    .param p0, "width"    # D
    .param p2, "height"    # D

    .prologue
    .line 2300
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;-><init>()V

    double-to-float v1, p0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;->width(F)Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;

    move-result-object v0

    double-to-float v1, p2

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;->height(F)Lcom/googlecode/javacv/cpp/opencv_core$CvSize2D32f;

    move-result-object v0

    return-object v0
.end method

.method public static cvSlice(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
    .locals 1
    .param p0, "start"    # I
    .param p1, "end"    # I

    .prologue
    .line 2381
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;->start_index(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;->end_index(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;

    move-result-object v0

    return-object v0
.end method

.method public static native cvSliceLength(Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;)I
    .param p0    # Lcom/googlecode/javacv/cpp/opencv_core$CvSlice;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvSolve(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)I
    .locals 1
    .param p0, "A"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "B"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p2, "X"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3547
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSolve(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)I

    move-result v0

    return v0
.end method

.method public static native cvSolve(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)I
.end method

.method public static native cvSolveCubic(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)I
.end method

.method public static native cvSolvePoly(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;II)V
.end method

.method public static native cvSort(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V
.end method

.method public static native cvSplit(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvStartAppendToSeq(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
.end method

.method public static native cvStartNextStream(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V
.end method

.method public static native cvStartReadRawData(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;)V
.end method

.method public static native cvStartReadSeq(Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqReader;I)V
.end method

.method public static native cvStartWriteSeq(IIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvSeqWriter;)V
.end method

.method public static cvStartWriteStruct(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "struct_flags"    # I
    .param p3, "type_name"    # Ljava/lang/String;

    .prologue
    .line 4141
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-static {p0, p1, p2, p3, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvStartWriteStruct(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;ILjava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V

    .line 4142
    return-void
.end method

.method public static native cvStartWriteStruct(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;ILjava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvStdErrReport(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/googlecode/javacpp/Pointer;)I
.end method

.method public static native cvSub(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvSubRS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvSubS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 8
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "value"    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .param p2, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p3, "mask"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3408
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    neg-double v0, v0

    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v2

    neg-double v2, v2

    const/4 v4, 0x2

    invoke-virtual {p1, v4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    neg-double v4, v4

    const/4 v6, 0x3

    invoke-virtual {p1, v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v6

    neg-double v6, v6

    invoke-static/range {v0 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->cvScalar(DDDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    invoke-static {p0, v0, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvAddS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3409
    return-void
.end method

.method public static native cvSum(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static cvT(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 0
    .param p0, "src"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
    .param p1, "dst"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3512
    invoke-static {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core;->cvTranspose(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3513
    return-void
.end method

.method public static cvTermCriteria(IID)Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;
    .locals 1
    .param p0, "type"    # I
    .param p1, "max_iter"    # I
    .param p2, "epsilon"    # D

    .prologue
    .line 1755
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;-><init>()V

    invoke-virtual {v0, p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;->type(I)Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;->max_iter(I)Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;->epsilon(D)Lcom/googlecode/javacv/cpp/opencv_core$CvTermCriteria;

    move-result-object v0

    return-object v0
.end method

.method public static native cvTrace(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native cvTransform(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
.end method

.method public static native cvTranspose(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvTreeToNodeSeq(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
.end method

.method public static native cvTypeOf(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvTypeInfo;
.end method

.method public static native cvUnregisterType(Ljava/lang/String;)V
.end method

.method public static native cvUseOptimized(I)I
.end method

.method public static cvWrite(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;)V
    .locals 1
    .param p0, "fs"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "ptr"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4151
    sget-object v0, Lcom/googlecode/javacv/cpp/opencv_core;->CV_ATTR_LIST_EMPTY:Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvWrite(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V

    .line 4152
    return-void
.end method

.method public static native cvWrite(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;)V
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvAttrList;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native cvWriteComment(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;I)V
.end method

.method public static native cvWriteFileNode(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;I)V
.end method

.method public static native cvWriteInt(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;I)V
.end method

.method public static native cvWriteRawData(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;)V
.end method

.method public static native cvWriteReal(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;D)V
.end method

.method public static native cvWriteString(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Ljava/lang/String;Ljava/lang/String;I)V
.end method

.method public static native cvXor(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
.end method

.method public static native cvXorS(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static cvZero(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .locals 0
    .param p0, "arr"    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;

    .prologue
    .line 3374
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSetZero(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V

    .line 3375
    return-void
.end method

.method public static native getBuildInformation()Ljava/lang/String;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
        value = "cv"
    .end annotation
.end method

.method public static native partition(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/opencv_core$Predicate;)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/StdVector;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/StdVector;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$Predicate;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "cv::partition<void*>"
        }
    .end annotation
.end method


# virtual methods
.method public cvSetNew(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    .locals 3
    .param p1, "set_header"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    .prologue
    .line 3745
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->free_elems()Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    move-result-object v0

    .line 3746
    .local v0, "elem":Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
    if-eqz v0, :cond_0

    .line 3747
    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->next_free()Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->free_elems(Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    .line 3748
    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags()I

    move-result v1

    const v2, 0x3ffffff

    and-int/2addr v1, v2

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    .line 3749
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->active_count()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p1, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->active_count(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    .line 3753
    :goto_0
    return-object v0

    .line 3751
    :cond_0
    const/4 v1, 0x0

    invoke-static {p1, v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvSetAdd(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)I

    goto :goto_0
.end method

.method public cvSetRemoveByPtr(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)V
    .locals 2
    .param p1, "set_header"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
    .param p2, "elem"    # Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    .prologue
    .line 3756
    sget-boolean v0, Lcom/googlecode/javacv/cpp/opencv_core;->$assertionsDisabled:Z

    if-nez v0, :cond_0

    invoke-virtual {p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags()I

    move-result v0

    if-gez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 3757
    :cond_0
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->free_elems()Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->next_free(Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    .line 3758
    invoke-virtual {p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags()I

    move-result v0

    const v1, 0x3ffffff

    and-int/2addr v0, v1

    or-int/lit16 v0, v0, 0x80

    invoke-virtual {p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;->flags(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;

    .line 3759
    invoke-virtual {p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->free_elems(Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    .line 3760
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->active_count()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->active_count(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    .line 3761
    return-void
.end method
