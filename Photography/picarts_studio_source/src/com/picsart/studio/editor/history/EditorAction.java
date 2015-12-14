// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.socialin.android.NoProGuard;
import org.json.JSONObject;

public abstract class EditorAction
    implements NoProGuard
{

    public EditorAction()
    {
    }

    public Bitmap apply(Bitmap bitmap)
    {
        throw new UnsupportedOperationException("Apply is not supported");
    }

    public abstract JSONObject getJSONRepresentation();

    public abstract Point getOutSize(Point point);

    public abstract boolean isReversible();

    public abstract boolean isSourceDependent();

    public Bitmap reverseApply(Bitmap bitmap)
    {
        throw new UnsupportedOperationException("Reverse apply is not supported");
    }
}
