// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mrz.impl.smartEngines.swig.MrzRectMatrix;
import com.jumio.mrz.impl.smartEngines.swig.MrzRectVector;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StreamReporterInterface;

public class jd extends StreamReporterInterface
{

    public boolean a;
    public MrzResult b;
    public MrzRectVector c[];

    public jd()
    {
        a = false;
    }

    public void SnapshotProcessed(MrzResult mrzresult, boolean flag)
    {
        a = flag;
        if (flag)
        {
            b = new MrzResult(mrzresult);
        }
    }

    public void SnapshotRejected()
    {
        c = new MrzRectVector[0];
    }

    public void SymbolRectsFound(MrzRectMatrix mrzrectmatrix)
    {
        c = new MrzRectVector[(int)mrzrectmatrix.size()];
        for (int i = 0; (long)i < mrzrectmatrix.size(); i++)
        {
            c[i] = new MrzRectVector(mrzrectmatrix.get(i).size());
            for (int j = 0; (long)j < mrzrectmatrix.get(i).size(); j++)
            {
                c[i].set(j, mrzrectmatrix.get(i).get(j));
            }

        }

    }

    public void a()
    {
        a = false;
        b = null;
        c = new MrzRectVector[0];
    }
}
