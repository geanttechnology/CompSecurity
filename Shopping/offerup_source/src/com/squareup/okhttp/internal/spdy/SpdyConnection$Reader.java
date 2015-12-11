// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import d.j;
import d.k;
import d.q;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, ErrorCode, SpdyStream, Variant, 
//            FrameReader, HeadersMode, Ping, Settings

class <init> extends NamedRunnable
    implements <init>
{

    FrameReader frameReader;
    final SpdyConnection this$0;

    private void ackSettingsLater(Settings settings1)
    {
        class _cls2 extends NamedRunnable
        {

            final SpdyConnection.Reader this$1;
            final Settings val$peerSettings;

            public void execute()
            {
                try
                {
                    frameWriter.ackSettings(peerSettings);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient _cls2(Object aobj[], Settings settings1)
            {
                this$1 = SpdyConnection.Reader.this;
                peerSettings = settings1;
                super(final_s, aobj);
            }
        }

        SpdyConnection.access$1900().execute(new _cls2(new Object[] {
            SpdyConnection.access$900(SpdyConnection.this)
        }, settings1));
    }

    public void ackSettings()
    {
    }

    public void alternateService(int i, String s, k k1, String s1, int l, long l1)
    {
    }

    public void data(boolean flag, int i, j j1, int l)
    {
        if (SpdyConnection.access$1100(SpdyConnection.this, i))
        {
            SpdyConnection.access$1200(SpdyConnection.this, i, j1, l, flag);
        } else
        {
            SpdyStream spdystream = getStream(i);
            if (spdystream == null)
            {
                writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                j1.f(l);
                return;
            }
            spdystream.receiveData(j1, l);
            if (flag)
            {
                spdystream.receiveFin();
                return;
            }
        }
    }

    protected void execute()
    {
        Object obj;
        ErrorCode errorcode;
        Object obj2;
        ErrorCode errorcode1;
        obj2 = ErrorCode.INTERNAL_ERROR;
        errorcode1 = ErrorCode.INTERNAL_ERROR;
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        frameReader = variant.newReader(q.a(q.b(socket)), client);
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        if (client)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        frameReader.readConnectionPreface();
_L2:
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        if (frameReader.nextFrame(this)) goto _L2; else goto _L1
_L1:
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        obj2 = ErrorCode.NO_ERROR;
        errorcode = ((ErrorCode) (obj2));
        obj = obj2;
        ErrorCode errorcode2 = ErrorCode.CANCEL;
        IOException ioexception;
        Object obj1;
        try
        {
            SpdyConnection.access$1000(SpdyConnection.this, ((ErrorCode) (obj2)), errorcode2);
        }
        catch (IOException ioexception1) { }
        Util.closeQuietly(frameReader);
        return;
        obj;
        obj = errorcode;
        obj2 = ErrorCode.PROTOCOL_ERROR;
        obj = ErrorCode.PROTOCOL_ERROR;
        try
        {
            SpdyConnection.access$1000(SpdyConnection.this, ((ErrorCode) (obj2)), ((ErrorCode) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        Util.closeQuietly(frameReader);
        return;
        obj1;
        obj2 = obj;
        obj = obj1;
_L4:
        try
        {
            SpdyConnection.access$1000(SpdyConnection.this, ((ErrorCode) (obj2)), errorcode1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        Util.closeQuietly(frameReader);
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void goAway(int i, ErrorCode errorcode, k k1)
    {
        k1.e();
        synchronized (SpdyConnection.this)
        {
            k1 = (SpdyStream[])SpdyConnection.access$1700(SpdyConnection.this).values().toArray(new SpdyStream[SpdyConnection.access$1700(SpdyConnection.this).size()]);
            SpdyConnection.access$1402(SpdyConnection.this, true);
        }
        int i1 = k1.length;
        for (int l = 0; l < i1; l++)
        {
            errorcode = k1[l];
            if (errorcode.getId() > i && errorcode.isLocallyInitiated())
            {
                errorcode.receiveRstStream(ErrorCode.REFUSED_STREAM);
                removeStream(errorcode.getId());
            }
        }

        break MISSING_BLOCK_LABEL_126;
        k1;
        errorcode;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public void headers(boolean flag, boolean flag1, int i, int l, List list, HeadersMode headersmode)
    {
        if (!SpdyConnection.access$1100(SpdyConnection.this, i)) goto _L2; else goto _L1
_L1:
        SpdyConnection.access$1300(SpdyConnection.this, i, list, flag1);
_L4:
        return;
_L2:
        synchronized (SpdyConnection.this)
        {
            if (!SpdyConnection.access$1400(SpdyConnection.this))
            {
                break MISSING_BLOCK_LABEL_54;
            }
        }
        return;
        list;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw list;
        SpdyStream spdystream = getStream(i);
        if (spdystream != null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (!headersmode.failIfStreamAbsent())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        writeSynResetLater(i, ErrorCode.INVALID_STREAM);
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        if (i > SpdyConnection.access$1500(SpdyConnection.this))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        if (i % 2 != SpdyConnection.access$1600(SpdyConnection.this) % 2)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        list = new SpdyStream(i, SpdyConnection.this, flag, flag1, list);
        SpdyConnection.access$1502(SpdyConnection.this, i);
        SpdyConnection.access$1700(SpdyConnection.this).put(Integer.valueOf(i), list);
        class _cls1 extends NamedRunnable
        {

            final SpdyConnection.Reader this$1;
            final SpdyStream val$newStream;

            public void execute()
            {
                try
                {
                    SpdyConnection.access$1800(this$0).receive(newStream);
                    return;
                }
                catch (IOException ioexception)
                {
                    throw new RuntimeException(ioexception);
                }
            }

            transient _cls1(Object aobj[], SpdyStream spdystream)
            {
                this$1 = SpdyConnection.Reader.this;
                newStream = spdystream;
                super(final_s, aobj);
            }
        }

        SpdyConnection.access$1900().execute(new _cls1(new Object[] {
            SpdyConnection.access$900(SpdyConnection.this), Integer.valueOf(i)
        }, list));
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        spdyconnection;
        JVM INSTR monitorexit ;
        if (headersmode.failIfStreamPresent())
        {
            spdystream.closeLater(ErrorCode.PROTOCOL_ERROR);
            removeStream(i);
            return;
        }
        spdystream.receiveHeaders(list, headersmode);
        if (flag1)
        {
            spdystream.receiveFin();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void ping(boolean flag, int i, int l)
    {
        if (flag)
        {
            Ping ping1 = SpdyConnection.access$2200(SpdyConnection.this, i);
            if (ping1 != null)
            {
                ping1.receive();
            }
            return;
        } else
        {
            SpdyConnection.access$2300(SpdyConnection.this, true, i, l, null);
            return;
        }
    }

    public void priority(int i, int l, int i1, boolean flag)
    {
    }

    public void pushPromise(int i, int l, List list)
    {
        SpdyConnection.access$2400(SpdyConnection.this, l, list);
    }

    public void rstStream(int i, ErrorCode errorcode)
    {
        if (SpdyConnection.access$1100(SpdyConnection.this, i))
        {
            SpdyConnection.access$2000(SpdyConnection.this, i, errorcode);
        } else
        {
            SpdyStream spdystream = removeStream(i);
            if (spdystream != null)
            {
                spdystream.receiveRstStream(errorcode);
                return;
            }
        }
    }

    public void settings(boolean flag, Settings settings1)
    {
        spdyconnection = SpdyConnection.this;
        spdyconnection;
        JVM INSTR monitorenter ;
        int i = peerSettings.getInitialWindowSize(0x10000);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        peerSettings.clear();
        int i1;
        peerSettings.merge(settings1);
        if (getProtocol() == Protocol.HTTP_2)
        {
            ackSettingsLater(settings1);
        }
        i1 = peerSettings.getInitialWindowSize(0x10000);
        long l1;
        if (i1 == -1 || i1 == i)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        l1 = i1 - i;
        if (!SpdyConnection.access$2100(SpdyConnection.this))
        {
            addBytesToWriteWindow(l1);
            SpdyConnection.access$2102(SpdyConnection.this, true);
        }
        if (SpdyConnection.access$1700(SpdyConnection.this).isEmpty()) goto _L2; else goto _L1
_L1:
        settings1 = (SpdyStream[])SpdyConnection.access$1700(SpdyConnection.this).values().toArray(new SpdyStream[SpdyConnection.access$1700(SpdyConnection.this).size()]);
_L3:
        spdyconnection;
        JVM INSTR monitorexit ;
        if (settings1 != null && l1 != 0L)
        {
            int j1 = settings1.length;
            for (int l = 0; l < j1; l++)
            {
                synchronized (settings1[l])
                {
                    spdyconnection.addBytesToWriteWindow(l1);
                }
            }

        }
        break MISSING_BLOCK_LABEL_241;
        settings1;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw settings1;
        settings1;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw settings1;
        return;
_L2:
        settings1 = null;
          goto _L3
        settings1 = null;
        l1 = 0L;
          goto _L3
    }

    public void windowUpdate(int i, long l)
    {
        if (i == 0)
        {
            synchronized (SpdyConnection.this)
            {
                SpdyConnection spdyconnection1 = SpdyConnection.this;
                spdyconnection1.bytesLeftInWriteWindow = spdyconnection1.bytesLeftInWriteWindow + l;
                notifyAll();
            }
            return;
        }
        break MISSING_BLOCK_LABEL_50;
        exception;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw exception;
        SpdyStream spdystream;
        spdystream = getStream(i);
        if (spdystream == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        spdystream;
        JVM INSTR monitorenter ;
        spdystream.addBytesToWriteWindow(l);
        spdystream;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private _cls1()
    {
        this$0 = SpdyConnection.this;
        super("OkHttp %s", new Object[] {
            SpdyConnection.access$900(SpdyConnection.this)
        });
    }

    _cls900(_cls900 _pcls900)
    {
        this();
    }
}
