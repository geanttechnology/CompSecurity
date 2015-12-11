.class public Lcom/auditude/ads/util/AuditudeUtil$LocaltimeTagResult;
.super Ljava/lang/Object;
.source "AuditudeUtil.java"

# interfaces
.implements Lcom/auditude/ads/util/AuditudeUtil$ITagResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/util/AuditudeUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocaltimeTagResult"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 155
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 11

    .prologue
    const/16 v10, 0x30

    const/4 v9, 0x2

    .line 159
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 160
    .local v0, "cal":Ljava/util/Calendar;
    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 162
    const/4 v7, 0x1

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    .line 163
    .local v6, "yearStr":Ljava/lang/String;
    invoke-virtual {v0, v9}, Ljava/util/Calendar;->get(I)I

    move-result v7

    add-int/lit8 v7, v7, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    .line 165
    .local v4, "monthStr":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v9, :cond_0

    .line 170
    const/4 v7, 0x5

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 171
    .local v1, "dateStr":Ljava/lang/String;
    :goto_1
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v9, :cond_1

    .line 176
    const/16 v7, 0xb

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    .line 177
    .local v2, "hourStr":Ljava/lang/String;
    :goto_2
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v9, :cond_2

    .line 182
    const/16 v7, 0xc

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    .line 183
    .local v3, "minuteStr":Ljava/lang/String;
    :goto_3
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v9, :cond_3

    .line 188
    const/16 v7, 0xd

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    .line 189
    .local v5, "secondStr":Ljava/lang/String;
    :goto_4
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v9, :cond_4

    .line 194
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7

    .line 167
    .end local v1    # "dateStr":Ljava/lang/String;
    .end local v2    # "hourStr":Ljava/lang/String;
    .end local v3    # "minuteStr":Ljava/lang/String;
    .end local v5    # "secondStr":Ljava/lang/String;
    :cond_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 173
    .restart local v1    # "dateStr":Ljava/lang/String;
    :cond_1
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 179
    .restart local v2    # "hourStr":Ljava/lang/String;
    :cond_2
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_2

    .line 185
    .restart local v3    # "minuteStr":Ljava/lang/String;
    :cond_3
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_3

    .line 191
    .restart local v5    # "secondStr":Ljava/lang/String;
    :cond_4
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_4
.end method
