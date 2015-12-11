// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.Context;
import c.a.a.a.a.b.j;
import c.a.a.a.a.b.y;
import c.a.a.a.e;
import c.a.a.a.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            ByteString, CodedOutputStream, LogFileManager

class SessionDataWriter
{

    private static final String SIGNAL_DEFAULT = "0";
    private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
    private final Context context;
    private StackTraceElement exceptionStack[];
    private final int maxChainedExceptionsDepth = 8;
    private final ByteString optionalBuildIdBytes;
    private final ByteString packageNameBytes;
    private android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
    private List stacks;
    private Thread threads[];

    public SessionDataWriter(Context context1, String s, String s1)
    {
        context = context1;
        packageNameBytes = ByteString.copyFromUtf8(s1);
        if (s == null)
        {
            context1 = null;
        } else
        {
            context1 = ByteString.copyFromUtf8(s.replace("-", ""));
        }
        optionalBuildIdBytes = context1;
    }

    private int getBinaryImageSize()
    {
        int k = CodedOutputStream.computeUInt64Size(1, 0L) + 0 + CodedOutputStream.computeUInt64Size(2, 0L) + CodedOutputStream.computeBytesSize(3, packageNameBytes);
        int i = k;
        if (optionalBuildIdBytes != null)
        {
            i = k + CodedOutputStream.computeBytesSize(4, optionalBuildIdBytes);
        }
        return i;
    }

    private int getDeviceIdentifierSize(y y1, String s)
    {
        return CodedOutputStream.computeEnumSize(1, y1.h) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
    }

    private int getEventAppCustomAttributeSize(String s, String s1)
    {
        int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(s));
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
    }

    private int getEventAppExecutionExceptionSize(Throwable throwable, int i)
    {
        int k;
        int l;
label0:
        {
            boolean flag = false;
            l = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(throwable.getClass().getName())) + 0;
            Object obj = throwable.getLocalizedMessage();
            k = l;
            if (obj != null)
            {
                k = l + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(((String) (obj))));
            }
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            int i1 = astacktraceelement.length;
            for (l = 0; l < i1;)
            {
                int j1 = getFrameSize(astacktraceelement[l], true);
                int k1 = CodedOutputStream.computeTagSize(4);
                int l1 = CodedOutputStream.computeRawVarint32Size(j1);
                l++;
                k = j1 + (k1 + l1) + k;
            }

            astacktraceelement = throwable.getCause();
            l = k;
            if (astacktraceelement != null)
            {
                l = ((flag) ? 1 : 0);
                throwable = astacktraceelement;
                if (i >= maxChainedExceptionsDepth)
                {
                    break label0;
                }
                i = getEventAppExecutionExceptionSize(((Throwable) (astacktraceelement)), i + 1);
                l = k + (i + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(i)));
            }
            return l;
        }
        while (throwable != null) 
        {
            throwable = throwable.getCause();
            l++;
        }
        return k + CodedOutputStream.computeUInt32Size(7, l);
    }

    private int getEventAppExecutionSignalSize()
    {
        return CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + 0 + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeUInt64Size(3, 0L);
    }

    private int getEventAppExecutionSize(Thread thread, Throwable throwable)
    {
        int i = getThreadSize(thread, exceptionStack, 4, true);
        int i1 = CodedOutputStream.computeTagSize(1);
        int j1 = CodedOutputStream.computeRawVarint32Size(i);
        int l = threads.length;
        int k = 0;
        i = i + (i1 + j1) + 0;
        for (; k < l; k++)
        {
            i1 = getThreadSize(threads[k], (StackTraceElement[])stacks.get(k), 0, false);
            i += i1 + (CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(i1));
        }

        k = getEventAppExecutionExceptionSize(throwable, 1);
        l = CodedOutputStream.computeTagSize(2);
        i1 = CodedOutputStream.computeRawVarint32Size(k);
        j1 = getEventAppExecutionSignalSize();
        int k1 = CodedOutputStream.computeTagSize(3);
        int l1 = CodedOutputStream.computeRawVarint32Size(j1);
        int i2 = getBinaryImageSize();
        return k + (l + i1) + i + (j1 + (k1 + l1)) + (i2 + (CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(i2)));
    }

    private int getEventAppSize(Thread thread, Throwable throwable, int i, Map map)
    {
        int k = getEventAppExecutionSize(thread, throwable);
        k = k + (CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(k)) + 0;
        int l;
        if (map != null)
        {
            thread = map.entrySet().iterator();
            do
            {
                l = k;
                if (!thread.hasNext())
                {
                    break;
                }
                throwable = (java.util.Map.Entry)thread.next();
                l = getEventAppCustomAttributeSize((String)throwable.getKey(), (String)throwable.getValue());
                k = l + (CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(l)) + k;
            } while (true);
        } else
        {
            l = k;
        }
        k = l;
        if (runningAppProcessInfo != null)
        {
            boolean flag;
            if (runningAppProcessInfo.importance != 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = l + CodedOutputStream.computeBoolSize(3, flag);
        }
        return CodedOutputStream.computeUInt32Size(4, i) + k;
    }

    private int getEventDeviceSize(float f, int i, boolean flag, int k, long l, long l1)
    {
        return CodedOutputStream.computeFloatSize(1, f) + 0 + CodedOutputStream.computeSInt32Size(2, i) + CodedOutputStream.computeBoolSize(3, flag) + CodedOutputStream.computeUInt32Size(4, k) + CodedOutputStream.computeUInt64Size(5, l) + CodedOutputStream.computeUInt64Size(6, l1);
    }

    private int getEventLogSize(ByteString bytestring)
    {
        return CodedOutputStream.computeBytesSize(1, bytestring);
    }

    private int getFrameSize(StackTraceElement stacktraceelement, boolean flag)
    {
        int i;
        int k;
        if (stacktraceelement.isNativeMethod())
        {
            i = CodedOutputStream.computeUInt64Size(1, Math.max(stacktraceelement.getLineNumber(), 0)) + 0;
        } else
        {
            i = CodedOutputStream.computeUInt64Size(1, 0L) + 0;
        }
        k = i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        i = k;
        if (stacktraceelement.getFileName() != null)
        {
            i = k + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(stacktraceelement.getFileName()));
        }
        if (!stacktraceelement.isNativeMethod() && stacktraceelement.getLineNumber() > 0)
        {
            i += CodedOutputStream.computeUInt64Size(4, stacktraceelement.getLineNumber());
        }
        if (flag)
        {
            k = 2;
        } else
        {
            k = 0;
        }
        return CodedOutputStream.computeUInt32Size(5, k) + i;
    }

    private int getSessionAppOrgSize()
    {
        return CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8((new j()).a(context))) + 0;
    }

    private int getSessionAppSize(ByteString bytestring, ByteString bytestring1, ByteString bytestring2, ByteString bytestring3, int i)
    {
        int k = CodedOutputStream.computeBytesSize(1, bytestring);
        int l = CodedOutputStream.computeBytesSize(2, bytestring1);
        int i1 = CodedOutputStream.computeBytesSize(3, bytestring2);
        int j1 = getSessionAppOrgSize();
        return k + 0 + l + i1 + (j1 + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(j1))) + CodedOutputStream.computeBytesSize(6, bytestring3) + CodedOutputStream.computeEnumSize(10, i);
    }

    private int getSessionDeviceSize(int i, ByteString bytestring, ByteString bytestring1, int k, long l, long l1, boolean flag, Map map, int i1, ByteString bytestring2, ByteString bytestring3)
    {
        int j1 = CodedOutputStream.computeBytesSize(1, bytestring);
        int k1 = CodedOutputStream.computeEnumSize(3, i);
        if (bytestring1 == null)
        {
            i = 0;
        } else
        {
            i = CodedOutputStream.computeBytesSize(4, bytestring1);
        }
        i = i + (k1 + (j1 + 0)) + CodedOutputStream.computeUInt32Size(5, k) + CodedOutputStream.computeUInt64Size(6, l) + CodedOutputStream.computeUInt64Size(7, l1) + CodedOutputStream.computeBoolSize(10, flag);
        if (map != null)
        {
            bytestring = map.entrySet().iterator();
            do
            {
                k = i;
                if (!bytestring.hasNext())
                {
                    break;
                }
                bytestring1 = (java.util.Map.Entry)bytestring.next();
                k = getDeviceIdentifierSize((y)bytestring1.getKey(), (String)bytestring1.getValue());
                i = k + (CodedOutputStream.computeTagSize(11) + CodedOutputStream.computeRawVarint32Size(k)) + i;
            } while (true);
        } else
        {
            k = i;
        }
        j1 = CodedOutputStream.computeUInt32Size(12, i1);
        if (bytestring2 == null)
        {
            i = 0;
        } else
        {
            i = CodedOutputStream.computeBytesSize(13, bytestring2);
        }
        if (bytestring3 == null)
        {
            i1 = 0;
        } else
        {
            i1 = CodedOutputStream.computeBytesSize(14, bytestring3);
        }
        return i1 + (k + j1 + i);
    }

    private int getSessionEventSize(Thread thread, Throwable throwable, String s, long l, Map map, float f, 
            int i, boolean flag, int k, long l1, long l2, 
            ByteString bytestring)
    {
        int i1 = CodedOutputStream.computeUInt64Size(1, l);
        int j1 = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
        int k1 = getEventAppSize(thread, throwable, k, map);
        int i2 = CodedOutputStream.computeTagSize(3);
        int j2 = CodedOutputStream.computeRawVarint32Size(k1);
        i = getEventDeviceSize(f, i, flag, k, l1, l2);
        k = i1 + 0 + j1 + (k1 + (i2 + j2)) + (i + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(i)));
        i = k;
        if (bytestring != null)
        {
            i = getEventLogSize(bytestring);
            i = k + (i + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(i)));
        }
        return i;
    }

    private int getSessionOSSize(ByteString bytestring, ByteString bytestring1, boolean flag)
    {
        return CodedOutputStream.computeEnumSize(1, 3) + 0 + CodedOutputStream.computeBytesSize(2, bytestring) + CodedOutputStream.computeBytesSize(3, bytestring1) + CodedOutputStream.computeBoolSize(4, flag);
    }

    private int getThreadSize(Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
    {
        int k = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(thread.getName()));
        k = CodedOutputStream.computeUInt32Size(2, i) + k;
        int l = astacktraceelement.length;
        for (i = 0; i < l; i++)
        {
            int i1 = getFrameSize(astacktraceelement[i], flag);
            k += i1 + (CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(i1));
        }

        return k;
    }

    private ByteString stringToByteString(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return ByteString.copyFromUtf8(s);
        }
    }

    private void writeFrame(CodedOutputStream codedoutputstream, int i, StackTraceElement stacktraceelement, boolean flag)
    {
        byte byte0 = 4;
        codedoutputstream.writeTag(i, 2);
        codedoutputstream.writeRawVarint32(getFrameSize(stacktraceelement, flag));
        if (stacktraceelement.isNativeMethod())
        {
            codedoutputstream.writeUInt64(1, Math.max(stacktraceelement.getLineNumber(), 0));
        } else
        {
            codedoutputstream.writeUInt64(1, 0L);
        }
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        if (stacktraceelement.getFileName() != null)
        {
            codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(stacktraceelement.getFileName()));
        }
        if (!stacktraceelement.isNativeMethod() && stacktraceelement.getLineNumber() > 0)
        {
            codedoutputstream.writeUInt64(4, stacktraceelement.getLineNumber());
        }
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        codedoutputstream.writeUInt32(5, i);
    }

    private void writeSessionEventApp(CodedOutputStream codedoutputstream, Thread thread, Throwable throwable, int i, Map map)
    {
        codedoutputstream.writeTag(3, 2);
        codedoutputstream.writeRawVarint32(getEventAppSize(thread, throwable, i, map));
        writeSessionEventAppExecution(codedoutputstream, thread, throwable);
        if (map != null && !map.isEmpty())
        {
            writeSessionEventAppCustomAttributes(codedoutputstream, map);
        }
        if (runningAppProcessInfo != null)
        {
            boolean flag;
            if (runningAppProcessInfo.importance != 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            codedoutputstream.writeBool(3, flag);
        }
        codedoutputstream.writeUInt32(4, i);
    }

    private void writeSessionEventAppCustomAttributes(CodedOutputStream codedoutputstream, Map map)
    {
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(map)))
        {
            map = (java.util.Map.Entry)iterator.next();
            codedoutputstream.writeTag(2, 2);
            codedoutputstream.writeRawVarint32(getEventAppCustomAttributeSize((String)map.getKey(), (String)map.getValue()));
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8((String)map.getKey()));
            String s = (String)map.getValue();
            map = s;
            if (s == null)
            {
                map = "";
            }
        }

    }

    private void writeSessionEventAppExecution(CodedOutputStream codedoutputstream, Thread thread, Throwable throwable)
    {
        codedoutputstream.writeTag(1, 2);
        codedoutputstream.writeRawVarint32(getEventAppExecutionSize(thread, throwable));
        writeThread(codedoutputstream, thread, exceptionStack, 4, true);
        int k = threads.length;
        for (int i = 0; i < k; i++)
        {
            writeThread(codedoutputstream, threads[i], (StackTraceElement[])stacks.get(i), 0, false);
        }

        writeSessionEventAppExecutionException(codedoutputstream, throwable, 1, 2);
        codedoutputstream.writeTag(3, 2);
        codedoutputstream.writeRawVarint32(getEventAppExecutionSignalSize());
        codedoutputstream.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
        codedoutputstream.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
        codedoutputstream.writeUInt64(3, 0L);
        codedoutputstream.writeTag(4, 2);
        codedoutputstream.writeRawVarint32(getBinaryImageSize());
        codedoutputstream.writeUInt64(1, 0L);
        codedoutputstream.writeUInt64(2, 0L);
        codedoutputstream.writeBytes(3, packageNameBytes);
        if (optionalBuildIdBytes != null)
        {
            codedoutputstream.writeBytes(4, optionalBuildIdBytes);
        }
    }

    private void writeSessionEventAppExecutionException(CodedOutputStream codedoutputstream, Throwable throwable, int i, int k)
    {
label0:
        {
            boolean flag = false;
            codedoutputstream.writeTag(k, 2);
            codedoutputstream.writeRawVarint32(getEventAppExecutionExceptionSize(throwable, 1));
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(throwable.getClass().getName()));
            Object obj = throwable.getLocalizedMessage();
            if (obj != null)
            {
                codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(((String) (obj))));
            }
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            int l = astacktraceelement.length;
            for (k = 0; k < l; k++)
            {
                writeFrame(codedoutputstream, 4, astacktraceelement[k], true);
            }

            astacktraceelement = throwable.getCause();
            if (astacktraceelement != null)
            {
                k = ((flag) ? 1 : 0);
                throwable = astacktraceelement;
                if (i >= maxChainedExceptionsDepth)
                {
                    break label0;
                }
                writeSessionEventAppExecutionException(codedoutputstream, ((Throwable) (astacktraceelement)), i + 1, 6);
            }
            return;
        }
        while (throwable != null) 
        {
            throwable = throwable.getCause();
            k++;
        }
        codedoutputstream.writeUInt32(7, k);
    }

    private void writeSessionEventDevice(CodedOutputStream codedoutputstream, float f, int i, boolean flag, int k, long l, 
            long l1)
    {
        codedoutputstream.writeTag(5, 2);
        codedoutputstream.writeRawVarint32(getEventDeviceSize(f, i, flag, k, l, l1));
        codedoutputstream.writeFloat(1, f);
        codedoutputstream.writeSInt32(2, i);
        codedoutputstream.writeBool(3, flag);
        codedoutputstream.writeUInt32(4, k);
        codedoutputstream.writeUInt64(5, l);
        codedoutputstream.writeUInt64(6, l1);
    }

    private void writeSessionEventLog(CodedOutputStream codedoutputstream, ByteString bytestring)
    {
        if (bytestring != null)
        {
            codedoutputstream.writeTag(6, 2);
            codedoutputstream.writeRawVarint32(getEventLogSize(bytestring));
            codedoutputstream.writeBytes(1, bytestring);
        }
    }

    private void writeThread(CodedOutputStream codedoutputstream, Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
    {
        codedoutputstream.writeTag(1, 2);
        codedoutputstream.writeRawVarint32(getThreadSize(thread, astacktraceelement, i, flag));
        codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(thread.getName()));
        codedoutputstream.writeUInt32(2, i);
        int k = astacktraceelement.length;
        for (i = 0; i < k; i++)
        {
            writeFrame(codedoutputstream, 3, astacktraceelement[i], flag);
        }

    }

    public void writeBeginSession(CodedOutputStream codedoutputstream, String s, String s1, long l)
    {
        codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(s1));
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(s));
        codedoutputstream.writeUInt64(3, l);
    }

    public void writeSessionApp(CodedOutputStream codedoutputstream, String s, String s1, String s2, String s3, int i)
    {
        s = ByteString.copyFromUtf8(s);
        s1 = ByteString.copyFromUtf8(s1);
        s2 = ByteString.copyFromUtf8(s2);
        s3 = ByteString.copyFromUtf8(s3);
        codedoutputstream.writeTag(7, 2);
        codedoutputstream.writeRawVarint32(getSessionAppSize(s, s1, s2, s3, i));
        codedoutputstream.writeBytes(1, s);
        codedoutputstream.writeBytes(2, s1);
        codedoutputstream.writeBytes(3, s2);
        codedoutputstream.writeTag(5, 2);
        codedoutputstream.writeRawVarint32(getSessionAppOrgSize());
        codedoutputstream.writeString(1, (new j()).a(context));
        codedoutputstream.writeBytes(6, s3);
        codedoutputstream.writeEnum(10, i);
    }

    public void writeSessionDevice(CodedOutputStream codedoutputstream, String s, int i, String s1, int k, long l, 
            long l1, boolean flag, Map map, int i1, String s2, String s3)
    {
        s = ByteString.copyFromUtf8(s);
        ByteString bytestring = stringToByteString(s1);
        s1 = stringToByteString(s3);
        s2 = stringToByteString(s2);
        codedoutputstream.writeTag(9, 2);
        codedoutputstream.writeRawVarint32(getSessionDeviceSize(i, s, bytestring, k, l, l1, flag, map, i1, s2, s1));
        codedoutputstream.writeBytes(1, s);
        codedoutputstream.writeEnum(3, i);
        codedoutputstream.writeBytes(4, bytestring);
        codedoutputstream.writeUInt32(5, k);
        codedoutputstream.writeUInt64(6, l);
        codedoutputstream.writeUInt64(7, l1);
        codedoutputstream.writeBool(10, flag);
        for (s = map.entrySet().iterator(); s.hasNext(); codedoutputstream.writeBytes(2, ByteString.copyFromUtf8((String)map.getValue())))
        {
            map = (java.util.Map.Entry)s.next();
            codedoutputstream.writeTag(11, 2);
            codedoutputstream.writeRawVarint32(getDeviceIdentifierSize((y)map.getKey(), (String)map.getValue()));
            codedoutputstream.writeEnum(1, ((y)map.getKey()).h);
        }

        codedoutputstream.writeUInt32(12, i1);
        if (s2 != null)
        {
            codedoutputstream.writeBytes(13, s2);
        }
        if (s1 != null)
        {
            codedoutputstream.writeBytes(14, s1);
        }
    }

    public void writeSessionEvent(CodedOutputStream codedoutputstream, long l, Thread thread, Throwable throwable, String s, Thread athread[], 
            float f, int i, boolean flag, int k, long l1, long l2, android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo, List list, StackTraceElement astacktraceelement[], LogFileManager logfilemanager, Map map)
    {
        runningAppProcessInfo = runningappprocessinfo;
        stacks = list;
        exceptionStack = astacktraceelement;
        threads = athread;
        athread = logfilemanager.getByteStringForLog();
        if (athread == null)
        {
            e.d().a("CrashlyticsCore", "No log data to include with this event.");
        }
        logfilemanager.clearLog();
        codedoutputstream.writeTag(10, 2);
        codedoutputstream.writeRawVarint32(getSessionEventSize(thread, throwable, s, l, map, f, i, flag, k, l1, l2, athread));
        codedoutputstream.writeUInt64(1, l);
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(s));
        writeSessionEventApp(codedoutputstream, thread, throwable, k, map);
        writeSessionEventDevice(codedoutputstream, f, i, flag, k, l1, l2);
        writeSessionEventLog(codedoutputstream, athread);
    }

    public void writeSessionOS(CodedOutputStream codedoutputstream, boolean flag)
    {
        ByteString bytestring = ByteString.copyFromUtf8(android.os.Build.VERSION.RELEASE);
        ByteString bytestring1 = ByteString.copyFromUtf8(android.os.Build.VERSION.CODENAME);
        codedoutputstream.writeTag(8, 2);
        codedoutputstream.writeRawVarint32(getSessionOSSize(bytestring, bytestring1, flag));
        codedoutputstream.writeEnum(1, 3);
        codedoutputstream.writeBytes(2, bytestring);
        codedoutputstream.writeBytes(3, bytestring1);
        codedoutputstream.writeBool(4, flag);
    }

    public void writeSessionUser(CodedOutputStream codedoutputstream, String s, String s1, String s2)
    {
        Object obj = s;
        if (s == null)
        {
            obj = "";
        }
        s = ByteString.copyFromUtf8(((String) (obj)));
        obj = stringToByteString(s1);
        ByteString bytestring = stringToByteString(s2);
        int k = CodedOutputStream.computeBytesSize(1, s) + 0;
        int i = k;
        if (s1 != null)
        {
            i = k + CodedOutputStream.computeBytesSize(2, ((ByteString) (obj)));
        }
        k = i;
        if (s2 != null)
        {
            k = i + CodedOutputStream.computeBytesSize(3, bytestring);
        }
        codedoutputstream.writeTag(6, 2);
        codedoutputstream.writeRawVarint32(k);
        codedoutputstream.writeBytes(1, s);
        if (s1 != null)
        {
            codedoutputstream.writeBytes(2, ((ByteString) (obj)));
        }
        if (s2 != null)
        {
            codedoutputstream.writeBytes(3, bytestring);
        }
    }

}
