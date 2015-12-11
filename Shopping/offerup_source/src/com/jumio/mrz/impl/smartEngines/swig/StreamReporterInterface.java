// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzResult, MrzRectMatrix

public class StreamReporterInterface
{

    private long a;
    protected boolean swigCMemOwn;

    public StreamReporterInterface()
    {
        this(mrzjniInterfaceJNI.new_StreamReporterInterface(), true);
        mrzjniInterfaceJNI.StreamReporterInterface_director_connect(this, a, swigCMemOwn, true);
    }

    protected StreamReporterInterface(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(StreamReporterInterface streamreporterinterface)
    {
        if (streamreporterinterface == null)
        {
            return 0L;
        } else
        {
            return streamreporterinterface.a;
        }
    }

    public void SnapshotProcessed(MrzResult mrzresult, boolean flag)
    {
        mrzjniInterfaceJNI.StreamReporterInterface_SnapshotProcessed(a, this, MrzResult.getCPtr(mrzresult), mrzresult, flag);
    }

    public void SnapshotRejected()
    {
        if (getClass() == com/jumio/mrz/impl/smartEngines/swig/StreamReporterInterface)
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_0(a, this);
            return;
        } else
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_0(a, this);
            return;
        }
    }

    public void SnapshotRejected(String s)
    {
        if (getClass() == com/jumio/mrz/impl/smartEngines/swig/StreamReporterInterface)
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_1(a, this, s);
            return;
        } else
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_1(a, this, s);
            return;
        }
    }

    public void SymbolRectsFound(MrzRectMatrix mrzrectmatrix)
    {
        if (getClass() == com/jumio/mrz/impl/smartEngines/swig/StreamReporterInterface)
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFound(a, this, MrzRectMatrix.getCPtr(mrzrectmatrix), mrzrectmatrix);
            return;
        } else
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundSwigExplicitStreamReporterInterface(a, this, MrzRectMatrix.getCPtr(mrzrectmatrix), mrzrectmatrix);
            return;
        }
    }

    public void SymbolRectsFoundAfterSnapshotProcessed(MrzRectMatrix mrzrectmatrix)
    {
        if (getClass() == com/jumio/mrz/impl/smartEngines/swig/StreamReporterInterface)
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(a, this, MrzRectMatrix.getCPtr(mrzrectmatrix), mrzrectmatrix);
            return;
        } else
        {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessedSwigExplicitStreamReporterInterface(a, this, MrzRectMatrix.getCPtr(mrzrectmatrix), mrzrectmatrix);
            return;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_StreamReporterInterface(a);
            }
            a = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, a, true);
    }
}
