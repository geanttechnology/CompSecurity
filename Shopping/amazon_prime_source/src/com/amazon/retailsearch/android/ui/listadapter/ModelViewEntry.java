// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.metrics.RetailSearchDCMLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewBuilderEntry, ModelView

public class ModelViewEntry extends ViewBuilderEntry
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/listadapter/ModelViewEntry);
    RetailSearchDCMLogger dcmLog;
    private final android.view.ViewGroup.LayoutParams layoutParams;
    private Object model;
    private final Class viewClass;

    public ModelViewEntry(int i, Class class1, Object obj)
    {
        this(i, class1, obj, null);
    }

    public ModelViewEntry(int i, Class class1, Object obj, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(i);
        viewClass = class1;
        model = obj;
        layoutParams = layoutparams;
    }

    public ModelViewEntry(ModelViewEntry modelviewentry)
    {
        this(modelviewentry.getType(), modelviewentry.getViewClass(), modelviewentry.getModel(), modelviewentry.getLayoutParams());
    }

    public static ModelViewEntry create(int i, Class class1, Object obj)
    {
        return new ModelViewEntry(i, class1, obj);
    }

    public void buildView(View view)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ((ModelView)(View)viewClass.cast(view)).build(model);
        return;
        view;
        log.error("Recycled view has unexpected type", view);
        return;
    }

    public View createView(ViewGroup viewgroup)
    {
        ViewGroup viewgroup1;
        Object obj;
        obj = null;
        viewgroup1 = null;
        viewgroup = (View)viewClass.getConstructor(new Class[] {
            android/content/Context, android/util/AttributeSet
        }).newInstance(new Object[] {
            viewgroup.getContext(), null
        });
        viewgroup1 = viewgroup;
        viewgroup = obj;
_L2:
        if (viewgroup != null)
        {
            log.error((new StringBuilder()).append("View instantiation error for viewClass ").append(viewClass.getCanonicalName()).toString(), viewgroup);
        }
        if (viewgroup1 != null && layoutParams != null)
        {
            viewgroup1.setLayoutParams(layoutParams);
        }
        return viewgroup1;
        viewgroup;
        continue; /* Loop/switch isn't completed */
        viewgroup;
        continue; /* Loop/switch isn't completed */
        viewgroup;
        continue; /* Loop/switch isn't completed */
        viewgroup;
        continue; /* Loop/switch isn't completed */
        viewgroup;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public android.view.ViewGroup.LayoutParams getLayoutParams()
    {
        return layoutParams;
    }

    public Object getModel()
    {
        return model;
    }

    public Class getViewClass()
    {
        return viewClass;
    }

    public void setModel(Object obj)
    {
        model = obj;
    }

}
