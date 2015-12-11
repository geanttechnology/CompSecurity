// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.json.JSONArray;
import com.boldchat.visitor.api.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.boldchat.visitor.api:
//            FormField

public class Form
{

    private ArrayList formFields;
    private HashMap formFieldsByKey;

    protected Form(JSONObject jsonobject)
    {
        formFields = null;
        jsonobject = jsonobject.optJSONArray("Fields");
        formFieldsByKey = new HashMap();
        if (jsonobject != null)
        {
            formFields = new ArrayList();
            for (int i = 0; i < jsonobject.length(); i++)
            {
                FormField formfield = new FormField(jsonobject.optJSONObject(i));
                formFields.add(formfield);
                formFieldsByKey.put(formfield.getKey(), formfield);
            }

        }
    }

    public FormField getFormField(String s)
    {
        return (FormField)formFieldsByKey.get(s);
    }

    public List getFormFields()
    {
        return formFields;
    }
}
