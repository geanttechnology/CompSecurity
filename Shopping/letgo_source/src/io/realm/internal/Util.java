// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package io.realm.internal:
//            RealmCore

public class Util
{
    public static final class Testcase extends Enum
    {

        private static final Testcase $VALUES[];
        public static final Testcase Exception_ClassNotFound;
        public static final Testcase Exception_FileAccessError;
        public static final Testcase Exception_FileNotFound;
        public static final Testcase Exception_IOFailed;
        public static final Testcase Exception_IllegalArgument;
        public static final Testcase Exception_IndexOutOfBounds;
        public static final Testcase Exception_NoSuchField;
        public static final Testcase Exception_NoSuchMethod;
        public static final Testcase Exception_OutOfMemory;
        public static final Testcase Exception_RowInvalid;
        public static final Testcase Exception_RuntimeError;
        public static final Testcase Exception_TableInvalid;
        public static final Testcase Exception_Unspecified;
        public static final Testcase Exception_UnsupportedOperation;
        private final int nativeTestcase;

        public static Testcase valueOf(String s)
        {
            return (Testcase)Enum.valueOf(io/realm/internal/Util$Testcase, s);
        }

        public static Testcase[] values()
        {
            return (Testcase[])$VALUES.clone();
        }

        public String execute(long l)
        {
            return Util.nativeTestcase(nativeTestcase, true, l);
        }

        public String expectedResult(long l)
        {
            return Util.nativeTestcase(nativeTestcase, false, l);
        }

        static 
        {
            Exception_ClassNotFound = new Testcase("Exception_ClassNotFound", 0, 0);
            Exception_NoSuchField = new Testcase("Exception_NoSuchField", 1, 1);
            Exception_NoSuchMethod = new Testcase("Exception_NoSuchMethod", 2, 2);
            Exception_IllegalArgument = new Testcase("Exception_IllegalArgument", 3, 3);
            Exception_IOFailed = new Testcase("Exception_IOFailed", 4, 4);
            Exception_FileNotFound = new Testcase("Exception_FileNotFound", 5, 5);
            Exception_FileAccessError = new Testcase("Exception_FileAccessError", 6, 6);
            Exception_IndexOutOfBounds = new Testcase("Exception_IndexOutOfBounds", 7, 7);
            Exception_TableInvalid = new Testcase("Exception_TableInvalid", 8, 8);
            Exception_UnsupportedOperation = new Testcase("Exception_UnsupportedOperation", 9, 9);
            Exception_OutOfMemory = new Testcase("Exception_OutOfMemory", 10, 10);
            Exception_Unspecified = new Testcase("Exception_Unspecified", 11, 11);
            Exception_RuntimeError = new Testcase("Exception_RuntimeError", 12, 12);
            Exception_RowInvalid = new Testcase("Exception_RowInvalid", 13, 13);
            $VALUES = (new Testcase[] {
                Exception_ClassNotFound, Exception_NoSuchField, Exception_NoSuchMethod, Exception_IllegalArgument, Exception_IOFailed, Exception_FileNotFound, Exception_FileAccessError, Exception_IndexOutOfBounds, Exception_TableInvalid, Exception_UnsupportedOperation, 
                Exception_OutOfMemory, Exception_Unspecified, Exception_RuntimeError, Exception_RowInvalid
            });
        }

        private Testcase(String s, int i, int j)
        {
            super(s, i);
            nativeTestcase = j;
        }
    }


    public Util()
    {
    }

    public static long getNativeMemUsage()
    {
        return nativeGetMemUsage();
    }

    static void javaPrint(String s)
    {
        System.out.print(s);
    }

    static native long nativeGetMemUsage();

    static native void nativeSetDebugLevel(int i);

    static native String nativeTestcase(int i, boolean flag, long l);

    public static void setDebugLevel(int i)
    {
        nativeSetDebugLevel(i);
    }

    public static void waitForEnter()
    {
        System.out.println("Press Enter to continue...");
        Scanner scanner;
        for (scanner = new Scanner(System.in); !scanner.nextLine().equals("");) { }
        scanner.close();
    }

    static 
    {
        RealmCore.loadLibrary();
    }
}
