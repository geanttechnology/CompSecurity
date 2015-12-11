// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.ui.listadapter.ViewEntryList;
import com.amazon.retailsearch.android.ui.listadapter.ViewGenerator;
import com.amazon.retailsearch.util.Utils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElement, LayoutElementModel

public class ResultsController
{
    public static interface ModelMatcher
    {

        public abstract boolean match(Object obj);
    }


    private Map modelMap;
    private Map modelMapParkingLot;
    private final ViewEntryList results = new ViewEntryList(16);

    public ResultsController()
    {
        modelMap = new HashMap(16);
        modelMapParkingLot = new HashMap(4);
    }

    private void addToModelMap(int i, LayoutElement layoutelement)
    {
        addToModelMap(i, layoutelement.getLayoutElementModel());
    }

    private void addToModelMap(int i, LayoutElementModel layoutelementmodel)
    {
        int k = results.getContent().size();
        if (i < k)
        {
            for (int j = i; j < k; j++)
            {
                Object obj;
                for (Iterator iterator = get(j).getLayoutElementModel().getAllModels().iterator(); iterator.hasNext(); modelMap.put(obj, Integer.valueOf(j + 1)))
                {
                    obj = iterator.next();
                }

            }

        }
        setInModelMap(i, layoutelementmodel);
    }

    private void removeFromModelMap(int i, int j)
    {
        for (int k = i; k < j; k++)
        {
            Object obj;
            for (Iterator iterator = get(k).getLayoutElementModel().getAllModels().iterator(); iterator.hasNext(); modelMap.remove(obj))
            {
                obj = iterator.next();
            }

        }

        int i1 = results.getContent().size();
        if (j < i1)
        {
            for (int l = j; l < i1; l++)
            {
                Object obj1;
                for (Iterator iterator1 = get(l).getLayoutElementModel().getAllModels().iterator(); iterator1.hasNext(); modelMap.put(obj1, Integer.valueOf(l - (j - i))))
                {
                    obj1 = iterator1.next();
                }

            }

        }
    }

    private void setInModelMap(int i, LayoutElementModel layoutelementmodel)
    {
        if (Utils.isEmpty(layoutelementmodel.getAllModels()))
        {
            modelMapParkingLot.put(layoutelementmodel, Integer.valueOf(i));
        } else
        {
            layoutelementmodel = layoutelementmodel.getAllModels().iterator();
            while (layoutelementmodel.hasNext()) 
            {
                Object obj = layoutelementmodel.next();
                modelMap.put(obj, Integer.valueOf(i));
            }
        }
    }

    public void add(int i, LayoutElement layoutelement)
    {
        addToModelMap(i, layoutelement);
        results.getContent().add(i, layoutelement);
    }

    public boolean add(LayoutElement layoutelement)
    {
        addToModelMap(results.getContent().size(), layoutelement);
        return results.getContent().add(layoutelement);
    }

    public int binarySearch(LayoutElement layoutelement)
    {
        return Collections.binarySearch(results.getContent(), layoutelement);
    }

    public void clear()
    {
        modelMap.clear();
        results.getContent().clear();
    }

    public void clear(int i, int j)
    {
        removeFromModelMap(i, j);
        results.getContent().subList(i, j).clear();
    }

    public boolean contains(Object obj)
    {
        return results.getContent().contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return results.getContent().containsAll(collection);
    }

    public void finalizeModels(LayoutElementModel layoutelementmodel)
    {
        modelMapParkingLot.remove(layoutelementmodel);
    }

    public LayoutElement get(int i)
    {
        return (LayoutElement)results.getContent().get(i);
    }

    public Integer getByModel(Object obj)
    {
        return (Integer)modelMap.get(obj);
    }

    public List getLoadersFor(int i)
    {
        List list = results.getContent();
        if (list != null && i >= 0 && i < list.size())
        {
            return ((LayoutElement)list.get(i)).getLoaders();
        } else
        {
            return null;
        }
    }

    public Object getModel(ModelMatcher modelmatcher, int i, int j)
    {
        if (i > j || i < 0 || j < 0 || j >= results.getContent().size())
        {
            return null;
        }
_L2:
        Object obj;
        if (i > j)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = (LayoutElement)results.getContent().get(i);
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        if ((obj = ((LayoutElement) (obj)).getLayoutElementModel()) == null || ((LayoutElementModel) (obj)).getAllModels() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((LayoutElementModel) (obj)).getAllModels().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = ((Iterator) (obj)).next();
        } while (!modelmatcher.match(obj1));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return obj1;
        return null;
    }

    public ViewGenerator getViewGenerator()
    {
        return results;
    }

    public int indexOf(Object obj)
    {
        return results.getContent().indexOf(obj);
    }

    public boolean isEmpty()
    {
        return results.getContent().isEmpty();
    }

    public LayoutElement set(int i, LayoutElement layoutelement)
    {
        setInModelMap(i, layoutelement.getLayoutElementModel());
        return (LayoutElement)results.getContent().set(i, layoutelement);
    }

    public int size()
    {
        return results.getContent().size();
    }

    public void updateModels(LayoutElementModel layoutelementmodel)
    {
        Integer integer = (Integer)modelMapParkingLot.get(layoutelementmodel);
        if (integer != null)
        {
            if (((LayoutElement)results.getContent().get(integer.intValue())).getLayoutElementModel() != layoutelementmodel)
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Cannot update models if element has moved. Element was originall saved at position ").append(integer.intValue()).toString());
            }
            addToModelMap(integer.intValue(), layoutelementmodel);
        }
    }
}
