// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.groupon.util.ViewUtils;
import roboguice.util.Strings;

public class ShippingEditText extends EditText
{

    private String errorMessage;
    private String httpParam;
    private String jsonParam;

    public ShippingEditText(Context context)
    {
        super(context);
    }

    public ShippingEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ShippingEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public String getHttpParam()
    {
        return httpParam;
    }

    public String getJsonParam()
    {
        return jsonParam;
    }

    public boolean isEmpty()
    {
        while (Strings.isEmpty(errorMessage) || Strings.notEmpty(getText())) 
        {
            return false;
        }
        ViewUtils.setEditTextError(this, errorMessage);
        return true;
    }

    public void setErrorMessage(String s)
    {
        errorMessage = s;
    }

    public void setHttpParam(String s)
    {
        httpParam = s;
    }

    public void setJsonParam(String s)
    {
        jsonParam = s;
    }
}
