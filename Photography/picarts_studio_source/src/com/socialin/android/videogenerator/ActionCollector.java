// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import com.socialin.android.d;
import com.socialin.android.videogenerator.actions.Action;
import com.socialin.android.videogenerator.actions.AsyncAction;
import com.socialin.android.videogenerator.actions.LayerAdditionAction;
import com.socialin.android.videogenerator.actions.LayerConfigChangeAction;
import com.socialin.android.videogenerator.actions.LayersMergeAction;
import com.socialin.android.videogenerator.actions.RedoAction;
import com.socialin.android.videogenerator.actions.UndoAction;
import com.socialin.android.videogenerator.actions.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ActionCollector
{

    private static final ActionCollector d = new ActionCollector();
    private static final String e = com/socialin/android/videogenerator/ActionCollector.getSimpleName();
    public Executor a;
    public Queue b;
    public boolean c;
    private boolean f;
    private a g;
    private File h;
    private ActionsInfo i;

    private ActionCollector()
    {
    }

    static ActionsInfo a(ActionCollector actioncollector)
    {
        return actioncollector.i;
    }

    static ActionsInfo a(ActionCollector actioncollector, ActionsInfo actionsinfo)
    {
        actioncollector.i = actionsinfo;
        return actionsinfo;
    }

    public static ActionsInfo a(File file)
    {
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        ActionsInfo actionsinfo;
        file = new ObjectInputStream(new FileInputStream(file));
        actionsinfo = (ActionsInfo)file.readObject();
        file.close();
        return actionsinfo;
        file;
_L4:
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
        });
_L2:
        return null;
        file;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ActionCollector a()
    {
        return d;
    }

    static void a(ActionCollector actioncollector, Action action)
    {
label0:
        {
            if (actioncollector.i != null)
            {
                if (!(action instanceof LayerConfigChangeAction))
                {
                    break label0;
                }
                actioncollector = actioncollector.i;
                actioncollector.shortActionsCount = ((ActionsInfo) (actioncollector)).shortActionsCount + 1;
            }
            return;
        }
        if (action instanceof UndoAction)
        {
            actioncollector = actioncollector.i;
            actioncollector.longActionsCount = ((ActionsInfo) (actioncollector)).longActionsCount - 1;
            return;
        }
        if (!(action instanceof RedoAction) && !action.isVisible())
        {
            actioncollector = actioncollector.i;
            actioncollector.invisibleActionsCount = ((ActionsInfo) (actioncollector)).invisibleActionsCount + 1;
            return;
        } else
        {
            actioncollector = actioncollector.i;
            actioncollector.longActionsCount = ((ActionsInfo) (actioncollector)).longActionsCount + 1;
            return;
        }
    }

    public static boolean a(String s)
    {
        return s.equals("image-data") || s.equals("tmp") || s.equals("actionsinfo.vnf") || s.equals("actions.vnf");
    }

    static File b(ActionCollector actioncollector)
    {
        return actioncollector.h;
    }

    static void b(ActionCollector actioncollector, ActionsInfo actionsinfo)
    {
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(new FileOutputStream(actioncollector.h));
        actioncollector = objectoutputstream;
        objectoutputstream.writeObject(actionsinfo);
        objectoutputstream.close();
_L2:
        return;
        actioncollector;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(actioncollector.getMessage()).toString()
        });
        return;
        IOException ioexception;
        ioexception;
        actionsinfo = null;
_L5:
        actioncollector = actionsinfo;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        if (actionsinfo == null) goto _L2; else goto _L1
_L1:
        try
        {
            actionsinfo.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ActionCollector actioncollector)
        {
            com.socialin.android.d.b(e, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(actioncollector.getMessage()).toString()
            });
        }
        return;
        actionsinfo;
        actioncollector = null;
_L4:
        if (actioncollector != null)
        {
            try
            {
                actioncollector.close();
            }
            // Misplaced declaration of an exception variable
            catch (ActionCollector actioncollector)
            {
                com.socialin.android.d.b(e, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(actioncollector.getMessage()).toString()
                });
            }
        }
        throw actionsinfo;
        actionsinfo;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        actionsinfo = objectoutputstream;
          goto _L5
    }

    private void b(Action action)
    {
        if (c)
        {
            a.execute(new Runnable(action) {

                private Action a;
                private ActionCollector b;

                public final void run()
                {
                    if (com.socialin.android.videogenerator.ActionCollector.a(b) == null)
                    {
                        com.socialin.android.videogenerator.ActionCollector.a(b, com.socialin.android.videogenerator.ActionCollector.a(ActionCollector.b(b)));
                    }
                    com.socialin.android.videogenerator.ActionCollector.a(b);
                    ActionCollector.c(b).a(a);
                    com.socialin.android.videogenerator.ActionCollector.a(b, a);
                    if (com.socialin.android.videogenerator.ActionCollector.a(b) != null)
                    {
                        ActionCollector.b(b, com.socialin.android.videogenerator.ActionCollector.a(b));
                    }
                }

            
            {
                b = ActionCollector.this;
                a = action;
                super();
            }
            });
        }
    }

    static a c(ActionCollector actioncollector)
    {
        return actioncollector.g;
    }

    private void c()
    {
        for (; b.peek() != null && (!(b.peek() instanceof AsyncAction) || ((AsyncAction)b.peek()).isReady()); b((Action)b.poll())) { }
    }

    private void c(Action action)
    {
        if ((action instanceof AsyncAction) || b.peek() != null)
        {
            b.add(action);
            return;
        } else
        {
            b(action);
            return;
        }
    }

    public final LayersMergeAction a(UUID uuid)
    {
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Action action = (Action)iterator.next();
            if (action instanceof LayersMergeAction)
            {
                List list = ((LayersMergeAction)action).getActions();
                int j = 0;
                while (j < list.size()) 
                {
                    Action action1 = (Action)list.get(j);
                    if ((action1 instanceof LayerAdditionAction) && ((LayerAdditionAction)action1).getLayerId().equals(uuid))
                    {
                        return (LayersMergeAction)action;
                    }
                    j++;
                }
            }
        } while (true);
        return null;
    }

    public final void a(Action action)
    {
label0:
        {
            Action action1;
label1:
            {
                if (c)
                {
                    if (!f)
                    {
                        action.setVisibile(false);
                    }
                    if (b.size() == 0)
                    {
                        break label0;
                    }
                    action1 = (Action)b.peek();
                    if (!(action1 instanceof LayersMergeAction))
                    {
                        break label0;
                    }
                    if (!((LayersMergeAction)action1).isComplete())
                    {
                        break label1;
                    }
                    c(action);
                }
                return;
            }
            ((LayersMergeAction)action1).addMergeAction(action);
            return;
        }
        c(action);
    }

    public final void a(AsyncAction asyncaction)
    {
        if (c)
        {
            asyncaction.setReady(true);
            if (asyncaction instanceof LayerAdditionAction)
            {
                asyncaction = a(((LayerAdditionAction)asyncaction).getLayerId());
                if (asyncaction != null && asyncaction.isComplete())
                {
                    asyncaction.setReady(true);
                }
                c();
            } else
            if (b.peek() == asyncaction)
            {
                c();
                return;
            }
        }
    }

    public final void a(File file, File file1, boolean flag)
    {
        c = flag;
        if (!flag) goto _L2; else goto _L1
_L1:
        a = Executors.newSingleThreadExecutor();
        f = true;
        if (file.length() <= 0L || file1.length() != 0L) goto _L4; else goto _L3
_L3:
        i = null;
_L6:
        g = new a(file);
        b = new LinkedList();
        g.a();
        h = file1;
_L2:
        return;
_L4:
        if (a(file1) == null)
        {
            i = new ActionsInfo();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final int b()
    {
        if (i != null)
        {
            return i.getActionsCount();
        } else
        {
            return 0;
        }
    }


    // Unreferenced inner class com/socialin/android/videogenerator/ActionCollector$2

/* anonymous class */
    public final class _cls2
        implements Runnable
    {

        private ActionCollector a;

        public final void run()
        {
            a a1;
            a1 = ActionCollector.c(a);
            if (a1.b == null)
            {
                break MISSING_BLOCK_LABEL_22;
            }
            a1.b.close();
            return;
            IOException ioexception;
            ioexception;
            com.socialin.android.d.b(a.a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
            });
            return;
        }

            public 
            {
                a = ActionCollector.this;
                super();
            }
    }


    private class ActionsInfo
        implements Serializable
    {

        private static final long serialVersionUID = 0x8aba5ac52b28303bL;
        public int invisibleActionsCount;
        public int longActionsCount;
        public int shortActionsCount;

        public int getActionsCount()
        {
            return shortActionsCount + longActionsCount;
        }

        public ActionsInfo()
        {
        }
    }

}
