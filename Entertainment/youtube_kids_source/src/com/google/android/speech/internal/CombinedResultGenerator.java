// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.internal;

import a;
import android.text.TextUtils;
import euf;
import ewh;
import ewk;
import ewl;
import java.util.Iterator;
import java.util.List;

public class CombinedResultGenerator
{

    private static final String TAG = "VS.CombinedResultGenerator";
    private final List mRecognitionEvents = a.K();

    public CombinedResultGenerator()
    {
    }

    private ewk handleMultipleRecognitionEvents()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj = mRecognitionEvents.iterator();
        float f = 3.402823E+38F;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (ewk)((Iterator) (obj)).next();
            if (((ewk) (obj1)).d)
            {
                obj1 = ((ewk) (obj1)).e;
                if (((ewl) (obj1)).d() > 0)
                {
                    obj1 = ((ewl) (obj1)).a(0);
                    stringbuilder.append(((ewh) (obj1)).b);
                    f = Math.min(f, ((ewh) (obj1)).e);
                }
            }
        } while (true);
        obj = (ewk)mRecognitionEvents.get(mRecognitionEvents.size() - 1);
        ewk ewk1 = new ewk();
        try
        {
            ewk1.a(((ewk) (obj)).c());
        }
        catch (euf euf1)
        {
            return ((ewk) (obj));
        }
        if (!TextUtils.isEmpty(stringbuilder.toString()))
        {
            obj = new ewl();
            ((ewl) (obj)).a((new ewh()).a(f).a(stringbuilder.toString()));
            ewk1.a(((ewl) (obj)));
        }
        return ewk1;
    }

    private ewk handleSingleRecognitionEvent()
    {
        ewk ewk1 = (ewk)mRecognitionEvents.get(0);
        if (ewk1.d)
        {
            ewk1.a(ewk1.e);
        }
        return ewk1;
    }

    public ewk getCombinedResultEvent()
    {
        if (mRecognitionEvents.isEmpty())
        {
            return null;
        }
        if (mRecognitionEvents.size() == 1)
        {
            return handleSingleRecognitionEvent();
        } else
        {
            return handleMultipleRecognitionEvents();
        }
    }

    public void update(ewk ewk1)
    {
        mRecognitionEvents.add(ewk1);
    }
}
