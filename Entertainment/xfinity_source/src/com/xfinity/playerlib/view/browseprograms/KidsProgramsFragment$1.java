// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            KidsProgramsFragment

class istener extends DefaultTaskExecutionListener
{

    final KidsProgramsFragment this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        getLoadingViewDelegate().onLoadingFailed();
    }

    public void onPostExecute(Tuple3 tuple3)
    {
        Object obj = (DibicResource)tuple3.e1;
        tuple3 = (VideoEntitlement)tuple3.e3;
        showFilterButton();
        obj = new ArrayList(((DibicResource) (obj)).getPrograms());
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((DibicProgram)iterator.next()).isKids())
            {
                iterator.remove();
            }
        } while (true);
        displayPrograms(((List) (obj)), tuple3);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Tuple3)obj);
    }

    ion()
    {
        this$0 = KidsProgramsFragment.this;
        super();
    }
}
