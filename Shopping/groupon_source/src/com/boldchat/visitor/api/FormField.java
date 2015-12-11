// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.json.JSONArray;
import com.boldchat.visitor.api.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.boldchat.visitor.api:
//            FormFieldType, FormFieldOption

public class FormField
{

    private String additionalHeading;
    private FormFieldOption defaultOption;
    private boolean floatToTop;
    private boolean isDepartmentStatusVisible;
    private boolean isMultiLine;
    private boolean isRequired;
    private boolean isVisible;
    private String key;
    private String label;
    private String labelBrandingKey;
    private ArrayList options;
    private FormFieldType type;
    private String value;

    protected FormField(JSONObject jsonobject)
    {
        options = null;
        value = null;
        additionalHeading = null;
        floatToTop = false;
        isVisible = true;
        defaultOption = null;
        type = FormFieldType.getFormFieldType(jsonobject.optString("Type"));
        key = jsonobject.optString("Key");
        labelBrandingKey = jsonobject.optString("LabelBranding");
        label = jsonobject.optString("Label");
        isRequired = jsonobject.optBoolean("Required", false);
        isMultiLine = jsonobject.optBoolean("MultiLine", false);
        isDepartmentStatusVisible = jsonobject.optBoolean("ShowDepartmentStatus", false);
        value = jsonobject.optString("Value", null);
        JSONArray jsonarray = jsonobject.optJSONArray("Options");
        if (jsonarray != null && jsonarray.length() > 0)
        {
            options = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                FormFieldOption formfieldoption = new FormFieldOption(jsonarray.optJSONObject(i));
                if (formfieldoption.isDefaultValue())
                {
                    defaultOption = formfieldoption;
                }
                options.add(formfieldoption);
            }

        }
        isVisible = jsonobject.optBoolean("ShowSelector", true);
    }

    public String getAdditionalHeading()
    {
        return additionalHeading;
    }

    public FormFieldOption getDefaultOption()
    {
        return defaultOption;
    }

    public String getKey()
    {
        return key;
    }

    public String getLabel()
    {
        return label;
    }

    public String getLabelBrandingKey()
    {
        return labelBrandingKey;
    }

    public List getOptions()
    {
        return options;
    }

    public FormFieldType getType()
    {
        return type;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isDepartmentStatusVisible()
    {
        return isDepartmentStatusVisible;
    }

    public boolean isFloatToTop()
    {
        return floatToTop;
    }

    public boolean isMultiLine()
    {
        return isMultiLine;
    }

    public boolean isRequired()
    {
        return isRequired;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setAdditionalHeading(String s)
    {
        additionalHeading = s;
    }

    public void setFloatToTop(boolean flag)
    {
        floatToTop = flag;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
