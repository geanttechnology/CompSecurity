// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cz;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.videogenerator.layer.LayerConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class a
{

    public final Project a;
    public List b;
    public int c;
    public int d;
    public float e;
    public float f;

    public a(Project project, int i, int j)
    {
        b = new ArrayList();
        a = project;
        d = j;
        c = i;
        e = 1.0F;
        f = 1.0F;
    }

    private void a(Canvas canvas)
    {
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.socialin.android.videogenerator.layer.a a1 = (com.socialin.android.videogenerator.layer.a)iterator.next();
            if (a1.b.isVisibility())
            {
                Paint paint = a1.b.toPaint();
                paint.setAlpha(a1.b.getOpacity());
                canvas.drawBitmap(a1.a, 0.0F, 0.0F, paint);
            }
        } while (true);
    }

    public final com.socialin.android.videogenerator.layer.a a(int i)
    {
        return (com.socialin.android.videogenerator.layer.a)b.get(i);
    }

    public final com.socialin.android.videogenerator.layer.a a(UUID uuid)
    {
        int j = b.size();
        for (int i = 0; i < j; i++)
        {
            com.socialin.android.videogenerator.layer.a a1 = a(i);
            if (a1.c.equals(uuid))
            {
                return a1;
            }
        }

        return null;
    }

    public final void a(Bitmap bitmap, Bitmap bitmap1)
    {
        bitmap.eraseColor(0);
        bitmap = new Canvas(bitmap);
        a(((Canvas) (bitmap)));
        bitmap.drawBitmap(bitmap1, 0.0F, 0.0F, null);
    }

    public final String toString()
    {
        String s = (new StringBuilder()).append("-----------------------").append(System.getProperty("line.separator")).toString();
        s = (new StringBuilder()).append(s).append("State Layers:").toString();
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            com.socialin.android.videogenerator.layer.a a1 = (com.socialin.android.videogenerator.layer.a)iterator.next();
            s = (new StringBuilder()).append(s).append(System.getProperty("line.separator")).append(a1.toString()).toString();
        }

        s = (new StringBuilder()).append(s).append(System.getProperty("line.separator")).toString();
        s = (new StringBuilder()).append(s).append(" width:").append(c).toString();
        s = (new StringBuilder()).append(s).append(" height:").append(d).toString();
        s = (new StringBuilder()).append(s).append(" scale:").append(e).toString();
        s = (new StringBuilder()).append(s).append(System.getProperty("line.separator")).toString();
        return (new StringBuilder()).append(s).append("-----------------------").toString();
    }
}
