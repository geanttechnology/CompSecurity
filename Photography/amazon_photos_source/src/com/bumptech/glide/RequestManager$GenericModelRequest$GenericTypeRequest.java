// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;


// Referenced classes of package com.bumptech.glide:
//            RequestManager, GenericTranscodeRequest

public final class modelClass
{

    private final Object model;
    private final Class modelClass;
    private final boolean providedModel = true;
    final model this$1;

    public GenericTranscodeRequest as(Class class1)
    {
        class1 = (GenericTranscodeRequest)RequestManager.access$500(this._cls1.this.modelClass)._mth1(new GenericTranscodeRequest(RequestManager.access$100(_fld1), RequestManager.access$200(_fld1), modelClass, modelClass(this._cls1.this), this._mth1(this._cls1.this), class1, RequestManager.access$300(_fld1), RequestManager.access$400(_fld1), RequestManager.access$500(_fld1)));
        if (providedModel)
        {
            class1.load(model);
        }
        return class1;
    }

    (Object obj)
    {
        this$1 = this._cls1.this;
        super();
        model = obj;
        modelClass = RequestManager.access$000(obj);
    }
}
