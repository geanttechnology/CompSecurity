// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.commerce.ocr.loyalty.fragments;

import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.google.android.libraries.commerce.ocr.loyalty.fragments:
//            BarcodeModule, OcrCaptureListener

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final BarcodeModule module;

    public final OcrCaptureListener get()
    {
        return module.provideOcrCaptureListener();
    }

    public final volatile Object get()
    {
        return get();
    }

    public (BarcodeModule barcodemodule)
    {
        super("com.google.android.libraries.commerce.ocr.loyalty.fragments.OcrCaptureListener", false, "com.google.android.libraries.commerce.ocr.loyalty.fragments.BarcodeModule", "provideOcrCaptureListener");
        module = barcodemodule;
        setLibrary(true);
    }
}
