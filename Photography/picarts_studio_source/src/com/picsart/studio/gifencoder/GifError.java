// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import java.util.Locale;

public final class GifError extends Enum
{

    private static final GifError $VALUES[];
    public static final GifError CLOSE_FAILED;
    public static final GifError DATA_TOO_BIG;
    public static final GifError EOF_TOO_SOON;
    public static final GifError IMAGE_DEFECT;
    public static final GifError IMG_NOT_CONFINED;
    public static final GifError INVALID_BYTE_BUFFER;
    public static final GifError INVALID_IMG_DIMS;
    public static final GifError INVALID_SCR_DIMS;
    public static final GifError NOT_ENOUGH_MEM;
    public static final GifError NOT_GIF_FILE;
    public static final GifError NOT_READABLE;
    public static final GifError NO_COLOR_MAP;
    public static final GifError NO_ERROR;
    public static final GifError NO_FRAMES;
    public static final GifError NO_IMAG_DSCR;
    public static final GifError NO_SCRN_DSCR;
    public static final GifError OPEN_FAILED;
    public static final GifError READ_FAILED;
    public static final GifError REWIND_FAILED;
    public static final GifError UNKNOWN;
    public static final GifError WRONG_RECORD;
    public final String description;
    int errorCode;

    private GifError(String s, int i, int j, String s1)
    {
        super(s, i);
        errorCode = j;
        description = s1;
    }

    static GifError fromCode(int i)
    {
        GifError agiferror[] = values();
        int k = agiferror.length;
        for (int j = 0; j < k; j++)
        {
            GifError giferror1 = agiferror[j];
            if (giferror1.errorCode == i)
            {
                return giferror1;
            }
        }

        GifError giferror = UNKNOWN;
        giferror.errorCode = i;
        return giferror;
    }

    public static GifError valueOf(String s)
    {
        return (GifError)Enum.valueOf(com/picsart/studio/gifencoder/GifError, s);
    }

    public static GifError[] values()
    {
        return (GifError[])$VALUES.clone();
    }

    public final int getErrorCode()
    {
        return errorCode;
    }

    final String getFormattedDescription()
    {
        return String.format(Locale.US, "GifError %d: %s", new Object[] {
            Integer.valueOf(errorCode), description
        });
    }

    static 
    {
        NO_ERROR = new GifError("NO_ERROR", 0, 0, "No error");
        OPEN_FAILED = new GifError("OPEN_FAILED", 1, 101, "Failed to open given input");
        READ_FAILED = new GifError("READ_FAILED", 2, 102, "Failed to read from given input");
        NOT_GIF_FILE = new GifError("NOT_GIF_FILE", 3, 103, "Data is not in GIF format");
        NO_SCRN_DSCR = new GifError("NO_SCRN_DSCR", 4, 104, "No screen descriptor detected");
        NO_IMAG_DSCR = new GifError("NO_IMAG_DSCR", 5, 105, "No image descriptor detected");
        NO_COLOR_MAP = new GifError("NO_COLOR_MAP", 6, 106, "Neither global nor local color map found");
        WRONG_RECORD = new GifError("WRONG_RECORD", 7, 107, "Wrong record type detected");
        DATA_TOO_BIG = new GifError("DATA_TOO_BIG", 8, 108, "Number of pixels bigger than width * height");
        NOT_ENOUGH_MEM = new GifError("NOT_ENOUGH_MEM", 9, 109, "Failed to allocate required memory");
        CLOSE_FAILED = new GifError("CLOSE_FAILED", 10, 110, "Failed to close given input");
        NOT_READABLE = new GifError("NOT_READABLE", 11, 111, "Given file was not opened for read");
        IMAGE_DEFECT = new GifError("IMAGE_DEFECT", 12, 112, "Image is defective, decoding aborted");
        EOF_TOO_SOON = new GifError("EOF_TOO_SOON", 13, 113, "Image EOF detected before image complete");
        NO_FRAMES = new GifError("NO_FRAMES", 14, 1000, "No frames found, at least one frame required");
        INVALID_SCR_DIMS = new GifError("INVALID_SCR_DIMS", 15, 1001, "Invalid screen size, dimensions must be positive");
        INVALID_IMG_DIMS = new GifError("INVALID_IMG_DIMS", 16, 1002, "Invalid image size, dimensions must be positive");
        IMG_NOT_CONFINED = new GifError("IMG_NOT_CONFINED", 17, 1003, "Image size exceeds screen size");
        REWIND_FAILED = new GifError("REWIND_FAILED", 18, 1004, "Input source rewind has failed, animation is stopped");
        INVALID_BYTE_BUFFER = new GifError("INVALID_BYTE_BUFFER", 19, 1005, "Invalid and/or indirect byte buffer specified");
        UNKNOWN = new GifError("UNKNOWN", 20, -1, "Unknown error");
        $VALUES = (new GifError[] {
            NO_ERROR, OPEN_FAILED, READ_FAILED, NOT_GIF_FILE, NO_SCRN_DSCR, NO_IMAG_DSCR, NO_COLOR_MAP, WRONG_RECORD, DATA_TOO_BIG, NOT_ENOUGH_MEM, 
            CLOSE_FAILED, NOT_READABLE, IMAGE_DEFECT, EOF_TOO_SOON, NO_FRAMES, INVALID_SCR_DIMS, INVALID_IMG_DIMS, IMG_NOT_CONFINED, REWIND_FAILED, INVALID_BYTE_BUFFER, 
            UNKNOWN
        });
    }
}
