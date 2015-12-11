.class public Lcom/comcast/cim/utils/UIPresentationUtil;
.super Ljava/lang/Object;
.source "UIPresentationUtil.java"


# static fields
.field private static final FORBIDDEN_WORDS:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 272
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "A "

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "An "

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "The "

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/utils/UIPresentationUtil;->FORBIDDEN_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addQuotesToString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 95
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 97
    .local v0, "sb":Ljava/lang/StringBuffer;
    if-eqz p0, :cond_0

    .line 98
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 100
    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 101
    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 102
    invoke-virtual {v0, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 103
    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 107
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static bytesToMB(J)J
    .locals 2
    .param p0, "videoFileSizeInBytes"    # J

    .prologue
    .line 291
    const-wide/32 v0, 0x100000

    div-long v0, p0, v0

    return-wide v0
.end method

.method public static getAbsListStateDescription(Landroid/view/View;Ljava/lang/String;III)Ljava/lang/String;
    .locals 8
    .param p0, "absListView"    # Landroid/view/View;
    .param p1, "description"    # Ljava/lang/String;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 77
    instance-of v3, p0, Landroid/widget/ListView;

    if-eqz v3, :cond_0

    .line 78
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->content_description_entity_list_view_list:I

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "gridOrList":Ljava/lang/String;
    :goto_0
    add-int/lit8 v1, p2, 0x1

    .line 82
    .local v1, "itemFrom":I
    add-int v3, p2, p3

    if-le v3, p4, :cond_1

    move v2, p4

    .line 84
    .local v2, "itemTo":I
    :goto_1
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->content_description_entity_list_view:I

    const/4 v5, 0x5

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    const/4 v6, 0x2

    .line 87
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x3

    .line 88
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x4

    .line 89
    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    .line 84
    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 79
    .end local v0    # "gridOrList":Ljava/lang/String;
    .end local v1    # "itemFrom":I
    .end local v2    # "itemTo":I
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->content_description_entity_list_view_grid:I

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 82
    .restart local v0    # "gridOrList":Ljava/lang/String;
    .restart local v1    # "itemFrom":I
    :cond_1
    add-int v2, p2, p3

    goto :goto_1
.end method

.method public static getDaysLeft(Ljava/util/Date;)I
    .locals 8
    .param p0, "expireDate"    # Ljava/util/Date;

    .prologue
    .line 296
    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 297
    .local v2, "time":J
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    .line 298
    .local v0, "now":J
    sub-long v4, v2, v0

    const-wide/32 v6, 0x5265c00

    div-long/2addr v4, v6

    long-to-int v4, v4

    return v4
.end method

.method public static getDuration(Landroid/content/Context;I)Ljava/lang/String;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "durationInSeconds"    # I

    .prologue
    .line 234
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 235
    .local v3, "sb":Ljava/lang/StringBuffer;
    move v5, p1

    .line 237
    .local v5, "secs":I
    div-int/lit16 v0, v5, 0xe10

    .line 238
    .local v0, "hours":I
    rem-int/lit16 v2, v5, 0xe10

    .line 239
    .local v2, "remainder":I
    div-int/lit8 v1, v2, 0x3c

    .line 240
    .local v1, "minutes":I
    rem-int/lit8 v4, v2, 0x3c

    .line 242
    .local v4, "seconds":I
    if-lez v0, :cond_2

    .line 243
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    const-string v7, " "

    .line 244
    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    const/4 v6, 0x1

    if-ne v0, v6, :cond_1

    sget v6, Lcom/comcast/cim/android/R$string;->hour:I

    .line 246
    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 245
    :goto_0
    invoke-virtual {v7, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 249
    if-lez v1, :cond_0

    .line 250
    const-string v6, ", "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 251
    invoke-static {p0, v3, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    .line 261
    :cond_0
    :goto_1
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_2
    return-object v6

    .line 247
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v8, Lcom/comcast/cim/android/R$string;->hours:I

    invoke-virtual {v6, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 253
    :cond_2
    if-lez v1, :cond_3

    .line 254
    invoke-static {p0, v3, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    goto :goto_1

    .line 255
    :cond_3
    if-lez v4, :cond_4

    .line 256
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/comcast/cim/android/R$string;->less_than_a_minute:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 258
    :cond_4
    const-string v6, ""

    goto :goto_2
.end method

.method public static getDurationSpoken(Landroid/content/Context;I)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "durationInSeconds"    # I

    .prologue
    .line 222
    invoke-static {p0, p1}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDuration(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 224
    .local v0, "retval":Ljava/lang/String;
    const-string v1, "hr"

    const-string v2, "hour"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 225
    const-string v1, "min"

    const-string v2, "minute"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 227
    return-object v0
.end method

.method public static getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "duration"    # I
    .param p2, "position"    # I

    .prologue
    .line 164
    int-to-double v8, p2

    int-to-double v10, p1

    div-double v2, v8, v10

    .line 166
    .local v2, "progressPercent":D
    const-wide v8, 0x3fef5c28f5c28f5cL    # 0.98

    cmpl-double v8, v2, v8

    if-lez v8, :cond_0

    .line 167
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->finished:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 198
    :goto_0
    return-object v8

    .line 170
    :cond_0
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    .line 171
    .local v5, "sb":Ljava/lang/StringBuffer;
    sub-int v8, p1, p2

    div-int/lit16 v7, v8, 0x3e8

    .line 173
    .local v7, "secs":I
    div-int/lit16 v0, v7, 0xe10

    .line 174
    .local v0, "hours":I
    rem-int/lit16 v4, v7, 0xe10

    .line 175
    .local v4, "remainder":I
    div-int/lit8 v1, v4, 0x3c

    .line 176
    .local v1, "minutes":I
    rem-int/lit8 v6, v4, 0x3c

    .line 178
    .local v6, "seconds":I
    if-lez v0, :cond_3

    .line 179
    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, " "

    .line 180
    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    const/4 v8, 0x1

    if-ne v0, v8, :cond_2

    sget v8, Lcom/comcast/cim/android/R$string;->hour:I

    .line 182
    invoke-virtual {p0, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 181
    :goto_1
    invoke-virtual {v9, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 185
    if-lez v1, :cond_1

    .line 186
    const-string v8, ", "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 187
    invoke-static {p0, v5, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    .line 195
    :cond_1
    :goto_2
    const-string v8, " "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    .line 196
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Lcom/comcast/cim/android/R$string;->left:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 198
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_0

    .line 183
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v10, Lcom/comcast/cim/android/R$string;->hours:I

    invoke-virtual {v8, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    goto :goto_1

    .line 189
    :cond_3
    if-lez v1, :cond_4

    .line 190
    invoke-static {p0, v5, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    goto :goto_2

    .line 191
    :cond_4
    if-lez v6, :cond_1

    .line 192
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->less_than_a_minute:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2
.end method

.method public static getRemainingTimeTalkBack(Landroid/content/Context;II)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "duration"    # I
    .param p2, "position"    # I

    .prologue
    .line 156
    invoke-static {p0, p1, p2}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v0

    .line 157
    .local v0, "retval":Ljava/lang/String;
    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->translateTimeForTalkBack(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 159
    return-object v0
.end method

.method public static getSeriesString(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;
    .locals 2
    .param p0, "seasonNumber"    # Ljava/lang/Integer;
    .param p1, "episodeNumber"    # Ljava/lang/Integer;

    .prologue
    .line 23
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    .line 24
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "S"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " | Ep"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 27
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public static getSeriesStringSpoken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "seriesString"    # Ljava/lang/String;
    .param p1, "seasonSpoken"    # Ljava/lang/String;
    .param p2, "episodeSpoken"    # Ljava/lang/String;

    .prologue
    .line 34
    const-string v0, "S"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 35
    const-string v0, "Ep"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 36
    const-string v0, "|"

    const-string v1, ", "

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 37
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 39
    return-object p0
.end method

.method public static getSortStringFromTitle(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "displayTitle"    # Ljava/lang/String;

    .prologue
    .line 275
    invoke-static {p0}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    move-object v0, p0

    .line 278
    .local v0, "sortTitle":Ljava/lang/String;
    sget-object v3, Lcom/comcast/cim/utils/UIPresentationUtil;->FORBIDDEN_WORDS:[Ljava/lang/String;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_1

    aget-object v1, v3, v2

    .line 279
    .local v1, "word":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 280
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 281
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 278
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 285
    .end local v1    # "word":Ljava/lang/String;
    :cond_1
    return-object v0
.end method

.method public static getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "secs"    # I

    .prologue
    .line 113
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 116
    .local v3, "sb":Ljava/lang/StringBuffer;
    div-int/lit16 v0, p1, 0xe10

    .line 117
    .local v0, "hours":I
    rem-int/lit16 v2, p1, 0xe10

    .line 118
    .local v2, "remainder":I
    div-int/lit8 v1, v2, 0x3c

    .line 119
    .local v1, "minutes":I
    rem-int/lit8 v4, v2, 0x3c

    .line 121
    .local v4, "seconds":I
    if-lez v0, :cond_0

    .line 122
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " "

    .line 123
    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    const/4 v5, 0x1

    if-ne v0, v5, :cond_3

    sget v5, Lcom/comcast/cim/android/R$string;->hour:I

    .line 125
    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 124
    :goto_0
    invoke-virtual {v6, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 129
    :cond_0
    if-lez v1, :cond_1

    .line 130
    const-string v5, ", "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 131
    invoke-static {p0, v3, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    .line 134
    :cond_1
    if-lez p1, :cond_2

    .line 135
    const-string v5, ", "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 136
    invoke-static {p0, v3, v4}, Lcom/comcast/cim/utils/UIPresentationUtil;->showSeconds(Landroid/content/Context;Ljava/lang/StringBuffer;I)V

    .line 139
    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/comcast/cim/utils/UIPresentationUtil;->translateTimeForTalkBack(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    return-object v5

    .line 126
    :cond_3
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v7, Lcom/comcast/cim/android/R$string;->hours:I

    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method private static showMinutes(Landroid/content/Context;Ljava/lang/StringBuffer;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sb"    # Ljava/lang/StringBuffer;
    .param p2, "minutes"    # I

    .prologue
    .line 204
    invoke-virtual {p1, p2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    .line 205
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 207
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/comcast/cim/android/R$string;->min:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 206
    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 209
    return-void

    .line 208
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/comcast/cim/android/R$string;->mins:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static showSeconds(Landroid/content/Context;Ljava/lang/StringBuffer;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sb"    # Ljava/lang/StringBuffer;
    .param p2, "secs"    # I

    .prologue
    .line 213
    invoke-virtual {p1, p2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    .line 214
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 216
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/comcast/cim/android/R$string;->sec:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 215
    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 218
    return-void

    .line 217
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/comcast/cim/android/R$string;->secs:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static translateTimeForTalkBack(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "abbreviatedTime"    # Ljava/lang/String;

    .prologue
    .line 145
    move-object v0, p0

    .line 147
    .local v0, "retval":Ljava/lang/String;
    const-string v1, "hr"

    const-string v2, "hour"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 148
    const-string v1, "min"

    const-string v2, "minute"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 149
    const-string v1, "sec"

    const-string v2, "second"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 151
    return-object v0
.end method
