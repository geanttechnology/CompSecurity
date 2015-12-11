// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.abtnprojects.ambatana.models.product.AbstractImage;
import com.abtnprojects.ambatana.models.product.EmptyImage;
import com.abtnprojects.ambatana.models.product.LocalImage;
import com.abtnprojects.ambatana.models.product.RemoteImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ait, ew

public class hu extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class a extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        final ImageView a;
        final ImageView b;
        final View c;

        public a(View view)
        {
            super(view);
            a = (ImageView)view.findViewById(0x7f100123);
            b = (ImageView)view.findViewById(0x7f100124);
            c = view;
        }
    }


    private List a;
    private ew b;

    public hu(List list)
    {
        a = new ArrayList();
        b = ew.a(1, ait.d);
        if (list != null)
        {
            a.addAll(list);
        }
    }

    private void a(a a1, String s)
    {
        if (!TextUtils.isEmpty(s) && !s.equals(a1.a.getTag()))
        {
            a1.a.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            b.a(s, a1.a, null);
        }
    }

    private boolean b(int i)
    {
        if (a == null || i >= a.size())
        {
            return false;
        } else
        {
            return a.get(i) instanceof EmptyImage;
        }
    }

    public int a()
    {
        Iterator iterator = a.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((AbstractImage)iterator.next() instanceof EmptyImage))
            {
                i++;
            }
        } while (true);
        return i;
    }

    public a a(ViewGroup viewgroup, int i)
    {
        return new a(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f040049, viewgroup, false));
    }

    public AbstractImage a(int i)
    {
        if (i >= 0 && i < getItemCount())
        {
            return (AbstractImage)a.get(i);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The position index must be a valid value between 0 and ").append(getItemCount()).append(" provided : ").append(i).toString());
        }
    }

    public void a(a a1, int i)
    {
        Object obj = (AbstractImage)a.get(i);
        a1.getItemViewType();
        JVM INSTR tableswitch 0 2: default 44
    //                   0 45
    //                   1 64
    //                   2 83;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        a1.a.setVisibility(8);
        a1.b.setVisibility(8);
        return;
_L3:
        a1.c.setBackgroundResource(0x7f020143);
        a1.b.setVisibility(8);
        return;
_L4:
        obj = ((AbstractImage) (obj)).getDisplayUrl();
        if (obj != null)
        {
            a(a1, ((String) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(AbstractImage abstractimage)
    {
        int i = b(abstractimage);
        if (i != -1 && i < getItemCount())
        {
            notifyItemChanged(i);
        }
    }

    public void a(AbstractImage abstractimage, int i)
    {
        if (abstractimage != null && i != -1 && i < getItemCount())
        {
            a.remove(i);
            a.add(i, abstractimage);
            notifyItemChanged(i);
        }
    }

    public void a(AbstractImage abstractimage, LocalImage localimage)
    {
        int i = b(abstractimage);
        if (i != -1 && i < getItemCount())
        {
            a(((AbstractImage) (localimage)), i);
        }
    }

    public int b()
    {
        Iterator iterator = a.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AbstractImage abstractimage = (AbstractImage)iterator.next();
            boolean flag;
            if ((abstractimage instanceof RemoteImage) && ((RemoteImage)abstractimage).getId() == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((abstractimage instanceof LocalImage) || flag)
            {
                i++;
            }
        } while (true);
        return i;
    }

    public int b(AbstractImage abstractimage)
    {
        return a.indexOf(abstractimage);
    }

    public List c()
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < getItemCount()) 
        {
            if (getItemViewType(i) != 2)
            {
                continue;
            }
            Object obj = a(i);
            if (obj != null)
            {
                if (obj instanceof RemoteImage)
                {
                    obj = (RemoteImage)obj;
                } else
                if (obj instanceof LocalImage)
                {
                    obj = new RemoteImage(((LocalImage)obj).getPath(), null);
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }
            i++;
        }
        return arraylist;
    }

    public void c(AbstractImage abstractimage)
    {
        int i = b(abstractimage);
        if (i != -1 && i < getItemCount())
        {
            a.remove(abstractimage);
            notifyItemRemoved(i);
            a.add(new EmptyImage());
            notifyItemInserted(a.size() - 1);
        }
    }

    public int getItemCount()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (b(i))
        {
            while (i == 0 || !b(i - 1)) 
            {
                return 1;
            }
            return 0;
        } else
        {
            return 2;
        }
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        a((a)viewholder, i);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return a(viewgroup, i);
    }
}
