.class public Lcom/adobe/ave/ABRParameters;
.super Ljava/lang/Object;
.source "ABRParameters.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/ave/ABRParameters$ABRPolicy;
    }
.end annotation


# instance fields
.field public maxBitsPerSecond:I

.field public maxVideoHeight:I

.field public maxVideoWidth:I

.field public minBitsPerSecond:I

.field public minVideoHeight:I

.field public minVideoWidth:I

.field public policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;

.field public profileIndex:I

.field public startBitsPerSecond:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const v2, 0x7fffffff

    const/4 v1, 0x0

    .line 149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 150
    sget-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    iput-object v0, p0, Lcom/adobe/ave/ABRParameters;->policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    .line 151
    iput v1, p0, Lcom/adobe/ave/ABRParameters;->profileIndex:I

    .line 152
    iput v1, p0, Lcom/adobe/ave/ABRParameters;->startBitsPerSecond:I

    .line 153
    iput v1, p0, Lcom/adobe/ave/ABRParameters;->minBitsPerSecond:I

    .line 154
    iput v2, p0, Lcom/adobe/ave/ABRParameters;->maxBitsPerSecond:I

    .line 155
    iput v1, p0, Lcom/adobe/ave/ABRParameters;->minVideoWidth:I

    .line 156
    iput v2, p0, Lcom/adobe/ave/ABRParameters;->maxVideoWidth:I

    .line 157
    iput v1, p0, Lcom/adobe/ave/ABRParameters;->minVideoHeight:I

    .line 158
    iput v2, p0, Lcom/adobe/ave/ABRParameters;->maxVideoHeight:I

    .line 160
    return-void
.end method


# virtual methods
.method public getPolicyType()I
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/adobe/ave/ABRParameters;->policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    invoke-virtual {v0}, Lcom/adobe/ave/ABRParameters$ABRPolicy;->getValue()I

    move-result v0

    return v0
.end method
