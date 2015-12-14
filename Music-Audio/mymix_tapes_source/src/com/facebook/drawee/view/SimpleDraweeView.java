// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;

// Referenced classes of package com.facebook.drawee.view:
//            GenericDraweeView

public class SimpleDraweeView extends GenericDraweeView
{

    private static Supplier sDraweeControllerBuilderSupplier;
    private SimpleDraweeControllerBuilder mSimpleDraweeControllerBuilder;

    public SimpleDraweeView(Context context)
    {
        super(context);
        init();
    }

    public SimpleDraweeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public SimpleDraweeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericdraweehierarchy)
    {
        super(context, genericdraweehierarchy);
        init();
    }

    private void init()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            Preconditions.checkNotNull(sDraweeControllerBuilderSupplier, "SimpleDraweeView was not initialized!");
            mSimpleDraweeControllerBuilder = (SimpleDraweeControllerBuilder)sDraweeControllerBuilderSupplier.get();
            return;
        }
    }

    public static void initialize(Supplier supplier)
    {
        sDraweeControllerBuilderSupplier = supplier;
    }

    public static void shutDown()
    {
        sDraweeControllerBuilderSupplier = null;
    }

    protected SimpleDraweeControllerBuilder getControllerBuilder()
    {
        return mSimpleDraweeControllerBuilder;
    }

    public void setImageURI(Uri uri)
    {
        setImageURI(uri, null);
    }

    public void setImageURI(Uri uri, Object obj)
    {
        setController(mSimpleDraweeControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }
}
