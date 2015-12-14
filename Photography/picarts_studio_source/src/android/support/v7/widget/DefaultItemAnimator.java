// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends RecyclerView.ItemAnimator
{

    private static final boolean DEBUG = false;
    private ArrayList mAddAnimations;
    private ArrayList mAdditionsList;
    private ArrayList mChangeAnimations;
    private ArrayList mChangesList;
    private ArrayList mMoveAnimations;
    private ArrayList mMovesList;
    private ArrayList mPendingAdditions;
    private ArrayList mPendingChanges;
    private ArrayList mPendingMoves;
    private ArrayList mPendingRemovals;
    private ArrayList mRemoveAnimations;

    public DefaultItemAnimator()
    {
        mPendingRemovals = new ArrayList();
        mPendingAdditions = new ArrayList();
        mPendingMoves = new ArrayList();
        mPendingChanges = new ArrayList();
        mAdditionsList = new ArrayList();
        mMovesList = new ArrayList();
        mChangesList = new ArrayList();
        mAddAnimations = new ArrayList();
        mMoveAnimations = new ArrayList();
        mRemoveAnimations = new ArrayList();
        mChangeAnimations = new ArrayList();
    }

    private void animateAddImpl(RecyclerView.ViewHolder viewholder)
    {
        Object obj = viewholder.itemView;
        mAddAnimations.add(viewholder);
        obj = ViewCompat.animate(((android.view.View) (obj)));
        ((ViewPropertyAnimatorCompat) (obj)).alpha(1.0F).setDuration(getAddDuration()).setListener(new _cls5(viewholder, ((ViewPropertyAnimatorCompat) (obj)))).start();
    }

    private void animateChangeImpl(ChangeInfo changeinfo)
    {
        android.view.View view = null;
        Object obj = changeinfo.oldHolder;
        RecyclerView.ViewHolder viewholder;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((RecyclerView.ViewHolder) (obj)).itemView;
        }
        viewholder = changeinfo.newHolder;
        if (viewholder != null)
        {
            view = viewholder.itemView;
        }
        if (obj != null)
        {
            mChangeAnimations.add(changeinfo.oldHolder);
            obj = ViewCompat.animate(((android.view.View) (obj))).setDuration(getChangeDuration());
            ((ViewPropertyAnimatorCompat) (obj)).translationX(changeinfo.toX - changeinfo.fromX);
            ((ViewPropertyAnimatorCompat) (obj)).translationY(changeinfo.toY - changeinfo.fromY);
            ((ViewPropertyAnimatorCompat) (obj)).alpha(0.0F).setListener(new _cls7(changeinfo, ((ViewPropertyAnimatorCompat) (obj)))).start();
        }
        if (view != null)
        {
            mChangeAnimations.add(changeinfo.newHolder);
            obj = ViewCompat.animate(view);
            ((ViewPropertyAnimatorCompat) (obj)).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new _cls8(changeinfo, ((ViewPropertyAnimatorCompat) (obj)), view)).start();
        }
    }

    private void animateMoveImpl(RecyclerView.ViewHolder viewholder, int i, int j, int k, int l)
    {
        Object obj = viewholder.itemView;
        i = k - i;
        j = l - j;
        if (i != 0)
        {
            ViewCompat.animate(((android.view.View) (obj))).translationX(0.0F);
        }
        if (j != 0)
        {
            ViewCompat.animate(((android.view.View) (obj))).translationY(0.0F);
        }
        mMoveAnimations.add(viewholder);
        obj = ViewCompat.animate(((android.view.View) (obj)));
        ((ViewPropertyAnimatorCompat) (obj)).setDuration(getMoveDuration()).setListener(new _cls6(viewholder, i, j, ((ViewPropertyAnimatorCompat) (obj)))).start();
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewholder)
    {
        ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(viewholder.itemView);
        viewpropertyanimatorcompat.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new _cls4(viewholder, viewpropertyanimatorcompat)).start();
        mRemoveAnimations.add(viewholder);
    }

    private void dispatchFinishedWhenDone()
    {
        if (!isRunning())
        {
            dispatchAnimationsFinished();
        }
    }

    private void endChangeAnimation(List list, RecyclerView.ViewHolder viewholder)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            ChangeInfo changeinfo = (ChangeInfo)list.get(i);
            if (endChangeAnimationIfNecessary(changeinfo, viewholder) && changeinfo.oldHolder == null && changeinfo.newHolder == null)
            {
                list.remove(changeinfo);
            }
        }

    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeinfo)
    {
        if (changeinfo.oldHolder != null)
        {
            endChangeAnimationIfNecessary(changeinfo, changeinfo.oldHolder);
        }
        if (changeinfo.newHolder != null)
        {
            endChangeAnimationIfNecessary(changeinfo, changeinfo.newHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeinfo, RecyclerView.ViewHolder viewholder)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        if (changeinfo.newHolder != viewholder) goto _L2; else goto _L1
_L1:
        changeinfo.newHolder = null;
_L6:
        ViewCompat.setAlpha(viewholder.itemView, 1.0F);
        ViewCompat.setTranslationX(viewholder.itemView, 0.0F);
        ViewCompat.setTranslationY(viewholder.itemView, 0.0F);
        dispatchChangeFinished(viewholder, flag);
        flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (changeinfo.oldHolder != viewholder) goto _L4; else goto _L3
_L3:
        changeinfo.oldHolder = null;
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewholder)
    {
        endAnimation(viewholder);
        ViewCompat.setAlpha(viewholder.itemView, 0.0F);
        mPendingAdditions.add(viewholder);
        return true;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewholder, RecyclerView.ViewHolder viewholder1, int i, int j, int k, int l)
    {
        float f = ViewCompat.getTranslationX(viewholder.itemView);
        float f1 = ViewCompat.getTranslationY(viewholder.itemView);
        float f2 = ViewCompat.getAlpha(viewholder.itemView);
        endAnimation(viewholder);
        int i1 = (int)((float)(k - i) - f);
        int j1 = (int)((float)(l - j) - f1);
        ViewCompat.setTranslationX(viewholder.itemView, f);
        ViewCompat.setTranslationY(viewholder.itemView, f1);
        ViewCompat.setAlpha(viewholder.itemView, f2);
        if (viewholder1 != null && viewholder1.itemView != null)
        {
            endAnimation(viewholder1);
            ViewCompat.setTranslationX(viewholder1.itemView, -i1);
            ViewCompat.setTranslationY(viewholder1.itemView, -j1);
            ViewCompat.setAlpha(viewholder1.itemView, 0.0F);
        }
        mPendingChanges.add(new ChangeInfo(viewholder, viewholder1, i, j, k, l, null));
        return true;
    }

    public boolean animateMove(RecyclerView.ViewHolder viewholder, int i, int j, int k, int l)
    {
        android.view.View view = viewholder.itemView;
        i = (int)((float)i + ViewCompat.getTranslationX(viewholder.itemView));
        j = (int)((float)j + ViewCompat.getTranslationY(viewholder.itemView));
        endAnimation(viewholder);
        int i1 = k - i;
        int j1 = l - j;
        if (i1 == 0 && j1 == 0)
        {
            dispatchMoveFinished(viewholder);
            return false;
        }
        if (i1 != 0)
        {
            ViewCompat.setTranslationX(view, -i1);
        }
        if (j1 != 0)
        {
            ViewCompat.setTranslationY(view, -j1);
        }
        mPendingMoves.add(new MoveInfo(viewholder, i, j, k, l, null));
        return true;
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewholder)
    {
        endAnimation(viewholder);
        mPendingRemovals.add(viewholder);
        return true;
    }

    void cancelAll(List list)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            ViewCompat.animate(((RecyclerView.ViewHolder)list.get(i)).itemView).cancel();
        }

    }

    public void endAnimation(RecyclerView.ViewHolder viewholder)
    {
        android.view.View view = viewholder.itemView;
        ViewCompat.animate(view).cancel();
        for (int i = mPendingMoves.size() - 1; i >= 0; i--)
        {
            if (((MoveInfo)mPendingMoves.get(i)).holder == viewholder)
            {
                ViewCompat.setTranslationY(view, 0.0F);
                ViewCompat.setTranslationX(view, 0.0F);
                dispatchMoveFinished(viewholder);
                mPendingMoves.remove(i);
            }
        }

        endChangeAnimation(mPendingChanges, viewholder);
        if (mPendingRemovals.remove(viewholder))
        {
            ViewCompat.setAlpha(view, 1.0F);
            dispatchRemoveFinished(viewholder);
        }
        if (mPendingAdditions.remove(viewholder))
        {
            ViewCompat.setAlpha(view, 1.0F);
            dispatchAddFinished(viewholder);
        }
        for (int j = mChangesList.size() - 1; j >= 0; j--)
        {
            ArrayList arraylist = (ArrayList)mChangesList.get(j);
            endChangeAnimation(arraylist, viewholder);
            if (arraylist.isEmpty())
            {
                mChangesList.remove(j);
            }
        }

        int k = mMovesList.size() - 1;
label0:
        do
        {
            if (k >= 0)
            {
                ArrayList arraylist1 = (ArrayList)mMovesList.get(k);
                int i1 = arraylist1.size() - 1;
                do
                {
label1:
                    {
                        if (i1 >= 0)
                        {
                            if (((MoveInfo)arraylist1.get(i1)).holder != viewholder)
                            {
                                break label1;
                            }
                            ViewCompat.setTranslationY(view, 0.0F);
                            ViewCompat.setTranslationX(view, 0.0F);
                            dispatchMoveFinished(viewholder);
                            arraylist1.remove(i1);
                            if (arraylist1.isEmpty())
                            {
                                mMovesList.remove(k);
                            }
                        }
                        k--;
                        continue label0;
                    }
                    i1--;
                } while (true);
            }
            for (int l = mAdditionsList.size() - 1; l >= 0; l--)
            {
                ArrayList arraylist2 = (ArrayList)mAdditionsList.get(l);
                if (!arraylist2.remove(viewholder))
                {
                    continue;
                }
                ViewCompat.setAlpha(view, 1.0F);
                dispatchAddFinished(viewholder);
                if (arraylist2.isEmpty())
                {
                    mAdditionsList.remove(l);
                }
            }

            mRemoveAnimations.remove(viewholder);
            mAddAnimations.remove(viewholder);
            mChangeAnimations.remove(viewholder);
            mMoveAnimations.remove(viewholder);
            dispatchFinishedWhenDone();
            return;
        } while (true);
    }

    public void endAnimations()
    {
        for (int i = mPendingMoves.size() - 1; i >= 0; i--)
        {
            MoveInfo moveinfo = (MoveInfo)mPendingMoves.get(i);
            android.view.View view = moveinfo.holder.itemView;
            ViewCompat.setTranslationY(view, 0.0F);
            ViewCompat.setTranslationX(view, 0.0F);
            dispatchMoveFinished(moveinfo.holder);
            mPendingMoves.remove(i);
        }

        for (int j = mPendingRemovals.size() - 1; j >= 0; j--)
        {
            dispatchRemoveFinished((RecyclerView.ViewHolder)mPendingRemovals.get(j));
            mPendingRemovals.remove(j);
        }

        for (int k = mPendingAdditions.size() - 1; k >= 0; k--)
        {
            RecyclerView.ViewHolder viewholder = (RecyclerView.ViewHolder)mPendingAdditions.get(k);
            ViewCompat.setAlpha(viewholder.itemView, 1.0F);
            dispatchAddFinished(viewholder);
            mPendingAdditions.remove(k);
        }

        for (int l = mPendingChanges.size() - 1; l >= 0; l--)
        {
            endChangeAnimationIfNecessary((ChangeInfo)mPendingChanges.get(l));
        }

        mPendingChanges.clear();
        if (!isRunning())
        {
            return;
        }
        for (int i1 = mMovesList.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist = (ArrayList)mMovesList.get(i1);
            for (int l1 = arraylist.size() - 1; l1 >= 0; l1--)
            {
                MoveInfo moveinfo1 = (MoveInfo)arraylist.get(l1);
                android.view.View view1 = moveinfo1.holder.itemView;
                ViewCompat.setTranslationY(view1, 0.0F);
                ViewCompat.setTranslationX(view1, 0.0F);
                dispatchMoveFinished(moveinfo1.holder);
                arraylist.remove(l1);
                if (arraylist.isEmpty())
                {
                    mMovesList.remove(arraylist);
                }
            }

        }

        for (int j1 = mAdditionsList.size() - 1; j1 >= 0; j1--)
        {
            ArrayList arraylist1 = (ArrayList)mAdditionsList.get(j1);
            for (int i2 = arraylist1.size() - 1; i2 >= 0; i2--)
            {
                RecyclerView.ViewHolder viewholder1 = (RecyclerView.ViewHolder)arraylist1.get(i2);
                ViewCompat.setAlpha(viewholder1.itemView, 1.0F);
                dispatchAddFinished(viewholder1);
                arraylist1.remove(i2);
                if (arraylist1.isEmpty())
                {
                    mAdditionsList.remove(arraylist1);
                }
            }

        }

        for (int k1 = mChangesList.size() - 1; k1 >= 0; k1--)
        {
            ArrayList arraylist2 = (ArrayList)mChangesList.get(k1);
            for (int j2 = arraylist2.size() - 1; j2 >= 0; j2--)
            {
                endChangeAnimationIfNecessary((ChangeInfo)arraylist2.get(j2));
                if (arraylist2.isEmpty())
                {
                    mChangesList.remove(arraylist2);
                }
            }

        }

        cancelAll(mRemoveAnimations);
        cancelAll(mMoveAnimations);
        cancelAll(mAddAnimations);
        cancelAll(mChangeAnimations);
        dispatchAnimationsFinished();
    }

    public boolean isRunning()
    {
        return !mPendingAdditions.isEmpty() || !mPendingChanges.isEmpty() || !mPendingMoves.isEmpty() || !mPendingRemovals.isEmpty() || !mMoveAnimations.isEmpty() || !mRemoveAnimations.isEmpty() || !mAddAnimations.isEmpty() || !mChangeAnimations.isEmpty() || !mMovesList.isEmpty() || !mAdditionsList.isEmpty() || !mChangesList.isEmpty();
    }

    public void runPendingAnimations()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (!mPendingRemovals.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!mPendingMoves.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!mPendingChanges.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!mPendingAdditions.isEmpty())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag || flag1 || flag3 || flag2)
        {
            for (Iterator iterator = mPendingRemovals.iterator(); iterator.hasNext(); animateRemoveImpl((RecyclerView.ViewHolder)iterator.next())) { }
            mPendingRemovals.clear();
            Object obj;
            if (flag1)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(mPendingMoves);
                mMovesList.add(arraylist);
                mPendingMoves.clear();
                obj = new _cls1(arraylist);
                if (flag)
                {
                    ViewCompat.postOnAnimationDelayed(((MoveInfo)arraylist.get(0)).holder.itemView, ((Runnable) (obj)), getRemoveDuration());
                } else
                {
                    ((Runnable) (obj)).run();
                }
            }
            if (flag2)
            {
                arraylist = new ArrayList();
                arraylist.addAll(mPendingChanges);
                mChangesList.add(arraylist);
                mPendingChanges.clear();
                obj = new _cls2(arraylist);
                if (flag)
                {
                    ViewCompat.postOnAnimationDelayed(((ChangeInfo)arraylist.get(0)).oldHolder.itemView, ((Runnable) (obj)), getRemoveDuration());
                } else
                {
                    ((Runnable) (obj)).run();
                }
            }
            if (flag3)
            {
                arraylist = new ArrayList();
                arraylist.addAll(mPendingAdditions);
                mAdditionsList.add(arraylist);
                mPendingAdditions.clear();
                obj = new _cls3(arraylist);
                if (flag || flag1 || flag2)
                {
                    long l;
                    long l1;
                    long l2;
                    if (flag)
                    {
                        l = getRemoveDuration();
                    } else
                    {
                        l = 0L;
                    }
                    if (flag1)
                    {
                        l1 = getMoveDuration();
                    } else
                    {
                        l1 = 0L;
                    }
                    if (flag2)
                    {
                        l2 = getChangeDuration();
                    } else
                    {
                        l2 = 0L;
                    }
                    l1 = Math.max(l1, l2);
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)arraylist.get(0)).itemView, ((Runnable) (obj)), l + l1);
                    return;
                } else
                {
                    ((Runnable) (obj)).run();
                    return;
                }
            }
        }
    }












    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class ChangeInfo {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class MoveInfo {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
