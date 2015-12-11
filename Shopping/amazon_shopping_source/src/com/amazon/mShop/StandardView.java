// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ScrollView;
import com.amazon.mShop.util.LayoutUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.mShop:
//            DelayedInitView, TitleProvider

public class StandardView extends ScrollView
    implements DelayedInitView, TitleProvider
{

    public static final int NOT_FOUND = 0;
    public static final String TITLE_ATTR_NAME = "amazon_titleResourceId";
    private boolean initialized;
    private final Resources resources;
    private final int titleResourceId;

    public StandardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initialized = false;
        resources = context.getResources();
        titleResourceId = attributeset.getAttributeResourceValue(null, "amazon_titleResourceId", 0);
    }

    public StandardView(Context context, Integer integer)
    {
        int i = 0;
        super(context);
        initialized = false;
        setLayoutParams(LayoutUtils.fillBoth());
        resources = context.getResources();
        if (integer != null)
        {
            i = integer.intValue();
        }
        titleResourceId = i;
    }

    public static StandardView createStandardView(String s, Context context, int i)
        throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        return (StandardView)Class.forName(s).asSubclass(com/amazon/mShop/StandardView).getConstructor(new Class[] {
            android/content/Context, java/lang/Integer
        }).newInstance(new Object[] {
            context, Integer.valueOf(i)
        });
    }

    public View getContentView()
    {
        return super.getChildAt(0);
    }

    public CharSequence getTitle()
    {
        if (titleResourceId != 0)
        {
            return resources.getString(titleResourceId);
        } else
        {
            return null;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        presentLoadingIndicator(false);
    }

    public void onPushViewCompleted()
    {
        if (initialized) goto _L2; else goto _L1
_L1:
        if (getChildCount() != 0) goto _L4; else goto _L3
_L3:
        presentLoadingIndicator(false);
_L6:
        initialized = true;
_L2:
        return;
_L4:
        View view = getChildAt(0);
        if (view instanceof DelayedInitView)
        {
            ((DelayedInitView)view).onPushViewCompleted();
        } else
        if (view instanceof ViewStub)
        {
            ((ViewStub)view).inflate();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void presentLoadingIndicator(boolean flag)
    {
        if (flag)
        {
            setContentView(com.amazon.mShop.android.lib.R.layout.loading_indicator);
        } else
        if (getChildCount() == 0)
        {
            setContentView(com.amazon.mShop.android.lib.R.layout.loading_indicator);
            return;
        }
    }

    public void replaceLoadingIndicator(int i)
    {
        if (getChildCount() == 0)
        {
            setContentView(i);
        } else
        {
            View view = getChildAt(0);
            if (com.amazon.mShop.android.lib.R.id.loading_indicator == view.getId())
            {
                setContentView(i);
                return;
            }
        }
    }

    public void setContentView(int i)
    {
        super.removeAllViews();
        super.addView(View.inflate(getContext(), i, null));
    }

    public void setContentView(View view)
    {
        super.removeAllViews();
        super.addView(view);
    }
}
