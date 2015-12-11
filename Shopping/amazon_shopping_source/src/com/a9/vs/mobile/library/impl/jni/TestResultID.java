// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class TestResultID extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final TestResultID $VALUES[];
    public static final TestResultID FALSE_NEGATIVE;
    public static final TestResultID FALSE_POSITIVE;
    public static final TestResultID TRUE_NEGATIVE;
    public static final TestResultID TRUE_POSITIVE;
    public static final TestResultID UNSPECIFIED_RESULT;
    private final int swigValue;

    private TestResultID(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private TestResultID(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private TestResultID(String s, int i, TestResultID testresultid)
    {
        Enum(s, i);
        swigValue = testresultid.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static TestResultID swigToEnum(int i)
    {
        TestResultID atestresultid[] = (TestResultID[])com/a9/vs/mobile/library/impl/jni/TestResultID.getEnumConstants();
        if (i >= atestresultid.length || i < 0 || atestresultid[i].swigValue != i) goto _L2; else goto _L1
_L1:
        TestResultID testresultid = atestresultid[i];
_L4:
        return testresultid;
_L2:
        int k = atestresultid.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                TestResultID testresultid1 = atestresultid[j];
                testresultid = testresultid1;
                if (testresultid1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/TestResultID).append(" with value ").append(i).toString());
    }

    public static TestResultID valueOf(String s)
    {
        return (TestResultID)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/TestResultID, s);
    }

    public static TestResultID[] values()
    {
        return (TestResultID[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        TRUE_POSITIVE = new TestResultID("TRUE_POSITIVE", 0, 0);
        TRUE_NEGATIVE = new TestResultID("TRUE_NEGATIVE", 1);
        FALSE_POSITIVE = new TestResultID("FALSE_POSITIVE", 2);
        FALSE_NEGATIVE = new TestResultID("FALSE_NEGATIVE", 3);
        UNSPECIFIED_RESULT = new TestResultID("UNSPECIFIED_RESULT", 4);
        $VALUES = (new TestResultID[] {
            TRUE_POSITIVE, TRUE_NEGATIVE, FALSE_POSITIVE, FALSE_NEGATIVE, UNSPECIFIED_RESULT
        });
    }
}
