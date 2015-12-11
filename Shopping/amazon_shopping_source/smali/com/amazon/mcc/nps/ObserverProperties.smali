.class public Lcom/amazon/mcc/nps/ObserverProperties;
.super Ljava/lang/Object;
.source "ObserverProperties.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mcc/nps/ObserverProperties$Builder;
    }
.end annotation


# instance fields
.field private final priority:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/mcc/nps/ObserverProperties$Builder;

    invoke-direct {v0}, Lcom/amazon/mcc/nps/ObserverProperties$Builder;-><init>()V

    invoke-direct {p0, v0}, Lcom/amazon/mcc/nps/ObserverProperties;-><init>(Lcom/amazon/mcc/nps/ObserverProperties$Builder;)V

    .line 13
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mcc/nps/ObserverProperties$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/amazon/mcc/nps/ObserverProperties$Builder;

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    invoke-virtual {p1}, Lcom/amazon/mcc/nps/ObserverProperties$Builder;->getPriority()I

    move-result v0

    iput v0, p0, Lcom/amazon/mcc/nps/ObserverProperties;->priority:I

    .line 9
    return-void
.end method


# virtual methods
.method public getPriority()I
    .locals 1

    .prologue
    .line 16
    iget v0, p0, Lcom/amazon/mcc/nps/ObserverProperties;->priority:I

    return v0
.end method
