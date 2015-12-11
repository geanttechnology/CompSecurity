// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.graphics.Bitmap;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebServiceHandler, AkWebservice, AkAddQuestionWS, AkAddPhotoWS, 
//            AkAnswerWS, AkCancelAnswerWS, AkExclusionWS, SessionFactory, 
//            AkListWS, AkSoundlikeSearchWS, AkSearchQuestionWS, AkReportWS, 
//            AkChoiceWS, AkNewElementWS, AkSignalerDoublon, AkSoundlikeAcceptanceWS

public class Session
    implements AkWebServiceHandler
{
    public static class LimuleObject
        implements Serializable
    {

        private String mDescription;
        private int mId_base;
        private String mName;

        public String getDescription()
        {
            return mDescription;
        }

        public int getIdBase()
        {
            return mId_base;
        }

        public String getName()
        {
            return mName;
        }

        public void setDescription(String s)
        {
            mDescription = s;
        }

        public void setIdBase(int i)
        {
            mId_base = i;
        }

        public void setName(String s)
        {
            mName = s;
        }

        public LimuleObject()
        {
        }

        public LimuleObject(int i, String s, String s1)
        {
            mId_base = i;
            mName = s;
            mDescription = s1;
        }
    }

    public static class LimuleObjectStats
        implements Serializable
    {

        private int mDelayAward;
        private int mFlagPhoto;
        private int mIdBase;
        private int mNbPlayed;
        private String mPreviousTime;

        public int getDelayAward()
        {
            return mDelayAward;
        }

        public int getFlagPhoto()
        {
            return mFlagPhoto;
        }

        public int getIdBase()
        {
            return mIdBase;
        }

        public int getNbPlayed()
        {
            return mNbPlayed;
        }

        public String getPreviousTime()
        {
            return mPreviousTime;
        }

        public void setDelayAward(int i)
        {
            mDelayAward = i;
        }

        public void setFlagPhoto(int i)
        {
            mFlagPhoto = i;
        }

        public void setIdBase(int i)
        {
            mIdBase = i;
        }

        public void setNbPlayed(int i)
        {
            mNbPlayed = i;
        }

        public void setPreviousTime(String s)
        {
            mPreviousTime = s;
        }



/*
        static int access$402(LimuleObjectStats limuleobjectstats, int i)
        {
            limuleobjectstats.mIdBase = i;
            return i;
        }

*/



/*
        static int access$502(LimuleObjectStats limuleobjectstats, int i)
        {
            limuleobjectstats.mNbPlayed = i;
            return i;
        }

*/



/*
        static int access$602(LimuleObjectStats limuleobjectstats, int i)
        {
            limuleobjectstats.mDelayAward = i;
            return i;
        }

*/



/*
        static String access$702(LimuleObjectStats limuleobjectstats, String s)
        {
            limuleobjectstats.mPreviousTime = s;
            return s;
        }

*/



/*
        static int access$802(LimuleObjectStats limuleobjectstats, int i)
        {
            limuleobjectstats.mFlagPhoto = i;
            return i;
        }

*/

        public LimuleObjectStats()
        {
        }

        public LimuleObjectStats(int i, int j, int k, String s, int l)
        {
            mNbPlayed = i;
            mIdBase = j;
            mFlagPhoto = k;
            mPreviousTime = s;
            mDelayAward = l;
        }
    }

    public static class ObjectAnswer
        implements Serializable
    {

        private int mIndex;
        private String mValue;

        public int getIndex()
        {
            return mIndex;
        }

        public String getValue()
        {
            return mValue;
        }

        public ObjectAnswer()
        {
        }

        public ObjectAnswer(int i, String s)
        {
            mIndex = i;
            mValue = s;
        }
    }

    public static class ObjectReport
        implements Serializable
    {

        private String mAnswerExpected;
        private String mAnswerGiven;
        private String mQuestionLabel;

        public String getExpectedAnswer()
        {
            return mAnswerExpected;
        }

        public String getGivenAnswer()
        {
            return mAnswerGiven;
        }

        public String getQuestionLabel()
        {
            return mQuestionLabel;
        }

        public void setAnswerExpected(String s)
        {
            mAnswerExpected = s;
        }

        public void setGivenAnswer(String s)
        {
            mAnswerGiven = s;
        }

        public void setQuestionLabel(String s)
        {
            mQuestionLabel = s;
        }

        public ObjectReport()
        {
        }

        public ObjectReport(String s, String s1, String s2)
        {
            mQuestionLabel = s;
            mAnswerExpected = s1;
            mAnswerExpected = s2;
        }
    }

    public static class ProposedLimuleObject extends LimuleObject
    {

        private boolean mDoesValidateConstraint;
        private int mIdInSession;
        private String mPicturePath;
        private int mRanking_limit;

        public int getIdSession()
        {
            return mIdInSession;
        }

        public String getPicturePath()
        {
            return mPicturePath;
        }

        public int getRankingLimit()
        {
            return mRanking_limit;
        }

        public boolean isValidateConstraint()
        {
            return mDoesValidateConstraint;
        }

        public void setIdSession(int i)
        {
            mIdInSession = i;
        }

        public void setPicturePath(String s)
        {
            mPicturePath = s;
        }

        public void setRankingLimit(int i)
        {
            mRanking_limit = i;
        }

        public void setValideConstrait(boolean flag)
        {
            mDoesValidateConstraint = flag;
        }

        public ProposedLimuleObject()
        {
        }

        public ProposedLimuleObject(int i, String s, String s1, int j, String s2, boolean flag, int k)
        {
            super(i, s, s1);
            mIdInSession = j;
            mPicturePath = s2;
            mDoesValidateConstraint = flag;
            mRanking_limit = k;
        }
    }

    public static class ProposedLimuleObjectMinibase extends ProposedLimuleObject
    {

        private int mElementMinibaseId;
        private boolean mMyWorldAddable;
        private int mNbPlayed;

        public int getElementMinibaseId()
        {
            return mElementMinibaseId;
        }

        public int getNbPlayed()
        {
            return mNbPlayed;
        }

        public boolean isMyWorldAddable()
        {
            return mMyWorldAddable;
        }

        public void setElementMinibaseId(int i)
        {
            mElementMinibaseId = i;
        }

        public void setMyWorldAddable(boolean flag)
        {
            mMyWorldAddable = flag;
        }

        public void setNbPlayed(int i)
        {
            mNbPlayed = i;
        }

        public ProposedLimuleObjectMinibase()
        {
            mMyWorldAddable = false;
            mElementMinibaseId = -1;
            mNbPlayed = 0;
        }

        public ProposedLimuleObjectMinibase(int i, String s, String s1, int j, String s2, boolean flag, int k, 
                boolean flag1, int l)
        {
            super(i, s, s1, j, s2, flag, k);
            mMyWorldAddable = false;
            mElementMinibaseId = -1;
            mNbPlayed = 0;
            mMyWorldAddable = flag1;
            mElementMinibaseId = l;
        }
    }

    public static class QuestionObject
        implements Serializable
    {

        private int mId;
        private String mQuestion;
        private boolean mValidated;

        public int getId()
        {
            return mId;
        }

        public String getQuestion()
        {
            return mQuestion;
        }

        public boolean isValidated()
        {
            return mValidated;
        }

        public void setId(int i)
        {
            mId = i;
        }

        public void setQuestion(String s)
        {
            mQuestion = s;
        }

        public void setValidated(boolean flag)
        {
            mValidated = flag;
        }

        public QuestionObject()
        {
        }
    }

    public static class QuestionProgression
        implements Serializable
    {

        private ArrayList mAnswers;
        private float mProgress;
        private String mQuestion;
        private int mStep;

        public ArrayList getAnswers()
        {
            return mAnswers;
        }

        public float getProgression()
        {
            return mProgress;
        }

        public String getQuestion()
        {
            return mQuestion;
        }

        public int getStep()
        {
            return mStep;
        }



/*
        static int access$002(QuestionProgression questionprogression, int i)
        {
            questionprogression.mStep = i;
            return i;
        }

*/



/*
        static String access$102(QuestionProgression questionprogression, String s)
        {
            questionprogression.mQuestion = s;
            return s;
        }

*/



/*
        static float access$202(QuestionProgression questionprogression, float f)
        {
            questionprogression.mProgress = f;
            return f;
        }

*/



/*
        static ArrayList access$302(QuestionProgression questionprogression, ArrayList arraylist)
        {
            questionprogression.mAnswers = arraylist;
            return arraylist;
        }

*/

        public QuestionProgression()
        {
        }
    }


    private static ArrayList mLastDelayAnswers = new ArrayList();
    private String mChannel;
    private boolean mIsActive;
    private boolean mIsMinibaseActivated;
    private boolean mIsOnlyMinibaseActivated;
    private ArrayList mListofObjectsProposed;
    private int mNbObjectPertinent;
    private LimuleObject mObjectProposed;
    private ArrayList mQuestions;
    private ArrayList mReport;
    private String mSession;
    private QuestionProgression mSessionState;
    private String mSignature;
    private LimuleObjectStats mStats;

    protected Session(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        mIsActive = false;
        mIsMinibaseActivated = false;
        mIsOnlyMinibaseActivated = false;
        mChannel = "";
        mSession = "";
        mSignature = "";
        mListofObjectsProposed = new ArrayList();
        mObjectProposed = new LimuleObject();
        mSessionState = new QuestionProgression();
        mStats = new LimuleObjectStats();
        mQuestions = new ArrayList();
        mReport = new ArrayList();
        mChannel = s;
        mSession = s1;
        mSignature = s2;
        mIsMinibaseActivated = flag;
        mIsOnlyMinibaseActivated = flag1;
    }

    private void updateDelayMoyen(long l)
    {
        if (mLastDelayAnswers == null)
        {
            mLastDelayAnswers = new ArrayList();
        }
        if (mLastDelayAnswers.size() >= 5)
        {
            mLastDelayAnswers.remove(0);
        }
        mLastDelayAnswers.add(Long.valueOf(l));
        l = 0L;
        Iterator iterator = mLastDelayAnswers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Long long1 = (Long)iterator.next();
            if (long1.longValue() > l)
            {
                l = long1.longValue();
            }
        } while (true);
        AkWebservice.TIMEOUT_DEFAULT_ANSWERS = (int)Math.max(10000L, 2L * l);
    }

    public int addNewQuestionWithLabelAndAnswers(String s, ArrayList arraylist)
    {
        if (arraylist == null || s == null || s.equals(""))
        {
            return 100;
        } else
        {
            return (new AkAddQuestionWS(s, arraylist)).call();
        }
    }

    public int addPhotoToObjectWithId(int i, Bitmap bitmap)
    {
        if (i < 0 || bitmap == null)
        {
            return 100;
        }
        if (mIsActive)
        {
            return 200;
        } else
        {
            return (new AkAddPhotoWS(i, bitmap)).call();
        }
    }

    public int addPhotoToObjectWithId(int i, File file)
    {
        if (i < 0 || file == null)
        {
            return 100;
        }
        if (mIsActive)
        {
            return 200;
        } else
        {
            return (new AkAddPhotoWS(i, file)).call();
        }
    }

    public int answerQuestionWithTag(int i)
    {
        if (mSessionState == null)
        {
            return 400;
        }
        long l = System.currentTimeMillis();
        i = (new AkAnswerWS(i)).call();
        long l1 = System.currentTimeMillis();
        if (i == 300)
        {
            updateSessionState(null, null, mSessionState.mStep + 1, 100F);
        }
        updateDelayMoyen(l1 - l);
        return i;
    }

    public int answerQuestionWithTag(int i, QuestionProgression questionprogression)
    {
        if (questionprogression == null)
        {
            return 100;
        }
        if (mSessionState == null)
        {
            return 400;
        }
        long l = System.currentTimeMillis();
        i = (new AkAnswerWS(i)).call();
        long l1 = System.currentTimeMillis();
        if (i == 0)
        {
            questionprogression.mStep = mSessionState.mStep;
            questionprogression.mQuestion = mSessionState.mQuestion;
            questionprogression.mProgress = mSessionState.mProgress;
            questionprogression.mAnswers = mSessionState.mAnswers;
        }
        updateDelayMoyen(l1 - l);
        return i;
    }

    public int cancelAnswer(QuestionProgression questionprogression)
    {
        if (questionprogression == null)
        {
            return 100;
        }
        if (mSessionState == null)
        {
            return 400;
        }
        int i = (new AkCancelAnswerWS()).call();
        if (i == 0)
        {
            questionprogression.mStep = mSessionState.mStep;
            questionprogression.mQuestion = mSessionState.mQuestion;
            questionprogression.mProgress = mSessionState.mProgress;
            questionprogression.mAnswers = mSessionState.mAnswers;
            return i;
        } else
        {
            return i;
        }
    }

    public int excludeProposition()
    {
        int i;
        if (!mIsActive)
        {
            i = 200;
        } else
        {
            int j = (new AkExclusionWS()).call();
            i = j;
            if (j == 0)
            {
                return answerQuestionWithTag(-1);
            }
        }
        return i;
    }

    public String getChannel()
    {
        return mChannel;
    }

    public ArrayList getCurrentListofProposedObjects()
    {
        return mListofObjectsProposed;
    }

    public ArrayList getCurrentListofQuestions()
    {
        return mQuestions;
    }

    public LimuleObject getCurrentProposedObject()
    {
        return mObjectProposed;
    }

    public ArrayList getCurrentReport()
    {
        return mReport;
    }

    public QuestionProgression getCurrentSessionProgression()
    {
        return mSessionState;
    }

    public LimuleObjectStats getCurrentStats()
    {
        return mStats;
    }

    public int getNbPertinentObjects()
    {
        return mNbObjectPertinent;
    }

    public int getObjectForProposition(ProposedLimuleObject proposedlimuleobject)
    {
        if (SessionFactory.sharedInstance().getHauteurPhoto() == -1 || SessionFactory.sharedInstance().getLargeurPhoto() == -1 || proposedlimuleobject == null)
        {
            return 100;
        }
        Object obj = new AkListWS(1, false);
        int i = ((AkListWS) (obj)).call();
        if (i == 0)
        {
            obj = (ProposedLimuleObject)((AkListWS) (obj)).getLimuleObjects().get(0);
            proposedlimuleobject.setRankingLimit(((ProposedLimuleObject) (obj)).getRankingLimit());
            proposedlimuleobject.setValideConstrait(((ProposedLimuleObject) (obj)).isValidateConstraint());
            proposedlimuleobject.setIdSession(((ProposedLimuleObject) (obj)).getIdSession());
            proposedlimuleobject.setIdBase(((ProposedLimuleObject) (obj)).getIdBase());
            proposedlimuleobject.setDescription(((ProposedLimuleObject) (obj)).getDescription());
            proposedlimuleobject.setPicturePath(((ProposedLimuleObject) (obj)).getPicturePath());
            proposedlimuleobject.setName(((ProposedLimuleObject) (obj)).getName());
            return i;
        } else
        {
            return i;
        }
    }

    public int getObjectForPropositionWithMinibaseEnabled(ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        if (SessionFactory.sharedInstance().getHauteurPhoto() == -1 || SessionFactory.sharedInstance().getLargeurPhoto() == -1 || proposedlimuleobjectminibase == null)
        {
            return 100;
        }
        Object obj = new AkListWS(1, false);
        int i = ((AkListWS) (obj)).call();
        if (i == 0)
        {
            obj = (ProposedLimuleObjectMinibase)((AkListWS) (obj)).getLimuleObjects().get(0);
            proposedlimuleobjectminibase.setRankingLimit(((ProposedLimuleObjectMinibase) (obj)).getRankingLimit());
            proposedlimuleobjectminibase.setValideConstrait(((ProposedLimuleObjectMinibase) (obj)).isValidateConstraint());
            proposedlimuleobjectminibase.setIdSession(((ProposedLimuleObjectMinibase) (obj)).getIdSession());
            proposedlimuleobjectminibase.setIdBase(((ProposedLimuleObjectMinibase) (obj)).getIdBase());
            proposedlimuleobjectminibase.setDescription(((ProposedLimuleObjectMinibase) (obj)).getDescription());
            proposedlimuleobjectminibase.setPicturePath(((ProposedLimuleObjectMinibase) (obj)).getPicturePath());
            proposedlimuleobjectminibase.setName(((ProposedLimuleObjectMinibase) (obj)).getName());
            proposedlimuleobjectminibase.setElementMinibaseId(((ProposedLimuleObjectMinibase) (obj)).getElementMinibaseId());
            proposedlimuleobjectminibase.setMyWorldAddable(((ProposedLimuleObjectMinibase) (obj)).isMyWorldAddable());
            proposedlimuleobjectminibase.setNbPlayed(((ProposedLimuleObjectMinibase) (obj)).getNbPlayed());
            return i;
        } else
        {
            return i;
        }
    }

    public int getObjectsForQuestionWithListSize(int i, ArrayList arraylist)
    {
        if (i > 0 && i <= 50 && arraylist != null) goto _L2; else goto _L1
_L1:
        i = 100;
_L4:
        return i;
_L2:
        int j;
label0:
        {
            Object obj = new AkListWS(i, true);
            j = ((AkListWS) (obj)).call();
            if (j != 0)
            {
                break label0;
            }
            obj = ((AkListWS) (obj)).getLimuleObjects().iterator();
            do
            {
                i = j;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                arraylist.add((LimuleObject)((Iterator) (obj)).next());
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public int getObjectsFromString(String s, ArrayList arraylist)
    {
        if (mIsActive) goto _L2; else goto _L1
_L1:
        int i = 200;
_L4:
        return i;
_L2:
        int j;
label0:
        {
            if (arraylist == null)
            {
                return 400;
            }
            s = new AkSoundlikeSearchWS(s);
            j = s.call();
            if (j != 0)
            {
                break label0;
            }
            s = s.getListofLimuleObjects().iterator();
            do
            {
                i = j;
                if (!s.hasNext())
                {
                    break;
                }
                arraylist.add((LimuleObject)s.next());
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public int getObjectsWithListSize(int i, ArrayList arraylist)
    {
        if (i > 0 && i <= 50 && arraylist != null) goto _L2; else goto _L1
_L1:
        i = 100;
_L4:
        return i;
_L2:
        int j;
label0:
        {
            if (!mIsActive)
            {
                return 200;
            }
            Object obj = new AkListWS(i, false);
            j = ((AkListWS) (obj)).call();
            if (j != 0)
            {
                break label0;
            }
            obj = ((AkListWS) (obj)).getLimuleObjects().iterator();
            do
            {
                i = j;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                arraylist.add((ProposedLimuleObject)(LimuleObject)((Iterator) (obj)).next());
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public int getQuestionsFromString(String s, ArrayList arraylist)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        int i = 100;
_L4:
        return i;
_L2:
        int j;
label0:
        {
            s = new AkSearchQuestionWS(s);
            j = s.call();
            if (j != 0)
            {
                break label0;
            }
            s = s.getListOfQuestions().iterator();
            do
            {
                i = j;
                if (!s.hasNext())
                {
                    break;
                }
                arraylist.add((QuestionObject)s.next());
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public int getReport(ArrayList arraylist)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        int i = 100;
_L4:
        return i;
_L2:
        int j;
label0:
        {
            if (mIsActive)
            {
                return 200;
            }
            Object obj = new AkReportWS();
            j = ((AkReportWS) (obj)).call();
            if (j != 0)
            {
                break label0;
            }
            obj = ((AkReportWS) (obj)).getReport().iterator();
            do
            {
                i = j;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                arraylist.add((ObjectReport)((Iterator) (obj)).next());
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public String getSession()
    {
        return mSession;
    }

    public String getSignature()
    {
        return mSignature;
    }

    public void handleWSCallCompleted(AkWebservice akwebservice)
    {
        if (akwebservice instanceof AkAnswerWS)
        {
            akwebservice = (AkAnswerWS)akwebservice;
            updateSessionState(akwebservice.getQuestion(), akwebservice.getAnswers(), akwebservice.getStep(), akwebservice.getProgression());
        } else
        {
            if (akwebservice instanceof AkCancelAnswerWS)
            {
                akwebservice = (AkCancelAnswerWS)akwebservice;
                updateSessionState(akwebservice.getQuestion(), akwebservice.getAnswers(), akwebservice.getStep(), akwebservice.getProgression());
                return;
            }
            if (akwebservice instanceof AkChoiceWS)
            {
                akwebservice = (AkChoiceWS)akwebservice;
                updateStats(akwebservice.getLimuleObjectStats());
                if (mListofObjectsProposed.size() > 0)
                {
                    Iterator iterator = mListofObjectsProposed.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        LimuleObject limuleobject = (LimuleObject)iterator.next();
                        if (((ProposedLimuleObject)limuleobject).getIdSession() == akwebservice.getIdSession())
                        {
                            updateObjectProposed(limuleobject, mNbObjectPertinent);
                        }
                    } while (true);
                }
                mIsActive = false;
                return;
            }
            if (akwebservice instanceof AkListWS)
            {
                akwebservice = (AkListWS)akwebservice;
                if (akwebservice.isModeObjectPropose())
                {
                    updateObjectProposed((LimuleObject)akwebservice.getLimuleObjects().get(0), akwebservice.getNbObjetsPertinents());
                }
                updateListOfObjectsProposed(akwebservice.getLimuleObjects(), akwebservice.getNbObjetsPertinents());
                return;
            }
            if (akwebservice instanceof AkSearchQuestionWS)
            {
                updateQuestions(((AkSearchQuestionWS)akwebservice).getListOfQuestions());
                return;
            }
            if (akwebservice instanceof AkReportWS)
            {
                updateReport(((AkReportWS)akwebservice).getReport());
                return;
            }
        }
    }

    public boolean isActive()
    {
        return mIsActive;
    }

    public boolean isMiniBaseActivited()
    {
        return mIsMinibaseActivated;
    }

    public boolean isOnlyMiniBaseActivited()
    {
        return mIsOnlyMinibaseActivated;
    }

    public int modifyQuestionWithId(int i, String s, ArrayList arraylist)
    {
        if (i < 0 || s == null || s.equals("") || arraylist == null)
        {
            return 100;
        } else
        {
            s = new AkAddQuestionWS(s, arraylist);
            s.setQuestionId(i);
            return s.call();
        }
    }

    public int newElementWithNameAndDescription(String s, String s1)
    {
        while (s == null || s.equals("") || s1 == null || s1.equals("")) 
        {
            return 100;
        }
        if (!mIsActive)
        {
            return 200;
        } else
        {
            return (new AkNewElementWS(s, s1)).call();
        }
    }

    public int reportDuplicatesWithArray(ArrayList arraylist, boolean flag)
    {
        if (!mIsActive)
        {
            return 200;
        } else
        {
            return (new AkSignalerDoublon(arraylist, flag)).call();
        }
    }

    protected void reset()
    {
        updateSessionState(null, null, -1, -1F);
        mStats = null;
        mQuestions.clear();
        mListofObjectsProposed.clear();
        mObjectProposed = null;
        mReport.clear();
    }

    public void setActive(boolean flag)
    {
        mIsActive = flag;
    }

    public int soundlikeAcceptanceObjectAtIndex(int i)
    {
        if (!mIsActive)
        {
            i = 200;
        } else
        {
            int j = (new AkSoundlikeAcceptanceWS(i)).call();
            i = j;
            if (j == 0)
            {
                mIsActive = false;
                return j;
            }
        }
        return i;
    }

    protected void updateListOfObjectsProposed(ArrayList arraylist, int i)
    {
        mListofObjectsProposed.clear();
        mNbObjectPertinent = i;
        LimuleObject limuleobject;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); mListofObjectsProposed.add(limuleobject))
        {
            limuleobject = (LimuleObject)arraylist.next();
        }

    }

    protected void updateObjectProposed(LimuleObject limuleobject, int i)
    {
        mObjectProposed = limuleobject;
        mNbObjectPertinent = i;
    }

    protected void updateObjectProposedWithMinibaseParam(String s, int i)
    {
        mObjectProposed.setName(s);
        ((ProposedLimuleObjectMinibase)mObjectProposed).setElementMinibaseId(i);
    }

    protected void updateQuestions(ArrayList arraylist)
    {
        mQuestions.clear();
        QuestionObject questionobject;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); mQuestions.add(questionobject))
        {
            questionobject = (QuestionObject)arraylist.next();
        }

    }

    protected void updateReport(ArrayList arraylist)
    {
        mReport.clear();
        ObjectReport objectreport;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); mReport.add(objectreport))
        {
            objectreport = (ObjectReport)arraylist.next();
        }

    }

    protected void updateSessionState(String s, ArrayList arraylist, int i, float f)
    {
        mSessionState.mQuestion = s;
        mSessionState.mStep = i;
        mSessionState.mProgress = f;
        mSessionState.mAnswers = arraylist;
    }

    protected void updateStats(LimuleObjectStats limuleobjectstats)
    {
        mStats = limuleobjectstats;
    }

    public int validateObjectWithId(int i)
    {
        if (i < 0)
        {
            return 100;
        } else
        {
            return (new AkChoiceWS(i, false)).call();
        }
    }

    public int validateObjectWithId(int i, LimuleObjectStats limuleobjectstats)
    {
        if (i < 0 || limuleobjectstats == null)
        {
            return 100;
        }
        Object obj = new AkChoiceWS(i, false);
        i = ((AkChoiceWS) (obj)).call();
        if (i == 0)
        {
            obj = ((AkChoiceWS) (obj)).getLimuleObjectStats();
            limuleobjectstats.mIdBase = ((LimuleObjectStats) (obj)).mIdBase;
            limuleobjectstats.mNbPlayed = ((LimuleObjectStats) (obj)).mNbPlayed;
            limuleobjectstats.mDelayAward = ((LimuleObjectStats) (obj)).mDelayAward;
            limuleobjectstats.mPreviousTime = ((LimuleObjectStats) (obj)).mPreviousTime;
            limuleobjectstats.mFlagPhoto = ((LimuleObjectStats) (obj)).mFlagPhoto;
            return i;
        } else
        {
            return i;
        }
    }

    public int validateObjectWithIdWithJackpot(int i)
    {
        if (i < 0)
        {
            return 100;
        } else
        {
            return (new AkChoiceWS(i, true)).call();
        }
    }

}
