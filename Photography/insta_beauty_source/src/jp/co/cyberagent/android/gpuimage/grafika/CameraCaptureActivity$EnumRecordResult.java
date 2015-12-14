// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;


public final class  extends Enum
{

    private static final RESULT_FAIL_UNKOWN $VALUES[];
    public static final RESULT_FAIL_UNKOWN RESULT_FAIL_NOT_PREPARE;
    public static final RESULT_FAIL_UNKOWN RESULT_FAIL_PERMISSION_DENY;
    public static final RESULT_FAIL_UNKOWN RESULT_FAIL_UNKOWN;
    public static final RESULT_FAIL_UNKOWN RESULT_SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(jp/co/cyberagent/android/gpuimage/grafika/CameraCaptureActivity$EnumRecordResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RESULT_SUCCESS = new <init>("RESULT_SUCCESS", 0);
        RESULT_FAIL_NOT_PREPARE = new <init>("RESULT_FAIL_NOT_PREPARE", 1);
        RESULT_FAIL_PERMISSION_DENY = new <init>("RESULT_FAIL_PERMISSION_DENY", 2);
        RESULT_FAIL_UNKOWN = new <init>("RESULT_FAIL_UNKOWN", 3);
        $VALUES = (new .VALUES[] {
            RESULT_SUCCESS, RESULT_FAIL_NOT_PREPARE, RESULT_FAIL_PERMISSION_DENY, RESULT_FAIL_UNKOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
