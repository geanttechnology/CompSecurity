.class public abstract Lcom/amazon/mShop/search/viewit/ResultWrapper;
.super Ljava/lang/Object;
.source "ResultWrapper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    }
.end annotation


# instance fields
.field private mOriginalScannedOutput:Ljava/lang/String;

.field private mResultType:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

.field private mScannedDate:Ljava/util/Date;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Date;)V
    .locals 0
    .param p1, "originalScannedOutput"    # Ljava/lang/String;
    .param p2, "scannedDate"    # Ljava/util/Date;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mOriginalScannedOutput:Ljava/lang/String;

    .line 59
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mScannedDate:Ljava/util/Date;

    .line 60
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->updateResultType(Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method public static getCurrentDate()Ljava/util/Date;
    .locals 4

    .prologue
    .line 80
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 81
    .local v0, "now":Ljava/lang/Long;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v1

    .line 82
    .local v1, "scannedDate":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/util/Date;->setTime(J)V

    .line 83
    return-object v1
.end method

.method private updateResultType(Ljava/lang/String;)V
    .locals 1
    .param p1, "originalScannedOutput"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 65
    sget-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 66
    sget-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mResultType:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 67
    :cond_1
    sget-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 68
    sget-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mResultType:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    goto :goto_0

    .line 70
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mResultType:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    goto :goto_0
.end method


# virtual methods
.method public abstract getAsinList()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public getOriginalScannedOutput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mOriginalScannedOutput:Ljava/lang/String;

    return-object v0
.end method

.method public getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mResultType:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    return-object v0
.end method

.method public getScannedDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mScannedDate:Ljava/util/Date;

    return-object v0
.end method

.method public updateOriginalScannedOutput(Ljava/lang/String;)V
    .locals 0
    .param p1, "originalScannedOutput"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mOriginalScannedOutput:Ljava/lang/String;

    .line 45
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->updateResultType(Ljava/lang/String;)V

    .line 46
    return-void
.end method

.method public updateScannedDate()V
    .locals 1

    .prologue
    .line 76
    invoke-static {}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->getCurrentDate()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper;->mScannedDate:Ljava/util/Date;

    .line 77
    return-void
.end method
