.class public Lcom/adobe/ave/DataTrackInfo;
.super Ljava/lang/Object;
.source "DataTrackInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    }
.end annotation


# instance fields
.field public activity:Z

.field public description:Ljava/lang/String;

.field public isAutoSelect:Z

.field public isDefault:Z

.field public isForced:Z

.field public language:Ljava/lang/String;

.field public serviceType:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;IZZZZ)V
    .locals 5
    .param p1, "aDesc"    # Ljava/lang/String;
    .param p2, "aLanguage"    # Ljava/lang/String;
    .param p3, "aServiceType"    # I
    .param p4, "aIsDefault"    # Z
    .param p5, "aIsAutoSelect"    # Z
    .param p6, "aIsForced"    # Z
    .param p7, "aActivity"    # Z

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/adobe/ave/DataTrackInfo;->description:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lcom/adobe/ave/DataTrackInfo;->language:Ljava/lang/String;

    .line 57
    invoke-static {}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->values()[Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 59
    .local v0, "type":Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    invoke-virtual {v0}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->getValue()I

    move-result v4

    if-ne v4, p3, :cond_1

    .line 61
    iput-object v0, p0, Lcom/adobe/ave/DataTrackInfo;->serviceType:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    .line 65
    .end local v0    # "type":Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    :cond_0
    iput-boolean p4, p0, Lcom/adobe/ave/DataTrackInfo;->isDefault:Z

    .line 66
    iput-boolean p5, p0, Lcom/adobe/ave/DataTrackInfo;->isAutoSelect:Z

    .line 67
    iput-boolean p6, p0, Lcom/adobe/ave/DataTrackInfo;->isForced:Z

    .line 68
    iput-boolean p7, p0, Lcom/adobe/ave/DataTrackInfo;->activity:Z

    .line 69
    return-void

    .line 57
    .restart local v0    # "type":Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
