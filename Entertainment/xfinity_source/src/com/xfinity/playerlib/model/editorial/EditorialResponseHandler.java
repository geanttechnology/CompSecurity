// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialResourceFactory, EditorialParser

public class EditorialResponseHandler extends DelegatingResponseHandler
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/editorial/EditorialResponseHandler);
    private final EditorialParser parser;
    private EditorialResourceFactory resourceFactory;
    private Object response;

    public EditorialResponseHandler(EditorialParser editorialparser, EditorialResourceFactory editorialresourcefactory)
    {
        parser = editorialparser;
        resourceFactory = editorialresourcefactory;
        addDefaultHeaderHandlers();
    }

    public Object getEditorialResponse()
    {
        return response;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            inputstream = IOUtils.toString(inputstream, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimIOException(inputstream);
        }
        response = resourceFactory.createResource(parser, inputstream);
    }

}
