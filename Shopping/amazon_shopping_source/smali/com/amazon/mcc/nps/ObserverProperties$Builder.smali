.class public Lcom/amazon/mcc/nps/ObserverProperties$Builder;
.super Ljava/lang/Object;
.source "ObserverProperties.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mcc/nps/ObserverProperties;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private priority:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mcc/nps/ObserverProperties$Builder;->priority:I

    return-void
.end method


# virtual methods
.method public getPriority()I
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/amazon/mcc/nps/ObserverProperties$Builder;->priority:I

    return v0
.end method
