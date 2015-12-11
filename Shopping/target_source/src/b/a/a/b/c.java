// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import b.a.a.a.a;
import b.a.a.a.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

// Referenced classes of package b.a.a.b:
//            a, b

public class c extends b.a.a.a.a
{
    public static interface a
    {

        public abstract void a(b b1);
    }


    private List mFormats;
    private a mResultHandler;
    private ImageScanner mScanner;

    public c(Context context)
    {
        super(context);
        d();
    }

    public void d()
    {
        mScanner = new ImageScanner();
        mScanner.setConfig(0, 256, 3);
        mScanner.setConfig(0, 257, 3);
        mScanner.setConfig(0, 0, 0);
        b.a.a.b.a a1;
        for (Iterator iterator = getFormats().iterator(); iterator.hasNext(); mScanner.setConfig(a1.a(), 0, 1))
        {
            a1 = (b.a.a.b.a)iterator.next();
        }

    }

    public Collection getFormats()
    {
        if (mFormats == null)
        {
            return b.a.a.b.a.r;
        } else
        {
            return mFormats;
        }
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        Object obj = camera.getParameters().getPreviewSize();
        int i = ((android.hardware.Camera.Size) (obj)).width;
        int j = ((android.hardware.Camera.Size) (obj)).height;
        int l;
        if (b.a.a.a.d.b(getContext()) == 1)
        {
            byte abyte1[] = new byte[abyte0.length];
            for (int k = 0; k < j; k++)
            {
                for (int i1 = 0; i1 < i; i1++)
                {
                    abyte1[(i1 * j + j) - k - 1] = abyte0[k * i + i1];
                }

            }

            abyte0 = abyte1;
            l = j;
            j = i;
        } else
        {
            l = i;
        }
        abyte1 = new Image(l, j, "Y800");
        abyte1.setData(abyte0);
        if (mScanner.scanImage(abyte1) != 0)
        {
            c();
            if (mResultHandler != null)
            {
                camera = mScanner.getResults();
                abyte0 = new b();
                camera = camera.iterator();
                do
                {
                    if (!camera.hasNext())
                    {
                        break;
                    }
                    Symbol symbol = (Symbol)camera.next();
                    String s = symbol.getData();
                    if (TextUtils.isEmpty(s))
                    {
                        continue;
                    }
                    abyte0.a(s);
                    abyte0.a(b.a.a.b.a.a(symbol.getType()));
                    break;
                } while (true);
                mResultHandler.a(abyte0);
            }
            return;
        } else
        {
            camera.setOneShotPreviewCallback(this);
            return;
        }
    }

    public void setFormats(List list)
    {
        mFormats = list;
        d();
    }

    public void setResultHandler(a a1)
    {
        mResultHandler = a1;
    }

    static 
    {
        System.loadLibrary("iconv");
    }
}
