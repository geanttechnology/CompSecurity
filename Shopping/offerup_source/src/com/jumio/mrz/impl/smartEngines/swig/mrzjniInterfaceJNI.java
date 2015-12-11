// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            MrzResult, StreamReporterInterface, MrzRectMatrix, MrzDateField, 
//            MrzDate, MrzEngineSessionHelpers, MrzEngineSessionSettings, MrzEngine, 
//            MrzRect, MrzField, MrzOcrCharVariantVector, MrzOcrCharVariant, 
//            MrzOcrCharVector, MrzOcrChar, MrzOcrStringVector, MrzOcrString, 
//            MrzRectVector, StringVector, MrzEngineInternalSettings

public class mrzjniInterfaceJNI
{

    public mrzjniInterfaceJNI()
    {
    }

    public static final native long MrzDateField_SWIGUpcast(long l);

    public static final native long MrzDateField_getAsMrzDate(long l, MrzDateField mrzdatefield);

    public static final native int MrzDate_getDay(long l, MrzDate mrzdate);

    public static final native int MrzDate_getMonth(long l, MrzDate mrzdate);

    public static final native int MrzDate_getYear(long l, MrzDate mrzdate);

    public static final native boolean MrzDate_isDayPresent(long l, MrzDate mrzdate);

    public static final native boolean MrzDate_isMonthPresent(long l, MrzDate mrzdate);

    public static final native boolean MrzDate_isYearPresent(long l, MrzDate mrzdate);

    public static final native void MrzDate_setDay(long l, MrzDate mrzdate, int i);

    public static final native void MrzDate_setMonth(long l, MrzDate mrzdate, int i);

    public static final native void MrzDate_setYear(long l, MrzDate mrzdate, int i);

    public static final native long MrzEngineInternalSettings_createFromFilesystem(String s);

    public static final native double MrzEngineSessionHelpers_get_optimal_aspect_ratio(long l, MrzEngineSessionHelpers mrzenginesessionhelpers);

    public static final native void MrzEngineSessionHelpers_set_optimal_aspect_ratio(long l, MrzEngineSessionHelpers mrzenginesessionhelpers, double d);

    public static final native boolean MrzEngineSessionSettings_get_cnis_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_m3z_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_mrp_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_mrva_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_mrvb_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native int MrzEngineSessionSettings_get_number_of_threads(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_postprocess(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_recognize_in_parallel(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_focus(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_output(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_segmentation(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_segment_best_effort(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_should_segment_in_parallel(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_td1_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native boolean MrzEngineSessionSettings_get_td2_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native void MrzEngineSessionSettings_set_cnis_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_m3z_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_mrp_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_mrva_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_mrvb_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_number_of_threads(long l, MrzEngineSessionSettings mrzenginesessionsettings, int i);

    public static final native void MrzEngineSessionSettings_set_should_postprocess(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_recognize_in_parallel(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_focus(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_output(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_segmentation(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_segment_best_effort(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_should_segment_in_parallel(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_td1_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngineSessionSettings_set_td2_support_enabled(long l, MrzEngineSessionSettings mrzenginesessionsettings, boolean flag);

    public static final native void MrzEngine_FeedImageFile__SWIG_0(long l, MrzEngine mrzengine, String s, int i);

    public static final native void MrzEngine_FeedImageFile__SWIG_1(long l, MrzEngine mrzengine, String s);

    public static final native void MrzEngine_FeedUncompressedImageData__SWIG_0(long l, MrzEngine mrzengine, byte abyte0[], int i, int j, int k, int i1, 
            long l1, MrzRect mrzrect, int j1);

    public static final native void MrzEngine_FeedUncompressedImageData__SWIG_1(long l, MrzEngine mrzengine, byte abyte0[], int i, int j, int k, int i1, 
            long l1, MrzRect mrzrect);

    public static final native void MrzEngine_FeedUncompressedYUVImageData__SWIG_0(long l, MrzEngine mrzengine, byte abyte0[], int i, int j, int k, long l1, MrzRect mrzrect, int i1);

    public static final native void MrzEngine_FeedUncompressedYUVImageData__SWIG_1(long l, MrzEngine mrzengine, byte abyte0[], int i, int j, int k, long l1, MrzRect mrzrect);

    public static final native void MrzEngine_InitializeSession__SWIG_0(long l, MrzEngine mrzengine, long l1, StreamReporterInterface streamreporterinterface, long l2, 
            MrzEngineSessionHelpers mrzenginesessionhelpers, long l3, MrzEngineSessionSettings mrzenginesessionsettings);

    public static final native void MrzEngine_InitializeSession__SWIG_1(long l, MrzEngine mrzengine, long l1, StreamReporterInterface streamreporterinterface, long l2, 
            MrzEngineSessionHelpers mrzenginesessionhelpers);

    public static final native void MrzEngine_InitializeSession__SWIG_2(long l, MrzEngine mrzengine, long l1, StreamReporterInterface streamreporterinterface);

    public static final native void MrzEngine_TerminateSession(long l, MrzEngine mrzengine);

    public static final native int MrzField_calculateChecksum(long l, MrzField mrzfield);

    public static final native String MrzField_getAsString(long l, MrzField mrzfield);

    public static final native long MrzField_getChecksumOcrChar(long l, MrzField mrzfield);

    public static final native double MrzField_getConfidence(long l, MrzField mrzfield);

    public static final native long MrzField_getOcrString(long l, MrzField mrzfield);

    public static final native boolean MrzField_hasChecksumOcrChar(long l, MrzField mrzfield);

    public static final native boolean MrzField_hasCorrectChecksum(long l, MrzField mrzfield);

    public static final native boolean MrzField_isAccepted(long l, MrzField mrzfield);

    public static final native float MrzImageCheck_computeFlashConfidence(byte abyte0[], int i, int j, int k, int l);

    public static final native int MrzImageCheck_computeFocusConfidence(byte abyte0[], int i, int j, int k, int l);

    public static final native boolean MrzImageCheck_isFlashNeeded(byte abyte0[], int i, int j, int k, int l, int i1);

    public static final native boolean MrzImageCheck_isRefocusNeeded(byte abyte0[], int i, int j, int k, int l, int i1);

    public static final native void MrzOcrCharVariantVector_add(long l, MrzOcrCharVariantVector mrzocrcharvariantvector, long l1, MrzOcrCharVariant mrzocrcharvariant);

    public static final native long MrzOcrCharVariantVector_capacity(long l, MrzOcrCharVariantVector mrzocrcharvariantvector);

    public static final native void MrzOcrCharVariantVector_clear(long l, MrzOcrCharVariantVector mrzocrcharvariantvector);

    public static final native long MrzOcrCharVariantVector_get(long l, MrzOcrCharVariantVector mrzocrcharvariantvector, int i);

    public static final native boolean MrzOcrCharVariantVector_isEmpty(long l, MrzOcrCharVariantVector mrzocrcharvariantvector);

    public static final native void MrzOcrCharVariantVector_reserve(long l, MrzOcrCharVariantVector mrzocrcharvariantvector, long l1);

    public static final native void MrzOcrCharVariantVector_set(long l, MrzOcrCharVariantVector mrzocrcharvariantvector, int i, long l1, MrzOcrCharVariant mrzocrcharvariant);

    public static final native long MrzOcrCharVariantVector_size(long l, MrzOcrCharVariantVector mrzocrcharvariantvector);

    public static final native char MrzOcrCharVariant_getCharacter(long l, MrzOcrCharVariant mrzocrcharvariant);

    public static final native double MrzOcrCharVariant_getConfidence(long l, MrzOcrCharVariant mrzocrcharvariant);

    public static final native void MrzOcrCharVector_add(long l, MrzOcrCharVector mrzocrcharvector, long l1, MrzOcrChar mrzocrchar);

    public static final native long MrzOcrCharVector_capacity(long l, MrzOcrCharVector mrzocrcharvector);

    public static final native void MrzOcrCharVector_clear(long l, MrzOcrCharVector mrzocrcharvector);

    public static final native long MrzOcrCharVector_get(long l, MrzOcrCharVector mrzocrcharvector, int i);

    public static final native boolean MrzOcrCharVector_isEmpty(long l, MrzOcrCharVector mrzocrcharvector);

    public static final native void MrzOcrCharVector_reserve(long l, MrzOcrCharVector mrzocrcharvector, long l1);

    public static final native void MrzOcrCharVector_set(long l, MrzOcrCharVector mrzocrcharvector, int i, long l1, MrzOcrChar mrzocrchar);

    public static final native long MrzOcrCharVector_size(long l, MrzOcrCharVector mrzocrcharvector);

    public static final native char MrzOcrChar_GetChar(long l, MrzOcrChar mrzocrchar);

    public static final native long MrzOcrChar_getOcrCharVariants(long l, MrzOcrChar mrzocrchar);

    public static final native boolean MrzOcrChar_isCorrected(long l, MrzOcrChar mrzocrchar);

    public static final native boolean MrzOcrChar_isFoundInDictionary(long l, MrzOcrChar mrzocrchar);

    public static final native boolean MrzOcrChar_isHighlighted(long l, MrzOcrChar mrzocrchar);

    public static final native void MrzOcrStringVector_add(long l, MrzOcrStringVector mrzocrstringvector, long l1, MrzOcrString mrzocrstring);

    public static final native long MrzOcrStringVector_capacity(long l, MrzOcrStringVector mrzocrstringvector);

    public static final native void MrzOcrStringVector_clear(long l, MrzOcrStringVector mrzocrstringvector);

    public static final native long MrzOcrStringVector_get(long l, MrzOcrStringVector mrzocrstringvector, int i);

    public static final native boolean MrzOcrStringVector_isEmpty(long l, MrzOcrStringVector mrzocrstringvector);

    public static final native void MrzOcrStringVector_reserve(long l, MrzOcrStringVector mrzocrstringvector, long l1);

    public static final native void MrzOcrStringVector_set(long l, MrzOcrStringVector mrzocrstringvector, int i, long l1, MrzOcrString mrzocrstring);

    public static final native long MrzOcrStringVector_size(long l, MrzOcrStringVector mrzocrstringvector);

    public static final native long MrzOcrString_getOcrChars(long l, MrzOcrString mrzocrstring);

    public static final native void MrzRectMatrix_add(long l, MrzRectMatrix mrzrectmatrix, long l1, MrzRectVector mrzrectvector);

    public static final native long MrzRectMatrix_capacity(long l, MrzRectMatrix mrzrectmatrix);

    public static final native void MrzRectMatrix_clear(long l, MrzRectMatrix mrzrectmatrix);

    public static final native long MrzRectMatrix_get(long l, MrzRectMatrix mrzrectmatrix, int i);

    public static final native boolean MrzRectMatrix_isEmpty(long l, MrzRectMatrix mrzrectmatrix);

    public static final native void MrzRectMatrix_reserve(long l, MrzRectMatrix mrzrectmatrix, long l1);

    public static final native void MrzRectMatrix_set(long l, MrzRectMatrix mrzrectmatrix, int i, long l1, MrzRectVector mrzrectvector);

    public static final native long MrzRectMatrix_size(long l, MrzRectMatrix mrzrectmatrix);

    public static final native void MrzRectVector_add(long l, MrzRectVector mrzrectvector, long l1, MrzRect mrzrect);

    public static final native long MrzRectVector_capacity(long l, MrzRectVector mrzrectvector);

    public static final native void MrzRectVector_clear(long l, MrzRectVector mrzrectvector);

    public static final native long MrzRectVector_get(long l, MrzRectVector mrzrectvector, int i);

    public static final native boolean MrzRectVector_isEmpty(long l, MrzRectVector mrzrectvector);

    public static final native void MrzRectVector_reserve(long l, MrzRectVector mrzrectvector, long l1);

    public static final native void MrzRectVector_set(long l, MrzRectVector mrzrectvector, int i, long l1, MrzRect mrzrect);

    public static final native long MrzRectVector_size(long l, MrzRectVector mrzrectvector);

    public static final native int MrzRect_getHeight(long l, MrzRect mrzrect);

    public static final native int MrzRect_getWidth(long l, MrzRect mrzrect);

    public static final native int MrzRect_getX(long l, MrzRect mrzrect);

    public static final native int MrzRect_getY(long l, MrzRect mrzrect);

    public static final native void MrzRect_setHeight(long l, MrzRect mrzrect, int i);

    public static final native void MrzRect_setWidth(long l, MrzRect mrzrect, int i);

    public static final native void MrzRect_setX(long l, MrzRect mrzrect, int i);

    public static final native void MrzRect_setY(long l, MrzRect mrzrect, int i);

    public static final native long MrzResult_getBirthdate(long l, MrzResult mrzresult);

    public static final native long MrzResult_getCountry(long l, MrzResult mrzresult);

    public static final native long MrzResult_getDepartmentCode(long l, MrzResult mrzresult);

    public static final native long MrzResult_getDocNum(long l, MrzResult mrzresult);

    public static final native long MrzResult_getDocNumFormatted(long l, MrzResult mrzresult);

    public static final native long MrzResult_getDocType(long l, MrzResult mrzresult);

    public static final native long MrzResult_getDocTypeCode(long l, MrzResult mrzresult);

    public static final native long MrzResult_getExpidate(long l, MrzResult mrzresult);

    public static final native long MrzResult_getFirstName(long l, MrzResult mrzresult);

    public static final native long MrzResult_getIssuedate(long l, MrzResult mrzresult);

    public static final native long MrzResult_getMrzCompositeCheckDigit(long l, MrzResult mrzresult);

    public static final native long MrzResult_getMrzLines(long l, MrzResult mrzresult);

    public static final native long MrzResult_getMrzOcrLines(long l, MrzResult mrzresult);

    public static final native long MrzResult_getNationality(long l, MrzResult mrzresult);

    public static final native long MrzResult_getOptData1(long l, MrzResult mrzresult);

    public static final native long MrzResult_getOptData2(long l, MrzResult mrzresult);

    public static final native long MrzResult_getSecondName(long l, MrzResult mrzresult);

    public static final native long MrzResult_getSex(long l, MrzResult mrzresult);

    public static final native boolean MrzResult_hasCorrectCompositeChecksum(long l, MrzResult mrzresult);

    public static final native void MrzResult_setBirthdate(long l, MrzResult mrzresult, long l1, MrzDateField mrzdatefield);

    public static final native void MrzResult_setCountry(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setDepartmentCode(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setDocNum(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setDocNumFormatted(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setDocType(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setDocTypeCode(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setExpidate(long l, MrzResult mrzresult, long l1, MrzDateField mrzdatefield);

    public static final native void MrzResult_setFirstName(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setIssuedate(long l, MrzResult mrzresult, long l1, MrzDateField mrzdatefield);

    public static final native void MrzResult_setMrzCompositeCheckDigit(long l, MrzResult mrzresult, long l1, MrzOcrChar mrzocrchar);

    public static final native void MrzResult_setMrzLines(long l, MrzResult mrzresult, long l1, StringVector stringvector);

    public static final native void MrzResult_setMrzOcrLines(long l, MrzResult mrzresult, long l1, MrzOcrStringVector mrzocrstringvector);

    public static final native void MrzResult_setNationality(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setOptData1(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setOptData2(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setSecondName(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void MrzResult_setSex(long l, MrzResult mrzresult, long l1, MrzField mrzfield);

    public static final native void StreamReporterInterface_SnapshotProcessed(long l, StreamReporterInterface streamreporterinterface, long l1, MrzResult mrzresult, boolean flag);

    public static final native void StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_0(long l, StreamReporterInterface streamreporterinterface);

    public static final native void StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_1(long l, StreamReporterInterface streamreporterinterface, String s);

    public static final native void StreamReporterInterface_SnapshotRejected__SWIG_0(long l, StreamReporterInterface streamreporterinterface);

    public static final native void StreamReporterInterface_SnapshotRejected__SWIG_1(long l, StreamReporterInterface streamreporterinterface, String s);

    public static final native void StreamReporterInterface_SymbolRectsFound(long l, StreamReporterInterface streamreporterinterface, long l1, MrzRectMatrix mrzrectmatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(long l, StreamReporterInterface streamreporterinterface, long l1, MrzRectMatrix mrzrectmatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessedSwigExplicitStreamReporterInterface(long l, StreamReporterInterface streamreporterinterface, long l1, MrzRectMatrix mrzrectmatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundSwigExplicitStreamReporterInterface(long l, StreamReporterInterface streamreporterinterface, long l1, MrzRectMatrix mrzrectmatrix);

    public static final native void StreamReporterInterface_change_ownership(StreamReporterInterface streamreporterinterface, long l, boolean flag);

    public static final native void StreamReporterInterface_director_connect(StreamReporterInterface streamreporterinterface, long l, boolean flag, boolean flag1);

    public static final native void StringVector_add(long l, StringVector stringvector, String s);

    public static final native long StringVector_capacity(long l, StringVector stringvector);

    public static final native void StringVector_clear(long l, StringVector stringvector);

    public static final native String StringVector_get(long l, StringVector stringvector, int i);

    public static final native boolean StringVector_isEmpty(long l, StringVector stringvector);

    public static final native void StringVector_reserve(long l, StringVector stringvector, long l1);

    public static final native void StringVector_set(long l, StringVector stringvector, int i, String s);

    public static final native long StringVector_size(long l, StringVector stringvector);

    public static void SwigDirector_StreamReporterInterface_SnapshotProcessed(StreamReporterInterface streamreporterinterface, long l, boolean flag)
    {
        streamreporterinterface.SnapshotProcessed(new MrzResult(l, false), flag);
    }

    public static void SwigDirector_StreamReporterInterface_SnapshotRejected__SWIG_0(StreamReporterInterface streamreporterinterface)
    {
        streamreporterinterface.SnapshotRejected();
    }

    public static void SwigDirector_StreamReporterInterface_SnapshotRejected__SWIG_1(StreamReporterInterface streamreporterinterface, String s)
    {
        streamreporterinterface.SnapshotRejected(s);
    }

    public static void SwigDirector_StreamReporterInterface_SymbolRectsFound(StreamReporterInterface streamreporterinterface, long l)
    {
        streamreporterinterface.SymbolRectsFound(new MrzRectMatrix(l, false));
    }

    public static void SwigDirector_StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(StreamReporterInterface streamreporterinterface, long l)
    {
        streamreporterinterface.SymbolRectsFoundAfterSnapshotProcessed(new MrzRectMatrix(l, false));
    }

    public static final native void delete_MrzDate(long l);

    public static final native void delete_MrzDateField(long l);

    public static final native void delete_MrzEngine(long l);

    public static final native void delete_MrzEngineInternalSettings(long l);

    public static final native void delete_MrzEngineSessionHelpers(long l);

    public static final native void delete_MrzEngineSessionSettings(long l);

    public static final native void delete_MrzField(long l);

    public static final native void delete_MrzImageCheck(long l);

    public static final native void delete_MrzOcrChar(long l);

    public static final native void delete_MrzOcrCharVariant(long l);

    public static final native void delete_MrzOcrCharVariantVector(long l);

    public static final native void delete_MrzOcrCharVector(long l);

    public static final native void delete_MrzOcrString(long l);

    public static final native void delete_MrzOcrStringVector(long l);

    public static final native void delete_MrzRect(long l);

    public static final native void delete_MrzRectMatrix(long l);

    public static final native void delete_MrzRectVector(long l);

    public static final native void delete_MrzResult(long l);

    public static final native void delete_StreamReporterInterface(long l);

    public static final native void delete_StringVector(long l);

    public static final native long new_MrzDateField__SWIG_0();

    public static final native long new_MrzDateField__SWIG_1(long l, MrzDate mrzdate, boolean flag, double d);

    public static final native long new_MrzDateField__SWIG_2(long l, MrzDate mrzdate, boolean flag);

    public static final native long new_MrzDateField__SWIG_3(long l, MrzDate mrzdate);

    public static final native long new_MrzDateField__SWIG_4(long l, MrzDate mrzdate, boolean flag, double d, long l1, 
            MrzOcrString mrzocrstring, long l2, MrzOcrChar mrzocrchar);

    public static final native long new_MrzDate__SWIG_0(int i, int j, int k);

    public static final native long new_MrzDate__SWIG_1(int i, int j);

    public static final native long new_MrzDate__SWIG_2(int i);

    public static final native long new_MrzDate__SWIG_3();

    public static final native long new_MrzDate__SWIG_4(long l, MrzDate mrzdate);

    public static final native long new_MrzEngine(long l, MrzEngineInternalSettings mrzengineinternalsettings);

    public static final native long new_MrzEngineSessionHelpers();

    public static final native long new_MrzEngineSessionSettings();

    public static final native long new_MrzField__SWIG_0();

    public static final native long new_MrzField__SWIG_1(String s, boolean flag, double d);

    public static final native long new_MrzField__SWIG_2(String s, boolean flag);

    public static final native long new_MrzField__SWIG_3(String s);

    public static final native long new_MrzField__SWIG_4(String s, boolean flag, double d, long l, MrzOcrString mrzocrstring, long l1, MrzOcrChar mrzocrchar);

    public static final native long new_MrzImageCheck();

    public static final native long new_MrzOcrCharVariantVector__SWIG_0();

    public static final native long new_MrzOcrCharVariantVector__SWIG_1(long l);

    public static final native long new_MrzOcrCharVariant__SWIG_0();

    public static final native long new_MrzOcrCharVariant__SWIG_1(char c, double d);

    public static final native long new_MrzOcrCharVector__SWIG_0();

    public static final native long new_MrzOcrCharVector__SWIG_1(long l);

    public static final native long new_MrzOcrChar__SWIG_0();

    public static final native long new_MrzOcrChar__SWIG_1(long l, MrzOcrCharVariantVector mrzocrcharvariantvector, boolean flag, boolean flag1, boolean flag2);

    public static final native long new_MrzOcrStringVector__SWIG_0();

    public static final native long new_MrzOcrStringVector__SWIG_1(long l);

    public static final native long new_MrzOcrString__SWIG_0();

    public static final native long new_MrzOcrString__SWIG_1(long l, MrzOcrCharVector mrzocrcharvector);

    public static final native long new_MrzRectMatrix__SWIG_0();

    public static final native long new_MrzRectMatrix__SWIG_1(long l);

    public static final native long new_MrzRectVector__SWIG_0();

    public static final native long new_MrzRectVector__SWIG_1(long l);

    public static final native long new_MrzRect__SWIG_0(int i, int j, int k, int l);

    public static final native long new_MrzRect__SWIG_1(int i, int j, int k);

    public static final native long new_MrzRect__SWIG_2(int i, int j);

    public static final native long new_MrzRect__SWIG_3(int i);

    public static final native long new_MrzRect__SWIG_4();

    public static final native long new_MrzResult__SWIG_0();

    public static final native long new_MrzResult__SWIG_1(long l, MrzResult mrzresult);

    public static final native long new_StreamReporterInterface();

    public static final native long new_StringVector__SWIG_0();

    public static final native long new_StringVector__SWIG_1(long l);

    private static final native void swig_module_init();

    static 
    {
        swig_module_init();
    }
}
