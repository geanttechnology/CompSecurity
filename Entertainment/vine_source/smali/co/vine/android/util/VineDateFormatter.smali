.class public Lco/vine/android/util/VineDateFormatter;
.super Ljava/lang/Object;
.source "VineDateFormatter.java"


# instance fields
.field private final mDateFormatLong:Ljava/text/SimpleDateFormat;

.field private final mDateFormatShort:Ljava/text/SimpleDateFormat;

.field private final mDateSectionSpans:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Landroid/text/style/TypefaceSpan;",
            ">;"
        }
    .end annotation
.end field

.field private final mDateTimePlacerPart1:Ljava/lang/String;

.field private final mIsDateBeforeTime:Z

.field private mStartOfToday:Ljava/util/Calendar;

.field private mStartOfYesterday:J

.field private final mTimeFormat:Ljava/text/SimpleDateFormat;

.field private final mTimeSectionSpans:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Landroid/text/style/TypefaceSpan;",
            ">;"
        }
    .end annotation
.end field

.field private final mYesterday:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 5
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v3, Ljava/text/SimpleDateFormat;

    const v4, 0x7f0e0283

    invoke-virtual {p1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mTimeFormat:Ljava/text/SimpleDateFormat;

    .line 33
    const v3, 0x7f0e0277

    invoke-virtual {p1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "dateTimePlacer":Ljava/lang/String;
    const-string v3, "%1$s"

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 37
    .local v1, "dateTimePlacerStart1":I
    const-string v3, "%2$s"

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 39
    .local v2, "dateTimePlacerStart2":I
    if-ge v1, v2, :cond_0

    const/4 v3, 0x1

    :goto_0
    iput-boolean v3, p0, Lco/vine/android/util/VineDateFormatter;->mIsDateBeforeTime:Z

    .line 41
    iget-boolean v3, p0, Lco/vine/android/util/VineDateFormatter;->mIsDateBeforeTime:Z

    if-eqz v3, :cond_1

    .line 42
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    .line 47
    :goto_1
    new-instance v3, Ljava/text/SimpleDateFormat;

    const v4, 0x7f0e00a9

    invoke-virtual {p1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatLong:Ljava/text/SimpleDateFormat;

    .line 48
    new-instance v3, Ljava/text/SimpleDateFormat;

    const v4, 0x7f0e00aa

    invoke-virtual {p1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatShort:Ljava/text/SimpleDateFormat;

    .line 50
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mDateSectionSpans:Ljava/util/HashSet;

    .line 51
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mTimeSectionSpans:Ljava/util/HashSet;

    .line 53
    const v3, 0x7f0e0289

    invoke-virtual {p1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mYesterday:Ljava/lang/String;

    .line 54
    return-void

    .line 39
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 44
    :cond_1
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    goto :goto_1
.end method


# virtual methods
.method public addSpanForDateSection(Landroid/text/style/TypefaceSpan;)V
    .locals 1
    .param p1, "span"    # Landroid/text/style/TypefaceSpan;

    .prologue
    .line 113
    iget-object v0, p0, Lco/vine/android/util/VineDateFormatter;->mDateSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 114
    return-void
.end method

.method public addSpanForTimeSection(Landroid/text/style/TypefaceSpan;)V
    .locals 1
    .param p1, "span"    # Landroid/text/style/TypefaceSpan;

    .prologue
    .line 117
    iget-object v0, p0, Lco/vine/android/util/VineDateFormatter;->mTimeSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 118
    return-void
.end method

.method public format(J)Ljava/lang/CharSequence;
    .locals 12
    .param p1, "time"    # J

    .prologue
    .line 62
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1, p1, p2}, Ljava/util/Date;-><init>(J)V

    .line 63
    .local v1, "createdDate":Ljava/util/Date;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 64
    .local v0, "createdCal":Ljava/util/Calendar;
    invoke-virtual {v0, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 65
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfToday:Ljava/util/Calendar;

    invoke-virtual {v9}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v9

    cmp-long v9, p1, v9

    if-lez v9, :cond_1

    .line 66
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mTimeFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v9, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v7

    .line 108
    :cond_0
    return-object v7

    .line 68
    :cond_1
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-direct {v7}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 69
    .local v7, "ssb":Landroid/text/SpannableStringBuilder;
    iget-boolean v9, p0, Lco/vine/android/util/VineDateFormatter;->mIsDateBeforeTime:Z

    if-eqz v9, :cond_5

    .line 70
    iget-wide v9, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfYesterday:J

    cmp-long v9, p1, v9

    if-lez v9, :cond_2

    .line 71
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mYesterday:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 79
    :goto_0
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    .line 80
    .local v3, "end1":I
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mTimeFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v9, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 81
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    .line 82
    .local v4, "end2":I
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v9}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/text/style/TypefaceSpan;

    .line 83
    .local v6, "span":Landroid/text/style/TypefaceSpan;
    const/4 v9, 0x0

    const/16 v10, 0x21

    invoke-static {v7, v6, v9, v3, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    goto :goto_1

    .line 73
    .end local v3    # "end1":I
    .end local v4    # "end2":I
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "span":Landroid/text/style/TypefaceSpan;
    :cond_2
    const/4 v9, 0x1

    invoke-virtual {v0, v9}, Ljava/util/Calendar;->get(I)I

    move-result v9

    iget-object v10, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfToday:Ljava/util/Calendar;

    const/4 v11, 0x1

    invoke-virtual {v10, v11}, Ljava/util/Calendar;->get(I)I

    move-result v10

    if-ne v9, v10, :cond_3

    .line 74
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatShort:Ljava/text/SimpleDateFormat;

    invoke-virtual {v11, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0

    .line 76
    :cond_3
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatLong:Ljava/text/SimpleDateFormat;

    invoke-virtual {v11, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0

    .line 85
    .restart local v3    # "end1":I
    .restart local v4    # "end2":I
    .restart local v5    # "i$":Ljava/util/Iterator;
    :cond_4
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mTimeSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v9}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/text/style/TypefaceSpan;

    .line 86
    .restart local v6    # "span":Landroid/text/style/TypefaceSpan;
    const/16 v9, 0x21

    invoke-static {v7, v6, v3, v4, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    goto :goto_2

    .line 89
    .end local v3    # "end1":I
    .end local v4    # "end2":I
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "span":Landroid/text/style/TypefaceSpan;
    :cond_5
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mTimeFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v9, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 90
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v8

    .line 91
    .local v8, "start":I
    iget-wide v9, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfYesterday:J

    cmp-long v9, p1, v9

    if-lez v9, :cond_6

    .line 92
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mYesterday:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 100
    :goto_3
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 101
    .local v2, "end":I
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v9}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .restart local v5    # "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_8

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/text/style/TypefaceSpan;

    .line 102
    .restart local v6    # "span":Landroid/text/style/TypefaceSpan;
    const/16 v9, 0x21

    invoke-static {v7, v6, v8, v2, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    goto :goto_4

    .line 94
    .end local v2    # "end":I
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "span":Landroid/text/style/TypefaceSpan;
    :cond_6
    const/4 v9, 0x1

    invoke-virtual {v0, v9}, Ljava/util/Calendar;->get(I)I

    move-result v9

    iget-object v10, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfToday:Ljava/util/Calendar;

    const/4 v11, 0x1

    invoke-virtual {v10, v11}, Ljava/util/Calendar;->get(I)I

    move-result v10

    if-ne v9, v10, :cond_7

    .line 95
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatShort:Ljava/text/SimpleDateFormat;

    invoke-virtual {v11, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_3

    .line 97
    :cond_7
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mDateTimePlacerPart1:Ljava/lang/String;

    const-string v10, "%1$s"

    iget-object v11, p0, Lco/vine/android/util/VineDateFormatter;->mDateFormatLong:Ljava/text/SimpleDateFormat;

    invoke-virtual {v11, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_3

    .line 104
    .restart local v2    # "end":I
    .restart local v5    # "i$":Ljava/util/Iterator;
    :cond_8
    iget-object v9, p0, Lco/vine/android/util/VineDateFormatter;->mTimeSectionSpans:Ljava/util/HashSet;

    invoke-virtual {v9}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_5
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/text/style/TypefaceSpan;

    .line 105
    .restart local v6    # "span":Landroid/text/style/TypefaceSpan;
    const/4 v9, 0x0

    const/16 v10, 0x21

    invoke-static {v7, v6, v9, v8, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    goto :goto_5
.end method

.method public refreshDates()V
    .locals 4

    .prologue
    .line 57
    invoke-static {}, Lco/vine/android/util/DateTimeUtil;->getStartOfDay()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfToday:Ljava/util/Calendar;

    .line 58
    iget-object v0, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfToday:Ljava/util/Calendar;

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    const-wide/32 v2, 0x5265c00

    sub-long/2addr v0, v2

    iput-wide v0, p0, Lco/vine/android/util/VineDateFormatter;->mStartOfYesterday:J

    .line 59
    return-void
.end method
