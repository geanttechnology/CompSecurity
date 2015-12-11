// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocate extends Pointer
{
    public static class Node extends Pointer
    {

        private native void allocate();

        private native void allocate(int i, int j, int k, float f);

        private native void allocateArray(int i);

        public native float boundary();

        public native Node boundary(float f);

        public native int idx();

        public native Node idx(int i);

        public native int left();

        public native Node left(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public Node position(int i)
        {
            return (Node)super.position(i);
        }

        public native int right();

        public native Node right(int i);

        static 
        {
            Loader.load();
        }

        public Node()
        {
            allocate();
        }

        public Node(int i)
        {
            allocateArray(i);
        }

        public Node(int i, int j, int k, float f)
        {
            allocate(i, j, k, f);
        }

        public Node(Pointer pointer)
        {
            super(pointer);
        }
    }


    private native void allocate();

    private native void allocate(Node node, Node node1, boolean flag);

    private native void allocate(Node node, boolean flag);

    public native void build(Node node, Node node1, boolean flag);

    public native void build(Node node, boolean flag);

    public native int dims();

    public native int findNearest(FloatPointer floatpointer, int i, int j, IntPointer intpointer, Node node, FloatPointer floatpointer1, IntPointer intpointer1);

    public native int findNearest(Node node, int i, int j, Node node1, Node node2, Node node3, Node node4);

    public native void findOrthoRange(FloatPointer floatpointer, FloatPointer floatpointer1, IntPointer intpointer, Node node, IntPointer intpointer1);

    public native void findOrthoRange(Node node, Node node1, Node node2, Node node3, Node node4);

    public native FloatPointer getPoint(int i, int ai[]);

    public native void getPoints(FloatPointer floatpointer, Node node, IntPointer intpointer);

    public native void getPoints(Node node, Node node1, Node node2);

    public native IntPointer labels();

    public native Node labels(IntPointer intpointer);

    public native int maxDepth();

    public native Node maxDepth(int i);

    public native Node nodes();

    public native Node nodes(Node node);

    public native int normType();

    public native Node normType(int i);

    public native Node points();

    public native Node points(Node node);

    static 
    {
        Loader.load();
    }

    public Node()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }

    public allocate(allocate allocate1, allocate allocate2, boolean flag)
    {
        allocate(allocate1, allocate2, flag);
    }

    public allocate(allocate allocate1, boolean flag)
    {
        allocate(allocate1, flag);
    }
}
