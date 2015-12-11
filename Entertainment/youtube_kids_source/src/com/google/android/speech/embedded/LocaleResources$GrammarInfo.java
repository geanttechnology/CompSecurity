// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import eyn;
import java.io.File;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Grammar

class metadata
{

    final File directory;
    final Greco3Grammar grammar;
    final eyn metadata;
    final String revisionName;

    (Greco3Grammar greco3grammar, String s, File file, eyn eyn)
    {
        grammar = greco3grammar;
        revisionName = s;
        directory = file;
        metadata = eyn;
    }
}
