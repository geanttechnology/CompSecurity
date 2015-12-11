// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.enums;


public final class ErrorCase extends Enum
{

    private static final ErrorCase $VALUES[];
    public static final ErrorCase AUTH_FAILED;
    public static final ErrorCase CANCEL_TYPE_BACKGROUND;
    public static final ErrorCase CANCEL_TYPE_USER;
    public static final ErrorCase CARD_NOT_DETECTED;
    public static final ErrorCase CREDIT_CARD_EXPIRED;
    public static final ErrorCase CREDIT_CARD_NOT_SUPPORTED;
    public static final ErrorCase DEVICE_IS_OFFLINE;
    public static final ErrorCase OCR_LOADING_FAILED;
    public static final ErrorCase REQUEST_IMAGE_FAILED;
    public static final ErrorCase REQUEST_RESULT_FAILED;
    public static final ErrorCase REQUEST_SCANS_FAILED;
    public static final ErrorCase UNEXPECTED_ERROR;
    private String button;
    private int code;
    private String message;
    private boolean retry;

    private ErrorCase(String s, int i, int j, String s1, String s2, boolean flag)
    {
        super(s, i);
        code = j;
        message = s1;
        button = s2;
        retry = flag;
    }

    public static ErrorCase valueOf(String s)
    {
        return (ErrorCase)Enum.valueOf(com/jumio/netswipe/sdk/enums/ErrorCase, s);
    }

    public static ErrorCase[] values()
    {
        return (ErrorCase[])$VALUES.clone();
    }

    public String button()
    {
        return button;
    }

    public int code()
    {
        return code;
    }

    public String message()
    {
        return message;
    }

    public boolean retry()
    {
        return retry;
    }

    static 
    {
        DEVICE_IS_OFFLINE = new ErrorCase("DEVICE_IS_OFFLINE", 0, 144, "error_view_message_device_is_offline", "error_view_button_try_again", true);
        CREDIT_CARD_NOT_SUPPORTED = new ErrorCase("CREDIT_CARD_NOT_SUPPORTED", 1, 141, "error_view_message_credit_card_not_supported", "error_view_button_scan_another_card", true);
        CREDIT_CARD_EXPIRED = new ErrorCase("CREDIT_CARD_EXPIRED", 2, 142, "error_view_message_credit_card_expired", "error_view_button_scan_another_card", true);
        CARD_NOT_DETECTED = new ErrorCase("CARD_NOT_DETECTED", 3, 140, "error_view_message_card_not_detected", "error_view_button_scan_another_card", true);
        AUTH_FAILED = new ErrorCase("AUTH_FAILED", 4, 120, "error_view_message_auth_failed", "error_view_button_cancel", false);
        UNEXPECTED_ERROR = new ErrorCase("UNEXPECTED_ERROR", 5, 103, "error_view_message_unexpected_error", "error_view_button_try_again", true);
        REQUEST_RESULT_FAILED = new ErrorCase("REQUEST_RESULT_FAILED", 6, 102, "error_view_message_request_failed", "error_view_button_scan_another_card", true);
        REQUEST_IMAGE_FAILED = new ErrorCase("REQUEST_IMAGE_FAILED", 7, 101, "error_view_message_request_failed", "error_view_button_scan_another_card", true);
        REQUEST_SCANS_FAILED = new ErrorCase("REQUEST_SCANS_FAILED", 8, 100, "error_view_message_request_failed", "error_view_button_scan_another_card", true);
        CANCEL_TYPE_USER = new ErrorCase("CANCEL_TYPE_USER", 9, 146, "", "", false);
        CANCEL_TYPE_BACKGROUND = new ErrorCase("CANCEL_TYPE_BACKGROUND", 10, 143, "", "", false);
        OCR_LOADING_FAILED = new ErrorCase("OCR_LOADING_FAILED", 11, 145, "error_view_message_startup_error", "error_view_button_cancel", false);
        $VALUES = (new ErrorCase[] {
            DEVICE_IS_OFFLINE, CREDIT_CARD_NOT_SUPPORTED, CREDIT_CARD_EXPIRED, CARD_NOT_DETECTED, AUTH_FAILED, UNEXPECTED_ERROR, REQUEST_RESULT_FAILED, REQUEST_IMAGE_FAILED, REQUEST_SCANS_FAILED, CANCEL_TYPE_USER, 
            CANCEL_TYPE_BACKGROUND, OCR_LOADING_FAILED
        });
    }
}
