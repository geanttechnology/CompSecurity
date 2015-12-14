// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import com.bumptech.glide.load.model.ModelLoader;

// Referenced classes of package com.bumptech.glide:
//            RequestManager, GenericTranscodeRequest

public final class dataClass
{
    public final class GenericTypeRequest
    {

        private final Object model;
        private final Class modelClass;
        private final boolean providedModel = true;
        final RequestManager.GenericModelRequest this$1;

        public GenericTranscodeRequest as(Class class1)
        {
            class1 = (GenericTranscodeRequest)RequestManager.access$500(this$0).apply(new GenericTranscodeRequest(RequestManager.access$100(this$0), RequestManager.access$200(this$0), modelClass, modelLoader, dataClass, class1, RequestManager.access$300(this$0), RequestManager.access$400(this$0), RequestManager.access$500(this$0)));
            if (providedModel)
            {
                class1.load(model);
            }
            return class1;
        }

        GenericTypeRequest(Object obj)
        {
            this$1 = RequestManager.GenericModelRequest.this;
            super();
            model = obj;
            modelClass = RequestManager.access$000(obj);
        }
    }


    private final Class dataClass;
    private final ModelLoader modelLoader;
    final RequestManager this$0;

    public GenericTypeRequest load(Object obj)
    {
        return new GenericTypeRequest(obj);
    }



    GenericTypeRequest.modelClass(ModelLoader modelloader, Class class1)
    {
        this$0 = RequestManager.this;
        super();
        modelLoader = modelloader;
        dataClass = class1;
    }
}
